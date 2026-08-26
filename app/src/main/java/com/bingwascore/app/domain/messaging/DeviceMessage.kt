package com.bingwascore.app.domain.messaging

import com.google.gson.Gson
import com.google.gson.JsonObject

data class DeviceMessage(
    val type: String = "",
    val deviceId: String? = null,
    val payload: JsonObject? = null
) {
    companion object {
        const val CONNECT = "CONNECT"
        const val PING = "PING"
        const val PONG = "PONG"
        const val TRANSACTION_EVENT = "TRANSACTION_EVENT"
        const val OFFER_EVENT = "OFFER_EVENT"
        const val KPI_EVENT = "KPI_EVENT"
        const val APP_STATE = "APP_STATE"
        const val APP_STATE_QUERY = "APP_STATE_QUERY"
    }
}

object DeviceMessageParser {

    private val gson = Gson()

    fun parse(text: String): DeviceMessage? {
        return try {
            gson.fromJson(text, DeviceMessage::class.java)
        } catch (e: Exception) {
            null
        }
    }

    fun toJson(message: DeviceMessage): String = gson.toJson(message)
}
