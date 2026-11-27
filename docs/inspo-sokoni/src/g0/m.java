package g0;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f8470k = k(b.f8436c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f8472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f8474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f8476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f8477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f8478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f8479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f8480j;

    public m(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f8476f = f10;
        this.f8471a = f11;
        this.f8472b = f12;
        this.f8473c = f13;
        this.f8474d = f14;
        this.f8475e = f15;
        this.f8477g = fArr;
        this.f8478h = f16;
        this.f8479i = f17;
        this.f8480j = f18;
    }

    public static m k(float[] fArr, float f10, float f11, float f12, boolean z10) {
        float[][] fArr2 = b.f8434a;
        float f13 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f14 = fArr3[0] * f13;
        float f15 = fArr[1];
        float f16 = f14 + (fArr3[1] * f15);
        float f17 = fArr[2];
        float f18 = f16 + (fArr3[2] * f17);
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[0] * f13) + (fArr4[1] * f15) + (fArr4[2] * f17);
        float[] fArr5 = fArr2[2];
        float f20 = (f13 * fArr5[0]) + (f15 * fArr5[1]) + (f17 * fArr5[2]);
        float f21 = (f12 / 10.0f) + 0.8f;
        float fD = ((double) f21) >= 0.9d ? b.d(0.59f, 0.69f, (f21 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f21 - 0.8f) * 10.0f);
        float fExp = z10 ? 1.0f : (1.0f - (((float) Math.exp(((-f10) - 42.0f) / 92.0f)) * 0.2777778f)) * f21;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f18) * fExp) + 1.0f) - fExp, (((100.0f / f19) * fExp) + 1.0f) - fExp, (((100.0f / f20) * fExp) + 1.0f) - fExp};
        float f22 = 1.0f / ((5.0f * f10) + 1.0f);
        float f23 = f22 * f22 * f22 * f22;
        float f24 = 1.0f - f23;
        float fCbrt = (f23 * f10) + (0.1f * f24 * f24 * ((float) Math.cbrt(((double) f10) * 5.0d)));
        float fH = b.h(f11) / fArr[1];
        double d11 = fH;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float fPow2 = (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f20)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f18)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f19)) / 100.0d, 0.42d), fPow2};
        float f25 = fArr7[0];
        float f26 = fArr7[1];
        return new m(fH, ((((f25 * 400.0f) / (f25 + 27.13f)) * 2.0f) + ((f26 * 400.0f) / (f26 + 27.13f)) + (((400.0f * fPow2) / (fPow2 + 27.13f)) * 0.05f)) * fPow, fPow, fPow, fD, f21, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float a() {
        return this.f8471a;
    }

    public float b() {
        return this.f8474d;
    }

    public float c() {
        return this.f8478h;
    }

    public float d() {
        return this.f8479i;
    }

    public float e() {
        return this.f8476f;
    }

    public float f() {
        return this.f8472b;
    }

    public float g() {
        return this.f8475e;
    }

    public float h() {
        return this.f8473c;
    }

    public float[] i() {
        return this.f8477g;
    }

    public float j() {
        return this.f8480j;
    }
}
