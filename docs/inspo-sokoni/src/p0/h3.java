package p0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13984a;

    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f13985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k0 f13986b;

        public a(Window window, k0 k0Var) {
            this.f13985a = window;
            this.f13986b = k0Var;
        }

        @Override // p0.h3.e
        public void c(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    f(i11);
                }
            }
        }

        public void d(int i10) {
            View decorView = this.f13985a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void e(int i10) {
            this.f13985a.addFlags(i10);
        }

        public final void f(int i10) {
            if (i10 == 1) {
                g(4);
                h(1024);
            } else if (i10 == 2) {
                g(2);
            } else {
                if (i10 != 8) {
                    return;
                }
                this.f13986b.a();
            }
        }

        public void g(int i10) {
            View decorView = this.f13985a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public void h(int i10) {
            this.f13985a.clearFlags(i10);
        }
    }

    public static class b extends a {
        public b(Window window, k0 k0Var) {
            super(window, k0Var);
        }

        @Override // p0.h3.e
        public void b(boolean z10) {
            if (!z10) {
                g(8192);
                return;
            }
            h(67108864);
            e(Integer.MIN_VALUE);
            d(8192);
        }
    }

    public static class c extends b {
        public c(Window window, k0 k0Var) {
            super(window, k0Var);
        }

        @Override // p0.h3.e
        public void a(boolean z10) {
            if (!z10) {
                g(16);
                return;
            }
            h(134217728);
            e(Integer.MIN_VALUE);
            d(16);
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h3 f13987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f13988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0 f13989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final t.g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f13990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f13991e;

        public d(Window window, h3 h3Var, k0 k0Var) {
            this(window.getInsetsController(), h3Var, k0Var);
            this.f13991e = window;
        }

        public d(WindowInsetsController windowInsetsController, h3 h3Var, k0 k0Var) {
            this.f13990d = new t.g<>();
            this.f13988b = windowInsetsController;
            this.f13987a = h3Var;
            this.f13989c = k0Var;
        }

        @Override // p0.h3.e
        public void a(boolean z10) {
            if (z10) {
                if (this.f13991e != null) {
                    d(16);
                }
                this.f13988b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f13991e != null) {
                    e(16);
                }
                this.f13988b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // p0.h3.e
        public void b(boolean z10) {
            if (z10) {
                if (this.f13991e != null) {
                    d(8192);
                }
                this.f13988b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f13991e != null) {
                    e(8192);
                }
                this.f13988b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // p0.h3.e
        public void c(int i10) {
            if ((i10 & 8) != 0) {
                this.f13989c.a();
            }
            this.f13988b.show(i10 & (-9));
        }

        public void d(int i10) {
            View decorView = this.f13991e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void e(int i10) {
            View decorView = this.f13991e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }
    }

    public static class e {
        public void a(boolean z10) {
            throw null;
        }

        public void b(boolean z10) {
            throw null;
        }

        public void c(int i10) {
            throw null;
        }
    }

    public h3(Window window, View view) {
        k0 k0Var = new k0(view);
        this.f13984a = Build.VERSION.SDK_INT >= 30 ? new d(window, this, k0Var) : new c(window, k0Var);
    }

    @Deprecated
    public h3(WindowInsetsController windowInsetsController) {
        this.f13984a = new d(windowInsetsController, this, new k0(windowInsetsController));
    }

    @Deprecated
    public static h3 d(WindowInsetsController windowInsetsController) {
        return new h3(windowInsetsController);
    }

    public void a(boolean z10) {
        this.f13984a.a(z10);
    }

    public void b(boolean z10) {
        this.f13984a.b(z10);
    }

    public void c(int i10) {
        this.f13984a.c(i10);
    }
}
