package s7;

/* JADX INFO: loaded from: classes.dex */
public class i<K, V> extends j<K, V> {
    public i(K k10, V v10) {
        super(k10, v10, g.i(), g.i());
    }

    public i(K k10, V v10, h<K, V> hVar, h<K, V> hVar2) {
        super(k10, v10, hVar, hVar2);
    }

    @Override // s7.h
    public boolean d() {
        return true;
    }

    @Override // s7.j
    public j<K, V> k(K k10, V v10, h<K, V> hVar, h<K, V> hVar2) {
        if (k10 == null) {
            k10 = getKey();
        }
        if (v10 == null) {
            v10 = getValue();
        }
        if (hVar == null) {
            hVar = a();
        }
        if (hVar2 == null) {
            hVar2 = f();
        }
        return new i(k10, v10, hVar, hVar2);
    }

    @Override // s7.j
    public h.a m() {
        return h.a.RED;
    }

    @Override // s7.h
    public int size() {
        return a().size() + 1 + f().size();
    }
}
