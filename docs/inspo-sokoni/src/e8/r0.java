package e8;

/* JADX INFO: loaded from: classes.dex */
public class r0 extends p {
    public r0(h8.q qVar, d9.d0 d0Var) {
        super(qVar, p.b.IN, d0Var);
        l8.b.d(h8.y.u(d0Var), "InFilter expects an ArrayValue", new Object[0]);
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        d9.d0 d0VarL = hVar.l(f());
        return d0VarL != null && h8.y.q(h().p0(), d0VarL);
    }
}
