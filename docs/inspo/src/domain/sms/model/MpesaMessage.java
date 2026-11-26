package com.example.bingwahybrid.domain.sms.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MpesaMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/model/MpesaMessage;", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "mpesaCode", "", "senderName", "senderPhone", "amount", "", "message", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getMpesaCode", "()Ljava/lang/String;", "getSenderName", "getSenderPhone", "getAmount", "()I", "getMessage", "getTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MpesaMessage implements SmsMessage {
    public static final int $stable = 0;
    private final int amount;
    private final String message;
    private final String mpesaCode;
    private final String senderName;
    private final String senderPhone;
    private final long time;

    public static /* synthetic */ MpesaMessage copy$default(MpesaMessage mpesaMessage, String str, String str2, String str3, int i, String str4, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mpesaMessage.mpesaCode;
        }
        if ((i2 & 2) != 0) {
            str2 = mpesaMessage.senderName;
        }
        if ((i2 & 4) != 0) {
            str3 = mpesaMessage.senderPhone;
        }
        if ((i2 & 8) != 0) {
            i = mpesaMessage.amount;
        }
        if ((i2 & 16) != 0) {
            str4 = mpesaMessage.message;
        }
        if ((i2 & 32) != 0) {
            j = mpesaMessage.time;
        }
        long j2 = j;
        String str5 = str4;
        String str6 = str3;
        return mpesaMessage.copy(str, str2, str6, i, str5, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMpesaCode() {
        return this.mpesaCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSenderName() {
        return this.senderName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSenderPhone() {
        return this.senderPhone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final MpesaMessage copy(String mpesaCode, String senderName, String senderPhone, int amount, String message, long time) {
        Intrinsics.checkNotNullParameter(mpesaCode, "mpesaCode");
        Intrinsics.checkNotNullParameter(senderName, "senderName");
        Intrinsics.checkNotNullParameter(senderPhone, "senderPhone");
        Intrinsics.checkNotNullParameter(message, "message");
        return new MpesaMessage(mpesaCode, senderName, senderPhone, amount, message, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MpesaMessage)) {
            return false;
        }
        MpesaMessage mpesaMessage = (MpesaMessage) other;
        return Intrinsics.areEqual(this.mpesaCode, mpesaMessage.mpesaCode) && Intrinsics.areEqual(this.senderName, mpesaMessage.senderName) && Intrinsics.areEqual(this.senderPhone, mpesaMessage.senderPhone) && this.amount == mpesaMessage.amount && Intrinsics.areEqual(this.message, mpesaMessage.message) && this.time == mpesaMessage.time;
    }

    public int hashCode() {
        return (((((((((this.mpesaCode.hashCode() * 31) + this.senderName.hashCode()) * 31) + this.senderPhone.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "MpesaMessage(mpesaCode=" + this.mpesaCode + ", senderName=" + this.senderName + ", senderPhone=" + this.senderPhone + ", amount=" + this.amount + ", message=" + this.message + ", time=" + this.time + ")";
    }

    public MpesaMessage(String mpesaCode, String senderName, String senderPhone, int i, String message, long j) {
        Intrinsics.checkNotNullParameter(mpesaCode, "mpesaCode");
        Intrinsics.checkNotNullParameter(senderName, "senderName");
        Intrinsics.checkNotNullParameter(senderPhone, "senderPhone");
        Intrinsics.checkNotNullParameter(message, "message");
        this.mpesaCode = mpesaCode;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.amount = i;
        this.message = message;
        this.time = j;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public String getMpesaCode() {
        return this.mpesaCode;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public String getSenderName() {
        return this.senderName;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public String getSenderPhone() {
        return this.senderPhone;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public int getAmount() {
        return this.amount;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public String getMessage() {
        return this.message;
    }

    @Override // com.example.bingwahybrid.domain.sms.model.SmsMessage
    public long getTime() {
        return this.time;
    }
}
