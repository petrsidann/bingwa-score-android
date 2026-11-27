package z;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<m> f19670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19671l;

    public c(y.e eVar, int i10) {
        super(eVar);
        this.f19670k = new ArrayList<>();
        this.f19721f = i10;
        q();
    }

    /* JADX WARN: Code duplicated, block: B:120:0x01c7 A[PHI: r1 r22 r23 r24
  0x01c7: PHI (r1v53 int) = (r1v51 int), (r1v59 int) binds: [B:119:0x01c5, B:110:0x019f] A[DONT_GENERATE, DONT_INLINE]
  0x01c7: PHI (r22v3 float) = (r22v2 float), (r22v5 float) binds: [B:119:0x01c5, B:110:0x019f] A[DONT_GENERATE, DONT_INLINE]
  0x01c7: PHI (r23v6 boolean) = (r23v5 boolean), (r23v8 boolean) binds: [B:119:0x01c5, B:110:0x019f] A[DONT_GENERATE, DONT_INLINE]
  0x01c7: PHI (r24v6 int) = (r24v5 int), (r24v8 int) binds: [B:119:0x01c5, B:110:0x019f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:309:0x00f6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ee A[ADDED_TO_REGION] */
    @Override // z.m, z.d
    public void a(d dVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f10;
        boolean z10;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z11;
        int i19;
        float f11;
        int iMax;
        int i20;
        int i21;
        float f12;
        if (this.f19723h.f19690j && this.f19724i.f19690j) {
            y.e eVarG = this.f19717b.G();
            boolean zA1 = (eVarG == null || !(eVarG instanceof y.f)) ? false : ((y.f) eVarG).a1();
            int i22 = this.f19724i.f19687g - this.f19723h.f19687g;
            int size = this.f19670k.size();
            int i23 = 0;
            while (true) {
                i10 = -1;
                i11 = 8;
                if (i23 >= size) {
                    i23 = -1;
                    break;
                } else if (this.f19670k.get(i23).f19717b.O() != 8) {
                    break;
                } else {
                    i23++;
                }
            }
            int i24 = size - 1;
            for (int i25 = i24; i25 >= 0; i25--) {
                if (this.f19670k.get(i25).f19717b.O() != 8) {
                    i10 = i25;
                    break;
                }
            }
            int i26 = 0;
            while (true) {
                if (i26 >= 2) {
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    f10 = 0.0f;
                    break;
                }
                int i27 = 0;
                i13 = 0;
                i14 = 0;
                int i28 = 0;
                f10 = 0.0f;
                while (i27 < size) {
                    m mVar = this.f19670k.get(i27);
                    if (mVar.f19717b.O() != i11) {
                        i28++;
                        if (i27 > 0 && i27 >= i23) {
                            i13 += mVar.f19723h.f19686f;
                        }
                        g gVar = mVar.f19720e;
                        int i29 = gVar.f19687g;
                        boolean z12 = mVar.f19719d != y.e.b.MATCH_CONSTRAINT;
                        if (z12) {
                            int i30 = this.f19721f;
                            if (i30 == 0 && !mVar.f19717b.f19165e.f19720e.f19690j) {
                                return;
                            }
                            if (i30 == 1 && !mVar.f19717b.f19167f.f19720e.f19690j) {
                                return;
                            } else {
                                i20 = i29;
                            }
                        } else {
                            i20 = i29;
                            if (mVar.f19716a == 1 && i26 == 0) {
                                i21 = gVar.f19702m;
                                i14++;
                            } else {
                                if (gVar.f19690j) {
                                    i21 = i20;
                                }
                                if (z12) {
                                    i13 += i21;
                                } else {
                                    i14++;
                                    f12 = mVar.f19717b.f19190q0[this.f19721f];
                                    if (f12 >= 0.0f) {
                                        f10 += f12;
                                    }
                                }
                                if (i27 >= i24 && i27 < i10) {
                                    i13 += -mVar.f19724i.f19686f;
                                }
                            }
                            z12 = true;
                            if (z12) {
                                i14++;
                                f12 = mVar.f19717b.f19190q0[this.f19721f];
                                if (f12 >= 0.0f) {
                                    f10 += f12;
                                }
                            } else {
                                i13 += i21;
                            }
                            if (i27 >= i24) {
                            }
                        }
                        i21 = i20;
                        if (z12) {
                            i14++;
                            f12 = mVar.f19717b.f19190q0[this.f19721f];
                            if (f12 >= 0.0f) {
                                f10 += f12;
                            }
                        } else {
                            i13 += i21;
                        }
                        if (i27 >= i24) {
                        }
                    }
                    i27++;
                    i11 = 8;
                }
                if (i13 < i22 || i14 == 0) {
                    i12 = i28;
                    break;
                } else {
                    i26++;
                    i11 = 8;
                }
            }
            int i31 = this.f19723h.f19687g;
            if (zA1) {
                i31 = this.f19724i.f19687g;
            }
            if (i13 > i22) {
                int i32 = (int) (((i13 - i22) / 2.0f) + 0.5f);
                i31 = zA1 ? i31 + i32 : i31 - i32;
            }
            if (i14 > 0) {
                float f13 = i22 - i13;
                int i33 = (int) ((f13 / i14) + 0.5f);
                int i34 = 0;
                int i35 = 0;
                while (i34 < size) {
                    m mVar2 = this.f19670k.get(i34);
                    int i36 = i33;
                    int i37 = i13;
                    if (mVar2.f19717b.O() != 8 && mVar2.f19719d == y.e.b.MATCH_CONSTRAINT) {
                        g gVar2 = mVar2.f19720e;
                        if (gVar2.f19690j) {
                            z11 = zA1;
                            i19 = i12;
                            i31 = i31;
                            f11 = f13;
                        } else {
                            int i38 = f10 > 0.0f ? (int) (((mVar2.f19717b.f19190q0[this.f19721f] * f13) / f10) + 0.5f) : i36;
                            if (this.f19721f == 0) {
                                y.e eVar = mVar2.f19717b;
                                f11 = f13;
                                int i39 = eVar.f19187p;
                                z11 = zA1;
                                i19 = i12;
                                iMax = Math.max(eVar.f19185o, mVar2.f19716a == 1 ? Math.min(i38, gVar2.f19702m) : i38);
                                if (i39 > 0) {
                                    iMax = Math.min(i39, iMax);
                                }
                                if (iMax != i38) {
                                    i35++;
                                    i38 = iMax;
                                }
                            } else {
                                z11 = zA1;
                                i19 = i12;
                                f11 = f13;
                                y.e eVar2 = mVar2.f19717b;
                                int i40 = eVar2.f19193s;
                                iMax = Math.max(eVar2.f19191r, mVar2.f19716a == 1 ? Math.min(i38, gVar2.f19702m) : i38);
                                if (i40 > 0) {
                                    iMax = Math.min(i40, iMax);
                                }
                                if (iMax != i38) {
                                    i35++;
                                    i38 = iMax;
                                }
                            }
                            mVar2.f19720e.d(i38);
                        }
                    } else {
                        z11 = zA1;
                        i19 = i12;
                        i31 = i31;
                        f11 = f13;
                    }
                    i34++;
                    i33 = i36;
                    i13 = i37;
                    i31 = i31;
                    f13 = f11;
                    zA1 = z11;
                    i12 = i19;
                }
                z10 = zA1;
                i15 = i12;
                i16 = i31;
                int i41 = i13;
                if (i35 > 0) {
                    i14 -= i35;
                    int i42 = 0;
                    for (int i43 = 0; i43 < size; i43++) {
                        m mVar3 = this.f19670k.get(i43);
                        if (mVar3.f19717b.O() != 8) {
                            if (i43 > 0 && i43 >= i23) {
                                i42 += mVar3.f19723h.f19686f;
                            }
                            i42 += mVar3.f19720e.f19687g;
                            if (i43 < i24 && i43 < i10) {
                                i42 += -mVar3.f19724i.f19686f;
                            }
                        }
                    }
                    i13 = i42;
                } else {
                    i13 = i41;
                }
                i18 = 2;
                if (this.f19671l == 2 && i35 == 0) {
                    i17 = 0;
                    this.f19671l = 0;
                } else {
                    i17 = 0;
                }
            } else {
                z10 = zA1;
                i15 = i12;
                i16 = i31;
                i17 = 0;
                i18 = 2;
            }
            if (i13 > i22) {
                this.f19671l = i18;
            }
            if (i15 > 0 && i14 == 0 && i23 == i10) {
                this.f19671l = i18;
            }
            int i44 = this.f19671l;
            int i45 = i15;
            if (i44 == 1) {
                int i46 = i45 > 1 ? (i22 - i13) / (i45 - 1) : i45 == 1 ? (i22 - i13) / 2 : i17;
                if (i14 > 0) {
                    i46 = i17;
                }
                int i47 = i16;
                for (int i48 = i17; i48 < size; i48++) {
                    m mVar4 = this.f19670k.get(z10 ? size - (i48 + 1) : i48);
                    if (mVar4.f19717b.O() == 8) {
                        mVar4.f19723h.d(i47);
                        mVar4.f19724i.d(i47);
                    } else {
                        if (i48 > 0) {
                            i47 = z10 ? i47 - i46 : i47 + i46;
                        }
                        if (i48 > 0 && i48 >= i23) {
                            int i49 = mVar4.f19723h.f19686f;
                            i47 = z10 ? i47 - i49 : i47 + i49;
                        }
                        (z10 ? mVar4.f19724i : mVar4.f19723h).d(i47);
                        g gVar3 = mVar4.f19720e;
                        int i50 = gVar3.f19687g;
                        if (mVar4.f19719d == y.e.b.MATCH_CONSTRAINT && mVar4.f19716a == 1) {
                            i50 = gVar3.f19702m;
                        }
                        i47 = z10 ? i47 - i50 : i47 + i50;
                        (z10 ? mVar4.f19723h : mVar4.f19724i).d(i47);
                        mVar4.f19722g = true;
                        if (i48 < i24 && i48 < i10) {
                            int i51 = -mVar4.f19724i.f19686f;
                            i47 = z10 ? i47 - i51 : i47 + i51;
                        }
                    }
                }
                return;
            }
            if (i44 == 0) {
                int i52 = (i22 - i13) / (i45 + 1);
                if (i14 > 0) {
                    i52 = i17;
                }
                int i53 = i16;
                for (int i54 = i17; i54 < size; i54++) {
                    m mVar5 = this.f19670k.get(z10 ? size - (i54 + 1) : i54);
                    if (mVar5.f19717b.O() == 8) {
                        mVar5.f19723h.d(i53);
                        mVar5.f19724i.d(i53);
                    } else {
                        int i55 = z10 ? i53 - i52 : i53 + i52;
                        if (i54 > 0 && i54 >= i23) {
                            int i56 = mVar5.f19723h.f19686f;
                            i55 = z10 ? i55 - i56 : i55 + i56;
                        }
                        (z10 ? mVar5.f19724i : mVar5.f19723h).d(i55);
                        g gVar4 = mVar5.f19720e;
                        int iMin = gVar4.f19687g;
                        if (mVar5.f19719d == y.e.b.MATCH_CONSTRAINT && mVar5.f19716a == 1) {
                            iMin = Math.min(iMin, gVar4.f19702m);
                        }
                        i53 = z10 ? i55 - iMin : i55 + iMin;
                        (z10 ? mVar5.f19723h : mVar5.f19724i).d(i53);
                        if (i54 < i24 && i54 < i10) {
                            int i57 = -mVar5.f19724i.f19686f;
                            i53 = z10 ? i53 - i57 : i53 + i57;
                        }
                    }
                }
                return;
            }
            if (i44 == 2) {
                float fW = this.f19721f == 0 ? this.f19717b.w() : this.f19717b.K();
                if (z10) {
                    fW = 1.0f - fW;
                }
                int i58 = (int) (((i22 - i13) * fW) + 0.5f);
                if (i58 < 0 || i14 > 0) {
                    i58 = i17;
                }
                int i59 = z10 ? i16 - i58 : i16 + i58;
                for (int i60 = i17; i60 < size; i60++) {
                    m mVar6 = this.f19670k.get(z10 ? size - (i60 + 1) : i60);
                    if (mVar6.f19717b.O() == 8) {
                        mVar6.f19723h.d(i59);
                        mVar6.f19724i.d(i59);
                    } else {
                        if (i60 > 0 && i60 >= i23) {
                            int i61 = mVar6.f19723h.f19686f;
                            i59 = z10 ? i59 - i61 : i59 + i61;
                        }
                        (z10 ? mVar6.f19724i : mVar6.f19723h).d(i59);
                        g gVar5 = mVar6.f19720e;
                        int i62 = gVar5.f19687g;
                        if (mVar6.f19719d == y.e.b.MATCH_CONSTRAINT && mVar6.f19716a == 1) {
                            i62 = gVar5.f19702m;
                        }
                        i59 = z10 ? i59 - i62 : i59 + i62;
                        (z10 ? mVar6.f19723h : mVar6.f19724i).d(i59);
                        if (i60 < i24 && i60 < i10) {
                            int i63 = -mVar6.f19724i.f19686f;
                            i59 = z10 ? i59 - i63 : i59 + i63;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a5 A[PHI: r0 r1
  0x00a5: PHI (r0v13 int) = (r0v10 int), (r0v19 int) binds: [B:29:0x00a3, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r1v3 z.f) = (r1v2 z.f), (r1v7 z.f) binds: [B:29:0x00a3, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // z.m
    public void d() {
        f fVarI;
        int iC;
        Iterator<m> it = this.f19670k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f19670k.size();
        if (size < 1) {
            return;
        }
        y.e eVar = this.f19670k.get(0).f19717b;
        y.e eVar2 = this.f19670k.get(size - 1).f19717b;
        if (this.f19721f == 0) {
            y.d dVar = eVar.B;
            y.d dVar2 = eVar2.D;
            f fVarI2 = i(dVar, 0);
            int iC2 = dVar.c();
            y.e eVarR = r();
            if (eVarR != null) {
                iC2 = eVarR.B.c();
            }
            if (fVarI2 != null) {
                b(this.f19723h, fVarI2, iC2);
            }
            fVarI = i(dVar2, 0);
            iC = dVar2.c();
            y.e eVarS = s();
            if (eVarS != null) {
                iC = eVarS.D.c();
            }
            if (fVarI != null) {
                b(this.f19724i, fVarI, -iC);
            }
        } else {
            y.d dVar3 = eVar.C;
            y.d dVar4 = eVar2.E;
            f fVarI3 = i(dVar3, 1);
            int iC3 = dVar3.c();
            y.e eVarR2 = r();
            if (eVarR2 != null) {
                iC3 = eVarR2.C.c();
            }
            if (fVarI3 != null) {
                b(this.f19723h, fVarI3, iC3);
            }
            fVarI = i(dVar4, 1);
            iC = dVar4.c();
            y.e eVarS2 = s();
            if (eVarS2 != null) {
                iC = eVarS2.E.c();
            }
            if (fVarI != null) {
                b(this.f19724i, fVarI, -iC);
            }
        }
        this.f19723h.f19681a = this;
        this.f19724i.f19681a = this;
    }

    @Override // z.m
    public void e() {
        for (int i10 = 0; i10 < this.f19670k.size(); i10++) {
            this.f19670k.get(i10).e();
        }
    }

    @Override // z.m
    public void f() {
        this.f19718c = null;
        Iterator<m> it = this.f19670k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // z.m
    public long j() {
        int size = this.f19670k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = this.f19670k.get(i10);
            j10 = j10 + ((long) mVar.f19723h.f19686f) + mVar.j() + ((long) mVar.f19724i.f19686f);
        }
        return j10;
    }

    @Override // z.m
    public boolean m() {
        int size = this.f19670k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f19670k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        y.e eVar;
        y.e eVarH = this.f19717b;
        do {
            eVar = eVarH;
            eVarH = eVarH.H(this.f19721f);
        } while (eVarH != null);
        this.f19717b = eVar;
        this.f19670k.add(eVar.J(this.f19721f));
        y.e eVarF = eVar.F(this.f19721f);
        while (eVarF != null) {
            this.f19670k.add(eVarF.J(this.f19721f));
            eVarF = eVarF.F(this.f19721f);
        }
        for (m mVar : this.f19670k) {
            int i10 = this.f19721f;
            if (i10 == 0) {
                mVar.f19717b.f19161c = this;
            } else if (i10 == 1) {
                mVar.f19717b.f19163d = this;
            }
        }
        if ((this.f19721f == 0 && ((y.f) this.f19717b.G()).a1()) && this.f19670k.size() > 1) {
            ArrayList<m> arrayList = this.f19670k;
            this.f19717b = arrayList.get(arrayList.size() - 1).f19717b;
        }
        this.f19671l = this.f19721f == 0 ? this.f19717b.x() : this.f19717b.L();
    }

    public final y.e r() {
        for (int i10 = 0; i10 < this.f19670k.size(); i10++) {
            m mVar = this.f19670k.get(i10);
            if (mVar.f19717b.O() != 8) {
                return mVar.f19717b;
            }
        }
        return null;
    }

    public final y.e s() {
        for (int size = this.f19670k.size() - 1; size >= 0; size--) {
            m mVar = this.f19670k.get(size);
            if (mVar.f19717b.O() != 8) {
                return mVar.f19717b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChainRun ");
        sb2.append(this.f19721f == 0 ? "horizontal : " : "vertical : ");
        String string = sb2.toString();
        Iterator<m> it = this.f19670k.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + it.next()) + "> ";
        }
        return string;
    }
}
