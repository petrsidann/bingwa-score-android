package g8;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class i2 implements m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8768k = "i2";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f8769l = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<e8.g1, List<e8.g1>> f8773d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w0.a f8774e = new w0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Map<Integer, h8.p>> f8775f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Queue<h8.p> f8776g = new PriorityQueue(10, new Comparator() { // from class: g8.a2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i2.R((h8.p) obj, (h8.p) obj2);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8777h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8778i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f8779j = -1;

    public i2(e3 e3Var, p pVar, c8.j jVar) {
        this.f8770a = e3Var;
        this.f8771b = pVar;
        this.f8772c = jVar.b() ? jVar.a() : "";
    }

    public static /* synthetic */ void O(ArrayList arrayList, Cursor cursor) {
        arrayList.add(f.b(cursor.getString(0)));
    }

    public static /* synthetic */ void P(List list, Cursor cursor) {
        list.add(h8.k.n(h8.t.z(cursor.getString(0))));
    }

    public static /* synthetic */ void Q(SortedSet sortedSet, h8.p pVar, h8.k kVar, Cursor cursor) {
        sortedSet.add(f8.e.h(pVar.f(), kVar, cursor.getBlob(0), cursor.getBlob(1)));
    }

    public static /* synthetic */ int R(h8.p pVar, h8.p pVar2) {
        int iCompare = Long.compare(pVar.g().d(), pVar2.g().d());
        return iCompare == 0 ? pVar.d().compareTo(pVar2.d()) : iCompare;
    }

    public static /* synthetic */ void S(Map map, Cursor cursor) {
        map.put(Integer.valueOf(cursor.getInt(0)), h8.p.b.b(cursor.getLong(1), new h8.v(new h7.q(cursor.getLong(2), cursor.getInt(3))), h8.k.n(f.b(cursor.getString(4))), cursor.getInt(5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Map map, Cursor cursor) {
        try {
            int i10 = cursor.getInt(0);
            W(h8.p.b(i10, cursor.getString(1), this.f8771b.c(b9.a.k0(cursor.getBlob(2))), map.containsKey(Integer.valueOf(i10)) ? (h8.p.b) map.get(Integer.valueOf(i10)) : h8.p.f9749a));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("Failed to decode index: " + e10, new Object[0]);
        }
    }

    public final byte[] A(h8.p pVar, h8.h hVar) {
        f8.d dVar = new f8.d();
        for (h8.p.c cVar : pVar.e()) {
            d9.d0 d0VarL = hVar.l(cVar.i());
            if (d0VarL == null) {
                return null;
            }
            f8.c.f8246a.e(d0VarL, dVar.b(cVar.k()));
        }
        return dVar.c();
    }

    public final byte[] B(h8.p pVar) {
        return this.f8771b.l(pVar.h()).i();
    }

    public final byte[] C(d9.d0 d0Var) {
        f8.d dVar = new f8.d();
        f8.c.f8246a.e(d0Var, dVar.b(h8.p.c.a.ASCENDING));
        return dVar.c();
    }

    public final Object[] D(h8.p pVar, e8.g1 g1Var, Collection<d9.d0> collection) {
        if (collection == null) {
            return null;
        }
        List<f8.d> arrayList = new ArrayList<>();
        arrayList.add(new f8.d());
        Iterator<d9.d0> it = collection.iterator();
        for (h8.p.c cVar : pVar.e()) {
            d9.d0 next = it.next();
            for (f8.d dVar : arrayList) {
                if (N(g1Var, cVar.i()) && h8.y.u(next)) {
                    arrayList = E(arrayList, cVar, next);
                } else {
                    f8.c.f8246a.e(next, dVar.b(cVar.k()));
                }
            }
        }
        return H(arrayList);
    }

    public final List<f8.d> E(List<f8.d> list, h8.p.c cVar, d9.d0 d0Var) {
        ArrayList<f8.d> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (d9.d0 d0Var2 : d0Var.p0().m()) {
            for (f8.d dVar : arrayList) {
                f8.d dVar2 = new f8.d();
                dVar2.d(dVar.c());
                f8.c.f8246a.e(d0Var2, dVar2.b(cVar.k()));
                arrayList2.add(dVar2);
            }
        }
        return arrayList2;
    }

    public final Object[] F(int i10, int i11, List<d9.d0> list, Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = i10 / (list != null ? list.size() : 1);
        int i12 = 0;
        Object[] objArr4 = new Object[(i10 * 5) + (objArr3 != null ? objArr3.length : 0)];
        int i13 = 0;
        int i14 = 0;
        while (i13 < i10) {
            int i15 = i14 + 1;
            objArr4[i14] = Integer.valueOf(i11);
            int i16 = i15 + 1;
            objArr4[i15] = this.f8772c;
            int i17 = i16 + 1;
            objArr4[i16] = list != null ? C(list.get(i13 / size)) : f8769l;
            int i18 = i17 + 1;
            int i19 = i13 % size;
            objArr4[i17] = objArr[i19];
            objArr4[i18] = objArr2[i19];
            i13++;
            i14 = i18 + 1;
        }
        if (objArr3 != null) {
            int length = objArr3.length;
            while (i12 < length) {
                objArr4[i14] = objArr3[i12];
                i12++;
                i14++;
            }
        }
        return objArr4;
    }

    public final Object[] G(e8.g1 g1Var, int i10, List<d9.d0> list, Object[] objArr, String str, Object[] objArr2, String str2, Object[] objArr3) {
        StringBuilder sb2;
        int iMax = Math.max(objArr.length, objArr2.length) * (list != null ? list.size() : 1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SELECT document_key, directional_value FROM index_entries ");
        sb3.append("WHERE index_id = ? AND uid = ? ");
        sb3.append("AND array_value = ? ");
        sb3.append("AND directional_value ");
        sb3.append(str);
        sb3.append(" ? ");
        sb3.append("AND directional_value ");
        sb3.append(str2);
        sb3.append(" ? ");
        CharSequence charSequenceA = l8.g0.A(sb3, iMax, " UNION ");
        if (objArr3 != null) {
            StringBuilder sb4 = new StringBuilder("SELECT document_key, directional_value FROM (");
            sb4.append(charSequenceA);
            sb4.append(") WHERE directional_value NOT IN (");
            sb4.append((CharSequence) l8.g0.A("?", objArr3.length, ", "));
            sb4.append(")");
            sb2 = sb4;
        } else {
            sb2 = charSequenceA;
        }
        Object[] objArrF = F(iMax, i10, list, objArr, objArr2, objArr3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb2.toString());
        arrayList.addAll(Arrays.asList(objArrF));
        return arrayList.toArray();
    }

    public final Object[] H(List<f8.d> list) {
        Object[] objArr = new Object[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            objArr[i10] = list.get(i10).c();
        }
        return objArr;
    }

    public final SortedSet<f8.e> I(final h8.k kVar, final h8.p pVar) {
        final TreeSet treeSet = new TreeSet();
        this.f8770a.F("SELECT array_value, directional_value FROM index_entries WHERE index_id = ? AND document_key = ? AND uid = ?").b(Integer.valueOf(pVar.f()), kVar.toString(), this.f8772c).e(new l8.n() { // from class: g8.f2
            @Override // l8.n
            public final void accept(Object obj) {
                i2.Q(treeSet, pVar, kVar, (Cursor) obj);
            }
        });
        return treeSet;
    }

    public final h8.p J(e8.g1 g1Var) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        h8.x xVar = new h8.x(g1Var);
        Collection<h8.p> collectionK = K(g1Var.d() != null ? g1Var.d() : g1Var.n().p());
        h8.p pVar = null;
        if (collectionK.isEmpty()) {
            return null;
        }
        for (h8.p pVar2 : collectionK) {
            if (xVar.h(pVar2) && (pVar == null || pVar2.h().size() > pVar.h().size())) {
                pVar = pVar2;
            }
        }
        return pVar;
    }

    public Collection<h8.p> K(String str) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        Map<Integer, h8.p> map = this.f8775f.get(str);
        return map == null ? Collections.emptyList() : map.values();
    }

    public final h8.p.a L(Collection<h8.p> collection) {
        l8.b.d(!collection.isEmpty(), "Found empty index group when looking for least recent index offset.", new Object[0]);
        Iterator<h8.p> it = collection.iterator();
        h8.p.a aVarC = it.next().g().c();
        int iO = aVarC.o();
        while (it.hasNext()) {
            h8.p.a aVarC2 = it.next().g().c();
            if (aVarC2.compareTo(aVarC) < 0) {
                aVarC = aVarC2;
            }
            iO = Math.max(aVarC2.o(), iO);
        }
        return h8.p.a.i(aVarC.p(), aVarC.n(), iO);
    }

    public final List<e8.g1> M(e8.g1 g1Var) {
        if (this.f8773d.containsKey(g1Var)) {
            return this.f8773d.get(g1Var);
        }
        ArrayList arrayList = new ArrayList();
        if (g1Var.h().isEmpty()) {
            arrayList.add(g1Var);
        } else {
            Iterator<e8.q> it = l8.w.i(new e8.k(g1Var.h(), e8.k.a.AND)).iterator();
            while (it.hasNext()) {
                arrayList.add(new e8.g1(g1Var.n(), g1Var.d(), it.next().b(), g1Var.m(), g1Var.j(), g1Var.p(), g1Var.f()));
            }
        }
        this.f8773d.put(g1Var, arrayList);
        return arrayList;
    }

    public final boolean N(e8.g1 g1Var, h8.q qVar) {
        for (e8.q qVar2 : g1Var.h()) {
            if (qVar2 instanceof e8.p) {
                e8.p pVar = (e8.p) qVar2;
                if (pVar.f().equals(qVar)) {
                    e8.p.b bVarG = pVar.g();
                    if (bVarG.equals(e8.p.b.IN) || bVarG.equals(e8.p.b.NOT_IN)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final void W(h8.p pVar) {
        Map<Integer, h8.p> map = this.f8775f.get(pVar.d());
        if (map == null) {
            map = new HashMap<>();
            this.f8775f.put(pVar.d(), map);
        }
        h8.p pVar2 = map.get(Integer.valueOf(pVar.f()));
        if (pVar2 != null) {
            this.f8776g.remove(pVar2);
        }
        map.put(Integer.valueOf(pVar.f()), pVar);
        this.f8776g.add(pVar);
        this.f8778i = Math.max(this.f8778i, pVar.f());
        this.f8779j = Math.max(this.f8779j, pVar.g().d());
    }

    public final void X(final h8.h hVar, SortedSet<f8.e> sortedSet, SortedSet<f8.e> sortedSet2) {
        l8.v.a(f8768k, "Updating index entries for document '%s'", hVar.getKey());
        l8.g0.t(sortedSet, sortedSet2, new l8.n() { // from class: g8.c2
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8692a.U(hVar, (f8.e) obj);
            }
        }, new l8.n() { // from class: g8.d2
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8704a.V(hVar, (f8.e) obj);
            }
        });
    }

    @Override // g8.m
    public void a(h8.t tVar) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        l8.b.d(tVar.u() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.f8774e.a(tVar)) {
            this.f8770a.w("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", tVar.p(), f.c(tVar.w()));
        }
    }

    @Override // g8.m
    public void b(e8.g1 g1Var) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        for (e8.g1 g1Var2 : M(g1Var)) {
            m.a aVarK = k(g1Var2);
            if (aVarK == m.a.NONE || aVarK == m.a.PARTIAL) {
                h8.p pVarB = new h8.x(g1Var2).b();
                if (pVarB != null) {
                    n(pVarB);
                }
            }
        }
    }

    @Override // g8.m
    public void c(h8.p pVar) {
        this.f8770a.w("DELETE FROM index_configuration WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f8770a.w("DELETE FROM index_entries WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f8770a.w("DELETE FROM index_state WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f8776g.remove(pVar);
        Map<Integer, h8.p> map = this.f8775f.get(pVar.d());
        if (map != null) {
            map.remove(Integer.valueOf(pVar.f()));
        }
    }

    @Override // g8.m
    public List<h8.k> d(e8.g1 g1Var) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Pair> arrayList3 = new ArrayList();
        for (e8.g1 g1Var2 : M(g1Var)) {
            h8.p pVarJ = J(g1Var2);
            if (pVarJ == null) {
                return null;
            }
            arrayList3.add(Pair.create(g1Var2, pVarJ));
        }
        for (Pair pair : arrayList3) {
            e8.g1 g1Var3 = (e8.g1) pair.first;
            h8.p pVar = (h8.p) pair.second;
            List<d9.d0> listA = g1Var3.a(pVar);
            Collection<d9.d0> collectionL = g1Var3.l(pVar);
            e8.i iVarK = g1Var3.k(pVar);
            e8.i iVarQ = g1Var3.q(pVar);
            if (l8.v.c()) {
                l8.v.a(f8768k, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", pVar, g1Var3, listA, iVarK, iVarQ);
            }
            Object[] objArrG = G(g1Var3, pVar.f(), listA, z(pVar, g1Var3, iVarK), iVarK.c() ? ">=" : ">", z(pVar, g1Var3, iVarQ), iVarQ.c() ? "<=" : "<", D(pVar, g1Var3, collectionL));
            arrayList.add(String.valueOf(objArrG[0]));
            arrayList2.addAll(Arrays.asList(objArrG).subList(1, objArrG.length));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(TextUtils.join(" UNION ", arrayList));
        sb2.append("ORDER BY directional_value, document_key ");
        sb2.append(g1Var.i().equals(e8.a1.a.ASCENDING) ? "asc " : "desc ");
        String str = "SELECT DISTINCT document_key FROM (" + sb2.toString() + ")";
        if (g1Var.r()) {
            str = str + " LIMIT " + g1Var.j();
        }
        l8.b.d(arrayList2.size() < 1000, "Cannot perform query with more than 999 bind elements", new Object[0]);
        e3.d dVarB = this.f8770a.F(str).b(arrayList2.toArray());
        final ArrayList arrayList4 = new ArrayList();
        dVarB.e(new l8.n() { // from class: g8.b2
            @Override // l8.n
            public final void accept(Object obj) {
                i2.P(arrayList4, (Cursor) obj);
            }
        });
        l8.v.a(f8768k, "Index scan returned %s documents", Integer.valueOf(arrayList4.size()));
        return arrayList4;
    }

    @Override // g8.m
    public void e(s7.c<h8.k, h8.h> cVar) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        for (Map.Entry<h8.k, h8.h> entry : cVar) {
            for (h8.p pVar : K(entry.getKey().p())) {
                SortedSet<f8.e> sortedSetI = I(entry.getKey(), pVar);
                SortedSet<f8.e> sortedSetX = x(entry.getValue(), pVar);
                if (!sortedSetI.equals(sortedSetX)) {
                    X(entry.getValue(), sortedSetI, sortedSetX);
                }
            }
        }
    }

    @Override // g8.m
    public Collection<h8.p> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<Integer, h8.p>> it = this.f8775f.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    @Override // g8.m
    public String g() {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        h8.p pVarPeek = this.f8776g.peek();
        if (pVarPeek != null) {
            return pVarPeek.d();
        }
        return null;
    }

    @Override // g8.m
    public List<h8.t> h(String str) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        this.f8770a.F("SELECT parent FROM collection_parents WHERE collection_id = ?").b(str).e(new l8.n() { // from class: g8.e2
            @Override // l8.n
            public final void accept(Object obj) {
                i2.O(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // g8.m
    public void i() {
        this.f8770a.w("DELETE FROM index_configuration", new Object[0]);
        this.f8770a.w("DELETE FROM index_entries", new Object[0]);
        this.f8770a.w("DELETE FROM index_state", new Object[0]);
        this.f8776g.clear();
        this.f8775f.clear();
    }

    @Override // g8.m
    public void j(String str, h8.p.a aVar) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        this.f8779j++;
        for (h8.p pVar : K(str)) {
            h8.p pVarB = h8.p.b(pVar.f(), pVar.d(), pVar.h(), h8.p.b.a(this.f8779j, aVar));
            this.f8770a.w("REPLACE INTO index_state (index_id, uid,  sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id) VALUES(?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(pVar.f()), this.f8772c, Long.valueOf(this.f8779j), Long.valueOf(aVar.p().h().k()), Integer.valueOf(aVar.p().h().h()), f.c(aVar.n().s()), Integer.valueOf(aVar.o()));
            W(pVarB);
        }
    }

    @Override // g8.m
    public m.a k(e8.g1 g1Var) {
        m.a aVar = m.a.FULL;
        List<e8.g1> listM = M(g1Var);
        for (e8.g1 g1Var2 : listM) {
            h8.p pVarJ = J(g1Var2);
            if (pVarJ == null) {
                aVar = m.a.NONE;
                break;
            }
            if (pVarJ.h().size() < g1Var2.o()) {
                aVar = m.a.PARTIAL;
            }
        }
        return (g1Var.r() && listM.size() > 1 && aVar == m.a.FULL) ? m.a.PARTIAL : aVar;
    }

    @Override // g8.m
    public h8.p.a l(String str) {
        Collection<h8.p> collectionK = K(str);
        l8.b.d(!collectionK.isEmpty(), "minOffset was called for collection without indexes", new Object[0]);
        return L(collectionK);
    }

    @Override // g8.m
    public h8.p.a m(e8.g1 g1Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<e8.g1> it = M(g1Var).iterator();
        while (it.hasNext()) {
            h8.p pVarJ = J(it.next());
            if (pVarJ != null) {
                arrayList.add(pVarJ);
            }
        }
        return L(arrayList);
    }

    @Override // g8.m
    public void n(h8.p pVar) {
        l8.b.d(this.f8777h, "IndexManager not started", new Object[0]);
        int i10 = this.f8778i + 1;
        h8.p pVarB = h8.p.b(i10, pVar.d(), pVar.h(), pVar.g());
        this.f8770a.w("INSERT INTO index_configuration (index_id, collection_group, index_proto) VALUES(?, ?, ?)", Integer.valueOf(i10), pVarB.d(), B(pVarB));
        W(pVarB);
    }

    @Override // g8.m
    public void start() {
        final HashMap map = new HashMap();
        this.f8770a.F("SELECT index_id, sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id FROM index_state WHERE uid = ?").b(this.f8772c).e(new l8.n() { // from class: g8.g2
            @Override // l8.n
            public final void accept(Object obj) {
                i2.S(map, (Cursor) obj);
            }
        });
        this.f8770a.F("SELECT index_id, collection_group, index_proto FROM index_configuration").e(new l8.n() { // from class: g8.h2
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8758a.T(map, (Cursor) obj);
            }
        });
        this.f8777h = true;
    }

    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final void U(h8.h hVar, f8.e eVar) {
        this.f8770a.w("INSERT INTO index_entries (index_id, uid, array_value, directional_value, document_key) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(eVar.n()), this.f8772c, eVar.i(), eVar.k(), hVar.getKey().toString());
    }

    public final SortedSet<f8.e> x(h8.h hVar, h8.p pVar) {
        TreeSet treeSet = new TreeSet();
        byte[] bArrA = A(pVar, hVar);
        if (bArrA == null) {
            return treeSet;
        }
        h8.p.c cVarC = pVar.c();
        if (cVarC != null) {
            d9.d0 d0VarL = hVar.l(cVarC.i());
            if (h8.y.u(d0VarL)) {
                Iterator<d9.d0> it = d0VarL.p0().m().iterator();
                while (it.hasNext()) {
                    treeSet.add(f8.e.h(pVar.f(), hVar.getKey(), C(it.next()), bArrA));
                }
            }
        } else {
            treeSet.add(f8.e.h(pVar.f(), hVar.getKey(), new byte[0], bArrA));
        }
        return treeSet;
    }

    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final void V(h8.h hVar, f8.e eVar) {
        this.f8770a.w("DELETE FROM index_entries WHERE index_id = ? AND uid = ? AND array_value = ? AND directional_value = ? AND document_key = ?", Integer.valueOf(eVar.n()), this.f8772c, eVar.i(), eVar.k(), hVar.getKey().toString());
    }

    public final Object[] z(h8.p pVar, e8.g1 g1Var, e8.i iVar) {
        return D(pVar, g1Var, iVar.b());
    }
}
