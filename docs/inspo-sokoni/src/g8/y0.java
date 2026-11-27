package g8;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class y0 implements m1, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f9007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f9008b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n1 f9010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f9011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e8.w0 f9012f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<h8.k, Long> f9009c = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9013g = -1;

    public y0(b1 b1Var, q0.b bVar, p pVar) {
        this.f9007a = b1Var;
        this.f9008b = pVar;
        this.f9012f = new e8.w0(b1Var.i().n());
        this.f9011e = new q0(this, bVar);
    }

    public static /* synthetic */ void s(long[] jArr, Long l10) {
        jArr[0] = jArr[0] + 1;
    }

    @Override // g8.m0
    public int a(long j10, SparseArray<?> sparseArray) {
        return this.f9007a.i().p(j10, sparseArray);
    }

    @Override // g8.m1
    public void b(h8.k kVar) {
        this.f9009c.put(kVar, Long.valueOf(h()));
    }

    @Override // g8.m1
    public void c(h8.k kVar) {
        this.f9009c.put(kVar, Long.valueOf(h()));
    }

    @Override // g8.m1
    public void d() {
        l8.b.d(this.f9013g != -1, "Committing a transaction without having started one", new Object[0]);
        this.f9013g = -1L;
    }

    @Override // g8.m0
    public q0 e() {
        return this.f9011e;
    }

    @Override // g8.m1
    public void f() {
        l8.b.d(this.f9013g == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f9013g = this.f9012f.a();
    }

    @Override // g8.m0
    public void g(l8.n<n4> nVar) {
        this.f9007a.i().l(nVar);
    }

    @Override // g8.m1
    public long h() {
        l8.b.d(this.f9013g != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f9013g;
    }

    @Override // g8.m1
    public void i(n4 n4Var) {
        this.f9007a.i().a(n4Var.l(h()));
    }

    @Override // g8.m0
    public long j() {
        long jO = this.f9007a.i().o();
        final long[] jArr = new long[1];
        o(new l8.n() { // from class: g8.x0
            @Override // l8.n
            public final void accept(Object obj) {
                y0.s(jArr, (Long) obj);
            }
        });
        return jO + jArr[0];
    }

    @Override // g8.m0
    public int k(long j10) {
        c1 c1VarH = this.f9007a.h();
        ArrayList arrayList = new ArrayList();
        Iterator<h8.h> it = c1VarH.i().iterator();
        while (it.hasNext()) {
            h8.k key = it.next().getKey();
            if (!r(key, j10)) {
                arrayList.add(key);
                this.f9009c.remove(key);
            }
        }
        c1VarH.removeAll(arrayList);
        return arrayList.size();
    }

    @Override // g8.m1
    public void l(n1 n1Var) {
        this.f9010d = n1Var;
    }

    @Override // g8.m0
    public long m() {
        long jM = this.f9007a.i().m(this.f9008b) + 0 + this.f9007a.h().h(this.f9008b);
        Iterator<z0> it = this.f9007a.r().iterator();
        while (it.hasNext()) {
            jM += it.next().m(this.f9008b);
        }
        return jM;
    }

    @Override // g8.m1
    public void n(h8.k kVar) {
        this.f9009c.put(kVar, Long.valueOf(h()));
    }

    @Override // g8.m0
    public void o(l8.n<Long> nVar) {
        for (Map.Entry<h8.k, Long> entry : this.f9009c.entrySet()) {
            if (!r(entry.getKey(), entry.getValue().longValue())) {
                nVar.accept(entry.getValue());
            }
        }
    }

    @Override // g8.m1
    public void p(h8.k kVar) {
        this.f9009c.put(kVar, Long.valueOf(h()));
    }

    public final boolean r(h8.k kVar, long j10) {
        if (t(kVar) || this.f9010d.c(kVar) || this.f9007a.i().k(kVar)) {
            return true;
        }
        Long l10 = this.f9009c.get(kVar);
        return l10 != null && l10.longValue() > j10;
    }

    public final boolean t(h8.k kVar) {
        Iterator<z0> it = this.f9007a.r().iterator();
        while (it.hasNext()) {
            if (it.next().l(kVar)) {
                return true;
            }
        }
        return false;
    }
}
