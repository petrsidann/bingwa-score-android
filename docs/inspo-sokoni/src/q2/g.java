package q2;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import kotlin.jvm.internal.k;
import p0.k2;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14627a = new g();

    public final Rect a(Context context) {
        k.e(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        k.d(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final k2 b(Context context) {
        k.e(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        k.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        k2 k2VarU = k2.u(windowInsets);
        k.d(k2VarU, "toWindowInsetsCompat(platformInsets)");
        return k2VarU;
    }

    public final m2.k c(Context context) {
        k.e(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        k2 k2VarU = k2.u(windowManager.getCurrentWindowMetrics().getWindowInsets());
        k.d(k2VarU, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        k.d(bounds, "wm.currentWindowMetrics.bounds");
        return new m2.k(bounds, k2VarU);
    }

    public final Rect d(Context context) {
        k.e(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        k.d(bounds, "wm.maximumWindowMetrics.bounds");
        return bounds;
    }
}
