package com.bingwascore.app.domain.intelligence

import com.bingwascore.app.domain.enums.AutoReplyType
import com.bingwascore.app.domain.model.Customer
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus

enum class ChurnRisk { NONE, LOW, HIGH }

data class CustomerProfile(
    val phone: String,
    val name: String?,
    val totalSpent: Double,
    val purchases: Int,
    val favoriteOffer: String?,
    val daysSinceLast: Long,
    val churnRisk: ChurnRisk
)

object IntelligenceEngine {

    private val DAY_MS = 24 * 60 * 60 * 1000L

    fun profile(customer: Customer, transactions: List<Transaction>): CustomerProfile {
        val txs = transactions
            .filter { it.phoneNumber == customer.phoneNumber && it.status == TransactionStatus.SUCCESSFUL }
            .sortedBy { it.createdAt }

        val totalSpent = txs.sumOf { it.amount }
        val favorite = txs.groupingBy { it.offerName }.eachCount().maxByOrNull { it.value }?.key

        val daysSince = if (txs.isEmpty()) 999L
        else (System.currentTimeMillis() - txs.last().createdAt) / DAY_MS

        val intervals = txs.zipWithNext { a, b -> (b.createdAt - a.createdAt) / DAY_MS.toDouble() }
        val avgInterval = intervals.average().let { if (it.isNaN()) 0.0 else it }

        val risk = when {
            txs.size < 2 -> if (daysSince > 3) ChurnRisk.HIGH else ChurnRisk.NONE
            avgInterval > 0 && daysSince > avgInterval * 2 -> ChurnRisk.HIGH
            avgInterval > 0 && daysSince > avgInterval * 1.2 -> ChurnRisk.LOW
            else -> ChurnRisk.NONE
        }

        return CustomerProfile(
            phone = customer.phoneNumber,
            name = customer.name,
            totalSpent = totalSpent,
            purchases = txs.size,
            favoriteOffer = favorite,
            daysSinceLast = daysSince,
            churnRisk = risk
        )
    }

    fun recommend(profile: CustomerProfile, offers: List<Offer>): List<Offer> {
        return offers.filter { it.isActive }.sortedByDescending { it.name == profile.favoriteOffer }
    }

    fun isDuplicatePayment(
        transactions: List<Transaction>,
        phone: String,
        amount: Double,
        withinMs: Long = 5 * 60 * 1000L
    ): Boolean {
        val now = System.currentTimeMillis()
        return transactions.any {
            it.phoneNumber == phone &&
            it.amount == amount &&
            now - it.createdAt < withinMs &&
            it.id.isNotEmpty()
        }
    }

    fun engageReply(body: String, templates: Map<AutoReplyType, String>): String? {
        val lower = body.lowercase()
        val type = when {
            lower.contains("not received") || lower.contains("failed") || lower.contains("problem") ->
                AutoReplyType.FAILED_REQUEST
            lower.contains("thank") -> AutoReplyType.SUCCESSFUL_RESPONSE
            lower.contains("price") || lower.contains("offer") || lower.contains("bundle") ->
                AutoReplyType.UNAVAILABLE_OFFER
            else -> null
        }
        return type?.let { templates[it] }
    }
}
