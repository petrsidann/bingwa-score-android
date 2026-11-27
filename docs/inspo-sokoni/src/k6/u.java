package k6;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class u<K, V> extends s<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient t<V> f11633c;

    public static final class a<K, V> extends s.a<K, V> {
        public u<K, V> a() {
            Collection collectionEntrySet = this.f11629a.entrySet();
            Comparator<? super K> comparator = this.f11630b;
            if (comparator != null) {
                collectionEntrySet = i0.a(comparator).d().b(collectionEntrySet);
            }
            return u.e(collectionEntrySet, this.f11631c);
        }
    }

    public u(r<K, t<V>> rVar, int i10, Comparator<? super V> comparator) {
        super(rVar, i10);
        this.f11633c = d(comparator);
    }

    public static <V> t<V> d(Comparator<? super V> comparator) {
        return comparator == null ? t.v() : v.G(comparator);
    }

    public static <K, V> u<K, V> e(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return f();
        }
        r.a aVar = new r.a(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            t tVarG = g(comparator, entry.getValue());
            if (!tVarG.isEmpty()) {
                aVar.f(key, tVarG);
                size += tVarG.size();
            }
        }
        return new u<>(aVar.c(), size, comparator);
    }

    public static <K, V> u<K, V> f() {
        return l.f11575d;
    }

    public static <V> t<V> g(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? t.r(collection) : v.C(comparator, collection);
    }
}
