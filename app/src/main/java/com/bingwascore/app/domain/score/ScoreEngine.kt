package com.bingwascore.app.domain.score

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.domain.TransactionStatus
import javax.inject.Inject
import javax.inject.Singleton

data class ScoreState(
    val score: Int,
    val levelName: String,
    val nextLevelAt: Int,
    val progress: Float,
    val streakDays: Int,
    val successRate: Float,
    val totalCommission: Double,
    val customersServed: Int
)

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val unlocked: Boolean
)

@Singleton
class ScoreEngine @Inject constructor() {

    private val levels = listOf(
        "Bronze" to 0,
        "Silver" to 500,
        "Gold" to 1500,
        "Platinum" to 4000,
        "Diamond" to 10000
    )

    fun compute(transactions: List<Transaction>, customers: List<Customer>): ScoreState {
        val successful = transactions.count { it.status == TransactionStatus.SUCCESSFUL.value }
        val totalCommission = transactions
            .filter { it.status == TransactionStatus.SUCCESSFUL.value }
            .sumOf { it.commission }
        val streakDays = computeStreak(transactions)
        val score = successful * 10 + totalCommission.toInt() + streakDays * 20
        val total = transactions.size
        val successRate = if (total > 0) successful.toFloat() / total else 0f
        val (levelName, nextLevelAt, progress) = levelFor(score)
        return ScoreState(score, levelName, nextLevelAt, progress, streakDays, successRate, totalCommission, customers.size)
    }

    fun levelFor(score: Int): Triple<String, Int, Float> {
        val idx = levels.indexOfLast { it.second <= score }
        val current = levels[idx]
        val next = levels.getOrNull(idx + 1)
        val progress = if (next == null) 1f
        else {
            val span = next.second - current.second
            val into = score - current.second
            if (span <= 0) 1f else (into.toFloat() / span).coerceIn(0f, 1f)
        }
        return Triple(current.first, next?.second ?: current.second, progress)
    }

    fun computeStreak(transactions: List<Transaction>): Int {
        val days = transactions
            .filter { it.status == TransactionStatus.SUCCESSFUL.value }
            .map { (it.createdAt / 86_400_000L).toInt() }
            .toSet()
        if (days.isEmpty()) return 0
        val today = todayIndex()
        var day = if (days.contains(today)) today else today - 1
        var streak = 0
        while (days.contains(day)) { streak++; day-- }
        return streak
    }

    fun achievements(transactions: List<Transaction>, customers: List<Customer>): List<Achievement> {
        val successful = transactions.count { it.status == TransactionStatus.SUCCESSFUL.value }
        val commission = transactions.filter { it.status == TransactionStatus.SUCCESSFUL.value }.sumOf { it.commission }
        val streak = computeStreak(transactions)
        return listOf(
            Achievement("first_sale", "First Sale", "Complete your first transaction", successful >= 1),
            Achievement("streak_7", "7-Day Streak", "7 consecutive active days", streak >= 7),
            Achievement("commission_1000", "Ksh 1,000 Commission", "Earn Ksh 1,000 in commissions", commission >= 1000.0),
            Achievement("transactions_50", "50 Transactions", "Complete 50 transactions", transactions.size >= 50),
            Achievement("customers_10", "10 Customers", "Serve 10 customers", customers.size >= 10)
        ).sortedByDescending { it.unlocked }
    }

    private fun todayIndex(): Int {
        val cal = java.util.Calendar.getInstance()
        cal.set(java.util.Calendar.HOUR_OF_DAY, 0)
        cal.set(java.util.Calendar.MINUTE, 0)
        cal.set(java.util.Calendar.SECOND, 0)
        cal.set(java.util.Calendar.MILLISECOND, 0)
        return (cal.timeInMillis / 86_400_000L).toInt()
    }
}
