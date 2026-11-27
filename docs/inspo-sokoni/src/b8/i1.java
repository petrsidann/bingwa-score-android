package b8;

/* JADX INFO: loaded from: classes.dex */
public final class i1 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2910a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2911a;

        public b() {
            this.f2911a = 104857600L;
        }

        public i1 a() {
            return new i1(this.f2911a);
        }

        public b b(long j10) {
            this.f2911a = j10;
            return this;
        }
    }

    public i1(long j10) {
        this.f2910a = j10;
    }

    public static b b() {
        return new b();
    }

    public long a() {
        return this.f2910a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && i1.class == obj.getClass() && this.f2910a == ((i1) obj).f2910a;
    }

    public int hashCode() {
        long j10 = this.f2910a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.f2910a + '}';
    }
}
