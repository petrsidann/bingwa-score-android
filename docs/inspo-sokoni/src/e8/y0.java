package e8;

/* JADX INFO: loaded from: classes.dex */
public class y0 extends p {
    public y0(h8.q qVar, d9.d0 d0Var) {
        super(qVar, p.b.NOT_IN, d0Var);
        l8.b.d(h8.y.u(d0Var), "NotInFilter expects an ArrayValue", new Object[0]);
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        d9.d0 d0VarL;
        return (h8.y.q(h().p0(), h8.y.f9784b) || (d0VarL = hVar.l(f())) == null || h8.y.q(h().p0(), d0VarL)) ? false : true;
    }
}
