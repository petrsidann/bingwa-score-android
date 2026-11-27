package h8;

/* JADX INFO: loaded from: classes.dex */
public final class c extends p.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.a f9734b;

    public c(long j10, p.a aVar) {
        this.f9733a = j10;
        if (aVar == null) {
            throw new NullPointerException("Null offset");
        }
        this.f9734b = aVar;
    }

    @Override // h8.p.b
    public p.a c() {
        return this.f9734b;
    }

    @Override // h8.p.b
    public long d() {
        return this.f9733a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.b)) {
            return false;
        }
        p.b bVar = (p.b) obj;
        return this.f9733a == bVar.d() && this.f9734b.equals(bVar.c());
    }

    public int hashCode() {
        long j10 = this.f9733a;
        return ((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f9734b.hashCode();
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.f9733a + ", offset=" + this.f9734b + "}";
    }
}
