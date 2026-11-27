package g3;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f8645c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8647b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8648a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8649b = 0;

        public f a() {
            return new f(this.f8648a, this.f8649b);
        }

        public a b(long j10) {
            this.f8649b = j10;
            return this;
        }

        public a c(long j10) {
            this.f8648a = j10;
            return this;
        }
    }

    public f(long j10, long j11) {
        this.f8646a = j10;
        this.f8647b = j11;
    }

    public static a c() {
        return new a();
    }

    @z7.d(tag = 2)
    public long a() {
        return this.f8647b;
    }

    @z7.d(tag = 1)
    public long b() {
        return this.f8646a;
    }
}
