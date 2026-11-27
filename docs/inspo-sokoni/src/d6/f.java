package d6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class f extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f6381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f6382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EditText f6383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f6384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnFocusChangeListener f6385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f6386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f6387m;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f6415b.a0(true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f6415b.a0(false);
        }
    }

    public f(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.f6384j = new View.OnClickListener() { // from class: d6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6377a.G(view);
            }
        };
        this.f6385k = new View.OnFocusChangeListener() { // from class: d6.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f6378a.H(view, z10);
            }
        };
        Context context = aVar.getContext();
        int i10 = z4.b.C;
        this.f6379e = u5.e.f(context, i10, 100);
        this.f6380f = u5.e.f(aVar.getContext(), i10, 150);
        this.f6381g = u5.e.g(aVar.getContext(), z4.b.H, a5.a.f360a);
        this.f6382h = u5.e.g(aVar.getContext(), z4.b.G, a5.a.f363d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f6417d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f6417d.setScaleX(fFloatValue);
        this.f6417d.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f6383i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    public final void A(boolean z10) {
        boolean z11 = this.f6415b.F() == z10;
        if (z10 && !this.f6386l.isRunning()) {
            this.f6387m.cancel();
            this.f6386l.start();
            if (z11) {
                this.f6386l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f6386l.cancel();
        this.f6387m.start();
        if (z11) {
            this.f6387m.end();
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f6381g);
        valueAnimatorOfFloat.setDuration(this.f6379e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d6.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6376a.E(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f6382h);
        valueAnimatorOfFloat.setDuration(this.f6380f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d6.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f6375a.F(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6386l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f6386l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f6387m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    public final boolean J() {
        EditText editText = this.f6383i;
        return editText != null && (editText.hasFocus() || this.f6417d.hasFocus()) && this.f6383i.getText().length() > 0;
    }

    @Override // d6.r
    public void a(Editable editable) {
        if (this.f6415b.w() != null) {
            return;
        }
        A(J());
    }

    @Override // d6.r
    public int c() {
        return z4.i.f19928e;
    }

    @Override // d6.r
    public int d() {
        return z4.e.f19875k;
    }

    @Override // d6.r
    public View.OnFocusChangeListener e() {
        return this.f6385k;
    }

    @Override // d6.r
    public View.OnClickListener f() {
        return this.f6384j;
    }

    @Override // d6.r
    public View.OnFocusChangeListener g() {
        return this.f6385k;
    }

    @Override // d6.r
    public void n(EditText editText) {
        this.f6383i = editText;
        this.f6414a.setEndIconVisible(J());
    }

    @Override // d6.r
    public void q(boolean z10) {
        if (this.f6415b.w() == null) {
            return;
        }
        A(z10);
    }

    @Override // d6.r
    public void s() {
        D();
    }

    @Override // d6.r
    public void u() {
        EditText editText = this.f6383i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: d6.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6373a.I();
                }
            });
        }
    }
}
