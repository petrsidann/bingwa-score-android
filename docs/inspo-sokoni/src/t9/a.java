package t9;

import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import e0.b;
import fb.i;
import fb.j;
import fb.n;
import java.util.Map;
import kotlin.jvm.internal.k;
import ya.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, j.c, n, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f15857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15858b = 39;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f15859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f15860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SmsManager f15861e;

    public final void a() {
        SmsManager smsManager;
        try {
            Context context = this.f15860d;
            k.b(context);
            smsManager = (SmsManager) context.getSystemService(SmsManager.class);
        } catch (Exception unused) {
            smsManager = SmsManager.getDefault();
        }
        this.f15861e = smsManager;
    }

    public final void b(j.d dVar) {
        Context context = this.f15860d;
        k.b(context);
        if (f0.a.checkSelfPermission(context, "android.permission.SEND_SMS") == 0) {
            dVar.a(Boolean.TRUE);
            return;
        }
        Activity activity = this.f15859c;
        k.b(activity);
        if (b.f(activity, "android.permission.SEND_SMS")) {
            dVar.b("Permission Denied", "This plugin requires Sending SMS permission in order to work", new Exception("This plugin requires Sending SMS permission in order to work"));
            return;
        }
        Activity activity2 = this.f15859c;
        k.b(activity2);
        b.e(activity2, new String[]{"android.permission.SEND_SMS"}, this.f15858b);
    }

    @Override // ya.a
    public void onAttachedToActivity(c binding) {
        k.e(binding, "binding");
        this.f15859c = binding.g();
        if (f0.a.checkSelfPermission(binding.g(), "android.permission.SEND_SMS") == 0) {
            a();
        }
        binding.h(this);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f15860d = flutterPluginBinding.a();
        j jVar = new j(flutterPluginBinding.b(), "telephony_sms");
        this.f15857a = jVar;
        jVar.e(this);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f15859c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f15859c = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        j jVar = this.f15857a;
        if (jVar == null) {
            k.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        k.e(call, "call");
        k.e(result, "result");
        if (k.a(call.f8284a, "requestPermission")) {
            b(result);
            return;
        }
        if (!k.a(call.f8284a, "sendSMS")) {
            result.c();
            return;
        }
        if (this.f15861e == null) {
            result.b("Permission Denied", "This plugin requires Sending SMS permission in order to work", new Exception("This plugin requires Sending SMS permission in order to work"));
        }
        try {
            Object obj = call.f8285b;
            k.c(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Object obj2 = ((Map) obj).get("phone");
            k.b(obj2);
            Object obj3 = call.f8285b;
            k.c(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Object obj4 = ((Map) obj3).get("message");
            k.b(obj4);
            SmsManager smsManager = this.f15861e;
            k.b(smsManager);
            smsManager.sendTextMessage((String) obj2, null, (String) obj4, null, null);
        } catch (Exception e10) {
            result.b("Error while sending SMS", "An error has occurred", e10);
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c binding) {
        k.e(binding, "binding");
        this.f15859c = binding.g();
        if (f0.a.checkSelfPermission(binding.g(), "android.permission.SEND_SMS") == 0) {
            a();
        }
        binding.h(this);
    }

    @Override // fb.n
    public boolean onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        k.e(permissions, "permissions");
        k.e(grantResults, "grantResults");
        if (i10 != this.f15858b) {
            return false;
        }
        if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
            a();
        }
        return true;
    }
}
