package g8;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements d8.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f8808o = TimeUnit.MINUTES.toSeconds(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f8809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f8811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e1 f8812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g8.b f8813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o1 f8814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f8815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j1 f8816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n1 f8817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m4 f8818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g8.a f8819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SparseArray<n4> f8820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<e8.g1, Integer> f8821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e8.h1 f8822n;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n4 f8823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8824b;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<h8.k, h8.r> f8825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<h8.k> f8826b;

        public c(Map<h8.k, h8.r> map, Set<h8.k> set) {
            this.f8825a = map;
            this.f8826b = set;
        }
    }

    public k0(h1 h1Var, j1 j1Var, c8.j jVar) {
        l8.b.d(h1Var.j(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.f8809a = h1Var;
        this.f8816h = j1Var;
        this.f8810b = h1Var.c();
        m4 m4VarI = h1Var.i();
        this.f8818j = m4VarI;
        this.f8819k = h1Var.a();
        this.f8822n = e8.h1.b(m4VarI.c());
        this.f8814f = h1Var.h();
        n1 n1Var = new n1();
        this.f8817i = n1Var;
        this.f8820l = new SparseArray<>();
        this.f8821m = new HashMap();
        h1Var.g().l(n1Var);
        O(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s7.c P(i8.h hVar) {
        i8.g gVarB = hVar.b();
        this.f8812d.f(gVarB, hVar.f());
        y(hVar);
        this.f8812d.a();
        this.f8813e.d(hVar.b().e());
        this.f8815g.o(F(hVar));
        return this.f8815g.d(gVarB.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(b bVar, e8.g1 g1Var) {
        int iC = this.f8822n.c();
        bVar.f8824b = iC;
        n4 n4Var = new n4(g1Var, iC, this.f8809a.g().h(), k1.LISTEN);
        bVar.f8823a = n4Var;
        this.f8818j.h(n4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s7.c R(s7.c cVar, n4 n4Var) {
        s7.e<h8.k> eVarK = h8.k.k();
        HashMap map = new HashMap();
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            h8.k kVar = (h8.k) entry.getKey();
            h8.r rVar = (h8.r) entry.getValue();
            if (rVar.c()) {
                eVarK = eVarK.i(kVar);
            }
            map.put(kVar, rVar);
        }
        this.f8818j.g(n4Var.h());
        this.f8818j.j(eVarK, n4Var.h());
        c cVarJ0 = j0(map);
        return this.f8815g.j(cVarJ0.f8825a, cVarJ0.f8826b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s7.c S(k8.n0 n0Var, h8.v vVar) {
        Map<Integer, k8.v0> mapD = n0Var.d();
        long jH = this.f8809a.g().h();
        for (Map.Entry<Integer, k8.v0> entry : mapD.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            k8.v0 value = entry.getValue();
            n4 n4Var = this.f8820l.get(iIntValue);
            if (n4Var != null) {
                this.f8818j.f(value.d(), iIntValue);
                this.f8818j.j(value.b(), iIntValue);
                n4 n4VarL = n4Var.l(jH);
                if (n0Var.e().containsKey(Integer.valueOf(iIntValue))) {
                    com.google.protobuf.i iVar = com.google.protobuf.i.f5753b;
                    h8.v vVar2 = h8.v.f9777b;
                    n4VarL = n4VarL.k(iVar, vVar2).j(vVar2);
                } else if (!value.e().isEmpty()) {
                    n4VarL = n4VarL.k(value.e(), n0Var.c());
                }
                this.f8820l.put(iIntValue, n4VarL);
                if (p0(n4Var, n4VarL, value)) {
                    this.f8818j.a(n4VarL);
                }
            }
        }
        Map<h8.k, h8.r> mapA = n0Var.a();
        Set<h8.k> setB = n0Var.b();
        for (h8.k kVar : mapA.keySet()) {
            if (setB.contains(kVar)) {
                this.f8809a.g().c(kVar);
            }
        }
        c cVarJ0 = j0(mapA);
        Map<h8.k, h8.r> map = cVarJ0.f8825a;
        h8.v vVarE = this.f8818j.e();
        if (!vVar.equals(h8.v.f9777b)) {
            l8.b.d(vVar.compareTo(vVarE) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", vVar, vVarE);
            this.f8818j.b(vVar);
        }
        return this.f8815g.j(map, cVarJ0.f8826b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ q0.c T(q0 q0Var) {
        return q0Var.f(this.f8820l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(List list) {
        Collection<h8.p> collectionF = this.f8811c.f();
        Comparator<h8.p> comparator = h8.p.f9750b;
        final m mVar = this.f8811c;
        Objects.requireNonNull(mVar);
        l8.n nVar = new l8.n() { // from class: g8.x
            @Override // l8.n
            public final void accept(Object obj) {
                mVar.n((h8.p) obj);
            }
        };
        final m mVar2 = this.f8811c;
        Objects.requireNonNull(mVar2);
        l8.g0.r(collectionF, list, comparator, nVar, new l8.n() { // from class: g8.y
            @Override // l8.n
            public final void accept(Object obj) {
                mVar2.c((h8.p) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f8811c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ d8.j W(String str) {
        return this.f8819k.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean X(d8.e eVar) {
        d8.e eVarA = this.f8819k.a(eVar.a());
        return Boolean.valueOf(eVarA != null && eVarA.b().compareTo(eVar.b()) >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l0 l0Var = (l0) it.next();
            int iD = l0Var.d();
            this.f8817i.b(l0Var.b(), iD);
            s7.e<h8.k> eVarC = l0Var.c();
            Iterator<h8.k> it2 = eVarC.iterator();
            while (it2.hasNext()) {
                this.f8809a.g().p(it2.next());
            }
            this.f8817i.g(eVarC, iD);
            if (!l0Var.e()) {
                n4 n4Var = this.f8820l.get(iD);
                l8.b.d(n4Var != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(iD));
                n4 n4VarJ = n4Var.j(n4Var.f());
                this.f8820l.put(iD, n4VarJ);
                if (p0(n4Var, n4VarJ, null)) {
                    this.f8818j.a(n4VarJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s7.c Z(int i10) {
        i8.g gVarI = this.f8812d.i(i10);
        l8.b.d(gVarI != null, "Attempt to reject nonexistent batch!", new Object[0]);
        this.f8812d.e(gVarI);
        this.f8812d.a();
        this.f8813e.d(i10);
        this.f8815g.o(gVarI.f());
        return this.f8815g.d(gVarI.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(int i10) {
        n4 n4Var = this.f8820l.get(i10);
        l8.b.d(n4Var != null, "Tried to release nonexistent target: %s", Integer.valueOf(i10));
        Iterator<h8.k> it = this.f8817i.h(i10).iterator();
        while (it.hasNext()) {
            this.f8809a.g().p(it.next());
        }
        this.f8809a.g().i(n4Var);
        this.f8820l.remove(i10);
        this.f8821m.remove(n4Var.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(d8.e eVar) {
        this.f8819k.b(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(d8.j jVar, n4 n4Var, int i10, s7.e eVar) {
        if (jVar.c().compareTo(n4Var.f()) > 0) {
            n4 n4VarK = n4Var.k(com.google.protobuf.i.f5753b, jVar.c());
            this.f8820l.append(i10, n4VarK);
            this.f8818j.a(n4VarK);
            this.f8818j.g(i10);
            this.f8818j.j(eVar, i10);
        }
        this.f8819k.d(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(com.google.protobuf.i iVar) {
        this.f8812d.d(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        this.f8811c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        this.f8812d.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n g0(Set set, List list, h7.q qVar) {
        Map<h8.k, h8.r> mapE = this.f8814f.e(set);
        HashSet hashSet = new HashSet();
        for (Map.Entry<h8.k, h8.r> entry : mapE.entrySet()) {
            if (!entry.getValue().q()) {
                hashSet.add(entry.getKey());
            }
        }
        Map<h8.k, g1> mapL = this.f8815g.l(mapE);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i8.f fVar = (i8.f) it.next();
            h8.s sVarD = fVar.d(mapL.get(fVar.g()).a());
            if (sVarD != null) {
                arrayList.add(new i8.l(fVar.g(), sVarD, sVarD.j(), i8.m.a(true)));
            }
        }
        i8.g gVarC = this.f8812d.c(qVar, arrayList, list);
        this.f8813e.e(gVarC.e(), gVarC.a(mapL, hashSet));
        return n.a(gVarC.e(), mapL);
    }

    public static e8.g1 h0(String str) {
        return e8.b1.b(h8.t.z("__bundle__/docs/" + str)).D();
    }

    public static boolean p0(n4 n4Var, n4 n4Var2, k8.v0 v0Var) {
        if (n4Var.d().isEmpty()) {
            return true;
        }
        long jK = n4Var2.f().h().k() - n4Var.f().h().k();
        long j10 = f8808o;
        if (jK < j10 && n4Var2.b().h().k() - n4Var.b().h().k() < j10) {
            return v0Var != null && (v0Var.b().size() + v0Var.c().size()) + v0Var.d().size() > 0;
        }
        return true;
    }

    public void A(final List<h8.p> list) {
        this.f8809a.l("Configure indexes", new Runnable() { // from class: g8.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8765a.U(list);
            }
        });
    }

    public void B() {
        this.f8809a.l("Delete All Indexes", new Runnable() { // from class: g8.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8711a.V();
            }
        });
    }

    public l1 C(e8.b1 b1Var, boolean z10) {
        s7.e<h8.k> eVarD;
        h8.v vVarB;
        n4 n4VarL = L(b1Var.D());
        h8.v vVar = h8.v.f9777b;
        s7.e<h8.k> eVarK = h8.k.k();
        if (n4VarL != null) {
            vVarB = n4VarL.b();
            eVarD = this.f8818j.d(n4VarL.h());
        } else {
            eVarD = eVarK;
            vVarB = vVar;
        }
        j1 j1Var = this.f8816h;
        if (z10) {
            vVar = vVarB;
        }
        return new l1(j1Var.e(b1Var, vVar, eVarD), eVarD);
    }

    public int D() {
        return this.f8812d.h();
    }

    public m E() {
        return this.f8811c;
    }

    public final Set<h8.k> F(i8.h hVar) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < hVar.e().size(); i10++) {
            if (!hVar.e().get(i10).a().isEmpty()) {
                hashSet.add(hVar.b().h().get(i10).g());
            }
        }
        return hashSet;
    }

    public h8.v G() {
        return this.f8818j.e();
    }

    public com.google.protobuf.i H() {
        return this.f8812d.j();
    }

    public o I() {
        return this.f8815g;
    }

    public d8.j J(final String str) {
        return (d8.j) this.f8809a.k("Get named query", new l8.y() { // from class: g8.u
            @Override // l8.y
            public final Object get() {
                return this.f8958a.W(str);
            }
        });
    }

    public i8.g K(int i10) {
        return this.f8812d.g(i10);
    }

    public n4 L(e8.g1 g1Var) {
        Integer num = this.f8821m.get(g1Var);
        return num != null ? this.f8820l.get(num.intValue()) : this.f8818j.i(g1Var);
    }

    public s7.c<h8.k, h8.h> M(c8.j jVar) {
        List<i8.g> listK = this.f8812d.k();
        O(jVar);
        r0();
        s0();
        List<i8.g> listK2 = this.f8812d.k();
        s7.e<h8.k> eVarK = h8.k.k();
        Iterator it = Arrays.asList(listK, listK2).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                Iterator<i8.f> it3 = ((i8.g) it2.next()).h().iterator();
                while (it3.hasNext()) {
                    eVarK = eVarK.i(it3.next().g());
                }
            }
        }
        return this.f8815g.d(eVarK);
    }

    public boolean N(final d8.e eVar) {
        return ((Boolean) this.f8809a.k("Has newer bundle", new l8.y() { // from class: g8.t
            @Override // l8.y
            public final Object get() {
                return this.f8948a.X(eVar);
            }
        })).booleanValue();
    }

    public final void O(c8.j jVar) {
        m mVarD = this.f8809a.d(jVar);
        this.f8811c = mVarD;
        this.f8812d = this.f8809a.e(jVar, mVarD);
        g8.b bVarB = this.f8809a.b(jVar);
        this.f8813e = bVarB;
        this.f8815g = new o(this.f8814f, this.f8812d, bVarB, this.f8811c);
        this.f8814f.b(this.f8811c);
        this.f8816h.f(this.f8815g, this.f8811c);
    }

    @Override // d8.a
    public void a(final d8.e eVar) {
        this.f8809a.l("Save bundle", new Runnable() { // from class: g8.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8743a.b0(eVar);
            }
        });
    }

    @Override // d8.a
    public void b(final d8.j jVar, final s7.e<h8.k> eVar) {
        final n4 n4VarW = w(jVar.a().b());
        final int iH = n4VarW.h();
        this.f8809a.l("Saved named query", new Runnable() { // from class: g8.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f8931a.c0(jVar, n4VarW, iH, eVar);
            }
        });
    }

    @Override // d8.a
    public s7.c<h8.k, h8.h> c(final s7.c<h8.k, h8.r> cVar, String str) {
        final n4 n4VarW = w(h0(str));
        return (s7.c) this.f8809a.k("Apply bundle documents", new l8.y() { // from class: g8.d0
            @Override // l8.y
            public final Object get() {
                return this.f8695a.R(cVar, n4VarW);
            }
        });
    }

    public void i0(final List<l0> list) {
        this.f8809a.l("notifyLocalViewChanges", new Runnable() { // from class: g8.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8736a.Y(list);
            }
        });
    }

    public final c j0(Map<h8.k, h8.r> map) {
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<h8.k, h8.r> mapE = this.f8814f.e(map.keySet());
        for (Map.Entry<h8.k, h8.r> entry : map.entrySet()) {
            h8.k key = entry.getKey();
            h8.r value = entry.getValue();
            h8.r rVar = mapE.get(key);
            if (value.c() != rVar.c()) {
                hashSet.add(key);
            }
            if (value.j() && value.m().equals(h8.v.f9777b)) {
                arrayList.add(value.getKey());
            } else if (!rVar.q() || value.m().compareTo(rVar.m()) > 0 || (value.m().compareTo(rVar.m()) == 0 && rVar.f())) {
                l8.b.d(!h8.v.f9777b.equals(value.g()), "Cannot add a document when the remote version is zero", new Object[0]);
                this.f8814f.d(value, value.g());
            } else {
                l8.v.a("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, rVar.m(), value.m());
            }
            map2.put(key, value);
        }
        this.f8814f.removeAll(arrayList);
        return new c(map2, hashSet);
    }

    public h8.h k0(h8.k kVar) {
        return this.f8815g.c(kVar);
    }

    public s7.c<h8.k, h8.h> l0(final int i10) {
        return (s7.c) this.f8809a.k("Reject batch", new l8.y() { // from class: g8.c0
            @Override // l8.y
            public final Object get() {
                return this.f8685a.Z(i10);
            }
        });
    }

    public void m0(final int i10) {
        this.f8809a.l("Release target", new Runnable() { // from class: g8.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f8969a.a0(i10);
            }
        });
    }

    public void n0(boolean z10) {
        this.f8816h.j(z10);
    }

    public void o0(final com.google.protobuf.i iVar) {
        this.f8809a.l("Set stream token", new Runnable() { // from class: g8.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f8942a.d0(iVar);
            }
        });
    }

    public void q0() {
        this.f8809a.f().run();
        r0();
        s0();
    }

    public final void r0() {
        this.f8809a.l("Start IndexManager", new Runnable() { // from class: g8.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f8906a.e0();
            }
        });
    }

    public final void s0() {
        this.f8809a.l("Start MutationQueue", new Runnable() { // from class: g8.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8672a.f0();
            }
        });
    }

    public n t0(final List<i8.f> list) {
        final h7.q qVarN = h7.q.n();
        final HashSet hashSet = new HashSet();
        Iterator<i8.f> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().g());
        }
        return (n) this.f8809a.k("Locally write mutations", new l8.y() { // from class: g8.j0
            @Override // l8.y
            public final Object get() {
                return this.f8789a.g0(hashSet, list, qVarN);
            }
        });
    }

    public s7.c<h8.k, h8.h> v(final i8.h hVar) {
        return (s7.c) this.f8809a.k("Acknowledge batch", new l8.y() { // from class: g8.z
            @Override // l8.y
            public final Object get() {
                return this.f9019a.P(hVar);
            }
        });
    }

    public n4 w(final e8.g1 g1Var) {
        int iH;
        n4 n4VarI = this.f8818j.i(g1Var);
        if (n4VarI != null) {
            iH = n4VarI.h();
        } else {
            final b bVar = new b();
            this.f8809a.l("Allocate target", new Runnable() { // from class: g8.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8979a.Q(bVar, g1Var);
                }
            });
            iH = bVar.f8824b;
            n4VarI = bVar.f8823a;
        }
        if (this.f8820l.get(iH) == null) {
            this.f8820l.put(iH, n4VarI);
            this.f8821m.put(g1Var, Integer.valueOf(iH));
        }
        return n4VarI;
    }

    public s7.c<h8.k, h8.h> x(final k8.n0 n0Var) {
        final h8.v vVarC = n0Var.c();
        return (s7.c) this.f8809a.k("Apply remote event", new l8.y() { // from class: g8.a0
            @Override // l8.y
            public final Object get() {
                return this.f8667a.S(n0Var, vVarC);
            }
        });
    }

    public final void y(i8.h hVar) {
        i8.g gVarB = hVar.b();
        for (h8.k kVar : gVarB.f()) {
            h8.r rVarA = this.f8814f.a(kVar);
            h8.v vVarH = hVar.d().h(kVar);
            l8.b.d(vVarH != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (rVarA.m().compareTo(vVarH) < 0) {
                gVarB.c(rVarA, hVar);
                if (rVarA.q()) {
                    this.f8814f.d(rVarA, hVar.c());
                }
            }
        }
        this.f8812d.e(gVarB);
    }

    public q0.c z(final q0 q0Var) {
        return (q0.c) this.f8809a.k("Collect garbage", new l8.y() { // from class: g8.h0
            @Override // l8.y
            public final Object get() {
                return this.f8754a.T(q0Var);
            }
        });
    }
}
