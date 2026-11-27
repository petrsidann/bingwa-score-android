package p;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f13908e = new HashMap<>();

    public boolean contains(K k10) {
        return this.f13908e.containsKey(k10);
    }

    @Override // p.b
    public b.c<K, V> h(K k10) {
        return this.f13908e.get(k10);
    }

    @Override // p.b
    public V l(K k10, V v10) {
        b.c<K, V> cVarH = h(k10);
        if (cVarH != null) {
            return cVarH.f13914b;
        }
        this.f13908e.put(k10, k(k10, v10));
        return null;
    }

    @Override // p.b
    public V n(K k10) {
        V v10 = (V) super.n(k10);
        this.f13908e.remove(k10);
        return v10;
    }

    public Map.Entry<K, V> o(K k10) {
        if (contains(k10)) {
            return this.f13908e.get(k10).f13916d;
        }
        return null;
    }
}
