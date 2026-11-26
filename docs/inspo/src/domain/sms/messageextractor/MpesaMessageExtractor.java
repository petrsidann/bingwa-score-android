package com.example.bingwahybrid.domain.sms.messageextractor;

import android.util.Log;
import com.example.bingwahybrid.domain.sms.model.MpesaMessage;
import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MpesaMessageExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/messageextractor/MpesaMessageExtractor;", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "<init>", "()V", "extractDetails", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "message", "", "extractMpesaCode", "extractSenderName", "extractPhoneNumber", "extractAmount", "", "extractTime", "", "extractWithRegex", "pattern", "group", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MpesaMessageExtractor implements MessageExtractor {
    public static final int $stable = 0;

    @Inject
    public MpesaMessageExtractor() {
    }

    @Override // com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor
    public SmsMessage extractDetails(String message) throws Exception {
        Intrinsics.checkNotNullParameter(message, "message");
        String strExtractMpesaCode = extractMpesaCode(message);
        String strExtractSenderName = extractSenderName(message);
        String strExtractPhoneNumber = extractPhoneNumber(message);
        int iExtractAmount = extractAmount(message);
        long jExtractTime = extractTime(message);
        Log.d("DefaultMessageExtractor", "Extracted details: " + strExtractSenderName + ", " + strExtractPhoneNumber + ", " + iExtractAmount + ", " + jExtractTime);
        return new MpesaMessage(strExtractMpesaCode, strExtractSenderName, strExtractPhoneNumber, iExtractAmount, message, jExtractTime);
    }

    private final String extractMpesaCode(String message) throws Exception {
        String strExtractWithRegex = extractWithRegex(message, "^(\\S+)", 1);
        if (strExtractWithRegex != null) {
            return strExtractWithRegex;
        }
        throw new Exception("Invalid M-Pesa Code");
    }

    private final String extractSenderName(String message) {
        String strExtractWithRegex = extractWithRegex(message, "from (.+?) (\\d{10})", 1);
        return strExtractWithRegex == null ? "Unknown" : strExtractWithRegex;
    }

    private final String extractPhoneNumber(String message) {
        String strExtractWithRegex = extractWithRegex(message, "(\\d{10})", 0);
        return strExtractWithRegex == null ? "" : strExtractWithRegex;
    }

    private final int extractAmount(String message) {
        String strReplace$default;
        String strExtractWithRegex = extractWithRegex(message, "Ksh([\\d,]+\\.\\d{2})", 1);
        if (strExtractWithRegex == null || (strReplace$default = StringsKt.replace$default(strExtractWithRegex, ",", "", false, 4, (Object) null)) == null) {
            return 0;
        }
        return (int) Double.parseDouble(strReplace$default);
    }

    private final long extractTime(String message) {
        Date date;
        String strExtractWithRegex = extractWithRegex(message, "on (\\d{1,2}/\\d{1,2}/\\d{2,4} at \\d{1,2}:\\d{2} [AP]M)", 1);
        if (strExtractWithRegex == null || (date = new SimpleDateFormat("dd/MM/yy 'at' hh:mm a", Locale.ENGLISH).parse(strExtractWithRegex)) == null) {
            return 0L;
        }
        return date.getTime();
    }

    private final String extractWithRegex(String message, String pattern, int group) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        MatchResult matchResultFind$default = Regex.find$default(new Regex(pattern, RegexOption.IGNORE_CASE), message, 0, 2, null);
        if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(group)) == null) {
            return null;
        }
        return matchGroup.getValue();
    }
}
