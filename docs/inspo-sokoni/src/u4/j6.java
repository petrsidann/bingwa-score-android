package u4;

/* JADX INFO: loaded from: classes.dex */
public final class j6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f6 f16389b;

    public j6(f6 f6Var, boolean z10) {
        this.f16388a = z10;
        this.f16389b = f6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16389b.f16183a.M(this.f16388a);
    }
}
