package oe;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class c extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f13849i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f13850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f13851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f13852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f13853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static c f13854n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f13856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13857h;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final c c() throws InterruptedException {
            c cVar = c.f13854n;
            kotlin.jvm.internal.k.b(cVar);
            c cVar2 = cVar.f13856g;
            long jNanoTime = System.nanoTime();
            if (cVar2 == null) {
                e().await(c.f13852l, TimeUnit.MILLISECONDS);
                c cVar3 = c.f13854n;
                kotlin.jvm.internal.k.b(cVar3);
                if (cVar3.f13856g != null || System.nanoTime() - jNanoTime < c.f13853m) {
                    return null;
                }
                return c.f13854n;
            }
            long jU = cVar2.u(jNanoTime);
            if (jU > 0) {
                e().await(jU, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.f13854n;
            kotlin.jvm.internal.k.b(cVar4);
            cVar4.f13856g = cVar2.f13856g;
            cVar2.f13856g = null;
            return cVar2;
        }

        public final boolean d(c cVar) {
            ReentrantLock reentrantLockF = c.f13849i.f();
            reentrantLockF.lock();
            try {
                if (!cVar.f13855f) {
                    return false;
                }
                cVar.f13855f = false;
                for (c cVar2 = c.f13854n; cVar2 != null; cVar2 = cVar2.f13856g) {
                    if (cVar2.f13856g == cVar) {
                        cVar2.f13856g = cVar.f13856g;
                        cVar.f13856g = null;
                        return false;
                    }
                }
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        public final Condition e() {
            return c.f13851k;
        }

        public final ReentrantLock f() {
            return c.f13850j;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0061 A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:8:0x002a, B:11:0x0036, B:12:0x003f, B:17:0x0050, B:18:0x0058, B:20:0x0061, B:23:0x0071, B:24:0x0076, B:26:0x0086, B:27:0x008f, B:16:0x0049, B:30:0x0095, B:31:0x009a, B:32:0x009b, B:33:0x00a6), top: B:37:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0071 A[Catch: all -> 0x00a7, LOOP:0: B:18:0x0058->B:23:0x0071, LOOP_END, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:8:0x002a, B:11:0x0036, B:12:0x003f, B:17:0x0050, B:18:0x0058, B:20:0x0061, B:23:0x0071, B:24:0x0076, B:26:0x0086, B:27:0x008f, B:16:0x0049, B:30:0x0095, B:31:0x009a, B:32:0x009b, B:33:0x00a6), top: B:37:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0086 A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:8:0x002a, B:11:0x0036, B:12:0x003f, B:17:0x0050, B:18:0x0058, B:20:0x0061, B:23:0x0071, B:24:0x0076, B:26:0x0086, B:27:0x008f, B:16:0x0049, B:30:0x0095, B:31:0x009a, B:32:0x009b, B:33:0x00a6), top: B:37:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0076 A[EDGE_INSN: B:38:0x0076->B:24:0x0076 BREAK  A[LOOP:0: B:18:0x0058->B:23:0x0071], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:0x0070 A[SYNTHETIC] */
        public final void g(c cVar, long j10, boolean z10) {
            long jU;
            c cVar2;
            c cVar3;
            ReentrantLock reentrantLockF = c.f13849i.f();
            reentrantLockF.lock();
            try {
                if (!(!cVar.f13855f)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                cVar.f13855f = true;
                if (c.f13854n == null) {
                    c.f13854n = new c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 == 0 || !z10) {
                    if (j10 == 0) {
                        if (!z10) {
                            throw new AssertionError();
                        }
                        cVar.f13857h = cVar.a();
                    }
                    jU = cVar.u(jNanoTime);
                    cVar2 = c.f13854n;
                    while (true) {
                        kotlin.jvm.internal.k.b(cVar2);
                        if (cVar2.f13856g != null) {
                            break;
                        }
                        cVar3 = cVar2.f13856g;
                        kotlin.jvm.internal.k.b(cVar3);
                        if (jU < cVar3.u(jNanoTime)) {
                            break;
                        } else {
                            cVar2 = cVar2.f13856g;
                        }
                    }
                    cVar.f13856g = cVar2.f13856g;
                    cVar2.f13856g = cVar;
                    if (cVar2 == c.f13854n) {
                        c.f13849i.e().signal();
                    }
                    lc.q qVar = lc.q.f12711a;
                    reentrantLockF.unlock();
                }
                j10 = Math.min(j10, cVar.a() - jNanoTime);
                cVar.f13857h = j10 + jNanoTime;
                jU = cVar.u(jNanoTime);
                cVar2 = c.f13854n;
                while (true) {
                    kotlin.jvm.internal.k.b(cVar2);
                    if (cVar2.f13856g != null) {
                        break;
                        break;
                    }
                    cVar3 = cVar2.f13856g;
                    kotlin.jvm.internal.k.b(cVar3);
                    if (jU < cVar3.u(jNanoTime)) {
                        break;
                        break;
                    }
                    cVar2 = cVar2.f13856g;
                }
                cVar.f13856g = cVar2.f13856g;
                cVar2.f13856g = cVar;
                if (cVar2 == c.f13854n) {
                    c.f13849i.e().signal();
                }
                lc.q qVar2 = lc.q.f12711a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }
    }

    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    a aVar = c.f13849i;
                    ReentrantLock reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        c cVarC = aVar.c();
                        if (cVarC == c.f13854n) {
                            c.f13854n = null;
                            reentrantLockF.unlock();
                            return;
                        } else {
                            lc.q qVar = lc.q.f12711a;
                            reentrantLockF.unlock();
                            if (cVarC != null) {
                                cVarC.x();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLockF.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    /* JADX INFO: renamed from: oe.c$c, reason: collision with other inner class name */
    public static final class C0238c implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f13859b;

        public C0238c(r rVar) {
            this.f13859b = rVar;
        }

        @Override // oe.r
        public void X(oe.d source, long j10) throws IOException {
            kotlin.jvm.internal.k.e(source, "source");
            oe.b.b(source.size(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                o oVar = source.f13862a;
                while (true) {
                    kotlin.jvm.internal.k.b(oVar);
                    if (j11 >= 65536) {
                        break;
                    }
                    j11 += (long) (oVar.f13890c - oVar.f13889b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    oVar = oVar.f13893f;
                }
                c cVar = c.this;
                r rVar = this.f13859b;
                cVar.r();
                try {
                    try {
                        rVar.X(source, j11);
                        lc.q qVar = lc.q.f12711a;
                        if (cVar.s()) {
                            throw cVar.l(null);
                        }
                        j10 -= j11;
                    } catch (IOException e10) {
                        if (!cVar.s()) {
                            throw e10;
                        }
                        throw cVar.l(e10);
                    }
                } catch (Throwable th) {
                    cVar.s();
                    throw th;
                }
            }
        }

        @Override // oe.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            r rVar = this.f13859b;
            cVar.r();
            try {
                try {
                    rVar.close();
                    lc.q qVar = lc.q.f12711a;
                    if (cVar.s()) {
                        throw cVar.l(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.s()) {
                        throw e10;
                    }
                    throw cVar.l(e10);
                }
            } catch (Throwable th) {
                cVar.s();
                throw th;
            }
        }

        @Override // oe.r, java.io.Flushable
        public void flush() throws IOException {
            c cVar = c.this;
            r rVar = this.f13859b;
            cVar.r();
            try {
                try {
                    rVar.flush();
                    lc.q qVar = lc.q.f12711a;
                    if (cVar.s()) {
                        throw cVar.l(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.s()) {
                        throw e10;
                    }
                    throw cVar.l(e10);
                }
            } catch (Throwable th) {
                cVar.s();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f13859b + ')';
        }
    }

    public static final class d implements t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f13861b;

        public d(t tVar) {
            this.f13861b = tVar;
        }

        @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            t tVar = this.f13861b;
            cVar.r();
            try {
                try {
                    tVar.close();
                    lc.q qVar = lc.q.f12711a;
                    if (cVar.s()) {
                        throw cVar.l(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.s()) {
                        throw e10;
                    }
                    throw cVar.l(e10);
                }
            } catch (Throwable th) {
                cVar.s();
                throw th;
            }
        }

        @Override // oe.t
        public long s(oe.d sink, long j10) throws IOException {
            kotlin.jvm.internal.k.e(sink, "sink");
            c cVar = c.this;
            t tVar = this.f13861b;
            cVar.r();
            try {
                try {
                    long jS = tVar.s(sink, j10);
                    if (cVar.s()) {
                        throw cVar.l(null);
                    }
                    return jS;
                } catch (IOException e10) {
                    if (cVar.s()) {
                        throw cVar.l(e10);
                    }
                    throw e10;
                }
            } catch (Throwable th) {
                cVar.s();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f13861b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f13850j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.k.d(conditionNewCondition, "lock.newCondition()");
        f13851k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f13852l = millis;
        f13853m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException l(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        long jD = d();
        boolean zB = b();
        if (jD != 0 || zB) {
            f13849i.g(this, jD, zB);
        }
    }

    public final boolean s() {
        return f13849i.d(this);
    }

    public IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long u(long j10) {
        return this.f13857h - j10;
    }

    public final r v(r sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        return new C0238c(sink);
    }

    public final t w(t source) {
        kotlin.jvm.internal.k.e(source, "source");
        return new d(source);
    }

    public void x() {
    }
}
