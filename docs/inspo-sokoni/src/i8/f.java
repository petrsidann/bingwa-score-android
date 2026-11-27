package i8;

import d9.d0;
import h8.r;
import h8.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.k f10527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f10528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f10529c;

    public f(h8.k kVar, m mVar) {
        this(kVar, mVar, new ArrayList());
    }

    public f(h8.k kVar, m mVar, List<e> list) {
        this.f10527a = kVar;
        this.f10528b = mVar;
        this.f10529c = list;
    }

    public static f c(r rVar, d dVar) {
        if (!rVar.e()) {
            return null;
        }
        if (dVar != null && dVar.c().isEmpty()) {
            return null;
        }
        if (dVar == null) {
            return rVar.j() ? new c(rVar.getKey(), m.f10544c) : new o(rVar.getKey(), rVar.a(), m.f10544c);
        }
        s sVarA = rVar.a();
        s sVar = new s();
        HashSet hashSet = new HashSet();
        for (h8.q qVarW : dVar.c()) {
            if (!hashSet.contains(qVarW)) {
                if (sVarA.i(qVarW) == null && qVarW.u() > 1) {
                    qVarW = qVarW.w();
                }
                sVar.m(qVarW, sVarA.i(qVarW));
                hashSet.add(qVarW);
            }
        }
        return new l(rVar.getKey(), sVar, d.b(hashSet), m.f10544c);
    }

    public abstract d a(r rVar, d dVar, h7.q qVar);

    public abstract void b(r rVar, i iVar);

    public s d(h8.h hVar) {
        s sVar = null;
        for (e eVar : this.f10529c) {
            d0 d0VarA = eVar.b().a(hVar.l(eVar.a()));
            if (d0VarA != null) {
                if (sVar == null) {
                    sVar = new s();
                }
                sVar.m(eVar.a(), d0VarA);
            }
        }
        return sVar;
    }

    public abstract d e();

    public List<e> f() {
        return this.f10529c;
    }

    public h8.k g() {
        return this.f10527a;
    }

    public m h() {
        return this.f10528b;
    }

    public boolean i(f fVar) {
        return this.f10527a.equals(fVar.f10527a) && this.f10528b.equals(fVar.f10528b);
    }

    public int j() {
        return (g().hashCode() * 31) + this.f10528b.hashCode();
    }

    public String k() {
        return "key=" + this.f10527a + ", precondition=" + this.f10528b;
    }

    public Map<h8.q, d0> l(h7.q qVar, r rVar) {
        HashMap map = new HashMap(this.f10529c.size());
        for (e eVar : this.f10529c) {
            map.put(eVar.a(), eVar.b().c(rVar.l(eVar.a()), qVar));
        }
        return map;
    }

    public Map<h8.q, d0> m(r rVar, List<d0> list) {
        HashMap map = new HashMap(this.f10529c.size());
        l8.b.d(this.f10529c.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.f10529c.size()));
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = this.f10529c.get(i10);
            map.put(eVar.a(), eVar.b().b(rVar.l(eVar.a()), list.get(i10)));
        }
        return map;
    }

    public void n(r rVar) {
        l8.b.d(rVar.getKey().equals(g()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }
}
