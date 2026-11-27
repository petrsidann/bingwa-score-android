package i1;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentContainerView;

/* JADX INFO: loaded from: classes.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f10304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f10305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f10306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10307d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10308e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10309a;

        public a(View view) {
            this.f10309a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f10309a.removeOnAttachStateChangeListener(this);
            p0.p0.m0(this.f10309a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10311a;

        static {
            int[] iArr = new int[androidx.lifecycle.g.b.values().length];
            f10311a = iArr;
            try {
                iArr[androidx.lifecycle.g.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10311a[androidx.lifecycle.g.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10311a[androidx.lifecycle.g.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10311a[androidx.lifecycle.g.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public n0(b0 b0Var, o0 o0Var, p pVar) {
        this.f10304a = b0Var;
        this.f10305b = o0Var;
        this.f10306c = pVar;
    }

    public n0(b0 b0Var, o0 o0Var, p pVar, Bundle bundle) {
        this.f10304a = b0Var;
        this.f10305b = o0Var;
        this.f10306c = pVar;
        pVar.f10322c = null;
        pVar.f10324d = null;
        pVar.f10345y = 0;
        pVar.f10342v = false;
        pVar.f10337q = false;
        p pVar2 = pVar.f10333m;
        pVar.f10334n = pVar2 != null ? pVar2.f10328f : null;
        pVar.f10333m = null;
        pVar.f10320b = bundle;
        pVar.f10332l = bundle.getBundle("arguments");
    }

    public n0(b0 b0Var, o0 o0Var, ClassLoader classLoader, y yVar, Bundle bundle) {
        this.f10304a = b0Var;
        this.f10305b = o0Var;
        p pVarA = ((m0) bundle.getParcelable("state")).a(yVar, classLoader);
        this.f10306c = pVarA;
        pVarA.f10320b = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        pVarA.w1(bundle2);
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + pVarA);
        }
    }

    public void a() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f10306c);
        }
        Bundle bundle = this.f10306c.f10320b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f10306c.Q0(bundle2);
        this.f10304a.a(this.f10306c, bundle2, false);
    }

    public void b() {
        p pVarL0 = h0.l0(this.f10306c.N);
        p pVarG = this.f10306c.G();
        if (pVarL0 != null && !pVarL0.equals(pVarG)) {
            p pVar = this.f10306c;
            j1.c.j(pVar, pVarL0, pVar.E);
        }
        int iJ = this.f10305b.j(this.f10306c);
        p pVar2 = this.f10306c;
        pVar2.N.addView(pVar2.O, iJ);
    }

    public void c() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f10306c);
        }
        p pVar = this.f10306c;
        p pVar2 = pVar.f10333m;
        n0 n0VarN = null;
        if (pVar2 != null) {
            n0 n0VarN2 = this.f10305b.n(pVar2.f10328f);
            if (n0VarN2 == null) {
                throw new IllegalStateException("Fragment " + this.f10306c + " declared target fragment " + this.f10306c.f10333m + " that does not belong to this FragmentManager!");
            }
            p pVar3 = this.f10306c;
            pVar3.f10334n = pVar3.f10333m.f10328f;
            pVar3.f10333m = null;
            n0VarN = n0VarN2;
        } else {
            String str = pVar.f10334n;
            if (str != null && (n0VarN = this.f10305b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f10306c + " declared target fragment " + this.f10306c.f10334n + " that does not belong to this FragmentManager!");
            }
        }
        if (n0VarN != null) {
            n0VarN.m();
        }
        p pVar4 = this.f10306c;
        pVar4.A = pVar4.f10346z.v0();
        p pVar5 = this.f10306c;
        pVar5.C = pVar5.f10346z.y0();
        this.f10304a.g(this.f10306c, false);
        this.f10306c.R0();
        this.f10304a.b(this.f10306c, false);
    }

    public int d() {
        p pVar = this.f10306c;
        if (pVar.f10346z == null) {
            return pVar.f10318a;
        }
        int iMin = this.f10308e;
        int i10 = b.f10311a[pVar.Y.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i10 != 3) {
                iMin = i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        p pVar2 = this.f10306c;
        if (pVar2.f10341u) {
            if (pVar2.f10342v) {
                iMin = Math.max(this.f10308e, 2);
                View view = this.f10306c.O;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f10308e < 4 ? Math.min(iMin, pVar2.f10318a) : Math.min(iMin, 1);
            }
        }
        if (!this.f10306c.f10337q) {
            iMin = Math.min(iMin, 1);
        }
        p pVar3 = this.f10306c;
        ViewGroup viewGroup = pVar3.N;
        x0.d.a aVarS = viewGroup != null ? x0.u(viewGroup, pVar3.H()).s(this) : null;
        if (aVarS == x0.d.a.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aVarS == x0.d.a.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            p pVar4 = this.f10306c;
            if (pVar4.f10338r) {
                iMin = pVar4.c0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        p pVar5 = this.f10306c;
        if (pVar5.P && pVar5.f10318a < 5) {
            iMin = Math.min(iMin, 4);
        }
        p pVar6 = this.f10306c;
        if (pVar6.f10339s && pVar6.N != null) {
            iMin = Math.max(iMin, 3);
        }
        if (h0.I0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f10306c);
        }
        return iMin;
    }

    public void e() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f10306c);
        }
        Bundle bundle = this.f10306c.f10320b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        p pVar = this.f10306c;
        if (pVar.W) {
            pVar.f10318a = 1;
            pVar.s1();
        } else {
            this.f10304a.h(pVar, bundle2, false);
            this.f10306c.U0(bundle2);
            this.f10304a.c(this.f10306c, bundle2, false);
        }
    }

    public void f() {
        String resourceName;
        if (this.f10306c.f10341u) {
            return;
        }
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10306c);
        }
        Bundle bundle = this.f10306c.f10320b;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterA1 = this.f10306c.a1(bundle2);
        p pVar = this.f10306c;
        ViewGroup viewGroup2 = pVar.N;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = pVar.E;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f10306c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) pVar.f10346z.r0().j(this.f10306c.E);
                if (viewGroup == null) {
                    p pVar2 = this.f10306c;
                    if (!pVar2.f10343w) {
                        try {
                            resourceName = pVar2.N().getResourceName(this.f10306c.E);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f10306c.E) + " (" + resourceName + ") for fragment " + this.f10306c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    j1.c.i(this.f10306c, viewGroup);
                }
            }
        }
        p pVar3 = this.f10306c;
        pVar3.N = viewGroup;
        pVar3.W0(layoutInflaterA1, viewGroup, bundle2);
        if (this.f10306c.O != null) {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f10306c);
            }
            this.f10306c.O.setSaveFromParentEnabled(false);
            p pVar4 = this.f10306c;
            pVar4.O.setTag(h1.b.f9582a, pVar4);
            if (viewGroup != null) {
                b();
            }
            p pVar5 = this.f10306c;
            if (pVar5.G) {
                pVar5.O.setVisibility(8);
            }
            if (this.f10306c.O.isAttachedToWindow()) {
                p0.p0.m0(this.f10306c.O);
            } else {
                View view = this.f10306c.O;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f10306c.n1();
            b0 b0Var = this.f10304a;
            p pVar6 = this.f10306c;
            b0Var.m(pVar6, pVar6.O, bundle2, false);
            int visibility = this.f10306c.O.getVisibility();
            this.f10306c.A1(this.f10306c.O.getAlpha());
            p pVar7 = this.f10306c;
            if (pVar7.N != null && visibility == 0) {
                View viewFindFocus = pVar7.O.findFocus();
                if (viewFindFocus != null) {
                    this.f10306c.x1(viewFindFocus);
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f10306c);
                    }
                }
                this.f10306c.O.setAlpha(0.0f);
            }
        }
        this.f10306c.f10318a = 2;
    }

    public void g() {
        p pVarF;
        if (h0.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f10306c);
        }
        p pVar = this.f10306c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = pVar.f10338r && !pVar.c0();
        if (z10) {
            p pVar2 = this.f10306c;
            if (!pVar2.f10340t) {
                this.f10305b.B(pVar2.f10328f, null);
            }
        }
        if (!(z10 || this.f10305b.p().p(this.f10306c))) {
            String str = this.f10306c.f10334n;
            if (str != null && (pVarF = this.f10305b.f(str)) != null && pVarF.I) {
                this.f10306c.f10333m = pVarF;
            }
            this.f10306c.f10318a = 0;
            return;
        }
        z<?> zVar = this.f10306c.A;
        if (zVar instanceof androidx.lifecycle.j0) {
            zIsChangingConfigurations = this.f10305b.p().m();
        } else if (zVar.o() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) zVar.o()).isChangingConfigurations();
        }
        if ((z10 && !this.f10306c.f10340t) || zIsChangingConfigurations) {
            this.f10305b.p().e(this.f10306c, false);
        }
        this.f10306c.X0();
        this.f10304a.d(this.f10306c, false);
        for (n0 n0Var : this.f10305b.k()) {
            if (n0Var != null) {
                p pVarK = n0Var.k();
                if (this.f10306c.f10328f.equals(pVarK.f10334n)) {
                    pVarK.f10333m = this.f10306c;
                    pVarK.f10334n = null;
                }
            }
        }
        p pVar3 = this.f10306c;
        String str2 = pVar3.f10334n;
        if (str2 != null) {
            pVar3.f10333m = this.f10305b.f(str2);
        }
        this.f10305b.s(this);
    }

    public void h() {
        View view;
        if (h0.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f10306c);
        }
        p pVar = this.f10306c;
        ViewGroup viewGroup = pVar.N;
        if (viewGroup != null && (view = pVar.O) != null) {
            viewGroup.removeView(view);
        }
        this.f10306c.Y0();
        this.f10304a.n(this.f10306c, false);
        p pVar2 = this.f10306c;
        pVar2.N = null;
        pVar2.O = null;
        pVar2.f10319a0 = null;
        pVar2.f10321b0.n(null);
        this.f10306c.f10342v = false;
    }

    public void i() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f10306c);
        }
        this.f10306c.Z0();
        boolean z10 = false;
        this.f10304a.e(this.f10306c, false);
        p pVar = this.f10306c;
        pVar.f10318a = -1;
        pVar.A = null;
        pVar.C = null;
        pVar.f10346z = null;
        if (pVar.f10338r && !pVar.c0()) {
            z10 = true;
        }
        if (z10 || this.f10305b.p().p(this.f10306c)) {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f10306c);
            }
            this.f10306c.Y();
        }
    }

    public void j() {
        p pVar = this.f10306c;
        if (pVar.f10341u && pVar.f10342v && !pVar.f10344x) {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10306c);
            }
            Bundle bundle = this.f10306c.f10320b;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            p pVar2 = this.f10306c;
            pVar2.W0(pVar2.a1(bundle2), null, bundle2);
            View view = this.f10306c.O;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                p pVar3 = this.f10306c;
                pVar3.O.setTag(h1.b.f9582a, pVar3);
                p pVar4 = this.f10306c;
                if (pVar4.G) {
                    pVar4.O.setVisibility(8);
                }
                this.f10306c.n1();
                b0 b0Var = this.f10304a;
                p pVar5 = this.f10306c;
                b0Var.m(pVar5, pVar5.O, bundle2, false);
                this.f10306c.f10318a = 2;
            }
        }
    }

    public p k() {
        return this.f10306c;
    }

    public final boolean l(View view) {
        if (view == this.f10306c.O) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f10306c.O) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f10307d) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f10307d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                p pVar = this.f10306c;
                int i10 = pVar.f10318a;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && pVar.f10338r && !pVar.c0() && !this.f10306c.f10340t) {
                        if (h0.I0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f10306c);
                        }
                        this.f10305b.p().e(this.f10306c, true);
                        this.f10305b.s(this);
                        if (h0.I0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f10306c);
                        }
                        this.f10306c.Y();
                    }
                    p pVar2 = this.f10306c;
                    if (pVar2.U) {
                        if (pVar2.O != null && (viewGroup = pVar2.N) != null) {
                            x0 x0VarU = x0.u(viewGroup, pVar2.H());
                            if (this.f10306c.G) {
                                x0VarU.k(this);
                            } else {
                                x0VarU.m(this);
                            }
                        }
                        p pVar3 = this.f10306c;
                        h0 h0Var = pVar3.f10346z;
                        if (h0Var != null) {
                            h0Var.G0(pVar3);
                        }
                        p pVar4 = this.f10306c;
                        pVar4.U = false;
                        pVar4.z0(pVar4.G);
                        this.f10306c.B.I();
                    }
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (pVar.f10340t && this.f10305b.q(pVar.f10328f) == null) {
                                this.f10305b.B(this.f10306c.f10328f, q());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f10306c.f10318a = 1;
                            break;
                        case 2:
                            pVar.f10342v = false;
                            pVar.f10318a = 2;
                            break;
                        case 3:
                            if (h0.I0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f10306c);
                            }
                            p pVar5 = this.f10306c;
                            if (pVar5.f10340t) {
                                this.f10305b.B(pVar5.f10328f, q());
                            } else if (pVar5.O != null && pVar5.f10322c == null) {
                                r();
                            }
                            p pVar6 = this.f10306c;
                            if (pVar6.O != null && (viewGroup2 = pVar6.N) != null) {
                                x0.u(viewGroup2, pVar6.H()).l(this);
                            }
                            this.f10306c.f10318a = 3;
                            break;
                        case 4:
                            u();
                            break;
                        case 5:
                            pVar.f10318a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (pVar.O != null && (viewGroup3 = pVar.N) != null) {
                                x0.u(viewGroup3, pVar.H()).j(x0.d.b.i(this.f10306c.O.getVisibility()), this);
                            }
                            this.f10306c.f10318a = 4;
                            break;
                        case 5:
                            t();
                            break;
                        case 6:
                            pVar.f10318a = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } finally {
            this.f10307d = false;
        }
    }

    public void n() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f10306c);
        }
        this.f10306c.f1();
        this.f10304a.f(this.f10306c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f10306c.f10320b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f10306c.f10320b.getBundle("savedInstanceState") == null) {
            this.f10306c.f10320b.putBundle("savedInstanceState", new Bundle());
        }
        try {
            p pVar = this.f10306c;
            pVar.f10322c = pVar.f10320b.getSparseParcelableArray("viewState");
            p pVar2 = this.f10306c;
            pVar2.f10324d = pVar2.f10320b.getBundle("viewRegistryState");
            m0 m0Var = (m0) this.f10306c.f10320b.getParcelable("state");
            if (m0Var != null) {
                p pVar3 = this.f10306c;
                pVar3.f10334n = m0Var.f10279q;
                pVar3.f10335o = m0Var.f10280r;
                Boolean bool = pVar3.f10326e;
                if (bool != null) {
                    pVar3.Q = bool.booleanValue();
                    this.f10306c.f10326e = null;
                } else {
                    pVar3.Q = m0Var.f10281s;
                }
            }
            p pVar4 = this.f10306c;
            if (pVar4.Q) {
                return;
            }
            pVar4.P = true;
        } catch (BadParcelableException e10) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e10);
        }
    }

    public void p() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f10306c);
        }
        View viewB = this.f10306c.B();
        if (viewB != null && l(viewB)) {
            boolean zRequestFocus = viewB.requestFocus();
            if (h0.I0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(viewB);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f10306c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f10306c.O.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f10306c.x1(null);
        this.f10306c.j1();
        this.f10304a.i(this.f10306c, false);
        this.f10305b.B(this.f10306c.f10328f, null);
        p pVar = this.f10306c;
        pVar.f10320b = null;
        pVar.f10322c = null;
        pVar.f10324d = null;
    }

    public Bundle q() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        p pVar = this.f10306c;
        if (pVar.f10318a == -1 && (bundle = pVar.f10320b) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new m0(this.f10306c));
        if (this.f10306c.f10318a > -1) {
            Bundle bundle3 = new Bundle();
            this.f10306c.k1(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f10304a.j(this.f10306c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f10306c.f10325d0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleQ0 = this.f10306c.B.Q0();
            if (!bundleQ0.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleQ0);
            }
            if (this.f10306c.O != null) {
                r();
            }
            SparseArray<Parcelable> sparseArray = this.f10306c.f10322c;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f10306c.f10324d;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f10306c.f10332l;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void r() {
        if (this.f10306c.O == null) {
            return;
        }
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f10306c + " with view " + this.f10306c.O);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f10306c.O.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f10306c.f10322c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f10306c.f10319a0.f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f10306c.f10324d = bundle;
    }

    public void s(int i10) {
        this.f10308e = i10;
    }

    public void t() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f10306c);
        }
        this.f10306c.l1();
        this.f10304a.k(this.f10306c, false);
    }

    public void u() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f10306c);
        }
        this.f10306c.m1();
        this.f10304a.l(this.f10306c, false);
    }
}
