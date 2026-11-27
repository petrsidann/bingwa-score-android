package m;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import h.j;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12789a;

    public a(Context context) {
        this.f12789a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f12789a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f12789a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f12789a.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600) {
            return 5;
        }
        if (i10 > 960 && i11 > 720) {
            return 5;
        }
        if (i10 > 720 && i11 > 960) {
            return 5;
        }
        if (i10 >= 500) {
            return 4;
        }
        if (i10 > 640 && i11 > 480) {
            return 4;
        }
        if (i10 <= 480 || i11 <= 640) {
            return i10 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f12789a.getResources().getDimensionPixelSize(h.d.f9322b);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f12789a.obtainStyledAttributes(null, j.f9418a, h.a.f9288c, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(j.f9463j, 0);
        Resources resources = this.f12789a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(h.d.f9321a));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f12789a.getResources().getBoolean(h.b.f9312a);
    }

    public boolean h() {
        return true;
    }
}
