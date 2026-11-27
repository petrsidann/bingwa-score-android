package t;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f<K, V> f15719m;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    public class C0284a extends f<K, V> {
        public C0284a() {
        }

        @Override // t.f
        public void a() {
            a.this.clear();
        }

        @Override // t.f
        public Object b(int i10, int i11) {
            return a.this.f15760b[(i10 << 1) + i11];
        }

        @Override // t.f
        public Map<K, V> c() {
            return a.this;
        }

        @Override // t.f
        public int d() {
            return a.this.f15761c;
        }

        @Override // t.f
        public int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // t.f
        public int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // t.f
        public void g(K k10, V v10) {
            a.this.put(k10, v10);
        }

        @Override // t.f
        public void h(int i10) {
            a.this.k(i10);
        }

        @Override // t.f
        public V i(int i10, V v10) {
            return a.this.l(i10, v10);
        }
    }

    public a() {
    }

    public a(int i10) {
        super(i10);
    }

    public a(g gVar) {
        super(gVar);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public final f<K, V> n() {
        if (this.f15719m == null) {
            this.f15719m = new C0284a();
        }
        return this.f15719m;
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f15761c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
