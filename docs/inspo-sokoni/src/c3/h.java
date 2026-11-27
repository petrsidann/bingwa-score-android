package c3;

/* JADX INFO: loaded from: classes.dex */
public final class h extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3271a;

    public h(long j10) {
        this.f3271a = j10;
    }

    @Override // c3.n
    public long c() {
        return this.f3271a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f3271a == ((n) obj).c();
    }

    public int hashCode() {
        long j10 = this.f3271a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f3271a + "}";
    }
}
