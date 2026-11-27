package oa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import fb.i;
import fb.j;
import kotlin.jvm.internal.k;
import ya.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, j.c, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f13798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f13799c;

    public final void a() {
        Activity activity = this.f13799c;
        if (activity != null) {
            Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268468224);
            }
            activity.startActivity(launchIntentForPackage);
            activity.finishAffinity();
        }
    }

    @Override // ya.a
    public void onAttachedToActivity(c binding) {
        k.e(binding, "binding");
        this.f13799c = binding.g();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f13797a = flutterPluginBinding.a();
        j jVar = new j(flutterPluginBinding.b(), "restart");
        this.f13798b = jVar;
        jVar.e(this);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f13799c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f13799c = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        j jVar = this.f13798b;
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
        if (!k.a(call.f8284a, "restartApp")) {
            result.c();
        } else {
            a();
            result.a("ok");
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c binding) {
        k.e(binding, "binding");
        this.f13799c = binding.g();
    }
}
