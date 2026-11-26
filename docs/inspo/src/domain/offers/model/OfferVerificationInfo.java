package com.example.bingwahybrid.domain.offers.model;

import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferVerificationInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "", "offerId", "Ljava/util/UUID;", "code", "", "version", "", "maxPagination", "steps", "", "Lcom/example/bingwahybrid/domain/offers/model/VerifiedOfferStep;", "<init>", "(Ljava/util/UUID;Ljava/lang/String;IILjava/util/List;)V", "getOfferId", "()Ljava/util/UUID;", "getCode", "()Ljava/lang/String;", "getVersion", "()I", "getMaxPagination", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfferVerificationInfo {
    public static final int $stable = 8;
    private final String code;
    private final int maxPagination;
    private final UUID offerId;
    private final List<VerifiedOfferStep> steps;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferVerificationInfo copy$default(OfferVerificationInfo offerVerificationInfo, UUID uuid, String str, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uuid = offerVerificationInfo.offerId;
        }
        if ((i3 & 2) != 0) {
            str = offerVerificationInfo.code;
        }
        if ((i3 & 4) != 0) {
            i = offerVerificationInfo.version;
        }
        if ((i3 & 8) != 0) {
            i2 = offerVerificationInfo.maxPagination;
        }
        if ((i3 & 16) != 0) {
            list = offerVerificationInfo.steps;
        }
        List list2 = list;
        int i4 = i;
        return offerVerificationInfo.copy(uuid, str, i4, i2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getOfferId() {
        return this.offerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMaxPagination() {
        return this.maxPagination;
    }

    public final List<VerifiedOfferStep> component5() {
        return this.steps;
    }

    public final OfferVerificationInfo copy(UUID offerId, String code, int version, int maxPagination, List<VerifiedOfferStep> steps) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new OfferVerificationInfo(offerId, code, version, maxPagination, steps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferVerificationInfo)) {
            return false;
        }
        OfferVerificationInfo offerVerificationInfo = (OfferVerificationInfo) other;
        return Intrinsics.areEqual(this.offerId, offerVerificationInfo.offerId) && Intrinsics.areEqual(this.code, offerVerificationInfo.code) && this.version == offerVerificationInfo.version && this.maxPagination == offerVerificationInfo.maxPagination && Intrinsics.areEqual(this.steps, offerVerificationInfo.steps);
    }

    public int hashCode() {
        return (((((((this.offerId.hashCode() * 31) + this.code.hashCode()) * 31) + Integer.hashCode(this.version)) * 31) + Integer.hashCode(this.maxPagination)) * 31) + this.steps.hashCode();
    }

    public String toString() {
        return "OfferVerificationInfo(offerId=" + this.offerId + ", code=" + this.code + ", version=" + this.version + ", maxPagination=" + this.maxPagination + ", steps=" + this.steps + ")";
    }

    public OfferVerificationInfo(UUID offerId, String code, int i, int i2, List<VerifiedOfferStep> steps) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.offerId = offerId;
        this.code = code;
        this.version = i;
        this.maxPagination = i2;
        this.steps = steps;
    }

    public /* synthetic */ OfferVerificationInfo(UUID uuid, String str, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, i, (i3 & 8) != 0 ? 5 : i2, list);
    }

    public final UUID getOfferId() {
        return this.offerId;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getMaxPagination() {
        return this.maxPagination;
    }

    public final List<VerifiedOfferStep> getSteps() {
        return this.steps;
    }
}
