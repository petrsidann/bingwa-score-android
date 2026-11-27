package gd;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j {
    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    public static final <T> T a(oc.i iVar, xc.p<? super m0, ? super oc.e<? super T>, ? extends Object> pVar) {
        i1 i1VarA;
        r1 r1Var;
        Thread threadCurrentThread = Thread.currentThread();
        oc.f fVar = (oc.f) iVar.get(oc.f.f13810k);
        if (fVar == null) {
            i1VarA = w2.f9268a.b();
            r1Var = r1.f9255a;
            iVar = iVar.plus(i1VarA);
        } else {
            i1 i1Var = fVar instanceof i1 ? (i1) fVar : null;
            if (i1Var == null) {
                i1VarA = w2.f9268a.a();
            } else {
                i1 i1Var2 = i1Var.q0() ? i1Var : null;
                if (i1Var2 == null) {
                    i1VarA = w2.f9268a.a();
                } else {
                    i1VarA = i1Var2;
                }
            }
            r1Var = r1.f9255a;
        }
        g gVar = new g(i0.d(r1Var, iVar), threadCurrentThread, i1VarA);
        gVar.P0(o0.DEFAULT, gVar, pVar);
        return (T) gVar.Q0();
    }

    public static /* synthetic */ Object b(oc.i iVar, xc.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = oc.j.f13812a;
        }
        return i.e(iVar, pVar);
    }
}
