package com.example.bingwahybrid.domain.sms.messageextractor;

import com.example.bingwahybrid.domain.sitelink.model.SiteLinkMessage;
import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import io.ktor.sse.ServerSentEventKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SiteLinkMessageExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/messageextractor/SiteLinkMessageExtractor;", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "<init>", "()V", "extractDetails", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "message", "", "parseDateTime", "", "date", "time", "period", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SiteLinkMessageExtractor implements MessageExtractor {
    public static final int $stable = 0;

    @Inject
    public SiteLinkMessageExtractor() {
    }

    @Override // com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor
    public SmsMessage extractDetails(String message) throws Exception {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        List<String> groupValues3;
        String str3;
        String strReplace$default;
        long jCurrentTimeMillis;
        List<String> groupValues4;
        Intrinsics.checkNotNullParameter(message, "message");
        Regex regex = new Regex("BHSL\\s+([A-Z0-9]+)\\s+Confirmed");
        Regex regex2 = new Regex("from\\s+(\\d+)");
        Regex regex3 = new Regex("for\\s+(\\d+)");
        Regex regex4 = new Regex("Ksh([\\d,]+\\.\\d{2})");
        Regex regex5 = new Regex("on (\\d{2}/\\d{2}/\\d{2}) at (\\d{1,2}:\\d{2}) (AM|PM)");
        String str4 = message;
        MatchResult matchResultFind$default = Regex.find$default(regex, str4, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
            throw new Exception("Invalid M-Pesa Code");
        }
        MatchResult matchResultFind$default2 = Regex.find$default(regex2, str4, 0, 2, null);
        if (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) {
            throw new Exception("Invalid phone number");
        }
        String str5 = groupValues2.get(1);
        MatchResult matchResultFind$default3 = Regex.find$default(regex3, str4, 0, 2, null);
        if (matchResultFind$default3 == null || (groupValues4 = matchResultFind$default3.getGroupValues()) == null || (str2 = groupValues4.get(1)) == null) {
            str2 = str5;
        }
        MatchResult matchResultFind$default4 = Regex.find$default(regex4, str4, 0, 2, null);
        if (matchResultFind$default4 != null && (groupValues3 = matchResultFind$default4.getGroupValues()) != null && (str3 = groupValues3.get(1)) != null && (strReplace$default = StringsKt.replace$default(str3, ",", "", false, 4, (Object) null)) != null) {
            int i = (int) Double.parseDouble(strReplace$default);
            MatchResult matchResultFind$default5 = Regex.find$default(regex5, str4, 0, 2, null);
            if (matchResultFind$default5 != null) {
                MatchResult.Destructured destructured = matchResultFind$default5.getDestructured();
                jCurrentTimeMillis = parseDateTime(destructured.getMatch().getGroupValues().get(1), destructured.getMatch().getGroupValues().get(2), destructured.getMatch().getGroupValues().get(3));
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return new SiteLinkMessage(str, str2, str2, i, message, jCurrentTimeMillis);
        }
        throw new Exception("Invalid amount");
    }

    private final long parseDateTime(String date, String time, String period) {
        try {
            Date date2 = new SimpleDateFormat("dd/MM/yy hh:mm a", Locale.getDefault()).parse(date + ServerSentEventKt.SPACE + time + ServerSentEventKt.SPACE + period);
            return date2 != null ? date2.getTime() : System.currentTimeMillis();
        } catch (Exception unused) {
            return System.currentTimeMillis();
        }
    }
}
