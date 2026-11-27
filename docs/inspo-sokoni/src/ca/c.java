package ca;

import android.telephony.SmsMessage;
import java.util.HashMap;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final HashMap<String, Object> a(SmsMessage smsMessage) {
        k.e(smsMessage, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        map.put("message_body", smsMessage.getMessageBody());
        map.put("timestamp", String.valueOf(smsMessage.getTimestampMillis()));
        map.put("originating_address", smsMessage.getOriginatingAddress());
        map.put("status", String.valueOf(smsMessage.getStatus()));
        map.put("service_center", smsMessage.getServiceCenterAddress());
        return map;
    }
}
