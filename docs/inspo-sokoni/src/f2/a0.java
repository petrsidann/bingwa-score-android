package f2;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f8035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f8036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property<View, Rect> f8037c;

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(a0.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            a0.g(view, f10.floatValue());
        }
    }

    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return p0.p0.u(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            p0.p0.w0(view, rect);
        }
    }

    static {
        f8035a = Build.VERSION.SDK_INT >= 29 ? new l0() : new k0();
        f8036b = new a(Float.class, "translationAlpha");
        f8037c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f8035a.a(view);
    }

    public static z b(View view) {
        return new y(view);
    }

    public static float c(View view) {
        return f8035a.b(view);
    }

    public static p0 d(View view) {
        return new o0(view);
    }

    public static void e(View view) {
        f8035a.c(view);
    }

    public static void f(View view, int i10, int i11, int i12, int i13) {
        f8035a.d(view, i10, i11, i12, i13);
    }

    public static void g(View view, float f10) {
        f8035a.e(view, f10);
    }

    public static void h(View view, int i10) {
        f8035a.f(view, i10);
    }

    public static void i(View view, Matrix matrix) {
        f8035a.g(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f8035a.h(view, matrix);
    }
}
