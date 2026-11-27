package g8;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class k4 implements m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h8.v f8843e = h8.v.f9777b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8844f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s7.e<h8.k> f8845a;

        public b() {
            this.f8845a = h8.k.k();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n4 f8846a;

        public c() {
        }
    }

    public k4(e3 e3Var, p pVar) {
        this.f8839a = e3Var;
        this.f8840b = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(l8.n nVar, Cursor cursor) {
        nVar.accept(p(cursor.getBlob(0)));
    }

    public static /* synthetic */ void u(b bVar, Cursor cursor) {
        bVar.f8845a = bVar.f8845a.i(h8.k.n(f.b(cursor.getString(0))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(e8.g1 g1Var, c cVar, Cursor cursor) {
        n4 n4VarP = p(cursor.getBlob(0));
        if (g1Var.equals(n4VarP.g())) {
            cVar.f8846a = n4VarP;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(SparseArray sparseArray, int[] iArr, Cursor cursor) {
        int i10 = cursor.getInt(0);
        if (sparseArray.get(i10) == null) {
            z(i10);
            iArr[0] = iArr[0] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Cursor cursor) {
        this.f8841c = cursor.getInt(0);
        this.f8842d = cursor.getInt(1);
        this.f8843e = new h8.v(new h7.q(cursor.getLong(2), cursor.getInt(3)));
        this.f8844f = cursor.getLong(4);
    }

    public final void A(n4 n4Var) {
        int iH = n4Var.h();
        String strC = n4Var.g().c();
        h7.q qVarH = n4Var.f().h();
        this.f8839a.w("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(iH), strC, Long.valueOf(qVarH.k()), Integer.valueOf(qVarH.h()), n4Var.d().I(), Long.valueOf(n4Var.e()), this.f8840b.q(n4Var).i());
    }

    public void B() {
        l8.b.d(this.f8839a.F("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").c(new l8.n() { // from class: g8.f4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8742a.x((Cursor) obj);
            }
        }) == 1, "Missing target_globals entry", new Object[0]);
    }

    public final boolean C(n4 n4Var) {
        boolean z10;
        if (n4Var.h() > this.f8841c) {
            this.f8841c = n4Var.h();
            z10 = true;
        } else {
            z10 = false;
        }
        if (n4Var.e() <= this.f8842d) {
            return z10;
        }
        this.f8842d = n4Var.e();
        return true;
    }

    public final void D() {
        this.f8839a.w("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.f8841c), Long.valueOf(this.f8842d), Long.valueOf(this.f8843e.h().k()), Integer.valueOf(this.f8843e.h().h()), Long.valueOf(this.f8844f));
    }

    @Override // g8.m4
    public void a(n4 n4Var) {
        A(n4Var);
        if (C(n4Var)) {
            D();
        }
    }

    @Override // g8.m4
    public void b(h8.v vVar) {
        this.f8843e = vVar;
        D();
    }

    @Override // g8.m4
    public int c() {
        return this.f8841c;
    }

    @Override // g8.m4
    public s7.e<h8.k> d(int i10) {
        final b bVar = new b();
        this.f8839a.F("SELECT path FROM target_documents WHERE target_id = ?").b(Integer.valueOf(i10)).e(new l8.n() { // from class: g8.h4
            @Override // l8.n
            public final void accept(Object obj) {
                k4.u(bVar, (Cursor) obj);
            }
        });
        return bVar.f8845a;
    }

    @Override // g8.m4
    public h8.v e() {
        return this.f8843e;
    }

    @Override // g8.m4
    public void f(s7.e<h8.k> eVar, int i10) {
        SQLiteStatement sQLiteStatementE = this.f8839a.E("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        m2 m2VarA = this.f8839a.g();
        for (h8.k kVar : eVar) {
            this.f8839a.v(sQLiteStatementE, Integer.valueOf(i10), f.c(kVar.s()));
            m2VarA.p(kVar);
        }
    }

    @Override // g8.m4
    public void g(int i10) {
        this.f8839a.w("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i10));
    }

    @Override // g8.m4
    public void h(n4 n4Var) {
        A(n4Var);
        C(n4Var);
        this.f8844f++;
        D();
    }

    @Override // g8.m4
    public n4 i(final e8.g1 g1Var) {
        String strC = g1Var.c();
        final c cVar = new c();
        this.f8839a.F("SELECT target_proto FROM targets WHERE canonical_id = ?").b(strC).e(new l8.n() { // from class: g8.g4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8750a.v(g1Var, cVar, (Cursor) obj);
            }
        });
        return cVar.f8846a;
    }

    @Override // g8.m4
    public void j(s7.e<h8.k> eVar, int i10) {
        SQLiteStatement sQLiteStatementE = this.f8839a.E("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        m2 m2VarA = this.f8839a.g();
        for (h8.k kVar : eVar) {
            this.f8839a.v(sQLiteStatementE, Integer.valueOf(i10), f.c(kVar.s()));
            m2VarA.n(kVar);
        }
    }

    public final n4 p(byte[] bArr) {
        try {
            return this.f8840b.h(j8.c.w0(bArr));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("TargetData failed to parse: %s", e10);
        }
    }

    public void q(final l8.n<n4> nVar) {
        this.f8839a.F("SELECT target_proto FROM targets").e(new l8.n() { // from class: g8.j4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8805a.t(nVar, (Cursor) obj);
            }
        });
    }

    public long r() {
        return this.f8842d;
    }

    public long s() {
        return this.f8844f;
    }

    public int y(long j10, final SparseArray<?> sparseArray) {
        final int[] iArr = new int[1];
        this.f8839a.F("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").b(Long.valueOf(j10)).e(new l8.n() { // from class: g8.i4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8785a.w(sparseArray, iArr, (Cursor) obj);
            }
        });
        D();
        return iArr[0];
    }

    public final void z(int i10) {
        g(i10);
        this.f8839a.w("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i10));
        this.f8844f--;
    }
}
