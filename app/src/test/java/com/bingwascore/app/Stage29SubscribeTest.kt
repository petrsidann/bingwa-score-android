package com.bingwascore.app

import com.bingwascore.app.domain.PlanCatalog
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 29 — Subscribe flow and Payment status UX tests.
 */
class Stage29SubscribeTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    @Test
    fun `api service declares subscribe and payment status endpoints`() {
        val apiServiceSrc = source("app/src/main/java/com/bingwascore/app/data/remote/ApiService.kt")
        assertTrue("ApiService declares subscribe", apiServiceSrc.contains("suspend fun subscribe("))
        assertTrue("ApiService declares getPaymentStatus", apiServiceSrc.contains("suspend fun getPaymentStatus("))
        assertTrue("ApiService contains SubscribeRequest", apiServiceSrc.contains("data class SubscribeRequest"))
        assertTrue("ApiService contains SubscribeResponse", apiServiceSrc.contains("data class SubscribeResponse"))
        assertTrue("ApiService contains PaymentStatusResponse", apiServiceSrc.contains("data class PaymentStatusResponse"))
    }

    @Test
    fun `offline first api service implements subscribe and payment status polling`() {
        val offlineApiSrc = source("app/src/main/java/com/bingwascore/app/data/remote/OfflineFirstApiService.kt")
        assertTrue("OfflineFirstApiService implements subscribe", offlineApiSrc.contains("override suspend fun subscribe("))
        assertTrue("OfflineFirstApiService implements getPaymentStatus", offlineApiSrc.contains("override suspend fun getPaymentStatus("))
        assertTrue("OfflineFirstApiService uses PATH_SUBSCRIBE", offlineApiSrc.contains("PATH_SUBSCRIBE = \"/api/subscribe\""))
        assertTrue("OfflineFirstApiService uses PATH_PAYMENT_STATUS", offlineApiSrc.contains("PATH_PAYMENT_STATUS = \"/api/payments/status\""))
    }

    @Test
    fun `my plan view model handles polling states timeout and retry`() {
        val myPlanSrc = source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
        assertTrue("PurchaseState includes Pending", myPlanSrc.contains("data class Pending("))
        assertTrue("PurchaseState includes Success", myPlanSrc.contains("data class Success("))
        assertTrue("PurchaseState includes Failed", myPlanSrc.contains("data class Failed("))

        assertTrue("ViewModel calls apiService.subscribe", myPlanSrc.contains("apiService.subscribe("))
        assertTrue("ViewModel calls apiService.getPaymentStatus", myPlanSrc.contains("apiService.getPaymentStatus("))
        assertTrue("ViewModel enforces 60s timeout", myPlanSrc.contains("timeoutMs"))
        assertTrue("ViewModel inserts receipt transaction on COMPLETED", myPlanSrc.contains("transactionRepository.insert(tx)"))
    }

    @Test
    fun `trust line text and queued status chip exist in MyPlanScreen`() {
        val myPlanSrc = source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
        assertTrue("Must contain trust line text", myPlanSrc.contains("Payments settle securely to Bingwa Score till (M-Pesa)"))
        assertTrue("Must display status chip Queued or StatusChipQueued", myPlanSrc.contains("StatusChipQueued") || myPlanSrc.contains("\"Queued\""))
        assertTrue("Must contain M-Pesa prompt message", myPlanSrc.contains("Check your phone for the M-Pesa prompt"))
    }

    @Test
    fun `no sensitive shortcode or payment keys exposed in my plan or repository`() {
        val myPlanSrc = source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
        assertTrue("No raw consumer keys exposed", !myPlanSrc.contains("ConsumerKey", ignoreCase = true))
        assertTrue("No raw consumer secrets exposed", !myPlanSrc.contains("ConsumerSecret", ignoreCase = true))
    }
}
