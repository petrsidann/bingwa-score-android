package z5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f20272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f20273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f20274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f20275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f20276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f20277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<f> f20278g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<g> f20279h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20280i;

    public class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f20281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f20282d;

        public a(List list, Matrix matrix) {
            this.f20281c = list;
            this.f20282d = matrix;
        }

        @Override // z5.m.g
        public void a(Matrix matrix, y5.a aVar, int i10, Canvas canvas) {
            Iterator it = this.f20281c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f20282d, aVar, i10, canvas);
            }
        }
    }

    public static class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f20284c;

        public b(d dVar) {
            this.f20284c = dVar;
        }

        @Override // z5.m.g
        public void a(Matrix matrix, y5.a aVar, int i10, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f20284c.k(), this.f20284c.o(), this.f20284c.l(), this.f20284c.j()), i10, this.f20284c.m(), this.f20284c.n());
        }
    }

    public static class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f20285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f20286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f20287e;

        public c(e eVar, float f10, float f11) {
            this.f20285c = eVar;
            this.f20286d = f10;
            this.f20287e = f11;
        }

        @Override // z5.m.g
        public void a(Matrix matrix, y5.a aVar, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f20285c.f20296c - this.f20287e, this.f20285c.f20295b - this.f20286d), 0.0f);
            this.f20299a.set(matrix);
            this.f20299a.preTranslate(this.f20286d, this.f20287e);
            this.f20299a.preRotate(c());
            aVar.b(canvas, this.f20299a, rectF, i10);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f20285c.f20296c - this.f20287e) / (this.f20285c.f20295b - this.f20286d)));
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f20288h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f20289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f20290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f20291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f20292e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f20293f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f20294g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        @Override // z5.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f20297a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f20288h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f20292e;
        }

        public final float k() {
            return this.f20289b;
        }

        public final float l() {
            return this.f20291d;
        }

        public final float m() {
            return this.f20293f;
        }

        public final float n() {
            return this.f20294g;
        }

        public final float o() {
            return this.f20290c;
        }

        public final void p(float f10) {
            this.f20292e = f10;
        }

        public final void q(float f10) {
            this.f20289b = f10;
        }

        public final void r(float f10) {
            this.f20291d = f10;
        }

        public final void s(float f10) {
            this.f20293f = f10;
        }

        public final void t(float f10) {
            this.f20294g = f10;
        }

        public final void u(float f10) {
            this.f20290c = f10;
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f20296c;

        @Override // z5.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f20297a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f20295b, this.f20296c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f20297a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f20298b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f20299a = new Matrix();

        public abstract void a(Matrix matrix, y5.a aVar, int i10, Canvas canvas);

        public final void b(y5.a aVar, int i10, Canvas canvas) {
            a(f20298b, aVar, i10, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f20278g.add(dVar);
        b bVar = new b(dVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public final void b(float f10) {
        if (g() == f10) {
            return;
        }
        float fG = ((f10 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f20279h.add(new b(dVar));
        p(f10);
    }

    public final void c(g gVar, float f10, float f11) {
        b(f10);
        this.f20279h.add(gVar);
        p(f11);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f20278g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20278g.get(i10).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f20280i;
    }

    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f20279h), new Matrix(matrix));
    }

    public final float g() {
        return this.f20276e;
    }

    public final float h() {
        return this.f20277f;
    }

    public float i() {
        return this.f20274c;
    }

    public float j() {
        return this.f20275d;
    }

    public float k() {
        return this.f20272a;
    }

    public float l() {
        return this.f20273b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f20295b = f10;
        eVar.f20296c = f11;
        this.f20278g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f20278g.clear();
        this.f20279h.clear();
        this.f20280i = false;
    }

    public final void p(float f10) {
        this.f20276e = f10;
    }

    public final void q(float f10) {
        this.f20277f = f10;
    }

    public final void r(float f10) {
        this.f20274c = f10;
    }

    public final void s(float f10) {
        this.f20275d = f10;
    }

    public final void t(float f10) {
        this.f20272a = f10;
    }

    public final void u(float f10) {
        this.f20273b = f10;
    }
}
