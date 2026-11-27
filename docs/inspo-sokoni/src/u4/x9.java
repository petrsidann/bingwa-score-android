package u4;

/* JADX INFO: loaded from: classes.dex */
public final class x9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16955b;

    public x9(e9 e9Var, boolean z10) {
        this.f16954a = z10;
        this.f16955b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zN = this.f16955b.f16624a.n();
        boolean zM = this.f16955b.f16624a.m();
        this.f16955b.f16624a.i(this.f16954a);
        if (zM == this.f16954a) {
            this.f16955b.f16624a.zzj().G().b("Default data collection state already set to", Boolean.valueOf(this.f16954a));
        }
        if (this.f16955b.f16624a.n() == zN || this.f16955b.f16624a.n() != this.f16955b.f16624a.m()) {
            this.f16955b.f16624a.zzj().I().c("Default data collection is different than actual status", Boolean.valueOf(this.f16954a), Boolean.valueOf(zN));
        }
        this.f16955b.L0();
    }
}
