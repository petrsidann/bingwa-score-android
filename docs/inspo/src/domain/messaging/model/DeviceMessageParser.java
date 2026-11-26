package com.example.bingwahybrid.domain.messaging.model;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceMessageParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessageParser;", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "parse", "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;", "jsonString", "", "toJsonString", "message", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceMessageParser {
    public static final int $stable = 8;
    private final Gson gson;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceMessageParser() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DeviceMessageParser(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.gson = gson;
    }

    public /* synthetic */ DeviceMessageParser(Gson gson, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Gson() : gson);
    }

    public final DeviceMessage parse(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Object objFromJson = this.gson.fromJson(jsonString, (Class<Object>) DeviceMessage.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (DeviceMessage) objFromJson;
    }

    public final String toJsonString(DeviceMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(NotificationCompat.CATEGORY_EVENT, message.getEvent());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("deviceId", message.getSource().getDeviceId());
        jsonObject2.addProperty("connectId", message.getSource().getConnectId());
        Unit unit = Unit.INSTANCE;
        jsonObject.add("source", jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("deviceId", message.getDestination().getDeviceId());
        Unit unit2 = Unit.INSTANCE;
        jsonObject.add(FirebaseAnalytics.Param.DESTINATION, jsonObject3);
        JsonObject jsonObject4 = new JsonObject();
        for (Map.Entry<String, Object> entry : message.getPayload().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                jsonObject4.add(key, null);
            } else if (value instanceof String) {
                jsonObject4.addProperty(key, (String) value);
            } else if (value instanceof Number) {
                jsonObject4.addProperty(key, (Number) value);
            } else if (value instanceof Boolean) {
                jsonObject4.addProperty(key, (Boolean) value);
            } else {
                jsonObject4.add(key, this.gson.toJsonTree(value));
            }
        }
        jsonObject.add("payload", jsonObject4);
        String json = this.gson.toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
