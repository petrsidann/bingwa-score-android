package l8;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<d> f12526c = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f12525b = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12524a = new c();

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f12527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f12528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f12529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ScheduledFuture f12530d;

        public b(d dVar, long j10, Runnable runnable) {
            this.f12527a = dVar;
            this.f12528b = j10;
            this.f12529c = runnable;
        }

        public void c() {
            g.this.x();
            ScheduledFuture scheduledFuture = this.f12530d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                e();
            }
        }

        public final void d() {
            g.this.x();
            if (this.f12530d != null) {
                e();
                this.f12529c.run();
            }
        }

        public final void e() {
            l8.b.d(this.f12530d != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f12530d = null;
            g.this.v(this);
        }

        public final void f(long j10) {
            this.f12530d = g.this.f12524a.schedule(new Runnable() { // from class: l8.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12555a.d();
                }
            }, j10, TimeUnit.MILLISECONDS);
        }
    }

    public class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledThreadPoolExecutor f12532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Thread f12534c;

        public class a extends ScheduledThreadPoolExecutor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f12536a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i10, ThreadFactory threadFactory, g gVar) {
                super(i10, threadFactory);
                this.f12536a = gVar;
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            public void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (CancellationException unused2) {
                    } catch (ExecutionException e10) {
                        th = e10.getCause();
                    }
                }
                if (th != null) {
                    g.this.u(th);
                }
            }
        }

        public class b implements Runnable, ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CountDownLatch f12538a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Runnable f12539b;

            public b() {
                this.f12538a = new CountDownLatch(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                l8.b.d(this.f12539b == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f12539b = runnable;
                this.f12538a.countDown();
                return c.this.f12534c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f12538a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.f12539b.run();
            }
        }

        public c() {
            b bVar = new b();
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(bVar);
            this.f12534c = threadNewThread;
            threadNewThread.setName("FirestoreWorker");
            threadNewThread.setDaemon(true);
            threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: l8.i
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    this.f12556a.r(thread, th);
                }
            });
            a aVar = new a(1, bVar, g.this);
            this.f12532a = aVar;
            aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.f12533b = false;
        }

        public static /* synthetic */ Void p(Runnable runnable) {
            runnable.run();
            return null;
        }

        public static /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e10) {
                taskCompletionSource.setException(e10);
                throw new RuntimeException(e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Thread thread, Throwable th) {
            g.this.u(th);
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.f12533b) {
                this.f12532a.execute(runnable);
            }
        }

        public final synchronized Task<Void> l(final Runnable runnable) {
            if (!o()) {
                Task<Void> taskM = m(new Callable() { // from class: l8.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return g.c.p(runnable);
                    }
                });
                this.f12533b = true;
                return taskM;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }

        public final <T> Task<T> m(final Callable<T> callable) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(new Runnable() { // from class: l8.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.c.q(taskCompletionSource, callable);
                    }
                });
            } catch (RejectedExecutionException unused) {
                v.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        public void n(Runnable runnable) {
            try {
                this.f12532a.execute(runnable);
            } catch (RejectedExecutionException unused) {
                v.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }

        public final synchronized boolean o() {
            return this.f12533b;
        }

        public final void s(int i10) {
            this.f12532a.setCorePoolSize(i10);
        }

        public final synchronized ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f12533b) {
                return null;
            }
            return this.f12532a.schedule(runnable, j10, timeUnit);
        }

        public final void t() {
            this.f12532a.shutdownNow();
        }
    }

    public enum d {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        HEALTH_CHECK_TIMEOUT,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER,
        INDEX_BACKFILL
    }

    public static <TResult> Task<TResult> g(final Executor executor, final Callable<Task<TResult>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: l8.e
            @Override // java.lang.Runnable
            public final void run() {
                g.r(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ Void q(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public static /* synthetic */ void r(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new Continuation() { // from class: l8.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return g.q(taskCompletionSource, task);
                }
            });
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    public static /* synthetic */ Void s(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static /* synthetic */ void t(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            throw new RuntimeException("Internal error in Cloud Firestore (25.1.2).", th);
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (25.1.2) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
        outOfMemoryError.initCause(th);
        throw outOfMemoryError;
    }

    public final b h(d dVar, long j10, Runnable runnable) {
        b bVar = new b(dVar, System.currentTimeMillis() + j10, runnable);
        bVar.f(j10);
        return bVar;
    }

    public Task<Void> i(final Runnable runnable) {
        return j(new Callable() { // from class: l8.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g.s(runnable);
            }
        });
    }

    public <T> Task<T> j(Callable<T> callable) {
        return this.f12524a.m(callable);
    }

    public b k(d dVar, long j10, Runnable runnable) {
        if (this.f12526c.contains(dVar)) {
            j10 = 0;
        }
        b bVarH = h(dVar, j10, runnable);
        this.f12525b.add(bVarH);
        return bVarH;
    }

    public void l(Runnable runnable) {
        i(runnable);
    }

    public void m(Runnable runnable) {
        this.f12524a.n(runnable);
    }

    public Task<Void> n(Runnable runnable) {
        return this.f12524a.l(runnable);
    }

    public Executor o() {
        return this.f12524a;
    }

    public boolean p() {
        return this.f12524a.o();
    }

    public void u(final Throwable th) {
        this.f12524a.t();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: l8.d
            @Override // java.lang.Runnable
            public final void run() {
                g.t(th);
            }
        });
    }

    public final void v(b bVar) {
        l8.b.d(this.f12525b.remove(bVar), "Delayed task not found.", new Object[0]);
    }

    public void w() {
        this.f12524a.s(0);
    }

    public void x() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.f12524a.f12534c != threadCurrentThread) {
            throw l8.b.a("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.f12524a.f12534c.getName(), Long.valueOf(this.f12524a.f12534c.getId()), threadCurrentThread.getName(), Long.valueOf(threadCurrentThread.getId()));
        }
    }
}
