package u4;

/* JADX INFO: loaded from: classes.dex */
public final class e3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f16128b;

    public e3(a aVar, long j10) {
        this.f16127a = j10;
        this.f16128b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16128b.y(this.f16127a);
    }
}
