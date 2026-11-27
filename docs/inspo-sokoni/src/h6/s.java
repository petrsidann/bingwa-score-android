package h6;

/* JADX INFO: loaded from: classes.dex */
public final class s extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9684b;

    public s(int i10, long j10) {
        this.f9683a = i10;
        this.f9684b = j10;
    }

    @Override // h6.t
    public final int a() {
        return this.f9683a;
    }

    @Override // h6.t
    public final long b() {
        return this.f9684b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f9683a == tVar.a() && this.f9684b == tVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f9684b;
        return ((int) (j10 ^ (j10 >>> 32))) ^ ((this.f9683a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f9683a + ", eventTimestamp=" + this.f9684b + "}";
    }
}
