package b5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f2847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f2848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VelocityTracker f2853j;

    /* JADX INFO: renamed from: b5.a$a, reason: collision with other inner class name */
    public class RunnableC0046a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f2854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f2855b;

        public RunnableC0046a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f2854a = coordinatorLayout;
            this.f2855b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f2855b == null || (overScroller = a.this.f2848e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.N(this.f2854a, this.f2855b);
                return;
            }
            a aVar = a.this;
            aVar.P(this.f2854a, this.f2855b, aVar.f2848e.getCurrY());
            p0.h0(this.f2855b, this);
        }
    }

    public a() {
        this.f2850g = -1;
        this.f2852i = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2850g = -1;
        this.f2852i = -1;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f2853j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f2853j.computeCurrentVelocity(1000);
                J(coordinatorLayout, v10, -L(v10), 0, this.f2853j.getYVelocity(this.f2850g));
                z10 = true;
            }
            this.f2849f = false;
            this.f2850g = -1;
            velocityTracker = this.f2853j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2853j = null;
            }
            velocityTracker2 = this.f2853j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f2849f) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f2850g);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            int i10 = this.f2851h - y10;
            this.f2851h = y10;
            O(coordinatorLayout, v10, i10, K(v10), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i11 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f2850g = motionEvent.getPointerId(i11);
                this.f2851h = (int) (motionEvent.getY(i11) + 0.5f);
            }
        }
        z10 = false;
        velocityTracker2 = this.f2853j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f2849f || z10;
        z10 = false;
        this.f2849f = false;
        this.f2850g = -1;
        velocityTracker = this.f2853j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2853j = null;
        }
        velocityTracker2 = this.f2853j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f2849f) {
            return true;
        }
    }

    public boolean H(V v10) {
        return false;
    }

    public final void I() {
        if (this.f2853j == null) {
            this.f2853j = VelocityTracker.obtain();
        }
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f2847d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f2847d = null;
        }
        if (this.f2848e == null) {
            this.f2848e = new OverScroller(v10.getContext());
        }
        this.f2848e.fling(0, E(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f2848e.computeScrollOffset()) {
            N(coordinatorLayout, v10);
            return false;
        }
        RunnableC0046a runnableC0046a = new RunnableC0046a(coordinatorLayout, v10);
        this.f2847d = runnableC0046a;
        p0.h0(v10, runnableC0046a);
        return true;
    }

    public int K(V v10) {
        return -v10.getHeight();
    }

    public int L(V v10) {
        return v10.getHeight();
    }

    public int M() {
        return E();
    }

    public void N(CoordinatorLayout coordinatorLayout, V v10) {
    }

    public final int O(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return Q(coordinatorLayout, v10, M() - i10, i11, i12);
    }

    public int P(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return Q(coordinatorLayout, v10, i10, Integer.MIN_VALUE, com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
    }

    public int Q(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iB;
        int iE = E();
        if (i11 == 0 || iE < i11 || iE > i12 || iE == (iB = k0.a.b(i10, i11, i12))) {
            return 0;
        }
        G(iB);
        return iE - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f2852i < 0) {
            this.f2852i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2849f) {
            int i10 = this.f2850g;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f2851h) > this.f2852i) {
                this.f2851h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2850g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = H(v10) && coordinatorLayout.B(v10, x10, y11);
            this.f2849f = z10;
            if (z10) {
                this.f2851h = y11;
                this.f2850g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f2848e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2848e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2853j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
