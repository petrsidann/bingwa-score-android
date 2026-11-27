package id;

import gd.d3;
import ld.q0;
import ld.z;

/* JADX INFO: loaded from: classes2.dex */
public class o<E> extends b<E> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f10631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f10632s;

    public o(int i10, a aVar, xc.l<? super E, lc.q> lVar) {
        super(i10, lVar);
        this.f10631r = i10;
        this.f10632s = aVar;
        if (!(aVar != a.SUSPEND)) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.u.b(b.class).b() + " instead").toString());
        }
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    public static /* synthetic */ <E> Object G0(o<E> oVar, E e10, oc.e<? super lc.q> eVar) throws Throwable {
        q0 q0VarD;
        Object objJ0 = oVar.J0(e10, true);
        if (!(objJ0 instanceof h.a)) {
            return lc.q.f12711a;
        }
        h.e(objJ0);
        xc.l<E, lc.q> lVar = oVar.f10588b;
        if (lVar == null || (q0VarD = z.d(lVar, e10, null, 2, null)) == null) {
            throw oVar.M();
        }
        lc.a.a(q0VarD, oVar.M());
        throw q0VarD;
    }

    public final Object H0(E e10, boolean z10) {
        xc.l<E, lc.q> lVar;
        q0 q0VarD;
        Object objL = super.l(e10);
        if (h.i(objL) || h.h(objL)) {
            return objL;
        }
        if (!z10 || (lVar = this.f10588b) == null || (q0VarD = z.d(lVar, e10, null, 2, null)) == null) {
            return h.f10625b.c(lc.q.f12711a);
        }
        throw q0VarD;
    }

    public final Object I0(E e10) {
        j jVar;
        Object obj = c.f10602d;
        j jVar2 = (j) b.f10582m.get(this);
        while (true) {
            long andIncrement = b.f10578d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zW = W(andIncrement);
            int i10 = c.f10600b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar2.f12721c != j11) {
                j jVarH = H(j11, jVar2);
                if (jVarH != null) {
                    jVar = jVarH;
                } else if (zW) {
                    return h.f10625b.a(M());
                }
            } else {
                jVar = jVar2;
            }
            int iB0 = B0(jVar, i11, e10, j10, obj, zW);
            if (iB0 == 0) {
                jVar.b();
                return h.f10625b.c(lc.q.f12711a);
            }
            if (iB0 == 1) {
                return h.f10625b.c(lc.q.f12711a);
            }
            if (iB0 == 2) {
                if (zW) {
                    jVar.p();
                    return h.f10625b.a(M());
                }
                d3 d3Var = obj instanceof d3 ? (d3) obj : null;
                if (d3Var != null) {
                    l0(d3Var, jVar, i11);
                }
                D((jVar.f12721c * ((long) i10)) + ((long) i11));
                return h.f10625b.c(lc.q.f12711a);
            }
            if (iB0 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iB0 == 4) {
                if (j10 < L()) {
                    jVar.b();
                }
                return h.f10625b.a(M());
            }
            if (iB0 == 5) {
                jVar.b();
            }
            jVar2 = jVar;
        }
    }

    public final Object J0(E e10, boolean z10) {
        return this.f10632s == a.DROP_LATEST ? H0(e10, z10) : I0(e10);
    }

    @Override // id.b
    public boolean X() {
        return this.f10632s == a.DROP_OLDEST;
    }

    @Override // id.b, id.u
    public Object d(E e10, oc.e<? super lc.q> eVar) {
        return G0(this, e10, eVar);
    }

    @Override // id.b, id.u
    public Object l(E e10) {
        return J0(e10, false);
    }
}
