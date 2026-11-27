package c3;

/* JADX INFO: loaded from: classes.dex */
public final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.b f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c3.a f3240b;

    public static final class b extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k.b f3241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c3.a f3242b;

        @Override // c3.k.a
        public k a() {
            return new e(this.f3241a, this.f3242b);
        }

        @Override // c3.k.a
        public k.a b(c3.a aVar) {
            this.f3242b = aVar;
            return this;
        }

        @Override // c3.k.a
        public k.a c(k.b bVar) {
            this.f3241a = bVar;
            return this;
        }
    }

    public e(k.b bVar, c3.a aVar) {
        this.f3239a = bVar;
        this.f3240b = aVar;
    }

    @Override // c3.k
    public c3.a b() {
        return this.f3240b;
    }

    @Override // c3.k
    public k.b c() {
        return this.f3239a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.f3239a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            c3.a aVar = this.f3240b;
            c3.a aVarB = kVar.b();
            if (aVar == null) {
                if (aVarB == null) {
                    return true;
                }
            } else if (aVar.equals(aVarB)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.f3239a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        c3.a aVar = this.f3240b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f3239a + ", androidClientInfo=" + this.f3240b + "}";
    }
}
