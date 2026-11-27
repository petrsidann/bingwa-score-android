package z;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y.f f19672a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y.f f19675d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19673b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19674c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<m> f19676e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<k> f19677f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.InterfaceC0341b f19678g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b.a f19679h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<k> f19680i = new ArrayList<>();

    public e(y.f fVar) {
        this.f19672a = fVar;
        this.f19675d = fVar;
    }

    public final void a(f fVar, int i10, int i11, f fVar2, ArrayList<k> arrayList, k kVar) {
        m mVar = fVar.f19684d;
        if (mVar.f19718c == null) {
            y.f fVar3 = this.f19672a;
            if (mVar == fVar3.f19165e || mVar == fVar3.f19167f) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i11);
                arrayList.add(kVar);
            }
            mVar.f19718c = kVar;
            kVar.a(mVar);
            for (d dVar : mVar.f19723h.f19691k) {
                if (dVar instanceof f) {
                    a((f) dVar, i10, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.f19724i.f19691k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i10, 1, fVar2, arrayList, kVar);
                }
            }
            if (i10 == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).f19713k.f19691k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i10, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            for (f fVar4 : mVar.f19723h.f19692l) {
                if (fVar4 == fVar2) {
                    kVar.f19707b = true;
                }
                a(fVar4, i10, 0, fVar2, arrayList, kVar);
            }
            for (f fVar5 : mVar.f19724i.f19692l) {
                if (fVar5 == fVar2) {
                    kVar.f19707b = true;
                }
                a(fVar5, i10, 1, fVar2, arrayList, kVar);
            }
            if (i10 == 1 && (mVar instanceof l)) {
                Iterator<f> it = ((l) mVar).f19713k.f19692l.iterator();
                while (it.hasNext()) {
                    a(it.next(), i10, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:98:0x0141  */
    /* JADX WARN: Code duplicated, block: B:99:0x0143  */
    public final boolean b(y.f fVar) {
        int iP;
        y.e.b bVar;
        int iV;
        y.e.b bVar2;
        y.e.b[] bVarArr;
        y.e.b bVar3;
        g gVar;
        int iV2;
        y.e.b bVar4;
        y.e.b bVar5;
        for (y.e eVar : fVar.f19252w0) {
            y.e.b[] bVarArr2 = eVar.M;
            y.e.b bVar6 = bVarArr2[0];
            y.e.b bVar7 = bVarArr2[1];
            if (eVar.O() != 8) {
                if (eVar.f19189q < 1.0f && bVar6 == y.e.b.MATCH_CONSTRAINT) {
                    eVar.f19179l = 2;
                }
                if (eVar.f19195t < 1.0f && bVar7 == y.e.b.MATCH_CONSTRAINT) {
                    eVar.f19181m = 2;
                }
                if (eVar.t() > 0.0f) {
                    y.e.b bVar8 = y.e.b.MATCH_CONSTRAINT;
                    if (bVar6 == bVar8 && (bVar7 == y.e.b.WRAP_CONTENT || bVar7 == y.e.b.FIXED)) {
                        eVar.f19179l = 3;
                    } else if (bVar7 == bVar8 && (bVar6 == y.e.b.WRAP_CONTENT || bVar6 == y.e.b.FIXED)) {
                        eVar.f19181m = 3;
                    } else if (bVar6 == bVar8 && bVar7 == bVar8) {
                        if (eVar.f19179l == 0) {
                            eVar.f19179l = 3;
                        }
                        if (eVar.f19181m == 0) {
                            eVar.f19181m = 3;
                        }
                    }
                }
                y.e.b bVar9 = y.e.b.MATCH_CONSTRAINT;
                if (bVar6 == bVar9 && eVar.f19179l == 1 && (eVar.B.f19141d == null || eVar.D.f19141d == null)) {
                    bVar6 = y.e.b.WRAP_CONTENT;
                }
                y.e.b bVar10 = bVar6;
                if (bVar7 == bVar9 && eVar.f19181m == 1 && (eVar.C.f19141d == null || eVar.E.f19141d == null)) {
                    bVar7 = y.e.b.WRAP_CONTENT;
                }
                y.e.b bVar11 = bVar7;
                j jVar = eVar.f19165e;
                jVar.f19719d = bVar10;
                int i10 = eVar.f19179l;
                jVar.f19716a = i10;
                l lVar = eVar.f19167f;
                lVar.f19719d = bVar11;
                int i11 = eVar.f19181m;
                lVar.f19716a = i11;
                y.e.b bVar12 = y.e.b.MATCH_PARENT;
                if ((bVar10 == bVar12 || bVar10 == y.e.b.FIXED || bVar10 == y.e.b.WRAP_CONTENT) && (bVar11 == bVar12 || bVar11 == y.e.b.FIXED || bVar11 == y.e.b.WRAP_CONTENT)) {
                    int iP2 = eVar.P();
                    if (bVar10 == bVar12) {
                        iP = (fVar.P() - eVar.B.f19142e) - eVar.D.f19142e;
                        bVar = y.e.b.FIXED;
                    } else {
                        iP = iP2;
                        bVar = bVar10;
                    }
                    int iV3 = eVar.v();
                    if (bVar11 == bVar12) {
                        iV = (fVar.v() - eVar.C.f19142e) - eVar.E.f19142e;
                        bVar2 = y.e.b.FIXED;
                    } else {
                        iV = iV3;
                        bVar2 = bVar11;
                    }
                    this = this;
                    eVar = eVar;
                    this.l(eVar, bVar, iP, bVar2, iV);
                    eVar.f19165e.f19720e.d(eVar.P());
                    eVar.f19167f.f19720e.d(eVar.v());
                } else if (bVar10 == bVar9 && (bVar11 == (bVar5 = y.e.b.WRAP_CONTENT) || bVar11 == y.e.b.FIXED)) {
                    if (i10 == 3) {
                        if (bVar11 == bVar5) {
                            l(eVar, bVar5, 0, bVar5, 0);
                        }
                        iV = eVar.v();
                        iP = (int) ((iV * eVar.Q) + 0.5f);
                    } else {
                        if (i10 == 1) {
                            l(eVar, bVar5, 0, bVar11, 0);
                            gVar = eVar.f19165e.f19720e;
                            iV2 = eVar.P();
                        } else if (i10 == 2) {
                            y.e.b bVar13 = fVar.M[0];
                            bVar5 = y.e.b.FIXED;
                            if (bVar13 == bVar5 || bVar13 == bVar12) {
                                iP = (int) ((eVar.f19189q * fVar.P()) + 0.5f);
                                iV = eVar.v();
                                bVar = bVar5;
                                bVar2 = bVar11;
                                this.l(eVar, bVar, iP, bVar2, iV);
                                eVar.f19165e.f19720e.d(eVar.P());
                                eVar.f19167f.f19720e.d(eVar.v());
                            } else if (bVar11 != bVar9) {
                                if (bVar10 != bVar9) {
                                }
                            } else if (bVar10 != bVar9) {
                            }
                        } else {
                            y.d[] dVarArr = eVar.J;
                            if (dVarArr[0].f19141d == null || dVarArr[1].f19141d == null) {
                                iP = 0;
                                iV = 0;
                                bVar = bVar5;
                                bVar2 = bVar11;
                                this.l(eVar, bVar, iP, bVar2, iV);
                                eVar.f19165e.f19720e.d(eVar.P());
                                eVar.f19167f.f19720e.d(eVar.v());
                            } else if (bVar11 != bVar9) {
                                if (bVar10 != bVar9) {
                                }
                            } else if (bVar10 != bVar9) {
                            }
                        }
                        gVar.f19702m = iV2;
                    }
                    bVar2 = y.e.b.FIXED;
                    this = this;
                    eVar = eVar;
                    bVar = bVar2;
                    this.l(eVar, bVar, iP, bVar2, iV);
                    eVar.f19165e.f19720e.d(eVar.P());
                    eVar.f19167f.f19720e.d(eVar.v());
                } else if (bVar11 != bVar9 && (bVar10 == (bVar4 = y.e.b.WRAP_CONTENT) || bVar10 == y.e.b.FIXED)) {
                    if (i11 == 3) {
                        if (bVar10 == bVar4) {
                            l(eVar, bVar4, 0, bVar4, 0);
                        }
                        iP = eVar.P();
                        float f10 = eVar.Q;
                        if (eVar.u() == -1) {
                            f10 = 1.0f / f10;
                        }
                        iV = (int) ((iP * f10) + 0.5f);
                        bVar2 = y.e.b.FIXED;
                        this = this;
                        eVar = eVar;
                        bVar = bVar2;
                    } else {
                        if (i11 == 1) {
                            l(eVar, bVar10, 0, bVar4, 0);
                        } else {
                            if (i11 == 2) {
                                y.e.b bVar14 = fVar.M[1];
                                bVar2 = y.e.b.FIXED;
                                if (bVar14 == bVar2 || bVar14 == bVar12) {
                                    float f11 = eVar.f19195t;
                                    iP = eVar.P();
                                    this = this;
                                    eVar = eVar;
                                    bVar = bVar10;
                                    iV = (int) ((f11 * fVar.v()) + 0.5f);
                                }
                            } else {
                                y.d[] dVarArr2 = eVar.J;
                                if (dVarArr2[2].f19141d == null || dVarArr2[3].f19141d == null) {
                                    iP = 0;
                                    iV = 0;
                                    bVar = bVar4;
                                    bVar2 = bVar11;
                                }
                            }
                            if (bVar10 != bVar9) {
                            }
                        }
                        gVar = eVar.f19167f.f19720e;
                        iV2 = eVar.v();
                        gVar.f19702m = iV2;
                    }
                    this.l(eVar, bVar, iP, bVar2, iV);
                    eVar.f19165e.f19720e.d(eVar.P());
                    eVar.f19167f.f19720e.d(eVar.v());
                } else if (bVar10 != bVar9 && bVar11 == bVar9) {
                    if (i10 == 1 || i11 == 1) {
                        y.e.b bVar15 = y.e.b.WRAP_CONTENT;
                        l(eVar, bVar15, 0, bVar15, 0);
                        eVar.f19165e.f19720e.f19702m = eVar.P();
                        gVar = eVar.f19167f.f19720e;
                        iV2 = eVar.v();
                        gVar.f19702m = iV2;
                    } else if (i11 == 2 && i10 == 2 && ((bVar3 = (bVarArr = fVar.M)[0]) == (bVar2 = y.e.b.FIXED) || bVar3 == bVar2)) {
                        y.e.b bVar16 = bVarArr[1];
                        if (bVar16 == bVar2 || bVar16 == bVar2) {
                            float f12 = eVar.f19189q;
                            float f13 = eVar.f19195t;
                            iP = (int) ((f12 * fVar.P()) + 0.5f);
                            iV = (int) ((f13 * fVar.v()) + 0.5f);
                            this = this;
                            eVar = eVar;
                            bVar = bVar2;
                            this.l(eVar, bVar, iP, bVar2, iV);
                            eVar.f19165e.f19720e.d(eVar.P());
                            eVar.f19167f.f19720e.d(eVar.v());
                        }
                    }
                }
            }
            eVar.f19157a = true;
        }
        return false;
    }

    public void c() {
        d(this.f19676e);
        this.f19680i.clear();
        k.f19705h = 0;
        i(this.f19672a.f19165e, 0, this.f19680i);
        i(this.f19672a.f19167f, 1, this.f19680i);
        this.f19673b = false;
    }

    public void d(ArrayList<m> arrayList) {
        m hVar;
        arrayList.clear();
        this.f19675d.f19165e.f();
        this.f19675d.f19167f.f();
        arrayList.add(this.f19675d.f19165e);
        arrayList.add(this.f19675d.f19167f);
        HashSet hashSet = null;
        for (y.e eVar : this.f19675d.f19252w0) {
            if (eVar instanceof y.h) {
                hVar = new h(eVar);
            } else {
                if (eVar.V()) {
                    if (eVar.f19161c == null) {
                        eVar.f19161c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f19161c);
                } else {
                    arrayList.add(eVar.f19165e);
                }
                if (eVar.X()) {
                    if (eVar.f19163d == null) {
                        eVar.f19163d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f19163d);
                } else {
                    arrayList.add(eVar.f19167f);
                }
                if (eVar instanceof y.j) {
                    hVar = new i(eVar);
                }
            }
            arrayList.add(hVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (m mVar : arrayList) {
            if (mVar.f19717b != this.f19675d) {
                mVar.d();
            }
        }
    }

    public final int e(y.f fVar, int i10) {
        int size = this.f19680i.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, this.f19680i.get(i11).b(fVar, i10));
        }
        return (int) jMax;
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f19673b || this.f19674c) {
            for (y.e eVar : this.f19672a.f19252w0) {
                eVar.f19157a = false;
                eVar.f19165e.r();
                eVar.f19167f.q();
            }
            y.f fVar = this.f19672a;
            fVar.f19157a = false;
            fVar.f19165e.r();
            this.f19672a.f19167f.q();
            this.f19674c = false;
        }
        if (b(this.f19675d)) {
            return false;
        }
        this.f19672a.F0(0);
        this.f19672a.G0(0);
        y.e.b bVarS = this.f19672a.s(0);
        y.e.b bVarS2 = this.f19672a.s(1);
        if (this.f19673b) {
            c();
        }
        int iQ = this.f19672a.Q();
        int iR = this.f19672a.R();
        this.f19672a.f19165e.f19723h.d(iQ);
        this.f19672a.f19167f.f19723h.d(iR);
        m();
        y.e.b bVar = y.e.b.WRAP_CONTENT;
        if (bVarS == bVar || bVarS2 == bVar) {
            if (z13) {
                Iterator<m> it = this.f19676e.iterator();
                while (it.hasNext()) {
                    if (!it.next().m()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && bVarS == y.e.b.WRAP_CONTENT) {
                this.f19672a.l0(y.e.b.FIXED);
                y.f fVar2 = this.f19672a;
                fVar2.E0(e(fVar2, 0));
                y.f fVar3 = this.f19672a;
                fVar3.f19165e.f19720e.d(fVar3.P());
            }
            if (z13 && bVarS2 == y.e.b.WRAP_CONTENT) {
                this.f19672a.A0(y.e.b.FIXED);
                y.f fVar4 = this.f19672a;
                fVar4.h0(e(fVar4, 1));
                y.f fVar5 = this.f19672a;
                fVar5.f19167f.f19720e.d(fVar5.v());
            }
        }
        y.f fVar6 = this.f19672a;
        y.e.b bVar2 = fVar6.M[0];
        y.e.b bVar3 = y.e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == y.e.b.MATCH_PARENT) {
            int iP = fVar6.P() + iQ;
            this.f19672a.f19165e.f19724i.d(iP);
            this.f19672a.f19165e.f19720e.d(iP - iQ);
            m();
            y.f fVar7 = this.f19672a;
            y.e.b bVar4 = fVar7.M[1];
            if (bVar4 == bVar3 || bVar4 == y.e.b.MATCH_PARENT) {
                int iV = fVar7.v() + iR;
                this.f19672a.f19167f.f19724i.d(iV);
                this.f19672a.f19167f.f19720e.d(iV - iR);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        for (m mVar : this.f19676e) {
            if (mVar.f19717b != this.f19672a || mVar.f19722g) {
                mVar.e();
            }
        }
        for (m mVar2 : this.f19676e) {
            if (z11 || mVar2.f19717b != this.f19672a) {
                if (!mVar2.f19723h.f19690j || ((!mVar2.f19724i.f19690j && !(mVar2 instanceof h)) || (!mVar2.f19720e.f19690j && !(mVar2 instanceof c) && !(mVar2 instanceof h)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f19672a.l0(bVarS);
        this.f19672a.A0(bVarS2);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f19673b) {
            for (y.e eVar : this.f19672a.f19252w0) {
                eVar.f19157a = false;
                j jVar = eVar.f19165e;
                jVar.f19720e.f19690j = false;
                jVar.f19722g = false;
                jVar.r();
                l lVar = eVar.f19167f;
                lVar.f19720e.f19690j = false;
                lVar.f19722g = false;
                lVar.q();
            }
            y.f fVar = this.f19672a;
            fVar.f19157a = false;
            j jVar2 = fVar.f19165e;
            jVar2.f19720e.f19690j = false;
            jVar2.f19722g = false;
            jVar2.r();
            l lVar2 = this.f19672a.f19167f;
            lVar2.f19720e.f19690j = false;
            lVar2.f19722g = false;
            lVar2.q();
            c();
        }
        if (b(this.f19675d)) {
            return false;
        }
        this.f19672a.F0(0);
        this.f19672a.G0(0);
        this.f19672a.f19165e.f19723h.d(0);
        this.f19672a.f19167f.f19723h.d(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    public boolean h(boolean z10, int i10) {
        boolean z11;
        y.e.b bVar;
        g gVar;
        int iV;
        boolean z12 = true;
        boolean z13 = z10 & true;
        y.e.b bVarS = this.f19672a.s(0);
        y.e.b bVarS2 = this.f19672a.s(1);
        int iQ = this.f19672a.Q();
        int iR = this.f19672a.R();
        if (z13 && (bVarS == (bVar = y.e.b.WRAP_CONTENT) || bVarS2 == bVar)) {
            for (m mVar : this.f19676e) {
                if (mVar.f19721f == i10 && !mVar.m()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && bVarS == y.e.b.WRAP_CONTENT) {
                    this.f19672a.l0(y.e.b.FIXED);
                    y.f fVar = this.f19672a;
                    fVar.E0(e(fVar, 0));
                    y.f fVar2 = this.f19672a;
                    gVar = fVar2.f19165e.f19720e;
                    iV = fVar2.P();
                    gVar.d(iV);
                }
            } else if (z13 && bVarS2 == y.e.b.WRAP_CONTENT) {
                this.f19672a.A0(y.e.b.FIXED);
                y.f fVar3 = this.f19672a;
                fVar3.h0(e(fVar3, 1));
                y.f fVar4 = this.f19672a;
                gVar = fVar4.f19167f.f19720e;
                iV = fVar4.v();
                gVar.d(iV);
            }
        }
        y.f fVar5 = this.f19672a;
        if (i10 == 0) {
            y.e.b bVar2 = fVar5.M[0];
            if (bVar2 == y.e.b.FIXED || bVar2 == y.e.b.MATCH_PARENT) {
                int iP = fVar5.P() + iQ;
                this.f19672a.f19165e.f19724i.d(iP);
                this.f19672a.f19165e.f19720e.d(iP - iQ);
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            y.e.b bVar3 = fVar5.M[1];
            if (bVar3 == y.e.b.FIXED || bVar3 == y.e.b.MATCH_PARENT) {
                int iV2 = fVar5.v() + iR;
                this.f19672a.f19167f.f19724i.d(iV2);
                this.f19672a.f19167f.f19720e.d(iV2 - iR);
                z11 = true;
            } else {
                z11 = false;
            }
        }
        m();
        for (m mVar2 : this.f19676e) {
            if (mVar2.f19721f == i10 && (mVar2.f19717b != this.f19672a || mVar2.f19722g)) {
                mVar2.e();
            }
        }
        for (m mVar3 : this.f19676e) {
            if (mVar3.f19721f == i10 && (z11 || mVar3.f19717b != this.f19672a)) {
                if (!mVar3.f19723h.f19690j || !mVar3.f19724i.f19690j || (!(mVar3 instanceof c) && !mVar3.f19720e.f19690j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f19672a.l0(bVarS);
        this.f19672a.A0(bVarS2);
        return z12;
    }

    public final void i(m mVar, int i10, ArrayList<k> arrayList) {
        for (d dVar : mVar.f19723h.f19691k) {
            if (dVar instanceof f) {
                a((f) dVar, i10, 0, mVar.f19724i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).f19723h, i10, 0, mVar.f19724i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.f19724i.f19691k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, 1, mVar.f19723h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).f19724i, i10, 1, mVar.f19723h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((l) mVar).f19713k.f19691k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    public void j() {
        this.f19673b = true;
    }

    public void k() {
        this.f19674c = true;
    }

    public final void l(y.e eVar, y.e.b bVar, int i10, y.e.b bVar2, int i11) {
        b.a aVar = this.f19679h;
        aVar.f19660a = bVar;
        aVar.f19661b = bVar2;
        aVar.f19662c = i10;
        aVar.f19663d = i11;
        this.f19678g.b(eVar, aVar);
        eVar.E0(this.f19679h.f19664e);
        eVar.h0(this.f19679h.f19665f);
        eVar.g0(this.f19679h.f19667h);
        eVar.b0(this.f19679h.f19666g);
    }

    public void m() {
        g gVar;
        int iP;
        g gVar2;
        int iP2;
        g gVar3;
        for (y.e eVar : this.f19672a.f19252w0) {
            if (!eVar.f19157a) {
                y.e.b[] bVarArr = eVar.M;
                boolean z10 = false;
                y.e.b bVar = bVarArr[0];
                y.e.b bVar2 = bVarArr[1];
                int i10 = eVar.f19179l;
                int i11 = eVar.f19181m;
                y.e.b bVar3 = y.e.b.WRAP_CONTENT;
                boolean z11 = bVar == bVar3 || (bVar == y.e.b.MATCH_CONSTRAINT && i10 == 1);
                if (bVar2 == bVar3 || (bVar2 == y.e.b.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                g gVar4 = eVar.f19165e.f19720e;
                boolean z12 = gVar4.f19690j;
                g gVar5 = eVar.f19167f.f19720e;
                boolean z13 = gVar5.f19690j;
                if (z12 && z13) {
                    y.e.b bVar4 = y.e.b.FIXED;
                    l(eVar, bVar4, gVar4.f19687g, bVar4, gVar5.f19687g);
                } else {
                    if (z12 && z10) {
                        l(eVar, y.e.b.FIXED, gVar4.f19687g, bVar3, gVar5.f19687g);
                        if (bVar2 == y.e.b.MATCH_CONSTRAINT) {
                            gVar2 = eVar.f19167f.f19720e;
                            iP2 = eVar.v();
                            gVar2.f19702m = iP2;
                        } else {
                            gVar = eVar.f19167f.f19720e;
                            iP = eVar.v();
                            gVar.d(iP);
                        }
                    } else if (z13 && z11) {
                        l(eVar, bVar3, gVar4.f19687g, y.e.b.FIXED, gVar5.f19687g);
                        if (bVar == y.e.b.MATCH_CONSTRAINT) {
                            gVar2 = eVar.f19165e.f19720e;
                            iP2 = eVar.P();
                            gVar2.f19702m = iP2;
                        } else {
                            gVar = eVar.f19165e.f19720e;
                            iP = eVar.P();
                            gVar.d(iP);
                        }
                    }
                    if (!eVar.f19157a && (gVar3 = eVar.f19167f.f19714l) != null) {
                        gVar3.d(eVar.n());
                    }
                }
                eVar.f19157a = true;
                if (!eVar.f19157a) {
                }
            }
        }
    }

    public void n(b.InterfaceC0341b interfaceC0341b) {
        this.f19678g = interfaceC0341b;
    }
}
