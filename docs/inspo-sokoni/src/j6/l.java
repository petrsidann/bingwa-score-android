package j6;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11278a = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f11279b = b();

    public static final class b implements k {
        public b() {
        }
    }

    public static String a(double d10) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d10));
    }

    public static k b() {
        return new b();
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
