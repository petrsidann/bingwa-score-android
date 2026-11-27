package g0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f8426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f8428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f8430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f8431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f8432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f8433i;

    public a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f8425a = f10;
        this.f8426b = f11;
        this.f8427c = f12;
        this.f8428d = f13;
        this.f8429e = f14;
        this.f8430f = f15;
        this.f8431g = f16;
        this.f8432h = f17;
        this.f8433i = f18;
    }

    public static a b(float f10, float f11, float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        float f15 = 0.0f;
        a aVar = null;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f13) > 0.01f) {
            float f17 = ((f13 - f15) / 2.0f) + f15;
            int iP = e(f17, f11, f10).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f12 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f10));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f14 = fAbs;
                    f16 = fA;
                }
            }
            if (f14 == 0.0f && f16 == 0.0f) {
                break;
            }
            if (fB < f12) {
                f15 = f17;
            } else {
                f13 = f17;
            }
        }
        return aVar;
    }

    public static a c(int i10) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i10, m.f8470k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i10, m mVar, float[] fArr, float[] fArr2) {
        b.f(i10, fArr2);
        float[][] fArr3 = b.f8434a;
        float f10 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f11 = fArr4[0] * f10;
        float f12 = fArr2[1];
        float f13 = f11 + (fArr4[1] * f12);
        float f14 = fArr2[2];
        float f15 = f13 + (fArr4[2] * f14);
        float[] fArr5 = fArr3[1];
        float f16 = (fArr5[0] * f10) + (fArr5[1] * f12) + (fArr5[2] * f14);
        float[] fArr6 = fArr3[2];
        float f17 = (f10 * fArr6[0]) + (f12 * fArr6[1]) + (f14 * fArr6[2]);
        float f18 = mVar.i()[0] * f15;
        float f19 = mVar.i()[1] * f16;
        float f20 = mVar.i()[2] * f17;
        float fPow = (float) Math.pow(((double) (mVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (mVar.c() * Math.abs(f19))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (mVar.c() * Math.abs(f20))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f18) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f19) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f20) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f21 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d10)) / 11.0f;
        float f22 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f23 = fSignum2 * 20.0f;
        float f24 = (((fSignum * 20.0f) + f23) + (21.0f * fSignum3)) / 20.0f;
        float f25 = (((fSignum * 40.0f) + f23) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f22, f21)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f26 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f25 * mVar.f()) / mVar.a(), mVar.b() * mVar.j())) * 100.0f;
        float fB = (4.0f / mVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (mVar.a() + 4.0f) * mVar.d();
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, mVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * mVar.g()) * mVar.h()) * ((float) Math.sqrt((f21 * f21) + (f22 * f22)))) / (f24 + 0.305f), 0.9d));
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * fPow5;
        float fD = mVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((fPow5 * mVar.b()) / (mVar.a() + 4.0f))) * 50.0f;
        float f27 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d11 = f26;
        float fCos = ((float) Math.cos(d11)) * fLog;
        float fSin = fLog * ((float) Math.sin(d11));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f27;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    public static a e(float f10, float f11, float f12) {
        return f(f10, f11, f12, m.f8470k);
    }

    public static a f(float f10, float f11, float f12, m mVar) {
        double d10 = ((double) f10) / 100.0d;
        float fB = (4.0f / mVar.b()) * ((float) Math.sqrt(d10)) * (mVar.a() + 4.0f) * mVar.d();
        float fD = f11 * mVar.d();
        float fSqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(d10))) * mVar.b()) / (mVar.a() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d11 = (3.1415927f * f12) / 180.0f;
        return new a(f12, f11, f10, fB, fD, fSqrt, f13, fLog * ((float) Math.cos(d11)), fLog * ((float) Math.sin(d11)));
    }

    public static int m(float f10, float f11, float f12) {
        return n(f10, f11, f12, m.f8470k);
    }

    public static int n(float f10, float f11, float f12, m mVar) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return b.a(f12);
        }
        float fMin = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
        a aVar = null;
        boolean z10 = true;
        float f13 = 0.0f;
        float f14 = f11;
        while (Math.abs(f13 - f11) >= 0.4f) {
            a aVarB = b(fMin, f14, f12);
            if (!z10) {
                if (aVarB == null) {
                    f11 = f14;
                } else {
                    f13 = f14;
                    aVar = aVarB;
                }
                f14 = ((f11 - f13) / 2.0f) + f13;
            } else {
                if (aVarB != null) {
                    return aVarB.o(mVar);
                }
                f14 = ((f11 - f13) / 2.0f) + f13;
                z10 = false;
            }
        }
        return aVar == null ? b.a(f12) : aVar.o(mVar);
    }

    public float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f8432h;
    }

    public float h() {
        return this.f8433i;
    }

    public float i() {
        return this.f8426b;
    }

    public float j() {
        return this.f8425a;
    }

    public float k() {
        return this.f8427c;
    }

    public float l() {
        return this.f8431g;
    }

    public int o(m mVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, mVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = mVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) mVar.b())) / ((double) mVar.j())));
        float fG = fCos * 3846.1538f * mVar.g() * mVar.h();
        float f10 = fA / mVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f11 = (((0.305f + f10) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f12 = fCos2 * f11;
        float f13 = f11 * fSin;
        float f14 = f10 * 460.0f;
        float f15 = (((451.0f * f12) + f14) + (288.0f * f13)) / 1403.0f;
        float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
        float f17 = ((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f;
        float fSignum = Math.signum(f15) * (100.0f / mVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f16) * (100.0f / mVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f17) * (100.0f / mVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17)))), 2.380952380952381d));
        float f18 = fSignum / mVar.i()[0];
        float f19 = fSignum2 / mVar.i()[1];
        float f20 = fSignum3 / mVar.i()[2];
        float[][] fArr = b.f8435b;
        float[] fArr2 = fArr[0];
        float f21 = (fArr2[0] * f18) + (fArr2[1] * f19) + (fArr2[2] * f20);
        float[] fArr3 = fArr[1];
        float f22 = (fArr3[0] * f18) + (fArr3[1] * f19) + (fArr3[2] * f20);
        float[] fArr4 = fArr[2];
        return h0.a.b(f21, f22, (f18 * fArr4[0]) + (f19 * fArr4[1]) + (f20 * fArr4[2]));
    }

    public int p() {
        return o(m.f8470k);
    }
}
