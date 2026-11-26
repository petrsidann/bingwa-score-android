package com.example.bingwahybrid.domain.engagebot.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EngageBot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/model/EngageBot;", "", "isActive", "", "engageMessage", "", "successResponse", "invalidInputResponse", "sessionTimeoutResponse", "sessionTimeoutMins", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "()Z", "getEngageMessage", "()Ljava/lang/String;", "getSuccessResponse", "getInvalidInputResponse", "getSessionTimeoutResponse", "getSessionTimeoutMins", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EngageBot {
    public static final int $stable = 0;
    private final String engageMessage;
    private final String invalidInputResponse;
    private final boolean isActive;
    private final int sessionTimeoutMins;
    private final String sessionTimeoutResponse;
    private final String successResponse;

    public EngageBot() {
        this(false, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ EngageBot copy$default(EngageBot engageBot, boolean z, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = engageBot.isActive;
        }
        if ((i2 & 2) != 0) {
            str = engageBot.engageMessage;
        }
        if ((i2 & 4) != 0) {
            str2 = engageBot.successResponse;
        }
        if ((i2 & 8) != 0) {
            str3 = engageBot.invalidInputResponse;
        }
        if ((i2 & 16) != 0) {
            str4 = engageBot.sessionTimeoutResponse;
        }
        if ((i2 & 32) != 0) {
            i = engageBot.sessionTimeoutMins;
        }
        String str5 = str4;
        int i3 = i;
        return engageBot.copy(z, str, str2, str3, str5, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEngageMessage() {
        return this.engageMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSuccessResponse() {
        return this.successResponse;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInvalidInputResponse() {
        return this.invalidInputResponse;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSessionTimeoutResponse() {
        return this.sessionTimeoutResponse;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSessionTimeoutMins() {
        return this.sessionTimeoutMins;
    }

    public final EngageBot copy(boolean isActive, String engageMessage, String successResponse, String invalidInputResponse, String sessionTimeoutResponse, int sessionTimeoutMins) {
        Intrinsics.checkNotNullParameter(engageMessage, "engageMessage");
        Intrinsics.checkNotNullParameter(successResponse, "successResponse");
        Intrinsics.checkNotNullParameter(invalidInputResponse, "invalidInputResponse");
        Intrinsics.checkNotNullParameter(sessionTimeoutResponse, "sessionTimeoutResponse");
        return new EngageBot(isActive, engageMessage, successResponse, invalidInputResponse, sessionTimeoutResponse, sessionTimeoutMins);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EngageBot)) {
            return false;
        }
        EngageBot engageBot = (EngageBot) other;
        return this.isActive == engageBot.isActive && Intrinsics.areEqual(this.engageMessage, engageBot.engageMessage) && Intrinsics.areEqual(this.successResponse, engageBot.successResponse) && Intrinsics.areEqual(this.invalidInputResponse, engageBot.invalidInputResponse) && Intrinsics.areEqual(this.sessionTimeoutResponse, engageBot.sessionTimeoutResponse) && this.sessionTimeoutMins == engageBot.sessionTimeoutMins;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.isActive) * 31) + this.engageMessage.hashCode()) * 31) + this.successResponse.hashCode()) * 31) + this.invalidInputResponse.hashCode()) * 31) + this.sessionTimeoutResponse.hashCode()) * 31) + Integer.hashCode(this.sessionTimeoutMins);
    }

    public String toString() {
        return "EngageBot(isActive=" + this.isActive + ", engageMessage=" + this.engageMessage + ", successResponse=" + this.successResponse + ", invalidInputResponse=" + this.invalidInputResponse + ", sessionTimeoutResponse=" + this.sessionTimeoutResponse + ", sessionTimeoutMins=" + this.sessionTimeoutMins + ")";
    }

    public EngageBot(boolean z, String engageMessage, String successResponse, String invalidInputResponse, String sessionTimeoutResponse, int i) {
        Intrinsics.checkNotNullParameter(engageMessage, "engageMessage");
        Intrinsics.checkNotNullParameter(successResponse, "successResponse");
        Intrinsics.checkNotNullParameter(invalidInputResponse, "invalidInputResponse");
        Intrinsics.checkNotNullParameter(sessionTimeoutResponse, "sessionTimeoutResponse");
        this.isActive = z;
        this.engageMessage = engageMessage;
        this.successResponse = successResponse;
        this.invalidInputResponse = invalidInputResponse;
        this.sessionTimeoutResponse = sessionTimeoutResponse;
        this.sessionTimeoutMins = i;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public /* synthetic */ EngageBot(boolean z, String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? EngageBotDefaults.ENGAGE_MESSAGE : str, (i2 & 4) != 0 ? EngageBotDefaults.SUCCESS_RESPONSE : str2, (i2 & 8) != 0 ? EngageBotDefaults.INVALID_INPUT_RESPONSE : str3, (i2 & 16) != 0 ? EngageBotDefaults.SESSION_TIMEOUT_RESPONSE : str4, (i2 & 32) != 0 ? 10 : i);
    }

    public final String getEngageMessage() {
        return this.engageMessage;
    }

    public final String getSuccessResponse() {
        return this.successResponse;
    }

    public final String getInvalidInputResponse() {
        return this.invalidInputResponse;
    }

    public final String getSessionTimeoutResponse() {
        return this.sessionTimeoutResponse;
    }

    public final int getSessionTimeoutMins() {
        return this.sessionTimeoutMins;
    }
}
