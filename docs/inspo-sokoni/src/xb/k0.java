package xb;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0 implements w {
    @Override // xb.k1
    public Runnable a(k1.a aVar) {
        return b().a(aVar);
    }

    public abstract w b();

    @Override // xb.k1
    public void c(vb.l1 l1Var) {
        b().c(l1Var);
    }

    @Override // xb.k1
    public void d(vb.l1 l1Var) {
        b().d(l1Var);
    }

    @Override // xb.t
    public void e(t.a aVar, Executor executor) {
        b().e(aVar, executor);
    }

    @Override // vb.r0
    public vb.l0 g() {
        return b().g();
    }

    @Override // xb.w
    public vb.a getAttributes() {
        return b().getAttributes();
    }

    @Override // xb.t
    public r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
        return b().h(b1Var, a1Var, cVar, kVarArr);
    }

    public String toString() {
        return j6.g.b(this).d("delegate", b()).toString();
    }
}
