package com.example.bingwa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import fb.j;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class IncomingSmsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3528a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f3529b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final void a(String str) {
        j jVar = f3529b;
        if (jVar == null) {
            Log.e("IncomingSmsReceiver", "Flutter MethodChannel is not initialized");
        } else {
            k.b(jVar);
            jVar.c("broadcast", str);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Object[] objArr;
        k.e(context, "context");
        k.e(intent, "intent");
        if (!k.a(intent.getAction(), "android.provider.Telephony.SMS_RECEIVED") || (extras = intent.getExtras()) == null || (objArr = (Object[]) extras.get("pdus")) == null) {
            return;
        }
        Iterator itA = b.a(objArr);
        while (itA.hasNext()) {
            Object next = itA.next();
            k.c(next, "null cannot be cast to non-null type kotlin.ByteArray");
            String messageBody = SmsMessage.createFromPdu((byte[]) next).getMessageBody();
            k.b(messageBody);
            a(messageBody);
        }
    }
}
