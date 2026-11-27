package s5;

import android.view.View;
import android.view.ViewGroup;
import p0.p0;
import p0.u;

/* JADX INFO: loaded from: classes.dex */
public class g extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15511d;

    public static int a(int i10, int i11, int i12) {
        if (i11 != Integer.MIN_VALUE) {
            return i11 != 1073741824 ? i12 : i10;
        }
        return Math.min(i12, i10);
    }

    public int b(View view) {
        Object tag = view.getTag(z4.f.G);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f15510c;
    }

    public int getItemSpacing() {
        return this.f15509b;
    }

    public int getLineSpacing() {
        return this.f15508a;
    }

    public int getRowCount() {
        return this.f15511d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iA;
        int iB;
        if (getChildCount() == 0) {
            this.f15511d = 0;
            return;
        }
        this.f15511d = 1;
        boolean z11 = p0.B(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = (i12 - i10) - paddingLeft;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(z4.f.G, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iB = u.b(marginLayoutParams);
                    iA = u.a(marginLayoutParams);
                } else {
                    iA = 0;
                    iB = 0;
                }
                int measuredWidth2 = measuredWidth + iB + childAt.getMeasuredWidth();
                if (!this.f15510c && measuredWidth2 > i14) {
                    i15 = this.f15508a + paddingTop;
                    this.f15511d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(z4.f.G, Integer.valueOf(this.f15511d - 1));
                int i17 = measuredWidth + iB;
                int measuredWidth3 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z11) {
                    i17 = i14 - measuredWidth3;
                    measuredWidth3 = (i14 - measuredWidth) - iB;
                }
                childAt.layout(i17, i15, measuredWidth3, measuredHeight);
                measuredWidth += iB + iA + childAt.getMeasuredWidth() + this.f15509b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (paddingLeft2 + i12 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f15508a + paddingTop;
                }
                int measuredWidth = paddingLeft + i12 + childAt.getMeasuredWidth();
                int measuredHeight = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i12 + i13 + childAt.getMeasuredWidth() + this.f15509b;
                if (i17 == getChildCount() - 1) {
                    i16 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i16 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i10) {
        this.f15509b = i10;
    }

    public void setLineSpacing(int i10) {
        this.f15508a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f15510c = z10;
    }
}
