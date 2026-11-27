package s;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f15398a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) f10) + ((1.0d - f15398a) * ((double) f11))) : f10;
    }

    public static float b(float f10, float f11, boolean z10) {
        float f12 = f10 * 1.5f;
        return z10 ? (float) (((double) f12) + ((1.0d - f15398a) * ((double) f11))) : f12;
    }
}
