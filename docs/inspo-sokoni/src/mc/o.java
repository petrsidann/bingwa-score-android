package mc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class o extends n {
    public static final <T> ArrayList<T> e(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new f(elements, true));
    }

    public static final <T> Collection<T> f(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new f(tArr, false);
    }

    public static final <T> List<T> g() {
        return y.f13318a;
    }

    public static final <T> int h(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static final <T> List<T> i(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length > 0 ? j.c(elements) : g();
    }

    public static final <T> List<T> j(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return k.l(elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> k(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : n.b(list.get(0));
        }
        return g();
    }

    public static final void l() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
