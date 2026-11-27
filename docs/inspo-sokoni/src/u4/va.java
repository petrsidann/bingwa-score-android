package u4;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzeb;

/* JADX INFO: loaded from: classes.dex */
public final class va implements Application.ActivityLifecycleCallbacks, wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e9 f16910a;

    public va(e9 e9Var) {
        this.f16910a = e9Var;
    }

    public static /* synthetic */ void f(va vaVar, boolean z10, Uri uri, String str, String str2) {
        Bundle bundleY;
        Bundle bundleY2;
        vaVar.f16910a.j();
        try {
            af afVarG = vaVar.f16910a.g();
            if (TextUtils.isEmpty(str2)) {
                bundleY = null;
            } else if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                bundleY = afVarG.y(Uri.parse("https://google.com/search?" + str2));
                if (bundleY != null) {
                    bundleY.putString("_cis", "referrer");
                }
            } else {
                afVarG.zzj().B().a("Activity created with data 'referrer' without required params");
                bundleY = null;
            }
            boolean z11 = false;
            if (z10 && (bundleY2 = vaVar.f16910a.g().y(uri)) != null) {
                bundleY2.putString("_cis", "intent");
                if (!bundleY2.containsKey("gclid") && bundleY != null && bundleY.containsKey("gclid")) {
                    bundleY2.putString("_cer", String.format("gclid=%s", bundleY.getString("gclid")));
                }
                vaVar.f16910a.a1(str, "_cmp", bundleY2);
                vaVar.f16910a.f16156r.b(str, bundleY2);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            vaVar.f16910a.zzj().B().b("Activity created with referrer", str2);
            if (vaVar.f16910a.a().p(p0.B0)) {
                if (bundleY != null) {
                    vaVar.f16910a.a1(str, "_cmp", bundleY);
                    vaVar.f16910a.f16156r.b(str, bundleY);
                } else {
                    vaVar.f16910a.zzj().B().b("Referrer does not contain valid parameters", str2);
                }
                vaVar.f16910a.W("auto", "_ldl", null, true);
                return;
            }
            if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                z11 = true;
            }
            if (!z11) {
                vaVar.f16910a.zzj().B().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                vaVar.f16910a.W("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e10) {
            vaVar.f16910a.zzj().C().b("Throwable caught in handleReferrerForOnActivityCreated", e10);
        }
    }

    @Override // u4.wa
    public final void a(zzeb zzebVar) {
        this.f16910a.p().B(zzebVar);
    }

    @Override // u4.wa
    public final void b(zzeb zzebVar) {
        id idVarR = this.f16910a.r();
        idVarR.zzl().y(new hd(idVarR, idVarR.zzb().b()));
        this.f16910a.p().O(zzebVar);
    }

    @Override // u4.wa
    public final void c(zzeb zzebVar) {
        this.f16910a.p().M(zzebVar);
        id idVarR = this.f16910a.r();
        idVarR.zzl().y(new kd(idVarR, idVarR.zzb().b()));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    @Override // u4.wa
    public final void d(zzeb zzebVar, Bundle bundle) {
        try {
            try {
                this.f16910a.zzj().G().a("onActivityCreated");
                Intent intent = zzebVar.zzc;
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data == null || !data.isHierarchical()) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            String string = extras.getString("com.android.vending.referral_url");
                            if (TextUtils.isEmpty(string)) {
                                data = null;
                            } else {
                                data = Uri.parse(string);
                            }
                        } else {
                            data = null;
                        }
                    }
                    Uri uri = data;
                    if (uri != null && uri.isHierarchical()) {
                        this.f16910a.g();
                        this.f16910a.zzl().y(new ya(this, bundle == null, uri, af.b0(intent) ? "gs" : "auto", uri.getQueryParameter("referrer")));
                    }
                }
            } catch (RuntimeException e10) {
                this.f16910a.zzj().C().b("Throwable caught in onActivityCreated", e10);
            }
        } finally {
            this.f16910a.p().C(zzebVar, bundle);
        }
    }

    @Override // u4.wa
    public final void e(zzeb zzebVar, Bundle bundle) {
        this.f16910a.p().N(zzebVar, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        d(zzeb.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c(zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        b(zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        e(zzeb.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
