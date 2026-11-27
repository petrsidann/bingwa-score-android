package u4;

/* JADX INFO: loaded from: classes.dex */
public final class bc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ze f16049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qb f16050d;

    public bc(qb qbVar, me meVar, boolean z10, ze zeVar) {
        this.f16047a = meVar;
        this.f16048b = z10;
        this.f16049c = zeVar;
        this.f16050d = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        f5 f5Var = this.f16050d.f16738d;
        if (f5Var == null) {
            this.f16050d.zzj().C().a("Discarding data. Failed to set user property");
            return;
        }
        com.google.android.gms.common.internal.r.l(this.f16047a);
        this.f16050d.O(f5Var, this.f16048b ? null : this.f16049c, this.f16047a);
        this.f16050d.m0();
    }
}
