package ba;

import android.app.Activity;
import android.content.Context;
import ca.h;
import ca.i;
import com.shounakmulay.telephony.sms.IncomingSmsReceiver;
import fb.j;
import kotlin.jvm.internal.k;
import ya.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements xa.a, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f3044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f3045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f3046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fb.b f3047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f3048e;

    public final void a(Context context, fb.b bVar) {
        this.f3046c = new h(context);
        this.f3048e = new a(context);
        h hVar = this.f3046c;
        j jVar = null;
        if (hVar == null) {
            k.o("smsController");
            hVar = null;
        }
        a aVar = this.f3048e;
        if (aVar == null) {
            k.o("permissionsController");
            aVar = null;
        }
        this.f3045b = new i(context, hVar, aVar);
        j jVar2 = new j(bVar, "plugins.shounakmulay.com/foreground_sms_channel");
        this.f3044a = jVar2;
        i iVar = this.f3045b;
        if (iVar == null) {
            k.o("smsMethodCallHandler");
            iVar = null;
        }
        jVar2.e(iVar);
        i iVar2 = this.f3045b;
        if (iVar2 == null) {
            k.o("smsMethodCallHandler");
            iVar2 = null;
        }
        j jVar3 = this.f3044a;
        if (jVar3 == null) {
            k.o("smsChannel");
        } else {
            jVar = jVar3;
        }
        iVar2.l(jVar);
    }

    public final void b() {
        IncomingSmsReceiver.f6093a.a(null);
        j jVar = this.f3044a;
        if (jVar == null) {
            k.o("smsChannel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // ya.a
    public void onAttachedToActivity(c binding) {
        k.e(binding, "binding");
        IncomingSmsReceiver.a aVar = IncomingSmsReceiver.f6093a;
        j jVar = this.f3044a;
        i iVar = null;
        if (jVar == null) {
            k.o("smsChannel");
            jVar = null;
        }
        aVar.a(jVar);
        i iVar2 = this.f3045b;
        if (iVar2 == null) {
            k.o("smsMethodCallHandler");
            iVar2 = null;
        }
        Activity activityG = binding.g();
        k.d(activityG, "getActivity(...)");
        iVar2.k(activityG);
        i iVar3 = this.f3045b;
        if (iVar3 == null) {
            k.o("smsMethodCallHandler");
        } else {
            iVar = iVar3;
        }
        binding.h(iVar);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        if (this.f3047d == null) {
            this.f3047d = flutterPluginBinding.b();
        }
        Context contextA = flutterPluginBinding.a();
        k.d(contextA, "getApplicationContext(...)");
        fb.b bVar = this.f3047d;
        if (bVar == null) {
            k.o("binaryMessenger");
            bVar = null;
        }
        a(contextA, bVar);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        b();
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        b();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c binding) {
        k.e(binding, "binding");
        onAttachedToActivity(binding);
    }
}
