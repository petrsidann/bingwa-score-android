package gd;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class p<T> extends z0<T> implements o<T>, qc.e, d3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9244f = AtomicIntegerFieldUpdater.newUpdater(p.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9245l = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9246m = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oc.e<T> f9247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oc.i f9248e;

    /* JADX WARN: Multi-variable type inference failed */
    public p(oc.e<? super T> eVar, int i10) {
        super(i10);
        this.f9247d = eVar;
        this.f9248e = eVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f9149a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void M(p pVar, Object obj, int i10, xc.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        pVar.L(obj, i10, lVar);
    }

    public final String A() {
        Object objZ = z();
        if (objZ instanceof n2) {
            return "Active";
        }
        return objZ instanceof s ? "Cancelled" : "Completed";
    }

    public void B() {
        e1 e1VarC = C();
        if (e1VarC != null && isCompleted()) {
            e1VarC.d();
            f9246m.set(this, m2.f9235a);
        }
    }

    public final e1 C() {
        y1 y1Var = (y1) getContext().get(y1.f9273i);
        if (y1Var == null) {
            return null;
        }
        e1 e1VarE = y1.a.e(y1Var, true, false, new t(this), 2, null);
        u.b.a(f9246m, this, null, e1VarE);
        return e1VarE;
    }

    public final void D(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof m ? true : obj2 instanceof ld.e0) {
                    G(obj, obj2);
                } else {
                    boolean z10 = obj2 instanceof c0;
                    if (z10) {
                        c0 c0Var = (c0) obj2;
                        if (!c0Var.b()) {
                            G(obj, obj2);
                        }
                        if (obj2 instanceof s) {
                            if (!z10) {
                                c0Var = null;
                            }
                            Throwable th = c0Var != null ? c0Var.f9143a : null;
                            if (obj instanceof m) {
                                o((m) obj, th);
                                return;
                            } else {
                                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                q((ld.e0) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof b0) {
                        b0 b0Var = (b0) obj2;
                        if (b0Var.f9135b != null) {
                            G(obj, obj2);
                        }
                        if (obj instanceof ld.e0) {
                            return;
                        }
                        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        m mVar = (m) obj;
                        if (b0Var.c()) {
                            o(mVar, b0Var.f9138e);
                            return;
                        } else {
                            if (u.b.a(f9245l, this, obj2, b0.b(b0Var, null, mVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof ld.e0) {
                            return;
                        }
                        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (u.b.a(f9245l, this, obj2, new b0(obj2, (m) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (u.b.a(f9245l, this, obj2, obj)) {
                return;
            }
        }
    }

    public final boolean E() {
        if (a1.c(this.f9276c)) {
            oc.e<T> eVar = this.f9247d;
            kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((ld.j) eVar).q()) {
                return true;
            }
        }
        return false;
    }

    public final m F(xc.l<? super Throwable, lc.q> lVar) {
        return lVar instanceof m ? (m) lVar : new v1(lVar);
    }

    public final void G(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public String H() {
        return "CancellableContinuation";
    }

    public final void I(Throwable th) {
        if (s(th)) {
            return;
        }
        r(th);
        u();
    }

    public final void J() {
        Throwable thT;
        oc.e<T> eVar = this.f9247d;
        ld.j jVar = eVar instanceof ld.j ? (ld.j) eVar : null;
        if (jVar == null || (thT = jVar.t(this)) == null) {
            return;
        }
        t();
        r(thT);
    }

    public final boolean K() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof b0) && ((b0) obj).f9137d != null) {
            t();
            return false;
        }
        f9244f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f9149a);
        return true;
    }

    public final void L(Object obj, int i10, xc.l<? super Throwable, lc.q> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof n2)) {
                if (obj2 instanceof s) {
                    s sVar = (s) obj2;
                    if (sVar.c()) {
                        if (lVar != null) {
                            p(lVar, sVar.f9143a);
                            return;
                        }
                        return;
                    }
                }
                m(obj);
                throw new lc.c();
            }
        } while (!u.b.a(f9245l, this, obj2, N((n2) obj2, obj, i10, lVar, null)));
        u();
        v(i10);
    }

    public final Object N(n2 n2Var, Object obj, int i10, xc.l<? super Throwable, lc.q> lVar, Object obj2) {
        if (obj instanceof c0) {
            return obj;
        }
        if (!a1.b(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(n2Var instanceof m) && obj2 == null) {
            return obj;
        }
        return new b0(obj, n2Var instanceof m ? (m) n2Var : null, lVar, obj2, null, 16, null);
    }

    public final boolean O() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9244f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f9244f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    public final ld.h0 P(Object obj, Object obj2, xc.l<? super Throwable, lc.q> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof n2)) {
                if ((obj3 instanceof b0) && obj2 != null && ((b0) obj3).f9137d == obj2) {
                    return q.f9251a;
                }
                return null;
            }
        } while (!u.b.a(f9245l, this, obj3, N((n2) obj3, obj, this.f9276c, lVar, obj2)));
        u();
        return q.f9251a;
    }

    public final boolean Q() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9244f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f9244f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    @Override // gd.z0
    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof n2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof c0) {
                return;
            }
            if (obj2 instanceof b0) {
                b0 b0Var = (b0) obj2;
                if (!(!b0Var.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (u.b.a(f9245l, this, obj2, b0.b(b0Var, null, null, null, null, th, 15, null))) {
                    b0Var.d(this, th);
                    return;
                }
            } else if (u.b.a(f9245l, this, obj2, new b0(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // gd.d3
    public void b(ld.e0<?> e0Var, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9244f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!((i11 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        D(e0Var);
    }

    @Override // gd.o
    public void c(T t10, xc.l<? super Throwable, lc.q> lVar) {
        L(t10, this.f9276c, lVar);
    }

    @Override // gd.z0
    public final oc.e<T> d() {
        return this.f9247d;
    }

    @Override // gd.z0
    public Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.z0
    public <T> T f(Object obj) {
        return obj instanceof b0 ? (T) ((b0) obj).f9134a : obj;
    }

    @Override // gd.o
    public void g(xc.l<? super Throwable, lc.q> lVar) {
        D(F(lVar));
    }

    @Override // qc.e
    public qc.e getCallerFrame() {
        oc.e<T> eVar = this.f9247d;
        if (eVar instanceof qc.e) {
            return (qc.e) eVar;
        }
        return null;
    }

    @Override // oc.e
    public oc.i getContext() {
        return this.f9248e;
    }

    @Override // gd.o
    public Object h(Throwable th) {
        return P(new c0(th, false, 2, null), null, null);
    }

    @Override // gd.o
    public void i(j0 j0Var, T t10) {
        oc.e<T> eVar = this.f9247d;
        ld.j jVar = eVar instanceof ld.j ? (ld.j) eVar : null;
        M(this, t10, (jVar != null ? jVar.f12730d : null) == j0Var ? 4 : this.f9276c, null, 4, null);
    }

    @Override // gd.o
    public boolean isCompleted() {
        return !(z() instanceof n2);
    }

    @Override // gd.o
    public Object k(T t10, Object obj, xc.l<? super Throwable, lc.q> lVar) {
        return P(t10, obj, lVar);
    }

    @Override // gd.z0
    public Object l() {
        return z();
    }

    public final Void m(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    @Override // gd.o
    public void n(Object obj) {
        v(this.f9276c);
    }

    public final void o(m mVar, Throwable th) {
        try {
            mVar.g(th);
        } catch (Throwable th2) {
            l0.a(getContext(), new f0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void p(xc.l<? super Throwable, lc.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            l0.a(getContext(), new f0("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void q(ld.e0<?> e0Var, Throwable th) {
        int i10 = f9244f.get(this) & 536870911;
        if (!(i10 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            e0Var.o(i10, th, getContext());
        } catch (Throwable th2) {
            l0.a(getContext(), new f0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public boolean r(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9245l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof n2)) {
                return false;
            }
        } while (!u.b.a(f9245l, this, obj, new s(this, th, (obj instanceof m) || (obj instanceof ld.e0))));
        n2 n2Var = (n2) obj;
        if (n2Var instanceof m) {
            o((m) obj, th);
        } else if (n2Var instanceof ld.e0) {
            q((ld.e0) obj, th);
        }
        u();
        v(this.f9276c);
        return true;
    }

    @Override // oc.e
    public void resumeWith(Object obj) {
        M(this, g0.b(obj, this), this.f9276c, null, 4, null);
    }

    public final boolean s(Throwable th) {
        if (!E()) {
            return false;
        }
        oc.e<T> eVar = this.f9247d;
        kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((ld.j) eVar).r(th);
    }

    public final void t() {
        e1 e1VarX = x();
        if (e1VarX == null) {
            return;
        }
        e1VarX.d();
        f9246m.set(this, m2.f9235a);
    }

    public String toString() {
        return H() + '(' + q0.c(this.f9247d) + "){" + A() + "}@" + q0.b(this);
    }

    public final void u() {
        if (E()) {
            return;
        }
        t();
    }

    public final void v(int i10) {
        if (O()) {
            return;
        }
        a1.a(this, i10);
    }

    public Throwable w(y1 y1Var) {
        return y1Var.getCancellationException();
    }

    public final e1 x() {
        return (e1) f9246m.get(this);
    }

    public final Object y() {
        y1 y1Var;
        boolean zE = E();
        if (Q()) {
            if (x() == null) {
                C();
            }
            if (zE) {
                J();
            }
            return pc.c.c();
        }
        if (zE) {
            J();
        }
        Object objZ = z();
        if (objZ instanceof c0) {
            throw ((c0) objZ).f9143a;
        }
        if (!a1.b(this.f9276c) || (y1Var = (y1) getContext().get(y1.f9273i)) == null || y1Var.isActive()) {
            return f(objZ);
        }
        CancellationException cancellationException = y1Var.getCancellationException();
        a(objZ, cancellationException);
        throw cancellationException;
    }

    public final Object z() {
        return f9245l.get(this);
    }
}
