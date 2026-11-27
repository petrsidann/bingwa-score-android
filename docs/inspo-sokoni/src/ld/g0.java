package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f12724a = new a.a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12726c;

    static {
        Object objB;
        Object objB2;
        try {
            lc.j.a aVar = lc.j.f12703b;
            objB = lc.j.b(qc.a.class.getCanonicalName());
        } catch (Throwable th) {
            lc.j.a aVar2 = lc.j.f12703b;
            objB = lc.j.b(lc.k.a(th));
        }
        if (lc.j.d(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f12725b = (String) objB;
        try {
            objB2 = lc.j.b(g0.class.getCanonicalName());
        } catch (Throwable th2) {
            lc.j.a aVar3 = lc.j.f12703b;
            objB2 = lc.j.b(lc.k.a(th2));
        }
        if (lc.j.d(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f12726c = (String) objB2;
    }

    public static final <E extends Throwable> E a(E e10) {
        return e10;
    }
}
