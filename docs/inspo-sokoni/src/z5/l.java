package z5;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m[] f20254a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f20255b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f20256c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f20257d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f20258e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f20259f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f20260g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f20261h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f20262i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f20263j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f20264k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20265l = true;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f20266a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i10);

        void b(m mVar, Matrix matrix, int i10);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f20267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f20268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f20269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f20270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f20271e;

        public c(k kVar, float f10, RectF rectF, b bVar, Path path) {
            this.f20270d = bVar;
            this.f20267a = kVar;
            this.f20271e = f10;
            this.f20269c = rectF;
            this.f20268b = path;
        }
    }

    public l() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f20254a[i10] = new m();
            this.f20255b[i10] = new Matrix();
            this.f20256c[i10] = new Matrix();
        }
    }

    public static l k() {
        return a.f20266a;
    }

    public final float a(int i10) {
        return ((i10 + 1) % 4) * 90;
    }

    public final void b(c cVar, int i10) {
        this.f20261h[0] = this.f20254a[i10].k();
        this.f20261h[1] = this.f20254a[i10].l();
        this.f20255b[i10].mapPoints(this.f20261h);
        Path path = cVar.f20268b;
        float[] fArr = this.f20261h;
        if (i10 == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f20254a[i10].d(this.f20255b[i10], cVar.f20268b);
        b bVar = cVar.f20270d;
        if (bVar != null) {
            bVar.b(this.f20254a[i10], this.f20255b[i10], i10);
        }
    }

    public final void c(c cVar, int i10) {
        m mVar;
        Matrix matrix;
        Path path;
        int i11 = (i10 + 1) % 4;
        this.f20261h[0] = this.f20254a[i10].i();
        this.f20261h[1] = this.f20254a[i10].j();
        this.f20255b[i10].mapPoints(this.f20261h);
        this.f20262i[0] = this.f20254a[i11].k();
        this.f20262i[1] = this.f20254a[i11].l();
        this.f20255b[i11].mapPoints(this.f20262i);
        float[] fArr = this.f20261h;
        float f10 = fArr[0];
        float[] fArr2 = this.f20262i;
        float fMax = Math.max(((float) Math.hypot(f10 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f20269c, i10);
        this.f20260g.n(0.0f, 0.0f);
        f fVarJ = j(i10, cVar.f20267a);
        fVarJ.b(fMax, fI, cVar.f20271e, this.f20260g);
        this.f20263j.reset();
        this.f20260g.d(this.f20256c[i10], this.f20263j);
        if (this.f20265l && (fVarJ.a() || l(this.f20263j, i10) || l(this.f20263j, i11))) {
            Path path2 = this.f20263j;
            path2.op(path2, this.f20259f, Path.Op.DIFFERENCE);
            this.f20261h[0] = this.f20260g.k();
            this.f20261h[1] = this.f20260g.l();
            this.f20256c[i10].mapPoints(this.f20261h);
            Path path3 = this.f20258e;
            float[] fArr3 = this.f20261h;
            path3.moveTo(fArr3[0], fArr3[1]);
            mVar = this.f20260g;
            matrix = this.f20256c[i10];
            path = this.f20258e;
        } else {
            mVar = this.f20260g;
            matrix = this.f20256c[i10];
            path = cVar.f20268b;
        }
        mVar.d(matrix, path);
        b bVar = cVar.f20270d;
        if (bVar != null) {
            bVar.a(this.f20260g, this.f20256c[i10], i10);
        }
    }

    public void d(k kVar, float f10, RectF rectF, Path path) {
        e(kVar, f10, rectF, null, path);
    }

    public void e(k kVar, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f20258e.rewind();
        this.f20259f.rewind();
        this.f20259f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            n(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f20258e.close();
        if (this.f20258e.isEmpty()) {
            return;
        }
        path.op(this.f20258e, Path.Op.UNION);
    }

    public final void f(int i10, RectF rectF, PointF pointF) {
        float f10;
        float f11;
        if (i10 != 1) {
            if (i10 != 2) {
                f10 = i10 != 3 ? rectF.right : rectF.left;
                f11 = rectF.top;
            } else {
                f10 = rectF.left;
            }
            pointF.set(f10, f11);
        }
        f10 = rectF.right;
        f11 = rectF.bottom;
        pointF.set(f10, f11);
    }

    public final z5.c g(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.l();
        }
        if (i10 != 2) {
            return i10 != 3 ? kVar.t() : kVar.r();
        }
        return kVar.j();
    }

    public final d h(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.k();
        }
        if (i10 != 2) {
            return i10 != 3 ? kVar.s() : kVar.q();
        }
        return kVar.i();
    }

    public final float i(RectF rectF, int i10) {
        float fCenterX;
        float f10;
        float[] fArr = this.f20261h;
        m mVar = this.f20254a[i10];
        fArr[0] = mVar.f20274c;
        fArr[1] = mVar.f20275d;
        this.f20255b[i10].mapPoints(fArr);
        if (i10 == 1 || i10 == 3) {
            fCenterX = rectF.centerX();
            f10 = this.f20261h[0];
        } else {
            fCenterX = rectF.centerY();
            f10 = this.f20261h[1];
        }
        return Math.abs(fCenterX - f10);
    }

    public final f j(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.h();
        }
        if (i10 != 2) {
            return i10 != 3 ? kVar.o() : kVar.p();
        }
        return kVar.n();
    }

    public final boolean l(Path path, int i10) {
        this.f20264k.reset();
        this.f20254a[i10].d(this.f20255b[i10], this.f20264k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f20264k.computeBounds(rectF, true);
        path.op(this.f20264k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void m(c cVar, int i10) {
        h(i10, cVar.f20267a).b(this.f20254a[i10], 90.0f, cVar.f20271e, cVar.f20269c, g(i10, cVar.f20267a));
        float fA = a(i10);
        this.f20255b[i10].reset();
        f(i10, cVar.f20269c, this.f20257d);
        Matrix matrix = this.f20255b[i10];
        PointF pointF = this.f20257d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f20255b[i10].preRotate(fA);
    }

    public final void n(int i10) {
        this.f20261h[0] = this.f20254a[i10].i();
        this.f20261h[1] = this.f20254a[i10].j();
        this.f20255b[i10].mapPoints(this.f20261h);
        float fA = a(i10);
        this.f20256c[i10].reset();
        Matrix matrix = this.f20256c[i10];
        float[] fArr = this.f20261h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f20256c[i10].preRotate(fA);
    }
}
