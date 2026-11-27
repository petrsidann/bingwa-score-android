package x;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f17880q = 1000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f17881r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f17882s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f17883t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f17886c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x.b[] f17889f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f17896m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f17899p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17884a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, i> f17885b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17887d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17888e = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17890g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17891h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f17892i = new boolean[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17893j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17894k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17895l = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i[] f17897n = new i[f17880q];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17898o = 0;

    public interface a {
        void a(a aVar);

        void b(i iVar);

        i c(d dVar, boolean[] zArr);

        void clear();

        i getKey();
    }

    public class b extends x.b {
        public b(c cVar) {
            this.f17874e = new j(this, cVar);
        }
    }

    public d() {
        this.f17889f = null;
        this.f17889f = new x.b[32];
        C();
        c cVar = new c();
        this.f17896m = cVar;
        this.f17886c = new h(cVar);
        this.f17899p = f17881r ? new b(cVar) : new x.b(cVar);
    }

    public static x.b s(d dVar, i iVar, i iVar2, float f10) {
        return dVar.r().j(iVar, iVar2, f10);
    }

    public static e w() {
        return null;
    }

    public void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public final int B(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f17893j; i10++) {
            this.f17892i[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f17893j * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f17892i[aVar.getKey().f17916c] = true;
            }
            i iVarC = aVar.c(this, this.f17892i);
            if (iVarC != null) {
                boolean[] zArr = this.f17892i;
                int i12 = iVarC.f17916c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (iVarC != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f17894k; i14++) {
                    x.b bVar = this.f17889f[i14];
                    if (bVar.f17870a.f17923j != i.a.UNRESTRICTED && !bVar.f17875f && bVar.t(iVarC)) {
                        float fA = bVar.f17874e.a(iVarC);
                        if (fA < 0.0f) {
                            float f11 = (-bVar.f17871b) / fA;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    x.b bVar2 = this.f17889f[i13];
                    bVar2.f17870a.f17917d = -1;
                    bVar2.y(iVarC);
                    i iVar = bVar2.f17870a;
                    iVar.f17917d = i13;
                    iVar.g(bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    public final void C() {
        int i10 = 0;
        if (f17881r) {
            while (true) {
                x.b[] bVarArr = this.f17889f;
                if (i10 >= bVarArr.length) {
                    return;
                }
                x.b bVar = bVarArr[i10];
                if (bVar != null) {
                    this.f17896m.f17876a.a(bVar);
                }
                this.f17889f[i10] = null;
                i10++;
            }
        } else {
            while (true) {
                x.b[] bVarArr2 = this.f17889f;
                if (i10 >= bVarArr2.length) {
                    return;
                }
                x.b bVar2 = bVarArr2[i10];
                if (bVar2 != null) {
                    this.f17896m.f17877b.a(bVar2);
                }
                this.f17889f[i10] = null;
                i10++;
            }
        }
    }

    public void D() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f17896m;
            i[] iVarArr = cVar.f17879d;
            if (i10 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i10];
            if (iVar != null) {
                iVar.d();
            }
            i10++;
        }
        cVar.f17878c.c(this.f17897n, this.f17898o);
        this.f17898o = 0;
        Arrays.fill(this.f17896m.f17879d, (Object) null);
        HashMap<String, i> map = this.f17885b;
        if (map != null) {
            map.clear();
        }
        this.f17884a = 0;
        this.f17886c.clear();
        this.f17893j = 1;
        for (int i11 = 0; i11 < this.f17894k; i11++) {
            this.f17889f[i11].f17872c = false;
        }
        C();
        this.f17894k = 0;
        this.f17899p = f17881r ? new b(this.f17896m) : new x.b(this.f17896m);
    }

    public final i a(i.a aVar, String str) {
        i iVarB = this.f17896m.f17878c.b();
        if (iVarB == null) {
            iVarB = new i(aVar, str);
        } else {
            iVarB.d();
        }
        iVarB.f(aVar, str);
        int i10 = this.f17898o;
        int i11 = f17880q;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f17880q = i12;
            this.f17897n = (i[]) Arrays.copyOf(this.f17897n, i12);
        }
        i[] iVarArr = this.f17897n;
        int i13 = this.f17898o;
        this.f17898o = i13 + 1;
        iVarArr[i13] = iVarB;
        return iVarB;
    }

    public void b(y.e eVar, y.e eVar2, float f10, int i10) {
        y.d.b bVar = y.d.b.LEFT;
        i iVarQ = q(eVar.m(bVar));
        y.d.b bVar2 = y.d.b.TOP;
        i iVarQ2 = q(eVar.m(bVar2));
        y.d.b bVar3 = y.d.b.RIGHT;
        i iVarQ3 = q(eVar.m(bVar3));
        y.d.b bVar4 = y.d.b.BOTTOM;
        i iVarQ4 = q(eVar.m(bVar4));
        i iVarQ5 = q(eVar2.m(bVar));
        i iVarQ6 = q(eVar2.m(bVar2));
        i iVarQ7 = q(eVar2.m(bVar3));
        i iVarQ8 = q(eVar2.m(bVar4));
        x.b bVarR = r();
        double d10 = f10;
        double d11 = i10;
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d10) * d11));
        d(bVarR);
        x.b bVarR2 = r();
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d10) * d11));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11, int i12) {
        x.b bVarR = r();
        bVarR.h(iVar, iVar2, i10, f10, iVar3, iVar4, i11);
        if (i12 != 8) {
            bVarR.d(this, i12);
        }
        d(bVarR);
    }

    public void d(x.b bVar) {
        i iVarW;
        if (bVar == null) {
            return;
        }
        boolean z10 = true;
        if (this.f17894k + 1 >= this.f17895l || this.f17893j + 1 >= this.f17888e) {
            y();
        }
        boolean z11 = false;
        if (!bVar.f17875f) {
            bVar.D(this);
            if (bVar.u()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i iVarP = p();
                bVar.f17870a = iVarP;
                l(bVar);
                this.f17899p.a(bVar);
                B(this.f17899p, true);
                if (iVarP.f17917d == -1) {
                    if (bVar.f17870a == iVarP && (iVarW = bVar.w(iVarP)) != null) {
                        bVar.y(iVarW);
                    }
                    if (!bVar.f17875f) {
                        bVar.f17870a.g(bVar);
                    }
                    this.f17894k--;
                }
            } else {
                z10 = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z11 = z10;
            }
        }
        if (z11) {
            return;
        }
        l(bVar);
    }

    public x.b e(i iVar, i iVar2, int i10, int i11) {
        if (i11 == 8 && iVar2.f17920g && iVar.f17917d == -1) {
            iVar.e(this, iVar2.f17919f + i10);
            return null;
        }
        x.b bVarR = r();
        bVarR.n(iVar, iVar2, i10);
        if (i11 != 8) {
            bVarR.d(this, i11);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i10) {
        x.b bVarR;
        int i11 = iVar.f17917d;
        if (i11 == -1) {
            iVar.e(this, i10);
            return;
        }
        if (i11 != -1) {
            x.b bVar = this.f17889f[i11];
            if (!bVar.f17875f) {
                if (bVar.f17874e.b() == 0) {
                    bVar.f17875f = true;
                } else {
                    bVarR = r();
                    bVarR.m(iVar, i10);
                }
            }
            bVar.f17871b = i10;
            return;
        }
        bVarR = r();
        bVarR.i(iVar, i10);
        d(bVarR);
    }

    public void g(i iVar, i iVar2, int i10, boolean z10) {
        x.b bVarR = r();
        i iVarT = t();
        iVarT.f17918e = 0;
        bVarR.o(iVar, iVar2, iVarT, i10);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i10, int i11) {
        x.b bVarR = r();
        i iVarT = t();
        iVarT.f17918e = 0;
        bVarR.o(iVar, iVar2, iVarT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f17874e.a(iVarT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i10, boolean z10) {
        x.b bVarR = r();
        i iVarT = t();
        iVarT.f17918e = 0;
        bVarR.p(iVar, iVar2, iVarT, i10);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i10, int i11) {
        x.b bVarR = r();
        i iVarT = t();
        iVarT.f17918e = 0;
        bVarR.p(iVar, iVar2, iVarT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f17874e.a(iVarT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f10, int i10) {
        x.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f10);
        if (i10 != 8) {
            bVarR.d(this, i10);
        }
        d(bVarR);
    }

    public final void l(x.b bVar) {
        x.b bVar2;
        f<x.b> fVar;
        if (f17881r) {
            bVar2 = this.f17889f[this.f17894k];
            if (bVar2 != null) {
                fVar = this.f17896m.f17876a;
                fVar.a(bVar2);
            }
        } else {
            bVar2 = this.f17889f[this.f17894k];
            if (bVar2 != null) {
                fVar = this.f17896m.f17877b;
                fVar.a(bVar2);
            }
        }
        x.b[] bVarArr = this.f17889f;
        int i10 = this.f17894k;
        bVarArr[i10] = bVar;
        i iVar = bVar.f17870a;
        iVar.f17917d = i10;
        this.f17894k = i10 + 1;
        iVar.g(bVar);
    }

    public void m(x.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public final void n() {
        for (int i10 = 0; i10 < this.f17894k; i10++) {
            x.b bVar = this.f17889f[i10];
            bVar.f17870a.f17919f = bVar.f17871b;
        }
    }

    public i o(int i10, String str) {
        if (this.f17893j + 1 >= this.f17888e) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i11 = this.f17884a + 1;
        this.f17884a = i11;
        this.f17893j++;
        iVarA.f17916c = i11;
        iVarA.f17918e = i10;
        this.f17896m.f17879d[i11] = iVarA;
        this.f17886c.b(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f17893j + 1 >= this.f17888e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i10 = this.f17884a + 1;
        this.f17884a = i10;
        this.f17893j++;
        iVarA.f17916c = i10;
        this.f17896m.f17879d[i10] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarF = null;
        if (obj == null) {
            return null;
        }
        if (this.f17893j + 1 >= this.f17888e) {
            y();
        }
        if (obj instanceof y.d) {
            y.d dVar = (y.d) obj;
            iVarF = dVar.f();
            if (iVarF == null) {
                dVar.m(this.f17896m);
                iVarF = dVar.f();
            }
            int i10 = iVarF.f17916c;
            if (i10 == -1 || i10 > this.f17884a || this.f17896m.f17879d[i10] == null) {
                if (i10 != -1) {
                    iVarF.d();
                }
                int i11 = this.f17884a + 1;
                this.f17884a = i11;
                this.f17893j++;
                iVarF.f17916c = i11;
                iVarF.f17923j = i.a.UNRESTRICTED;
                this.f17896m.f17879d[i11] = iVarF;
            }
        }
        return iVarF;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0038 A[PHI: r0
  0x0038: PHI (r0v6 x.b) = (r0v4 x.b), (r0v11 x.b) binds: [B:8:0x0029, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    public x.b r() {
        x.b bVarB;
        if (f17881r) {
            bVarB = this.f17896m.f17876a.b();
            if (bVarB == null) {
                bVarB = new b(this.f17896m);
                f17883t++;
            } else {
                bVarB.z();
            }
        } else {
            bVarB = this.f17896m.f17877b.b();
            if (bVarB == null) {
                bVarB = new x.b(this.f17896m);
                f17882s++;
            } else {
                bVarB.z();
            }
        }
        i.b();
        return bVarB;
    }

    public i t() {
        if (this.f17893j + 1 >= this.f17888e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i10 = this.f17884a + 1;
        this.f17884a = i10;
        this.f17893j++;
        iVarA.f17916c = i10;
        this.f17896m.f17879d[i10] = iVarA;
        return iVarA;
    }

    public final int u(a aVar) {
        float f10;
        boolean z10;
        int i10 = 0;
        while (true) {
            f10 = 0.0f;
            if (i10 >= this.f17894k) {
                z10 = false;
                break;
            }
            x.b bVar = this.f17889f[i10];
            if (bVar.f17870a.f17923j != i.a.UNRESTRICTED && bVar.f17871b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            float f11 = Float.MAX_VALUE;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            int i15 = 0;
            while (i14 < this.f17894k) {
                x.b bVar2 = this.f17889f[i14];
                if (bVar2.f17870a.f17923j != i.a.UNRESTRICTED && !bVar2.f17875f && bVar2.f17871b < f10) {
                    int i16 = 1;
                    while (i16 < this.f17893j) {
                        i iVar = this.f17896m.f17879d[i16];
                        float fA = bVar2.f17874e.a(iVar);
                        if (fA > f10) {
                            for (int i17 = 0; i17 < 9; i17++) {
                                float f12 = iVar.f17921h[i17] / fA;
                                if ((f12 < f11 && i17 == i15) || i17 > i15) {
                                    i15 = i17;
                                    f11 = f12;
                                    i12 = i14;
                                    i13 = i16;
                                }
                            }
                        }
                        i16++;
                        f10 = 0.0f;
                    }
                }
                i14++;
                f10 = 0.0f;
            }
            if (i12 != -1) {
                x.b bVar3 = this.f17889f[i12];
                bVar3.f17870a.f17917d = -1;
                bVar3.y(this.f17896m.f17879d[i13]);
                i iVar2 = bVar3.f17870a;
                iVar2.f17917d = i12;
                iVar2.g(bVar3);
            } else {
                z11 = true;
            }
            if (i11 > this.f17893j / 2) {
                z11 = true;
            }
            f10 = 0.0f;
        }
        return i11;
    }

    public c v() {
        return this.f17896m;
    }

    public int x(Object obj) {
        i iVarF = ((y.d) obj).f();
        if (iVarF != null) {
            return (int) (iVarF.f17919f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i10 = this.f17887d * 2;
        this.f17887d = i10;
        this.f17889f = (x.b[]) Arrays.copyOf(this.f17889f, i10);
        c cVar = this.f17896m;
        cVar.f17879d = (i[]) Arrays.copyOf(cVar.f17879d, this.f17887d);
        int i11 = this.f17887d;
        this.f17892i = new boolean[i11];
        this.f17888e = i11;
        this.f17895l = i11;
    }

    public void z() {
        if (this.f17890g || this.f17891h) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.f17894k) {
                    z10 = true;
                    break;
                } else if (!this.f17889f[i10].f17875f) {
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                n();
                return;
            }
        }
        A(this.f17886c);
    }
}
