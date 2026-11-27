package l4;

import android.content.Context;
import j4.m;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f12491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f12492b;

    public static synchronized boolean a(Context context) {
        Boolean boolValueOf;
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f12491a;
        if (context2 != null && (bool = f12492b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f12492b = null;
        if (!m.e()) {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f12492b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                boolValueOf = Boolean.FALSE;
                f12492b = boolValueOf;
            }
            f12491a = applicationContext;
            return f12492b.booleanValue();
        }
        boolValueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        f12492b = boolValueOf;
        f12491a = applicationContext;
        return f12492b.booleanValue();
    }
}
