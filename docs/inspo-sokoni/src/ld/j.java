package ld;

import gd.i1;
import gd.w2;
import gd.z0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends z0<T> implements qc.e, oc.e<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12729m = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gd.j0 f12730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oc.e<T> f12731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f12732f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f12733l;

    /* JADX WARN: Multi-variable type inference failed */
    public j(gd.j0 j0Var, oc.e<? super T> eVar) {
        super(-1);
        this.f12730d = j0Var;
        this.f12731e = eVar;
        this.f12732f = k.f12735a;
        this.f12733l = l0.b(getContext());
    }

    @Override // gd.z0
    public void a(Object obj, Throwable th) {
        if (obj instanceof gd.d0) {
            ((gd.d0) obj).f9151b.invoke(th);
        }
    }

    @Override // gd.z0
    public oc.e<T> d() {
        return this;
    }

    @Override // qc.e
    public qc.e getCallerFrame() {
        oc.e<T> eVar = this.f12731e;
        if (eVar instanceof qc.e) {
            return (qc.e) eVar;
        }
        return null;
    }

    @Override // oc.e
    public oc.i getContext() {
        return this.f12731e.getContext();
    }

    @Override // gd.z0
    public Object l() {
        Object obj = this.f12732f;
        this.f12732f = k.f12735a;
        return obj;
    }

    public final void m() {
        while (f12729m.get(this) == k.f12736b) {
        }
    }

    public final gd.p<T> o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12729m;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f12729m.set(this, k.f12736b);
                return null;
            }
            if (obj instanceof gd.p) {
                if (u.b.a(f12729m, this, obj, k.f12736b)) {
                    return (gd.p) obj;
                }
            } else if (obj != k.f12736b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final gd.p<?> p() {
        Object obj = f12729m.get(this);
        if (obj instanceof gd.p) {
            return (gd.p) obj;
        }
        return null;
    }

    public final boolean q() {
        return f12729m.get(this) != null;
    }

    public final boolean r(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12729m;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0 h0Var = k.f12736b;
            if (kotlin.jvm.internal.k.a(obj, h0Var)) {
                if (u.b.a(f12729m, this, h0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (u.b.a(f12729m, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // oc.e
    public void resumeWith(Object obj) {
        oc.i context = this.f12731e.getContext();
        Object objD = gd.g0.d(obj, null, 1, null);
        if (this.f12730d.d0(context)) {
            this.f12732f = objD;
            this.f9276c = 0;
            this.f12730d.c0(context, this);
            return;
        }
        i1 i1VarB = w2.f9268a.b();
        if (i1VarB.m0()) {
            this.f12732f = objD;
            this.f9276c = 0;
            i1VarB.i0(this);
            return;
        }
        i1VarB.k0(true);
        try {
            oc.i context2 = getContext();
            Object objC = l0.c(context2, this.f12733l);
            try {
                this.f12731e.resumeWith(obj);
                lc.q qVar = lc.q.f12711a;
                l0.a(context2, objC);
                while (i1VarB.p0()) {
                }
            } catch (Throwable th) {
                l0.a(context2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                j(th2, null);
            } finally {
                i1VarB.f0(true);
            }
        }
    }

    public final void s() {
        m();
        gd.p<?> pVarP = p();
        if (pVarP != null) {
            pVarP.t();
        }
    }

    public final Throwable t(gd.o<?> oVar) {
        h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12729m;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0Var = k.f12736b;
            if (obj != h0Var) {
                if (obj instanceof Throwable) {
                    if (u.b.a(f12729m, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!u.b.a(f12729m, this, h0Var, oVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f12730d + ", " + gd.q0.c(this.f12731e) + ']';
    }
}
