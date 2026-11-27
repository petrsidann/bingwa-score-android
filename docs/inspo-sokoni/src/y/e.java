package y;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static float f19156v0 = 0.5f;
    public d I;
    public d[] J;
    public ArrayList<d> K;
    public boolean[] L;
    public b[] M;
    public e N;
    public int O;
    public int P;
    public float Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f19158a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f19160b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z.c f19161c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f19162c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z.c f19163d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Object f19164d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f19166e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f19168f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f19170g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f19172h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f19174i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f19176j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f19178k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f19180l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f19182m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f19184n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f19186o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f19188p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float[] f19190q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public e[] f19192r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public e[] f19194s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public e f19196t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public e f19198u0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f19203z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19157a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z.m[] f19159b = new z.m[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z.j f19165e = new z.j(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z.l f19167f = new z.l(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f19169g = {true, true};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f19171h = {0, 0, 0, 0};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19173i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19175j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19177k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19179l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19181m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f19183n = new int[2];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19185o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19187p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f19189q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19191r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f19193s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f19195t = 1.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19197u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f19199v = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f19200w = {com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f19201x = 0.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f19202y = false;
    public boolean A = false;
    public d B = new d(this, d.b.LEFT);
    public d C = new d(this, d.b.TOP);
    public d D = new d(this, d.b.RIGHT);
    public d E = new d(this, d.b.BOTTOM);
    public d F = new d(this, d.b.BASELINE);
    public d G = new d(this, d.b.CENTER_X);
    public d H = new d(this, d.b.CENTER_Y);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19205b;

        static {
            int[] iArr = new int[b.values().length];
            f19205b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19205b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19205b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19205b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f19204a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19204a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19204a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19204a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19204a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19204a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19204a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f19204a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f19204a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.I = dVar;
        this.J = new d[]{this.B, this.D, this.C, this.E, this.F, dVar};
        this.K = new ArrayList<>();
        this.L = new boolean[2];
        b bVar = b.FIXED;
        this.M = new b[]{bVar, bVar};
        this.N = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f10 = f19156v0;
        this.f19160b0 = f10;
        this.f19162c0 = f10;
        this.f19166e0 = 0;
        this.f19168f0 = 0;
        this.f19170g0 = null;
        this.f19172h0 = null;
        this.f19178k0 = false;
        this.f19180l0 = false;
        this.f19182m0 = 0;
        this.f19184n0 = 0;
        this.f19190q0 = new float[]{-1.0f, -1.0f};
        this.f19192r0 = new e[]{null, null};
        this.f19194s0 = new e[]{null, null};
        this.f19196t0 = null;
        this.f19198u0 = null;
        d();
    }

    public int A(int i10) {
        if (i10 == 0) {
            return P();
        }
        if (i10 == 1) {
            return v();
        }
        return 0;
    }

    public void A0(b bVar) {
        this.M[1] = bVar;
    }

    public int B() {
        return this.f19200w[1];
    }

    public void B0(int i10, int i11, int i12, float f10) {
        this.f19181m = i10;
        this.f19191r = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f19193s = i12;
        this.f19195t = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f19181m = 2;
    }

    public int C() {
        return this.f19200w[0];
    }

    public void C0(float f10) {
        this.f19190q0[1] = f10;
    }

    public int D() {
        return this.f19158a0;
    }

    public void D0(int i10) {
        this.f19168f0 = i10;
    }

    public int E() {
        return this.Z;
    }

    public void E0(int i10) {
        this.O = i10;
        int i11 = this.Z;
        if (i10 < i11) {
            this.O = i11;
        }
    }

    public e F(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.E).f19141d) != null && dVar2.f19141d == dVar) {
                return dVar2.f19139b;
            }
            return null;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.f19141d;
        if (dVar4 == null || dVar4.f19141d != dVar3) {
            return null;
        }
        return dVar4.f19139b;
    }

    public void F0(int i10) {
        this.S = i10;
    }

    public e G() {
        return this.N;
    }

    public void G0(int i10) {
        this.T = i10;
    }

    public e H(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.C).f19141d) != null && dVar2.f19141d == dVar) {
                return dVar2.f19139b;
            }
            return null;
        }
        d dVar3 = this.B;
        d dVar4 = dVar3.f19141d;
        if (dVar4 == null || dVar4.f19141d != dVar3) {
            return null;
        }
        return dVar4.f19139b;
    }

    public void H0(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f19197u == -1) {
            if (z12 && !z13) {
                this.f19197u = 0;
            } else if (!z12 && z13) {
                this.f19197u = 1;
                if (this.R == -1) {
                    this.f19199v = 1.0f / this.f19199v;
                }
            }
        }
        if (this.f19197u == 0 && (!this.C.j() || !this.E.j())) {
            this.f19197u = 1;
        } else if (this.f19197u == 1 && (!this.B.j() || !this.D.j())) {
            this.f19197u = 0;
        }
        if (this.f19197u == -1 && (!this.C.j() || !this.E.j() || !this.B.j() || !this.D.j())) {
            if (this.C.j() && this.E.j()) {
                this.f19197u = 0;
            } else if (this.B.j() && this.D.j()) {
                this.f19199v = 1.0f / this.f19199v;
                this.f19197u = 1;
            }
        }
        if (this.f19197u == -1) {
            int i10 = this.f19185o;
            if (i10 > 0 && this.f19191r == 0) {
                this.f19197u = 0;
            } else {
                if (i10 != 0 || this.f19191r <= 0) {
                    return;
                }
                this.f19199v = 1.0f / this.f19199v;
                this.f19197u = 1;
            }
        }
    }

    public int I() {
        return Q() + this.O;
    }

    public void I0(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zK = z10 & this.f19165e.k();
        boolean zK2 = z11 & this.f19167f.k();
        z.j jVar = this.f19165e;
        int i12 = jVar.f19723h.f19687g;
        z.l lVar = this.f19167f;
        int i13 = lVar.f19723h.f19687g;
        int i14 = jVar.f19724i.f19687g;
        int i15 = lVar.f19724i.f19687g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zK) {
            this.S = i12;
        }
        if (zK2) {
            this.T = i13;
        }
        if (this.f19168f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        if (zK) {
            if (this.M[0] == b.FIXED && i17 < (i11 = this.O)) {
                i17 = i11;
            }
            this.O = i17;
            int i19 = this.Z;
            if (i17 < i19) {
                this.O = i19;
            }
        }
        if (zK2) {
            if (this.M[1] == b.FIXED && i18 < (i10 = this.P)) {
                i18 = i10;
            }
            this.P = i18;
            int i20 = this.f19158a0;
            if (i18 < i20) {
                this.P = i20;
            }
        }
    }

    public z.m J(int i10) {
        if (i10 == 0) {
            return this.f19165e;
        }
        if (i10 == 1) {
            return this.f19167f;
        }
        return null;
    }

    public void J0(x.d dVar) {
        int iX = dVar.x(this.B);
        int iX2 = dVar.x(this.C);
        int iX3 = dVar.x(this.D);
        int iX4 = dVar.x(this.E);
        z.j jVar = this.f19165e;
        z.f fVar = jVar.f19723h;
        if (fVar.f19690j) {
            z.f fVar2 = jVar.f19724i;
            if (fVar2.f19690j) {
                iX = fVar.f19687g;
                iX3 = fVar2.f19687g;
            }
        }
        z.l lVar = this.f19167f;
        z.f fVar3 = lVar.f19723h;
        if (fVar3.f19690j) {
            z.f fVar4 = lVar.f19724i;
            if (fVar4.f19690j) {
                iX2 = fVar3.f19687g;
                iX4 = fVar4.f19687g;
            }
        }
        int i10 = iX4 - iX2;
        if (iX3 - iX < 0 || i10 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX = 0;
            iX4 = 0;
            iX2 = 0;
            iX3 = 0;
        }
        f0(iX, iX2, iX3, iX4);
    }

    public float K() {
        return this.f19162c0;
    }

    public int L() {
        return this.f19184n0;
    }

    public b M() {
        return this.M[1];
    }

    public int N() {
        int i10 = this.B != null ? 0 + this.C.f19142e : 0;
        return this.D != null ? i10 + this.E.f19142e : i10;
    }

    public int O() {
        return this.f19168f0;
    }

    public int P() {
        if (this.f19168f0 == 8) {
            return 0;
        }
        return this.O;
    }

    public int Q() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.S : ((f) eVar).C0 + this.S;
    }

    public int R() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.T : ((f) eVar).D0 + this.T;
    }

    public boolean S() {
        return this.f19202y;
    }

    public void T(d.b bVar, e eVar, d.b bVar2, int i10, int i11) {
        m(bVar).b(eVar.m(bVar2), i10, i11, true);
    }

    public final boolean U(int i10) {
        d dVar;
        d dVar2;
        int i11 = i10 * 2;
        d[] dVarArr = this.J;
        d dVar3 = dVarArr[i11];
        d dVar4 = dVar3.f19141d;
        return (dVar4 == null || dVar4.f19141d == dVar3 || (dVar2 = (dVar = dVarArr[i11 + 1]).f19141d) == null || dVar2.f19141d != dVar) ? false : true;
    }

    public boolean V() {
        d dVar = this.B;
        d dVar2 = dVar.f19141d;
        if (dVar2 != null && dVar2.f19141d == dVar) {
            return true;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.f19141d;
        return dVar4 != null && dVar4.f19141d == dVar3;
    }

    public boolean W() {
        return this.f19203z;
    }

    public boolean X() {
        d dVar = this.C;
        d dVar2 = dVar.f19141d;
        if (dVar2 != null && dVar2.f19141d == dVar) {
            return true;
        }
        d dVar3 = this.E;
        d dVar4 = dVar3.f19141d;
        return dVar4 != null && dVar4.f19141d == dVar3;
    }

    public void Y() {
        this.B.l();
        this.C.l();
        this.D.l();
        this.E.l();
        this.F.l();
        this.G.l();
        this.H.l();
        this.I.l();
        this.N = null;
        this.f19201x = 0.0f;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f19158a0 = 0;
        float f10 = f19156v0;
        this.f19160b0 = f10;
        this.f19162c0 = f10;
        b[] bVarArr = this.M;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f19164d0 = null;
        this.f19166e0 = 0;
        this.f19168f0 = 0;
        this.f19172h0 = null;
        this.f19174i0 = false;
        this.f19176j0 = false;
        this.f19182m0 = 0;
        this.f19184n0 = 0;
        this.f19186o0 = false;
        this.f19188p0 = false;
        float[] fArr = this.f19190q0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f19175j = -1;
        this.f19177k = -1;
        int[] iArr = this.f19200w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f19179l = 0;
        this.f19181m = 0;
        this.f19189q = 1.0f;
        this.f19195t = 1.0f;
        this.f19187p = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
        this.f19193s = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
        this.f19185o = 0;
        this.f19191r = 0;
        this.f19173i = false;
        this.f19197u = -1;
        this.f19199v = 1.0f;
        this.f19178k0 = false;
        this.f19180l0 = false;
        boolean[] zArr = this.f19169g;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.L;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void Z() {
        e eVarG = G();
        if (eVarG != null && (eVarG instanceof f) && ((f) G()).W0()) {
            return;
        }
        int size = this.K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.K.get(i10).l();
        }
    }

    public void a0(x.c cVar) {
        this.B.m(cVar);
        this.C.m(cVar);
        this.D.m(cVar);
        this.E.m(cVar);
        this.F.m(cVar);
        this.I.m(cVar);
        this.G.m(cVar);
        this.H.m(cVar);
    }

    public void b0(int i10) {
        this.Y = i10;
        this.f19202y = i10 > 0;
    }

    public void c0(Object obj) {
        this.f19164d0 = obj;
    }

    public final void d() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    public void d0(String str) {
        this.f19170g0 = str;
    }

    public boolean e() {
        return (this instanceof l) || (this instanceof h);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[PHI: r0
  0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void e0(String str) {
        float fAbs;
        int i10 = 0;
        if (str == null || str.length() == 0) {
            this.Q = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i11 = 0;
        int i12 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i11 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i12 = i11;
            i11 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i11);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i10;
                }
            } else {
                String strSubstring3 = str.substring(i11, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i10;
                } else {
                    float f10 = Float.parseFloat(strSubstring3);
                    float f11 = Float.parseFloat(strSubstring4);
                    if (f10 <= 0.0f || f11 <= 0.0f) {
                        fAbs = i10;
                    } else {
                        fAbs = i12 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i10 = (fAbs > i10 ? 1 : (fAbs == i10 ? 0 : -1));
        if (i10 > 0) {
            this.Q = fAbs;
            this.R = i12;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12141. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void f(x.d r48) {
        /*
            Method dump skipped, instruction units count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.f(x.d):void");
    }

    public void f0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.S = i10;
        this.T = i11;
        if (this.f19168f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        b[] bVarArr = this.M;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.O)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.P)) {
            i17 = i14;
        }
        this.O = i16;
        this.P = i17;
        int i18 = this.f19158a0;
        if (i17 < i18) {
            this.P = i18;
        }
        int i19 = this.Z;
        if (i16 < i19) {
            this.O = i19;
        }
    }

    public boolean g() {
        return this.f19168f0 != 8;
    }

    public void g0(boolean z10) {
        this.f19202y = z10;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x019e  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x0273  */
    /* JADX WARN: Code duplicated, block: B:159:0x0277  */
    /* JADX WARN: Code duplicated, block: B:181:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:183:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:185:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:186:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:188:0x031c  */
    /* JADX WARN: Code duplicated, block: B:191:0x0330 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:192:0x0331 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0333  */
    /* JADX WARN: Code duplicated, block: B:201:0x0346  */
    /* JADX WARN: Code duplicated, block: B:204:0x0360  */
    /* JADX WARN: Code duplicated, block: B:212:0x0378  */
    /* JADX WARN: Code duplicated, block: B:214:0x0380  */
    /* JADX WARN: Code duplicated, block: B:235:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:237:0x03af  */
    /* JADX WARN: Code duplicated, block: B:245:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:247:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:248:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:250:0x03db  */
    /* JADX WARN: Code duplicated, block: B:251:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:260:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:272:0x0414 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:274:0x0422 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:27:0x0077  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    /* JADX WARN: Code duplicated, block: B:293:0x0456  */
    /* JADX WARN: Code duplicated, block: B:301:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:34:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:0x009b  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:73:0x0106  */
    /* JADX WARN: Code duplicated, block: B:75:0x0111  */
    /* JADX WARN: Code duplicated, block: B:79:0x0118  */
    /* JADX WARN: Code duplicated, block: B:81:0x011b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0121  */
    /* JADX WARN: Code duplicated, block: B:84:0x0128  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x012f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0133  */
    /* JADX WARN: Code duplicated, block: B:91:0x013f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0142  */
    /* JADX WARN: Code duplicated, block: B:99:0x0164  */
    public final void h(x.d dVar, boolean z10, boolean z11, boolean z12, boolean z13, x.i iVar, x.i iVar2, b bVar, boolean z14, d dVar2, d dVar3, int i10, int i11, int i12, int i13, float f10, boolean z15, boolean z16, boolean z17, boolean z18, int i14, int i15, int i16, int i17, float f11, boolean z19) {
        int i18;
        boolean z20;
        int iMin;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z21;
        d.b bVarH;
        d.b bVar2;
        x.i iVarQ;
        e eVar;
        d.b bVar3;
        boolean z22;
        int i25;
        char c10;
        char c11;
        d dVar4;
        boolean z23;
        boolean z24;
        boolean z25;
        int i26;
        boolean z26;
        int i27;
        boolean z27;
        boolean z28;
        x.i iVar3;
        boolean z29;
        int i28;
        int i29;
        x.i iVar4;
        e eVar2;
        x.i iVar5;
        int i30;
        int i31;
        boolean z30;
        int i32;
        int i33;
        int iC;
        int iMin2;
        int i34;
        int i35;
        boolean z31;
        int i36;
        int i37;
        int i38;
        int i39;
        boolean z32;
        x.i iVarQ2 = dVar.q(dVar2);
        x.i iVarQ3 = dVar.q(dVar3);
        x.i iVarQ4 = dVar.q(dVar2.g());
        x.i iVarQ5 = dVar.q(dVar3.g());
        x.d.w();
        boolean zJ = dVar2.j();
        boolean zJ2 = dVar3.j();
        boolean zJ3 = this.I.j();
        int i40 = zJ2 ? (zJ ? 1 : 0) + 1 : zJ ? 1 : 0;
        if (zJ3) {
            i40++;
        }
        int i41 = z15 ? 3 : i14;
        int i42 = a.f19205b[bVar.ordinal()];
        if (i42 != 1 && i42 != 2 && i42 != 3 && i42 == 4) {
            i18 = i41;
            if (i18 != 4) {
                z20 = true;
            }
            if (this.f19168f0 == 8) {
                iMin = 0;
                z20 = false;
            } else {
                iMin = i11;
            }
            if (!z19) {
                if (zJ && !zJ2 && !zJ3) {
                    dVar.f(iVarQ2, i10);
                } else if (zJ && !zJ2) {
                    i19 = 8;
                    dVar.e(iVarQ2, iVarQ4, dVar2.c(), 8);
                }
                i19 = 8;
            } else {
                i19 = 8;
            }
            if (!z20) {
                if (i40 == 2 && !z15 && (i18 == 1 || i18 == 0)) {
                    int iMax = Math.max(i16, iMin);
                    if (i17 > 0) {
                        iMax = Math.min(i17, iMax);
                    }
                    dVar.e(iVarQ3, iVarQ2, iMax, 8);
                    i24 = i16;
                    i21 = i17;
                    iVarQ4 = iVarQ4;
                    iVarQ3 = iVarQ3;
                    z21 = false;
                    i23 = i40;
                } else {
                    if (i16 == -2) {
                        i20 = iMin;
                    } else {
                        i20 = i16;
                    }
                    if (i17 == -2) {
                        i21 = iMin;
                    } else {
                        i21 = i17;
                    }
                    if (iMin > 0 && i18 != 1) {
                        iMin = 0;
                    }
                    if (i20 > 0) {
                        dVar.h(iVarQ3, iVarQ2, i20, 8);
                        iMin = Math.max(iMin, i20);
                    }
                    if (i21 > 0) {
                        if (z11 || i18 != 1) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        if (z22) {
                            i22 = 8;
                            dVar.j(iVarQ3, iVarQ2, i21, 8);
                        } else {
                            i22 = 8;
                        }
                        iMin = Math.min(iMin, i21);
                    } else {
                        i22 = 8;
                    }
                    if (i18 == 1) {
                        if (z11) {
                            dVar.e(iVarQ3, iVarQ2, iMin, i22);
                        } else {
                            dVar.e(iVarQ3, iVarQ2, iMin, 5);
                            dVar.j(iVarQ3, iVarQ2, iMin, i22);
                        }
                        i24 = i20;
                    } else if (i18 == 2) {
                        bVarH = dVar2.h();
                        bVar2 = d.b.TOP;
                        if (bVarH != bVar2 || dVar2.h() == d.b.BOTTOM) {
                            iVarQ = dVar.q(this.N.m(bVar2));
                            eVar = this.N;
                            bVar3 = d.b.BOTTOM;
                        } else {
                            iVarQ = dVar.q(this.N.m(d.b.LEFT));
                            eVar = this.N;
                            bVar3 = d.b.RIGHT;
                        }
                        x.i iVarQ6 = dVar.q(eVar.m(bVar3));
                        x.i iVar6 = iVarQ;
                        x.b bVarR = dVar.r();
                        int i43 = i20;
                        iVarQ5 = iVarQ5;
                        iVarQ4 = iVarQ4;
                        i23 = i40 == true ? 1 : 0;
                        iVarQ3 = iVarQ3;
                        dVar.d(bVarR.k(iVarQ3, iVarQ2, iVarQ6, iVar6, f11));
                        z13 = z13;
                        i24 = i43;
                        z21 = false;
                    } else {
                        iVarQ4 = iVarQ4;
                        iVarQ3 = iVarQ3;
                        int i44 = i20;
                        iVarQ5 = iVarQ5;
                        i23 = i40;
                        i24 = i44;
                        z21 = z20;
                        z13 = true;
                    }
                }
                if (z19 || z16) {
                    i25 = 8;
                    c10 = 2;
                    c11 = 1;
                    if (i23 >= c10 && z11 && z13) {
                        dVar.h(iVarQ2, iVar, 0, i25);
                        char c12 = (z10 || this.F.f19141d == null) ? c11 : (char) 0;
                        if (z10 || (dVar4 = this.F.f19141d) == null) {
                            c11 = c12;
                        } else {
                            e eVar3 = dVar4.f19139b;
                            if (eVar3.Q != 0.0f) {
                                b[] bVarArr = eVar3.M;
                                b bVar4 = bVarArr[0];
                                b bVar5 = b.MATCH_CONSTRAINT;
                                if (bVar4 != bVar5 || bVarArr[c11] != bVar5) {
                                    c11 = 0;
                                }
                            } else {
                                c11 = 0;
                            }
                        }
                        if (c11 != 0) {
                            dVar.h(iVar2, iVarQ3, 0, i25);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((zJ || zJ2 || zJ3) && (!zJ || zJ2)) {
                    if (!zJ && zJ2) {
                        dVar.e(iVarQ3, iVarQ5, -dVar3.c(), 8);
                        if (z11) {
                            dVar.h(iVarQ2, iVar, 0, 5);
                        }
                    } else if (zJ && zJ2) {
                        e eVar4 = dVar2.f19141d.f19139b;
                        e eVar5 = dVar3.f19141d.f19139b;
                        e eVarG = G();
                        int i45 = 6;
                        if (z21) {
                            if (i18 == 0) {
                                if (i21 == 0 && i24 == 0) {
                                    z32 = false;
                                    i38 = 8;
                                    i39 = 8;
                                    z26 = true;
                                } else {
                                    z26 = false;
                                    i38 = 5;
                                    i39 = 5;
                                    z32 = true;
                                }
                                if ((eVar4 instanceof y.a) || (eVar5 instanceof y.a)) {
                                    i27 = i38;
                                    z25 = z32;
                                    z24 = false;
                                    z23 = true;
                                    i26 = 4;
                                } else {
                                    i27 = i38;
                                    i45 = 6;
                                    z25 = z32;
                                    z24 = false;
                                    z23 = true;
                                    i26 = i39;
                                }
                            } else if (i18 == 1) {
                                i27 = 8;
                                i45 = 6;
                                z24 = true;
                                z23 = true;
                                i26 = 4;
                                z26 = false;
                                z25 = true;
                            } else if (i18 != 3) {
                                z23 = true;
                                z24 = false;
                                i26 = 4;
                                z26 = false;
                                z25 = false;
                            } else if (this.f19197u == -1) {
                                if (z17) {
                                    i45 = z11 ? 5 : 4;
                                } else {
                                    i45 = 8;
                                }
                                z24 = true;
                                z23 = true;
                                i26 = 5;
                                z26 = true;
                                z25 = true;
                                i27 = 8;
                            } else if (z15) {
                                if (i15 != 2) {
                                    z23 = true;
                                    if (i15 != 1) {
                                        z31 = false;
                                    }
                                    if (z31) {
                                        i36 = 5;
                                        i37 = 4;
                                    } else {
                                        i36 = 8;
                                        i37 = 5;
                                    }
                                    i27 = i36;
                                    i26 = i37;
                                    z24 = z23;
                                    z26 = z24;
                                    z25 = z26;
                                    i45 = 6;
                                } else {
                                    z23 = true;
                                }
                                z31 = z23;
                                if (z31) {
                                    i36 = 8;
                                    i37 = 5;
                                } else {
                                    i36 = 5;
                                    i37 = 4;
                                }
                                i27 = i36;
                                i26 = i37;
                                z24 = z23;
                                z26 = z24;
                                z25 = z26;
                                i45 = 6;
                            } else {
                                z23 = true;
                                if (i21 > 0) {
                                    z24 = true;
                                    z26 = true;
                                    z25 = true;
                                    i26 = 5;
                                } else if (i21 != 0 || i24 != 0) {
                                    z24 = true;
                                    z26 = true;
                                    z25 = true;
                                    i26 = 4;
                                } else if (z17) {
                                    i27 = (eVar4 == eVarG || eVar5 == eVarG) ? 5 : 4;
                                    z24 = true;
                                    z26 = true;
                                    z25 = true;
                                    i26 = 4;
                                } else {
                                    z24 = true;
                                    z26 = true;
                                    z25 = true;
                                    i26 = 8;
                                }
                            }
                            if (z24 || iVarQ4 != iVarQ5 || eVar4 == eVarG) {
                                z27 = z24;
                                z28 = z23;
                            } else {
                                z27 = false;
                                z28 = false;
                            }
                            if (z25) {
                                if (this.f19168f0 == 8) {
                                    i35 = 4;
                                } else {
                                    i35 = i45;
                                }
                                iVar3 = iVarQ3;
                                i29 = 4;
                                z29 = true;
                                i28 = 8;
                                dVar.c(iVarQ2, iVarQ4, dVar2.c(), f10, iVarQ5, iVar3, dVar3.c(), i35);
                            } else {
                                iVar3 = iVarQ3;
                                z29 = z23;
                                i28 = 8;
                                i29 = 4;
                            }
                            if (this.f19168f0 == i28) {
                                return;
                            }
                            if (z27) {
                                if (z11 || iVarQ4 == iVarQ5 || z21) {
                                    eVar2 = eVar4;
                                } else {
                                    eVar2 = eVar4;
                                    if ((eVar2 instanceof y.a) || (eVar5 instanceof y.a)) {
                                        i34 = 6;
                                    }
                                    iVar5 = iVarQ2;
                                    dVar.h(iVar5, iVarQ4, dVar2.c(), i34);
                                    iVar4 = iVar3;
                                    dVar.j(iVar4, iVarQ5, -dVar3.c(), i34);
                                    i27 = i34;
                                }
                                i34 = i27;
                                iVar5 = iVarQ2;
                                dVar.h(iVar5, iVarQ4, dVar2.c(), i34);
                                iVar4 = iVar3;
                                dVar.j(iVar4, iVarQ5, -dVar3.c(), i34);
                                i27 = i34;
                            } else {
                                iVar4 = iVar3;
                                eVar2 = eVar4;
                                iVar5 = iVarQ2;
                            }
                            if (z11 || !z18 || (eVar2 instanceof y.a) || (eVar5 instanceof y.a)) {
                                i30 = i26;
                                i31 = i27;
                                z30 = z28;
                            } else {
                                i30 = 6;
                                i31 = 6;
                                z30 = z29;
                            }
                            if (z30) {
                                if (z26 || (z17 && !z12)) {
                                    iMin2 = i30;
                                } else {
                                    if (eVar2 != eVarG && eVar5 != eVarG) {
                                        i45 = i30;
                                    }
                                    if ((eVar2 instanceof h) || (eVar5 instanceof h)) {
                                        i45 = 5;
                                    }
                                    if ((eVar2 instanceof y.a) || (eVar5 instanceof y.a)) {
                                        i45 = 5;
                                    }
                                    iMin2 = Math.max(z17 ? 5 : i45, i30);
                                }
                                if (z11) {
                                    iMin2 = Math.min(i31, iMin2);
                                    if (z15 && !z17 && (eVar2 == eVarG || eVar5 == eVarG)) {
                                        iMin2 = i29;
                                    }
                                }
                                dVar.e(iVar5, iVarQ4, dVar2.c(), iMin2);
                                dVar.e(iVar4, iVarQ5, -dVar3.c(), iMin2);
                            }
                            if (z11) {
                                i32 = i28;
                                if (iVar == iVarQ4) {
                                    iC = dVar2.c();
                                } else {
                                    iC = 0;
                                }
                                if (iVarQ4 != iVar) {
                                    dVar.h(iVar5, iVar, iC, 5);
                                }
                            } else {
                                i32 = i28;
                            }
                            if (z11 && z21 && i12 == 0 && i24 == 0) {
                                if (z21 || i18 != 3) {
                                    i33 = 0;
                                    i32 = 5;
                                } else {
                                    i33 = 0;
                                }
                                dVar.h(iVar4, iVar5, i33, i32);
                            }
                        } else {
                            z23 = true;
                            z24 = true;
                            z25 = true;
                            i26 = 4;
                            z26 = false;
                        }
                        i27 = 5;
                        if (z24) {
                            z27 = z24;
                            z28 = z23;
                        } else {
                            z27 = z24;
                            z28 = z23;
                        }
                        if (z25) {
                            if (this.f19168f0 == 8) {
                                i35 = 4;
                            } else {
                                i35 = i45;
                            }
                            iVar3 = iVarQ3;
                            i29 = 4;
                            z29 = true;
                            i28 = 8;
                            dVar.c(iVarQ2, iVarQ4, dVar2.c(), f10, iVarQ5, iVar3, dVar3.c(), i35);
                        } else {
                            iVar3 = iVarQ3;
                            z29 = z23;
                            i28 = 8;
                            i29 = 4;
                        }
                        if (this.f19168f0 == i28) {
                            return;
                        }
                        if (z27) {
                            if (z11) {
                                eVar2 = eVar4;
                                i34 = i27;
                            } else {
                                eVar2 = eVar4;
                                i34 = i27;
                            }
                            iVar5 = iVarQ2;
                            dVar.h(iVar5, iVarQ4, dVar2.c(), i34);
                            iVar4 = iVar3;
                            dVar.j(iVar4, iVarQ5, -dVar3.c(), i34);
                            i27 = i34;
                        } else {
                            iVar4 = iVar3;
                            eVar2 = eVar4;
                            iVar5 = iVarQ2;
                        }
                        if (z11) {
                            i30 = i26;
                            i31 = i27;
                            z30 = z28;
                        } else {
                            i30 = i26;
                            i31 = i27;
                            z30 = z28;
                        }
                        if (z30) {
                            if (z26) {
                                iMin2 = i30;
                            } else {
                                iMin2 = i30;
                            }
                            if (z11) {
                                iMin2 = Math.min(i31, iMin2);
                                if (z15) {
                                    iMin2 = i29;
                                }
                            }
                            dVar.e(iVar5, iVarQ4, dVar2.c(), iMin2);
                            dVar.e(iVar4, iVarQ5, -dVar3.c(), iMin2);
                        }
                        if (z11) {
                            i32 = i28;
                            if (iVar == iVarQ4) {
                                iC = dVar2.c();
                            } else {
                                iC = 0;
                            }
                            if (iVarQ4 != iVar) {
                                dVar.h(iVar5, iVar, iC, 5);
                            }
                        } else {
                            i32 = i28;
                        }
                        if (z11) {
                            if (z21) {
                                i33 = 0;
                                i32 = 5;
                            } else {
                                i33 = 0;
                                i32 = 5;
                            }
                            dVar.h(iVar4, iVar5, i33, i32);
                        }
                    }
                    iVar4 = iVarQ3;
                } else {
                    iVar4 = iVarQ3;
                }
                if (z11 && z13) {
                    int iC2 = dVar3.f19141d != null ? dVar3.c() : 0;
                    if (iVarQ5 != iVar2) {
                        dVar.h(iVar2, iVar4, iC2, 5);
                        return;
                    }
                    return;
                }
                return;
            }
            if (z14) {
                dVar.e(iVarQ3, iVarQ2, 0, 3);
                if (i12 > 0) {
                    dVar.h(iVarQ3, iVarQ2, i12, 8);
                }
                if (i13 < Integer.MAX_VALUE) {
                    dVar.j(iVarQ3, iVarQ2, i13, 8);
                }
            } else {
                dVar.e(iVarQ3, iVarQ2, iMin, i19);
            }
            i24 = i16;
            i21 = i17;
            z21 = z20;
            i23 = i40;
            if (z19) {
                i25 = 8;
                c10 = 2;
                c11 = 1;
            } else {
                i25 = 8;
                c10 = 2;
                c11 = 1;
            }
            if (i23 >= c10) {
            }
        }
        i18 = i41;
        z20 = false;
        if (this.f19168f0 == 8) {
            iMin = 0;
            z20 = false;
        } else {
            iMin = i11;
        }
        if (!z19) {
            i19 = 8;
        } else if (zJ) {
            if (zJ) {
                i19 = 8;
            } else {
                i19 = 8;
            }
        } else if (zJ) {
            i19 = 8;
        } else {
            i19 = 8;
        }
        if (!z20) {
            if (i40 == 2) {
            }
            if (i16 == -2) {
                i20 = iMin;
            } else {
                i20 = i16;
            }
            if (i17 == -2) {
                i21 = iMin;
            } else {
                i21 = i17;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i20 > 0) {
                dVar.h(iVarQ3, iVarQ2, i20, 8);
                iMin = Math.max(iMin, i20);
            }
            if (i21 > 0) {
                if (z11) {
                    z22 = true;
                } else {
                    z22 = true;
                }
                if (z22) {
                    i22 = 8;
                    dVar.j(iVarQ3, iVarQ2, i21, 8);
                } else {
                    i22 = 8;
                }
                iMin = Math.min(iMin, i21);
            } else {
                i22 = 8;
            }
            if (i18 == 1) {
                if (z11) {
                    dVar.e(iVarQ3, iVarQ2, iMin, i22);
                } else {
                    dVar.e(iVarQ3, iVarQ2, iMin, 5);
                    dVar.j(iVarQ3, iVarQ2, iMin, i22);
                }
                i24 = i20;
            } else if (i18 == 2) {
                bVarH = dVar2.h();
                bVar2 = d.b.TOP;
                if (bVarH != bVar2) {
                    iVarQ = dVar.q(this.N.m(bVar2));
                    eVar = this.N;
                    bVar3 = d.b.BOTTOM;
                } else {
                    iVarQ = dVar.q(this.N.m(bVar2));
                    eVar = this.N;
                    bVar3 = d.b.BOTTOM;
                }
                x.i iVarQ7 = dVar.q(eVar.m(bVar3));
                x.i iVar7 = iVarQ;
                x.b bVarR2 = dVar.r();
                int i46 = i20;
                iVarQ5 = iVarQ5;
                iVarQ4 = iVarQ4;
                i23 = i40 == true ? 1 : 0;
                iVarQ3 = iVarQ3;
                dVar.d(bVarR2.k(iVarQ3, iVarQ2, iVarQ7, iVar7, f11));
                z13 = z13;
                i24 = i46;
                z21 = false;
            } else {
                iVarQ4 = iVarQ4;
                iVarQ3 = iVarQ3;
                int i47 = i20;
                iVarQ5 = iVarQ5;
                i23 = i40;
                i24 = i47;
                z21 = z20;
                z13 = true;
            }
            if (z19) {
                i25 = 8;
                c10 = 2;
                c11 = 1;
            } else {
                i25 = 8;
                c10 = 2;
                c11 = 1;
            }
            if (i23 >= c10) {
            }
        }
        if (z14) {
            dVar.e(iVarQ3, iVarQ2, 0, 3);
            if (i12 > 0) {
                dVar.h(iVarQ3, iVarQ2, i12, 8);
            }
            if (i13 < Integer.MAX_VALUE) {
                dVar.j(iVarQ3, iVarQ2, i13, 8);
            }
        } else {
            dVar.e(iVarQ3, iVarQ2, iMin, i19);
        }
        i24 = i16;
        i21 = i17;
        z21 = z20;
        i23 = i40;
        if (z19) {
            i25 = 8;
            c10 = 2;
            c11 = 1;
        } else {
            i25 = 8;
            c10 = 2;
            c11 = 1;
        }
        if (i23 >= c10) {
        }
    }

    public void h0(int i10) {
        this.P = i10;
        int i11 = this.f19158a0;
        if (i10 < i11) {
            this.P = i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:97:0x01b6 A[PHI: r9 r11
  0x01b6: PHI (r9v3 y.d) = (r9v2 y.d), (r9v5 y.d) binds: [B:96:0x01b4, B:87:0x018b] A[DONT_GENERATE, DONT_INLINE]
  0x01b6: PHI (r11v6 y.d) = (r11v5 y.d), (r11v9 y.d) binds: [B:96:0x01b4, B:87:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    public void i(d.b bVar, e eVar, d.b bVar2, int i10) {
        d dVarD;
        d dVarM;
        d dVarM2;
        d.b bVar3;
        d.b bVar4;
        d dVarM3;
        d.b bVar5;
        boolean z10;
        d.b bVar6;
        d.b bVar7 = d.b.CENTER;
        if (bVar == bVar7) {
            d.b bVar8 = d.b.LEFT;
            if (bVar2 == bVar7) {
                d dVarM4 = m(bVar8);
                d.b bVar9 = d.b.RIGHT;
                d dVarM5 = m(bVar9);
                d.b bVar10 = d.b.TOP;
                d dVarM6 = m(bVar10);
                d.b bVar11 = d.b.BOTTOM;
                d dVarM7 = m(bVar11);
                boolean z11 = true;
                if ((dVarM4 == null || !dVarM4.j()) && (dVarM5 == null || !dVarM5.j())) {
                    i(bVar8, eVar, bVar8, 0);
                    i(bVar9, eVar, bVar9, 0);
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((dVarM6 == null || !dVarM6.j()) && (dVarM7 == null || !dVarM7.j())) {
                    i(bVar10, eVar, bVar10, 0);
                    i(bVar11, eVar, bVar11, 0);
                } else {
                    z11 = false;
                }
                if (!z10 || !z11) {
                    if (z10) {
                        bVar6 = d.b.CENTER_X;
                    } else if (!z11) {
                        return;
                    } else {
                        bVar6 = d.b.CENTER_Y;
                    }
                    m(bVar6).a(eVar.m(bVar6), 0);
                    return;
                }
                dVarM2 = m(bVar7);
                dVarM3 = eVar.m(bVar7);
            } else {
                if (bVar2 == bVar8 || bVar2 == d.b.RIGHT) {
                    i(bVar8, eVar, bVar2, 0);
                    bVar5 = d.b.RIGHT;
                } else {
                    d.b bVar12 = d.b.TOP;
                    if (bVar2 != bVar12 && bVar2 != d.b.BOTTOM) {
                        return;
                    }
                    i(bVar12, eVar, bVar2, 0);
                    bVar5 = d.b.BOTTOM;
                }
                i(bVar5, eVar, bVar2, 0);
                dVarM2 = m(bVar7);
                dVarM3 = eVar.m(bVar2);
            }
        } else {
            d.b bVar13 = d.b.CENTER_X;
            if (bVar == bVar13 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
                d dVarM8 = m(bVar4);
                dVarM3 = eVar.m(bVar2);
                d dVarM9 = m(d.b.RIGHT);
                dVarM8.a(dVarM3, 0);
                dVarM9.a(dVarM3, 0);
                dVarM2 = m(bVar13);
            } else {
                d.b bVar14 = d.b.CENTER_Y;
                if (bVar == bVar14 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
                    d dVarM10 = eVar.m(bVar2);
                    m(bVar3).a(dVarM10, 0);
                    m(d.b.BOTTOM).a(dVarM10, 0);
                    m(bVar14).a(dVarM10, 0);
                    return;
                }
                if (bVar == bVar13 && bVar2 == bVar13) {
                    d.b bVar15 = d.b.LEFT;
                    m(bVar15).a(eVar.m(bVar15), 0);
                    d.b bVar16 = d.b.RIGHT;
                    m(bVar16).a(eVar.m(bVar16), 0);
                    dVarM2 = m(bVar13);
                } else {
                    if (bVar != bVar14 || bVar2 != bVar14) {
                        d dVarM11 = m(bVar);
                        d dVarM12 = eVar.m(bVar2);
                        if (dVarM11.k(dVarM12)) {
                            d.b bVar17 = d.b.BASELINE;
                            if (bVar == bVar17) {
                                d dVarM13 = m(d.b.TOP);
                                d dVarM14 = m(d.b.BOTTOM);
                                if (dVarM13 != null) {
                                    dVarM13.l();
                                }
                                if (dVarM14 != null) {
                                    dVarM14.l();
                                }
                                i10 = 0;
                            } else if (bVar == d.b.TOP || bVar == d.b.BOTTOM) {
                                d dVarM15 = m(bVar17);
                                if (dVarM15 != null) {
                                    dVarM15.l();
                                }
                                d dVarM16 = m(bVar7);
                                if (dVarM16.g() != dVarM12) {
                                    dVarM16.l();
                                }
                                dVarD = m(bVar).d();
                                dVarM = m(bVar14);
                                if (dVarM.j()) {
                                    dVarD.l();
                                    dVarM.l();
                                }
                            } else if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                                d dVarM17 = m(bVar7);
                                if (dVarM17.g() != dVarM12) {
                                    dVarM17.l();
                                }
                                dVarD = m(bVar).d();
                                dVarM = m(bVar13);
                                if (dVarM.j()) {
                                    dVarD.l();
                                    dVarM.l();
                                }
                            }
                            dVarM11.a(dVarM12, i10);
                            return;
                        }
                        return;
                    }
                    d.b bVar18 = d.b.TOP;
                    m(bVar18).a(eVar.m(bVar18), 0);
                    d.b bVar19 = d.b.BOTTOM;
                    m(bVar19).a(eVar.m(bVar19), 0);
                    dVarM2 = m(bVar14);
                }
                dVarM3 = eVar.m(bVar2);
            }
        }
        dVarM2.a(dVarM3, 0);
    }

    public void i0(float f10) {
        this.f19160b0 = f10;
    }

    public void j(d dVar, d dVar2, int i10) {
        if (dVar.e() == this) {
            i(dVar.h(), dVar2.e(), dVar2.h(), i10);
        }
    }

    public void j0(int i10) {
        this.f19182m0 = i10;
    }

    public void k(e eVar, float f10, int i10) {
        d.b bVar = d.b.CENTER;
        T(bVar, eVar, bVar, i10, 0);
        this.f19201x = f10;
    }

    public void k0(int i10, int i11) {
        this.S = i10;
        int i12 = i11 - i10;
        this.O = i12;
        int i13 = this.Z;
        if (i12 < i13) {
            this.O = i13;
        }
    }

    public void l(x.d dVar) {
        dVar.q(this.B);
        dVar.q(this.C);
        dVar.q(this.D);
        dVar.q(this.E);
        if (this.Y > 0) {
            dVar.q(this.F);
        }
    }

    public void l0(b bVar) {
        this.M[0] = bVar;
    }

    public d m(d.b bVar) {
        switch (a.f19204a[bVar.ordinal()]) {
            case 1:
                return this.B;
            case 2:
                return this.C;
            case 3:
                return this.D;
            case 4:
                return this.E;
            case 5:
                return this.F;
            case 6:
                return this.I;
            case 7:
                return this.G;
            case 8:
                return this.H;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void m0(int i10, int i11, int i12, float f10) {
        this.f19179l = i10;
        this.f19185o = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f19187p = i12;
        this.f19189q = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f19179l = 2;
    }

    public int n() {
        return this.Y;
    }

    public void n0(float f10) {
        this.f19190q0[0] = f10;
    }

    public float o(int i10) {
        if (i10 == 0) {
            return this.f19160b0;
        }
        if (i10 == 1) {
            return this.f19162c0;
        }
        return -1.0f;
    }

    public void o0(int i10, boolean z10) {
        this.L[i10] = z10;
    }

    public int p() {
        return R() + this.P;
    }

    public void p0(boolean z10) {
        this.f19203z = z10;
    }

    public Object q() {
        return this.f19164d0;
    }

    public void q0(boolean z10) {
        this.A = z10;
    }

    public String r() {
        return this.f19170g0;
    }

    public void r0(int i10) {
        this.f19200w[1] = i10;
    }

    public b s(int i10) {
        if (i10 == 0) {
            return y();
        }
        if (i10 == 1) {
            return M();
        }
        return null;
    }

    public void s0(int i10) {
        this.f19200w[0] = i10;
    }

    public float t() {
        return this.Q;
    }

    public void t0(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f19158a0 = i10;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f19172h0 != null) {
            str = "type: " + this.f19172h0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f19170g0 != null) {
            str2 = "id: " + this.f19170g0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.S);
        sb2.append(", ");
        sb2.append(this.T);
        sb2.append(") - (");
        sb2.append(this.O);
        sb2.append(" x ");
        sb2.append(this.P);
        sb2.append(")");
        return sb2.toString();
    }

    public int u() {
        return this.R;
    }

    public void u0(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.Z = i10;
    }

    public int v() {
        if (this.f19168f0 == 8) {
            return 0;
        }
        return this.P;
    }

    public void v0(int i10, int i11) {
        this.S = i10;
        this.T = i11;
    }

    public float w() {
        return this.f19160b0;
    }

    public void w0(e eVar) {
        this.N = eVar;
    }

    public int x() {
        return this.f19182m0;
    }

    public void x0(float f10) {
        this.f19162c0 = f10;
    }

    public b y() {
        return this.M[0];
    }

    public void y0(int i10) {
        this.f19184n0 = i10;
    }

    public int z() {
        d dVar = this.B;
        int i10 = dVar != null ? 0 + dVar.f19142e : 0;
        d dVar2 = this.D;
        return dVar2 != null ? i10 + dVar2.f19142e : i10;
    }

    public void z0(int i10, int i11) {
        this.T = i10;
        int i12 = i11 - i10;
        this.P = i12;
        int i13 = this.f19158a0;
        if (i12 < i13) {
            this.P = i13;
        }
    }
}
