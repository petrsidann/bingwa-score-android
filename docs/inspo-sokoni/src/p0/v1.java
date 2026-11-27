package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f14060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f14061b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f14062c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14063d = -1;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f14064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f14065b;

        public a(w1 w1Var, View view) {
            this.f14064a = w1Var;
            this.f14065b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14064a.a(this.f14065b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14064a.b(this.f14065b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f14064a.c(this.f14065b);
        }
    }

    public static class b {
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    public v1(View view) {
        this.f14060a = new WeakReference<>(view);
    }

    public v1 b(float f10) {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f14060a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public v1 f(long j10) {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public v1 g(Interpolator interpolator) {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public v1 h(w1 w1Var) {
        View view = this.f14060a.get();
        if (view != null) {
            i(view, w1Var);
        }
        return this;
    }

    public final void i(View view, w1 w1Var) {
        if (w1Var != null) {
            view.animate().setListener(new a(w1Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public v1 j(long j10) {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public v1 k(final y1 y1Var) {
        final View view = this.f14060a.get();
        if (view != null) {
            b.a(view.animate(), y1Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: p0.u1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    y1Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public v1 m(float f10) {
        View view = this.f14060a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
