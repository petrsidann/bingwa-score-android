package w8;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Binder f17731b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17733d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f17730a = m.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17732c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17734e = 0;

    public class a implements f1.a {
        public a() {
        }

        @Override // w8.f1.a
        public Task<Void> a(Intent intent) {
            return g.this.j(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            d1.c(intent);
        }
        synchronized (this.f17732c) {
            int i10 = this.f17734e - 1;
            this.f17734e = i10;
            if (i10 == 0) {
                k(this.f17733d);
            }
        }
    }

    public Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    public final Task<Void> j(final Intent intent) {
        if (g(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f17730a.execute(new Runnable() { // from class: w8.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f17724a.i(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean k(int i10) {
        return stopSelfResult(i10);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f17731b == null) {
            this.f17731b = new f1(new a());
        }
        return this.f17731b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f17730a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i10, int i11) {
        synchronized (this.f17732c) {
            this.f17733d = i11;
            this.f17734e++;
        }
        Intent intentE = e(intent);
        if (intentE == null) {
            d(intent);
            return 2;
        }
        Task<Void> taskJ = j(intentE);
        if (taskJ.isComplete()) {
            d(intent);
            return 2;
        }
        taskJ.addOnCompleteListener(new x1.b(), new OnCompleteListener() { // from class: w8.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f17715a.h(intent, task);
            }
        });
        return 3;
    }
}
