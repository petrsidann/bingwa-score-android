package u4;

/* JADX INFO: loaded from: classes.dex */
public final class vc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f5 f16914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uc f16915b;

    public vc(uc ucVar, f5 f5Var) {
        this.f16914a = f5Var;
        this.f16915b = ucVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16915b) {
            this.f16915b.f16873a = false;
            if (!this.f16915b.f16875c.g0()) {
                this.f16915b.f16875c.zzj().B().a("Connected to remote service");
                this.f16915b.f16875c.N(this.f16914a);
            }
        }
    }
}
