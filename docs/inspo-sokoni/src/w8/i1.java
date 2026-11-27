package w8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class i1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f17752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f17753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<a> f17754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f1 f17755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17756f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f17757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource<Void> f17758b = new TaskCompletionSource<>();

        public a(Intent intent) {
            this.f17757a = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f17757a.getAction() + " finishing.");
            d();
        }

        public void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: w8.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17739a.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: w8.h1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        public void d() {
            this.f17758b.trySetResult(null);
        }

        public Task<Void> e() {
            return this.f17758b.getTask();
        }
    }

    public i1(Context context, String str) {
        this(context, str, a());
    }

    public i1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f17754d = new ArrayDeque();
        this.f17756f = false;
        Context applicationContext = context.getApplicationContext();
        this.f17751a = applicationContext;
        this.f17752b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f17753c = scheduledExecutorService;
    }

    public static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    public final void b() {
        while (!this.f17754d.isEmpty()) {
            this.f17754d.poll().d();
        }
    }

    public final synchronized void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.f17754d.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            f1 f1Var = this.f17755e;
            if (f1Var == null || !f1Var.isBinderAlive()) {
                e();
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
            }
            this.f17755e.c(this.f17754d.poll());
        }
    }

    public synchronized Task<Void> d(Intent intent) {
        a aVar;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        aVar = new a(intent);
        aVar.c(this.f17753c);
        this.f17754d.add(aVar);
        c();
        return aVar.e();
    }

    public final void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.f17756f);
            Log.d("FirebaseMessaging", sb2.toString());
        }
        if (this.f17756f) {
            return;
        }
        this.f17756f = true;
        try {
            if (i4.b.b().a(this.f17751a, this.f17752b, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e10) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e10);
        }
        this.f17756f = false;
        b();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
        }
        this.f17756f = false;
        if (iBinder instanceof f1) {
            this.f17755e = (f1) iBinder;
            c();
            return;
        }
        Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
        b();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        c();
    }
}
