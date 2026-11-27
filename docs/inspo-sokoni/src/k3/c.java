package k3;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<f.c> f11448c;

    public static final class b extends f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f11449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f11450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<f.c> f11451c;

        @Override // k3.f.b.a
        public f.b a() {
            String str = "";
            if (this.f11449a == null) {
                str = " delta";
            }
            if (this.f11450b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f11451c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f11449a.longValue(), this.f11450b.longValue(), this.f11451c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k3.f.b.a
        public f.b.a b(long j10) {
            this.f11449a = Long.valueOf(j10);
            return this;
        }

        @Override // k3.f.b.a
        public f.b.a c(Set<f.c> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f11451c = set;
            return this;
        }

        @Override // k3.f.b.a
        public f.b.a d(long j10) {
            this.f11450b = Long.valueOf(j10);
            return this;
        }
    }

    public c(long j10, long j11, Set<f.c> set) {
        this.f11446a = j10;
        this.f11447b = j11;
        this.f11448c = set;
    }

    @Override // k3.f.b
    public long b() {
        return this.f11446a;
    }

    @Override // k3.f.b
    public Set<f.c> c() {
        return this.f11448c;
    }

    @Override // k3.f.b
    public long d() {
        return this.f11447b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.b)) {
            return false;
        }
        f.b bVar = (f.b) obj;
        return this.f11446a == bVar.b() && this.f11447b == bVar.d() && this.f11448c.equals(bVar.c());
    }

    public int hashCode() {
        long j10 = this.f11446a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f11447b;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f11448c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f11446a + ", maxAllowedDelay=" + this.f11447b + ", flags=" + this.f11448c + "}";
    }
}
