package u4;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzdj;

/* JADX INFO: loaded from: classes.dex */
public final class id extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f16365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rd f16367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final pd f16368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jd f16369g;

    public id(k7 k7Var) {
        super(k7Var);
        this.f16366d = true;
        this.f16367e = new rd(this);
        this.f16368f = new pd(this);
        this.f16369g = new jd(this);
    }

    public static /* synthetic */ void F(id idVar, long j10) {
        idVar.j();
        idVar.D();
        idVar.zzj().G().b("Activity resumed, time", Long.valueOf(j10));
        if (!idVar.a().p(p0.W0) ? idVar.a().T() || idVar.e().f16345u.b() : idVar.a().T() || idVar.f16366d) {
            idVar.f16368f.f(j10);
        }
        idVar.f16369g.a();
        rd rdVar = idVar.f16367e;
        rdVar.f16769a.j();
        if (rdVar.f16769a.f16624a.n()) {
            rdVar.b(rdVar.f16769a.zzb().a(), false);
        }
    }

    public static /* synthetic */ void z(id idVar, long j10) {
        idVar.j();
        idVar.D();
        idVar.zzj().G().b("Activity paused, time", Long.valueOf(j10));
        idVar.f16369g.b(j10);
        if (idVar.a().T()) {
            idVar.f16368f.e(j10);
        }
    }

    public final void A(boolean z10) {
        j();
        this.f16366d = z10;
    }

    public final boolean B(boolean z10, boolean z11, long j10) {
        return this.f16368f.d(z10, z11, j10);
    }

    public final boolean C() {
        j();
        return this.f16366d;
    }

    public final void D() {
        j();
        if (this.f16365c == null) {
            this.f16365c = new zzdj(Looper.getMainLooper());
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ a k() {
        return super.k();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ n5 l() {
        return super.l();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ q5 m() {
        return super.m();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ e9 n() {
        return super.n();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ db o() {
        return super.o();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ kb p() {
        return super.p();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ qb q() {
        return super.q();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ id r() {
        return super.r();
    }

    @Override // u4.f4
    public final boolean t() {
        return false;
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
