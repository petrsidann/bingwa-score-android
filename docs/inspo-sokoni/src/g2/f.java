package g2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import g0.l;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class f extends g2.e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final PorterDuff.Mode f8540p = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f8541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f8542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorFilter f8543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8545f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable.ConstantState f8546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f8547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f8548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f8549o;

    public static class b extends AbstractC0150f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // g2.f.AbstractC0150f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (l.h(xmlPullParser, "pathData")) {
                TypedArray typedArrayI = l.i(resources, theme, attributeSet, g2.a.f8513d);
                f(typedArrayI, xmlPullParser);
                typedArrayI.recycle();
            }
        }

        public final void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f8576b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f8575a = h0.i.d(string2);
            }
            this.f8577c = l.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    public static class c extends AbstractC0150f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f8550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g0.d f8551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8552g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g0.d f8553h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f8554i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f8555j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f8556k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f8557l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f8558m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Paint.Cap f8559n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Paint.Join f8560o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f8561p;

        public c() {
            this.f8552g = 0.0f;
            this.f8554i = 1.0f;
            this.f8555j = 1.0f;
            this.f8556k = 0.0f;
            this.f8557l = 1.0f;
            this.f8558m = 0.0f;
            this.f8559n = Paint.Cap.BUTT;
            this.f8560o = Paint.Join.MITER;
            this.f8561p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.f8552g = 0.0f;
            this.f8554i = 1.0f;
            this.f8555j = 1.0f;
            this.f8556k = 0.0f;
            this.f8557l = 1.0f;
            this.f8558m = 0.0f;
            this.f8559n = Paint.Cap.BUTT;
            this.f8560o = Paint.Join.MITER;
            this.f8561p = 4.0f;
            this.f8550e = cVar.f8550e;
            this.f8551f = cVar.f8551f;
            this.f8552g = cVar.f8552g;
            this.f8554i = cVar.f8554i;
            this.f8553h = cVar.f8553h;
            this.f8577c = cVar.f8577c;
            this.f8555j = cVar.f8555j;
            this.f8556k = cVar.f8556k;
            this.f8557l = cVar.f8557l;
            this.f8558m = cVar.f8558m;
            this.f8559n = cVar.f8559n;
            this.f8560o = cVar.f8560o;
            this.f8561p = cVar.f8561p;
        }

        @Override // g2.f.e
        public boolean a() {
            return this.f8553h.i() || this.f8551f.i();
        }

        @Override // g2.f.e
        public boolean b(int[] iArr) {
            return this.f8551f.j(iArr) | this.f8553h.j(iArr);
        }

        public final Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 1) {
                return i10 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        public final Paint.Join f(int i10, Paint.Join join) {
            if (i10 == 0) {
                return Paint.Join.MITER;
            }
            if (i10 != 1) {
                return i10 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayI = l.i(resources, theme, attributeSet, g2.a.f8512c);
            h(typedArrayI, xmlPullParser, theme);
            typedArrayI.recycle();
        }

        public float getFillAlpha() {
            return this.f8555j;
        }

        public int getFillColor() {
            return this.f8553h.e();
        }

        public float getStrokeAlpha() {
            return this.f8554i;
        }

        public int getStrokeColor() {
            return this.f8551f.e();
        }

        public float getStrokeWidth() {
            return this.f8552g;
        }

        public float getTrimPathEnd() {
            return this.f8557l;
        }

        public float getTrimPathOffset() {
            return this.f8558m;
        }

        public float getTrimPathStart() {
            return this.f8556k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f8550e = null;
            if (l.h(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f8576b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f8575a = h0.i.d(string2);
                }
                this.f8553h = l.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f8555j = l.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f8555j);
                this.f8559n = e(l.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f8559n);
                this.f8560o = f(l.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f8560o);
                this.f8561p = l.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f8561p);
                this.f8551f = l.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f8554i = l.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f8554i);
                this.f8552g = l.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f8552g);
                this.f8557l = l.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f8557l);
                this.f8558m = l.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f8558m);
                this.f8556k = l.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f8556k);
                this.f8577c = l.g(typedArray, xmlPullParser, "fillType", 13, this.f8577c);
            }
        }

        public void setFillAlpha(float f10) {
            this.f8555j = f10;
        }

        public void setFillColor(int i10) {
            this.f8553h.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f8554i = f10;
        }

        public void setStrokeColor(int i10) {
            this.f8551f.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f8552g = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f8557l = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f8558m = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f8556k = f10;
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f8562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f8563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f8569h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f8570i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Matrix f8571j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f8572k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int[] f8573l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f8574m;

        public d() {
            super();
            this.f8562a = new Matrix();
            this.f8563b = new ArrayList<>();
            this.f8564c = 0.0f;
            this.f8565d = 0.0f;
            this.f8566e = 0.0f;
            this.f8567f = 1.0f;
            this.f8568g = 1.0f;
            this.f8569h = 0.0f;
            this.f8570i = 0.0f;
            this.f8571j = new Matrix();
            this.f8574m = null;
        }

        public d(d dVar, t.a<String, Object> aVar) {
            AbstractC0150f bVar;
            super();
            this.f8562a = new Matrix();
            this.f8563b = new ArrayList<>();
            this.f8564c = 0.0f;
            this.f8565d = 0.0f;
            this.f8566e = 0.0f;
            this.f8567f = 1.0f;
            this.f8568g = 1.0f;
            this.f8569h = 0.0f;
            this.f8570i = 0.0f;
            Matrix matrix = new Matrix();
            this.f8571j = matrix;
            this.f8574m = null;
            this.f8564c = dVar.f8564c;
            this.f8565d = dVar.f8565d;
            this.f8566e = dVar.f8566e;
            this.f8567f = dVar.f8567f;
            this.f8568g = dVar.f8568g;
            this.f8569h = dVar.f8569h;
            this.f8570i = dVar.f8570i;
            this.f8573l = dVar.f8573l;
            String str = dVar.f8574m;
            this.f8574m = str;
            this.f8572k = dVar.f8572k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f8571j);
            ArrayList<e> arrayList = dVar.f8563b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f8563b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f8563b.add(bVar);
                    String str2 = bVar.f8576b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // g2.f.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f8563b.size(); i10++) {
                if (this.f8563b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // g2.f.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i10 = 0; i10 < this.f8563b.size(); i10++) {
                zB |= this.f8563b.get(i10).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayI = l.i(resources, theme, attributeSet, g2.a.f8511b);
            e(typedArrayI, xmlPullParser);
            typedArrayI.recycle();
        }

        public final void d() {
            this.f8571j.reset();
            this.f8571j.postTranslate(-this.f8565d, -this.f8566e);
            this.f8571j.postScale(this.f8567f, this.f8568g);
            this.f8571j.postRotate(this.f8564c, 0.0f, 0.0f);
            this.f8571j.postTranslate(this.f8569h + this.f8565d, this.f8570i + this.f8566e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f8573l = null;
            this.f8564c = l.f(typedArray, xmlPullParser, "rotation", 5, this.f8564c);
            this.f8565d = typedArray.getFloat(1, this.f8565d);
            this.f8566e = typedArray.getFloat(2, this.f8566e);
            this.f8567f = l.f(typedArray, xmlPullParser, "scaleX", 3, this.f8567f);
            this.f8568g = l.f(typedArray, xmlPullParser, "scaleY", 4, this.f8568g);
            this.f8569h = l.f(typedArray, xmlPullParser, "translateX", 6, this.f8569h);
            this.f8570i = l.f(typedArray, xmlPullParser, "translateY", 7, this.f8570i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f8574m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f8574m;
        }

        public Matrix getLocalMatrix() {
            return this.f8571j;
        }

        public float getPivotX() {
            return this.f8565d;
        }

        public float getPivotY() {
            return this.f8566e;
        }

        public float getRotation() {
            return this.f8564c;
        }

        public float getScaleX() {
            return this.f8567f;
        }

        public float getScaleY() {
            return this.f8568g;
        }

        public float getTranslateX() {
            return this.f8569h;
        }

        public float getTranslateY() {
            return this.f8570i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f8565d) {
                this.f8565d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f8566e) {
                this.f8566e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f8564c) {
                this.f8564c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f8567f) {
                this.f8567f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f8568g) {
                this.f8568g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f8569h) {
                this.f8569h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f8570i) {
                this.f8570i = f10;
                d();
            }
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: renamed from: g2.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0150f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h0.i.b[] f8575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8578d;

        public AbstractC0150f() {
            super();
            this.f8575a = null;
            this.f8577c = 0;
        }

        public AbstractC0150f(AbstractC0150f abstractC0150f) {
            super();
            this.f8575a = null;
            this.f8577c = 0;
            this.f8576b = abstractC0150f.f8576b;
            this.f8578d = abstractC0150f.f8578d;
            this.f8575a = h0.i.f(abstractC0150f.f8575a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            h0.i.b[] bVarArr = this.f8575a;
            if (bVarArr != null) {
                h0.i.b.d(bVarArr, path);
            }
        }

        public h0.i.b[] getPathData() {
            return this.f8575a;
        }

        public String getPathName() {
            return this.f8576b;
        }

        public void setPathData(h0.i.b[] bVarArr) {
            if (h0.i.b(this.f8575a, bVarArr)) {
                h0.i.j(this.f8575a, bVarArr);
            } else {
                this.f8575a = h0.i.f(bVarArr);
            }
        }
    }

    public static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Matrix f8579q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f8580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f8581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f8582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f8583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f8584e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PathMeasure f8585f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8586g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final d f8587h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f8588i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f8589j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f8590k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f8591l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8592m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f8593n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f8594o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final t.a<String, Object> f8595p;

        public g() {
            this.f8582c = new Matrix();
            this.f8588i = 0.0f;
            this.f8589j = 0.0f;
            this.f8590k = 0.0f;
            this.f8591l = 0.0f;
            this.f8592m = 255;
            this.f8593n = null;
            this.f8594o = null;
            this.f8595p = new t.a<>();
            this.f8587h = new d();
            this.f8580a = new Path();
            this.f8581b = new Path();
        }

        public g(g gVar) {
            this.f8582c = new Matrix();
            this.f8588i = 0.0f;
            this.f8589j = 0.0f;
            this.f8590k = 0.0f;
            this.f8591l = 0.0f;
            this.f8592m = 255;
            this.f8593n = null;
            this.f8594o = null;
            t.a<String, Object> aVar = new t.a<>();
            this.f8595p = aVar;
            this.f8587h = new d(gVar.f8587h, aVar);
            this.f8580a = new Path(gVar.f8580a);
            this.f8581b = new Path(gVar.f8581b);
            this.f8588i = gVar.f8588i;
            this.f8589j = gVar.f8589j;
            this.f8590k = gVar.f8590k;
            this.f8591l = gVar.f8591l;
            this.f8586g = gVar.f8586g;
            this.f8592m = gVar.f8592m;
            this.f8593n = gVar.f8593n;
            String str = gVar.f8593n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f8594o = gVar.f8594o;
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f8587h, f8579q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f8562a.set(matrix);
            dVar.f8562a.preConcat(dVar.f8571j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f8563b.size(); i12++) {
                e eVar = dVar.f8563b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f8562a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof AbstractC0150f) {
                    d(dVar, (AbstractC0150f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, AbstractC0150f abstractC0150f, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f8590k;
            float f11 = i11 / this.f8591l;
            float fMin = Math.min(f10, f11);
            Matrix matrix = dVar.f8562a;
            this.f8582c.set(matrix);
            this.f8582c.postScale(f10, f11);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            abstractC0150f.d(this.f8580a);
            Path path = this.f8580a;
            this.f8581b.reset();
            if (abstractC0150f.c()) {
                this.f8581b.setFillType(abstractC0150f.f8577c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f8581b.addPath(path, this.f8582c);
                canvas.clipPath(this.f8581b);
                return;
            }
            c cVar = (c) abstractC0150f;
            float f12 = cVar.f8556k;
            if (f12 != 0.0f || cVar.f8557l != 1.0f) {
                float f13 = cVar.f8558m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f8557l + f13) % 1.0f;
                if (this.f8585f == null) {
                    this.f8585f = new PathMeasure();
                }
                this.f8585f.setPath(this.f8580a, false);
                float length = this.f8585f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f8585f.getSegment(f16, length, path, true);
                    this.f8585f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f8585f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f8581b.addPath(path, this.f8582c);
            if (cVar.f8553h.l()) {
                g0.d dVar2 = cVar.f8553h;
                if (this.f8584e == null) {
                    Paint paint = new Paint(1);
                    this.f8584e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f8584e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f8582c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f8555j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(f.a(dVar2.e(), cVar.f8555j));
                }
                paint2.setColorFilter(colorFilter);
                this.f8581b.setFillType(cVar.f8577c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f8581b, paint2);
            }
            if (cVar.f8551f.l()) {
                g0.d dVar3 = cVar.f8551f;
                if (this.f8583d == null) {
                    Paint paint3 = new Paint(1);
                    this.f8583d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f8583d;
                Paint.Join join = cVar.f8560o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f8559n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f8561p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f8582c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f8554i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(f.a(dVar3.e(), cVar.f8554i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f8552g * fMin * fE);
                canvas.drawPath(this.f8581b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f8594o == null) {
                this.f8594o = Boolean.valueOf(this.f8587h.a());
            }
            return this.f8594o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f8587h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f8592m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f8592m = i10;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f8597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f8598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f8599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f8601f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f8602g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f8603h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8604i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8605j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8606k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Paint f8607l;

        public h() {
            this.f8598c = null;
            this.f8599d = f.f8540p;
            this.f8597b = new g();
        }

        public h(h hVar) {
            this.f8598c = null;
            this.f8599d = f.f8540p;
            if (hVar != null) {
                this.f8596a = hVar.f8596a;
                g gVar = new g(hVar.f8597b);
                this.f8597b = gVar;
                if (hVar.f8597b.f8584e != null) {
                    gVar.f8584e = new Paint(hVar.f8597b.f8584e);
                }
                if (hVar.f8597b.f8583d != null) {
                    this.f8597b.f8583d = new Paint(hVar.f8597b.f8583d);
                }
                this.f8598c = hVar.f8598c;
                this.f8599d = hVar.f8599d;
                this.f8600e = hVar.f8600e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f8601f.getWidth() && i11 == this.f8601f.getHeight();
        }

        public boolean b() {
            return !this.f8606k && this.f8602g == this.f8598c && this.f8603h == this.f8599d && this.f8605j == this.f8600e && this.f8604i == this.f8597b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f8601f == null || !a(i10, i11)) {
                this.f8601f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f8606k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f8601f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f8607l == null) {
                Paint paint = new Paint();
                this.f8607l = paint;
                paint.setFilterBitmap(true);
            }
            this.f8607l.setAlpha(this.f8597b.getRootAlpha());
            this.f8607l.setColorFilter(colorFilter);
            return this.f8607l;
        }

        public boolean f() {
            return this.f8597b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f8597b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8596a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f8597b.g(iArr);
            this.f8606k |= zG;
            return zG;
        }

        public void i() {
            this.f8602g = this.f8598c;
            this.f8603h = this.f8599d;
            this.f8604i = this.f8597b.getRootAlpha();
            this.f8605j = this.f8600e;
            this.f8606k = false;
        }

        public void j(int i10, int i11) {
            this.f8601f.eraseColor(0);
            this.f8597b.b(new Canvas(this.f8601f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f8608a;

        public i(Drawable.ConstantState constantState) {
            this.f8608a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f8608a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8608a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f8539a = (VectorDrawable) this.f8608a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f8539a = (VectorDrawable) this.f8608a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f8539a = (VectorDrawable) this.f8608a.newDrawable(resources, theme);
            return fVar;
        }
    }

    public f() {
        this.f8545f = true;
        this.f8547m = new float[9];
        this.f8548n = new Matrix();
        this.f8549o = new Rect();
        this.f8541b = new h();
    }

    public f(h hVar) {
        this.f8545f = true;
        this.f8547m = new float[9];
        this.f8548n = new Matrix();
        this.f8549o = new Rect();
        this.f8541b = hVar;
        this.f8542c = i(this.f8542c, hVar.f8598c, hVar.f8599d);
    }

    public static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static f b(Resources resources, int i10, Resources.Theme theme) {
        f fVar = new f();
        fVar.f8539a = g0.h.e(resources, i10, theme);
        fVar.f8546l = new i(fVar.f8539a.getConstantState());
        return fVar;
    }

    public static PorterDuff.Mode f(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public Object c(String str) {
        return this.f8541b.f8597b.f8595p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f8539a;
        if (drawable == null) {
            return false;
        }
        i0.a.b(drawable);
        return false;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i10;
        int i11;
        h hVar = this.f8541b;
        g gVar = hVar.f8597b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f8587h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f8563b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f8595p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f8596a = cVar.f8578d | hVar.f8596a;
                    z10 = false;
                } else {
                    if ("clip-path".equals(name)) {
                        b bVar = new b();
                        bVar.e(resources, attributeSet, theme, xmlPullParser);
                        dVar.f8563b.add(bVar);
                        if (bVar.getPathName() != null) {
                            gVar.f8595p.put(bVar.getPathName(), bVar);
                        }
                        i10 = hVar.f8596a;
                        i11 = bVar.f8578d;
                    } else if ("group".equals(name)) {
                        d dVar2 = new d();
                        dVar2.c(resources, attributeSet, theme, xmlPullParser);
                        dVar.f8563b.add(dVar2);
                        arrayDeque.push(dVar2);
                        if (dVar2.getGroupName() != null) {
                            gVar.f8595p.put(dVar2.getGroupName(), dVar2);
                        }
                        i10 = hVar.f8596a;
                        i11 = dVar2.f8572k;
                    }
                    hVar.f8596a = i11 | i10;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f8549o);
        if (this.f8549o.width() <= 0 || this.f8549o.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f8543d;
        if (colorFilter == null) {
            colorFilter = this.f8542c;
        }
        canvas.getMatrix(this.f8548n);
        this.f8548n.getValues(this.f8547m);
        float fAbs = Math.abs(this.f8547m[0]);
        float fAbs2 = Math.abs(this.f8547m[4]);
        float fAbs3 = Math.abs(this.f8547m[1]);
        float fAbs4 = Math.abs(this.f8547m[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f8549o.width() * fAbs);
        int iHeight = (int) (this.f8549o.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f8549o;
        canvas.translate(rect.left, rect.top);
        if (e()) {
            canvas.translate(this.f8549o.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f8549o.offsetTo(0, 0);
        this.f8541b.c(iMin, iMin2);
        if (!this.f8545f) {
            this.f8541b.j(iMin, iMin2);
        } else if (!this.f8541b.b()) {
            this.f8541b.j(iMin, iMin2);
            this.f8541b.i();
        }
        this.f8541b.d(canvas, colorFilter, this.f8549o);
        canvas.restoreToCount(iSave);
    }

    public final boolean e() {
        return isAutoMirrored() && i0.a.f(this) == 1;
    }

    public void g(boolean z10) {
        this.f8545f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.d(drawable) : this.f8541b.f8597b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f8541b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.e(drawable) : this.f8543d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f8539a != null) {
            return new i(this.f8539a.getConstantState());
        }
        this.f8541b.f8596a = getChangingConfigurations();
        return this.f8541b;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f8541b.f8597b.f8589j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f8541b.f8597b.f8588i;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f8541b;
        g gVar = hVar.f8597b;
        hVar.f8599d = f(l.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = l.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f8598c = colorStateListC;
        }
        hVar.f8600e = l.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f8600e);
        gVar.f8590k = l.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f8590k);
        float f10 = l.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f8591l);
        gVar.f8591l = f10;
        if (gVar.f8590k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f8588i = typedArray.getDimension(3, gVar.f8588i);
        float dimension = typedArray.getDimension(2, gVar.f8589j);
        gVar.f8589j = dimension;
        if (gVar.f8588i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(l.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f8593n = string;
            gVar.f8595p.put(string, gVar);
        }
    }

    public PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f8541b;
        hVar.f8597b = new g();
        TypedArray typedArrayI = l.i(resources, theme, attributeSet, g2.a.f8510a);
        h(typedArrayI, xmlPullParser, theme);
        typedArrayI.recycle();
        hVar.f8596a = getChangingConfigurations();
        hVar.f8606k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f8542c = i(this.f8542c, hVar.f8598c, hVar.f8599d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.h(drawable) : this.f8541b.f8600e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f8541b) != null && (hVar.g() || ((colorStateList = this.f8541b.f8598c) != null && colorStateList.isStateful())));
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f8544e && super.mutate() == this) {
            this.f8541b = new h(this.f8541b);
            this.f8544e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f8541b;
        ColorStateList colorStateList = hVar.f8598c;
        if (colorStateList == null || (mode = hVar.f8599d) == null) {
            z10 = false;
        } else {
            this.f8542c = i(this.f8542c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f8541b.f8597b.getRootAlpha() != i10) {
            this.f8541b.f8597b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.j(drawable, z10);
        } else {
            this.f8541b.f8600e = z10;
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8543d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f8541b;
        if (hVar.f8598c != colorStateList) {
            hVar.f8598c = colorStateList;
            this.f8542c = i(this.f8542c, colorStateList, hVar.f8599d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.p(drawable, mode);
            return;
        }
        h hVar = this.f8541b;
        if (hVar.f8599d != mode) {
            hVar.f8599d = mode;
            this.f8542c = i(this.f8542c, hVar.f8598c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
