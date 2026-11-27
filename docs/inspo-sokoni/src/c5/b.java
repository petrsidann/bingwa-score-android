package c5;

import z5.f;
import z5.m;

/* JADX INFO: loaded from: classes.dex */
public class b extends f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3407f;

    @Override // z5.f
    public void b(float f10, float f11, float f12, m mVar) {
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21 = this.f3404c;
        if (f21 == 0.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f22 = ((this.f3403b * 2.0f) + f21) / 2.0f;
        float f23 = f12 * this.f3402a;
        float f24 = f11 + this.f3406e;
        float f25 = (this.f3405d * f12) + ((1.0f - f12) * f22);
        if (f25 / f22 >= 1.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f26 = this.f3407f;
        float f27 = f26 * f12;
        boolean z10 = f26 == -1.0f || Math.abs((f26 * 2.0f) - f21) < 0.1f;
        if (z10) {
            f13 = f25;
            f14 = 0.0f;
        } else {
            f14 = 1.75f;
            f13 = 0.0f;
        }
        float f28 = f22 + f23;
        float f29 = f13 + f23;
        float fSqrt = (float) Math.sqrt((f28 * f28) - (f29 * f29));
        float f30 = f24 - fSqrt;
        float f31 = f24 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f29));
        float f32 = (90.0f - degrees) + f14;
        mVar.m(f30, 0.0f);
        float f33 = f23 * 2.0f;
        mVar.a(f30 - f23, 0.0f, f30 + f23, f33, 270.0f, degrees);
        if (z10) {
            f16 = f24 - f22;
            f17 = (-f22) - f13;
            f15 = f24 + f22;
            f18 = f22 - f13;
            f19 = 180.0f - f32;
            f20 = (f32 * 2.0f) - 180.0f;
        } else {
            float f34 = this.f3403b;
            float f35 = f27 * 2.0f;
            float f36 = f24 - f22;
            mVar.a(f36, -(f27 + f34), f36 + f34 + f35, f34 + f27, 180.0f - f32, ((f32 * 2.0f) - 180.0f) / 2.0f);
            f15 = f24 + f22;
            float f37 = this.f3403b;
            mVar.m(f15 - ((f37 / 2.0f) + f27), f37 + f27);
            float f38 = this.f3403b;
            f16 = f15 - (f35 + f38);
            f17 = -(f27 + f38);
            f18 = f38 + f27;
            f19 = 90.0f;
            f20 = f32 - 90.0f;
        }
        mVar.a(f16, f17, f15, f18, f19, f20);
        mVar.a(f31 - f23, 0.0f, f31 + f23, f33, 270.0f - degrees, degrees);
        mVar.m(f10, 0.0f);
    }

    public float c() {
        return this.f3405d;
    }

    public float d() {
        return this.f3407f;
    }

    public float f() {
        return this.f3403b;
    }

    public float g() {
        return this.f3402a;
    }

    public float h() {
        return this.f3404c;
    }

    public void i(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f3405d = f10;
    }

    public void j(float f10) {
        this.f3407f = f10;
    }

    public void l(float f10) {
        this.f3403b = f10;
    }

    public void m(float f10) {
        this.f3402a = f10;
    }

    public void n(float f10) {
        this.f3404c = f10;
    }

    public void o(float f10) {
        this.f3406e = f10;
    }
}
