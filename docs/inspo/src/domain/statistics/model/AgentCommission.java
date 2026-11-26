package com.example.bingwahybrid.domain.statistics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgentCommission.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;", "", "date", "", "amount", "", "<init>", "(Ljava/lang/String;D)V", "getDate", "()Ljava/lang/String;", "getAmount", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AgentCommission {
    public static final int $stable = 0;
    private final double amount;
    private final String date;

    public static /* synthetic */ AgentCommission copy$default(AgentCommission agentCommission, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentCommission.date;
        }
        if ((i & 2) != 0) {
            d = agentCommission.amount;
        }
        return agentCommission.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    public final AgentCommission copy(String date, double amount) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new AgentCommission(date, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCommission)) {
            return false;
        }
        AgentCommission agentCommission = (AgentCommission) other;
        return Intrinsics.areEqual(this.date, agentCommission.date) && Double.compare(this.amount, agentCommission.amount) == 0;
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + Double.hashCode(this.amount);
    }

    public String toString() {
        return "AgentCommission(date=" + this.date + ", amount=" + this.amount + ")";
    }

    public AgentCommission(String date, double d) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
        this.amount = d;
    }

    public final String getDate() {
        return this.date;
    }

    public final double getAmount() {
        return this.amount;
    }
}
