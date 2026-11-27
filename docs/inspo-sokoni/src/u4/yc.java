package u4;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
public final class yc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uc f16990a;

    public yc(uc ucVar) {
        this.f16990a = ucVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qb.Q(this.f16990a.f16875c, new ComponentName(this.f16990a.f16875c.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
