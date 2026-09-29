package com.bingwascore.app.utils

/**
 * Pure CSV escaper shared by the archive worker and the manual exporter
 * (Audit G8/G9): extracted so `./gradlew test` can cover it on the JVM.
 */
object CsvEscapes {

    fun escape(value: String): String =
        if (value.contains(',') || value.contains('"') || value.contains('\n')) {
            "\"" + value.replace("\"", "\"\"") + "\""
        } else value
}
