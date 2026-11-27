package p0;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f13993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f13994c;

    public i0(View view, Runnable runnable) {
        this.f13992a = view;
        this.f13993b = view.getViewTreeObserver();
        this.f13994c = runnable;
    }

    public static i0 a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        i0 i0Var = new i0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(i0Var);
        view.addOnAttachStateChangeListener(i0Var);
        return i0Var;
    }

    public void b() {
        (this.f13993b.isAlive() ? this.f13993b : this.f13992a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f13992a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f13994c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f13993b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
