package u4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzgf;

/* JADX INFO: loaded from: classes.dex */
public final class db extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JobScheduler f16115c;

    public db(k7 k7Var) {
        super(k7Var);
    }

    public final int A() {
        return ("measurement-client" + zza().getPackageName()).hashCode();
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

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ a k() {
        return super.k();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ n5 l() {
        return super.l();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ q5 m() {
        return super.m();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ e9 n() {
        return super.n();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ db o() {
        return super.o();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ kb p() {
        return super.p();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ qb q() {
        return super.q();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ id r() {
        return super.r();
    }

    @Override // u4.f4
    public final boolean t() {
        return true;
    }

    @Override // u4.f4
    public final void x() {
        this.f16115c = (JobScheduler) zza().getSystemService("jobscheduler");
    }

    public final void y(long j10) {
        u();
        j();
        JobScheduler jobScheduler = this.f16115c;
        if (jobScheduler != null && jobScheduler.getPendingJob(A()) != null) {
            zzj().G().a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        zzgf.zzo.zza zzaVarZ = z();
        if (zzaVarZ != zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
            zzj().G().b("[sgtm] Not eligible for Scion upload", zzaVarZ.name());
            return;
        }
        zzj().G().b("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j10));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        zzj().G().b("[sgtm] Scion upload job scheduled with result", ((JobScheduler) com.google.android.gms.common.internal.r.l(this.f16115c)).schedule(new JobInfo.Builder(A(), new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build()) == 1 ? "SUCCESS" : "FAILURE");
    }

    public final zzgf.zzo.zza z() {
        u();
        j();
        if (!a().p(p0.M0)) {
            return zzgf.zzo.zza.CLIENT_FLAG_OFF;
        }
        if (this.f16115c == null) {
            return zzgf.zzo.zza.MISSING_JOB_SCHEDULER;
        }
        if (!a().r()) {
            return zzgf.zzo.zza.NOT_ENABLED_IN_MANIFEST;
        }
        if (!a().p(p0.O0)) {
            return zzgf.zzo.zza.SDK_TOO_OLD;
        }
        if (af.q0(zza(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return !q().k0() ? zzgf.zzo.zza.NON_PLAY_MODE : zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
        }
        return zzgf.zzo.zza.MEASUREMENT_SERVICE_NOT_ENABLED;
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
