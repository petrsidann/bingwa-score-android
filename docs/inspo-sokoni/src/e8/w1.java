package e8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f7348a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h8.m f7351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s7.e<h8.k> f7352e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y1.a f7349b = y1.a.NONE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s7.e<h8.k> f7353f = h8.k.k();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s7.e<h8.k> f7354g = h8.k.k();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7355a;

        static {
            int[] iArr = new int[m.a.values().length];
            f7355a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7355a[m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7355a[m.a.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7355a[m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h8.m f7356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f7357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s7.e<h8.k> f7359d;

        public b(h8.m mVar, n nVar, s7.e<h8.k> eVar, boolean z10) {
            this.f7356a = mVar;
            this.f7357b = nVar;
            this.f7359d = eVar;
            this.f7358c = z10;
        }

        public /* synthetic */ b(h8.m mVar, n nVar, s7.e eVar, boolean z10, a aVar) {
            this(mVar, nVar, eVar, z10);
        }

        public boolean b() {
            return this.f7358c;
        }
    }

    public w1(b1 b1Var, s7.e<h8.k> eVar) {
        this.f7348a = b1Var;
        this.f7351d = h8.m.i(b1Var.c());
        this.f7352e = eVar;
    }

    public static int g(m mVar) {
        int i10 = a.f7355a[mVar.c().ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 3) {
                if (i10 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + mVar.c());
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int l(m mVar, m mVar2) {
        int iL = l8.g0.l(g(mVar), g(mVar2));
        return iL != 0 ? iL : this.f7348a.c().compare(mVar.b(), mVar2.b());
    }

    public x1 b(b bVar) {
        return c(bVar, null);
    }

    public x1 c(b bVar, k8.v0 v0Var) {
        return d(bVar, v0Var, false);
    }

    public x1 d(b bVar, k8.v0 v0Var, boolean z10) {
        y1 y1Var;
        l8.b.d(!bVar.f7358c, "Cannot apply changes that need a refill", new Object[0]);
        h8.m mVar = this.f7351d;
        this.f7351d = bVar.f7356a;
        this.f7354g = bVar.f7359d;
        List<m> listB = bVar.f7357b.b();
        Collections.sort(listB, new Comparator() { // from class: e8.v1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f7343a.l((m) obj, (m) obj2);
            }
        });
        f(v0Var);
        List<v0> listEmptyList = z10 ? Collections.emptyList() : o();
        y1.a aVar = this.f7353f.size() == 0 && this.f7350c && !z10 ? y1.a.SYNCED : y1.a.LOCAL;
        boolean z11 = aVar != this.f7349b;
        this.f7349b = aVar;
        if (listB.size() != 0 || z11) {
            y1Var = new y1(this.f7348a, bVar.f7356a, mVar, listB, aVar == y1.a.LOCAL, bVar.f7359d, z11, false, (v0Var == null || v0Var.e().isEmpty()) ? false : true);
        } else {
            y1Var = null;
        }
        return new x1(y1Var, listEmptyList);
    }

    public x1 e(z0 z0Var) {
        if (!this.f7350c || z0Var != z0.OFFLINE) {
            return new x1(null, Collections.emptyList());
        }
        this.f7350c = false;
        return b(new b(this.f7351d, new n(), this.f7354g, false, null));
    }

    public final void f(k8.v0 v0Var) {
        if (v0Var != null) {
            Iterator<h8.k> it = v0Var.b().iterator();
            while (it.hasNext()) {
                this.f7352e = this.f7352e.i(it.next());
            }
            for (h8.k kVar : v0Var.c()) {
                l8.b.d(this.f7352e.contains(kVar), "Modified document %s not found in view.", kVar);
            }
            Iterator<h8.k> it2 = v0Var.d().iterator();
            while (it2.hasNext()) {
                this.f7352e = this.f7352e.k(it2.next());
            }
            this.f7350c = v0Var.f();
        }
    }

    public b h(s7.c<h8.k, h8.h> cVar) {
        return i(cVar, null);
    }

    /* JADX WARN: Code duplicated, block: B:73:0x012c A[PHI: r17
  0x012c: PHI (r17v5 h8.m) = (r17v0 h8.m), (r17v0 h8.m), (r17v6 h8.m), (r17v6 h8.m) binds: [B:71:0x0128, B:72:0x012a, B:58:0x0102, B:55:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    public b i(s7.c<h8.k, h8.h> cVar, b bVar) {
        h8.m mVar;
        m.a aVar;
        boolean z10;
        s7.e<h8.k> eVarK;
        n nVar = bVar != null ? bVar.f7357b : new n();
        h8.m mVar2 = bVar != null ? bVar.f7356a : this.f7351d;
        s7.e<h8.k> eVarK2 = bVar != null ? bVar.f7359d : this.f7354g;
        h8.h hVarL = (this.f7348a.l().equals(b1.a.LIMIT_TO_FIRST) && ((long) mVar2.size()) == this.f7348a.k()) ? mVar2.l() : null;
        h8.h hVarK = (this.f7348a.l().equals(b1.a.LIMIT_TO_LAST) && ((long) mVar2.size()) == this.f7348a.k()) ? mVar2.k() : null;
        h8.m mVarQ = mVar2;
        boolean z11 = false;
        for (Map.Entry<h8.k, h8.h> entry : cVar) {
            h8.k key = entry.getKey();
            h8.h hVarJ = mVar2.j(key);
            h8.h value = this.f7348a.u(entry.getValue()) ? entry.getValue() : null;
            boolean z12 = hVarJ != null && this.f7354g.contains(hVarJ.getKey());
            boolean z13 = value != null && (value.e() || (this.f7354g.contains(value.getKey()) && value.d()));
            if (hVarJ == null || value == null) {
                mVar = mVar2;
                if (hVarJ == null && value != null) {
                    aVar = m.a.ADDED;
                    nVar.a(m.a(aVar, value));
                } else if (hVarJ == null || value != null) {
                    z10 = false;
                } else {
                    nVar.a(m.a(m.a.REMOVED, hVarJ));
                    if (hVarL != null || hVarK != null) {
                        z11 = true;
                    }
                }
                z10 = true;
            } else {
                mVar = mVar2;
                if (hVarJ.a().equals(value.a())) {
                    if (z12 != z13) {
                        aVar = m.a.METADATA;
                        nVar.a(m.a(aVar, value));
                        z10 = true;
                    }
                } else if (!n(hVarJ, value)) {
                    nVar.a(m.a(m.a.MODIFIED, value));
                    if ((hVarL != null && this.f7348a.c().compare(value, hVarL) > 0) || (hVarK != null && this.f7348a.c().compare(value, hVarK) < 0)) {
                        z11 = true;
                    }
                    z10 = true;
                }
                z10 = false;
            }
            if (z10) {
                if (value != null) {
                    mVarQ = mVarQ.h(value);
                    eVarK = value.e() ? eVarK2.i(value.getKey()) : eVarK2.k(value.getKey());
                } else {
                    mVarQ = mVarQ.q(key);
                    eVarK = eVarK2.k(key);
                }
                eVarK2 = eVarK;
            }
            mVar2 = mVar;
        }
        if (this.f7348a.p()) {
            long size = mVarQ.size();
            long jK = this.f7348a.k();
            while (true) {
                size -= jK;
                if (size <= 0) {
                    break;
                }
                h8.h hVarL2 = this.f7348a.l().equals(b1.a.LIMIT_TO_FIRST) ? mVarQ.l() : mVarQ.k();
                mVarQ = mVarQ.q(hVarL2.getKey());
                eVarK2 = eVarK2.k(hVarL2.getKey());
                nVar.a(m.a(m.a.REMOVED, hVarL2));
                jK = 1;
            }
        }
        s7.e<h8.k> eVar = eVarK2;
        h8.m mVar3 = mVarQ;
        l8.b.d(!z11 || bVar == null, "View was refilled using docs that themselves needed refilling.", new Object[0]);
        return new b(mVar3, nVar, eVar, z11, null);
    }

    public y1.a j() {
        return this.f7349b;
    }

    public s7.e<h8.k> k() {
        return this.f7352e;
    }

    public final boolean m(h8.k kVar) {
        h8.h hVarJ;
        return (this.f7352e.contains(kVar) || (hVarJ = this.f7351d.j(kVar)) == null || hVarJ.e()) ? false : true;
    }

    public final boolean n(h8.h hVar, h8.h hVar2) {
        return hVar.e() && hVar2.d() && !hVar2.e();
    }

    public final List<v0> o() {
        if (!this.f7350c) {
            return Collections.emptyList();
        }
        s7.e<h8.k> eVar = this.f7353f;
        this.f7353f = h8.k.k();
        for (h8.h hVar : this.f7351d) {
            if (m(hVar.getKey())) {
                this.f7353f = this.f7353f.i(hVar.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(eVar.size() + this.f7353f.size());
        for (h8.k kVar : eVar) {
            if (!this.f7353f.contains(kVar)) {
                arrayList.add(new v0(v0.a.REMOVED, kVar));
            }
        }
        for (h8.k kVar2 : this.f7353f) {
            if (!eVar.contains(kVar2)) {
                arrayList.add(new v0(v0.a.ADDED, kVar2));
            }
        }
        return arrayList;
    }
}
