package l3;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12416f;

    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f12417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f12418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f12419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f12420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f12421e;

        @Override // l3.e.a
        public e a() {
            String str = "";
            if (this.f12417a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f12418b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f12419c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f12420d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f12421e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f12417a.longValue(), this.f12418b.intValue(), this.f12419c.intValue(), this.f12420d.longValue(), this.f12421e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l3.e.a
        public e.a b(int i10) {
            this.f12419c = Integer.valueOf(i10);
            return this;
        }

        @Override // l3.e.a
        public e.a c(long j10) {
            this.f12420d = Long.valueOf(j10);
            return this;
        }

        @Override // l3.e.a
        public e.a d(int i10) {
            this.f12418b = Integer.valueOf(i10);
            return this;
        }

        @Override // l3.e.a
        public e.a e(int i10) {
            this.f12421e = Integer.valueOf(i10);
            return this;
        }

        @Override // l3.e.a
        public e.a f(long j10) {
            this.f12417a = Long.valueOf(j10);
            return this;
        }
    }

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f12412b = j10;
        this.f12413c = i10;
        this.f12414d = i11;
        this.f12415e = j11;
        this.f12416f = i12;
    }

    @Override // l3.e
    public int b() {
        return this.f12414d;
    }

    @Override // l3.e
    public long c() {
        return this.f12415e;
    }

    @Override // l3.e
    public int d() {
        return this.f12413c;
    }

    @Override // l3.e
    public int e() {
        return this.f12416f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f12412b == eVar.f() && this.f12413c == eVar.d() && this.f12414d == eVar.b() && this.f12415e == eVar.c() && this.f12416f == eVar.e();
    }

    @Override // l3.e
    public long f() {
        return this.f12412b;
    }

    public int hashCode() {
        long j10 = this.f12412b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f12413c) * 1000003) ^ this.f12414d) * 1000003;
        long j11 = this.f12415e;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f12416f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f12412b + ", loadBatchSize=" + this.f12413c + ", criticalSectionEnterTimeoutMs=" + this.f12414d + ", eventCleanUpAge=" + this.f12415e + ", maxBlobByteSizePerRow=" + this.f12416f + "}";
    }
}
