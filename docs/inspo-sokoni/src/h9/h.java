package h9;

import e9.p;
import e9.s;
import e9.x;
import e9.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.c f9825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9826b;

    public final class a<K, V> extends x<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x<K> f9827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x<V> f9828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g9.i<? extends Map<K, V>> f9829c;

        public a(e9.e eVar, Type type, x<K> xVar, Type type2, x<V> xVar2, g9.i<? extends Map<K, V>> iVar) {
            this.f9827a = new n(eVar, xVar, type);
            this.f9828b = new n(eVar, xVar2, type2);
            this.f9829c = iVar;
        }

        public final String f(e9.k kVar) {
            if (!kVar.q()) {
                if (kVar.n()) {
                    return "null";
                }
                throw new AssertionError();
            }
            p pVarJ = kVar.j();
            if (pVarJ.y()) {
                return String.valueOf(pVarJ.v());
            }
            if (pVarJ.w()) {
                return Boolean.toString(pVarJ.e());
            }
            if (pVarJ.z()) {
                return pVarJ.k();
            }
            throw new AssertionError();
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<K, V> c(m9.a aVar) throws IOException {
            m9.b bVarL0 = aVar.l0();
            if (bVarL0 == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            Map<K, V> mapA = this.f9829c.a();
            if (bVarL0 == m9.b.BEGIN_ARRAY) {
                aVar.d();
                while (aVar.I()) {
                    aVar.d();
                    K kC = this.f9827a.c(aVar);
                    if (mapA.put(kC, this.f9828b.c(aVar)) != null) {
                        throw new s("duplicate key: " + kC);
                    }
                    aVar.z();
                }
                aVar.z();
            } else {
                aVar.e();
                while (aVar.I()) {
                    g9.f.f9073a.a(aVar);
                    K kC2 = this.f9827a.c(aVar);
                    if (mapA.put(kC2, this.f9828b.c(aVar)) != null) {
                        throw new s("duplicate key: " + kC2);
                    }
                }
                aVar.B();
            }
            return mapA;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.L();
                return;
            }
            if (!h.this.f9826b) {
                cVar.t();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.I(String.valueOf(entry.getKey()));
                    this.f9828b.e(cVar, entry.getValue());
                }
                cVar.B();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                e9.k kVarD = this.f9827a.d(entry2.getKey());
                arrayList.add(kVarD);
                arrayList2.add(entry2.getValue());
                z10 |= kVarD.l() || kVarD.o();
            }
            if (!z10) {
                cVar.t();
                int size = arrayList.size();
                while (i10 < size) {
                    cVar.I(f((e9.k) arrayList.get(i10)));
                    this.f9828b.e(cVar, (V) arrayList2.get(i10));
                    i10++;
                }
                cVar.B();
                return;
            }
            cVar.k();
            int size2 = arrayList.size();
            while (i10 < size2) {
                cVar.k();
                g9.m.b((e9.k) arrayList.get(i10), cVar);
                this.f9828b.e(cVar, (V) arrayList2.get(i10));
                cVar.z();
                i10++;
            }
            cVar.z();
        }
    }

    public h(g9.c cVar, boolean z10) {
        this.f9825a = cVar;
        this.f9826b = z10;
    }

    public final x<?> a(e9.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.f9887f : eVar.l(l9.a.b(type));
    }

    @Override // e9.y
    public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = g9.b.j(typeD, clsC);
        return new a(eVar, typeArrJ[0], a(eVar, typeArrJ[0]), typeArrJ[1], eVar.l(l9.a.b(typeArrJ[1])), this.f9825a.b(aVar));
    }
}
