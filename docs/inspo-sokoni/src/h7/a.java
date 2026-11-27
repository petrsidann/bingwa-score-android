package h7;

/* JADX INFO: loaded from: classes.dex */
public final class a extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9687c;

    public a(long j10, long j11, long j12) {
        this.f9685a = j10;
        this.f9686b = j11;
        this.f9687c = j12;
    }

    @Override // h7.p
    public long b() {
        return this.f9686b;
    }

    @Override // h7.p
    public long c() {
        return this.f9685a;
    }

    @Override // h7.p
    public long d() {
        return this.f9687c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f9685a == pVar.c() && this.f9686b == pVar.b() && this.f9687c == pVar.d();
    }

    public int hashCode() {
        long j10 = this.f9685a;
        long j11 = this.f9686b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f9687c;
        return i10 ^ ((int) ((j12 >>> 32) ^ j12));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f9685a + ", elapsedRealtime=" + this.f9686b + ", uptimeMillis=" + this.f9687c + "}";
    }
}
