package g8;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m2 implements m1, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.w0 f8871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8872c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f8873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n1 f8874e;

    public m2(e3 e3Var, q0.b bVar) {
        this.f8870a = e3Var;
        this.f8873d = new q0(this, bVar);
    }

    public static /* synthetic */ void u(l8.n nVar, Cursor cursor) {
        nVar.accept(Long.valueOf(cursor.getLong(0)));
    }

    public static /* synthetic */ Long v(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(int[] iArr, List list, h8.t[] tVarArr, Cursor cursor) {
        h8.t tVarB = f.b(cursor.getString(0));
        h8.k kVarN = h8.k.n(tVarB);
        if (!t(kVarN)) {
            iArr[0] = iArr[0] + 1;
            list.add(kVarN);
            y(kVarN);
        }
        tVarArr[0] = tVarB;
    }

    public final void A(h8.k kVar) {
        this.f8870a.w("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", f.c(kVar.s()), Long.valueOf(h()));
    }

    @Override // g8.m0
    public int a(long j10, SparseArray<?> sparseArray) {
        return this.f8870a.i().y(j10, sparseArray);
    }

    @Override // g8.m1
    public void b(h8.k kVar) {
        A(kVar);
    }

    @Override // g8.m1
    public void c(h8.k kVar) {
        A(kVar);
    }

    @Override // g8.m1
    public void d() {
        l8.b.d(this.f8872c != -1, "Committing a transaction without having started one", new Object[0]);
        this.f8872c = -1L;
    }

    @Override // g8.m0
    public q0 e() {
        return this.f8873d;
    }

    @Override // g8.m1
    public void f() {
        l8.b.d(this.f8872c == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f8872c = this.f8871b.a();
    }

    @Override // g8.m0
    public void g(l8.n<n4> nVar) {
        this.f8870a.i().q(nVar);
    }

    @Override // g8.m1
    public long h() {
        l8.b.d(this.f8872c != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f8872c;
    }

    @Override // g8.m1
    public void i(n4 n4Var) {
        this.f8870a.i().a(n4Var.l(h()));
    }

    @Override // g8.m0
    public long j() {
        return this.f8870a.i().s() + ((Long) this.f8870a.F("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").d(new l8.t() { // from class: g8.j2
            @Override // l8.t
            public final Object apply(Object obj) {
                return m2.v((Cursor) obj);
            }
        })).longValue();
    }

    @Override // g8.m0
    public int k(long j10) {
        final int[] iArr = new int[1];
        final ArrayList arrayList = new ArrayList();
        final h8.t[] tVarArr = {h8.t.f9776b};
        while (true) {
            boolean z10 = true;
            while (true) {
                if (!z10) {
                    this.f8870a.h().removeAll(arrayList);
                    return iArr[0];
                }
                if (this.f8870a.F("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? AND path > ? LIMIT ?").b(Long.valueOf(j10), f.c(tVarArr[0]), 100).e(new l8.n() { // from class: g8.k2
                    @Override // l8.n
                    public final void accept(Object obj) {
                        this.f8832a.w(iArr, arrayList, tVarArr, (Cursor) obj);
                    }
                }) == 100) {
                    break;
                }
                z10 = false;
            }
        }
    }

    @Override // g8.m1
    public void l(n1 n1Var) {
        this.f8874e = n1Var;
    }

    @Override // g8.m0
    public long m() {
        return this.f8870a.x();
    }

    @Override // g8.m1
    public void n(h8.k kVar) {
        A(kVar);
    }

    @Override // g8.m0
    public void o(final l8.n<Long> nVar) {
        this.f8870a.F("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").e(new l8.n() { // from class: g8.l2
            @Override // l8.n
            public final void accept(Object obj) {
                m2.u(nVar, (Cursor) obj);
            }
        });
    }

    @Override // g8.m1
    public void p(h8.k kVar) {
        A(kVar);
    }

    public final boolean t(h8.k kVar) {
        if (this.f8874e.c(kVar)) {
            return true;
        }
        return x(kVar);
    }

    public final boolean x(h8.k kVar) {
        return !this.f8870a.F("SELECT 1 FROM document_mutations WHERE path = ?").b(f.c(kVar.s())).f();
    }

    public final void y(h8.k kVar) {
        this.f8870a.w("DELETE FROM target_documents WHERE path = ? AND target_id = 0", f.c(kVar.s()));
    }

    public void z(long j10) {
        this.f8871b = new e8.w0(j10);
    }
}
