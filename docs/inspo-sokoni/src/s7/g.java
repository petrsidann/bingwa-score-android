package s7;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class g<K, V> implements h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f15599a = new g();

    public static <K, V> g<K, V> i() {
        return f15599a;
    }

    @Override // s7.h
    public h<K, V> a() {
        return this;
    }

    @Override // s7.h
    public h<K, V> b(K k10, V v10, Comparator<K> comparator) {
        return new i(k10, v10);
    }

    @Override // s7.h
    public h<K, V> c(K k10, Comparator<K> comparator) {
        return this;
    }

    @Override // s7.h
    public boolean d() {
        return false;
    }

    @Override // s7.h
    public h<K, V> e(K k10, V v10, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        return this;
    }

    @Override // s7.h
    public h<K, V> f() {
        return this;
    }

    @Override // s7.h
    public h<K, V> g() {
        return this;
    }

    @Override // s7.h
    public K getKey() {
        return null;
    }

    @Override // s7.h
    public V getValue() {
        return null;
    }

    @Override // s7.h
    public h<K, V> h() {
        return this;
    }

    @Override // s7.h
    public boolean isEmpty() {
        return true;
    }

    @Override // s7.h
    public int size() {
        return 0;
    }
}
