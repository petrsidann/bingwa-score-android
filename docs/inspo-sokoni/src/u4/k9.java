package u4;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: loaded from: classes.dex */
public final class k9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f16447e;

    public k9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzdq zzdqVar, String str, String str2, boolean z10) {
        this.f16443a = zzdqVar;
        this.f16444b = str;
        this.f16445c = str2;
        this.f16446d = z10;
        this.f16447e = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16447e.f4056a.I().C(this.f16443a, this.f16444b, this.f16445c, this.f16446d);
    }
}
