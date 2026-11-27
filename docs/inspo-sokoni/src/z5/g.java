package z5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements n {
    public static final String C = "g";
    public static final Paint D;
    public final RectF A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m.g[] f20182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.g[] f20183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f20184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f20186f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f20187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Path f20188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f20189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f20190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Region f20191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Region f20192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public k f20193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f20194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f20195t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y5.a f20196u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l.b f20197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l f20198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PorterDuffColorFilter f20199x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PorterDuffColorFilter f20200y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20201z;

    public class a implements l.b {
        public a() {
        }

        @Override // z5.l.b
        public void a(m mVar, Matrix matrix, int i10) {
            g.this.f20184d.set(i10 + 4, mVar.e());
            g.this.f20183c[i10] = mVar.f(matrix);
        }

        @Override // z5.l.b
        public void b(m mVar, Matrix matrix, int i10) {
            g.this.f20184d.set(i10, mVar.e());
            g.this.f20182b[i10] = mVar.f(matrix);
        }
    }

    public class b implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f20203a;

        public b(float f10) {
            this.f20203a = f10;
        }

        @Override // z5.k.c
        public z5.c a(z5.c cVar) {
            return cVar instanceof i ? cVar : new z5.b(this.f20203a, cVar);
        }
    }

    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f20205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p5.a f20206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f20207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f20208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f20209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f20210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f20211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f20212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Rect f20213i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f20214j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f20215k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f20216l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20217m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f20218n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f20219o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f20220p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f20221q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f20222r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f20223s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f20224t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f20225u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f20226v;

        public c(c cVar) {
            this.f20208d = null;
            this.f20209e = null;
            this.f20210f = null;
            this.f20211g = null;
            this.f20212h = PorterDuff.Mode.SRC_IN;
            this.f20213i = null;
            this.f20214j = 1.0f;
            this.f20215k = 1.0f;
            this.f20217m = 255;
            this.f20218n = 0.0f;
            this.f20219o = 0.0f;
            this.f20220p = 0.0f;
            this.f20221q = 0;
            this.f20222r = 0;
            this.f20223s = 0;
            this.f20224t = 0;
            this.f20225u = false;
            this.f20226v = Paint.Style.FILL_AND_STROKE;
            this.f20205a = cVar.f20205a;
            this.f20206b = cVar.f20206b;
            this.f20216l = cVar.f20216l;
            this.f20207c = cVar.f20207c;
            this.f20208d = cVar.f20208d;
            this.f20209e = cVar.f20209e;
            this.f20212h = cVar.f20212h;
            this.f20211g = cVar.f20211g;
            this.f20217m = cVar.f20217m;
            this.f20214j = cVar.f20214j;
            this.f20223s = cVar.f20223s;
            this.f20221q = cVar.f20221q;
            this.f20225u = cVar.f20225u;
            this.f20215k = cVar.f20215k;
            this.f20218n = cVar.f20218n;
            this.f20219o = cVar.f20219o;
            this.f20220p = cVar.f20220p;
            this.f20222r = cVar.f20222r;
            this.f20224t = cVar.f20224t;
            this.f20210f = cVar.f20210f;
            this.f20226v = cVar.f20226v;
            if (cVar.f20213i != null) {
                this.f20213i = new Rect(cVar.f20213i);
            }
        }

        public c(k kVar, p5.a aVar) {
            this.f20208d = null;
            this.f20209e = null;
            this.f20210f = null;
            this.f20211g = null;
            this.f20212h = PorterDuff.Mode.SRC_IN;
            this.f20213i = null;
            this.f20214j = 1.0f;
            this.f20215k = 1.0f;
            this.f20217m = 255;
            this.f20218n = 0.0f;
            this.f20219o = 0.0f;
            this.f20220p = 0.0f;
            this.f20221q = 0;
            this.f20222r = 0;
            this.f20223s = 0;
            this.f20224t = 0;
            this.f20225u = false;
            this.f20226v = Paint.Style.FILL_AND_STROKE;
            this.f20205a = kVar;
            this.f20206b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f20185e = true;
            return gVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        D = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(k.e(context, attributeSet, i10, i11).m());
    }

    public g(c cVar) {
        this.f20182b = new m.g[4];
        this.f20183c = new m.g[4];
        this.f20184d = new BitSet(8);
        this.f20186f = new Matrix();
        this.f20187l = new Path();
        this.f20188m = new Path();
        this.f20189n = new RectF();
        this.f20190o = new RectF();
        this.f20191p = new Region();
        this.f20192q = new Region();
        Paint paint = new Paint(1);
        this.f20194s = paint;
        Paint paint2 = new Paint(1);
        this.f20195t = paint2;
        this.f20196u = new y5.a();
        this.f20198w = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.A = new RectF();
        this.B = true;
        this.f20181a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        h0();
        g0(getState());
        this.f20197v = new a();
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    public static int T(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    public static g m(Context context, float f10, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(m5.a.c(context, z4.b.f19812l, g.class.getSimpleName()));
        }
        g gVar = new g();
        gVar.O(context);
        gVar.Y(colorStateList);
        gVar.X(f10);
        return gVar;
    }

    public int A() {
        c cVar = this.f20181a;
        return (int) (((double) cVar.f20223s) * Math.cos(Math.toRadians(cVar.f20224t)));
    }

    public int B() {
        return this.f20181a.f20222r;
    }

    public k C() {
        return this.f20181a.f20205a;
    }

    public ColorStateList D() {
        return this.f20181a.f20209e;
    }

    public final float E() {
        if (N()) {
            return this.f20195t.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float F() {
        return this.f20181a.f20216l;
    }

    public ColorStateList G() {
        return this.f20181a.f20211g;
    }

    public float H() {
        return this.f20181a.f20205a.r().a(s());
    }

    public float I() {
        return this.f20181a.f20205a.t().a(s());
    }

    public float J() {
        return this.f20181a.f20220p;
    }

    public float K() {
        return u() + J();
    }

    public final boolean L() {
        c cVar = this.f20181a;
        int i10 = cVar.f20221q;
        return i10 != 1 && cVar.f20222r > 0 && (i10 == 2 || V());
    }

    public final boolean M() {
        Paint.Style style = this.f20181a.f20226v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean N() {
        Paint.Style style = this.f20181a.f20226v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f20195t.getStrokeWidth() > 0.0f;
    }

    public void O(Context context) {
        this.f20181a.f20206b = new p5.a(context);
        i0();
    }

    public final void P() {
        super.invalidateSelf();
    }

    public boolean Q() {
        p5.a aVar = this.f20181a.f20206b;
        return aVar != null && aVar.d();
    }

    public boolean R() {
        return this.f20181a.f20205a.u(s());
    }

    public final void S(Canvas canvas) {
        if (L()) {
            canvas.save();
            U(canvas);
            if (this.B) {
                int iWidth = (int) (this.A.width() - getBounds().width());
                int iHeight = (int) (this.A.height() - getBounds().height());
                if (iWidth < 0 || iHeight < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.A.width()) + (this.f20181a.f20222r * 2) + iWidth, ((int) this.A.height()) + (this.f20181a.f20222r * 2) + iHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f10 = (getBounds().left - this.f20181a.f20222r) - iWidth;
                float f11 = (getBounds().top - this.f20181a.f20222r) - iHeight;
                canvas2.translate(-f10, -f11);
                n(canvas2);
                canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
                bitmapCreateBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    public final void U(Canvas canvas) {
        canvas.translate(z(), A());
    }

    public boolean V() {
        return (R() || this.f20187l.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void W(z5.c cVar) {
        setShapeAppearanceModel(this.f20181a.f20205a.x(cVar));
    }

    public void X(float f10) {
        c cVar = this.f20181a;
        if (cVar.f20219o != f10) {
            cVar.f20219o = f10;
            i0();
        }
    }

    public void Y(ColorStateList colorStateList) {
        c cVar = this.f20181a;
        if (cVar.f20208d != colorStateList) {
            cVar.f20208d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Z(float f10) {
        c cVar = this.f20181a;
        if (cVar.f20215k != f10) {
            cVar.f20215k = f10;
            this.f20185e = true;
            invalidateSelf();
        }
    }

    public void a0(int i10, int i11, int i12, int i13) {
        c cVar = this.f20181a;
        if (cVar.f20213i == null) {
            cVar.f20213i = new Rect();
        }
        this.f20181a.f20213i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void b0(float f10) {
        c cVar = this.f20181a;
        if (cVar.f20218n != f10) {
            cVar.f20218n = f10;
            i0();
        }
    }

    public void c0(float f10, int i10) {
        f0(f10);
        e0(ColorStateList.valueOf(i10));
    }

    public void d0(float f10, ColorStateList colorStateList) {
        f0(f10);
        e0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f20194s.setColorFilter(this.f20199x);
        int alpha = this.f20194s.getAlpha();
        this.f20194s.setAlpha(T(alpha, this.f20181a.f20217m));
        this.f20195t.setColorFilter(this.f20200y);
        this.f20195t.setStrokeWidth(this.f20181a.f20216l);
        int alpha2 = this.f20195t.getAlpha();
        this.f20195t.setAlpha(T(alpha2, this.f20181a.f20217m));
        if (this.f20185e) {
            i();
            g(s(), this.f20187l);
            this.f20185e = false;
        }
        S(canvas);
        if (M()) {
            o(canvas);
        }
        if (N()) {
            r(canvas);
        }
        this.f20194s.setAlpha(alpha);
        this.f20195t.setAlpha(alpha2);
    }

    public void e0(ColorStateList colorStateList) {
        c cVar = this.f20181a;
        if (cVar.f20209e != colorStateList) {
            cVar.f20209e = colorStateList;
            onStateChange(getState());
        }
    }

    public final PorterDuffColorFilter f(Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f20201z = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public void f0(float f10) {
        this.f20181a.f20216l = f10;
        invalidateSelf();
    }

    public final void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f20181a.f20214j != 1.0f) {
            this.f20186f.reset();
            Matrix matrix = this.f20186f;
            float f10 = this.f20181a.f20214j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f20186f);
        }
        path.computeBounds(this.A, true);
    }

    public final boolean g0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f20181a.f20208d == null || color2 == (colorForState2 = this.f20181a.f20208d.getColorForState(iArr, (color2 = this.f20194s.getColor())))) {
            z10 = false;
        } else {
            this.f20194s.setColor(colorForState2);
            z10 = true;
        }
        if (this.f20181a.f20209e == null || color == (colorForState = this.f20181a.f20209e.getColorForState(iArr, (color = this.f20195t.getColor())))) {
            return z10;
        }
        this.f20195t.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f20181a.f20217m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f20181a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f20181a.f20221q == 2) {
            return;
        }
        if (R()) {
            outline.setRoundRect(getBounds(), H() * this.f20181a.f20215k);
        } else {
            g(s(), this.f20187l);
            o5.c.i(outline, this.f20187l);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f20181a.f20213i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f20191p.set(getBounds());
        g(s(), this.f20187l);
        this.f20192q.setPath(this.f20187l, this.f20191p);
        this.f20191p.op(this.f20192q, Region.Op.DIFFERENCE);
        return this.f20191p;
    }

    public final void h(RectF rectF, Path path) {
        l lVar = this.f20198w;
        c cVar = this.f20181a;
        lVar.e(cVar.f20205a, cVar.f20215k, rectF, this.f20197v, path);
    }

    public final boolean h0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f20199x;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f20200y;
        c cVar = this.f20181a;
        this.f20199x = k(cVar.f20211g, cVar.f20212h, this.f20194s, true);
        c cVar2 = this.f20181a;
        this.f20200y = k(cVar2.f20210f, cVar2.f20212h, this.f20195t, false);
        c cVar3 = this.f20181a;
        if (cVar3.f20225u) {
            this.f20196u.d(cVar3.f20211g.getColorForState(getState(), 0));
        }
        return (o0.c.a(porterDuffColorFilter, this.f20199x) && o0.c.a(porterDuffColorFilter2, this.f20200y)) ? false : true;
    }

    public final void i() {
        k kVarY = C().y(new b(-E()));
        this.f20193r = kVarY;
        this.f20198w.d(kVarY, this.f20181a.f20215k, t(), this.f20188m);
    }

    public final void i0() {
        float fK = K();
        this.f20181a.f20222r = (int) Math.ceil(0.75f * fK);
        this.f20181a.f20223s = (int) Math.ceil(fK * 0.25f);
        h0();
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f20185e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f20181a.f20211g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f20181a.f20210f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f20181a.f20209e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f20181a.f20208d) != null && colorStateList4.isStateful())));
    }

    public final PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.f20201z = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? f(paint, z10) : j(colorStateList, mode, z10);
    }

    public int l(int i10) {
        float fK = K() + x();
        p5.a aVar = this.f20181a.f20206b;
        return aVar != null ? aVar.c(i10, fK) : i10;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f20181a = new c(this.f20181a);
        return this;
    }

    public final void n(Canvas canvas) {
        if (this.f20184d.cardinality() > 0) {
            Log.w(C, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f20181a.f20223s != 0) {
            canvas.drawPath(this.f20187l, this.f20196u.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f20182b[i10].b(this.f20196u, this.f20181a.f20222r, canvas);
            this.f20183c[i10].b(this.f20196u, this.f20181a.f20222r, canvas);
        }
        if (this.B) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f20187l, D);
            canvas.translate(iZ, iA);
        }
    }

    public final void o(Canvas canvas) {
        q(canvas, this.f20194s, this.f20187l, this.f20181a.f20205a, s());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f20185e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, s5.n.b
    public boolean onStateChange(int[] iArr) {
        boolean z10 = g0(iArr) || h0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f20181a.f20205a, rectF);
    }

    public final void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f20181a.f20215k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void r(Canvas canvas) {
        q(canvas, this.f20195t, this.f20188m, this.f20193r, t());
    }

    public RectF s() {
        this.f20189n.set(getBounds());
        return this.f20189n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f20181a;
        if (cVar.f20217m != i10) {
            cVar.f20217m = i10;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f20181a.f20207c = colorFilter;
        P();
    }

    @Override // z5.n
    public void setShapeAppearanceModel(k kVar) {
        this.f20181a.f20205a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f20181a.f20211g = colorStateList;
        h0();
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f20181a;
        if (cVar.f20212h != mode) {
            cVar.f20212h = mode;
            h0();
            P();
        }
    }

    public final RectF t() {
        this.f20190o.set(s());
        float fE = E();
        this.f20190o.inset(fE, fE);
        return this.f20190o;
    }

    public float u() {
        return this.f20181a.f20219o;
    }

    public ColorStateList v() {
        return this.f20181a.f20208d;
    }

    public float w() {
        return this.f20181a.f20215k;
    }

    public float x() {
        return this.f20181a.f20218n;
    }

    public int y() {
        return this.f20201z;
    }

    public int z() {
        c cVar = this.f20181a;
        return (int) (((double) cVar.f20223s) * Math.sin(Math.toRadians(cVar.f20224t)));
    }
}
