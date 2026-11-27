package u4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcy;

/* JADX INFO: loaded from: classes.dex */
public final class ud extends fe {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AlarmManager f16876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d0 f16877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f16878f;

    public ud(ge geVar) {
        super(geVar);
        this.f16876d = (AlarmManager) zza().getSystemService("alarm");
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ we k() {
        return super.k();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ kf l() {
        return super.l();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ s m() {
        return super.m();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ u6 n() {
        return super.n();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ad o() {
        return super.o();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ee p() {
        return super.p();
    }

    @Override // u4.fe
    public final boolean t() {
        AlarmManager alarmManager = this.f16876d;
        if (alarmManager != null) {
            alarmManager.cancel(x());
        }
        z();
        return false;
    }

    public final void u(long j10) {
        q();
        Context contextZza = zza();
        if (!af.Z(contextZza)) {
            zzj().B().a("Receiver not registered/enabled");
        }
        if (!af.a0(contextZza, false)) {
            zzj().B().a("Service not registered/enabled");
        }
        v();
        zzj().G().b("Scheduling upload, millis", Long.valueOf(j10));
        zzb().b();
        if (j10 < Math.max(0L, p0.H.a(null).longValue()) && !y().e()) {
            y().b(j10);
        }
        Context contextZza2 = zza();
        ComponentName componentName = new ComponentName(contextZza2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iW = w();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        zzcx.zza(contextZza2, new JobInfo.Builder(iW, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void v() {
        q();
        zzj().G().a("Unscheduling upload");
        AlarmManager alarmManager = this.f16876d;
        if (alarmManager != null) {
            alarmManager.cancel(x());
        }
        y().a();
        z();
    }

    public final int w() {
        if (this.f16878f == null) {
            this.f16878f = Integer.valueOf(("measurement" + zza().getPackageName()).hashCode());
        }
        return this.f16878f.intValue();
    }

    public final PendingIntent x() {
        Context contextZza = zza();
        return zzcy.zza(contextZza, 0, new Intent().setClassName(contextZza, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzcy.zza);
    }

    public final d0 y() {
        if (this.f16877e == null) {
            this.f16877e = new xd(this, this.f16938b.B0());
        }
        return this.f16877e;
    }

    public final void z() {
        JobScheduler jobScheduler = (JobScheduler) zza().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(w());
        }
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
