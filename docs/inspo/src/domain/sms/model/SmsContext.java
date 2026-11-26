package com.example.bingwahybrid.domain.sms.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/model/SmsContext;", "", "message", "", "sender", "simSlot", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "getSender", "getSimSlot", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SmsContext {
    public static final int $stable = 0;
    private final String message;
    private final String sender;
    private final int simSlot;

    public static /* synthetic */ SmsContext copy$default(SmsContext smsContext, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smsContext.message;
        }
        if ((i2 & 2) != 0) {
            str2 = smsContext.sender;
        }
        if ((i2 & 4) != 0) {
            i = smsContext.simSlot;
        }
        return smsContext.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSimSlot() {
        return this.simSlot;
    }

    public final SmsContext copy(String message, String sender, int simSlot) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sender, "sender");
        return new SmsContext(message, sender, simSlot);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmsContext)) {
            return false;
        }
        SmsContext smsContext = (SmsContext) other;
        return Intrinsics.areEqual(this.message, smsContext.message) && Intrinsics.areEqual(this.sender, smsContext.sender) && this.simSlot == smsContext.simSlot;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.sender.hashCode()) * 31) + Integer.hashCode(this.simSlot);
    }

    public String toString() {
        return "SmsContext(message=" + this.message + ", sender=" + this.sender + ", simSlot=" + this.simSlot + ")";
    }

    public SmsContext(String message, String sender, int i) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.message = message;
        this.sender = sender;
        this.simSlot = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSender() {
        return this.sender;
    }

    public final int getSimSlot() {
        return this.simSlot;
    }
}
