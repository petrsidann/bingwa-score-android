package g8;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f8892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f8893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f8894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f8895d;

    public o(o1 o1Var, e1 e1Var, b bVar, m mVar) {
        this.f8892a = o1Var;
        this.f8893b = e1Var;
        this.f8894c = bVar;
        this.f8895d = mVar;
    }

    public final Map<h8.k, g1> a(Map<h8.k, h8.r> map, Map<h8.k, i8.k> map2, Set<h8.k> set) {
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (h8.r rVar : map.values()) {
            i8.k kVar = map2.get(rVar.getKey());
            if (set.contains(rVar.getKey()) && (kVar == null || (kVar.d() instanceof i8.l))) {
                map3.put(rVar.getKey(), rVar);
            } else if (kVar != null) {
                map4.put(rVar.getKey(), kVar.d().e());
                kVar.d().a(rVar, kVar.d().e(), h7.q.n());
            } else {
                map4.put(rVar.getKey(), i8.d.f10523b);
            }
        }
        map4.putAll(n(map3));
        HashMap map5 = new HashMap();
        for (Map.Entry<h8.k, h8.r> entry : map.entrySet()) {
            map5.put(entry.getKey(), new g1(entry.getValue(), (i8.d) map4.get(entry.getKey())));
        }
        return map5;
    }

    public final h8.r b(h8.k kVar, i8.k kVar2) {
        return (kVar2 == null || (kVar2.d() instanceof i8.l)) ? this.f8892a.a(kVar) : h8.r.s(kVar);
    }

    public h8.h c(h8.k kVar) {
        i8.k kVarC = this.f8894c.c(kVar);
        h8.r rVarB = b(kVar, kVarC);
        if (kVarC != null) {
            kVarC.d().a(rVarB, i8.d.f10523b, h7.q.n());
        }
        return rVarB;
    }

    public s7.c<h8.k, h8.h> d(Iterable<h8.k> iterable) {
        return j(this.f8892a.e(iterable), new HashSet());
    }

    public final s7.c<h8.k, h8.h> e(e8.b1 b1Var, h8.p.a aVar, i1 i1Var) {
        l8.b.d(b1Var.n().r(), "Currently we only support collection group queries at the root.", new Object[0]);
        String strF = b1Var.f();
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        Iterator<h8.t> it = this.f8895d.h(strF).iterator();
        while (it.hasNext()) {
            for (Map.Entry<h8.k, h8.h> entry : f(b1Var.a(it.next().h(strF)), aVar, i1Var)) {
                cVarA = cVarA.l(entry.getKey(), entry.getValue());
            }
        }
        return cVarA;
    }

    public final s7.c<h8.k, h8.h> f(e8.b1 b1Var, h8.p.a aVar, i1 i1Var) {
        Map<h8.k, i8.k> mapB = this.f8894c.b(b1Var.n(), aVar.o());
        Map<h8.k, h8.r> mapC = this.f8892a.c(b1Var, aVar, mapB.keySet(), i1Var);
        for (Map.Entry<h8.k, i8.k> entry : mapB.entrySet()) {
            if (!mapC.containsKey(entry.getKey())) {
                mapC.put(entry.getKey(), h8.r.s(entry.getKey()));
            }
        }
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        for (Map.Entry<h8.k, h8.r> entry2 : mapC.entrySet()) {
            i8.k kVar = mapB.get(entry2.getKey());
            if (kVar != null) {
                kVar.d().a(entry2.getValue(), i8.d.f10523b, h7.q.n());
            }
            if (b1Var.u(entry2.getValue())) {
                cVarA = cVarA.l(entry2.getKey(), entry2.getValue());
            }
        }
        return cVarA;
    }

    public final s7.c<h8.k, h8.h> g(h8.t tVar) {
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        h8.h hVarC = c(h8.k.n(tVar));
        return hVarC.c() ? cVarA.l(hVarC.getKey(), hVarC) : cVarA;
    }

    public s7.c<h8.k, h8.h> h(e8.b1 b1Var, h8.p.a aVar) {
        return i(b1Var, aVar, null);
    }

    public s7.c<h8.k, h8.h> i(e8.b1 b1Var, h8.p.a aVar, i1 i1Var) {
        h8.t tVarN = b1Var.n();
        if (b1Var.r()) {
            return g(tVarN);
        }
        return b1Var.q() ? e(b1Var, aVar, i1Var) : f(b1Var, aVar, i1Var);
    }

    public s7.c<h8.k, h8.h> j(Map<h8.k, h8.r> map, Set<h8.k> set) {
        HashMap map2 = new HashMap();
        m(map2, map.keySet());
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        for (Map.Entry<h8.k, g1> entry : a(map, map2, set).entrySet()) {
            cVarA = cVarA.l(entry.getKey(), entry.getValue().a());
        }
        return cVarA;
    }

    public n k(String str, h8.p.a aVar, int i10) {
        Map<h8.k, h8.r> mapF = this.f8892a.f(str, aVar, i10);
        Map<h8.k, i8.k> mapF2 = i10 - mapF.size() > 0 ? this.f8894c.f(str, aVar.o(), i10 - mapF.size()) : new HashMap<>();
        int iMax = -1;
        for (i8.k kVar : mapF2.values()) {
            if (!mapF.containsKey(kVar.b())) {
                mapF.put(kVar.b(), b(kVar.b(), kVar));
            }
            iMax = Math.max(iMax, kVar.c());
        }
        m(mapF2, mapF.keySet());
        return n.a(iMax, a(mapF, mapF2, Collections.emptySet()));
    }

    public Map<h8.k, g1> l(Map<h8.k, h8.r> map) {
        HashMap map2 = new HashMap();
        m(map2, map.keySet());
        return a(map, map2, new HashSet());
    }

    public final void m(Map<h8.k, i8.k> map, Set<h8.k> set) {
        TreeSet treeSet = new TreeSet();
        for (h8.k kVar : set) {
            if (!map.containsKey(kVar)) {
                treeSet.add(kVar);
            }
        }
        map.putAll(this.f8894c.a(treeSet));
    }

    public final Map<h8.k, i8.d> n(Map<h8.k, h8.r> map) {
        List<i8.g> listB = this.f8893b.b(map.keySet());
        HashMap map2 = new HashMap();
        TreeMap treeMap = new TreeMap();
        for (i8.g gVar : listB) {
            for (h8.k kVar : gVar.f()) {
                h8.r rVar = map.get(kVar);
                if (rVar != null) {
                    map2.put(kVar, gVar.b(rVar, map2.containsKey(kVar) ? (i8.d) map2.get(kVar) : i8.d.f10523b));
                    int iE = gVar.e();
                    if (!treeMap.containsKey(Integer.valueOf(iE))) {
                        treeMap.put(Integer.valueOf(iE), new HashSet());
                    }
                    ((Set) treeMap.get(Integer.valueOf(iE))).add(kVar);
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : treeMap.descendingMap().entrySet()) {
            HashMap map3 = new HashMap();
            for (h8.k kVar2 : (Set) entry.getValue()) {
                if (!hashSet.contains(kVar2)) {
                    i8.f fVarC = i8.f.c(map.get(kVar2), (i8.d) map2.get(kVar2));
                    if (fVarC != null) {
                        map3.put(kVar2, fVarC);
                    }
                    hashSet.add(kVar2);
                }
            }
            this.f8894c.e(((Integer) entry.getKey()).intValue(), map3);
        }
        return map2;
    }

    public void o(Set<h8.k> set) {
        n(this.f8892a.e(set));
    }
}
