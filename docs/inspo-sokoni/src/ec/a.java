package ec;

import vb.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends vb.k {
    @Override // vb.o1
    public void a(int i10) {
        o().a(i10);
    }

    @Override // vb.o1
    public void b(int i10, long j10, long j11) {
        o().b(i10, j10, j11);
    }

    @Override // vb.o1
    public void c(long j10) {
        o().c(j10);
    }

    @Override // vb.o1
    public void d(long j10) {
        o().d(j10);
    }

    @Override // vb.o1
    public void e(int i10) {
        o().e(i10);
    }

    @Override // vb.o1
    public void f(int i10, long j10, long j11) {
        o().f(i10, j10, j11);
    }

    @Override // vb.o1
    public void g(long j10) {
        o().g(j10);
    }

    @Override // vb.o1
    public void h(long j10) {
        o().h(j10);
    }

    @Override // vb.k
    public void j() {
        o().j();
    }

    @Override // vb.k
    public void k() {
        o().k();
    }

    @Override // vb.k
    public void l(a1 a1Var) {
        o().l(a1Var);
    }

    @Override // vb.k
    public void m() {
        o().m();
    }

    @Override // vb.k
    public void n(vb.a aVar, a1 a1Var) {
        o().n(aVar, a1Var);
    }

    public abstract vb.k o();

    public String toString() {
        return j6.g.b(this).d("delegate", o()).toString();
    }
}
