package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 extends vb.c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.c1 f18766a;

    public n0(vb.c1 c1Var) {
        j6.m.p(c1Var, "delegate can not be null");
        this.f18766a = c1Var;
    }

    @Override // vb.c1
    public String a() {
        return this.f18766a.a();
    }

    @Override // vb.c1
    public void b() {
        this.f18766a.b();
    }

    @Override // vb.c1
    public void c() {
        this.f18766a.c();
    }

    @Override // vb.c1
    public void d(vb.c1.e eVar) {
        this.f18766a.d(eVar);
    }

    @Override // vb.c1
    @Deprecated
    public void e(vb.c1.f fVar) {
        this.f18766a.e(fVar);
    }

    public String toString() {
        return j6.g.b(this).d("delegate", this.f18766a).toString();
    }
}
