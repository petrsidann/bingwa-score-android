package d6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class p extends r {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f6398s = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f6401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f6402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View.OnClickListener f6403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View.OnFocusChangeListener f6404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0.c.b f6405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AccessibilityManager f6410p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f6411q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f6412r;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f6412r.start();
        }
    }

    public p(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.f6403i = new View.OnClickListener() { // from class: d6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6391a.J(view);
            }
        };
        this.f6404j = new View.OnFocusChangeListener() { // from class: d6.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f6392a.K(view, z10);
            }
        };
        this.f6405k = new q0.c.b() { // from class: d6.k
            @Override // q0.c.b
            public final void onTouchExplorationStateChanged(boolean z10) {
                this.f6393a.L(z10);
            }
        };
        this.f6409o = Long.MAX_VALUE;
        Context context = aVar.getContext();
        int i10 = z4.b.C;
        this.f6400f = u5.e.f(context, i10, 67);
        this.f6399e = u5.e.f(aVar.getContext(), i10, 50);
        this.f6401g = u5.e.g(aVar.getContext(), z4.b.H, a5.a.f360a);
    }

    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean zIsPopupShowing = this.f6402h.isPopupShowing();
        O(zIsPopupShowing);
        this.f6407m = zIsPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f6417d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f6406l = z10;
        r();
        if (z10) {
            return;
        }
        O(false);
        this.f6407m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        AutoCompleteTextView autoCompleteTextView = this.f6402h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        p0.z0(this.f6417d, z10 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f6407m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    public final ValueAnimator E(int i10, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f6401g);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d6.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6394a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void F() {
        this.f6412r = E(this.f6400f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f6399e, 1.0f, 0.0f);
        this.f6411q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    public final boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f6409o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    public final void O(boolean z10) {
        if (this.f6408n != z10) {
            this.f6408n = z10;
            this.f6412r.cancel();
            this.f6411q.start();
        }
    }

    public final void P() {
        this.f6402h.setOnTouchListener(new View.OnTouchListener() { // from class: d6.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f6396a.M(view, motionEvent);
            }
        });
        if (f6398s) {
            this.f6402h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: d6.o
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f6397a.N();
                }
            });
        }
        this.f6402h.setThreshold(0);
    }

    public final void Q() {
        if (this.f6402h == null) {
            return;
        }
        if (G()) {
            this.f6407m = false;
        }
        if (this.f6407m) {
            this.f6407m = false;
            return;
        }
        if (f6398s) {
            O(!this.f6408n);
        } else {
            this.f6408n = !this.f6408n;
            r();
        }
        if (!this.f6408n) {
            this.f6402h.dismissDropDown();
        } else {
            this.f6402h.requestFocus();
            this.f6402h.showDropDown();
        }
    }

    public final void R() {
        this.f6407m = true;
        this.f6409o = System.currentTimeMillis();
    }

    @Override // d6.r
    public void a(Editable editable) {
        if (this.f6410p.isTouchExplorationEnabled() && q.a(this.f6402h) && !this.f6417d.hasFocus()) {
            this.f6402h.dismissDropDown();
        }
        this.f6402h.post(new Runnable() { // from class: d6.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f6395a.H();
            }
        });
    }

    @Override // d6.r
    public int c() {
        return z4.i.f19930g;
    }

    @Override // d6.r
    public int d() {
        return f6398s ? z4.e.f19873i : z4.e.f19874j;
    }

    @Override // d6.r
    public View.OnFocusChangeListener e() {
        return this.f6404j;
    }

    @Override // d6.r
    public View.OnClickListener f() {
        return this.f6403i;
    }

    @Override // d6.r
    public q0.c.b h() {
        return this.f6405k;
    }

    @Override // d6.r
    public boolean i(int i10) {
        return i10 != 0;
    }

    @Override // d6.r
    public boolean j() {
        return true;
    }

    @Override // d6.r
    public boolean k() {
        return this.f6406l;
    }

    @Override // d6.r
    public boolean l() {
        return true;
    }

    @Override // d6.r
    public boolean m() {
        return this.f6408n;
    }

    @Override // d6.r
    public void n(EditText editText) {
        this.f6402h = D(editText);
        P();
        this.f6414a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f6410p.isTouchExplorationEnabled()) {
            p0.z0(this.f6417d, 2);
        }
        this.f6414a.setEndIconVisible(true);
    }

    @Override // d6.r
    public void o(View view, q0.p pVar) {
        if (!q.a(this.f6402h)) {
            pVar.d0(Spinner.class.getName());
        }
        if (pVar.P()) {
            pVar.n0(null);
        }
    }

    @Override // d6.r
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f6410p.isEnabled() || q.a(this.f6402h)) {
            return;
        }
        boolean z10 = accessibilityEvent.getEventType() == 32768 && this.f6408n && !this.f6402h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z10) {
            Q();
            R();
        }
    }

    @Override // d6.r
    public void s() {
        F();
        this.f6410p = (AccessibilityManager) this.f6416c.getSystemService("accessibility");
    }

    @Override // d6.r
    public boolean t() {
        return true;
    }

    @Override // d6.r
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f6402h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f6398s) {
                this.f6402h.setOnDismissListener(null);
            }
        }
    }
}
