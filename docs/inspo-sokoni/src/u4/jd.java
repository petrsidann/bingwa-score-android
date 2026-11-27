package u4;

/* JADX INFO: loaded from: classes.dex */
public final class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nd f16405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ id f16406b;

    public jd(id idVar) {
        this.f16406b = idVar;
    }

    public final void a() {
        this.f16406b.j();
        if (this.f16405a != null) {
            this.f16406b.f16365c.removeCallbacks(this.f16405a);
        }
        this.f16406b.e().f16345u.a(false);
        this.f16406b.A(false);
        if (this.f16406b.a().p(p0.U0) && this.f16406b.n().K0()) {
            this.f16406b.zzj().G().a("Retrying trigger URI registration in foreground");
            this.f16406b.n().I0();
        }
    }

    public final void b(long j10) {
        this.f16405a = new nd(this, this.f16406b.zzb().a(), j10);
        this.f16406b.f16365c.postDelayed(this.f16405a, 2000L);
    }
}
