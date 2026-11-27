package d6;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.q0;
import com.google.android.material.textfield.TextInputLayout;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class u extends androidx.appcompat.widget.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f6450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AccessibilityManager f6451f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f6452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f6453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f6454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f6455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ColorStateList f6457q;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            u uVar = u.this;
            u.this.j(i10 < 0 ? uVar.f6450e.v() : uVar.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = u.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = u.this.f6450e.y();
                    i10 = u.this.f6450e.x();
                    j10 = u.this.f6450e.w();
                }
                onItemClickListener.onItemClick(u.this.f6450e.j(), view, i10, j10);
            }
            u.this.f6450e.dismiss();
        }
    }

    public class b<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ColorStateList f6459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorStateList f6460b;

        public b(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        public final ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{m5.a.i(u.this.f6456p, u.this.f6457q.getColorForState(iArr2, 0)), m5.a.i(u.this.f6456p, u.this.f6457q.getColorForState(iArr, 0)), u.this.f6456p});
        }

        public final Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(u.this.f6456p);
            if (this.f6460b == null) {
                return colorDrawable;
            }
            i0.a.o(colorDrawable, this.f6459a);
            return new RippleDrawable(this.f6460b, colorDrawable, null);
        }

        public final boolean c() {
            return u.this.f6456p != 0;
        }

        public final boolean d() {
            return u.this.f6457q != null;
        }

        public final ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{u.this.f6457q.getColorForState(iArr, 0), 0});
        }

        public void f() {
            this.f6460b = e();
            this.f6459a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                p0.t0(textView, u.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z4.b.f19801a);
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(f6.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f6452l = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = s5.p.i(context2, attributeSet, z4.k.V1, i10, z4.j.f19948b, new int[0]);
        int i11 = z4.k.W1;
        if (typedArrayI.hasValue(i11) && typedArrayI.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f6453m = typedArrayI.getResourceId(z4.k.Z1, z4.h.f19915j);
        this.f6454n = typedArrayI.getDimensionPixelOffset(z4.k.X1, z4.d.X);
        int i12 = z4.k.Y1;
        if (typedArrayI.hasValue(i12)) {
            this.f6455o = ColorStateList.valueOf(typedArrayI.getColor(i12, 0));
        }
        this.f6456p = typedArrayI.getColor(z4.k.f19972a2, 0);
        this.f6457q = w5.c.a(context2, typedArrayI, z4.k.f19980b2);
        this.f6451f = (AccessibilityManager) context2.getSystemService("accessibility");
        q0 q0Var = new q0(context2);
        this.f6450e = q0Var;
        q0Var.J(true);
        q0Var.D(this);
        q0Var.I(2);
        q0Var.p(getAdapter());
        q0Var.L(new a());
        int i13 = z4.k.f19988c2;
        if (typedArrayI.hasValue(i13)) {
            setSimpleItems(typedArrayI.getResourceId(i13, 0));
        }
        typedArrayI.recycle();
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f6450e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public final TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean g() {
        AccessibilityManager accessibilityManager = this.f6451f;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f6455o;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutF = f();
        return (textInputLayoutF == null || !textInputLayoutF.R()) ? super.getHint() : textInputLayoutF.getHint();
    }

    public float getPopupElevation() {
        return this.f6454n;
    }

    public int getSimpleItemSelectedColor() {
        return this.f6456p;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f6457q;
    }

    public final int h() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutF = f();
        int i10 = 0;
        if (adapter == null || textInputLayoutF == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f6450e.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutF);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableI = this.f6450e.i();
        if (drawableI != null) {
            drawableI.getPadding(this.f6452l);
            Rect rect = this.f6452l;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutF.getEndIconView().getMeasuredWidth();
    }

    public final void i() {
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null) {
            textInputLayoutF.r0();
        }
    }

    public final <T extends ListAdapter & Filterable> void j(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null && textInputLayoutF.R() && super.getHint() == null && s5.i.b()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6450e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), h()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f6450e.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        q0 q0Var = this.f6450e;
        if (q0Var != null) {
            q0Var.c(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f6455o = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof z5.g) {
            ((z5.g) dropDownBackground).Y(this.f6455o);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f6450e.M(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        i();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f6456p = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f6457q = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f6453m, strArr));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f6450e.a();
        } else {
            super.showDropDown();
        }
    }
}
