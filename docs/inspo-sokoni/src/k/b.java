package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f11420m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f11421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f11425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f11427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f11431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11432l;

    public static float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void b(float f10) {
        if (this.f11430j != f10) {
            this.f11430j = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i10 = this.f11432l;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? i0.a.f(this) == 0 : i0.a.f(this) == 1))) {
            z10 = true;
        }
        float f10 = this.f11422b;
        float fA = a(this.f11423c, (float) Math.sqrt(f10 * f10 * 2.0f), this.f11430j);
        float fA2 = a(this.f11423c, this.f11424d, this.f11430j);
        float fRound = Math.round(a(0.0f, this.f11431k, this.f11430j));
        float fA3 = a(0.0f, f11420m, this.f11430j);
        float fA4 = a(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f11430j);
        double d10 = fA;
        double d11 = fA3;
        boolean z11 = z10;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(d10 * Math.sin(d11));
        this.f11427g.rewind();
        float fA5 = a(this.f11425e + this.f11421a.getStrokeWidth(), -this.f11431k, this.f11430j);
        float f11 = (-fA2) / 2.0f;
        this.f11427g.moveTo(f11 + fRound, 0.0f);
        this.f11427g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f11427g.moveTo(f11, fA5);
        this.f11427g.rLineTo(fRound2, fRound3);
        this.f11427g.moveTo(f11, -fA5);
        this.f11427g.rLineTo(fRound2, -fRound3);
        this.f11427g.close();
        canvas.save();
        float strokeWidth = this.f11421a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        float f12 = this.f11425e;
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * f12))) / 4) * 2) + (strokeWidth * 1.5f) + f12);
        if (this.f11426f) {
            canvas.rotate(fA4 * (this.f11429i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f11427g, this.f11421a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11428h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11428h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f11421a.getAlpha()) {
            this.f11421a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11421a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
