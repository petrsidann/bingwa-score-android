package pd;

import gd.d3;
import gd.j0;
import gd.o;
import gd.p;
import gd.q0;
import gd.r;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ld.e0;
import oc.i;
import qc.h;
import xc.l;
import xc.q;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d implements pd.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14538i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q<od.f<?>, Object, Object, l<Throwable, lc.q>> f14539h;
    private volatile Object owner;

    public final class a implements o<lc.q>, d3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p<lc.q> f14540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f14541b;

        /* JADX INFO: renamed from: pd.b$a$a, reason: collision with other inner class name */
        public static final class C0253a extends kotlin.jvm.internal.l implements l<Throwable, lc.q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f14543a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f14544b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0253a(b bVar, a aVar) {
                super(1);
                this.f14543a = bVar;
                this.f14544b = aVar;
            }

            public final void a(Throwable th) {
                this.f14543a.a(this.f14544b.f14541b);
            }

            @Override // xc.l
            public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
                a(th);
                return lc.q.f12711a;
            }
        }

        /* JADX INFO: renamed from: pd.b$a$b, reason: collision with other inner class name */
        public static final class C0254b extends kotlin.jvm.internal.l implements l<Throwable, lc.q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f14545a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f14546b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0254b(b bVar, a aVar) {
                super(1);
                this.f14545a = bVar;
                this.f14546b = aVar;
            }

            public final void a(Throwable th) {
                b.f14538i.set(this.f14545a, this.f14546b.f14541b);
                this.f14545a.a(this.f14546b.f14541b);
            }

            @Override // xc.l
            public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
                a(th);
                return lc.q.f12711a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(p<? super lc.q> pVar, Object obj) {
            this.f14540a = pVar;
            this.f14541b = obj;
        }

        @Override // gd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void c(lc.q qVar, l<? super Throwable, lc.q> lVar) {
            b.f14538i.set(b.this, this.f14541b);
            this.f14540a.c(qVar, new C0253a(b.this, this));
        }

        @Override // gd.d3
        public void b(e0<?> e0Var, int i10) {
            this.f14540a.b(e0Var, i10);
        }

        @Override // gd.o
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void i(j0 j0Var, lc.q qVar) {
            this.f14540a.i(j0Var, qVar);
        }

        @Override // gd.o
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object k(lc.q qVar, Object obj, l<? super Throwable, lc.q> lVar) {
            Object objK = this.f14540a.k(qVar, obj, new C0254b(b.this, this));
            if (objK != null) {
                b.f14538i.set(b.this, this.f14541b);
            }
            return objK;
        }

        @Override // gd.o
        public void g(l<? super Throwable, lc.q> lVar) {
            this.f14540a.g(lVar);
        }

        @Override // oc.e
        public i getContext() {
            return this.f14540a.getContext();
        }

        @Override // gd.o
        public Object h(Throwable th) {
            return this.f14540a.h(th);
        }

        @Override // gd.o
        public boolean isCompleted() {
            return this.f14540a.isCompleted();
        }

        @Override // gd.o
        public void n(Object obj) {
            this.f14540a.n(obj);
        }

        @Override // oc.e
        public void resumeWith(Object obj) {
            this.f14540a.resumeWith(obj);
        }
    }

    /* JADX INFO: renamed from: pd.b$b, reason: collision with other inner class name */
    public static final class C0255b extends kotlin.jvm.internal.l implements q<od.f<?>, Object, Object, l<? super Throwable, ? extends lc.q>> {

        /* JADX INFO: renamed from: pd.b$b$a */
        public static final class a extends kotlin.jvm.internal.l implements l<Throwable, lc.q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f14548a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f14549b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Object obj) {
                super(1);
                this.f14548a = bVar;
                this.f14549b = obj;
            }

            public final void a(Throwable th) {
                this.f14548a.a(this.f14549b);
            }

            @Override // xc.l
            public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
                a(th);
                return lc.q.f12711a;
            }
        }

        public C0255b() {
            super(3);
        }

        @Override // xc.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l<Throwable, lc.q> e(od.f<?> fVar, Object obj, Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : c.f14550a;
        this.f14539h = new C0255b();
    }

    public static /* synthetic */ Object o(b bVar, Object obj, oc.e<? super lc.q> eVar) {
        Object objP;
        return (!bVar.q(obj) && (objP = bVar.p(obj, eVar)) == pc.c.c()) ? objP : lc.q.f12711a;
    }

    @Override // pd.a
    public void a(Object obj) {
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14538i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != c.f14550a) {
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (u.b.a(atomicReferenceFieldUpdater, this, obj2, c.f14550a)) {
                    h();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Override // pd.a
    public Object b(Object obj, oc.e<? super lc.q> eVar) {
        return o(this, obj, eVar);
    }

    public final int m(Object obj) {
        while (n()) {
            Object obj2 = f14538i.get(this);
            if (obj2 != c.f14550a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public boolean n() {
        return g() == 0;
    }

    public final Object p(Object obj, oc.e<? super lc.q> eVar) {
        p pVarB = r.b(pc.b.b(eVar));
        try {
            c(new a(pVarB, obj));
            Object objY = pVarB.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY == pc.c.c() ? objY : lc.q.f12711a;
        } catch (Throwable th) {
            pVarB.J();
            throw th;
        }
    }

    public boolean q(Object obj) {
        int iR = r(obj);
        if (iR == 0) {
            return true;
        }
        if (iR == 1) {
            return false;
        }
        if (iR != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public final int r(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            int iM = m(obj);
            if (iM == 1) {
                return 2;
            }
            if (iM == 2) {
                return 1;
            }
        }
        f14538i.set(this, obj);
        return 0;
    }

    public String toString() {
        return "Mutex@" + q0.b(this) + "[isLocked=" + n() + ",owner=" + f14538i.get(this) + ']';
    }
}
