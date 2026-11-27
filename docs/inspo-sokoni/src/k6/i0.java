package k6;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0<T> implements Comparator<T> {
    public static <T> i0<T> a(Comparator<T> comparator) {
        return comparator instanceof i0 ? (i0) comparator : new k(comparator);
    }

    public static <C extends Comparable> i0<C> c() {
        return f0.f11547a;
    }

    public <E extends T> q<E> b(Iterable<E> iterable) {
        return q.D(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t10, T t11);

    public <T2 extends T> i0<Map.Entry<T2, ?>> d() {
        return (i0<Map.Entry<T2, ?>>) e(b0.b());
    }

    public <F> i0<F> e(j6.e<F, ? extends T> eVar) {
        return new f(eVar, this);
    }
}
