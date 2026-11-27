package u4;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzoy;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class e9 extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public va f16141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z8 f16142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<c9> f16143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<String> f16145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f16146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d0 f16149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d0 f16150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PriorityQueue<sd> f16151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public s8 f16153o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f16154p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f16155q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final hf f16156r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16157s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d0 f16158t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f16159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d0 f16160v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final cf f16161w;

    public e9(k7 k7Var) {
        super(k7Var);
        this.f16143e = new CopyOnWriteArraySet();
        this.f16146h = new Object();
        this.f16147i = false;
        this.f16148j = 1;
        this.f16157s = true;
        this.f16161w = new oa(this);
        this.f16145g = new AtomicReference<>();
        this.f16153o = s8.f16793c;
        this.f16155q = -1L;
        this.f16154p = new AtomicLong(0L);
        this.f16156r = new hf(k7Var);
    }

    public static /* synthetic */ int B(e9 e9Var, Throwable th) {
        String message = th.getMessage();
        e9Var.f16152n = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            e9Var.f16152n = true;
        }
        return 1;
    }

    public static /* synthetic */ void U0(e9 e9Var, int i10) {
        if (e9Var.f16149k == null) {
            e9Var.f16149k = new y9(e9Var, e9Var.f16624a);
        }
        e9Var.f16149k.b(((long) i10) * 1000);
    }

    public static /* synthetic */ void V0(e9 e9Var, Bundle bundle) {
        e9Var.j();
        e9Var.u();
        com.google.android.gms.common.internal.r.l(bundle);
        String strF = com.google.android.gms.common.internal.r.f(bundle.getString("name"));
        if (!e9Var.f16624a.n()) {
            e9Var.zzj().G().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            e9Var.q().L(new h(bundle.getString("app_id"), "", new ze(strF, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), e9Var.g().G(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public static /* synthetic */ void c1(e9 e9Var, Bundle bundle) {
        e9Var.j();
        e9Var.u();
        com.google.android.gms.common.internal.r.l(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        com.google.android.gms.common.internal.r.f(string);
        com.google.android.gms.common.internal.r.f(string2);
        com.google.android.gms.common.internal.r.l(bundle.get("value"));
        if (!e9Var.f16624a.n()) {
            e9Var.zzj().G().a("Conditional property not set since app measurement is disabled");
            return;
        }
        ze zeVar = new ze(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            n0 n0VarG = e9Var.g().G(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            e9Var.q().L(new h(bundle.getString("app_id"), string2, zeVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), e9Var.g().G(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), n0VarG, bundle.getLong("time_to_live"), e9Var.g().G(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public static /* synthetic */ void e0(e9 e9Var, SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            e9Var.zzj().G().a("IABTCF_TCString change picked up in listener.");
            ((d0) com.google.android.gms.common.internal.r.l(e9Var.f16160v)).b(500L);
        }
    }

    public static /* synthetic */ void f0(e9 e9Var, Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = new Bundle(e9Var.e().A.a());
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    e9Var.g();
                    if (af.d0(obj)) {
                        e9Var.g();
                        af.V(e9Var.f16161w, 27, null, null, 0);
                    }
                    e9Var.zzj().I().c("Invalid default event parameter type. Name, value", str, obj);
                } else if (af.C0(str)) {
                    e9Var.zzj().I().b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (e9Var.g().h0("param", str, e9Var.a().n(null, false), obj)) {
                    e9Var.g().K(bundle2, str, obj);
                }
            }
            e9Var.g();
            if (af.c0(bundle2, e9Var.a().w())) {
                e9Var.g();
                af.V(e9Var.f16161w, 26, null, null, 0);
                e9Var.zzj().I().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        e9Var.e().A.b(bundle2);
        if (!bundle.isEmpty() || e9Var.a().p(p0.Z0)) {
            e9Var.q().z(bundle2);
        }
    }

    public static /* synthetic */ void g0(e9 e9Var, Bundle bundle, long j10) {
        if (TextUtils.isEmpty(e9Var.l().E())) {
            e9Var.I(bundle, 0, j10);
        } else {
            e9Var.zzj().I().a("Using developer consent only; google app id found");
        }
    }

    public static /* synthetic */ void i0(e9 e9Var, String str) {
        if (e9Var.l().I(str)) {
            e9Var.l().G();
        }
    }

    public static /* synthetic */ void j0(e9 e9Var, List list) {
        e9Var.j();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayG = e9Var.e().G();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sd sdVar = (sd) it.next();
                if (!sparseArrayG.contains(sdVar.f16813c) || sparseArrayG.get(sdVar.f16813c).longValue() < sdVar.f16812b) {
                    e9Var.A0().add(sdVar);
                }
            }
            e9Var.I0();
        }
    }

    public static /* synthetic */ void k0(e9 e9Var, AtomicReference atomicReference) {
        Bundle bundleA = e9Var.e().f16340p.a();
        qb qbVarQ = e9Var.q();
        if (bundleA == null) {
            bundleA = new Bundle();
        }
        qbVarQ.G(atomicReference, bundleA);
    }

    public static /* synthetic */ void l0(e9 e9Var, AtomicReference atomicReference, zd zdVar, String str, int i10, Throwable th, byte[] bArr, Map map) {
        e9Var.j();
        boolean z10 = (i10 == 200 || i10 == 204 || i10 == 304) && th == null;
        if (z10) {
            e9Var.zzj().G().b("[sgtm] Upload succeeded for row_id", Long.valueOf(zdVar.f17007a));
        } else {
            e9Var.zzj().H().d("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zdVar.f17007a), Integer.valueOf(i10), th);
        }
        e9Var.q().K(new f(zdVar.f17007a, (z10 ? gb.SUCCESS : gb.FAILURE).zza(), zdVar.f17012f));
        e9Var.zzj().G().c("[sgtm] Updated status for row_id", Long.valueOf(zdVar.f17007a), z10 ? "SUCCESS" : "FAILURE");
        synchronized (atomicReference) {
            atomicReference.set(Boolean.valueOf(z10));
            atomicReference.notifyAll();
        }
    }

    public static /* synthetic */ void m0(e9 e9Var, s8 s8Var, long j10, boolean z10, boolean z11) {
        e9Var.j();
        e9Var.u();
        s8 s8VarI = e9Var.e().I();
        if (j10 <= e9Var.f16155q && s8.l(s8VarI.b(), s8Var.b())) {
            e9Var.zzj().F().b("Dropped out-of-date consent setting, proposed settings", s8Var);
            return;
        }
        if (!e9Var.e().w(s8Var)) {
            e9Var.zzj().F().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(s8Var.b()));
            return;
        }
        e9Var.zzj().G().b("Setting storage consent(FE)", s8Var);
        e9Var.f16155q = j10;
        if (e9Var.q().j0()) {
            e9Var.q().o0(z10);
        } else {
            e9Var.q().W(z10);
        }
        if (z11) {
            e9Var.q().F(new AtomicReference<>());
        }
    }

    public static int z(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return 25;
    }

    public final PriorityQueue<sd> A0() {
        if (this.f16151m == null) {
            this.f16151m = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: u4.h9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((sd) obj).f16812b);
                }
            }, new Comparator() { // from class: u4.g9
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.f16151m;
    }

    public final void B0() {
        j();
        u();
        qb qbVarQ = q();
        qbVarQ.j();
        qbVarQ.u();
        boolean z10 = true;
        if (qbVarQ.k0() && qbVarQ.g().D0() < 242600) {
            z10 = false;
        }
        if (z10) {
            q().Z();
        }
    }

    public final void C0() {
        j();
        u();
        if (this.f16624a.q()) {
            Boolean boolC = a().C("google_analytics_deferred_deep_link_enabled");
            if (boolC != null && boolC.booleanValue()) {
                zzj().B().a("Deferred Deep Link feature enabled.");
                zzl().y(new Runnable() { // from class: u4.p9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16703a.G0();
                    }
                });
            }
            q().a0();
            this.f16157s = false;
            String strM = e().M();
            if (TextUtils.isEmpty(strM)) {
                return;
            }
            c().l();
            if (strM.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strM);
            a1("auto", "_ou", bundle);
        }
    }

    public final ArrayList<Bundle> D(String str, String str2) {
        if (zzl().G()) {
            zzj().C().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (g.a()) {
            zzj().C().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f16624a.zzl().q(atomicReference, 5000L, "get conditional user properties", new ia(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return af.p0(list);
        }
        zzj().C().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final void D0() {
        j();
        d0 d0Var = this.f16150l;
        if (d0Var != null) {
            d0Var.a();
        }
    }

    public final Map<String, Object> E(String str, String str2, boolean z10) {
        x5 x5VarC;
        String str3;
        if (!zzl().G()) {
            if (g.a()) {
                x5VarC = zzj().C();
                str3 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                this.f16624a.zzl().q(atomicReference, 5000L, "get user properties", new ma(this, atomicReference, null, str, str2, z10));
                List<ze> list = (List) atomicReference.get();
                if (list != null) {
                    t.a aVar = new t.a(list.size());
                    for (ze zeVar : list) {
                        Object objS = zeVar.S();
                        if (objS != null) {
                            aVar.put(zeVar.f17015b, objS);
                        }
                    }
                    return aVar;
                }
                zzj().C().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            }
            return Collections.emptyMap();
        }
        x5VarC = zzj().C();
        str3 = "Cannot get user properties from analytics worker thread";
        x5VarC.a(str3);
        return Collections.emptyMap();
    }

    public final void E0() {
        if (!(zza().getApplicationContext() instanceof Application) || this.f16141c == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f16141c);
    }

    public final void F(long j10) {
        Q0(null);
        zzl().y(new ha(this, j10));
    }

    public final void F0() {
        if (zzoy.zza() && a().p(p0.R0)) {
            if (zzl().G()) {
                zzj().C().a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (g.a()) {
                zzj().C().a("Cannot get trigger URIs from main thread");
                return;
            }
            u();
            zzj().G().a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().q(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: u4.i9
                @Override // java.lang.Runnable
                public final void run() {
                    e9.k0(this.f16357a, atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().C().a("Timed out waiting for get trigger URIs");
            } else {
                zzl().y(new Runnable() { // from class: u4.m9
                    @Override // java.lang.Runnable
                    public final void run() {
                        e9.j0(this.f16514a, list);
                    }
                });
            }
        }
    }

    public final void G(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            zzj().F().a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            zzj().F().a("Preview Mode was not enabled.");
            a().J(null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        zzj().F().b("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
        a().J(queryParameter2);
    }

    public final void G0() {
        j();
        if (e().f16346v.b()) {
            zzj().B().a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jA = e().f16347w.a();
        e().f16347w.b(1 + jA);
        if (jA >= 5) {
            zzj().H().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            e().f16346v.a(true);
        } else {
            if (this.f16158t == null) {
                this.f16158t = new fa(this, this.f16624a);
            }
            this.f16158t.b(0L);
        }
    }

    public final void H(Bundle bundle) {
        J(bundle, zzb().a());
    }

    public final void H0() {
        j();
        zzj().B().a("Handle tcf update.");
        qd qdVarD = qd.d(e().D());
        zzj().G().b("Tcf preferences read", qdVarD);
        if (e().x(qdVarD)) {
            Bundle bundleB = qdVarD.b();
            zzj().G().b("Consent generated from Tcf", bundleB);
            if (bundleB != Bundle.EMPTY) {
                I(bundleB, -30, zzb().a());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", qdVarD.e());
            a1("auto", "_tcf", bundle);
        }
    }

    public final void I(Bundle bundle, int i10, long j10) {
        u();
        String strD = s8.d(bundle);
        if (strD != null) {
            zzj().I().b("Ignoring invalid consent setting", strD);
            zzj().I().a("Valid consent values are 'granted', 'denied'");
        }
        boolean zG = zzl().G();
        s8 s8VarE = s8.e(bundle, i10);
        if (s8VarE.y()) {
            a0(s8VarE, zG);
        }
        f0 f0VarC = f0.c(bundle, i10);
        if (f0VarC.k()) {
            Y(f0VarC, zG);
        }
        Boolean boolB = f0.b(bundle);
        if (boolB != null) {
            String str = i10 == -30 ? "tcf" : "app";
            String string = boolB.toString();
            if (zG) {
                V(str, "allow_personalized_ads", string, j10);
            } else {
                X(str, "allow_personalized_ads", string, false, j10);
            }
        }
    }

    public final void I0() {
        sd sdVarPoll;
        w1.a aVarM0;
        j();
        this.f16152n = false;
        if (A0().isEmpty() || this.f16147i || (sdVarPoll = A0().poll()) == null || (aVarM0 = g().M0()) == null) {
            return;
        }
        this.f16147i = true;
        zzj().G().b("Registering trigger URI", sdVarPoll.f16811a);
        p6.e<lc.q> eVarC = aVarM0.c(Uri.parse(sdVarPoll.f16811a));
        if (eVarC != null) {
            p6.c.a(eVarC, new v9(this, sdVarPoll), new w9(this));
        } else {
            this.f16147i = false;
            A0().add(sdVarPoll);
        }
    }

    public final void J(Bundle bundle, long j10) {
        com.google.android.gms.common.internal.r.l(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().H().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        com.google.android.gms.common.internal.r.l(bundle2);
        t8.a(bundle2, "app_id", String.class, null);
        t8.a(bundle2, "origin", String.class, null);
        t8.a(bundle2, "name", String.class, null);
        t8.a(bundle2, "value", Object.class, null);
        t8.a(bundle2, "trigger_event_name", String.class, null);
        t8.a(bundle2, "trigger_timeout", Long.class, 0L);
        t8.a(bundle2, "timed_out_event_name", String.class, null);
        t8.a(bundle2, "timed_out_event_params", Bundle.class, null);
        t8.a(bundle2, "triggered_event_name", String.class, null);
        t8.a(bundle2, "triggered_event_params", Bundle.class, null);
        t8.a(bundle2, "time_to_live", Long.class, 0L);
        t8.a(bundle2, "expired_event_name", String.class, null);
        t8.a(bundle2, "expired_event_params", Bundle.class, null);
        com.google.android.gms.common.internal.r.f(bundle2.getString("name"));
        com.google.android.gms.common.internal.r.f(bundle2.getString("origin"));
        com.google.android.gms.common.internal.r.l(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (g().n0(string) != 0) {
            zzj().C().b("Invalid conditional user property name", d().g(string));
            return;
        }
        if (g().s(string, obj) != 0) {
            zzj().C().c("Invalid conditional user property value", d().g(string), obj);
            return;
        }
        Object objW0 = g().w0(string, obj);
        if (objW0 == null) {
            zzj().C().c("Unable to normalize conditional user property value", d().g(string), obj);
            return;
        }
        t8.b(bundle2, objW0);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j11 > 15552000000L || j11 < 1)) {
            zzj().C().c("Invalid conditional user property timeout", d().g(string), Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong("time_to_live");
        if (j12 > 15552000000L || j12 < 1) {
            zzj().C().c("Invalid conditional user property time to live", d().g(string), Long.valueOf(j12));
        } else {
            zzl().y(new ga(this, bundle2));
        }
    }

    public final void J0() {
        j();
        zzj().B().a("Register tcfPrefChangeListener.");
        if (this.f16159u == null) {
            this.f16160v = new ca(this, this.f16624a);
            this.f16159u = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: u4.s9
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    e9.e0(this.f16802a, sharedPreferences, str);
                }
            };
        }
        e().D().registerOnSharedPreferenceChangeListener(this.f16159u);
    }

    public final void K(zzdq zzdqVar) {
        zzl().y(new la(this, zzdqVar));
    }

    public final boolean K0() {
        return this.f16152n;
    }

    public final void L(Boolean bool) {
        u();
        zzl().y(new sa(this, bool));
    }

    public final void L0() {
        j();
        String strA = e().f16339o.a();
        if (strA != null) {
            if ("unset".equals(strA)) {
                V("app", "_npa", null, zzb().a());
            } else {
                V("app", "_npa", Long.valueOf("true".equals(strA) ? 1L : 0L), zzb().a());
            }
        }
        if (!this.f16624a.n() || !this.f16157s) {
            zzj().B().a("Updating Scion state (FE)");
            q().f0();
        } else {
            zzj().B().a("Recording app launch after enabling measurement for the first time (FE)");
            C0();
            r().f16367e.a();
            zzl().y(new aa(this));
        }
    }

    public final void M(Boolean bool, boolean z10) {
        j();
        u();
        zzj().B().b("Setting app measurement enabled (FE)", bool);
        e().r(bool);
        if (z10) {
            e().A(bool);
        }
        if (this.f16624a.o() || !(bool == null || bool.booleanValue())) {
            L0();
        }
    }

    public final void N(Runnable runnable) {
        if (a().p(p0.M0)) {
            u();
            if (zzl().G()) {
                zzj().C().a("Cannot retrieve and upload batches from analytics worker thread");
                return;
            }
            if (zzl().F()) {
                zzj().C().a("Cannot retrieve and upload batches from analytics network thread");
                return;
            }
            if (g.a()) {
                zzj().C().a("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzj().G().a("[sgtm] Started client-side batch upload work.");
            boolean z10 = false;
            int size = 0;
            int i10 = 0;
            while (!z10) {
                zzj().G().a("[sgtm] Getting upload batches from service (FE)");
                final AtomicReference atomicReference = new AtomicReference();
                zzl().q(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: u4.o9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16625a.q().J(atomicReference, be.S(fb.SGTM_CLIENT));
                    }
                });
                de deVar = (de) atomicReference.get();
                if (deVar != null && !deVar.f16122a.isEmpty()) {
                    zzj().G().b("[sgtm] Retrieved upload batches. count", Integer.valueOf(deVar.f16122a.size()));
                    size += deVar.f16122a.size();
                    Iterator<zd> it = deVar.f16122a.iterator();
                    while (it.hasNext()) {
                        if (!o0(it.next())) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                } else {
                    break;
                }
            }
            zzj().G().c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i10));
            runnable.run();
        }
    }

    public final void N0(long j10) {
        j();
        u();
        zzj().B().a("Resetting analytics data (FE)");
        id idVarR = r();
        idVarR.j();
        idVarR.f16368f.b();
        l().G();
        boolean zN = this.f16624a.n();
        i6 i6VarE = e();
        i6VarE.f16331g.b(j10);
        if (!TextUtils.isEmpty(i6VarE.e().f16348x.a())) {
            i6VarE.f16348x.b(null);
        }
        i6VarE.f16342r.b(0L);
        i6VarE.f16343s.b(0L);
        if (!i6VarE.a().U()) {
            i6VarE.C(!zN);
        }
        i6VarE.f16349y.b(null);
        i6VarE.f16350z.b(0L);
        i6VarE.A.b(null);
        q().d0();
        r().f16367e.a();
        this.f16157s = !zN;
    }

    public final void O(final String str, long j10) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.f16624a.zzj().H().a("User ID must be non-empty or null");
        } else {
            zzl().y(new Runnable() { // from class: u4.j9
                @Override // java.lang.Runnable
                public final void run() {
                    e9.i0(this.f16393a, str);
                }
            });
            X(null, "_id", str, true, j10);
        }
    }

    public final void O0(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().y(new Runnable() { // from class: u4.l9
            @Override // java.lang.Runnable
            public final void run() {
                e9.f0(this.f16486a, bundle2);
            }
        });
    }

    public final void P(String str, String str2, long j10, Bundle bundle) {
        j();
        Q(str, str2, j10, bundle, true, this.f16142d == null || af.C0(str2), true, null);
    }

    public final void P0(final Bundle bundle, final long j10) {
        zzl().C(new Runnable() { // from class: u4.q9
            @Override // java.lang.Runnable
            public final void run() {
                e9.g0(this.f16732a, bundle, j10);
            }
        });
    }

    public final void Q(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        long j11;
        boolean z13;
        int length;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(bundle);
        j();
        u();
        if (!this.f16624a.n()) {
            zzj().B().a("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listF = l().F();
        if (listF != null && !listF.contains(str2)) {
            zzj().B().c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        boolean z14 = true;
        if (!this.f16144f) {
            this.f16144f = true;
            try {
                try {
                    (!this.f16624a.r() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e10) {
                    zzj().H().b("Failed to invoke Tag Manager's initialize() method", e10);
                }
            } catch (ClassNotFoundException unused) {
                zzj().F().a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            V("auto", "_lgclid", bundle.getString("gclid"), zzb().a());
        }
        if (z10 && af.F0(str2)) {
            g().J(bundle, e().A.a());
        }
        if (!z12 && !"_iap".equals(str2)) {
            af afVarK = this.f16624a.K();
            int i10 = 2;
            if (afVarK.y0("event", str2)) {
                if (!afVarK.l0("event", y8.f16974a, y8.f16975b, str2)) {
                    i10 = 13;
                } else if (afVarK.f0("event", 40, str2)) {
                    i10 = 0;
                }
            }
            if (i10 != 0) {
                zzj().D().b("Invalid public event name. Event will not be logged (FE)", d().b(str2));
                this.f16624a.K();
                String strE = af.E(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.f16624a.K();
                af.V(this.f16161w, i10, "_ev", strE, length);
                return;
            }
        }
        hb hbVarZ = p().z(false);
        if (hbVarZ != null && !bundle.containsKey("_sc")) {
            hbVarZ.f16314d = true;
        }
        af.U(hbVarZ, bundle, z10 && !z12);
        boolean zEquals = "am".equals(str);
        boolean zC0 = af.C0(str2);
        if (z10 && this.f16142d != null && !zC0 && !zEquals) {
            zzj().B().c("Passing event to registered event handler (FE)", d().b(str2), d().a(bundle));
            com.google.android.gms.common.internal.r.l(this.f16142d);
            this.f16142d.a(str, str2, bundle, j10);
            return;
        }
        if (this.f16624a.q()) {
            int iR = g().r(str2);
            if (iR != 0) {
                zzj().D().b("Invalid event name. Event will not be logged (FE)", d().b(str2));
                g();
                String strE2 = af.E(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.f16624a.K();
                af.W(this.f16161w, str3, iR, "_ev", strE2, length);
                return;
            }
            Bundle bundleB = g().B(str3, str2, bundle, j4.e.b("_o", "_sn", "_sc", "_si"), z12);
            com.google.android.gms.common.internal.r.l(bundleB);
            if (p().z(false) != null && "_ae".equals(str2)) {
                pd pdVar = r().f16368f;
                long jB = pdVar.f16717d.zzb().b();
                long j12 = jB - pdVar.f16715b;
                pdVar.f16715b = jB;
                if (j12 > 0) {
                    g().I(bundleB, j12);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                af afVarG = g();
                String string = bundleB.getString("_ffr");
                if (j4.q.b(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, afVarG.e().f16348x.a())) {
                    afVarG.zzj().B().a("Not logging duplicate session_start_with_rollout event");
                    z13 = false;
                } else {
                    afVarG.e().f16348x.b(string);
                    z13 = true;
                }
                if (!z13) {
                    return;
                }
            } else if ("_ae".equals(str2)) {
                String strA = g().e().f16348x.a();
                if (!TextUtils.isEmpty(strA)) {
                    bundleB.putString("_ffr", strA);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleB);
            boolean zC = a().p(p0.W0) ? r().C() : e().f16345u.b();
            if (e().f16342r.a() > 0 && e().u(j10) && zC) {
                zzj().G().a("Current session is expired, remove the session number, ID, and engagement time");
                j11 = 0;
                V("auto", "_sid", null, zzb().a());
                V("auto", "_sno", null, zzb().a());
                V("auto", "_se", null, zzb().a());
                e().f16343s.b(0L);
            } else {
                j11 = 0;
            }
            if (bundleB.getLong("extend_session", j11) == 1) {
                zzj().G().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.f16624a.J().f16367e.b(j10, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleB.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                String str4 = (String) obj;
                if (str4 != null) {
                    g();
                    Bundle[] bundleArrT0 = af.t0(bundleB.get(str4));
                    if (bundleArrT0 != null) {
                        bundleB.putParcelableArray(str4, bundleArrT0);
                    }
                }
            }
            int i12 = 0;
            while (i12 < arrayList.size()) {
                Bundle bundleA = (Bundle) arrayList.get(i12);
                String str5 = i12 != 0 ? z14 : false ? "_ep" : str2;
                bundleA.putString("_o", str);
                if (z11) {
                    bundleA = g().A(bundleA, null);
                }
                Bundle bundle2 = bundleA;
                q().M(new n0(str5, new i0(bundle2), str, j10), str3);
                if (!zEquals) {
                    Iterator<c9> it = this.f16143e.iterator();
                    while (it.hasNext()) {
                        it.next().a(str, str2, new Bundle(bundle2), j10);
                    }
                }
                i12++;
                z14 = true;
            }
            if (p().z(false) == null || !"_ae".equals(str2)) {
                return;
            }
            r().B(true, true, zzb().b());
        }
    }

    public final void Q0(String str) {
        this.f16145g.set(str);
    }

    public final void R(String str, String str2, long j10, Object obj) {
        zzl().y(new ea(this, str, str2, obj, j10));
    }

    public final void R0(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        zzl().y(new ba(this, str, str2, j10, af.z(bundle), z10, z11, z12, str3));
    }

    public final void S(String str, String str2, Bundle bundle) {
        long jA = zzb().a();
        com.google.android.gms.common.internal.r.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jA);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzl().y(new ja(this, bundle2));
    }

    public final void S0(String str, String str2, Bundle bundle) {
        U(str, str2, bundle, true, true, zzb().a());
    }

    public final void T(String str, String str2, Bundle bundle, String str3) {
        i();
        R0(str, str2, zzb().a(), bundle, false, true, true, str3);
    }

    public final void T0(c9 c9Var) {
        u();
        com.google.android.gms.common.internal.r.l(c9Var);
        if (this.f16143e.remove(c9Var)) {
            return;
        }
        zzj().H().a("OnEventListener had not been registered");
    }

    public final void U(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            p().A(bundle2, j10);
        } else {
            R0(str3, str2, j10, bundle2, z11, !z11 || this.f16142d == null || af.C0(str2), z10, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    public final void V(String str, String str2, Object obj, long j10) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        u();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long lValueOf = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    e().f16339o.b(lValueOf.longValue() == 1 ? "true" : "false");
                    obj = lValueOf;
                } else if (obj == null) {
                    e().f16339o.b("unset");
                }
                str2 = "_npa";
            } else if (obj == null) {
                e().f16339o.b("unset");
                str2 = "_npa";
            }
            zzj().G().c("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.f16624a.n()) {
            zzj().G().a("User property not set since app measurement is disabled");
        } else if (this.f16624a.q()) {
            q().V(new ze(str4, j10, obj2, str));
        }
    }

    public final void W(String str, String str2, Object obj, boolean z10) {
        X(str, str2, obj, z10, zzb().a());
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public final void X(String str, String str2, Object obj, boolean z10, long j10) {
        int iN0;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z10) {
            iN0 = g().n0(str2);
        } else {
            af afVarG = g();
            if (!afVarG.y0("user property", str2)) {
                iN0 = 6;
            } else if (!afVarG.k0("user property", a9.f15988a, str2)) {
                iN0 = 15;
            } else if (afVarG.f0("user property", 24, str2)) {
                iN0 = 0;
            } else {
                iN0 = 6;
            }
        }
        if (iN0 != 0) {
            g();
            String strE = af.E(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.f16624a.K();
            af.V(this.f16161w, iN0, "_ev", strE, length);
            return;
        }
        if (obj == null) {
            R(str3, str2, j10, null);
            return;
        }
        int iS = g().s(str2, obj);
        if (iS == 0) {
            Object objW0 = g().w0(str2, obj);
            if (objW0 != null) {
                R(str3, str2, j10, objW0);
                return;
            }
            return;
        }
        g();
        String strE2 = af.E(str2, 24, true);
        length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
        this.f16624a.K();
        af.V(this.f16161w, iS, "_ev", strE2, length);
    }

    public final void X0(boolean z10) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.f16141c == null) {
                this.f16141c = new va(this);
            }
            if (z10) {
                application.unregisterActivityLifecycleCallbacks(this.f16141c);
                application.registerActivityLifecycleCallbacks(this.f16141c);
                zzj().G().a("Registered activity lifecycle callback");
            }
        }
    }

    public final void Y(f0 f0Var, boolean z10) {
        ra raVar = new ra(this, f0Var);
        if (!z10) {
            zzl().y(raVar);
        } else {
            j();
            raVar.run();
        }
    }

    public final void Y0(long j10) {
        j();
        if (this.f16150l == null) {
            this.f16150l = new u9(this, this.f16624a);
        }
        this.f16150l.b(j10);
    }

    public final void Z(s8 s8Var) {
        j();
        boolean z10 = (s8Var.x() && s8Var.w()) || q().i0();
        if (z10 != this.f16624a.o()) {
            this.f16624a.t(z10);
            Boolean boolK = e().K();
            if (!z10 || boolK == null || boolK.booleanValue()) {
                M(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void Z0(Bundle bundle, long j10) {
        I(bundle, -20, j10);
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    public final void a0(s8 s8Var, boolean z10) {
        boolean z11;
        s8 s8Var2;
        boolean zS;
        boolean z12;
        u();
        int iB = s8Var.b();
        if (iB != -10) {
            v8 v8VarR = s8Var.r();
            v8 v8Var = v8.UNINITIALIZED;
            if (v8VarR == v8Var && s8Var.t() == v8Var) {
                zzj().I().a("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.f16146h) {
            z11 = false;
            if (s8.l(iB, this.f16153o.b())) {
                zS = s8Var.s(this.f16153o);
                if (s8Var.x() && !this.f16153o.x()) {
                    z11 = true;
                }
                s8 s8VarQ = s8Var.q(this.f16153o);
                this.f16153o = s8VarQ;
                s8Var2 = s8VarQ;
                z12 = z11;
                z11 = true;
            } else {
                s8Var2 = s8Var;
                zS = false;
                z12 = false;
            }
        }
        if (!z11) {
            zzj().F().b("Ignoring lower-priority consent settings, proposed settings", s8Var2);
            return;
        }
        long andIncrement = this.f16154p.getAndIncrement();
        if (zS) {
            Q0(null);
            ua uaVar = new ua(this, s8Var2, andIncrement, z12);
            if (!z10) {
                zzl().C(uaVar);
                return;
            } else {
                j();
                uaVar.run();
                return;
            }
        }
        ta taVar = new ta(this, s8Var2, andIncrement, z12);
        if (z10) {
            j();
            taVar.run();
        } else if (iB == 30 || iB == -10) {
            zzl().C(taVar);
        } else {
            zzl().y(taVar);
        }
    }

    public final void a1(String str, String str2, Bundle bundle) {
        j();
        P(str, str2, zzb().a(), bundle);
    }

    public final void b0(z8 z8Var) {
        z8 z8Var2;
        j();
        u();
        if (z8Var != null && z8Var != (z8Var2 = this.f16142d)) {
            com.google.android.gms.common.internal.r.p(z8Var2 == null, "EventInterceptor already set.");
        }
        this.f16142d = z8Var;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    public final void c0(c9 c9Var) {
        u();
        com.google.android.gms.common.internal.r.l(c9Var);
        if (this.f16143e.add(c9Var)) {
            return;
        }
        zzj().H().a("OnEventListener already registered");
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    public final void d1(boolean z10) {
        u();
        zzl().y(new x9(this, z10));
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    public final void e1(long j10) {
        zzl().y(new z9(this, j10));
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

    public final boolean o0(final zd zdVar) {
        try {
            URL url = new URI(zdVar.f17009c).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strD = l().D();
            zzj().G().d("[sgtm] Uploading data from app. row_id, url, uncompressed size", Long.valueOf(zdVar.f17007a), zdVar.f17009c, Integer.valueOf(zdVar.f17008b.length));
            if (!TextUtils.isEmpty(zdVar.f17013l)) {
                zzj().G().c("[sgtm] Uploading data from app. row_id", Long.valueOf(zdVar.f17007a), zdVar.f17013l);
            }
            HashMap map = new HashMap();
            for (String str : zdVar.f17010d.keySet()) {
                String string = zdVar.f17010d.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            ab abVarF = f();
            byte[] bArr = zdVar.f17008b;
            za zaVar = new za() { // from class: u4.n9
                @Override // u4.za
                public final void a(String str2, int i10, Throwable th, byte[] bArr2, Map map2) {
                    e9.l0(this.f16599a, atomicReference, zdVar, str2, i10, th, bArr2, map2);
                }
            };
            abVarF.l();
            com.google.android.gms.common.internal.r.l(url);
            com.google.android.gms.common.internal.r.l(bArr);
            com.google.android.gms.common.internal.r.l(zaVar);
            abVarF.zzl().t(new cb(abVarF, strD, url, bArr, map, zaVar));
            try {
                af afVarG = g();
                long jA = afVarG.zzb().a() + 60000;
                synchronized (atomicReference) {
                    for (long jA2 = 60000; atomicReference.get() == null && jA2 > 0; jA2 = jA - afVarG.zzb().a()) {
                        atomicReference.wait(jA2);
                    }
                }
            } catch (InterruptedException unused) {
                zzj().H().a("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == Boolean.TRUE;
        } catch (MalformedURLException | URISyntaxException e10) {
            zzj().C().d("[sgtm] Bad upload url for row_id", zdVar.f17009c, Long.valueOf(zdVar.f17007a), e10);
            return false;
        }
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ kb p() {
        return super.p();
    }

    public final q p0() {
        j();
        return q().X();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ qb q() {
        return super.q();
    }

    public final wa q0() {
        return this.f16141c;
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ id r() {
        return super.r();
    }

    public final Boolean r0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().q(atomicReference, 15000L, "boolean test flag value", new r9(this, atomicReference));
    }

    public final Double s0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().q(atomicReference, 15000L, "double test flag value", new pa(this, atomicReference));
    }

    @Override // u4.f4
    public final boolean t() {
        return false;
    }

    public final Integer t0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().q(atomicReference, 15000L, "int test flag value", new qa(this, atomicReference));
    }

    public final Long u0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().q(atomicReference, 15000L, "long test flag value", new na(this, atomicReference));
    }

    public final String v0() {
        return this.f16145g.get();
    }

    public final String w0() {
        hb hbVarL = this.f16624a.H().L();
        if (hbVarL != null) {
            return hbVarL.f16312b;
        }
        return null;
    }

    public final String x0() {
        hb hbVarL = this.f16624a.H().L();
        if (hbVarL != null) {
            return hbVarL.f16311a;
        }
        return null;
    }

    public final String y0() {
        if (this.f16624a.L() != null) {
            return this.f16624a.L();
        }
        try {
            return new e7(zza(), this.f16624a.O()).b("google_app_id");
        } catch (IllegalStateException e10) {
            this.f16624a.zzj().C().b("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    public final String z0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().q(atomicReference, 15000L, "String test flag value", new da(this, atomicReference));
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
