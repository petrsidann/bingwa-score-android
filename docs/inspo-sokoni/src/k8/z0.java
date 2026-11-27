package k8;

import e8.g1;
import g8.k1;
import g8.n4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, w0> f11882b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<h8.k, h8.r> f11883c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<h8.k, Set<Integer>> f11884d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, k1> f11885e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h8.f f11886f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11887a;

        static {
            int[] iArr = new int[y0.e.values().length];
            f11887a = iArr;
            try {
                iArr[y0.e.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11887a[y0.e.Added.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11887a[y0.e.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11887a[y0.e.Current.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11887a[y0.e.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        SUCCESS,
        SKIPPED,
        FALSE_POSITIVE
    }

    public interface c {
        n4 a(int i10);

        s7.e<h8.k> b(int i10);
    }

    public z0(h8.f fVar, c cVar) {
        this.f11886f = fVar;
        this.f11881a = cVar;
    }

    public final void a(int i10, h8.r rVar) {
        if (l(i10)) {
            e(i10).a(rVar.getKey(), s(i10, rVar.getKey()) ? e8.m.a.MODIFIED : e8.m.a.ADDED);
            this.f11883c.put(rVar.getKey(), rVar);
            d(rVar.getKey()).add(Integer.valueOf(i10));
        }
    }

    public final b b(m mVar, y0.c cVar, int i10) {
        return cVar.a().a() == i10 - f(mVar, cVar.b()) ? b.SUCCESS : b.FALSE_POSITIVE;
    }

    public n0 c(h8.v vVar) {
        boolean z10;
        HashMap map = new HashMap();
        for (Map.Entry<Integer, w0> entry : this.f11882b.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            w0 value = entry.getValue();
            n4 n4VarN = n(iIntValue);
            if (n4VarN != null) {
                if (value.d() && n4VarN.g().s()) {
                    h8.k kVarN = h8.k.n(n4VarN.g().n());
                    if (this.f11883c.get(kVarN) == null && !s(iIntValue, kVarN)) {
                        p(iIntValue, kVarN, h8.r.t(kVarN, vVar));
                    }
                }
                if (value.c()) {
                    map.put(Integer.valueOf(iIntValue), value.j());
                    value.b();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<h8.k, Set<Integer>> entry2 : this.f11884d.entrySet()) {
            h8.k key = entry2.getKey();
            Iterator<Integer> it = entry2.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    break;
                }
                n4 n4VarN2 = n(it.next().intValue());
                if (n4VarN2 != null && !n4VarN2.c().equals(k1.LIMBO_RESOLUTION)) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                hashSet.add(key);
            }
        }
        Iterator<h8.r> it2 = this.f11883c.values().iterator();
        while (it2.hasNext()) {
            it2.next().x(vVar);
        }
        n0 n0Var = new n0(vVar, Collections.unmodifiableMap(map), Collections.unmodifiableMap(this.f11885e), Collections.unmodifiableMap(this.f11883c), Collections.unmodifiableSet(hashSet));
        this.f11883c = new HashMap();
        this.f11884d = new HashMap();
        this.f11885e = new HashMap();
        return n0Var;
    }

    public final Set<Integer> d(h8.k kVar) {
        Set<Integer> set = this.f11884d.get(kVar);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f11884d.put(kVar, hashSet);
        return hashSet;
    }

    public final w0 e(int i10) {
        w0 w0Var = this.f11882b.get(Integer.valueOf(i10));
        if (w0Var != null) {
            return w0Var;
        }
        w0 w0Var2 = new w0();
        this.f11882b.put(Integer.valueOf(i10), w0Var2);
        return w0Var2;
    }

    public final int f(m mVar, int i10) {
        s7.e<h8.k> eVarB = this.f11881a.b(i10);
        String str = "projects/" + this.f11886f.l() + "/databases/" + this.f11886f.k() + "/documents/";
        int i11 = 0;
        for (h8.k kVar : eVarB) {
            if (!mVar.h(str + kVar.s().i())) {
                p(i10, kVar, null);
                i11++;
            }
        }
        return i11;
    }

    public final int g(int i10) {
        v0 v0VarJ = e(i10).j();
        return (this.f11881a.b(i10).size() + v0VarJ.b().size()) - v0VarJ.d().size();
    }

    public final Collection<Integer> h(y0.d dVar) {
        List<Integer> listD = dVar.d();
        if (!listD.isEmpty()) {
            return listD;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.f11882b.keySet()) {
            if (l(num.intValue())) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    public void i(y0.b bVar) {
        h8.r rVarB = bVar.b();
        h8.k kVarA = bVar.a();
        Iterator<Integer> it = bVar.d().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (rVarB == null || !rVarB.c()) {
                p(iIntValue, kVarA, rVarB);
            } else {
                a(iIntValue, rVarB);
            }
        }
        Iterator<Integer> it2 = bVar.c().iterator();
        while (it2.hasNext()) {
            p(it2.next().intValue(), kVarA, bVar.b());
        }
    }

    public void j(y0.c cVar) {
        int iB = cVar.b();
        int iA = cVar.a().a();
        n4 n4VarN = n(iB);
        if (n4VarN != null) {
            g1 g1VarG = n4VarN.g();
            if (g1VarG.s()) {
                if (iA != 0) {
                    l8.b.d(iA == 1, "Single document existence filter with count: %d", Integer.valueOf(iA));
                    return;
                } else {
                    h8.k kVarN = h8.k.n(g1VarG.n());
                    p(iB, kVarN, h8.r.t(kVarN, h8.v.f9777b));
                    return;
                }
            }
            int iG = g(iB);
            if (iG != iA) {
                m mVarM = m(cVar);
                b bVarB = mVarM != null ? b(mVarM, cVar, iG) : b.SKIPPED;
                if (bVarB != b.SUCCESS) {
                    r(iB);
                    this.f11885e.put(Integer.valueOf(iB), bVarB == b.FALSE_POSITIVE ? k1.EXISTENCE_FILTER_MISMATCH_BLOOM : k1.EXISTENCE_FILTER_MISMATCH);
                }
                x0.a().b(x0.b.e(iG, cVar.a(), this.f11886f, mVarM, bVarB));
            }
        }
    }

    public void k(y0.d dVar) {
        Iterator<Integer> it = h(dVar).iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            w0 w0VarE = e(iIntValue);
            int i10 = a.f11887a[dVar.b().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    w0VarE.h();
                    if (!w0VarE.e()) {
                        w0VarE.b();
                    }
                } else if (i10 == 3) {
                    w0VarE.h();
                    if (!w0VarE.e()) {
                        q(iIntValue);
                    }
                    l8.b.d(dVar.a() == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                } else if (i10 != 4) {
                    if (i10 != 5) {
                        throw l8.b.a("Unknown target watch change state: %s", dVar.b());
                    }
                    if (l(iIntValue)) {
                        r(iIntValue);
                    }
                } else if (l(iIntValue)) {
                    w0VarE.f();
                }
                w0VarE.k(dVar.c());
            } else if (l(iIntValue)) {
                w0VarE.k(dVar.c());
            }
        }
    }

    public final boolean l(int i10) {
        return n(i10) != null;
    }

    public final m m(y0.c cVar) {
        d9.g gVarB = cVar.a().b();
        if (gVarB != null && gVarB.h0()) {
            try {
                m mVarA = m.a(gVarB.e0().e0(), gVarB.e0().g0(), gVarB.g0());
                if (mVarA.c() == 0) {
                    return null;
                }
                return mVarA;
            } catch (m.a e10) {
                l8.v.e("WatchChangeAggregator", "Applying bloom filter failed: (" + e10.getMessage() + "); ignoring the bloom filter and falling back to full re-query.", new Object[0]);
            }
        }
        return null;
    }

    public final n4 n(int i10) {
        w0 w0Var = this.f11882b.get(Integer.valueOf(i10));
        if (w0Var == null || !w0Var.e()) {
            return this.f11881a.a(i10);
        }
        return null;
    }

    public void o(int i10) {
        e(i10).g();
    }

    public final void p(int i10, h8.k kVar, h8.r rVar) {
        if (l(i10)) {
            w0 w0VarE = e(i10);
            if (s(i10, kVar)) {
                w0VarE.a(kVar, e8.m.a.REMOVED);
            } else {
                w0VarE.i(kVar);
            }
            d(kVar).add(Integer.valueOf(i10));
            if (rVar != null) {
                this.f11883c.put(kVar, rVar);
            }
        }
    }

    public void q(int i10) {
        this.f11882b.remove(Integer.valueOf(i10));
    }

    public final void r(int i10) {
        l8.b.d((this.f11882b.get(Integer.valueOf(i10)) == null || this.f11882b.get(Integer.valueOf(i10)).e()) ? false : true, "Should only reset active targets", new Object[0]);
        this.f11882b.put(Integer.valueOf(i10), new w0());
        Iterator<h8.k> it = this.f11881a.b(i10).iterator();
        while (it.hasNext()) {
            p(i10, it.next(), null);
        }
    }

    public final boolean s(int i10, h8.k kVar) {
        return this.f11881a.b(i10).contains(kVar);
    }
}
