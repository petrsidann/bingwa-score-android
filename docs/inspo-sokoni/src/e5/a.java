package e5;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import p0.p0;
import s5.s;
import w5.c;
import z4.b;
import z5.g;
import z5.k;
import z5.n;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f6996u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f6997v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f6998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f6999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f7006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f7007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f7008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f7009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f7010m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7014q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LayerDrawable f7016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7017t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7011n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7012o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7013p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7015r = true;

    public a(MaterialButton materialButton, k kVar) {
        this.f6998a = materialButton;
        this.f6999b = kVar;
    }

    public void A(boolean z10) {
        this.f7011n = z10;
        J();
    }

    public void B(ColorStateList colorStateList) {
        if (this.f7008k != colorStateList) {
            this.f7008k = colorStateList;
            J();
        }
    }

    public void C(int i10) {
        if (this.f7005h != i10) {
            this.f7005h = i10;
            J();
        }
    }

    public void D(ColorStateList colorStateList) {
        if (this.f7007j != colorStateList) {
            this.f7007j = colorStateList;
            if (f() != null) {
                i0.a.o(f(), this.f7007j);
            }
        }
    }

    public void E(PorterDuff.Mode mode) {
        if (this.f7006i != mode) {
            this.f7006i = mode;
            if (f() == null || this.f7006i == null) {
                return;
            }
            i0.a.p(f(), this.f7006i);
        }
    }

    public void F(boolean z10) {
        this.f7015r = z10;
    }

    public final void G(int i10, int i11) {
        int iG = p0.G(this.f6998a);
        int paddingTop = this.f6998a.getPaddingTop();
        int iF = p0.F(this.f6998a);
        int paddingBottom = this.f6998a.getPaddingBottom();
        int i12 = this.f7002e;
        int i13 = this.f7003f;
        this.f7003f = i11;
        this.f7002e = i10;
        if (!this.f7012o) {
            H();
        }
        p0.E0(this.f6998a, iG, (paddingTop + i10) - i12, iF, (paddingBottom + i11) - i13);
    }

    public final void H() {
        this.f6998a.setInternalBackground(a());
        g gVarF = f();
        if (gVarF != null) {
            gVarF.X(this.f7017t);
            gVarF.setState(this.f6998a.getDrawableState());
        }
    }

    public final void I(k kVar) {
        if (f6997v && !this.f7012o) {
            int iG = p0.G(this.f6998a);
            int paddingTop = this.f6998a.getPaddingTop();
            int iF = p0.F(this.f6998a);
            int paddingBottom = this.f6998a.getPaddingBottom();
            H();
            p0.E0(this.f6998a, iG, paddingTop, iF, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    public final void J() {
        g gVarF = f();
        g gVarN = n();
        if (gVarF != null) {
            gVarF.d0(this.f7005h, this.f7008k);
            if (gVarN != null) {
                gVarN.c0(this.f7005h, this.f7011n ? m5.a.d(this.f6998a, b.f19812l) : 0);
            }
        }
    }

    public final InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f7000c, this.f7002e, this.f7001d, this.f7003f);
    }

    public final Drawable a() {
        g gVar = new g(this.f6999b);
        gVar.O(this.f6998a.getContext());
        i0.a.o(gVar, this.f7007j);
        PorterDuff.Mode mode = this.f7006i;
        if (mode != null) {
            i0.a.p(gVar, mode);
        }
        gVar.d0(this.f7005h, this.f7008k);
        g gVar2 = new g(this.f6999b);
        gVar2.setTint(0);
        gVar2.c0(this.f7005h, this.f7011n ? m5.a.d(this.f6998a, b.f19812l) : 0);
        if (f6996u) {
            g gVar3 = new g(this.f6999b);
            this.f7010m = gVar3;
            i0.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(x5.b.a(this.f7009l), K(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f7010m);
            this.f7016s = rippleDrawable;
            return rippleDrawable;
        }
        x5.a aVar = new x5.a(this.f6999b);
        this.f7010m = aVar;
        i0.a.o(aVar, x5.b.a(this.f7009l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f7010m});
        this.f7016s = layerDrawable;
        return K(layerDrawable);
    }

    public int b() {
        return this.f7004g;
    }

    public int c() {
        return this.f7003f;
    }

    public int d() {
        return this.f7002e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f7016s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.f7016s.getNumberOfLayers() > 2 ? this.f7016s.getDrawable(2) : this.f7016s.getDrawable(1));
    }

    public g f() {
        return g(false);
    }

    public final g g(boolean z10) {
        LayerDrawable layerDrawable = this.f7016s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (f6996u ? (LayerDrawable) ((InsetDrawable) this.f7016s.getDrawable(0)).getDrawable() : this.f7016s).getDrawable(!z10 ? 1 : 0);
    }

    public ColorStateList h() {
        return this.f7009l;
    }

    public k i() {
        return this.f6999b;
    }

    public ColorStateList j() {
        return this.f7008k;
    }

    public int k() {
        return this.f7005h;
    }

    public ColorStateList l() {
        return this.f7007j;
    }

    public PorterDuff.Mode m() {
        return this.f7006i;
    }

    public final g n() {
        return g(true);
    }

    public boolean o() {
        return this.f7012o;
    }

    public boolean p() {
        return this.f7014q;
    }

    public boolean q() {
        return this.f7015r;
    }

    public void r(TypedArray typedArray) {
        this.f7000c = typedArray.getDimensionPixelOffset(z4.k.f20012f2, 0);
        this.f7001d = typedArray.getDimensionPixelOffset(z4.k.f20020g2, 0);
        this.f7002e = typedArray.getDimensionPixelOffset(z4.k.f20028h2, 0);
        this.f7003f = typedArray.getDimensionPixelOffset(z4.k.f20036i2, 0);
        int i10 = z4.k.f20068m2;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f7004g = dimensionPixelSize;
            z(this.f6999b.w(dimensionPixelSize));
            this.f7013p = true;
        }
        this.f7005h = typedArray.getDimensionPixelSize(z4.k.f20148w2, 0);
        this.f7006i = s.i(typedArray.getInt(z4.k.f20060l2, -1), PorterDuff.Mode.SRC_IN);
        this.f7007j = c.a(this.f6998a.getContext(), typedArray, z4.k.f20052k2);
        this.f7008k = c.a(this.f6998a.getContext(), typedArray, z4.k.f20140v2);
        this.f7009l = c.a(this.f6998a.getContext(), typedArray, z4.k.f20132u2);
        this.f7014q = typedArray.getBoolean(z4.k.f20044j2, false);
        this.f7017t = typedArray.getDimensionPixelSize(z4.k.f20076n2, 0);
        this.f7015r = typedArray.getBoolean(z4.k.f20156x2, true);
        int iG = p0.G(this.f6998a);
        int paddingTop = this.f6998a.getPaddingTop();
        int iF = p0.F(this.f6998a);
        int paddingBottom = this.f6998a.getPaddingBottom();
        if (typedArray.hasValue(z4.k.f20004e2)) {
            t();
        } else {
            H();
        }
        p0.E0(this.f6998a, iG + this.f7000c, paddingTop + this.f7002e, iF + this.f7001d, paddingBottom + this.f7003f);
    }

    public void s(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    public void t() {
        this.f7012o = true;
        this.f6998a.setSupportBackgroundTintList(this.f7007j);
        this.f6998a.setSupportBackgroundTintMode(this.f7006i);
    }

    public void u(boolean z10) {
        this.f7014q = z10;
    }

    public void v(int i10) {
        if (this.f7013p && this.f7004g == i10) {
            return;
        }
        this.f7004g = i10;
        this.f7013p = true;
        z(this.f6999b.w(i10));
    }

    public void w(int i10) {
        G(this.f7002e, i10);
    }

    public void x(int i10) {
        G(i10, this.f7003f);
    }

    public void y(ColorStateList colorStateList) {
        if (this.f7009l != colorStateList) {
            this.f7009l = colorStateList;
            boolean z10 = f6996u;
            if (z10 && (this.f6998a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f6998a.getBackground()).setColor(x5.b.a(colorStateList));
            } else {
                if (z10 || !(this.f6998a.getBackground() instanceof x5.a)) {
                    return;
                }
                ((x5.a) this.f6998a.getBackground()).setTintList(x5.b.a(colorStateList));
            }
        }
    }

    public void z(k kVar) {
        this.f6999b = kVar;
        I(kVar);
    }
}
