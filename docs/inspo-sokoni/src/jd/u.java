package jd;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends kd.d<s<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f11392a = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_state");
    private volatile Object _state;

    @Override // kd.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(s<?> sVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11392a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, t.f11390a);
        return true;
    }

    public final Object e(oc.e<? super lc.q> eVar) {
        gd.p pVar = new gd.p(pc.b.b(eVar), 1);
        pVar.B();
        if (!u.b.a(f11392a, this, t.f11390a, pVar)) {
            lc.j.a aVar = lc.j.f12703b;
            pVar.resumeWith(lc.j.b(lc.q.f12711a));
        }
        Object objY = pVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY == pc.c.c() ? objY : lc.q.f12711a;
    }

    @Override // kd.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public oc.e<lc.q>[] b(s<?> sVar) {
        f11392a.set(this, null);
        return kd.c.f12322a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11392a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == t.f11391b) {
                return;
            }
            if (obj == t.f11390a) {
                if (u.b.a(f11392a, this, obj, t.f11391b)) {
                    return;
                }
            } else if (u.b.a(f11392a, this, obj, t.f11390a)) {
                lc.j.a aVar = lc.j.f12703b;
                ((gd.p) obj).resumeWith(lc.j.b(lc.q.f12711a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f11392a.getAndSet(this, t.f11390a);
        kotlin.jvm.internal.k.b(andSet);
        return andSet == t.f11391b;
    }
}
