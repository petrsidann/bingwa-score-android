package i1;

import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f10134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f10135b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f10136a;

        public final h0.k a() {
            return null;
        }

        public final boolean b() {
            return this.f10136a;
        }
    }

    public b0(h0 fragmentManager) {
        kotlin.jvm.internal.k.e(fragmentManager, "fragmentManager");
        this.f10134a = fragmentManager;
        this.f10135b = new CopyOnWriteArrayList<>();
    }

    public final void a(p f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().a(f10, bundle, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void b(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        this.f10134a.v0().o();
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().b(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void c(p f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().c(f10, bundle, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void d(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().d(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void e(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().e(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void f(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().f(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void g(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        this.f10134a.v0().o();
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().g(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void h(p f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().h(f10, bundle, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void i(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().i(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void j(p f10, Bundle outState, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        kotlin.jvm.internal.k.e(outState, "outState");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().j(f10, outState, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void k(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().k(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void l(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().l(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void m(p f10, View v10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        kotlin.jvm.internal.k.e(v10, "v");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().m(f10, v10, bundle, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }

    public final void n(p f10, boolean z10) {
        kotlin.jvm.internal.k.e(f10, "f");
        p pVarY0 = this.f10134a.y0();
        if (pVarY0 != null) {
            h0 h0VarH = pVarY0.H();
            kotlin.jvm.internal.k.d(h0VarH, "parent.getParentFragmentManager()");
            h0VarH.x0().n(f10, true);
        }
        for (a aVar : this.f10135b) {
            if (!z10 || aVar.b()) {
                aVar.a();
                throw null;
            }
        }
    }
}
