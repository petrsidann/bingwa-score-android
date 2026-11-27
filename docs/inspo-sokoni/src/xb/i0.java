package xb;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i0 implements r {
    @Override // xb.r
    public void a(vb.l1 l1Var) {
        m().a(l1Var);
    }

    @Override // xb.p2
    public void b(vb.o oVar) {
        m().b(oVar);
    }

    @Override // xb.p2
    public boolean c() {
        return m().c();
    }

    @Override // xb.p2
    public void d(int i10) {
        m().d(i10);
    }

    @Override // xb.r
    public void e(int i10) {
        m().e(i10);
    }

    @Override // xb.r
    public void f(int i10) {
        m().f(i10);
    }

    @Override // xb.p2
    public void flush() {
        m().flush();
    }

    @Override // xb.r
    public void g(s sVar) {
        m().g(sVar);
    }

    @Override // xb.r
    public void h(vb.w wVar) {
        m().h(wVar);
    }

    @Override // xb.r
    public void i(String str) {
        m().i(str);
    }

    @Override // xb.r
    public void j() {
        m().j();
    }

    @Override // xb.p2
    public void k(InputStream inputStream) {
        m().k(inputStream);
    }

    @Override // xb.p2
    public void l() {
        m().l();
    }

    public abstract r m();

    @Override // xb.r
    public void n(x0 x0Var) {
        m().n(x0Var);
    }

    @Override // xb.r
    public void o(vb.u uVar) {
        m().o(uVar);
    }

    @Override // xb.r
    public void p(boolean z10) {
        m().p(z10);
    }

    public String toString() {
        return j6.g.b(this).d("delegate", m()).toString();
    }
}
