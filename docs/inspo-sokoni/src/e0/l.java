package e0;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class l extends Service {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f6803m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<ComponentName, g> f6804n = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f6805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f6806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f6807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6808d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6809e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6810f = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<c> f6811l = null;

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                d dVarA = l.this.a();
                if (dVarA == null) {
                    return null;
                }
                l.this.g(dVarA.getIntent());
                dVarA.a();
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r10) {
            l.this.i();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r10) {
            l.this.i();
        }
    }

    public interface b {
        IBinder a();

        d b();
    }

    public final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f6813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6814b;

        public c(Intent intent, int i10) {
            this.f6813a = intent;
            this.f6814b = i10;
        }

        @Override // e0.l.d
        public void a() {
            l.this.stopSelf(this.f6814b);
        }

        @Override // e0.l.d
        public Intent getIntent() {
            return this.f6813a;
        }
    }

    public interface d {
        void a();

        Intent getIntent();
    }

    public static final class e extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f6816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f6817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f6818c;

        public final class a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f6819a;

            public a(JobWorkItem jobWorkItem) {
                this.f6819a = jobWorkItem;
            }

            @Override // e0.l.d
            public void a() {
                synchronized (e.this.f6817b) {
                    JobParameters jobParameters = e.this.f6818c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f6819a);
                    }
                }
            }

            @Override // e0.l.d
            public Intent getIntent() {
                return this.f6819a.getIntent();
            }
        }

        public e(l lVar) {
            super(lVar);
            this.f6817b = new Object();
            this.f6816a = lVar;
        }

        @Override // e0.l.b
        public IBinder a() {
            return getBinder();
        }

        @Override // e0.l.b
        public d b() {
            synchronized (this.f6817b) {
                JobParameters jobParameters = this.f6818c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f6816a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f6818c = jobParameters;
            this.f6816a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f6816a.b();
            synchronized (this.f6817b) {
                this.f6818c = null;
            }
            return zB;
        }
    }

    public static final class f extends g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f6821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f6822e;

        public f(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f6821d = new JobInfo.Builder(i10, this.f6823a).setOverrideDeadline(0L).build();
            this.f6822e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // e0.l.g
        public void a(Intent intent) {
            this.f6822e.enqueue(this.f6821d, new JobWorkItem(intent));
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f6823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6825c;

        public g(ComponentName componentName) {
            this.f6823a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i10) {
            if (!this.f6824b) {
                this.f6824b = true;
                this.f6825c = i10;
            } else {
                if (this.f6825c == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f6825c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public static void c(Context context, ComponentName componentName, int i10, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f6803m) {
            g gVarF = f(context, componentName, true, i10);
            gVarF.b(i10);
            gVarF.a(intent);
        }
    }

    public static void d(Context context, Class<?> cls, int i10, Intent intent) {
        c(context, new ComponentName(context, cls), i10, intent);
    }

    public static g f(Context context, ComponentName componentName, boolean z10, int i10) {
        HashMap<ComponentName, g> map = f6804n;
        g gVar = map.get(componentName);
        if (gVar != null) {
            return gVar;
        }
        if (!z10) {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        f fVar = new f(context, componentName, i10);
        map.put(componentName, fVar);
        return fVar;
    }

    public d a() {
        b bVar = this.f6805a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f6811l) {
            if (this.f6811l.size() <= 0) {
                return null;
            }
            return this.f6811l.remove(0);
        }
    }

    public boolean b() {
        a aVar = this.f6807c;
        if (aVar != null) {
            aVar.cancel(this.f6808d);
        }
        this.f6809e = true;
        return h();
    }

    public void e(boolean z10) {
        if (this.f6807c == null) {
            this.f6807c = new a();
            g gVar = this.f6806b;
            if (gVar != null && z10) {
                gVar.d();
            }
            this.f6807c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    public void i() {
        ArrayList<c> arrayList = this.f6811l;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f6807c = null;
                ArrayList<c> arrayList2 = this.f6811l;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f6810f) {
                    this.f6806b.c();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f6805a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f6805a = new e(this);
        this.f6806b = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<c> arrayList = this.f6811l;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f6810f = true;
                this.f6806b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f6811l == null) {
            return 2;
        }
        this.f6806b.e();
        synchronized (this.f6811l) {
            ArrayList<c> arrayList = this.f6811l;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new c(intent, i11));
            e(true);
        }
        return 3;
    }
}
