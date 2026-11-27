package f2;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f8083d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f8084e = true;

    @Override // f2.m0
    public void g(View view, Matrix matrix) {
        if (f8083d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f8083d = false;
            }
        }
    }

    @Override // f2.m0
    public void h(View view, Matrix matrix) {
        if (f8084e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f8084e = false;
            }
        }
    }
}
