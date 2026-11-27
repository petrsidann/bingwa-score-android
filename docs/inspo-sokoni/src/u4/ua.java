package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ua implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s8 f16865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f16866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e9 f16868d;

    public ua(e9 e9Var, s8 s8Var, long j10, boolean z10) {
        this.f16865a = s8Var;
        this.f16866b = j10;
        this.f16867c = z10;
        this.f16868d = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16868d.Z(this.f16865a);
        e9.m0(this.f16868d, this.f16865a, this.f16866b, true, this.f16867c);
    }
}
