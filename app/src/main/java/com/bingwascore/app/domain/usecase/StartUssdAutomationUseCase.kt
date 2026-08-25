package com.bingwascore.app.domain.usecase

import android.content.Context
import android.content.Intent
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StartUssdAutomationUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    suspend fun execute(offerId: String, transactionId: String, customerPhone: String) =
        withContext(Dispatchers.IO) {
            try {
                val intent = Intent(context, UssdAutomationService::class.java).apply {
                    putExtra("OFFER_ID", offerId)
                    putExtra("TRANSACTION_ID", transactionId)
                    putExtra("CUSTOMER_PHONE", customerPhone)
                }
                context.startService(intent)
                Timber.d("USSD Automation started for transaction $transactionId")
            } catch (e: Exception) {
                Timber.e(e, "Failed to start USSD Automation")
            }
        }
}
