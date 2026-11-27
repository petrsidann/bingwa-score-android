package y;

/* JADX INFO: loaded from: classes.dex */
public class a extends j {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f19114y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f19115z0 = true;
    public int A0 = 0;

    public boolean K0() {
        return this.f19115z0;
    }

    public int L0() {
        return this.f19114y0;
    }

    public int M0() {
        return this.A0;
    }

    public void N0() {
        for (int i10 = 0; i10 < this.f19248x0; i10++) {
            e eVar = this.f19247w0[i10];
            int i11 = this.f19114y0;
            if (i11 == 0 || i11 == 1) {
                eVar.o0(0, true);
            } else if (i11 == 2 || i11 == 3) {
                eVar.o0(1, true);
            }
        }
    }

    public void O0(boolean z10) {
        this.f19115z0 = z10;
    }

    public void P0(int i10) {
        this.f19114y0 = i10;
    }

    public void Q0(int i10) {
        this.A0 = i10;
    }

    @Override // y.e
    public void f(x.d dVar) {
        d[] dVarArr;
        boolean z10;
        x.i iVar;
        d dVar2;
        int i10;
        int i11;
        int i12;
        d[] dVarArr2 = this.J;
        dVarArr2[0] = this.B;
        dVarArr2[2] = this.C;
        dVarArr2[1] = this.D;
        dVarArr2[3] = this.E;
        int i13 = 0;
        while (true) {
            dVarArr = this.J;
            if (i13 >= dVarArr.length) {
                break;
            }
            d dVar3 = dVarArr[i13];
            dVar3.f19144g = dVar.q(dVar3);
            i13++;
        }
        int i14 = this.f19114y0;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        d dVar4 = dVarArr[i14];
        int i15 = 0;
        while (true) {
            if (i15 >= this.f19248x0) {
                z10 = false;
                break;
            }
            e eVar = this.f19247w0[i15];
            if ((this.f19115z0 || eVar.g()) && ((((i11 = this.f19114y0) == 0 || i11 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.B.f19141d != null && eVar.D.f19141d != null) || (((i12 = this.f19114y0) == 2 || i12 == 3) && eVar.M() == e.b.MATCH_CONSTRAINT && eVar.C.f19141d != null && eVar.E.f19141d != null))) {
                z10 = true;
                break;
            }
            i15++;
        }
        boolean z11 = this.B.i() || this.D.i();
        boolean z12 = this.C.i() || this.E.i();
        int i16 = !(!z10 && (((i10 = this.f19114y0) == 0 && z11) || ((i10 == 2 && z12) || ((i10 == 1 && z11) || (i10 == 3 && z12))))) ? 4 : 5;
        for (int i17 = 0; i17 < this.f19248x0; i17++) {
            e eVar2 = this.f19247w0[i17];
            if (this.f19115z0 || eVar2.g()) {
                x.i iVarQ = dVar.q(eVar2.J[this.f19114y0]);
                d[] dVarArr3 = eVar2.J;
                int i18 = this.f19114y0;
                d dVar5 = dVarArr3[i18];
                dVar5.f19144g = iVarQ;
                d dVar6 = dVar5.f19141d;
                int i19 = (dVar6 == null || dVar6.f19139b != this) ? 0 : dVar5.f19142e + 0;
                if (i18 == 0 || i18 == 2) {
                    dVar.i(dVar4.f19144g, iVarQ, this.A0 - i19, z10);
                } else {
                    dVar.g(dVar4.f19144g, iVarQ, this.A0 + i19, z10);
                }
                dVar.e(dVar4.f19144g, iVarQ, this.A0 + i19, i16);
            }
        }
        int i20 = this.f19114y0;
        if (i20 == 0) {
            dVar.e(this.D.f19144g, this.B.f19144g, 0, 8);
            dVar.e(this.B.f19144g, this.N.D.f19144g, 0, 4);
            iVar = this.B.f19144g;
            dVar2 = this.N.B;
        } else if (i20 == 1) {
            dVar.e(this.B.f19144g, this.D.f19144g, 0, 8);
            dVar.e(this.B.f19144g, this.N.B.f19144g, 0, 4);
            iVar = this.B.f19144g;
            dVar2 = this.N.D;
        } else if (i20 == 2) {
            dVar.e(this.E.f19144g, this.C.f19144g, 0, 8);
            dVar.e(this.C.f19144g, this.N.E.f19144g, 0, 4);
            iVar = this.C.f19144g;
            dVar2 = this.N.C;
        } else {
            if (i20 != 3) {
                return;
            }
            dVar.e(this.C.f19144g, this.E.f19144g, 0, 8);
            dVar.e(this.C.f19144g, this.N.C.f19144g, 0, 4);
            iVar = this.C.f19144g;
            dVar2 = this.N.E;
        }
        dVar.e(iVar, dVar2.f19144g, 0, 0);
    }

    @Override // y.e
    public boolean g() {
        return true;
    }

    @Override // y.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i10 = 0; i10 < this.f19248x0; i10++) {
            e eVar = this.f19247w0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }
}
