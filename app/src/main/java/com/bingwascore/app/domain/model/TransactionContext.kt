package com.bingwascore.app.domain.model

data class TransactionContext(
    val transaction: Transaction,
    val ussdCode: String,
    val isAdvancedMode: Boolean,
    val customerPhone: String,
    val shouldSendAutoReply: Boolean = true,
    val autoReplyType: AutoReplyType? = null,
    var stopPipeline: Boolean = false,
    var stopReason: String? = null
)

enum class AutoReplyType {
    SUCCESSFUL_RESPONSE,
    OFFER_ALREADY_RECOMMENDED,
    FAILED_REQUEST,
    UNAVAILABLE_OFFER,
    APP_PAUSED,
    CUSTOMER_BLACKLISTED,
    CUSTOM
}
