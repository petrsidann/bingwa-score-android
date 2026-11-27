package p8;

/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14352c;

    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f14354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f14355c;

        @Override // p8.m.a
        public m a() {
            String str = "";
            if (this.f14353a == null) {
                str = " token";
            }
            if (this.f14354b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f14355c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f14353a, this.f14354b.longValue(), this.f14355c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p8.m.a
        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f14353a = str;
            return this;
        }

        @Override // p8.m.a
        public m.a c(long j10) {
            this.f14355c = Long.valueOf(j10);
            return this;
        }

        @Override // p8.m.a
        public m.a d(long j10) {
            this.f14354b = Long.valueOf(j10);
            return this;
        }
    }

    public a(String str, long j10, long j11) {
        this.f14350a = str;
        this.f14351b = j10;
        this.f14352c = j11;
    }

    @Override // p8.m
    public String b() {
        return this.f14350a;
    }

    @Override // p8.m
    public long c() {
        return this.f14352c;
    }

    @Override // p8.m
    public long d() {
        return this.f14351b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f14350a.equals(mVar.b()) && this.f14351b == mVar.d() && this.f14352c == mVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.f14350a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f14351b;
        long j11 = this.f14352c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f14350a + ", tokenExpirationTimestamp=" + this.f14351b + ", tokenCreationTimestamp=" + this.f14352c + "}";
    }
}
