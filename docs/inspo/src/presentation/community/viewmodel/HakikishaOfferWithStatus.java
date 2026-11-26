package com.example.bingwahybrid.presentation.community.viewmodel;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommunityOffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/example/bingwahybrid/presentation/community/viewmodel/HakikishaOfferWithStatus;", "", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "verificationInfo", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "isLocked", "", "requiresPurchase", "<init>", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;ZZ)V", "getOffer", "()Lcom/example/bingwahybrid/domain/offers/model/Offer;", "getVerificationInfo", "()Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "()Z", "getRequiresPurchase", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HakikishaOfferWithStatus {
    public static final int $stable = 8;
    private final boolean isLocked;
    private final Offer offer;
    private final boolean requiresPurchase;
    private final OfferVerificationInfo verificationInfo;

    public static /* synthetic */ HakikishaOfferWithStatus copy$default(HakikishaOfferWithStatus hakikishaOfferWithStatus, Offer offer, OfferVerificationInfo offerVerificationInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            offer = hakikishaOfferWithStatus.offer;
        }
        if ((i & 2) != 0) {
            offerVerificationInfo = hakikishaOfferWithStatus.verificationInfo;
        }
        if ((i & 4) != 0) {
            z = hakikishaOfferWithStatus.isLocked;
        }
        if ((i & 8) != 0) {
            z2 = hakikishaOfferWithStatus.requiresPurchase;
        }
        return hakikishaOfferWithStatus.copy(offer, offerVerificationInfo, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Offer getOffer() {
        return this.offer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OfferVerificationInfo getVerificationInfo() {
        return this.verificationInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequiresPurchase() {
        return this.requiresPurchase;
    }

    public final HakikishaOfferWithStatus copy(Offer offer, OfferVerificationInfo verificationInfo, boolean isLocked, boolean requiresPurchase) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        Intrinsics.checkNotNullParameter(verificationInfo, "verificationInfo");
        return new HakikishaOfferWithStatus(offer, verificationInfo, isLocked, requiresPurchase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HakikishaOfferWithStatus)) {
            return false;
        }
        HakikishaOfferWithStatus hakikishaOfferWithStatus = (HakikishaOfferWithStatus) other;
        return Intrinsics.areEqual(this.offer, hakikishaOfferWithStatus.offer) && Intrinsics.areEqual(this.verificationInfo, hakikishaOfferWithStatus.verificationInfo) && this.isLocked == hakikishaOfferWithStatus.isLocked && this.requiresPurchase == hakikishaOfferWithStatus.requiresPurchase;
    }

    public int hashCode() {
        return (((((this.offer.hashCode() * 31) + this.verificationInfo.hashCode()) * 31) + Boolean.hashCode(this.isLocked)) * 31) + Boolean.hashCode(this.requiresPurchase);
    }

    public String toString() {
        return "HakikishaOfferWithStatus(offer=" + this.offer + ", verificationInfo=" + this.verificationInfo + ", isLocked=" + this.isLocked + ", requiresPurchase=" + this.requiresPurchase + ")";
    }

    public HakikishaOfferWithStatus(Offer offer, OfferVerificationInfo verificationInfo, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        Intrinsics.checkNotNullParameter(verificationInfo, "verificationInfo");
        this.offer = offer;
        this.verificationInfo = verificationInfo;
        this.isLocked = z;
        this.requiresPurchase = z2;
    }

    public final Offer getOffer() {
        return this.offer;
    }

    public final OfferVerificationInfo getVerificationInfo() {
        return this.verificationInfo;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean getRequiresPurchase() {
        return this.requiresPurchase;
    }
}
