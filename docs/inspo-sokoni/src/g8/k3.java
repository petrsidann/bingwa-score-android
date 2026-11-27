package g8;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k3 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f8838c;

    public k3(e3 e3Var, p pVar) {
        this.f8836a = e3Var;
        this.f8837b = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(l8.m mVar, Map map, Cursor cursor) {
        r(mVar, map, cursor, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(l8.m mVar, Map map, l8.t tVar, i1 i1Var, Cursor cursor) {
        r(mVar, map, cursor, tVar);
        if (i1Var != null) {
            i1Var.b();
        }
    }

    public static /* synthetic */ Boolean p(e8.b1 b1Var, Set set, h8.r rVar) {
        return Boolean.valueOf(b1Var.u(rVar) || set.contains(rVar.getKey()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(byte[] bArr, int i10, int i11, l8.t tVar, Map map) {
        h8.r rVarK = k(bArr, i10, i11);
        if (tVar == null || ((Boolean) tVar.apply(rVarK)).booleanValue()) {
            synchronized (map) {
                map.put(rVarK.getKey(), rVarK);
            }
        }
    }

    @Override // g8.o1
    public h8.r a(h8.k kVar) {
        return e(Collections.singletonList(kVar)).get(kVar);
    }

    @Override // g8.o1
    public void b(m mVar) {
        this.f8838c = mVar;
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> c(final e8.b1 b1Var, h8.p.a aVar, final Set<h8.k> set, i1 i1Var) {
        return m(Collections.singletonList(b1Var.n()), aVar, com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, new l8.t() { // from class: g8.g3
            @Override // l8.t
            public final Object apply(Object obj) {
                return k3.p(b1Var, set, (h8.r) obj);
            }
        }, i1Var);
    }

    @Override // g8.o1
    public void d(h8.r rVar, h8.v vVar) {
        l8.b.d(!vVar.equals(h8.v.f9777b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        h8.k key = rVar.getKey();
        h7.q qVarH = vVar.h();
        this.f8836a.w("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?, ?)", f.c(key.s()), Integer.valueOf(key.s().u()), Long.valueOf(qVarH.k()), Integer.valueOf(qVarH.h()), this.f8837b.m(rVar).i());
        this.f8838c.a(rVar.getKey().q());
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> e(Iterable<h8.k> iterable) {
        final HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (h8.k kVar : iterable) {
            arrayList.add(f.c(kVar.s()));
            map.put(kVar, h8.r.s(kVar));
        }
        e3.b bVar = new e3.b(this.f8836a, "SELECT contents, read_time_seconds, read_time_nanos FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        final l8.m mVar = new l8.m();
        while (bVar.d()) {
            bVar.e().e(new l8.n() { // from class: g8.h3
                @Override // l8.n
                public final void accept(Object obj) {
                    this.f8760a.n(mVar, map, (Cursor) obj);
                }
            });
        }
        mVar.b();
        return map;
    }

    @Override // g8.o1
    public Map<h8.k, h8.r> f(String str, h8.p.a aVar, int i10) {
        List<h8.t> listH = this.f8838c.h(str);
        ArrayList arrayList = new ArrayList(listH.size());
        Iterator<h8.t> it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().h(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyMap();
        }
        if (arrayList.size() * 9 < 900) {
            return l(arrayList, aVar, i10, null);
        }
        HashMap map = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            int i12 = i11 + 100;
            map.putAll(l(arrayList.subList(i11, Math.min(arrayList.size(), i12)), aVar, i10, null));
            i11 = i12;
        }
        return l8.g0.v(map, i10, h8.p.a.f9752b);
    }

    public final h8.r k(byte[] bArr, int i10, int i11) {
        try {
            return this.f8837b.d(j8.a.o0(bArr)).x(new h8.v(new h7.q(i10, i11)));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("MaybeDocument failed to parse: %s", e10);
        }
    }

    public final Map<h8.k, h8.r> l(List<h8.t> list, h8.p.a aVar, int i10, l8.t<h8.r, Boolean> tVar) {
        return m(list, aVar, i10, tVar, null);
    }

    public final Map<h8.k, h8.r> m(List<h8.t> list, h8.p.a aVar, int i10, final l8.t<h8.r, Boolean> tVar, final i1 i1Var) {
        h7.q qVarH = aVar.p().h();
        h8.k kVarN = aVar.n();
        StringBuilder sbA = l8.g0.A("SELECT contents, read_time_seconds, read_time_nanos, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ", list.size(), " UNION ");
        sbA.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        Object[] objArr = new Object[(list.size() * 9) + 1];
        int i11 = 0;
        for (h8.t tVar2 : list) {
            String strC = f.c(tVar2);
            int i12 = i11 + 1;
            objArr[i11] = strC;
            int i13 = i12 + 1;
            objArr[i12] = f.f(strC);
            int i14 = i13 + 1;
            objArr[i13] = Integer.valueOf(tVar2.u() + 1);
            int i15 = i14 + 1;
            objArr[i14] = Long.valueOf(qVarH.k());
            int i16 = i15 + 1;
            objArr[i15] = Long.valueOf(qVarH.k());
            int i17 = i16 + 1;
            objArr[i16] = Integer.valueOf(qVarH.h());
            int i18 = i17 + 1;
            objArr[i17] = Long.valueOf(qVarH.k());
            int i19 = i18 + 1;
            objArr[i18] = Integer.valueOf(qVarH.h());
            objArr[i19] = f.c(kVarN.s());
            i11 = i19 + 1;
        }
        objArr[i11] = Integer.valueOf(i10);
        final l8.m mVar = new l8.m();
        final HashMap map = new HashMap();
        this.f8836a.F(sbA.toString()).b(objArr).e(new l8.n() { // from class: g8.i3
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8780a.o(mVar, map, tVar, i1Var, (Cursor) obj);
            }
        });
        mVar.b();
        return map;
    }

    public final void r(l8.m mVar, final Map<h8.k, h8.r> map, Cursor cursor, final l8.t<h8.r, Boolean> tVar) {
        final byte[] blob = cursor.getBlob(0);
        final int i10 = cursor.getInt(1);
        final int i11 = cursor.getInt(2);
        Executor executor = mVar;
        if (cursor.isLast()) {
            executor = l8.p.f12580b;
        }
        executor.execute(new Runnable() { // from class: g8.j3
            @Override // java.lang.Runnable
            public final void run() {
                this.f8799a.q(blob, i10, i11, tVar, map);
            }
        });
    }

    @Override // g8.o1
    public void removeAll(Collection<h8.k> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        for (h8.k kVar : collection) {
            arrayList.add(f.c(kVar.s()));
            cVarA = cVarA.l(kVar, h8.r.t(kVar, h8.v.f9777b));
        }
        e3.b bVar = new e3.b(this.f8836a, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
        while (bVar.d()) {
            bVar.a();
        }
        this.f8838c.e(cVarA);
    }
}
