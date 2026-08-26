package com.bingwascore.app.domain.enums

enum class ProcessingMode { EXPRESS, ADVANCED }

enum class AppState { STATE_RUNNING, STATE_PAUSED, STATE_STOPPED }

enum class SubscriptionType { DAILY, WEEKLY, MONTHLY, USSD_REQUESTS, UNLIMITED }

enum class RescheduleMode { ONCE, AUTO_RENEW }

enum class StepType { SELECT, INPUT }

enum class InputMode { STATIC, DYNAMIC }

enum class SmsType {
    MPESA_CONFIRMATION,
    COMMISSION,
    BUNDLE_DELIVERY,
    TILL,
    PAYBILL,
    SITELINK,
    ENGAGE,
    UNKNOWN
}

enum class AutoReplyType {
    SUCCESSFUL_RESPONSE,
    OFFER_ALREADY_RECOMMENDED,
    FAILED_REQUEST,
    UNAVAILABLE_OFFER,
    APP_PAUSED,
    CUSTOMER_BLACKLISTED,
    CUSTOM
}

enum class SiteLinkAccountType { TILL, MPESA }

enum class TransactionType { NORMAL, AUTO_RENEWAL, SITELINK, QUICK_DIAL }

enum class OfferStepState { PENDING, COMPLETED, SKIPPED }

enum class StepAction { NEXT, COMPLETE, CANCEL }

enum class ConnectionType { WIFI, MOBILE_DATA, NONE }
