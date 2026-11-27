package s;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f15380f = {R.attr.colorBackground};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f15381l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f15386e;

    static {
        b bVar = new b();
        f15381l = bVar;
        bVar.i();
    }

    public ColorStateList getCardBackgroundColor() {
        return f15381l.k(null);
    }

    public float getCardElevation() {
        return f15381l.h(null);
    }

    public int getContentPaddingBottom() {
        return this.f15386e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f15386e.left;
    }

    public int getContentPaddingRight() {
        return this.f15386e.right;
    }

    public int getContentPaddingTop() {
        return this.f15386e.top;
    }

    public float getMaxCardElevation() {
        return f15381l.e(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.f15383b;
    }

    public float getRadius() {
        return f15381l.b(null);
    }

    public boolean getUseCompatPadding() {
        return this.f15382a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        d dVar = f15381l;
        if (!(dVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(dVar.c(null)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(dVar.g(null)), View.MeasureSpec.getSize(i11)), mode2);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f15381l.m(null, ColorStateList.valueOf(i10));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f15381l.m(null, colorStateList);
    }

    public void setCardElevation(float f10) {
        f15381l.a(null, f10);
    }

    public void setMaxCardElevation(float f10) {
        f15381l.l(null, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f15385d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f15384c = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f15383b) {
            this.f15383b = z10;
            f15381l.f(null);
        }
    }

    public void setRadius(float f10) {
        f15381l.j(null, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f15382a != z10) {
            this.f15382a = z10;
            f15381l.d(null);
        }
    }
}
