package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class r2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f9256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<lc.q> f9257b;

    /* JADX WARN: Multi-variable type inference failed */
    public r2(j0 j0Var, o<? super lc.q> oVar) {
        this.f9256a = j0Var;
        this.f9257b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9257b.i(this.f9256a, lc.q.f12711a);
    }
}
