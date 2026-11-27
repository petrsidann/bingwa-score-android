package id;

import gd.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class q<E> extends e<E> implements r<E> {
    public q(oc.i iVar, d<E> dVar) {
        super(iVar, dVar, true, true);
    }

    @Override // gd.a
    public void N0(Throwable th, boolean z10) {
        if (Q0().e(th) || z10) {
            return;
        }
        l0.a(getContext(), th);
    }

    @Override // gd.a
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public void O0(lc.q qVar) {
        u.a.a(Q0(), null, 1, null);
    }

    @Override // gd.a, gd.g2, gd.y1
    public boolean isActive() {
        return super.isActive();
    }
}
