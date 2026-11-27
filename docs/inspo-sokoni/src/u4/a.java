package u4;

import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends g5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f15978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f15979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15980d;

    public a(k7 k7Var) {
        super(k7Var);
        this.f15979c = new t.a();
        this.f15978b = new t.a();
    }

    public static /* synthetic */ void A(a aVar, String str, long j10) {
        aVar.j();
        com.google.android.gms.common.internal.r.f(str);
        Integer num = aVar.f15979c.get(str);
        if (num == null) {
            aVar.zzj().C().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        hb hbVarZ = aVar.p().z(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            aVar.f15979c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        aVar.f15979c.remove(str);
        Long l10 = aVar.f15978b.get(str);
        if (l10 == null) {
            aVar.zzj().C().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j10 - l10.longValue();
            aVar.f15978b.remove(str);
            aVar.v(str, jLongValue, hbVarZ);
        }
        if (aVar.f15979c.isEmpty()) {
            long j11 = aVar.f15980d;
            if (j11 == 0) {
                aVar.zzj().C().a("First ad exposure time was never set");
            } else {
                aVar.t(j10 - j11, hbVarZ);
                aVar.f15980d = 0L;
            }
        }
    }

    public static /* synthetic */ void x(a aVar, String str, long j10) {
        aVar.j();
        com.google.android.gms.common.internal.r.f(str);
        if (aVar.f15979c.isEmpty()) {
            aVar.f15980d = j10;
        }
        Integer num = aVar.f15979c.get(str);
        if (num != null) {
            aVar.f15979c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (aVar.f15979c.size() >= 100) {
            aVar.zzj().H().a("Too many ads visible");
        } else {
            aVar.f15979c.put(str, 1);
            aVar.f15978b.put(str, Long.valueOf(j10));
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

    public final void s(long j10) {
        hb hbVarZ = p().z(false);
        for (String str : this.f15978b.keySet()) {
            v(str, j10 - this.f15978b.get(str).longValue(), hbVarZ);
        }
        if (!this.f15978b.isEmpty()) {
            t(j10 - this.f15980d, hbVarZ);
        }
        y(j10);
    }

    public final void t(long j10, hb hbVar) {
        if (hbVar == null) {
            zzj().G().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().G().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        af.U(hbVar, bundle, true);
        n().a1("am", "_xa", bundle);
    }

    public final void u(String str, long j10) {
        if (str == null || str.length() == 0) {
            zzj().C().a("Ad unit id must be a non-empty string");
        } else {
            zzl().y(new c1(this, str, j10));
        }
    }

    public final void v(String str, long j10, hb hbVar) {
        if (hbVar == null) {
            zzj().G().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().G().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        af.U(hbVar, bundle, true);
        n().a1("am", "_xu", bundle);
    }

    public final void y(long j10) {
        Iterator<String> it = this.f15978b.keySet().iterator();
        while (it.hasNext()) {
            this.f15978b.put(it.next(), Long.valueOf(j10));
        }
        if (this.f15978b.isEmpty()) {
            return;
        }
        this.f15980d = j10;
    }

    public final void z(String str, long j10) {
        if (str == null || str.length() == 0) {
            zzj().C().a("Ad unit id must be a non-empty string");
        } else {
            zzl().y(new b0(this, str, j10));
        }
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
