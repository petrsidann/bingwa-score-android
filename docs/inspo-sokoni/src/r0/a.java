package r0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: r0.a$a, reason: collision with other inner class name */
    public static class C0264a {
        public static Interpolator a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        public static Interpolator b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        public static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f10, float f11, float f12, float f13) {
        return C0264a.b(f10, f11, f12, f13);
    }

    public static Interpolator b(Path path) {
        return C0264a.c(path);
    }
}
