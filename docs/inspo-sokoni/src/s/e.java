package s;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f15388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f15389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f15390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f15391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f15394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f15395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f15396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f15397k;

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f15394h;
    }

    public float c() {
        return this.f15391e;
    }

    public float d() {
        return this.f15387a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f15388b;
        if (this.f15395i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f15395i);
            z10 = true;
        }
        RectF rectF = this.f15389c;
        float f10 = this.f15387a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f15394h = colorStateList;
        this.f15388b.setColor(colorStateList.getColorForState(getState(), this.f15394h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f15391e && this.f15392f == z10 && this.f15393g == z11) {
            return;
        }
        this.f15391e = f10;
        this.f15392f = z10;
        this.f15393g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f15390d, this.f15387a);
    }

    public void h(float f10) {
        if (f10 == this.f15387a) {
            return;
        }
        this.f15387a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f15389c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f15390d.set(rect);
        if (this.f15392f) {
            this.f15390d.inset((int) Math.ceil(f.a(this.f15391e, this.f15387a, this.f15393g)), (int) Math.ceil(f.b(this.f15391e, this.f15387a, this.f15393g)));
            this.f15389c.set(this.f15390d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f15396j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f15394h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f15394h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f15388b.getColor();
        if (z10) {
            this.f15388b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f15396j;
        if (colorStateList2 == null || (mode = this.f15397k) == null) {
            return z10;
        }
        this.f15395i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f15388b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15388b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f15396j = colorStateList;
        this.f15395i = a(colorStateList, this.f15397k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f15397k = mode;
        this.f15395i = a(this.f15396j, mode);
        invalidateSelf();
    }
}
