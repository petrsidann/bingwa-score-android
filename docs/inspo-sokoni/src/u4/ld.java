package u4;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: loaded from: classes.dex */
public final class ld implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f16497b;

    public ld(AppMeasurementDynamiteService appMeasurementDynamiteService, zzdq zzdqVar) {
        this.f16496a = zzdqVar;
        this.f16497b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16497b.f4056a.K().Q(this.f16496a, this.f16497b.f4056a.m());
    }
}
