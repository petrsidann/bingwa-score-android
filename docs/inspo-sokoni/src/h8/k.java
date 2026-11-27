package h8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable<k> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<k> f9743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s7.e<k> f9744c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f9745a;

    static {
        Comparator<k> comparator = new Comparator() { // from class: h8.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((k) obj).compareTo((k) obj2);
            }
        };
        f9743b = comparator;
        f9744c = new s7.e<>(Collections.emptyList(), comparator);
    }

    public k(t tVar) {
        l8.b.d(u(tVar), "Not a document key path: %s", tVar);
        this.f9745a = tVar;
    }

    public static Comparator<k> d() {
        return f9743b;
    }

    public static k i() {
        return o(Collections.emptyList());
    }

    public static s7.e<k> k() {
        return f9744c;
    }

    public static k l(String str) {
        t tVarZ = t.z(str);
        l8.b.d(tVarZ.u() > 4 && tVarZ.q(0).equals("projects") && tVarZ.q(2).equals("databases") && tVarZ.q(4).equals("documents"), "Tried to parse an invalid key: %s", tVarZ);
        return n(tVarZ.v(5));
    }

    public static k n(t tVar) {
        return new k(tVar);
    }

    public static k o(List<String> list) {
        return new k(t.y(list));
    }

    public static boolean u(t tVar) {
        return tVar.u() % 2 == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return this.f9745a.equals(((k) obj).f9745a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f9745a.compareTo(kVar.f9745a);
    }

    public int hashCode() {
        return this.f9745a.hashCode();
    }

    public String p() {
        t tVar = this.f9745a;
        return tVar.q(tVar.u() - 2);
    }

    public t q() {
        return this.f9745a.w();
    }

    public String r() {
        return this.f9745a.p();
    }

    public t s() {
        return this.f9745a;
    }

    public boolean t(String str) {
        if (this.f9745a.u() >= 2) {
            t tVar = this.f9745a;
            if (tVar.f9737a.get(tVar.u() - 2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f9745a.toString();
    }
}
