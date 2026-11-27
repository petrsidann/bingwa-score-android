package s7;

/* JADX INFO: loaded from: classes.dex */
public class f<K, V> extends j<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15598e;

    public f(K k10, V v10, h<K, V> hVar, h<K, V> hVar2) {
        super(k10, v10, hVar, hVar2);
        this.f15598e = -1;
    }

    @Override // s7.h
    public boolean d() {
        return false;
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
        return new f(k10, v10, hVar, hVar2);
    }

    @Override // s7.j
    public h.a m() {
        return h.a.BLACK;
    }

    @Override // s7.h
    public int size() {
        if (this.f15598e == -1) {
            this.f15598e = a().size() + 1 + f().size();
        }
        return this.f15598e;
    }

    @Override // s7.j
    public void t(h<K, V> hVar) {
        if (this.f15598e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.t(hVar);
    }
}
