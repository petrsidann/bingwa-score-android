package u4;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: loaded from: classes.dex */
public final class h7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f16305b;

    public h7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzdq zzdqVar) {
        this.f16304a = zzdqVar;
        this.f16305b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16305b.f4056a.I().A(this.f16304a);
    }
}
