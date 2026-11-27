package u4;

/* JADX INFO: loaded from: classes.dex */
public final class hd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ id f16320b;

    public hd(id idVar, long j10) {
        this.f16319a = j10;
        this.f16320b = idVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        id.F(this.f16320b, this.f16319a);
    }
}
