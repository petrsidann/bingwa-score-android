package g8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s7.c<h8.k, h8.h> f8687a = h8.i.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f8688b;

    public class b implements Iterable<h8.h> {

        public class a implements Iterator<h8.h> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f8690a;

            public a(Iterator it) {
                this.f8690a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h8.h next() {
                return (h8.h) ((Map.Entry) this.f8690a.next()).getValue();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f8690a.hasNext();
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator<h8.h> iterator() {
            return new a(c1.this.f8687a.iterator());
        }
    }

    @Override // g8.o1
    public h8.r a(h8.k kVar) {
        h8.h hVarH = this.f8687a.h(kVar);
        return hVarH != null ? hVarH.b() : h8.r.s(kVar);
    }

    @Override // g8.o1
    public void b(m mVar) {
        this.f8688b = mVar;
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> c(e8.b1 b1Var, h8.p.a aVar, Set<h8.k> set, i1 i1Var) {
        HashMap map = new HashMap();
        Iterator<Map.Entry<h8.k, h8.h>> itN = this.f8687a.n(h8.k.n(b1Var.n().h("")));
        while (itN.hasNext()) {
            Map.Entry<h8.k, h8.h> next = itN.next();
            h8.h value = next.getValue();
            h8.k key = next.getKey();
            if (!b1Var.n().t(key.s())) {
                break;
            }
            if (key.s().u() <= b1Var.n().u() + 1 && h8.p.a.l(value).compareTo(aVar) > 0 && (set.contains(value.getKey()) || b1Var.u(value))) {
                map.put(value.getKey(), value.b());
            }
        }
        return map;
    }

    @Override // g8.o1
    public void d(h8.r rVar, h8.v vVar) {
        l8.b.d(this.f8688b != null, "setIndexManager() not called", new Object[0]);
        l8.b.d(!vVar.equals(h8.v.f9777b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.f8687a = this.f8687a.l(rVar.getKey(), rVar.b().x(vVar));
        this.f8688b.a(rVar.getKey().q());
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> e(Iterable<h8.k> iterable) {
        HashMap map = new HashMap();
        for (h8.k kVar : iterable) {
            map.put(kVar, a(kVar));
        }
        return map;
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> f(String str, h8.p.a aVar, int i10) {
        throw new UnsupportedOperationException("getAll(String, IndexOffset, int) is not supported.");
    }

    public long h(p pVar) {
        Iterator<h8.h> it = new b().iterator();
        long jD = 0;
        while (it.hasNext()) {
            jD += (long) pVar.m(it.next()).d();
        }
        return jD;
    }

    public Iterable<h8.h> i() {
        return new b();
    }

    @Override // g8.o1
    public void removeAll(Collection<h8.k> collection) {
        l8.b.d(this.f8688b != null, "setIndexManager() not called", new Object[0]);
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        for (h8.k kVar : collection) {
            this.f8687a = this.f8687a.o(kVar);
            cVarA = cVarA.l(kVar, h8.r.t(kVar, h8.v.f9777b));
        }
        this.f8688b.e(cVarA);
    }
}
