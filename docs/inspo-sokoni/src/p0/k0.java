package p0;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13996a;

    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f13997a;

        public a(View view) {
            this.f13997a = view;
        }

        public static /* synthetic */ void c(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // p0.k0.c
        public void a() {
            final View viewFindViewById = this.f13997a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f13997a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: p0.j0
                @Override // java.lang.Runnable
                public final void run() {
                    k0.a.c(viewFindViewById);
                }
            });
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f13998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsetsController f13999c;

        public b(View view) {
            super(view);
            this.f13998b = view;
        }

        public b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f13999c = windowInsetsController;
        }

        @Override // p0.k0.a, p0.k0.c
        public void a() {
            View view = this.f13998b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f13999c;
            if (windowInsetsController == null) {
                View view2 = this.f13998b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.a();
            }
        }
    }

    public static class c {
        public void a() {
            throw null;
        }
    }

    public k0(View view) {
        this.f13996a = Build.VERSION.SDK_INT >= 30 ? new b(view) : new a(view);
    }

    @Deprecated
    public k0(WindowInsetsController windowInsetsController) {
        this.f13996a = new b(windowInsetsController);
    }

    public void a() {
        this.f13996a.a();
    }
}
