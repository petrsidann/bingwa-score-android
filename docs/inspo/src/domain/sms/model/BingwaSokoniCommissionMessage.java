package com.example.bingwahybrid.domain.sms.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BingwaSokoniCommissionMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000e¨\u0006&"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/model/BingwaSokoniCommissionMessage;", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "mpesaCode", "", "senderName", "senderPhone", "amount", "", "message", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getMpesaCode", "()Ljava/lang/String;", "getSenderName", "getSenderPhone", "getAmount", "()I", "getMessage", "getTime", "()J", "customerNumber", "getCustomerNumber", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BingwaSokoniCommissionMessage implements SmsMessage {
    public static final int $stable = 0;
    private final int amount;
    private final String message;
    private final String mpesaCode;
    private final String senderName;
    private final String senderPhone;
    private final long time;
    private static final Regex CUSTOMER_PATTERN = new Regex("successfully recommended offer to (\\d+)\\.?");

    public static /* synthetic */ BingwaSokoniCommissionMessage copy$default(BingwaSokoniCommissionMessage bingwaSokoniCommissionMessage, String str, String str2, String str3, int i, String str4, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bingwaSokoniCommissionMessage.mpesaCode;
        }
        if ((i2 & 2) != 0) {
            str2 = bingwaSokoniCommissionMessage.senderName;
        }
        if ((i2 & 4) != 0) {
            str3 = bingwaSokoniCommissionMessage.senderPhone;
        }
        if ((i2 & 8) != 0) {
            i = bingwaSokoniCommissionMessage.amount;
        }
        if ((i2 & 16) != 0) {
            str4 = bingwaSokoniCommissionMessage.message;
        }
        if ((i2 & 32) != 0) {
            j = bingwaSokoniCommissionMessage.time;
        }
        long j2 = j;
        String str5 = str4;
        String str6 = str3;
        return bingwaSokoniCommissionMessage.copy(str, str2, str6, i, str5, j2);
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

    public final BingwaSokoniCommissionMessage copy(String mpesaCode, String senderName, String senderPhone, int amount, String message, long time) {
        Intrinsics.checkNotNullParameter(mpesaCode, "mpesaCode");
        Intrinsics.checkNotNullParameter(senderName, "senderName");
        Intrinsics.checkNotNullParameter(senderPhone, "senderPhone");
        Intrinsics.checkNotNullParameter(message, "message");
        return new BingwaSokoniCommissionMessage(mpesaCode, senderName, senderPhone, amount, message, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BingwaSokoniCommissionMessage)) {
            return false;
        }
        BingwaSokoniCommissionMessage bingwaSokoniCommissionMessage = (BingwaSokoniCommissionMessage) other;
        return Intrinsics.areEqual(this.mpesaCode, bingwaSokoniCommissionMessage.mpesaCode) && Intrinsics.areEqual(this.senderName, bingwaSokoniCommissionMessage.senderName) && Intrinsics.areEqual(this.senderPhone, bingwaSokoniCommissionMessage.senderPhone) && this.amount == bingwaSokoniCommissionMessage.amount && Intrinsics.areEqual(this.message, bingwaSokoniCommissionMessage.message) && this.time == bingwaSokoniCommissionMessage.time;
    }

    public int hashCode() {
        return (((((((((this.mpesaCode.hashCode() * 31) + this.senderName.hashCode()) * 31) + this.senderPhone.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "BingwaSokoniCommissionMessage(mpesaCode=" + this.mpesaCode + ", senderName=" + this.senderName + ", senderPhone=" + this.senderPhone + ", amount=" + this.amount + ", message=" + this.message + ", time=" + this.time + ")";
    }

    public BingwaSokoniCommissionMessage(String mpesaCode, String senderName, String senderPhone, int i, String message, long j) {
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

    public /* synthetic */ BingwaSokoniCommissionMessage(String str, String str2, String str3, int i, String str4, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? SmsSender.SAFARICOM : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, str4, (i2 & 32) != 0 ? System.currentTimeMillis() : j);
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

    public final String getCustomerNumber() {
        List<String> groupValues;
        String str;
        String strTakeLast;
        String string;
        MatchResult matchResultFind$default = Regex.find$default(CUSTOMER_PATTERN, getMessage(), 0, 2, null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null || (strTakeLast = StringsKt.takeLast(str, 9)) == null || (string = new StringBuilder("0").append(strTakeLast).toString()) == null) ? "" : string;
    }
}
