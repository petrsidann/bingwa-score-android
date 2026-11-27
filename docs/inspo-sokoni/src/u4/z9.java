package u4;

/* JADX INFO: loaded from: classes.dex */
public final class z9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16999b;

    public z9(e9 e9Var, long j10) {
        this.f16998a = j10;
        this.f16999b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16999b.e().f16337m.b(this.f16998a);
        this.f16999b.zzj().B().b("Session timeout duration set", Long.valueOf(this.f16998a));
    }
}
