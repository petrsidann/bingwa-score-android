package h8;

import e8.a1;
import e8.g1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SortedSet<e8.p> f9780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e8.p> f9781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a1> f9782d;

    public x(g1 g1Var) {
        this.f9779a = g1Var.d() != null ? g1Var.d() : g1Var.n().p();
        this.f9782d = g1Var.m();
        this.f9780b = new TreeSet(new Comparator() { // from class: h8.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return x.e((e8.p) obj, (e8.p) obj2);
            }
        });
        this.f9781c = new ArrayList();
        Iterator<e8.q> it = g1Var.h().iterator();
        while (it.hasNext()) {
            e8.p pVar = (e8.p) it.next();
            if (pVar.i()) {
                this.f9780b.add(pVar);
            } else {
                this.f9781c.add(pVar);
            }
        }
    }

    public static /* synthetic */ int e(e8.p pVar, e8.p pVar2) {
        return pVar.f().compareTo(pVar2.f());
    }

    public p b() {
        q qVarF;
        p.c.a aVar;
        if (d()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (e8.p pVar : this.f9781c) {
            if (!pVar.f().B()) {
                if (pVar.g().equals(e8.p.b.ARRAY_CONTAINS) || pVar.g().equals(e8.p.b.ARRAY_CONTAINS_ANY)) {
                    qVarF = pVar.f();
                    aVar = p.c.a.CONTAINS;
                } else if (!hashSet.contains(pVar.f())) {
                    hashSet.add(pVar.f());
                    qVarF = pVar.f();
                    aVar = p.c.a.ASCENDING;
                }
                arrayList.add(p.c.h(qVarF, aVar));
            }
        }
        for (a1 a1Var : this.f9782d) {
            if (!a1Var.c().B() && !hashSet.contains(a1Var.c())) {
                hashSet.add(a1Var.c());
                arrayList.add(p.c.h(a1Var.c(), a1Var.b() == a1.a.ASCENDING ? p.c.a.ASCENDING : p.c.a.DESCENDING));
            }
        }
        return p.b(-1, this.f9779a, arrayList, p.f9749a);
    }

    public final boolean c(p.c cVar) {
        Iterator<e8.p> it = this.f9781c.iterator();
        while (it.hasNext()) {
            if (f(it.next(), cVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return this.f9780b.size() > 1;
    }

    public final boolean f(e8.p pVar, p.c cVar) {
        if (pVar == null || !pVar.f().equals(cVar.i())) {
            return false;
        }
        return cVar.k().equals(p.c.a.CONTAINS) == (pVar.g().equals(e8.p.b.ARRAY_CONTAINS) || pVar.g().equals(e8.p.b.ARRAY_CONTAINS_ANY));
    }

    public final boolean g(a1 a1Var, p.c cVar) {
        if (a1Var.c().equals(cVar.i())) {
            return (cVar.k().equals(p.c.a.ASCENDING) && a1Var.b().equals(a1.a.ASCENDING)) || (cVar.k().equals(p.c.a.DESCENDING) && a1Var.b().equals(a1.a.DESCENDING));
        }
        return false;
    }

    public boolean h(p pVar) {
        l8.b.d(pVar.d().equals(this.f9779a), "Collection IDs do not match", new Object[0]);
        if (d()) {
            return false;
        }
        p.c cVarC = pVar.c();
        if (cVarC != null && !c(cVarC)) {
            return false;
        }
        Iterator<a1> it = this.f9782d.iterator();
        List<p.c> listE = pVar.e();
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < listE.size() && c(listE.get(i10))) {
            hashSet.add(listE.get(i10).i().i());
            i10++;
        }
        if (i10 == listE.size()) {
            return true;
        }
        if (this.f9780b.size() > 0) {
            e8.p pVarFirst = this.f9780b.first();
            if (!hashSet.contains(pVarFirst.f().i())) {
                p.c cVar = listE.get(i10);
                if (!f(pVarFirst, cVar) || !g(it.next(), cVar)) {
                    return false;
                }
            }
            i10++;
        }
        while (i10 < listE.size()) {
            p.c cVar2 = listE.get(i10);
            if (!it.hasNext() || !g(it.next(), cVar2)) {
                return false;
            }
            i10++;
        }
        return true;
    }
}
