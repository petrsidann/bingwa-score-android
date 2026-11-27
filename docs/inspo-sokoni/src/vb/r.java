package vb;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f17494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f17495b;

    public r(q qVar, l1 l1Var) {
        this.f17494a = (q) j6.m.p(qVar, "state is null");
        this.f17495b = (l1) j6.m.p(l1Var, "status is null");
    }

    public static r a(q qVar) {
        j6.m.e(qVar != q.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new r(qVar, l1.f17405e);
    }

    public static r b(l1 l1Var) {
        j6.m.e(!l1Var.o(), "The error status must not be OK");
        return new r(q.TRANSIENT_FAILURE, l1Var);
    }

    public q c() {
        return this.f17494a;
    }

    public l1 d() {
        return this.f17495b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f17494a.equals(rVar.f17494a) && this.f17495b.equals(rVar.f17495b);
    }

    public int hashCode() {
        return this.f17494a.hashCode() ^ this.f17495b.hashCode();
    }

    public String toString() {
        if (this.f17495b.o()) {
            return this.f17494a.toString();
        }
        return this.f17494a + "(" + this.f17495b + ")";
    }
}
