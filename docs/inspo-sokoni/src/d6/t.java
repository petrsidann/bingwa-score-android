package d6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f6421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f6422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f6423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f6424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextInputLayout f6425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f6426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f6428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Animator f6429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f6430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6432o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f6433p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f6435r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f6436s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f6439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f6440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f6442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6443z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f6445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f6446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f6447d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f6444a = i10;
            this.f6445b = textView;
            this.f6446c = i11;
            this.f6447d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            t.this.f6431n = this.f6444a;
            t.this.f6429l = null;
            TextView textView = this.f6445b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f6446c == 1 && t.this.f6435r != null) {
                    t.this.f6435r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f6447d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f6447d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f6447d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f6447d.setAlpha(0.0f);
            }
        }
    }

    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = t.this.f6425h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public t(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f6424g = context;
        this.f6425h = textInputLayout;
        this.f6430m = context.getResources().getDimensionPixelSize(z4.d.f19845g);
        int i10 = z4.b.D;
        this.f6418a = u5.e.f(context, i10, 217);
        this.f6419b = u5.e.f(context, z4.b.A, 167);
        this.f6420c = u5.e.f(context, i10, 167);
        int i11 = z4.b.F;
        this.f6421d = u5.e.g(context, i11, a5.a.f363d);
        TimeInterpolator timeInterpolator = a5.a.f360a;
        this.f6422e = u5.e.g(context, i11, timeInterpolator);
        this.f6423f = u5.e.g(context, z4.b.H, timeInterpolator);
    }

    public boolean A() {
        return this.f6434q;
    }

    public boolean B() {
        return this.f6441x;
    }

    public void C(TextView textView, int i10) {
        ViewGroup viewGroup;
        if (this.f6426i == null) {
            return;
        }
        if (!z(i10) || (viewGroup = this.f6428k) == null) {
            viewGroup = this.f6426i;
        }
        viewGroup.removeView(textView);
        int i11 = this.f6427j - 1;
        this.f6427j = i11;
        O(this.f6426i, i11);
    }

    public final void D(int i10, int i11) {
        TextView textViewM;
        TextView textViewM2;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (textViewM2 = m(i11)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i10 != 0 && (textViewM = m(i10)) != null) {
            textViewM.setVisibility(4);
            if (i10 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f6431n = i11;
    }

    public void E(int i10) {
        this.f6437t = i10;
        TextView textView = this.f6435r;
        if (textView != null) {
            p0.r0(textView, i10);
        }
    }

    public void F(CharSequence charSequence) {
        this.f6436s = charSequence;
        TextView textView = this.f6435r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void G(boolean z10) {
        if (this.f6434q == z10) {
            return;
        }
        h();
        if (z10) {
            e0 e0Var = new e0(this.f6424g);
            this.f6435r = e0Var;
            e0Var.setId(z4.f.N);
            this.f6435r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f6435r.setTypeface(typeface);
            }
            H(this.f6438u);
            I(this.f6439v);
            F(this.f6436s);
            E(this.f6437t);
            this.f6435r.setVisibility(4);
            e(this.f6435r, 0);
        } else {
            w();
            C(this.f6435r, 0);
            this.f6435r = null;
            this.f6425h.p0();
            this.f6425h.A0();
        }
        this.f6434q = z10;
    }

    public void H(int i10) {
        this.f6438u = i10;
        TextView textView = this.f6435r;
        if (textView != null) {
            this.f6425h.c0(textView, i10);
        }
    }

    public void I(ColorStateList colorStateList) {
        this.f6439v = colorStateList;
        TextView textView = this.f6435r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void J(int i10) {
        this.f6443z = i10;
        TextView textView = this.f6442y;
        if (textView != null) {
            t0.k.n(textView, i10);
        }
    }

    public void K(boolean z10) {
        if (this.f6441x == z10) {
            return;
        }
        h();
        if (z10) {
            e0 e0Var = new e0(this.f6424g);
            this.f6442y = e0Var;
            e0Var.setId(z4.f.O);
            this.f6442y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f6442y.setTypeface(typeface);
            }
            this.f6442y.setVisibility(4);
            p0.r0(this.f6442y, 1);
            J(this.f6443z);
            L(this.A);
            e(this.f6442y, 1);
            this.f6442y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f6442y, 1);
            this.f6442y = null;
            this.f6425h.p0();
            this.f6425h.A0();
        }
        this.f6441x = z10;
    }

    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f6442y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f6435r, typeface);
            M(this.f6442y, typeface);
        }
    }

    public final void O(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean P(TextView textView, CharSequence charSequence) {
        return p0.T(this.f6425h) && this.f6425h.isEnabled() && !(this.f6432o == this.f6431n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public void Q(CharSequence charSequence) {
        h();
        this.f6433p = charSequence;
        this.f6435r.setText(charSequence);
        int i10 = this.f6431n;
        if (i10 != 1) {
            this.f6432o = 1;
        }
        S(i10, this.f6432o, P(this.f6435r, charSequence));
    }

    public void R(CharSequence charSequence) {
        h();
        this.f6440w = charSequence;
        this.f6442y.setText(charSequence);
        int i10 = this.f6431n;
        if (i10 != 2) {
            this.f6432o = 2;
        }
        S(i10, this.f6432o, P(this.f6442y, charSequence));
    }

    public final void S(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f6429l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f6441x, this.f6442y, 2, i10, i11);
            i(arrayList, this.f6434q, this.f6435r, 1, i10, i11);
            a5.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
            animatorSet.start();
        } else {
            D(i10, i11);
        }
        this.f6425h.p0();
        this.f6425h.u0(z10);
        this.f6425h.A0();
    }

    public void e(TextView textView, int i10) {
        if (this.f6426i == null && this.f6428k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f6424g);
            this.f6426i = linearLayout;
            linearLayout.setOrientation(0);
            this.f6425h.addView(this.f6426i, -1, -2);
            this.f6428k = new FrameLayout(this.f6424g);
            this.f6426i.addView(this.f6428k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f6425h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f6428k.setVisibility(0);
            this.f6428k.addView(textView);
        } else {
            this.f6426i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f6426i.setVisibility(0);
        this.f6427j++;
    }

    public void f() {
        if (g()) {
            EditText editText = this.f6425h.getEditText();
            boolean zG = w5.c.g(this.f6424g);
            LinearLayout linearLayout = this.f6426i;
            int i10 = z4.d.G;
            p0.E0(linearLayout, v(zG, i10, p0.G(editText)), v(zG, z4.d.H, this.f6424g.getResources().getDimensionPixelSize(z4.d.F)), v(zG, i10, p0.F(editText)), 0);
        }
    }

    public final boolean g() {
        return (this.f6426i == null || this.f6425h.getEditText() == null) ? false : true;
    }

    public void h() {
        Animator animator = this.f6429l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void i(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        boolean z11 = false;
        if (i10 == i12 || i10 == i11) {
            ObjectAnimator objectAnimatorJ = j(textView, i12 == i10);
            if (i10 == i12 && i11 != 0) {
                z11 = true;
            }
            if (z11) {
                objectAnimatorJ.setStartDelay(this.f6420c);
            }
            list.add(objectAnimatorJ);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f6420c);
            list.add(objectAnimatorK);
        }
    }

    public final ObjectAnimator j(TextView textView, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z10 ? this.f6419b : this.f6420c);
        objectAnimatorOfFloat.setInterpolator(z10 ? this.f6422e : this.f6423f);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f6430m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f6418a);
        objectAnimatorOfFloat.setInterpolator(this.f6421d);
        return objectAnimatorOfFloat;
    }

    public boolean l() {
        return y(this.f6432o);
    }

    public final TextView m(int i10) {
        if (i10 == 1) {
            return this.f6435r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f6442y;
    }

    public int n() {
        return this.f6437t;
    }

    public CharSequence o() {
        return this.f6436s;
    }

    public CharSequence p() {
        return this.f6433p;
    }

    public int q() {
        TextView textView = this.f6435r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList r() {
        TextView textView = this.f6435r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence s() {
        return this.f6440w;
    }

    public View t() {
        return this.f6442y;
    }

    public int u() {
        TextView textView = this.f6442y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int v(boolean z10, int i10, int i11) {
        return z10 ? this.f6424g.getResources().getDimensionPixelSize(i10) : i11;
    }

    public void w() {
        this.f6433p = null;
        h();
        if (this.f6431n == 1) {
            this.f6432o = (!this.f6441x || TextUtils.isEmpty(this.f6440w)) ? 0 : 2;
        }
        S(this.f6431n, this.f6432o, P(this.f6435r, ""));
    }

    public void x() {
        h();
        int i10 = this.f6431n;
        if (i10 == 2) {
            this.f6432o = 0;
        }
        S(i10, this.f6432o, P(this.f6442y, ""));
    }

    public final boolean y(int i10) {
        return (i10 != 1 || this.f6435r == null || TextUtils.isEmpty(this.f6433p)) ? false : true;
    }

    public boolean z(int i10) {
        return i10 == 0 || i10 == 1;
    }
}
