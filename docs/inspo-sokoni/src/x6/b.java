package x6;

import e7.j0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18007a = new a().d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final j0 f18008b = j0.N();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final j0 f18009c = j0.N();

    static {
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void a() {
        c.e();
        if (v6.a.a()) {
            return;
        }
        a.m(true);
    }
}
