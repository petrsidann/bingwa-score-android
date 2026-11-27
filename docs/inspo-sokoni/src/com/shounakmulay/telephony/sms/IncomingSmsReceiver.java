package com.shounakmulay.telephony.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import ca.b;
import ca.c;
import ed.t;
import fb.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import mc.o;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class IncomingSmsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6093a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f6094b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(j jVar) {
            IncomingSmsReceiver.f6094b = jVar;
        }
    }

    public final void b(Context context, HashMap<String, Object> map) {
        b bVar = b.f3447a;
        if (bVar.f().get()) {
            bVar.a(context, map);
            return;
        }
        bVar.d(context);
        bVar.j(context, context.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).getLong("background_setup_handle", 0L));
        bVar.c().add(map);
    }

    public final void c(Context context, List<? extends SmsMessage> list) {
        HashMap<String, Object> mapA = c.a((SmsMessage) w.u(list));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.l();
            }
            SmsMessage smsMessage = (SmsMessage) obj;
            if (i10 > 0) {
                StringBuilder sb2 = new StringBuilder();
                Object obj2 = mapA.get("message_body");
                k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                sb2.append((String) obj2);
                String messageBody = smsMessage.getMessageBody();
                k.d(messageBody, "getMessageBody(...)");
                sb2.append(t.o0(messageBody).toString());
                mapA.put("message_body", sb2.toString());
            }
            i10 = i11;
        }
        if (!b.f3447a.e(context)) {
            if (context.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).getBoolean("disable_background", false)) {
                return;
            }
            b(context, mapA);
        } else {
            HashMap map = new HashMap();
            map.put("message", mapA);
            j jVar = f6094b;
            if (jVar != null) {
                jVar.c("onMessage", map);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        ca.a.f3445a.b(context.getApplicationContext());
        SmsMessage[] messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        k.b(messagesFromIntent);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SmsMessage smsMessage : messagesFromIntent) {
            String originatingAddress = smsMessage.getOriginatingAddress();
            Object arrayList = linkedHashMap.get(originatingAddress);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(originatingAddress, arrayList);
            }
            ((List) arrayList).add(smsMessage);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            c(context, (List) ((Map.Entry) it.next()).getValue());
        }
    }
}
