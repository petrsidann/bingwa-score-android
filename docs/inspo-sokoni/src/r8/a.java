package r8;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f15144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f15148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f15149h;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.a f15151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f15153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f15154e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f15155f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f15156g;

        public b() {
        }

        public b(d dVar) {
            this.f15150a = dVar.d();
            this.f15151b = dVar.g();
            this.f15152c = dVar.b();
            this.f15153d = dVar.f();
            this.f15154e = Long.valueOf(dVar.c());
            this.f15155f = Long.valueOf(dVar.h());
            this.f15156g = dVar.e();
        }

        @Override // r8.d.a
        public d a() {
            String str = "";
            if (this.f15151b == null) {
                str = " registrationStatus";
            }
            if (this.f15154e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f15155f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f15150a, this.f15151b, this.f15152c, this.f15153d, this.f15154e.longValue(), this.f15155f.longValue(), this.f15156g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // r8.d.a
        public d.a b(String str) {
            this.f15152c = str;
            return this;
        }

        @Override // r8.d.a
        public d.a c(long j10) {
            this.f15154e = Long.valueOf(j10);
            return this;
        }

        @Override // r8.d.a
        public d.a d(String str) {
            this.f15150a = str;
            return this;
        }

        @Override // r8.d.a
        public d.a e(String str) {
            this.f15156g = str;
            return this;
        }

        @Override // r8.d.a
        public d.a f(String str) {
            this.f15153d = str;
            return this;
        }

        @Override // r8.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f15151b = aVar;
            return this;
        }

        @Override // r8.d.a
        public d.a h(long j10) {
            this.f15155f = Long.valueOf(j10);
            return this;
        }
    }

    public a(String str, c.a aVar, String str2, String str3, long j10, long j11, String str4) {
        this.f15143b = str;
        this.f15144c = aVar;
        this.f15145d = str2;
        this.f15146e = str3;
        this.f15147f = j10;
        this.f15148g = j11;
        this.f15149h = str4;
    }

    @Override // r8.d
    public String b() {
        return this.f15145d;
    }

    @Override // r8.d
    public long c() {
        return this.f15147f;
    }

    @Override // r8.d
    public String d() {
        return this.f15143b;
    }

    @Override // r8.d
    public String e() {
        return this.f15149h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f15143b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f15144c.equals(dVar.g()) && ((str = this.f15145d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f15146e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f15147f == dVar.c() && this.f15148g == dVar.h()) {
                String str4 = this.f15149h;
                String strE = dVar.e();
                if (str4 == null) {
                    if (strE == null) {
                        return true;
                    }
                } else if (str4.equals(strE)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // r8.d
    public String f() {
        return this.f15146e;
    }

    @Override // r8.d
    public c.a g() {
        return this.f15144c;
    }

    @Override // r8.d
    public long h() {
        return this.f15148g;
    }

    public int hashCode() {
        String str = this.f15143b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f15144c.hashCode()) * 1000003;
        String str2 = this.f15145d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f15146e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f15147f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f15148g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f15149h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // r8.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f15143b + ", registrationStatus=" + this.f15144c + ", authToken=" + this.f15145d + ", refreshToken=" + this.f15146e + ", expiresInSecs=" + this.f15147f + ", tokenCreationEpochInSecs=" + this.f15148g + ", fisError=" + this.f15149h + "}";
    }
}
