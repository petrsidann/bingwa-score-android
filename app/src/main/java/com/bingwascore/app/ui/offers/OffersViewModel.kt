package com.bingwascore.app.ui.offers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.OfferTransitionRule
import com.bingwascore.app.data.preferences.OfferTransitionStore
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.BatchDialPlanner
import com.bingwascore.app.domain.BatchDialTarget
import com.bingwascore.app.domain.DuplicateOfferTransitionRuleException
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

/**
 * POLISH P4 - offer categories, derived from the offer's own type.
 *
 * The chips are not a hand-maintained taxonomy: they come from
 * [com.bingwascore.app.data.local.Offer.TYPES], so an offer can never land in a
 * bucket the UI does not show, and a category with nothing in it gets an honest
 * empty state instead of silently disappearing.
 */
enum class OfferCategory(val label: String, val type: String?) {
    ALL("All", null),
    DATA("Data", com.bingwascore.app.data.local.Offer.TYPE_DATA),
    AIRTIME("Airtime", com.bingwascore.app.data.local.Offer.TYPE_AIRTIME),
    SMS("SMS", com.bingwascore.app.data.local.Offer.TYPE_SMS),
    COMBO("Combo", com.bingwascore.app.data.local.Offer.TYPE_COMBO);

    /** True when this category should list [offer]. Unknown types land in [ALL]. */
    fun matches(offer: com.bingwascore.app.data.local.Offer): Boolean =
        type == null || offer.type.equals(type, ignoreCase = true)

    companion object {
        fun filter(
            offers: List<com.bingwascore.app.data.local.Offer>,
            category: OfferCategory
        ): List<com.bingwascore.app.data.local.Offer> = offers.filter { category.matches(it) }
    }
}

/** POLISH P4 - the minimum width of one grid cell, in dp. */
internal const val OFFER_GRID_MIN_WIDTH = 168

/**
 * MEGA A â€” the Offer Settings form state, mirroring their OfferSettingsState.
 *
 * The sheet used to hold raw local booleans and save optimistically, so a bad
 * value (empty retries, nonsense timeout) silently persisted. Now the form is
 * validated up-front: [errorMessage] renders inline above Save, and
 * [isLoading] disables the button while the write lands so the sheet never
 * looks like it saved when it did not.
 */
data class OfferSettingsState(
    val offerId: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val savedMessage: String? = null
)

/** Outcome of validating a settings form â€” sealed so the UI cannot half-render. */
sealed interface OfferSettingsValidation {
    data class Valid(val offer: Offer) : OfferSettingsValidation
    data class Invalid(val message: String) : OfferSettingsValidation
}

/**
 * Validates an OfferSettings form submission.
 *
 * Pure and JVM-testable: takes the raw string inputs exactly as the form holds
 * them and returns either the fully-built [Offer] or the message to show inline.
 */
object OfferSettingsValidator {

    /** Widest sensible USSD budget: 5s..180s. */
    const val MIN_TIMEOUT_SECONDS = 5
    const val MAX_TIMEOUT_SECONDS = 180
    const val MAX_RETRIES = 10

    fun validate(
        offer: Offer,
        numberOfRetries: String,
        retryIntervalMins: String,
        ussdTimeoutSeconds: String,
        rescheduleTime: String,
        autoReschedule: Boolean,
        completionMessage: String,
        type: String,
        autoRetryConnectionProblems: Boolean
    ): OfferSettingsValidation {
        val retries = numberOfRetries.toIntOrNull()
            ?: return OfferSettingsValidation.Invalid("Retries must be a whole number")
        if (retries < 0 || retries > MAX_RETRIES) {
            return OfferSettingsValidation.Invalid("Retries must be between 0 and $MAX_RETRIES")
        }

        val interval = retryIntervalMins.toIntOrNull()
            ?: return OfferSettingsValidation.Invalid("Retry interval must be a whole number")
        if (interval < 1) {
            return OfferSettingsValidation.Invalid("Retry interval must be at least 1 minute")
        }

        val timeout = ussdTimeoutSeconds.toIntOrNull()
            ?: return OfferSettingsValidation.Invalid("Timeout must be a whole number of seconds")
        if (timeout < MIN_TIMEOUT_SECONDS || timeout > MAX_TIMEOUT_SECONDS) {
            return OfferSettingsValidation.Invalid(
                "Timeout must be between $MIN_TIMEOUT_SECONDS and $MAX_TIMEOUT_SECONDS seconds"
            )
        }

        // Reschedule only needs a sane HH:mm when the toggle is actually on.
        if (autoReschedule && !isValidRunTime(rescheduleTime)) {
            return OfferSettingsValidation.Invalid("Run time must look like 08:00")
        }

        return OfferSettingsValidation.Valid(
            offer.copy(
                type = type,
                numberOfRetries = retries,
                retryIntervalMins = interval,
                ussdTimeoutSeconds = timeout,
                // Keep the legacy millis field in sync so anything still reading
                // it (exports, the retry worker) agrees with the seconds value.
                ussdTimeoutMillis = timeout * 1000L,
                autoReschedule = autoReschedule,
                autoRescheduleRunTime = rescheduleTime.ifBlank { offer.autoRescheduleRunTime },
                completionMessage = completionMessage.ifBlank { null },
                autoRetryConnectionProblems = autoRetryConnectionProblems,
                isDirty = true
            )
        )
    }

