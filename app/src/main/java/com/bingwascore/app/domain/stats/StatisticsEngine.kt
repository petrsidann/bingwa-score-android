package com.bingwascore.app.domain.stats

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.PowerManager
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import java.util.Calendar
import java.util.Locale

data class AgentScore(
    val score: Int,
    val level: String,
    val streakDays: Int,
    val successRate: Double,
    val totalCommission: Double,
    val totalAirtimeUsed: Double,
    val successfulCount: Int,
    val failedCount: Int
)

data class DayPoint(val label: String, val value: Double)

data class HealthCheck(val name: String, val ok: Boolean, val advice: String)

object StatisticsEngine {

    fun levelFor(score: Int): String = when {
        score >= 900 -> "Diamond Bingwa"
        score >= 750 -> "Platinum Bingwa"
        score >= 600 -> "Gold Bingwa"
        score >= 400 -> "Silver Bingwa"
        score >= 200 -> "Bronze Bingwa"
        else -> "Rookie"
    }

    fun nextLevelTarget(score: Int): Int = when {
        score >= 900 -> 1000
        score >= 750 -> 900
        score >= 600 -> 750
        score >= 400 -> 600
        score >= 200 -> 400
        else -> 200
    }

    fun compute(transactions: List<Transaction>): AgentScore {
        val successful = transactions.count { it.status == TransactionStatus.SUCCESSFUL }
        val failed = transactions.count {
            it.status == TransactionStatus.FAILED ||
            it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED
        }
        val decided = successful + failed
        val successRate = if (decided == 0) 0.0 else successful * 100.0 / decided
        val commission = transactions
            .filter { it.status == TransactionStatus.SUCCESSFUL }
            .sumOf { it.commission }
        val airtime = transactions
            .filter { it.status == TransactionStatus.SUCCESSFUL }
            .sumOf { it.amount }

        val streak = streakDays(transactions)

        val volumeScore = successful.coerceAtMost(500) * 0.8
        val rateScore = successRate * 3.0
        val commissionScore = commission.coerceAtMost(3000.0) / 10.0
        val streakScore = streak.coerceAtMost(30) * (10.0 / 3.0)

        val score = (volumeScore + rateScore + commissionScore + streakScore)
            .toInt().coerceIn(0, 1000)

        return AgentScore(
            score = score,
            level = levelFor(score),
            streakDays = streak,
            successRate = successRate,
            totalCommission = commission,
            totalAirtimeUsed = airtime,
            successfulCount = successful,
            failedCount = failed
        )
    }

    fun streakDays(transactions: List<Transaction>): Int {
        val days = transactions
            .filter { it.status == TransactionStatus.SUCCESSFUL }
            .map { dayKey(it.createdAt) }
            .toSet()

        val cursor = Calendar.getInstance()
        if (!days.contains(dayKey(cursor.timeInMillis))) {
            cursor.add(Calendar.DAY_OF_YEAR, -1)
        }
        var streak = 0
        while (days.contains(dayKey(cursor.timeInMillis))) {
            streak++
            cursor.add(Calendar.DAY_OF_YEAR, -1)
        }
        return streak
    }

    fun last7DaysCommission(txs: List<Transaction>): List<DayPoint> =
        last7Days(txs) { it.commission }

    fun last7DaysAirtime(txs: List<Transaction>): List<DayPoint> =
        last7Days(txs) { it.amount }

    private fun last7Days(txs: List<Transaction>, value: (Transaction) -> Double): List<DayPoint> {
        val out = mutableListOf<DayPoint>()
        for (i in 6 downTo 0) {
            val day = Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, -i)
                set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }
            val next = (day.clone() as Calendar).apply { add(Calendar.DAY_OF_YEAR, 1) }
            val sum = txs
                .filter {
                    it.status == TransactionStatus.SUCCESSFUL &&
                    it.createdAt >= day.timeInMillis && it.createdAt < next.timeInMillis
                }
                .sumOf(value)
            out += DayPoint(
                label = day.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()) ?: "",
                value = sum
            )
        }
        return out
    }

    // 4 windows (Night/Morning/Afternoon/Evening) x 7 days
    fun heatmap(txs: List<Transaction>): List<List<Int>> {
        val matrix = List(4) { MutableList(7) { 0 } }
        txs.filter { it.status == TransactionStatus.SUCCESSFUL }.forEach { tx ->
            val cal = Calendar.getInstance().apply { timeInMillis = tx.createdAt }
            val day = (cal.get(Calendar.DAY_OF_WEEK) + 5) % 7
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val window = when (hour) {
                in 5..11 -> 1
                in 12..16 -> 2
                in 17..21 -> 3
                else -> 0
            }
            matrix[window][day]++
        }
        return matrix
    }

    fun bestSellingWindow(txs: List<Transaction>): String {
        val counts = IntArray(4)
        txs.filter { it.status == TransactionStatus.SUCCESSFUL }.forEach { tx ->
            val hour = Calendar.getInstance().apply { timeInMillis = tx.createdAt }.get(Calendar.HOUR_OF_DAY)
            counts[when (hour) { in 5..11 -> 1; in 12..16 -> 2; in 17..21 -> 3; else -> 0 }]++
        }
        val best = counts.indices.maxByOrNull { counts[it] } ?: 0
        return when (best) {
            1 -> "Morning (5am - 12pm)"
            2 -> "Afternoon (12pm - 5pm)"
            3 -> "Evening (5pm - 10pm)"
            else -> "Night (10pm - 5am)"
        }
    }

    private fun dayKey(ts: Long): String {
        val c = Calendar.getInstance().apply { timeInMillis = ts }
        return "${c.get(Calendar.YEAR)}-${c.get(Calendar.DAY_OF_YEAR)}"
    }
}

object EngineHealth {

    fun checks(context: Context): List<HealthCheck> {
        val list = mutableListOf<HealthCheck>()

        val sms = ContextCompat.checkSelfPermission(context, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED
        list += HealthCheck("SMS access", sms, "Grant SMS permission so payments are detected instantly.")

        val call = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
        list += HealthCheck("USSD dialing", call, "Grant Phone permission to auto-dial USSD codes.")

        val notif = NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.packageName)
        list += HealthCheck("Notification listener", notif, "Enable notification access for backup payment capture.")

        val autoTime = Settings.Global.getInt(context.contentResolver, "auto_time", 0) == 1
        list += HealthCheck("Automatic time", autoTime, "Enable automatic date and time for USSD security checks.")

        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val battery = pm.isIgnoringBatteryOptimizations(context.packageName)
        list += HealthCheck("Battery optimization", battery, "Exclude Bingwa Score from battery optimization to stay alive 24/7.")

        return list
    }
}
