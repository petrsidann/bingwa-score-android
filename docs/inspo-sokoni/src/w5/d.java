package w5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import z4.k;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f17624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f17625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f17626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f17631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f17632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f17633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f17634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f17635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f17636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f17637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f17638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f17639p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Typeface f17640q;

    public class a extends g0.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f17641a;

        public a(f fVar) {
            this.f17641a = fVar;
        }

        @Override // g0.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i10) {
            d.this.f17639p = true;
            this.f17641a.a(i10);
        }

        @Override // g0.h.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            d dVar = d.this;
            dVar.f17640q = Typeface.create(typeface, dVar.f17628e);
            d.this.f17639p = true;
            this.f17641a.b(d.this.f17640q, false);
        }
    }

    public class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f17644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f17645c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f17643a = context;
            this.f17644b = textPaint;
            this.f17645c = fVar;
        }

        @Override // w5.f
        public void a(int i10) {
            this.f17645c.a(i10);
        }

        @Override // w5.f
        public void b(Typeface typeface, boolean z10) {
            d.this.p(this.f17643a, this.f17644b, typeface);
            this.f17645c.b(typeface, z10);
        }
    }

    public d(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, k.Z4);
        l(typedArrayObtainStyledAttributes.getDimension(k.f19975a5, 0.0f));
        k(c.a(context, typedArrayObtainStyledAttributes, k.f19999d5));
        this.f17624a = c.a(context, typedArrayObtainStyledAttributes, k.f20007e5);
        this.f17625b = c.a(context, typedArrayObtainStyledAttributes, k.f20015f5);
        this.f17628e = typedArrayObtainStyledAttributes.getInt(k.f19991c5, 0);
        this.f17629f = typedArrayObtainStyledAttributes.getInt(k.f19983b5, 1);
        int iE = c.e(typedArrayObtainStyledAttributes, k.f20063l5, k.f20055k5);
        this.f17638o = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f17627d = typedArrayObtainStyledAttributes.getString(iE);
        this.f17630g = typedArrayObtainStyledAttributes.getBoolean(k.f20071m5, false);
        this.f17626c = c.a(context, typedArrayObtainStyledAttributes, k.f20023g5);
        this.f17631h = typedArrayObtainStyledAttributes.getFloat(k.f20031h5, 0.0f);
        this.f17632i = typedArrayObtainStyledAttributes.getFloat(k.f20039i5, 0.0f);
        this.f17633j = typedArrayObtainStyledAttributes.getFloat(k.f20047j5, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, k.f20125t3);
        int i11 = k.f20133u3;
        this.f17634k = typedArrayObtainStyledAttributes2.hasValue(i11);
        this.f17635l = typedArrayObtainStyledAttributes2.getFloat(i11, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void d() {
        Typeface typeface;
        String str;
        if (this.f17640q == null && (str = this.f17627d) != null) {
            this.f17640q = Typeface.create(str, this.f17628e);
        }
        if (this.f17640q == null) {
            int i10 = this.f17629f;
            if (i10 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i10 != 2) {
                typeface = i10 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            this.f17640q = typeface;
            this.f17640q = Typeface.create(this.f17640q, this.f17628e);
        }
    }

    public Typeface e() {
        d();
        return this.f17640q;
    }

    public Typeface f(Context context) {
        if (this.f17639p) {
            return this.f17640q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = g0.h.g(context, this.f17638o);
                this.f17640q = typefaceG;
                if (typefaceG != null) {
                    this.f17640q = Typeface.create(typefaceG, this.f17628e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f17627d, e10);
            }
        }
        d();
        this.f17639p = true;
        return this.f17640q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f17638o;
        if (i10 == 0) {
            this.f17639p = true;
        }
        if (this.f17639p) {
            fVar.b(this.f17640q, true);
            return;
        }
        try {
            g0.h.i(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f17639p = true;
            fVar.a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f17627d, e10);
            this.f17639p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f17636m;
    }

    public float j() {
        return this.f17637n;
    }

    public void k(ColorStateList colorStateList) {
        this.f17636m = colorStateList;
    }

    public void l(float f10) {
        this.f17637n = f10;
    }

    public final boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i10 = this.f17638o;
        return (i10 != 0 ? g0.h.c(context, i10) : null) != null;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f17636m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f10 = this.f17633j;
        float f11 = this.f17631h;
        float f12 = this.f17632i;
        ColorStateList colorStateList2 = this.f17626c;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = i.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f17628e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f17637n);
        if (this.f17634k) {
            textPaint.setLetterSpacing(this.f17635l);
        }
    }
}
