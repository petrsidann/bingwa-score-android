package ec;

import java.util.List;
import vb.t0;
import vb.y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends t0.i {
    @Override // vb.t0.i
    public List<y> b() {
        return j().b();
    }

    @Override // vb.t0.i
    public vb.a c() {
        return j().c();
    }

    @Override // vb.t0.i
    public vb.f d() {
        return j().d();
    }

    @Override // vb.t0.i
    public Object e() {
        return j().e();
    }

    @Override // vb.t0.i
    public void f() {
        j().f();
    }

    @Override // vb.t0.i
    public void g() {
        j().g();
    }

    @Override // vb.t0.i
    public void h(t0.k kVar) {
        j().h(kVar);
    }

    @Override // vb.t0.i
    public void i(List<y> list) {
        j().i(list);
    }

    public abstract t0.i j();

    public String toString() {
        return j6.g.b(this).d("delegate", j()).toString();
    }
}
