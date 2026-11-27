package l0;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12386a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12390e;

    /* JADX INFO: renamed from: l0.a$a, reason: collision with other inner class name */
    public static final class C0206a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0206a f12391a = new C0206a();

        public final int a(int i10) {
            return SdkExtensions.getExtensionVersion(i10);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f12387b = i10 >= 30 ? C0206a.f12391a.a(30) : 0;
        f12388c = i10 >= 30 ? C0206a.f12391a.a(31) : 0;
        f12389d = i10 >= 30 ? C0206a.f12391a.a(33) : 0;
        f12390e = i10 >= 30 ? C0206a.f12391a.a(1000000) : 0;
    }

    public static final boolean a(String codename, String buildCodename) {
        kotlin.jvm.internal.k.e(codename, "codename");
        kotlin.jvm.internal.k.e(buildCodename, "buildCodename");
        if (kotlin.jvm.internal.k.a("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        kotlin.jvm.internal.k.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        kotlin.jvm.internal.k.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 33) {
            if (i10 >= 32) {
                String CODENAME = Build.VERSION.CODENAME;
                kotlin.jvm.internal.k.d(CODENAME, "CODENAME");
                if (a("Tiramisu", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
