package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f9171a;

    public f1(e1 e1Var) {
        this.f9171a = e1Var;
    }

    @Override // gd.n
    public void g(Throwable th) {
        this.f9171a.d();
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        g(th);
        return lc.q.f12711a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f9171a + ']';
    }
}
