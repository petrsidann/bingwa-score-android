package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class y<T> extends g2 implements x<T> {
    public y(y1 y1Var) {
        super(true);
        g0(y1Var);
    }

    @Override // gd.x
    public boolean E(Throwable th) {
        return l0(new c0(th, false, 2, null));
    }

    @Override // gd.x
    public boolean G(T t10) {
        return l0(t10);
    }

    @Override // gd.g2
    public boolean a0() {
        return true;
    }

    @Override // gd.t0
    public Object await(oc.e<? super T> eVar) throws Throwable {
        Object objY = y(eVar);
        pc.c.c();
        return objY;
    }

    @Override // gd.t0
    public T getCompleted() {
        return (T) V();
    }

    @Override // gd.t0
    public od.c<T> getOnAwait() {
        od.c<T> cVar = (od.c<T>) Z();
        kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return cVar;
    }
}
