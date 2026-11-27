package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class b3<T> extends ld.d0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal<lc.i<oc.i, Object>> f9141e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public b3(oc.i iVar, oc.e<? super T> eVar) {
        c3 c3Var = c3.f9148a;
        super(iVar.get(c3Var) == null ? iVar.plus(c3Var) : iVar, eVar);
        this.f9141e = new ThreadLocal<>();
        if (eVar.getContext().get(oc.f.f13810k) instanceof j0) {
            return;
        }
        Object objC = ld.l0.c(iVar, null);
        ld.l0.a(iVar, objC);
        R0(iVar, objC);
    }

    @Override // ld.d0, gd.a
    public void M0(Object obj) {
        if (this.threadLocalIsSet) {
            lc.i<oc.i, Object> iVar = this.f9141e.get();
            if (iVar != null) {
                ld.l0.a(iVar.a(), iVar.b());
            }
            this.f9141e.remove();
        }
        Object objA = g0.a(obj, this.f12717d);
        oc.e<T> eVar = this.f12717d;
        oc.i context = eVar.getContext();
        Object objC = ld.l0.c(context, null);
        b3<?> b3VarG = objC != ld.l0.f12738a ? i0.g(eVar, context, objC) : null;
        try {
            this.f12717d.resumeWith(objA);
            lc.q qVar = lc.q.f12711a;
        } finally {
            if (b3VarG == null || b3VarG.Q0()) {
                ld.l0.a(context, objC);
            }
        }
    }

    public final boolean Q0() {
        boolean z10 = this.threadLocalIsSet && this.f9141e.get() == null;
        this.f9141e.remove();
        return !z10;
    }

    public final void R0(oc.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f9141e.set(lc.m.a(iVar, obj));
    }
}
