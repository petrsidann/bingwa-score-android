package b8;

/* JADX INFO: loaded from: classes.dex */
public final class b1 implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2880a;

    public long a() {
        return this.f2880a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && b1.class == obj.getClass() && this.f2880a == ((b1) obj).f2880a;
    }

    public int hashCode() {
        long j10 = this.f2880a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public String toString() {
        return "MemoryLruGcSettings{cacheSize=" + a() + "}";
    }
}
