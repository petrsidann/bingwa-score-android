package i1;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e0.m1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class p implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.k, androidx.lifecycle.j0, androidx.lifecycle.f, b2.f {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final Object f10317i0 = new Object();
    public z<?> A;
    public p C;
    public int D;
    public int E;
    public String F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean M;
    public ViewGroup N;
    public View O;
    public boolean P;
    public g R;
    public Handler S;
    public boolean U;
    public LayoutInflater V;
    public boolean W;
    public String X;
    public androidx.lifecycle.l Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public t0 f10319a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f10320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SparseArray<Parcelable> f10322c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public androidx.lifecycle.g0.b f10323c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f10324d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public b2.e f10325d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f10326e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f10327e0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bundle f10332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f10333m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10335o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10337q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10338r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10339s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10340t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10341u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10342v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10343w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10344x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10345y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h0 f10346z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10318a = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10328f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10334n = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f10336p = null;
    public h0 B = new i0();
    public boolean L = true;
    public boolean Q = true;
    public Runnable T = new a();
    public androidx.lifecycle.g.b Y = androidx.lifecycle.g.b.RESUMED;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public androidx.lifecycle.q<androidx.lifecycle.k> f10321b0 = new androidx.lifecycle.q<>();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final AtomicInteger f10329f0 = new AtomicInteger();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final ArrayList<i> f10330g0 = new ArrayList<>();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final i f10331h0 = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.D1();
        }
    }

    public class b extends i {
        public b() {
            super(null);
        }

        @Override // i1.p.i
        public void a() {
            p.this.f10325d0.c();
            androidx.lifecycle.b0.a(p.this);
            Bundle bundle = p.this.f10320b;
            p.this.f10325d0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f(false);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f10350a;

        public d(x0 x0Var) {
            this.f10350a = x0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10350a.w()) {
                this.f10350a.n();
            }
        }
    }

    public class e extends w {
        public e() {
        }

        @Override // i1.w
        public View j(int i10) {
            View view = p.this.O;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + p.this + " does not have a view");
        }

        @Override // i1.w
        public boolean l() {
            return p.this.O != null;
        }
    }

    public class f implements androidx.lifecycle.i {
        public f() {
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k kVar, androidx.lifecycle.g.a aVar) {
            View view;
            if (aVar != androidx.lifecycle.g.a.ON_STOP || (view = p.this.O) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f10354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10359f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10360g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList<String> f10361h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList<String> f10362i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f10363j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f10364k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f10365l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f10366m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f10367n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f10368o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f10369p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f10370q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public m1 f10371r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public m1 f10372s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f10373t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public View f10374u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f10375v;

        public g() {
            Object obj = p.f10317i0;
            this.f10364k = obj;
            this.f10365l = null;
            this.f10366m = obj;
            this.f10367n = null;
            this.f10368o = obj;
            this.f10371r = null;
            this.f10372s = null;
            this.f10373t = 1.0f;
            this.f10374u = null;
        }
    }

    public static class h extends RuntimeException {
        public h(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class i {
        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }

        public abstract void a();
    }

    public p() {
        X();
    }

    @Deprecated
    public static p Z(Context context, String str, Bundle bundle) {
        try {
            p pVarNewInstance = y.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(pVarNewInstance.getClass().getClassLoader());
                pVarNewInstance.w1(bundle);
            }
            return pVarNewInstance;
        } catch (IllegalAccessException e10) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (InstantiationException e11) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        this.f10319a0.e(this.f10324d);
        this.f10324d = null;
    }

    public m1 A() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10372s;
    }

    @Deprecated
    public void A0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.M = true;
    }

    public void A1(float f10) {
        k().f10373t = f10;
    }

    public View B() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10374u;
    }

    public void B0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.M = true;
        z<?> zVar = this.A;
        Activity activityN = zVar == null ? null : zVar.n();
        if (activityN != null) {
            this.M = false;
            A0(activityN, attributeSet, bundle);
        }
    }

    public void B1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        k();
        g gVar = this.R;
        gVar.f10361h = arrayList;
        gVar.f10362i = arrayList2;
    }

    public final Object C() {
        z<?> zVar = this.A;
        if (zVar == null) {
            return null;
        }
        return zVar.y();
    }

    public void C0(boolean z10) {
    }

    @Deprecated
    public void C1(Intent intent, int i10, Bundle bundle) {
        if (this.A != null) {
            H().V0(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater D(Bundle bundle) {
        z<?> zVar = this.A;
        if (zVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterZ = zVar.z();
        p0.t.a(layoutInflaterZ, this.B.w0());
        return layoutInflaterZ;
    }

    @Deprecated
    public boolean D0(MenuItem menuItem) {
        return false;
    }

    public void D1() {
        if (this.R == null || !k().f10375v) {
            return;
        }
        if (this.A == null) {
            k().f10375v = false;
        } else if (Looper.myLooper() != this.A.w().getLooper()) {
            this.A.w().postAtFrontOfQueue(new c());
        } else {
            f(true);
        }
    }

    public final int E() {
        androidx.lifecycle.g.b bVar = this.Y;
        return (bVar == androidx.lifecycle.g.b.INITIALIZED || this.C == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.C.E());
    }

    @Deprecated
    public void E0(Menu menu) {
    }

    public int F() {
        g gVar = this.R;
        if (gVar == null) {
            return 0;
        }
        return gVar.f10360g;
    }

    public void F0() {
        this.M = true;
    }

    public final p G() {
        return this.C;
    }

    public void G0(boolean z10) {
    }

    public final h0 H() {
        h0 h0Var = this.f10346z;
        if (h0Var != null) {
            return h0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    public void H0(Menu menu) {
    }

    public boolean I() {
        g gVar = this.R;
        if (gVar == null) {
            return false;
        }
        return gVar.f10355b;
    }

    public void I0(boolean z10) {
    }

    public int J() {
        g gVar = this.R;
        if (gVar == null) {
            return 0;
        }
        return gVar.f10358e;
    }

    @Deprecated
    public void J0(int i10, String[] strArr, int[] iArr) {
    }

    public int K() {
        g gVar = this.R;
        if (gVar == null) {
            return 0;
        }
        return gVar.f10359f;
    }

    public void K0() {
        this.M = true;
    }

    public float L() {
        g gVar = this.R;
        if (gVar == null) {
            return 1.0f;
        }
        return gVar.f10373t;
    }

    public void L0(Bundle bundle) {
    }

    public Object M() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f10366m;
        return obj == f10317i0 ? z() : obj;
    }

    public void M0() {
        this.M = true;
    }

    public final Resources N() {
        return q1().getResources();
    }

    public void N0() {
        this.M = true;
    }

    public Object O() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f10364k;
        return obj == f10317i0 ? w() : obj;
    }

    public void O0(View view, Bundle bundle) {
    }

    public Object P() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10367n;
    }

    public void P0(Bundle bundle) {
        this.M = true;
    }

    public Object Q() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f10368o;
        return obj == f10317i0 ? P() : obj;
    }

    public void Q0(Bundle bundle) {
        this.B.X0();
        this.f10318a = 3;
        this.M = false;
        j0(bundle);
        if (this.M) {
            t1();
            this.B.x();
        } else {
            throw new z0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public ArrayList<String> R() {
        ArrayList<String> arrayList;
        g gVar = this.R;
        return (gVar == null || (arrayList = gVar.f10361h) == null) ? new ArrayList<>() : arrayList;
    }

    public void R0() {
        Iterator<i> it = this.f10330g0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f10330g0.clear();
        this.B.l(this.A, g(), this);
        this.f10318a = 0;
        this.M = false;
        m0(this.A.o());
        if (this.M) {
            this.f10346z.H(this);
            this.B.y();
        } else {
            throw new z0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public ArrayList<String> S() {
        ArrayList<String> arrayList;
        g gVar = this.R;
        return (gVar == null || (arrayList = gVar.f10362i) == null) ? new ArrayList<>() : arrayList;
    }

    public void S0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public final String T(int i10) {
        return N().getString(i10);
    }

    public boolean T0(MenuItem menuItem) {
        if (this.G) {
            return false;
        }
        if (o0(menuItem)) {
            return true;
        }
        return this.B.A(menuItem);
    }

    public final p U(boolean z10) {
        String str;
        if (z10) {
            j1.c.h(this);
        }
        p pVar = this.f10333m;
        if (pVar != null) {
            return pVar;
        }
        h0 h0Var = this.f10346z;
        if (h0Var == null || (str = this.f10334n) == null) {
            return null;
        }
        return h0Var.f0(str);
    }

    public void U0(Bundle bundle) {
        this.B.X0();
        this.f10318a = 1;
        this.M = false;
        this.Z.a(new f());
        p0(bundle);
        this.W = true;
        if (this.M) {
            this.Z.h(androidx.lifecycle.g.a.ON_CREATE);
            return;
        }
        throw new z0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public View V() {
        return this.O;
    }

    public boolean V0(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.G) {
            return false;
        }
        if (this.K && this.L) {
            s0(menu, menuInflater);
            z10 = true;
        }
        return z10 | this.B.C(menu, menuInflater);
    }

    public androidx.lifecycle.o<androidx.lifecycle.k> W() {
        return this.f10321b0;
    }

    public void W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.B.X0();
        this.f10344x = true;
        this.f10319a0 = new t0(this, m(), new Runnable() { // from class: i1.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f10312a.h0();
            }
        });
        View viewT0 = t0(layoutInflater, viewGroup, bundle);
        this.O = viewT0;
        if (viewT0 == null) {
            if (this.f10319a0.d()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f10319a0 = null;
            return;
        }
        this.f10319a0.c();
        if (h0.I0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.O + " for Fragment " + this);
        }
        androidx.lifecycle.k0.a(this.O, this.f10319a0);
        androidx.lifecycle.l0.a(this.O, this.f10319a0);
        b2.g.a(this.O, this.f10319a0);
        this.f10321b0.n(this.f10319a0);
    }

    public final void X() {
        this.Z = new androidx.lifecycle.l(this);
        this.f10325d0 = b2.e.a(this);
        this.f10323c0 = null;
        if (this.f10330g0.contains(this.f10331h0)) {
            return;
        }
        o1(this.f10331h0);
    }

    public void X0() {
        this.B.D();
        this.Z.h(androidx.lifecycle.g.a.ON_DESTROY);
        this.f10318a = 0;
        this.M = false;
        this.W = false;
        u0();
        if (this.M) {
            return;
        }
        throw new z0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void Y() {
        X();
        this.X = this.f10328f;
        this.f10328f = UUID.randomUUID().toString();
        this.f10337q = false;
        this.f10338r = false;
        this.f10341u = false;
        this.f10342v = false;
        this.f10343w = false;
        this.f10345y = 0;
        this.f10346z = null;
        this.B = new i0();
        this.A = null;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = false;
        this.H = false;
    }

    public void Y0() {
        this.B.E();
        if (this.O != null && this.f10319a0.a().b().h(androidx.lifecycle.g.b.CREATED)) {
            this.f10319a0.b(androidx.lifecycle.g.a.ON_DESTROY);
        }
        this.f10318a = 1;
        this.M = false;
        w0();
        if (this.M) {
            o1.a.b(this).d();
            this.f10344x = false;
        } else {
            throw new z0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void Z0() {
        this.f10318a = -1;
        this.M = false;
        x0();
        this.V = null;
        if (this.M) {
            if (this.B.H0()) {
                return;
            }
            this.B.D();
            this.B = new i0();
            return;
        }
        throw new z0("Fragment " + this + " did not call through to super.onDetach()");
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g a() {
        return this.Z;
    }

    public final boolean a0() {
        return this.A != null && this.f10337q;
    }

    public LayoutInflater a1(Bundle bundle) {
        LayoutInflater layoutInflaterY0 = y0(bundle);
        this.V = layoutInflaterY0;
        return layoutInflaterY0;
    }

    public final boolean b0() {
        h0 h0Var;
        return this.G || ((h0Var = this.f10346z) != null && h0Var.L0(this.C));
    }

    public void b1() {
        onLowMemory();
    }

    public final boolean c0() {
        return this.f10345y > 0;
    }

    public void c1(boolean z10) {
        C0(z10);
    }

    public final boolean d0() {
        h0 h0Var;
        return this.L && ((h0Var = this.f10346z) == null || h0Var.M0(this.C));
    }

    public boolean d1(MenuItem menuItem) {
        if (this.G) {
            return false;
        }
        if (this.K && this.L && D0(menuItem)) {
            return true;
        }
        return this.B.J(menuItem);
    }

    public boolean e0() {
        g gVar = this.R;
        if (gVar == null) {
            return false;
        }
        return gVar.f10375v;
    }

    public void e1(Menu menu) {
        if (this.G) {
            return;
        }
        if (this.K && this.L) {
            E0(menu);
        }
        this.B.K(menu);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(boolean z10) {
        ViewGroup viewGroup;
        h0 h0Var;
        g gVar = this.R;
        if (gVar != null) {
            gVar.f10375v = false;
        }
        if (this.O == null || (viewGroup = this.N) == null || (h0Var = this.f10346z) == null) {
            return;
        }
        x0 x0VarU = x0.u(viewGroup, h0Var);
        x0VarU.x();
        if (z10) {
            this.A.w().post(new d(x0VarU));
        } else {
            x0VarU.n();
        }
        Handler handler = this.S;
        if (handler != null) {
            handler.removeCallbacks(this.T);
            this.S = null;
        }
    }

    public final boolean f0() {
        return this.f10338r;
    }

    public void f1() {
        this.B.M();
        if (this.O != null) {
            this.f10319a0.b(androidx.lifecycle.g.a.ON_PAUSE);
        }
        this.Z.h(androidx.lifecycle.g.a.ON_PAUSE);
        this.f10318a = 6;
        this.M = false;
        F0();
        if (this.M) {
            return;
        }
        throw new z0("Fragment " + this + " did not call through to super.onPause()");
    }

    public w g() {
        return new e();
    }

    public final boolean g0() {
        h0 h0Var = this.f10346z;
        if (h0Var == null) {
            return false;
        }
        return h0Var.P0();
    }

    public void g1(boolean z10) {
        G0(z10);
    }

    public boolean h1(Menu menu) {
        boolean z10 = false;
        if (this.G) {
            return false;
        }
        if (this.K && this.L) {
            H0(menu);
            z10 = true;
        }
        return z10 | this.B.O(menu);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.E));
        printWriter.print(" mTag=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f10318a);
        printWriter.print(" mWho=");
        printWriter.print(this.f10328f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f10345y);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f10337q);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f10338r);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f10341u);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f10342v);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.G);
        printWriter.print(" mDetached=");
        printWriter.print(this.H);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.L);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.K);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.I);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.Q);
        if (this.f10346z != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f10346z);
        }
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.A);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.C);
        }
        if (this.f10332l != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f10332l);
        }
        if (this.f10320b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f10320b);
        }
        if (this.f10322c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f10322c);
        }
        if (this.f10324d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f10324d);
        }
        p pVarU = U(false);
        if (pVarU != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(pVarU);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f10335o);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(I());
        if (u() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(u());
        }
        if (y() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(y());
        }
        if (J() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(J());
        }
        if (K() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(K());
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.N);
        }
        if (this.O != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.O);
        }
        if (q() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(q());
        }
        if (t() != null) {
            o1.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.B + ":");
        this.B.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void i0() {
        this.B.X0();
    }

    public void i1() {
        boolean zN0 = this.f10346z.N0(this);
        Boolean bool = this.f10336p;
        if (bool == null || bool.booleanValue() != zN0) {
            this.f10336p = Boolean.valueOf(zN0);
            I0(zN0);
            this.B.P();
        }
    }

    @Override // androidx.lifecycle.f
    public n1.a j() {
        Application application;
        Context applicationContext = q1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && h0.I0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + q1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        n1.b bVar = new n1.b();
        if (application != null) {
            bVar.b(androidx.lifecycle.g0.a.f2182e, application);
        }
        bVar.b(androidx.lifecycle.b0.f2153a, this);
        bVar.b(androidx.lifecycle.b0.f2154b, this);
        if (r() != null) {
            bVar.b(androidx.lifecycle.b0.f2155c, r());
        }
        return bVar;
    }

    @Deprecated
    public void j0(Bundle bundle) {
        this.M = true;
    }

    public void j1() {
        this.B.X0();
        this.B.a0(true);
        this.f10318a = 7;
        this.M = false;
        K0();
        if (!this.M) {
            throw new z0("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.l lVar = this.Z;
        androidx.lifecycle.g.a aVar = androidx.lifecycle.g.a.ON_RESUME;
        lVar.h(aVar);
        if (this.O != null) {
            this.f10319a0.b(aVar);
        }
        this.B.Q();
    }

    public final g k() {
        if (this.R == null) {
            this.R = new g();
        }
        return this.R;
    }

    @Deprecated
    public void k0(int i10, int i11, Intent intent) {
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    public void k1(Bundle bundle) {
        L0(bundle);
    }

    public p l(String str) {
        return str.equals(this.f10328f) ? this : this.B.j0(str);
    }

    @Deprecated
    public void l0(Activity activity) {
        this.M = true;
    }

    public void l1() {
        this.B.X0();
        this.B.a0(true);
        this.f10318a = 5;
        this.M = false;
        M0();
        if (!this.M) {
            throw new z0("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.l lVar = this.Z;
        androidx.lifecycle.g.a aVar = androidx.lifecycle.g.a.ON_START;
        lVar.h(aVar);
        if (this.O != null) {
            this.f10319a0.b(aVar);
        }
        this.B.R();
    }

    @Override // androidx.lifecycle.j0
    public androidx.lifecycle.i0 m() {
        if (this.f10346z == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (E() != androidx.lifecycle.g.b.INITIALIZED.ordinal()) {
            return this.f10346z.D0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public void m0(Context context) {
        this.M = true;
        z<?> zVar = this.A;
        Activity activityN = zVar == null ? null : zVar.n();
        if (activityN != null) {
            this.M = false;
            l0(activityN);
        }
    }

    public void m1() {
        this.B.T();
        if (this.O != null) {
            this.f10319a0.b(androidx.lifecycle.g.a.ON_STOP);
        }
        this.Z.h(androidx.lifecycle.g.a.ON_STOP);
        this.f10318a = 4;
        this.M = false;
        N0();
        if (this.M) {
            return;
        }
        throw new z0("Fragment " + this + " did not call through to super.onStop()");
    }

    public final u n() {
        z<?> zVar = this.A;
        if (zVar == null) {
            return null;
        }
        return (u) zVar.n();
    }

    @Deprecated
    public void n0(p pVar) {
    }

    public void n1() {
        Bundle bundle = this.f10320b;
        O0(this.O, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.B.U();
    }

    public boolean o() {
        Boolean bool;
        g gVar = this.R;
        if (gVar == null || (bool = gVar.f10370q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean o0(MenuItem menuItem) {
        return false;
    }

    public final void o1(i iVar) {
        if (this.f10318a >= 0) {
            iVar.a();
        } else {
            this.f10330g0.add(iVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.M = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        p1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.M = true;
    }

    public boolean p() {
        Boolean bool;
        g gVar = this.R;
        if (gVar == null || (bool = gVar.f10369p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void p0(Bundle bundle) {
        this.M = true;
        s1();
        if (this.B.O0(1)) {
            return;
        }
        this.B.B();
    }

    public final u p1() {
        u uVarN = n();
        if (uVarN != null) {
            return uVarN;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public View q() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10354a;
    }

    public Animation q0(int i10, boolean z10, int i11) {
        return null;
    }

    public final Context q1() {
        Context contextT = t();
        if (contextT != null) {
            return contextT;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final Bundle r() {
        return this.f10332l;
    }

    public Animator r0(int i10, boolean z10, int i11) {
        return null;
    }

    public final View r1() {
        View viewV = V();
        if (viewV != null) {
            return viewV;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final h0 s() {
        if (this.A != null) {
            return this.B;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Deprecated
    public void s0(Menu menu, MenuInflater menuInflater) {
    }

    public void s1() {
        Bundle bundle;
        Bundle bundle2 = this.f10320b;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.B.k1(bundle);
        this.B.B();
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        C1(intent, i10, null);
    }

    public Context t() {
        z<?> zVar = this.A;
        if (zVar == null) {
            return null;
        }
        return zVar.o();
    }

    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10 = this.f10327e0;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    public final void t1() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.O != null) {
            Bundle bundle = this.f10320b;
            u1(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.f10320b = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.f10328f);
        if (this.D != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.D));
        }
        if (this.F != null) {
            sb2.append(" tag=");
            sb2.append(this.F);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public int u() {
        g gVar = this.R;
        if (gVar == null) {
            return 0;
        }
        return gVar.f10356c;
    }

    public void u0() {
        this.M = true;
    }

    public final void u1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f10322c;
        if (sparseArray != null) {
            this.O.restoreHierarchyState(sparseArray);
            this.f10322c = null;
        }
        this.M = false;
        P0(bundle);
        if (this.M) {
            if (this.O != null) {
                this.f10319a0.b(androidx.lifecycle.g.a.ON_CREATE);
            }
        } else {
            throw new z0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    @Override // b2.f
    public final b2.d v() {
        return this.f10325d0.b();
    }

    @Deprecated
    public void v0() {
    }

    public void v1(int i10, int i11, int i12, int i13) {
        if (this.R == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        k().f10356c = i10;
        k().f10357d = i11;
        k().f10358e = i12;
        k().f10359f = i13;
    }

    public Object w() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10363j;
    }

    public void w0() {
        this.M = true;
    }

    public void w1(Bundle bundle) {
        if (this.f10346z != null && g0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f10332l = bundle;
    }

    public m1 x() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10371r;
    }

    public void x0() {
        this.M = true;
    }

    public void x1(View view) {
        k().f10374u = view;
    }

    public int y() {
        g gVar = this.R;
        if (gVar == null) {
            return 0;
        }
        return gVar.f10357d;
    }

    public LayoutInflater y0(Bundle bundle) {
        return D(bundle);
    }

    public void y1(int i10) {
        if (this.R == null && i10 == 0) {
            return;
        }
        k();
        this.R.f10360g = i10;
    }

    public Object z() {
        g gVar = this.R;
        if (gVar == null) {
            return null;
        }
        return gVar.f10365l;
    }

    public void z0(boolean z10) {
    }

    public void z1(boolean z10) {
        if (this.R == null) {
            return;
        }
        k().f10355b = z10;
    }
}
