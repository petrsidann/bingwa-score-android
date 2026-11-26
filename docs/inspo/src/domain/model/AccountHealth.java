package com.example.bingwahybrid.domain.model;

import com.example.bingwahybrid.domain.enums.AccountHealthStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountHealth.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/example/bingwahybrid/domain/model/AccountHealth;", "", "id", "", "healthStatus", "Lcom/example/bingwahybrid/domain/enums/AccountHealthStatus;", "serverTime", "", "localTime", "lastCheckedAt", "<init>", "(ILcom/example/bingwahybrid/domain/enums/AccountHealthStatus;JJJ)V", "getId", "()I", "getHealthStatus", "()Lcom/example/bingwahybrid/domain/enums/AccountHealthStatus;", "getServerTime", "()J", "getLocalTime", "getLastCheckedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AccountHealth {
    public static final int $stable = 0;
    private final AccountHealthStatus healthStatus;
    private final int id;
    private final long lastCheckedAt;
    private final long localTime;
    private final long serverTime;

    public static /* synthetic */ AccountHealth copy$default(AccountHealth accountHealth, int i, AccountHealthStatus accountHealthStatus, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = accountHealth.id;
        }
        if ((i2 & 2) != 0) {
            accountHealthStatus = accountHealth.healthStatus;
        }
        if ((i2 & 4) != 0) {
            j = accountHealth.serverTime;
        }
        if ((i2 & 8) != 0) {
            j2 = accountHealth.localTime;
        }
        if ((i2 & 16) != 0) {
            j3 = accountHealth.lastCheckedAt;
        }
        long j4 = j3;
        long j5 = j2;
        return accountHealth.copy(i, accountHealthStatus, j, j5, j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AccountHealthStatus getHealthStatus() {
        return this.healthStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getServerTime() {
        return this.serverTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLocalTime() {
        return this.localTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLastCheckedAt() {
        return this.lastCheckedAt;
    }

    public final AccountHealth copy(int id, AccountHealthStatus healthStatus, long serverTime, long localTime, long lastCheckedAt) {
        Intrinsics.checkNotNullParameter(healthStatus, "healthStatus");
        return new AccountHealth(id, healthStatus, serverTime, localTime, lastCheckedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountHealth)) {
            return false;
        }
        AccountHealth accountHealth = (AccountHealth) other;
        return this.id == accountHealth.id && this.healthStatus == accountHealth.healthStatus && this.serverTime == accountHealth.serverTime && this.localTime == accountHealth.localTime && this.lastCheckedAt == accountHealth.lastCheckedAt;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.healthStatus.hashCode()) * 31) + Long.hashCode(this.serverTime)) * 31) + Long.hashCode(this.localTime)) * 31) + Long.hashCode(this.lastCheckedAt);
    }

    public String toString() {
        return "AccountHealth(id=" + this.id + ", healthStatus=" + this.healthStatus + ", serverTime=" + this.serverTime + ", localTime=" + this.localTime + ", lastCheckedAt=" + this.lastCheckedAt + ")";
    }

    public AccountHealth(int i, AccountHealthStatus healthStatus, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(healthStatus, "healthStatus");
        this.id = i;
        this.healthStatus = healthStatus;
        this.serverTime = j;
        this.localTime = j2;
        this.lastCheckedAt = j3;
    }

    public /* synthetic */ AccountHealth(int i, AccountHealthStatus accountHealthStatus, long j, long j2, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, accountHealthStatus, j, j2, j3);
    }

    public final int getId() {
        return this.id;
    }

    public final AccountHealthStatus getHealthStatus() {
        return this.healthStatus;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getLocalTime() {
        return this.localTime;
    }

    public final long getLastCheckedAt() {
        return this.lastCheckedAt;
    }
}
