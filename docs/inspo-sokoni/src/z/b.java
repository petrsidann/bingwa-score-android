package z;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<y.e> f19657a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f19658b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y.f f19659c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y.e.b f19660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y.e.b f19661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19665f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19666g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19667h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f19668i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f19669j;
    }

    /* JADX INFO: renamed from: z.b$b, reason: collision with other inner class name */
    public interface InterfaceC0341b {
        void a();

        void b(y.e eVar, a aVar);
    }

    public b(y.f fVar) {
        this.f19659c = fVar;
    }

    public final boolean a(InterfaceC0341b interfaceC0341b, y.e eVar, boolean z10) {
        this.f19658b.f19660a = eVar.y();
        this.f19658b.f19661b = eVar.M();
        this.f19658b.f19662c = eVar.P();
        this.f19658b.f19663d = eVar.v();
        a aVar = this.f19658b;
        aVar.f19668i = false;
        aVar.f19669j = z10;
        y.e.b bVar = aVar.f19660a;
        y.e.b bVar2 = y.e.b.MATCH_CONSTRAINT;
        boolean z11 = bVar == bVar2;
        boolean z12 = aVar.f19661b == bVar2;
        boolean z13 = z11 && eVar.Q > 0.0f;
        boolean z14 = z12 && eVar.Q > 0.0f;
        if (z13 && eVar.f19183n[0] == 4) {
            aVar.f19660a = y.e.b.FIXED;
        }
        if (z14 && eVar.f19183n[1] == 4) {
            aVar.f19661b = y.e.b.FIXED;
        }
        interfaceC0341b.b(eVar, aVar);
        eVar.E0(this.f19658b.f19664e);
        eVar.h0(this.f19658b.f19665f);
        eVar.g0(this.f19658b.f19667h);
        eVar.b0(this.f19658b.f19666g);
        a aVar2 = this.f19658b;
        aVar2.f19669j = false;
        return aVar2.f19668i;
    }

    public final void b(y.f fVar) {
        int size = fVar.f19252w0.size();
        InterfaceC0341b interfaceC0341bU0 = fVar.U0();
        for (int i10 = 0; i10 < size; i10++) {
            y.e eVar = fVar.f19252w0.get(i10);
            if (!(eVar instanceof y.h) && (!eVar.f19165e.f19720e.f19690j || !eVar.f19167f.f19720e.f19690j)) {
                y.e.b bVarS = eVar.s(0);
                y.e.b bVarS2 = eVar.s(1);
                y.e.b bVar = y.e.b.MATCH_CONSTRAINT;
                if (!(bVarS == bVar && eVar.f19179l != 1 && bVarS2 == bVar && eVar.f19181m != 1)) {
                    a(interfaceC0341bU0, eVar, false);
                }
            }
        }
        interfaceC0341bU0.a();
    }

    public final void c(y.f fVar, String str, int i10, int i11) {
        int iE = fVar.E();
        int iD = fVar.D();
        fVar.u0(0);
        fVar.t0(0);
        fVar.E0(i10);
        fVar.h0(i11);
        fVar.u0(iE);
        fVar.t0(iD);
        this.f19659c.K0();
    }

    public long d(y.f fVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zR0;
        int i19;
        boolean z10;
        boolean z11;
        int i20;
        int i21;
        InterfaceC0341b interfaceC0341b;
        boolean z12;
        boolean zT0;
        int i22;
        InterfaceC0341b interfaceC0341bU0 = fVar.U0();
        int size = fVar.f19252w0.size();
        int iP = fVar.P();
        int iV = fVar.v();
        boolean zB = y.k.b(i10, 128);
        boolean z13 = zB || y.k.b(i10, 64);
        if (z13) {
            for (int i23 = 0; i23 < size; i23++) {
                y.e eVar = fVar.f19252w0.get(i23);
                y.e.b bVarY = eVar.y();
                y.e.b bVar = y.e.b.MATCH_CONSTRAINT;
                boolean z14 = (bVarY == bVar) && (eVar.M() == bVar) && eVar.t() > 0.0f;
                if ((eVar.V() && z14) || ((eVar.X() && z14) || (eVar instanceof y.l) || eVar.V() || eVar.X())) {
                    z13 = false;
                    break;
                }
            }
        }
        if (z13) {
            int i24 = x.d.f17880q;
        }
        int i25 = 2;
        if (z13 && ((i13 == 1073741824 && i15 == 1073741824) || zB)) {
            int iMin = Math.min(fVar.C(), i14);
            int iMin2 = Math.min(fVar.B(), i16);
            if (i13 == 1073741824 && fVar.P() != iMin) {
                fVar.E0(iMin);
                fVar.X0();
            }
            if (i15 == 1073741824 && fVar.v() != iMin2) {
                fVar.h0(iMin2);
                fVar.X0();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                zR0 = fVar.R0(zB);
                i19 = 2;
            } else {
                boolean zS0 = fVar.S0(zB);
                if (i13 == 1073741824) {
                    zT0 = zS0 & fVar.T0(zB, 0);
                    i22 = 1;
                } else {
                    zT0 = zS0;
                    i22 = 0;
                }
                if (i15 == 1073741824) {
                    boolean zT1 = fVar.T0(zB, 1) & zT0;
                    i19 = i22 + 1;
                    zR0 = zT1;
                } else {
                    i19 = i22;
                    zR0 = zT0;
                }
            }
            if (zR0) {
                fVar.I0(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            zR0 = false;
            i19 = 0;
        }
        if (zR0 && i19 == 2) {
            return 0L;
        }
        if (size > 0) {
            b(fVar);
        }
        int iV0 = fVar.V0();
        int size2 = this.f19657a.size();
        if (size > 0) {
            c(fVar, "First pass", iP, iV);
        }
        if (size2 > 0) {
            y.e.b bVarY2 = fVar.y();
            y.e.b bVar2 = y.e.b.WRAP_CONTENT;
            boolean z15 = bVarY2 == bVar2;
            boolean z16 = fVar.M() == bVar2;
            int iMax = Math.max(fVar.P(), this.f19659c.E());
            int iMax2 = Math.max(fVar.v(), this.f19659c.D());
            int i26 = 0;
            boolean zA = false;
            while (i26 < size2) {
                y.e eVar2 = this.f19657a.get(i26);
                if (eVar2 instanceof y.l) {
                    int iP2 = eVar2.P();
                    int iV2 = eVar2.v();
                    boolean zA2 = zA | a(interfaceC0341bU0, eVar2, true);
                    int iP3 = eVar2.P();
                    int iV3 = eVar2.v();
                    if (iP3 != iP2) {
                        eVar2.E0(iP3);
                        if (z15 && eVar2.I() > iMax) {
                            iMax = Math.max(iMax, eVar2.I() + eVar2.m(y.d.b.RIGHT).c());
                        }
                        z12 = true;
                    } else {
                        z12 = zA2;
                    }
                    if (iV3 != iV2) {
                        eVar2.h0(iV3);
                        if (z16 && eVar2.p() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.p() + eVar2.m(y.d.b.BOTTOM).c());
                        }
                        z12 = true;
                    }
                    zA = z12 | ((y.l) eVar2).V0();
                }
                i26++;
                iV0 = iV0;
                i25 = 2;
            }
            int i27 = iV0;
            int i28 = 0;
            for (int i29 = i25; i28 < i29; i29 = 2) {
                int i30 = 0;
                while (i30 < size2) {
                    y.e eVar3 = this.f19657a.get(i30);
                    if (((eVar3 instanceof y.i) && !(eVar3 instanceof y.l)) || (eVar3 instanceof y.h) || eVar3.O() == 8 || ((eVar3.f19165e.f19720e.f19690j && eVar3.f19167f.f19720e.f19690j) || (eVar3 instanceof y.l))) {
                        i21 = i28;
                        i20 = size2;
                        interfaceC0341b = interfaceC0341bU0;
                    } else {
                        int iP4 = eVar3.P();
                        int iV4 = eVar3.v();
                        i20 = size2;
                        int iN = eVar3.n();
                        i21 = i28;
                        zA |= a(interfaceC0341bU0, eVar3, true);
                        int iP5 = eVar3.P();
                        interfaceC0341b = interfaceC0341bU0;
                        int iV5 = eVar3.v();
                        if (iP5 != iP4) {
                            eVar3.E0(iP5);
                            if (z15 && eVar3.I() > iMax) {
                                iMax = Math.max(iMax, eVar3.I() + eVar3.m(y.d.b.RIGHT).c());
                            }
                            zA = true;
                        }
                        if (iV5 != iV4) {
                            eVar3.h0(iV5);
                            if (z16 && eVar3.p() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.p() + eVar3.m(y.d.b.BOTTOM).c());
                            }
                            zA = true;
                        }
                        if (eVar3.S() && iN != eVar3.n()) {
                            zA = true;
                        }
                    }
                    i30++;
                    size2 = i20;
                    interfaceC0341bU0 = interfaceC0341b;
                    i28 = i21;
                }
                int i31 = i28;
                int i32 = size2;
                InterfaceC0341b interfaceC0341b2 = interfaceC0341bU0;
                if (zA) {
                    c(fVar, "intermediate pass", iP, iV);
                    zA = false;
                }
                i28 = i31 + 1;
                size2 = i32;
                interfaceC0341bU0 = interfaceC0341b2;
            }
            if (zA) {
                c(fVar, "2nd pass", iP, iV);
                if (fVar.P() < iMax) {
                    fVar.E0(iMax);
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (fVar.v() < iMax2) {
                    fVar.h0(iMax2);
                    z11 = true;
                } else {
                    z11 = z10;
                }
                if (z11) {
                    c(fVar, "3rd pass", iP, iV);
                }
            }
            iV0 = i27;
        }
        fVar.g1(iV0);
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    public void e(y.f fVar) {
        this.f19657a.clear();
        int size = fVar.f19252w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            y.e eVar = fVar.f19252w0.get(i10);
            y.e.b bVarY = eVar.y();
            y.e.b bVar = y.e.b.MATCH_CONSTRAINT;
            if (bVarY != bVar) {
                y.e.b bVarY2 = eVar.y();
                y.e.b bVar2 = y.e.b.MATCH_PARENT;
                if (bVarY2 == bVar2 || eVar.M() == bVar || eVar.M() == bVar2) {
                    this.f19657a.add(eVar);
                }
            } else {
                this.f19657a.add(eVar);
            }
        }
        fVar.X0();
    }
}
