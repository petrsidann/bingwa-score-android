package com.example.bingwahybrid.domain.model;

import com.example.bingwahybrid.domain.enums.AutoReplyType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/example/bingwahybrid/domain/model/TransactionContext;", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "ussdCode", "", "stopPipeline", "", "stopReason", "shouldSendAutoReply", "autoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "<init>", "(Lcom/example/bingwahybrid/domain/model/Transaction;Ljava/lang/String;ZLjava/lang/String;ZLcom/example/bingwahybrid/domain/enums/AutoReplyType;)V", "getTransaction", "()Lcom/example/bingwahybrid/domain/model/Transaction;", "getUssdCode", "()Ljava/lang/String;", "getStopPipeline", "()Z", "getStopReason", "getShouldSendAutoReply", "getAutoReplyType", "()Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TransactionContext {
    public static final int $stable = 8;
    private final AutoReplyType autoReplyType;
    private final boolean shouldSendAutoReply;
    private final boolean stopPipeline;
    private final String stopReason;
    private final Transaction transaction;
    private final String ussdCode;

    public static /* synthetic */ TransactionContext copy$default(TransactionContext transactionContext, Transaction transaction, String str, boolean z, String str2, boolean z2, AutoReplyType autoReplyType, int i, Object obj) {
        if ((i & 1) != 0) {
            transaction = transactionContext.transaction;
        }
        if ((i & 2) != 0) {
            str = transactionContext.ussdCode;
        }
        if ((i & 4) != 0) {
            z = transactionContext.stopPipeline;
        }
        if ((i & 8) != 0) {
            str2 = transactionContext.stopReason;
        }
        if ((i & 16) != 0) {
            z2 = transactionContext.shouldSendAutoReply;
        }
        if ((i & 32) != 0) {
            autoReplyType = transactionContext.autoReplyType;
        }
        boolean z3 = z2;
        AutoReplyType autoReplyType2 = autoReplyType;
        return transactionContext.copy(transaction, str, z, str2, z3, autoReplyType2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Transaction getTransaction() {
        return this.transaction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUssdCode() {
        return this.ussdCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getStopPipeline() {
        return this.stopPipeline;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStopReason() {
        return this.stopReason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldSendAutoReply() {
        return this.shouldSendAutoReply;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AutoReplyType getAutoReplyType() {
        return this.autoReplyType;
    }

    public final TransactionContext copy(Transaction transaction, String ussdCode, boolean stopPipeline, String stopReason, boolean shouldSendAutoReply, AutoReplyType autoReplyType) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        return new TransactionContext(transaction, ussdCode, stopPipeline, stopReason, shouldSendAutoReply, autoReplyType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransactionContext)) {
            return false;
        }
        TransactionContext transactionContext = (TransactionContext) other;
        return Intrinsics.areEqual(this.transaction, transactionContext.transaction) && Intrinsics.areEqual(this.ussdCode, transactionContext.ussdCode) && this.stopPipeline == transactionContext.stopPipeline && Intrinsics.areEqual(this.stopReason, transactionContext.stopReason) && this.shouldSendAutoReply == transactionContext.shouldSendAutoReply && this.autoReplyType == transactionContext.autoReplyType;
    }

    public int hashCode() {
        int iHashCode = this.transaction.hashCode() * 31;
        String str = this.ussdCode;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.stopPipeline)) * 31;
        String str2 = this.stopReason;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.shouldSendAutoReply)) * 31;
        AutoReplyType autoReplyType = this.autoReplyType;
        return iHashCode3 + (autoReplyType != null ? autoReplyType.hashCode() : 0);
    }

    public String toString() {
        return "TransactionContext(transaction=" + this.transaction + ", ussdCode=" + this.ussdCode + ", stopPipeline=" + this.stopPipeline + ", stopReason=" + this.stopReason + ", shouldSendAutoReply=" + this.shouldSendAutoReply + ", autoReplyType=" + this.autoReplyType + ")";
    }

    public TransactionContext(Transaction transaction, String str, boolean z, String str2, boolean z2, AutoReplyType autoReplyType) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        this.transaction = transaction;
        this.ussdCode = str;
        this.stopPipeline = z;
        this.stopReason = str2;
        this.shouldSendAutoReply = z2;
        this.autoReplyType = autoReplyType;
    }

    public /* synthetic */ TransactionContext(Transaction transaction, String str, boolean z, String str2, boolean z2, AutoReplyType autoReplyType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transaction, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? null : autoReplyType);
    }

    public final Transaction getTransaction() {
        return this.transaction;
    }

    public final String getUssdCode() {
        return this.ussdCode;
    }

    public final boolean getStopPipeline() {
        return this.stopPipeline;
    }

    public final String getStopReason() {
        return this.stopReason;
    }

    public final boolean getShouldSendAutoReply() {
        return this.shouldSendAutoReply;
    }

    public final AutoReplyType getAutoReplyType() {
        return this.autoReplyType;
    }
}
