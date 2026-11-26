package com.example.bingwahybrid.presentation.offers.dto;

import com.fasterxml.jackson.core.io.doubleparser.FastDoubleMath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferSettingsState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jo\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006,"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/OfferSettingsState;", "", "isLoading", "", "errorMessage", "", "autoReschedule", "autoRescheduleRunTime", "ussdTimeoutSeconds", "", "autoRetry", "numberOfRetries", "retryIntervalMins", "autoRetryConnectionProblems", "strictMode", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;IZIIZZ)V", "()Z", "getErrorMessage", "()Ljava/lang/String;", "getAutoReschedule", "getAutoRescheduleRunTime", "getUssdTimeoutSeconds", "()I", "getAutoRetry", "getNumberOfRetries", "getRetryIntervalMins", "getAutoRetryConnectionProblems", "getStrictMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfferSettingsState {
    public static final int $stable = 0;
    private final boolean autoReschedule;
    private final String autoRescheduleRunTime;
    private final boolean autoRetry;
    private final boolean autoRetryConnectionProblems;
    private final String errorMessage;
    private final boolean isLoading;
    private final int numberOfRetries;
    private final int retryIntervalMins;
    private final boolean strictMode;
    private final int ussdTimeoutSeconds;

    public OfferSettingsState() {
        this(false, null, false, null, 0, false, 0, 0, false, false, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    public static /* synthetic */ OfferSettingsState copy$default(OfferSettingsState offerSettingsState, boolean z, String str, boolean z2, String str2, int i, boolean z3, int i2, int i3, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = offerSettingsState.isLoading;
        }
        if ((i4 & 2) != 0) {
            str = offerSettingsState.errorMessage;
        }
        if ((i4 & 4) != 0) {
            z2 = offerSettingsState.autoReschedule;
        }
        if ((i4 & 8) != 0) {
            str2 = offerSettingsState.autoRescheduleRunTime;
        }
        if ((i4 & 16) != 0) {
            i = offerSettingsState.ussdTimeoutSeconds;
        }
        if ((i4 & 32) != 0) {
            z3 = offerSettingsState.autoRetry;
        }
        if ((i4 & 64) != 0) {
            i2 = offerSettingsState.numberOfRetries;
        }
        if ((i4 & 128) != 0) {
            i3 = offerSettingsState.retryIntervalMins;
        }
        if ((i4 & 256) != 0) {
            z4 = offerSettingsState.autoRetryConnectionProblems;
        }
        if ((i4 & 512) != 0) {
            z5 = offerSettingsState.strictMode;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        int i5 = i2;
        int i6 = i3;
        int i7 = i;
        boolean z8 = z3;
        return offerSettingsState.copy(z, str, z2, str2, i7, z8, i5, i6, z6, z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getStrictMode() {
        return this.strictMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAutoRescheduleRunTime() {
        return this.autoRescheduleRunTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getUssdTimeoutSeconds() {
        return this.ussdTimeoutSeconds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAutoRetry() {
        return this.autoRetry;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getNumberOfRetries() {
        return this.numberOfRetries;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getRetryIntervalMins() {
        return this.retryIntervalMins;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAutoRetryConnectionProblems() {
        return this.autoRetryConnectionProblems;
    }

    public final OfferSettingsState copy(boolean isLoading, String errorMessage, boolean autoReschedule, String autoRescheduleRunTime, int ussdTimeoutSeconds, boolean autoRetry, int numberOfRetries, int retryIntervalMins, boolean autoRetryConnectionProblems, boolean strictMode) {
        Intrinsics.checkNotNullParameter(autoRescheduleRunTime, "autoRescheduleRunTime");
        return new OfferSettingsState(isLoading, errorMessage, autoReschedule, autoRescheduleRunTime, ussdTimeoutSeconds, autoRetry, numberOfRetries, retryIntervalMins, autoRetryConnectionProblems, strictMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferSettingsState)) {
            return false;
        }
        OfferSettingsState offerSettingsState = (OfferSettingsState) other;
        return this.isLoading == offerSettingsState.isLoading && Intrinsics.areEqual(this.errorMessage, offerSettingsState.errorMessage) && this.autoReschedule == offerSettingsState.autoReschedule && Intrinsics.areEqual(this.autoRescheduleRunTime, offerSettingsState.autoRescheduleRunTime) && this.ussdTimeoutSeconds == offerSettingsState.ussdTimeoutSeconds && this.autoRetry == offerSettingsState.autoRetry && this.numberOfRetries == offerSettingsState.numberOfRetries && this.retryIntervalMins == offerSettingsState.retryIntervalMins && this.autoRetryConnectionProblems == offerSettingsState.autoRetryConnectionProblems && this.strictMode == offerSettingsState.strictMode;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isLoading) * 31;
        String str = this.errorMessage;
        return ((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.autoReschedule)) * 31) + this.autoRescheduleRunTime.hashCode()) * 31) + Integer.hashCode(this.ussdTimeoutSeconds)) * 31) + Boolean.hashCode(this.autoRetry)) * 31) + Integer.hashCode(this.numberOfRetries)) * 31) + Integer.hashCode(this.retryIntervalMins)) * 31) + Boolean.hashCode(this.autoRetryConnectionProblems)) * 31) + Boolean.hashCode(this.strictMode);
    }

    public String toString() {
        return "OfferSettingsState(isLoading=" + this.isLoading + ", errorMessage=" + this.errorMessage + ", autoReschedule=" + this.autoReschedule + ", autoRescheduleRunTime=" + this.autoRescheduleRunTime + ", ussdTimeoutSeconds=" + this.ussdTimeoutSeconds + ", autoRetry=" + this.autoRetry + ", numberOfRetries=" + this.numberOfRetries + ", retryIntervalMins=" + this.retryIntervalMins + ", autoRetryConnectionProblems=" + this.autoRetryConnectionProblems + ", strictMode=" + this.strictMode + ")";
    }

    public OfferSettingsState(boolean z, String str, boolean z2, String autoRescheduleRunTime, int i, boolean z3, int i2, int i3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(autoRescheduleRunTime, "autoRescheduleRunTime");
        this.isLoading = z;
        this.errorMessage = str;
        this.autoReschedule = z2;
        this.autoRescheduleRunTime = autoRescheduleRunTime;
        this.ussdTimeoutSeconds = i;
        this.autoRetry = z3;
        this.numberOfRetries = i2;
        this.retryIntervalMins = i3;
        this.autoRetryConnectionProblems = z4;
        this.strictMode = z5;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getAutoReschedule() {
        return this.autoReschedule;
    }

    public /* synthetic */ OfferSettingsState(boolean z, String str, boolean z2, String str2, int i, boolean z3, int i2, int i3, boolean z4, boolean z5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? false : z2, (i4 & 8) != 0 ? "00:01" : str2, (i4 & 16) != 0 ? 40 : i, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 1 : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? true : z4, (i4 & 512) != 0 ? false : z5);
    }

    public final String getAutoRescheduleRunTime() {
        return this.autoRescheduleRunTime;
    }

    public final int getUssdTimeoutSeconds() {
        return this.ussdTimeoutSeconds;
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

    public final boolean getAutoRetryConnectionProblems() {
        return this.autoRetryConnectionProblems;
    }

    public final boolean getStrictMode() {
        return this.strictMode;
    }
}
