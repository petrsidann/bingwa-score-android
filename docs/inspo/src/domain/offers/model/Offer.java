package com.example.bingwahybrid.domain.offers.model;

import com.example.bingwahybrid.domain.offers.enums.OfferTag;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Offer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0001LBµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u00103\u001a\u000204J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0018HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003JÁ\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000eHÆ\u0001J\u0013\u0010H\u001a\u00020\u000e2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\bHÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010)R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010)R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010)R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)¨\u0006M"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/model/Offer;", "", "id", "Ljava/util/UUID;", "name", "", "ussdCode", FirebaseAnalytics.Param.PRICE, "", "type", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "tag", "Lcom/example/bingwahybrid/domain/offers/enums/OfferTag;", "autoReschedule", "", "autoRescheduleRunTime", "isActive", "isVerified", "isDirty", "autoRetryConnectionProblems", "autoRetry", "numberOfRetries", "retryIntervalMins", "ussdTimeoutMillis", "", "relayDevice", "strictMode", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;ILcom/example/bingwahybrid/domain/offers/enums/OfferType;Lcom/example/bingwahybrid/domain/offers/enums/OfferTag;ZLjava/lang/String;ZZZZZIIJLjava/lang/String;Z)V", "getId", "()Ljava/util/UUID;", "getName", "()Ljava/lang/String;", "getUssdCode", "getPrice", "()I", "getType", "()Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "getTag", "()Lcom/example/bingwahybrid/domain/offers/enums/OfferTag;", "getAutoReschedule", "()Z", "getAutoRescheduleRunTime", "getAutoRetryConnectionProblems", "getAutoRetry", "getNumberOfRetries", "getRetryIntervalMins", "getUssdTimeoutMillis", "()J", "getRelayDevice", "getStrictMode", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Offer {
    private final boolean autoReschedule;
    private final String autoRescheduleRunTime;
    private final boolean autoRetry;
    private final boolean autoRetryConnectionProblems;
    private final UUID id;
    private final boolean isActive;
    private final boolean isDirty;
    private final boolean isVerified;
    private final String name;
    private final int numberOfRetries;
    private final int price;
    private final String relayDevice;
    private final int retryIntervalMins;
    private final boolean strictMode;
    private final OfferTag tag;
    private final OfferType type;
    private final String ussdCode;
    private final long ussdTimeoutMillis;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ Offer copy$default(Offer offer, UUID uuid, String str, String str2, int i, OfferType offerType, OfferTag offerTag, boolean z, String str3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, int i3, long j, String str4, boolean z7, int i4, Object obj) {
        UUID uuid2 = (i4 & 1) != 0 ? offer.id : uuid;
        return offer.copy(uuid2, (i4 & 2) != 0 ? offer.name : str, (i4 & 4) != 0 ? offer.ussdCode : str2, (i4 & 8) != 0 ? offer.price : i, (i4 & 16) != 0 ? offer.type : offerType, (i4 & 32) != 0 ? offer.tag : offerTag, (i4 & 64) != 0 ? offer.autoReschedule : z, (i4 & 128) != 0 ? offer.autoRescheduleRunTime : str3, (i4 & 256) != 0 ? offer.isActive : z2, (i4 & 512) != 0 ? offer.isVerified : z3, (i4 & 1024) != 0 ? offer.isDirty : z4, (i4 & 2048) != 0 ? offer.autoRetryConnectionProblems : z5, (i4 & 4096) != 0 ? offer.autoRetry : z6, (i4 & 8192) != 0 ? offer.numberOfRetries : i2, (i4 & 16384) != 0 ? offer.retryIntervalMins : i3, (i4 & 32768) != 0 ? offer.ussdTimeoutMillis : j, (i4 & 65536) != 0 ? offer.relayDevice : str4, (i4 & 131072) != 0 ? offer.strictMode : z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsVerified() {
        return this.isVerified;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsDirty() {
        return this.isDirty;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getAutoRetryConnectionProblems() {
        return this.autoRetryConnectionProblems;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getAutoRetry() {
        return this.autoRetry;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getNumberOfRetries() {
        return this.numberOfRetries;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getRetryIntervalMins() {
        return this.retryIntervalMins;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getUssdTimeoutMillis() {
        return this.ussdTimeoutMillis;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRelayDevice() {
        return this.relayDevice;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getStrictMode() {
        return this.strictMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUssdCode() {
        return this.ussdCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final OfferType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final OfferTag getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAutoRescheduleRunTime() {
        return this.autoRescheduleRunTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final Offer copy(UUID id, String name, String ussdCode, int price, OfferType type, OfferTag tag, boolean autoReschedule, String autoRescheduleRunTime, boolean isActive, boolean isVerified, boolean isDirty, boolean autoRetryConnectionProblems, boolean autoRetry, int numberOfRetries, int retryIntervalMins, long ussdTimeoutMillis, String relayDevice, boolean strictMode) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(autoRescheduleRunTime, "autoRescheduleRunTime");
        return new Offer(id, name, ussdCode, price, type, tag, autoReschedule, autoRescheduleRunTime, isActive, isVerified, isDirty, autoRetryConnectionProblems, autoRetry, numberOfRetries, retryIntervalMins, ussdTimeoutMillis, relayDevice, strictMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Offer)) {
            return false;
        }
        Offer offer = (Offer) other;
        return Intrinsics.areEqual(this.id, offer.id) && Intrinsics.areEqual(this.name, offer.name) && Intrinsics.areEqual(this.ussdCode, offer.ussdCode) && this.price == offer.price && this.type == offer.type && this.tag == offer.tag && this.autoReschedule == offer.autoReschedule && Intrinsics.areEqual(this.autoRescheduleRunTime, offer.autoRescheduleRunTime) && this.isActive == offer.isActive && this.isVerified == offer.isVerified && this.isDirty == offer.isDirty && this.autoRetryConnectionProblems == offer.autoRetryConnectionProblems && this.autoRetry == offer.autoRetry && this.numberOfRetries == offer.numberOfRetries && this.retryIntervalMins == offer.retryIntervalMins && this.ussdTimeoutMillis == offer.ussdTimeoutMillis && Intrinsics.areEqual(this.relayDevice, offer.relayDevice) && this.strictMode == offer.strictMode;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.ussdCode.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.type.hashCode()) * 31;
        OfferTag offerTag = this.tag;
        int iHashCode2 = (((((((((((((((((((((iHashCode + (offerTag == null ? 0 : offerTag.hashCode())) * 31) + Boolean.hashCode(this.autoReschedule)) * 31) + this.autoRescheduleRunTime.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + Boolean.hashCode(this.isVerified)) * 31) + Boolean.hashCode(this.isDirty)) * 31) + Boolean.hashCode(this.autoRetryConnectionProblems)) * 31) + Boolean.hashCode(this.autoRetry)) * 31) + Integer.hashCode(this.numberOfRetries)) * 31) + Integer.hashCode(this.retryIntervalMins)) * 31) + Long.hashCode(this.ussdTimeoutMillis)) * 31;
        String str = this.relayDevice;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.strictMode);
    }

    public String toString() {
        return "Offer(id=" + this.id + ", name=" + this.name + ", ussdCode=" + this.ussdCode + ", price=" + this.price + ", type=" + this.type + ", tag=" + this.tag + ", autoReschedule=" + this.autoReschedule + ", autoRescheduleRunTime=" + this.autoRescheduleRunTime + ", isActive=" + this.isActive + ", isVerified=" + this.isVerified + ", isDirty=" + this.isDirty + ", autoRetryConnectionProblems=" + this.autoRetryConnectionProblems + ", autoRetry=" + this.autoRetry + ", numberOfRetries=" + this.numberOfRetries + ", retryIntervalMins=" + this.retryIntervalMins + ", ussdTimeoutMillis=" + this.ussdTimeoutMillis + ", relayDevice=" + this.relayDevice + ", strictMode=" + this.strictMode + ")";
    }

    public Offer(UUID id, String name, String ussdCode, int i, OfferType type, OfferTag offerTag, boolean z, String autoRescheduleRunTime, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, int i3, long j, String str, boolean z7) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(autoRescheduleRunTime, "autoRescheduleRunTime");
        this.id = id;
        this.name = name;
        this.ussdCode = ussdCode;
        this.price = i;
        this.type = type;
        this.tag = offerTag;
        this.autoReschedule = z;
        this.autoRescheduleRunTime = autoRescheduleRunTime;
        this.isActive = z2;
        this.isVerified = z3;
        this.isDirty = z4;
        this.autoRetryConnectionProblems = z5;
        this.autoRetry = z6;
        this.numberOfRetries = i2;
        this.retryIntervalMins = i3;
        this.ussdTimeoutMillis = j;
        this.relayDevice = str;
        this.strictMode = z7;
    }

    public final UUID getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUssdCode() {
        return this.ussdCode;
    }

    public final int getPrice() {
        return this.price;
    }

    public final OfferType getType() {
        return this.type;
    }

    public final OfferTag getTag() {
        return this.tag;
    }

    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    public /* synthetic */ Offer(UUID uuid, String str, String str2, int i, OfferType offerType, OfferTag offerTag, boolean z, String str3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, int i3, long j, String str4, boolean z7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, str2, i, offerType, (i4 & 32) != 0 ? null : offerTag, (i4 & 64) != 0 ? false : z, (i4 & 128) != 0 ? "00:01" : str3, (i4 & 256) != 0 ? true : z2, (i4 & 512) != 0 ? false : z3, (i4 & 1024) != 0 ? true : z4, (i4 & 2048) != 0 ? true : z5, (i4 & 4096) != 0 ? true : z6, (i4 & 8192) != 0 ? 2 : i2, (i4 & 16384) != 0 ? 1 : i3, (32768 & i4) != 0 ? 40000L : j, (65536 & i4) != 0 ? null : str4, (i4 & 131072) != 0 ? false : z7);
    }

    public final String getAutoRescheduleRunTime() {
        return this.autoRescheduleRunTime;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isVerified() {
        return this.isVerified;
    }

    public final boolean isDirty() {
        return this.isDirty;
    }

    public final boolean getAutoRetryConnectionProblems() {
        return this.autoRetryConnectionProblems;
    }

    public final boolean getAutoRetry() {
        return this.autoRetry;
    }

    public final int getNumberOfRetries() {
        return this.numberOfRetries;
    }

    public final int getRetryIntervalMins() {
        return this.retryIntervalMins;
    }

    public final long getUssdTimeoutMillis() {
        return this.ussdTimeoutMillis;
    }

    public final String getRelayDevice() {
        return this.relayDevice;
    }

    public final boolean getStrictMode() {
        return this.strictMode;
    }

    public final JSONObject toJson() throws JSONException {
        Object objName;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id.toString());
        jSONObject.put("name", this.name);
        jSONObject.put("ussdCode", this.ussdCode);
        jSONObject.put(FirebaseAnalytics.Param.PRICE, this.price);
        jSONObject.put("type", this.type.name());
        OfferTag offerTag = this.tag;
        if (offerTag == null || (objName = offerTag.name()) == null) {
            objName = JSONObject.NULL;
        }
        jSONObject.put("tag", objName);
        jSONObject.put("autoReschedule", this.autoReschedule);
        jSONObject.put("autoSchedulesRunTime", this.autoRescheduleRunTime);
        jSONObject.put("autoRetryConnectionProblems", this.autoRetryConnectionProblems);
        jSONObject.put("autoRetry", this.autoRetry);
        jSONObject.put("numberOfRetries", this.numberOfRetries);
        jSONObject.put("retryIntervalMins", this.retryIntervalMins);
        jSONObject.put("ussdTimeoutMillis", this.ussdTimeoutMillis);
        jSONObject.put("isActive", this.isActive);
        Object obj = this.relayDevice;
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put("relayDevice", obj);
        jSONObject.put("strictMode", this.strictMode);
        return jSONObject;
    }

    /* JADX INFO: compiled from: Offer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/model/Offer$Companion;", "", "<init>", "()V", "fromJson", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "json", "Lorg/json/JSONObject;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Offer fromJson(JSONObject json) throws JSONException {
            OfferTag offerTagValueOf;
            Intrinsics.checkNotNullParameter(json, "json");
            UUID uuidFromString = UUID.fromString(json.getString("id"));
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
            String string = json.getString("name");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = json.getString("ussdCode");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int i = json.getInt(FirebaseAnalytics.Param.PRICE);
            String string3 = json.getString("type");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            OfferType offerTypeValueOf = OfferType.valueOf(string3);
            if (json.isNull("tag")) {
                offerTagValueOf = null;
            } else {
                String string4 = json.getString("tag");
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                offerTagValueOf = OfferTag.valueOf(string4);
            }
            boolean zOptBoolean = json.optBoolean("autoReschedule", false);
            String strOptString = json.optString("autoSchedulesRunTime", "00:01");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            return new Offer(uuidFromString, string, string2, i, offerTypeValueOf, offerTagValueOf, zOptBoolean, strOptString, json.optBoolean("isActive", false), false, false, json.optBoolean("autoRetryConnectionProblems", false), json.optBoolean("autoRetry", false), json.optInt("numberOfRetries", 0), json.optInt("retryIntervalMins", 1), json.optLong("ussdTimeoutMillis", 40000L), json.isNull("relayDevice") ? null : json.getString("relayDevice"), json.optBoolean("strictMode", false), 1536, null);
        }
    }
}
