package com.phan_tech.ussd_advanced;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import fb.i;
import fb.j;
import fb.r;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import lc.q;
import mc.w;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class c implements xa.a, j.c, ya.a, fb.a.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f6054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f6056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f6057d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AccessibilityEvent f6059f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fb.a<String> f6060l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.phan_tech.ussd_advanced.a f6058e = com.phan_tech.ussd_advanced.b.f6045a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String[] f6061m = {"extra_asus_dial_use_dualsim", "com.android.phone.extra.slot", "slot", "simslot", "sim_slot", "subscription", "Subscription", "phone", "com.android.phone.DialingMode", "simSlot", "slot_id", "simId", "simnum", "phone_type", "slotId", "slotIdx"};

    public static final class a extends Exception {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0105a f6062b = new C0105a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f6063c = "ussd_plugin_ussd_execution_failure";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6064a;

        /* JADX INFO: renamed from: com.phan_tech.ussd_advanced.c$a$a, reason: collision with other inner class name */
        public static final class C0105a {
            public C0105a() {
            }

            public /* synthetic */ C0105a(g gVar) {
                this();
            }

            public final String a() {
                return a.f6063c;
            }
        }

        public a(String message) {
            k.e(message, "message");
            this.f6064a = message;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f6064a;
        }
    }

    public static final class b extends Exception {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6065b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f6066c = "ussd_plugin_incorrect__parameters";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6067a;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(g gVar) {
                this();
            }
        }

        public b(String message) {
            k.e(message, "message");
            this.f6067a = message;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f6067a;
        }
    }

    /* JADX INFO: renamed from: com.phan_tech.ussd_advanced.c$c, reason: collision with other inner class name */
    public static final class C0106c implements com.phan_tech.ussd_advanced.b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j.d f6069b;

        public C0106c(j.d dVar) {
            this.f6069b = dVar;
        }

        @Override // com.phan_tech.ussd_advanced.b.a
        public void a(String message) {
            k.e(message, "message");
            try {
                fb.a aVar = c.this.f6060l;
                if (aVar == null) {
                    k.o("basicMessageChannel");
                    aVar = null;
                }
                aVar.c(message);
                this.f6069b.a(message);
                fb.a aVar2 = c.this.f6060l;
                if (aVar2 == null) {
                    k.o("basicMessageChannel");
                    aVar2 = null;
                }
                aVar2.e(null);
            } catch (Exception unused) {
            }
        }

        @Override // com.phan_tech.ussd_advanced.b.a
        public void b(AccessibilityEvent ev) {
            k.e(ev, "ev");
            c.this.f6059f = AccessibilityEvent.obtain(ev);
            c.this.r();
            try {
                List<CharSequence> text = ev.getText();
                k.d(text, "getText(...)");
                if (!text.isEmpty()) {
                    this.f6069b.a(String.join("\n", ev.getText()));
                } else {
                    this.f6069b.a(null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final class d extends TelephonyManager.UssdResponseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t<CompletableFuture<String>> f6070a;

        public d(t<CompletableFuture<String>> tVar) {
            this.f6070a = tVar;
        }

        @Override // android.telephony.TelephonyManager.UssdResponseCallback
        public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
            k.e(telephonyManager, "telephonyManager");
            k.e(request, "request");
            k.e(response, "response");
            this.f6070a.f12381a.complete(response.toString());
        }

        @Override // android.telephony.TelephonyManager.UssdResponseCallback
        public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int i10) {
            CompletableFuture<String> completableFuture;
            a aVar;
            k.e(telephonyManager, "telephonyManager");
            k.e(request, "request");
            if (i10 == -2) {
                completableFuture = this.f6070a.f12381a;
                aVar = new a("USSD_ERROR_SERVICE_UNAVAIL");
            } else if (i10 != -1) {
                completableFuture = this.f6070a.f12381a;
                aVar = new a("unknown error");
            } else {
                completableFuture = this.f6070a.f12381a;
                aVar = new a("USSD_RETURN_FAILURE");
            }
            completableFuture.completeExceptionally(aVar);
        }
    }

    public static final q o(c cVar, fb.a.e eVar, AccessibilityEvent it) {
        String string;
        k.e(it, "it");
        cVar.f6059f = AccessibilityEvent.obtain(it);
        try {
            List<CharSequence> text = it.getText();
            k.d(text, "getText(...)");
            if (!text.isEmpty()) {
                List<CharSequence> text2 = it.getText();
                k.d(text2, "getText(...)");
                string = w.u(text2).toString();
            } else {
                string = null;
            }
            eVar.a(string);
        } catch (Exception unused) {
        }
        return q.f12711a;
    }

    public static final String p(j.d dVar, Throwable th) {
        String strA;
        String message;
        if (th instanceof a) {
            strA = a.f6062b.a();
            message = ((a) th).getMessage();
        } else {
            strA = a.f6062b.a();
            message = th != null ? th.getMessage() : null;
        }
        dVar.b(strA, message, null);
        return null;
    }

    public final void g(String str, int i10) throws Exception {
        Context context = this.f6055b;
        Context context2 = null;
        if (context == null) {
            k.o("context");
            context = null;
        }
        if (f0.a.checkSelfPermission(context, "android.permission.CALL_PHONE") != 0) {
            Activity activity = this.f6056c;
            k.b(activity);
            if (!e0.b.f(activity, "android.permission.CALL_PHONE")) {
                Activity activity2 = this.f6056c;
                k.b(activity2);
                e0.b.e(activity2, new String[]{"android.permission.CALL_PHONE"}, 2);
            }
        }
        boolean z10 = i10 == -1;
        int i11 = i10 - 1;
        try {
            String strP = ed.q.p(str, "#", "%23", false, 4, null);
            if (!ed.q.r(strP, "tel:", false, 2, null)) {
                kotlin.jvm.internal.w wVar = kotlin.jvm.internal.w.f12384a;
                strP = String.format("tel:%s", Arrays.copyOf(new Object[]{strP}, 1));
                k.d(strP, "format(format, *args)");
            }
            Intent intent = new Intent(k() ? "android.intent.action.CALL" : "android.intent.action.VIEW");
            intent.setData(Uri.parse(strP));
            intent.addFlags(268435456);
            if (!z10) {
                intent.putExtra("com.android.phone.force.slot", true);
                intent.putExtra("Cdma_Supp", true);
                for (String str2 : this.f6061m) {
                    intent.putExtra(str2, i11);
                }
                Context context3 = this.f6055b;
                if (context3 == null) {
                    k.o("context");
                    context3 = null;
                }
                if (f0.a.checkSelfPermission(context3, "android.permission.READ_PHONE_STATE") != 0) {
                    Activity activity3 = this.f6056c;
                    k.b(activity3);
                    if (!e0.b.f(activity3, "android.permission.READ_PHONE_STATE")) {
                        Activity activity4 = this.f6056c;
                        k.b(activity4);
                        e0.b.e(activity4, new String[]{"android.permission.READ_PHONE_STATE"}, 2);
                    }
                }
                Context context4 = this.f6055b;
                if (context4 == null) {
                    k.o("context");
                    context4 = null;
                }
                Object systemService = context4.getSystemService("telecom");
                k.c(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
                List<PhoneAccountHandle> callCapablePhoneAccounts = ((TelecomManager) systemService).getCallCapablePhoneAccounts();
                if (callCapablePhoneAccounts != null && (!callCapablePhoneAccounts.isEmpty())) {
                    intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", callCapablePhoneAccounts.get(i11));
                }
            }
            Context context5 = this.f6055b;
            if (context5 == null) {
                k.o("context");
            } else {
                context2 = context5;
            }
            context2.startActivity(intent);
        } catch (Exception e10) {
            throw e10;
        }
    }

    public final String h(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USSD_PREFS", 0);
        String string = sharedPreferences.getString("USSD_RESPONSE", "No Response");
        if (string == null) {
            string = "No Response";
        }
        sharedPreferences.edit().putString("USSD_RESPONSE", "No Response").apply();
        return string;
    }

    public final boolean i() {
        Context context = this.f6055b;
        Context context2 = null;
        if (context == null) {
            k.o("context");
            context = null;
        }
        if (f0.a.checkSelfPermission(context, "android.permission.CALL_PHONE") == 0) {
            Context context3 = this.f6055b;
            if (context3 == null) {
                k.o("context");
                context3 = null;
            }
            if (f0.a.checkSelfPermission(context3, "android.permission.READ_PHONE_STATE") == 0) {
                Context context4 = this.f6055b;
                if (context4 == null) {
                    k.o("context");
                } else {
                    context2 = context4;
                }
                if (j(context2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean j(Context context) {
        Object systemService = context.getSystemService("accessibility");
        k.c(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        Iterator<AccessibilityServiceInfo> it = ((AccessibilityManager) systemService).getEnabledAccessibilityServiceList(-1).iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            k.b(id2);
            if (ed.t.v(id2, "com.phan_tech.ussd_advanced.USSDServiceKT", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() {
        Context context = this.f6055b;
        if (context == null) {
            k.o("context");
            context = null;
        }
        Object systemService = context.getSystemService("phone");
        k.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).getPhoneType() != 0;
    }

    public final void l(String str, int i10, j.d dVar) {
        if (i10 == -1) {
            i10 = 0;
        }
        try {
            com.phan_tech.ussd_advanced.a aVar = this.f6058e;
            Context context = this.f6055b;
            if (context == null) {
                k.o("context");
                context = null;
            }
            aVar.c(context, str, i10, new C0106c(dVar));
        } catch (Exception e10) {
            dVar.b("USSDError", "USSD session failed: " + e10.getLocalizedMessage(), null);
        }
    }

    public final void m() {
        AccessibilityEvent accessibilityEvent = this.f6059f;
        if (accessibilityEvent != null) {
            try {
                com.phan_tech.ussd_advanced.a aVar = this.f6058e;
                k.b(accessibilityEvent);
                aVar.a(accessibilityEvent);
                fb.a<String> aVar2 = this.f6060l;
                if (aVar2 == null) {
                    k.o("basicMessageChannel");
                    aVar2 = null;
                }
                aVar2.e(null);
            } catch (Exception e10) {
                Log.e("UssdAdvancedPlugin", "Error canceling USSD session: " + e10.getMessage());
            }
        }
    }

    @Override // fb.a.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(String str, final fb.a.e<String> reply) {
        k.e(reply, "reply");
        if (str != null) {
            com.phan_tech.ussd_advanced.b bVar = com.phan_tech.ussd_advanced.b.f6045a;
            AccessibilityEvent accessibilityEvent = this.f6059f;
            k.b(accessibilityEvent);
            bVar.n(str, accessibilityEvent, new l() { // from class: v9.e
                @Override // xc.l
                public final Object invoke(Object obj) {
                    return com.phan_tech.ussd_advanced.c.o(this.f17196a, reply, (AccessibilityEvent) obj);
                }
            });
        }
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c binding) {
        k.e(binding, "binding");
        this.f6056c = binding.g();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        j jVar = new j(flutterPluginBinding.b(), "method.com.phan_tech/ussd_advanced");
        this.f6054a = jVar;
        jVar.e(this);
        this.f6055b = flutterPluginBinding.a();
        this.f6060l = new fb.a<>(flutterPluginBinding.b(), "message.com.phan_tech/ussd_advanced", r.f8302b);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f6056c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f6057d = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        j jVar = this.f6054a;
        if (jVar == null) {
            k.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        if (r8.equals("requestPermissions") == false) goto L68;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // fb.j.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMethodCall(i call, final j.d result) throws Exception {
        String str;
        Object objValueOf;
        k.e(call, "call");
        k.e(result, "result");
        int i10 = 1;
        if (k.a(call.f8284a, "sendUssd") || k.a(call.f8284a, "sendAdvancedUssd") || k.a(call.f8284a, "multisessionUssd")) {
            Integer num = (Integer) call.a("subscriptionId");
            if (num == null) {
                throw new b("Incorrect parameter type: `subscriptionId` must be an int");
            }
            int iIntValue = num.intValue();
            if (iIntValue < -1) {
                throw new b("Incorrect parameter value: `subscriptionId` must be >= -1");
            }
            String str2 = (String) call.a("code");
            if (str2 == null) {
                throw new b("Incorrect parameter type: `code` must be a String");
            }
            if ((str2.length() != 0 ? 0 : 1) != 0) {
                throw new b("Incorrect parameter value: `code` must not be an empty string");
            }
            i10 = iIntValue;
            str = str2;
        } else {
            str = "";
        }
        String str3 = call.f8284a;
        if (str3 != null) {
            Context context = null;
            switch (str3.hashCode()) {
                case -1613134260:
                    if (str3.equals("multisessionUssd")) {
                        if (i()) {
                            l(str, i10, result);
                            return;
                        }
                        q();
                        result.a(null);
                        return;
                    }
                    break;
                case -1348927399:
                    if (str3.equals("sendAdvancedUssd")) {
                        CompletableFuture<String> completableFutureS = s(str, i10);
                        objValueOf = completableFutureS;
                        if (completableFutureS != null) {
                            completableFutureS.exceptionally(new Function() { // from class: v9.c
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    return com.phan_tech.ussd_advanced.c.p(result, (Throwable) obj);
                                }
                            }).thenAccept(new Consumer() { // from class: v9.d
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    result.a(obj);
                                }
                            });
                            return;
                        }
                        result.a(objValueOf);
                        return;
                    }
                    break;
                case 1032406410:
                    if (str3.equals("hasPermissions")) {
                        objValueOf = Boolean.valueOf(i());
                        result.a(objValueOf);
                        return;
                    }
                    break;
                case 1213577190:
                    if (str3.equals("multisessionUssdCancel")) {
                        m();
                        return;
                    }
                    break;
                case 1247489303:
                    if (str3.equals("sendUssd")) {
                        g(str, i10);
                        objValueOf = q.f12711a;
                        result.a(objValueOf);
                        return;
                    }
                    break;
                case 1669188213:
                    break;
                case 1737576887:
                    if (str3.equals("getResponse")) {
                        if (this.f6055b == null) {
                            k.o("context");
                        }
                        Context context2 = this.f6055b;
                        if (context2 == null) {
                            k.o("context");
                        } else {
                            context = context2;
                        }
                        objValueOf = h(context);
                        result.a(objValueOf);
                        return;
                    }
                    break;
            }
        }
        result.c();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c binding) {
        k.e(binding, "binding");
        this.f6057d = binding.g();
    }

    public final void q() {
        Context context = this.f6055b;
        Context context2 = null;
        if (context == null) {
            k.o("context");
            context = null;
        }
        if (!j(context)) {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.setFlags(268435456);
            Context context3 = this.f6055b;
            if (context3 == null) {
                k.o("context");
                context3 = null;
            }
            context3.startActivity(intent);
        }
        Context context4 = this.f6055b;
        if (context4 == null) {
            k.o("context");
            context4 = null;
        }
        if (f0.a.checkSelfPermission(context4, "android.permission.CALL_PHONE") != 0) {
            Activity activity = this.f6056c;
            k.b(activity);
            if (!e0.b.f(activity, "android.permission.CALL_PHONE")) {
                Activity activity2 = this.f6056c;
                k.b(activity2);
                e0.b.e(activity2, new String[]{"android.permission.CALL_PHONE"}, 2);
            }
        }
        Context context5 = this.f6055b;
        if (context5 == null) {
            k.o("context");
        } else {
            context2 = context5;
        }
        if (f0.a.checkSelfPermission(context2, "android.permission.READ_PHONE_STATE") != 0) {
            Activity activity3 = this.f6056c;
            k.b(activity3);
            if (e0.b.f(activity3, "android.permission.READ_PHONE_STATE")) {
                return;
            }
            Activity activity4 = this.f6056c;
            k.b(activity4);
            e0.b.e(activity4, new String[]{"android.permission.READ_PHONE_STATE"}, 2);
        }
    }

    public final void r() {
        fb.a<String> aVar = this.f6060l;
        if (aVar == null) {
            k.o("basicMessageChannel");
            aVar = null;
        }
        aVar.e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.concurrent.CompletableFuture] */
    public final CompletableFuture<String> s(String str, int i10) {
        boolean z10 = i10 == -1;
        t tVar = new t();
        tVar.f12381a = new CompletableFuture();
        Context context = this.f6055b;
        Context context2 = null;
        if (context == null) {
            k.o("context");
            context = null;
        }
        if (f0.a.checkSelfPermission(context, "android.permission.CALL_PHONE") != 0) {
            Activity activity = this.f6056c;
            k.b(activity);
            if (!e0.b.f(activity, "android.permission.CALL_PHONE")) {
                Activity activity2 = this.f6056c;
                k.b(activity2);
                e0.b.e(activity2, new String[]{"android.permission.CALL_PHONE"}, 2);
            }
        }
        Context context3 = this.f6055b;
        if (context3 == null) {
            k.o("context");
        } else {
            context2 = context3;
        }
        Object systemService = context2.getSystemService("phone");
        k.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        TelephonyManager telephonyManagerCreateForSubscriptionId = telephonyManager.createForSubscriptionId(i10);
        k.d(telephonyManagerCreateForSubscriptionId, "createForSubscriptionId(...)");
        d dVar = new d(tVar);
        if (z10) {
            telephonyManager.sendUssdRequest(str, dVar, new Handler(Looper.getMainLooper()));
        } else {
            telephonyManagerCreateForSubscriptionId.sendUssdRequest(str, dVar, new Handler(Looper.getMainLooper()));
        }
        return (CompletableFuture) tVar.f12381a;
    }
}
