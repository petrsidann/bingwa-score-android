package gd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f2 extends e0 implements e1, t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g2 f9172d;

    @Override // gd.t1
    public l2 a() {
        return null;
    }

    @Override // gd.e1
    public void d() {
        u().A0(this);
    }

    @Override // gd.t1
    public boolean isActive() {
        return true;
    }

    @Override // ld.s
    public String toString() {
        return q0.a(this) + '@' + q0.b(this) + "[job@" + q0.b(u()) + ']';
    }

    public final g2 u() {
        g2 g2Var = this.f9172d;
        if (g2Var != null) {
            return g2Var;
        }
        kotlin.jvm.internal.k.o("job");
        return null;
    }

    public final void v(g2 g2Var) {
        this.f9172d = g2Var;
    }
}
