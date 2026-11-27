package k3;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes.dex */
public class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l3.d f11453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f11454c;

    public d(Context context, l3.d dVar, f fVar) {
        this.f11452a = context;
        this.f11453b = dVar;
        this.f11454c = fVar;
    }

    @Override // k3.x
    public void a(d3.o oVar, int i10) {
        b(oVar, i10, false);
    }

    @Override // k3.x
    public void b(d3.o oVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f11452a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f11452a.getSystemService("jobscheduler");
        int iC = c(oVar);
        if (!z10 && d(jobScheduler, iC, i10)) {
            h3.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long jR = this.f11453b.R(oVar);
        JobInfo.Builder builderC = this.f11454c.c(new JobInfo.Builder(iC, componentName), oVar.d(), jR, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt("priority", o3.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        h3.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(iC), Long.valueOf(this.f11454c.g(oVar.d(), jR, i10)), Long.valueOf(jR), Integer.valueOf(i10));
        jobScheduler.schedule(builderC.build());
    }

    public int c(d3.o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f11452a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(o3.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i12 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i10) {
                return i12 >= i11;
            }
        }
        return false;
    }
}
