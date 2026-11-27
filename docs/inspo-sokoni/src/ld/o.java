package ld;

import gd.e1;
import gd.s0;
import gd.v0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends gd.j0 implements v0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12748m = AtomicIntegerFieldUpdater.newUpdater(o.class, "runningWorkers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gd.j0 f12749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v0 f12751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t<Runnable> f12752f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f12753l;
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f12754a;

        public a(Runnable runnable) {
            this.f12754a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f12754a.run();
                } catch (Throwable th) {
                    gd.l0.a(oc.j.f13812a, th);
                }
                Runnable runnableH0 = o.this.h0();
                if (runnableH0 == null) {
                    return;
                }
                this.f12754a = runnableH0;
                i10++;
                if (i10 >= 16 && o.this.f12749c.d0(o.this)) {
                    o.this.f12749c.c0(o.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(gd.j0 j0Var, int i10) {
        this.f12749c = j0Var;
        this.f12750d = i10;
        v0 v0Var = j0Var instanceof v0 ? (v0) j0Var : null;
        this.f12751e = v0Var == null ? s0.a() : v0Var;
        this.f12752f = new t<>(false);
        this.f12753l = new Object();
    }

    @Override // gd.j0
    public void c0(oc.i iVar, Runnable runnable) {
        Runnable runnableH0;
        this.f12752f.a(runnable);
        if (f12748m.get(this) >= this.f12750d || !i0() || (runnableH0 = h0()) == null) {
            return;
        }
        this.f12749c.c0(this, new a(runnableH0));
    }

    @Override // gd.v0
    public void e(long j10, gd.o<? super lc.q> oVar) {
        this.f12751e.e(j10, oVar);
    }

    public final Runnable h0() {
        while (true) {
            Runnable runnableD = this.f12752f.d();
            if (runnableD != null) {
                return runnableD;
            }
            synchronized (this.f12753l) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12748m;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f12752f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean i0() {
        synchronized (this.f12753l) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12748m;
            if (atomicIntegerFieldUpdater.get(this) >= this.f12750d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // gd.v0
    public e1 k(long j10, Runnable runnable, oc.i iVar) {
        return this.f12751e.k(j10, runnable, iVar);
    }
}
