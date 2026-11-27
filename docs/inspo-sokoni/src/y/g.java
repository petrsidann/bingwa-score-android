package y;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g extends l {

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public e[] f19222i1;
    public int L0 = -1;
    public int M0 = -1;
    public int N0 = -1;
    public int O0 = -1;
    public int P0 = -1;
    public int Q0 = -1;
    public float R0 = 0.5f;
    public float S0 = 0.5f;
    public float T0 = 0.5f;
    public float U0 = 0.5f;
    public float V0 = 0.5f;
    public float W0 = 0.5f;
    public int X0 = 0;
    public int Y0 = 0;
    public int Z0 = 2;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f19214a1 = 2;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f19215b1 = 0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f19216c1 = -1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f19217d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public ArrayList<a> f19218e1 = new ArrayList<>();

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public e[] f19219f1 = null;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public e[] f19220g1 = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int[] f19221h1 = null;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public int f19223j1 = 0;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19224a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f19227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f19228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f19229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f19230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19234k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19240q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f19225b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19226c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19235l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19236m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f19237n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19238o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f19239p = 0;

        public a(int i10, d dVar, d dVar2, d dVar3, d dVar4, int i11) {
            this.f19231h = 0;
            this.f19232i = 0;
            this.f19233j = 0;
            this.f19234k = 0;
            this.f19240q = 0;
            this.f19224a = i10;
            this.f19227d = dVar;
            this.f19228e = dVar2;
            this.f19229f = dVar3;
            this.f19230g = dVar4;
            this.f19231h = g.this.P0();
            this.f19232i = g.this.R0();
            this.f19233j = g.this.Q0();
            this.f19234k = g.this.O0();
            this.f19240q = i11;
        }

        public void b(e eVar) {
            if (this.f19224a == 0) {
                int iB1 = g.this.B1(eVar, this.f19240q);
                if (eVar.y() == e.b.MATCH_CONSTRAINT) {
                    this.f19239p++;
                    iB1 = 0;
                }
                this.f19235l += iB1 + (eVar.O() != 8 ? g.this.X0 : 0);
                int iA1 = g.this.A1(eVar, this.f19240q);
                if (this.f19225b == null || this.f19226c < iA1) {
                    this.f19225b = eVar;
                    this.f19226c = iA1;
                    this.f19236m = iA1;
                }
            } else {
                int iB2 = g.this.B1(eVar, this.f19240q);
                int iA2 = g.this.A1(eVar, this.f19240q);
                if (eVar.M() == e.b.MATCH_CONSTRAINT) {
                    this.f19239p++;
                    iA2 = 0;
                }
                this.f19236m += iA2 + (eVar.O() != 8 ? g.this.Y0 : 0);
                if (this.f19225b == null || this.f19226c < iB2) {
                    this.f19225b = eVar;
                    this.f19226c = iB2;
                    this.f19235l = iB2;
                }
            }
            this.f19238o++;
        }

        public void c() {
            this.f19226c = 0;
            this.f19225b = null;
            this.f19235l = 0;
            this.f19236m = 0;
            this.f19237n = 0;
            this.f19238o = 0;
            this.f19239p = 0;
        }

        public void d(boolean z10, int i10, boolean z11) {
            d dVar;
            d dVar2;
            d dVar3;
            d dVar4;
            d dVar5;
            d dVar6;
            e eVar;
            char c10;
            d dVar7;
            d dVar8;
            int i11 = this.f19238o;
            for (int i12 = 0; i12 < i11 && this.f19237n + i12 < g.this.f19223j1; i12++) {
                e eVar2 = g.this.f19222i1[this.f19237n + i12];
                if (eVar2 != null) {
                    eVar2.Z();
                }
            }
            if (i11 == 0 || this.f19225b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i13 = -1;
            int i14 = -1;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = z10 ? (i11 - 1) - i15 : i15;
                if (this.f19237n + i16 >= g.this.f19223j1) {
                    break;
                }
                if (g.this.f19222i1[this.f19237n + i16].O() == 0) {
                    if (i13 == -1) {
                        i13 = i15;
                    }
                    i14 = i15;
                }
            }
            e eVar3 = null;
            if (this.f19224a == 0) {
                e eVar4 = this.f19225b;
                eVar4.y0(g.this.M0);
                int i17 = this.f19232i;
                if (i10 > 0) {
                    i17 += g.this.Y0;
                }
                eVar4.C.a(this.f19228e, i17);
                if (z11) {
                    eVar4.E.a(this.f19230g, this.f19234k);
                }
                if (i10 > 0) {
                    this.f19228e.f19139b.E.a(eVar4.C, 0);
                }
                if (g.this.f19214a1 != 3 || eVar4.S()) {
                    eVar = eVar4;
                    break;
                }
                int i18 = 0;
                while (true) {
                    if (i18 < i11) {
                        int i19 = z10 ? (i11 - 1) - i18 : i18;
                        if (this.f19237n + i19 < g.this.f19223j1) {
                            eVar = g.this.f19222i1[this.f19237n + i19];
                            if (eVar.S()) {
                                break;
                            } else {
                                i18++;
                            }
                        }
                    }
                    eVar = eVar4;
                    break;
                }
                int i20 = 0;
                while (i20 < i11) {
                    int i21 = z10 ? (i11 - 1) - i20 : i20;
                    if (this.f19237n + i21 >= g.this.f19223j1) {
                        return;
                    }
                    e eVar5 = g.this.f19222i1[this.f19237n + i21];
                    if (i20 == 0) {
                        eVar5.j(eVar5.B, this.f19227d, this.f19231h);
                    }
                    if (i21 == 0) {
                        int i22 = g.this.L0;
                        float f10 = g.this.R0;
                        if (this.f19237n == 0 && g.this.N0 != -1) {
                            i22 = g.this.N0;
                            f10 = g.this.T0;
                        } else if (z11 && g.this.P0 != -1) {
                            i22 = g.this.P0;
                            f10 = g.this.V0;
                        }
                        eVar5.j0(i22);
                        eVar5.i0(f10);
                    }
                    if (i20 == i11 - 1) {
                        eVar5.j(eVar5.D, this.f19229f, this.f19233j);
                    }
                    if (eVar3 != null) {
                        eVar5.B.a(eVar3.D, g.this.X0);
                        if (i20 == i13) {
                            eVar5.B.n(this.f19231h);
                        }
                        eVar3.D.a(eVar5.B, 0);
                        if (i20 == i14 + 1) {
                            eVar3.D.n(this.f19233j);
                        }
                    }
                    if (eVar5 != eVar4) {
                        c10 = 3;
                        if (g.this.f19214a1 == 3 && eVar.S() && eVar5 != eVar && eVar5.S()) {
                            dVar7 = eVar5.F;
                            dVar8 = eVar.F;
                        } else {
                            int i23 = g.this.f19214a1;
                            if (i23 != 0) {
                                if (i23 != 1) {
                                    d dVar9 = eVar5.C;
                                    if (z12) {
                                        dVar9.a(this.f19228e, this.f19232i);
                                        eVar5.E.a(this.f19230g, this.f19234k);
                                    } else {
                                        dVar9.a(eVar4.C, 0);
                                    }
                                }
                                dVar7 = eVar5.E;
                                dVar8 = eVar4.E;
                            } else {
                                dVar7 = eVar5.C;
                                dVar8 = eVar4.C;
                            }
                        }
                        dVar7.a(dVar8, 0);
                    } else {
                        c10 = 3;
                    }
                    i20++;
                    eVar3 = eVar5;
                }
                return;
            }
            e eVar6 = this.f19225b;
            eVar6.j0(g.this.L0);
            int i24 = this.f19231h;
            if (i10 > 0) {
                i24 += g.this.X0;
            }
            if (z10) {
                eVar6.D.a(this.f19229f, i24);
                if (z11) {
                    eVar6.B.a(this.f19227d, this.f19233j);
                }
                if (i10 > 0) {
                    dVar = this.f19229f.f19139b.B;
                    dVar2 = eVar6.D;
                    dVar.a(dVar2, 0);
                }
            } else {
                eVar6.B.a(this.f19227d, i24);
                if (z11) {
                    eVar6.D.a(this.f19229f, this.f19233j);
                }
                if (i10 > 0) {
                    dVar = this.f19227d.f19139b.D;
                    dVar2 = eVar6.B;
                    dVar.a(dVar2, 0);
                }
            }
            int i25 = 0;
            while (i25 < i11 && this.f19237n + i25 < g.this.f19223j1) {
                e eVar7 = g.this.f19222i1[this.f19237n + i25];
                if (i25 == 0) {
                    eVar7.j(eVar7.C, this.f19228e, this.f19232i);
                    int i26 = g.this.M0;
                    float f11 = g.this.S0;
                    if (this.f19237n == 0 && g.this.O0 != -1) {
                        i26 = g.this.O0;
                        f11 = g.this.U0;
                    } else if (z11 && g.this.Q0 != -1) {
                        i26 = g.this.Q0;
                        f11 = g.this.W0;
                    }
                    eVar7.y0(i26);
                    eVar7.x0(f11);
                }
                if (i25 == i11 - 1) {
                    eVar7.j(eVar7.E, this.f19230g, this.f19234k);
                }
                if (eVar3 != null) {
                    eVar7.C.a(eVar3.E, g.this.Y0);
                    if (i25 == i13) {
                        eVar7.C.n(this.f19232i);
                    }
                    eVar3.E.a(eVar7.C, 0);
                    if (i25 == i14 + 1) {
                        eVar3.E.n(this.f19234k);
                    }
                }
                if (eVar7 != eVar6) {
                    int i27 = g.this.Z0;
                    if (!z10) {
                        if (i27 != 0) {
                            if (i27 != 1) {
                                if (i27 == 2) {
                                    d dVar10 = eVar7.B;
                                    if (z12) {
                                        dVar10.a(this.f19227d, this.f19231h);
                                        eVar7.D.a(this.f19229f, this.f19233j);
                                    } else {
                                        dVar10.a(eVar6.B, 0);
                                    }
                                }
                            }
                            dVar3 = eVar7.D;
                            dVar4 = eVar6.D;
                        } else {
                            dVar3 = eVar7.B;
                            dVar4 = eVar6.B;
                        }
                        dVar3.a(dVar4, 0);
                    } else if (i27 == 0) {
                        dVar5 = eVar7.D;
                        dVar6 = eVar6.D;
                        dVar5.a(dVar6, 0);
                    } else if (i27 == 1) {
                        dVar5 = eVar7.B;
                        dVar6 = eVar6.B;
                        dVar5.a(dVar6, 0);
                    } else if (i27 == 2) {
                        eVar7.B.a(eVar6.B, 0);
                        dVar5 = eVar7.D;
                        dVar6 = eVar6.D;
                        dVar5.a(dVar6, 0);
                    }
                }
                i25++;
                eVar3 = eVar7;
            }
        }

        public int e() {
            return this.f19224a == 1 ? this.f19236m - g.this.Y0 : this.f19236m;
        }

        public int f() {
            return this.f19224a == 0 ? this.f19235l - g.this.X0 : this.f19235l;
        }

        public void g(int i10) {
            g gVar;
            e.b bVarY;
            int iP;
            e.b bVarM;
            int iV;
            int i11 = this.f19239p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f19238o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f19237n + i14 < g.this.f19223j1; i14++) {
                e eVar = g.this.f19222i1[this.f19237n + i14];
                if (this.f19224a == 0) {
                    if (eVar != null && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.f19179l == 0) {
                        gVar = g.this;
                        bVarY = e.b.FIXED;
                        bVarM = eVar.M();
                        iV = eVar.v();
                        iP = i13;
                        gVar.T0(eVar, bVarY, iP, bVarM, iV);
                    }
                } else if (eVar != null && eVar.M() == e.b.MATCH_CONSTRAINT && eVar.f19181m == 0) {
                    gVar = g.this;
                    bVarY = eVar.y();
                    iP = eVar.P();
                    bVarM = e.b.FIXED;
                    iV = i13;
                    gVar.T0(eVar, bVarY, iP, bVarM, iV);
                }
            }
            h();
        }

        public final void h() {
            this.f19235l = 0;
            this.f19236m = 0;
            this.f19225b = null;
            this.f19226c = 0;
            int i10 = this.f19238o;
            for (int i11 = 0; i11 < i10 && this.f19237n + i11 < g.this.f19223j1; i11++) {
                e eVar = g.this.f19222i1[this.f19237n + i11];
                if (this.f19224a == 0) {
                    int iP = eVar.P();
                    int i12 = g.this.X0;
                    if (eVar.O() == 8) {
                        i12 = 0;
                    }
                    this.f19235l += iP + i12;
                    int iA1 = g.this.A1(eVar, this.f19240q);
                    if (this.f19225b == null || this.f19226c < iA1) {
                        this.f19225b = eVar;
                        this.f19226c = iA1;
                        this.f19236m = iA1;
                    }
                } else {
                    int iB1 = g.this.B1(eVar, this.f19240q);
                    int iA2 = g.this.A1(eVar, this.f19240q);
                    int i13 = g.this.Y0;
                    if (eVar.O() == 8) {
                        i13 = 0;
                    }
                    this.f19236m += iA2 + i13;
                    if (this.f19225b == null || this.f19226c < iB1) {
                        this.f19225b = eVar;
                        this.f19226c = iB1;
                        this.f19235l = iB1;
                    }
                }
            }
        }

        public void i(int i10) {
            this.f19237n = i10;
        }

        public void j(int i10, d dVar, d dVar2, d dVar3, d dVar4, int i11, int i12, int i13, int i14, int i15) {
            this.f19224a = i10;
            this.f19227d = dVar;
            this.f19228e = dVar2;
            this.f19229f = dVar3;
            this.f19230g = dVar4;
            this.f19231h = i11;
            this.f19232i = i12;
            this.f19233j = i13;
            this.f19234k = i14;
            this.f19240q = i15;
        }
    }

    public final int A1(e eVar, int i10) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.M() == e.b.MATCH_CONSTRAINT) {
            int i11 = eVar.f19181m;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (eVar.f19195t * i10);
                if (i12 != eVar.v()) {
                    T0(eVar, eVar.y(), eVar.P(), e.b.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return eVar.v();
            }
            if (i11 == 3) {
                return (int) ((eVar.P() * eVar.Q) + 0.5f);
            }
        }
        return eVar.v();
    }

    public final int B1(e eVar, int i10) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.y() == e.b.MATCH_CONSTRAINT) {
            int i11 = eVar.f19179l;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (eVar.f19189q * i10);
                if (i12 != eVar.P()) {
                    T0(eVar, e.b.FIXED, i12, eVar.M(), eVar.v());
                }
                return i12;
            }
            if (i11 == 1) {
                return eVar.P();
            }
            if (i11 == 3) {
                return (int) ((eVar.v() * eVar.Q) + 0.5f);
            }
        }
        return eVar.P();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x010d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x0115 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:115:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0057 A[ADDED_TO_REGION, EDGE_INSN: B:117:0x0057->B:40:0x0057 BREAK  A[LOOP:1: B:42:0x005a->B:122:0x005a], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0057 A[ADDED_TO_REGION, EDGE_INSN: B:120:0x0057->B:40:0x0057 BREAK  A[LOOP:1: B:42:0x005a->B:122:0x005a], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x00d1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x005e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0068  */
    /* JADX WARN: Code duplicated, block: B:48:0x0076  */
    /* JADX WARN: Code duplicated, block: B:52:0x007e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0086  */
    /* JADX WARN: Code duplicated, block: B:59:0x008e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0095  */
    /* JADX WARN: Code duplicated, block: B:64:0x0098  */
    /* JADX WARN: Code duplicated, block: B:66:0x009d  */
    /* JADX WARN: Code duplicated, block: B:70:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:87:0x00db  */
    /* JADX WARN: Code duplicated, block: B:89:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:95:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x00fa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x010b -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x010d -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0113 -> B:40:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0115 -> B:40:0x0057). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:97:0x00f8
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final void C1(y.e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.g.C1(y.e[], int, int, int, int[]):void");
    }

    public final void D1(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        d dVar;
        int iQ0;
        d dVar2;
        int iO0;
        int i15;
        if (i10 == 0) {
            return;
        }
        this.f19218e1.clear();
        a aVar = new a(i11, this.B, this.C, this.D, this.E, i12);
        this.f19218e1.add(aVar);
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        if (i11 == 0) {
            while (i18 < i10) {
                e eVar = eVarArr[i18];
                int iB1 = B1(eVar, i12);
                if (eVar.y() == e.b.MATCH_CONSTRAINT) {
                    i16++;
                }
                int i19 = i16;
                boolean z10 = (i17 == i12 || (this.X0 + i17) + iB1 > i12) && aVar.f19225b != null;
                if (!z10 && i18 > 0 && (i15 = this.f19216c1) > 0 && i18 % i15 == 0) {
                    z10 = true;
                }
                if (z10) {
                    aVar = new a(i11, this.B, this.C, this.D, this.E, i12);
                    aVar.i(i18);
                    this.f19218e1.add(aVar);
                } else {
                    if (i18 > 0) {
                        i17 += this.X0 + iB1;
                    }
                    aVar.b(eVar);
                    i18++;
                    i16 = i19;
                }
                i17 = iB1;
                aVar.b(eVar);
                i18++;
                i16 = i19;
            }
        } else {
            while (i18 < i10) {
                e eVar2 = eVarArr[i18];
                int iA1 = A1(eVar2, i12);
                if (eVar2.M() == e.b.MATCH_CONSTRAINT) {
                    i16++;
                }
                int i20 = i16;
                boolean z11 = (i17 == i12 || (this.Y0 + i17) + iA1 > i12) && aVar.f19225b != null;
                if (!z11 && i18 > 0 && (i13 = this.f19216c1) > 0 && i18 % i13 == 0) {
                    z11 = true;
                }
                if (z11) {
                    aVar = new a(i11, this.B, this.C, this.D, this.E, i12);
                    aVar.i(i18);
                    this.f19218e1.add(aVar);
                } else {
                    if (i18 > 0) {
                        i17 += this.Y0 + iA1;
                    }
                    aVar.b(eVar2);
                    i18++;
                    i16 = i20;
                }
                i17 = iA1;
                aVar.b(eVar2);
                i18++;
                i16 = i20;
            }
        }
        int size = this.f19218e1.size();
        d dVar3 = this.B;
        d dVar4 = this.C;
        d dVar5 = this.D;
        d dVar6 = this.E;
        int iP0 = P0();
        int iR0 = R0();
        int iQ1 = Q0();
        int iO1 = O0();
        e.b bVarY = y();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z12 = bVarY == bVar || M() == bVar;
        if (i16 > 0 && z12) {
            for (int i21 = 0; i21 < size; i21++) {
                a aVar2 = this.f19218e1.get(i21);
                aVar2.g(i12 - (i11 == 0 ? aVar2.f() : aVar2.e()));
            }
        }
        int i22 = iR0;
        int i23 = iQ1;
        int iE = 0;
        int iF = 0;
        int i24 = 0;
        int i25 = iP0;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i26 = iO1;
        while (i24 < size) {
            a aVar3 = this.f19218e1.get(i24);
            if (i11 == 0) {
                if (i24 < size - 1) {
                    dVar2 = this.f19218e1.get(i24 + 1).f19225b.C;
                    iO0 = 0;
                } else {
                    dVar2 = this.E;
                    iO0 = O0();
                }
                d dVar9 = aVar3.f19225b.E;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i27 = iE;
                d dVar12 = dVar7;
                int i28 = iF;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i14 = i24;
                aVar3.j(i11, dVar10, dVar12, dVar13, dVar2, i25, i22, i23, iO0, i12);
                int iMax = Math.max(i28, aVar3.f());
                iE = i27 + aVar3.e();
                if (i14 > 0) {
                    iE += this.Y0;
                }
                dVar8 = dVar11;
                iF = iMax;
                i22 = 0;
                dVar7 = dVar9;
                dVar = dVar14;
                int i29 = iO0;
                dVar6 = dVar2;
                i26 = i29;
            } else {
                d dVar15 = dVar8;
                int i30 = iE;
                int i31 = iF;
                i14 = i24;
                if (i14 < size - 1) {
                    dVar = this.f19218e1.get(i14 + 1).f19225b.B;
                    iQ0 = 0;
                } else {
                    dVar = this.D;
                    iQ0 = Q0();
                }
                d dVar16 = aVar3.f19225b.D;
                aVar3.j(i11, dVar15, dVar7, dVar, dVar6, i25, i22, iQ0, i26, i12);
                iF = i31 + aVar3.f();
                int iMax2 = Math.max(i30, aVar3.e());
                if (i14 > 0) {
                    iF += this.X0;
                }
                iE = iMax2;
                i25 = 0;
                i23 = iQ0;
                dVar8 = dVar16;
            }
            i24 = i14 + 1;
            dVar5 = dVar;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    public final void E1(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.f19218e1.size() == 0) {
            aVar = new a(i11, this.B, this.C, this.D, this.E, i12);
            this.f19218e1.add(aVar);
        } else {
            a aVar2 = this.f19218e1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i11, this.B, this.C, this.D, this.E, P0(), R0(), Q0(), O0(), i12);
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.b(eVarArr[i13]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void F1(float f10) {
        this.T0 = f10;
    }

    public void G1(int i10) {
        this.N0 = i10;
    }

    public void H1(float f10) {
        this.U0 = f10;
    }

    public void I1(int i10) {
        this.O0 = i10;
    }

    public void J1(int i10) {
        this.Z0 = i10;
    }

    public void K1(float f10) {
        this.R0 = f10;
    }

    public void L1(int i10) {
        this.X0 = i10;
    }

    public void M1(int i10) {
        this.L0 = i10;
    }

    public void N1(float f10) {
        this.V0 = f10;
    }

    public void O1(int i10) {
        this.P0 = i10;
    }

    public void P1(float f10) {
        this.W0 = f10;
    }

    public void Q1(int i10) {
        this.Q0 = i10;
    }

    public void R1(int i10) {
        this.f19216c1 = i10;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // y.l
    public void S0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        boolean z10;
        if (this.f19248x0 > 0 && !U0()) {
            X0(0, 0);
            W0(false);
            return;
        }
        int iP0 = P0();
        int iQ0 = Q0();
        int iR0 = R0();
        int iO0 = O0();
        int[] iArr = new int[2];
        int i16 = (i11 - iP0) - iQ0;
        int i17 = this.f19217d1;
        if (i17 == 1) {
            i16 = (i13 - iR0) - iO0;
        }
        int i18 = i16;
        if (i17 == 0) {
            if (this.L0 == -1) {
                this.L0 = 0;
            }
            if (this.M0 == -1) {
                this.M0 = 0;
            }
        } else {
            if (this.L0 == -1) {
                this.L0 = 0;
            }
            if (this.M0 == -1) {
                this.M0 = 0;
            }
        }
        e[] eVarArr = this.f19247w0;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            i14 = this.f19248x0;
            if (i19 >= i14) {
                break;
            }
            if (this.f19247w0[i19].O() == 8) {
                i20++;
            }
            i19++;
        }
        if (i20 > 0) {
            eVarArr = new e[i14 - i20];
            int i21 = 0;
            for (int i22 = 0; i22 < this.f19248x0; i22++) {
                e eVar = this.f19247w0[i22];
                if (eVar.O() != 8) {
                    eVarArr[i21] = eVar;
                    i21++;
                }
            }
            i15 = i21;
        } else {
            i15 = i14;
        }
        this.f19222i1 = eVarArr;
        this.f19223j1 = i15;
        int i23 = this.f19215b1;
        if (i23 == 0) {
            z10 = true;
            E1(eVarArr, i15, this.f19217d1, i18, iArr);
        } else if (i23 == 1) {
            z10 = true;
            D1(eVarArr, i15, this.f19217d1, i18, iArr);
        } else if (i23 != 2) {
            z10 = true;
        } else {
            z10 = true;
            C1(eVarArr, i15, this.f19217d1, i18, iArr);
        }
        int iMin = iArr[0] + iP0 + iQ0;
        int iMin2 = iArr[z10 ? 1 : 0] + iR0 + iO0;
        if (i10 == 1073741824) {
            iMin = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i11);
        } else if (i10 != 0) {
            iMin = 0;
        }
        if (i12 == 1073741824) {
            iMin2 = i13;
        } else if (i12 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i13);
        } else if (i12 != 0) {
            iMin2 = 0;
        }
        X0(iMin, iMin2);
        E0(iMin);
        h0(iMin2);
        if (this.f19248x0 <= 0) {
            z10 = false;
        }
        W0(z10);
    }

    public void S1(int i10) {
        this.f19217d1 = i10;
    }

    public void T1(int i10) {
        this.f19214a1 = i10;
    }

    public void U1(float f10) {
        this.S0 = f10;
    }

    public void V1(int i10) {
        this.Y0 = i10;
    }

    public void W1(int i10) {
        this.M0 = i10;
    }

    public void X1(int i10) {
        this.f19215b1 = i10;
    }

    @Override // y.e
    public void f(x.d dVar) {
        super.f(dVar);
        boolean zA1 = G() != null ? ((f) G()).a1() : false;
        int i10 = this.f19215b1;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.f19218e1.size();
                int i11 = 0;
                while (i11 < size) {
                    this.f19218e1.get(i11).d(zA1, i11, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 == 2) {
                z1(zA1);
            }
        } else if (this.f19218e1.size() > 0) {
            this.f19218e1.get(0).d(zA1, 0, true);
        }
        W0(false);
    }

    public final void z1(boolean z10) {
        e eVar;
        if (this.f19221h1 == null || this.f19220g1 == null || this.f19219f1 == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f19223j1; i10++) {
            this.f19222i1[i10].Z();
        }
        int[] iArr = this.f19221h1;
        int i11 = iArr[0];
        int i12 = iArr[1];
        e eVar2 = null;
        for (int i13 = 0; i13 < i11; i13++) {
            e eVar3 = this.f19220g1[z10 ? (i11 - i13) - 1 : i13];
            if (eVar3 != null && eVar3.O() != 8) {
                if (i13 == 0) {
                    eVar3.j(eVar3.B, this.B, P0());
                    eVar3.j0(this.L0);
                    eVar3.i0(this.R0);
                }
                if (i13 == i11 - 1) {
                    eVar3.j(eVar3.D, this.D, Q0());
                }
                if (i13 > 0) {
                    eVar3.j(eVar3.B, eVar2.D, this.X0);
                    eVar2.j(eVar2.D, eVar3.B, 0);
                }
                eVar2 = eVar3;
            }
        }
        for (int i14 = 0; i14 < i12; i14++) {
            e eVar4 = this.f19219f1[i14];
            if (eVar4 != null && eVar4.O() != 8) {
                if (i14 == 0) {
                    eVar4.j(eVar4.C, this.C, R0());
                    eVar4.y0(this.M0);
                    eVar4.x0(this.S0);
                }
                if (i14 == i12 - 1) {
                    eVar4.j(eVar4.E, this.E, O0());
                }
                if (i14 > 0) {
                    eVar4.j(eVar4.C, eVar2.E, this.Y0);
                    eVar2.j(eVar2.E, eVar4.C, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = 0; i16 < i12; i16++) {
                int i17 = (i16 * i11) + i15;
                if (this.f19217d1 == 1) {
                    i17 = (i15 * i12) + i16;
                }
                e[] eVarArr = this.f19222i1;
                if (i17 < eVarArr.length && (eVar = eVarArr[i17]) != null && eVar.O() != 8) {
                    e eVar5 = this.f19220g1[i15];
                    e eVar6 = this.f19219f1[i16];
                    if (eVar != eVar5) {
                        eVar.j(eVar.B, eVar5.B, 0);
                        eVar.j(eVar.D, eVar5.D, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.j(eVar.C, eVar6.C, 0);
                        eVar.j(eVar.E, eVar6.E, 0);
                    }
                }
            }
        }
    }
}
