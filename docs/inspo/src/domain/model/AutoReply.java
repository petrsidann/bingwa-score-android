package com.example.bingwahybrid.domain.model;

import com.example.bingwahybrid.domain.enums.AutoReplyType;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoReply.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018JL\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReply;", "", "id", "", LinkHeader.Parameters.Title, "", "message", "isActive", "", "type", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "amount", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;ZLcom/example/bingwahybrid/domain/enums/AutoReplyType;Ljava/lang/Integer;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getMessage", "()Z", "getType", "()Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/String;ZLcom/example/bingwahybrid/domain/enums/AutoReplyType;Ljava/lang/Integer;)Lcom/example/bingwahybrid/domain/model/AutoReply;", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AutoReply {
    public static final int $stable = 0;
    private final Integer amount;
    private final long id;
    private final boolean isActive;
    private final String message;
    private final String title;
    private final AutoReplyType type;

    public static /* synthetic */ AutoReply copy$default(AutoReply autoReply, long j, String str, String str2, boolean z, AutoReplyType autoReplyType, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            j = autoReply.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = autoReply.title;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = autoReply.message;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            z = autoReply.isActive;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            autoReplyType = autoReply.type;
        }
        AutoReplyType autoReplyType2 = autoReplyType;
        if ((i & 32) != 0) {
            num = autoReply.amount;
        }
        return autoReply.copy(j2, str3, str4, z2, autoReplyType2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AutoReplyType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getAmount() {
        return this.amount;
    }

    public final AutoReply copy(long id, String title, String message, boolean isActive, AutoReplyType type, Integer amount) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(type, "type");
        return new AutoReply(id, title, message, isActive, type, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoReply)) {
            return false;
        }
        AutoReply autoReply = (AutoReply) other;
        return this.id == autoReply.id && Intrinsics.areEqual(this.title, autoReply.title) && Intrinsics.areEqual(this.message, autoReply.message) && this.isActive == autoReply.isActive && this.type == autoReply.type && Intrinsics.areEqual(this.amount, autoReply.amount);
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.type.hashCode()) * 31;
        Integer num = this.amount;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "AutoReply(id=" + this.id + ", title=" + this.title + ", message=" + this.message + ", isActive=" + this.isActive + ", type=" + this.type + ", amount=" + this.amount + ")";
    }

    public AutoReply(long j, String title, String message, boolean z, AutoReplyType type, Integer num) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = j;
        this.title = title;
        this.message = message;
        this.isActive = z;
        this.type = type;
        this.amount = num;
    }

    public /* synthetic */ AutoReply(long j, String str, String str2, boolean z, AutoReplyType autoReplyType, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, (i & 8) != 0 ? false : z, autoReplyType, (i & 32) != 0 ? null : num);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final AutoReplyType getType() {
        return this.type;
    }

    public final Integer getAmount() {
        return this.amount;
    }
}
