package f2;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l0 extends k0 {
    @Override // f2.d0, f2.m0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // f2.i0, f2.m0
    public void d(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // f2.d0, f2.m0
    public void e(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // f2.k0, f2.m0
    public void f(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // f2.g0, f2.m0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // f2.g0, f2.m0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
