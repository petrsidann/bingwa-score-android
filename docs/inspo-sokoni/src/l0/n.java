package l0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f12403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f12404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f12405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f12406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f12407e;

    public static class a {
        public static void a(String str) {
            Trace.beginSection(str);
        }

        public static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f12403a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f12404b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f12405c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f12406d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f12407e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e10) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e10);
            }
        }
    }

    public static void a(String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
