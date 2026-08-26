package com.bingwascore.app.domain.engine

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.core.content.ContextCompat
import com.bingwascore.app.domain.model.Transaction

enum class ValidationResult {
    OK,
    MISSING_PERMISSION,
    ALREADY_SUCCESSFUL,
    AUTO_TIME_DISABLED
}

object Validators {

    fun hasPermissions(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS) ==
                PackageManager.PERMISSION_GRANTED
    }

    fun validate(transaction: Transaction, context: Context): ValidationResult {
        if (transaction.status == com.bingwascore.app.domain.model.TransactionStatus.SUCCESSFUL) {
            return ValidationResult.ALREADY_SUCCESSFUL
        }
        if (!hasPermissions(context)) {
            return ValidationResult.MISSING_PERMISSION
        }
        if (!isAutoTimeEnabled(context)) {
            return ValidationResult.AUTO_TIME_DISABLED
        }
        return ValidationResult.OK
    }

    fun isAutoTimeEnabled(context: Context): Boolean {
        return Settings.Global.getInt(context.contentResolver, "auto_time", 0) == 1
    }
}
