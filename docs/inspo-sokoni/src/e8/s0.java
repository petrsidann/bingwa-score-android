package e8;

/* JADX INFO: loaded from: classes.dex */
public class s0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h8.k f7316d;

    public s0(h8.q qVar, p.b bVar, d9.d0 d0Var) {
        super(qVar, bVar, d0Var);
        l8.b.d(h8.y.C(d0Var), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.f7316d = h8.k.l(h().x0());
    }

    @Override // e8.p, e8.q
    public boolean d(h8.h hVar) {
        return j(hVar.getKey().compareTo(this.f7316d));
    }
}
