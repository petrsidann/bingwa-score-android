package com.example.bingwahybrid.domain.subscriptions.model;

import com.example.bingwahybrid.domain.enums.SubscriptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Subscription.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "", "featureCode", "", "type", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "limit", "", "deviceId", "<init>", "(Ljava/lang/String;Lcom/example/bingwahybrid/domain/enums/SubscriptionType;JLjava/lang/String;)V", "getFeatureCode", "()Ljava/lang/String;", "getType", "()Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "getLimit", "()J", "getDeviceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Subscription {
    public static final int $stable = 0;
    private final String deviceId;
    private final String featureCode;
    private final long limit;
    private final SubscriptionType type;

    public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, SubscriptionType subscriptionType, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscription.featureCode;
        }
        if ((i & 2) != 0) {
            subscriptionType = subscription.type;
        }
        if ((i & 4) != 0) {
            j = subscription.limit;
        }
        if ((i & 8) != 0) {
            str2 = subscription.deviceId;
        }
        String str3 = str2;
        return subscription.copy(str, subscriptionType, j, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeatureCode() {
        return this.featureCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SubscriptionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final Subscription copy(String featureCode, SubscriptionType type, long limit, String deviceId) {
        Intrinsics.checkNotNullParameter(featureCode, "featureCode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return new Subscription(featureCode, type, limit, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) other;
        return Intrinsics.areEqual(this.featureCode, subscription.featureCode) && this.type == subscription.type && this.limit == subscription.limit && Intrinsics.areEqual(this.deviceId, subscription.deviceId);
    }

    public int hashCode() {
        return (((((this.featureCode.hashCode() * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.limit)) * 31) + this.deviceId.hashCode();
    }

    public String toString() {
        return "Subscription(featureCode=" + this.featureCode + ", type=" + this.type + ", limit=" + this.limit + ", deviceId=" + this.deviceId + ")";
    }

    public Subscription(String featureCode, SubscriptionType type, long j, String deviceId) {
        Intrinsics.checkNotNullParameter(featureCode, "featureCode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.featureCode = featureCode;
        this.type = type;
        this.limit = j;
        this.deviceId = deviceId;
    }

    public final String getFeatureCode() {
        return this.featureCode;
    }

    public final SubscriptionType getType() {
        return this.type;
    }

    public final long getLimit() {
        return this.limit;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
