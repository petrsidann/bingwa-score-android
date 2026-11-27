package q2;

import android.view.DisplayCutout;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f14629a = new i();

    public final int a(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
