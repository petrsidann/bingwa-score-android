package d6;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class h extends z5.g {
    public b E;

    public static final class b extends z5.g.c {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final RectF f6390w;

        public b(b bVar) {
            super(bVar);
            this.f6390w = bVar.f6390w;
        }

        public b(z5.k kVar, RectF rectF) {
            super(kVar, null);
            this.f6390w = rectF;
        }

        @Override // z5.g.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVarK0 = h.k0(this);
            hVarK0.invalidateSelf();
            return hVarK0;
        }
    }

    public static class c extends h {
        public c(b bVar) {
            super(bVar);
        }

        @Override // z5.g
        public void r(Canvas canvas) {
            if (this.E.f6390w.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.E.f6390w);
            super.r(canvas);
            canvas.restore();
        }
    }

    public h(b bVar) {
        super(bVar);
        this.E = bVar;
    }

    public static h k0(b bVar) {
        return new c(bVar);
    }

    public static h l0(z5.k kVar) {
        if (kVar == null) {
            kVar = new z5.k();
        }
        return k0(new b(kVar, new RectF()));
    }

    public boolean m0() {
        return !this.E.f6390w.isEmpty();
    }

    @Override // z5.g, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.E = new b(this.E);
        return this;
    }

    public void n0() {
        o0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void o0(float f10, float f11, float f12, float f13) {
        if (f10 == this.E.f6390w.left && f11 == this.E.f6390w.top && f12 == this.E.f6390w.right && f13 == this.E.f6390w.bottom) {
            return;
        }
        this.E.f6390w.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    public void p0(RectF rectF) {
        o0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
