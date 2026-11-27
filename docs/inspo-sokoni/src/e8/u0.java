package e8;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h8.k> f7329d;

    /* JADX WARN: Illegal instructions before constructor call */
    public u0(h8.q qVar, d9.d0 d0Var) {
        p.b bVar = p.b.NOT_IN;
        super(qVar, bVar, d0Var);
        ArrayList arrayList = new ArrayList();
        this.f7329d = arrayList;
        arrayList.addAll(t0.k(bVar, d0Var));
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        return !this.f7329d.contains(hVar.getKey());
    }
}
