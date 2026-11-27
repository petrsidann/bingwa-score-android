package x;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f17934n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17935a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17936b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17937c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f17938d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f17939e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f17940f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f17941g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f17942h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f17943i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17944j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17945k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f17946l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f17947m;

    public j(b bVar, c cVar) {
        this.f17946l = bVar;
        this.f17947m = cVar;
        clear();
    }

    @Override // x.b.a
    public float a(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f17941g[iP];
        }
        return 0.0f;
    }

    @Override // x.b.a
    public int b() {
        return this.f17944j;
    }

    @Override // x.b.a
    public void c(i iVar, float f10) {
        float f11 = f17934n;
        if (f10 > (-f11) && f10 < f11) {
            g(iVar, true);
            return;
        }
        if (this.f17944j == 0) {
            m(0, iVar, f10);
            l(iVar, 0);
            this.f17945k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f17941g[iP] = f10;
            return;
        }
        if (this.f17944j + 1 >= this.f17936b) {
            o();
        }
        int i10 = this.f17944j;
        int i11 = this.f17945k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f17940f[i11];
            int i15 = iVar.f17916c;
            if (i14 == i15) {
                this.f17941g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f17943i[i11];
            if (i11 == -1) {
                break;
            }
        }
        q(i12, iVar, f10);
    }

    @Override // x.b.a
    public void clear() {
        int i10 = this.f17944j;
        for (int i11 = 0; i11 < i10; i11++) {
            i iVarD = d(i11);
            if (iVarD != null) {
                iVarD.c(this.f17946l);
            }
        }
        for (int i12 = 0; i12 < this.f17936b; i12++) {
            this.f17940f[i12] = -1;
            this.f17939e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f17937c; i13++) {
            this.f17938d[i13] = -1;
        }
        this.f17944j = 0;
        this.f17945k = -1;
    }

    @Override // x.b.a
    public i d(int i10) {
        int i11 = this.f17944j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f17945k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f17947m.f17879d[this.f17940f[i12]];
            }
            i12 = this.f17943i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // x.b.a
    public void e() {
        int i10 = this.f17944j;
        int i11 = this.f17945k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f17941g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f17943i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // x.b.a
    public float f(int i10) {
        int i11 = this.f17944j;
        int i12 = this.f17945k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f17941g[i12];
            }
            i12 = this.f17943i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // x.b.a
    public float g(i iVar, boolean z10) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f10 = this.f17941g[iP];
        if (this.f17945k == iP) {
            this.f17945k = this.f17943i[iP];
        }
        this.f17940f[iP] = -1;
        int[] iArr = this.f17942h;
        int i10 = iArr[iP];
        if (i10 != -1) {
            int[] iArr2 = this.f17943i;
            iArr2[i10] = iArr2[iP];
        }
        int i11 = this.f17943i[iP];
        if (i11 != -1) {
            iArr[i11] = iArr[iP];
        }
        this.f17944j--;
        iVar.f17926m--;
        if (z10) {
            iVar.c(this.f17946l);
        }
        return f10;
    }

    @Override // x.b.a
    public float h(b bVar, boolean z10) {
        float fA = a(bVar.f17870a);
        g(bVar.f17870a, z10);
        j jVar = (j) bVar.f17874e;
        int iB = jVar.b();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iB) {
            int i12 = jVar.f17940f[i11];
            if (i12 != -1) {
                i(this.f17947m.f17879d[i12], jVar.f17941g[i11] * fA, z10);
                i10++;
            }
            i11++;
        }
        return fA;
    }

    @Override // x.b.a
    public void i(i iVar, float f10, boolean z10) {
        float f11 = f17934n;
        if (f10 <= (-f11) || f10 >= f11) {
            int iP = p(iVar);
            if (iP == -1) {
                c(iVar, f10);
                return;
            }
            float[] fArr = this.f17941g;
            float f12 = fArr[iP] + f10;
            fArr[iP] = f12;
            float f13 = f17934n;
            if (f12 <= (-f13) || f12 >= f13) {
                return;
            }
            fArr[iP] = 0.0f;
            g(iVar, z10);
        }
    }

    @Override // x.b.a
    public void j(float f10) {
        int i10 = this.f17944j;
        int i11 = this.f17945k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f17941g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f17943i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // x.b.a
    public boolean k(i iVar) {
        return p(iVar) != -1;
    }

    public final void l(i iVar, int i10) {
        int[] iArr;
        int i11 = iVar.f17916c % this.f17937c;
        int[] iArr2 = this.f17938d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f17939e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f17939e[i10] = -1;
    }

    public final void m(int i10, i iVar, float f10) {
        this.f17940f[i10] = iVar.f17916c;
        this.f17941g[i10] = f10;
        this.f17942h[i10] = -1;
        this.f17943i[i10] = -1;
        iVar.a(this.f17946l);
        iVar.f17926m++;
        this.f17944j++;
    }

    public final int n() {
        for (int i10 = 0; i10 < this.f17936b; i10++) {
            if (this.f17940f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    public final void o() {
        int i10 = this.f17936b * 2;
        this.f17940f = Arrays.copyOf(this.f17940f, i10);
        this.f17941g = Arrays.copyOf(this.f17941g, i10);
        this.f17942h = Arrays.copyOf(this.f17942h, i10);
        this.f17943i = Arrays.copyOf(this.f17943i, i10);
        this.f17939e = Arrays.copyOf(this.f17939e, i10);
        for (int i11 = this.f17936b; i11 < i10; i11++) {
            this.f17940f[i11] = -1;
            this.f17939e[i11] = -1;
        }
        this.f17936b = i10;
    }

    public int p(i iVar) {
        if (this.f17944j == 0) {
            return -1;
        }
        int i10 = iVar.f17916c;
        int i11 = this.f17938d[i10 % this.f17937c];
        if (i11 == -1) {
            return -1;
        }
        if (this.f17940f[i11] == i10) {
            return i11;
        }
        do {
            i11 = this.f17939e[i11];
            if (i11 == -1) {
                break;
            }
        } while (this.f17940f[i11] != i10);
        if (i11 != -1 && this.f17940f[i11] == i10) {
            return i11;
        }
        return -1;
    }

    public final void q(int i10, i iVar, float f10) {
        int iN = n();
        m(iN, iVar, f10);
        if (i10 != -1) {
            this.f17942h[iN] = i10;
            int[] iArr = this.f17943i;
            iArr[iN] = iArr[i10];
            iArr[i10] = iN;
        } else {
            this.f17942h[iN] = -1;
            if (this.f17944j > 0) {
                this.f17943i[iN] = this.f17945k;
                this.f17945k = iN;
            } else {
                this.f17943i[iN] = -1;
            }
        }
        int i11 = this.f17943i[iN];
        if (i11 != -1) {
            this.f17942h[i11] = iN;
        }
        l(iVar, iN);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i10;
        int i11 = iVar.f17916c;
        int i12 = i11 % this.f17937c;
        int[] iArr2 = this.f17938d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f17940f[i13] == i11) {
            int[] iArr3 = this.f17939e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f17939e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f17940f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 == -1 || this.f17940f[i10] != i11) {
            return;
        }
        iArr[i13] = iArr[i10];
        iArr[i10] = -1;
    }

    public String toString() {
        StringBuilder sb2;
        String str = hashCode() + " { ";
        int i10 = this.f17944j;
        for (int i11 = 0; i11 < i10; i11++) {
            i iVarD = d(i11);
            if (iVarD != null) {
                String str2 = str + iVarD + " = " + f(i11) + " ";
                int iP = p(iVarD);
                String str3 = str2 + "[p: ";
                if (this.f17942h[iP] != -1) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(this.f17947m.f17879d[this.f17940f[this.f17942h[iP]]]);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append("none");
                }
                String str4 = sb2.toString() + ", n: ";
                str = (this.f17943i[iP] != -1 ? str4 + this.f17947m.f17879d[this.f17940f[this.f17943i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
