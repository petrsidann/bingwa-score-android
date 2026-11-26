package com.example.bingwahybrid.domain.model;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommissionRate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/CommissionRate;", "", "id", "Ljava/util/UUID;", "amount", "", "rate", "", "updatedAt", "", "<init>", "(Ljava/util/UUID;IDJ)V", "getId", "()Ljava/util/UUID;", "getAmount", "()I", "getRate", "()D", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommissionRate {
    public static final int $stable = 8;
    private final int amount;
    private final UUID id;
    private final double rate;
    private final long updatedAt;

    public static /* synthetic */ CommissionRate copy$default(CommissionRate commissionRate, UUID uuid, int i, double d, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uuid = commissionRate.id;
        }
        if ((i2 & 2) != 0) {
            i = commissionRate.amount;
        }
        if ((i2 & 4) != 0) {
            d = commissionRate.rate;
        }
        if ((i2 & 8) != 0) {
            j = commissionRate.updatedAt;
        }
        long j2 = j;
        return commissionRate.copy(uuid, i, d, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final CommissionRate copy(UUID id, int amount, double rate, long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new CommissionRate(id, amount, rate, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommissionRate)) {
            return false;
        }
        CommissionRate commissionRate = (CommissionRate) other;
        return Intrinsics.areEqual(this.id, commissionRate.id) && this.amount == commissionRate.amount && Double.compare(this.rate, commissionRate.rate) == 0 && this.updatedAt == commissionRate.updatedAt;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + Integer.hashCode(this.amount)) * 31) + Double.hashCode(this.rate)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "CommissionRate(id=" + this.id + ", amount=" + this.amount + ", rate=" + this.rate + ", updatedAt=" + this.updatedAt + ")";
    }

    public CommissionRate(UUID id, int i, double d, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.amount = i;
        this.rate = d;
        this.updatedAt = j;
    }

    public final UUID getId() {
        return this.id;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final double getRate() {
        return this.rate;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
