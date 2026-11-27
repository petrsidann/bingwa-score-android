package f2;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class i0 extends g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f8087f = true;

    @Override // f2.m0
    public void d(View view, int i10, int i11, int i12, int i13) {
        if (f8087f) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f8087f = false;
            }
        }
    }
}
