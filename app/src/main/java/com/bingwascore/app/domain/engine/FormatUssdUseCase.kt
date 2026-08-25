package com.bingwascore.app.domain.engine

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormatUssdUseCase @Inject constructor() {

    fun format(code: String, customerPhone: String): String {
        val substituted = OfferSignature.tokens(code).joinToString("*") { token ->
            when (token.uppercase()) {
                "BH", "PHONE", "MSISDN" -> customerPhone
                else -> token
            }
        }
        return "*$substituted#"
    }

    fun formatFirstStep(code: String, customerPhone: String): String =
        format(code, customerPhone)
}
