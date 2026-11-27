package ra;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends Activity implements e.c, androidx.lifecycle.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f15204e = View.generateViewId();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15205a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f15206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.l f15207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f15208d;

    public class a implements OnBackAnimationCallback {
        public a() {
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackCancelled() {
            d.this.F();
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            d.this.G();
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackProgressed(BackEvent backEvent) {
            d.this.V(backEvent);
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackStarted(BackEvent backEvent) {
            d.this.R(backEvent);
        }
    }

    public d() {
        this.f15208d = Build.VERSION.SDK_INT < 33 ? null : K();
        this.f15207c = new androidx.lifecycle.l(this);
    }

    @Override // ra.e.c
    public String A() {
        try {
            Bundle bundleN = N();
            if (bundleN != null) {
                return bundleN.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // ra.e.c
    public String B() {
        String dataString;
        if (O() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // ra.e.c
    public sa.j C() {
        return sa.j.a(getIntent());
    }

    @Override // ra.e.c
    public c0 D() {
        return L() == f.a.opaque ? c0.surface : c0.texture;
    }

    @Override // ra.e.c
    public d0 E() {
        return L() == f.a.opaque ? d0.opaque : d0.transparent;
    }

    public void F() {
        if (S("cancelBackGesture")) {
            this.f15206b.h();
        }
    }

    public void G() {
        if (S("commitBackGesture")) {
            this.f15206b.i();
        }
    }

    public final void H() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public final void I() {
        if (L() == f.a.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public final View J() {
        return this.f15206b.u(null, null, null, f15204e, D() == c0.surface);
    }

    public final OnBackInvokedCallback K() {
        return Build.VERSION.SDK_INT >= 34 ? new a() : new OnBackInvokedCallback() { // from class: ra.c
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                this.f15199a.onBackPressed();
            }
        };
    }

    public f.a L() {
        return getIntent().hasExtra("background_mode") ? f.a.valueOf(getIntent().getStringExtra("background_mode")) : f.a.opaque;
    }

    public io.flutter.embedding.engine.a M() {
        return this.f15206b.n();
    }

    public Bundle N() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public final boolean O() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public void P() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f15208d);
            this.f15205a = true;
        }
    }

    public void Q() {
        U();
        e eVar = this.f15206b;
        if (eVar != null) {
            eVar.J();
            this.f15206b = null;
        }
    }

    public void R(BackEvent backEvent) {
        if (S("startBackGesture")) {
            this.f15206b.L(backEvent);
        }
    }

    public final boolean S(String str) {
        StringBuilder sb2;
        String str2;
        e eVar = this.f15206b;
        if (eVar == null) {
            sb2 = new StringBuilder();
            sb2.append("FlutterActivity ");
            sb2.append(hashCode());
            sb2.append(" ");
            sb2.append(str);
            str2 = " called after release.";
        } else {
            if (eVar.o()) {
                return true;
            }
            sb2 = new StringBuilder();
            sb2.append("FlutterActivity ");
            sb2.append(hashCode());
            sb2.append(" ");
            sb2.append(str);
            str2 = " called after detach.";
        }
        sb2.append(str2);
        qa.b.g("FlutterActivity", sb2.toString());
        return false;
    }

    public final void T() {
        try {
            Bundle bundleN = N();
            if (bundleN != null) {
                int i10 = bundleN.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i10 != -1) {
                    setTheme(i10);
                }
            } else {
                qa.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            qa.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public void U() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f15208d);
            this.f15205a = false;
        }
    }

    public void V(BackEvent backEvent) {
        if (S("updateBackGestureProgress")) {
            this.f15206b.M(backEvent);
        }
    }

    @Override // ra.e.c, androidx.lifecycle.k
    public androidx.lifecycle.g a() {
        return this.f15207c;
    }

    @Override // io.flutter.plugin.platform.g.d
    public boolean b() {
        return false;
    }

    @Override // ra.e.c
    public void c() {
    }

    @Override // ra.e.c
    public void d() {
        qa.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + M() + " evicted by another attaching activity");
        e eVar = this.f15206b;
        if (eVar != null) {
            eVar.v();
            this.f15206b.w();
        }
    }

    @Override // ra.e.c
    public void e() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.plugin.platform.g.d
    public void f(boolean z10) {
        if (z10 && !this.f15205a) {
            P();
        } else {
            if (z10 || !this.f15205a) {
                return;
            }
            U();
        }
    }

    @Override // ra.e.c
    public Activity g() {
        return this;
    }

    @Override // ra.e.c
    public Context getContext() {
        return this;
    }

    @Override // ra.e.c
    public List<String> i() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // ra.e.c
    public String j() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // ra.e.c
    public boolean k() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        return j() == null;
    }

    @Override // ra.e.c
    public String l() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle bundleN = N();
            String string = bundleN != null ? bundleN.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // ra.e.c
    public io.flutter.plugin.platform.g m(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new io.flutter.plugin.platform.g(g(), aVar.p(), this);
    }

    @Override // ra.e.c
    public boolean n() {
        try {
            return f.a(N());
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // ra.e.c
    public boolean o() {
        return true;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (S("onActivityResult")) {
            this.f15206b.r(i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (S("onBackPressed")) {
            this.f15206b.t();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        T();
        super.onCreate(bundle);
        e eVar = new e(this);
        this.f15206b = eVar;
        eVar.s(this);
        this.f15206b.B(bundle);
        this.f15207c.h(androidx.lifecycle.g.a.ON_CREATE);
        I();
        setContentView(J());
        H();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (S("onDestroy")) {
            this.f15206b.v();
            this.f15206b.w();
        }
        Q();
        this.f15207c.h(androidx.lifecycle.g.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (S("onNewIntent")) {
            this.f15206b.x(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (S("onPause")) {
            this.f15206b.y();
        }
        this.f15207c.h(androidx.lifecycle.g.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (S("onPostResume")) {
            this.f15206b.z();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (S("onRequestPermissionsResult")) {
            this.f15206b.A(i10, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f15207c.h(androidx.lifecycle.g.a.ON_RESUME);
        if (S("onResume")) {
            this.f15206b.C();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (S("onSaveInstanceState")) {
            this.f15206b.D(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f15207c.h(androidx.lifecycle.g.a.ON_START);
        if (S("onStart")) {
            this.f15206b.E();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (S("onStop")) {
            this.f15206b.F();
        }
        this.f15207c.h(androidx.lifecycle.g.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (S("onTrimMemory")) {
            this.f15206b.G(i10);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (S("onUserLeaveHint")) {
            this.f15206b.H();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (S("onWindowFocusChanged")) {
            this.f15206b.I(z10);
        }
    }

    @Override // ra.e.c
    public void p(k kVar) {
    }

    @Override // ra.e.c
    public io.flutter.embedding.engine.a q(Context context) {
        return null;
    }

    public void r(io.flutter.embedding.engine.a aVar) {
        if (this.f15206b.p()) {
            return;
        }
        db.a.a(aVar);
    }

    @Override // ra.e.c
    public void s(l lVar) {
    }

    @Override // ra.e.c
    public String t() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    @Override // ra.e.c
    public String u() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle bundleN = N();
            if (bundleN != null) {
                return bundleN.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // ra.e.c
    public boolean w() {
        return true;
    }

    @Override // ra.e.c
    public boolean x() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (j() != null || this.f15206b.p()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // ra.e.c
    public boolean y() {
        return true;
    }

    @Override // ra.e.c
    public void z(io.flutter.embedding.engine.a aVar) {
    }
}
