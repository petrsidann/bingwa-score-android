package com.example.bingwahybrid.domain.sms.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawSmsMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/model/RawSmsMessage;", "", "message", "", "sender", "simSlot", "", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "getMessage", "()Ljava/lang/String;", "getSender", "getSimSlot", "()I", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RawSmsMessage {
    public static final int $stable = 0;
    private final String message;
    private final String sender;
    private final int simSlot;
    private final long timestamp;

    public static /* synthetic */ RawSmsMessage copy$default(RawSmsMessage rawSmsMessage, String str, String str2, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rawSmsMessage.message;
        }
        if ((i2 & 2) != 0) {
            str2 = rawSmsMessage.sender;
        }
        if ((i2 & 4) != 0) {
            i = rawSmsMessage.simSlot;
        }
        if ((i2 & 8) != 0) {
            j = rawSmsMessage.timestamp;
        }
        int i3 = i;
        return rawSmsMessage.copy(str, str2, i3, j);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final RawSmsMessage copy(String message, String sender, int simSlot, long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sender, "sender");
        return new RawSmsMessage(message, sender, simSlot, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RawSmsMessage)) {
            return false;
        }
        RawSmsMessage rawSmsMessage = (RawSmsMessage) other;
        return Intrinsics.areEqual(this.message, rawSmsMessage.message) && Intrinsics.areEqual(this.sender, rawSmsMessage.sender) && this.simSlot == rawSmsMessage.simSlot && this.timestamp == rawSmsMessage.timestamp;
    }

    public int hashCode() {
        return (((((this.message.hashCode() * 31) + this.sender.hashCode()) * 31) + Integer.hashCode(this.simSlot)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "RawSmsMessage(message=" + this.message + ", sender=" + this.sender + ", simSlot=" + this.simSlot + ", timestamp=" + this.timestamp + ")";
    }

    public RawSmsMessage(String message, String sender, int i, long j) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.message = message;
        this.sender = sender;
        this.simSlot = i;
        this.timestamp = j;
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

    public final long getTimestamp() {
        return this.timestamp;
    }
}
