package a6;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f383a;

    public a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f383a = sideSheetBehavior;
    }

    @Override // a6.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // a6.d
    public float b(int i10) {
        float fD = d();
        return (i10 - fD) / (c() - fD);
    }

    @Override // a6.d
    public int c() {
        return Math.max(0, this.f383a.f0() + this.f383a.d0());
    }

    @Override // a6.d
    public int d() {
        return (-this.f383a.Y()) - this.f383a.d0();
    }

    @Override // a6.d
    public int e() {
        return this.f383a.d0();
    }

    @Override // a6.d
    public int f() {
        return -this.f383a.Y();
    }

    @Override // a6.d
    public <V extends View> int g(V v10) {
        return v10.getRight() + this.f383a.d0();
    }

    @Override // a6.d
    public int h(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // a6.d
    public int i() {
        return 1;
    }

    @Override // a6.d
    public boolean j(float f10) {
        return f10 > 0.0f;
    }

    @Override // a6.d
    public boolean k(View view) {
        return view.getRight() < (c() - d()) / 2;
    }

    @Override // a6.d
    public boolean l(float f10, float f11) {
        return e.a(f10, f11) && Math.abs(f10) > ((float) this.f383a.h0());
    }

    @Override // a6.d
    public boolean m(View view, float f10) {
        return Math.abs(((float) view.getLeft()) + (f10 * this.f383a.b0())) > this.f383a.c0();
    }

    @Override // a6.d
    public void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f383a.g0()) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
