package r7;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class o implements ScheduledExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f15124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f15125b;

    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f15124a = executorService;
        this.f15125b = scheduledExecutorService;
    }

    public static /* synthetic */ void n(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final Runnable runnable, final p.b bVar) {
        this.f15124a.execute(new Runnable() { // from class: r7.d
            @Override // java.lang.Runnable
            public final void run() {
                o.n(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture p(final Runnable runnable, long j10, TimeUnit timeUnit, final p.b bVar) {
        return this.f15125b.schedule(new Runnable() { // from class: r7.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f15114a.o(runnable, bVar);
            }
        }, j10, timeUnit);
    }

    public static /* synthetic */ void q(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Future r(final Callable callable, final p.b bVar) {
        return this.f15124a.submit(new Runnable() { // from class: r7.m
            @Override // java.lang.Runnable
            public final void run() {
                o.q(callable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture s(final Callable callable, long j10, TimeUnit timeUnit, final p.b bVar) {
        return this.f15125b.schedule(new Callable() { // from class: r7.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f15117a.r(callable, bVar);
            }
        }, j10, timeUnit);
    }

    public static /* synthetic */ void t(Runnable runnable, p.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final Runnable runnable, final p.b bVar) {
        this.f15124a.execute(new Runnable() { // from class: r7.n
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                o.t(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture v(final Runnable runnable, long j10, long j11, TimeUnit timeUnit, final p.b bVar) {
        return this.f15125b.scheduleAtFixedRate(new Runnable() { // from class: r7.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f15108a.u(runnable, bVar);
            }
        }, j10, j11, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(final Runnable runnable, final p.b bVar) {
        this.f15124a.execute(new Runnable() { // from class: r7.e
            @Override // java.lang.Runnable
            public final void run() {
                o.y(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture x(final Runnable runnable, long j10, long j11, TimeUnit timeUnit, final p.b bVar) {
        return this.f15125b.scheduleWithFixedDelay(new Runnable() { // from class: r7.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f15111a.w(runnable, bVar);
            }
        }, j10, j11, timeUnit);
    }

    public static /* synthetic */ void y(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f15124a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f15124a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f15124a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return this.f15124a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f15124a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return (T) this.f15124a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f15124a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f15124a.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(final Runnable runnable, final long j10, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: r7.f
            @Override // r7.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f15094a.p(runnable, j10, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(final Callable<V> callable, final long j10, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: r7.c
            @Override // r7.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f15086a.s(callable, j10, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long j10, final long j11, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: r7.h
            @Override // r7.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f15103a.v(runnable, j10, j11, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long j10, final long j11, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: r7.g
            @Override // r7.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f15098a.x(runnable, j10, j11, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f15124a.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.f15124a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f15124a.submit(callable);
    }
}
