package e8;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e extends p {
    public e(h8.q qVar, d9.d0 d0Var) {
        super(qVar, p.b.ARRAY_CONTAINS_ANY, d0Var);
        l8.b.d(h8.y.u(d0Var), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        d9.d0 d0VarL = hVar.l(f());
        if (!h8.y.u(d0VarL)) {
            return false;
        }
        Iterator<d9.d0> it = d0VarL.p0().m().iterator();
        while (it.hasNext()) {
            if (h8.y.q(h().p0(), it.next())) {
                return true;
            }
        }
        return false;
    }
}
