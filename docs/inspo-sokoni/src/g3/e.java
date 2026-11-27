package g3;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f8640c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8642b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8643a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8644b = 0;

        public e a() {
            return new e(this.f8643a, this.f8644b);
        }

        public a b(long j10) {
            this.f8643a = j10;
            return this;
        }

        public a c(long j10) {
            this.f8644b = j10;
            return this;
        }
    }

    public e(long j10, long j11) {
        this.f8641a = j10;
        this.f8642b = j11;
    }

    public static a c() {
        return new a();
    }

    @z7.d(tag = 1)
    public long a() {
        return this.f8641a;
    }

    @z7.d(tag = 2)
    public long b() {
        return this.f8642b;
    }
}
