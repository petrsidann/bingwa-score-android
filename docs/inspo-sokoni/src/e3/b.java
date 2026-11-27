package e3;

/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a f6967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6968b;

    public b(g.a aVar, long j10) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f6967a = aVar;
        this.f6968b = j10;
    }

    @Override // e3.g
    public long b() {
        return this.f6968b;
    }

    @Override // e3.g
    public g.a c() {
        return this.f6967a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f6967a.equals(gVar.c()) && this.f6968b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.f6967a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f6968b;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f6967a + ", nextRequestWaitMillis=" + this.f6968b + "}";
    }
}
