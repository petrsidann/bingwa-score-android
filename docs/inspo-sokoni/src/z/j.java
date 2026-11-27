package z;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f19703k = new int[2];

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19704a;

        static {
            int[] iArr = new int[m.b.values().length];
            f19704a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19704a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19704a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(y.e eVar) {
        super(eVar);
        this.f19723h.f19685e = f.a.LEFT;
        this.f19724i.f19685e = f.a.RIGHT;
        this.f19721f = 0;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0292, code lost:
    
        if (r14 != 1) goto L134;
     */
    @Override // z.m, z.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i10;
        int iG;
        int iG2;
        float f10;
        g gVar;
        int iG3;
        int iG4;
        float f11;
        float fT;
        int i11 = a.f19704a[this.f19725j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            y.e eVar = this.f19717b;
            n(dVar, eVar.B, eVar.D, 0);
            return;
        }
        if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT) {
            y.e eVar2 = this.f19717b;
            int i12 = eVar2.f19179l;
            if (i12 == 2) {
                y.e eVarG = eVar2.G();
                if (eVarG != null) {
                    g gVar2 = eVarG.f19165e.f19720e;
                    if (gVar2.f19690j) {
                        i10 = (int) ((gVar2.f19687g * this.f19717b.f19189q) + 0.5f);
                        this.f19720e.d(i10);
                    }
                }
            } else if (i12 == 3) {
                int i13 = eVar2.f19181m;
                if (i13 == 0 || i13 == 3) {
                    l lVar = eVar2.f19167f;
                    f fVar = lVar.f19723h;
                    f fVar2 = lVar.f19724i;
                    boolean z10 = eVar2.B.f19141d != null;
                    boolean z11 = eVar2.C.f19141d != null;
                    boolean z12 = eVar2.D.f19141d != null;
                    boolean z13 = eVar2.E.f19141d != null;
                    int iU = eVar2.u();
                    if (z10 && z11 && z12 && z13) {
                        float fT2 = this.f19717b.t();
                        if (fVar.f19690j && fVar2.f19690j) {
                            f fVar3 = this.f19723h;
                            if (fVar3.f19683c && this.f19724i.f19683c) {
                                q(f19703k, fVar3.f19692l.get(0).f19687g + this.f19723h.f19686f, this.f19724i.f19692l.get(0).f19687g - this.f19724i.f19686f, fVar.f19687g + fVar.f19686f, fVar2.f19687g - fVar2.f19686f, fT2, iU);
                                this.f19720e.d(f19703k[0]);
                                this.f19717b.f19167f.f19720e.d(f19703k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f19723h;
                        if (fVar4.f19690j) {
                            f fVar5 = this.f19724i;
                            if (fVar5.f19690j) {
                                if (!fVar.f19683c || !fVar2.f19683c) {
                                    return;
                                }
                                q(f19703k, fVar4.f19687g + fVar4.f19686f, fVar5.f19687g - fVar5.f19686f, fVar.f19692l.get(0).f19687g + fVar.f19686f, fVar2.f19692l.get(0).f19687g - fVar2.f19686f, fT2, iU);
                                this.f19720e.d(f19703k[0]);
                                this.f19717b.f19167f.f19720e.d(f19703k[1]);
                            }
                        }
                        f fVar6 = this.f19723h;
                        if (!fVar6.f19683c || !this.f19724i.f19683c || !fVar.f19683c || !fVar2.f19683c) {
                            return;
                        }
                        q(f19703k, fVar6.f19692l.get(0).f19687g + this.f19723h.f19686f, this.f19724i.f19692l.get(0).f19687g - this.f19724i.f19686f, fVar.f19692l.get(0).f19687g + fVar.f19686f, fVar2.f19692l.get(0).f19687g - fVar2.f19686f, fT2, iU);
                        this.f19720e.d(f19703k[0]);
                        gVar = this.f19717b.f19167f.f19720e;
                        iG = f19703k[1];
                    } else if (z10 && z12) {
                        if (!this.f19723h.f19683c || !this.f19724i.f19683c) {
                            return;
                        }
                        float fT3 = this.f19717b.t();
                        int i14 = this.f19723h.f19692l.get(0).f19687g + this.f19723h.f19686f;
                        int i15 = this.f19724i.f19692l.get(0).f19687g - this.f19724i.f19686f;
                        if (iU == -1 || iU == 0) {
                            iG3 = g(i15 - i14, 0);
                            int i16 = (int) ((iG3 * fT3) + 0.5f);
                            iG4 = g(i16, 1);
                            if (i16 != iG4) {
                                f11 = iG4 / fT3;
                                iG3 = (int) (f11 + 0.5f);
                            }
                            this.f19720e.d(iG3);
                            this.f19717b.f19167f.f19720e.d(iG4);
                        } else if (iU == 1) {
                            iG3 = g(i15 - i14, 0);
                            int i17 = (int) ((iG3 / fT3) + 0.5f);
                            iG4 = g(i17, 1);
                            if (i17 != iG4) {
                                f11 = iG4 * fT3;
                                iG3 = (int) (f11 + 0.5f);
                            }
                            this.f19720e.d(iG3);
                            this.f19717b.f19167f.f19720e.d(iG4);
                        }
                    } else if (z11 && z13) {
                        if (!fVar.f19683c || !fVar2.f19683c) {
                            return;
                        }
                        float fT4 = this.f19717b.t();
                        int i18 = fVar.f19692l.get(0).f19687g + fVar.f19686f;
                        int i19 = fVar2.f19692l.get(0).f19687g - fVar2.f19686f;
                        if (iU == -1) {
                            iG = g(i19 - i18, 1);
                            int i20 = (int) ((iG / fT4) + 0.5f);
                            iG2 = g(i20, 0);
                            if (i20 != iG2) {
                                f10 = iG2 * fT4;
                                iG = (int) (f10 + 0.5f);
                            }
                            this.f19720e.d(iG2);
                            gVar = this.f19717b.f19167f.f19720e;
                        } else if (iU == 0) {
                            iG = g(i19 - i18, 1);
                            int i21 = (int) ((iG * fT4) + 0.5f);
                            iG2 = g(i21, 0);
                            if (i21 != iG2) {
                                f10 = iG2 / fT4;
                                iG = (int) (f10 + 0.5f);
                            }
                            this.f19720e.d(iG2);
                            gVar = this.f19717b.f19167f.f19720e;
                        }
                    }
                    gVar.d(iG);
                } else {
                    int iU2 = eVar2.u();
                    if (iU2 == -1) {
                        y.e eVar3 = this.f19717b;
                        fT = eVar3.f19167f.f19720e.f19687g * eVar3.t();
                        i10 = (int) (fT + 0.5f);
                    } else if (iU2 == 0) {
                        y.e eVar4 = this.f19717b;
                        fT = eVar4.f19167f.f19720e.f19687g / eVar4.t();
                        i10 = (int) (fT + 0.5f);
                    } else if (iU2 != 1) {
                        i10 = 0;
                    } else {
                        y.e eVar5 = this.f19717b;
                        fT = eVar5.f19167f.f19720e.f19687g * eVar5.t();
                        i10 = (int) (fT + 0.5f);
                    }
                    this.f19720e.d(i10);
                }
            }
        }
        f fVar7 = this.f19723h;
        if (fVar7.f19683c) {
            f fVar8 = this.f19724i;
            if (fVar8.f19683c) {
                if (fVar7.f19690j && fVar8.f19690j && this.f19720e.f19690j) {
                    return;
                }
                if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT) {
                    y.e eVar6 = this.f19717b;
                    if (eVar6.f19179l == 0 && !eVar6.V()) {
                        f fVar9 = this.f19723h.f19692l.get(0);
                        f fVar10 = this.f19724i.f19692l.get(0);
                        int i22 = fVar9.f19687g;
                        f fVar11 = this.f19723h;
                        int i23 = i22 + fVar11.f19686f;
                        int i24 = fVar10.f19687g + this.f19724i.f19686f;
                        fVar11.d(i23);
                        this.f19724i.d(i24);
                        this.f19720e.d(i24 - i23);
                        return;
                    }
                }
                if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT && this.f19716a == 1 && this.f19723h.f19692l.size() > 0 && this.f19724i.f19692l.size() > 0) {
                    int iMin = Math.min((this.f19724i.f19692l.get(0).f19687g + this.f19724i.f19686f) - (this.f19723h.f19692l.get(0).f19687g + this.f19723h.f19686f), this.f19720e.f19702m);
                    y.e eVar7 = this.f19717b;
                    int i25 = eVar7.f19187p;
                    int iMax = Math.max(eVar7.f19185o, iMin);
                    if (i25 > 0) {
                        iMax = Math.min(i25, iMax);
                    }
                    this.f19720e.d(iMax);
                }
                if (this.f19720e.f19690j) {
                    f fVar12 = this.f19723h.f19692l.get(0);
                    f fVar13 = this.f19724i.f19692l.get(0);
                    int i26 = fVar12.f19687g + this.f19723h.f19686f;
                    int i27 = fVar13.f19687g + this.f19724i.f19686f;
                    float fW = this.f19717b.w();
                    if (fVar12 == fVar13) {
                        i26 = fVar12.f19687g;
                        i27 = fVar13.f19687g;
                        fW = 0.5f;
                    }
                    this.f19723h.d((int) (i26 + 0.5f + (((i27 - i26) - this.f19720e.f19687g) * fW)));
                    this.f19724i.d(this.f19723h.f19687g + this.f19720e.f19687g);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0331  */
    /* JADX WARN: Code duplicated, block: B:104:0x0337  */
    /* JADX WARN: Code duplicated, block: B:105:0x0344  */
    /* JADX WARN: Code duplicated, block: B:107:0x034a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0350  */
    /* JADX WARN: Code duplicated, block: B:110:0x036b  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x0238  */
    /* JADX WARN: Code duplicated, block: B:82:0x0240  */
    /* JADX WARN: Code duplicated, block: B:83:0x0259  */
    /* JADX WARN: Code duplicated, block: B:84:0x0260  */
    /* JADX WARN: Code duplicated, block: B:87:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:90:0x02b5  */
    @Override // z.m
    public void d() {
        y.e eVarG;
        y.e eVar;
        y.d[] dVarArr;
        y.d dVar;
        y.d dVar2;
        y.d dVar3;
        f fVarH;
        f fVar;
        int iQ;
        f fVarH2;
        f fVar2;
        y.d dVar4;
        y.e eVar2;
        int i10;
        y.e eVarG2;
        List<d> list;
        d dVar5;
        f fVar3;
        f fVarH3;
        f fVar4;
        int iQ2;
        f fVar5;
        f fVar6;
        int i11;
        y.e eVarG3;
        y.e eVar3 = this.f19717b;
        if (eVar3.f19157a) {
            this.f19720e.d(eVar3.P());
        }
        if (this.f19720e.f19690j) {
            y.e.b bVar = this.f19719d;
            y.e.b bVar2 = y.e.b.MATCH_PARENT;
            if (bVar == bVar2 && (((eVarG = this.f19717b.G()) != null && eVarG.y() == y.e.b.FIXED) || eVarG.y() == bVar2)) {
                b(this.f19723h, eVarG.f19165e.f19723h, this.f19717b.B.c());
                b(this.f19724i, eVarG.f19165e.f19724i, -this.f19717b.D.c());
                return;
            }
        } else {
            y.e.b bVarY = this.f19717b.y();
            this.f19719d = bVarY;
            if (bVarY != y.e.b.MATCH_CONSTRAINT) {
                y.e.b bVar3 = y.e.b.MATCH_PARENT;
                if (bVarY == bVar3 && (((eVarG3 = this.f19717b.G()) != null && eVarG3.y() == y.e.b.FIXED) || eVarG3.y() == bVar3)) {
                    int iP = (eVarG3.P() - this.f19717b.B.c()) - this.f19717b.D.c();
                    b(this.f19723h, eVarG3.f19165e.f19723h, this.f19717b.B.c());
                    b(this.f19724i, eVarG3.f19165e.f19724i, -this.f19717b.D.c());
                    this.f19720e.d(iP);
                    return;
                }
                if (this.f19719d == y.e.b.FIXED) {
                    this.f19720e.d(this.f19717b.P());
                }
            }
        }
        g gVar = this.f19720e;
        if (!gVar.f19690j) {
            if (this.f19719d == y.e.b.MATCH_CONSTRAINT) {
                eVar2 = this.f19717b;
                i10 = eVar2.f19179l;
                if (i10 != 2) {
                    eVarG2 = eVar2.G();
                    if (eVarG2 != null) {
                        g gVar2 = eVarG2.f19167f.f19720e;
                        this.f19720e.f19692l.add(gVar2);
                        gVar2.f19691k.add(this.f19720e);
                        g gVar3 = this.f19720e;
                        gVar3.f19682b = true;
                        gVar3.f19691k.add(this.f19723h);
                        list = this.f19720e.f19691k;
                        dVar5 = this.f19724i;
                        list.add(dVar5);
                    }
                } else if (i10 == 3) {
                    if (eVar2.f19181m == 3) {
                        this.f19723h.f19681a = this;
                        this.f19724i.f19681a = this;
                        l lVar = eVar2.f19167f;
                        lVar.f19723h.f19681a = this;
                        lVar.f19724i.f19681a = this;
                        gVar.f19681a = this;
                        if (eVar2.X()) {
                            this.f19720e.f19692l.add(this.f19717b.f19167f.f19720e);
                            this.f19717b.f19167f.f19720e.f19691k.add(this.f19720e);
                            l lVar2 = this.f19717b.f19167f;
                            lVar2.f19720e.f19681a = this;
                            this.f19720e.f19692l.add(lVar2.f19723h);
                            this.f19720e.f19692l.add(this.f19717b.f19167f.f19724i);
                            this.f19717b.f19167f.f19723h.f19691k.add(this.f19720e);
                            list = this.f19717b.f19167f.f19724i.f19691k;
                            dVar5 = this.f19720e;
                        } else if (this.f19717b.V()) {
                            this.f19717b.f19167f.f19720e.f19692l.add(this.f19720e);
                            list = this.f19720e.f19691k;
                            dVar5 = this.f19717b.f19167f.f19720e;
                        } else {
                            fVar3 = this.f19717b.f19167f.f19720e;
                        }
                        list.add(dVar5);
                    } else {
                        g gVar4 = eVar2.f19167f.f19720e;
                        gVar.f19692l.add(gVar4);
                        gVar4.f19691k.add(this.f19720e);
                        this.f19717b.f19167f.f19723h.f19691k.add(this.f19720e);
                        this.f19717b.f19167f.f19724i.f19691k.add(this.f19720e);
                        g gVar5 = this.f19720e;
                        gVar5.f19682b = true;
                        gVar5.f19691k.add(this.f19723h);
                        this.f19720e.f19691k.add(this.f19724i);
                        this.f19723h.f19692l.add(this.f19720e);
                        fVar3 = this.f19724i;
                    }
                    list = fVar3.f19692l;
                    dVar5 = this.f19720e;
                    list.add(dVar5);
                }
            }
            eVar = this.f19717b;
            dVarArr = eVar.J;
            dVar = dVarArr[0];
            dVar2 = dVar.f19141d;
            if (dVar2 != null) {
            }
            if (dVar2 == null) {
                dVar3 = dVarArr[1];
                if (dVar3.f19141d == null) {
                    if (eVar instanceof y.i) {
                        return;
                    } else {
                        return;
                    }
                }
                fVarH2 = h(dVar3);
                if (fVarH2 != null) {
                    b(this.f19724i, fVarH2, -this.f19717b.J[1].c());
                    c(this.f19723h, this.f19724i, -1, this.f19720e);
                    return;
                }
                return;
            }
            fVarH = h(dVar);
            if (fVarH != null) {
                return;
            }
            fVar = this.f19723h;
            iQ = this.f19717b.J[0].c();
            b(fVar, fVarH, iQ);
            c(this.f19724i, this.f19723h, 1, this.f19720e);
            return;
        }
        y.e eVar4 = this.f19717b;
        if (eVar4.f19157a) {
            y.d[] dVarArr2 = eVar4.J;
            y.d dVar6 = dVarArr2[0];
            y.d dVar7 = dVar6.f19141d;
            if (dVar7 == null || dVarArr2[1].f19141d == null) {
                if (dVar7 == null) {
                    y.d dVar8 = dVarArr2[1];
                    if (dVar8.f19141d != null) {
                        f fVarH4 = h(dVar8);
                        if (fVarH4 == null) {
                            return;
                        }
                        b(this.f19724i, fVarH4, -this.f19717b.J[1].c());
                        fVar5 = this.f19723h;
                        fVar6 = this.f19724i;
                        i11 = -this.f19720e.f19687g;
                    } else {
                        if ((eVar4 instanceof y.i) || eVar4.G() == null || this.f19717b.m(y.d.b.CENTER).f19141d != null) {
                            return;
                        }
                        fVarH3 = this.f19717b.G().f19165e.f19723h;
                        fVar4 = this.f19723h;
                        iQ2 = this.f19717b.Q();
                    }
                    b(fVar5, fVar6, i11);
                    return;
                }
                fVarH3 = h(dVar6);
                if (fVarH3 == null) {
                    return;
                }
                fVar4 = this.f19723h;
                iQ2 = this.f19717b.J[0].c();
                b(fVar4, fVarH3, iQ2);
                fVar5 = this.f19724i;
                fVar6 = this.f19723h;
                i11 = this.f19720e.f19687g;
                b(fVar5, fVar6, i11);
                return;
            }
            if (!eVar4.V()) {
                f fVarH5 = h(this.f19717b.J[0]);
                if (fVarH5 != null) {
                    b(this.f19723h, fVarH5, this.f19717b.J[0].c());
                }
                f fVarH6 = h(this.f19717b.J[1]);
                if (fVarH6 != null) {
                    b(this.f19724i, fVarH6, -this.f19717b.J[1].c());
                }
                this.f19723h.f19682b = true;
                this.f19724i.f19682b = true;
                return;
            }
            this.f19723h.f19686f = this.f19717b.J[0].c();
            fVar2 = this.f19724i;
            dVar4 = this.f19717b.J[1];
        } else {
            if (this.f19719d == y.e.b.MATCH_CONSTRAINT) {
                eVar2 = this.f19717b;
                i10 = eVar2.f19179l;
                if (i10 != 2) {
                    eVarG2 = eVar2.G();
                    if (eVarG2 != null) {
                        g gVar6 = eVarG2.f19167f.f19720e;
                        this.f19720e.f19692l.add(gVar6);
                        gVar6.f19691k.add(this.f19720e);
                        g gVar7 = this.f19720e;
                        gVar7.f19682b = true;
                        gVar7.f19691k.add(this.f19723h);
                        list = this.f19720e.f19691k;
                        dVar5 = this.f19724i;
                        list.add(dVar5);
                    }
                } else if (i10 == 3) {
                    if (eVar2.f19181m == 3) {
                        this.f19723h.f19681a = this;
                        this.f19724i.f19681a = this;
                        l lVar3 = eVar2.f19167f;
                        lVar3.f19723h.f19681a = this;
                        lVar3.f19724i.f19681a = this;
                        gVar.f19681a = this;
                        if (eVar2.X()) {
                            this.f19720e.f19692l.add(this.f19717b.f19167f.f19720e);
                            this.f19717b.f19167f.f19720e.f19691k.add(this.f19720e);
                            l lVar4 = this.f19717b.f19167f;
                            lVar4.f19720e.f19681a = this;
                            this.f19720e.f19692l.add(lVar4.f19723h);
                            this.f19720e.f19692l.add(this.f19717b.f19167f.f19724i);
                            this.f19717b.f19167f.f19723h.f19691k.add(this.f19720e);
                            list = this.f19717b.f19167f.f19724i.f19691k;
                            dVar5 = this.f19720e;
                        } else if (this.f19717b.V()) {
                            this.f19717b.f19167f.f19720e.f19692l.add(this.f19720e);
                            list = this.f19720e.f19691k;
                            dVar5 = this.f19717b.f19167f.f19720e;
                        } else {
                            fVar3 = this.f19717b.f19167f.f19720e;
                        }
                        list.add(dVar5);
                    } else {
                        g gVar8 = eVar2.f19167f.f19720e;
                        gVar.f19692l.add(gVar8);
                        gVar8.f19691k.add(this.f19720e);
                        this.f19717b.f19167f.f19723h.f19691k.add(this.f19720e);
                        this.f19717b.f19167f.f19724i.f19691k.add(this.f19720e);
                        g gVar9 = this.f19720e;
                        gVar9.f19682b = true;
                        gVar9.f19691k.add(this.f19723h);
                        this.f19720e.f19691k.add(this.f19724i);
                        this.f19723h.f19692l.add(this.f19720e);
                        fVar3 = this.f19724i;
                    }
                    list = fVar3.f19692l;
                    dVar5 = this.f19720e;
                    list.add(dVar5);
                }
            }
            eVar = this.f19717b;
            dVarArr = eVar.J;
            dVar = dVarArr[0];
            dVar2 = dVar.f19141d;
            if (dVar2 != null || dVarArr[1].f19141d == null) {
                if (dVar2 == null) {
                    fVarH = h(dVar);
                    if (fVarH != null) {
                        return;
                    }
                    fVar = this.f19723h;
                    iQ = this.f19717b.J[0].c();
                } else {
                    dVar3 = dVarArr[1];
                    if (dVar3.f19141d == null) {
                        fVarH2 = h(dVar3);
                        if (fVarH2 != null) {
                            b(this.f19724i, fVarH2, -this.f19717b.J[1].c());
                            c(this.f19723h, this.f19724i, -1, this.f19720e);
                            return;
                        }
                        return;
                    }
                    if ((eVar instanceof y.i) || eVar.G() == null) {
                        return;
                    }
                    fVarH = this.f19717b.G().f19165e.f19723h;
                    fVar = this.f19723h;
                    iQ = this.f19717b.Q();
                }
                b(fVar, fVarH, iQ);
                c(this.f19724i, this.f19723h, 1, this.f19720e);
                return;
            }
            if (!eVar.V()) {
                f fVarH7 = h(this.f19717b.J[0]);
                f fVarH8 = h(this.f19717b.J[1]);
                fVarH7.b(this);
                fVarH8.b(this);
                this.f19725j = m.b.CENTER;
                return;
            }
            this.f19723h.f19686f = this.f19717b.J[0].c();
            fVar2 = this.f19724i;
            dVar4 = this.f19717b.J[1];
        }
        fVar2.f19686f = -dVar4.c();
    }

    @Override // z.m
    public void e() {
        f fVar = this.f19723h;
        if (fVar.f19690j) {
            this.f19717b.F0(fVar.f19687g);
        }
    }

    @Override // z.m
    public void f() {
        this.f19718c = null;
        this.f19723h.c();
        this.f19724i.c();
        this.f19720e.c();
        this.f19722g = false;
    }

    @Override // z.m
    public boolean m() {
        return this.f19719d != y.e.b.MATCH_CONSTRAINT || this.f19717b.f19179l == 0;
    }

    public final void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    public void r() {
        this.f19722g = false;
        this.f19723h.c();
        this.f19723h.f19690j = false;
        this.f19724i.c();
        this.f19724i.f19690j = false;
        this.f19720e.f19690j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f19717b.r();
    }
}
