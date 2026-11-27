package z5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final z5.c f20229m = new i(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f20230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f20231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f20232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f20233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z5.c f20234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z5.c f20235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z5.c f20236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z5.c f20237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f20238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f20239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f20240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f20241l;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f20242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f20243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f20244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f20245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z5.c f20246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public z5.c f20247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z5.c f20248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public z5.c f20249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public f f20250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f f20251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f f20252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public f f20253l;

        public b() {
            this.f20242a = h.b();
            this.f20243b = h.b();
            this.f20244c = h.b();
            this.f20245d = h.b();
            this.f20246e = new z5.a(0.0f);
            this.f20247f = new z5.a(0.0f);
            this.f20248g = new z5.a(0.0f);
            this.f20249h = new z5.a(0.0f);
            this.f20250i = h.c();
            this.f20251j = h.c();
            this.f20252k = h.c();
            this.f20253l = h.c();
        }

        public b(k kVar) {
            this.f20242a = h.b();
            this.f20243b = h.b();
            this.f20244c = h.b();
            this.f20245d = h.b();
            this.f20246e = new z5.a(0.0f);
            this.f20247f = new z5.a(0.0f);
            this.f20248g = new z5.a(0.0f);
            this.f20249h = new z5.a(0.0f);
            this.f20250i = h.c();
            this.f20251j = h.c();
            this.f20252k = h.c();
            this.f20253l = h.c();
            this.f20242a = kVar.f20230a;
            this.f20243b = kVar.f20231b;
            this.f20244c = kVar.f20232c;
            this.f20245d = kVar.f20233d;
            this.f20246e = kVar.f20234e;
            this.f20247f = kVar.f20235f;
            this.f20248g = kVar.f20236g;
            this.f20249h = kVar.f20237h;
            this.f20250i = kVar.f20238i;
            this.f20251j = kVar.f20239j;
            this.f20252k = kVar.f20240k;
            this.f20253l = kVar.f20241l;
        }

        public static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f20228a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f20180a;
            }
            return -1.0f;
        }

        public b A(float f10) {
            this.f20246e = new z5.a(f10);
            return this;
        }

        public b B(z5.c cVar) {
            this.f20246e = cVar;
            return this;
        }

        public b C(int i10, z5.c cVar) {
            return D(h.a(i10)).F(cVar);
        }

        public b D(d dVar) {
            this.f20243b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f10) {
            this.f20247f = new z5.a(f10);
            return this;
        }

        public b F(z5.c cVar) {
            this.f20247f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f10) {
            return A(f10).E(f10).w(f10).s(f10);
        }

        public b p(z5.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i10, z5.c cVar) {
            return r(h.a(i10)).t(cVar);
        }

        public b r(d dVar) {
            this.f20245d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        public b s(float f10) {
            this.f20249h = new z5.a(f10);
            return this;
        }

        public b t(z5.c cVar) {
            this.f20249h = cVar;
            return this;
        }

        public b u(int i10, z5.c cVar) {
            return v(h.a(i10)).x(cVar);
        }

        public b v(d dVar) {
            this.f20244c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f10) {
            this.f20248g = new z5.a(f10);
            return this;
        }

        public b x(z5.c cVar) {
            this.f20248g = cVar;
            return this;
        }

        public b y(int i10, z5.c cVar) {
            return z(h.a(i10)).B(cVar);
        }

        public b z(d dVar) {
            this.f20242a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }
    }

    public interface c {
        z5.c a(z5.c cVar);
    }

    public k() {
        this.f20230a = h.b();
        this.f20231b = h.b();
        this.f20232c = h.b();
        this.f20233d = h.b();
        this.f20234e = new z5.a(0.0f);
        this.f20235f = new z5.a(0.0f);
        this.f20236g = new z5.a(0.0f);
        this.f20237h = new z5.a(0.0f);
        this.f20238i = h.c();
        this.f20239j = h.c();
        this.f20240k = h.c();
        this.f20241l = h.c();
    }

    public k(b bVar) {
        this.f20230a = bVar.f20242a;
        this.f20231b = bVar.f20243b;
        this.f20232c = bVar.f20244c;
        this.f20233d = bVar.f20245d;
        this.f20234e = bVar.f20246e;
        this.f20235f = bVar.f20247f;
        this.f20236g = bVar.f20248g;
        this.f20237h = bVar.f20249h;
        this.f20238i = bVar.f20250i;
        this.f20239j = bVar.f20251j;
        this.f20240k = bVar.f20252k;
        this.f20241l = bVar.f20253l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    public static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new z5.a(i12));
    }

    public static b d(Context context, int i10, int i11, z5.c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(z4.k.f20062l4);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(z4.k.f20070m4, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(z4.k.f20094p4, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(z4.k.f20102q4, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(z4.k.f20086o4, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(z4.k.f20078n4, i12);
            z5.c cVarM = m(typedArrayObtainStyledAttributes, z4.k.f20110r4, cVar);
            z5.c cVarM2 = m(typedArrayObtainStyledAttributes, z4.k.f20134u4, cVarM);
            z5.c cVarM3 = m(typedArrayObtainStyledAttributes, z4.k.f20142v4, cVarM);
            z5.c cVarM4 = m(typedArrayObtainStyledAttributes, z4.k.f20126t4, cVarM);
            return new b().y(i13, cVarM2).C(i14, cVarM3).u(i15, cVarM4).q(i16, m(typedArrayObtainStyledAttributes, z4.k.f20118s4, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new z5.a(i12));
    }

    public static b g(Context context, AttributeSet attributeSet, int i10, int i11, z5.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z4.k.f20093p3, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(z4.k.f20101q3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(z4.k.f20109r3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    public static z5.c m(TypedArray typedArray, int i10, z5.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i11 = typedValuePeekValue.type;
        if (i11 == 5) {
            return new z5.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i11 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f20240k;
    }

    public d i() {
        return this.f20233d;
    }

    public z5.c j() {
        return this.f20237h;
    }

    public d k() {
        return this.f20232c;
    }

    public z5.c l() {
        return this.f20236g;
    }

    public f n() {
        return this.f20241l;
    }

    public f o() {
        return this.f20239j;
    }

    public f p() {
        return this.f20238i;
    }

    public d q() {
        return this.f20230a;
    }

    public z5.c r() {
        return this.f20234e;
    }

    public d s() {
        return this.f20231b;
    }

    public z5.c t() {
        return this.f20235f;
    }

    public boolean u(RectF rectF) {
        boolean z10 = this.f20241l.getClass().equals(f.class) && this.f20239j.getClass().equals(f.class) && this.f20238i.getClass().equals(f.class) && this.f20240k.getClass().equals(f.class);
        float fA = this.f20234e.a(rectF);
        return z10 && ((this.f20235f.a(rectF) > fA ? 1 : (this.f20235f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f20237h.a(rectF) > fA ? 1 : (this.f20237h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f20236g.a(rectF) > fA ? 1 : (this.f20236g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f20231b instanceof j) && (this.f20230a instanceof j) && (this.f20232c instanceof j) && (this.f20233d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f10) {
        return v().o(f10).m();
    }

    public k x(z5.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }
}
