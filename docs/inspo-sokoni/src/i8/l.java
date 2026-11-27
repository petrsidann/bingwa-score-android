package i8;

import d9.d0;
import h8.r;
import h8.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f10542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f10543e;

    public l(h8.k kVar, s sVar, d dVar, m mVar) {
        this(kVar, sVar, dVar, mVar, new ArrayList());
    }

    public l(h8.k kVar, s sVar, d dVar, m mVar, List<e> list) {
        super(kVar, mVar, list);
        this.f10542d = sVar;
        this.f10543e = dVar;
    }

    @Override // i8.f
    public d a(r rVar, d dVar, h7.q qVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        Map<h8.q, d0> mapL = l(qVar, rVar);
        Map<h8.q, d0> mapP = p();
        s sVarA = rVar.a();
        sVarA.n(mapP);
        sVarA.n(mapL);
        rVar.n(rVar.m(), rVar.a()).w();
        if (dVar == null) {
            return null;
        }
        HashSet hashSet = new HashSet(dVar.c());
        hashSet.addAll(this.f10543e.c());
        hashSet.addAll(o());
        return d.b(hashSet);
    }

    @Override // i8.f
    public void b(r rVar, i iVar) {
        n(rVar);
        if (!h().e(rVar)) {
            rVar.p(iVar.b());
            return;
        }
        Map<h8.q, d0> mapM = m(rVar, iVar.a());
        s sVarA = rVar.a();
        sVarA.n(p());
        sVarA.n(mapM);
        rVar.n(iVar.b(), rVar.a()).v();
    }

    @Override // i8.f
    public d e() {
        return this.f10543e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return i(lVar) && this.f10542d.equals(lVar.f10542d) && f().equals(lVar.f());
    }

    public int hashCode() {
        return (j() * 31) + this.f10542d.hashCode();
    }

    public final List<h8.q> o() {
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = f().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    public final Map<h8.q, d0> p() {
        HashMap map = new HashMap();
        for (h8.q qVar : this.f10543e.c()) {
            if (!qVar.r()) {
                map.put(qVar, this.f10542d.i(qVar));
            }
        }
        return map;
    }

    public s q() {
        return this.f10542d;
    }

    public String toString() {
        return "PatchMutation{" + k() + ", mask=" + this.f10543e + ", value=" + this.f10542d + "}";
    }
}
