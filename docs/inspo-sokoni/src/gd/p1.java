package gd;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 extends o1 implements v0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f9249d;

    public p1(Executor executor) {
        this.f9249d = executor;
        ld.c.a(g0());
    }

    @Override // gd.j0
    public void c0(oc.i iVar, Runnable runnable) {
        try {
            Executor executorG0 = g0();
            c.a();
            executorG0.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            f0(iVar, e10);
            c1.b().c0(iVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorG0 = g0();
        ExecutorService executorService = executorG0 instanceof ExecutorService ? (ExecutorService) executorG0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // gd.v0
    public void e(long j10, o<? super lc.q> oVar) {
        Executor executorG0 = g0();
        ScheduledExecutorService scheduledExecutorService = executorG0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorG0 : null;
        ScheduledFuture<?> scheduledFutureH0 = scheduledExecutorService != null ? h0(scheduledExecutorService, new r2(this, oVar), oVar.getContext(), j10) : null;
        if (scheduledFutureH0 != null) {
            c2.f(oVar, scheduledFutureH0);
        } else {
            r0.f9253n.e(j10, oVar);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof p1) && ((p1) obj).g0() == g0();
    }

    public final void f0(oc.i iVar, RejectedExecutionException rejectedExecutionException) {
        c2.c(iVar, n1.a("The task was rejected", rejectedExecutionException));
    }

    public Executor g0() {
        return this.f9249d;
    }

    public final ScheduledFuture<?> h0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, oc.i iVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            f0(iVar, e10);
            return null;
        }
    }

    public int hashCode() {
        return System.identityHashCode(g0());
    }

    @Override // gd.v0
    public e1 k(long j10, Runnable runnable, oc.i iVar) {
        Executor executorG0 = g0();
        ScheduledExecutorService scheduledExecutorService = executorG0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorG0 : null;
        ScheduledFuture<?> scheduledFutureH0 = scheduledExecutorService != null ? h0(scheduledExecutorService, runnable, iVar, j10) : null;
        return scheduledFutureH0 != null ? new d1(scheduledFutureH0) : r0.f9253n.k(j10, runnable, iVar);
    }

    @Override // gd.j0
    public String toString() {
        return g0().toString();
    }
}
