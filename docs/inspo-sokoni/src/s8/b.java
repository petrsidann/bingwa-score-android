package s8;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f15632c;

    /* JADX INFO: renamed from: s8.b$b, reason: collision with other inner class name */
    public static final class C0280b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f15634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.b f15635c;

        @Override // s8.f.a
        public f a() {
            String str = "";
            if (this.f15634b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f15633a, this.f15634b.longValue(), this.f15635c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // s8.f.a
        public f.a b(f.b bVar) {
            this.f15635c = bVar;
            return this;
        }

        @Override // s8.f.a
        public f.a c(String str) {
            this.f15633a = str;
            return this;
        }

        @Override // s8.f.a
        public f.a d(long j10) {
            this.f15634b = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, long j10, f.b bVar) {
        this.f15630a = str;
        this.f15631b = j10;
        this.f15632c = bVar;
    }

    @Override // s8.f
    public f.b b() {
        return this.f15632c;
    }

    @Override // s8.f
    public String c() {
        return this.f15630a;
    }

    @Override // s8.f
    public long d() {
        return this.f15631b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f15630a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f15631b == fVar.d()) {
                f.b bVar = this.f15632c;
                f.b bVarB = fVar.b();
                if (bVar == null) {
                    if (bVarB == null) {
                        return true;
                    }
                } else if (bVar.equals(bVarB)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f15630a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f15631b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        f.b bVar = this.f15632c;
        return i10 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f15630a + ", tokenExpirationTimestamp=" + this.f15631b + ", responseCode=" + this.f15632c + "}";
    }
}
