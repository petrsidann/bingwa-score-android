package v5;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.v;
import s5.p;
import t0.c;
import z4.b;
import z4.j;
import z4.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends v {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f17189l = j.f19963q;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[][] f17190m = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f17191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17192f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.K);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f17189l;
        super(f6.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayI = p.i(context2, attributeSet, k.f20069m3, i10, i11, new int[0]);
        int i12 = k.f20077n3;
        if (typedArrayI.hasValue(i12)) {
            c.d(this, w5.c.a(context2, typedArrayI, i12));
        }
        this.f17192f = typedArrayI.getBoolean(k.f20085o3, false);
        typedArrayI.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f17191e == null) {
            int iD = m5.a.d(this, b.f19805e);
            int iD2 = m5.a.d(this, b.f19808h);
            int iD3 = m5.a.d(this, b.f19812l);
            int[][] iArr = f17190m;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = m5.a.j(iD3, iD, 1.0f);
            iArr2[1] = m5.a.j(iD3, iD2, 0.54f);
            iArr2[2] = m5.a.j(iD3, iD2, 0.38f);
            iArr2[3] = m5.a.j(iD3, iD2, 0.38f);
            this.f17191e = new ColorStateList(iArr, iArr2);
        }
        return this.f17191e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17192f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f17192f = z10;
        c.d(this, z10 ? getMaterialThemeColorsTintList() : null);
    }
}
