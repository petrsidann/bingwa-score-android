package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    public static final m0 a(oc.i iVar) {
        if (iVar.get(y1.f9273i) == null) {
            iVar = iVar.plus(e2.b(null, 1, null));
        }
        return new ld.f(iVar);
    }

    public static final m0 b() {
        return new ld.f(u2.b(null, 1, null).plus(c1.c()));
    }

    public static final <R> Object c(xc.p<? super m0, ? super oc.e<? super R>, ? extends Object> pVar, oc.e<? super R> eVar) {
        ld.d0 d0Var = new ld.d0(eVar.getContext(), eVar);
        Object objB = md.b.b(d0Var, d0Var, pVar);
        if (objB == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objB;
    }

    public static final void d(m0 m0Var) {
        c2.i(m0Var.f());
    }

    public static final boolean e(m0 m0Var) {
        y1 y1Var = (y1) m0Var.f().get(y1.f9273i);
        if (y1Var != null) {
            return y1Var.isActive();
        }
        return true;
    }
}
