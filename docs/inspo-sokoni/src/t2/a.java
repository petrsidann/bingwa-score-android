package t2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import fb.i;
import fb.j;
import fb.l;
import java.util.Iterator;
import u2.d;
import u2.e;
import u2.f;
import ya.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements j.c, xa.a, ya.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xa.a.b f15804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f15805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f15806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f15807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j.d f15808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15809f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f15810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15811m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15812n = 273;

    public final boolean a() {
        try {
            return this.f15806c.getPackageManager().canRequestPackageInstalls();
        } catch (SecurityException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final void b() {
        String str;
        if (d()) {
            if (d.j(this.f15809f)) {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    if (i10 >= 33 && d.g(this.f15809f, this.f15810l)) {
                        if (d.i(this.f15810l) && !c("android.permission.READ_MEDIA_IMAGES") && !Environment.isExternalStorageManager()) {
                            str = "Permission denied: android.permission.READ_MEDIA_IMAGES";
                        } else if (d.l(this.f15810l) && !c("android.permission.READ_MEDIA_VIDEO") && !Environment.isExternalStorageManager()) {
                            str = "Permission denied: android.permission.READ_MEDIA_VIDEO";
                        } else if (d.f(this.f15810l) && !c("android.permission.READ_MEDIA_AUDIO") && !Environment.isExternalStorageManager()) {
                            str = "Permission denied: android.permission.READ_MEDIA_AUDIO";
                        }
                        f(-3, str);
                        return;
                    }
                    if (!Environment.isExternalStorageManager()) {
                        str = "Permission denied: android.permission.MANAGE_EXTERNAL_STORAGE";
                        f(-3, str);
                        return;
                    }
                } else if (!c("android.permission.READ_EXTERNAL_STORAGE")) {
                    str = "Permission denied: android.permission.READ_EXTERNAL_STORAGE";
                    f(-3, str);
                    return;
                }
            }
            if ("application/vnd.android.package-archive".equals(this.f15810l)) {
                e();
            } else {
                h();
            }
        }
    }

    public final boolean c(String str) {
        return f0.a.checkSelfPermission(this.f15806c, str) == 0;
    }

    public final boolean d() {
        if (this.f15809f != null) {
            return true;
        }
        f(-4, "the file path cannot be null");
        return false;
    }

    public final void e() {
        if (a()) {
            h();
        } else {
            f(-3, "Permission denied: android.permission.REQUEST_INSTALL_PACKAGES");
        }
    }

    public final void f(int i10, String str) {
        if (this.f15808e == null || this.f15811m) {
            return;
        }
        this.f15808e.a(e.a(f.a(i10, str)));
        this.f15811m = true;
    }

    public final void g() {
        if (this.f15807d == null) {
            this.f15807d = new j(this.f15804a.b(), "open_file");
        }
        this.f15807d.e(this);
    }

    public final void h() {
        int i10;
        String str;
        if (d()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            Uri uriE = d.e(this.f15805b, this.f15809f);
            intent.setDataAndType(uriE, this.f15810l);
            intent.addFlags(268435459);
            Iterator<ResolveInfo> it = (Build.VERSION.SDK_INT >= 33 ? this.f15806c.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(65536L)) : this.f15806c.getPackageManager().queryIntentActivities(intent, 65536)).iterator();
            while (it.hasNext()) {
                this.f15806c.grantUriPermission(it.next().activityInfo.packageName, uriE, 3);
            }
            try {
                this.f15806c.startActivity(intent);
                i10 = 0;
                str = "done";
            } catch (ActivityNotFoundException unused) {
                i10 = -1;
                str = "No APP found to open this file。";
            } catch (Exception unused2) {
                i10 = -4;
                str = "File opened incorrectly。";
            }
            f(i10, str);
        }
    }

    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        Uri data;
        if (intent != null && i10 == this.f15812n && (data = intent.getData()) != null) {
            this.f15805b.getContentResolver().takePersistableUriPermission(data, 3);
            b();
        }
        return false;
    }

    @Override // ya.a
    public void onAttachedToActivity(c cVar) {
        this.f15806c = cVar.g();
        cVar.b(this);
        g();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        this.f15804a = bVar;
        this.f15805b = bVar.a();
        g();
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f15804a = null;
        j jVar = this.f15807d;
        if (jVar == null) {
            return;
        }
        jVar.e(null);
        this.f15807d = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        this.f15811m = false;
        if (!iVar.f8284a.equals("open_file")) {
            dVar.c();
            this.f15811m = true;
            return;
        }
        this.f15808e = dVar;
        if (iVar.c("file_path")) {
            this.f15809f = d.c((String) iVar.a("file_path"));
        }
        this.f15810l = (!iVar.c("type") || iVar.a("type") == null) ? d.d(this.f15809f) : (String) iVar.a("type");
        b();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c cVar) {
        onAttachedToActivity(cVar);
    }
}
