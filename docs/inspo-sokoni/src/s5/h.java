package s5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.p0;

/* JADX INFO: loaded from: classes.dex */
public class h extends p0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f15512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f15513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f15514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f15517z;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15513v = new Rect();
        this.f15514w = new Rect();
        this.f15515x = 119;
        this.f15516y = true;
        this.f15517z = false;
        TypedArray typedArrayI = p.i(context, attributeSet, z4.k.f20171z1, i10, 0, new int[0]);
        this.f15515x = typedArrayI.getInt(z4.k.B1, this.f15515x);
        Drawable drawable = typedArrayI.getDrawable(z4.k.A1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f15516y = typedArrayI.getBoolean(z4.k.C1, true);
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f15512u;
        if (drawable != null) {
            if (this.f15517z) {
                this.f15517z = false;
                Rect rect = this.f15513v;
                Rect rect2 = this.f15514w;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f15516y) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f15515x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f15512u;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f15512u;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f15512u.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f15512u;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f15515x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f15512u;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.p0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f15517z = z10 | this.f15517z;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f15517z = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f15512u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f15512u);
            }
            this.f15512u = drawable;
            this.f15517z = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f15515x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f15515x != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f15515x = i10;
            if (i10 == 119 && this.f15512u != null) {
                this.f15512u.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f15512u;
    }
}
