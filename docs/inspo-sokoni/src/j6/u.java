package j6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f11298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f11299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f11300c;

    static {
        Object objB = b();
        f11298a = objB;
        f11299b = objB == null ? null : a();
        f11300c = objB != null ? d(objB) : null;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Object obj) {
        try {
            Method methodC = c("getStackTraceDepth", Throwable.class);
            if (methodC == null) {
                return null;
            }
            methodC.invoke(obj, new Throwable());
            return methodC;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(Throwable th) {
        m.o(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
