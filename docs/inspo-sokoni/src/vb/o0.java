package vb;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f17465a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l6.a f17466b = a1.f17242f;

    public interface a<T> extends a1.j<T> {
    }

    public static int a(a1 a1Var) {
        return a1Var.h();
    }

    public static <T> a1.g<T> b(String str, a<T> aVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return a1.g.g(str, z10, aVar);
    }

    public static a1 c(byte[]... bArr) {
        return new a1(bArr);
    }

    public static byte[][] d(a1 a1Var) {
        return a1Var.q();
    }
}
