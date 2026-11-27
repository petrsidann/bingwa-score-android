package i;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.n1;
import androidx.appcompat.widget.o1;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import p0.f0;
import p0.k2;
import p0.p0;
import p0.v1;
import p0.x1;

/* JADX INFO: loaded from: classes.dex */
public class f extends i.e implements androidx.appcompat.view.menu.e.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final t.g<String, Integer> f9973o0 = new t.g<>();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final boolean f9974p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int[] f9975q0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final boolean f9976r0 = !"robolectric".equals(Build.FINGERPRINT);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final boolean f9977s0 = true;
    public ActionBarContextView A;
    public PopupWindow B;
    public Runnable C;
    public v1 D;
    public boolean E;
    public boolean F;
    public ViewGroup G;
    public TextView H;
    public View I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public s[] R;
    public s S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public Configuration X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f9978a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f9979b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public o f9980c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public o f9981d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f9982e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f9983f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Runnable f9984g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f9985h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Rect f9986i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Rect f9987j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public i.j f9988k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public i.n f9989l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public OnBackInvokedDispatcher f9990m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public OnBackInvokedCallback f9991n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f9992o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f9993p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Window f9994q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m f9995r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final i.c f9996s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i.a f9997t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MenuInflater f9998u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f9999v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j0 f10000w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public C0167f f10001x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public t f10002y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m.b f10003z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.f9983f0 & 1) != 0) {
                fVar.f0(0);
            }
            f fVar2 = f.this;
            if ((fVar2.f9983f0 & 4096) != 0) {
                fVar2.f0(108);
            }
            f fVar3 = f.this;
            fVar3.f9982e0 = false;
            fVar3.f9983f0 = 0;
        }
    }

    public class b implements f0 {
        public b() {
        }

        @Override // p0.f0
        public k2 a(View view, k2 k2Var) {
            int iK = k2Var.k();
            int iC1 = f.this.c1(k2Var, null);
            if (iK != iC1) {
                k2Var = k2Var.o(k2Var.i(), iC1, k2Var.j(), k2Var.h());
            }
            return p0.b0(view, k2Var);
        }
    }

    public class c implements ContentFrameLayout.a {
        public c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.d0();
        }
    }

    public class d implements Runnable {

        public class a extends x1 {
            public a() {
            }

            @Override // p0.w1
            public void b(View view) {
                f.this.A.setAlpha(1.0f);
                f.this.D.h(null);
                f.this.D = null;
            }

            @Override // p0.x1, p0.w1
            public void c(View view) {
                f.this.A.setVisibility(0);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.B.showAtLocation(fVar.A, 55, 0, 0);
            f.this.g0();
            if (!f.this.R0()) {
                f.this.A.setAlpha(1.0f);
                f.this.A.setVisibility(0);
            } else {
                f.this.A.setAlpha(0.0f);
                f fVar2 = f.this;
                fVar2.D = p0.e(fVar2.A).b(1.0f);
                f.this.D.h(new a());
            }
        }
    }

    public class e extends x1 {
        public e() {
        }

        @Override // p0.w1
        public void b(View view) {
            f.this.A.setAlpha(1.0f);
            f.this.D.h(null);
            f.this.D = null;
        }

        @Override // p0.x1, p0.w1
        public void c(View view) {
            f.this.A.setVisibility(0);
            if (f.this.A.getParent() instanceof View) {
                p0.m0((View) f.this.A.getParent());
            }
        }
    }

    /* JADX INFO: renamed from: i.f$f, reason: collision with other inner class name */
    public final class C0167f implements androidx.appcompat.view.menu.i.a {
        public C0167f() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            f.this.W(eVar);
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackS0 = f.this.s0();
            if (callbackS0 == null) {
                return true;
            }
            callbackS0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public class g implements m.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m.b.a f10011a;

        public class a extends x1 {
            public a() {
            }

            @Override // p0.w1
            public void b(View view) {
                f.this.A.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.A.getParent() instanceof View) {
                    p0.m0((View) f.this.A.getParent());
                }
                f.this.A.k();
                f.this.D.h(null);
                f fVar2 = f.this;
                fVar2.D = null;
                p0.m0(fVar2.G);
            }
        }

        public g(m.b.a aVar) {
            this.f10011a = aVar;
        }

        @Override // m.b.a
        public void a(m.b bVar) {
            this.f10011a.a(bVar);
            f fVar = f.this;
            if (fVar.B != null) {
                fVar.f9994q.getDecorView().removeCallbacks(f.this.C);
            }
            f fVar2 = f.this;
            if (fVar2.A != null) {
                fVar2.g0();
                f fVar3 = f.this;
                fVar3.D = p0.e(fVar3.A).b(0.0f);
                f.this.D.h(new a());
            }
            f fVar4 = f.this;
            i.c cVar = fVar4.f9996s;
            if (cVar != null) {
                cVar.o(fVar4.f10003z);
            }
            f fVar5 = f.this;
            fVar5.f10003z = null;
            p0.m0(fVar5.G);
            f.this.a1();
        }

        @Override // m.b.a
        public boolean b(m.b bVar, Menu menu) {
            p0.m0(f.this.G);
            return this.f10011a.b(bVar, menu);
        }

        @Override // m.b.a
        public boolean c(m.b bVar, Menu menu) {
            return this.f10011a.c(bVar, menu);
        }

        @Override // m.b.a
        public boolean d(m.b bVar, MenuItem menuItem) {
            return this.f10011a.d(bVar, menuItem);
        }
    }

    public static class h {
        public static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }

        public static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        public static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    public static class i {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    public static class j {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static l0.j b(Configuration configuration) {
            return l0.j.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(l0.j jVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(jVar.g()));
        }

        public static void d(Configuration configuration, l0.j jVar) {
            configuration.setLocales(LocaleList.forLanguageTags(jVar.g()));
        }
    }

    public static class k {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    public static class l {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, final f fVar) {
            Objects.requireNonNull(fVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: i.g
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    fVar.A0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class m extends m.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10016d;

        public m(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f10015c = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f10015c = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f10014b = true;
                callback.onContentChanged();
            } finally {
                this.f10014b = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f10016d = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f10016d = false;
            }
        }

        @Override // m.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f10015c) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return f.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // m.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.D0(keyEvent.getKeyCode(), keyEvent);
        }

        public final ActionMode e(ActionMode.Callback callback) {
            m.f.a aVar = new m.f.a(f.this.f9993p, callback);
            m.b bVarU0 = f.this.U0(aVar);
            if (bVarU0 != null) {
                return aVar.e(bVarU0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f10014b) {
                a().onContentChanged();
            }
        }

        @Override // m.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // m.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            return super.onCreatePanelView(i10);
        }

        @Override // m.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            f.this.G0(i10);
            return true;
        }

        @Override // m.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f10016d) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                f.this.H0(i10);
            }
        }

        @Override // m.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            if (eVar != null) {
                eVar.a0(false);
            }
            return zOnPreparePanel;
        }

        @Override // m.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            s sVarQ0 = f.this.q0(0, true);
            if (sVarQ0 == null || (eVar = sVarQ0.f10035j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // m.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (f.this.y0() && i10 == 0) ? e(callback) : super.onWindowStartingActionMode(callback, i10);
        }
    }

    public class n extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f10018c;

        public n(Context context) {
            super();
            this.f10018c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // i.f.o
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // i.f.o
        public int c() {
            return i.a(this.f10018c) ? 2 : 1;
        }

        @Override // i.f.o
        public void d() {
            f.this.Q();
        }
    }

    public abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f10020a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                o.this.d();
            }
        }

        public o() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f10020a;
            if (broadcastReceiver != null) {
                try {
                    f.this.f9993p.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f10020a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f10020a == null) {
                this.f10020a = new a();
            }
            f.this.f9993p.registerReceiver(this.f10020a, intentFilterB);
        }
    }

    public class p extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i.q f10023c;

        public p(i.q qVar) {
            super();
            this.f10023c = qVar;
        }

        @Override // i.f.o
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // i.f.o
        public int c() {
            return this.f10023c.d() ? 2 : 1;
        }

        @Override // i.f.o
        public void d() {
            f.this.Q();
        }
    }

    public static class q {
        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        public final boolean b(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.Y(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(j.a.b(getContext(), i10));
        }
    }

    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ViewGroup f10032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f10033h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f10034i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f10035j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.c f10036k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Context f10037l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f10038m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f10039n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f10040o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f10041p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f10042q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f10043r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Bundle f10044s;

        public s(int i10) {
            this.f10026a = i10;
        }

        public androidx.appcompat.view.menu.j a(androidx.appcompat.view.menu.i.a aVar) {
            if (this.f10035j == null) {
                return null;
            }
            if (this.f10036k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f10037l, h.g.f9393j);
                this.f10036k = cVar;
                cVar.h(aVar);
                this.f10035j.b(this.f10036k);
            }
            return this.f10036k.b(this.f10032g);
        }

        public boolean b() {
            if (this.f10033h == null) {
                return false;
            }
            return this.f10034i != null || this.f10036k.a().getCount() > 0;
        }

        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f10035j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.f10036k);
            }
            this.f10035j = eVar;
            if (eVar == null || (cVar = this.f10036k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(h.a.f9286a, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                themeNewTheme.applyStyle(i10, true);
            }
            themeNewTheme.resolveAttribute(h.a.F, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 == 0) {
                i11 = h.i.f9415a;
            }
            themeNewTheme.applyStyle(i11, true);
            m.d dVar = new m.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f10037l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(h.j.f9539y0);
            this.f10027b = typedArrayObtainStyledAttributes.getResourceId(h.j.B0, 0);
            this.f10031f = typedArrayObtainStyledAttributes.getResourceId(h.j.A0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final class t implements androidx.appcompat.view.menu.i.a {
        public t() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z11 = eVarD != eVar;
            f fVar = f.this;
            if (z11) {
                eVar = eVarD;
            }
            s sVarJ0 = fVar.j0(eVar);
            if (sVarJ0 != null) {
                if (!z11) {
                    f.this.Z(sVarJ0, z10);
                } else {
                    f.this.V(sVarJ0.f10026a, sVarJ0, eVarD);
                    f.this.Z(sVarJ0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackS0;
            if (eVar != eVar.D()) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.L || (callbackS0 = fVar.s0()) == null || f.this.W) {
                return true;
            }
            callbackS0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public f(Activity activity, i.c cVar) {
        this(activity, null, cVar, activity);
    }

    public f(Dialog dialog, i.c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    public f(Context context, Window window, i.c cVar, Object obj) {
        t.g<String, Integer> gVar;
        Integer num;
        i.b bVarX0;
        this.D = null;
        this.E = true;
        this.Y = -100;
        this.f9984g0 = new a();
        this.f9993p = context;
        this.f9996s = cVar;
        this.f9992o = obj;
        if (this.Y == -100 && (obj instanceof Dialog) && (bVarX0 = X0()) != null) {
            this.Y = bVarX0.d0().n();
        }
        if (this.Y == -100 && (num = (gVar = f9973o0).get(obj.getClass().getName())) != null) {
            this.Y = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            S(window);
        }
        androidx.appcompat.widget.k.h();
    }

    public static Configuration k0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            j.a(configuration, configuration2, configuration3);
            int i14 = configuration.touchscreen;
            int i15 = configuration2.touchscreen;
            if (i14 != i15) {
                configuration3.touchscreen = i15;
            }
            int i16 = configuration.keyboard;
            int i17 = configuration2.keyboard;
            if (i16 != i17) {
                configuration3.keyboard = i17;
            }
            int i18 = configuration.keyboardHidden;
            int i19 = configuration2.keyboardHidden;
            if (i18 != i19) {
                configuration3.keyboardHidden = i19;
            }
            int i20 = configuration.navigation;
            int i21 = configuration2.navigation;
            if (i20 != i21) {
                configuration3.navigation = i21;
            }
            int i22 = configuration.navigationHidden;
            int i23 = configuration2.navigationHidden;
            if (i22 != i23) {
                configuration3.navigationHidden = i23;
            }
            int i24 = configuration.orientation;
            int i25 = configuration2.orientation;
            if (i24 != i25) {
                configuration3.orientation = i25;
            }
            int i26 = configuration.screenLayout & 15;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 15)) {
                configuration3.screenLayout |= i27 & 15;
            }
            int i28 = configuration.screenLayout & 192;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 192)) {
                configuration3.screenLayout |= i29 & 192;
            }
            int i30 = configuration.screenLayout & 48;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & 48)) {
                configuration3.screenLayout |= i31 & 48;
            }
            int i32 = configuration.screenLayout & 768;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & 768)) {
                configuration3.screenLayout |= i33 & 768;
            }
            k.a(configuration, configuration2, configuration3);
            int i34 = configuration.uiMode & 15;
            int i35 = configuration2.uiMode;
            if (i34 != (i35 & 15)) {
                configuration3.uiMode |= i35 & 15;
            }
            int i36 = configuration.uiMode & 48;
            int i37 = configuration2.uiMode;
            if (i36 != (i37 & 48)) {
                configuration3.uiMode |= i37 & 48;
            }
            int i38 = configuration.screenWidthDp;
            int i39 = configuration2.screenWidthDp;
            if (i38 != i39) {
                configuration3.screenWidthDp = i39;
            }
            int i40 = configuration.screenHeightDp;
            int i41 = configuration2.screenHeightDp;
            if (i40 != i41) {
                configuration3.screenHeightDp = i41;
            }
            int i42 = configuration.smallestScreenWidthDp;
            int i43 = configuration2.smallestScreenWidthDp;
            if (i42 != i43) {
                configuration3.smallestScreenWidthDp = i43;
            }
            h.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    @Override // i.e
    public void A() {
        i.a aVarR = r();
        if (aVarR != null) {
            aVarR.r(true);
        }
    }

    public boolean A0() {
        boolean z10 = this.T;
        this.T = false;
        s sVarQ0 = q0(0, false);
        if (sVarQ0 != null && sVarQ0.f10040o) {
            if (!z10) {
                Z(sVarQ0, true);
            }
            return true;
        }
        m.b bVar = this.f10003z;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        i.a aVarR = r();
        return aVarR != null && aVarR.g();
    }

    @Override // i.e
    public void B(Bundle bundle) {
    }

    public boolean B0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.T = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            C0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // i.e
    public void C() {
        P(true, false);
    }

    public final boolean C0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        s sVarQ0 = q0(i10, true);
        if (sVarQ0.f10040o) {
            return false;
        }
        return M0(sVarQ0, keyEvent);
    }

    @Override // i.e
    public void D() {
        i.a aVarR = r();
        if (aVarR != null) {
            aVarR.r(false);
        }
    }

    public boolean D0(int i10, KeyEvent keyEvent) {
        i.a aVarR = r();
        if (aVarR != null && aVarR.n(i10, keyEvent)) {
            return true;
        }
        s sVar = this.S;
        if (sVar != null && L0(sVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            s sVar2 = this.S;
            if (sVar2 != null) {
                sVar2.f10039n = true;
            }
            return true;
        }
        if (this.S == null) {
            s sVarQ0 = q0(0, true);
            M0(sVarQ0, keyEvent);
            boolean zL0 = L0(sVarQ0, keyEvent.getKeyCode(), keyEvent, 1);
            sVarQ0.f10038m = false;
            if (zL0) {
                return true;
            }
        }
        return false;
    }

    public boolean E0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                F0(0, keyEvent);
                return true;
            }
        } else if (A0()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    public final boolean F0(int i10, KeyEvent keyEvent) {
        boolean zM0;
        j0 j0Var;
        if (this.f10003z != null) {
            return false;
        }
        boolean zF = true;
        s sVarQ0 = q0(i10, true);
        if (i10 != 0 || (j0Var = this.f10000w) == null || !j0Var.d() || ViewConfiguration.get(this.f9993p).hasPermanentMenuKey()) {
            boolean z10 = sVarQ0.f10040o;
            if (z10 || sVarQ0.f10039n) {
                Z(sVarQ0, true);
                zF = z10;
            } else if (sVarQ0.f10038m) {
                if (sVarQ0.f10043r) {
                    sVarQ0.f10038m = false;
                    zM0 = M0(sVarQ0, keyEvent);
                } else {
                    zM0 = true;
                }
                if (zM0) {
                    J0(sVarQ0, keyEvent);
                } else {
                    zF = false;
                }
            } else {
                zF = false;
            }
        } else if (this.f10000w.b()) {
            zF = this.f10000w.f();
        } else if (this.W || !M0(sVarQ0, keyEvent)) {
            zF = false;
        } else {
            zF = this.f10000w.g();
        }
        if (zF) {
            AudioManager audioManager = (AudioManager) this.f9993p.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zF;
    }

    @Override // i.e
    public boolean G(int i10) {
        int iO0 = O0(i10);
        if (this.P && iO0 == 108) {
            return false;
        }
        if (this.L && iO0 == 1) {
            this.L = false;
        }
        if (iO0 == 1) {
            W0();
            this.P = true;
            return true;
        }
        if (iO0 == 2) {
            W0();
            this.J = true;
            return true;
        }
        if (iO0 == 5) {
            W0();
            this.K = true;
            return true;
        }
        if (iO0 == 10) {
            W0();
            this.N = true;
            return true;
        }
        if (iO0 == 108) {
            W0();
            this.L = true;
            return true;
        }
        if (iO0 != 109) {
            return this.f9994q.requestFeature(iO0);
        }
        W0();
        this.M = true;
        return true;
    }

    public void G0(int i10) {
        i.a aVarR;
        if (i10 != 108 || (aVarR = r()) == null) {
            return;
        }
        aVarR.h(true);
    }

    @Override // i.e
    public void H(int i10) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f9993p).inflate(i10, viewGroup);
        this.f9995r.c(this.f9994q.getCallback());
    }

    public void H0(int i10) {
        if (i10 == 108) {
            i.a aVarR = r();
            if (aVarR != null) {
                aVarR.h(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            s sVarQ0 = q0(i10, true);
            if (sVarQ0.f10040o) {
                Z(sVarQ0, false);
            }
        }
    }

    @Override // i.e
    public void I(View view) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f9995r.c(this.f9994q.getCallback());
    }

    public void I0(ViewGroup viewGroup) {
    }

    @Override // i.e
    public void J(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f9995r.c(this.f9994q.getCallback());
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public final void J0(s sVar, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (sVar.f10040o || this.W) {
            return;
        }
        if (sVar.f10026a == 0) {
            if ((this.f9993p.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackS0 = s0();
        if (callbackS0 != null && !callbackS0.onMenuOpened(sVar.f10026a, sVar.f10035j)) {
            Z(sVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f9993p.getSystemService("window");
        if (windowManager != null && M0(sVar, keyEvent)) {
            ViewGroup viewGroup = sVar.f10032g;
            if (viewGroup != null && !sVar.f10042q) {
                View view = sVar.f10034i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i10 = -1;
                }
                sVar.f10039n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i10, -2, sVar.f10029d, sVar.f10030e, 1002, 8519680, -3);
                layoutParams2.gravity = sVar.f10028c;
                layoutParams2.windowAnimations = sVar.f10031f;
                windowManager.addView(sVar.f10032g, layoutParams2);
                sVar.f10040o = true;
                if (sVar.f10026a == 0) {
                    a1();
                }
            }
            if (viewGroup == null) {
                if (!v0(sVar) || sVar.f10032g == null) {
                    return;
                }
            } else if (sVar.f10042q && viewGroup.getChildCount() > 0) {
                sVar.f10032g.removeAllViews();
            }
            if (!u0(sVar) || !sVar.b()) {
                sVar.f10042q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = sVar.f10033h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            sVar.f10032g.setBackgroundResource(sVar.f10027b);
            ViewParent parent = sVar.f10033h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(sVar.f10033h);
            }
            sVar.f10032g.addView(sVar.f10033h, layoutParams3);
            if (!sVar.f10033h.hasFocus()) {
                sVar.f10033h.requestFocus();
            }
            i10 = -2;
            sVar.f10039n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i10, -2, sVar.f10029d, sVar.f10030e, 1002, 8519680, -3);
            layoutParams4.gravity = sVar.f10028c;
            layoutParams4.windowAnimations = sVar.f10031f;
            windowManager.addView(sVar.f10032g, layoutParams4);
            sVar.f10040o = true;
            if (sVar.f10026a == 0) {
                a1();
            }
        }
    }

    @Override // i.e
    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.K(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f9990m0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f9991n0) != null) {
            l.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f9991n0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f9992o;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                onBackInvokedDispatcher = l.a((Activity) this.f9992o);
            }
        }
        this.f9990m0 = onBackInvokedDispatcher;
        a1();
    }

    public final i.a K0() {
        return this.f9997t;
    }

    @Override // i.e
    public void L(int i10) {
        this.Z = i10;
    }

    public final boolean L0(s sVar, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((sVar.f10038m || M0(sVar, keyEvent)) && (eVar = sVar.f10035j) != null) {
            zPerformShortcut = eVar.performShortcut(i10, keyEvent, i11);
        }
        if (zPerformShortcut && (i11 & 1) == 0 && this.f10000w == null) {
            Z(sVar, true);
        }
        return zPerformShortcut;
    }

    @Override // i.e
    public final void M(CharSequence charSequence) {
        this.f9999v = charSequence;
        j0 j0Var = this.f10000w;
        if (j0Var != null) {
            j0Var.setWindowTitle(charSequence);
            return;
        }
        if (K0() != null) {
            K0().s(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean M0(s sVar, KeyEvent keyEvent) {
        j0 j0Var;
        j0 j0Var2;
        j0 j0Var3;
        if (this.W) {
            return false;
        }
        if (sVar.f10038m) {
            return true;
        }
        s sVar2 = this.S;
        if (sVar2 != null && sVar2 != sVar) {
            Z(sVar2, false);
        }
        Window.Callback callbackS0 = s0();
        if (callbackS0 != null) {
            sVar.f10034i = callbackS0.onCreatePanelView(sVar.f10026a);
        }
        int i10 = sVar.f10026a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (j0Var3 = this.f10000w) != null) {
            j0Var3.c();
        }
        if (sVar.f10034i == null) {
            if (z10) {
                K0();
            }
            androidx.appcompat.view.menu.e eVar = sVar.f10035j;
            if (eVar == null || sVar.f10043r) {
                if (eVar == null && (!w0(sVar) || sVar.f10035j == null)) {
                    return false;
                }
                if (z10 && this.f10000w != null) {
                    if (this.f10001x == null) {
                        this.f10001x = new C0167f();
                    }
                    this.f10000w.a(sVar.f10035j, this.f10001x);
                }
                sVar.f10035j.d0();
                if (!callbackS0.onCreatePanelMenu(sVar.f10026a, sVar.f10035j)) {
                    sVar.c(null);
                    if (z10 && (j0Var = this.f10000w) != null) {
                        j0Var.a(null, this.f10001x);
                    }
                    return false;
                }
                sVar.f10043r = false;
            }
            sVar.f10035j.d0();
            Bundle bundle = sVar.f10044s;
            if (bundle != null) {
                sVar.f10035j.P(bundle);
                sVar.f10044s = null;
            }
            if (!callbackS0.onPreparePanel(0, sVar.f10034i, sVar.f10035j)) {
                if (z10 && (j0Var2 = this.f10000w) != null) {
                    j0Var2.a(null, this.f10001x);
                }
                sVar.f10035j.c0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            sVar.f10041p = z11;
            sVar.f10035j.setQwertyMode(z11);
            sVar.f10035j.c0();
        }
        sVar.f10038m = true;
        sVar.f10039n = false;
        this.S = sVar;
        return true;
    }

    public final void N0(boolean z10) {
        j0 j0Var = this.f10000w;
        if (j0Var == null || !j0Var.d() || (ViewConfiguration.get(this.f9993p).hasPermanentMenuKey() && !this.f10000w.e())) {
            s sVarQ0 = q0(0, true);
            sVarQ0.f10042q = true;
            Z(sVarQ0, false);
            J0(sVarQ0, null);
            return;
        }
        Window.Callback callbackS0 = s0();
        if (this.f10000w.b() && z10) {
            this.f10000w.f();
            if (this.W) {
                return;
            }
            callbackS0.onPanelClosed(108, q0(0, true).f10035j);
            return;
        }
        if (callbackS0 == null || this.W) {
            return;
        }
        if (this.f9982e0 && (this.f9983f0 & 1) != 0) {
            this.f9994q.getDecorView().removeCallbacks(this.f9984g0);
            this.f9984g0.run();
        }
        s sVarQ1 = q0(0, true);
        androidx.appcompat.view.menu.e eVar = sVarQ1.f10035j;
        if (eVar == null || sVarQ1.f10043r || !callbackS0.onPreparePanel(0, sVarQ1.f10034i, eVar)) {
            return;
        }
        callbackS0.onMenuOpened(108, sVarQ1.f10035j);
        this.f10000w.g();
    }

    public final boolean O(boolean z10) {
        return P(z10, true);
    }

    public final int O0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 != 9) {
            return i10;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    public final boolean P(boolean z10, boolean z11) {
        if (this.W) {
            return false;
        }
        int iU = U();
        int iZ0 = z0(this.f9993p, iU);
        l0.j jVarT = Build.VERSION.SDK_INT < 33 ? T(this.f9993p) : null;
        if (!z11 && jVarT != null) {
            jVarT = p0(this.f9993p.getResources().getConfiguration());
        }
        boolean zZ0 = Z0(iZ0, jVarT, z10);
        if (iU == 0) {
            o0(this.f9993p).e();
        } else {
            o oVar = this.f9980c0;
            if (oVar != null) {
                oVar.a();
            }
        }
        if (iU == 3) {
            n0(this.f9993p).e();
        } else {
            o oVar2 = this.f9981d0;
            if (oVar2 != null) {
                oVar2.a();
            }
        }
        return zZ0;
    }

    public void P0(Configuration configuration, l0.j jVar) {
        j.d(configuration, jVar);
    }

    public boolean Q() {
        return O(true);
    }

    public void Q0(l0.j jVar) {
        j.c(jVar);
    }

    public final void R() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.G.findViewById(R.id.content);
        View decorView = this.f9994q.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f9993p.obtainStyledAttributes(h.j.f9539y0);
        typedArrayObtainStyledAttributes.getValue(h.j.K0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(h.j.L0, contentFrameLayout.getMinWidthMinor());
        int i10 = h.j.I0;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = h.j.J0;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            typedArrayObtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = h.j.G0;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            typedArrayObtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = h.j.H0;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            typedArrayObtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean R0() {
        ViewGroup viewGroup;
        return this.F && (viewGroup = this.G) != null && p0.T(viewGroup);
    }

    public final void S(Window window) {
        if (this.f9994q != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof m) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        m mVar = new m(callback);
        this.f9995r = mVar;
        window.setCallback(mVar);
        h1 h1VarU = h1.u(this.f9993p, null, f9975q0);
        Drawable drawableH = h1VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        h1VarU.w();
        this.f9994q = window;
        if (Build.VERSION.SDK_INT < 33 || this.f9990m0 != null) {
            return;
        }
        K(null);
    }

    public final boolean S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f9994q.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || p0.S((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public l0.j T(Context context) {
        l0.j jVarQ;
        if (Build.VERSION.SDK_INT >= 33 || (jVarQ = i.e.q()) == null) {
            return null;
        }
        l0.j jVarP0 = p0(context.getApplicationContext().getResources().getConfiguration());
        l0.j jVarB = i.o.b(jVarQ, jVarP0);
        return jVarB.e() ? jVarP0 : jVarB;
    }

    public boolean T0() {
        if (this.f9990m0 == null) {
            return false;
        }
        s sVarQ0 = q0(0, false);
        return (sVarQ0 != null && sVarQ0.f10040o) || this.f10003z != null;
    }

    public final int U() {
        int i10 = this.Y;
        return i10 != -100 ? i10 : i.e.m();
    }

    public m.b U0(m.b.a aVar) {
        i.c cVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        m.b bVar = this.f10003z;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        i.a aVarR = r();
        if (aVarR != null) {
            m.b bVarT = aVarR.t(gVar);
            this.f10003z = bVarT;
            if (bVarT != null && (cVar = this.f9996s) != null) {
                cVar.f(bVarT);
            }
        }
        if (this.f10003z == null) {
            this.f10003z = V0(gVar);
        }
        a1();
        return this.f10003z;
    }

    public void V(int i10, s sVar, Menu menu) {
        if (menu == null) {
            if (sVar == null && i10 >= 0) {
                s[] sVarArr = this.R;
                if (i10 < sVarArr.length) {
                    sVar = sVarArr[i10];
                }
            }
            if (sVar != null) {
                menu = sVar.f10035j;
            }
        }
        if ((sVar == null || sVar.f10040o) && !this.W) {
            this.f9995r.d(this.f9994q.getCallback(), i10, menu);
        }
    }

    public m.b V0(m.b.a aVar) {
        m.b bVarQ;
        Context dVar;
        i.c cVar;
        g0();
        m.b bVar = this.f10003z;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof g)) {
            aVar = new g(aVar);
        }
        i.c cVar2 = this.f9996s;
        if (cVar2 == null || this.W) {
            bVarQ = null;
        } else {
            try {
                bVarQ = cVar2.q(aVar);
            } catch (AbstractMethodError unused) {
                bVarQ = null;
            }
        }
        if (bVarQ != null) {
            this.f10003z = bVarQ;
        } else {
            if (this.A == null) {
                if (this.O) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f9993p.getTheme();
                    theme.resolveAttribute(h.a.f9291f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f9993p.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new m.d(this.f9993p, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f9993p;
                    }
                    this.A = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, h.a.f9294i);
                    this.B = popupWindow;
                    t0.j.b(popupWindow, 2);
                    this.B.setContentView(this.A);
                    this.B.setWidth(-1);
                    dVar.getTheme().resolveAttribute(h.a.f9287b, typedValue, true);
                    this.A.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.B.setHeight(-2);
                    this.C = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.G.findViewById(h.f.f9365h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(l0()));
                        this.A = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.A != null) {
                g0();
                this.A.k();
                m.e eVar = new m.e(this.A.getContext(), this.A, aVar, this.B == null);
                if (aVar.c(eVar, eVar.e())) {
                    eVar.k();
                    this.A.h(eVar);
                    this.f10003z = eVar;
                    if (R0()) {
                        this.A.setAlpha(0.0f);
                        v1 v1VarB = p0.e(this.A).b(1.0f);
                        this.D = v1VarB;
                        v1VarB.h(new e());
                    } else {
                        this.A.setAlpha(1.0f);
                        this.A.setVisibility(0);
                        if (this.A.getParent() instanceof View) {
                            p0.m0((View) this.A.getParent());
                        }
                    }
                    if (this.B != null) {
                        this.f9994q.getDecorView().post(this.C);
                    }
                } else {
                    this.f10003z = null;
                }
            }
        }
        m.b bVar2 = this.f10003z;
        if (bVar2 != null && (cVar = this.f9996s) != null) {
            cVar.f(bVar2);
        }
        a1();
        return this.f10003z;
    }

    public void W(androidx.appcompat.view.menu.e eVar) {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.f10000w.i();
        Window.Callback callbackS0 = s0();
        if (callbackS0 != null && !this.W) {
            callbackS0.onPanelClosed(108, eVar);
        }
        this.Q = false;
    }

    public final void W0() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void X() {
        o oVar = this.f9980c0;
        if (oVar != null) {
            oVar.a();
        }
        o oVar2 = this.f9981d0;
        if (oVar2 != null) {
            oVar2.a();
        }
    }

    public final i.b X0() {
        for (Context baseContext = this.f9993p; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof i.b) {
                return (i.b) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public void Y(int i10) {
        Z(q0(i10, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0(Configuration configuration) {
        Activity activity = (Activity) this.f9992o;
        if (activity instanceof androidx.lifecycle.k) {
            if (!((androidx.lifecycle.k) activity).a().b().h(androidx.lifecycle.g.b.CREATED)) {
                return;
            }
        } else if (!this.V || this.W) {
            return;
        }
        activity.onConfigurationChanged(configuration);
    }

    public void Z(s sVar, boolean z10) {
        ViewGroup viewGroup;
        j0 j0Var;
        if (z10 && sVar.f10026a == 0 && (j0Var = this.f10000w) != null && j0Var.b()) {
            W(sVar.f10035j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f9993p.getSystemService("window");
        if (windowManager != null && sVar.f10040o && (viewGroup = sVar.f10032g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                V(sVar.f10026a, sVar, null);
            }
        }
        sVar.f10038m = false;
        sVar.f10039n = false;
        sVar.f10040o = false;
        sVar.f10033h = null;
        sVar.f10042q = true;
        if (this.S == sVar) {
            this.S = null;
        }
        if (sVar.f10026a == 0) {
            a1();
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    public final boolean Z0(int i10, l0.j jVar, boolean z10) {
        boolean z11;
        Configuration configurationA0 = a0(this.f9993p, i10, jVar, null, false);
        int iM0 = m0(this.f9993p);
        Configuration configuration = this.X;
        if (configuration == null) {
            configuration = this.f9993p.getResources().getConfiguration();
        }
        int i11 = configuration.uiMode & 48;
        int i12 = configurationA0.uiMode & 48;
        l0.j jVarP0 = p0(configuration);
        l0.j jVarP1 = jVar == null ? null : p0(configurationA0);
        int i13 = i11 != i12 ? 512 : 0;
        if (jVarP1 != null && !jVarP0.equals(jVarP1)) {
            i13 = i13 | 4 | 8192;
        }
        boolean z12 = true;
        if (((~iM0) & i13) != 0 && z10 && this.U && (f9976r0 || this.V)) {
            Object obj = this.f9992o;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z11 = false;
            } else {
                e0.b.d((Activity) this.f9992o);
                z11 = true;
            }
        } else {
            z11 = false;
        }
        if (z11 || i13 == 0) {
            z12 = z11;
        } else {
            b1(i12, jVarP1, (i13 & iM0) == i13, null);
        }
        if (z12) {
            Object obj2 = this.f9992o;
            if (obj2 instanceof i.b) {
                if ((i13 & 512) != 0) {
                    ((i.b) obj2).j0(i10);
                }
                if ((i13 & 4) != 0) {
                    ((i.b) this.f9992o).i0(jVar);
                }
            }
        }
        if (z12 && jVarP1 != null) {
            Q0(p0(this.f9993p.getResources().getConfiguration()));
        }
        return z12;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        s sVarJ0;
        Window.Callback callbackS0 = s0();
        if (callbackS0 == null || this.W || (sVarJ0 = j0(eVar.D())) == null) {
            return false;
        }
        return callbackS0.onMenuItemSelected(sVarJ0.f10026a, menuItem);
    }

    public final Configuration a0(Context context, int i10, l0.j jVar, Configuration configuration, boolean z10) {
        int i11;
        if (i10 == 1) {
            i11 = 16;
        } else if (i10 != 2) {
            i11 = z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i11 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (jVar != null) {
            P0(configuration2, jVar);
        }
        return configuration2;
    }

    public void a1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zT0 = T0();
            if (zT0 && this.f9991n0 == null) {
                this.f9991n0 = l.b(this.f9990m0, this);
            } else {
                if (zT0 || (onBackInvokedCallback = this.f9991n0) == null) {
                    return;
                }
                l.c(this.f9990m0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        N0(true);
    }

    public final ViewGroup b0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f9993p.obtainStyledAttributes(h.j.f9539y0);
        int i10 = h.j.D0;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.j.M0, false)) {
            G(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            G(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.j.E0, false)) {
            G(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.j.F0, false)) {
            G(10);
        }
        this.O = typedArrayObtainStyledAttributes.getBoolean(h.j.f9544z0, false);
        typedArrayObtainStyledAttributes.recycle();
        i0();
        this.f9994q.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f9993p);
        if (this.P) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(this.N ? h.g.f9398o : h.g.f9397n, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(h.g.f9389f, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            this.f9993p.getTheme().resolveAttribute(h.a.f9291f, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new m.d(this.f9993p, typedValue.resourceId) : this.f9993p).inflate(h.g.f9399p, (ViewGroup) null);
            j0 j0Var = (j0) viewGroup.findViewById(h.f.f9373p);
            this.f10000w = j0Var;
            j0Var.setWindowCallback(s0());
            if (this.M) {
                this.f10000w.h(109);
            }
            if (this.J) {
                this.f10000w.h(2);
            }
            if (this.K) {
                this.f10000w.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.L + ", windowActionBarOverlay: " + this.M + ", android:windowIsFloating: " + this.O + ", windowActionModeOverlay: " + this.N + ", windowNoTitle: " + this.P + " }");
        }
        p0.D0(viewGroup, new b());
        if (this.f10000w == null) {
            this.H = (TextView) viewGroup.findViewById(h.f.L);
        }
        o1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(h.f.f9359b);
        ViewGroup viewGroup2 = (ViewGroup) this.f9994q.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f9994q.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    public final void b1(int i10, l0.j jVar, boolean z10, Configuration configuration) {
        Resources resources = this.f9993p.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        if (jVar != null) {
            P0(configuration2, jVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i11 = this.Z;
        if (i11 != 0) {
            this.f9993p.setTheme(i11);
            this.f9993p.getTheme().applyStyle(this.Z, true);
        }
        if (z10 && (this.f9992o instanceof Activity)) {
            Y0(configuration2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View c0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        i.j jVar;
        boolean zS0 = false;
        if (this.f9988k0 == null) {
            String string = this.f9993p.obtainStyledAttributes(h.j.f9539y0).getString(h.j.C0);
            if (string == null) {
                jVar = new i.j();
            } else {
                try {
                    this.f9988k0 = (i.j) this.f9993p.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    jVar = new i.j();
                    this.f9988k0 = jVar;
                }
            }
            this.f9988k0 = jVar;
        }
        boolean z11 = f9974p0;
        if (z11) {
            if (this.f9989l0 == null) {
                this.f9989l0 = new i.n();
            }
            if (this.f9989l0.a(attributeSet)) {
                z10 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zS0 = S0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zS0 = true;
                }
                z10 = zS0;
            }
        } else {
            z10 = zS0;
        }
        return this.f9988k0.r(view, str, context, attributeSet, z10, z11, true, n1.c());
    }

    public final int c1(k2 k2Var, Rect rect) {
        int iK;
        boolean z10;
        boolean z11;
        if (k2Var != null) {
            iK = k2Var.k();
        } else {
            iK = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.A;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            boolean z12 = true;
            if (this.A.isShown()) {
                if (this.f9986i0 == null) {
                    this.f9986i0 = new Rect();
                    this.f9987j0 = new Rect();
                }
                Rect rect2 = this.f9986i0;
                Rect rect3 = this.f9987j0;
                if (k2Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(k2Var.i(), k2Var.k(), k2Var.j(), k2Var.h());
                }
                o1.a(this.G, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                k2 k2VarH = p0.H(this.G);
                int i13 = k2VarH == null ? 0 : k2VarH.i();
                int iJ = k2VarH == null ? 0 : k2VarH.j();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                if (i10 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i14 = marginLayoutParams2.height;
                        int i15 = marginLayoutParams.topMargin;
                        if (i14 != i15 || marginLayoutParams2.leftMargin != i13 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i15;
                            marginLayoutParams2.leftMargin = i13;
                            marginLayoutParams2.rightMargin = iJ;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f9993p);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i13;
                    layoutParams.rightMargin = iJ;
                    this.G.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                z12 = view3 != null;
                if (z12 && view3.getVisibility() != 0) {
                    d1(this.I);
                }
                if (!this.N && z12) {
                    iK = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.A.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.I;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return iK;
    }

    public void d0() {
        androidx.appcompat.view.menu.e eVar;
        j0 j0Var = this.f10000w;
        if (j0Var != null) {
            j0Var.i();
        }
        if (this.B != null) {
            this.f9994q.getDecorView().removeCallbacks(this.C);
            if (this.B.isShowing()) {
                try {
                    this.B.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.B = null;
        }
        g0();
        s sVarQ0 = q0(0, false);
        if (sVarQ0 == null || (eVar = sVarQ0.f10035j) == null) {
            return;
        }
        eVar.close();
    }

    public final void d1(View view) {
        Context context;
        int i10;
        if ((p0.L(view) & 8192) != 0) {
            context = this.f9993p;
            i10 = h.c.f9314b;
        } else {
            context = this.f9993p;
            i10 = h.c.f9313a;
        }
        view.setBackgroundColor(f0.a.getColor(context, i10));
    }

    @Override // i.e
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ((ViewGroup) this.G.findViewById(R.id.content)).addView(view, layoutParams);
        this.f9995r.c(this.f9994q.getCallback());
    }

    public boolean e0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f9992o;
        if (((obj instanceof p0.s.a) || (obj instanceof i.i)) && (decorView = this.f9994q.getDecorView()) != null && p0.s.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f9995r.b(this.f9994q.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? B0(keyCode, keyEvent) : E0(keyCode, keyEvent);
    }

    public void f0(int i10) {
        s sVarQ0;
        s sVarQ1 = q0(i10, true);
        if (sVarQ1.f10035j != null) {
            Bundle bundle = new Bundle();
            sVarQ1.f10035j.Q(bundle);
            if (bundle.size() > 0) {
                sVarQ1.f10044s = bundle;
            }
            sVarQ1.f10035j.d0();
            sVarQ1.f10035j.clear();
        }
        sVarQ1.f10043r = true;
        sVarQ1.f10042q = true;
        if ((i10 != 108 && i10 != 0) || this.f10000w == null || (sVarQ0 = q0(0, false)) == null) {
            return;
        }
        sVarQ0.f10038m = false;
        M0(sVarQ0, null);
    }

    @Override // i.e
    public Context g(Context context) {
        this.U = true;
        int iZ0 = z0(context, U());
        if (i.e.u(context)) {
            i.e.N(context);
        }
        l0.j jVarT = T(context);
        if (f9977s0 && (context instanceof ContextThemeWrapper)) {
            try {
                q.a((ContextThemeWrapper) context, a0(context, iZ0, jVarT, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof m.d) {
            try {
                ((m.d) context).a(a0(context, iZ0, jVarT, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f9976r0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = h.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationA0 = a0(context, iZ0, jVarT, !configuration2.equals(configuration3) ? k0(configuration2, configuration3) : null, true);
        m.d dVar = new m.d(context, h.i.f9416b);
        dVar.a(configurationA0);
        boolean z10 = false;
        try {
            z10 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z10) {
            g0.h.f.a(dVar.getTheme());
        }
        return super.g(dVar);
    }

    public void g0() {
        v1 v1Var = this.D;
        if (v1Var != null) {
            v1Var.c();
        }
    }

    public final void h0() {
        if (this.F) {
            return;
        }
        this.G = b0();
        CharSequence charSequenceR0 = r0();
        if (!TextUtils.isEmpty(charSequenceR0)) {
            j0 j0Var = this.f10000w;
            if (j0Var != null) {
                j0Var.setWindowTitle(charSequenceR0);
            } else if (K0() != null) {
                K0().s(charSequenceR0);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(charSequenceR0);
                }
            }
        }
        R();
        I0(this.G);
        this.F = true;
        s sVarQ0 = q0(0, false);
        if (this.W) {
            return;
        }
        if (sVarQ0 == null || sVarQ0.f10035j == null) {
            x0(108);
        }
    }

    public final void i0() {
        if (this.f9994q == null) {
            Object obj = this.f9992o;
            if (obj instanceof Activity) {
                S(((Activity) obj).getWindow());
            }
        }
        if (this.f9994q == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // i.e
    public <T extends View> T j(int i10) {
        h0();
        return (T) this.f9994q.findViewById(i10);
    }

    public s j0(Menu menu) {
        s[] sVarArr = this.R;
        int length = sVarArr != null ? sVarArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            s sVar = sVarArr[i10];
            if (sVar != null && sVar.f10035j == menu) {
                return sVar;
            }
        }
        return null;
    }

    @Override // i.e
    public Context l() {
        return this.f9993p;
    }

    public final Context l0() {
        i.a aVarR = r();
        Context contextJ = aVarR != null ? aVarR.j() : null;
        return contextJ == null ? this.f9993p : contextJ;
    }

    public final int m0(Context context) {
        if (!this.f9979b0 && (this.f9992o instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f9992o.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.f9978a0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.f9978a0 = 0;
            }
        }
        this.f9979b0 = true;
        return this.f9978a0;
    }

    @Override // i.e
    public int n() {
        return this.Y;
    }

    public final o n0(Context context) {
        if (this.f9981d0 == null) {
            this.f9981d0 = new n(context);
        }
        return this.f9981d0;
    }

    public final o o0(Context context) {
        if (this.f9980c0 == null) {
            this.f9980c0 = new p(i.q.a(context));
        }
        return this.f9980c0;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return c0(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // i.e
    public MenuInflater p() {
        if (this.f9998u == null) {
            t0();
            i.a aVar = this.f9997t;
            this.f9998u = new m.g(aVar != null ? aVar.j() : this.f9993p);
        }
        return this.f9998u;
    }

    public l0.j p0(Configuration configuration) {
        return j.b(configuration);
    }

    public s q0(int i10, boolean z10) {
        s[] sVarArr = this.R;
        if (sVarArr == null || sVarArr.length <= i10) {
            s[] sVarArr2 = new s[i10 + 1];
            if (sVarArr != null) {
                System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
            }
            this.R = sVarArr2;
            sVarArr = sVarArr2;
        }
        s sVar = sVarArr[i10];
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(i10);
        sVarArr[i10] = sVar2;
        return sVar2;
    }

    @Override // i.e
    public i.a r() {
        t0();
        return this.f9997t;
    }

    public final CharSequence r0() {
        Object obj = this.f9992o;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f9999v;
    }

    @Override // i.e
    public void s() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f9993p);
        if (layoutInflaterFrom.getFactory() == null) {
            p0.t.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof f) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final Window.Callback s0() {
        return this.f9994q.getCallback();
    }

    @Override // i.e
    public void t() {
        if (K0() == null || r().k()) {
            return;
        }
        x0(0);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public final void t0() {
        i.r rVar;
        i.a aVar;
        h0();
        if (this.L && this.f9997t == null) {
            Object obj = this.f9992o;
            if (!(obj instanceof Activity)) {
                if (obj instanceof Dialog) {
                    rVar = new i.r((Dialog) this.f9992o);
                }
                aVar = this.f9997t;
                if (aVar != null) {
                    aVar.q(this.f9985h0);
                }
            }
            rVar = new i.r((Activity) this.f9992o, this.M);
            this.f9997t = rVar;
            aVar = this.f9997t;
            if (aVar != null) {
                aVar.q(this.f9985h0);
            }
        }
    }

    public final boolean u0(s sVar) {
        View view = sVar.f10034i;
        if (view != null) {
            sVar.f10033h = view;
            return true;
        }
        if (sVar.f10035j == null) {
            return false;
        }
        if (this.f10002y == null) {
            this.f10002y = new t();
        }
        View view2 = (View) sVar.a(this.f10002y);
        sVar.f10033h = view2;
        return view2 != null;
    }

    public final boolean v0(s sVar) {
        sVar.d(l0());
        sVar.f10032g = new r(sVar.f10037l);
        sVar.f10028c = 81;
        return true;
    }

    @Override // i.e
    public void w(Configuration configuration) {
        i.a aVarR;
        if (this.L && this.F && (aVarR = r()) != null) {
            aVarR.l(configuration);
        }
        androidx.appcompat.widget.k.b().g(this.f9993p);
        this.X = new Configuration(this.f9993p.getResources().getConfiguration());
        P(false, false);
    }

    public final boolean w0(s sVar) {
        Resources.Theme themeNewTheme;
        Context context = this.f9993p;
        int i10 = sVar.f10026a;
        if ((i10 == 0 || i10 == 108) && this.f10000w != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(h.a.f9291f, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(h.a.f9292g, typedValue, true);
            } else {
                theme.resolveAttribute(h.a.f9292g, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                m.d dVar = new m.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        sVar.c(eVar);
        return true;
    }

    @Override // i.e
    public void x(Bundle bundle) {
        String strC;
        this.U = true;
        O(false);
        i0();
        Object obj = this.f9992o;
        if (obj instanceof Activity) {
            try {
                strC = e0.o.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                i.a aVarK0 = K0();
                if (aVarK0 == null) {
                    this.f9985h0 = true;
                } else {
                    aVarK0.q(true);
                }
            }
            i.e.d(this);
        }
        this.X = new Configuration(this.f9993p.getResources().getConfiguration());
        this.V = true;
    }

    public final void x0(int i10) {
        this.f9983f0 = (1 << i10) | this.f9983f0;
        if (this.f9982e0) {
            return;
        }
        p0.h0(this.f9994q.getDecorView(), this.f9984g0);
        this.f9982e0 = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    @Override // i.e
    public void y() {
        if (this.f9992o instanceof Activity) {
            i.e.E(this);
        }
        if (this.f9982e0) {
            this.f9994q.getDecorView().removeCallbacks(this.f9984g0);
        }
        this.W = true;
        if (this.Y != -100) {
            Object obj = this.f9992o;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f9973o0.put(this.f9992o.getClass().getName(), Integer.valueOf(this.Y));
            } else {
                f9973o0.remove(this.f9992o.getClass().getName());
            }
        } else {
            f9973o0.remove(this.f9992o.getClass().getName());
        }
        i.a aVar = this.f9997t;
        if (aVar != null) {
            aVar.m();
        }
        X();
    }

    public boolean y0() {
        return this.E;
    }

    @Override // i.e
    public void z(Bundle bundle) {
        h0();
    }

    public int z0(Context context, int i10) {
        o oVarO0;
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2) {
                    if (i10 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    oVarO0 = n0(context);
                }
            } else {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                oVarO0 = o0(context);
            }
            return oVarO0.c();
        }
        return i10;
    }
}
