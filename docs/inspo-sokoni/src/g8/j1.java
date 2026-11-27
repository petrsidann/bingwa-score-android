package g8;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f8793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f8794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8796d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8797e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f8798f = 2.0d;

    public final s7.c<h8.k, h8.h> a(Iterable<h8.h> iterable, e8.b1 b1Var, h8.p.a aVar) {
        s7.c<h8.k, h8.h> cVarH = this.f8793a.h(b1Var, aVar);
        for (h8.h hVar : iterable) {
            cVarH = cVarH.l(hVar.getKey(), hVar);
        }
        return cVarH;
    }

    public final s7.e<h8.h> b(e8.b1 b1Var, s7.c<h8.k, h8.h> cVar) {
        s7.e<h8.h> eVar = new s7.e<>(Collections.emptyList(), b1Var.c());
        Iterator<Map.Entry<h8.k, h8.h>> it = cVar.iterator();
        while (it.hasNext()) {
            h8.h value = it.next().getValue();
            if (b1Var.u(value)) {
                eVar = eVar.i(value);
            }
        }
        return eVar;
    }

    public final void c(e8.b1 b1Var, i1 i1Var, int i10) {
        if (i1Var.a() < this.f8797e) {
            l8.v.a("QueryEngine", "SDK will not create cache indexes for query: %s, since it only creates cache indexes for collection contains more than or equal to %s documents.", b1Var.toString(), Integer.valueOf(this.f8797e));
            return;
        }
        l8.v.a("QueryEngine", "Query: %s, scans %s local documents and returns %s documents as results.", b1Var.toString(), Integer.valueOf(i1Var.a()), Integer.valueOf(i10));
        if (i1Var.a() > this.f8798f * ((double) i10)) {
            this.f8794b.b(b1Var.D());
            l8.v.a("QueryEngine", "The SDK decides to create cache indexes for query: %s, as using cache indexes may help improve performance.", b1Var.toString());
        }
    }

    public final s7.c<h8.k, h8.h> d(e8.b1 b1Var, i1 i1Var) {
        if (l8.v.c()) {
            l8.v.a("QueryEngine", "Using full collection scan to execute query: %s", b1Var.toString());
        }
        return this.f8793a.i(b1Var, h8.p.a.f9751a, i1Var);
    }

    public s7.c<h8.k, h8.h> e(e8.b1 b1Var, h8.v vVar, s7.e<h8.k> eVar) {
        l8.b.d(this.f8795c, "initialize() not called", new Object[0]);
        s7.c<h8.k, h8.h> cVarH = h(b1Var);
        if (cVarH != null) {
            return cVarH;
        }
        s7.c<h8.k, h8.h> cVarI = i(b1Var, eVar, vVar);
        if (cVarI != null) {
            return cVarI;
        }
        i1 i1Var = new i1();
        s7.c<h8.k, h8.h> cVarD = d(b1Var, i1Var);
        if (cVarD != null && this.f8796d) {
            c(b1Var, i1Var, cVarD.size());
        }
        return cVarD;
    }

    public void f(o oVar, m mVar) {
        this.f8793a = oVar;
        this.f8794b = mVar;
        this.f8795c = true;
    }

    public final boolean g(e8.b1 b1Var, int i10, s7.e<h8.h> eVar, h8.v vVar) {
        if (!b1Var.p()) {
            return false;
        }
        if (i10 != eVar.size()) {
            return true;
        }
        h8.h hVarE = b1Var.l() == e8.b1.a.LIMIT_TO_FIRST ? eVar.e() : eVar.h();
        if (hVarE == null) {
            return false;
        }
        return hVarE.f() || hVarE.m().compareTo(vVar) > 0;
    }

    public final s7.c<h8.k, h8.h> h(e8.b1 b1Var) {
        if (b1Var.v()) {
            return null;
        }
        e8.g1 g1VarD = b1Var.D();
        m.a aVarK = this.f8794b.k(g1VarD);
        if (aVarK.equals(m.a.NONE)) {
            return null;
        }
        if (!b1Var.p() || !aVarK.equals(m.a.PARTIAL)) {
            List<h8.k> listD = this.f8794b.d(g1VarD);
            l8.b.d(listD != null, "index manager must return results for partial and full indexes.", new Object[0]);
            s7.c<h8.k, h8.h> cVarD = this.f8793a.d(listD);
            h8.p.a aVarM = this.f8794b.m(g1VarD);
            s7.e<h8.h> eVarB = b(b1Var, cVarD);
            if (!g(b1Var, listD.size(), eVarB, aVarM.p())) {
                return a(eVarB, b1Var, aVarM);
            }
        }
        return h(b1Var.s(-1L));
    }

    public final s7.c<h8.k, h8.h> i(e8.b1 b1Var, s7.e<h8.k> eVar, h8.v vVar) {
        if (b1Var.v() || vVar.equals(h8.v.f9777b)) {
            return null;
        }
        s7.e<h8.h> eVarB = b(b1Var, this.f8793a.d(eVar));
        if (g(b1Var, eVar.size(), eVarB, vVar)) {
            return null;
        }
        if (l8.v.c()) {
            l8.v.a("QueryEngine", "Re-using previous result from %s to execute query: %s", vVar.toString(), b1Var.toString());
        }
        return a(eVarB, b1Var, h8.p.a.k(vVar, -1));
    }

    public void j(boolean z10) {
        this.f8796d = z10;
    }
}
