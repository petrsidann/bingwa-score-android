package com.bingwascore.app.util

import android.content.Context
import com.bingwascore.app.domain.model.Transaction
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object CsvExporter {

    fun export(context: Context, transactions: List<Transaction>): File? {
        return try {
            val dir = context.getExternalFilesDir(null) ?: return null
            val stamp = SimpleDateFormat("yyyyMMdd-HHmmss", Locale.getDefault()).format(Date())
            val file = File(dir, "bingwa-transactions-$stamp.csv")

            val sb = StringBuilder()
            sb.appendLine("id,phone,customer,offer,amount,commission,status,date")
            transactions.forEach { t ->
                val date = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(t.createdAt))
                sb.appendLine(
                    "${t.id},${t.phoneNumber},${(t.customerName ?: "").replace(",", " ")},${t.offerName.replace(",", " ")},${t.amount},${t.commission},${t.status.name},$date"
                )
            }
            file.writeText(sb.toString())
            file
        } catch (e: Exception) {
            null
        }
    }
}
