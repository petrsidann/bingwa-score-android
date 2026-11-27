package p5;

import android.content.Context;
import android.graphics.Color;
import w5.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14140f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14145e;

    public a(Context context) {
        this(b.b(context, z4.b.f19816p, false), m5.a.b(context, z4.b.f19815o, 0), m5.a.b(context, z4.b.f19814n, 0), m5.a.b(context, z4.b.f19812l, 0), context.getResources().getDisplayMetrics().density);
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f14141a = z10;
        this.f14142b = i10;
        this.f14143c = i11;
        this.f14144d = i12;
        this.f14145e = f10;
    }

    public float a(float f10) {
        float f11 = this.f14145e;
        if (f11 <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / f11)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float fA = a(f10);
        int iAlpha = Color.alpha(i10);
        int iJ = m5.a.j(h0.a.k(i10, 255), this.f14142b, fA);
        if (fA > 0.0f && (i11 = this.f14143c) != 0) {
            iJ = m5.a.i(iJ, h0.a.k(i11, f14140f));
        }
        return h0.a.k(iJ, iAlpha);
    }

    public int c(int i10, float f10) {
        return (this.f14141a && e(i10)) ? b(i10, f10) : i10;
    }

    public boolean d() {
        return this.f14141a;
    }

    public final boolean e(int i10) {
        return h0.a.k(i10, 255) == this.f14144d;
    }
}
