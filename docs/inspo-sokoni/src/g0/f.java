package g0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f8453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f8454b;

        public a(int i10, int i11) {
            this.f8453a = new int[]{i10, i11};
            this.f8454b = new float[]{0.0f, 1.0f};
        }

        public a(int i10, int i11, int i12) {
            this.f8453a = new int[]{i10, i11, i12};
            this.f8454b = new float[]{0.0f, 0.5f, 1.0f};
        }

        public a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f8453a = new int[size];
            this.f8454b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f8453a[i10] = list.get(i10).intValue();
                this.f8454b[i10] = list2.get(i10).floatValue();
            }
        }
    }

    public static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        return z10 ? new a(i10, i12, i11) : new a(i10, i11);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayI = l.i(resources, theme, attributeSet, d0.g.A);
        float f10 = l.f(typedArrayI, xmlPullParser, "startX", d0.g.J, 0.0f);
        float f11 = l.f(typedArrayI, xmlPullParser, "startY", d0.g.K, 0.0f);
        float f12 = l.f(typedArrayI, xmlPullParser, "endX", d0.g.L, 0.0f);
        float f13 = l.f(typedArrayI, xmlPullParser, "endY", d0.g.M, 0.0f);
        float f14 = l.f(typedArrayI, xmlPullParser, "centerX", d0.g.E, 0.0f);
        float f15 = l.f(typedArrayI, xmlPullParser, "centerY", d0.g.F, 0.0f);
        int iG = l.g(typedArrayI, xmlPullParser, "type", d0.g.D, 0);
        int iB = l.b(typedArrayI, xmlPullParser, "startColor", d0.g.B, 0);
        boolean zH = l.h(xmlPullParser, "centerColor");
        int iB2 = l.b(typedArrayI, xmlPullParser, "centerColor", d0.g.I, 0);
        int iB3 = l.b(typedArrayI, xmlPullParser, "endColor", d0.g.C, 0);
        int iG2 = l.g(typedArrayI, xmlPullParser, "tileMode", d0.g.H, 0);
        float f16 = l.f(typedArrayI, xmlPullParser, "gradientRadius", d0.g.G, 0.0f);
        typedArrayI.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iB, iB3, zH, iB2);
        if (iG != 1) {
            return iG != 2 ? new LinearGradient(f10, f11, f12, f13, aVarA.f8453a, aVarA.f8454b, d(iG2)) : new SweepGradient(f14, f15, aVarA.f8453a, aVarA.f8454b);
        }
        if (f16 > 0.0f) {
            return new RadialGradient(f14, f15, f16, aVarA.f8453a, aVarA.f8454b, d(iG2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    public static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayI = l.i(resources, theme, attributeSet, d0.g.N);
                int i10 = d0.g.O;
                boolean zHasValue = typedArrayI.hasValue(i10);
                int i11 = d0.g.P;
                boolean zHasValue2 = typedArrayI.hasValue(i11);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayI.getColor(i10, 0);
                float f10 = typedArrayI.getFloat(i11, 0.0f);
                typedArrayI.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f10));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    public static Shader.TileMode d(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
