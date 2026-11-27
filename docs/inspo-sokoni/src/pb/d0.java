package pb;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f14438l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap<e, i> f14439m = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f14441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f14442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14443d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14444e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<d> f14445f = new ArrayList<>();

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f14446a = Executors.newSingleThreadExecutor();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f14447b = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: pb.d0$a$a, reason: collision with other inner class name */
        public class RunnableC0250a implements Runnable {

            /* JADX INFO: renamed from: pb.d0$a$a$a, reason: collision with other inner class name */
            public class RunnableC0251a implements Runnable {
                public RunnableC0251a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    d0.this.i();
                }
            }

            public RunnableC0250a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    f fVarA = d0.this.a();
                    if (fVarA == null) {
                        a.this.f14447b.post(new RunnableC0251a());
                        return;
                    } else {
                        d0.this.g(fVarA.getIntent());
                        fVarA.a();
                    }
                }
            }
        }

        public a() {
        }

        public void b() {
            d0.this.i();
        }

        public void c() {
            this.f14446a.execute(new RunnableC0250a());
        }
    }

    public interface b {
        IBinder a();

        f b();
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f14451d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f14452e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f14453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f14454g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f14455h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f14451d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f14452e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f14453f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // pb.d0.i
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f14468a);
            if (this.f14451d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f14454g) {
                        this.f14454g = true;
                        if (!this.f14455h) {
                            this.f14452e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // pb.d0.i
        public void c() {
            synchronized (this) {
                if (this.f14455h) {
                    if (this.f14454g) {
                        this.f14452e.acquire(60000L);
                    }
                    this.f14455h = false;
                    this.f14453f.release();
                }
            }
        }

        @Override // pb.d0.i
        public void d() {
            synchronized (this) {
                if (!this.f14455h) {
                    this.f14455h = true;
                    this.f14453f.acquire(600000L);
                    this.f14452e.release();
                }
            }
        }

        @Override // pb.d0.i
        public void e() {
            synchronized (this) {
                this.f14454g = false;
            }
        }
    }

    public final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f14456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14457b;

        public d(Intent intent, int i10) {
            this.f14456a = intent;
            this.f14457b = i10;
        }

        @Override // pb.d0.f
        public void a() {
            d0.this.stopSelf(this.f14457b);
        }

        @Override // pb.d0.f
        public Intent getIntent() {
            return this.f14456a;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ComponentName f14459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14460b;

        public e(ComponentName componentName, boolean z10) {
            this.f14459a = componentName;
            this.f14460b = z10;
        }
    }

    public interface f {
        void a();

        Intent getIntent();
    }

    public static final class g extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f14461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f14462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f14463c;

        public final class a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f14464a;

            public a(JobWorkItem jobWorkItem) {
                this.f14464a = jobWorkItem;
            }

            @Override // pb.d0.f
            public void a() {
                String str;
                String str2;
                synchronized (g.this.f14462b) {
                    JobParameters jobParameters = g.this.f14463c;
                    if (jobParameters != null) {
                        try {
                            jobParameters.completeWork(this.f14464a);
                        } catch (IllegalArgumentException e10) {
                            e = e10;
                            str = "JobServiceEngineImpl";
                            str2 = "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        } catch (SecurityException e11) {
                            e = e11;
                            str = "JobServiceEngineImpl";
                            str2 = "SecurityException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        }
                    }
                }
            }

            @Override // pb.d0.f
            public Intent getIntent() {
                return this.f14464a.getIntent();
            }
        }

        public g(d0 d0Var) {
            super(d0Var);
            this.f14462b = new Object();
            this.f14461a = d0Var;
        }

        @Override // pb.d0.b
        public IBinder a() {
            return getBinder();
        }

        @Override // pb.d0.b
        public f b() {
            synchronized (this.f14462b) {
                JobParameters jobParameters = this.f14463c;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f14461a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                } catch (SecurityException e10) {
                    Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e10);
                    return null;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f14463c = jobParameters;
            this.f14461a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f14461a.b();
            synchronized (this.f14462b) {
                this.f14463c = null;
            }
            return zB;
        }
    }

    public static final class h extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f14466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f14467e;

        public h(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f14466d = new JobInfo.Builder(i10, this.f14468a).setOverrideDeadline(0L).build();
            this.f14467e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // pb.d0.i
        public void a(Intent intent) {
            this.f14467e.enqueue(this.f14466d, new JobWorkItem(intent));
        }
    }

    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f14468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14470c;

        public i(ComponentName componentName) {
            this.f14468a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i10) {
            if (!this.f14469b) {
                this.f14469b = true;
                this.f14470c = i10;
            } else {
                if (this.f14470c == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f14470c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public static void c(Context context, ComponentName componentName, int i10, Intent intent, boolean z10) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f14438l) {
            i iVarF = f(context, componentName, true, i10, z10);
            iVarF.b(i10);
            try {
                iVarF.a(intent);
            } catch (IllegalStateException e10) {
                if (!z10) {
                    throw e10;
                }
                f(context, componentName, true, i10, false).a(intent);
            }
        }
    }

    public static void d(Context context, Class cls, int i10, Intent intent, boolean z10) {
        c(context, new ComponentName(context, (Class<?>) cls), i10, intent, z10);
    }

    public static i f(Context context, ComponentName componentName, boolean z10, int i10, boolean z11) {
        i cVar;
        e eVar = new e(componentName, z11);
        HashMap<e, i> map = f14439m;
        i iVar = map.get(eVar);
        if (iVar != null) {
            return iVar;
        }
        if (z11) {
            cVar = new c(context, componentName);
        } else {
            if (!z10) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new h(context, componentName, i10);
        }
        i iVar2 = cVar;
        map.put(eVar, iVar2);
        return iVar2;
    }

    public f a() {
        f fVarB;
        b bVar = this.f14440a;
        if (bVar != null && (fVarB = bVar.b()) != null) {
            return fVarB;
        }
        synchronized (this.f14445f) {
            if (this.f14445f.size() > 0) {
                return this.f14445f.remove(0);
            }
            return null;
        }
    }

    public boolean b() {
        a aVar = this.f14442c;
        if (aVar != null) {
            aVar.b();
        }
        this.f14443d = true;
        return h();
    }

    public void e(boolean z10) {
        if (this.f14442c == null) {
            this.f14442c = new a();
            i iVar = this.f14441b;
            if (iVar != null && z10) {
                iVar.d();
            }
            this.f14442c.c();
        }
    }

    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    public void i() {
        ArrayList<d> arrayList = this.f14445f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f14442c = null;
                ArrayList<d> arrayList2 = this.f14445f;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f14444e) {
                    this.f14441b.c();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f14440a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14440a = new g(this);
        this.f14441b = null;
        this.f14441b = f(this, new ComponentName(this, getClass()), false, 0, true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
        synchronized (this.f14445f) {
            this.f14444e = true;
            this.f14441b.c();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        this.f14441b.e();
        synchronized (this.f14445f) {
            ArrayList<d> arrayList = this.f14445f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i11));
            e(true);
        }
        return 3;
    }
}
