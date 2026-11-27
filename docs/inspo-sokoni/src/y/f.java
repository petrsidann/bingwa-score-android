package y;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class f extends m {
    public int C0;
    public int D0;
    public int E0;
    public int F0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public z.b f19211x0 = new z.b(this);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public z.e f19212y0 = new z.e(this);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public z.b.InterfaceC0341b f19213z0 = null;
    public boolean A0 = false;
    public x.d B0 = new x.d();
    public int G0 = 0;
    public int H0 = 0;
    public c[] I0 = new c[4];
    public c[] J0 = new c[4];
    public boolean K0 = false;
    public boolean L0 = false;
    public boolean M0 = false;
    public int N0 = 0;
    public int O0 = 0;
    public int P0 = 263;
    public boolean Q0 = false;
    public boolean R0 = false;
    public boolean S0 = false;
    public int T0 = 0;

    @Override // y.e
    public void I0(boolean z10, boolean z11) {
        super.I0(z10, z11);
        int size = this.f19252w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f19252w0.get(i10).I0(z10, z11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01c5 A[PHI: r0 r5
  0x01c5: PHI (r0v26 ??) = (r0v25 ??), (r0v28 ??), (r0v28 ??), (r0v28 ??) binds: [B:70:0x018a, B:78:0x01ad, B:79:0x01af, B:81:0x01b5] A[DONT_GENERATE, DONT_INLINE]
  0x01c5: PHI (r5v11 boolean) = (r5v10 boolean), (r5v13 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:70:0x018a, B:78:0x01ad, B:79:0x01af, B:81:0x01b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // y.m
    public void K0() {
        ?? r11;
        boolean z10;
        ?? r12;
        boolean z11;
        ?? r10;
        ?? r13;
        boolean z12;
        this.S = 0;
        this.T = 0;
        int iMax = Math.max(0, P());
        int iMax2 = Math.max(0, v());
        this.R0 = false;
        this.S0 = false;
        boolean z13 = d1(64) || d1(128);
        x.d dVar = this.B0;
        dVar.f17890g = false;
        dVar.f17891h = false;
        if (this.P0 != 0 && z13) {
            dVar.f17891h = true;
        }
        e.b[] bVarArr = this.M;
        e.b bVar = bVarArr[1];
        e.b bVar2 = bVarArr[0];
        ArrayList<e> arrayList = this.f19252w0;
        e.b bVarY = y();
        e.b bVar3 = e.b.WRAP_CONTENT;
        boolean z14 = bVarY == bVar3 || M() == bVar3;
        e1();
        int size = this.f19252w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f19252w0.get(i10);
            if (eVar instanceof m) {
                ((m) eVar).K0();
            }
        }
        int i11 = 0;
        boolean z15 = false;
        ?? r14 = 1;
        while (r14 != 0) {
            int i12 = i11 + 1;
            try {
                this.B0.D();
                e1();
                l(this.B0);
                for (int i13 = 0; i13 < size; i13++) {
                    this.f19252w0.get(i13).l(this.B0);
                }
                boolean zO0 = O0(this.B0);
                r11 = zO0;
                if (zO0) {
                    this.B0.z();
                    r11 = zO0;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                System.out.println("EXCEPTION : " + e10);
                r11 = r14;
            }
            x.d dVar2 = this.B0;
            if (r11 != 0) {
                i1(dVar2, k.f19249a);
            } else {
                J0(dVar2);
                for (int i14 = 0; i14 < size; i14++) {
                    this.f19252w0.get(i14).J0(this.B0);
                }
            }
            if (z14 && i12 < 8 && k.f19249a[2]) {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i15 = 0; i15 < size; i15++) {
                    e eVar2 = this.f19252w0.get(i15);
                    iMax3 = Math.max(iMax3, eVar2.S + eVar2.P());
                    iMax4 = Math.max(iMax4, eVar2.T + eVar2.v());
                }
                int iMax5 = Math.max(this.Z, iMax3);
                int iMax6 = Math.max(this.f19158a0, iMax4);
                e.b bVar4 = e.b.WRAP_CONTENT;
                if (bVar2 != bVar4 || P() >= iMax5) {
                    z10 = false;
                    z15 = z15;
                } else {
                    E0(iMax5);
                    this.M[0] = bVar4;
                    z10 = true;
                    z15 = true;
                }
                if (bVar == bVar4 && v() < iMax6) {
                    h0(iMax6);
                    this.M[1] = bVar4;
                    z10 = true;
                    z15 = true;
                }
            } else {
                z10 = false;
            }
            int iMax7 = Math.max(this.Z, P());
            boolean z16 = z10;
            boolean z17 = z15;
            if (iMax7 > P()) {
                E0(iMax7);
                this.M[0] = e.b.FIXED;
                z16 = true;
                z17 = true;
            }
            int iMax8 = Math.max(this.f19158a0, v());
            if (iMax8 > v()) {
                h0(iMax8);
                r12 = 1;
                this.M[1] = e.b.FIXED;
                r10 = 1;
                z11 = true;
            } else {
                r12 = 1;
                z11 = z17;
                r10 = z16;
            }
            if (z11) {
                r13 = r10;
                z12 = z11;
            } else {
                e.b bVar5 = this.M[0];
                e.b bVar6 = e.b.WRAP_CONTENT;
                r10 = r10;
                r10 = r10;
                z11 = z11;
                z11 = z11;
                if (bVar5 == bVar6 && iMax > 0) {
                    r10 = r10;
                    z11 = z11;
                    if (P() > iMax) {
                        this.R0 = r12;
                        this.M[0] = e.b.FIXED;
                        E0(iMax);
                        ?? r15 = r12;
                        z11 = r15 == true ? 1 : 0;
                        r10 = r15;
                    }
                }
                if (this.M[r12] != bVar6 || iMax2 <= 0 || v() <= iMax2) {
                    r13 = r10;
                    z12 = z11;
                } else {
                    this.S0 = r12;
                    this.M[r12] = e.b.FIXED;
                    h0(iMax2);
                    r13 = 1;
                    z12 = true;
                }
            }
            i11 = i12;
            r14 = r13;
            z15 = z12;
        }
        this.f19252w0 = arrayList;
        if (z15) {
            e.b[] bVarArr2 = this.M;
            bVarArr2[0] = bVar2;
            bVarArr2[1] = bVar;
        }
        a0(this.B0.v());
    }

    public void N0(e eVar, int i10) {
        if (i10 == 0) {
            P0(eVar);
        } else if (i10 == 1) {
            Q0(eVar);
        }
    }

    public boolean O0(x.d dVar) {
        f(dVar);
        int size = this.f19252w0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f19252w0.get(i10);
            eVar.o0(0, false);
            eVar.o0(1, false);
            if (eVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                e eVar2 = this.f19252w0.get(i11);
                if (eVar2 instanceof a) {
                    ((a) eVar2).N0();
                }
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            e eVar3 = this.f19252w0.get(i12);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            e eVar4 = this.f19252w0.get(i13);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.l0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.A0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.l0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.A0(bVar2);
                }
            } else {
                k.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.G0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.H0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public final void P0(e eVar) {
        int i10 = this.G0 + 1;
        c[] cVarArr = this.J0;
        if (i10 >= cVarArr.length) {
            this.J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.J0[this.G0] = new c(eVar, 0, a1());
        this.G0++;
    }

    public final void Q0(e eVar) {
        int i10 = this.H0 + 1;
        c[] cVarArr = this.I0;
        if (i10 >= cVarArr.length) {
            this.I0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.I0[this.H0] = new c(eVar, 1, a1());
        this.H0++;
    }

    public boolean R0(boolean z10) {
        return this.f19212y0.f(z10);
    }

    public boolean S0(boolean z10) {
        return this.f19212y0.g(z10);
    }

    public boolean T0(boolean z10, int i10) {
        return this.f19212y0.h(z10, i10);
    }

    public z.b.InterfaceC0341b U0() {
        return this.f19213z0;
    }

    public int V0() {
        return this.P0;
    }

    public boolean W0() {
        return false;
    }

    public void X0() {
        this.f19212y0.j();
    }

    @Override // y.m, y.e
    public void Y() {
        this.B0.D();
        this.C0 = 0;
        this.E0 = 0;
        this.D0 = 0;
        this.F0 = 0;
        this.Q0 = false;
        super.Y();
    }

    public void Y0() {
        this.f19212y0.k();
    }

    public boolean Z0() {
        return this.S0;
    }

    public boolean a1() {
        return this.A0;
    }

    public boolean b1() {
        return this.R0;
    }

    public long c1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.C0 = i17;
        this.D0 = i18;
        return this.f19211x0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean d1(int i10) {
        return (this.P0 & i10) == i10;
    }

    public final void e1() {
        this.G0 = 0;
        this.H0 = 0;
    }

    public void f1(z.b.InterfaceC0341b interfaceC0341b) {
        this.f19213z0 = interfaceC0341b;
        this.f19212y0.n(interfaceC0341b);
    }

    public void g1(int i10) {
        this.P0 = i10;
        x.d.f17881r = k.b(i10, 256);
    }

    public void h1(boolean z10) {
        this.A0 = z10;
    }

    public void i1(x.d dVar, boolean[] zArr) {
        zArr[2] = false;
        J0(dVar);
        int size = this.f19252w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f19252w0.get(i10).J0(dVar);
        }
    }

    public void j1() {
        this.f19211x0.e(this);
    }
}
