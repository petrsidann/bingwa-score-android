package u4;

/* JADX INFO: loaded from: classes.dex */
public final class td {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j4.d f16840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16841b;

    public td(j4.d dVar) {
        com.google.android.gms.common.internal.r.l(dVar);
        this.f16840a = dVar;
    }

    public final void a() {
        this.f16841b = 0L;
    }

    public final boolean b(long j10) {
        return this.f16841b == 0 || this.f16840a.b() - this.f16841b >= 3600000;
    }

    public final void c() {
        this.f16841b = this.f16840a.b();
    }
}
