package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class z2 {
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0018, please report this as an issue */
    public static final x2 a(long j10, v0 v0Var, y1 y1Var) {
        String strJ;
        x0 x0Var = v0Var instanceof x0 ? (x0) v0Var : null;
        if (x0Var != null) {
            fd.a.C0144a c0144a = fd.a.f8310a;
            strJ = x0Var.J(fd.c.d(j10, fd.d.MILLISECONDS));
            if (strJ == null) {
                strJ = "Timed out waiting for " + j10 + " ms";
            }
        } else {
            strJ = "Timed out waiting for " + j10 + " ms";
        }
        return new x2(strJ, y1Var);
    }

    public static final <U, T extends U> Object b(y2<U, ? super T> y2Var, xc.p<? super m0, ? super oc.e<? super T>, ? extends Object> pVar) {
        c2.g(y2Var, w0.b(y2Var.f12717d.getContext()).k(y2Var.f9275e, y2Var, y2Var.getContext()));
        return md.b.c(y2Var, y2Var, pVar);
    }

    public static final <T> Object c(long j10, xc.p<? super m0, ? super oc.e<? super T>, ? extends Object> pVar, oc.e<? super T> eVar) {
        if (j10 <= 0) {
            throw new x2("Timed out immediately");
        }
        Object objB = b(new y2(j10, eVar), pVar);
        if (objB == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objB;
    }
}
