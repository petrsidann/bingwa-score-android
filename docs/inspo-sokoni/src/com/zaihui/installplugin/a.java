package com.zaihui.installplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import fb.i;
import fb.j;
import fb.l;
import ja.c;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, j.c, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f6096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j.d f6097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f6098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f6099d = new WeakReference<>(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6100e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6101f = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6102l;

    public static final boolean h(a aVar, int i10, int i11, Intent intent) {
        return aVar.e(i10, i11, intent);
    }

    public static final boolean i(a aVar, int i10, int i11, Intent intent) {
        return aVar.e(i10, i11, intent);
    }

    public final Activity c() {
        return this.f6099d.get();
    }

    public final Intent d(Context context, String str, String str2, boolean z10) {
        if (context == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            return null;
        }
        Log.i("test", "getInstallAppIntent:" + Build.VERSION.SDK_INT);
        Uri uriA = InstallFileProvider.f6095l.a(context, file);
        Log.i("test", "getInstallAppIntent:" + uriA);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriA, "application/vnd.android.package-archive");
        intent.setFlags(1);
        return !z10 ? intent : intent.addFlags(268435456);
    }

    public final boolean e(int i10, int i11, Intent intent) {
        j.d dVar;
        c cVar;
        Log.i("InstallPlugin", "handleActivityResult(" + i10 + ',' + i11 + ',' + intent + ')');
        if (i10 != this.f6100e) {
            return false;
        }
        if (i11 == -1) {
            if (this.f6102l) {
                dVar = this.f6097b;
                if (dVar != null) {
                    cVar = new c(true, "Install Success");
                    dVar.a(cVar.a());
                }
            } else {
                g(this.f6101f, "");
            }
        } else if (this.f6102l) {
            dVar = this.f6097b;
            if (dVar != null) {
                cVar = new c(false, "Install Cancel");
                dVar.a(cVar.a());
            }
        } else {
            dVar = this.f6097b;
            if (dVar != null) {
                cVar = new c(false, "Request Install Permission Fail");
                dVar.a(cVar.a());
            }
        }
        return true;
    }

    public final boolean f() {
        PackageManager packageManager;
        Context context = this.f6098c;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        return packageManager.canRequestPackageInstalls();
    }

    public final void g(String str, String str2) {
        if (str == null || str.length() == 0) {
            j.d dVar = this.f6097b;
            if (dVar != null) {
                dVar.a(new c(false, "FilePath Must Not Null").a());
                return;
            }
            return;
        }
        this.f6101f = str;
        if (str2 == null || str2.length() == 0) {
            Context context = this.f6098c;
            str2 = context != null ? context.getPackageName() : null;
        }
        if (str2 == null || str2.length() == 0) {
            j.d dVar2 = this.f6097b;
            if (dVar2 != null) {
                dVar2.a(new c(false, "Failed To Obtain PackageName Must Not Null").a());
                return;
            }
            return;
        }
        if (!f()) {
            this.f6102l = false;
            j(str2);
            return;
        }
        this.f6102l = true;
        Intent intentD = d(this.f6098c, str2, str, false);
        if (intentD == null) {
            j.d dVar3 = this.f6097b;
            if (dVar3 != null) {
                dVar3.a(new c(false, "Not Get Install Intent").a());
                return;
            }
            return;
        }
        intentD.addFlags(536870912);
        intentD.putExtra("android.intent.extra.RETURN_RESULT", true);
        Activity activityC = c();
        if (activityC != null) {
            activityC.startActivityForResult(intentD, this.f6100e);
        }
    }

    public final void j(String str) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(Uri.parse("package:" + str));
        Activity activityC = c();
        if (activityC != null) {
            activityC.startActivityForResult(intent, this.f6100e);
        }
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c binding) {
        k.e(binding, "binding");
        this.f6099d = new WeakReference<>(binding.g());
        binding.b(new l() { // from class: ja.b
            @Override // fb.l
            public final boolean onActivityResult(int i10, int i11, Intent intent) {
                return com.zaihui.installplugin.a.h(this.f11327a, i10, i11, intent);
            }
        });
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f6098c = flutterPluginBinding.a();
        j jVar = new j(flutterPluginBinding.b(), "install_plugin");
        this.f6096a = jVar;
        jVar.e(this);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f6099d.clear();
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f6099d.clear();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        this.f6098c = null;
        j jVar = this.f6096a;
        if (jVar == null) {
            k.o("channel");
            jVar = null;
        }
        jVar.e(null);
        this.f6097b = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        k.e(call, "call");
        k.e(result, "result");
        this.f6097b = result;
        if (!k.a(call.f8284a, "installApk")) {
            result.c();
            return;
        }
        String str = (String) call.a("filePath");
        String str2 = (String) call.a("packageName");
        Log.i("test", "onMethodCall:" + str + ',' + str2);
        g(str, str2);
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c binding) {
        k.e(binding, "binding");
        this.f6099d = new WeakReference<>(binding.g());
        binding.b(new l() { // from class: ja.a
            @Override // fb.l
            public final boolean onActivityResult(int i10, int i11, Intent intent) {
                return com.zaihui.installplugin.a.i(this.f11326a, i10, i11, intent);
            }
        });
    }
}
