package s8;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f15623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.b f15624e;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f15628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.b f15629e;

        @Override // s8.d.a
        public d a() {
            return new a(this.f15625a, this.f15626b, this.f15627c, this.f15628d, this.f15629e);
        }

        @Override // s8.d.a
        public d.a b(f fVar) {
            this.f15628d = fVar;
            return this;
        }

        @Override // s8.d.a
        public d.a c(String str) {
            this.f15626b = str;
            return this;
        }

        @Override // s8.d.a
        public d.a d(String str) {
            this.f15627c = str;
            return this;
        }

        @Override // s8.d.a
        public d.a e(d.b bVar) {
            this.f15629e = bVar;
            return this;
        }

        @Override // s8.d.a
        public d.a f(String str) {
            this.f15625a = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f15620a = str;
        this.f15621b = str2;
        this.f15622c = str3;
        this.f15623d = fVar;
        this.f15624e = bVar;
    }

    @Override // s8.d
    public f b() {
        return this.f15623d;
    }

    @Override // s8.d
    public String c() {
        return this.f15621b;
    }

    @Override // s8.d
    public String d() {
        return this.f15622c;
    }

    @Override // s8.d
    public d.b e() {
        return this.f15624e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f15620a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f15621b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f15622c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f15623d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f15624e;
                        d.b bVarE = dVar.e();
                        if (bVar == null) {
                            if (bVarE == null) {
                                return true;
                            }
                        } else if (bVar.equals(bVarE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // s8.d
    public String f() {
        return this.f15620a;
    }

    public int hashCode() {
        String str = this.f15620a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f15621b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f15622c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f15623d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f15624e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f15620a + ", fid=" + this.f15621b + ", refreshToken=" + this.f15622c + ", authToken=" + this.f15623d + ", responseCode=" + this.f15624e + "}";
    }
}
