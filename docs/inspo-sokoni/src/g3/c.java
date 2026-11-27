package g3;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f8621c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8623b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8624a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f8625b = b.REASON_UNKNOWN;

        public c a() {
            return new c(this.f8624a, this.f8625b);
        }

        public a b(long j10) {
            this.f8624a = j10;
            return this;
        }

        public a c(b bVar) {
            this.f8625b = bVar;
            return this;
        }
    }

    public enum b implements z7.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8634a;

        b(int i10) {
            this.f8634a = i10;
        }

        @Override // z7.c
        public int a() {
            return this.f8634a;
        }
    }

    public c(long j10, b bVar) {
        this.f8622a = j10;
        this.f8623b = bVar;
    }

    public static a c() {
        return new a();
    }

    @z7.d(tag = 1)
    public long a() {
        return this.f8622a;
    }

    @z7.d(tag = 3)
    public b b() {
        return this.f8623b;
    }
}
