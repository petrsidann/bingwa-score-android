package i8;

import h8.r;

/* JADX INFO: loaded from: classes.dex */
public final class q extends f {
    public q(h8.k kVar, m mVar) {
        super(kVar, mVar);
    }

    @Override // i8.f
    public d a(r rVar, d dVar, h7.q qVar) {
        throw l8.b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // i8.f
    public void b(r rVar, i iVar) {
        throw l8.b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // i8.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return i((q) obj);
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return "VerifyMutation{" + k() + "}";
    }
}
