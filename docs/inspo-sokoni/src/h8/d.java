package h8;

/* JADX INFO: loaded from: classes.dex */
public final class d extends p.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f9735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.c.a f9736b;

    public d(q qVar, p.c.a aVar) {
        if (qVar == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.f9735a = qVar;
        if (aVar == null) {
            throw new NullPointerException("Null kind");
        }
        this.f9736b = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.c)) {
            return false;
        }
        p.c cVar = (p.c) obj;
        return this.f9735a.equals(cVar.i()) && this.f9736b.equals(cVar.k());
    }

    public int hashCode() {
        return ((this.f9735a.hashCode() ^ 1000003) * 1000003) ^ this.f9736b.hashCode();
    }

    @Override // h8.p.c
    public q i() {
        return this.f9735a;
    }

    @Override // h8.p.c
    public p.c.a k() {
        return this.f9736b;
    }

    public String toString() {
        return "Segment{fieldPath=" + this.f9735a + ", kind=" + this.f9736b + "}";
    }
}
