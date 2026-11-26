package com.example.bingwahybrid.domain.portal.events;

import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "New", "Deleted", "Rescheduled", "StatusChanged", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$Deleted;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$New;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$Rescheduled;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$StatusChanged;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TransactionEvent {
    public static final int $stable = 0;
    private final String eventName;

    public /* synthetic */ TransactionEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private TransactionEvent(String str) {
        this.eventName = str;
    }

    public final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: compiled from: TransactionEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$New;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "<init>", "(Lcom/example/bingwahybrid/domain/model/Transaction;)V", "getTransaction", "()Lcom/example/bingwahybrid/domain/model/Transaction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class New extends TransactionEvent {
        public static final int $stable = 8;
        private final Transaction transaction;

        public static /* synthetic */ New copy$default(New r0, Transaction transaction, int i, Object obj) {
            if ((i & 1) != 0) {
                transaction = r0.transaction;
            }
            return r0.copy(transaction);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Transaction getTransaction() {
            return this.transaction;
        }

        public final New copy(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            return new New(transaction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof New) && Intrinsics.areEqual(this.transaction, ((New) other).transaction);
        }

        public int hashCode() {
            return this.transaction.hashCode();
        }

        public String toString() {
            return "New(transaction=" + this.transaction + ")";
        }

        public final Transaction getTransaction() {
            return this.transaction;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public New(Transaction transaction) {
            super("transaction.received", null);
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            this.transaction = transaction;
        }
    }

    /* JADX INFO: compiled from: TransactionEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$Deleted;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "transactionId", "Ljava/util/UUID;", "<init>", "(Ljava/util/UUID;)V", "getTransactionId", "()Ljava/util/UUID;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Deleted extends TransactionEvent {
        public static final int $stable = 8;
        private final UUID transactionId;

        public static /* synthetic */ Deleted copy$default(Deleted deleted, UUID uuid, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = deleted.transactionId;
            }
            return deleted.copy(uuid);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UUID getTransactionId() {
            return this.transactionId;
        }

        public final Deleted copy(UUID transactionId) {
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            return new Deleted(transactionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Deleted) && Intrinsics.areEqual(this.transactionId, ((Deleted) other).transactionId);
        }

        public int hashCode() {
            return this.transactionId.hashCode();
        }

        public String toString() {
            return "Deleted(transactionId=" + this.transactionId + ")";
        }

        public final UUID getTransactionId() {
            return this.transactionId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Deleted(UUID transactionId) {
            super("transaction.deleted", null);
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            this.transactionId = transactionId;
        }
    }

    /* JADX INFO: compiled from: TransactionEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$Rescheduled;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "transactionId", "Ljava/util/UUID;", "newTime", "", "offerId", "<init>", "(Ljava/util/UUID;JLjava/util/UUID;)V", "getTransactionId", "()Ljava/util/UUID;", "getNewTime", "()J", "getOfferId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Rescheduled extends TransactionEvent {
        public static final int $stable = 8;
        private final long newTime;
        private final UUID offerId;
        private final UUID transactionId;

        public static /* synthetic */ Rescheduled copy$default(Rescheduled rescheduled, UUID uuid, long j, UUID uuid2, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = rescheduled.transactionId;
            }
            if ((i & 2) != 0) {
                j = rescheduled.newTime;
            }
            if ((i & 4) != 0) {
                uuid2 = rescheduled.offerId;
            }
            return rescheduled.copy(uuid, j, uuid2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UUID getTransactionId() {
            return this.transactionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getNewTime() {
            return this.newTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final UUID getOfferId() {
            return this.offerId;
        }

        public final Rescheduled copy(UUID transactionId, long newTime, UUID offerId) {
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            return new Rescheduled(transactionId, newTime, offerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rescheduled)) {
                return false;
            }
            Rescheduled rescheduled = (Rescheduled) other;
            return Intrinsics.areEqual(this.transactionId, rescheduled.transactionId) && this.newTime == rescheduled.newTime && Intrinsics.areEqual(this.offerId, rescheduled.offerId);
        }

        public int hashCode() {
            int iHashCode = ((this.transactionId.hashCode() * 31) + Long.hashCode(this.newTime)) * 31;
            UUID uuid = this.offerId;
            return iHashCode + (uuid == null ? 0 : uuid.hashCode());
        }

        public String toString() {
            return "Rescheduled(transactionId=" + this.transactionId + ", newTime=" + this.newTime + ", offerId=" + this.offerId + ")";
        }

        public final UUID getTransactionId() {
            return this.transactionId;
        }

        public final long getNewTime() {
            return this.newTime;
        }

        public final UUID getOfferId() {
            return this.offerId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rescheduled(UUID transactionId, long j, UUID uuid) {
            super("transaction.rescheduled", null);
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            this.transactionId = transactionId;
            this.newTime = j;
            this.offerId = uuid;
        }
    }

    /* JADX INFO: compiled from: TransactionEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent$StatusChanged;", "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "transactionId", "Ljava/util/UUID;", NotificationCompat.CATEGORY_STATUS, "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "message", "", "<init>", "(Ljava/util/UUID;Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Ljava/lang/String;)V", "getTransactionId", "()Ljava/util/UUID;", "getStatus", "()Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StatusChanged extends TransactionEvent {
        public static final int $stable = 8;
        private final String message;
        private final TransactionStatus status;
        private final UUID transactionId;

        public static /* synthetic */ StatusChanged copy$default(StatusChanged statusChanged, UUID uuid, TransactionStatus transactionStatus, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = statusChanged.transactionId;
            }
            if ((i & 2) != 0) {
                transactionStatus = statusChanged.status;
            }
            if ((i & 4) != 0) {
                str = statusChanged.message;
            }
            return statusChanged.copy(uuid, transactionStatus, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UUID getTransactionId() {
            return this.transactionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TransactionStatus getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final StatusChanged copy(UUID transactionId, TransactionStatus status, String message) {
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            Intrinsics.checkNotNullParameter(status, "status");
            return new StatusChanged(transactionId, status, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatusChanged)) {
                return false;
            }
            StatusChanged statusChanged = (StatusChanged) other;
            return Intrinsics.areEqual(this.transactionId, statusChanged.transactionId) && this.status == statusChanged.status && Intrinsics.areEqual(this.message, statusChanged.message);
        }

        public int hashCode() {
            int iHashCode = ((this.transactionId.hashCode() * 31) + this.status.hashCode()) * 31;
            String str = this.message;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "StatusChanged(transactionId=" + this.transactionId + ", status=" + this.status + ", message=" + this.message + ")";
        }

        public /* synthetic */ StatusChanged(UUID uuid, TransactionStatus transactionStatus, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(uuid, transactionStatus, (i & 4) != 0 ? null : str);
        }

        public final UUID getTransactionId() {
            return this.transactionId;
        }

        public final TransactionStatus getStatus() {
            return this.status;
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StatusChanged(UUID transactionId, TransactionStatus status, String str) {
            super("transaction.status.changed", null);
            Intrinsics.checkNotNullParameter(transactionId, "transactionId");
            Intrinsics.checkNotNullParameter(status, "status");
            this.transactionId = transactionId;
            this.status = status;
            this.message = str;
        }
    }
}
