package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 implements s {
    @Override // xb.q2
    public void a(q2.a aVar) {
        e().a(aVar);
    }

    @Override // xb.q2
    public void b() {
        e().b();
    }

    @Override // xb.s
    public void c(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
        e().c(l1Var, aVar, a1Var);
    }

    @Override // xb.s
    public void d(vb.a1 a1Var) {
        e().d(a1Var);
    }

    public abstract s e();

    public String toString() {
        return j6.g.b(this).d("delegate", e()).toString();
    }
}
