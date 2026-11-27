package ra;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class q extends FrameLayout implements hb.a.c, z.e {
    public final io.flutter.embedding.engine.renderer.d A;
    public final o0.a<m2.j> B;
    public r C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f15257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f15258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f15259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.e f15260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.e f15261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<io.flutter.embedding.engine.renderer.d> f15262f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public io.flutter.embedding.engine.a f15264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<f> f15265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public hb.a f15266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public io.flutter.plugin.editing.f f15267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public io.flutter.plugin.editing.d f15268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public gb.a f15269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z f15270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ra.a f15271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public io.flutter.view.e f15272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextServicesManager f15273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e0 f15274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FlutterRenderer.h f15275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final io.flutter.view.e.k f15276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ContentObserver f15277z;

    public class a implements io.flutter.view.e.k {
        public a() {
        }

        @Override // io.flutter.view.e.k
        public void a(boolean z10, boolean z11) {
            q.this.z(z10, z11);
        }
    }

    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            if (q.this.f15264m == null) {
                return;
            }
            qa.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            q.this.B();
        }
    }

    public class c implements io.flutter.embedding.engine.renderer.d {
        public c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
            q.this.f15263l = false;
            Iterator it = q.this.f15262f.iterator();
            while (it.hasNext()) {
                ((io.flutter.embedding.engine.renderer.d) it.next()).c();
            }
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            q.this.f15263l = true;
            Iterator it = q.this.f15262f.iterator();
            while (it.hasNext()) {
                ((io.flutter.embedding.engine.renderer.d) it.next()).e();
            }
        }
    }

    public class d implements o0.a<m2.j> {
        public d() {
        }

        @Override // o0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(m2.j jVar) {
            q.this.setWindowInfoListenerDisplayFeatures(jVar);
        }
    }

    public class e implements io.flutter.embedding.engine.renderer.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterRenderer f15282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f15283b;

        public e(FlutterRenderer flutterRenderer, Runnable runnable) {
            this.f15282a = flutterRenderer;
            this.f15283b = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            this.f15282a.u(this);
            this.f15283b.run();
            q qVar = q.this;
            if ((qVar.f15260d instanceof j) || qVar.f15259c == null) {
                return;
            }
            q.this.f15259c.d();
            q.this.x();
        }
    }

    public interface f {
        void a();

        void b(io.flutter.embedding.engine.a aVar);
    }

    public enum g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public q(Context context, AttributeSet attributeSet, k kVar) {
        super(context, attributeSet);
        this.f15262f = new HashSet();
        this.f15265n = new HashSet();
        this.f15275x = new FlutterRenderer.h();
        this.f15276y = new a();
        this.f15277z = new b(new Handler(Looper.getMainLooper()));
        this.A = new c();
        this.B = new d();
        this.C = new r();
        this.f15257a = kVar;
        this.f15260d = kVar;
        u();
    }

    public q(Context context, AttributeSet attributeSet, l lVar) {
        super(context, attributeSet);
        this.f15262f = new HashSet();
        this.f15265n = new HashSet();
        this.f15275x = new FlutterRenderer.h();
        this.f15276y = new a();
        this.f15277z = new b(new Handler(Looper.getMainLooper()));
        this.A = new c();
        this.B = new d();
        this.C = new r();
        this.f15258b = lVar;
        this.f15260d = lVar;
        u();
    }

    public q(Context context, k kVar) {
        this(context, (AttributeSet) null, kVar);
    }

    public q(Context context, l lVar) {
        this(context, (AttributeSet) null, lVar);
    }

    public static /* synthetic */ boolean w(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    public void A(Runnable runnable) {
        if (this.f15259c == null) {
            qa.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        io.flutter.embedding.engine.renderer.e eVar = this.f15261e;
        if (eVar == null) {
            qa.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f15260d = eVar;
        this.f15261e = null;
        FlutterRenderer flutterRendererT = this.f15264m.t();
        if (this.f15264m != null && flutterRendererT != null) {
            this.f15260d.a();
            flutterRendererT.j(new e(flutterRendererT, runnable));
        } else {
            this.f15259c.d();
            x();
            runnable.run();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    public void B() {
        boolean z10;
        eb.p.c cVar = (getResources().getConfiguration().uiMode & 48) == 32 ? eb.p.c.dark : eb.p.c.light;
        TextServicesManager textServicesManager = this.f15273v;
        if (textServicesManager == null) {
            z10 = false;
        } else {
            if (Build.VERSION.SDK_INT >= 31) {
                boolean zAnyMatch = textServicesManager.getEnabledSpellCheckerInfos().stream().anyMatch(new Predicate() { // from class: ra.p
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return q.w((SpellCheckerInfo) obj);
                    }
                });
                if (!this.f15273v.isSpellCheckerEnabled() || !zAnyMatch) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        this.f15264m.w().d().f(getResources().getConfiguration().fontScale).c(getResources().getDisplayMetrics()).d(z10).b(Settings.System.getInt(getContext().getContentResolver(), "show_password", 1) == 1).g(DateFormat.is24HourFormat(getContext())).e(cVar).a();
    }

    public final void C() {
        if (!v()) {
            qa.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f15275x.f10771a = getResources().getDisplayMetrics().density;
        this.f15275x.f10786p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f15264m.t().y(this.f15275x);
    }

    @Override // hb.a.c
    public PointerIcon a(int i10) {
        return PointerIcon.getSystemIcon(getContext(), i10);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f15267p.j(sparseArray);
    }

    @Override // ra.z.e
    public void b(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // ra.z.e
    public boolean c(KeyEvent keyEvent) {
        return this.f15267p.q(keyEvent);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.f15264m;
        return aVar != null ? aVar.q().G(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (v() && this.f15270s.a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.e eVar = this.f15272u;
        if (eVar == null || !eVar.C()) {
            return null;
        }
        return this.f15272u;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.f15264m;
    }

    @Override // ra.z.e
    public fb.b getBinaryMessenger() {
        return this.f15264m.k();
    }

    public j getCurrentImageSurface() {
        return this.f15259c;
    }

    public FlutterRenderer.h getViewportMetrics() {
        return this.f15275x;
    }

    public boolean k() {
        j jVar = this.f15259c;
        if (jVar != null) {
            return jVar.e();
        }
        return false;
    }

    public void l(io.flutter.embedding.engine.renderer.d dVar) {
        this.f15262f.add(dVar);
    }

    public void m(j jVar) {
        io.flutter.embedding.engine.a aVar = this.f15264m;
        if (aVar != null) {
            jVar.b(aVar.t());
        }
    }

    public void n(io.flutter.embedding.engine.a aVar) {
        qa.b.f("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (v()) {
            if (aVar == this.f15264m) {
                qa.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                qa.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                s();
            }
        }
        this.f15264m = aVar;
        FlutterRenderer flutterRendererT = aVar.t();
        this.f15263l = flutterRendererT.n();
        this.f15260d.b(flutterRendererT);
        flutterRendererT.j(this.A);
        this.f15266o = new hb.a(this, this.f15264m.n());
        this.f15267p = new io.flutter.plugin.editing.f(this, this.f15264m.z(), this.f15264m.q());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f15273v = textServicesManager;
            this.f15268q = new io.flutter.plugin.editing.d(textServicesManager, this.f15264m.x());
        } catch (Exception unused) {
            qa.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f15269r = this.f15264m.m();
        this.f15270s = new z(this);
        this.f15271t = new ra.a(this.f15264m.t(), false);
        io.flutter.view.e eVar = new io.flutter.view.e(this, aVar.h(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f15264m.q());
        this.f15272u = eVar;
        eVar.a0(this.f15276y);
        z(this.f15272u.C(), this.f15272u.E());
        this.f15264m.q().a(this.f15272u);
        this.f15264m.q().E(this.f15264m.t());
        this.f15267p.p().restartInput(this);
        B();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f15277z);
        C();
        aVar.q().F(this);
        Iterator<f> it = this.f15265n.iterator();
        while (it.hasNext()) {
            it.next().b(aVar);
        }
        if (this.f15263l) {
            this.A.e();
        }
    }

    public g o() {
        Context context = getContext();
        if (context.getResources().getConfiguration().orientation == 2) {
            int rotation = ((DisplayManager) context.getSystemService("display")).getDisplay(0).getRotation();
            if (rotation == 1) {
                return g.RIGHT;
            }
            if (rotation == 3) {
                return g.LEFT;
            }
            if (rotation == 0 || rotation == 2) {
                return g.BOTH;
            }
        }
        return g.NONE;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f15275x.f10782l = systemGestureInsets.top;
            this.f15275x.f10783m = systemGestureInsets.right;
            this.f15275x.f10784n = systemGestureInsets.bottom;
            this.f15275x.f10785o = systemGestureInsets.left;
        }
        boolean z10 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z11 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i10 >= 30) {
            int iNavigationBars = z11 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z10) {
                iNavigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(iNavigationBars);
            this.f15275x.f10774d = insets.top;
            this.f15275x.f10775e = insets.right;
            this.f15275x.f10776f = insets.bottom;
            this.f15275x.f10777g = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f15275x.f10778h = insets2.top;
            this.f15275x.f10779i = insets2.right;
            this.f15275x.f10780j = insets2.bottom;
            this.f15275x.f10781k = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f15275x.f10782l = insets3.top;
            this.f15275x.f10783m = insets3.right;
            this.f15275x.f10784n = insets3.bottom;
            this.f15275x.f10785o = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.h hVar = this.f15275x;
                hVar.f10774d = Math.max(Math.max(hVar.f10774d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.h hVar2 = this.f15275x;
                hVar2.f10775e = Math.max(Math.max(hVar2.f10775e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.h hVar3 = this.f15275x;
                hVar3.f10776f = Math.max(Math.max(hVar3.f10776f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.h hVar4 = this.f15275x;
                hVar4.f10777g = Math.max(Math.max(hVar4.f10777g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            g gVarO = g.NONE;
            if (!z11) {
                gVarO = o();
            }
            this.f15275x.f10774d = z10 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f15275x.f10775e = (gVarO == g.RIGHT || gVarO == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f15275x.f10776f = (z11 && t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f15275x.f10777g = (gVarO == g.LEFT || gVarO == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.h hVar5 = this.f15275x;
            hVar5.f10778h = 0;
            hVar5.f10779i = 0;
            hVar5.f10780j = t(windowInsets);
            this.f15275x.f10781k = 0;
        }
        if (i10 >= 35) {
            this.C.c(getContext(), this.f15275x);
        }
        qa.b.f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f15275x.f10774d + ", Left: " + this.f15275x.f10777g + ", Right: " + this.f15275x.f10775e + "\nKeyboard insets: Bottom: " + this.f15275x.f10780j + ", Left: " + this.f15275x.f10781k + ", Right: " + this.f15275x.f10779i + "System Gesture Insets - Left: " + this.f15275x.f10785o + ", Top: " + this.f15275x.f10782l + ", Right: " + this.f15275x.f10783m + ", Bottom: " + this.f15275x.f10780j);
        C();
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15274w = r();
        Activity activityE = ub.h.e(getContext());
        e0 e0Var = this.f15274w;
        if (e0Var == null || activityE == null) {
            return;
        }
        e0Var.a(activityE, f0.a.getMainExecutor(getContext()), this.B);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f15264m != null) {
            qa.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f15269r.d(configuration);
            B();
            ub.h.c(getContext(), this.f15264m);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !v() ? super.onCreateInputConnection(editorInfo) : this.f15267p.n(this, this.f15270s, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e0 e0Var = this.f15274w;
        if (e0Var != null) {
            e0Var.b(this.B);
        }
        this.f15274w = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (v() && this.f15271t.i(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !v() ? super.onHoverEvent(motionEvent) : this.f15272u.L(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i10) {
        super.onProvideAutofillVirtualStructure(viewStructure, i10);
        this.f15267p.y(viewStructure, i10);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        qa.b.f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i12 + " x " + i13 + ", it is now " + i10 + " x " + i11);
        FlutterRenderer.h hVar = this.f15275x;
        hVar.f10772b = i10;
        hVar.f10773c = i11;
        C();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!v()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.f15271t.j(motionEvent);
    }

    public void p() {
        this.f15260d.c();
        j jVar = this.f15259c;
        if (jVar == null) {
            j jVarQ = q();
            this.f15259c = jVarQ;
            addView(jVarQ);
        } else {
            jVar.k(getWidth(), getHeight());
        }
        this.f15261e = this.f15260d;
        j jVar2 = this.f15259c;
        this.f15260d = jVar2;
        io.flutter.embedding.engine.a aVar = this.f15264m;
        if (aVar != null) {
            jVar2.b(aVar.t());
        }
    }

    public j q() {
        return new j(getContext(), getWidth(), getHeight(), j.b.background);
    }

    public e0 r() {
        try {
            return new e0(new l2.a(m2.f.f12928a.d(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void s() {
        qa.b.f("FlutterView", "Detaching from a FlutterEngine: " + this.f15264m);
        if (!v()) {
            qa.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        Iterator<f> it = this.f15265n.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f15277z);
        this.f15264m.q().P();
        this.f15264m.q().d();
        this.f15272u.S();
        this.f15272u = null;
        this.f15267p.p().restartInput(this);
        this.f15267p.o();
        this.f15270s.d();
        io.flutter.plugin.editing.d dVar = this.f15268q;
        if (dVar != null) {
            dVar.b();
        }
        hb.a aVar = this.f15266o;
        if (aVar != null) {
            aVar.c();
        }
        FlutterRenderer flutterRendererT = this.f15264m.t();
        this.f15263l = false;
        flutterRendererT.u(this.A);
        flutterRendererT.A();
        flutterRendererT.x(false);
        io.flutter.embedding.engine.renderer.e eVar = this.f15261e;
        if (eVar != null && this.f15260d == this.f15259c) {
            this.f15260d = eVar;
        }
        this.f15260d.d();
        x();
        this.f15261e = null;
        this.f15264m = null;
    }

    public void setDelegate(r rVar) {
        this.C = rVar;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        io.flutter.embedding.engine.renderer.e eVar = this.f15260d;
        if (eVar instanceof k) {
            ((k) eVar).setVisibility(i10);
        }
    }

    public void setWindowInfoListenerDisplayFeatures(m2.j jVar) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        List<m2.a> listA = jVar.a();
        ArrayList arrayList = new ArrayList();
        for (m2.a aVar : listA) {
            qa.b.f("FlutterView", "WindowInfoTracker Display Feature reported with bounds = " + aVar.getBounds().toString() + " and type = " + aVar.getClass().getSimpleName());
            if (aVar instanceof m2.c) {
                m2.c cVar = (m2.c) aVar;
                arrayList.add(new FlutterRenderer.c(aVar.getBounds(), cVar.a() == m2.c.a.f12907d ? FlutterRenderer.e.HINGE : FlutterRenderer.e.FOLD, cVar.getState() == m2.c.b.f12910c ? FlutterRenderer.d.POSTURE_FLAT : cVar.getState() == m2.c.b.f12911d ? FlutterRenderer.d.POSTURE_HALF_OPENED : FlutterRenderer.d.UNKNOWN));
            } else {
                arrayList.add(new FlutterRenderer.c(aVar.getBounds(), FlutterRenderer.e.UNKNOWN, FlutterRenderer.d.UNKNOWN));
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            for (Rect rect : displayCutout.getBoundingRects()) {
                qa.b.f("FlutterView", "DisplayCutout area reported with bounds = " + rect.toString());
                arrayList.add(new FlutterRenderer.c(rect, FlutterRenderer.e.CUTOUT));
            }
        }
        this.f15275x.f10787q = arrayList;
        C();
    }

    public final int t(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final void u() {
        View view;
        qa.b.f("FlutterView", "Initializing FlutterView");
        if (this.f15257a != null) {
            qa.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f15257a;
        } else if (this.f15258b != null) {
            qa.b.f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f15258b;
        } else {
            qa.b.f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f15259c;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setImportantForAutofill(1);
    }

    public boolean v() {
        io.flutter.embedding.engine.a aVar = this.f15264m;
        return aVar != null && aVar.t() == this.f15260d.getAttachedRenderer();
    }

    public final void x() {
        j jVar = this.f15259c;
        if (jVar != null) {
            jVar.g();
            removeView(this.f15259c);
            this.f15259c = null;
        }
    }

    public void y(io.flutter.embedding.engine.renderer.d dVar) {
        this.f15262f.remove(dVar);
    }

    public final void z(boolean z10, boolean z11) {
        boolean z12 = false;
        if (!this.f15264m.t().o() && !z10 && !z11) {
            z12 = true;
        }
        setWillNotDraw(z12);
    }
}
