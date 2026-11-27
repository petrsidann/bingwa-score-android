package u4;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzed;
import java.util.Objects;
import u4.fd;

/* JADX INFO: loaded from: classes.dex */
public final class cd<T extends Context & fd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f16080a;

    public cd(T t10) {
        com.google.android.gms.common.internal.r.l(t10);
        this.f16080a = t10;
    }

    public static /* synthetic */ void d(cd cdVar, int i10, v5 v5Var, Intent intent) {
        if (cdVar.f16080a.zza(i10)) {
            v5Var.G().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            cdVar.k().G().a("Completed wakeful intent.");
            cdVar.f16080a.a(intent);
        }
    }

    public static /* synthetic */ void e(cd cdVar, JobParameters jobParameters) {
        Log.v("FA", "AppMeasurementJobService processed last Scion upload request.");
        cdVar.f16080a.b(jobParameters, false);
    }

    public static /* synthetic */ void f(cd cdVar, v5 v5Var, JobParameters jobParameters) {
        v5Var.G().a("AppMeasurementJobService processed last upload request.");
        cdVar.f16080a.b(jobParameters, false);
    }

    public final int a(final Intent intent, int i10, final int i11) {
        final v5 v5VarZzj = k7.a(this.f16080a, null, null).zzj();
        if (intent == null) {
            v5VarZzj.H().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        v5VarZzj.G().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            g(ge.n(this.f16080a), new Runnable() { // from class: u4.ed
                @Override // java.lang.Runnable
                public final void run() {
                    cd.d(this.f16169a, i11, v5VarZzj, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().C().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new o7(ge.n(this.f16080a));
        }
        k().H().b("onBind received unknown action", action);
        return null;
    }

    public final void c() {
        k7.a(this.f16080a, null, null).zzj().G().a("Local AppMeasurementService is starting up");
    }

    public final void g(ge geVar, Runnable runnable) {
        geVar.zzl().y(new gd(this, geVar, runnable));
    }

    public final boolean h(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) com.google.android.gms.common.internal.r.l(string);
            ge geVarN = ge.n(this.f16080a);
            final v5 v5VarZzj = geVarN.zzj();
            v5VarZzj.G().b("Local AppMeasurementJobService called. action", str);
            g(geVarN, new Runnable() { // from class: u4.dd
                @Override // java.lang.Runnable
                public final void run() {
                    cd.f(this.f16119a, v5VarZzj, jobParameters);
                }
            });
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        zzed zzedVarZza = zzed.zza(this.f16080a);
        if (!p0.O0.a(null).booleanValue()) {
            return true;
        }
        zzedVarZza.zza(new Runnable() { // from class: u4.bd
            @Override // java.lang.Runnable
            public final void run() {
                cd.e(this.f16051a, jobParameters);
            }
        });
        return true;
    }

    public final void i() {
        k7.a(this.f16080a, null, null).zzj().G().a("Local AppMeasurementService is shutting down");
    }

    public final void j(Intent intent) {
        if (intent == null) {
            k().C().a("onRebind called with null intent");
        } else {
            k().G().b("onRebind called. action", intent.getAction());
        }
    }

    public final v5 k() {
        return k7.a(this.f16080a, null, null).zzj();
    }

    public final boolean l(Intent intent) {
        if (intent == null) {
            k().C().a("onUnbind called with null intent");
            return true;
        }
        k().G().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
