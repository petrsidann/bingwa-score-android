package f2;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class d0 extends m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f8068c = true;

    @Override // f2.m0
    public void a(View view) {
    }

    @Override // f2.m0
    public float b(View view) {
        if (f8068c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f8068c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // f2.m0
    public void c(View view) {
    }

    @Override // f2.m0
    public void e(View view, float f10) {
        if (f8068c) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f8068c = false;
            }
        }
        view.setAlpha(f10);
    }
}
