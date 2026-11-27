package a6;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f384a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f384a = sideSheetBehavior;
    }

    @Override // a6.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // a6.d
    public float b(int i10) {
        float fD = d();
        return (fD - i10) / (fD - c());
    }

    @Override // a6.d
    public int c() {
        return Math.max(0, (d() - this.f384a.Y()) - this.f384a.d0());
    }

    @Override // a6.d
    public int d() {
        return this.f384a.g0();
    }

    @Override // a6.d
    public int e() {
        return this.f384a.g0();
    }

    @Override // a6.d
    public int f() {
        return c();
    }

    @Override // a6.d
    public <V extends View> int g(V v10) {
        return v10.getLeft() - this.f384a.d0();
    }

    @Override // a6.d
    public int h(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // a6.d
    public int i() {
        return 0;
    }

    @Override // a6.d
    public boolean j(float f10) {
        return f10 < 0.0f;
    }

    @Override // a6.d
    public boolean k(View view) {
        return view.getLeft() > (d() + c()) / 2;
    }

    @Override // a6.d
    public boolean l(float f10, float f11) {
        return e.a(f10, f11) && Math.abs(f10) > ((float) this.f384a.h0());
    }

    @Override // a6.d
    public boolean m(View view, float f10) {
        return Math.abs(((float) view.getRight()) + (f10 * this.f384a.b0())) > this.f384a.c0();
    }

    @Override // a6.d
    public void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int iG0 = this.f384a.g0();
        if (i10 <= iG0) {
            marginLayoutParams.rightMargin = iG0 - i10;
        }
    }
}
