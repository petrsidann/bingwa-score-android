package u4;

/* JADX INFO: loaded from: classes.dex */
public final class nd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ jd f16617c;

    public nd(jd jdVar, long j10, long j11) {
        this.f16617c = jdVar;
        this.f16615a = j10;
        this.f16616b = j11;
    }

    public static /* synthetic */ void a(nd ndVar) {
        jd jdVar = ndVar.f16617c;
        long j10 = ndVar.f16615a;
        long j11 = ndVar.f16616b;
        jdVar.f16406b.j();
        jdVar.f16406b.zzj().B().a("Application going to the background");
        jdVar.f16406b.e().f16345u.a(true);
        jdVar.f16406b.A(true);
        if (!jdVar.f16406b.a().T()) {
            jdVar.f16406b.B(false, false, j11);
            jdVar.f16406b.f16368f.e(j11);
        }
        jdVar.f16406b.zzj().F().b("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
        jdVar.f16406b.n().B0();
        if (jdVar.f16406b.a().p(p0.N0)) {
            long jY = jdVar.f16406b.g().A0(jdVar.f16406b.zza().getPackageName(), jdVar.f16406b.a().R()) ? 1000L : jdVar.f16406b.a().y(jdVar.f16406b.zza().getPackageName(), p0.A);
            jdVar.f16406b.zzj().G().b("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jY));
            jdVar.f16406b.o().y(jY);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16617c.f16406b.zzl().y(new Runnable() { // from class: u4.md
            @Override // java.lang.Runnable
            public final void run() {
                nd.a(this.f16527a);
            }
        });
    }
}
