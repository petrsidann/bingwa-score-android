package w8;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f17680i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f17682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f17683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f17684d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f17686f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y0 f17688h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f17685e = new t.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17687g = false;

    public a1(FirebaseMessaging firebaseMessaging, i0 i0Var, y0 y0Var, e0 e0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f17684d = firebaseMessaging;
        this.f17682b = i0Var;
        this.f17688h = y0Var;
        this.f17683c = e0Var;
        this.f17681a = context;
        this.f17686f = scheduledExecutorService;
    }

    public static <T> void c(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            e = e10;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e11);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e12) {
            e = e12;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static Task<a1> f(final FirebaseMessaging firebaseMessaging, final i0 i0Var, final e0 e0Var, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: w8.z0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a1.j(context, scheduledExecutorService, firebaseMessaging, i0Var, e0Var);
            }
        });
    }

    public static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public static /* synthetic */ a1 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, i0 i0Var, e0 e0Var) {
        return new a1(firebaseMessaging, i0Var, y0.b(context, scheduledExecutorService), e0Var, context, scheduledExecutorService);
    }

    public final void b(x0 x0Var, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.f17685e) {
            String strE = x0Var.e();
            if (this.f17685e.containsKey(strE)) {
                arrayDeque = this.f17685e.get(strE);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.f17685e.put(strE, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    public final void d(String str) throws IOException {
        c(this.f17683c.n(this.f17684d.o(), str));
    }

    public final void e(String str) throws IOException {
        c(this.f17683c.o(this.f17684d.o(), str));
    }

    public boolean g() {
        return this.f17688h.c() != null;
    }

    public synchronized boolean i() {
        return this.f17687g;
    }

    public final void k(x0 x0Var) {
        synchronized (this.f17685e) {
            String strE = x0Var.e();
            if (this.f17685e.containsKey(strE)) {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f17685e.get(strE);
                TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                if (taskCompletionSourcePoll != null) {
                    taskCompletionSourcePoll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.f17685e.remove(strE);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public boolean l(x0 x0Var) throws IOException {
        String str;
        byte b10;
        String str2;
        try {
            String strB = x0Var.b();
            int iHashCode = strB.hashCode();
            if (iHashCode != 83) {
                if (iHashCode == 85 && strB.equals("U")) {
                    b10 = 1;
                } else {
                    b10 = -1;
                }
            } else if (strB.equals("S")) {
                b10 = 0;
            } else {
                b10 = -1;
            }
            if (b10 == 0) {
                d(x0Var.c());
                if (h()) {
                    str2 = "Subscribe to topic: " + x0Var.c() + " succeeded.";
                    Log.d("FirebaseMessaging", str2);
                }
            } else if (b10 == 1) {
                e(x0Var.c());
                if (h()) {
                    str2 = "Unsubscribe from topic: " + x0Var.c() + " succeeded.";
                    Log.d("FirebaseMessaging", str2);
                }
            } else if (h()) {
                str2 = "Unknown topic operation" + x0Var + ".";
                Log.d("FirebaseMessaging", str2);
            }
            return true;
        } catch (IOException e10) {
            if ("SERVICE_NOT_AVAILABLE".equals(e10.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e10.getMessage()) || "TOO_MANY_SUBSCRIBERS".equals(e10.getMessage())) {
                str = "Topic operation failed: " + e10.getMessage() + ". Will retry Topic operation.";
            } else {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                str = "Topic operation failed without exception message. Will retry Topic operation.";
            }
            Log.e("FirebaseMessaging", str);
            return false;
        }
    }

    public void m(Runnable runnable, long j10) {
        this.f17686f.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    public Task<Void> n(x0 x0Var) {
        this.f17688h.a(x0Var);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        b(x0Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void o(boolean z10) {
        this.f17687g = z10;
    }

    public final void p() {
        if (i()) {
            return;
        }
        t(0L);
    }

    public void q() {
        if (g()) {
            p();
        }
    }

    public Task<Void> r(String str) {
        Task<Void> taskN = n(x0.f(str));
        q();
        return taskN;
    }

    public boolean s() {
        while (true) {
            synchronized (this) {
                x0 x0VarC = this.f17688h.c();
                if (x0VarC == null) {
                    if (h()) {
                        Log.d("FirebaseMessaging", "topic sync succeeded");
                    }
                    return true;
                }
                if (!l(x0VarC)) {
                    return false;
                }
                this.f17688h.e(x0VarC);
                k(x0VarC);
            }
        }
    }

    public void t(long j10) {
        m(new b1(this, this.f17681a, this.f17682b, Math.min(Math.max(30L, 2 * j10), f17680i)), j10);
        o(true);
    }

    public Task<Void> u(String str) {
        Task<Void> taskN = n(x0.g(str));
        q();
        return taskN;
    }
}
