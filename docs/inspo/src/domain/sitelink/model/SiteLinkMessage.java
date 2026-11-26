package com.example.bingwahybrid.domain.sitelink.model;

import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteLinkMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/model/SiteLinkMessage;", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "mpesaCode", "", "senderName", "senderPhone", "amount", "", "message", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getMpesaCode", "()Ljava/lang/String;", "getSenderName", "getSenderPhone", "getAmount", "()I", "getMessage", "getTime", "()J", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SiteLinkMessage implements SmsMessage {
    public static final int $stable = 0;
    private final int amount;
    private final String message;
    private final String mpesaCode;
    private final String senderName;
    private final String senderPhone;
    private final long time;

    public SiteLinkMessage(String mpesaCode, String senderName, String senderPhone, int i, String message, long j) {
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
