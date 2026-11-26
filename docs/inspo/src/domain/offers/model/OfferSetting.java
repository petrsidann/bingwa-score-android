package com.example.bingwahybrid.domain.offers.model;

import com.example.bingwahybrid.domain.enums.OfferSettingKey;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/example/bingwahybrid/domain/offers/model/OfferSetting;", "", "id", "", "offerId", "Ljava/util/UUID;", "key", "Lcom/example/bingwahybrid/domain/enums/OfferSettingKey;", "value", "", "updatedAt", "<init>", "(JLjava/util/UUID;Lcom/example/bingwahybrid/domain/enums/OfferSettingKey;Ljava/lang/String;J)V", "getId", "()J", "getOfferId", "()Ljava/util/UUID;", "getKey", "()Lcom/example/bingwahybrid/domain/enums/OfferSettingKey;", "getValue", "()Ljava/lang/String;", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfferSetting {
    public static final int $stable = 8;
    private final long id;
    private final OfferSettingKey key;
    private final UUID offerId;
    private final long updatedAt;
    private final String value;

    public static /* synthetic */ OfferSetting copy$default(OfferSetting offerSetting, long j, UUID uuid, OfferSettingKey offerSettingKey, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = offerSetting.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            uuid = offerSetting.offerId;
        }
        UUID uuid2 = uuid;
        if ((i & 4) != 0) {
            offerSettingKey = offerSetting.key;
        }
        OfferSettingKey offerSettingKey2 = offerSettingKey;
        if ((i & 8) != 0) {
            str = offerSetting.value;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            j2 = offerSetting.updatedAt;
        }
        return offerSetting.copy(j3, uuid2, offerSettingKey2, str2, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UUID getOfferId() {
        return this.offerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OfferSettingKey getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final OfferSetting copy(long id, UUID offerId, OfferSettingKey key, String value, long updatedAt) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new OfferSetting(id, offerId, key, value, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferSetting)) {
            return false;
        }
        OfferSetting offerSetting = (OfferSetting) other;
        return this.id == offerSetting.id && Intrinsics.areEqual(this.offerId, offerSetting.offerId) && this.key == offerSetting.key && Intrinsics.areEqual(this.value, offerSetting.value) && this.updatedAt == offerSetting.updatedAt;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.offerId.hashCode()) * 31) + this.key.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "OfferSetting(id=" + this.id + ", offerId=" + this.offerId + ", key=" + this.key + ", value=" + this.value + ", updatedAt=" + this.updatedAt + ")";
    }

    public OfferSetting(long j, UUID offerId, OfferSettingKey key, String value, long j2) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.id = j;
        this.offerId = offerId;
        this.key = key;
        this.value = value;
        this.updatedAt = j2;
    }

    public final long getId() {
        return this.id;
    }

    public final UUID getOfferId() {
        return this.offerId;
    }

    public final OfferSettingKey getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public /* synthetic */ OfferSetting(long j, UUID uuid, OfferSettingKey offerSettingKey, String str, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, uuid, offerSettingKey, str, (i & 16) != 0 ? System.currentTimeMillis() : j2);
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
