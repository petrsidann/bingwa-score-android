package com.example.bingwahybrid.domain.messaging.model;

import androidx.core.app.NotificationCompat;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0003\u001f !B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÂ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;", "", NotificationCompat.CATEGORY_EVENT, "", "source", "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Source;", FirebaseAnalytics.Param.DESTINATION, "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Destination;", "payload", "", "<init>", "(Ljava/lang/String;Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Source;Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Destination;Ljava/util/Map;)V", "getEvent", "()Ljava/lang/String;", "getSource", "()Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Source;", "getDestination", "()Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Destination;", "getPayload", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Source", "Destination", "Builder", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeviceMessage {
    public static final int $stable = 8;

    @SerializedName(FirebaseAnalytics.Param.DESTINATION)
    private final Destination destination;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("payload")
    private final Map<String, Object> payload;

    @SerializedName("source")
    private final Source source;

    public /* synthetic */ DeviceMessage(String str, Source source, Destination destination, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, source, destination, map);
    }

    private final DeviceMessage copy(String event, Source source, Destination destination, Map<String, ? extends Object> payload) {
        return new DeviceMessage(event, source, destination, payload);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ DeviceMessage copy$default(DeviceMessage deviceMessage, String str, Source source, Destination destination, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceMessage.event;
        }
        if ((i & 2) != 0) {
            source = deviceMessage.source;
        }
        if ((i & 4) != 0) {
            destination = deviceMessage.destination;
        }
        if ((i & 8) != 0) {
            map = deviceMessage.payload;
        }
        return deviceMessage.copy(str, source, destination, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Destination getDestination() {
        return this.destination;
    }

    public final Map<String, Object> component4() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceMessage)) {
            return false;
        }
        DeviceMessage deviceMessage = (DeviceMessage) other;
        return Intrinsics.areEqual(this.event, deviceMessage.event) && Intrinsics.areEqual(this.source, deviceMessage.source) && Intrinsics.areEqual(this.destination, deviceMessage.destination) && Intrinsics.areEqual(this.payload, deviceMessage.payload);
    }

    public int hashCode() {
        return (((((this.event.hashCode() * 31) + this.source.hashCode()) * 31) + this.destination.hashCode()) * 31) + this.payload.hashCode();
    }

    public String toString() {
        return "DeviceMessage(event=" + this.event + ", source=" + this.source + ", destination=" + this.destination + ", payload=" + this.payload + ")";
    }

    private DeviceMessage(String str, Source source, Destination destination, Map<String, ? extends Object> map) {
        this.event = str;
        this.source = source;
        this.destination = destination;
        this.payload = map;
    }

    public final String getEvent() {
        return this.event;
    }

    public final Source getSource() {
        return this.source;
    }

    public final Destination getDestination() {
        return this.destination;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    /* JADX INFO: compiled from: DeviceMessage.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Source;", "", "deviceId", "", "connectId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getConnectId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Source {
        public static final int $stable = 0;

        @SerializedName("connectId")
        private final String connectId;

        @SerializedName("deviceId")
        private final String deviceId;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.deviceId;
            }
            if ((i & 2) != 0) {
                str2 = source.connectId;
            }
            return source.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getConnectId() {
            return this.connectId;
        }

        public final Source copy(String deviceId, String connectId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(connectId, "connectId");
            return new Source(deviceId, connectId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.deviceId, source.deviceId) && Intrinsics.areEqual(this.connectId, source.connectId);
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.connectId.hashCode();
        }

        public String toString() {
            return "Source(deviceId=" + this.deviceId + ", connectId=" + this.connectId + ")";
        }

        public Source(String deviceId, String connectId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(connectId, "connectId");
            this.deviceId = deviceId;
            this.connectId = connectId;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getConnectId() {
            return this.connectId;
        }
    }

    /* JADX INFO: compiled from: DeviceMessage.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Destination;", "", "deviceId", "", "fcmToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getFcmToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Destination {
        public static final int $stable = 0;

        @SerializedName("deviceId")
        private final String deviceId;
        private final transient String fcmToken;

        public static /* synthetic */ Destination copy$default(Destination destination, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = destination.deviceId;
            }
            if ((i & 2) != 0) {
                str2 = destination.fcmToken;
            }
            return destination.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFcmToken() {
            return this.fcmToken;
        }

        public final Destination copy(String deviceId, String fcmToken) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            return new Destination(deviceId, fcmToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Destination)) {
                return false;
            }
            Destination destination = (Destination) other;
            return Intrinsics.areEqual(this.deviceId, destination.deviceId) && Intrinsics.areEqual(this.fcmToken, destination.fcmToken);
        }

        public int hashCode() {
            int iHashCode = this.deviceId.hashCode() * 31;
            String str = this.fcmToken;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Destination(deviceId=" + this.deviceId + ", fcmToken=" + this.fcmToken + ")";
        }

        public Destination(String deviceId, String str) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            this.deviceId = deviceId;
            this.fcmToken = str;
        }

        public /* synthetic */ Destination(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getFcmToken() {
            return this.fcmToken;
        }
    }

    /* JADX INFO: compiled from: DeviceMessage.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005J\u001a\u0010\b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\n\u001a\u00020\u00002\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Builder;", "", "<init>", "()V", NotificationCompat.CATEGORY_EVENT, "", "source", "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Source;", FirebaseAnalytics.Param.DESTINATION, "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage$Destination;", "payload", "", "deviceId", "connectId", "fcmToken", "", "addPayload", "key", "value", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Destination destination;
        private String event;
        private final Map<String, Object> payload = new LinkedHashMap();
        private Source source;

        public final Builder event(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            return this;
        }

        public static /* synthetic */ Builder source$default(Builder builder, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = str;
            }
            return builder.source(str, str2);
        }

        public final Builder source(String deviceId, String connectId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(connectId, "connectId");
            this.source = new Source(deviceId, connectId);
            return this;
        }

        public static /* synthetic */ Builder destination$default(Builder builder, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return builder.destination(str, str2);
        }

        public final Builder destination(String deviceId, String fcmToken) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            this.destination = new Destination(deviceId, fcmToken);
            return this;
        }

        public final Builder payload(Map<String, ? extends Object> payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.payload.clear();
            this.payload.putAll(payload);
            return this;
        }

        public final Builder addPayload(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.payload.put(key, value);
            return this;
        }

        public final DeviceMessage build() {
            if (this.event == null) {
                throw new IllegalArgumentException("Event is required".toString());
            }
            if (this.source == null) {
                throw new IllegalArgumentException("Source is required".toString());
            }
            if (this.destination == null) {
                throw new IllegalArgumentException("Destination is required".toString());
            }
            String str = this.event;
            Intrinsics.checkNotNull(str);
            Source source = this.source;
            Intrinsics.checkNotNull(source);
            Destination destination = this.destination;
            Intrinsics.checkNotNull(destination);
            return new DeviceMessage(str, source, destination, MapsKt.toMap(this.payload), null);
        }
    }
}