    /** Accepts "8:00" and "08:00" â€” 24-hour clock, minutes under 60. */
    fun isValidRunTime(value: String): Boolean {
        val parts = value.trim().split(":")
        if (parts.size != 2) return false
        val hours = parts[0].toIntOrNull() ?: return false
        val minutes = parts[1].toIntOrNull() ?: return false
        return hours in 0..23 && minutes in 0..59
    }
}

@HiltViewModel
class OffersViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val offerRepository: OfferRepository,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences,
    private val transitionStore: OfferTransitionStore
) : ViewModel() {

    val offers: StateFlow<List<Offer>> =
        offerRepository.allOffers.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    // Parity E â€” offer cards shimmer (skeleton) until the first Room emission.
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Parity F â€” silent batch dial state.
    private val _isBatching = MutableStateFlow(false)
    val isBatching: StateFlow<Boolean> = _isBatching.asStateFlow()

    /** Parity F â€” last dialled customer, prefilled into the batch dial bar. */
    val lastDialPhone: StateFlow<String> =
        userPreferences.lastDialPhone.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), ""
        )

    /** MEGA A â€” red inline error text shown inside the offer actions sheet. */
    private val _ruleError = MutableStateFlow<String?>(null)
    val ruleError: StateFlow<String?> = _ruleError.asStateFlow()

    /** MEGA A â€” the Offer Settings form: isLoading + inline errorMessage. */
    private val _settingsState = MutableStateFlow(OfferSettingsState())
    val settingsState: StateFlow<OfferSettingsState> = _settingsState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                offerRepository.allOffers.first()
            } catch (t: Throwable) {
                Timber.e(t, "Initial offer load failed")
            }
            _isLoading.value = false
        }
    }

    val transitionRules: StateFlow<List<OfferTransitionRule>> =
        transitionStore.rules.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    /** Creates a new active offer from the add-offer sheet. */
    fun addOffer(name: String, price: Int, ussdCode: String) {
        viewModelScope.launch {
            try {
                offerRepository.insert(
                    Offer(
                        id = "offer_${UUID.randomUUID()}",
                        name = name.trim(),
                        ussdCode = ussdCode.trim(),
                        price = price,
                        isActive = true
                    )
                )
            } catch (t: Throwable) {
                Timber.e(t, "Failed to add offer")
            }
        }
    }

    /** Flips the offer's active flag (the card Switch). */
    fun toggleActive(offer: Offer) {
        update(offer.copy(isActive = !offer.isActive))
    }


    /**
     * Parity F â€” a rule for the same (fromStatus, toOfferId) pair already exists:
     * reject it with [DuplicateOfferTransitionRuleException] and surface red error
     * text in the sheet instead of silently overwriting the saved rule.
     */
    fun saveTransitionRule(rule: OfferTransitionRule) {
        viewModelScope.launch {
            try {
                val existing = transitionStore.rules.first()
                if (existing.any {
                        it.fromStatus == rule.fromStatus && it.toOfferId == rule.toOfferId
                    }
                ) {
                    throw DuplicateOfferTransitionRuleException(rule.fromStatus, rule.toOfferId)
                }
                transitionStore.save(rule)
                _ruleError.value = null
            } catch (e: DuplicateOfferTransitionRuleException) {
                _ruleError.value =
                    "That rule already exists â€” pick another status or offer"
                Timber.w(e, "Duplicate offer transition rule rejected")
            } catch (t: Throwable) {
                Timber.e(t, "Failed to save offer transition rule")
                _ruleError.value = "Could not save the rule â€” try again"
            }
        }
    }

    /**
     * MEGA A â€” validating save for the Offer Settings form.
     *
     * Mirrors their OfferSettingsState contract: the sheet shows [isLoading]
     * while the write is in flight and [errorMessage] inline when validation or
     * persistence fails. Nothing is written on an invalid submission, so a bad
     * retries/timeout value can never reach Room.
     */
    fun saveOfferSettings(
        offer: Offer,
        numberOfRetries: String,
        retryIntervalMins: String,
        ussdTimeoutSeconds: String,
        autoReschedule: Boolean,
        rescheduleTime: String,
        completionMessage: String,
        type: String,
        strictMode: Boolean,
        autoRetry: Boolean,
        autoRetryConnectionProblems: Boolean,
        silentBatch: Boolean,
        tag: String?,
        relayDevice: String?
    ) {
        _settingsState.value = OfferSettingsState(offerId = offer.id, isLoading = true)

        when (
            val validation = OfferSettingsValidator.validate(
                offer = offer,
                numberOfRetries = numberOfRetries,
                retryIntervalMins = retryIntervalMins,
                ussdTimeoutSeconds = ussdTimeoutSeconds,
                rescheduleTime = rescheduleTime,
                autoReschedule = autoReschedule,
                completionMessage = completionMessage,
                type = type,
                autoRetryConnectionProblems = autoRetryConnectionProblems
            )
        ) {
            is OfferSettingsValidation.Invalid -> {
                _settingsState.value = OfferSettingsState(
                    offerId = offer.id,
                    isLoading = false,
                    errorMessage = validation.message
                )
            }

            is OfferSettingsValidation.Valid -> viewModelScope.launch {
                try {
                    offerRepository.update(
                        validation.offer.copy(
                            strictMode = strictMode,
                            autoRetry = autoRetry,
                            silentBatch = silentBatch,
                            tag = tag?.ifBlank { null },
                            relayDevice = relayDevice?.ifBlank { null }
                        )
                    )
                    _settingsState.value = OfferSettingsState(
                        offerId = offer.id,
                        isLoading = false,
                        savedMessage = "Settings saved"
                    )
                } catch (t: Throwable) {
                    Timber.e(t, "Failed to save offer settings for %s", offer.id)
                    _settingsState.value = OfferSettingsState(
                        offerId = offer.id,
                        isLoading = false,
                        errorMessage = "Could not save settings â€” try again"
                    )
                }
            }
        }
    }

    /** Clears the inline settings error when the agent edits a field again. */
    fun clearSettingsError() {
        _settingsState.value = _settingsState.value.copy(
            errorMessage = null,
            savedMessage = null
        )
    }

    /** Clears the red error text in the sheet (fired when the selection changes). */
    fun clearRuleError() {
        _ruleError.value = null
    }

    /**
     * Parity F â€” silent batch dial.
     *
     * [BatchDialPlanner] normalises [phoneRaw], expands every USSD code and can
     * only make silent offers reach the queue without a confirmation (the screen
     * shows that single dialog before calling us). Each dial writes a PENDING
     * transaction and starts [UssdAutomationService] with a
     * [BatchDialPlanner.GAP_MILLIS] gap so consecutive USSD sessions never
     * overlap. The outcome is announced with a toast.
     */
    fun batchDial(offers: List<Offer>, phoneRaw: String) {
        if (_isBatching.value) return
        val plan = BatchDialPlanner.plan(offers, phoneRaw)
        if (plan.isEmpty()) {
            toast("Enter a valid customer phone number")
            return
        }
        viewModelScope.launch {
            _isBatching.value = true
            var queued = 0
            try {
                userPreferences.setLastDialPhone(plan.first().phoneNumber)
                plan.forEachIndexed { index, target ->
                    if (dialSilently(target)) queued++
                    if (index != plan.lastIndex) delay(BatchDialPlanner.GAP_MILLIS)
                }
            } catch (t: Throwable) {
                Timber.e(t, "Silent batch dial stopped after %d queued", queued)
            } finally {
                _isBatching.value = false
            }
            Timber.i("Silent batch dial queued %d of %d", queued, plan.size)
            toast(BatchDialPlanner.queuedMessage(queued))
        }
    }

    /** One queued dial: PENDING transaction + USSD service. Never throws. */
    private suspend fun dialSilently(target: BatchDialTarget): Boolean = try {
        val transactionId = "tx_${UUID.randomUUID()}"
        transactionRepository.insert(
            Transaction(
                id = transactionId,
                phoneNumber = target.phoneNumber,
                customerName = null,
                offerId = target.offerId,
                offerName = target.offerName,
                ussdCode = target.ussdCode,
                amount = target.price.toDouble(),
                commission = target.price * 0.1,
                status = TransactionStatus.PENDING.value,
                createdAt = System.currentTimeMillis()
            )
        )
        context.startService(
            Intent(context, UssdAutomationService::class.java)
                .putExtra(UssdAutomationService.EXTRA_USSD_CODE, target.ussdCode)
                .putExtra(UssdAutomationService.EXTRA_TRANSACTION_ID, transactionId)
                .putExtra(UssdAutomationService.EXTRA_CUSTOMER_PHONE, target.phoneNumber)
        )
        true
    } catch (t: Throwable) {
        Timber.e(t, "Silent dial failed for offer %s", target.offerId)
        false
    }

    private fun toast(message: String) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        } catch (t: Throwable) {
            Timber.e(t, "Could not show toast: %s", message)
        }
    }

    fun deleteTransitionRule(rule: OfferTransitionRule) {
        viewModelScope.launch { transitionStore.delete(rule) }
    }

    private fun update(offer: Offer) {
        viewModelScope.launch {
            try {
                offerRepository.update(offer)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to update offer %s", offer.id)
            }
        }
    }
}
