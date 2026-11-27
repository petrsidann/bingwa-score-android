package j4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11238a = Process.myUid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f11239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f11240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f11241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f11242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f11243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f11244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Method f11245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Method f11246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Boolean f11247j;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f11239b = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f11240c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f11241d = method3;
        try {
            method4 = WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        f11242e = method4;
        try {
            method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
            method5 = null;
        }
        f11243f = method5;
        if (m.f()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e10) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e10);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f11244g = method6;
        if (m.f()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e11) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e11);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f11245h = method7;
        if (m.f()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                try {
                    method8.setAccessible(true);
                } catch (Exception unused6) {
                }
            } catch (Exception unused7) {
                method8 = null;
            }
        } else {
            method8 = null;
        }
        f11246i = method8;
        f11247j = null;
    }

    public static void a(WorkSource workSource, int i10, String str) {
        Method method = f11240c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i10), str);
                return;
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
                return;
            }
        }
        Method method2 = f11239b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i10));
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        String str2;
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfoC = l4.d.a(context).c(str, 0);
            if (applicationInfoC == null) {
                str2 = "Could not get applicationInfo from package: ";
                Log.e("WorkSourceUtil", str2.concat(str));
                return null;
            }
            int i10 = applicationInfoC.uid;
            WorkSource workSource = new WorkSource();
            a(workSource, i10, str);
            return workSource;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "Could not find package: ";
        }
    }

    public static synchronized boolean c(Context context) {
        Boolean bool = f11247j;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        Boolean boolValueOf = Boolean.valueOf(f0.a.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0);
        f11247j = boolValueOf;
        return boolValueOf.booleanValue();
    }
}
