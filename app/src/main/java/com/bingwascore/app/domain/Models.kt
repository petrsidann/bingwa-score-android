package com.bingwascore.app.domain

/**
 * Core domain enums shared across the app.
 * Room stores these as plain Strings (see data/local entities) and screens map
 * back using the [fromValue] helpers.
 */
enum class TransactionStatus(val value: String) {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    SCHEDULED("SCHEDULED"),
    SUCCESSFUL("SUCCESSFUL"),
    FAILED("FAILED"),
    FAILED_ALREADY_RECOMMENDED("FAILED_ALREADY_RECOMMENDED"),
    UNMATCHED("UNMATCHED"),
    CANCELLED("CANCELLED"),
    PAUSED("PAUSED");

    companion object {
        fun fromValue(value: String?): TransactionStatus =
            entries.firstOrNull { it.value == value } ?: PENDING
    }
}

enum class ThemeMode(val value: String) {
    SYSTEM("SYSTEM"),
    DARK("DARK"),
    LIGHT("LIGHT");

    companion object {
        fun fromValue(value: String?): ThemeMode =
            entries.firstOrNull { it.value == value } ?: DARK
    }
}

enum class AppProcessingMode(val value: String) {
    EXPRESS("EXPRESS"),
    ADVANCED("ADVANCED");

    companion object {
        fun fromValue(value: String?): AppProcessingMode =
            entries.firstOrNull { it.value == value } ?: EXPRESS
    }
}