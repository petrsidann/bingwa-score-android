package u4;

/* JADX INFO: loaded from: classes.dex */
public final class tc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f5 f16838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uc f16839b;

    public tc(uc ucVar, f5 f5Var) {
        this.f16838a = f5Var;
        this.f16839b = ucVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16839b) {
            this.f16839b.f16873a = false;
            if (!this.f16839b.f16875c.g0()) {
                this.f16839b.f16875c.zzj().G().a("Connected to service");
                this.f16839b.f16875c.N(this.f16838a);
            }
        }
    }
}
