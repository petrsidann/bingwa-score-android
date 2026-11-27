package s5;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f15504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f15505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f15506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15507d;

    public void a(float f10) {
        if (this.f15507d != f10) {
            this.f15507d = f10;
            f.a(f10, this.f15506c);
            this.f15504a.setAlpha((int) (this.f15506c[0] * 255.0f));
            this.f15505b.setAlpha((int) (this.f15506c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f15504a.draw(canvas);
        this.f15505b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f15504a.getIntrinsicHeight(), this.f15505b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f15504a.getIntrinsicWidth(), this.f15505b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f15504a.getMinimumHeight(), this.f15505b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f15504a.getMinimumWidth(), this.f15505b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f15504a.isStateful() || this.f15505b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f15507d <= 0.5f) {
            this.f15504a.setAlpha(i10);
            this.f15505b.setAlpha(0);
        } else {
            this.f15504a.setAlpha(0);
            this.f15505b.setAlpha(i10);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f15504a.setBounds(i10, i11, i12, i13);
        this.f15505b.setBounds(i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15504a.setColorFilter(colorFilter);
        this.f15505b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f15504a.setState(iArr) || this.f15505b.setState(iArr);
    }
}
