package mc;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h0 extends g0 {
    public static final <T> Set<T> b() {
        return a0.f13283a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        kotlin.jvm.internal.k.e(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : g0.a(set.iterator().next());
        }
        return b();
    }

    public static final <T> Set<T> d(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return k.b0(elements);
    }
}
