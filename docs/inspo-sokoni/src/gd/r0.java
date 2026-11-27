package gd;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends j1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final r0 f9253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f9254o;

    static {
        Long l10;
        r0 r0Var = new r0();
        f9253n = r0Var;
        i1.l0(r0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f9254o = timeUnit.toNanos(l10.longValue());
    }

    public final synchronized void H0() {
        if (K0()) {
            debugStatus = 3;
            B0();
            kotlin.jvm.internal.k.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread I0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean J0() {
        return debugStatus == 4;
    }

    public final boolean K0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final synchronized boolean L0() {
        if (K0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.k.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void M0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // gd.j1, gd.v0
    public e1 k(long j10, Runnable runnable, oc.i iVar) {
        return E0(j10, runnable);
    }

    @Override // gd.k1
    public Thread r0() {
        Thread thread = _thread;
        return thread == null ? I0() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zZ0;
        w2.f9268a.d(this);
        c.a();
        try {
            if (!L0()) {
                if (zZ0) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jO0 = o0();
                if (jO0 == Long.MAX_VALUE) {
                    c.a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f9254o + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        if (zZ0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    jO0 = bd.h.d(jO0, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jO0 > 0) {
                    if (K0()) {
                        if (zZ0) {
                            return;
                        } else {
                            return;
                        }
                    } else {
                        c.a();
                        LockSupport.parkNanos(this, jO0);
                    }
                }
            }
        } finally {
            _thread = null;
            H0();
            c.a();
            if (!z0()) {
                r0();
            }
        }
    }

    @Override // gd.k1
    public void s0(long j10, j1.c cVar) {
        M0();
    }

    @Override // gd.j1, gd.i1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // gd.j1
    public void x0(Runnable runnable) {
        if (J0()) {
            M0();
        }
        super.x0(runnable);
    }
}
