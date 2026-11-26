package com.example.bingwahybrid.domain.sms.utils;

import com.example.bingwahybrid.domain.enums.SmsType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"getSmsType", "Lcom/example/bingwahybrid/domain/enums/SmsType;", "message", "", "isAlreadyRecommendedResponse", "", "responseMessage", "isInsufficientBalanceResponse", "isConnectionProblemResponse", "isOkoaJahaziFailureResponse", "isSQLResponseError", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SmsUtilsKt {
    public static final SmsType getSmsType(String message) {
        SmsType next;
        Intrinsics.checkNotNullParameter(message, "message");
        String string = StringsKt.trim((CharSequence) message).toString();
        Iterator<SmsType> it = SmsType.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.matches(string));
        SmsType smsType = next;
        if (smsType != null) {
            return smsType;
        }
        throw new IllegalArgumentException("Unknown SMS type");
    }

    public static final boolean isAlreadyRecommendedResponse(String responseMessage) {
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        return StringsKt.contains((CharSequence) responseMessage, (CharSequence) "already been recommended", true);
    }

    public static final boolean isInsufficientBalanceResponse(String responseMessage) {
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        String str = responseMessage;
        return StringsKt.contains((CharSequence) str, (CharSequence) "insufficient airtime", true) || StringsKt.contains((CharSequence) str, (CharSequence) "insufficient account balance", true) || StringsKt.contains((CharSequence) str, (CharSequence) "insufficient balance", true) || StringsKt.contains((CharSequence) str, (CharSequence) "not enough airtime", true);
    }

    public static final boolean isConnectionProblemResponse(String responseMessage) {
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        return StringsKt.contains((CharSequence) responseMessage, (CharSequence) "Connection problem", true);
    }

    public static final boolean isOkoaJahaziFailureResponse(String responseMessage) {
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        return StringsKt.contains((CharSequence) responseMessage, (CharSequence) "has Okoa Jahazi and cannot receive bundles", true);
    }

    public static final boolean isSQLResponseError(String responseMessage) {
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        return StringsKt.contains((CharSequence) responseMessage, (CharSequence) "Excessive SQLs", true);
    }
}
