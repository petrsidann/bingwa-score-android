package vb;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f17367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r0 f17368e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f17370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f17371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r0 f17372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public r0 f17373e;

        public g0 a() {
            j6.m.p(this.f17369a, "description");
            j6.m.p(this.f17370b, "severity");
            j6.m.p(this.f17371c, "timestampNanos");
            j6.m.v(this.f17372d == null || this.f17373e == null, "at least one of channelRef and subchannelRef must be null");
            return new g0(this.f17369a, this.f17370b, this.f17371c.longValue(), this.f17372d, this.f17373e);
        }

        public a b(String str) {
            this.f17369a = str;
            return this;
        }

        public a c(b bVar) {
            this.f17370b = bVar;
            return this;
        }

        public a d(r0 r0Var) {
            this.f17373e = r0Var;
            return this;
        }

        public a e(long j10) {
            this.f17371c = Long.valueOf(j10);
            return this;
        }
    }

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public g0(String str, b bVar, long j10, r0 r0Var, r0 r0Var2) {
        this.f17364a = str;
        this.f17365b = (b) j6.m.p(bVar, "severity");
        this.f17366c = j10;
        this.f17367d = r0Var;
        this.f17368e = r0Var2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return j6.i.a(this.f17364a, g0Var.f17364a) && j6.i.a(this.f17365b, g0Var.f17365b) && this.f17366c == g0Var.f17366c && j6.i.a(this.f17367d, g0Var.f17367d) && j6.i.a(this.f17368e, g0Var.f17368e);
    }

    public int hashCode() {
        return j6.i.b(this.f17364a, this.f17365b, Long.valueOf(this.f17366c), this.f17367d, this.f17368e);
    }

    public String toString() {
        return j6.g.b(this).d("description", this.f17364a).d("severity", this.f17365b).c("timestampNanos", this.f17366c).d("channelRef", this.f17367d).d("subchannelRef", this.f17368e).toString();
    }
}
