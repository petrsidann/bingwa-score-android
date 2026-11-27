package gd;

/* JADX INFO: loaded from: classes2.dex */
public class u0<T> extends a<T> implements t0<T> {
    public u0(oc.i iVar, boolean z10) {
        super(iVar, true, z10);
    }

    public static /* synthetic */ <T> Object Q0(u0<T> u0Var, oc.e<? super T> eVar) throws Throwable {
        Object objY = u0Var.y(eVar);
        pc.c.c();
        return objY;
    }

    @Override // gd.t0
    public Object await(oc.e<? super T> eVar) {
        return Q0(this, eVar);
    }

    @Override // gd.t0
    public T getCompleted() {
        return (T) V();
    }
}
