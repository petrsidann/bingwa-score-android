package e8;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h8.k> f7323d;

    /* JADX WARN: Illegal instructions before constructor call */
    public t0(h8.q qVar, d9.d0 d0Var) {
        p.b bVar = p.b.IN;
        super(qVar, bVar, d0Var);
        ArrayList arrayList = new ArrayList();
        this.f7323d = arrayList;
        arrayList.addAll(k(bVar, d0Var));
    }

    public static List<h8.k> k(p.b bVar, d9.d0 d0Var) {
        l8.b.d(bVar == p.b.IN || bVar == p.b.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        l8.b.d(h8.y.u(d0Var), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (d9.d0 d0Var2 : d0Var.p0().m()) {
            l8.b.d(h8.y.C(d0Var2), "Comparing on key with " + bVar.toString() + ", but an array value was not a ReferenceValue", new Object[0]);
            arrayList.add(h8.k.l(d0Var2.x0()));
        }
        return arrayList;
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        return this.f7323d.contains(hVar.getKey());
    }
}
