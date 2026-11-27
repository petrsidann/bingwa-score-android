package i8;

import h8.r;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f {
    public c(h8.k kVar, m mVar) {
        super(kVar, mVar);
    }

    @Override // i8.f
    public d a(r rVar, d dVar, h7.q qVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        rVar.o(rVar.m()).w();
        return null;
    }

    @Override // i8.f
    public void b(r rVar, i iVar) {
        n(rVar);
        l8.b.d(iVar.a().isEmpty(), "Transform results received by DeleteMutation.", new Object[0]);
        rVar.o(iVar.b()).v();
    }

    @Override // i8.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return i((c) obj);
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return "DeleteMutation{" + k() + "}";
    }
}
