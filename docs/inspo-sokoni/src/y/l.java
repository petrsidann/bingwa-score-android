package y;

/* JADX INFO: loaded from: classes.dex */
public class l extends j {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f19250y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f19251z0 = 0;
    public int A0 = 0;
    public int B0 = 0;
    public int C0 = 0;
    public int D0 = 0;
    public int E0 = 0;
    public int F0 = 0;
    public boolean G0 = false;
    public int H0 = 0;
    public int I0 = 0;
    public z.b.a J0 = new z.b.a();
    public z.b.InterfaceC0341b K0 = null;

    public void K0(boolean z10) {
        int i10 = this.C0;
        if (i10 > 0 || this.D0 > 0) {
            if (z10) {
                this.E0 = this.D0;
                this.F0 = i10;
            } else {
                this.E0 = i10;
                this.F0 = this.D0;
            }
        }
    }

    public void L0() {
        for (int i10 = 0; i10 < this.f19248x0; i10++) {
            e eVar = this.f19247w0[i10];
            if (eVar != null) {
                eVar.q0(true);
            }
        }
    }

    public int M0() {
        return this.I0;
    }

    public int N0() {
        return this.H0;
    }

    public int O0() {
        return this.f19251z0;
    }

    public int P0() {
        return this.E0;
    }

    public int Q0() {
        return this.F0;
    }

    public int R0() {
        return this.f19250y0;
    }

    public void S0(int i10, int i11, int i12, int i13) {
    }

    public void T0(e eVar, e.b bVar, int i10, e.b bVar2, int i11) {
        while (this.K0 == null && G() != null) {
            this.K0 = ((f) G()).U0();
        }
        z.b.a aVar = this.J0;
        aVar.f19660a = bVar;
        aVar.f19661b = bVar2;
        aVar.f19662c = i10;
        aVar.f19663d = i11;
        this.K0.b(eVar, aVar);
        eVar.E0(this.J0.f19664e);
        eVar.h0(this.J0.f19665f);
        eVar.g0(this.J0.f19667h);
        eVar.b0(this.J0.f19666g);
    }

    public boolean U0() {
        e eVar = this.N;
        z.b.InterfaceC0341b interfaceC0341bU0 = eVar != null ? ((f) eVar).U0() : null;
        if (interfaceC0341bU0 == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f19248x0) {
                return true;
            }
            e eVar2 = this.f19247w0[i10];
            if (eVar2 != null && !(eVar2 instanceof h)) {
                e.b bVarS = eVar2.s(0);
                e.b bVarS2 = eVar2.s(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (!(bVarS == bVar && eVar2.f19179l != 1 && bVarS2 == bVar && eVar2.f19181m != 1)) {
                    if (bVarS == bVar) {
                        bVarS = e.b.WRAP_CONTENT;
                    }
                    if (bVarS2 == bVar) {
                        bVarS2 = e.b.WRAP_CONTENT;
                    }
                    z.b.a aVar = this.J0;
                    aVar.f19660a = bVarS;
                    aVar.f19661b = bVarS2;
                    aVar.f19662c = eVar2.P();
                    this.J0.f19663d = eVar2.v();
                    interfaceC0341bU0.b(eVar2, this.J0);
                    eVar2.E0(this.J0.f19664e);
                    eVar2.h0(this.J0.f19665f);
                    eVar2.b0(this.J0.f19666g);
                }
            }
            i10++;
        }
    }

    public boolean V0() {
        return this.G0;
    }

    public void W0(boolean z10) {
        this.G0 = z10;
    }

    public void X0(int i10, int i11) {
        this.H0 = i10;
        this.I0 = i11;
    }

    public void Y0(int i10) {
        this.A0 = i10;
        this.f19250y0 = i10;
        this.B0 = i10;
        this.f19251z0 = i10;
        this.C0 = i10;
        this.D0 = i10;
    }

    public void Z0(int i10) {
        this.f19251z0 = i10;
    }

    @Override // y.j, y.i
    public void a(f fVar) {
        L0();
    }

    public void a1(int i10) {
        this.D0 = i10;
    }

    public void b1(int i10) {
        this.A0 = i10;
        this.E0 = i10;
    }

    public void c1(int i10) {
        this.B0 = i10;
        this.F0 = i10;
    }

    public void d1(int i10) {
        this.C0 = i10;
        this.E0 = i10;
        this.F0 = i10;
    }

    public void e1(int i10) {
        this.f19250y0 = i10;
    }
}
