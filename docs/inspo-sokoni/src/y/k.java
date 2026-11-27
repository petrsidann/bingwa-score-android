package y;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f19249a = new boolean[3];

    public static void a(f fVar, x.d dVar, e eVar) {
        eVar.f19175j = -1;
        eVar.f19177k = -1;
        e.b bVar = fVar.M[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.M[0] == e.b.MATCH_PARENT) {
            int i10 = eVar.B.f19142e;
            int iP = fVar.P() - eVar.D.f19142e;
            d dVar2 = eVar.B;
            dVar2.f19144g = dVar.q(dVar2);
            d dVar3 = eVar.D;
            dVar3.f19144g = dVar.q(dVar3);
            dVar.f(eVar.B.f19144g, i10);
            dVar.f(eVar.D.f19144g, iP);
            eVar.f19175j = 2;
            eVar.k0(i10, iP);
        }
        if (fVar.M[1] == bVar2 || eVar.M[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i11 = eVar.C.f19142e;
        int iV = fVar.v() - eVar.E.f19142e;
        d dVar4 = eVar.C;
        dVar4.f19144g = dVar.q(dVar4);
        d dVar5 = eVar.E;
        dVar5.f19144g = dVar.q(dVar5);
        dVar.f(eVar.C.f19144g, i11);
        dVar.f(eVar.E.f19144g, iV);
        if (eVar.Y > 0 || eVar.O() == 8) {
            d dVar6 = eVar.F;
            dVar6.f19144g = dVar.q(dVar6);
            dVar.f(eVar.F.f19144g, eVar.Y + i11);
        }
        eVar.f19177k = 2;
        eVar.z0(i11, iV);
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
