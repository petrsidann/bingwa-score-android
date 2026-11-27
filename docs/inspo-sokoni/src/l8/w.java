package l8;

import e8.r0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [e8.q] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [e8.k] */
    public static e8.q a(e8.q qVar) {
        f(qVar);
        if (m(qVar)) {
            return qVar;
        }
        e8.k kVar = (e8.k) qVar;
        List<e8.q> listB = kVar.b();
        if (listB.size() == 1) {
            return a(listB.get(0));
        }
        if (kVar.h()) {
            return kVar;
        }
        ArrayList<??> arrayList = new ArrayList();
        Iterator<e8.q> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (?? r10 : arrayList) {
            if (!(r10 instanceof e8.p)) {
                if (r10 instanceof e8.k) {
                    r10 = (e8.k) r10;
                    if (r10.e().equals(kVar.e())) {
                        arrayList2.addAll(r10.b());
                    }
                }
            }
            arrayList2.add(r10);
        }
        return arrayList2.size() == 1 ? (e8.q) arrayList2.get(0) : new e8.k(arrayList2, kVar.e());
    }

    public static e8.q b(e8.k kVar, e8.k kVar2) {
        b.d((kVar.b().isEmpty() || kVar2.b().isEmpty()) ? false : true, "Found an empty composite filter", new Object[0]);
        if (kVar.f() && kVar2.f()) {
            return kVar.j(kVar2.b());
        }
        e8.k kVar3 = kVar.g() ? kVar : kVar2;
        if (kVar.g()) {
            kVar = kVar2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e8.q> it = kVar3.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next(), kVar));
        }
        return new e8.k(arrayList, e8.k.a.OR);
    }

    public static e8.q c(e8.p pVar, e8.k kVar) {
        if (kVar.f()) {
            return kVar.j(Collections.singletonList(pVar));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e8.q> it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e(pVar, it.next()));
        }
        return new e8.k(arrayList, e8.k.a.OR);
    }

    public static e8.q d(e8.p pVar, e8.p pVar2) {
        return new e8.k(Arrays.asList(pVar, pVar2), e8.k.a.AND);
    }

    public static e8.q e(e8.q qVar, e8.q qVar2) {
        e8.q qVarC;
        f(qVar);
        f(qVar2);
        boolean z10 = qVar instanceof e8.p;
        if (z10 && (qVar2 instanceof e8.p)) {
            qVarC = d((e8.p) qVar, (e8.p) qVar2);
        } else if (z10 && (qVar2 instanceof e8.k)) {
            qVarC = c((e8.p) qVar, (e8.k) qVar2);
        } else {
            qVarC = ((qVar instanceof e8.k) && (qVar2 instanceof e8.p)) ? c((e8.p) qVar2, (e8.k) qVar) : b((e8.k) qVar, (e8.k) qVar2);
        }
        return a(qVarC);
    }

    public static void f(e8.q qVar) {
        b.d((qVar instanceof e8.p) || (qVar instanceof e8.k), "Only field filters and composite filters are accepted.", new Object[0]);
    }

    public static e8.q g(e8.q qVar) {
        f(qVar);
        if (qVar instanceof e8.p) {
            return qVar;
        }
        e8.k kVar = (e8.k) qVar;
        if (kVar.b().size() == 1) {
            return g(qVar.b().get(0));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e8.q> it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(g(it.next()));
        }
        e8.q qVarA = a(new e8.k(arrayList, kVar.e()));
        if (k(qVarA)) {
            return qVarA;
        }
        b.d(qVarA instanceof e8.k, "field filters are already in DNF form.", new Object[0]);
        e8.k kVar2 = (e8.k) qVarA;
        b.d(kVar2.f(), "Disjunction of filters all of which are already in DNF form is itself in DNF form.", new Object[0]);
        b.d(kVar2.b().size() > 1, "Single-filter composite filters are already in DNF form.", new Object[0]);
        e8.q qVarE = kVar2.b().get(0);
        for (int i10 = 1; i10 < kVar2.b().size(); i10++) {
            qVarE = e(qVarE, kVar2.b().get(i10));
        }
        return qVarE;
    }

    public static e8.q h(e8.q qVar) {
        f(qVar);
        ArrayList arrayList = new ArrayList();
        if (!(qVar instanceof e8.p)) {
            e8.k kVar = (e8.k) qVar;
            Iterator<e8.q> it = kVar.b().iterator();
            while (it.hasNext()) {
                arrayList.add(h(it.next()));
            }
            return new e8.k(arrayList, kVar.e());
        }
        if (!(qVar instanceof r0)) {
            return qVar;
        }
        r0 r0Var = (r0) qVar;
        Iterator<d9.d0> it2 = r0Var.h().p0().m().iterator();
        while (it2.hasNext()) {
            arrayList.add(e8.p.e(r0Var.f(), e8.p.b.EQUAL, it2.next()));
        }
        return new e8.k(arrayList, e8.k.a.OR);
    }

    public static List<e8.q> i(e8.k kVar) {
        if (kVar.b().isEmpty()) {
            return Collections.emptyList();
        }
        e8.q qVarG = g(h(kVar));
        b.d(k(qVarG), "computeDistributedNormalForm did not result in disjunctive normal form", new Object[0]);
        return (m(qVarG) || l(qVarG)) ? Collections.singletonList(qVarG) : qVarG.b();
    }

    public static boolean j(e8.q qVar) {
        if (qVar instanceof e8.k) {
            e8.k kVar = (e8.k) qVar;
            if (kVar.g()) {
                for (e8.q qVar2 : kVar.b()) {
                    if (!m(qVar2) && !l(qVar2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean k(e8.q qVar) {
        return m(qVar) || l(qVar) || j(qVar);
    }

    public static boolean l(e8.q qVar) {
        return (qVar instanceof e8.k) && ((e8.k) qVar).i();
    }

    public static boolean m(e8.q qVar) {
        return qVar instanceof e8.p;
    }
}
