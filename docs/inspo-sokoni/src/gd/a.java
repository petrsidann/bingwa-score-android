package gd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends g2 implements oc.e<T>, m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oc.i f9132c;

    public a(oc.i iVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            g0((y1) iVar.get(y1.f9273i));
        }
        this.f9132c = iVar.plus(this);
    }

    @Override // gd.g2
    public String M() {
        return q0.a(this) + " was cancelled";
    }

    public void M0(Object obj) {
        x(obj);
    }

    public void N0(Throwable th, boolean z10) {
    }

    public void O0(T t10) {
    }

    public final <R> void P0(o0 o0Var, R r10, xc.p<? super R, ? super oc.e<? super T>, ? extends Object> pVar) {
        o0Var.h(pVar, r10, this);
    }

    @Override // gd.m0
    public oc.i f() {
        return this.f9132c;
    }

    @Override // gd.g2
    public final void f0(Throwable th) {
        l0.a(this.f9132c, th);
    }

    @Override // oc.e
    public final oc.i getContext() {
        return this.f9132c;
    }

    @Override // gd.g2, gd.y1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // gd.g2
    public String o0() {
        String strB = i0.b(this.f9132c);
        if (strB == null) {
            return super.o0();
        }
        return '\"' + strB + "\":" + super.o0();
    }

    @Override // oc.e
    public final void resumeWith(Object obj) {
        Object objM0 = m0(g0.d(obj, null, 1, null));
        if (objM0 == h2.f9204b) {
            return;
        }
        M0(objM0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gd.g2
    public final void v0(Object obj) {
        if (!(obj instanceof c0)) {
            O0(obj);
        } else {
            c0 c0Var = (c0) obj;
            N0(c0Var.f9143a, c0Var.a());
        }
    }
}
