package s7;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public interface h<K, V> {

    public enum a {
        RED,
        BLACK
    }

    h<K, V> a();

    h<K, V> b(K k10, V v10, Comparator<K> comparator);

    h<K, V> c(K k10, Comparator<K> comparator);

    boolean d();

    h<K, V> e(K k10, V v10, a aVar, h<K, V> hVar, h<K, V> hVar2);

    h<K, V> f();

    h<K, V> g();

    K getKey();

    V getValue();

    h<K, V> h();

    boolean isEmpty();

    int size();
}
