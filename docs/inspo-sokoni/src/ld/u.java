package ld;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class u<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12767e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12768f = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12769g = AtomicLongFieldUpdater.newUpdater(u.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h0 f12770h = new h0("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f12774d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | (((long) i10) << 0);
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (((long) i10) << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12775a;

        public b(int i10) {
            this.f12775a = i10;
        }
    }

    public u(int i10, boolean z10) {
        this.f12771a = i10;
        this.f12772b = z10;
        int i11 = i10 - 1;
        this.f12773c = i11;
        this.f12774d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final int a(E e10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12769g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j10) != 0) {
                return f12767e.a(j10);
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f12773c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            if (!this.f12772b && this.f12774d.get(i11 & i12) != null) {
                int i13 = this.f12771a;
                if (i13 < 1024 || ((i11 - i10) & 1073741823) > (i13 >> 1)) {
                    return 1;
                }
            } else if (f12769g.compareAndSet(this, j10, f12767e.c(j10, (i11 + 1) & 1073741823))) {
                this.f12774d.set(i11 & i12, e10);
                u<E> uVarE = this;
                while ((f12769g.get(uVarE) & 1152921504606846976L) != 0 && (uVarE = uVarE.i().e(i11, e10)) != null) {
                }
                return 0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<E> b(long j10) {
        u<E> uVar = new u<>(this.f12771a * 2, this.f12772b);
        int i10 = (int) ((1073741823 & j10) >> 0);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f12773c;
            if ((i10 & i12) == (i11 & i12)) {
                f12769g.set(uVar, f12767e.d(j10, 1152921504606846976L));
                return uVar;
            }
            Object bVar = this.f12774d.get(i12 & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            uVar.f12774d.set(uVar.f12773c & i10, bVar);
            i10++;
        }
    }

    public final u<E> c(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12768f;
        while (true) {
            u<E> uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar != null) {
                return uVar;
            }
            u.b.a(f12768f, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12769g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final u<E> e(int i10, E e10) {
        Object obj = this.f12774d.get(this.f12773c & i10);
        if (!(obj instanceof b) || ((b) obj).f12775a != i10) {
            return null;
        }
        this.f12774d.set(i10 & this.f12773c, e10);
        return this;
    }

    public final int f() {
        long j10 = f12769g.get(this);
        return (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j10 = f12769g.get(this);
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12769g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j11));
        return j11;
    }

    public final u<E> i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12769g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return f12770h;
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = this.f12773c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            Object obj = this.f12774d.get(i11 & i10);
            if (obj == null) {
                if (this.f12772b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                if (f12769g.compareAndSet(this, j10, f12767e.b(j10, i12))) {
                    this.f12774d.set(this.f12773c & i10, null);
                    return obj;
                }
                if (this.f12772b) {
                    u<E> uVarK = this;
                    do {
                        uVarK = uVarK.k(i10, i12);
                    } while (uVarK != null);
                    return obj;
                }
            }
        }
    }

    public final u<E> k(int i10, int i11) {
        long j10;
        int i12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12769g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            i12 = (int) ((1073741823 & j10) >> 0);
            if ((1152921504606846976L & j10) != 0) {
                return i();
            }
        } while (!f12769g.compareAndSet(this, j10, f12767e.b(j10, i11)));
        this.f12774d.set(this.f12773c & i12, null);
        return null;
    }
}
