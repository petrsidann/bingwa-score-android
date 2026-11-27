package d3;

/* JADX INFO: loaded from: classes.dex */
public final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3.d<?> f6317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3.g<?, byte[]> f6318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a3.c f6319e;

    public static final class b extends n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f6320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a3.d<?> f6322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a3.g<?, byte[]> f6323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a3.c f6324e;

        @Override // d3.n.a
        public n a() {
            String str = "";
            if (this.f6320a == null) {
                str = " transportContext";
            }
            if (this.f6321b == null) {
                str = str + " transportName";
            }
            if (this.f6322c == null) {
                str = str + " event";
            }
            if (this.f6323d == null) {
                str = str + " transformer";
            }
            if (this.f6324e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f6320a, this.f6321b, this.f6322c, this.f6323d, this.f6324e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d3.n.a
        public n.a b(a3.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f6324e = cVar;
            return this;
        }

        @Override // d3.n.a
        public n.a c(a3.d<?> dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f6322c = dVar;
            return this;
        }

        @Override // d3.n.a
        public n.a d(a3.g<?, byte[]> gVar) {
            if (gVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f6323d = gVar;
            return this;
        }

        @Override // d3.n.a
        public n.a e(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f6320a = oVar;
            return this;
        }

        @Override // d3.n.a
        public n.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f6321b = str;
            return this;
        }
    }

    public c(o oVar, String str, a3.d<?> dVar, a3.g<?, byte[]> gVar, a3.c cVar) {
        this.f6315a = oVar;
        this.f6316b = str;
        this.f6317c = dVar;
        this.f6318d = gVar;
        this.f6319e = cVar;
    }

    @Override // d3.n
    public a3.c b() {
        return this.f6319e;
    }

    @Override // d3.n
    public a3.d<?> c() {
        return this.f6317c;
    }

    @Override // d3.n
    public a3.g<?, byte[]> e() {
        return this.f6318d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f6315a.equals(nVar.f()) && this.f6316b.equals(nVar.g()) && this.f6317c.equals(nVar.c()) && this.f6318d.equals(nVar.e()) && this.f6319e.equals(nVar.b());
    }

    @Override // d3.n
    public o f() {
        return this.f6315a;
    }

    @Override // d3.n
    public String g() {
        return this.f6316b;
    }

    public int hashCode() {
        return ((((((((this.f6315a.hashCode() ^ 1000003) * 1000003) ^ this.f6316b.hashCode()) * 1000003) ^ this.f6317c.hashCode()) * 1000003) ^ this.f6318d.hashCode()) * 1000003) ^ this.f6319e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f6315a + ", transportName=" + this.f6316b + ", event=" + this.f6317c + ", transformer=" + this.f6318d + ", encoding=" + this.f6319e + "}";
    }
}
