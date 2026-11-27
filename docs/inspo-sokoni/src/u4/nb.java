package u4;

/* JADX INFO: loaded from: classes.dex */
public final class nb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hb f16604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hb f16605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f16606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kb f16608e;

    public nb(kb kbVar, hb hbVar, hb hbVar2, long j10, boolean z10) {
        this.f16604a = hbVar;
        this.f16605b = hbVar2;
        this.f16606c = j10;
        this.f16607d = z10;
        this.f16608e = kbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16608e.F(this.f16604a, this.f16605b, this.f16606c, this.f16607d, null);
    }
}
