package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class pd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f16716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ id f16717d;

    public pd(id idVar) {
        this.f16717d = idVar;
        this.f16716c = new od(this, idVar.f16624a);
        long jB = idVar.zzb().b();
        this.f16714a = jB;
        this.f16715b = jB;
    }

    public static /* synthetic */ void c(pd pdVar) {
        pdVar.f16717d.j();
        pdVar.d(false, false, pdVar.f16717d.zzb().b());
        pdVar.f16717d.k().s(pdVar.f16717d.zzb().b());
    }

    public final long a(long j10) {
        long j11 = j10 - this.f16715b;
        this.f16715b = j10;
        return j11;
    }

    public final void b() {
        this.f16716c.a();
        this.f16714a = this.f16717d.a().p(p0.X0) ? this.f16717d.zzb().b() : 0L;
        this.f16715b = this.f16714a;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f16717d.j();
        this.f16717d.u();
        if (this.f16717d.f16624a.n()) {
            this.f16717d.e().f16342r.b(this.f16717d.zzb().a());
        }
        long jA = j10 - this.f16714a;
        if (!z10 && jA < 1000) {
            this.f16717d.zzj().G().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jA));
            return false;
        }
        if (!z11) {
            jA = a(j10);
        }
        this.f16717d.zzj().G().b("Recording user engagement, ms", Long.valueOf(jA));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jA);
        af.U(this.f16717d.p().z(!this.f16717d.a().T()), bundle, true);
        if (!z11) {
            this.f16717d.n().a1("auto", "_e", bundle);
        }
        this.f16714a = j10;
        this.f16716c.a();
        this.f16716c.b(p0.f16664l0.a(null).longValue());
        return true;
    }

    public final void e(long j10) {
        this.f16716c.a();
    }

    public final void f(long j10) {
        this.f16717d.j();
        this.f16716c.a();
        this.f16714a = j10;
        this.f16715b = j10;
    }
}
