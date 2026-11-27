package i8;

import d9.d0;
import h8.r;
import h8.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class o extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f10548d;

    public o(h8.k kVar, s sVar, m mVar) {
        this(kVar, sVar, mVar, new ArrayList());
    }

    public o(h8.k kVar, s sVar, m mVar, List<e> list) {
        super(kVar, mVar, list);
        this.f10548d = sVar;
    }

    @Override // i8.f
    public d a(r rVar, d dVar, h7.q qVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        Map<h8.q, d0> mapL = l(qVar, rVar);
        s sVarClone = this.f10548d.clone();
        sVarClone.n(mapL);
        rVar.n(rVar.m(), sVarClone).w();
        return null;
    }

    @Override // i8.f
    public void b(r rVar, i iVar) {
        n(rVar);
        s sVarClone = this.f10548d.clone();
        sVarClone.n(m(rVar, iVar.a()));
        rVar.n(iVar.b(), sVarClone).v();
    }

    @Override // i8.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return i(oVar) && this.f10548d.equals(oVar.f10548d) && f().equals(oVar.f());
    }

    public int hashCode() {
        return (j() * 31) + this.f10548d.hashCode();
    }

    public s o() {
        return this.f10548d;
    }

    public String toString() {
        return "SetMutation{" + k() + ", value=" + this.f10548d + "}";
    }
}
