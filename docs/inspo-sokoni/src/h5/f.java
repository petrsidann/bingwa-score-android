package h5;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = iArr[i10] * 2;
        }
        return iArr2;
    }

    public static float b(float f10, float f11, float f12) {
        return 1.0f - ((f10 - f12) / (f11 - f12));
    }

    public boolean c() {
        return true;
    }

    public abstract com.google.android.material.carousel.b d(b bVar, View view);

    public abstract boolean e(b bVar, int i10);
}
