package g8;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class y1 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f9014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f9015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9016c;

    public y1(e3 e3Var, p pVar, c8.j jVar) {
        this.f9014a = e3Var;
        this.f9015b = pVar;
        this.f9016c = jVar.b() ? jVar.a() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i8.k n(Cursor cursor) {
        return m(cursor.getBlob(0), cursor.getInt(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int[] iArr, String[] strArr, String[] strArr2, l8.m mVar, Map map, Cursor cursor) {
        iArr[0] = cursor.getInt(1);
        strArr[0] = cursor.getString(2);
        strArr2[0] = cursor.getString(3);
        s(mVar, map, cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(byte[] bArr, int i10, Map map) {
        i8.k kVarM = m(bArr, i10);
        synchronized (map) {
            map.put(kVarM.b(), kVarM);
        }
    }

    @Override // g8.b
    public Map<h8.k, i8.k> a(SortedSet<h8.k> sortedSet) {
        l8.b.d(sortedSet.comparator() == null, "getOverlays() requires natural order", new Object[0]);
        HashMap map = new HashMap();
        l8.m mVar = new l8.m();
        h8.t tVarQ = h8.t.f9776b;
        ArrayList arrayList = new ArrayList();
        for (h8.k kVar : sortedSet) {
            if (!tVarQ.equals(kVar.q())) {
                u(map, mVar, tVarQ, arrayList);
                tVarQ = kVar.q();
                arrayList.clear();
            }
            arrayList.add(kVar.r());
        }
        u(map, mVar, tVarQ, arrayList);
        mVar.b();
        return map;
    }

    @Override // g8.b
    public Map<h8.k, i8.k> b(h8.t tVar, int i10) {
        final HashMap map = new HashMap();
        final l8.m mVar = new l8.m();
        this.f9014a.F("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND largest_batch_id > ?").b(this.f9016c, f.c(tVar), Integer.valueOf(i10)).e(new l8.n() { // from class: g8.u1
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8963a.o(mVar, map, (Cursor) obj);
            }
        });
        mVar.b();
        return map;
    }

    @Override // g8.b
    public i8.k c(h8.k kVar) {
        return (i8.k) this.f9014a.F("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id = ?").b(this.f9016c, f.c(kVar.s().w()), kVar.s().p()).d(new l8.t() { // from class: g8.s1
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f8946a.n((Cursor) obj);
            }
        });
    }

    @Override // g8.b
    public void d(int i10) {
        this.f9014a.w("DELETE FROM document_overlays WHERE uid = ? AND largest_batch_id = ?", this.f9016c, Integer.valueOf(i10));
    }

    @Override // g8.b
    public void e(int i10, Map<h8.k, i8.f> map) {
        for (Map.Entry<h8.k, i8.f> entry : map.entrySet()) {
            h8.k key = entry.getKey();
            v(i10, key, (i8.f) l8.x.d(entry.getValue(), "null value for key: %s", key));
        }
    }

    @Override // g8.b
    public Map<h8.k, i8.k> f(String str, int i10, int i11) {
        final HashMap map = new HashMap();
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final int[] iArr = new int[1];
        final l8.m mVar = new l8.m();
        this.f9014a.F("SELECT overlay_mutation, largest_batch_id, collection_path, document_id  FROM document_overlays WHERE uid = ? AND collection_group = ? AND largest_batch_id > ? ORDER BY largest_batch_id, collection_path, document_id LIMIT ?").b(this.f9016c, str, Integer.valueOf(i10), Integer.valueOf(i11)).e(new l8.n() { // from class: g8.w1
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8984a.p(iArr, strArr, strArr2, mVar, map, (Cursor) obj);
            }
        });
        if (strArr[0] == null) {
            return map;
        }
        e3.d dVarF = this.f9014a.F("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_group = ? AND (collection_path > ? OR (collection_path = ? AND document_id > ?)) AND largest_batch_id = ?");
        String str2 = strArr[0];
        dVarF.b(this.f9016c, str, str2, str2, strArr2[0], Integer.valueOf(iArr[0])).e(new l8.n() { // from class: g8.x1
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8994a.q(mVar, map, (Cursor) obj);
            }
        });
        mVar.b();
        return map;
    }

    public final i8.k m(byte[] bArr, int i10) {
        try {
            return i8.k.a(i10, this.f9015b.e(d9.e0.A0(bArr)));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("Overlay failed to parse: %s", e10);
        }
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void s(l8.m mVar, final Map<h8.k, i8.k> map, Cursor cursor) {
        final byte[] blob = cursor.getBlob(0);
        final int i10 = cursor.getInt(1);
        Executor executor = mVar;
        if (cursor.isLast()) {
            executor = l8.p.f12580b;
        }
        executor.execute(new Runnable() { // from class: g8.v1
            @Override // java.lang.Runnable
            public final void run() {
                this.f8972a.r(blob, i10, map);
            }
        });
    }

    public final void u(final Map<h8.k, i8.k> map, final l8.m mVar, h8.t tVar, List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        e3.b bVar = new e3.b(this.f9014a, "SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id IN (", Arrays.asList(this.f9016c, f.c(tVar)), list, ")");
        while (bVar.d()) {
            bVar.e().e(new l8.n() { // from class: g8.t1
                @Override // l8.n
                public final void accept(Object obj) {
                    this.f8952a.s(mVar, map, (Cursor) obj);
                }
            });
        }
    }

    public final void v(int i10, h8.k kVar, i8.f fVar) {
        this.f9014a.w("INSERT OR REPLACE INTO document_overlays (uid, collection_group, collection_path, document_id, largest_batch_id, overlay_mutation) VALUES (?, ?, ?, ?, ?, ?)", this.f9016c, kVar.p(), f.c(kVar.s().w()), kVar.s().p(), Integer.valueOf(i10), this.f9015b.n(fVar).i());
    }
}
