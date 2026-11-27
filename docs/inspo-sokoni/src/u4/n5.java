package u4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzoy;
import com.google.android.gms.internal.measurement.zzpq;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class n5 extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f16580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f16581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f16583m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f16584n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f16585o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f16586p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f16587q;

    public n5(k7 k7Var, long j10) {
        super(k7Var);
        this.f16586p = 0L;
        this.f16587q = null;
        this.f16579i = j10;
    }

    public final int A() {
        u();
        return this.f16575e;
    }

    public final String B() {
        u();
        return this.f16584n;
    }

    public final String C() {
        u();
        com.google.android.gms.common.internal.r.l(this.f16573c);
        return this.f16573c;
    }

    public final String D() {
        u();
        com.google.android.gms.common.internal.r.l(this.f16577g);
        return this.f16577g;
    }

    public final String E() {
        j();
        u();
        com.google.android.gms.common.internal.r.l(this.f16583m);
        return this.f16583m;
    }

    public final List<String> F() {
        return this.f16580j;
    }

    public final void G() {
        String str;
        j();
        if (e().I().m(s8.a.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            g().P0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzj().B().a("Analytics Storage consent is not granted");
            str = null;
        }
        x5 x5VarB = zzj().B();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        x5VarB.a(String.format("Resetting session stitching token to %s", objArr));
        this.f16585o = str;
        this.f16586p = zzb().a();
    }

    public final String H() {
        x5 x5VarJ;
        String str;
        if (zzpq.zza() && a().p(p0.C0)) {
            x5VarJ = zzj().G();
            str = "Disabled IID for tests.";
        } else {
            try {
                Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (clsLoadClass == null) {
                    return null;
                }
                try {
                    Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                    if (objInvoke == null) {
                        return null;
                    }
                    try {
                        return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                    } catch (Exception unused) {
                        x5VarJ = zzj().I();
                        str = "Failed to retrieve Firebase Instance Id";
                    }
                } catch (Exception unused2) {
                    x5VarJ = zzj().J();
                    str = "Failed to obtain Firebase Analytics instance";
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        }
        x5VarJ.a(str);
        return null;
    }

    public final boolean I(String str) {
        String str2 = this.f16587q;
        boolean z10 = (str2 == null || str2.equals(str)) ? false : true;
        this.f16587q = str;
        return z10;
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
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00db  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:41:0x0105  */
    /* JADX WARN: Code duplicated, block: B:42:0x010c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0113  */
    /* JADX WARN: Code duplicated, block: B:46:0x011e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0120  */
    /* JADX WARN: Code duplicated, block: B:50:0x0127  */
    /* JADX WARN: Code duplicated, block: B:53:0x014a  */
    /* JADX WARN: Code duplicated, block: B:54:0x014b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0154 A[Catch: IllegalStateException -> 0x018a, TryCatch #3 {IllegalStateException -> 0x018a, blocks: (B:51:0x012f, B:55:0x014c, B:57:0x0154, B:59:0x016d, B:61:0x0181, B:63:0x0186, B:62:0x0184), top: B:92:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x016d A[Catch: IllegalStateException -> 0x018a, TryCatch #3 {IllegalStateException -> 0x018a, blocks: (B:51:0x012f, B:55:0x014c, B:57:0x0154, B:59:0x016d, B:61:0x0181, B:63:0x0186, B:62:0x0184), top: B:92:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0181 A[Catch: IllegalStateException -> 0x018a, TryCatch #3 {IllegalStateException -> 0x018a, blocks: (B:51:0x012f, B:55:0x014c, B:57:0x0154, B:59:0x016d, B:61:0x0181, B:63:0x0186, B:62:0x0184), top: B:92:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0184 A[Catch: IllegalStateException -> 0x018a, TryCatch #3 {IllegalStateException -> 0x018a, blocks: (B:51:0x012f, B:55:0x014c, B:57:0x0154, B:59:0x016d, B:61:0x0181, B:63:0x0186, B:62:0x0184), top: B:92:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:71:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x01df  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:95:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[LOOP:0: B:74:0x01c4->B:96:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4.f4
    public final void x() {
        String str;
        String string;
        boolean z10;
        Object[] objArr;
        int iU;
        v5 v5VarZzj;
        x5 x5VarG;
        String str2;
        Object[] objArr2;
        List<String> listH;
        Iterator<String> it;
        String strB;
        String str3;
        String packageName = zza().getPackageName();
        PackageManager packageManager = zza().getPackageManager();
        String str4 = "";
        String installerPackageName = "unknown";
        String str5 = "Unknown";
        int i10 = Integer.MIN_VALUE;
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    zzj().C().b("Error retrieving app installer package name. appId", v5.r(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(zza().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str5 = packageInfo.versionName;
                            i10 = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str5;
                            str5 = string;
                            zzj().C().c("Error retrieving package info. appId, appName", v5.r(packageName), str5);
                            string = str5;
                            str5 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.f16573c = packageName;
                this.f16576f = installerPackageName;
                this.f16574d = str5;
                this.f16575e = i10;
                this.f16577g = string;
                this.f16578h = 0L;
                z10 = true;
                if (TextUtils.isEmpty(this.f16624a.L()) && "am".equals(this.f16624a.M())) {
                    objArr = true;
                } else {
                    objArr = false;
                }
                iU = this.f16624a.u();
                v5VarZzj = zzj();
                switch (iU) {
                    case 0:
                        x5VarG = v5VarZzj.G();
                        str2 = "App measurement collection enabled";
                        break;
                    case 1:
                        x5VarG = v5VarZzj.F();
                        str2 = "App measurement deactivated via the manifest";
                        break;
                    case 2:
                        x5VarG = v5VarZzj.G();
                        str2 = "App measurement deactivated via the init parameters";
                        break;
                    case 3:
                        x5VarG = v5VarZzj.F();
                        str2 = "App measurement disabled by setAnalyticsCollectionEnabled(false)";
                        break;
                    case 4:
                        x5VarG = v5VarZzj.F();
                        str2 = "App measurement disabled via the manifest";
                        break;
                    case 5:
                        x5VarG = v5VarZzj.G();
                        str2 = "App measurement disabled via the init parameters";
                        break;
                    case 6:
                        x5VarG = v5VarZzj.I();
                        str2 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics";
                        break;
                    case 7:
                        x5VarG = v5VarZzj.F();
                        str2 = "App measurement disabled via the global data collection setting";
                        break;
                    case 8:
                        x5VarG = v5VarZzj.F();
                        str2 = "App measurement disabled due to denied storage consent";
                        break;
                    default:
                        v5VarZzj.F().a("App measurement disabled");
                        x5VarG = zzj().E();
                        str2 = "Invalid scion state in identity";
                        break;
                }
                x5VarG.a(str2);
                if (iU == 0) {
                    objArr2 = true;
                } else {
                    objArr2 = false;
                }
                this.f16583m = "";
                this.f16584n = "";
                if (objArr != false) {
                    this.f16584n = this.f16624a.L();
                }
                strB = new e7(zza(), this.f16624a.O()).b("google_app_id");
                if (TextUtils.isEmpty(strB)) {
                    str4 = strB;
                }
                this.f16583m = str4;
                if (!TextUtils.isEmpty(strB)) {
                    this.f16584n = new e7(zza(), this.f16624a.O()).b("admob_app_id");
                }
                if (objArr2 != false) {
                    x5 x5VarG2 = zzj().G();
                    String str6 = this.f16573c;
                    if (TextUtils.isEmpty(this.f16583m)) {
                        str3 = this.f16584n;
                    } else {
                        str3 = this.f16583m;
                    }
                    x5VarG2.c("App measurement enabled for app package, google app id", str6, str3);
                }
                this.f16580j = null;
                listH = a().H("analytics.safelisted_events");
                if (listH != null) {
                    if (listH.isEmpty()) {
                        zzj().I().a("Safelisted event list is empty. Ignoring");
                    } else {
                        it = listH.iterator();
                        while (it.hasNext()) {
                            if (!g().s0("safelisted event", it.next())) {
                            }
                        }
                    }
                    z10 = false;
                }
                if (z10) {
                    this.f16580j = listH;
                }
                if (packageManager != null) {
                    this.f16582l = l4.b.a(zza()) ? 1 : 0;
                } else {
                    this.f16582l = 0;
                }
            }
            zzj().C().b("PackageManager is null, app identity information might be inaccurate. appId", v5.r(packageName));
            strB = new e7(zza(), this.f16624a.O()).b("google_app_id");
            if (TextUtils.isEmpty(strB)) {
                str4 = strB;
            }
            this.f16583m = str4;
            if (!TextUtils.isEmpty(strB)) {
                this.f16584n = new e7(zza(), this.f16624a.O()).b("admob_app_id");
            }
            if (objArr2 != false) {
                x5 x5VarG3 = zzj().G();
                String str7 = this.f16573c;
                if (TextUtils.isEmpty(this.f16583m)) {
                    str3 = this.f16584n;
                } else {
                    str3 = this.f16583m;
                }
                x5VarG3.c("App measurement enabled for app package, google app id", str7, str3);
            }
        } catch (IllegalStateException e10) {
            zzj().C().c("Fetching Google App Id failed with exception. appId", v5.r(packageName), e10);
        }
        string = "Unknown";
        this.f16573c = packageName;
        this.f16576f = installerPackageName;
        this.f16574d = str5;
        this.f16575e = i10;
        this.f16577g = string;
        this.f16578h = 0L;
        z10 = true;
        if (TextUtils.isEmpty(this.f16624a.L())) {
            objArr = false;
        } else {
            objArr = false;
        }
        iU = this.f16624a.u();
        v5VarZzj = zzj();
        switch (iU) {
            case 0:
                x5VarG = v5VarZzj.G();
                str2 = "App measurement collection enabled";
                break;
            case 1:
                x5VarG = v5VarZzj.F();
                str2 = "App measurement deactivated via the manifest";
                break;
            case 2:
                x5VarG = v5VarZzj.G();
                str2 = "App measurement deactivated via the init parameters";
                break;
            case 3:
                x5VarG = v5VarZzj.F();
                str2 = "App measurement disabled by setAnalyticsCollectionEnabled(false)";
                break;
            case 4:
                x5VarG = v5VarZzj.F();
                str2 = "App measurement disabled via the manifest";
                break;
            case 5:
                x5VarG = v5VarZzj.G();
                str2 = "App measurement disabled via the init parameters";
                break;
            case 6:
                x5VarG = v5VarZzj.I();
                str2 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics";
                break;
            case 7:
                x5VarG = v5VarZzj.F();
                str2 = "App measurement disabled via the global data collection setting";
                break;
            case 8:
                x5VarG = v5VarZzj.F();
                str2 = "App measurement disabled due to denied storage consent";
                break;
            default:
                v5VarZzj.F().a("App measurement disabled");
                x5VarG = zzj().E();
                str2 = "Invalid scion state in identity";
                break;
        }
        x5VarG.a(str2);
        if (iU == 0) {
            objArr2 = true;
        } else {
            objArr2 = false;
        }
        this.f16583m = "";
        this.f16584n = "";
        if (objArr != false) {
            this.f16584n = this.f16624a.L();
        }
        this.f16580j = null;
        listH = a().H("analytics.safelisted_events");
        if (listH != null) {
            if (listH.isEmpty()) {
                zzj().I().a("Safelisted event list is empty. Ignoring");
            } else {
                it = listH.iterator();
                while (it.hasNext()) {
                    if (!g().s0("safelisted event", it.next())) {
                    }
                }
            }
            z10 = false;
        }
        if (z10) {
            this.f16580j = listH;
        }
        if (packageManager != null) {
            this.f16582l = l4.b.a(zza()) ? 1 : 0;
        } else {
            this.f16582l = 0;
        }
    }

    public final me y(String str) {
        long j10;
        boolean z10;
        String str2;
        int iU0;
        j();
        String strC = C();
        String strE = E();
        u();
        String str3 = this.f16574d;
        long jA = A();
        u();
        com.google.android.gms.common.internal.r.l(this.f16576f);
        String str4 = this.f16576f;
        u();
        j();
        if (this.f16578h == 0) {
            this.f16578h = this.f16624a.K().v(zza(), zza().getPackageName());
        }
        long j11 = this.f16578h;
        boolean zN = this.f16624a.n();
        boolean z11 = !e().f16344t;
        j();
        String strH = !this.f16624a.n() ? null : H();
        k7 k7Var = this.f16624a;
        long jA2 = k7Var.C().f16331g.a();
        long jMin = jA2 == 0 ? k7Var.I : Math.min(k7Var.I, jA2);
        int iZ = z();
        boolean zS = a().S();
        i6 i6VarE = e();
        i6VarE.j();
        boolean z12 = i6VarE.F().getBoolean("deferred_analytics_collection", false);
        String strB = B();
        Boolean boolValueOf = Boolean.valueOf(a().z("google_analytics_default_allow_ad_personalization_signals", true) != v8.GRANTED);
        long j12 = this.f16579i;
        List<String> list = this.f16580j;
        String strV = e().I().v();
        if (this.f16581k == null) {
            this.f16581k = g().N0();
        }
        String str5 = this.f16581k;
        if (e().I().m(s8.a.ANALYTICS_STORAGE)) {
            j();
            j10 = 0;
            if (this.f16586p != 0) {
                z10 = zN;
                long jA3 = zzb().a() - this.f16586p;
                if (this.f16585o != null && jA3 > 86400000 && this.f16587q == null) {
                    G();
                }
            } else {
                z10 = zN;
            }
            if (this.f16585o == null) {
                G();
            }
            str2 = this.f16585o;
        } else {
            str2 = null;
            j10 = 0;
            z10 = zN;
        }
        boolean zR = a().r();
        long jV0 = g().v0(C());
        int iB = e().I().b();
        String strJ = e().H().j();
        if (zzoy.zza() && a().p(p0.R0)) {
            g();
            iU0 = af.u0();
        } else {
            iU0 = 0;
        }
        return new me(strC, strE, str3, jA, str4, 114010L, j11, str, z10, z11, strH, jMin, iZ, zS, z12, strB, boolValueOf, j12, list, (String) null, strV, str5, str2, zR, jV0, iB, strJ, iU0, (zzoy.zza() && a().p(p0.R0)) ? g().K0() : j10, a().R(), new d2(a().z("google_analytics_default_allow_ad_personalization_signals", true)).c(), this.f16624a.I, a().p(p0.M0) ? o().z().zza() : 0);
    }

    public final int z() {
        u();
        return this.f16582l;
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
