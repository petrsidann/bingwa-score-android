package d;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.k0;

/* JADX INFO: loaded from: classes.dex */
public class k extends Dialog implements androidx.lifecycle.k, r, b2.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.lifecycle.l f6151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b2.e f6152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f6153c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.k.e(context, "context");
        this.f6152b = b2.e.f2757d.a(this);
        this.f6153c = new p(new Runnable() { // from class: d.j
            @Override // java.lang.Runnable
            public final void run() {
                k.e(this.f6150a);
            }
        });
    }

    public static final void e(k this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g a() {
        return c();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.k.e(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    public final androidx.lifecycle.l c() {
        androidx.lifecycle.l lVar = this.f6151a;
        if (lVar != null) {
            return lVar;
        }
        androidx.lifecycle.l lVar2 = new androidx.lifecycle.l(this);
        this.f6151a = lVar2;
        return lVar2;
    }

    public void d() {
        Window window = getWindow();
        kotlin.jvm.internal.k.b(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.k.d(decorView, "window!!.decorView");
        k0.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.k.b(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.k.d(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.k.b(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.k.d(decorView3, "window!!.decorView");
        b2.g.a(decorView3, this);
    }

    @Override // d.r
    public final p h() {
        return this.f6153c;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f6153c.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            p pVar = this.f6153c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.k.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            pVar.n(onBackInvokedDispatcher);
        }
        this.f6152b.d(bundle);
        c().h(androidx.lifecycle.g.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.k.d(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f6152b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        c().h(androidx.lifecycle.g.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        c().h(androidx.lifecycle.g.a.ON_DESTROY);
        this.f6151a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        d();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.k.e(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }

    @Override // b2.f
    public b2.d v() {
        return this.f6152b.b();
    }
}
