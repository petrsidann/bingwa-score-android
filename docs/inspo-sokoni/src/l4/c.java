package l4;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import j4.m;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12493a;

    public c(Context context) {
        this.f12493a = context;
    }

    public int a(String str) {
        return this.f12493a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f12493a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i10) {
        return this.f12493a.getPackageManager().getApplicationInfo(str, i10);
    }

    public CharSequence d(String str) {
        Context context = this.f12493a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i10) {
        return this.f12493a.getPackageManager().getPackageInfo(str, i10);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f12493a);
        }
        if (!m.e() || (nameForUid = this.f12493a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f12493a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean g(int i10, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.f12493a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i10, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
