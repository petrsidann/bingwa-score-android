package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class a3 extends j0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a3 f9133c = new a3();

    @Override // gd.j0
    public void c0(oc.i iVar, Runnable runnable) {
        e3 e3Var = (e3) iVar.get(e3.f9161c);
        if (e3Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        e3Var.f9162b = true;
    }

    @Override // gd.j0
    public boolean d0(oc.i iVar) {
        return false;
    }

    @Override // gd.j0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
