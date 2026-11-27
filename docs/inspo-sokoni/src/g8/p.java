package g8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k8.o0 f8898a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8900b;

        static {
            int[] iArr = new int[j8.c.EnumC0188c.values().length];
            f8900b = iArr;
            try {
                iArr[j8.c.EnumC0188c.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8900b[j8.c.EnumC0188c.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[j8.a.c.values().length];
            f8899a = iArr2;
            try {
                iArr2[j8.a.c.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8899a[j8.a.c.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8899a[j8.a.c.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public p(k8.o0 o0Var) {
        this.f8898a = o0Var;
    }

    public d8.i a(c9.a aVar) {
        return new d8.i(this.f8898a.u(aVar.i0(), aVar.j0()), aVar.h0().equals(c9.a.c.FIRST) ? e8.b1.a.LIMIT_TO_FIRST : e8.b1.a.LIMIT_TO_LAST);
    }

    public final h8.r b(d9.k kVar, boolean z10) {
        h8.r rVarR = h8.r.r(this.f8898a.l(kVar.k0()), this.f8898a.y(kVar.l0()), h8.s.h(kVar.i0()));
        return z10 ? rVarR.v() : rVarR;
    }

    public List<h8.p.c> c(b9.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (b9.a.c cVar : aVar.i0()) {
            arrayList.add(h8.p.c.h(h8.q.z(cVar.h0()), cVar.j0().equals(b9.a.c.d.ARRAY_CONFIG) ? h8.p.c.a.CONTAINS : cVar.i0().equals(b9.a.c.EnumC0050c.ASCENDING) ? h8.p.c.a.ASCENDING : h8.p.c.a.DESCENDING));
        }
        return arrayList;
    }

    public h8.r d(j8.a aVar) {
        int i10 = a.f8899a[aVar.j0().ordinal()];
        if (i10 == 1) {
            return b(aVar.i0(), aVar.k0());
        }
        if (i10 == 2) {
            return g(aVar.l0(), aVar.k0());
        }
        if (i10 == 3) {
            return i(aVar.m0());
        }
        throw l8.b.a("Unknown MaybeDocument %s", aVar);
    }

    public i8.f e(d9.e0 e0Var) {
        return this.f8898a.o(e0Var);
    }

    public i8.g f(j8.e eVar) {
        int iO0 = eVar.o0();
        h7.q qVarW = this.f8898a.w(eVar.p0());
        int iN0 = eVar.n0();
        ArrayList arrayList = new ArrayList(iN0);
        for (int i10 = 0; i10 < iN0; i10++) {
            arrayList.add(this.f8898a.o(eVar.m0(i10)));
        }
        ArrayList arrayList2 = new ArrayList(eVar.r0());
        int i11 = 0;
        while (i11 < eVar.r0()) {
            d9.e0 e0VarQ0 = eVar.q0(i11);
            int i12 = i11 + 1;
            if (i12 < eVar.r0() && eVar.q0(i12).v0()) {
                l8.b.d(eVar.q0(i11).w0(), "TransformMutation should be preceded by a patch or set mutation", new Object[0]);
                d9.e0.b bVarZ0 = d9.e0.z0(e0VarQ0);
                Iterator<d9.p.c> it = eVar.q0(i12).p0().f0().iterator();
                while (it.hasNext()) {
                    bVarZ0.E(it.next());
                }
                arrayList2.add(this.f8898a.o(bVarZ0.build()));
                i11 = i12;
            } else {
                arrayList2.add(this.f8898a.o(e0VarQ0));
            }
            i11++;
        }
        return new i8.g(iO0, qVarW, arrayList, arrayList2);
    }

    public final h8.r g(j8.b bVar, boolean z10) {
        h8.r rVarT = h8.r.t(this.f8898a.l(bVar.h0()), this.f8898a.y(bVar.i0()));
        return z10 ? rVarT.v() : rVarT;
    }

    public n4 h(j8.c cVar) {
        e8.g1 g1VarE;
        int iT0 = cVar.t0();
        h8.v vVarY = this.f8898a.y(cVar.s0());
        h8.v vVarY2 = this.f8898a.y(cVar.o0());
        com.google.protobuf.i iVarR0 = cVar.r0();
        long jP0 = cVar.p0();
        int i10 = a.f8900b[cVar.u0().ordinal()];
        if (i10 == 1) {
            g1VarE = this.f8898a.e(cVar.n0());
        } else {
            if (i10 != 2) {
                throw l8.b.a("Unknown targetType %d", cVar.u0());
            }
            g1VarE = this.f8898a.t(cVar.q0());
        }
        return new n4(g1VarE, iT0, jP0, k1.LISTEN, vVarY, vVarY2, iVarR0, null);
    }

    public final h8.r i(j8.d dVar) {
        return h8.r.u(this.f8898a.l(dVar.h0()), this.f8898a.y(dVar.i0()));
    }

    public c9.a j(d8.i iVar) {
        d9.a0.d dVarS = this.f8898a.S(iVar.b());
        c9.a.b bVarK0 = c9.a.k0();
        bVarK0.E(iVar.a().equals(e8.b1.a.LIMIT_TO_FIRST) ? c9.a.c.FIRST : c9.a.c.LAST);
        bVarK0.F(dVarS.h0());
        bVarK0.H(dVarS.i0());
        return bVarK0.build();
    }

    public final d9.k k(h8.h hVar) {
        d9.k.b bVarO0 = d9.k.o0();
        bVarO0.F(this.f8898a.L(hVar.getKey()));
        bVarO0.E(hVar.a().l());
        bVarO0.H(this.f8898a.W(hVar.m().h()));
        return bVarO0.build();
    }

    public b9.a l(List<h8.p.c> list) {
        b9.a.b bVarJ0 = b9.a.j0();
        bVarJ0.F(b9.a.d.COLLECTION_GROUP);
        for (h8.p.c cVar : list) {
            b9.a.c.b bVarK0 = b9.a.c.k0();
            bVarK0.F(cVar.i().i());
            if (cVar.k() == h8.p.c.a.CONTAINS) {
                bVarK0.E(b9.a.c.EnumC0048a.CONTAINS);
            } else {
                bVarK0.H(cVar.k() == h8.p.c.a.ASCENDING ? b9.a.c.EnumC0050c.ASCENDING : b9.a.c.EnumC0050c.DESCENDING);
            }
            bVarJ0.E(bVarK0);
        }
        return bVarJ0.build();
    }

    public j8.a m(h8.h hVar) {
        j8.a.b bVarN0 = j8.a.n0();
        if (hVar.j()) {
            bVarN0.H(p(hVar));
        } else if (hVar.c()) {
            bVarN0.E(k(hVar));
        } else {
            if (!hVar.k()) {
                throw l8.b.a("Cannot encode invalid document %s", hVar);
            }
            bVarN0.I(r(hVar));
        }
        bVarN0.F(hVar.d());
        return bVarN0.build();
    }

    public d9.e0 n(i8.f fVar) {
        return this.f8898a.O(fVar);
    }

    public j8.e o(i8.g gVar) {
        j8.e.b bVarS0 = j8.e.s0();
        bVarS0.H(gVar.e());
        bVarS0.I(this.f8898a.W(gVar.g()));
        Iterator<i8.f> it = gVar.d().iterator();
        while (it.hasNext()) {
            bVarS0.E(this.f8898a.O(it.next()));
        }
        Iterator<i8.f> it2 = gVar.h().iterator();
        while (it2.hasNext()) {
            bVarS0.F(this.f8898a.O(it2.next()));
        }
        return bVarS0.build();
    }

    public final j8.b p(h8.h hVar) {
        j8.b.C0187b c0187bJ0 = j8.b.j0();
        c0187bJ0.E(this.f8898a.L(hVar.getKey()));
        c0187bJ0.F(this.f8898a.W(hVar.m().h()));
        return c0187bJ0.build();
    }

    public j8.c q(n4 n4Var) {
        k1 k1Var = k1.LISTEN;
        l8.b.d(k1Var.equals(n4Var.c()), "Only queries with purpose %s may be stored, got %s", k1Var, n4Var.c());
        j8.c.b bVarV0 = j8.c.v0();
        bVarV0.N(n4Var.h()).I(n4Var.e()).H(this.f8898a.Y(n4Var.b())).M(this.f8898a.Y(n4Var.f())).L(n4Var.d());
        e8.g1 g1VarG = n4Var.g();
        if (g1VarG.s()) {
            bVarV0.F(this.f8898a.F(g1VarG));
        } else {
            bVarV0.K(this.f8898a.S(g1VarG));
        }
        return bVarV0.build();
    }

    public final j8.d r(h8.h hVar) {
        j8.d.b bVarJ0 = j8.d.j0();
        bVarJ0.E(this.f8898a.L(hVar.getKey()));
        bVarJ0.F(this.f8898a.W(hVar.m().h()));
        return bVarJ0.build();
    }
}
