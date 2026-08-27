package com.bingwascore.app.domain.engine

import android.content.Context
import android.content.Intent
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.enums.ProcessingMode
import com.bingwascore.app.domain.model.TransactionContext
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.services.UssdAccessibilityService
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UssdDialingHandler @Inject constructor(
    @ApplicationContext private val context: Context,
    private val settingsRepository: SettingsRepository,
    private val formatUssdUseCase: FormatUssdUseCase
) {

    suspend fun handle(ctx: TransactionContext): TransactionContext {
        if (ctx.transaction.status != TransactionStatus.PROCESSING) {
            return ctx.copy(stopPipeline = true, stopReason = "Transaction not in PROCESSING state")
        }

        val mode = settingsRepository.getProcessingMode()
        val formattedCode = formatUssdUseCase.format(ctx.ussdCode, ctx.customerPhone)

        Timber.d("UssdDialingHandler: Mode=$mode, Code=$formattedCode")

        when (mode) {
            ProcessingMode.EXPRESS -> handleExpressMode(ctx, formattedCode)
            ProcessingMode.ADVANCED -> handleAdvancedMode(ctx, formattedCode)
        }

        return ctx
    }

    private fun handleExpressMode(ctx: TransactionContext, code: String) {
        // Direct USSD dial via TelephonyManager
        val intent = Intent(context, UssdAutomationService::class.java).apply {
            putExtra("USSD_CODE", code)
            putExtra("TRANSACTION_ID", ctx.transaction.id)
            putExtra("CUSTOMER_PHONE", ctx.customerPhone)
        }
        context.startService(intent)
    }

    private fun handleAdvancedMode(ctx: TransactionContext, code: String) {
        // Multi-step USSD via Accessibility Service
        // The Accessibility Service listens for USSD dialogs and auto-clicks/inputs
        val intent = Intent(context, UssdAutomationService::class.java).apply {
            putExtra("USSD_CODE", code)
            putExtra("TRANSACTION_ID", ctx.transaction.id)
            putExtra("CUSTOMER_PHONE", ctx.customerPhone)
            putExtra("ADVANCED_MODE", true)
        }
        context.startService(intent)
    }
}
