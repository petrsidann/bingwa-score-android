package u4;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q8 f16061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f16062b;

    public c0(d0 d0Var, q8 q8Var) {
        this.f16061a = q8Var;
        this.f16062b = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16061a.zzd();
        if (g.a()) {
            this.f16061a.zzl().y(this);
            return;
        }
        boolean zE = this.f16062b.e();
        this.f16062b.f16084c = 0L;
        if (zE) {
            this.f16062b.d();
        }
    }
}
