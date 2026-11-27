package id;

import gd.d3;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ld.e0;
import ld.z;

/* JADX INFO: loaded from: classes2.dex */
public final class j<E> extends e0<j<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b<E> f10629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f10630f;

    public j(long j10, j<E> jVar, b<E> bVar, int i10) {
        super(j10, jVar, i10);
        this.f10629e = bVar;
        this.f10630f = new AtomicReferenceArray(c.f10600b * 2);
    }

    public final void A(int i10, Object obj) {
        this.f10630f.set((i10 * 2) + 1, obj);
    }

    public final void B(int i10, E e10) {
        z(i10, e10);
    }

    @Override // ld.e0
    public int n() {
        return c.f10600b;
    }

    @Override // ld.e0
    public void o(int i10, Throwable th, oc.i iVar) throws IllegalAccessException, InvocationTargetException {
        xc.l<E, lc.q> lVar;
        xc.l<E, lc.q> lVar2;
        int i11 = c.f10600b;
        boolean z10 = i10 >= i11;
        if (z10) {
            i10 -= i11;
        }
        E eV = v(i10);
        while (true) {
            Object objW = w(i10);
            if ((objW instanceof d3) || (objW instanceof v)) {
                if (r(i10, objW, z10 ? c.f10608j : c.f10609k)) {
                    s(i10);
                    x(i10, !z10);
                    if (!z10 || (lVar = u().f10588b) == null) {
                        return;
                    }
                    z.b(lVar, eV, iVar);
                    return;
                }
            } else {
                if (objW == c.f10608j || objW == c.f10609k) {
                    break;
                }
                if (objW != c.f10605g && objW != c.f10604f) {
                    if (objW == c.f10607i || objW == c.f10602d || objW == c.z()) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + objW).toString());
                }
            }
        }
        s(i10);
        if (!z10 || (lVar2 = u().f10588b) == null) {
            return;
        }
        z.b(lVar2, eV, iVar);
    }

    public final boolean r(int i10, Object obj, Object obj2) {
        return i.a(this.f10630f, (i10 * 2) + 1, obj, obj2);
    }

    public final void s(int i10) {
        z(i10, null);
    }

    public final Object t(int i10, Object obj) {
        return this.f10630f.getAndSet((i10 * 2) + 1, obj);
    }

    public final b<E> u() {
        b<E> bVar = this.f10629e;
        kotlin.jvm.internal.k.b(bVar);
        return bVar;
    }

    public final E v(int i10) {
        return (E) this.f10630f.get(i10 * 2);
    }

    public final Object w(int i10) {
        return this.f10630f.get((i10 * 2) + 1);
    }

    public final void x(int i10, boolean z10) {
        if (z10) {
            u().F0((this.f12721c * ((long) c.f10600b)) + ((long) i10));
        }
        p();
    }

    public final E y(int i10) {
        E eV = v(i10);
        s(i10);
        return eV;
    }

    public final void z(int i10, Object obj) {
        this.f10630f.lazySet(i10 * 2, obj);
    }
}
