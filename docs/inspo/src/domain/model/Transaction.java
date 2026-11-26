package com.example.bingwahybrid.domain.model;

import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.RescheduleMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Transaction.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001[B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010A\u001a\u00020BJ\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\t\u0010J\u001a\u00020\u000fHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010M\u001a\u00020\u0014HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\tHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010:JÄ\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020W2\b\u0010@\u001a\u0004\u0018\u00010XHÖ\u0003J\t\u0010Y\u001a\u00020\u0007HÖ\u0001J\t\u0010Z\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u00105R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u00105R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010;\u001a\u0004\b>\u0010:¨\u0006\\"}, d2 = {"Lcom/example/bingwahybrid/domain/model/Transaction;", "", "id", "Ljava/util/UUID;", "mpesaCode", "", "amount", "", "time", "", "mpesaMessage", "responseMessage", NotificationCompat.CATEGORY_STATUS, "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "recommendedSimForDialing", "type", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "internalRetries", "externalRetries", "createdAt", "deletedAt", "rescheduleInfo", "Lcom/example/bingwahybrid/domain/model/RescheduleInfo;", "lastSynced", "<init>", "(Ljava/util/UUID;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Lcom/example/bingwahybrid/domain/model/Customer;Lcom/example/bingwahybrid/domain/offers/model/Offer;Ljava/lang/Integer;Lcom/example/bingwahybrid/domain/enums/TransactionType;IIJLjava/lang/Long;Lcom/example/bingwahybrid/domain/model/RescheduleInfo;Ljava/lang/Long;)V", "getId", "()Ljava/util/UUID;", "getMpesaCode", "()Ljava/lang/String;", "getAmount", "()I", "getTime", "()J", "getMpesaMessage", "getResponseMessage", "getStatus", "()Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "getCustomer", "()Lcom/example/bingwahybrid/domain/model/Customer;", "getOffer", "()Lcom/example/bingwahybrid/domain/offers/model/Offer;", "getRecommendedSimForDialing", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Lcom/example/bingwahybrid/domain/enums/TransactionType;", "getInternalRetries", "setInternalRetries", "(I)V", "getExternalRetries", "setExternalRetries", "getCreatedAt", "getDeletedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRescheduleInfo", "()Lcom/example/bingwahybrid/domain/model/RescheduleInfo;", "getLastSynced", "compareTo", "other", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/util/UUID;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Lcom/example/bingwahybrid/domain/model/Customer;Lcom/example/bingwahybrid/domain/offers/model/Offer;Ljava/lang/Integer;Lcom/example/bingwahybrid/domain/enums/TransactionType;IIJLjava/lang/Long;Lcom/example/bingwahybrid/domain/model/RescheduleInfo;Ljava/lang/Long;)Lcom/example/bingwahybrid/domain/model/Transaction;", "equals", "", "", "hashCode", "toString", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Transaction implements Comparable<Transaction> {
    private final int amount;
    private final long createdAt;
    private final Customer customer;
    private final Long deletedAt;
    private int externalRetries;
    private final UUID id;
    private int internalRetries;
    private final Long lastSynced;
    private final String mpesaCode;
    private final String mpesaMessage;
    private final Offer offer;
    private final Integer recommendedSimForDialing;
    private final RescheduleInfo rescheduleInfo;
    private final String responseMessage;
    private final TransactionStatus status;
    private final long time;
    private final TransactionType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ Transaction copy$default(Transaction transaction, UUID uuid, String str, int i, long j, String str2, String str3, TransactionStatus transactionStatus, Customer customer, Offer offer, Integer num, TransactionType transactionType, int i2, int i3, long j2, Long l, RescheduleInfo rescheduleInfo, Long l2, int i4, Object obj) {
        UUID uuid2 = (i4 & 1) != 0 ? transaction.id : uuid;
        String str4 = (i4 & 2) != 0 ? transaction.mpesaCode : str;
        return transaction.copy(uuid2, str4, (i4 & 4) != 0 ? transaction.amount : i, (i4 & 8) != 0 ? transaction.time : j, (i4 & 16) != 0 ? transaction.mpesaMessage : str2, (i4 & 32) != 0 ? transaction.responseMessage : str3, (i4 & 64) != 0 ? transaction.status : transactionStatus, (i4 & 128) != 0 ? transaction.customer : customer, (i4 & 256) != 0 ? transaction.offer : offer, (i4 & 512) != 0 ? transaction.recommendedSimForDialing : num, (i4 & 1024) != 0 ? transaction.type : transactionType, (i4 & 2048) != 0 ? transaction.internalRetries : i2, (i4 & 4096) != 0 ? transaction.externalRetries : i3, (i4 & 8192) != 0 ? transaction.createdAt : j2, (i4 & 16384) != 0 ? transaction.deletedAt : l, (32768 & i4) != 0 ? transaction.rescheduleInfo : rescheduleInfo, (i4 & 65536) != 0 ? transaction.lastSynced : l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getRecommendedSimForDialing() {
        return this.recommendedSimForDialing;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final TransactionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getInternalRetries() {
        return this.internalRetries;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getExternalRetries() {
        return this.externalRetries;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Long getDeletedAt() {
        return this.deletedAt;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final RescheduleInfo getRescheduleInfo() {
        return this.rescheduleInfo;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Long getLastSynced() {
        return this.lastSynced;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMpesaCode() {
        return this.mpesaCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMpesaMessage() {
        return this.mpesaMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getResponseMessage() {
        return this.responseMessage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TransactionStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Customer getCustomer() {
        return this.customer;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Offer getOffer() {
        return this.offer;
    }

    public final Transaction copy(UUID id, String mpesaCode, int amount, long time, String mpesaMessage, String responseMessage, TransactionStatus status, Customer customer, Offer offer, Integer recommendedSimForDialing, TransactionType type, int internalRetries, int externalRetries, long createdAt, Long deletedAt, RescheduleInfo rescheduleInfo, Long lastSynced) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mpesaMessage, "mpesaMessage");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Transaction(id, mpesaCode, amount, time, mpesaMessage, responseMessage, status, customer, offer, recommendedSimForDialing, type, internalRetries, externalRetries, createdAt, deletedAt, rescheduleInfo, lastSynced);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) other;
        return Intrinsics.areEqual(this.id, transaction.id) && Intrinsics.areEqual(this.mpesaCode, transaction.mpesaCode) && this.amount == transaction.amount && this.time == transaction.time && Intrinsics.areEqual(this.mpesaMessage, transaction.mpesaMessage) && Intrinsics.areEqual(this.responseMessage, transaction.responseMessage) && this.status == transaction.status && Intrinsics.areEqual(this.customer, transaction.customer) && Intrinsics.areEqual(this.offer, transaction.offer) && Intrinsics.areEqual(this.recommendedSimForDialing, transaction.recommendedSimForDialing) && this.type == transaction.type && this.internalRetries == transaction.internalRetries && this.externalRetries == transaction.externalRetries && this.createdAt == transaction.createdAt && Intrinsics.areEqual(this.deletedAt, transaction.deletedAt) && Intrinsics.areEqual(this.rescheduleInfo, transaction.rescheduleInfo) && Intrinsics.areEqual(this.lastSynced, transaction.lastSynced);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.mpesaCode;
        int iHashCode2 = (((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.amount)) * 31) + Long.hashCode(this.time)) * 31) + this.mpesaMessage.hashCode()) * 31) + this.responseMessage.hashCode()) * 31) + this.status.hashCode()) * 31) + this.customer.hashCode()) * 31;
        Offer offer = this.offer;
        int iHashCode3 = (iHashCode2 + (offer == null ? 0 : offer.hashCode())) * 31;
        Integer num = this.recommendedSimForDialing;
        int iHashCode4 = (((((((((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.internalRetries)) * 31) + Integer.hashCode(this.externalRetries)) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l = this.deletedAt;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        RescheduleInfo rescheduleInfo = this.rescheduleInfo;
        int iHashCode6 = (iHashCode5 + (rescheduleInfo == null ? 0 : rescheduleInfo.hashCode())) * 31;
        Long l2 = this.lastSynced;
        return iHashCode6 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "Transaction(id=" + this.id + ", mpesaCode=" + this.mpesaCode + ", amount=" + this.amount + ", time=" + this.time + ", mpesaMessage=" + this.mpesaMessage + ", responseMessage=" + this.responseMessage + ", status=" + this.status + ", customer=" + this.customer + ", offer=" + this.offer + ", recommendedSimForDialing=" + this.recommendedSimForDialing + ", type=" + this.type + ", internalRetries=" + this.internalRetries + ", externalRetries=" + this.externalRetries + ", createdAt=" + this.createdAt + ", deletedAt=" + this.deletedAt + ", rescheduleInfo=" + this.rescheduleInfo + ", lastSynced=" + this.lastSynced + ")";
    }

    public Transaction(UUID id, String str, int i, long j, String mpesaMessage, String responseMessage, TransactionStatus status, Customer customer, Offer offer, Integer num, TransactionType type, int i2, int i3, long j2, Long l, RescheduleInfo rescheduleInfo, Long l2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mpesaMessage, "mpesaMessage");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.mpesaCode = str;
        this.amount = i;
        this.time = j;
        this.mpesaMessage = mpesaMessage;
        this.responseMessage = responseMessage;
        this.status = status;
        this.customer = customer;
        this.offer = offer;
        this.recommendedSimForDialing = num;
        this.type = type;
        this.internalRetries = i2;
        this.externalRetries = i3;
        this.createdAt = j2;
        this.deletedAt = l;
        this.rescheduleInfo = rescheduleInfo;
        this.lastSynced = l2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Transaction(UUID uuid, String str, int i, long j, String str2, String str3, TransactionStatus transactionStatus, Customer customer, Offer offer, Integer num, TransactionType transactionType, int i2, int i3, long j2, Long l, RescheduleInfo rescheduleInfo, Long l2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        UUID uuid2;
        if ((i4 & 1) != 0) {
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            uuid2 = uuidRandomUUID;
        } else {
            uuid2 = uuid;
        }
        this(uuid2, (i4 & 2) != 0 ? null : str, i, (i4 & 8) != 0 ? System.currentTimeMillis() : j, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? TransactionStatus.SCHEDULED : transactionStatus, customer, offer, (i4 & 512) != 0 ? null : num, (i4 & 1024) != 0 ? TransactionType.TILL : transactionType, (i4 & 2048) != 0 ? 0 : i2, (i4 & 4096) != 0 ? 0 : i3, (i4 & 8192) != 0 ? System.currentTimeMillis() : j2, (i4 & 16384) != 0 ? null : l, (32768 & i4) != 0 ? null : rescheduleInfo, (i4 & 65536) != 0 ? null : l2);
    }

    public final UUID getId() {
        return this.id;
    }

    public final String getMpesaCode() {
        return this.mpesaCode;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getMpesaMessage() {
        return this.mpesaMessage;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final TransactionStatus getStatus() {
        return this.status;
    }

    public final Customer getCustomer() {
        return this.customer;
    }

    public final Offer getOffer() {
        return this.offer;
    }

    public final Integer getRecommendedSimForDialing() {
        return this.recommendedSimForDialing;
    }

    public final TransactionType getType() {
        return this.type;
    }

    public final int getInternalRetries() {
        return this.internalRetries;
    }

    public final void setInternalRetries(int i) {
        this.internalRetries = i;
    }

    public final int getExternalRetries() {
        return this.externalRetries;
    }

    public final void setExternalRetries(int i) {
        this.externalRetries = i;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getDeletedAt() {
        return this.deletedAt;
    }

    public final RescheduleInfo getRescheduleInfo() {
        return this.rescheduleInfo;
    }

    public final Long getLastSynced() {
        return this.lastSynced;
    }

    @Override // java.lang.Comparable
    public int compareTo(Transaction other) {
        Intrinsics.checkNotNullParameter(other, "other");
        List listListOf = CollectionsKt.listOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.QUICK_DIAL, TransactionType.AIRTIME_BALANCE_CHECK});
        Integer numValueOf = Integer.valueOf(listListOf.indexOf(this.type));
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : Integer.MAX_VALUE;
        Integer numValueOf2 = Integer.valueOf(listListOf.indexOf(other.type));
        Integer num = numValueOf2.intValue() >= 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : Integer.MAX_VALUE;
        if (iIntValue != iIntValue2) {
            return Intrinsics.compare(iIntValue, iIntValue2);
        }
        return Intrinsics.compare(this.createdAt, other.createdAt);
    }

    /* JADX INFO: compiled from: Transaction.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006J\n\u0010\b\u001a\u00020\u0005*\u00020\u0006J\n\u0010\t\u001a\u00020\u0005*\u00020\u0006J\n\u0010\n\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u000b\u001a\u00020\u0005*\u00020\u0006J\n\u0010\f\u001a\u00020\u0005*\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/model/Transaction$Companion;", "", "<init>", "()V", "isSubscriptionRenewal", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "isScheduled", "isProcessing", "isRescheduled", "isAutoRenewalTransaction", "isAutoRenewalParentTransaction", "isBalanceCheck", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSubscriptionRenewal(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            return transaction.getType() == TransactionType.SUBSCRIPTION_RENEWAL;
        }

        public final boolean isScheduled(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            return transaction.getStatus() == TransactionStatus.SCHEDULED;
        }

        public final boolean isProcessing(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            return transaction.getStatus() == TransactionStatus.PROCESSING;
        }

        public final boolean isRescheduled(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            if (transaction.getStatus() != TransactionStatus.RESCHEDULED) {
                return false;
            }
            RescheduleInfo rescheduleInfo = transaction.getRescheduleInfo();
            return (rescheduleInfo != null ? rescheduleInfo.getRescheduleMode() : null) == RescheduleMode.ONCE;
        }

        public final boolean isAutoRenewalTransaction(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            if (transaction.getStatus() != TransactionStatus.SCHEDULED) {
                return false;
            }
            RescheduleInfo rescheduleInfo = transaction.getRescheduleInfo();
            return (rescheduleInfo != null ? rescheduleInfo.getRescheduleMode() : null) == RescheduleMode.AUTO_RENEW;
        }

        public final boolean isAutoRenewalParentTransaction(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            return transaction.getStatus() == TransactionStatus.RESCHEDULED && transaction.getRescheduleInfo() == null;
        }

        public final boolean isBalanceCheck(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "<this>");
            return transaction.getType() == TransactionType.AIRTIME_BALANCE_CHECK;
        }
    }

    public final JSONObject toJson() throws JSONException {
        Object string;
        Object json;
        UUID id;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id.toString());
        jSONObject.put("mpesaMessage", this.mpesaMessage);
        Object obj = this.mpesaCode;
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put("mpesaCode", obj);
        jSONObject.put("amount", this.amount);
        jSONObject.put("time", this.time);
        jSONObject.put("type", this.type.name());
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.status.name());
        jSONObject.put("responseMessage", this.responseMessage);
        jSONObject.put("customer", this.customer.toJson());
        Offer offer = this.offer;
        if (offer == null || (id = offer.getId()) == null || (string = id.toString()) == null) {
            string = JSONObject.NULL;
        }
        jSONObject.put("offerId", string);
        jSONObject.put("createdAt", this.createdAt);
        Object obj2 = this.deletedAt;
        if (obj2 == null) {
            obj2 = JSONObject.NULL;
        }
        jSONObject.put("deletedAt", obj2);
        RescheduleInfo rescheduleInfo = this.rescheduleInfo;
        if (rescheduleInfo == null || (json = rescheduleInfo.toJson()) == null) {
            json = JSONObject.NULL;
        }
        jSONObject.put("rescheduleInfo", json);
        return jSONObject;
    }
}
