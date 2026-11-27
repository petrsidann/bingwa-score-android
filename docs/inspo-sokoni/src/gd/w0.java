package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {
    public static final Object a(long j10, oc.e<? super lc.q> eVar) {
        if (j10 <= 0) {
            return lc.q.f12711a;
        }
        p pVar = new p(pc.b.b(eVar), 1);
        pVar.B();
        if (j10 < Long.MAX_VALUE) {
            b(pVar.getContext()).e(j10, pVar);
        }
        Object objY = pVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY == pc.c.c() ? objY : lc.q.f12711a;
    }

    public static final v0 b(oc.i iVar) {
        oc.i.b bVar = iVar.get(oc.f.f13810k);
        v0 v0Var = bVar instanceof v0 ? (v0) bVar : null;
        return v0Var == null ? s0.a() : v0Var;
    }
}
