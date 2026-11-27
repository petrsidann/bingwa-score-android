package i5;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.h1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import s5.p;
import s5.s;
import z4.e;
import z4.f;
import z4.i;
import z4.j;
import z4.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends g {
    public static final int D = j.f19962p;
    public static final int[] E = {z4.b.Q};
    public static final int[] F;
    public static final int[][] G;
    public static final int H;
    public CompoundButton.OnCheckedChangeListener A;
    public final g2.c B;
    public final g2.b C;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<c> f10500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<b> f10501f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f10502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f10506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f10507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f10508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f10510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ColorStateList f10511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PorterDuff.Mode f10512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f10514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f10516z;

    /* JADX INFO: renamed from: i5.a$a, reason: collision with other inner class name */
    public class C0173a extends g2.b {
        public C0173a() {
        }

        @Override // g2.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = a.this.f10510t;
            if (colorStateList != null) {
                i0.a.o(drawable, colorStateList);
            }
        }

        @Override // g2.b
        public void c(Drawable drawable) {
            super.c(drawable);
            a aVar = a.this;
            ColorStateList colorStateList = aVar.f10510t;
            if (colorStateList != null) {
                i0.a.n(drawable, colorStateList.getColorForState(aVar.f10514x, a.this.f10510t.getDefaultColor()));
            }
        }
    }

    public interface b {
        void a(a aVar, int i10);
    }

    public interface c {
        void a(a aVar, boolean z10);
    }

    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new C0174a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10518a;

        /* JADX INFO: renamed from: i5.a$d$a, reason: collision with other inner class name */
        public class C0174a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f10518a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }

        public /* synthetic */ d(Parcel parcel, C0173a c0173a) {
            this(parcel);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public final String a() {
            int i10 = this.f10518a;
            if (i10 != 1) {
                return i10 != 2 ? "unchecked" : "indeterminate";
            }
            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f10518a));
        }
    }

    static {
        int i10 = z4.b.P;
        F = new int[]{i10};
        G = new int[][]{new int[]{R.attr.state_enabled, i10}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        H = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z4.b.f19803c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i10) {
        int i11 = D;
        super(f6.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f10500e = new LinkedHashSet<>();
        this.f10501f = new LinkedHashSet<>();
        this.B = g2.c.a(getContext(), e.f19871g);
        this.C = new C0173a();
        Context context2 = getContext();
        this.f10507q = t0.c.a(this);
        this.f10510t = getSuperButtonTintList();
        setSupportButtonTintList(null);
        h1 h1VarJ = p.j(context2, attributeSet, k.Z2, i10, i11, new int[0]);
        this.f10508r = h1VarJ.g(k.f19989c3);
        if (this.f10507q != null && p.g(context2) && c(h1VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f10507q = j.a.b(context2, e.f19870f);
            this.f10509s = true;
            if (this.f10508r == null) {
                this.f10508r = j.a.b(context2, e.f19872h);
            }
        }
        this.f10511u = w5.c.b(context2, h1VarJ, k.f19997d3);
        this.f10512v = s.i(h1VarJ.k(k.f20005e3, -1), PorterDuff.Mode.SRC_IN);
        this.f10503m = h1VarJ.a(k.f20045j3, false);
        this.f10504n = h1VarJ.a(k.f20013f3, true);
        this.f10505o = h1VarJ.a(k.f20037i3, false);
        this.f10506p = h1VarJ.p(k.f20029h3);
        int i12 = k.f20021g3;
        if (h1VarJ.s(i12)) {
            setCheckedState(h1VarJ.k(i12, 0));
        }
        h1VarJ.w();
        e();
    }

    private String getButtonStateDescription() {
        Resources resources;
        int i10;
        int i11 = this.f10513w;
        if (i11 == 1) {
            resources = getResources();
            i10 = i.f19931h;
        } else if (i11 == 0) {
            resources = getResources();
            i10 = i.f19933j;
        } else {
            resources = getResources();
            i10 = i.f19932i;
        }
        return resources.getString(i10);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10502l == null) {
            int[][] iArr = G;
            int[] iArr2 = new int[iArr.length];
            int iD = m5.a.d(this, z4.b.f19805e);
            int iD2 = m5.a.d(this, z4.b.f19807g);
            int iD3 = m5.a.d(this, z4.b.f19812l);
            int iD4 = m5.a.d(this, z4.b.f19808h);
            iArr2[0] = m5.a.j(iD3, iD2, 1.0f);
            iArr2[1] = m5.a.j(iD3, iD, 1.0f);
            iArr2[2] = m5.a.j(iD3, iD4, 0.54f);
            iArr2[3] = m5.a.j(iD3, iD4, 0.38f);
            iArr2[4] = m5.a.j(iD3, iD4, 0.38f);
            this.f10502l = new ColorStateList(iArr, iArr2);
        }
        return this.f10502l;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f10510t;
        if (colorStateList != null) {
            return colorStateList;
        }
        return super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final boolean c(h1 h1Var) {
        return h1Var.n(k.f19973a3, 0) == H && h1Var.n(k.f19981b3, 0) == 0;
    }

    public boolean d() {
        return this.f10505o;
    }

    public final void e() {
        this.f10507q = o5.c.c(this.f10507q, this.f10510t, t0.c.c(this));
        this.f10508r = o5.c.c(this.f10508r, this.f10511u, this.f10512v);
        g();
        h();
        super.setButtonDrawable(o5.c.a(this.f10507q, this.f10508r));
        refreshDrawableState();
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 30 || this.f10516z != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    public final void g() {
        g2.c cVar;
        if (this.f10509s) {
            g2.c cVar2 = this.B;
            if (cVar2 != null) {
                cVar2.f(this.C);
                this.B.b(this.C);
            }
            Drawable drawable = this.f10507q;
            if (!(drawable instanceof AnimatedStateListDrawable) || (cVar = this.B) == null) {
                return;
            }
            int i10 = f.f19878b;
            int i11 = f.S;
            ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, cVar, false);
            ((AnimatedStateListDrawable) this.f10507q).addTransition(f.f19884h, i11, this.B, false);
        }
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f10507q;
    }

    public Drawable getButtonIconDrawable() {
        return this.f10508r;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f10511u;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f10512v;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f10510t;
    }

    public int getCheckedState() {
        return this.f10513w;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f10506p;
    }

    public final void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f10507q;
        if (drawable != null && (colorStateList2 = this.f10510t) != null) {
            i0.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f10508r;
        if (drawable2 == null || (colorStateList = this.f10511u) == null) {
            return;
        }
        i0.a.o(drawable2, colorStateList);
    }

    public final void i() {
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f10513w == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10503m && this.f10510t == null && this.f10511u == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        this.f10514x = o5.c.e(iArrOnCreateDrawableState);
        i();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f10504n || !TextUtils.isEmpty(getText()) || (drawableA = t0.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (s.g(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            i0.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f10506p));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setCheckedState(dVar.f10518a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f10518a = getCheckedState();
        return dVar;
    }

    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(j.a.b(getContext(), i10));
    }

    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f10507q = drawable;
        this.f10509s = false;
        e();
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f10508r = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(j.a.b(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f10511u == colorStateList) {
            return;
        }
        this.f10511u = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f10512v == mode) {
            return;
        }
        this.f10512v = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f10510t == colorStateList) {
            return;
        }
        this.f10510t = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f10504n = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f10513w != i10) {
            this.f10513w = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            f();
            if (this.f10515y) {
                return;
            }
            this.f10515y = true;
            LinkedHashSet<b> linkedHashSet = this.f10501f;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f10513w);
                }
            }
            if (this.f10513w != 2 && (onCheckedChangeListener = this.A) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f10515y = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        i();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f10506p = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f10505o == z10) {
            return;
        }
        this.f10505o = z10;
        refreshDrawableState();
        Iterator<c> it = this.f10500e.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f10505o);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.A = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f10516z = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f10503m = z10;
        t0.c.d(this, z10 ? getMaterialThemeColorsTintList() : null);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
