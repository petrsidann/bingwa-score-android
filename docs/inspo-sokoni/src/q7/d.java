package q7;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    default <T> T a(Class<T> cls) {
        return (T) h(e0.b(cls));
    }

    <T> o8.b<T> b(e0<T> e0Var);

    default <T> o8.b<T> c(Class<T> cls) {
        return b(e0.b(cls));
    }

    <T> o8.a<T> d(e0<T> e0Var);

    default <T> Set<T> e(Class<T> cls) {
        return g(e0.b(cls));
    }

    <T> o8.b<Set<T>> f(e0<T> e0Var);

    default <T> Set<T> g(e0<T> e0Var) {
        return f(e0Var).get();
    }

    default <T> T h(e0<T> e0Var) {
        o8.b<T> bVarB = b(e0Var);
        if (bVarB == null) {
            return null;
        }
        return bVarB.get();
    }

    default <T> o8.a<T> i(Class<T> cls) {
        return d(e0.b(cls));
    }
}
