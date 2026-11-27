package e6;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.e0;
import w5.b;
import w5.c;
import z4.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends e0 {
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(f6.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        u(attributeSet, i10, 0);
    }

    public static boolean s(Context context) {
        return b.b(context, z4.b.T, true);
    }

    public static int t(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f20157x3, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k.f20165y3, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int v(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i10 = 0; i10 < iArr.length && iC < 0; i10++) {
            iC = c.c(context, typedArray, iArr[i10], -1);
        }
        return iC;
    }

    public static boolean w(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f20157x3, i10, i11);
        int iV = v(context, typedArrayObtainStyledAttributes, k.f20173z3, k.A3);
        typedArrayObtainStyledAttributes.recycle();
        return iV != -1;
    }

    public final void r(Resources.Theme theme, int i10) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, k.f20125t3);
        int iV = v(getContext(), typedArrayObtainStyledAttributes, k.f20141v3, k.f20149w3);
        typedArrayObtainStyledAttributes.recycle();
        if (iV >= 0) {
            setLineHeight(iV);
        }
    }

    @Override // androidx.appcompat.widget.e0, android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (s(context)) {
            r(context.getTheme(), i10);
        }
    }

    public final void u(AttributeSet attributeSet, int i10, int i11) {
        int iT;
        Context context = getContext();
        if (s(context)) {
            Resources.Theme theme = context.getTheme();
            if (w(context, theme, attributeSet, i10, i11) || (iT = t(theme, attributeSet, i10, i11)) == -1) {
                return;
            }
            r(theme, iT);
        }
    }
}
