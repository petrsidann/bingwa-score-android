package u4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzal;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class u6 extends fe implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, String>> f16845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Set<String>> f16846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f16847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f16848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, zzgc.zzd> f16849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Map<String, Integer>> f16850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t.e<String, zzb> f16851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzv f16852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f16853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f16854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f16855n;

    public u6(ge geVar) {
        super(geVar);
        this.f16845d = new t.a();
        this.f16846e = new t.a();
        this.f16847f = new t.a();
        this.f16848g = new t.a();
        this.f16849h = new t.a();
        this.f16853l = new t.a();
        this.f16854m = new t.a();
        this.f16855n = new t.a();
        this.f16850i = new t.a();
        this.f16851j = new a7(this, 20);
        this.f16852k = new z6(this);
    }

    public static /* synthetic */ zzal v(u6 u6Var) {
        return new zzr(u6Var.f16852k);
    }

    public static /* synthetic */ zzb w(u6 u6Var, String str) {
        u6Var.q();
        com.google.android.gms.common.internal.r.f(str);
        if (!u6Var.T(str)) {
            return null;
        }
        if (!u6Var.f16849h.containsKey(str) || u6Var.f16849h.get(str) == null) {
            u6Var.d0(str);
        } else {
            u6Var.C(str, u6Var.f16849h.get(str));
        }
        return u6Var.f16851j.snapshot().get(str);
    }

    public static Map<String, String> y(zzgc.zzd zzdVar) {
        t.a aVar = new t.a();
        if (zzdVar != null) {
            for (zzgc.zzh zzhVar : zzdVar.zzn()) {
                aVar.put(zzhVar.zzb(), zzhVar.zzc());
            }
        }
        return aVar;
    }

    public static s8.a z(zzgc.zza.zze zzeVar) {
        int i10 = b7.f16017b[zzeVar.ordinal()];
        if (i10 == 1) {
            return s8.a.AD_STORAGE;
        }
        if (i10 == 2) {
            return s8.a.ANALYTICS_STORAGE;
        }
        if (i10 == 3) {
            return s8.a.AD_USER_DATA;
        }
        if (i10 != 4) {
            return null;
        }
        return s8.a.AD_PERSONALIZATION;
    }

    public final v8 A(String str, s8.a aVar) {
        j();
        d0(str);
        zzgc.zza zzaVarF = F(str);
        if (zzaVarF == null) {
            return v8.UNINITIALIZED;
        }
        for (zzgc.zza.zzb zzbVar : zzaVarF.zzf()) {
            if (z(zzbVar.zzc()) == aVar) {
                int i10 = b7.f16018c[zzbVar.zzb().ordinal()];
                if (i10 != 1) {
                    return i10 != 2 ? v8.UNINITIALIZED : v8.GRANTED;
                }
                return v8.DENIED;
            }
        }
        return v8.UNINITIALIZED;
    }

    public final void B(String str, zzgc.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        t.a aVar = new t.a();
        t.a aVar2 = new t.a();
        t.a aVar3 = new t.a();
        if (zzaVar != null) {
            Iterator<zzgc.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i10 = 0; i10 < zzaVar.zza(); i10++) {
                zzgc.zzc.zza zzaVarZzch = zzaVar.zza(i10).zzch();
                if (zzaVarZzch.zzb().isEmpty()) {
                    zzj().H().a("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzch.zzb();
                    String strB = y8.b(zzaVarZzch.zzb());
                    if (!TextUtils.isEmpty(strB)) {
                        zzaVarZzch = zzaVarZzch.zza(strB);
                        zzaVar.zza(i10, zzaVarZzch);
                    }
                    if (zzaVarZzch.zze() && zzaVarZzch.zzc()) {
                        aVar.put(strZzb, Boolean.TRUE);
                    }
                    if (zzaVarZzch.zzf() && zzaVarZzch.zzd()) {
                        aVar2.put(zzaVarZzch.zzb(), Boolean.TRUE);
                    }
                    if (zzaVarZzch.zzg()) {
                        if (zzaVarZzch.zza() < 2 || zzaVarZzch.zza() > 65535) {
                            zzj().H().c("Invalid sampling rate. Event name, sample rate", zzaVarZzch.zzb(), Integer.valueOf(zzaVarZzch.zza()));
                        } else {
                            aVar3.put(zzaVarZzch.zzb(), Integer.valueOf(zzaVarZzch.zza()));
                        }
                    }
                }
            }
        }
        this.f16846e.put(str, hashSet);
        this.f16847f.put(str, aVar);
        this.f16848g.put(str, aVar2);
        this.f16850i.put(str, aVar3);
    }

    public final void C(final String str, zzgc.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.f16851j.remove(str);
            return;
        }
        zzj().G().b("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgr.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            zzb zzbVar = new zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: u4.w6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzm("internal.remoteConfig", new c7(this.f16928a, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: u4.v6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final u6 u6Var = this.f16898a;
                    final String str2 = str;
                    return new zzx("internal.appMetadata", new Callable() { // from class: u4.x6
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            u6 u6Var2 = u6Var;
                            String str3 = str2;
                            h6 h6VarQ0 = u6Var2.m().Q0(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            map.put("gmp_version", 114010L);
                            if (h6VarQ0 != null) {
                                String strO = h6VarQ0.o();
                                if (strO != null) {
                                    map.put("app_version", strO);
                                }
                                map.put("app_version_int", Long.valueOf(h6VarQ0.V()));
                                map.put("dynamite_version", Long.valueOf(h6VarQ0.w0()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: u4.y6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return u6.v(this.f16971a);
                }
            });
            zzbVar.zza(zzcVar);
            this.f16851j.put(str, zzbVar);
            zzj().G().c("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzgr.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().G().b("EES program activity", it.next().zzb());
            }
        } catch (zzc unused) {
            zzj().C().b("Failed to load EES program. appId", str);
        }
    }

    public final boolean D(String str, byte[] bArr, String str2, String str3) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        zzgc.zzd.zza zzaVarZzch = x(str, bArr).zzch();
        if (zzaVarZzch == null) {
            return false;
        }
        B(str, zzaVarZzch);
        C(str, (zzgc.zzd) ((zzkg) zzaVarZzch.zzaj()));
        this.f16849h.put(str, (zzgc.zzd) ((zzkg) zzaVarZzch.zzaj()));
        this.f16853l.put(str, zzaVarZzch.zzc());
        this.f16854m.put(str, str2);
        this.f16855n.put(str, str3);
        this.f16845d.put(str, y((zzgc.zzd) ((zzkg) zzaVarZzch.zzaj())));
        m().X(str, new ArrayList(zzaVarZzch.zzd()));
        try {
            zzaVarZzch.zzb();
            bArr = ((zzgc.zzd) ((zzkg) zzaVarZzch.zzaj())).zzce();
        } catch (RuntimeException e10) {
            zzj().H().c("Unable to serialize reduced-size config. Storing full config instead. appId", v5.r(str), e10);
        }
        s sVarM = m();
        com.google.android.gms.common.internal.r.f(str);
        sVarM.j();
        sVarM.q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (sVarM.x().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                sVarM.zzj().C().b("Failed to update remote config (got 0). appId", v5.r(str));
            }
        } catch (SQLiteException e11) {
            sVarM.zzj().C().c("Error storing remote config. appId", v5.r(str), e11);
        }
        this.f16849h.put(str, (zzgc.zzd) ((zzkg) zzaVarZzch.zzaj()));
        return true;
    }

    public final int E(String str, String str2) {
        Integer num;
        j();
        d0(str);
        Map<String, Integer> map = this.f16850i.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final zzgc.zza F(String str) {
        j();
        d0(str);
        zzgc.zzd zzdVarI = I(str);
        if (zzdVarI == null || !zzdVarI.zzo()) {
            return null;
        }
        return zzdVarI.zzd();
    }

    public final s8.a H(String str, s8.a aVar) {
        j();
        d0(str);
        zzgc.zza zzaVarF = F(str);
        if (zzaVarF == null) {
            return null;
        }
        for (zzgc.zza.zzc zzcVar : zzaVarF.zze()) {
            if (aVar == z(zzcVar.zzc())) {
                return z(zzcVar.zzb());
            }
        }
        return null;
    }

    public final zzgc.zzd I(String str) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        d0(str);
        return this.f16849h.get(str);
    }

    public final boolean J(String str, String str2) {
        Boolean bool;
        j();
        d0(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f16848g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean K(String str, s8.a aVar) {
        j();
        d0(str);
        zzgc.zza zzaVarF = F(str);
        if (zzaVarF == null) {
            return false;
        }
        for (zzgc.zza.zzb zzbVar : zzaVarF.zzd()) {
            if (aVar == z(zzbVar.zzc())) {
                if (zzbVar.zzb() == zzgc.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String L(String str) {
        j();
        return this.f16855n.get(str);
    }

    public final boolean M(String str, String str2) {
        Boolean bool;
        j();
        d0(str);
        if (U(str) && af.C0(str2)) {
            return true;
        }
        if (W(str) && af.E0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f16847f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String N(String str) {
        j();
        return this.f16854m.get(str);
    }

    public final String O(String str) {
        j();
        d0(str);
        return this.f16853l.get(str);
    }

    public final Set<String> P(String str) {
        j();
        d0(str);
        return this.f16846e.get(str);
    }

    public final SortedSet<String> Q(String str) {
        j();
        d0(str);
        TreeSet treeSet = new TreeSet();
        zzgc.zza zzaVarF = F(str);
        if (zzaVarF == null) {
            return treeSet;
        }
        Iterator<zzgc.zza.zzf> it = zzaVarF.zzc().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().zzb());
        }
        return treeSet;
    }

    public final void R(String str) {
        j();
        this.f16854m.put(str, null);
    }

    public final void S(String str) {
        j();
        this.f16849h.remove(str);
    }

    public final boolean T(String str) {
        zzgc.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.f16849h.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    public final boolean U(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean V(String str) {
        j();
        d0(str);
        zzgc.zza zzaVarF = F(str);
        return zzaVarF == null || !zzaVarF.zzh() || zzaVarF.zzg();
    }

    public final boolean W(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_public"));
    }

    public final boolean X(String str) {
        j();
        d0(str);
        return this.f16846e.get(str) != null && this.f16846e.get(str).contains("app_instance_id");
    }

    public final boolean Y(String str) {
        j();
        d0(str);
        if (this.f16846e.get(str) != null) {
            return this.f16846e.get(str).contains("device_model") || this.f16846e.get(str).contains("device_info");
        }
        return false;
    }

    public final boolean Z(String str) {
        j();
        d0(str);
        return this.f16846e.get(str) != null && this.f16846e.get(str).contains("enhanced_user_id");
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    public final boolean a0(String str) {
        j();
        d0(str);
        return this.f16846e.get(str) != null && this.f16846e.get(str).contains("google_signals");
    }

    @Override // u4.l
    public final String b(String str, String str2) {
        j();
        d0(str);
        Map<String, String> map = this.f16845d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public final boolean b0(String str) {
        j();
        d0(str);
        if (this.f16846e.get(str) != null) {
            return this.f16846e.get(str).contains("os_version") || this.f16846e.get(str).contains("device_info");
        }
        return false;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    public final boolean c0(String str) {
        j();
        d0(str);
        return this.f16846e.get(str) != null && this.f16846e.get(str).contains("user_id");
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    public final void d0(String str) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        if (this.f16849h.get(str) == null) {
            u uVarR0 = m().R0(str);
            if (uVarR0 != null) {
                zzgc.zzd.zza zzaVarZzch = x(str, uVarR0.f16842a).zzch();
                B(str, zzaVarZzch);
                this.f16845d.put(str, y((zzgc.zzd) ((zzkg) zzaVarZzch.zzaj())));
                this.f16849h.put(str, (zzgc.zzd) ((zzkg) zzaVarZzch.zzaj()));
                C(str, (zzgc.zzd) ((zzkg) zzaVarZzch.zzaj()));
                this.f16853l.put(str, zzaVarZzch.zzc());
                this.f16854m.put(str, uVarR0.f16843b);
                this.f16855n.put(str, uVarR0.f16844c);
                return;
            }
            this.f16845d.put(str, null);
            this.f16847f.put(str, null);
            this.f16846e.put(str, null);
            this.f16848g.put(str, null);
            this.f16849h.put(str, null);
            this.f16853l.put(str, null);
            this.f16854m.put(str, null);
            this.f16855n.put(str, null);
            this.f16850i.put(str, null);
        }
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

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ we k() {
        return super.k();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ kf l() {
        return super.l();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ s m() {
        return super.m();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ u6 n() {
        return super.n();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ad o() {
        return super.o();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ee p() {
        return super.p();
    }

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    public final long u(String str) {
        String strB = b(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strB)) {
            return 0L;
        }
        try {
            return Long.parseLong(strB);
        } catch (NumberFormatException e10) {
            zzj().H().c("Unable to parse timezone offset. appId", v5.r(str), e10);
            return 0L;
        }
    }

    public final zzgc.zzd x(String str, byte[] bArr) {
        if (bArr == null) {
            return zzgc.zzd.zzg();
        }
        try {
            zzgc.zzd zzdVar = (zzgc.zzd) ((zzkg) ((zzgc.zzd.zza) we.C(zzgc.zzd.zze(), bArr)).zzaj());
            zzj().G().c("Parsed config. version, gmp_app_id", zzdVar.zzr() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzp() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (zzkp | RuntimeException e10) {
            zzj().H().c("Unable to merge remote config. appId", v5.r(str), e10);
            return zzgc.zzd.zzg();
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
