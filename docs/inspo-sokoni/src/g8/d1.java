package g8;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d1 implements m4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8700c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f8703f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e8.g1, n4> f8698a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f8699b = new n1();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h8.v f8701d = h8.v.f9777b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8702e = 0;

    public d1(b1 b1Var) {
        this.f8703f = b1Var;
    }

    @Override // g8.m4
    public void a(n4 n4Var) {
        h(n4Var);
    }

    @Override // g8.m4
    public void b(h8.v vVar) {
        this.f8701d = vVar;
    }

    @Override // g8.m4
    public int c() {
        return this.f8700c;
    }

    @Override // g8.m4
    public s7.e<h8.k> d(int i10) {
        return this.f8699b.d(i10);
    }

    @Override // g8.m4
    public h8.v e() {
        return this.f8701d;
    }

    @Override // g8.m4
    public void f(s7.e<h8.k> eVar, int i10) {
        this.f8699b.g(eVar, i10);
        m1 m1VarG = this.f8703f.g();
        Iterator<h8.k> it = eVar.iterator();
        while (it.hasNext()) {
            m1VarG.p(it.next());
        }
    }

    @Override // g8.m4
    public void g(int i10) {
        this.f8699b.h(i10);
    }

    @Override // g8.m4
    public void h(n4 n4Var) {
        this.f8698a.put(n4Var.g(), n4Var);
        int iH = n4Var.h();
        if (iH > this.f8700c) {
            this.f8700c = iH;
        }
        if (n4Var.e() > this.f8702e) {
            this.f8702e = n4Var.e();
        }
    }

    @Override // g8.m4
    public n4 i(e8.g1 g1Var) {
        return this.f8698a.get(g1Var);
    }

    @Override // g8.m4
    public void j(s7.e<h8.k> eVar, int i10) {
        this.f8699b.b(eVar, i10);
        m1 m1VarG = this.f8703f.g();
        Iterator<h8.k> it = eVar.iterator();
        while (it.hasNext()) {
            m1VarG.n(it.next());
        }
    }

    public boolean k(h8.k kVar) {
        return this.f8699b.c(kVar);
    }

    public void l(l8.n<n4> nVar) {
        Iterator<n4> it = this.f8698a.values().iterator();
        while (it.hasNext()) {
            nVar.accept(it.next());
        }
    }

    public long m(p pVar) {
        Iterator<Map.Entry<e8.g1, n4>> it = this.f8698a.entrySet().iterator();
        long jD = 0;
        while (it.hasNext()) {
            jD += (long) pVar.q(it.next().getValue()).d();
        }
        return jD;
    }

    public long n() {
        return this.f8702e;
    }

    public long o() {
        return this.f8698a.size();
    }

    public int p(long j10, SparseArray<?> sparseArray) {
        Iterator<Map.Entry<e8.g1, n4>> it = this.f8698a.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Map.Entry<e8.g1, n4> next = it.next();
            int iH = next.getValue().h();
            if (next.getValue().e() <= j10 && sparseArray.get(iH) == null) {
                it.remove();
                g(iH);
                i10++;
            }
        }
        return i10;
    }

    public void q(n4 n4Var) {
        this.f8698a.remove(n4Var.g());
        this.f8699b.h(n4Var.h());
    }
}
