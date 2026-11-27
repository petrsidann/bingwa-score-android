package g0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f8438a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f8438a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006a A[PHI: r11
  0x006a: PHI (r11v9 int) = (r11v2 int), (r11v3 int) binds: [B:24:0x0068, B:27:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    public static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        float f10;
        int i10;
        int i11 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i12 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i11 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources, theme, attributeSet, d0.g.f6238b);
                int i13 = d0.g.f6239c;
                int resourceId = typedArrayH.getResourceId(i13, -1);
                if (resourceId == -1 || f(resources, resourceId)) {
                    color = typedArrayH.getColor(i13, -65281);
                } else {
                    try {
                        color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        i13 = d0.g.f6239c;
                        color = typedArrayH.getColor(i13, -65281);
                    }
                }
                int i14 = d0.g.f6240d;
                if (!typedArrayH.hasValue(i14)) {
                    i14 = d0.g.f6242f;
                    f10 = typedArrayH.hasValue(i14) ? typedArrayH.getFloat(i14, 1.0f) : 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    i10 = d0.g.f6241e;
                    if (!typedArrayH.hasValue(i10)) {
                        i10 = d0.g.f6243g;
                    }
                } else {
                    i10 = d0.g.f6243g;
                }
                float f11 = typedArrayH.getFloat(i10, -1.0f);
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i15 = 0;
                for (int i16 = 0; i16 < attributeCount; i16++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i16);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != d0.a.f6194a && attributeNameResource != d0.a.f6195b) {
                        int i17 = i15 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i16, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i15] = attributeNameResource;
                        i15 = i17;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i15);
                iArrA = g.a(iArrA, i12, g(color, f10, f11));
                iArr = (int[][]) g.b(iArr, i12, iArrTrimStateSet);
                i12++;
            }
            i11 = 1;
        }
        int[] iArr3 = new int[i12];
        int[][] iArr4 = new int[i12][];
        System.arraycopy(iArrA, 0, iArr3, 0, i12);
        System.arraycopy(iArr, 0, iArr4, 0, i12);
        return new ColorStateList(iArr4, iArr3);
    }

    public static boolean f(Resources resources, int i10) {
        TypedValue typedValueC = c();
        resources.getValue(i10, typedValueC, true);
        int i11 = typedValueC.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static int g(int i10, float f10, float f11) {
        boolean z10 = f11 >= 0.0f && f11 <= 100.0f;
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int iB = k0.a.b((int) ((Color.alpha(i10) * f10) + 0.5f), 0, 255);
        if (z10) {
            a aVarC = a.c(i10);
            i10 = a.m(aVarC.j(), aVarC.i(), f11);
        }
        return (i10 & 16777215) | (iB << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
