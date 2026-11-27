package z;

/* JADX INFO: loaded from: classes.dex */
public class l extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f19713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f19714l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19715a;

        static {
            int[] iArr = new int[m.b.values().length];
            f19715a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19715a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19715a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(y.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f19713k = fVar;
        this.f19714l = null;
        this.f19723h.f19685e = f.a.TOP;
        this.f19724i.f19685e = f.a.BOTTOM;
        fVar.f19685e = f.a.BASELINE;
        this.f19721f = 1;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    @Override // z.m, z.d
    public void a(d dVar) {
        int i10;
        float fT;
        int i11 = a.f19715a[this.f19725j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            y.e eVar = this.f19717b;
            n(dVar, eVar.C, eVar.E, 1);
            return;
        }
        g gVar = this.f19720e;
        if (gVar.f19683c && !gVar.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT) {
            y.e eVar2 = this.f19717b;
            int i12 = eVar2.f19181m;
            if (i12 == 2) {
                y.e eVarG = eVar2.G();
                if (eVarG != null) {
                    g gVar2 = eVarG.f19167f.f19720e;
                    if (gVar2.f19690j) {
                        i10 = (int) ((gVar2.f19687g * this.f19717b.f19195t) + 0.5f);
                        this.f19720e.d(i10);
                    }
                }
            } else if (i12 == 3 && eVar2.f19165e.f19720e.f19690j) {
                int iU = eVar2.u();
                if (iU == -1) {
                    y.e eVar3 = this.f19717b;
                    fT = eVar3.f19165e.f19720e.f19687g / eVar3.t();
                    i10 = (int) (fT + 0.5f);
                } else if (iU == 0) {
                    y.e eVar4 = this.f19717b;
                    fT = eVar4.f19165e.f19720e.f19687g * eVar4.t();
                    i10 = (int) (fT + 0.5f);
                } else if (iU != 1) {
                    i10 = 0;
                } else {
                    y.e eVar5 = this.f19717b;
                    fT = eVar5.f19165e.f19720e.f19687g / eVar5.t();
                    i10 = (int) (fT + 0.5f);
                }
                this.f19720e.d(i10);
            }
        }
        f fVar = this.f19723h;
        if (fVar.f19683c) {
            f fVar2 = this.f19724i;
            if (fVar2.f19683c) {
                if (fVar.f19690j && fVar2.f19690j && this.f19720e.f19690j) {
                    return;
                }
                if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT) {
                    y.e eVar6 = this.f19717b;
                    if (eVar6.f19179l == 0 && !eVar6.X()) {
                        f fVar3 = this.f19723h.f19692l.get(0);
                        f fVar4 = this.f19724i.f19692l.get(0);
                        int i13 = fVar3.f19687g;
                        f fVar5 = this.f19723h;
                        int i14 = i13 + fVar5.f19686f;
                        int i15 = fVar4.f19687g + this.f19724i.f19686f;
                        fVar5.d(i14);
                        this.f19724i.d(i15);
                        this.f19720e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT && this.f19716a == 1 && this.f19723h.f19692l.size() > 0 && this.f19724i.f19692l.size() > 0) {
                    f fVar6 = this.f19723h.f19692l.get(0);
                    int i16 = (this.f19724i.f19692l.get(0).f19687g + this.f19724i.f19686f) - (fVar6.f19687g + this.f19723h.f19686f);
                    g gVar3 = this.f19720e;
                    int i17 = gVar3.f19702m;
                    if (i16 < i17) {
                        gVar3.d(i16);
                    } else {
                        gVar3.d(i17);
                    }
                }
                if (this.f19720e.f19690j && this.f19723h.f19692l.size() > 0 && this.f19724i.f19692l.size() > 0) {
                    f fVar7 = this.f19723h.f19692l.get(0);
                    f fVar8 = this.f19724i.f19692l.get(0);
                    int i18 = fVar7.f19687g + this.f19723h.f19686f;
                    int i19 = fVar8.f19687g + this.f19724i.f19686f;
                    float fK = this.f19717b.K();
                    if (fVar7 == fVar8) {
                        i18 = fVar7.f19687g;
                        i19 = fVar8.f19687g;
                        fK = 0.5f;
                    }
                    this.f19723h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f19720e.f19687g) * fK)));
                    this.f19724i.d(this.f19723h.f19687g + this.f19720e.f19687g);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x03d5 A[PHI: r0
  0x03d5: PHI (r0v32 z.j) = (r0v23 z.j), (r0v47 z.j) binds: [B:150:0x03d3, B:124:0x032e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02d9, code lost:
    
        if (r10.f19717b.S() != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02db, code lost:
    
        r0 = r10.f19713k;
        r1 = r10.f19723h;
        r2 = r10.f19714l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x035e, code lost:
    
        if (r10.f19717b.S() != false) goto L110;
     */
    @Override // z.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        y.e eVarG;
        j jVar;
        m mVar;
        f fVar;
        f fVar2;
        int iN;
        y.e eVarG2;
        y.e eVar = this.f19717b;
        if (eVar.f19157a) {
            this.f19720e.d(eVar.v());
        }
        if (!this.f19720e.f19690j) {
            this.f19719d = this.f19717b.M();
            if (this.f19717b.S()) {
                this.f19714l = new z.a(this);
            }
            y.e.b bVar = this.f19719d;
            if (bVar != y.e.b.MATCH_CONSTRAINT) {
                if (bVar == y.e.b.MATCH_PARENT && (eVarG2 = this.f19717b.G()) != null && eVarG2.M() == y.e.b.FIXED) {
                    int iV = (eVarG2.v() - this.f19717b.C.c()) - this.f19717b.E.c();
                    b(this.f19723h, eVarG2.f19167f.f19723h, this.f19717b.C.c());
                    b(this.f19724i, eVarG2.f19167f.f19724i, -this.f19717b.E.c());
                    this.f19720e.d(iV);
                    return;
                }
                if (this.f19719d == y.e.b.FIXED) {
                    this.f19720e.d(this.f19717b.v());
                }
            }
        } else if (this.f19719d == y.e.b.MATCH_PARENT && (eVarG = this.f19717b.G()) != null && eVarG.M() == y.e.b.FIXED) {
            b(this.f19723h, eVarG.f19167f.f19723h, this.f19717b.C.c());
            b(this.f19724i, eVarG.f19167f.f19724i, -this.f19717b.E.c());
            return;
        }
        g gVar = this.f19720e;
        boolean z10 = gVar.f19690j;
        if (z10) {
            y.e eVar2 = this.f19717b;
            if (eVar2.f19157a) {
                y.d[] dVarArr = eVar2.J;
                y.d dVar = dVarArr[2];
                y.d dVar2 = dVar.f19141d;
                if (dVar2 != null && dVarArr[3].f19141d != null) {
                    if (eVar2.X()) {
                        this.f19723h.f19686f = this.f19717b.J[2].c();
                        this.f19724i.f19686f = -this.f19717b.J[3].c();
                    } else {
                        f fVarH = h(this.f19717b.J[2]);
                        if (fVarH != null) {
                            b(this.f19723h, fVarH, this.f19717b.J[2].c());
                        }
                        f fVarH2 = h(this.f19717b.J[3]);
                        if (fVarH2 != null) {
                            b(this.f19724i, fVarH2, -this.f19717b.J[3].c());
                        }
                        this.f19723h.f19682b = true;
                        this.f19724i.f19682b = true;
                    }
                    if (!this.f19717b.S()) {
                        return;
                    }
                } else if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 == null) {
                        return;
                    }
                    b(this.f19723h, fVarH3, this.f19717b.J[2].c());
                    b(this.f19724i, this.f19723h, this.f19720e.f19687g);
                    if (!this.f19717b.S()) {
                        return;
                    }
                } else {
                    y.d dVar3 = dVarArr[3];
                    if (dVar3.f19141d == null) {
                        y.d dVar4 = dVarArr[4];
                        if (dVar4.f19141d != null) {
                            f fVarH4 = h(dVar4);
                            if (fVarH4 == null) {
                                return;
                            }
                            b(this.f19713k, fVarH4, 0);
                            b(this.f19723h, this.f19713k, -this.f19717b.n());
                            fVar = this.f19724i;
                            fVar2 = this.f19723h;
                            iN = this.f19720e.f19687g;
                        } else {
                            if ((eVar2 instanceof y.i) || eVar2.G() == null || this.f19717b.m(y.d.b.CENTER).f19141d != null) {
                                return;
                            }
                            b(this.f19723h, this.f19717b.G().f19167f.f19723h, this.f19717b.R());
                            b(this.f19724i, this.f19723h, this.f19720e.f19687g);
                            if (!this.f19717b.S()) {
                                return;
                            }
                        }
                        b(fVar, fVar2, iN);
                        return;
                    }
                    f fVarH5 = h(dVar3);
                    if (fVarH5 != null) {
                        b(this.f19724i, fVarH5, -this.f19717b.J[3].c());
                        b(this.f19723h, this.f19724i, -this.f19720e.f19687g);
                    }
                    if (!this.f19717b.S()) {
                        return;
                    }
                }
                fVar = this.f19713k;
                fVar2 = this.f19723h;
                iN = this.f19717b.n();
                b(fVar, fVar2, iN);
                return;
            }
        }
        if (z10 || this.f19719d != y.e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            y.e eVar3 = this.f19717b;
            int i10 = eVar3.f19181m;
            if (i10 == 2) {
                y.e eVarG3 = eVar3.G();
                if (eVarG3 != null) {
                    mVar = eVarG3.f19167f;
                    g gVar2 = mVar.f19720e;
                    this.f19720e.f19692l.add(gVar2);
                    gVar2.f19691k.add(this.f19720e);
                    g gVar3 = this.f19720e;
                    gVar3.f19682b = true;
                    gVar3.f19691k.add(this.f19723h);
                    this.f19720e.f19691k.add(this.f19724i);
                }
            } else if (i10 == 3 && !eVar3.X()) {
                y.e eVar4 = this.f19717b;
                if (eVar4.f19179l != 3) {
                    mVar = eVar4.f19165e;
                    g gVar4 = mVar.f19720e;
                    this.f19720e.f19692l.add(gVar4);
                    gVar4.f19691k.add(this.f19720e);
                    g gVar5 = this.f19720e;
                    gVar5.f19682b = true;
                    gVar5.f19691k.add(this.f19723h);
                    this.f19720e.f19691k.add(this.f19724i);
                }
            }
        }
        y.e eVar5 = this.f19717b;
        y.d[] dVarArr2 = eVar5.J;
        y.d dVar5 = dVarArr2[2];
        y.d dVar6 = dVar5.f19141d;
        if (dVar6 == null || dVarArr2[3].f19141d == null) {
            if (dVar6 != null) {
                f fVarH6 = h(dVar5);
                if (fVarH6 != null) {
                    b(this.f19723h, fVarH6, this.f19717b.J[2].c());
                    c(this.f19724i, this.f19723h, 1, this.f19720e);
                    if (this.f19717b.S()) {
                        c(this.f19713k, this.f19723h, 1, this.f19714l);
                    }
                    y.e.b bVar2 = this.f19719d;
                    y.e.b bVar3 = y.e.b.MATCH_CONSTRAINT;
                    if (bVar2 == bVar3 && this.f19717b.t() > 0.0f) {
                        jVar = this.f19717b.f19165e;
                        if (jVar.f19719d == bVar3) {
                            jVar.f19720e.f19691k.add(this.f19720e);
                            this.f19720e.f19692l.add(this.f19717b.f19165e.f19720e);
                            this.f19720e.f19681a = this;
                        }
                    }
                }
            } else {
                y.d dVar7 = dVarArr2[3];
                if (dVar7.f19141d != null) {
                    f fVarH7 = h(dVar7);
                    if (fVarH7 != null) {
                        b(this.f19724i, fVarH7, -this.f19717b.J[3].c());
                        c(this.f19723h, this.f19724i, -1, this.f19720e);
                    }
                } else {
                    y.d dVar8 = dVarArr2[4];
                    if (dVar8.f19141d != null) {
                        f fVarH8 = h(dVar8);
                        if (fVarH8 != null) {
                            b(this.f19713k, fVarH8, 0);
                            c(this.f19723h, this.f19713k, -1, this.f19714l);
                            f fVar3 = this.f19724i;
                            f fVar4 = this.f19723h;
                            g gVar6 = this.f19720e;
                            c(fVar3, fVar4, 1, gVar6);
                        }
                    } else if (!(eVar5 instanceof y.i) && eVar5.G() != null) {
                        b(this.f19723h, this.f19717b.G().f19167f.f19723h, this.f19717b.R());
                        c(this.f19724i, this.f19723h, 1, this.f19720e);
                        if (this.f19717b.S()) {
                            c(this.f19713k, this.f19723h, 1, this.f19714l);
                        }
                        y.e.b bVar4 = this.f19719d;
                        y.e.b bVar5 = y.e.b.MATCH_CONSTRAINT;
                        if (bVar4 == bVar5 && this.f19717b.t() > 0.0f) {
                            jVar = this.f19717b.f19165e;
                            if (jVar.f19719d == bVar5) {
                                jVar.f19720e.f19691k.add(this.f19720e);
                                this.f19720e.f19692l.add(this.f19717b.f19165e.f19720e);
                                this.f19720e.f19681a = this;
                            }
                        }
                    }
                }
            }
        } else if (eVar5.X()) {
            this.f19723h.f19686f = this.f19717b.J[2].c();
            this.f19724i.f19686f = -this.f19717b.J[3].c();
        } else {
            f fVarH9 = h(this.f19717b.J[2]);
            f fVarH10 = h(this.f19717b.J[3]);
            fVarH9.b(this);
            fVarH10.b(this);
            this.f19725j = m.b.CENTER;
        }
        if (this.f19720e.f19692l.size() == 0) {
            this.f19720e.f19683c = true;
        }
    }

    @Override // z.m
    public void e() {
        f fVar = this.f19723h;
        if (fVar.f19690j) {
            this.f19717b.G0(fVar.f19687g);
        }
    }

    @Override // z.m
    public void f() {
        this.f19718c = null;
        this.f19723h.c();
        this.f19724i.c();
        this.f19713k.c();
        this.f19720e.c();
        this.f19722g = false;
    }

    @Override // z.m
    public boolean m() {
        return this.f19719d != y.e.b.MATCH_CONSTRAINT || this.f19717b.f19181m == 0;
    }

    public void q() {
        this.f19722g = false;
        this.f19723h.c();
        this.f19723h.f19690j = false;
        this.f19724i.c();
        this.f19724i.f19690j = false;
        this.f19713k.c();
        this.f19713k.f19690j = false;
        this.f19720e.f19690j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f19717b.r();
    }
}
