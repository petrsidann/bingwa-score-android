package com.example.bingwahybrid.domain.offers.model;

import com.example.bingwahybrid.domain.offers.enums.InputMode;
import com.example.bingwahybrid.domain.offers.enums.StepType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifiedOfferStep.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lcom/example/bingwahybrid/domain/offers/model/VerifiedOfferStep;", "", "type", "Lcom/example/bingwahybrid/domain/offers/enums/StepType;", "pattern", "", "inputMode", "Lcom/example/bingwahybrid/domain/offers/enums/InputMode;", "inputValue", "inputKey", "<init>", "(Lcom/example/bingwahybrid/domain/offers/enums/StepType;Ljava/lang/String;Lcom/example/bingwahybrid/domain/offers/enums/InputMode;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/example/bingwahybrid/domain/offers/enums/StepType;", "getPattern", "()Ljava/lang/String;", "getInputMode", "()Lcom/example/bingwahybrid/domain/offers/enums/InputMode;", "getInputValue", "getInputKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VerifiedOfferStep {
    public static final int $stable = 0;
    private final String inputKey;
    private final InputMode inputMode;
    private final String inputValue;
    private final String pattern;
    private final StepType type;

    public static /* synthetic */ VerifiedOfferStep copy$default(VerifiedOfferStep verifiedOfferStep, StepType stepType, String str, InputMode inputMode, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            stepType = verifiedOfferStep.type;
        }
        if ((i & 2) != 0) {
            str = verifiedOfferStep.pattern;
        }
        if ((i & 4) != 0) {
            inputMode = verifiedOfferStep.inputMode;
        }
        if ((i & 8) != 0) {
            str2 = verifiedOfferStep.inputValue;
        }
        if ((i & 16) != 0) {
            str3 = verifiedOfferStep.inputKey;
        }
        String str4 = str3;
        InputMode inputMode2 = inputMode;
        return verifiedOfferStep.copy(stepType, str, inputMode2, str2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StepType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InputMode getInputMode() {
        return this.inputMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInputValue() {
        return this.inputValue;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInputKey() {
        return this.inputKey;
    }

    public final VerifiedOfferStep copy(StepType type, String pattern, InputMode inputMode, String inputValue, String inputKey) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new VerifiedOfferStep(type, pattern, inputMode, inputValue, inputKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifiedOfferStep)) {
            return false;
        }
        VerifiedOfferStep verifiedOfferStep = (VerifiedOfferStep) other;
        return this.type == verifiedOfferStep.type && Intrinsics.areEqual(this.pattern, verifiedOfferStep.pattern) && this.inputMode == verifiedOfferStep.inputMode && Intrinsics.areEqual(this.inputValue, verifiedOfferStep.inputValue) && Intrinsics.areEqual(this.inputKey, verifiedOfferStep.inputKey);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.pattern;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        InputMode inputMode = this.inputMode;
        int iHashCode3 = (iHashCode2 + (inputMode == null ? 0 : inputMode.hashCode())) * 31;
        String str2 = this.inputValue;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.inputKey;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "VerifiedOfferStep(type=" + this.type + ", pattern=" + this.pattern + ", inputMode=" + this.inputMode + ", inputValue=" + this.inputValue + ", inputKey=" + this.inputKey + ")";
    }

    public VerifiedOfferStep(StepType type, String str, InputMode inputMode, String str2, String str3) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.pattern = str;
        this.inputMode = inputMode;
        this.inputValue = str2;
        this.inputKey = str3;
    }

    public /* synthetic */ VerifiedOfferStep(StepType stepType, String str, InputMode inputMode, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stepType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : inputMode, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public final StepType getType() {
        return this.type;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final InputMode getInputMode() {
        return this.inputMode;
    }

    public final String getInputValue() {
        return this.inputValue;
    }

    public final String getInputKey() {
        return this.inputKey;
    }
}
