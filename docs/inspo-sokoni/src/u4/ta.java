package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s8 f16833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f16834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e9 f16836d;

    public ta(e9 e9Var, s8 s8Var, long j10, boolean z10) {
        this.f16833a = s8Var;
        this.f16834b = j10;
        this.f16835c = z10;
        this.f16836d = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16836d.Z(this.f16833a);
        e9.m0(this.f16836d, this.f16833a, this.f16834b, false, this.f16835c);
    }
}
