package xb;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f18669d = Logger.getLogger(j2.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f18670e = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f18671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f18672b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f18673c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(j2 j2Var, int i10, int i11);

        public abstract void b(j2 j2Var, int i10);
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<j2> f18674a;

        public c(AtomicIntegerFieldUpdater<j2> atomicIntegerFieldUpdater) {
            super();
            this.f18674a = atomicIntegerFieldUpdater;
        }

        @Override // xb.j2.b
        public boolean a(j2 j2Var, int i10, int i11) {
            return this.f18674a.compareAndSet(j2Var, i10, i11);
        }

        @Override // xb.j2.b
        public void b(j2 j2Var, int i10) {
            this.f18674a.set(j2Var, i10);
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        @Override // xb.j2.b
        public boolean a(j2 j2Var, int i10, int i11) {
            synchronized (j2Var) {
                if (j2Var.f18673c != i10) {
                    return false;
                }
                j2Var.f18673c = i11;
                return true;
            }
        }

        @Override // xb.j2.b
        public void b(j2 j2Var, int i10) {
            synchronized (j2Var) {
                j2Var.f18673c = i10;
            }
        }
    }

    public j2(Executor executor) {
        j6.m.p(executor, "'executor' must not be null.");
        this.f18671a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(j2.class, "c"));
        } catch (Throwable th) {
            f18669d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void e(Runnable runnable) {
        if (f18670e.a(this, 0, -1)) {
            try {
                this.f18671a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f18672b.remove(runnable);
                }
                f18670e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f18672b.add((Runnable) j6.m.p(runnable, "'r' must not be null."));
        e(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnablePoll;
        try {
            Executor executor = this.f18671a;
            while (executor == this.f18671a && (runnablePoll = this.f18672b.poll()) != null) {
                try {
                    runnablePoll.run();
                } catch (RuntimeException e10) {
                    f18669d.log(Level.SEVERE, "Exception while executing runnable " + runnablePoll, (Throwable) e10);
                }
            }
            f18670e.b(this, 0);
            if (this.f18672b.isEmpty()) {
                return;
            }
            e(null);
        } catch (Throwable th) {
            f18670e.b(this, 0);
            throw th;
        }
    }
}
