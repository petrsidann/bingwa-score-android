package od;

import gd.d3;
import gd.e1;
import gd.m;
import gd.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import ld.e0;
import mc.n;
import mc.w;
import oc.i;
import xc.l;
import xc.q;

/* JADX INFO: loaded from: classes2.dex */
public class e<R> extends m implements f, d3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f13821f = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f13822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<e<R>.a> f13823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f13824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f13826e;
    private volatile Object state;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f13827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f13828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q<f<?>, Object, Object, l<Throwable, lc.q>> f13829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f13830d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13831e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e<R> f13832f;

        public final l<Throwable, lc.q> a(f<?> fVar, Object obj) {
            q<f<?>, Object, Object, l<Throwable, lc.q>> qVar = this.f13829c;
            if (qVar != null) {
                return qVar.e(fVar, this.f13828b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f13830d;
            e<R> eVar = this.f13832f;
            if (obj instanceof e0) {
                ((e0) obj).o(this.f13831e, null, eVar.getContext());
                return;
            }
            e1 e1Var = obj instanceof e1 ? (e1) obj : null;
            if (e1Var != null) {
                e1Var.d();
            }
        }
    }

    @Override // od.f
    public void a(e1 e1Var) {
        this.f13824c = e1Var;
    }

    @Override // gd.d3
    public void b(e0<?> e0Var, int i10) {
        this.f13824c = e0Var;
        this.f13825d = i10;
    }

    @Override // od.f
    public boolean c(Object obj, Object obj2) {
        return j(obj, obj2) == 0;
    }

    @Override // od.f
    public void d(Object obj) {
        this.f13826e = obj;
    }

    @Override // gd.n
    public void g(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13821f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == g.f13835c) {
                return;
            }
        } while (!u.b.a(atomicReferenceFieldUpdater, this, obj, g.f13836d));
        List<e<R>.a> list = this.f13823b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.f13826e = g.f13837e;
        this.f13823b = null;
    }

    @Override // od.f
    public i getContext() {
        return this.f13822a;
    }

    public final e<R>.a h(Object obj) {
        List<e<R>.a> list = this.f13823b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        for (Object obj3 : list) {
            if (((a) obj3).f13827a == obj) {
                obj2 = obj3;
                break;
            }
        }
        e<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final h i(Object obj, Object obj2) {
        return g.a(j(obj, obj2));
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        g(th);
        return lc.q.f12711a;
    }

    public final int j(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13821f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof o) {
                e<R>.a aVarH = h(obj);
                if (aVarH == null) {
                    continue;
                } else {
                    l<Throwable, lc.q> lVarA = aVarH.a(this, obj2);
                    if (u.b.a(atomicReferenceFieldUpdater, this, obj3, aVarH)) {
                        this.f13826e = obj2;
                        if (g.i((o) obj3, lVarA)) {
                            return 0;
                        }
                        this.f13826e = null;
                        return 2;
                    }
                }
            } else {
                if (k.a(obj3, g.f13835c) ? true : obj3 instanceof a) {
                    return 3;
                }
                if (k.a(obj3, g.f13836d)) {
                    return 2;
                }
                if (k.a(obj3, g.f13834b)) {
                    if (u.b.a(atomicReferenceFieldUpdater, this, obj3, n.b(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (u.b.a(atomicReferenceFieldUpdater, this, obj3, w.E((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }
}
