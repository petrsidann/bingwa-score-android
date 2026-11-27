package f6;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import m.d;
import z4.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8172a = {R.attr.theme, b.V};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f8173b = {b.f19823w};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8172a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static int b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8173b, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i10, int i11) {
        int iB = b(context, attributeSet, i10, i11);
        boolean z10 = (context instanceof d) && ((d) context).c() == iB;
        if (iB == 0 || z10) {
            return context;
        }
        d dVar = new d(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            dVar.getTheme().applyStyle(iA, true);
        }
        return dVar;
    }
}
