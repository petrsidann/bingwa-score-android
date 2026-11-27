package d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.b0;
import androidx.lifecycle.g0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.x;
import e0.g1;
import e0.p0;
import e0.q0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import p0.v;
import p0.w;
import p0.y;

/* JADX INFO: loaded from: classes.dex */
public class h extends e0.k implements j0, androidx.lifecycle.f, b2.f, r, f.e, f0.f, f0.g, p0, q0, v, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f6113c = new e.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f6114d = new w(new Runnable() { // from class: d.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f6109a.I();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.lifecycle.l f6115e = new androidx.lifecycle.l(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b2.e f6116f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i0 f6117l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f6118m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f6119n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m f6120o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6121p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f6122q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f.d f6123r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList<o0.a<Configuration>> f6124s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CopyOnWriteArrayList<o0.a<Integer>> f6125t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList<o0.a<Intent>> f6126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList<o0.a<e0.n>> f6127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList<o0.a<g1>> f6128w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6129x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6130y;

    public class a extends f.d {

        /* JADX INFO: renamed from: d.h$a$a, reason: collision with other inner class name */
        public class RunnableC0107a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6132a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g.a.C0146a f6133b;

            public RunnableC0107a(int i10, g.a.C0146a c0146a) {
                this.f6132a = i10;
                this.f6133b = c0146a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f6132a, this.f6133b.a());
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6135a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f6136b;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f6135a = i10;
                this.f6136b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f6135a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f6136b));
            }
        }

        public a() {
        }

        @Override // f.d
        public <I, O> void f(int i10, g.a<I, O> aVar, I i11, e0.d dVar) {
            Bundle bundle;
            h hVar = h.this;
            g.a.C0146a<O> c0146aB = aVar.b(hVar, i11);
            if (c0146aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0107a(i10, c0146aB));
                return;
            }
            Intent intentA = aVar.a(hVar, i11);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(hVar.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                e0.b.e(hVar, stringArrayExtra, i10);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                e0.b.g(hVar, intentA, i10, bundle);
                return;
            }
            f.f fVar = (f.f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                e0.b.h(hVar, fVar.d(), i10, fVar.a(), fVar.b(), fVar.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new b(i10, e10));
            }
        }
    }

    public class b implements androidx.lifecycle.i {
        public b() {
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k kVar, androidx.lifecycle.g.a aVar) {
            if (aVar == androidx.lifecycle.g.a.ON_STOP) {
                Window window = h.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    public class c implements androidx.lifecycle.i {
        public c() {
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k kVar, androidx.lifecycle.g.a aVar) {
            if (aVar == androidx.lifecycle.g.a.ON_DESTROY) {
                h.this.f6113c.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.m().a();
                }
                h.this.f6119n.d();
            }
        }
    }

    public class d implements androidx.lifecycle.i {
        public d() {
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k kVar, androidx.lifecycle.g.a aVar) {
            h.this.G();
            h.this.a().c(this);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }
    }

    public class f implements androidx.lifecycle.i {
        public f() {
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k kVar, androidx.lifecycle.g.a aVar) {
            if (aVar != androidx.lifecycle.g.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            h.this.f6118m.n(C0108h.a((h) kVar));
        }
    }

    public static class g {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: d.h$h, reason: collision with other inner class name */
    public static class C0108h {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i0 f6144b;
    }

    public interface j extends Executor {
        void D(View view);

        void d();
    }

    public class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f6146b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f6145a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6147c = false;

        public k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f6146b;
            if (runnable != null) {
                runnable.run();
                this.f6146b = null;
            }
        }

        @Override // d.h.j
        public void D(View view) {
            if (this.f6147c) {
                return;
            }
            this.f6147c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // d.h.j
        public void d() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f6146b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f6147c) {
                decorView.postOnAnimation(new Runnable() { // from class: d.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6149a.b();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f6146b;
            if (runnable != null) {
                runnable.run();
                this.f6146b = null;
                if (!h.this.f6120o.c()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f6145a) {
                return;
            }
            this.f6147c = false;
            h.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public h() {
        b2.e eVarA = b2.e.a(this);
        this.f6116f = eVarA;
        this.f6118m = null;
        j jVarF = F();
        this.f6119n = jVarF;
        this.f6120o = new m(jVarF, new xc.a() { // from class: d.e
            @Override // xc.a
            public final Object invoke() {
                return this.f6110a.J();
            }
        });
        this.f6122q = new AtomicInteger();
        this.f6123r = new a();
        this.f6124s = new CopyOnWriteArrayList<>();
        this.f6125t = new CopyOnWriteArrayList<>();
        this.f6126u = new CopyOnWriteArrayList<>();
        this.f6127v = new CopyOnWriteArrayList<>();
        this.f6128w = new CopyOnWriteArrayList<>();
        this.f6129x = false;
        this.f6130y = false;
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        a().a(new b());
        a().a(new c());
        a().a(new d());
        eVarA.c();
        b0.a(this);
        v().h("android:support:activity-result", new b2.d.c() { // from class: d.f
            @Override // b2.d.c
            public final Bundle a() {
                return this.f6111a.K();
            }
        });
        D(new e.b() { // from class: d.g
            @Override // e.b
            public final void a(Context context) {
                this.f6112a.L(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ lc.q J() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle K() {
        Bundle bundle = new Bundle();
        this.f6123r.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Context context) {
        Bundle bundleB = v().b("android:support:activity-result");
        if (bundleB != null) {
            this.f6123r.g(bundleB);
        }
    }

    public final void D(e.b bVar) {
        this.f6113c.a(bVar);
    }

    public final void E(o0.a<Intent> aVar) {
        this.f6126u.add(aVar);
    }

    public final j F() {
        return new k();
    }

    public void G() {
        if (this.f6117l == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.f6117l = iVar.f6144b;
            }
            if (this.f6117l == null) {
                this.f6117l = new i0();
            }
        }
    }

    public void H() {
        k0.a(getWindow().getDecorView(), this);
        l0.a(getWindow().getDecorView(), this);
        b2.g.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    public void I() {
        invalidateOptionsMenu();
    }

    @Deprecated
    public Object M() {
        return null;
    }

    @Override // e0.k, androidx.lifecycle.k
    public androidx.lifecycle.g a() {
        return this.f6115e;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        H();
        this.f6119n.D(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // e0.q0
    public final void c(o0.a<g1> aVar) {
        this.f6128w.remove(aVar);
    }

    @Override // f0.f
    public final void d(o0.a<Configuration> aVar) {
        this.f6124s.add(aVar);
    }

    @Override // e0.p0
    public final void e(o0.a<e0.n> aVar) {
        this.f6127v.add(aVar);
    }

    @Override // e0.p0
    public final void g(o0.a<e0.n> aVar) {
        this.f6127v.remove(aVar);
    }

    @Override // d.r
    public final p h() {
        if (this.f6118m == null) {
            this.f6118m = new p(new e());
            a().a(new f());
        }
        return this.f6118m;
    }

    @Override // f0.f
    public final void i(o0.a<Configuration> aVar) {
        this.f6124s.remove(aVar);
    }

    @Override // androidx.lifecycle.f
    public n1.a j() {
        n1.b bVar = new n1.b();
        if (getApplication() != null) {
            bVar.b(g0.a.f2182e, getApplication());
        }
        bVar.b(b0.f2153a, this);
        bVar.b(b0.f2154b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.b(b0.f2155c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // f.e
    public final f.d k() {
        return this.f6123r;
    }

    @Override // androidx.lifecycle.j0
    public i0 m() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        G();
        return this.f6117l;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f6123r.b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        h().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<o0.a<Configuration>> it = this.f6124s.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // e0.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f6116f.d(bundle);
        this.f6113c.c(this);
        super.onCreate(bundle);
        x.e(this);
        int i10 = this.f6121p;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f6114d.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f6114d.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.f6129x) {
            return;
        }
        Iterator<o0.a<e0.n>> it = this.f6127v.iterator();
        while (it.hasNext()) {
            it.next().accept(new e0.n(z10));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.f6129x = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.f6129x = false;
            Iterator<o0.a<e0.n>> it = this.f6127v.iterator();
            while (it.hasNext()) {
                it.next().accept(new e0.n(z10, configuration));
            }
        } catch (Throwable th) {
            this.f6129x = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<o0.a<Intent>> it = this.f6126u.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f6114d.c(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.f6130y) {
            return;
        }
        Iterator<o0.a<g1>> it = this.f6128w.iterator();
        while (it.hasNext()) {
            it.next().accept(new g1(z10));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.f6130y = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.f6130y = false;
            Iterator<o0.a<g1>> it = this.f6128w.iterator();
            while (it.hasNext()) {
                it.next().accept(new g1(z10, configuration));
            }
        } catch (Throwable th) {
            this.f6130y = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f6114d.e(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f6123r.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objM = M();
        i0 i0Var = this.f6117l;
        if (i0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            i0Var = iVar.f6144b;
        }
        if (i0Var == null && objM == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f6143a = objM;
        iVar2.f6144b = i0Var;
        return iVar2;
    }

    @Override // e0.k, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.g gVarA = a();
        if (gVarA instanceof androidx.lifecycle.l) {
            ((androidx.lifecycle.l) gVarA).n(androidx.lifecycle.g.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f6116f.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<o0.a<Integer>> it = this.f6125t.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    @Override // p0.v
    public void p(y yVar) {
        this.f6114d.f(yVar);
    }

    @Override // p0.v
    public void r(y yVar) {
        this.f6114d.a(yVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (e2.a.h()) {
                e2.a.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f6120o.b();
        } finally {
            e2.a.f();
        }
    }

    @Override // f0.g
    public final void s(o0.a<Integer> aVar) {
        this.f6125t.add(aVar);
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        H();
        this.f6119n.D(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        H();
        this.f6119n.D(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        H();
        this.f6119n.D(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // f0.g
    public final void t(o0.a<Integer> aVar) {
        this.f6125t.remove(aVar);
    }

    @Override // e0.q0
    public final void u(o0.a<g1> aVar) {
        this.f6128w.add(aVar);
    }

    @Override // b2.f
    public final b2.d v() {
        return this.f6116f.b();
    }
}
