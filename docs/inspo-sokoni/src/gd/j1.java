package gd;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j1 extends k1 implements v0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9220f = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9221l = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9222m = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o<lc.q> f9223c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, o<? super lc.q> oVar) {
            super(j10);
            this.f9223c = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9223c.i(j1.this, lc.q.f12711a);
        }

        @Override // gd.j1.c
        public String toString() {
            return super.toString() + this.f9223c;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f9225c;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.f9225c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9225c.run();
        }

        @Override // gd.j1.c
        public String toString() {
            return super.toString() + this.f9225c;
        }
    }

    public static abstract class c implements Runnable, Comparable<c>, e1, ld.o0 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9227b = -1;

        public c(long j10) {
            this.f9226a = j10;
        }

        @Override // gd.e1
        public final void d() {
            synchronized (this) {
                Object obj = this._heap;
                if (obj == m1.f9233a) {
                    return;
                }
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null) {
                    dVar.g(this);
                }
                this._heap = m1.f9233a;
                lc.q qVar = lc.q.f12711a;
            }
        }

        @Override // ld.o0
        public int getIndex() {
            return this.f9227b;
        }

        @Override // ld.o0
        public ld.n0<?> i() {
            Object obj = this._heap;
            if (obj instanceof ld.n0) {
                return (ld.n0) obj;
            }
            return null;
        }

        @Override // ld.o0
        public void k(ld.n0<?> n0Var) {
            if (!(this._heap != m1.f9233a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = n0Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j10 = this.f9226a - cVar.f9226a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public final int n(long j10, d dVar, j1 j1Var) {
            synchronized (this) {
                if (this._heap == m1.f9233a) {
                    return 2;
                }
                synchronized (dVar) {
                    c cVarB = dVar.b();
                    if (j1Var.isCompleted()) {
                        return 1;
                    }
                    if (cVarB == null) {
                        dVar.f9228c = j10;
                    } else {
                        long j11 = cVarB.f9226a;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - dVar.f9228c > 0) {
                            dVar.f9228c = j10;
                        }
                    }
                    long j12 = this.f9226a;
                    long j13 = dVar.f9228c;
                    if (j12 - j13 < 0) {
                        this.f9226a = j13;
                    }
                    dVar.a(this);
                    return 0;
                }
            }
        }

        public final boolean o(long j10) {
            return j10 - this.f9226a >= 0;
        }

        @Override // ld.o0
        public void setIndex(int i10) {
            this.f9227b = i10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f9226a + ']';
        }
    }

    public static final class d extends ld.n0<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9228c;

        public d(long j10) {
            this.f9228c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f9222m.get(this) != 0;
    }

    public final void A0() {
        c cVarI;
        gd.c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f9221l.get(this);
            if (dVar == null || (cVarI = dVar.i()) == null) {
                return;
            } else {
                s0(jNanoTime, cVarI);
            }
        }
    }

    public final void B0() {
        f9220f.set(this, null);
        f9221l.set(this, null);
    }

    public final void C0(long j10, c cVar) {
        int iD0 = D0(j10, cVar);
        if (iD0 == 0) {
            if (G0(cVar)) {
                t0();
            }
        } else if (iD0 == 1) {
            s0(j10, cVar);
        } else if (iD0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int D0(long j10, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9221l;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            u.b.a(atomicReferenceFieldUpdater, this, null, new d(j10));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.k.b(obj);
            dVar = (d) obj;
        }
        return cVar.n(j10, dVar, this);
    }

    public final e1 E0(long j10, Runnable runnable) {
        long jC = m1.c(j10);
        if (jC >= 4611686018427387903L) {
            return m2.f9235a;
        }
        gd.c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        C0(jNanoTime, bVar);
        return bVar;
    }

    public final void F0(boolean z10) {
        f9222m.set(this, z10 ? 1 : 0);
    }

    public final boolean G0(c cVar) {
        d dVar = (d) f9221l.get(this);
        return (dVar != null ? dVar.e() : null) == cVar;
    }

    @Override // gd.j0
    public final void c0(oc.i iVar, Runnable runnable) {
        x0(runnable);
    }

    @Override // gd.v0
    public void e(long j10, o<? super lc.q> oVar) {
        long jC = m1.c(j10);
        if (jC < 4611686018427387903L) {
            gd.c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, oVar);
            C0(jNanoTime, aVar);
            r.a(oVar, aVar);
        }
    }

    @Override // gd.i1
    public long j0() {
        c cVarE;
        if (super.j0() == 0) {
            return 0L;
        }
        Object obj = f9220f.get(this);
        if (obj != null) {
            if (!(obj instanceof ld.u)) {
                return obj == m1.f9234b ? Long.MAX_VALUE : 0L;
            }
            if (!((ld.u) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) f9221l.get(this);
        if (dVar == null || (cVarE = dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarE.f9226a;
        gd.c.a();
        return bd.h.b(j10 - System.nanoTime(), 0L);
    }

    @Override // gd.v0
    public e1 k(long j10, Runnable runnable, oc.i iVar) {
        return v0.a.a(this, j10, runnable, iVar);
    }

    @Override // gd.i1
    public long o0() {
        c cVarH;
        if (p0()) {
            return 0L;
        }
        d dVar = (d) f9221l.get(this);
        if (dVar != null && !dVar.d()) {
            gd.c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c cVarB = dVar.b();
                    cVarH = null;
                    if (cVarB != null) {
                        c cVar = cVarB;
                        if (cVar.o(jNanoTime) ? y0(cVar) : false) {
                            cVarH = dVar.h(0);
                        }
                    }
                }
            } while (cVarH != null);
        }
        Runnable runnableW0 = w0();
        if (runnableW0 == null) {
            return j0();
        }
        runnableW0.run();
        return 0L;
    }

    @Override // gd.i1
    public void shutdown() {
        w2.f9268a.c();
        F0(true);
        v0();
        while (o0() <= 0) {
        }
        A0();
    }

    public final void v0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9220f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (u.b.a(f9220f, this, null, m1.f9234b)) {
                    return;
                }
            } else if (obj instanceof ld.u) {
                ((ld.u) obj).d();
                return;
            } else {
                if (obj == m1.f9234b) {
                    return;
                }
                ld.u uVar = new ld.u(8, true);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar.a((Runnable) obj);
                if (u.b.a(f9220f, this, obj, uVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable w0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9220f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof ld.u) {
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                ld.u uVar = (ld.u) obj;
                Object objJ = uVar.j();
                if (objJ != ld.u.f12770h) {
                    return (Runnable) objJ;
                }
                u.b.a(f9220f, this, obj, uVar.i());
            } else {
                if (obj == m1.f9234b) {
                    return null;
                }
                if (u.b.a(f9220f, this, obj, null)) {
                    kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void x0(Runnable runnable) {
        if (y0(runnable)) {
            t0();
        } else {
            r0.f9253n.x0(runnable);
        }
    }

    public final boolean y0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9220f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (u.b.a(f9220f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof ld.u) {
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                ld.u uVar = (ld.u) obj;
                int iA = uVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    u.b.a(f9220f, this, obj, uVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == m1.f9234b) {
                    return false;
                }
                ld.u uVar2 = new ld.u(8, true);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar2.a((Runnable) obj);
                uVar2.a(runnable);
                if (u.b.a(f9220f, this, obj, uVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean z0() {
        if (!n0()) {
            return false;
        }
        d dVar = (d) f9221l.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f9220f.get(this);
        if (obj != null) {
            if (obj instanceof ld.u) {
                return ((ld.u) obj).g();
            }
            if (obj != m1.f9234b) {
                return false;
            }
        }
        return true;
    }
}
