package gd;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class y0<T> extends ld.d0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9272e = AtomicIntegerFieldUpdater.newUpdater(y0.class, "_decision");
    private volatile int _decision;

    public y0(oc.i iVar, oc.e<? super T> eVar) {
        super(iVar, eVar);
    }

    @Override // ld.d0, gd.a
    public void M0(Object obj) {
        if (R0()) {
            return;
        }
        ld.k.c(pc.b.b(this.f12717d), g0.a(obj, this.f12717d), null, 2, null);
    }

    public final Object Q0() {
        if (S0()) {
            return pc.c.c();
        }
        Object objH = h2.h(d0());
        if (objH instanceof c0) {
            throw ((c0) objH).f9143a;
        }
        return objH;
    }

    public final boolean R0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9272e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f9272e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean S0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9272e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f9272e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // ld.d0, gd.g2
    public void x(Object obj) {
        M0(obj);
    }
}
