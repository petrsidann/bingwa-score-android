package ld;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ld.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<N extends e<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12718a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12719b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public e(N n10) {
        this._prev = n10;
    }

    public final void b() {
        f12719b.lazySet(this, null);
    }

    public final N c() {
        N n10 = (N) g();
        while (n10 != null && n10.h()) {
            n10 = (N) f12719b.get(n10);
        }
        return n10;
    }

    public final N d() {
        e eVarE;
        N n10 = (N) e();
        kotlin.jvm.internal.k.b(n10);
        while (n10.h() && (eVarE = n10.e()) != null) {
            n10 = (N) eVarE;
        }
        return n10;
    }

    public final N e() {
        Object objF = f();
        if (objF == d.f12716a) {
            return null;
        }
        return (N) objF;
    }

    public final Object f() {
        return f12718a.get(this);
    }

    public final N g() {
        return (N) f12719b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return u.b.a(f12718a, this, null, d.f12716a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            e eVarC = c();
            e eVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12719b;
            do {
                obj = atomicReferenceFieldUpdater.get(eVarD);
            } while (!u.b.a(atomicReferenceFieldUpdater, eVarD, obj, ((e) obj) == null ? null : eVarC));
            if (eVarC != null) {
                f12718a.set(eVarC, eVarD);
            }
            if (!eVarD.h() || eVarD.i()) {
                if (eVarC == null || !eVarC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(N n10) {
        return u.b.a(f12718a, this, null, n10);
    }
}
