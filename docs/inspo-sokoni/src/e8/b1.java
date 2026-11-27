package e8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a1 f7101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a1 f7102m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a1> f7103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<a1> f7104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g1 f7105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g1 f7106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<q> f7107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h8.t f7108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f7110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f7111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f7112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f7113k;

    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    public static class b implements Comparator<h8.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a1> f7117a;

        public b(List<a1> list) {
            boolean z10;
            Iterator<a1> it = list.iterator();
            loop0: while (true) {
                z10 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    } else {
                        z10 = (z10 || it.next().c().equals(h8.q.f9757b)) ? true : z10;
                    }
                }
            }
            if (!z10) {
                throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
            }
            this.f7117a = list;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h8.h hVar, h8.h hVar2) {
            Iterator<a1> it = this.f7117a.iterator();
            while (it.hasNext()) {
                int iA = it.next().a(hVar, hVar2);
                if (iA != 0) {
                    return iA;
                }
            }
            return 0;
        }
    }

    static {
        a1.a aVar = a1.a.ASCENDING;
        h8.q qVar = h8.q.f9757b;
        f7101l = a1.d(aVar, qVar);
        f7102m = a1.d(a1.a.DESCENDING, qVar);
    }

    public b1(h8.t tVar, String str) {
        this(tVar, str, Collections.emptyList(), Collections.emptyList(), -1L, a.LIMIT_TO_FIRST, null, null);
    }

    public b1(h8.t tVar, String str, List<q> list, List<a1> list2, long j10, a aVar, i iVar, i iVar2) {
        this.f7108f = tVar;
        this.f7109g = str;
        this.f7103a = list2;
        this.f7107e = list;
        this.f7110h = j10;
        this.f7111i = aVar;
        this.f7112j = iVar;
        this.f7113k = iVar2;
    }

    public static b1 b(h8.t tVar) {
        return new b1(tVar, null);
    }

    public b1 A(a1 a1Var) {
        l8.b.d(!r(), "No ordering is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f7103a);
        arrayList.add(a1Var);
        return new b1(this.f7108f, this.f7109g, this.f7107e, arrayList, this.f7110h, this.f7111i, this.f7112j, this.f7113k);
    }

    public b1 B(i iVar) {
        return new b1(this.f7108f, this.f7109g, this.f7107e, this.f7103a, this.f7110h, this.f7111i, iVar, this.f7113k);
    }

    public synchronized g1 C() {
        if (this.f7106d == null) {
            this.f7106d = E(this.f7103a);
        }
        return this.f7106d;
    }

    public synchronized g1 D() {
        if (this.f7105c == null) {
            this.f7105c = E(m());
        }
        return this.f7105c;
    }

    public final synchronized g1 E(List<a1> list) {
        if (this.f7111i == a.LIMIT_TO_FIRST) {
            return new g1(n(), f(), i(), list, this.f7110h, o(), g());
        }
        ArrayList arrayList = new ArrayList();
        for (a1 a1Var : list) {
            a1.a aVarB = a1Var.b();
            a1.a aVar = a1.a.DESCENDING;
            if (aVarB == aVar) {
                aVar = a1.a.ASCENDING;
            }
            arrayList.add(a1.d(aVar, a1Var.c()));
        }
        i iVar = this.f7113k;
        i iVar2 = iVar != null ? new i(iVar.b(), this.f7113k.c()) : null;
        i iVar3 = this.f7112j;
        return new g1(n(), f(), i(), arrayList, this.f7110h, iVar2, iVar3 != null ? new i(iVar3.b(), this.f7112j.c()) : null);
    }

    public b1 a(h8.t tVar) {
        return new b1(tVar, null, this.f7107e, this.f7103a, this.f7110h, this.f7111i, this.f7112j, this.f7113k);
    }

    public Comparator<h8.h> c() {
        return new b(m());
    }

    public b1 d(i iVar) {
        return new b1(this.f7108f, this.f7109g, this.f7107e, this.f7103a, this.f7110h, this.f7111i, this.f7112j, iVar);
    }

    public b1 e(q qVar) {
        l8.b.d(!r(), "No filter is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f7107e);
        arrayList.add(qVar);
        return new b1(this.f7108f, this.f7109g, arrayList, this.f7103a, this.f7110h, this.f7111i, this.f7112j, this.f7113k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b1.class != obj.getClass()) {
            return false;
        }
        b1 b1Var = (b1) obj;
        if (this.f7111i != b1Var.f7111i) {
            return false;
        }
        return D().equals(b1Var.D());
    }

    public String f() {
        return this.f7109g;
    }

    public i g() {
        return this.f7113k;
    }

    public List<a1> h() {
        return this.f7103a;
    }

    public int hashCode() {
        return (D().hashCode() * 31) + this.f7111i.hashCode();
    }

    public List<q> i() {
        return this.f7107e;
    }

    public SortedSet<h8.q> j() {
        TreeSet treeSet = new TreeSet();
        Iterator<q> it = i().iterator();
        while (it.hasNext()) {
            for (p pVar : it.next().c()) {
                if (pVar.i()) {
                    treeSet.add(pVar.f());
                }
            }
        }
        return treeSet;
    }

    public long k() {
        return this.f7110h;
    }

    public a l() {
        return this.f7111i;
    }

    public synchronized List<a1> m() {
        a1.a aVarB;
        if (this.f7104b == null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            for (a1 a1Var : this.f7103a) {
                arrayList.add(a1Var);
                hashSet.add(a1Var.f7093b.i());
            }
            if (this.f7103a.size() > 0) {
                List<a1> list = this.f7103a;
                aVarB = list.get(list.size() - 1).b();
            } else {
                aVarB = a1.a.ASCENDING;
            }
            for (h8.q qVar : j()) {
                if (!hashSet.contains(qVar.i()) && !qVar.B()) {
                    arrayList.add(a1.d(aVarB, qVar));
                }
            }
            if (!hashSet.contains(h8.q.f9757b.i())) {
                arrayList.add(aVarB.equals(a1.a.ASCENDING) ? f7101l : f7102m);
            }
            this.f7104b = Collections.unmodifiableList(arrayList);
        }
        return this.f7104b;
    }

    public h8.t n() {
        return this.f7108f;
    }

    public i o() {
        return this.f7112j;
    }

    public boolean p() {
        return this.f7110h != -1;
    }

    public boolean q() {
        return this.f7109g != null;
    }

    public boolean r() {
        return h8.k.u(this.f7108f) && this.f7109g == null && this.f7107e.isEmpty();
    }

    public b1 s(long j10) {
        return new b1(this.f7108f, this.f7109g, this.f7107e, this.f7103a, j10, a.LIMIT_TO_FIRST, this.f7112j, this.f7113k);
    }

    public b1 t(long j10) {
        return new b1(this.f7108f, this.f7109g, this.f7107e, this.f7103a, j10, a.LIMIT_TO_LAST, this.f7112j, this.f7113k);
    }

    public String toString() {
        return "Query(target=" + D().toString() + ";limitType=" + this.f7111i.toString() + ")";
    }

    public boolean u(h8.h hVar) {
        return hVar.c() && z(hVar) && y(hVar) && x(hVar) && w(hVar);
    }

    public boolean v() {
        if (this.f7107e.isEmpty() && this.f7110h == -1 && this.f7112j == null && this.f7113k == null) {
            return h().isEmpty() || (h().size() == 1 && h().get(0).f7093b.B());
        }
        return false;
    }

    public final boolean w(h8.h hVar) {
        i iVar = this.f7112j;
        if (iVar != null && !iVar.f(m(), hVar)) {
            return false;
        }
        i iVar2 = this.f7113k;
        return iVar2 == null || iVar2.e(m(), hVar);
    }

    public final boolean x(h8.h hVar) {
        Iterator<q> it = this.f7107e.iterator();
        while (it.hasNext()) {
            if (!it.next().d(hVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean y(h8.h hVar) {
        for (a1 a1Var : m()) {
            if (!a1Var.c().equals(h8.q.f9757b) && hVar.l(a1Var.f7093b) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(h8.h hVar) {
        h8.t tVarS = hVar.getKey().s();
        if (this.f7109g != null) {
            return hVar.getKey().t(this.f7109g) && this.f7108f.t(tVarS);
        }
        if (h8.k.u(this.f7108f)) {
            return this.f7108f.equals(tVarS);
        }
        return this.f7108f.t(tVarS) && this.f7108f.u() == tVarS.u() - 1;
    }
}
