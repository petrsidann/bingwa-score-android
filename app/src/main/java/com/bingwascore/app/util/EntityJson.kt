package com.bingwascore.app.util

import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import org.json.JSONObject

// ---- Transaction ----

fun Transaction.toJson(): JSONObject = JSONObject().apply {
    put("id", id)
    put("phoneNumber", phoneNumber)
    put("customerName", customerName ?: JSONObject.NULL)
    put("offerId", offerId)
    put("offerName", offerName)
    put("ussdCode", ussdCode)
    put("amount", amount)
    put("commission", commission)
    put("status", status)
    put("createdAt", createdAt)
    put("scheduledAt", scheduledAt ?: JSONObject.NULL)
    put("mpesaReceipt", mpesaReceipt ?: JSONObject.NULL)
    put("errorMessage", errorMessage ?: JSONObject.NULL)
    put("retryCount", retryCount)
    put("isAutoRenewal", isAutoRenewal)
    put("parentTransactionId", parentTransactionId ?: JSONObject.NULL)
}

fun transactionFromJson(o: JSONObject): Transaction = Transaction(
    id = o.getString("id"),
    phoneNumber = o.getString("phoneNumber"),
    customerName = if (o.isNull("customerName")) null else o.optString("customerName"),
    offerId = o.getString("offerId"),
    offerName = o.getString("offerName"),
    ussdCode = o.getString("ussdCode"),
    amount = o.getDouble("amount"),
    commission = o.getDouble("commission"),
    status = o.getString("status"),
    createdAt = o.getLong("createdAt"),
    scheduledAt = if (o.isNull("scheduledAt")) null else o.getLong("scheduledAt"),
    mpesaReceipt = if (o.isNull("mpesaReceipt")) null else o.optString("mpesaReceipt"),
    errorMessage = if (o.isNull("errorMessage")) null else o.optString("errorMessage"),
    retryCount = o.optInt("retryCount", 0),
    isAutoRenewal = o.optBoolean("isAutoRenewal", false),
    parentTransactionId =
        if (o.isNull("parentTransactionId")) null else o.optString("parentTransactionId")
)

// ---- Offer ----

fun Offer.toJson(): JSONObject = JSONObject().apply {
    put("id", id)
    put("name", name)
    put("ussdCode", ussdCode)
    put("price", price)
    put("isActive", isActive)
    put("autoRenewable", autoRenewable)
    put("validityHours", validityHours)
    put("isVerified", isVerified)
    put("completionMessage", completionMessage ?: JSONObject.NULL)
    put("strictMode", strictMode)
    put("autoRetry", autoRetry)
    put("numberOfRetries", numberOfRetries)
    put("retryIntervalMins", retryIntervalMins)
    put("ussdTimeoutMillis", ussdTimeoutMillis)
    put("autoReschedule", autoReschedule)
    put("autoRescheduleRunTime", autoRescheduleRunTime)
}

fun offerFromJson(o: JSONObject): Offer = Offer(
    id = o.getString("id"),
    name = o.getString("name"),
    ussdCode = o.getString("ussdCode"),
    price = o.getInt("price"),
    isActive = o.optBoolean("isActive", true),
    autoRenewable = o.optBoolean("autoRenewable", false),
    validityHours = o.optInt("validityHours", 24),
    isVerified = o.optBoolean("isVerified", false),
    completionMessage =
        if (o.isNull("completionMessage")) null else o.optString("completionMessage"),
    strictMode = o.optBoolean("strictMode", false),
    autoRetry = o.optBoolean("autoRetry", false),
    numberOfRetries = o.optInt("numberOfRetries", 3),
    retryIntervalMins = o.optInt("retryIntervalMins", 5),
    ussdTimeoutMillis = o.optLong("ussdTimeoutMillis", 15000L),
    autoReschedule = o.optBoolean("autoReschedule", false),
    autoRescheduleRunTime = o.optString("autoRescheduleRunTime", "08:00")
)

// ---- Customer ----

fun Customer.toJson(): JSONObject = JSONObject().apply {
    put("phoneNumber", phoneNumber)
    put("name", name ?: JSONObject.NULL)
    put("isBlacklisted", isBlacklisted)
    put("createdAt", createdAt)
}

fun customerFromJson(o: JSONObject): Customer = Customer(
    phoneNumber = o.getString("phoneNumber"),
    name = if (o.isNull("name")) null else o.optString("name"),
    isBlacklisted = o.optBoolean("isBlacklisted", false),
    createdAt = o.getLong("createdAt")
)

// ---- AutoReply ----

fun AutoReply.toJson(): JSONObject = JSONObject().apply {
    put("id", id)
    put("title", title)
    put("message", message)
    put("type", type)
    put("isActive", isActive)
}

fun autoReplyFromJson(o: JSONObject): AutoReply = AutoReply(
    id = o.getInt("id"),
    title = o.getString("title"),
    message = o.getString("message"),
    type = o.getString("type"),
    isActive = o.optBoolean("isActive", true)
)
