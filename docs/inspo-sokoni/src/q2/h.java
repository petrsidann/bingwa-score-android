package q2;

import android.graphics.Point;
import android.view.Display;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14628a = new h();

    public final void a(Display display, Point point) {
        k.e(display, "display");
        k.e(point, "point");
        display.getRealSize(point);
    }
}
