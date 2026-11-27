package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f12745a;

    static {
        Object objB;
        try {
            lc.j.a aVar = lc.j.f12703b;
            objB = lc.j.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            lc.j.a aVar2 = lc.j.f12703b;
            objB = lc.j.b(lc.k.a(th));
        }
        f12745a = lc.j.g(objB);
    }

    public static final boolean a() {
        return f12745a;
    }
}
