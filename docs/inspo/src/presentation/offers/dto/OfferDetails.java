package com.example.bingwahybrid.presentation.offers.dto;

import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferDetails.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014¨\u0006!"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/OfferDetails;", "", "offerName", "", "ussdCode", FirebaseAnalytics.Param.PRICE, "type", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "autoReschedule", "", "isActive", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/offers/enums/OfferType;ZZ)V", "getOfferName", "()Ljava/lang/String;", "getUssdCode", "getPrice", "getType", "()Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "getAutoReschedule", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfferDetails {
    public static final int $stable = 0;
    private final boolean autoReschedule;
    private final boolean isActive;
    private final String offerName;
    private final String price;
    private final OfferType type;
    private final String ussdCode;

    public OfferDetails() {
        this(null, null, null, null, false, false, 63, null);
    }

    public static /* synthetic */ OfferDetails copy$default(OfferDetails offerDetails, String str, String str2, String str3, OfferType offerType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerDetails.offerName;
        }
        if ((i & 2) != 0) {
            str2 = offerDetails.ussdCode;
        }
        if ((i & 4) != 0) {
            str3 = offerDetails.price;
        }
        if ((i & 8) != 0) {
            offerType = offerDetails.type;
        }
        if ((i & 16) != 0) {
            z = offerDetails.autoReschedule;
        }
        if ((i & 32) != 0) {
            z2 = offerDetails.isActive;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return offerDetails.copy(str, str2, str3, offerType, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOfferName() {
        return this.offerName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUssdCode() {
        return this.ussdCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OfferType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final OfferDetails copy(String offerName, String ussdCode, String price, OfferType type, boolean autoReschedule, boolean isActive) {
        Intrinsics.checkNotNullParameter(offerName, "offerName");
        Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(type, "type");
        return new OfferDetails(offerName, ussdCode, price, type, autoReschedule, isActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferDetails)) {
            return false;
        }
        OfferDetails offerDetails = (OfferDetails) other;
        return Intrinsics.areEqual(this.offerName, offerDetails.offerName) && Intrinsics.areEqual(this.ussdCode, offerDetails.ussdCode) && Intrinsics.areEqual(this.price, offerDetails.price) && this.type == offerDetails.type && this.autoReschedule == offerDetails.autoReschedule && this.isActive == offerDetails.isActive;
    }

    public int hashCode() {
        return (((((((((this.offerName.hashCode() * 31) + this.ussdCode.hashCode()) * 31) + this.price.hashCode()) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.autoReschedule)) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "OfferDetails(offerName=" + this.offerName + ", ussdCode=" + this.ussdCode + ", price=" + this.price + ", type=" + this.type + ", autoReschedule=" + this.autoReschedule + ", isActive=" + this.isActive + ")";
    }

    public OfferDetails(String offerName, String ussdCode, String price, OfferType type, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(offerName, "offerName");
        Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(type, "type");
        this.offerName = offerName;
        this.ussdCode = ussdCode;
        this.price = price;
        this.type = type;
        this.autoReschedule = z;
        this.isActive = z2;
    }

    public /* synthetic */ OfferDetails(String str, String str2, String str3, OfferType offerType, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? OfferType.DATA : offerType, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2);
    }

    public final String getOfferName() {
        return this.offerName;
    }

    public final String getUssdCode() {
        return this.ussdCode;
    }

    public final String getPrice() {
        return this.price;
    }

    public final OfferType getType() {
        return this.type;
    }

    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
