package u4;

/* JADX INFO: loaded from: classes.dex */
public final class kd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ id f16465b;

    public kd(id idVar, long j10) {
        this.f16464a = j10;
        this.f16465b = idVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        id.z(this.f16465b, this.f16464a);
    }
}
