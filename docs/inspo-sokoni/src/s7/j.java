package s7;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<K, V> implements h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f15603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f15604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h<K, V> f15605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h<K, V> f15606d;

    public j(K k10, V v10, h<K, V> hVar, h<K, V> hVar2) {
        this.f15603a = k10;
        this.f15604b = v10;
        this.f15605c = hVar == null ? g.i() : hVar;
        this.f15606d = hVar2 == null ? g.i() : hVar2;
    }

    public static h.a p(h hVar) {
        return hVar.d() ? h.a.BLACK : h.a.RED;
    }

    @Override // s7.h
    public h<K, V> a() {
        return this.f15605c;
    }

    @Override // s7.h
    public h<K, V> b(K k10, V v10, Comparator<K> comparator) {
        j<K, V> jVarK;
        int iCompare = comparator.compare(k10, this.f15603a);
        if (iCompare < 0) {
            jVarK = k(null, null, this.f15605c.b(k10, v10, comparator), null);
        } else {
            jVarK = iCompare == 0 ? k(k10, v10, null, null) : k(null, null, null, this.f15606d.b(k10, v10, comparator));
        }
        return jVarK.l();
    }

    @Override // s7.h
    public h<K, V> c(K k10, Comparator<K> comparator) {
        j<K, V> jVarK;
        if (comparator.compare(k10, this.f15603a) < 0) {
            j<K, V> jVarN = (this.f15605c.isEmpty() || this.f15605c.d() || ((j) this.f15605c).f15605c.d()) ? this : n();
            jVarK = jVarN.k(null, null, jVarN.f15605c.c(k10, comparator), null);
        } else {
            j<K, V> jVarS = this.f15605c.d() ? s() : this;
            if (!jVarS.f15606d.isEmpty() && !jVarS.f15606d.d() && !((j) jVarS.f15606d).f15605c.d()) {
                jVarS = jVarS.o();
            }
            if (comparator.compare(k10, jVarS.f15603a) == 0) {
                if (jVarS.f15606d.isEmpty()) {
                    return g.i();
                }
                h<K, V> hVarG = jVarS.f15606d.g();
                jVarS = jVarS.k(hVarG.getKey(), hVarG.getValue(), null, ((j) jVarS.f15606d).q());
            }
            jVarK = jVarS.k(null, null, null, jVarS.f15606d.c(k10, comparator));
        }
        return jVarK.l();
    }

    @Override // s7.h
    public h<K, V> f() {
        return this.f15606d;
    }

    @Override // s7.h
    public h<K, V> g() {
        return this.f15605c.isEmpty() ? this : this.f15605c.g();
    }

    @Override // s7.h
    public K getKey() {
        return this.f15603a;
    }

    @Override // s7.h
    public V getValue() {
        return this.f15604b;
    }

    @Override // s7.h
    public h<K, V> h() {
        return this.f15606d.isEmpty() ? this : this.f15606d.h();
    }

    public final j<K, V> i() {
        h<K, V> hVar = this.f15605c;
        h<K, V> hVarE = hVar.e(null, null, p(hVar), null, null);
        h<K, V> hVar2 = this.f15606d;
        return e(null, null, p(this), hVarE, hVar2.e(null, null, p(hVar2), null, null));
    }

    @Override // s7.h
    public boolean isEmpty() {
        return false;
    }

    @Override // s7.h
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public j<K, V> e(K k10, V v10, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        if (k10 == null) {
            k10 = this.f15603a;
        }
        if (v10 == null) {
            v10 = this.f15604b;
        }
        if (hVar == null) {
            hVar = this.f15605c;
        }
        if (hVar2 == null) {
            hVar2 = this.f15606d;
        }
        return aVar == h.a.RED ? new i(k10, v10, hVar, hVar2) : new f(k10, v10, hVar, hVar2);
    }

    public abstract j<K, V> k(K k10, V v10, h<K, V> hVar, h<K, V> hVar2);

    public final j<K, V> l() {
        j<K, V> jVarR = (!this.f15606d.d() || this.f15605c.d()) ? this : r();
        if (jVarR.f15605c.d() && ((j) jVarR.f15605c).f15605c.d()) {
            jVarR = jVarR.s();
        }
        return (jVarR.f15605c.d() && jVarR.f15606d.d()) ? jVarR.i() : jVarR;
    }

    public abstract h.a m();

    public final j<K, V> n() {
        j<K, V> jVarI = i();
        return jVarI.f().a().d() ? jVarI.k(null, null, null, ((j) jVarI.f()).s()).r().i() : jVarI;
    }

    public final j<K, V> o() {
        j<K, V> jVarI = i();
        return jVarI.a().a().d() ? jVarI.s().i() : jVarI;
    }

    public final h<K, V> q() {
        if (this.f15605c.isEmpty()) {
            return g.i();
        }
        j<K, V> jVarN = (a().d() || a().a().d()) ? this : n();
        return jVarN.k(null, null, ((j) jVarN.f15605c).q(), null).l();
    }

    public final j<K, V> r() {
        return (j) this.f15606d.e(null, null, m(), e(null, null, h.a.RED, null, ((j) this.f15606d).f15605c), null);
    }

    public final j<K, V> s() {
        return (j) this.f15605c.e(null, null, m(), null, e(null, null, h.a.RED, ((j) this.f15605c).f15606d, null));
    }

    public void t(h<K, V> hVar) {
        this.f15605c = hVar;
    }
}
