package nd;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f13592b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f13593c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f13594d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f13595e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<h> f13596a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return b(hVar);
        }
        h hVar2 = (h) f13592b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f13580b.b() == 1) {
            f13595e.incrementAndGet(this);
        }
        int i10 = f13593c.get(this) & 127;
        while (this.f13596a.get(i10) != null) {
            Thread.yield();
        }
        this.f13596a.lazySet(i10, hVar);
        f13593c.incrementAndGet(this);
        return null;
    }

    public final void c(h hVar) {
        if (hVar != null) {
            if (hVar.f13580b.b() == 1) {
                f13595e.decrementAndGet(this);
            }
        }
    }

    public final int d() {
        return f13593c.get(this) - f13594d.get(this);
    }

    public final int e() {
        return f13592b.get(this) != null ? d() + 1 : d();
    }

    public final void f(d dVar) {
        h hVar = (h) f13592b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h g() {
        h hVar = (h) f13592b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final h h() {
        return k(true);
    }

    public final h i() {
        h andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f13594d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f13593c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f13596a.getAndSet(i11, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(d dVar) {
        h hVarI = i();
        if (hVarI == null) {
            return false;
        }
        dVar.a(hVarI);
        return true;
    }

    public final h k(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f13592b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.f13580b.b() == 1) == z10) {
                }
            }
            int i10 = f13594d.get(this);
            int i11 = f13593c.get(this);
            while (i10 != i11) {
                if (z10 && f13595e.get(this) == 0) {
                    return null;
                }
                i11--;
                h hVarM = m(i11, z10);
                if (hVarM != null) {
                    return hVarM;
                }
            }
            return null;
        } while (!u.b.a(atomicReferenceFieldUpdater, this, hVar, null));
        return hVar;
    }

    public final h l(int i10) {
        int i11 = f13594d.get(this);
        int i12 = f13593c.get(this);
        boolean z10 = i10 == 1;
        while (i11 != i12) {
            if (z10 && f13595e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            h hVarM = m(i11, z10);
            if (hVarM != null) {
                return hVarM;
            }
            i11 = i13;
        }
        return null;
    }

    public final h m(int i10, boolean z10) {
        int i11 = i10 & 127;
        h hVar = this.f13596a.get(i11);
        if (hVar != null) {
            if ((hVar.f13580b.b() == 1) == z10 && id.i.a(this.f13596a, i11, hVar, null)) {
                if (z10) {
                    f13595e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int i10, t<h> tVar) {
        T tI = i10 == 3 ? i() : l(i10);
        if (tI == 0) {
            return o(i10, tVar);
        }
        tVar.f12381a = tI;
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, nd.h] */
    public final long o(int i10, t<h> tVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r10;
        do {
            atomicReferenceFieldUpdater = f13592b;
            r10 = (h) atomicReferenceFieldUpdater.get(this);
            if (r10 == 0) {
                return -2L;
            }
            if (((r10.f13580b.b() == 1 ? 1 : 2) & i10) == 0) {
                return -2L;
            }
            long jA = l.f13588f.a() - r10.f13579a;
            long j10 = l.f13584b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!u.b.a(atomicReferenceFieldUpdater, this, r10, null));
        tVar.f12381a = r10;
        return -1L;
    }
}
