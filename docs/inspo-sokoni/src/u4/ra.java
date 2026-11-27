package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ra implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f16759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16760b;

    public ra(e9 e9Var, f0 f0Var) {
        this.f16759a = f0Var;
        this.f16760b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f16760b.e().v(this.f16759a)) {
            this.f16760b.zzj().F().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.f16759a.a()));
            return;
        }
        this.f16760b.zzj().G().b("Setting DMA consent(FE)", this.f16759a);
        if (this.f16760b.q().j0()) {
            this.f16760b.q().e0();
        } else {
            this.f16760b.q().W(false);
        }
    }
}
