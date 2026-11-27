package vb;

import com.google.android.gms.common.api.internal.v1;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f17469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f17470b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Thread> f17471c = new AtomicReference<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f17473b;

        public a(c cVar, Runnable runnable) {
            this.f17472a = cVar;
            this.f17473b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            p1.this.execute(this.f17472a);
        }

        public String toString() {
            return this.f17473b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f17476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f17477c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f17475a = cVar;
            this.f17476b = runnable;
            this.f17477c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            p1.this.execute(this.f17475a);
        }

        public String toString() {
            return this.f17476b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f17477c + ")";
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f17479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17481c;

        public c(Runnable runnable) {
            this.f17479a = (Runnable) j6.m.p(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17480b) {
                return;
            }
            this.f17481c = true;
            this.f17479a.run();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f17482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture<?> f17483b;

        public d(c cVar, ScheduledFuture<?> scheduledFuture) {
            this.f17482a = (c) j6.m.p(cVar, "runnable");
            this.f17483b = (ScheduledFuture) j6.m.p(scheduledFuture, "future");
        }

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f17482a.f17480b = true;
            this.f17483b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f17482a;
            return (cVar.f17481c || cVar.f17480b) ? false : true;
        }
    }

    public p1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f17469a = (Thread.UncaughtExceptionHandler) j6.m.p(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (v1.a(this.f17471c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnablePoll = this.f17470b.poll();
                    if (runnablePoll == null) {
                        break;
                    }
                    try {
                        runnablePoll.run();
                    } catch (Throwable th) {
                        this.f17469a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f17471c.set(null);
                    throw th2;
                }
            }
            this.f17471c.set(null);
            if (this.f17470b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f17470b.add((Runnable) j6.m.p(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit), null);
    }

    public final d e(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit), null);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }

    public void f() {
        j6.m.v(Thread.currentThread() == this.f17471c.get(), "Not called from the SynchronizationContext");
    }
}
