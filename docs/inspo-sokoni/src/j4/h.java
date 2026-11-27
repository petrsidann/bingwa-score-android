package j4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.apps.common.proguard.SideEffectFree;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f11226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f11227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f11228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f11229d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f11229d == null) {
            boolean z10 = false;
            if (m.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f11229d = Boolean.valueOf(z10);
        }
        return f11229d.booleanValue();
    }

    public static boolean b() {
        int i10 = c4.j.f3376a;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !m.d()) {
            return true;
        }
        if (e(context)) {
            return !m.e() || m.h();
        }
        return false;
    }

    public static boolean e(Context context) {
        if (f11227b == null) {
            f11227b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f11227b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f11228c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f11228c = Boolean.valueOf(z10);
        }
        return f11228c.booleanValue();
    }

    @SideEffectFree
    public static boolean g(PackageManager packageManager) {
        if (f11226a == null) {
            f11226a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f11226a.booleanValue();
    }
}
