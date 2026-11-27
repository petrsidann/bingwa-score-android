package s5;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import p0.z1;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Window window, boolean z10, Integer num, Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int iB = m5.a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(iB);
            }
            if (z12) {
                num2 = Integer.valueOf(iB);
            }
        }
        z1.b(window, !z10);
        int iC = c(window.getContext(), z10);
        int iB2 = b(window.getContext(), z10);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, m5.a.h(num.intValue())));
        e(window, d(iB2, m5.a.h(num2.intValue())));
    }

    public static int b(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 27) {
            return h0.a.k(m5.a.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return m5.a.b(context, R.attr.navigationBarColor, -16777216);
    }

    public static int c(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return m5.a.b(context, R.attr.statusBarColor, -16777216);
    }

    public static boolean d(int i10, boolean z10) {
        return m5.a.h(i10) || (i10 == 0 && z10);
    }

    public static void e(Window window, boolean z10) {
        z1.a(window, window.getDecorView()).a(z10);
    }

    public static void f(Window window, boolean z10) {
        z1.a(window, window.getDecorView()).b(z10);
    }
}
