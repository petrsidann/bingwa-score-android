package mc;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends d0 {
    public static final <K, V> Map<K, V> d() {
        z zVar = z.f13319a;
        kotlin.jvm.internal.k.c(zVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return zVar;
    }

    public static final <K, V> HashMap<K, V> e(lc.i<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.k.e(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(d0.a(pairs.length));
        j(map, pairs);
        return map;
    }

    public static final <K, V> Map<K, V> f(lc.i<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.k.e(pairs, "pairs");
        return pairs.length > 0 ? n(pairs, new LinkedHashMap(d0.a(pairs.length))) : d();
    }

    public static final <K, V> Map<K, V> g(lc.i<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.k.e(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.a(pairs.length));
        j(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> h(Map<K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : d0.c(map);
        }
        return d();
    }

    public static final <K, V> void i(Map<? super K, ? super V> map, Iterable<? extends lc.i<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.k.e(map, "<this>");
        kotlin.jvm.internal.k.e(pairs, "pairs");
        for (lc.i<? extends K, ? extends V> iVar : pairs) {
            map.put(iVar.a(), iVar.b());
        }
    }

    public static final <K, V> void j(Map<? super K, ? super V> map, lc.i<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.k.e(map, "<this>");
        kotlin.jvm.internal.k.e(pairs, "pairs");
        for (lc.i<? extends K, ? extends V> iVar : pairs) {
            map.put(iVar.a(), iVar.b());
        }
    }

    public static final <K, V> Map<K, V> k(Iterable<? extends lc.i<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return h(l(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return l(iterable, new LinkedHashMap(d0.a(collection.size())));
        }
        return d0.b((lc.i) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M l(Iterable<? extends lc.i<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        i(destination, iterable);
        return destination;
    }

    public static final <K, V> Map<K, V> m(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? o(map) : d0.c(map);
        }
        return d();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M n(lc.i<? extends K, ? extends V>[] iVarArr, M destination) {
        kotlin.jvm.internal.k.e(iVarArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        j(destination, iVarArr);
        return destination;
    }

    public static final <K, V> Map<K, V> o(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
