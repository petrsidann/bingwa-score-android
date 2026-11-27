package ae;

import td.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f515a;

    public static b e() {
        if (f515a == null) {
            f515a = new b();
        }
        return f515a;
    }

    public final a a(String str, a aVar) {
        c.a().b(str, aVar);
        return aVar;
    }

    public a b(String str, String str2, String str3, Exception exc) {
        return a(str, new a(str2, String.format("%s", exc.getLocalizedMessage()), str3, exc));
    }

    public a c(String str, String str2, String str3, String str4) {
        return a(str, new a(str2, str3, str4));
    }

    public a d(String str, String str2, String str3, String str4, Exception exc) {
        return a(str, new a(str2, str3, str4, exc));
    }

    public final void f(String str, a aVar) {
        c.a().b(str, aVar);
    }

    public void g(String str, String str2, String str3, Exception exc) {
        f(str, new a(str2, String.format("%s", exc.getLocalizedMessage()), str3, exc));
    }

    public void h(String str, String str2, String str3, String str4) {
        f(str, new a(str2, str3, str4));
    }

    public void i(String str, String str2, String str3, String str4, Exception exc) {
        f(str, new a(str2, str3, str4, exc));
    }
}
