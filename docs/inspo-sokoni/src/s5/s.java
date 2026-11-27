package s5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import p0.f0;
import p0.h3;
import p0.k2;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class s {

    public class a implements f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f15552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f15553b;

        public a(c cVar, d dVar) {
            this.f15552a = cVar;
            this.f15553b = dVar;
        }

        @Override // p0.f0
        public k2 a(View view, k2 k2Var) {
            return this.f15552a.a(view, k2Var, new d(this.f15553b));
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            p0.m0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface c {
        k2 a(View view, k2 k2Var, d dVar);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15557d;

        public d(int i10, int i11, int i12, int i13) {
            this.f15554a = i10;
            this.f15555b = i11;
            this.f15556c = i12;
            this.f15557d = i13;
        }

        public d(d dVar) {
            this.f15554a = dVar.f15554a;
            this.f15555b = dVar.f15555b;
            this.f15556c = dVar.f15556c;
            this.f15557d = dVar.f15557d;
        }
    }

    public static void b(View view, c cVar) {
        p0.D0(view, new a(cVar, new d(p0.G(view), view.getPaddingTop(), p0.F(view), view.getPaddingBottom())));
        j(view);
    }

    public static float c(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static Integer d(View view) {
        ColorStateList colorStateListF = o5.c.f(view.getBackground());
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    public static InputMethodManager e(View view) {
        return (InputMethodManager) f0.a.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static float f(View view) {
        float fW = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fW += p0.w((View) parent);
        }
        return fW;
    }

    public static boolean g(View view) {
        return p0.B(view) == 1;
    }

    public static PorterDuff.Mode i(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void j(View view) {
        if (p0.S(view)) {
            p0.m0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void k(final View view, final boolean z10) {
        view.requestFocus();
        view.post(new Runnable() { // from class: s5.r
            @Override // java.lang.Runnable
            public final void run() {
                s.l(view, z10);
            }
        });
    }

    public static void l(View view, boolean z10) {
        h3 h3VarK;
        if (!z10 || (h3VarK = p0.K(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            h3VarK.c(k2.m.c());
        }
    }
}
