package gd;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k {
    public static final <T> t0<T> a(m0 m0Var, oc.i iVar, o0 o0Var, xc.p<? super m0, ? super oc.e<? super T>, ? extends Object> pVar) {
        oc.i iVarD = i0.d(m0Var, iVar);
        u0 i2Var = o0Var.i() ? new i2(iVarD, pVar) : new u0(iVarD, true);
        ((a) i2Var).P0(o0Var, i2Var, pVar);
        return (t0<T>) i2Var;
    }

    public static /* synthetic */ t0 b(m0 m0Var, oc.i iVar, o0 o0Var, xc.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = oc.j.f13812a;
        }
        if ((i10 & 2) != 0) {
            o0Var = o0.DEFAULT;
        }
        return i.a(m0Var, iVar, o0Var, pVar);
    }

    public static final y1 c(m0 m0Var, oc.i iVar, o0 o0Var, xc.p<? super m0, ? super oc.e<? super lc.q>, ? extends Object> pVar) {
        oc.i iVarD = i0.d(m0Var, iVar);
        a j2Var = o0Var.i() ? new j2(iVarD, pVar) : new s2(iVarD, true);
        j2Var.P0(o0Var, j2Var, pVar);
        return j2Var;
    }

    public static /* synthetic */ y1 d(m0 m0Var, oc.i iVar, o0 o0Var, xc.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = oc.j.f13812a;
        }
        if ((i10 & 2) != 0) {
            o0Var = o0.DEFAULT;
        }
        return i.c(m0Var, iVar, o0Var, pVar);
    }

    public static final <T> Object e(oc.i iVar, xc.p<? super m0, ? super oc.e<? super T>, ? extends Object> pVar, oc.e<? super T> eVar) throws Throwable {
        Object objQ0;
        oc.i context = eVar.getContext();
        oc.i iVarE = i0.e(context, iVar);
        c2.i(iVarE);
        if (iVarE == context) {
            ld.d0 d0Var = new ld.d0(iVarE, eVar);
            objQ0 = md.b.b(d0Var, d0Var, pVar);
        } else {
            oc.f.b bVar = oc.f.f13810k;
            if (kotlin.jvm.internal.k.a(iVarE.get(bVar), context.get(bVar))) {
                b3 b3Var = new b3(iVarE, eVar);
                oc.i context2 = b3Var.getContext();
                Object objC = ld.l0.c(context2, null);
                try {
                    Object objB = md.b.b(b3Var, b3Var, pVar);
                    ld.l0.a(context2, objC);
                    objQ0 = objB;
                } catch (Throwable th) {
                    ld.l0.a(context2, objC);
                    throw th;
                }
            } else {
                y0 y0Var = new y0(iVarE, eVar);
                md.a.d(pVar, y0Var, y0Var, null, 4, null);
                objQ0 = y0Var.Q0();
            }
        }
        if (objQ0 == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objQ0;
    }
}
