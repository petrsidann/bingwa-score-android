package x;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f17858l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f17861c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17859a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17862d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f17863e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f17864f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f17865g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f17866h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17867i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17868j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17869k = false;

    public a(b bVar, c cVar) {
        this.f17860b = bVar;
        this.f17861c = cVar;
    }

    @Override // x.b.a
    public final float a(i iVar) {
        int i10 = this.f17867i;
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            if (this.f17864f[i10] == iVar.f17916c) {
                return this.f17866h[i10];
            }
            i10 = this.f17865g[i10];
        }
        return 0.0f;
    }

    @Override // x.b.a
    public int b() {
        return this.f17859a;
    }

    @Override // x.b.a
    public final void c(i iVar, float f10) {
        if (f10 == 0.0f) {
            g(iVar, true);
            return;
        }
        int i10 = this.f17867i;
        if (i10 == -1) {
            this.f17867i = 0;
            this.f17866h[0] = f10;
            this.f17864f[0] = iVar.f17916c;
            this.f17865g[0] = -1;
            iVar.f17926m++;
            iVar.a(this.f17860b);
            this.f17859a++;
            if (this.f17869k) {
                return;
            }
            int i11 = this.f17868j + 1;
            this.f17868j = i11;
            int[] iArr = this.f17864f;
            if (i11 >= iArr.length) {
                this.f17869k = true;
                this.f17868j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f17859a; i13++) {
            int i14 = this.f17864f[i10];
            int i15 = iVar.f17916c;
            if (i14 == i15) {
                this.f17866h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f17865g[i10];
        }
        int length = this.f17868j;
        int i16 = length + 1;
        if (this.f17869k) {
            int[] iArr2 = this.f17864f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f17864f;
        if (length >= iArr3.length && this.f17859a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f17864f;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f17864f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f17862d * 2;
            this.f17862d = i18;
            this.f17869k = false;
            this.f17868j = length - 1;
            this.f17866h = Arrays.copyOf(this.f17866h, i18);
            this.f17864f = Arrays.copyOf(this.f17864f, this.f17862d);
            this.f17865g = Arrays.copyOf(this.f17865g, this.f17862d);
        }
        this.f17864f[length] = iVar.f17916c;
        this.f17866h[length] = f10;
        int[] iArr6 = this.f17865g;
        if (i12 != -1) {
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            iArr6[length] = this.f17867i;
            this.f17867i = length;
        }
        iVar.f17926m++;
        iVar.a(this.f17860b);
        int i19 = this.f17859a + 1;
        this.f17859a = i19;
        if (!this.f17869k) {
            this.f17868j++;
        }
        int[] iArr7 = this.f17864f;
        if (i19 >= iArr7.length) {
            this.f17869k = true;
        }
        if (this.f17868j >= iArr7.length) {
            this.f17869k = true;
            this.f17868j = iArr7.length - 1;
        }
    }

    @Override // x.b.a
    public final void clear() {
        int i10 = this.f17867i;
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            i iVar = this.f17861c.f17879d[this.f17864f[i10]];
            if (iVar != null) {
                iVar.c(this.f17860b);
            }
            i10 = this.f17865g[i10];
        }
        this.f17867i = -1;
        this.f17868j = -1;
        this.f17869k = false;
        this.f17859a = 0;
    }

    @Override // x.b.a
    public i d(int i10) {
        int i11 = this.f17867i;
        for (int i12 = 0; i11 != -1 && i12 < this.f17859a; i12++) {
            if (i12 == i10) {
                return this.f17861c.f17879d[this.f17864f[i11]];
            }
            i11 = this.f17865g[i11];
        }
        return null;
    }

    @Override // x.b.a
    public void e() {
        int i10 = this.f17867i;
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            float[] fArr = this.f17866h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f17865g[i10];
        }
    }

    @Override // x.b.a
    public float f(int i10) {
        int i11 = this.f17867i;
        for (int i12 = 0; i11 != -1 && i12 < this.f17859a; i12++) {
            if (i12 == i10) {
                return this.f17866h[i11];
            }
            i11 = this.f17865g[i11];
        }
        return 0.0f;
    }

    @Override // x.b.a
    public final float g(i iVar, boolean z10) {
        if (this.f17863e == iVar) {
            this.f17863e = null;
        }
        int i10 = this.f17867i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f17859a) {
            if (this.f17864f[i10] == iVar.f17916c) {
                if (i10 == this.f17867i) {
                    this.f17867i = this.f17865g[i10];
                } else {
                    int[] iArr = this.f17865g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.c(this.f17860b);
                }
                iVar.f17926m--;
                this.f17859a--;
                this.f17864f[i10] = -1;
                if (this.f17869k) {
                    this.f17868j = i10;
                }
                return this.f17866h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f17865g[i10];
        }
        return 0.0f;
    }

    @Override // x.b.a
    public float h(b bVar, boolean z10) {
        float fA = a(bVar.f17870a);
        g(bVar.f17870a, z10);
        b.a aVar = bVar.f17874e;
        int iB = aVar.b();
        for (int i10 = 0; i10 < iB; i10++) {
            i iVarD = aVar.d(i10);
            i(iVarD, aVar.a(iVarD) * fA, z10);
        }
        return fA;
    }

    @Override // x.b.a
    public void i(i iVar, float f10, boolean z10) {
        float f11 = f17858l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f17867i;
            if (i10 == -1) {
                this.f17867i = 0;
                this.f17866h[0] = f10;
                this.f17864f[0] = iVar.f17916c;
                this.f17865g[0] = -1;
                iVar.f17926m++;
                iVar.a(this.f17860b);
                this.f17859a++;
                if (this.f17869k) {
                    return;
                }
                int i11 = this.f17868j + 1;
                this.f17868j = i11;
                int[] iArr = this.f17864f;
                if (i11 >= iArr.length) {
                    this.f17869k = true;
                    this.f17868j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f17859a; i13++) {
                int i14 = this.f17864f[i10];
                int i15 = iVar.f17916c;
                if (i14 == i15) {
                    float[] fArr = this.f17866h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f17858l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f17867i) {
                            this.f17867i = this.f17865g[i10];
                        } else {
                            int[] iArr2 = this.f17865g;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            iVar.c(this.f17860b);
                        }
                        if (this.f17869k) {
                            this.f17868j = i10;
                        }
                        iVar.f17926m--;
                        this.f17859a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f17865g[i10];
            }
            int length = this.f17868j;
            int i16 = length + 1;
            if (this.f17869k) {
                int[] iArr3 = this.f17864f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f17864f;
            if (length >= iArr4.length && this.f17859a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f17864f;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.f17864f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f17862d * 2;
                this.f17862d = i18;
                this.f17869k = false;
                this.f17868j = length - 1;
                this.f17866h = Arrays.copyOf(this.f17866h, i18);
                this.f17864f = Arrays.copyOf(this.f17864f, this.f17862d);
                this.f17865g = Arrays.copyOf(this.f17865g, this.f17862d);
            }
            this.f17864f[length] = iVar.f17916c;
            this.f17866h[length] = f10;
            int[] iArr7 = this.f17865g;
            if (i12 != -1) {
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                iArr7[length] = this.f17867i;
                this.f17867i = length;
            }
            iVar.f17926m++;
            iVar.a(this.f17860b);
            this.f17859a++;
            if (!this.f17869k) {
                this.f17868j++;
            }
            int i19 = this.f17868j;
            int[] iArr8 = this.f17864f;
            if (i19 >= iArr8.length) {
                this.f17869k = true;
                this.f17868j = iArr8.length - 1;
            }
        }
    }

    @Override // x.b.a
    public void j(float f10) {
        int i10 = this.f17867i;
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            float[] fArr = this.f17866h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f17865g[i10];
        }
    }

    @Override // x.b.a
    public boolean k(i iVar) {
        int i10 = this.f17867i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            if (this.f17864f[i10] == iVar.f17916c) {
                return true;
            }
            i10 = this.f17865g[i10];
        }
        return false;
    }

    public String toString() {
        int i10 = this.f17867i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f17859a; i11++) {
            str = ((str + " -> ") + this.f17866h[i10] + " : ") + this.f17861c.f17879d[this.f17864f[i10]];
            i10 = this.f17865g[i10];
        }
        return str;
    }
}
