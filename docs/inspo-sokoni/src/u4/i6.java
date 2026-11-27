package u4;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class i6 extends r8 {
    public static final Pair<String, Long> B = new Pair<>("", 0L);
    public final k6 A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f16327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f16328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SharedPreferences f16329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m6 f16330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n6 f16331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n6 f16332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p6 f16333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f16336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final n6 f16337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l6 f16338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p6 f16339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final k6 f16340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l6 f16341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final n6 f16342r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final n6 f16343s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16344t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public l6 f16345u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l6 f16346v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public n6 f16347w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p6 f16348x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p6 f16349y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n6 f16350z;

    public i6(k7 k7Var) {
        super(k7Var);
        this.f16328d = new Object();
        this.f16337m = new n6(this, "session_timeout", 1800000L);
        this.f16338n = new l6(this, "start_new_session", true);
        this.f16342r = new n6(this, "last_pause_time", 0L);
        this.f16343s = new n6(this, "session_id", 0L);
        this.f16339o = new p6(this, "non_personalized_ads", null);
        this.f16340p = new k6(this, "last_received_uri_timestamps_by_source", null);
        this.f16341q = new l6(this, "allow_remote_dynamite", false);
        this.f16331g = new n6(this, "first_open_time", 0L);
        this.f16332h = new n6(this, "app_install_time", 0L);
        this.f16333i = new p6(this, "app_instance_id", null);
        this.f16345u = new l6(this, "app_backgrounded", false);
        this.f16346v = new l6(this, "deep_link_retrieval_complete", false);
        this.f16347w = new n6(this, "deep_link_retrieval_attempts", 0L);
        this.f16348x = new p6(this, "firebase_feature_rollouts", null);
        this.f16349y = new p6(this, "deferred_attribution_cache", null);
        this.f16350z = new n6(this, "deferred_attribution_cache_timestamp", 0L);
        this.A = new k6(this, "default_event_parameters", null);
    }

    public final void A(Boolean bool) {
        j();
        SharedPreferences.Editor editorEdit = F().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled_from_api");
        }
        editorEdit.apply();
    }

    public final void B(String str) {
        j();
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    public final void C(boolean z10) {
        j();
        zzj().G().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final SharedPreferences D() {
        j();
        l();
        if (this.f16329e == null) {
            synchronized (this.f16328d) {
                if (this.f16329e == null) {
                    String str = zza().getPackageName() + "_preferences";
                    zzj().G().b("Default prefs file", str);
                    this.f16329e = zza().getSharedPreferences(str, 0);
                }
            }
        }
        return this.f16329e;
    }

    public final void E(String str) {
        j();
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    public final SharedPreferences F() {
        j();
        l();
        com.google.android.gms.common.internal.r.l(this.f16327c);
        return this.f16327c;
    }

    public final SparseArray<Long> G() {
        Bundle bundleA = this.f16340p.a();
        if (bundleA == null) {
            return new SparseArray<>();
        }
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().C().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i10 = 0; i10 < intArray.length; i10++) {
            sparseArray.put(intArray[i10], Long.valueOf(longArray[i10]));
        }
        return sparseArray;
    }

    public final f0 H() {
        j();
        return f0.d(F().getString("dma_consent_settings", null));
    }

    public final s8 I() {
        j();
        return s8.f(F().getString("consent_settings", "G1"), F().getInt("consent_source", 100));
    }

    public final Boolean J() {
        j();
        if (F().contains("use_service")) {
            return Boolean.valueOf(F().getBoolean("use_service", false));
        }
        return null;
    }

    public final Boolean K() {
        j();
        if (F().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(F().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    public final Boolean L() {
        j();
        if (F().contains("measurement_enabled")) {
            return Boolean.valueOf(F().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final String M() {
        j();
        String string = F().getString("previous_os_version", null);
        c().l();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = F().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    public final String N() {
        j();
        return F().getString("admob_app_id", null);
    }

    public final String O() {
        j();
        return F().getString("gmp_app_id", null);
    }

    @Override // u4.r8
    public final void k() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f16327c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f16344t = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.f16327c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f16330f = new m6(this, "health_monitor", Math.max(0L, p0.f16644d.a(null).longValue()));
    }

    @Override // u4.r8
    public final boolean p() {
        return true;
    }

    public final Pair<String, Boolean> q(String str) {
        j();
        if (!I().m(s8.a.AD_STORAGE)) {
            return new Pair<>("", Boolean.FALSE);
        }
        long jB = zzb().b();
        if (this.f16334j != null && jB < this.f16336l) {
            return new Pair<>(this.f16334j, Boolean.valueOf(this.f16335k));
        }
        this.f16336l = jB + a().A(str);
        p3.a.b(true);
        try {
            p3.a.C0248a c0248aA = p3.a.a(zza());
            this.f16334j = "";
            String strA = c0248aA.a();
            if (strA != null) {
                this.f16334j = strA;
            }
            this.f16335k = c0248aA.b();
        } catch (Exception e10) {
            zzj().B().b("Unable to get advertising id", e10);
            this.f16334j = "";
        }
        p3.a.b(false);
        return new Pair<>(this.f16334j, Boolean.valueOf(this.f16335k));
    }

    public final void r(Boolean bool) {
        j();
        SharedPreferences.Editor editorEdit = F().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    public final void s(boolean z10) {
        j();
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putBoolean("use_service", z10);
        editorEdit.apply();
    }

    public final boolean t(int i10) {
        return s8.l(i10, F().getInt("consent_source", 100));
    }

    public final boolean u(long j10) {
        return j10 - this.f16337m.a() > this.f16342r.a();
    }

    public final boolean v(f0 f0Var) {
        j();
        if (!s8.l(f0Var.a(), H().a())) {
            return false;
        }
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putString("dma_consent_settings", f0Var.j());
        editorEdit.apply();
        return true;
    }

    public final boolean w(s8 s8Var) {
        j();
        int iB = s8Var.b();
        if (!t(iB)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putString("consent_settings", s8Var.v());
        editorEdit.putInt("consent_source", iB);
        editorEdit.apply();
        return true;
    }

    public final boolean x(qd qdVar) {
        j();
        String string = F().getString("stored_tcf_param", "");
        String strG = qdVar.g();
        if (strG.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.putString("stored_tcf_param", strG);
        editorEdit.apply();
        return true;
    }

    public final void y() {
        j();
        Boolean boolL = L();
        SharedPreferences.Editor editorEdit = F().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolL != null) {
            r(boolL);
        }
    }

    public final boolean z() {
        SharedPreferences sharedPreferences = this.f16327c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }
}
