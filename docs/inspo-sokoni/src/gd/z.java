package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    public static final <T> x<T> a(y1 y1Var) {
        return new y(y1Var);
    }

    public static /* synthetic */ x b(y1 y1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            y1Var = null;
        }
        return a(y1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean c(x<T> xVar, Object obj) {
        Throwable thD = lc.j.d(obj);
        return thD == null ? xVar.G(obj) : xVar.E(thD);
    }
}
