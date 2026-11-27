package b5;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import p0.k2;
import p0.p0;
import p0.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends c<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f2857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f2858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2860g;

    public b() {
        this.f2857d = new Rect();
        this.f2858e = new Rect();
        this.f2859f = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2857d = new Rect();
        this.f2858e = new Rect();
        this.f2859f = 0;
    }

    public static int N(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    @Override // b5.c
    public void F(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int bottom;
        View viewH = H(coordinatorLayout.r(view));
        if (viewH != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f2857d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            k2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && p0.y(coordinatorLayout) && !p0.y(view)) {
                rect.left += lastWindowInsets.i();
                rect.right -= lastWindowInsets.j();
            }
            Rect rect2 = this.f2858e;
            r.a(N(fVar.f1645c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            int I = I(viewH);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            bottom = rect2.top - viewH.getBottom();
        } else {
            super.F(coordinatorLayout, view, i10);
            bottom = 0;
        }
        this.f2859f = bottom;
    }

    public abstract View H(List<View> list);

    public final int I(View view) {
        if (this.f2860g == 0) {
            return 0;
        }
        float fJ = J(view);
        int i10 = this.f2860g;
        return k0.a.b((int) (fJ * i10), 0, i10);
    }

    public float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f2860g;
    }

    public int L(View view) {
        return view.getMeasuredHeight();
    }

    public final int M() {
        return this.f2859f;
    }

    public final void O(int i10) {
        this.f2860g = i10;
    }

    public boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        View viewH;
        k2 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (viewH = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (p0.y(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.k() + lastWindowInsets.h();
        }
        int iL = size + L(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iL -= measuredHeight;
        }
        coordinatorLayout.J(view, i10, i11, View.MeasureSpec.makeMeasureSpec(iL, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }
}
