package ld;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class t<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12766a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_cur");
    private volatile Object _cur;

    public t(boolean z10) {
        this._cur = new u(8, z10);
    }

    public final boolean a(E e10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12766a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            int iA = uVar.a(e10);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                u.b.a(f12766a, this, uVar, uVar.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12766a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar.d()) {
                return;
            } else {
                u.b.a(f12766a, this, uVar, uVar.i());
            }
        }
    }

    public final int c() {
        return ((u) f12766a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12766a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) uVar.j();
            if (e10 != u.f12770h) {
                return e10;
            }
            u.b.a(f12766a, this, uVar, uVar.i());
        }
    }
}
