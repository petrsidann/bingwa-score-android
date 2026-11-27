package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ob implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hb f16628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f16629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kb f16630c;

    public ob(kb kbVar, hb hbVar, long j10) {
        this.f16628a = hbVar;
        this.f16629b = j10;
        this.f16630c = kbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16630c.G(this.f16628a, false, this.f16629b);
        kb kbVar = this.f16630c;
        kbVar.f16454e = null;
        kbVar.q().P(null);
    }
}
