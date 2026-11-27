package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final void a(o<?> oVar, e1 e1Var) {
        oVar.g(new f1(e1Var));
    }

    public static final <T> p<T> b(oc.e<? super T> eVar) {
        if (!(eVar instanceof ld.j)) {
            return new p<>(eVar, 1);
        }
        p<T> pVarO = ((ld.j) eVar).o();
        if (pVarO != null) {
            if (!pVarO.K()) {
                pVarO = null;
            }
            if (pVarO != null) {
                return pVarO;
            }
        }
        return new p<>(eVar, 2);
    }
}
