package f2;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8161a = true;

    public static v a(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    public static void b(ViewGroup viewGroup, boolean z10) {
        if (f8161a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f8161a = false;
            }
        }
    }

    public static void c(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else {
            b(viewGroup, z10);
        }
    }
}
