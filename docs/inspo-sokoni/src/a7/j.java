package a7;

import e7.j0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f409a = new i().d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final j0 f410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final j0 f411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final j0 f412d;

    static {
        j0 j0VarN = j0.N();
        f410b = j0VarN;
        f411c = j0VarN;
        f412d = j0VarN;
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    @Deprecated
    public static void a() {
        b();
    }

    public static void b() {
        m.f();
        i.p(true);
        if (v6.a.a()) {
            return;
        }
        b.o(true);
    }
}
