package s7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<K, V> implements Iterable<Map.Entry<K, V>> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0276a f15593a = new InterfaceC0276a() { // from class: s7.b
            @Override // s7.c.a.InterfaceC0276a
            public final Object a(Object obj) {
                return c.a.e(obj);
            }
        };

        /* JADX INFO: renamed from: s7.c$a$a, reason: collision with other inner class name */
        public interface InterfaceC0276a<C, D> {
            D a(C c10);
        }

        public static <A, B, C> c<A, C> b(List<A> list, Map<B, C> map, InterfaceC0276a<A, B> interfaceC0276a, Comparator<A> comparator) {
            return list.size() < 25 ? s7.a.t(list, map, interfaceC0276a, comparator) : k.q(list, map, interfaceC0276a, comparator);
        }

        public static <K, V> c<K, V> c(Comparator<K> comparator) {
            return new s7.a(comparator);
        }

        public static <A> InterfaceC0276a<A, A> d() {
            return f15593a;
        }

        public static /* synthetic */ Object e(Object obj) {
            return obj;
        }
    }

    public abstract boolean e(K k10);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!i().equals(cVar.i()) || size() != cVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = cVar.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract V h(K k10);

    public int hashCode() {
        int iHashCode = i().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public abstract Comparator<K> i();

    public abstract int indexOf(K k10);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract K j();

    public abstract K k();

    public abstract c<K, V> l(K k10, V v10);

    public abstract Iterator<Map.Entry<K, V>> n(K k10);

    public abstract c<K, V> o(K k10);

    public abstract int size();

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        boolean z10 = true;
        for (Map.Entry<K, V> entry : this) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append("(");
            sb2.append(entry.getKey());
            sb2.append("=>");
            sb2.append(entry.getValue());
            sb2.append(")");
        }
        sb2.append("};");
        return sb2.toString();
    }
}
