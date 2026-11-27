package f2;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class k0 extends i0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f8091g = true;

    @Override // f2.m0
    public void f(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i10);
        } else if (f8091g) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f8091g = false;
            }
        }
    }
}
