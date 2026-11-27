package k8;

import com.google.protobuf.u1;
import e8.g1;
import g8.k1;
import g8.n4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.f f11755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11756b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f11759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f11760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f11761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f11762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f11763g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f11764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int[] f11765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int[] f11766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int[] f11767k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ int[] f11768l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ int[] f11769m;

        static {
            int[] iArr = new int[d9.t.c.values().length];
            f11769m = iArr;
            try {
                iArr[d9.t.c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11769m[d9.t.c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11769m[d9.t.c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11769m[d9.t.c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11769m[d9.t.c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11769m[d9.t.c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[d9.b0.c.values().length];
            f11768l = iArr2;
            try {
                iArr2[d9.b0.c.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11768l[d9.b0.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11768l[d9.b0.c.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11768l[d9.b0.c.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11768l[d9.b0.c.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11768l[d9.b0.c.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[d9.z.e.values().length];
            f11767k = iArr3;
            try {
                iArr3[d9.z.e.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11767k[d9.z.e.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[d9.z.f.b.values().length];
            f11766j = iArr4;
            try {
                iArr4[d9.z.f.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11766j[d9.z.f.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11766j[d9.z.f.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11766j[d9.z.f.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f11766j[d9.z.f.b.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11766j[d9.z.f.b.GREATER_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f11766j[d9.z.f.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f11766j[d9.z.f.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f11766j[d9.z.f.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f11766j[d9.z.f.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr5 = new int[e8.p.b.values().length];
            f11765i = iArr5;
            try {
                iArr5[e8.p.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f11765i[e8.p.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f11765i[e8.p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f11765i[e8.p.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f11765i[e8.p.b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f11765i[e8.p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f11765i[e8.p.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f11765i[e8.p.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f11765i[e8.p.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f11765i[e8.p.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[d9.z.k.b.values().length];
            f11764h = iArr6;
            try {
                iArr6[d9.z.k.b.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f11764h[d9.z.k.b.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f11764h[d9.z.k.b.IS_NOT_NAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f11764h[d9.z.k.b.IS_NOT_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr7 = new int[d9.z.h.b.values().length];
            f11763g = iArr7;
            try {
                iArr7[d9.z.h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f11763g[d9.z.h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f11763g[d9.z.h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr8 = new int[d9.z.d.b.values().length];
            f11762f = iArr8;
            try {
                iArr8[d9.z.d.b.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f11762f[d9.z.d.b.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr9 = new int[e8.k.a.values().length];
            f11761e = iArr9;
            try {
                iArr9[e8.k.a.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f11761e[e8.k.a.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr10 = new int[k1.values().length];
            f11760d = iArr10;
            try {
                iArr10[k1.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f11760d[k1.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f11760d[k1.EXISTENCE_FILTER_MISMATCH_BLOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f11760d[k1.LIMBO_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr11 = new int[d9.p.c.EnumC0114c.values().length];
            f11759c = iArr11;
            try {
                iArr11[d9.p.c.EnumC0114c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f11759c[d9.p.c.EnumC0114c.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f11759c[d9.p.c.EnumC0114c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f11759c[d9.p.c.EnumC0114c.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused53) {
            }
            int[] iArr12 = new int[d9.v.c.values().length];
            f11758b = iArr12;
            try {
                iArr12[d9.v.c.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f11758b[d9.v.c.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f11758b[d9.v.c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            int[] iArr13 = new int[d9.e0.c.values().length];
            f11757a = iArr13;
            try {
                iArr13[d9.e0.c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f11757a[d9.e0.c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f11757a[d9.e0.c.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public o0(h8.f fVar) {
        this.f11755a = fVar;
        this.f11756b = Z(fVar).i();
    }

    public static h8.t Z(h8.f fVar) {
        return h8.t.y(Arrays.asList("projects", fVar.l(), "databases", fVar.k()));
    }

    public static h8.t a0(h8.t tVar) {
        l8.b.d(tVar.u() > 4 && tVar.q(4).equals("documents"), "Tried to deserialize invalid key %s", tVar);
        return tVar.v(5);
    }

    public static boolean d0(h8.t tVar) {
        return tVar.u() >= 4 && tVar.q(0).equals("projects") && tVar.q(2).equals("databases");
    }

    public y0 A(d9.t tVar) {
        y0.e eVar;
        y0 dVar;
        int i10 = a.f11769m[tVar.j0().ordinal()];
        l1 l1VarB0 = null;
        if (i10 == 1) {
            d9.b0 b0VarK0 = tVar.k0();
            int i11 = a.f11768l[b0VarK0.i0().ordinal()];
            if (i11 == 1) {
                eVar = y0.e.NoChange;
            } else if (i11 == 2) {
                eVar = y0.e.Added;
            } else if (i11 == 3) {
                eVar = y0.e.Removed;
                l1VarB0 = b0(b0VarK0.e0());
            } else if (i11 == 4) {
                eVar = y0.e.Current;
            } else {
                if (i11 != 5) {
                    throw new IllegalArgumentException("Unknown target change type");
                }
                eVar = y0.e.Reset;
            }
            dVar = new y0.d(eVar, b0VarK0.k0(), b0VarK0.h0(), l1VarB0);
        } else if (i10 == 2) {
            d9.l lVarF0 = tVar.f0();
            List<Integer> listH0 = lVarF0.h0();
            List<Integer> listG0 = lVarF0.g0();
            h8.k kVarL = l(lVarF0.f0().k0());
            h8.v vVarY = y(lVarF0.f0().l0());
            l8.b.d(!vVarY.equals(h8.v.f9777b), "Got a document change without an update time", new Object[0]);
            h8.r rVarR = h8.r.r(kVarL, vVarY, h8.s.h(lVarF0.f0().i0()));
            dVar = new y0.b(listH0, listG0, rVarR.getKey(), rVarR);
        } else {
            if (i10 == 3) {
                d9.m mVarG0 = tVar.g0();
                List<Integer> listH1 = mVarG0.h0();
                h8.r rVarT = h8.r.t(l(mVarG0.f0()), y(mVarG0.g0()));
                return new y0.b(Collections.emptyList(), listH1, rVarT.getKey(), rVarT);
            }
            if (i10 != 4) {
                if (i10 != 5) {
                    throw new IllegalArgumentException("Unknown change type set");
                }
                d9.q qVarI0 = tVar.i0();
                return new y0.c(qVarI0.g0(), new r(qVarI0.e0(), qVarI0.h0()));
            }
            d9.o oVarH0 = tVar.h0();
            dVar = new y0.b(Collections.emptyList(), oVarH0.g0(), l(oVarH0.f0()), null);
        }
        return dVar;
    }

    public d9.z.h B(e8.k kVar) {
        Object objBuild;
        ArrayList arrayList = new ArrayList(kVar.b().size());
        Iterator<e8.q> it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(J(it.next()));
        }
        if (arrayList.size() == 1) {
            objBuild = arrayList.get(0);
        } else {
            d9.z.d.a aVarL0 = d9.z.d.l0();
            aVarL0.F(C(kVar.e()));
            aVarL0.E(arrayList);
            objBuild = d9.z.h.m0().E(aVarL0).build();
        }
        return (d9.z.h) objBuild;
    }

    public d9.z.d.b C(e8.k.a aVar) {
        int i10 = a.f11761e[aVar.ordinal()];
        if (i10 == 1) {
            return d9.z.d.b.AND;
        }
        if (i10 == 2) {
            return d9.z.d.b.OR;
        }
        throw l8.b.a("Unrecognized composite filter type.", new Object[0]);
    }

    public d9.k D(h8.k kVar, h8.s sVar) {
        d9.k.b bVarO0 = d9.k.o0();
        bVarO0.F(L(kVar));
        bVarO0.E(sVar.l());
        return bVarO0.build();
    }

    public final d9.n E(i8.d dVar) {
        d9.n.b bVarK0 = d9.n.k0();
        Iterator<h8.q> it = dVar.c().iterator();
        while (it.hasNext()) {
            bVarK0.E(it.next().i());
        }
        return bVarK0.build();
    }

    public d9.a0.c F(g1 g1Var) {
        d9.a0.c.a aVarK0 = d9.a0.c.k0();
        aVarK0.E(R(g1Var.n()));
        return aVarK0.build();
    }

    public final d9.z.f.b G(e8.p.b bVar) {
        switch (a.f11765i[bVar.ordinal()]) {
            case 1:
                return d9.z.f.b.LESS_THAN;
            case 2:
                return d9.z.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return d9.z.f.b.EQUAL;
            case 4:
                return d9.z.f.b.NOT_EQUAL;
            case 5:
                return d9.z.f.b.GREATER_THAN;
            case 6:
                return d9.z.f.b.GREATER_THAN_OR_EQUAL;
            case 7:
                return d9.z.f.b.ARRAY_CONTAINS;
            case 8:
                return d9.z.f.b.IN;
            case 9:
                return d9.z.f.b.ARRAY_CONTAINS_ANY;
            case 10:
                return d9.z.f.b.NOT_IN;
            default:
                throw l8.b.a("Unknown operator %d", bVar);
        }
    }

    public final d9.z.g H(h8.q qVar) {
        return d9.z.g.h0().E(qVar.i()).build();
    }

    public final d9.p.c I(i8.e eVar) {
        d9.p.c.a aVarH;
        i8.p pVarB = eVar.b();
        if (pVarB instanceof i8.n) {
            aVarH = d9.p.c.p0().F(eVar.a().i()).K(d9.p.c.b.REQUEST_TIME);
        } else if (pVarB instanceof i8.a.b) {
            aVarH = d9.p.c.p0().F(eVar.a().i()).E(d9.b.n0().E(((i8.a.b) pVarB).f()));
        } else if (pVarB instanceof i8.a.C0175a) {
            aVarH = d9.p.c.p0().F(eVar.a().i()).I(d9.b.n0().E(((i8.a.C0175a) pVarB).f()));
        } else {
            if (!(pVarB instanceof i8.j)) {
                throw l8.b.a("Unknown transform: %s", pVarB);
            }
            aVarH = d9.p.c.p0().F(eVar.a().i()).H(((i8.j) pVarB).d());
        }
        return aVarH.build();
    }

    public d9.z.h J(e8.q qVar) {
        if (qVar instanceof e8.p) {
            return X((e8.p) qVar);
        }
        if (qVar instanceof e8.k) {
            return B((e8.k) qVar);
        }
        throw l8.b.a("Unrecognized filter type %s", qVar.toString());
    }

    public final d9.z.h K(List<e8.q> list) {
        return J(new e8.k(list, e8.k.a.AND));
    }

    public String L(h8.k kVar) {
        return T(this.f11755a, kVar.s());
    }

    public final String M(k1 k1Var) {
        int i10 = a.f11760d[k1Var.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            return "existence-filter-mismatch";
        }
        if (i10 == 3) {
            return "existence-filter-mismatch-bloom";
        }
        if (i10 == 4) {
            return "limbo-document";
        }
        throw l8.b.a("Unrecognized query purpose: %s", k1Var);
    }

    public Map<String, String> N(n4 n4Var) {
        String strM = M(n4Var.c());
        if (strM == null) {
            return null;
        }
        HashMap map = new HashMap(1);
        map.put("goog-listen-tags", strM);
        return map;
    }

    public d9.e0 O(i8.f fVar) {
        d9.e0.b bVarY0 = d9.e0.y0();
        if (fVar instanceof i8.o) {
            bVarY0.I(D(fVar.g(), ((i8.o) fVar).o()));
        } else if (fVar instanceof i8.l) {
            bVarY0.I(D(fVar.g(), ((i8.l) fVar).q()));
            bVarY0.K(E(fVar.e()));
        } else if (fVar instanceof i8.c) {
            bVarY0.H(L(fVar.g()));
        } else {
            if (!(fVar instanceof i8.q)) {
                throw l8.b.a("unknown mutation type %s", fVar.getClass());
            }
            bVarY0.L(L(fVar.g()));
        }
        Iterator<i8.e> it = fVar.f().iterator();
        while (it.hasNext()) {
            bVarY0.E(I(it.next()));
        }
        if (!fVar.h().d()) {
            bVarY0.F(Q(fVar.h()));
        }
        return bVarY0.build();
    }

    public final d9.z.i P(e8.a1 a1Var) {
        d9.z.i.a aVarI0 = d9.z.i.i0();
        aVarI0.E(a1Var.b().equals(e8.a1.a.ASCENDING) ? d9.z.e.ASCENDING : d9.z.e.DESCENDING);
        aVarI0.F(H(a1Var.c()));
        return aVarI0.build();
    }

    public final d9.v Q(i8.m mVar) {
        d9.v.b bVarE;
        l8.b.d(!mVar.d(), "Can't serialize an empty precondition", new Object[0]);
        d9.v.b bVarK0 = d9.v.k0();
        if (mVar.c() != null) {
            bVarE = bVarK0.F(Y(mVar.c()));
        } else {
            if (mVar.b() == null) {
                throw l8.b.a("Unknown Precondition", new Object[0]);
            }
            bVarE = bVarK0.E(mVar.b().booleanValue());
        }
        return bVarE.build();
    }

    public final String R(h8.t tVar) {
        return T(this.f11755a, tVar);
    }

    public d9.a0.d S(g1 g1Var) {
        d9.a0.d.a aVarJ0 = d9.a0.d.j0();
        d9.z.b bVarB0 = d9.z.B0();
        h8.t tVarN = g1Var.n();
        if (g1Var.d() != null) {
            l8.b.d(tVarN.u() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            aVarJ0.E(R(tVarN));
            d9.z.c.a aVarI0 = d9.z.c.i0();
            aVarI0.F(g1Var.d());
            aVarI0.E(true);
            bVarB0.E(aVarI0);
        } else {
            l8.b.d(tVarN.u() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            aVarJ0.E(R(tVarN.w()));
            d9.z.c.a aVarI1 = d9.z.c.i0();
            aVarI1.F(tVarN.p());
            bVarB0.E(aVarI1);
        }
        if (g1Var.h().size() > 0) {
            bVarB0.L(K(g1Var.h()));
        }
        Iterator<e8.a1> it = g1Var.m().iterator();
        while (it.hasNext()) {
            bVarB0.F(P(it.next()));
        }
        if (g1Var.r()) {
            bVarB0.I(com.google.protobuf.a0.h0().E((int) g1Var.j()));
        }
        if (g1Var.p() != null) {
            d9.j.b bVarK0 = d9.j.k0();
            bVarK0.E(g1Var.p().b());
            bVarK0.F(g1Var.p().c());
            bVarB0.K(bVarK0);
        }
        if (g1Var.f() != null) {
            d9.j.b bVarK1 = d9.j.k0();
            bVarK1.E(g1Var.f().b());
            bVarK1.F(!g1Var.f().c());
            bVarB0.H(bVarK1);
        }
        aVarJ0.F(bVarB0);
        return aVarJ0.build();
    }

    public final String T(h8.f fVar, h8.t tVar) {
        return Z(fVar).h("documents").d(tVar).i();
    }

    public d9.y U(d9.a0.d dVar, List<com.google.firebase.firestore.a> list, HashMap<String, String> map) {
        d9.y.c cVarI0 = d9.y.i0();
        cVarI0.F(dVar.i0());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i10 = 1;
        for (com.google.firebase.firestore.a aVar : list) {
            if (!hashSet.contains(aVar.c())) {
                hashSet.add(aVar.c());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("aggregate_");
                int i11 = i10 + 1;
                sb2.append(i10);
                String string = sb2.toString();
                map.put(string, aVar.c());
                d9.y.b.C0116b c0116bI0 = d9.y.b.i0();
                d9.z.g gVarBuild = d9.z.g.h0().E(aVar.d()).build();
                if (aVar instanceof com.google.firebase.firestore.a.c) {
                    c0116bI0.H(d9.y.b.c.e0());
                } else if (aVar instanceof com.google.firebase.firestore.a.d) {
                    c0116bI0.I(d9.y.b.d.f0().E(gVarBuild).build());
                } else {
                    if (!(aVar instanceof com.google.firebase.firestore.a.b)) {
                        throw new RuntimeException("Unsupported aggregation");
                    }
                    c0116bI0.F(d9.y.b.a.f0().E(gVarBuild).build());
                }
                c0116bI0.E(string);
                arrayList.add(c0116bI0.build());
                i10 = i11;
            }
        }
        cVarI0.E(arrayList);
        return (d9.y) cVarI0.build();
    }

    public d9.a0 V(n4 n4Var) {
        d9.a0.b bVarK0 = d9.a0.k0();
        g1 g1VarG = n4Var.g();
        if (g1VarG.s()) {
            bVarK0.E(F(g1VarG));
        } else {
            bVarK0.H(S(g1VarG));
        }
        bVarK0.L(n4Var.h());
        if (!n4Var.d().isEmpty() || n4Var.f().compareTo(h8.v.f9777b) <= 0) {
            bVarK0.K(n4Var.d());
        } else {
            bVarK0.I(W(n4Var.f().h()));
        }
        if (n4Var.a() != null && (!n4Var.d().isEmpty() || n4Var.f().compareTo(h8.v.f9777b) > 0)) {
            bVarK0.F(com.google.protobuf.a0.h0().E(n4Var.a().intValue()));
        }
        return bVarK0.build();
    }

    public u1 W(h7.q qVar) {
        u1.b bVarJ0 = u1.j0();
        bVarJ0.F(qVar.k());
        bVarJ0.E(qVar.h());
        return bVarJ0.build();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    public d9.z.h X(e8.p pVar) {
        d9.z.k.b bVar;
        d9.z.h.a aVarH;
        e8.p.b bVarG = pVar.g();
        e8.p.b bVar2 = e8.p.b.EQUAL;
        if (bVarG == bVar2 || pVar.g() == e8.p.b.NOT_EQUAL) {
            d9.z.k.a aVarJ0 = d9.z.k.j0();
            aVarJ0.E(H(pVar.f()));
            if (h8.y.z(pVar.h())) {
                bVar = pVar.g() == bVar2 ? d9.z.k.b.IS_NAN : d9.z.k.b.IS_NOT_NAN;
            } else if (h8.y.A(pVar.h())) {
                bVar = pVar.g() == bVar2 ? d9.z.k.b.IS_NULL : d9.z.k.b.IS_NOT_NULL;
            } else {
                d9.z.f.a aVarL0 = d9.z.f.l0();
                aVarL0.E(H(pVar.f()));
                aVarL0.F(G(pVar.g()));
                aVarL0.H(pVar.h());
                aVarH = d9.z.h.m0().F(aVarL0);
            }
            aVarJ0.F(bVar);
            aVarH = d9.z.h.m0().H(aVarJ0);
        } else {
            d9.z.f.a aVarL1 = d9.z.f.l0();
            aVarL1.E(H(pVar.f()));
            aVarL1.F(G(pVar.g()));
            aVarL1.H(pVar.h());
            aVarH = d9.z.h.m0().F(aVarL1);
        }
        return aVarH.build();
    }

    public u1 Y(h8.v vVar) {
        return W(vVar.h());
    }

    public String a() {
        return this.f11756b;
    }

    public e8.k b(d9.z.d dVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<d9.z.h> it = dVar.j0().iterator();
        while (it.hasNext()) {
            arrayList.add(i(it.next()));
        }
        return new e8.k(arrayList, c(dVar.k0()));
    }

    public final l1 b0(n9.a aVar) {
        return l1.h(aVar.e0()).q(aVar.g0());
    }

    public e8.k.a c(d9.z.d.b bVar) {
        int i10 = a.f11762f[bVar.ordinal()];
        if (i10 == 1) {
            return e8.k.a.AND;
        }
        if (i10 == 2) {
            return e8.k.a.OR;
        }
        throw l8.b.a("Only AND and OR composite filter types are supported.", new Object[0]);
    }

    public boolean c0(h8.t tVar) {
        return d0(tVar) && tVar.q(1).equals(this.f11755a.l()) && tVar.q(3).equals(this.f11755a.k());
    }

    public final i8.d d(d9.n nVar) {
        int iJ0 = nVar.j0();
        HashSet hashSet = new HashSet(iJ0);
        for (int i10 = 0; i10 < iJ0; i10++) {
            hashSet.add(h8.q.z(nVar.i0(i10)));
        }
        return i8.d.b(hashSet);
    }

    public g1 e(d9.a0.c cVar) {
        int iJ0 = cVar.j0();
        l8.b.d(iJ0 == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(iJ0));
        return e8.b1.b(s(cVar.i0(0))).D();
    }

    public e8.p f(d9.z.f fVar) {
        return e8.p.e(h8.q.z(fVar.i0().g0()), g(fVar.j0()), fVar.k0());
    }

    public final e8.p.b g(d9.z.f.b bVar) {
        switch (a.f11766j[bVar.ordinal()]) {
            case 1:
                return e8.p.b.LESS_THAN;
            case 2:
                return e8.p.b.LESS_THAN_OR_EQUAL;
            case 3:
                return e8.p.b.EQUAL;
            case 4:
                return e8.p.b.NOT_EQUAL;
            case 5:
                return e8.p.b.GREATER_THAN_OR_EQUAL;
            case 6:
                return e8.p.b.GREATER_THAN;
            case 7:
                return e8.p.b.ARRAY_CONTAINS;
            case 8:
                return e8.p.b.IN;
            case 9:
                return e8.p.b.ARRAY_CONTAINS_ANY;
            case 10:
                return e8.p.b.NOT_IN;
            default:
                throw l8.b.a("Unhandled FieldFilter.operator %d", bVar);
        }
    }

    public final i8.e h(d9.p.c cVar) {
        int i10 = a.f11759c[cVar.o0().ordinal()];
        if (i10 == 1) {
            l8.b.d(cVar.n0() == d9.p.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", cVar.n0());
            return new i8.e(h8.q.z(cVar.k0()), i8.n.d());
        }
        if (i10 == 2) {
            return new i8.e(h8.q.z(cVar.k0()), new i8.a.b(cVar.j0().m()));
        }
        if (i10 == 3) {
            return new i8.e(h8.q.z(cVar.k0()), new i8.a.C0175a(cVar.m0().m()));
        }
        if (i10 == 4) {
            return new i8.e(h8.q.z(cVar.k0()), new i8.j(cVar.l0()));
        }
        throw l8.b.a("Unknown FieldTransform proto: %s", cVar);
    }

    public e8.q i(d9.z.h hVar) {
        int i10 = a.f11763g[hVar.k0().ordinal()];
        if (i10 == 1) {
            return b(hVar.h0());
        }
        if (i10 == 2) {
            return f(hVar.j0());
        }
        if (i10 == 3) {
            return x(hVar.l0());
        }
        throw l8.b.a("Unrecognized Filter.filterType %d", hVar.k0());
    }

    public final List<e8.q> j(d9.z.h hVar) {
        e8.q qVarI = i(hVar);
        if (qVarI instanceof e8.k) {
            e8.k kVar = (e8.k) qVarI;
            if (kVar.i()) {
                return kVar.b();
            }
        }
        return Collections.singletonList(qVarI);
    }

    public final h8.r k(d9.e eVar) {
        l8.b.d(eVar.i0().equals(d9.e.c.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        h8.k kVarL = l(eVar.f0().k0());
        h8.s sVarH = h8.s.h(eVar.f0().i0());
        h8.v vVarY = y(eVar.f0().l0());
        l8.b.d(!vVarY.equals(h8.v.f9777b), "Got a document response with no snapshot version", new Object[0]);
        return h8.r.r(kVarL, vVarY, sVarH);
    }

    public h8.k l(String str) {
        h8.t tVarV = v(str);
        l8.b.d(tVarV.q(1).equals(this.f11755a.l()), "Tried to deserialize key from different project.", new Object[0]);
        l8.b.d(tVarV.q(3).equals(this.f11755a.k()), "Tried to deserialize key from different database.", new Object[0]);
        return h8.k.n(a0(tVarV));
    }

    public h8.r m(d9.e eVar) {
        if (eVar.i0().equals(d9.e.c.FOUND)) {
            return k(eVar);
        }
        if (eVar.i0().equals(d9.e.c.MISSING)) {
            return n(eVar);
        }
        throw new IllegalArgumentException("Unknown result case: " + eVar.i0());
    }

    public final h8.r n(d9.e eVar) {
        l8.b.d(eVar.i0().equals(d9.e.c.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        h8.k kVarL = l(eVar.g0());
        h8.v vVarY = y(eVar.h0());
        l8.b.d(!vVarY.equals(h8.v.f9777b), "Got a no document response with no snapshot version", new Object[0]);
        return h8.r.t(kVarL, vVarY);
    }

    public i8.f o(d9.e0 e0Var) {
        i8.m mVarR = e0Var.u0() ? r(e0Var.m0()) : i8.m.f10544c;
        ArrayList arrayList = new ArrayList();
        Iterator<d9.p.c> it = e0Var.s0().iterator();
        while (it.hasNext()) {
            arrayList.add(h(it.next()));
        }
        int i10 = a.f11757a[e0Var.o0().ordinal()];
        if (i10 == 1) {
            return e0Var.x0() ? new i8.l(l(e0Var.q0().k0()), h8.s.h(e0Var.q0().i0()), d(e0Var.r0()), mVarR, arrayList) : new i8.o(l(e0Var.q0().k0()), h8.s.h(e0Var.q0().i0()), mVarR, arrayList);
        }
        if (i10 == 2) {
            return new i8.c(l(e0Var.n0()), mVarR);
        }
        if (i10 == 3) {
            return new i8.q(l(e0Var.t0()), mVarR);
        }
        throw l8.b.a("Unknown mutation operation: %d", e0Var.o0());
    }

    public i8.i p(d9.h0 h0Var, h8.v vVar) {
        h8.v vVarY = y(h0Var.g0());
        if (!h8.v.f9777b.equals(vVarY)) {
            vVar = vVarY;
        }
        int iF0 = h0Var.f0();
        ArrayList arrayList = new ArrayList(iF0);
        for (int i10 = 0; i10 < iF0; i10++) {
            arrayList.add(h0Var.e0(i10));
        }
        return new i8.i(vVar, arrayList);
    }

    public final e8.a1 q(d9.z.i iVar) {
        e8.a1.a aVar;
        h8.q qVarZ = h8.q.z(iVar.h0().g0());
        int i10 = a.f11767k[iVar.g0().ordinal()];
        if (i10 == 1) {
            aVar = e8.a1.a.ASCENDING;
        } else {
            if (i10 != 2) {
                throw l8.b.a("Unrecognized direction %d", iVar.g0());
            }
            aVar = e8.a1.a.DESCENDING;
        }
        return e8.a1.d(aVar, qVarZ);
    }

    public final i8.m r(d9.v vVar) {
        int i10 = a.f11758b[vVar.g0().ordinal()];
        if (i10 == 1) {
            return i8.m.f(y(vVar.j0()));
        }
        if (i10 == 2) {
            return i8.m.a(vVar.i0());
        }
        if (i10 == 3) {
            return i8.m.f10544c;
        }
        throw l8.b.a("Unknown precondition", new Object[0]);
    }

    public final h8.t s(String str) {
        h8.t tVarV = v(str);
        return tVarV.u() == 4 ? h8.t.f9776b : a0(tVarV);
    }

    public g1 t(d9.a0.d dVar) {
        return u(dVar.h0(), dVar.i0());
    }

    public g1 u(String str, d9.z zVar) {
        h8.t tVar;
        String str2;
        List listEmptyList;
        h8.t tVarS = s(str);
        int iR0 = zVar.r0();
        if (iR0 <= 0) {
            tVar = tVarS;
            str2 = null;
        } else {
            l8.b.d(iR0 == 1, "StructuredQuery.from with more than one collection is not supported.", new Object[0]);
            d9.z.c cVarQ0 = zVar.q0(0);
            boolean zG0 = cVarQ0.g0();
            String strH0 = cVarQ0.h0();
            if (zG0) {
                tVar = tVarS;
                str2 = strH0;
            } else {
                tVarS = tVarS.h(strH0);
                tVar = tVarS;
                str2 = null;
            }
        }
        List<e8.q> listJ = zVar.A0() ? j(zVar.w0()) : Collections.emptyList();
        int iU0 = zVar.u0();
        if (iU0 > 0) {
            ArrayList arrayList = new ArrayList(iU0);
            for (int i10 = 0; i10 < iU0; i10++) {
                arrayList.add(q(zVar.t0(i10)));
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = Collections.emptyList();
        }
        return new g1(tVar, str2, listJ, listEmptyList, zVar.y0() ? zVar.s0().g0() : -1L, zVar.z0() ? new e8.i(zVar.v0().m(), zVar.v0().i0()) : null, zVar.x0() ? new e8.i(zVar.p0().m(), !zVar.p0().i0()) : null);
    }

    public final h8.t v(String str) {
        h8.t tVarZ = h8.t.z(str);
        l8.b.d(d0(tVarZ), "Tried to deserialize invalid key %s", tVarZ);
        return tVarZ;
    }

    public h7.q w(u1 u1Var) {
        return new h7.q(u1Var.i0(), u1Var.h0());
    }

    public final e8.q x(d9.z.k kVar) {
        e8.p.b bVar;
        d9.d0 d0Var;
        h8.q qVarZ = h8.q.z(kVar.h0().g0());
        int i10 = a.f11764h[kVar.i0().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                bVar = e8.p.b.EQUAL;
            } else if (i10 == 3) {
                bVar = e8.p.b.NOT_EQUAL;
            } else {
                if (i10 != 4) {
                    throw l8.b.a("Unrecognized UnaryFilter.operator %d", kVar.i0());
                }
                bVar = e8.p.b.NOT_EQUAL;
            }
            d0Var = h8.y.f9784b;
            return e8.p.e(qVarZ, bVar, d0Var);
        }
        bVar = e8.p.b.EQUAL;
        d0Var = h8.y.f9783a;
        return e8.p.e(qVarZ, bVar, d0Var);
    }

    public h8.v y(u1 u1Var) {
        return (u1Var.i0() == 0 && u1Var.h0() == 0) ? h8.v.f9777b : new h8.v(w(u1Var));
    }

    public h8.v z(d9.t tVar) {
        if (tVar.j0() == d9.t.c.TARGET_CHANGE && tVar.k0().j0() == 0) {
            return y(tVar.k0().g0());
        }
        return h8.v.f9777b;
    }
}
