package u4;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzdz;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzoy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k7 implements q8 {
    public static volatile k7 J;
    public long A;
    public volatile Boolean B;
    public Boolean C;
    public Boolean D;
    public volatile boolean E;
    public int F;
    public int G;
    public final long I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f16419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f16420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i6 f16421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v5 f16422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d7 f16423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final id f16424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final af f16425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s5 f16426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j4.d f16427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final kb f16428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e9 f16429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f16430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ab f16431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f16432s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q5 f16433t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public qb f16434u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h0 f16435v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public n5 f16436w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public db f16437x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f16439z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16438y = false;
    public AtomicInteger H = new AtomicInteger(0);

    public k7(b9 b9Var) {
        Bundle bundle;
        boolean z10 = false;
        com.google.android.gms.common.internal.r.l(b9Var);
        g gVar = new g(b9Var.f16023a);
        this.f16419f = gVar;
        a5.f15982a = gVar;
        Context context = b9Var.f16023a;
        this.f16414a = context;
        this.f16415b = b9Var.f16024b;
        this.f16416c = b9Var.f16025c;
        this.f16417d = b9Var.f16026d;
        this.f16418e = b9Var.f16030h;
        this.B = b9Var.f16027e;
        this.f16432s = b9Var.f16032j;
        this.E = true;
        zzdz zzdzVar = b9Var.f16029g;
        if (zzdzVar != null && (bundle = zzdzVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzdzVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        zzhx.zzb(context);
        j4.d dVarD = j4.g.d();
        this.f16427n = dVarD;
        Long l10 = b9Var.f16031i;
        this.I = l10 != null ? l10.longValue() : dVarD.a();
        this.f16420g = new j(this);
        i6 i6Var = new i6(this);
        i6Var.m();
        this.f16421h = i6Var;
        v5 v5Var = new v5(this);
        v5Var.m();
        this.f16422i = v5Var;
        af afVar = new af(this);
        afVar.m();
        this.f16425l = afVar;
        this.f16426m = new s5(new f9(b9Var, this));
        this.f16430q = new a(this);
        kb kbVar = new kb(this);
        kbVar.v();
        this.f16428o = kbVar;
        e9 e9Var = new e9(this);
        e9Var.v();
        this.f16429p = e9Var;
        id idVar = new id(this);
        idVar.v();
        this.f16424k = idVar;
        ab abVar = new ab(this);
        abVar.m();
        this.f16431r = abVar;
        d7 d7Var = new d7(this);
        d7Var.m();
        this.f16423j = d7Var;
        zzdz zzdzVar2 = b9Var.f16029g;
        if (zzdzVar2 != null && zzdzVar2.zzb != 0) {
            z10 = true;
        }
        boolean z11 = !z10;
        if (context.getApplicationContext() instanceof Application) {
            E().X0(z11);
        } else {
            zzj().H().a("Application context is not an Application");
        }
        d7Var.y(new l7(this, b9Var));
    }

    public static k7 a(Context context, zzdz zzdzVar, Long l10) {
        Bundle bundle;
        if (zzdzVar != null && (zzdzVar.zze == null || zzdzVar.zzf == null)) {
            zzdzVar = new zzdz(zzdzVar.zza, zzdzVar.zzb, zzdzVar.zzc, zzdzVar.zzd, null, null, zzdzVar.zzg, null);
        }
        com.google.android.gms.common.internal.r.l(context);
        com.google.android.gms.common.internal.r.l(context.getApplicationContext());
        if (J == null) {
            synchronized (k7.class) {
                if (J == null) {
                    J = new k7(new b9(context, zzdzVar, l10));
                }
            }
        } else if (zzdzVar != null && (bundle = zzdzVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            com.google.android.gms.common.internal.r.l(J);
            J.i(zzdzVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        com.google.android.gms.common.internal.r.l(J);
        return J;
    }

    public static void c(f4 f4Var) {
        if (f4Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (f4Var.s()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(f4Var.getClass()));
    }

    public static void d(g5 g5Var) {
        if (g5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static /* synthetic */ void e(k7 k7Var, String str, int i10, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        boolean z10 = true;
        if (!((i10 == 200 || i10 == 204 || i10 == 304) && th == null)) {
            k7Var.zzj().H().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
            return;
        }
        k7Var.C().f16346v.a(true);
        if (bArr == null || bArr.length == 0) {
            k7Var.zzj().B().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            if (TextUtils.isEmpty(strOptString)) {
                k7Var.zzj().B().a("Deferred Deep Link is empty.");
                return;
            }
            String strOptString2 = jSONObject.optString("gclid", "");
            String strOptString3 = jSONObject.optString("gbraid", "");
            String strOptString4 = jSONObject.optString("gad_source", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            Bundle bundle = new Bundle();
            af afVarK = k7Var.K();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = afVarK.zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                z10 = false;
            }
            if (!z10) {
                k7Var.zzj().H().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                bundle.putString("gbraid", strOptString3);
            }
            if (!TextUtils.isEmpty(strOptString4)) {
                bundle.putString("gad_source", strOptString4);
            }
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            try {
                k7Var.f16429p.a1("auto", "_cmp", bundle);
                af afVarK2 = k7Var.K();
                if (TextUtils.isEmpty(strOptString) || !afVarK2.e0(strOptString, dOptDouble)) {
                    return;
                }
                afVarK2.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            } catch (JSONException e10) {
                e = e10;
                k7Var.zzj().C().b("Failed to parse the Deferred Deep Link response. exception", e);
            }
        } catch (JSONException e11) {
            e = e11;
        }
    }

    public static /* synthetic */ void f(k7 k7Var, b9 b9Var) {
        k7Var.zzl().j();
        h0 h0Var = new h0(k7Var);
        h0Var.m();
        k7Var.f16435v = h0Var;
        n5 n5Var = new n5(k7Var, b9Var.f16028f);
        n5Var.v();
        k7Var.f16436w = n5Var;
        q5 q5Var = new q5(k7Var);
        q5Var.v();
        k7Var.f16433t = q5Var;
        qb qbVar = new qb(k7Var);
        qbVar.v();
        k7Var.f16434u = qbVar;
        k7Var.f16425l.n();
        k7Var.f16421h.n();
        k7Var.f16436w.w();
        db dbVar = new db(k7Var);
        dbVar.v();
        k7Var.f16437x = dbVar;
        dbVar.w();
        k7Var.zzj().F().b("App measurement initialized, version", 114010L);
        k7Var.zzj().F().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strC = n5Var.C();
        if (TextUtils.isEmpty(k7Var.f16415b)) {
            if (k7Var.K().A0(strC, k7Var.f16420g.R())) {
                k7Var.zzj().F().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                k7Var.zzj().F().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strC);
            }
        }
        k7Var.zzj().B().a("Debug-level message logging enabled");
        if (k7Var.F != k7Var.H.get()) {
            k7Var.zzj().C().c("Not all components initialized", Integer.valueOf(k7Var.F), Integer.valueOf(k7Var.H.get()));
        }
        k7Var.f16438y = true;
    }

    public static void g(o8 o8Var) {
        if (o8Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void h(r8 r8Var) {
        if (r8Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (r8Var.o()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(r8Var.getClass()));
    }

    public final s5 A() {
        return this.f16426m;
    }

    public final v5 B() {
        v5 v5Var = this.f16422i;
        if (v5Var == null || !v5Var.o()) {
            return null;
        }
        return this.f16422i;
    }

    public final i6 C() {
        g(this.f16421h);
        return this.f16421h;
    }

    public final d7 D() {
        return this.f16423j;
    }

    public final e9 E() {
        c(this.f16429p);
        return this.f16429p;
    }

    public final ab F() {
        h(this.f16431r);
        return this.f16431r;
    }

    public final db G() {
        d(this.f16437x);
        return this.f16437x;
    }

    public final kb H() {
        c(this.f16428o);
        return this.f16428o;
    }

    public final qb I() {
        c(this.f16434u);
        return this.f16434u;
    }

    public final id J() {
        c(this.f16424k);
        return this.f16424k;
    }

    public final af K() {
        g(this.f16425l);
        return this.f16425l;
    }

    public final String L() {
        return this.f16415b;
    }

    public final String M() {
        return this.f16416c;
    }

    public final String N() {
        return this.f16417d;
    }

    public final String O() {
        return this.f16432s;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0269  */
    /* JADX WARN: Code duplicated, block: B:104:0x0282  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:114:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:120:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:122:0x0321  */
    /* JADX WARN: Code duplicated, block: B:126:0x0388  */
    /* JADX WARN: Code duplicated, block: B:136:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:138:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:142:0x040f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0464  */
    /* JADX WARN: Code duplicated, block: B:154:0x0490  */
    /* JADX WARN: Code duplicated, block: B:156:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:94:0x022a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0257  */
    /* JADX WARN: Code duplicated, block: B:99:0x025d  */
    public final void b(zzdz zzdzVar) {
        s8 s8VarH;
        Boolean boolB;
        e9 e9VarE;
        f0 f0Var;
        Boolean boolC;
        boolean zBooleanValue;
        boolean zN;
        d5<Integer> d5Var;
        long jMax;
        zzl().j();
        j jVar = this.f16420g;
        d5<Boolean> d5Var2 = p0.M0;
        boolean z10 = jVar.p(d5Var2) && G().z() == zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
        if ((zzoy.zza() && this.f16420g.p(p0.R0) && K().Q0()) || z10) {
            af afVarK = K();
            afVarK.j();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            if (afVarK.a().p(d5Var2)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            f0.a.registerReceiver(afVarK.zza(), new df(afVarK.f16624a), intentFilter, 2);
            afVarK.zzj().B().a("Registered app receiver");
        }
        if (z10) {
            G().y(p0.f16689y.a(null).longValue());
        }
        s8 s8VarI = C().I();
        int iB = s8VarI.b();
        v8 v8VarZ = this.f16420g.z("google_analytics_default_allow_ad_storage", false);
        v8 v8VarZ2 = this.f16420g.z("google_analytics_default_allow_analytics_storage", false);
        v8 v8Var = v8.UNINITIALIZED;
        if (!(v8VarZ == v8Var && v8VarZ2 == v8Var) && C().t(-10)) {
            s8VarH = s8.h(v8VarZ, v8VarZ2, -10);
        } else {
            if (!TextUtils.isEmpty(y().E()) && (iB == 0 || iB == 30 || iB == 10 || iB == 30 || iB == 30 || iB == 40)) {
                E().a0(new s8(null, null, -10), false);
            } else if (TextUtils.isEmpty(y().E()) && zzdzVar != null && zzdzVar.zzg != null && C().t(30)) {
                s8VarH = s8.e(zzdzVar.zzg, 30);
                if (!s8VarH.y()) {
                }
            }
            s8VarH = null;
        }
        if (s8VarH != null) {
            E().a0(s8VarH, true);
            s8VarI = s8VarH;
        }
        E().Z(s8VarI);
        int iA = C().H().a();
        v8 v8VarZ3 = this.f16420g.z("google_analytics_default_allow_ad_personalization_signals", true);
        if (v8VarZ3 != v8Var) {
            zzj().G().b("Default ad personalization consent from Manifest", v8VarZ3);
        }
        v8 v8VarZ4 = this.f16420g.z("google_analytics_default_allow_ad_user_data", true);
        if (v8VarZ4 == v8Var || !s8.l(-10, iA)) {
            if (TextUtils.isEmpty(y().E()) || !(iA == 0 || iA == 30)) {
                if (TextUtils.isEmpty(y().E()) && zzdzVar != null && zzdzVar.zzg != null && s8.l(30, iA)) {
                    f0 f0VarC = f0.c(zzdzVar.zzg, 30);
                    if (f0VarC.k()) {
                        E().Y(f0VarC, true);
                    }
                }
                if (TextUtils.isEmpty(y().E()) && zzdzVar != null && zzdzVar.zzg != null && C().f16339o.a() == null && (boolB = f0.b(zzdzVar.zzg)) != null) {
                    E().W(zzdzVar.zze, "allow_personalized_ads", boolB.toString(), false);
                }
            } else {
                e9VarE = E();
                f0Var = new f0(null, -10);
            }
            boolC = this.f16420g.C("google_analytics_tcf_data_enabled");
            if (boolC == null) {
                zBooleanValue = true;
            } else {
                zBooleanValue = boolC.booleanValue();
            }
            if (zBooleanValue) {
                zzj().B().a("TCF client enabled.");
                E().J0();
                E().H0();
            }
            if (C().f16331g.a() == 0) {
                zzj().G().b("Persisting first open", Long.valueOf(this.I));
                C().f16331g.b(this.I);
            }
            E().f16156r.c();
            if (!q()) {
                if (TextUtils.isEmpty(y().E()) || !TextUtils.isEmpty(y().B())) {
                    K();
                    if (af.i0(y().E(), C().O(), y().B(), C().N())) {
                        zzj().F().a("Rechecking which service to use due to a GMP App Id change");
                        C().y();
                        z().E();
                        this.f16434u.c0();
                        this.f16434u.b0();
                        C().f16331g.b(this.I);
                        C().f16333i.b(null);
                    }
                    C().E(y().E());
                    C().B(y().B());
                }
                if (!C().I().m(s8.a.ANALYTICS_STORAGE)) {
                    C().f16333i.b(null);
                }
                E().Q0(C().f16333i.a());
                if (!K().R0() && !TextUtils.isEmpty(C().f16348x.a())) {
                    zzj().H().a("Remote config removed with active feature rollouts");
                    C().f16348x.b(null);
                }
                if (TextUtils.isEmpty(y().E()) || !TextUtils.isEmpty(y().B())) {
                    zN = n();
                    if (!C().z() && !this.f16420g.U()) {
                        C().C(!zN);
                    }
                    if (zN) {
                        E().C0();
                    }
                    J().f16367e.a();
                    I().F(new AtomicReference<>());
                    I().z(C().A.a());
                }
            } else if (n()) {
                if (!K().B0("android.permission.INTERNET")) {
                    zzj().C().a("App is missing INTERNET permission");
                }
                if (!K().B0("android.permission.ACCESS_NETWORK_STATE")) {
                    zzj().C().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!l4.d.a(this.f16414a).f() && !this.f16420g.V()) {
                    if (!af.Z(this.f16414a)) {
                        zzj().C().a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!af.a0(this.f16414a, false)) {
                        zzj().C().a("AppMeasurementService not registered/enabled");
                    }
                }
                zzj().C().a("Uploading is not possible. App measurement disabled");
            }
            if (zzoy.zza() && this.f16420g.p(p0.R0) && K().Q0()) {
                d5Var = p0.f16678s0;
                if (d5Var.a(null).intValue() > 0) {
                    jMax = Math.max(500L, ((((long) d5Var.a(null).intValue()) * 1000) + ((long) new Random().nextInt(5000))) - this.f16427n.b());
                    if (jMax > 500) {
                        zzj().G().b("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
                    }
                    E().Y0(jMax);
                } else {
                    final e9 e9VarE2 = E();
                    Objects.requireNonNull(e9VarE2);
                    new Thread(new Runnable() { // from class: u4.j7
                        @Override // java.lang.Runnable
                        public final void run() {
                            e9VarE2.F0();
                        }
                    }).start();
                }
            }
            C().f16341q.a(true);
        }
        e9VarE = E();
        f0Var = f0.e(v8VarZ4, -10);
        e9VarE.Y(f0Var, true);
        boolC = this.f16420g.C("google_analytics_tcf_data_enabled");
        if (boolC == null) {
            zBooleanValue = true;
        } else {
            zBooleanValue = boolC.booleanValue();
        }
        if (zBooleanValue) {
            zzj().B().a("TCF client enabled.");
            E().J0();
            E().H0();
        }
        if (C().f16331g.a() == 0) {
            zzj().G().b("Persisting first open", Long.valueOf(this.I));
            C().f16331g.b(this.I);
        }
        E().f16156r.c();
        if (!q()) {
            if (TextUtils.isEmpty(y().E())) {
                K();
                if (af.i0(y().E(), C().O(), y().B(), C().N())) {
                    zzj().F().a("Rechecking which service to use due to a GMP App Id change");
                    C().y();
                    z().E();
                    this.f16434u.c0();
                    this.f16434u.b0();
                    C().f16331g.b(this.I);
                    C().f16333i.b(null);
                }
                C().E(y().E());
                C().B(y().B());
            } else {
                K();
                if (af.i0(y().E(), C().O(), y().B(), C().N())) {
                    zzj().F().a("Rechecking which service to use due to a GMP App Id change");
                    C().y();
                    z().E();
                    this.f16434u.c0();
                    this.f16434u.b0();
                    C().f16331g.b(this.I);
                    C().f16333i.b(null);
                }
                C().E(y().E());
                C().B(y().B());
            }
            if (!C().I().m(s8.a.ANALYTICS_STORAGE)) {
                C().f16333i.b(null);
            }
            E().Q0(C().f16333i.a());
            if (!K().R0()) {
                zzj().H().a("Remote config removed with active feature rollouts");
                C().f16348x.b(null);
            }
            if (TextUtils.isEmpty(y().E())) {
                zN = n();
                if (!C().z()) {
                    C().C(!zN);
                }
                if (zN) {
                    E().C0();
                }
                J().f16367e.a();
                I().F(new AtomicReference<>());
                I().z(C().A.a());
            } else {
                zN = n();
                if (!C().z()) {
                    C().C(!zN);
                }
                if (zN) {
                    E().C0();
                }
                J().f16367e.a();
                I().F(new AtomicReference<>());
                I().z(C().A.a());
            }
        } else if (n()) {
            if (!K().B0("android.permission.INTERNET")) {
                zzj().C().a("App is missing INTERNET permission");
            }
            if (!K().B0("android.permission.ACCESS_NETWORK_STATE")) {
                zzj().C().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!l4.d.a(this.f16414a).f()) {
                if (!af.Z(this.f16414a)) {
                    zzj().C().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!af.a0(this.f16414a, false)) {
                    zzj().C().a("AppMeasurementService not registered/enabled");
                }
            }
            zzj().C().a("Uploading is not possible. App measurement disabled");
        }
        if (zzoy.zza()) {
            d5Var = p0.f16678s0;
            if (d5Var.a(null).intValue() > 0) {
                jMax = Math.max(500L, ((((long) d5Var.a(null).intValue()) * 1000) + ((long) new Random().nextInt(5000))) - this.f16427n.b());
                if (jMax > 500) {
                    zzj().G().b("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
                }
                E().Y0(jMax);
            } else {
                final e9 e9VarE3 = E();
                Objects.requireNonNull(e9VarE3);
                new Thread(new Runnable() { // from class: u4.j7
                    @Override // java.lang.Runnable
                    public final void run() {
                        e9VarE3.F0();
                    }
                }).start();
            }
        }
        C().f16341q.a(true);
    }

    public final void i(boolean z10) {
        this.B = Boolean.valueOf(z10);
    }

    public final void j() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public final void k() {
        this.H.incrementAndGet();
    }

    public final void l() {
        this.F++;
    }

    public final boolean m() {
        return this.B != null && this.B.booleanValue();
    }

    public final boolean n() {
        return u() == 0;
    }

    public final boolean o() {
        zzl().j();
        return this.E;
    }

    public final boolean p() {
        return TextUtils.isEmpty(this.f16415b);
    }

    public final boolean q() {
        if (!this.f16438y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().j();
        Boolean bool = this.f16439z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f16427n.b() - this.A) > 1000)) {
            this.A = this.f16427n.b();
            boolean z10 = true;
            Boolean boolValueOf = Boolean.valueOf(K().B0("android.permission.INTERNET") && K().B0("android.permission.ACCESS_NETWORK_STATE") && (l4.d.a(this.f16414a).f() || this.f16420g.V() || (af.Z(this.f16414a) && af.a0(this.f16414a, false))));
            this.f16439z = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!K().g0(y().E(), y().B()) && TextUtils.isEmpty(y().B())) {
                    z10 = false;
                }
                this.f16439z = Boolean.valueOf(z10);
            }
        }
        return this.f16439z.booleanValue();
    }

    public final boolean r() {
        return this.f16418e;
    }

    public final boolean s() {
        zzl().j();
        h(F());
        String strC = y().C();
        if (!this.f16420g.S()) {
            zzj().G().a("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair<String, Boolean> pairQ = C().q(strC);
        if (((Boolean) pairQ.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairQ.first)) {
            zzj().G().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!F().s()) {
            zzj().H().a("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        qb qbVarI = I();
        qbVarI.j();
        qbVarI.u();
        if (!qbVarI.k0() || qbVarI.g().D0() >= 234200) {
            q qVarP0 = E().p0();
            Bundle bundle = qVarP0 != null ? qVarP0.f16722a : null;
            if (bundle == null) {
                int i10 = this.G;
                this.G = i10 + 1;
                boolean z10 = i10 < 10;
                zzj().B().b("Failed to retrieve DMA consent from the service, " + (z10 ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.G));
                return z10;
            }
            s8 s8VarE = s8.e(bundle, 100);
            sb2.append("&gcs=");
            sb2.append(s8VarE.u());
            f0 f0VarC = f0.c(bundle, 100);
            sb2.append("&dma=");
            sb2.append(f0VarC.h() == Boolean.FALSE ? 0 : 1);
            if (!TextUtils.isEmpty(f0VarC.i())) {
                sb2.append("&dma_cps=");
                sb2.append(f0VarC.i());
            }
            int i11 = f0.b(bundle) == Boolean.TRUE ? 0 : 1;
            sb2.append("&npa=");
            sb2.append(i11);
            zzj().G().b("Consent query parameters to Bow", sb2);
        }
        af afVarK = K();
        y();
        URL urlF = afVarK.F(114010L, strC, (String) pairQ.first, C().f16347w.a() - 1, sb2.toString());
        if (urlF != null) {
            ab abVarF = F();
            za zaVar = new za() { // from class: u4.m7
                @Override // u4.za
                public final void a(String str, int i12, Throwable th, byte[] bArr, Map map) {
                    k7.e(this.f16510a, str, i12, th, bArr, map);
                }
            };
            abVarF.l();
            com.google.android.gms.common.internal.r.l(urlF);
            com.google.android.gms.common.internal.r.l(zaVar);
            abVarF.zzl().t(new cb(abVarF, strC, urlF, null, null, zaVar));
        }
        return false;
    }

    public final void t(boolean z10) {
        zzl().j();
        this.E = z10;
    }

    public final int u() {
        zzl().j();
        if (this.f16420g.U()) {
            return 1;
        }
        Boolean bool = this.D;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!o()) {
            return 8;
        }
        Boolean boolL = C().L();
        if (boolL != null) {
            return boolL.booleanValue() ? 0 : 3;
        }
        Boolean boolC = this.f16420g.C("firebase_analytics_collection_enabled");
        if (boolC != null) {
            return boolC.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.C;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        return (this.B == null || this.B.booleanValue()) ? 0 : 7;
    }

    public final a v() {
        d(this.f16430q);
        return this.f16430q;
    }

    public final j w() {
        return this.f16420g;
    }

    public final h0 x() {
        h(this.f16435v);
        return this.f16435v;
    }

    public final n5 y() {
        c(this.f16436w);
        return this.f16436w;
    }

    public final q5 z() {
        c(this.f16433t);
        return this.f16433t;
    }

    @Override // u4.q8
    public final Context zza() {
        return this.f16414a;
    }

    @Override // u4.q8
    public final j4.d zzb() {
        return this.f16427n;
    }

    @Override // u4.q8
    public final g zzd() {
        return this.f16419f;
    }

    @Override // u4.q8
    public final v5 zzj() {
        h(this.f16422i);
        return this.f16422i;
    }

    @Override // u4.q8
    public final d7 zzl() {
        h(this.f16423j);
        return this.f16423j;
    }
}
