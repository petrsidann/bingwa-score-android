package h5;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f9634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f9637h;

    public a(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.f9630a = i10;
        this.f9631b = k0.a.a(f10, f11, f12);
        this.f9632c = i11;
        this.f9634e = f13;
        this.f9633d = i12;
        this.f9635f = f14;
        this.f9636g = i13;
        d(f15, f11, f12, f14);
        this.f9637h = b(f14);
    }

    public static a c(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = i14;
                    int i16 = length2;
                    int i17 = i12;
                    int i18 = length;
                    a aVar2 = new a(i10, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (aVar == null || aVar2.f9637h < aVar.f9637h) {
                        if (aVar2.f9637h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i10++;
                    i14 = i15 + 1;
                    length2 = i16;
                    i12 = i17;
                    length = i18;
                }
                i12++;
            }
        }
        return aVar;
    }

    public final float a(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = 0.0f;
        }
        float f12 = i11 / 2.0f;
        return (f10 - ((i10 + f12) * f11)) / (i12 + f12);
    }

    public final float b(float f10) {
        if (g()) {
            return Math.abs(f10 - this.f9635f) * this.f9630a;
        }
        return Float.MAX_VALUE;
    }

    public final void d(float f10, float f11, float f12, float f13) {
        float f14;
        float f15 = f10 - f();
        int i10 = this.f9632c;
        if (i10 > 0 && f15 > 0.0f) {
            float f16 = this.f9631b;
            this.f9631b = f16 + Math.min(f15 / i10, f12 - f16);
        } else if (i10 > 0 && f15 < 0.0f) {
            float f17 = this.f9631b;
            this.f9631b = f17 + Math.max(f15 / i10, f11 - f17);
        }
        int i11 = this.f9632c;
        float f18 = i11 > 0 ? this.f9631b : 0.0f;
        this.f9631b = f18;
        float fA = a(f10, i11, f18, this.f9633d, this.f9636g);
        this.f9635f = fA;
        float f19 = (this.f9631b + fA) / 2.0f;
        this.f9634e = f19;
        int i12 = this.f9633d;
        if (i12 <= 0 || fA == f13) {
            return;
        }
        float f20 = (f13 - fA) * this.f9636g;
        float fMin = Math.min(Math.abs(f20), f19 * 0.1f * i12);
        if (f20 > 0.0f) {
            this.f9634e -= fMin / this.f9633d;
            f14 = this.f9635f + (fMin / this.f9636g);
        } else {
            this.f9634e += fMin / this.f9633d;
            f14 = this.f9635f - (fMin / this.f9636g);
        }
        this.f9635f = f14;
    }

    public int e() {
        return this.f9632c + this.f9633d + this.f9636g;
    }

    public final float f() {
        return (this.f9635f * this.f9636g) + (this.f9634e * this.f9633d) + (this.f9631b * this.f9632c);
    }

    public final boolean g() {
        int i10 = this.f9636g;
        if (i10 <= 0 || this.f9632c <= 0 || this.f9633d <= 0) {
            return i10 <= 0 || this.f9632c <= 0 || this.f9635f > this.f9631b;
        }
        float f10 = this.f9635f;
        float f11 = this.f9634e;
        return f10 > f11 && f11 > this.f9631b;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f9630a + ", smallCount=" + this.f9632c + ", smallSize=" + this.f9631b + ", mediumCount=" + this.f9633d + ", mediumSize=" + this.f9634e + ", largeCount=" + this.f9636g + ", largeSize=" + this.f9635f + ", cost=" + this.f9637h + "]";
    }
}
