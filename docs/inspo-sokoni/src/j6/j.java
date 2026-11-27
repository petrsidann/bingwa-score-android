package j6;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<T> implements Serializable {
    public static <T> j<T> a() {
        return a.h();
    }

    public static <T> j<T> b(T t10) {
        return t10 == null ? a() : new n(t10);
    }

    public static <T> j<T> e(T t10) {
        return new n(m.o(t10));
    }

    public abstract T c();

    public abstract boolean d();

    public abstract T f(T t10);

    public abstract T g();
}
