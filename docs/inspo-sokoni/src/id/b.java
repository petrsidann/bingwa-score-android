package id;

import gd.d3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ld.e0;
import ld.f0;
import ld.g0;
import ld.h0;
import ld.q0;
import ld.z;

/* JADX INFO: loaded from: classes2.dex */
public class b<E> implements d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f10578d = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f10579e = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f10580f = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f10581l = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10582m = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10583n = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10584o = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10585p = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10586q = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.l<E, lc.q> f10588b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xc.q<od.f<?>, Object, Object, xc.l<Throwable, lc.q>> f10589c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public final class a implements f<E>, d3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f10590a = id.c.f10614p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gd.p<? super Boolean> f10591b;

        public a() {
        }

        @Override // id.f
        public Object a(oc.e<? super Boolean> eVar) throws Throwable {
            boolean zG;
            j<E> jVar;
            b<E> bVar = b.this;
            j<E> jVar2 = (j) b.f10583n.get(bVar);
            while (!bVar.U()) {
                long andIncrement = b.f10579e.getAndIncrement(bVar);
                int i10 = id.c.f10600b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (jVar2.f12721c != j10) {
                    j<E> jVarG = bVar.G(j10, jVar2);
                    if (jVarG == null) {
                        continue;
                    } else {
                        jVar = jVarG;
                    }
                } else {
                    jVar = jVar2;
                }
                Object objZ0 = bVar.z0(jVar, i11, andIncrement, null);
                if (objZ0 == id.c.f10611m) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (objZ0 != id.c.f10613o) {
                    if (objZ0 == id.c.f10612n) {
                        return f(jVar, i11, andIncrement, eVar);
                    }
                    jVar.b();
                    this.f10590a = objZ0;
                    zG = true;
                    return qc.b.a(zG);
                }
                if (andIncrement < bVar.N()) {
                    jVar.b();
                }
                jVar2 = jVar;
            }
            zG = g();
            return qc.b.a(zG);
        }

        @Override // gd.d3
        public void b(e0<?> e0Var, int i10) {
            gd.p<? super Boolean> pVar = this.f10591b;
            if (pVar != null) {
                pVar.b(e0Var, i10);
            }
        }

        public final Object f(j<E> jVar, int i10, long j10, oc.e<? super Boolean> eVar) {
            Boolean boolA;
            b<E> bVar = b.this;
            gd.p pVarB = gd.r.b(pc.b.b(eVar));
            try {
                this.f10591b = pVarB;
                Object objZ0 = bVar.z0(jVar, i10, j10, this);
                if (objZ0 != id.c.f10611m) {
                    xc.l<Throwable, lc.q> lVarA = null;
                    if (objZ0 == id.c.f10613o) {
                        if (j10 < bVar.N()) {
                            jVar.b();
                        }
                        j jVar2 = (j) b.f10583n.get(bVar);
                        while (true) {
                            if (bVar.U()) {
                                h();
                                break;
                            }
                            long andIncrement = b.f10579e.getAndIncrement(bVar);
                            int i11 = id.c.f10600b;
                            long j11 = andIncrement / ((long) i11);
                            int i12 = (int) (andIncrement % ((long) i11));
                            if (jVar2.f12721c != j11) {
                                j jVarG = bVar.G(j11, jVar2);
                                if (jVarG != null) {
                                    jVar2 = jVarG;
                                }
                            }
                            Object objZ1 = bVar.z0(jVar2, i12, andIncrement, this);
                            if (objZ1 == id.c.f10611m) {
                                bVar.k0(this, jVar2, i12);
                                break;
                            }
                            if (objZ1 == id.c.f10613o) {
                                if (andIncrement < bVar.N()) {
                                    jVar2.b();
                                }
                            } else {
                                if (objZ1 == id.c.f10612n) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                jVar2.b();
                                this.f10590a = objZ1;
                                this.f10591b = null;
                                boolA = qc.b.a(true);
                                xc.l<E, lc.q> lVar = bVar.f10588b;
                                if (lVar != null) {
                                    lVarA = z.a(lVar, objZ1, pVarB.getContext());
                                }
                            }
                        }
                    } else {
                        jVar.b();
                        this.f10590a = objZ0;
                        this.f10591b = null;
                        boolA = qc.b.a(true);
                        xc.l<E, lc.q> lVar2 = bVar.f10588b;
                        if (lVar2 != null) {
                            lVarA = z.a(lVar2, objZ0, pVarB.getContext());
                        }
                    }
                    pVarB.c(boolA, lVarA);
                    break;
                }
                bVar.k0(this, jVar, i10);
                Object objY = pVarB.y();
                if (objY == pc.c.c()) {
                    qc.h.c(eVar);
                }
                return objY;
            } catch (Throwable th) {
                pVarB.J();
                throw th;
            }
        }

        public final boolean g() throws Throwable {
            this.f10590a = id.c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                return false;
            }
            throw g0.a(thJ);
        }

        public final void h() {
            Object objA;
            gd.p<? super Boolean> pVar = this.f10591b;
            kotlin.jvm.internal.k.b(pVar);
            this.f10591b = null;
            this.f10590a = id.c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                lc.j.a aVar = lc.j.f12703b;
                objA = Boolean.FALSE;
            } else {
                lc.j.a aVar2 = lc.j.f12703b;
                objA = lc.k.a(thJ);
            }
            pVar.resumeWith(lc.j.b(objA));
        }

        public final boolean i(E e10) {
            gd.p<? super Boolean> pVar = this.f10591b;
            kotlin.jvm.internal.k.b(pVar);
            this.f10591b = null;
            this.f10590a = e10;
            Boolean bool = Boolean.TRUE;
            xc.l<E, lc.q> lVar = b.this.f10588b;
            return id.c.B(pVar, bool, lVar != null ? z.a(lVar, e10, pVar.getContext()) : null);
        }

        public final void j() {
            Object objA;
            gd.p<? super Boolean> pVar = this.f10591b;
            kotlin.jvm.internal.k.b(pVar);
            this.f10591b = null;
            this.f10590a = id.c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                lc.j.a aVar = lc.j.f12703b;
                objA = Boolean.FALSE;
            } else {
                lc.j.a aVar2 = lc.j.f12703b;
                objA = lc.k.a(thJ);
            }
            pVar.resumeWith(lc.j.b(objA));
        }

        @Override // id.f
        public E next() throws Throwable {
            E e10 = (E) this.f10590a;
            if (!(e10 != id.c.f10614p)) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.f10590a = id.c.f10614p;
            if (e10 != id.c.z()) {
                return e10;
            }
            throw g0.a(b.this.K());
        }
    }

    /* JADX INFO: renamed from: id.b$b, reason: collision with other inner class name */
    public static final class C0177b implements d3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gd.o<Boolean> f10593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gd.p<Boolean> f10594b;

        public final gd.o<Boolean> a() {
            return this.f10593a;
        }

        @Override // gd.d3
        public void b(e0<?> e0Var, int i10) {
            this.f10594b.b(e0Var, i10);
        }
    }

    public static final class c extends kotlin.jvm.internal.l implements xc.q<od.f<?>, Object, Object, xc.l<? super Throwable, ? extends lc.q>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<E> f10595a;

        public static final class a extends kotlin.jvm.internal.l implements xc.l<Throwable, lc.q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f10596a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b<E> f10597b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ od.f<?> f10598c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, b<E> bVar, od.f<?> fVar) {
                super(1);
                this.f10596a = obj;
                this.f10597b = bVar;
                this.f10598c = fVar;
            }

            public final void a(Throwable th) throws IllegalAccessException, InvocationTargetException {
                if (this.f10596a != id.c.z()) {
                    z.b(this.f10597b.f10588b, this.f10596a, this.f10598c.getContext());
                }
            }

            @Override // xc.l
            public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) throws IllegalAccessException, InvocationTargetException {
                a(th);
                return lc.q.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b<E> bVar) {
            super(3);
            this.f10595a = bVar;
        }

        @Override // xc.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final xc.l<Throwable, lc.q> e(od.f<?> fVar, Object obj, Object obj2) {
            return new a(obj2, this.f10595a, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i10, xc.l<? super E, lc.q> lVar) {
        this.f10587a = i10;
        this.f10588b = lVar;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
        }
        this.bufferEnd = id.c.A(i10);
        this.completedExpandBuffersAndPauseFlag = I();
        j jVar = new j(0L, null, this, 3);
        this.sendSegment = jVar;
        this.receiveSegment = jVar;
        if (Y()) {
            jVar = id.c.f10599a;
            kotlin.jvm.internal.k.c(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = jVar;
        this.f10589c = lVar != 0 ? new c(this) : null;
        this._closeCause = id.c.f10617s;
    }

    public static /* synthetic */ void Q(b bVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bVar.P(j10);
    }

    public static /* synthetic */ <E> Object m0(b<E> bVar, oc.e<? super E> eVar) throws Throwable {
        j<E> jVar;
        j<E> jVar2 = (j) f10583n.get(bVar);
        while (!bVar.U()) {
            long andIncrement = f10579e.getAndIncrement(bVar);
            int i10 = id.c.f10600b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (jVar2.f12721c != j10) {
                j<E> jVarG = bVar.G(j10, jVar2);
                if (jVarG == null) {
                    continue;
                } else {
                    jVar = jVarG;
                }
            } else {
                jVar = jVar2;
            }
            Object objZ0 = bVar.z0(jVar, i11, andIncrement, null);
            if (objZ0 == id.c.f10611m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objZ0 != id.c.f10613o) {
                if (objZ0 == id.c.f10612n) {
                    return bVar.n0(jVar, i11, andIncrement, eVar);
                }
                jVar.b();
                return objZ0;
            }
            if (andIncrement < bVar.N()) {
                jVar.b();
            }
            jVar2 = jVar;
        }
        throw g0.a(bVar.K());
    }

    public static /* synthetic */ <E> Object s0(b<E> bVar, E e10, oc.e<? super lc.q> eVar) throws IllegalAccessException, InvocationTargetException {
        j<E> jVar;
        j<E> jVar2 = (j) f10582m.get(bVar);
        while (true) {
            long andIncrement = f10578d.getAndIncrement(bVar);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zW = bVar.W(andIncrement);
            int i10 = id.c.f10600b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar2.f12721c != j11) {
                j<E> jVarH = bVar.H(j11, jVar2);
                if (jVarH != null) {
                    jVar = jVarH;
                } else if (zW) {
                    Object objG0 = bVar.g0(e10, eVar);
                    if (objG0 != pc.c.c()) {
                        break;
                    }
                    return objG0;
                }
            } else {
                jVar = jVar2;
            }
            int iB0 = bVar.B0(jVar, i11, e10, j10, null, zW);
            if (iB0 == 0) {
                jVar.b();
                break;
            }
            if (iB0 != 1) {
                if (iB0 == 2) {
                    if (!zW) {
                        break;
                    }
                    jVar.p();
                    Object objG1 = bVar.g0(e10, eVar);
                    if (objG1 != pc.c.c()) {
                        break;
                    }
                    return objG1;
                }
                if (iB0 == 3) {
                    Object objT0 = bVar.t0(jVar, i11, e10, j10, eVar);
                    if (objT0 != pc.c.c()) {
                        break;
                    }
                    return objT0;
                }
                if (iB0 == 4) {
                    if (j10 < bVar.L()) {
                        jVar.b();
                    }
                    Object objG2 = bVar.g0(e10, eVar);
                    if (objG2 != pc.c.c()) {
                        break;
                    }
                    return objG2;
                }
                if (iB0 == 5) {
                    jVar.b();
                }
                jVar2 = jVar;
            } else {
                break;
            }
        }
        return lc.q.f12711a;
    }

    public final void A(long j10) throws IllegalAccessException, InvocationTargetException {
        o0(B(j10));
    }

    public final Object A0(j<E> jVar, int i10, long j10, Object obj) {
        while (true) {
            Object objW = jVar.w(i10);
            if (objW == null || objW == id.c.f10603e) {
                if (j10 < (f10578d.get(this) & 1152921504606846975L)) {
                    if (jVar.r(i10, objW, id.c.f10606h)) {
                        E();
                        return id.c.f10613o;
                    }
                } else {
                    if (obj == null) {
                        return id.c.f10612n;
                    }
                    if (jVar.r(i10, objW, obj)) {
                        E();
                        return id.c.f10611m;
                    }
                }
            } else {
                if (objW != id.c.f10602d) {
                    if (objW != id.c.f10608j && objW != id.c.f10606h) {
                        if (objW == id.c.z()) {
                            E();
                            return id.c.f10613o;
                        }
                        if (objW != id.c.f10605g && jVar.r(i10, objW, id.c.f10604f)) {
                            boolean z10 = objW instanceof v;
                            if (z10) {
                                objW = ((v) objW).f10639a;
                            }
                            if (w0(objW, jVar, i10)) {
                                jVar.A(i10, id.c.f10607i);
                                E();
                                return jVar.y(i10);
                            }
                            jVar.A(i10, id.c.f10608j);
                            jVar.x(i10, false);
                            if (z10) {
                                E();
                            }
                            return id.c.f10613o;
                        }
                    }
                    return id.c.f10613o;
                }
                if (jVar.r(i10, objW, id.c.f10607i)) {
                    E();
                    return jVar.y(i10);
                }
            }
        }
    }

    public final j<E> B(long j10) {
        j<E> jVarY = y();
        if (X()) {
            long jZ = Z(jVarY);
            if (jZ != -1) {
                D(jZ);
            }
        }
        x(jVarY, j10);
        return jVarY;
    }

    public final int B0(j<E> jVar, int i10, E e10, long j10, Object obj, boolean z10) {
        jVar.B(i10, e10);
        if (z10) {
            return C0(jVar, i10, e10, j10, obj, z10);
        }
        Object objW = jVar.w(i10);
        if (objW == null) {
            if (v(j10)) {
                if (jVar.r(i10, null, id.c.f10602d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (jVar.r(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (objW instanceof d3) {
            jVar.s(i10);
            if (v0(objW, e10)) {
                jVar.A(i10, id.c.f10607i);
                i0();
                return 0;
            }
            if (jVar.t(i10, id.c.f10609k) != id.c.f10609k) {
                jVar.x(i10, true);
            }
            return 5;
        }
        return C0(jVar, i10, e10, j10, obj, z10);
    }

    public final void C() {
        m();
    }

    public final int C0(j<E> jVar, int i10, E e10, long j10, Object obj, boolean z10) {
        while (true) {
            Object objW = jVar.w(i10);
            if (objW == null) {
                if (!v(j10) || z10) {
                    if (z10) {
                        if (jVar.r(i10, null, id.c.f10608j)) {
                            jVar.x(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (jVar.r(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (jVar.r(i10, null, id.c.f10602d)) {
                    return 1;
                }
            } else {
                if (objW != id.c.f10603e) {
                    if (objW == id.c.f10609k) {
                        jVar.s(i10);
                        return 5;
                    }
                    if (objW == id.c.f10606h) {
                        jVar.s(i10);
                        return 5;
                    }
                    h0 h0VarZ = id.c.z();
                    jVar.s(i10);
                    if (objW == h0VarZ) {
                        C();
                        return 4;
                    }
                    if (objW instanceof v) {
                        objW = ((v) objW).f10639a;
                    }
                    if (v0(objW, e10)) {
                        jVar.A(i10, id.c.f10607i);
                        i0();
                        return 0;
                    }
                    if (jVar.t(i10, id.c.f10609k) != id.c.f10609k) {
                        jVar.x(i10, true);
                    }
                    return 5;
                }
                if (jVar.r(i10, objW, id.c.f10602d)) {
                    return 1;
                }
            }
        }
    }

    public final void D(long j10) {
        q0 q0VarD;
        j<E> jVar = (j) f10583n.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f10579e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(((long) this.f10587a) + j11, I())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = id.c.f10600b;
                long j12 = j11 / ((long) i10);
                int i11 = (int) (j11 % ((long) i10));
                if (jVar.f12721c != j12) {
                    j<E> jVarG = G(j12, jVar);
                    if (jVarG == null) {
                        continue;
                    } else {
                        jVar = jVarG;
                    }
                }
                Object objZ0 = z0(jVar, i11, j11, null);
                if (objZ0 != id.c.f10613o) {
                    jVar.b();
                    xc.l<E, lc.q> lVar = this.f10588b;
                    if (lVar != null && (q0VarD = z.d(lVar, objZ0, null, 2, null)) != null) {
                        throw q0VarD;
                    }
                } else if (j11 < N()) {
                    jVar.b();
                }
            }
        }
    }

    public final void D0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10579e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
        } while (!f10579e.compareAndSet(this, j11, j10));
    }

    public final void E() {
        if (Y()) {
            return;
        }
        j<E> jVar = (j) f10584o.get(this);
        while (true) {
            long andIncrement = f10580f.getAndIncrement(this);
            int i10 = id.c.f10600b;
            long j10 = andIncrement / ((long) i10);
            long jN = N();
            long j11 = jVar.f12721c;
            if (jN <= andIncrement) {
                if (j11 < j10 && jVar.e() != 0) {
                    d0(j10, jVar);
                }
                Q(this, 0L, 1, null);
                return;
            }
            if (j11 != j10) {
                j<E> jVarF = F(j10, jVar, andIncrement);
                if (jVarF == null) {
                    continue;
                } else {
                    jVar = jVarF;
                }
            }
            boolean zX0 = x0(jVar, (int) (andIncrement % ((long) i10)), andIncrement);
            Q(this, 0L, 1, null);
            if (zX0) {
                return;
            }
        }
    }

    public final void E0(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10578d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = 1152921504606846975L & j11;
            if (j12 >= j10) {
                return;
            }
        } while (!f10578d.compareAndSet(this, j11, id.c.w(j12, (int) (j11 >> 60))));
    }

    public final j<E> F(long j10, j<E> jVar, long j11) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10584o;
        xc.p pVar = (xc.p) id.c.y();
        do {
            objC = ld.d.c(jVar, j10, pVar);
            if (!f0.c(objC)) {
                e0 e0VarB = f0.b(objC);
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    if (e0Var.f12721c < e0VarB.f12721c) {
                        if (!e0VarB.q()) {
                            z10 = false;
                            break;
                        }
                        if (u.b.a(atomicReferenceFieldUpdater, this, e0Var, e0VarB)) {
                            if (e0Var.m()) {
                                e0Var.k();
                            }
                        } else if (e0VarB.m()) {
                            e0VarB.k();
                        }
                    }
                    z10 = true;
                    break;
                }
            } else {
                break;
            }
        } while (!z10);
        if (f0.c(objC)) {
            C();
            d0(j10, jVar);
        } else {
            j<E> jVar2 = (j) f0.b(objC);
            long j12 = jVar2.f12721c;
            if (j12 <= j10) {
                return jVar2;
            }
            int i10 = id.c.f10600b;
            if (f10580f.compareAndSet(this, j11 + 1, ((long) i10) * j12)) {
                P((jVar2.f12721c * ((long) i10)) - j11);
                return null;
            }
        }
        Q(this, 0L, 1, null);
        return null;
    }

    public final void F0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        if (Y()) {
            return;
        }
        while (I() <= j10) {
        }
        int i10 = id.c.f10601c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jI = I();
            if (jI == (4611686018427387903L & f10581l.get(this)) && jI == I()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f10581l;
        do {
            j11 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, id.c.v(j11 & 4611686018427387903L, true)));
        while (true) {
            long jI2 = I();
            atomicLongFieldUpdater = f10581l;
            long j13 = atomicLongFieldUpdater.get(this);
            long j14 = j13 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j13) != 0;
            if (jI2 == j14 && jI2 == I()) {
                break;
            } else if (!z10) {
                atomicLongFieldUpdater.compareAndSet(this, j13, id.c.v(j14, true));
            }
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, id.c.v(j12 & 4611686018427387903L, false)));
    }

    public final j<E> G(long j10, j<E> jVar) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10583n;
        xc.p pVar = (xc.p) id.c.y();
        do {
            objC = ld.d.c(jVar, j10, pVar);
            if (!f0.c(objC)) {
                e0 e0VarB = f0.b(objC);
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (e0Var.f12721c >= e0VarB.f12721c) {
                        break;
                    }
                    if (!e0VarB.q()) {
                        z10 = false;
                        break;
                    }
                    if (u.b.a(atomicReferenceFieldUpdater, this, e0Var, e0VarB)) {
                        if (!e0Var.m()) {
                            break;
                        }
                        e0Var.k();
                        break;
                    }
                    if (e0VarB.m()) {
                        e0VarB.k();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        if (f0.c(objC)) {
            C();
            if (jVar.f12721c * ((long) id.c.f10600b) >= N()) {
                return null;
            }
        } else {
            jVar = (j) f0.b(objC);
            if (!Y() && j10 <= I() / ((long) id.c.f10600b)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f10584o;
                while (true) {
                    e0 e0Var2 = (e0) atomicReferenceFieldUpdater2.get(this);
                    if (e0Var2.f12721c >= jVar.f12721c || !jVar.q()) {
                        break;
                    }
                    if (u.b.a(atomicReferenceFieldUpdater2, this, e0Var2, jVar)) {
                        if (!e0Var2.m()) {
                            break;
                        }
                        e0Var2.k();
                        break;
                    }
                    if (jVar.m()) {
                        jVar.k();
                    }
                }
            }
            long j11 = jVar.f12721c;
            if (j11 <= j10) {
                return jVar;
            }
            int i10 = id.c.f10600b;
            D0(j11 * ((long) i10));
            if (jVar.f12721c * ((long) i10) >= N()) {
                return null;
            }
        }
        jVar.b();
        return null;
    }

    public final j<E> H(long j10, j<E> jVar) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10582m;
        xc.p pVar = (xc.p) id.c.y();
        do {
            objC = ld.d.c(jVar, j10, pVar);
            if (!f0.c(objC)) {
                e0 e0VarB = f0.b(objC);
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (e0Var.f12721c >= e0VarB.f12721c) {
                        break;
                    }
                    if (!e0VarB.q()) {
                        z10 = false;
                        break;
                    }
                    if (u.b.a(atomicReferenceFieldUpdater, this, e0Var, e0VarB)) {
                        if (!e0Var.m()) {
                            break;
                        }
                        e0Var.k();
                        break;
                    }
                    if (e0VarB.m()) {
                        e0VarB.k();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        if (f0.c(objC)) {
            C();
            if (jVar.f12721c * ((long) id.c.f10600b) >= L()) {
                return null;
            }
        } else {
            jVar = (j) f0.b(objC);
            long j11 = jVar.f12721c;
            if (j11 <= j10) {
                return jVar;
            }
            int i10 = id.c.f10600b;
            E0(j11 * ((long) i10));
            if (jVar.f12721c * ((long) i10) >= L()) {
                return null;
            }
        }
        jVar.b();
        return null;
    }

    public final long I() {
        return f10580f.get(this);
    }

    public final Throwable J() {
        return (Throwable) f10585p.get(this);
    }

    public final Throwable K() {
        Throwable thJ = J();
        return thJ == null ? new m("Channel was closed") : thJ;
    }

    public final long L() {
        return f10579e.get(this);
    }

    public final Throwable M() {
        Throwable thJ = J();
        return thJ == null ? new n("Channel was closed") : thJ;
    }

    public final long N() {
        return f10578d.get(this) & 1152921504606846975L;
    }

    public final boolean O() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10583n;
            j<E> jVarG = (j) atomicReferenceFieldUpdater.get(this);
            long jL = L();
            if (N() <= jL) {
                return false;
            }
            int i10 = id.c.f10600b;
            long j10 = jL / ((long) i10);
            if (jVarG.f12721c == j10 || (jVarG = G(j10, jVarG)) != null) {
                jVarG.b();
                if (S(jVarG, (int) (jL % ((long) i10)), jL)) {
                    return true;
                }
                f10579e.compareAndSet(this, jL, jL + 1);
            } else if (((j) atomicReferenceFieldUpdater.get(this)).f12721c < j10) {
                return false;
            }
        }
    }

    public final void P(long j10) {
        if ((f10581l.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
            } while ((f10581l.get(this) & 4611686018427387904L) != 0);
        }
    }

    public final void R() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10586q;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!u.b.a(atomicReferenceFieldUpdater, this, obj, obj == null ? id.c.f10615q : id.c.f10616r));
        if (obj == null) {
            return;
        }
        ((xc.l) obj).invoke(J());
    }

    public final boolean S(j<E> jVar, int i10, long j10) {
        Object objW;
        do {
            objW = jVar.w(i10);
            if (objW != null && objW != id.c.f10603e) {
                if (objW == id.c.f10602d) {
                    return true;
                }
                if (objW == id.c.f10608j || objW == id.c.z() || objW == id.c.f10607i || objW == id.c.f10606h) {
                    return false;
                }
                if (objW == id.c.f10605g) {
                    return true;
                }
                return objW != id.c.f10604f && j10 == L();
            }
        } while (!jVar.r(i10, objW, id.c.f10606h));
        E();
        return false;
    }

    public final boolean T(long j10, boolean z10) throws IllegalAccessException, InvocationTargetException {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            B(j10 & 1152921504606846975L);
            if (z10 && O()) {
                return false;
            }
        } else {
            if (i10 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i10).toString());
            }
            A(j10 & 1152921504606846975L);
        }
        return true;
    }

    public boolean U() {
        return V(f10578d.get(this));
    }

    public final boolean V(long j10) {
        return T(j10, true);
    }

    public final boolean W(long j10) {
        return T(j10, false);
    }

    public boolean X() {
        return false;
    }

    public final boolean Y() {
        long jI = I();
        return jI == 0 || jI == Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long Z(j<E> jVar) {
        do {
            int i10 = id.c.f10600b;
            while (true) {
                i10--;
                if (-1 < i10) {
                    long j10 = (jVar.f12721c * ((long) id.c.f10600b)) + ((long) i10);
                    if (j10 >= L()) {
                        while (true) {
                            Object objW = jVar.w(i10);
                            if (objW != null && objW != id.c.f10603e) {
                                if (objW != id.c.f10602d) {
                                    break;
                                }
                                return j10;
                            }
                            if (jVar.r(i10, objW, id.c.z())) {
                                jVar.p();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                }
            }
            jVar = (j) jVar.g();
        } while (jVar != null);
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.t
    public Object a() {
        j jVar;
        long j10 = f10579e.get(this);
        long j11 = f10578d.get(this);
        if (V(j11)) {
            return h.f10625b.a(J());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return h.f10625b.b();
        }
        Object obj = id.c.f10609k;
        j jVar2 = (j) f10583n.get(this);
        while (!U()) {
            long andIncrement = f10579e.getAndIncrement(this);
            int i10 = id.c.f10600b;
            long j12 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (jVar2.f12721c != j12) {
                j jVarG = G(j12, jVar2);
                if (jVarG == null) {
                    continue;
                } else {
                    jVar = jVarG;
                }
            } else {
                jVar = jVar2;
            }
            Object objZ0 = z0(jVar, i11, andIncrement, obj);
            if (objZ0 == id.c.f10611m) {
                d3 d3Var = obj instanceof d3 ? (d3) obj : null;
                if (d3Var != null) {
                    k0(d3Var, jVar, i11);
                }
                F0(andIncrement);
                jVar.p();
                return h.f10625b.b();
            }
            if (objZ0 != id.c.f10613o) {
                if (objZ0 == id.c.f10612n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                jVar.b();
                return h.f10625b.c(objZ0);
            }
            if (andIncrement < N()) {
                jVar.b();
            }
            jVar2 = jVar;
        }
        return h.f10625b.a(J());
    }

    public final void a0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10578d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, id.c.w(1152921504606846975L & j10, 1)));
    }

    @Override // id.t
    public Object b(oc.e<? super E> eVar) {
        return m0(this, eVar);
    }

    public final void b0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10578d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, id.c.w(1152921504606846975L & j10, 3)));
    }

    public final void c0() {
        long j10;
        long j11;
        int i10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10578d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (j10 >> 60);
            if (i11 == 0) {
                j11 = j10 & 1152921504606846975L;
                i10 = 2;
            } else {
                if (i11 != 1) {
                    return;
                }
                j11 = j10 & 1152921504606846975L;
                i10 = 3;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, id.c.w(j11, i10)));
    }

    @Override // id.t
    public final void cancel(CancellationException cancellationException) {
        w(cancellationException);
    }

    @Override // id.u
    public Object d(E e10, oc.e<? super lc.q> eVar) {
        return s0(this, e10, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0(long j10, j<E> jVar) {
        boolean z10;
        j<E> jVar2;
        j<E> jVar3;
        while (jVar.f12721c < j10 && (jVar3 = (j) jVar.e()) != null) {
            jVar = jVar3;
        }
        while (true) {
            if (!jVar.h() || (jVar2 = (j) jVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10584o;
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (e0Var.f12721c >= jVar.f12721c) {
                        break;
                    }
                    if (!jVar.q()) {
                        z10 = false;
                        break;
                    } else if (u.b.a(atomicReferenceFieldUpdater, this, e0Var, jVar)) {
                        if (!e0Var.m()) {
                            break;
                        }
                        e0Var.k();
                        break;
                    } else if (jVar.m()) {
                        jVar.k();
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                jVar = jVar2;
            }
        }
    }

    @Override // id.u
    public boolean e(Throwable th) {
        return z(th, false);
    }

    public void e0() {
    }

    public final void f0(gd.o<? super E> oVar) {
        lc.j.a aVar = lc.j.f12703b;
        oVar.resumeWith(lc.j.b(lc.k.a(K())));
    }

    public final Object g0(E e10, oc.e<? super lc.q> eVar) throws IllegalAccessException, InvocationTargetException {
        Throwable thM;
        gd.p pVar = new gd.p(pc.b.b(eVar), 1);
        pVar.B();
        xc.l<E, lc.q> lVar = this.f10588b;
        if (lVar == null || (thM = z.d(lVar, e10, null, 2, null)) == null) {
            thM = M();
        } else {
            lc.a.a(thM, M());
        }
        lc.j.a aVar = lc.j.f12703b;
        pVar.resumeWith(lc.j.b(lc.k.a(thM)));
        Object objY = pVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY == pc.c.c() ? objY : lc.q.f12711a;
    }

    public final void h0(E e10, gd.o<? super lc.q> oVar) throws IllegalAccessException, InvocationTargetException {
        xc.l<E, lc.q> lVar = this.f10588b;
        if (lVar != null) {
            z.b(lVar, e10, oVar.getContext());
        }
        Throwable thM = M();
        lc.j.a aVar = lc.j.f12703b;
        oVar.resumeWith(lc.j.b(lc.k.a(thM)));
    }

    public void i0() {
    }

    @Override // id.t
    public f<E> iterator() {
        return new a();
    }

    @Override // id.u
    public void j(xc.l<? super Throwable, lc.q> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10586q;
        if (u.b.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != id.c.f10615q) {
                if (obj == id.c.f10616r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!u.b.a(f10586q, this, id.c.f10615q, id.c.f10616r));
        lVar.invoke(J());
    }

    public void j0() {
    }

    public final void k0(d3 d3Var, j<E> jVar, int i10) {
        j0();
        d3Var.b(jVar, i10);
    }

    @Override // id.u
    public Object l(E e10) {
        j jVar;
        if (u0(f10578d.get(this))) {
            return h.f10625b.b();
        }
        Object obj = id.c.f10608j;
        j jVar2 = (j) f10582m.get(this);
        while (true) {
            long andIncrement = f10578d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zW = W(andIncrement);
            int i10 = id.c.f10600b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar2.f12721c != j11) {
                j jVarH = H(j11, jVar2);
                if (jVarH != null) {
                    jVar = jVarH;
                } else if (zW) {
                    break;
                }
            } else {
                jVar = jVar2;
            }
            int iB0 = B0(jVar, i11, e10, j10, obj, zW);
            if (iB0 == 0) {
                jVar.b();
            } else if (iB0 != 1) {
                if (iB0 == 2) {
                    if (zW) {
                        jVar.p();
                        break;
                    }
                    d3 d3Var = obj instanceof d3 ? (d3) obj : null;
                    if (d3Var != null) {
                        l0(d3Var, jVar, i11);
                    }
                    jVar.p();
                    return h.f10625b.b();
                }
                if (iB0 == 3) {
                    throw new IllegalStateException("unexpected".toString());
                }
                if (iB0 == 4) {
                    if (j10 >= L()) {
                        break;
                    }
                    jVar.b();
                    break;
                }
                if (iB0 == 5) {
                    jVar.b();
                }
                jVar2 = jVar;
            }
            return h.f10625b.c(lc.q.f12711a);
        }
        return h.f10625b.a(M());
    }

    public final void l0(d3 d3Var, j<E> jVar, int i10) {
        d3Var.b(jVar, i10 + id.c.f10600b);
    }

    @Override // id.u
    public boolean m() {
        return W(f10578d.get(this));
    }

    public final Object n0(j<E> jVar, int i10, long j10, oc.e<? super E> eVar) {
        gd.p pVarB = gd.r.b(pc.b.b(eVar));
        try {
            Object objZ0 = z0(jVar, i10, j10, pVarB);
            if (objZ0 != id.c.f10611m) {
                xc.l<Throwable, lc.q> lVarA = null;
                lVarA = null;
                if (objZ0 == id.c.f10613o) {
                    if (j10 < N()) {
                        jVar.b();
                    }
                    j jVar2 = (j) f10583n.get(this);
                    while (true) {
                        if (U()) {
                            f0(pVarB);
                            break;
                        }
                        long andIncrement = f10579e.getAndIncrement(this);
                        int i11 = id.c.f10600b;
                        long j11 = andIncrement / ((long) i11);
                        int i12 = (int) (andIncrement % ((long) i11));
                        if (jVar2.f12721c != j11) {
                            j jVarG = G(j11, jVar2);
                            if (jVarG != null) {
                                jVar2 = jVarG;
                            }
                        }
                        objZ0 = z0(jVar2, i12, andIncrement, pVarB);
                        if (objZ0 == id.c.f10611m) {
                            gd.p pVar = pVarB instanceof d3 ? pVarB : null;
                            if (pVar == null) {
                                break;
                            }
                            k0(pVar, jVar2, i12);
                            break;
                        }
                        if (objZ0 == id.c.f10613o) {
                            if (andIncrement < N()) {
                                jVar2.b();
                            }
                        } else {
                            if (objZ0 == id.c.f10612n) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            jVar2.b();
                            xc.l<E, lc.q> lVar = this.f10588b;
                            if (lVar != null) {
                                lVarA = z.a(lVar, objZ0, pVarB.getContext());
                            }
                        }
                    }
                } else {
                    jVar.b();
                    xc.l<E, lc.q> lVar2 = this.f10588b;
                    if (lVar2 != null) {
                        lVarA = z.a(lVar2, objZ0, pVarB.getContext());
                    }
                }
                pVarB.c(objZ0, lVarA);
                break;
            }
            k0(pVarB, jVar, i10);
            Object objY = pVarB.y();
            if (objY == pc.c.c()) {
                qc.h.c(eVar);
            }
            return objY;
        } catch (Throwable th) {
            pVarB.J();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(j<E> jVar) throws IllegalAccessException, InvocationTargetException {
        xc.l<E, lc.q> lVar = this.f10588b;
        q0 q0VarC = null;
        Object objB = ld.n.b(null, 1, null);
        loop0: do {
            for (int i10 = id.c.f10600b - 1; -1 < i10; i10--) {
                long j10 = (jVar.f12721c * ((long) id.c.f10600b)) + ((long) i10);
                while (true) {
                    Object objW = jVar.w(i10);
                    if (objW == id.c.f10607i) {
                        break loop0;
                    }
                    if (objW == id.c.f10602d) {
                        if (j10 < L()) {
                            break loop0;
                        }
                        if (jVar.r(i10, objW, id.c.z())) {
                            if (lVar != null) {
                                q0VarC = z.c(lVar, jVar.v(i10), q0VarC);
                            }
                            jVar.s(i10);
                        }
                    } else if (objW == id.c.f10603e || objW == null) {
                        if (jVar.r(i10, objW, id.c.z())) {
                        }
                    } else if ((objW instanceof d3) || (objW instanceof v)) {
                        if (j10 < L()) {
                            break loop0;
                        }
                        d3 d3Var = objW instanceof v ? ((v) objW).f10639a : (d3) objW;
                        if (jVar.r(i10, objW, id.c.z())) {
                            if (lVar != null) {
                                q0VarC = z.c(lVar, jVar.v(i10), q0VarC);
                            }
                            objB = ld.n.c(objB, d3Var);
                            jVar.s(i10);
                        }
                    } else if (objW == id.c.f10605g || objW == id.c.f10604f) {
                        break loop0;
                    } else if (objW != id.c.f10605g) {
                    }
                    jVar.p();
                }
            }
            jVar = (j) jVar.g();
        } while (jVar != null);
        if (objB != null) {
            if (objB instanceof ArrayList) {
                kotlin.jvm.internal.k.c(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    q0((d3) arrayList.get(size));
                }
            } else {
                q0((d3) objB);
            }
        }
        if (q0VarC != null) {
            throw q0VarC;
        }
    }

    public final void p0(d3 d3Var) {
        r0(d3Var, true);
    }

    public final void q0(d3 d3Var) {
        r0(d3Var, false);
    }

    public final void r0(d3 d3Var, boolean z10) {
        oc.e eVarA;
        Object objB;
        if (d3Var instanceof C0177b) {
            eVarA = ((C0177b) d3Var).a();
            lc.j.a aVar = lc.j.f12703b;
            objB = Boolean.FALSE;
        } else if (d3Var instanceof gd.o) {
            eVarA = (oc.e) d3Var;
            lc.j.a aVar2 = lc.j.f12703b;
            objB = lc.k.a(z10 ? K() : M());
        } else {
            if (!(d3Var instanceof s)) {
                if (d3Var instanceof a) {
                    ((a) d3Var).j();
                    return;
                } else {
                    if (d3Var instanceof od.f) {
                        ((od.f) d3Var).c(this, id.c.z());
                        return;
                    }
                    throw new IllegalStateException(("Unexpected waiter: " + d3Var).toString());
                }
            }
            eVarA = ((s) d3Var).f10638a;
            lc.j.a aVar3 = lc.j.f12703b;
            objB = h.b(h.f10625b.a(J()));
        }
        eVarA.resumeWith(lc.j.b(objB));
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0119  */
    /* JADX WARN: Code duplicated, block: B:63:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x0123  */
    public final Object t0(j<E> jVar, int i10, E e10, long j10, oc.e<? super lc.q> eVar) {
        Object objB;
        Object objY;
        j jVar2;
        gd.p pVarB = gd.r.b(pc.b.b(eVar));
        try {
            int iB0 = B0(jVar, i10, e10, j10, pVarB, false);
            if (iB0 == 0) {
                jVar.b();
                lc.j.a aVar = lc.j.f12703b;
                objB = lc.j.b(lc.q.f12711a);
            } else {
                if (iB0 != 1) {
                    if (iB0 != 2) {
                        if (iB0 != 4) {
                            if (iB0 != 5) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            jVar.b();
                            j jVar3 = (j) f10582m.get(this);
                            while (true) {
                                long andIncrement = f10578d.getAndIncrement(this);
                                long j11 = andIncrement & 1152921504606846975L;
                                boolean zW = W(andIncrement);
                                int i11 = id.c.f10600b;
                                long j12 = j11 / ((long) i11);
                                int i12 = (int) (j11 % ((long) i11));
                                if (jVar3.f12721c != j12) {
                                    j jVarH = H(j12, jVar3);
                                    if (jVarH != null) {
                                        jVar2 = jVarH;
                                    } else if (zW) {
                                    }
                                } else {
                                    jVar2 = jVar3;
                                }
                                j jVar4 = jVar2;
                                int iB1 = B0(jVar2, i12, e10, j11, pVarB, zW);
                                if (iB1 == 0) {
                                    jVar4.b();
                                    lc.j.a aVar2 = lc.j.f12703b;
                                    objB = lc.j.b(lc.q.f12711a);
                                } else if (iB1 == 1) {
                                    lc.j.a aVar3 = lc.j.f12703b;
                                    objB = lc.j.b(lc.q.f12711a);
                                } else if (iB1 == 2) {
                                    if (!zW) {
                                        gd.p pVar = pVarB instanceof d3 ? pVarB : null;
                                        if (pVar == null) {
                                            break;
                                        }
                                        l0(pVar, jVar4, i12);
                                        break;
                                    }
                                    jVar4.p();
                                } else {
                                    if (iB1 == 3) {
                                        throw new IllegalStateException("unexpected".toString());
                                    }
                                    if (iB1 != 4) {
                                        if (iB1 == 5) {
                                            jVar4.b();
                                        }
                                        jVar3 = jVar4;
                                    } else if (j11 < L()) {
                                        jVar4.b();
                                    }
                                }
                            }
                        } else if (j10 < L()) {
                            jVar.b();
                        }
                        h0(e10, pVarB);
                        break;
                    } else {
                        l0(pVarB, jVar, i10);
                    }
                    objY = pVarB.y();
                    if (objY == pc.c.c()) {
                        qc.h.c(eVar);
                    }
                    if (objY == pc.c.c()) {
                        return objY;
                    }
                    return lc.q.f12711a;
                }
                lc.j.a aVar4 = lc.j.f12703b;
                objB = lc.j.b(lc.q.f12711a);
            }
            pVarB.resumeWith(objB);
            objY = pVarB.y();
            if (objY == pc.c.c()) {
                qc.h.c(eVar);
            }
            if (objY == pc.c.c()) {
                return objY;
            }
            return lc.q.f12711a;
        } catch (Throwable th) {
            pVarB.J();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:103:0x0203 A[LOOP:2: B:30:0x00c0->B:103:0x0203, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:104:0x0207  */
    /* JADX WARN: Code duplicated, block: B:106:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x01e4 A[EDGE_INSN: B:114:0x01e4->B:98:0x01e4 BREAK  A[LOOP:2: B:30:0x00c0->B:103:0x0203], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x0071  */
    /* JADX WARN: Code duplicated, block: B:14:0x007e  */
    /* JADX WARN: Code duplicated, block: B:15:0x0080  */
    /* JADX WARN: Code duplicated, block: B:20:0x0091  */
    /* JADX WARN: Code duplicated, block: B:23:0x009c  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:52:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0107 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111  */
    /* JADX WARN: Code duplicated, block: B:58:0x0115  */
    /* JADX WARN: Code duplicated, block: B:59:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x011d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0121  */
    /* JADX WARN: Code duplicated, block: B:64:0x0125  */
    /* JADX WARN: Code duplicated, block: B:65:0x013d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0147  */
    /* JADX WARN: Code duplicated, block: B:68:0x0149  */
    /* JADX WARN: Code duplicated, block: B:70:0x0153  */
    /* JADX WARN: Code duplicated, block: B:71:0x0156 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0158  */
    /* JADX WARN: Code duplicated, block: B:73:0x015a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0164  */
    /* JADX WARN: Code duplicated, block: B:76:0x0166  */
    /* JADX WARN: Code duplicated, block: B:78:0x0170  */
    /* JADX WARN: Code duplicated, block: B:79:0x0172  */
    /* JADX WARN: Code duplicated, block: B:81:0x017c  */
    /* JADX WARN: Code duplicated, block: B:82:0x017e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0188  */
    /* JADX WARN: Code duplicated, block: B:85:0x018a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0194  */
    /* JADX WARN: Code duplicated, block: B:88:0x0196  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c3  */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x0125, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x01a6, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x01c3, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        int i10;
        ArrayList arrayList;
        Iterator it;
        Object next;
        j jVar;
        long jL;
        long jN;
        int i11;
        int i12;
        long j10;
        Object objW;
        Object objV;
        boolean zA;
        boolean zA2;
        boolean zA3;
        boolean zA4;
        boolean zA5;
        boolean zA6;
        boolean zA7;
        String string;
        String str;
        long j11;
        Object next2;
        long j12;
        boolean z10;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        int i13 = (int) (f10578d.get(this) >> 60);
        if (i13 != 2) {
            str2 = i13 == 3 ? "cancelled," : "closed,";
            sb2.append("capacity=" + this.f10587a + ',');
            sb2.append("data=[");
            i10 = 0;
            List listI = mc.o.i(f10583n.get(this), f10582m.get(this), f10584o.get(this));
            arrayList = new ArrayList();
            for (Object obj : listI) {
                if (((j) obj) != id.c.f10599a) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    arrayList.add(obj);
                }
            }
            it = arrayList.iterator();
            if (it.hasNext()) {
                throw new NoSuchElementException();
            }
            next = it.next();
            if (it.hasNext()) {
                j11 = ((j) next).f12721c;
                do {
                    next2 = it.next();
                    j12 = ((j) next2).f12721c;
                    if (j11 > j12) {
                        next = next2;
                        j11 = j12;
                    }
                } while (it.hasNext());
            }
            jVar = (j) next;
            jL = L();
            jN = N();
            loop2: while (true) {
                i11 = id.c.f10600b;
                for (i12 = i10; i12 < i11; i12++) {
                    j10 = (jVar.f12721c * ((long) id.c.f10600b)) + ((long) i12);
                    if (j10 < jN && j10 >= jL) {
                        break loop2;
                    }
                    objW = jVar.w(i12);
                    objV = jVar.v(i12);
                    if (objW instanceof gd.o) {
                        if (j10 >= jL && j10 >= jN) {
                            string = "receive";
                        } else if (j10 < jN || j10 < jL) {
                            string = "cont";
                        } else {
                            string = "send";
                        }
                    } else if (objW instanceof od.f) {
                        if (j10 >= jL && j10 >= jN) {
                            string = "onReceive";
                        } else if (j10 < jN || j10 < jL) {
                            string = "select";
                        } else {
                            string = "onSend";
                        }
                    } else if (objW instanceof s) {
                        string = "receiveCatching";
                    } else if (objW instanceof C0177b) {
                        string = "sendBroadcast";
                    } else if (objW instanceof v) {
                        string = "EB(" + objW + ')';
                    } else {
                        if (kotlin.jvm.internal.k.a(objW, id.c.f10604f)) {
                            zA = true;
                        } else {
                            zA = kotlin.jvm.internal.k.a(objW, id.c.f10605g);
                        }
                        if (zA) {
                            string = "resuming_sender";
                        } else {
                            if (objW == null) {
                                zA2 = true;
                            } else {
                                zA2 = kotlin.jvm.internal.k.a(objW, id.c.f10603e);
                            }
                            if (zA2) {
                                zA3 = true;
                            } else {
                                zA3 = kotlin.jvm.internal.k.a(objW, id.c.f10607i);
                            }
                            if (zA3) {
                                zA4 = true;
                            } else {
                                zA4 = kotlin.jvm.internal.k.a(objW, id.c.f10606h);
                            }
                            if (zA4) {
                                zA5 = true;
                            } else {
                                zA5 = kotlin.jvm.internal.k.a(objW, id.c.f10609k);
                            }
                            if (zA5) {
                                zA6 = true;
                            } else {
                                zA6 = kotlin.jvm.internal.k.a(objW, id.c.f10608j);
                            }
                            if (zA6) {
                                zA7 = true;
                            } else {
                                zA7 = kotlin.jvm.internal.k.a(objW, id.c.z());
                            }
                            if (!zA7) {
                                string = objW.toString();
                            }
                        }
                    }
                    if (objV != null) {
                        str = '(' + string + ',' + objV + "),";
                    } else {
                        str = string + ',';
                    }
                    sb2.append(str);
                }
                jVar = (j) jVar.e();
                if (jVar == null) {
                    break;
                }
                i10 = 0;
            }
            if (ed.v.q0(sb2) == ',') {
                kotlin.jvm.internal.k.d(sb2.deleteCharAt(sb2.length() - 1), "this.deleteCharAt(index)");
            }
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append(str2);
        sb2.append("capacity=" + this.f10587a + ',');
        sb2.append("data=[");
        i10 = 0;
        List listI2 = mc.o.i(f10583n.get(this), f10582m.get(this), f10584o.get(this));
        arrayList = new ArrayList();
        while (r2.hasNext()) {
            if (((j) obj) != id.c.f10599a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList.add(obj);
            }
        }
        it = arrayList.iterator();
        if (it.hasNext()) {
            throw new NoSuchElementException();
        }
        next = it.next();
        if (it.hasNext()) {
            j11 = ((j) next).f12721c;
            do {
                next2 = it.next();
                j12 = ((j) next2).f12721c;
                if (j11 > j12) {
                    next = next2;
                    j11 = j12;
                }
            } while (it.hasNext());
        }
        jVar = (j) next;
        jL = L();
        jN = N();
        loop2: while (true) {
            i11 = id.c.f10600b;
            while (i12 < i11) {
                j10 = (jVar.f12721c * ((long) id.c.f10600b)) + ((long) i12);
                if (j10 < jN) {
                }
                objW = jVar.w(i12);
                objV = jVar.v(i12);
                if (objW instanceof gd.o) {
                    if (j10 >= jL) {
                        if (j10 < jN) {
                            string = "cont";
                        } else {
                            string = "cont";
                        }
                    } else if (j10 < jN) {
                        string = "cont";
                    } else {
                        string = "cont";
                    }
                } else if (objW instanceof od.f) {
                    if (j10 >= jL) {
                        if (j10 < jN) {
                            string = "select";
                        } else {
                            string = "select";
                        }
                    } else if (j10 < jN) {
                        string = "select";
                    } else {
                        string = "select";
                    }
                } else if (objW instanceof s) {
                    string = "receiveCatching";
                } else if (objW instanceof C0177b) {
                    string = "sendBroadcast";
                } else if (objW instanceof v) {
                    string = "EB(" + objW + ')';
                } else {
                    if (kotlin.jvm.internal.k.a(objW, id.c.f10604f)) {
                        zA = true;
                    } else {
                        zA = kotlin.jvm.internal.k.a(objW, id.c.f10605g);
                    }
                    if (zA) {
                        string = "resuming_sender";
                    } else {
                        if (objW == null) {
                            zA2 = true;
                        } else {
                            zA2 = kotlin.jvm.internal.k.a(objW, id.c.f10603e);
                        }
                        if (zA2) {
                            zA3 = true;
                        } else {
                            zA3 = kotlin.jvm.internal.k.a(objW, id.c.f10607i);
                        }
                        if (zA3) {
                            zA4 = true;
                        } else {
                            zA4 = kotlin.jvm.internal.k.a(objW, id.c.f10606h);
                        }
                        if (zA4) {
                            zA5 = true;
                        } else {
                            zA5 = kotlin.jvm.internal.k.a(objW, id.c.f10609k);
                        }
                        if (zA5) {
                            zA6 = true;
                        } else {
                            zA6 = kotlin.jvm.internal.k.a(objW, id.c.f10608j);
                        }
                        if (zA6) {
                            zA7 = true;
                        } else {
                            zA7 = kotlin.jvm.internal.k.a(objW, id.c.z());
                        }
                        if (!zA7) {
                            string = objW.toString();
                        }
                    }
                }
                if (objV != null) {
                    str = '(' + string + ',' + objV + "),";
                } else {
                    str = string + ',';
                }
                sb2.append(str);
            }
            jVar = (j) jVar.e();
            if (jVar == null) {
                break;
                break;
            }
            i10 = 0;
        }
        if (ed.v.q0(sb2) == ',') {
            kotlin.jvm.internal.k.d(sb2.deleteCharAt(sb2.length() - 1), "this.deleteCharAt(index)");
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean u0(long j10) {
        if (W(j10)) {
            return false;
        }
        return !v(j10 & 1152921504606846975L);
    }

    public final boolean v(long j10) {
        return j10 < I() || j10 < L() + ((long) this.f10587a);
    }

    public final boolean v0(Object obj, E e10) {
        if (obj instanceof od.f) {
            return ((od.f) obj).c(this, e10);
        }
        if (obj instanceof s) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            s sVar = (s) obj;
            gd.p<h<? extends E>> pVar = sVar.f10638a;
            h hVarB = h.b(h.f10625b.c(e10));
            xc.l<E, lc.q> lVar = this.f10588b;
            return id.c.B(pVar, hVarB, lVar != null ? z.a(lVar, e10, sVar.f10638a.getContext()) : null);
        }
        if (obj instanceof a) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e10);
        }
        if (obj instanceof gd.o) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            gd.o oVar = (gd.o) obj;
            xc.l<E, lc.q> lVar2 = this.f10588b;
            return id.c.B(oVar, e10, lVar2 != null ? z.a(lVar2, e10, oVar.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public boolean w(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return z(th, true);
    }

    public final boolean w0(Object obj, j<E> jVar, int i10) {
        gd.o<Boolean> oVarA;
        Object obj2;
        if (obj instanceof gd.o) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            oVarA = (gd.o) obj;
            obj2 = lc.q.f12711a;
        } else {
            if (obj instanceof od.f) {
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                od.h hVarI = ((od.e) obj).i(this, lc.q.f12711a);
                if (hVarI == od.h.REREGISTER) {
                    jVar.s(i10);
                }
                return hVarI == od.h.SUCCESSFUL;
            }
            if (!(obj instanceof C0177b)) {
                throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
            }
            oVarA = ((C0177b) obj).a();
            obj2 = Boolean.TRUE;
        }
        return id.c.C(oVarA, obj2, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(j<E> jVar, long j10) {
        Object objB = ld.n.b(null, 1, null);
        loop0: while (jVar != null) {
            for (int i10 = id.c.f10600b - 1; -1 < i10; i10--) {
                if ((jVar.f12721c * ((long) id.c.f10600b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object objW = jVar.w(i10);
                    if (objW != null && objW != id.c.f10603e) {
                        if (!(objW instanceof v)) {
                            if (!(objW instanceof d3)) {
                                break;
                            }
                            if (jVar.r(i10, objW, id.c.z())) {
                                objB = ld.n.c(objB, objW);
                                jVar.x(i10, true);
                                break;
                                break;
                            }
                        } else {
                            if (jVar.r(i10, objW, id.c.z())) {
                                objW = ((v) objW).f10639a;
                                objB = ld.n.c(objB, objW);
                                jVar.x(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (jVar.r(i10, objW, id.c.z())) {
                            jVar.p();
                            break;
                        }
                    }
                }
            }
            jVar = (j) jVar.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                p0((d3) objB);
                return;
            }
            kotlin.jvm.internal.k.c(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                p0((d3) arrayList.get(size));
            }
        }
    }

    public final boolean x0(j<E> jVar, int i10, long j10) {
        Object objW = jVar.w(i10);
        if (!(objW instanceof d3) || j10 < f10579e.get(this) || !jVar.r(i10, objW, id.c.f10605g)) {
            return y0(jVar, i10, j10);
        }
        if (w0(objW, jVar, i10)) {
            jVar.A(i10, id.c.f10602d);
            return true;
        }
        jVar.A(i10, id.c.f10608j);
        jVar.x(i10, false);
        return false;
    }

    public final j<E> y() {
        Object obj = f10584o.get(this);
        j jVar = (j) f10582m.get(this);
        if (jVar.f12721c > ((j) obj).f12721c) {
            obj = jVar;
        }
        j jVar2 = (j) f10583n.get(this);
        if (jVar2.f12721c > ((j) obj).f12721c) {
            obj = jVar2;
        }
        return (j) ld.d.b((ld.e) obj);
    }

    public final boolean y0(j<E> jVar, int i10, long j10) {
        while (true) {
            Object objW = jVar.w(i10);
            if (objW instanceof d3) {
                if (j10 < f10579e.get(this)) {
                    if (jVar.r(i10, objW, new v((d3) objW))) {
                        return true;
                    }
                } else if (jVar.r(i10, objW, id.c.f10605g)) {
                    if (w0(objW, jVar, i10)) {
                        jVar.A(i10, id.c.f10602d);
                        return true;
                    }
                    jVar.A(i10, id.c.f10608j);
                    jVar.x(i10, false);
                    return false;
                }
            } else {
                if (objW == id.c.f10608j) {
                    return false;
                }
                if (objW == null) {
                    if (jVar.r(i10, objW, id.c.f10603e)) {
                        return true;
                    }
                } else {
                    if (objW == id.c.f10602d || objW == id.c.f10606h || objW == id.c.f10607i || objW == id.c.f10609k || objW == id.c.z()) {
                        return true;
                    }
                    if (objW != id.c.f10604f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objW).toString());
                    }
                }
            }
        }
    }

    public boolean z(Throwable th, boolean z10) {
        if (z10) {
            a0();
        }
        boolean zA = u.b.a(f10585p, this, id.c.f10617s, th);
        if (z10) {
            b0();
        } else {
            c0();
        }
        C();
        e0();
        if (zA) {
            R();
        }
        return zA;
    }

    public final Object z0(j<E> jVar, int i10, long j10, Object obj) {
        Object objW = jVar.w(i10);
        if (objW == null) {
            if (j10 >= (f10578d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return id.c.f10612n;
                }
                if (jVar.r(i10, objW, obj)) {
                    E();
                    return id.c.f10611m;
                }
            }
        } else if (objW == id.c.f10602d && jVar.r(i10, objW, id.c.f10607i)) {
            E();
            return jVar.y(i10);
        }
        return A0(jVar, i10, j10, obj);
    }
}
