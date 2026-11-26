package com.example.bingwahybrid.domain.enums;

import com.example.bingwahybrid.domain.sms.model.SmsSender;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'RECOMMENDATION_EXPIRED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SmsType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0019"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/SmsType;", "", "pattern", "", "settingKey", "Lcom/example/bingwahybrid/domain/enums/AppSetting;", "errorMessage", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/example/bingwahybrid/domain/enums/AppSetting;Ljava/lang/String;)V", "getPattern", "()Ljava/lang/String;", "getSettingKey", "()Lcom/example/bingwahybrid/domain/enums/AppSetting;", "getErrorMessage", "SITE_LINK", "PAY_BILL", SmsSender.MPESA, "TILL", "RECOMMENDATION_TIMEOUT", "RECOMMENDATION_EXPIRED", "AIRTIME_BALANCE", "BINGWA_SOKONI_COMMISSION", "matches", "", "message", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmsType[] $VALUES;
    public static final SmsType AIRTIME_BALANCE;
    public static final SmsType BINGWA_SOKONI_COMMISSION;
    public static final SmsType RECOMMENDATION_EXPIRED;
    private final String errorMessage;
    private final String pattern;
    private final AppSetting settingKey;
    public static final SmsType SITE_LINK = new SmsType("SITE_LINK", 0, "^BHSL", AppSetting.PROCESS_SITE_LINK_MESSAGES, "Not allowed to process SiteLink messages");
    public static final SmsType PAY_BILL = new SmsType("PAY_BILL", 1, "Account Number \\d{9,12}", AppSetting.PROCESS_PAY_BILL_MESSAGES, "Not allowed to process Pay Bill messages");
    public static final SmsType MPESA = new SmsType(SmsSender.MPESA, 2, "received Ksh\\d+(\\.\\d{2})?", AppSetting.PROCESS_MPESA_MESSAGES, "Not allowed to process M-Pesa messages");
    public static final SmsType TILL = new SmsType("TILL", 3, "received from \\d{9,12}", AppSetting.PROCESS_TILL_MESSAGES, "Not allowed to process Till messages");
    public static final SmsType RECOMMENDATION_TIMEOUT = new SmsType("RECOMMENDATION_TIMEOUT", 4, "Recommendation for (\\d{9,12}) timed out", null, null, 6, null);

    private static final /* synthetic */ SmsType[] $values() {
        return new SmsType[]{SITE_LINK, PAY_BILL, MPESA, TILL, RECOMMENDATION_TIMEOUT, RECOMMENDATION_EXPIRED, AIRTIME_BALANCE, BINGWA_SOKONI_COMMISSION};
    }

    public static EnumEntries<SmsType> getEntries() {
        return $ENTRIES;
    }

    public static SmsType valueOf(String str) {
        return (SmsType) Enum.valueOf(SmsType.class, str);
    }

    public static SmsType[] values() {
        return (SmsType[]) $VALUES.clone();
    }

    private SmsType(String str, int i, String str2, AppSetting appSetting, String str3) {
        super(str, i);
        this.pattern = str2;
        this.settingKey = appSetting;
        this.errorMessage = str3;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final AppSetting getSettingKey() {
        return this.settingKey;
    }

    /* synthetic */ SmsType(String str, int i, String str2, AppSetting appSetting, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? null : appSetting, (i2 & 4) != 0 ? "Not allowed to process messages" : str3);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object[] objArr = 0 == true ? 1 : 0;
        RECOMMENDATION_EXPIRED = new SmsType("RECOMMENDATION_EXPIRED", 5, "Recommendation for (\\d{9,12}) expired", objArr, null, 6, null);
        AIRTIME_BALANCE = new SmsType("AIRTIME_BALANCE", 6, "Airtime Bal: ", 0 == true ? 1 : 0, null, 6, null);
        BINGWA_SOKONI_COMMISSION = new SmsType("BINGWA_SOKONI_COMMISSION", 7, "You have successfully recommended offer to \\d+\\.?", 0 == true ? 1 : 0, null, 6, null);
        SmsType[] smsTypeArr$values = $values();
        $VALUES = smsTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(smsTypeArr$values);
    }

    public final boolean matches(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new Regex(this.pattern, RegexOption.IGNORE_CASE).containsMatchIn(message);
    }
}
