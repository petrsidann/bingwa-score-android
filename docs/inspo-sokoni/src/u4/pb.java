package u4;

/* JADX INFO: loaded from: classes.dex */
public final class pb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kb f16707b;

    public pb(kb kbVar, long j10) {
        this.f16706a = j10;
        this.f16707b = kbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16707b.k().s(this.f16706a);
        this.f16707b.f16454e = null;
    }
}
