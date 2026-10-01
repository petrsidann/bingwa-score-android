package com.bingwascore.app.ui.qr

import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.util.formatPhoneToTenDigits
import com.bingwascore.app.util.isTenDigitPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/** Constants for the delegated QR/vCard intents. */
object QrPayloadContract {
    /** Standard zxing-style scan action, understood by every QR app. */
    const val ACTION = "com.google.zxing.client.android.SCAN"
    const val EXTRA_PAYLOAD = "SCAN_RESULT"
}

/** The `Contacts` table cursor columns we read from the system picker. */
object ContactsContractPhone {
    val NUMBER: String = ContactsContract.CommonDataKinds.Phone.NUMBER
}

/** A contact the agent has just pulled into their book. */
data class ImportedContact(val name: String, val phone: String)

/**
 * PREMIUM LOCK — QR Scanner state.
 *
 * Parses the two payload shapes a shared contact QR actually uses — vCard
 * 3.0 (`BEGIN:VCARD … TEL;TYPE=CELL:0712…`) and MECARD (`MECARD:N:…;TEL:…;`) —
 * normalises the number to the canonical ten-digit form, and writes it to Room
 * so the contact is instantly dialable. Pure parsing, no network.
 */
@HiltViewModel
class QrScannerViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    private val _imported = MutableStateFlow<List<ImportedContact>>(emptyList())
    val imported: StateFlow<List<ImportedContact>> = _imported.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message: StateFlow<String?> = _message.asStateFlow()

    private val _busy = MutableStateFlow(false)
    val busy: StateFlow<Boolean> = _busy.asStateFlow()

    /** Handles a raw scanned payload (vCard or MECARD), or a bare number. */
    fun importPayload(raw: String) {
        _busy.value = true
        viewModelScope.launch {
            val parsed = VCardParser.parse(raw)
            if (parsed == null) {
                _message.value = "That code isn't a contact. Try a vCard or MECARD QR."
                _busy.value = false
                return@launch
            }
            persist(parsed)
        }
    }

    /** Handles a number taken straight from the system contacts picker. */
    fun importNumber(raw: String) {
        _busy.value = true
        viewModelScope.launch { persist(VCardParser.fromNumber(raw)) }
    }

    private suspend fun persist(contact: ImportedContact) {
        val normalized = formatPhoneToTenDigits(contact.phone)
        if (!isTenDigitPhone(normalized)) {
            _message.value = "Couldn't read a valid number from that."
            _busy.value = false
            return
        }
        try {
            customerRepository.insert(
                Customer(
                    phoneNumber = normalized,
                    name = contact.name,
                    isBlacklisted = false,
                    createdAt = System.currentTimeMillis()
                )
            )
            _imported.value = listOf(contact.copy(phone = normalized)) + _imported.value
            _message.value = "Imported ${contact.name} — ready to dial."
        } catch (t: Throwable) {
            Timber.e(t, "Failed to import contact")
            _message.value = "Couldn't save that contact."
        } finally {
            _busy.value = false
        }
    }
}

/**
 * Pure vCard/MECARD reader — no Android types, so it is JVM-testable.
 *
 * Both formats are line-oriented and tolerate `\r\n`, so we split on any
 * newline. MECARD is a single `;`-delimited line; vCard exposes `FN`/`N` for
 * the name and `TEL` for the number.
 */
object VCardParser {

    /** Parses a scanned payload. Returns null when no usable number is found. */
    fun parse(raw: String): ImportedContact? {
        val text = raw.trim()
        if (text.isEmpty()) return null

        // A bare phone number has no field separators at all.
        if (text.none { it == ':' || it == ';' }) return fromNumber(text)

        if (text.startsWith("MECARD:", ignoreCase = true)) return parseMecard(text)
        if (text.contains("BEGIN:VCARD", ignoreCase = true)) return parseVCard(text)
        return null
    }

    /** "MECARD:N:Ann;TEL:+254712345678;EMAIL:a@b.c;" -> contact. */
    fun parseMecard(raw: String): ImportedContact? {
        val fields = raw.removePrefix("MECARD:").split(';')
        var name: String? = null
        var phone: String? = null
        fields.forEach { field ->
            val key = field.substringBefore(':', missingDelimiterValue = "").trim().uppercase()
            val value = field.substringAfter(':', missingDelimiterValue = "").trim()
            if (value.isEmpty()) return@forEach
            when (key) {
                "N", "FN" -> if (name == null) name = value
                "TEL" -> if (phone == null) phone = value
            }
        }
        return phone?.let { ImportedContact(name.orEmpty().ifBlank { "Scanned contact" }, it) }
    }

    /** vCard 3.0: `FN:Ann` + `TEL;TYPE=CELL:+254712…`. */
    fun parseVCard(raw: String): ImportedContact? {
        val lines = raw.split("\r\n", "\n", "\r")
        var fullName: String? = null
        var structuredName: String? = null
        var phone: String? = null
        lines.forEach { line ->
            val clean = line.trim()
            if (clean.isEmpty()) return@forEach
            // Strip any parameters (`TEL;TYPE=CELL:` -> `TEL`).
            val property = clean.substringBefore(':').substringBefore(';').trim().uppercase()
            val value = clean.substringAfter(':', missingDelimiterValue = "").trim()
            if (value.isEmpty()) return@forEach
            when (property) {
                // FN is the pre-formatted display name and always wins;
                // N is only the structured fallback (`N:Ann;Bett;;;`).
                "FN" -> if (fullName == null) fullName = value
                "N" -> if (structuredName == null) structuredName = value.substringBefore(';').trim()
                "TEL" -> if (phone == null) phone = value
            }
        }
        val resolvedName = fullName?.takeIf { it.isNotBlank() }
            ?: structuredName?.takeIf { it.isNotBlank() }
        return phone?.let { ImportedContact(resolvedName ?: "Scanned contact", it) }
    }

    /** Wraps a plain phone string, keeping only dialable characters. */
    fun fromNumber(raw: String): ImportedContact {
        val dialable = raw.filter { it.isDigit() || it == '+' }
        return ImportedContact("Scanned contact", dialable.ifBlank { raw.trim() })
    }
}
