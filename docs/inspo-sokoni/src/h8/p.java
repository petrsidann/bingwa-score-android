package h8;

import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f9749a = b.a(0, a.f9751a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<p> f9750b = new Comparator() { // from class: h8.n
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p.i((p) obj, (p) obj2);
        }
    };

    @AutoValue
    public static abstract class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9751a = i(v.f9777b, k.i(), -1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Comparator<r> f9752b = new Comparator() { // from class: h8.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p.a.q((r) obj, (r) obj2);
            }
        };

        public static a i(v vVar, k kVar, int i10) {
            return new h8.b(vVar, kVar, i10);
        }

        public static a k(v vVar, int i10) {
            long jK = vVar.h().k();
            int iH = vVar.h().h() + 1;
            return i(new v(((double) iH) == 1.0E9d ? new h7.q(jK + 1, 0) : new h7.q(jK, iH)), k.i(), i10);
        }

        public static a l(h hVar) {
            return i(hVar.g(), hVar.getKey(), -1);
        }

        public static /* synthetic */ int q(r rVar, r rVar2) {
            return l(rVar).compareTo(l(rVar2));
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int iCompareTo = p().compareTo(aVar.p());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = n().compareTo(aVar.n());
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(o(), aVar.o());
        }

        public abstract k n();

        public abstract int o();

        public abstract v p();
    }

    @AutoValue
    public static abstract class b {
        public static b a(long j10, a aVar) {
            return new h8.c(j10, aVar);
        }

        public static b b(long j10, v vVar, k kVar, int i10) {
            return a(j10, a.i(vVar, kVar, i10));
        }

        public abstract a c();

        public abstract long d();
    }

    @AutoValue
    public static abstract class c implements Comparable<c> {

        public enum a {
            ASCENDING,
            DESCENDING,
            CONTAINS
        }

        public static c h(q qVar, a aVar) {
            return new d(qVar, aVar);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int iCompareTo = i().compareTo(cVar.i());
            return iCompareTo != 0 ? iCompareTo : k().compareTo(cVar.k());
        }

        public abstract q i();

        public abstract a k();
    }

    public static p b(int i10, String str, List<c> list, b bVar) {
        return new h8.a(i10, str, list, bVar);
    }

    public static /* synthetic */ int i(p pVar, p pVar2) {
        int iCompareTo = pVar.d().compareTo(pVar2.d());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Iterator<c> it = pVar.h().iterator();
        Iterator<c> it2 = pVar2.h().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo2 = it.next().compareTo(it2.next());
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        return Boolean.compare(it.hasNext(), it2.hasNext());
    }

    public c c() {
        for (c cVar : h()) {
            if (cVar.k().equals(c.a.CONTAINS)) {
                return cVar;
            }
        }
        return null;
    }

    public abstract String d();

    public List<c> e() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : h()) {
            if (!cVar.k().equals(c.a.CONTAINS)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public abstract int f();

    public abstract b g();

    public abstract List<c> h();
}
