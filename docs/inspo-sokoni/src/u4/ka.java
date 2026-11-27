package u4;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: loaded from: classes.dex */
public final class ka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f16449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f16451d;

    public ka(AppMeasurementDynamiteService appMeasurementDynamiteService, zzdq zzdqVar, n0 n0Var, String str) {
        this.f16448a = zzdqVar;
        this.f16449b = n0Var;
        this.f16450c = str;
        this.f16451d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16451d.f4056a.I().D(this.f16448a, this.f16449b, this.f16450c);
    }
}
