package ub;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements AutoCloseable {
    public e(String str) {
        d(str);
    }

    public static void d(String str) {
        e2.a.c(k(str));
    }

    public static void e(String str, int i10) {
        e2.a.a(k(str), i10);
    }

    public static String k(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void t() {
        e2.a.f();
    }

    public static void v(String str, int i10) {
        e2.a.d(k(str), i10);
    }

    public static e z(String str) {
        return new e(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        t();
    }
}
