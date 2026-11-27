package i;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.z0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p0.p0;
import p0.v1;
import p0.w1;
import p0.x1;
import p0.y1;

/* JADX INFO: loaded from: classes.dex */
public class r extends i.a implements ActionBarOverlayLayout.d {
    public static final Interpolator E = new AccelerateInterpolator();
    public static final Interpolator F = new DecelerateInterpolator();
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f10080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f10081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f10082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionBarContainer f10083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k0 f10084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionBarContextView f10085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f10086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z0 f10087i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f10091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m.b f10092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m.b.a f10093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10094p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10096r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10101w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m.h f10103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10104z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Object> f10088j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10089k = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<i.a.b> f10095q = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10097s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10098t = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10102x = true;
    public final w1 B = new a();
    public final w1 C = new b();
    public final y1 D = new c();

    public class a extends x1 {
        public a() {
        }

        @Override // p0.w1
        public void b(View view) {
            View view2;
            r rVar = r.this;
            if (rVar.f10098t && (view2 = rVar.f10086h) != null) {
                view2.setTranslationY(0.0f);
                r.this.f10083e.setTranslationY(0.0f);
            }
            r.this.f10083e.setVisibility(8);
            r.this.f10083e.setTransitioning(false);
            r rVar2 = r.this;
            rVar2.f10103y = null;
            rVar2.w();
            ActionBarOverlayLayout actionBarOverlayLayout = r.this.f10082d;
            if (actionBarOverlayLayout != null) {
                p0.m0(actionBarOverlayLayout);
            }
        }
    }

    public class b extends x1 {
        public b() {
        }

        @Override // p0.w1
        public void b(View view) {
            r rVar = r.this;
            rVar.f10103y = null;
            rVar.f10083e.requestLayout();
        }
    }

    public class c implements y1 {
        public c() {
        }

        @Override // p0.y1
        public void a(View view) {
            ((View) r.this.f10083e.getParent()).invalidate();
        }
    }

    public class d extends m.b implements androidx.appcompat.view.menu.e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f10108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f10109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public m.b.a f10110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WeakReference<View> f10111f;

        public d(Context context, m.b.a aVar) {
            this.f10108c = context;
            this.f10110e = aVar;
            androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(context).S(1);
            this.f10109d = eVarS;
            eVarS.R(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            m.b.a aVar = this.f10110e;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f10110e == null) {
                return;
            }
            k();
            r.this.f10085g.l();
        }

        @Override // m.b
        public void c() {
            r rVar = r.this;
            if (rVar.f10091m != this) {
                return;
            }
            if (r.v(rVar.f10099u, rVar.f10100v, false)) {
                this.f10110e.a(this);
            } else {
                r rVar2 = r.this;
                rVar2.f10092n = this;
                rVar2.f10093o = this.f10110e;
            }
            this.f10110e = null;
            r.this.u(false);
            r.this.f10085g.g();
            r rVar3 = r.this;
            rVar3.f10082d.setHideOnContentScrollEnabled(rVar3.A);
            r.this.f10091m = null;
        }

        @Override // m.b
        public View d() {
            WeakReference<View> weakReference = this.f10111f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // m.b
        public Menu e() {
            return this.f10109d;
        }

        @Override // m.b
        public MenuInflater f() {
            return new m.g(this.f10108c);
        }

        @Override // m.b
        public CharSequence g() {
            return r.this.f10085g.getSubtitle();
        }

        @Override // m.b
        public CharSequence i() {
            return r.this.f10085g.getTitle();
        }

        @Override // m.b
        public void k() {
            if (r.this.f10091m != this) {
                return;
            }
            this.f10109d.d0();
            try {
                this.f10110e.b(this, this.f10109d);
            } finally {
                this.f10109d.c0();
            }
        }

        @Override // m.b
        public boolean l() {
            return r.this.f10085g.j();
        }

        @Override // m.b
        public void m(View view) {
            r.this.f10085g.setCustomView(view);
            this.f10111f = new WeakReference<>(view);
        }

        @Override // m.b
        public void n(int i10) {
            o(r.this.f10079a.getResources().getString(i10));
        }

        @Override // m.b
        public void o(CharSequence charSequence) {
            r.this.f10085g.setSubtitle(charSequence);
        }

        @Override // m.b
        public void q(int i10) {
            r(r.this.f10079a.getResources().getString(i10));
        }

        @Override // m.b
        public void r(CharSequence charSequence) {
            r.this.f10085g.setTitle(charSequence);
        }

        @Override // m.b
        public void s(boolean z10) {
            super.s(z10);
            r.this.f10085g.setTitleOptional(z10);
        }

        public boolean t() {
            this.f10109d.d0();
            try {
                return this.f10110e.c(this, this.f10109d);
            } finally {
                this.f10109d.c0();
            }
        }
    }

