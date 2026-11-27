package u4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j extends o8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f16373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f16375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f16376e;

    public j(k7 k7Var) {
        super(k7Var);
        this.f16375d = new l() { // from class: u4.m
            @Override // u4.l
            public final String b(String str, String str2) {
                return null;
            }
        };
    }

    public static long G() {
        return p0.f16647e.a(null).longValue();
    }

    public static long I() {
        return p0.f16663l.a(null).intValue();
    }

    public static long N() {
        return p0.N.a(null).longValue();
    }

    public static long O() {
        return p0.I.a(null).longValue();
    }

    public final long A(String str) {
        return y(str, p0.f16638b);
    }

    public final String B(String str, d5<String> d5Var) {
        return d5Var.a(TextUtils.isEmpty(str) ? null : this.f16375d.b(str, d5Var.b()));
    }

    public final Boolean C(String str) {
        com.google.android.gms.common.internal.r.f(str);
        Bundle bundleS = s();
        if (bundleS == null) {
            zzj().C().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleS.containsKey(str)) {
            return Boolean.valueOf(bundleS.getBoolean(str));
        }
        return null;
    }

    public final boolean D(String str, d5<Boolean> d5Var) {
        return F(str, d5Var);
    }

    public final String E(String str) {
        return B(str, p0.W);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public final boolean F(String str, d5<Boolean> d5Var) {
        Boolean boolA;
        if (TextUtils.isEmpty(str)) {
            boolA = d5Var.a(null);
        } else {
            String strB = this.f16375d.b(str, d5Var.b());
            if (TextUtils.isEmpty(strB)) {
                boolA = d5Var.a(null);
            } else {
                boolA = d5Var.a(Boolean.valueOf("1".equals(strB)));
            }
        }
        return boolA.booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x003e A[Catch: NotFoundException -> 0x0043, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0043, blocks: (B:12:0x002b, B:15:0x003e), top: B:20:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final List<String> H(String str) {
        Integer numValueOf;
        String[] stringArray;
        com.google.android.gms.common.internal.r.f(str);
        Bundle bundleS = s();
        if (bundleS != null) {
            if (bundleS.containsKey(str)) {
                numValueOf = Integer.valueOf(bundleS.getInt(str));
            }
            if (numValueOf == null) {
                return null;
            }
            try {
                stringArray = zza().getResources().getStringArray(numValueOf.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (Resources.NotFoundException e10) {
                zzj().C().b("Failed to load string array from metadata: resource not found", e10);
                return null;
            }
        }
        zzj().C().a("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf == null) {
            return null;
        }
        stringArray = zza().getResources().getStringArray(numValueOf.intValue());
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public final void J(String str) {
        this.f16374c = str;
    }

    public final boolean K(String str) {
        return F(str, p0.V);
    }

    public final boolean L(String str) {
        return "1".equals(this.f16375d.b(str, "gaia_collection_enabled"));
    }

    public final boolean M(String str) {
        return "1".equals(this.f16375d.b(str, "measurement.event_sampling_enabled"));
    }

    public final String P() {
        return b("debug.firebase.analytics.app", "");
    }

    public final String Q() {
        return b("debug.deferred.deeplink", "");
    }

    public final String R() {
        return this.f16374c;
    }

    public final boolean S() {
        Boolean boolC = C("google_analytics_adid_collection_enabled");
        return boolC == null || boolC.booleanValue();
    }

    public final boolean T() {
        Boolean boolC = C("google_analytics_automatic_screen_reporting_enabled");
        return boolC == null || boolC.booleanValue();
    }

    public final boolean U() {
        Boolean boolC = C("firebase_analytics_collection_deactivated");
        return boolC != null && boolC.booleanValue();
    }

    public final boolean V() {
        if (this.f16373b == null) {
            Boolean boolC = C("app_measurement_lite");
            this.f16373b = boolC;
            if (boolC == null) {
                this.f16373b = Boolean.FALSE;
            }
        }
        return this.f16373b.booleanValue() || !this.f16624a.r();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    public final String b(String str, String str2) {
        x5 x5VarC;
        String str3;
        try {
            String str4 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            com.google.android.gms.common.internal.r.l(str4);
            return str4;
        } catch (ClassNotFoundException e10) {
            e = e10;
            x5VarC = zzj().C();
            str3 = "Could not find SystemProperties class";
            x5VarC.b(str3, e);
            return str2;
        } catch (IllegalAccessException e11) {
            e = e11;
            x5VarC = zzj().C();
            str3 = "Could not access SystemProperties.get()";
            x5VarC.b(str3, e);
            return str2;
        } catch (NoSuchMethodException e12) {
            e = e12;
            x5VarC = zzj().C();
            str3 = "Could not find SystemProperties.get() method";
            x5VarC.b(str3, e);
            return str2;
        } catch (InvocationTargetException e13) {
            e = e13;
            x5VarC = zzj().C();
            str3 = "SystemProperties.get() threw an exception";
            x5VarC.b(str3, e);
            return str2;
        }
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

    public final double k(String str, d5<Double> d5Var) {
        if (!TextUtils.isEmpty(str)) {
            String strB = this.f16375d.b(str, d5Var.b());
            if (!TextUtils.isEmpty(strB)) {
                try {
                    return d5Var.a(Double.valueOf(Double.parseDouble(strB))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return d5Var.a(null).doubleValue();
    }

    public final int l(String str) {
        return m(str, p0.S, 500, 2000);
    }

    public final int m(String str, d5<Integer> d5Var, int i10, int i11) {
        return Math.max(Math.min(u(str, d5Var), i11), i10);
    }

    public final int n(String str, boolean z10) {
        if (z10) {
            return m(str, p0.f16642c0, 100, 500);
        }
        return 500;
    }

    public final void o(l lVar) {
        this.f16375d = lVar;
    }

    public final boolean p(d5<Boolean> d5Var) {
        return F(null, d5Var);
    }

    public final boolean q() {
        if (this.f16376e == null) {
            synchronized (this) {
                if (this.f16376e == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String strA = j4.p.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f16376e = Boolean.valueOf(str != null && str.equals(strA));
                    }
                    if (this.f16376e == null) {
                        this.f16376e = Boolean.TRUE;
                        zzj().C().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f16376e.booleanValue();
    }

    public final boolean r() {
        Boolean boolC = C("google_analytics_sgtm_upload_enabled");
        if (boolC == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    public final Bundle s() {
        try {
            if (zza().getPackageManager() == null) {
                zzj().C().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoC = l4.d.a(zza()).c(zza().getPackageName(), 128);
            if (applicationInfoC != null) {
                return applicationInfoC.metaData;
            }
            zzj().C().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            zzj().C().b("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    public final int t(String str) {
        return m(str, p0.T, 25, 100);
    }

    public final int u(String str, d5<Integer> d5Var) {
        if (!TextUtils.isEmpty(str)) {
            String strB = this.f16375d.b(str, d5Var.b());
            if (!TextUtils.isEmpty(strB)) {
                try {
                    return d5Var.a(Integer.valueOf(Integer.parseInt(strB))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return d5Var.a(null).intValue();
    }

    public final int v(String str, boolean z10) {
        return Math.max(n(str, z10), 256);
    }

    public final int w() {
        return g().Y(201500000, true) ? 100 : 25;
    }

    public final int x(String str) {
        return u(str, p0.f16671p);
    }

    public final long y(String str, d5<Long> d5Var) {
        if (!TextUtils.isEmpty(str)) {
            String strB = this.f16375d.b(str, d5Var.b());
            if (!TextUtils.isEmpty(strB)) {
                try {
                    return d5Var.a(Long.valueOf(Long.parseLong(strB))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return d5Var.a(null).longValue();
    }

    public final v8 z(String str, boolean z10) {
        Object obj;
        com.google.android.gms.common.internal.r.f(str);
        Bundle bundleS = s();
        if (bundleS == null) {
            zzj().C().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleS.get(str);
        }
        if (obj == null) {
            return v8.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return v8.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return v8.DENIED;
        }
        if (z10 && "eu_consent_policy".equals(obj)) {
            return v8.POLICY;
        }
        zzj().H().b("Invalid manifest metadata for", str);
        return v8.UNINITIALIZED;
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
