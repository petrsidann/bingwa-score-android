package com.example.bingwahybrid.domain.engagebot.model;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EngageBotSession.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/model/EngageBotSession;", "", "customerId", "Ljava/util/UUID;", "transactionId", "isActive", "", "invalidAttemptCount", "", "lastInteractionTime", "", "<init>", "(Ljava/util/UUID;Ljava/util/UUID;ZIJ)V", "getCustomerId", "()Ljava/util/UUID;", "getTransactionId", "()Z", "getInvalidAttemptCount", "()I", "getLastInteractionTime", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EngageBotSession {
    public static final int $stable = 8;
    private final UUID customerId;
    private final int invalidAttemptCount;
    private final boolean isActive;
    private final long lastInteractionTime;
    private final UUID transactionId;

    public static /* synthetic */ EngageBotSession copy$default(EngageBotSession engageBotSession, UUID uuid, UUID uuid2, boolean z, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uuid = engageBotSession.customerId;
        }
        if ((i2 & 2) != 0) {
            uuid2 = engageBotSession.transactionId;
        }
        if ((i2 & 4) != 0) {
            z = engageBotSession.isActive;
        }
        if ((i2 & 8) != 0) {
            i = engageBotSession.invalidAttemptCount;
        }
        if ((i2 & 16) != 0) {
            j = engageBotSession.lastInteractionTime;
        }
        long j2 = j;
        return engageBotSession.copy(uuid, uuid2, z, i, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getCustomerId() {
        return this.customerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UUID getTransactionId() {
        return this.transactionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInvalidAttemptCount() {
        return this.invalidAttemptCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLastInteractionTime() {
        return this.lastInteractionTime;
    }

    public final EngageBotSession copy(UUID customerId, UUID transactionId, boolean isActive, int invalidAttemptCount, long lastInteractionTime) {
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        return new EngageBotSession(customerId, transactionId, isActive, invalidAttemptCount, lastInteractionTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EngageBotSession)) {
            return false;
        }
        EngageBotSession engageBotSession = (EngageBotSession) other;
        return Intrinsics.areEqual(this.customerId, engageBotSession.customerId) && Intrinsics.areEqual(this.transactionId, engageBotSession.transactionId) && this.isActive == engageBotSession.isActive && this.invalidAttemptCount == engageBotSession.invalidAttemptCount && this.lastInteractionTime == engageBotSession.lastInteractionTime;
    }

    public int hashCode() {
        return (((((((this.customerId.hashCode() * 31) + this.transactionId.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + Integer.hashCode(this.invalidAttemptCount)) * 31) + Long.hashCode(this.lastInteractionTime);
    }

    public String toString() {
        return "EngageBotSession(customerId=" + this.customerId + ", transactionId=" + this.transactionId + ", isActive=" + this.isActive + ", invalidAttemptCount=" + this.invalidAttemptCount + ", lastInteractionTime=" + this.lastInteractionTime + ")";
    }

    public EngageBotSession(UUID customerId, UUID transactionId, boolean z, int i, long j) {
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.isActive = z;
        this.invalidAttemptCount = i;
        this.lastInteractionTime = j;
    }

    public final UUID getCustomerId() {
        return this.customerId;
    }

    public final UUID getTransactionId() {
        return this.transactionId;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final int getInvalidAttemptCount() {
        return this.invalidAttemptCount;
    }

    public /* synthetic */ EngageBotSession(UUID uuid, UUID uuid2, boolean z, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, uuid2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getLastInteractionTime() {
        return this.lastInteractionTime;
    }
}
