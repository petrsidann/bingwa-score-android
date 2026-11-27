package e2;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f6959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f6960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f6961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f6962d;

    public static void a(String str, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        String strJ = j(str);
        if (i11 >= 29) {
            f.a(strJ, i10);
        } else {
            b(strJ, i10);
        }
    }

    public static void b(String str, int i10) {
        try {
            if (f6961c == null) {
                f6961c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f6961c.invoke(null, Long.valueOf(f6959a), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceBegin", e10);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        String strJ = j(str);
        if (i11 >= 29) {
            f.b(strJ, i10);
        } else {
            e(strJ, i10);
        }
    }

    public static void e(String str, int i10) {
        try {
            if (f6962d == null) {
                f6962d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f6962d.invoke(null, Long.valueOf(f6959a), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceEnd", e10);
        }
    }

    public static void f() {
        b.b();
    }

    public static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29 ? f.c() : i();
    }

    public static boolean i() {
        try {
            if (f6960b == null) {
                f6959a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f6960b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f6960b.invoke(null, Long.valueOf(f6959a))).booleanValue();
        } catch (Exception e10) {
            g("isTagEnabled", e10);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
