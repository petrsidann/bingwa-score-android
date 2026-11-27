package u4;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: loaded from: classes.dex */
public final class lb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f16493d;

    public lb(AppMeasurementDynamiteService appMeasurementDynamiteService, zzdq zzdqVar, String str, String str2) {
        this.f16490a = zzdqVar;
        this.f16491b = str;
        this.f16492c = str2;
        this.f16493d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16493d.f4056a.I().B(this.f16490a, this.f16491b, this.f16492c);
    }
}
