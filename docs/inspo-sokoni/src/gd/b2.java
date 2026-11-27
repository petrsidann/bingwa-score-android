package gd;

/* JADX INFO: loaded from: classes2.dex */
public class b2 extends g2 implements a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9140c;

    public b2(y1 y1Var) {
        super(true);
        g0(y1Var);
        this.f9140c = M0();
    }

    public final boolean M0() {
        g2 g2VarU;
        u uVarC0 = c0();
        v vVar = uVarC0 instanceof v ? (v) uVarC0 : null;
        if (vVar != null && (g2VarU = vVar.u()) != null) {
            while (!g2VarU.Y()) {
                u uVarC1 = g2VarU.c0();
                v vVar2 = uVarC1 instanceof v ? (v) uVarC1 : null;
                if (vVar2 == null || (g2VarU = vVar2.u()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // gd.g2
    public boolean Y() {
        return this.f9140c;
    }

    @Override // gd.g2
    public boolean a0() {
        return true;
    }
}
