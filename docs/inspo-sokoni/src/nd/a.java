package nd;

import gd.q0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.t;
import lc.q;
import ld.c0;
import ld.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0232a f13542m = new C0232a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f13543n = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f13544o = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f13545p = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final h0 f13546q = new h0("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13549c;
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nd.d f13551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final nd.d f13552f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<c> f13553l;
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: nd.a$a, reason: collision with other inner class name */
    public static final class C0232a {
        public C0232a() {
        }

        public /* synthetic */ C0232a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13554a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f13554a = iArr;
        }
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f13555n = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f13556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t<h> f13557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f13558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f13559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f13560e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13561f;
        private volatile int indexInArray;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f13562l;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f13556a = new n();
            this.f13557b = new t<>();
            this.f13558c = d.DORMANT;
            this.nextParkedWorker = a.f13546q;
            this.f13561f = zc.c.f20515a.b();
        }

        public c(a aVar, int i10) {
            this();
            q(i10);
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f13555n;
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            a.f13544o.addAndGet(a.this, -2097152L);
            if (this.f13558c != d.TERMINATED) {
                this.f13558c = d.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && u(d.BLOCKING)) {
                a.this.c0();
            }
        }

        public final void d(h hVar) {
            int iB = hVar.f13580b.b();
            k(iB);
            c(iB);
            a.this.L(hVar);
            b(iB);
        }

        public final h e(boolean z10) {
            h hVarO;
            h hVarO2;
            if (z10) {
                boolean z11 = m(a.this.f13547a * 2) == 0;
                if (z11 && (hVarO2 = o()) != null) {
                    return hVarO2;
                }
                h hVarG = this.f13556a.g();
                if (hVarG != null) {
                    return hVarG;
                }
                if (!z11 && (hVarO = o()) != null) {
                    return hVarO;
                }
            } else {
                h hVarO3 = o();
                if (hVarO3 != null) {
                    return hVarO3;
                }
            }
            return v(3);
        }

        public final h f() {
            h hVarH = this.f13556a.h();
            if (hVarH != null) {
                return hVarH;
            }
            h hVarD = a.this.f13552f.d();
            return hVarD == null ? v(1) : hVarD;
        }

        public final h g(boolean z10) {
            return s() ? e(z10) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int i10) {
            this.f13559d = 0L;
            if (this.f13558c == d.PARKING) {
                this.f13558c = d.BLOCKING;
            }
        }

        public final boolean l() {
            return this.nextParkedWorker != a.f13546q;
        }

        public final int m(int i10) {
            int i11 = this.f13561f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f13561f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER) % i10;
        }

        public final void n() {
            if (this.f13559d == 0) {
                this.f13559d = System.nanoTime() + a.this.f13549c;
            }
            LockSupport.parkNanos(a.this.f13549c);
            if (System.nanoTime() - this.f13559d >= 0) {
                this.f13559d = 0L;
                w();
            }
        }

        public final h o() {
            nd.d dVar;
            if (m(2) == 0) {
                h hVarD = a.this.f13551e.d();
                if (hVarD != null) {
                    return hVarD;
                }
                dVar = a.this.f13552f;
            } else {
                h hVarD2 = a.this.f13552f.d();
                if (hVarD2 != null) {
                    return hVarD2;
                }
                dVar = a.this.f13551e;
            }
            return dVar.d();
        }

        public final void p() {
            loop0: while (true) {
                boolean z10 = false;
                while (true) {
                    if (a.this.isTerminated() || this.f13558c == d.TERMINATED) {
                        break loop0;
                    }
                    h hVarG = g(this.f13562l);
                    if (hVarG != null) {
                        this.f13560e = 0L;
                        d(hVarG);
                        break;
                    }
                    this.f13562l = false;
                    if (this.f13560e == 0) {
                        t();
                    } else {
                        if (z10) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f13560e);
                            this.f13560e = 0L;
                            break;
                        }
                        z10 = true;
                    }
                }
            }
            u(d.TERMINATED);
        }

        public final void q(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.f13550d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean s() {
            boolean z10;
            if (this.f13558c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f13544o;
            while (true) {
                long j10 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    z10 = false;
                    break;
                }
                if (a.f13544o.compareAndSet(aVar, j10, j10 - 4398046511104L)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return false;
            }
            this.f13558c = d.CPU_ACQUIRED;
            return true;
        }

        public final void t() {
            if (!l()) {
                a.this.I(this);
                return;
            }
            f13555n.set(this, -1);
            while (l() && f13555n.get(this) == -1 && !a.this.isTerminated() && this.f13558c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        public final boolean u(d dVar) {
            d dVar2 = this.f13558c;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                a.f13544o.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f13558c = dVar;
            }
            return z10;
        }

        public final h v(int i10) {
            int i11 = (int) (a.f13544o.get(a.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iM = m(i11);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iM++;
                if (iM > i11) {
                    iM = 1;
                }
                c cVarB = aVar.f13553l.b(iM);
                if (cVarB != null && cVarB != this) {
                    long jN = cVarB.f13556a.n(i10, this.f13557b);
                    if (jN == -1) {
                        t<h> tVar = this.f13557b;
                        h hVar = tVar.f12381a;
                        tVar.f12381a = null;
                        return hVar;
                    }
                    if (jN > 0) {
                        jMin = Math.min(jMin, jN);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f13560e = jMin;
            return null;
        }

        public final void w() {
            a aVar = a.this;
            synchronized (aVar.f13553l) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (a.f13544o.get(aVar) & 2097151)) <= aVar.f13547a) {
                    return;
                }
                if (f13555n.compareAndSet(this, -1, 1)) {
                    int i10 = this.indexInArray;
                    q(0);
                    aVar.J(this, i10, 0);
                    int andDecrement = (int) (a.f13544o.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != i10) {
                        c cVarB = aVar.f13553l.b(andDecrement);
                        kotlin.jvm.internal.k.b(cVarB);
                        c cVar = cVarB;
                        aVar.f13553l.c(i10, cVar);
                        cVar.q(i10);
                        aVar.J(cVar, andDecrement, i10);
                    }
                    aVar.f13553l.c(andDecrement, null);
                    q qVar = q.f12711a;
                    this.f13558c = d.TERMINATED;
                }
            }
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i10, int i11, long j10, String str) {
        this.f13547a = i10;
        this.f13548b = i11;
        this.f13549c = j10;
        this.f13550d = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f13551e = new nd.d();
        this.f13552f = new nd.d();
        this.f13553l = new c0<>((i10 + 1) * 2);
        this.controlState = ((long) i10) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void C(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f13589g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.B(runnable, iVar, z10);
    }

    public static /* synthetic */ boolean f0(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f13544o.get(aVar);
        }
        return aVar.e0(j10);
    }

    public final void B(Runnable runnable, i iVar, boolean z10) {
        gd.c.a();
        h hVarV = v(runnable, iVar);
        boolean z11 = false;
        boolean z12 = hVarV.f13580b.b() == 1;
        long jAddAndGet = z12 ? f13544o.addAndGet(this, 2097152L) : 0L;
        c cVarZ = z();
        h hVarD0 = d0(cVarZ, hVarV, z10);
        if (hVarD0 != null && !k(hVarD0)) {
            throw new RejectedExecutionException(this.f13550d + " was terminated");
        }
        if (z10 && cVarZ != null) {
            z11 = true;
        }
        if (z12) {
            Q(jAddAndGet, z11);
        } else {
            if (z11) {
                return;
            }
            c0();
        }
    }

    public final int E(c cVar) {
        int iH;
        do {
            Object objI = cVar.i();
            if (objI == f13546q) {
                return -1;
            }
            if (objI == null) {
                return 0;
            }
            cVar = (c) objI;
            iH = cVar.h();
        } while (iH == 0);
        return iH;
    }

    public final c G() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13543n;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.f13553l.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int iE = E(cVarB);
            if (iE >= 0 && f13543n.compareAndSet(this, j10, ((long) iE) | j11)) {
                cVarB.r(f13546q);
                return cVarB;
            }
        }
    }

    public final boolean I(c cVar) {
        long j10;
        int iH;
        if (cVar.i() != f13546q) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13543n;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            iH = cVar.h();
            cVar.r(this.f13553l.b((int) (2097151 & j10)));
        } while (!f13543n.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | ((long) iH)));
        return true;
    }

    public final void J(c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13543n;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iE = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (iE == i10) {
                iE = i11 == 0 ? E(cVar) : i11;
            }
            if (iE >= 0 && f13543n.compareAndSet(this, j10, j11 | ((long) iE))) {
                return;
            }
        }
    }

    public final void L(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                gd.c.a();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public final void O(long j10) throws InterruptedException {
        int i10;
        h hVarD;
        if (f13545p.compareAndSet(this, 0, 1)) {
            c cVarZ = z();
            synchronized (this.f13553l) {
                i10 = (int) (f13544o.get(this) & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    c cVarB = this.f13553l.b(i11);
                    kotlin.jvm.internal.k.b(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarZ) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f13556a.f(this.f13552f);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.f13552f.b();
            this.f13551e.b();
            while (true) {
                if (cVarZ == null) {
                    hVarD = this.f13551e.d();
                    if (hVarD == null && (hVarD = this.f13552f.d()) == null) {
                        break;
                    }
                } else {
                    hVarD = cVarZ.g(true);
                    if (hVarD == null) {
                        hVarD = this.f13551e.d();
                        if (hVarD == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                L(hVarD);
            }
            if (cVarZ != null) {
                cVarZ.u(d.TERMINATED);
            }
            f13543n.set(this, 0L);
            f13544o.set(this, 0L);
        }
    }

    public final void Q(long j10, boolean z10) {
        if (z10 || g0() || e0(j10)) {
            return;
        }
        g0();
    }

    public final void c0() {
        if (g0() || f0(this, 0L, 1, null)) {
            return;
        }
        g0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        O(10000L);
    }

    public final h d0(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f13558c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f13580b.b() == 0 && cVar.f13558c == d.BLOCKING) {
            return hVar;
        }
        cVar.f13562l = true;
        return cVar.f13556a.a(hVar, z10);
    }

    public final boolean e0(long j10) {
        if (bd.h.a(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f13547a) {
            int iT = t();
            if (iT == 1 && this.f13547a > 1) {
                t();
            }
            if (iT > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        C(this, runnable, null, false, 6, null);
    }

    public final boolean g0() {
        c cVarG;
        do {
            cVarG = G();
            if (cVarG == null) {
                return false;
            }
        } while (!c.j().compareAndSet(cVarG, -1, 0));
        LockSupport.unpark(cVarG);
        return true;
    }

    public final boolean isTerminated() {
        return f13545p.get(this) != 0;
    }

    public final boolean k(h hVar) {
        return (hVar.f13580b.b() == 1 ? this.f13552f : this.f13551e).a(hVar);
    }

    public final int t() {
        synchronized (this.f13553l) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f13544o;
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 & 2097151);
            int iA = bd.h.a(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (iA >= this.f13547a) {
                return 0;
            }
            if (i10 >= this.f13548b) {
                return 0;
            }
            int i11 = ((int) (f13544o.get(this) & 2097151)) + 1;
            if (!(i11 > 0 && this.f13553l.b(i11) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i11);
            this.f13553l.c(i11, cVar);
            if (!(i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int i12 = iA + 1;
            cVar.start();
            return i12;
        }
    }

    public String toString() {
        StringBuilder sb2;
        char c10;
        ArrayList arrayList = new ArrayList();
        int iA = this.f13553l.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.f13553l.b(i15);
            if (cVarB != null) {
                int iE = cVarB.f13556a.e();
                int i16 = b.f13554a[cVarB.f13558c.ordinal()];
                if (i16 != 1) {
                    if (i16 == 2) {
                        i11++;
                        sb2 = new StringBuilder();
                        sb2.append(iE);
                        c10 = 'b';
                    } else if (i16 == 3) {
                        i10++;
                        sb2 = new StringBuilder();
                        sb2.append(iE);
                        c10 = 'c';
                    } else if (i16 == 4) {
                        i13++;
                        if (iE > 0) {
                            sb2 = new StringBuilder();
                            sb2.append(iE);
                            c10 = 'd';
                        }
                    } else if (i16 == 5) {
                        i14++;
                    }
                    sb2.append(c10);
                    arrayList.add(sb2.toString());
                } else {
                    i12++;
                }
            }
        }
        long j10 = f13544o.get(this);
        return this.f13550d + '@' + q0.b(this) + "[Pool Size {core = " + this.f13547a + ", max = " + this.f13548b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f13551e.c() + ", global blocking queue size = " + this.f13552f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f13547a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final h v(Runnable runnable, i iVar) {
        long jA = l.f13588f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.f13579a = jA;
        hVar.f13580b = iVar;
        return hVar;
    }

    public final c z() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !kotlin.jvm.internal.k.a(a.this, this)) {
            return null;
        }
        return cVar;
    }
}
