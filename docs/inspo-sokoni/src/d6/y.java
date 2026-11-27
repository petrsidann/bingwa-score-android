package d6;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.h1;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class y extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f6467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f6468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f6469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f6470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f6471f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView.ScaleType f6473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View.OnLongClickListener f6474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6475o;

    public y(TextInputLayout textInputLayout, h1 h1Var) {
        super(textInputLayout.getContext());
        this.f6466a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(z4.h.f19908c, (ViewGroup) this, false);
        this.f6469d = checkableImageButton;
        s.e(checkableImageButton);
        e0 e0Var = new e0(getContext());
        this.f6467b = e0Var;
        j(h1Var);
        i(h1Var);
        addView(checkableImageButton);
        addView(e0Var);
    }

    public void A(q0.p pVar) {
        View view;
        if (this.f6467b.getVisibility() == 0) {
            pVar.o0(this.f6467b);
            view = this.f6467b;
        } else {
            view = this.f6469d;
        }
        pVar.A0(view);
    }

    public void B() {
        EditText editText = this.f6466a.f4747d;
        if (editText == null) {
            return;
        }
        p0.E0(this.f6467b, k() ? 0 : p0.G(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(z4.d.I), editText.getCompoundPaddingBottom());
    }

    public final void C() {
        int i10 = (this.f6468c == null || this.f6475o) ? 8 : 0;
        setVisibility(this.f6469d.getVisibility() == 0 || i10 == 0 ? 0 : 8);
        this.f6467b.setVisibility(i10);
        this.f6466a.o0();
    }

    public CharSequence a() {
        return this.f6468c;
    }

    public ColorStateList b() {
        return this.f6467b.getTextColors();
    }

    public int c() {
        return p0.G(this) + p0.G(this.f6467b) + (k() ? this.f6469d.getMeasuredWidth() + p0.u.a((ViewGroup.MarginLayoutParams) this.f6469d.getLayoutParams()) : 0);
    }

    public TextView d() {
        return this.f6467b;
    }

    public CharSequence e() {
        return this.f6469d.getContentDescription();
    }

    public Drawable f() {
        return this.f6469d.getDrawable();
    }

    public int g() {
        return this.f6472l;
    }

    public ImageView.ScaleType h() {
        return this.f6473m;
    }

    public final void i(h1 h1Var) {
        this.f6467b.setVisibility(8);
        this.f6467b.setId(z4.f.Q);
        this.f6467b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        p0.r0(this.f6467b, 1);
        o(h1Var.n(z4.k.f20168y6, 0));
        int i10 = z4.k.f20176z6;
        if (h1Var.s(i10)) {
            p(h1Var.c(i10));
        }
        n(h1Var.p(z4.k.f20160x6));
    }

    public final void j(h1 h1Var) {
        if (w5.c.g(getContext())) {
            p0.u.c((ViewGroup.MarginLayoutParams) this.f6469d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i10 = z4.k.F6;
        if (h1Var.s(i10)) {
            this.f6470e = w5.c.b(getContext(), h1Var, i10);
        }
        int i11 = z4.k.G6;
        if (h1Var.s(i11)) {
            this.f6471f = s5.s.i(h1Var.k(i11, -1), null);
        }
        int i12 = z4.k.C6;
        if (h1Var.s(i12)) {
            s(h1Var.g(i12));
            int i13 = z4.k.B6;
            if (h1Var.s(i13)) {
                r(h1Var.p(i13));
            }
            q(h1Var.a(z4.k.A6, true));
        }
        t(h1Var.f(z4.k.D6, getResources().getDimensionPixelSize(z4.d.Z)));
        int i14 = z4.k.E6;
        if (h1Var.s(i14)) {
            w(s.b(h1Var.k(i14, -1)));
        }
    }

    public boolean k() {
        return this.f6469d.getVisibility() == 0;
    }

    public void l(boolean z10) {
        this.f6475o = z10;
        C();
    }

    public void m() {
        s.d(this.f6466a, this.f6469d, this.f6470e);
    }

    public void n(CharSequence charSequence) {
        this.f6468c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f6467b.setText(charSequence);
        C();
    }

    public void o(int i10) {
        t0.k.n(this.f6467b, i10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        B();
    }

    public void p(ColorStateList colorStateList) {
        this.f6467b.setTextColor(colorStateList);
    }

    public void q(boolean z10) {
        this.f6469d.setCheckable(z10);
    }

    public void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f6469d.setContentDescription(charSequence);
        }
    }

    public void s(Drawable drawable) {
        this.f6469d.setImageDrawable(drawable);
        if (drawable != null) {
            s.a(this.f6466a, this.f6469d, this.f6470e, this.f6471f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    public void t(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != this.f6472l) {
            this.f6472l = i10;
            s.g(this.f6469d, i10);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        s.h(this.f6469d, onClickListener, this.f6474n);
    }

    public void v(View.OnLongClickListener onLongClickListener) {
        this.f6474n = onLongClickListener;
        s.i(this.f6469d, onLongClickListener);
    }

    public void w(ImageView.ScaleType scaleType) {
        this.f6473m = scaleType;
        s.j(this.f6469d, scaleType);
    }

    public void x(ColorStateList colorStateList) {
        if (this.f6470e != colorStateList) {
            this.f6470e = colorStateList;
            s.a(this.f6466a, this.f6469d, colorStateList, this.f6471f);
        }
    }

    public void y(PorterDuff.Mode mode) {
        if (this.f6471f != mode) {
            this.f6471f = mode;
            s.a(this.f6466a, this.f6469d, this.f6470e, mode);
        }
    }

    public void z(boolean z10) {
        if (k() != z10) {
            this.f6469d.setVisibility(z10 ? 0 : 8);
            B();
            C();
        }
    }
}