    public r(Activity activity, boolean z10) {
        this.f10081c = activity;
        View decorView = activity.getWindow().getDecorView();
        C(decorView);
        if (z10) {
            return;
        }
        this.f10086h = decorView.findViewById(R.id.content);
    }

    public r(Dialog dialog) {
        C(dialog.getWindow().getDecorView());
    }

    public static boolean v(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public int A() {
        return this.f10084f.m();
    }

    public final void B() {
        if (this.f10101w) {
            this.f10101w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f10082d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            L(false);
        }
    }

    public final void C(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(h.f.f9373p);
        this.f10082d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f10084f = z(view.findViewById(h.f.f9358a));
        this.f10085g = (ActionBarContextView) view.findViewById(h.f.f9363f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(h.f.f9360c);
        this.f10083e = actionBarContainer;
        k0 k0Var = this.f10084f;
        if (k0Var == null || this.f10085g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f10079a = k0Var.getContext();
        boolean z10 = (this.f10084f.q() & 4) != 0;
        if (z10) {
            this.f10090l = true;
        }
        m.a aVarB = m.a.b(this.f10079a);
        I(aVarB.a() || z10);
        G(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f10079a.obtainStyledAttributes(null, h.j.f9418a, h.a.f9288c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(h.j.f9468k, false)) {
            H(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.j.f9458i, 0);
        if (dimensionPixelSize != 0) {
            F(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void D(boolean z10) {
        E(z10 ? 4 : 0, 4);
    }

    public void E(int i10, int i11) {
        int iQ = this.f10084f.q();
        if ((i11 & 4) != 0) {
            this.f10090l = true;
        }
        this.f10084f.k((i10 & i11) | ((~i11) & iQ));
    }

    public void F(float f10) {
        p0.x0(this.f10083e, f10);
    }

    public final void G(boolean z10) {
        this.f10096r = z10;
        if (z10) {
            this.f10083e.setTabContainer(null);
            this.f10084f.i(this.f10087i);
        } else {
            this.f10084f.i(null);
            this.f10083e.setTabContainer(this.f10087i);
        }
        boolean z11 = A() == 2;
        z0 z0Var = this.f10087i;
        if (z0Var != null) {
            if (z11) {
                z0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f10082d;
                if (actionBarOverlayLayout != null) {
                    p0.m0(actionBarOverlayLayout);
                }
            } else {
                z0Var.setVisibility(8);
            }
        }
        this.f10084f.t(!this.f10096r && z11);
        this.f10082d.setHasNonEmbeddedTabs(!this.f10096r && z11);
    }

    public void H(boolean z10) {
        if (z10 && !this.f10082d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z10;
        this.f10082d.setHideOnContentScrollEnabled(z10);
    }

    public void I(boolean z10) {
        this.f10084f.p(z10);
    }

    public final boolean J() {
        return p0.T(this.f10083e);
    }

    public final void K() {
        if (this.f10101w) {
            return;
        }
        this.f10101w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f10082d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        L(false);
    }

    public final void L(boolean z10) {
        if (v(this.f10099u, this.f10100v, this.f10101w)) {
            if (this.f10102x) {
                return;
            }
            this.f10102x = true;
            y(z10);
            return;
        }
        if (this.f10102x) {
            this.f10102x = false;
            x(z10);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f10100v) {
            this.f10100v = false;
            L(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z10) {
        this.f10098t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.f10100v) {
            return;
        }
        this.f10100v = true;
        L(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        m.h hVar = this.f10103y;
        if (hVar != null) {
            hVar.a();
            this.f10103y = null;
        }
    }

    @Override // i.a
    public boolean g() {
        k0 k0Var = this.f10084f;
        if (k0Var == null || !k0Var.j()) {
            return false;
        }
        this.f10084f.collapseActionView();
        return true;
    }

    @Override // i.a
    public void h(boolean z10) {
        if (z10 == this.f10094p) {
            return;
        }
        this.f10094p = z10;
        int size = this.f10095q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f10095q.get(i10).onMenuVisibilityChanged(z10);
        }
    }

    @Override // i.a
    public int i() {
        return this.f10084f.q();
    }

    @Override // i.a
    public Context j() {
        if (this.f10080b == null) {
            TypedValue typedValue = new TypedValue();
            this.f10079a.getTheme().resolveAttribute(h.a.f9292g, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f10080b = new ContextThemeWrapper(this.f10079a, i10);
            } else {
                this.f10080b = this.f10079a;
            }
        }
        return this.f10080b;
    }

    @Override // i.a
    public void l(Configuration configuration) {
        G(m.a.b(this.f10079a).g());
    }

    @Override // i.a
    public boolean n(int i10, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f10091m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void onWindowVisibilityChanged(int i10) {
        this.f10097s = i10;
    }

    @Override // i.a
    public void q(boolean z10) {
        if (this.f10090l) {
            return;
        }
        D(z10);
    }

    @Override // i.a
    public void r(boolean z10) {
        m.h hVar;
        this.f10104z = z10;
        if (z10 || (hVar = this.f10103y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // i.a
    public void s(CharSequence charSequence) {
        this.f10084f.setWindowTitle(charSequence);
    }

    @Override // i.a
    public m.b t(m.b.a aVar) {
        d dVar = this.f10091m;
        if (dVar != null) {
            dVar.c();
        }
        this.f10082d.setHideOnContentScrollEnabled(false);
        this.f10085g.k();
        d dVar2 = new d(this.f10085g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f10091m = dVar2;
        dVar2.k();
        this.f10085g.h(dVar2);
        u(true);
        return dVar2;
    }

    public void u(boolean z10) {
        v1 v1VarN;
        v1 v1VarF;
        if (z10) {
            K();
        } else {
            B();
        }
        if (!J()) {
            if (z10) {
                this.f10084f.o(4);
                this.f10085g.setVisibility(0);
                return;
            } else {
                this.f10084f.o(0);
                this.f10085g.setVisibility(8);
                return;
            }
        }
        if (z10) {
            v1VarF = this.f10084f.n(4, 100L);
            v1VarN = this.f10085g.f(0, 200L);
        } else {
            v1VarN = this.f10084f.n(0, 200L);
            v1VarF = this.f10085g.f(8, 100L);
        }
        m.h hVar = new m.h();
        hVar.d(v1VarF, v1VarN);
        hVar.h();
    }

    public void w() {
        m.b.a aVar = this.f10093o;
        if (aVar != null) {
            aVar.a(this.f10092n);
            this.f10092n = null;
            this.f10093o = null;
        }
    }

    public void x(boolean z10) {
        View view;
        m.h hVar = this.f10103y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f10097s != 0 || (!this.f10104z && !z10)) {
            this.B.b(null);
            return;
        }
        this.f10083e.setAlpha(1.0f);
        this.f10083e.setTransitioning(true);
        m.h hVar2 = new m.h();
        float f10 = -this.f10083e.getHeight();
        if (z10) {
            int[] iArr = {0, 0};
            this.f10083e.getLocationInWindow(iArr);
            f10 -= iArr[1];
        }
        v1 v1VarM = p0.e(this.f10083e).m(f10);
        v1VarM.k(this.D);
        hVar2.c(v1VarM);
        if (this.f10098t && (view = this.f10086h) != null) {
            hVar2.c(p0.e(view).m(f10));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f10103y = hVar2;
        hVar2.h();
    }

    public void y(boolean z10) {
        View view;
        View view2;
        m.h hVar = this.f10103y;
        if (hVar != null) {
            hVar.a();
        }
        this.f10083e.setVisibility(0);
        if (this.f10097s == 0 && (this.f10104z || z10)) {
            this.f10083e.setTranslationY(0.0f);
            float f10 = -this.f10083e.getHeight();
            if (z10) {
                int[] iArr = {0, 0};
                this.f10083e.getLocationInWindow(iArr);
                f10 -= iArr[1];
            }
            this.f10083e.setTranslationY(f10);
            m.h hVar2 = new m.h();
            v1 v1VarM = p0.e(this.f10083e).m(0.0f);
            v1VarM.k(this.D);
            hVar2.c(v1VarM);
            if (this.f10098t && (view2 = this.f10086h) != null) {
                view2.setTranslationY(f10);
                hVar2.c(p0.e(this.f10086h).m(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f10103y = hVar2;
            hVar2.h();
        } else {
            this.f10083e.setAlpha(1.0f);
            this.f10083e.setTranslationY(0.0f);
            if (this.f10098t && (view = this.f10086h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f10082d;
        if (actionBarOverlayLayout != null) {
            p0.m0(actionBarOverlayLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k0 z(View view) {
        if (view instanceof k0) {
            return (k0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }
}
