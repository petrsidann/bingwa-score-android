package u4;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16788a;

    public interface a {
        void a(Context context, Intent intent);
    }

    public s6(a aVar) {
        com.google.android.gms.common.internal.r.l(aVar);
        this.f16788a = aVar;
    }

    public final void a(Context context, Intent intent) {
        v5 v5VarZzj = k7.a(context, null, null).zzj();
        if (intent == null) {
            v5VarZzj.H().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        v5VarZzj.G().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                v5VarZzj.H().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            v5VarZzj.G().a("Starting wakeful intent.");
            this.f16788a.a(context, className);
        }
    }
}
