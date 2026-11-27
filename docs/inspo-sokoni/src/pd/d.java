package pd;

import gd.d3;
import gd.o;
import id.i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import lc.q;
import ld.e0;
import ld.f0;
import xc.l;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14552c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f14553d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14554e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f14555f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14556g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Throwable, q> f14558b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public /* synthetic */ class a extends j implements p<Long, f, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14559a = new a();

        public a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j10, f fVar) {
            return e.h(j10, fVar);
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ f invoke(Long l10, f fVar) {
            return d(l10.longValue(), fVar);
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements l<Throwable, q> {
        public b() {
            super(1);
        }

        public final void a(Throwable th) {
            d.this.h();
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(Throwable th) {
            a(th);
            return q.f12711a;
        }
    }

    public /* synthetic */ class c extends j implements p<Long, f, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14561a = new c();

        public c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j10, f fVar) {
            return e.h(j10, fVar);
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ f invoke(Long l10, f fVar) {
            return d(l10.longValue(), fVar);
        }
    }

    public d(int i10, int i11) {
        this.f14557a = i10;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
        }
        if (!(i11 >= 0 && i11 <= i10)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i10 - i11;
        this.f14558b = new b();
    }

    public final void c(o<? super q> oVar) {
        while (f() <= 0) {
            k.c(oVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((d3) oVar)) {
                return;
            }
        }
        oVar.c(q.f12711a, this.f14558b);
    }

    public final boolean d(d3 d3Var) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14554e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f14555f.getAndIncrement(this);
        a aVar = a.f14559a;
        long j10 = andIncrement / ((long) e.f14567f);
        do {
            objC = ld.d.c(fVar, j10, aVar);
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
        f fVar2 = (f) f0.b(objC);
        int i10 = (int) (andIncrement % ((long) e.f14567f));
        if (i.a(fVar2.r(), i10, null, d3Var)) {
            d3Var.b(fVar2, i10);
            return true;
        }
        if (!i.a(fVar2.r(), i10, e.f14563b, e.f14564c)) {
            return false;
        }
        if (d3Var instanceof o) {
            k.c(d3Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((o) d3Var).c(q.f12711a, this.f14558b);
            return true;
        }
        if (d3Var instanceof od.f) {
            ((od.f) d3Var).d(q.f12711a);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + d3Var).toString());
    }

    public final void e() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f14556g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.f14557a;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    public final int f() {
        int andDecrement;
        do {
            andDecrement = f14556g.getAndDecrement(this);
        } while (andDecrement > this.f14557a);
        return andDecrement;
    }

    public int g() {
        return Math.max(f14556g.get(this), 0);
    }

    public void h() {
        do {
            int andIncrement = f14556g.getAndIncrement(this);
            if (andIncrement >= this.f14557a) {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f14557a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!k());
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14556g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f14557a) {
                e();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean j(Object obj) {
        if (!(obj instanceof o)) {
            if (obj instanceof od.f) {
                return ((od.f) obj).c(this, q.f12711a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        o oVar = (o) obj;
        Object objK = oVar.k(q.f12711a, null, this.f14558b);
        if (objK == null) {
            return false;
        }
        oVar.n(objK);
        return true;
    }

    public final boolean k() {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14552c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f14553d.getAndIncrement(this);
        long j10 = andIncrement / ((long) e.f14567f);
        c cVar = c.f14561a;
        do {
            objC = ld.d.c(fVar, j10, cVar);
            if (f0.c(objC)) {
                break;
            }
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
        } while (!z10);
        f fVar2 = (f) f0.b(objC);
        fVar2.b();
        if (fVar2.f12721c > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) e.f14567f));
        Object andSet = fVar2.r().getAndSet(i10, e.f14563b);
        if (andSet != null) {
            if (andSet == e.f14566e) {
                return false;
            }
            return j(andSet);
        }
        int i11 = e.f14562a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (fVar2.r().get(i10) == e.f14564c) {
                return true;
            }
        }
        return !i.a(fVar2.r(), i10, e.f14563b, e.f14565d);
    }
}
