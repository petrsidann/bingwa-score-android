package u4;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzeb;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class kb extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile hb f16452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile hb f16453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hb f16454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, hb> f16455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzeb f16456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f16457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile hb f16458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public hb f16459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f16461l;

    public kb(k7 k7Var) {
        super(k7Var);
        this.f16461l = new Object();
        this.f16455f = new ConcurrentHashMap();
    }

    public static /* synthetic */ void H(kb kbVar, Bundle bundle, hb hbVar, hb hbVar2, long j10) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        kbVar.F(hbVar, hbVar2, j10, true, kbVar.g().B(null, "screen_view", bundle, null, false));
    }

    public final void A(Bundle bundle, long j10) {
        String str;
        synchronized (this.f16461l) {
            if (!this.f16460k) {
                zzj().I().a("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strB = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > a().n(null, false))) {
                    zzj().I().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > a().n(null, false))) {
                    zzj().I().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strB = string2;
                }
            } else {
                str = null;
            }
            if (strB == null) {
                zzeb zzebVar = this.f16456g;
                strB = zzebVar != null ? b(zzebVar.zzb, "Activity") : "Activity";
            }
            String str2 = strB;
            hb hbVar = this.f16452c;
            if (this.f16457h && hbVar != null) {
                this.f16457h = false;
                boolean zEquals = Objects.equals(hbVar.f16312b, str2);
                boolean zEquals2 = Objects.equals(hbVar.f16311a, str);
                if (zEquals && zEquals2) {
                    zzj().I().a("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().G().c("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            hb hbVar2 = this.f16452c == null ? this.f16453d : this.f16452c;
            hb hbVar3 = new hb(str, str2, g().L0(), true, j10);
            this.f16452c = hbVar3;
            this.f16453d = hbVar2;
            this.f16458i = hbVar3;
            zzl().y(new jb(this, bundle, hbVar3, hbVar2, zzb().b()));
        }
    }

    public final void B(zzeb zzebVar) {
        synchronized (this.f16461l) {
            if (Objects.equals(this.f16456g, zzebVar)) {
                this.f16456g = null;
            }
        }
        if (a().T()) {
            this.f16455f.remove(Integer.valueOf(zzebVar.zza));
        }
    }

    public final void C(zzeb zzebVar, Bundle bundle) {
        Bundle bundle2;
        if (!a().T() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f16455f.put(Integer.valueOf(zzebVar.zza), new hb(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @Deprecated
    public final void D(zzeb zzebVar, String str, String str2) {
        if (!a().T()) {
            zzj().I().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        hb hbVar = this.f16452c;
        if (hbVar == null) {
            zzj().I().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f16455f.get(Integer.valueOf(zzebVar.zza)) == null) {
            zzj().I().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = b(zzebVar.zzb, "Activity");
        }
        boolean zEquals = Objects.equals(hbVar.f16312b, str2);
        boolean zEquals2 = Objects.equals(hbVar.f16311a, str);
        if (zEquals && zEquals2) {
            zzj().I().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > a().n(null, false))) {
            zzj().I().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > a().n(null, false))) {
            zzj().I().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().G().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        hb hbVar2 = new hb(str, str2, g().L0());
        this.f16455f.put(Integer.valueOf(zzebVar.zza), hbVar2);
        E(zzebVar.zzb, hbVar2, true);
    }

    public final void E(String str, hb hbVar, boolean z10) {
        hb hbVar2;
        hb hbVar3 = this.f16452c == null ? this.f16453d : this.f16452c;
        if (hbVar.f16312b == null) {
            hbVar2 = new hb(hbVar.f16311a, str != null ? b(str, "Activity") : null, hbVar.f16313c, hbVar.f16315e, hbVar.f16316f);
        } else {
            hbVar2 = hbVar;
        }
        this.f16453d = this.f16452c;
        this.f16452c = hbVar2;
        zzl().y(new nb(this, hbVar2, hbVar3, zzb().b(), z10));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ad  */
    public final void F(hb hbVar, hb hbVar2, long j10, boolean z10, Bundle bundle) {
        long j11;
        j();
        boolean z11 = false;
        boolean z12 = (hbVar2 != null && hbVar2.f16313c == hbVar.f16313c && Objects.equals(hbVar2.f16312b, hbVar.f16312b) && Objects.equals(hbVar2.f16311a, hbVar.f16311a)) ? false : true;
        if (z10 && this.f16454e != null) {
            z11 = true;
        }
        if (z12) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            af.U(hbVar, bundle2, true);
            if (hbVar2 != null) {
                String str = hbVar2.f16311a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = hbVar2.f16312b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", hbVar2.f16313c);
            }
            if (z11) {
                long jA = r().f16368f.a(j10);
                if (jA > 0) {
                    g().I(bundle2, jA);
                }
            }
            if (!a().T()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = hbVar.f16315e ? "app" : "auto";
            long jA2 = zzb().a();
            if (hbVar.f16315e) {
                long j12 = hbVar.f16316f;
                if (j12 != 0) {
                    j11 = j12;
                } else {
                    j11 = jA2;
                }
            } else {
                j11 = jA2;
            }
            n().P(str3, "_vs", j11, bundle2);
        }
        if (z11) {
            G(this.f16454e, true, j10);
        }
        this.f16454e = hbVar;
        if (hbVar.f16315e) {
            this.f16459j = hbVar;
        }
        q().P(hbVar);
    }

    public final void G(hb hbVar, boolean z10, long j10) {
        k().s(zzb().b());
        if (!r().B(hbVar != null && hbVar.f16314d, z10, j10) || hbVar == null) {
            return;
        }
        hbVar.f16314d = false;
    }

    public final hb L() {
        return this.f16452c;
    }

    public final void M(zzeb zzebVar) {
        synchronized (this.f16461l) {
            this.f16460k = false;
            this.f16457h = true;
        }
        long jB = zzb().b();
        if (!a().T()) {
            this.f16452c = null;
            zzl().y(new pb(this, jB));
        } else {
            hb hbVarP = P(zzebVar);
            this.f16453d = this.f16452c;
            this.f16452c = null;
            zzl().y(new ob(this, hbVarP, jB));
        }
    }

    public final void N(zzeb zzebVar, Bundle bundle) {
        hb hbVar;
        if (!a().T() || bundle == null || (hbVar = this.f16455f.get(Integer.valueOf(zzebVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", hbVar.f16313c);
        bundle2.putString("name", hbVar.f16311a);
        bundle2.putString("referrer_name", hbVar.f16312b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void O(zzeb zzebVar) {
        synchronized (this.f16461l) {
            this.f16460k = true;
            if (!Objects.equals(zzebVar, this.f16456g)) {
                synchronized (this.f16461l) {
                    this.f16456g = zzebVar;
                    this.f16457h = false;
                }
                if (a().T()) {
                    this.f16458i = null;
                    zzl().y(new rb(this));
                }
            }
        }
        if (!a().T()) {
            this.f16452c = this.f16458i;
            zzl().y(new mb(this));
            return;
        }
        E(zzebVar.zzb, P(zzebVar), false);
        a aVarK = k();
        aVarK.zzl().y(new e3(aVarK, aVarK.zzb().b()));
    }

    public final hb P(zzeb zzebVar) {
        com.google.android.gms.common.internal.r.l(zzebVar);
        hb hbVar = this.f16455f.get(Integer.valueOf(zzebVar.zza));
        if (hbVar == null) {
            hb hbVar2 = new hb(null, b(zzebVar.zzb, "Activity"), g().L0());
            this.f16455f.put(Integer.valueOf(zzebVar.zza), hbVar2);
            hbVar = hbVar2;
        }
        return this.f16458i != null ? this.f16458i : hbVar;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    public final String b(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String[] strArrSplit = str.split("\\.");
        String str3 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str3.length() > a().n(null, false) ? str3.substring(0, a().n(null, false)) : str3;
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

    public final hb z(boolean z10) {
        u();
        j();
        if (!z10) {
            return this.f16454e;
        }
        hb hbVar = this.f16454e;
        return hbVar != null ? hbVar : this.f16459j;
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
