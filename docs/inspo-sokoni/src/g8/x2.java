package g8;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class x2 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f8999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.google.protobuf.i f9002f;

    public static class a implements l8.n<Cursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<com.google.protobuf.i> f9003a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9004b = true;

        public a(byte[] bArr) {
            c(bArr);
        }

        @Override // l8.n
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            c(blob);
            if (blob.length < 1000000) {
                this.f9004b = false;
            }
        }

        public final void c(byte[] bArr) {
            this.f9003a.add(com.google.protobuf.i.q(bArr));
        }

        public int d() {
            return this.f9003a.size();
        }

        public com.google.protobuf.i e() {
            return com.google.protobuf.i.o(this.f9003a);
        }
    }

    public x2(e3 e3Var, p pVar, c8.j jVar, m mVar) {
        this.f8997a = e3Var;
        this.f8998b = pVar;
        this.f9000d = jVar.b() ? jVar.a() : "";
        this.f9002f = k8.b1.f11651v;
        this.f8999c = mVar;
    }

    public static /* synthetic */ Integer A(Cursor cursor) {
        return Integer.valueOf(cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i8.g B(Cursor cursor) {
        return v(cursor.getInt(0), cursor.getBlob(1));
    }

    public static /* synthetic */ void C(List list, Cursor cursor) {
        list.add(cursor.getString(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Cursor cursor) {
        this.f9001e = Math.max(this.f9001e, cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i8.g E(int i10, Cursor cursor) {
        return v(i10, cursor.getBlob(0));
    }

    public static /* synthetic */ void F(List list, Cursor cursor) {
        list.add(f.b(cursor.getString(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Cursor cursor) {
        this.f9002f = com.google.protobuf.i.q(cursor.getBlob(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(List list, Cursor cursor) {
        list.add(v(cursor.getInt(0), cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Set set, List list, Cursor cursor) {
        int i10 = cursor.getInt(0);
        if (set.contains(Integer.valueOf(i10))) {
            return;
        }
        set.add(Integer.valueOf(i10));
        list.add(v(i10, cursor.getBlob(1)));
    }

    public static /* synthetic */ int z(i8.g gVar, i8.g gVar2) {
        return l8.g0.l(gVar.e(), gVar2.e());
    }

    public final void H() {
        final ArrayList arrayList = new ArrayList();
        this.f8997a.F("SELECT uid FROM mutation_queues").e(new l8.n() { // from class: g8.t2
            @Override // l8.n
            public final void accept(Object obj) {
                x2.C(arrayList, (Cursor) obj);
            }
        });
        this.f9001e = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f8997a.F("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").b((String) it.next()).e(new l8.n() { // from class: g8.u2
                @Override // l8.n
                public final void accept(Object obj) {
                    this.f8966a.D((Cursor) obj);
                }
            });
        }
        this.f9001e++;
    }

    public final void I() {
        this.f8997a.w("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.f9000d, -1, this.f9002f.I());
    }

    @Override // g8.e1
    public void a() {
        if (w()) {
            final ArrayList arrayList = new ArrayList();
            this.f8997a.F("SELECT path FROM document_mutations WHERE uid = ?").b(this.f9000d).e(new l8.n() { // from class: g8.w2
                @Override // l8.n
                public final void accept(Object obj) {
                    x2.F(arrayList, (Cursor) obj);
                }
            });
            l8.b.d(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    @Override // g8.e1
    public List<i8.g> b(Iterable<h8.k> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<h8.k> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(f.c(it.next().s()));
        }
        e3.b bVar = new e3.b(this.f8997a, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(1000000, this.f9000d), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        final ArrayList arrayList2 = new ArrayList();
        final HashSet hashSet = new HashSet();
        while (bVar.d()) {
            bVar.e().e(new l8.n() { // from class: g8.r2
                @Override // l8.n
                public final void accept(Object obj) {
                    this.f8938a.y(hashSet, arrayList2, (Cursor) obj);
                }
            });
        }
        if (bVar.c() > 1) {
            Collections.sort(arrayList2, new Comparator() { // from class: g8.s2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return x2.z((i8.g) obj, (i8.g) obj2);
                }
            });
        }
        return arrayList2;
    }

    @Override // g8.e1
    public i8.g c(h7.q qVar, List<i8.f> list, List<i8.f> list2) {
        int i10 = this.f9001e;
        this.f9001e = i10 + 1;
        i8.g gVar = new i8.g(i10, qVar, list, list2);
        this.f8997a.w("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.f9000d, Integer.valueOf(i10), this.f8998b.o(gVar).i());
        HashSet hashSet = new HashSet();
        SQLiteStatement sQLiteStatementE = this.f8997a.E("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        Iterator<i8.f> it = list2.iterator();
        while (it.hasNext()) {
            h8.k kVarG = it.next().g();
            if (hashSet.add(kVarG)) {
                this.f8997a.v(sQLiteStatementE, this.f9000d, f.c(kVarG.s()), Integer.valueOf(i10));
                this.f8999c.a(kVarG.q());
            }
        }
        return gVar;
    }

    @Override // g8.e1
    public void d(com.google.protobuf.i iVar) {
        this.f9002f = (com.google.protobuf.i) l8.x.b(iVar);
        I();
    }

    @Override // g8.e1
    public void e(i8.g gVar) {
        SQLiteStatement sQLiteStatementE = this.f8997a.E("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement sQLiteStatementE2 = this.f8997a.E("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int iE = gVar.e();
        l8.b.d(this.f8997a.v(sQLiteStatementE, this.f9000d, Integer.valueOf(iE)) != 0, "Mutation batch (%s, %d) did not exist", this.f9000d, Integer.valueOf(gVar.e()));
        Iterator<i8.f> it = gVar.h().iterator();
        while (it.hasNext()) {
            h8.k kVarG = it.next().g();
            this.f8997a.v(sQLiteStatementE2, this.f9000d, f.c(kVarG.s()), Integer.valueOf(iE));
            this.f8997a.g().b(kVarG);
        }
    }

    @Override // g8.e1
    public void f(i8.g gVar, com.google.protobuf.i iVar) {
        this.f9002f = (com.google.protobuf.i) l8.x.b(iVar);
        I();
    }

    @Override // g8.e1
    public i8.g g(int i10) {
        return (i8.g) this.f8997a.F("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").b(1000000, this.f9000d, Integer.valueOf(i10 + 1)).d(new l8.t() { // from class: g8.n2
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f8880a.B((Cursor) obj);
            }
        });
    }

    @Override // g8.e1
    public int h() {
        return ((Integer) this.f8997a.F("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").b(-1, this.f9000d).d(new l8.t() { // from class: g8.o2
            @Override // l8.t
            public final Object apply(Object obj) {
                return x2.A((Cursor) obj);
            }
        })).intValue();
    }

    @Override // g8.e1
    public i8.g i(final int i10) {
        return (i8.g) this.f8997a.F("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(1000000, this.f9000d, Integer.valueOf(i10)).d(new l8.t() { // from class: g8.v2
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f8976a.E(i10, (Cursor) obj);
            }
        });
    }

    @Override // g8.e1
    public com.google.protobuf.i j() {
        return this.f9002f;
    }

    @Override // g8.e1
    public List<i8.g> k() {
        final ArrayList arrayList = new ArrayList();
        this.f8997a.F("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").b(1000000, this.f9000d).e(new l8.n() { // from class: g8.p2
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8903a.x(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // g8.e1
    public void start() {
        H();
        if (this.f8997a.F("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").b(this.f9000d).c(new l8.n() { // from class: g8.q2
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8928a.G((Cursor) obj);
            }
        }) == 0) {
            I();
        }
    }

    public final i8.g v(int i10, byte[] bArr) {
        try {
            if (bArr.length < 1000000) {
                return this.f8998b.f(j8.e.u0(bArr));
            }
            a aVar = new a(bArr);
            while (aVar.f9004b) {
                this.f8997a.F("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(Integer.valueOf((aVar.d() * 1000000) + 1), 1000000, this.f9000d, Integer.valueOf(i10)).c(aVar);
            }
            return this.f8998b.f(j8.e.t0(aVar.e()));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("MutationBatch failed to parse: %s", e10);
        }
    }

    public boolean w() {
        return this.f8997a.F("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").b(this.f9000d).f();
    }
}
