package c3;

/* JADX INFO: loaded from: classes.dex */
public final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.c f3272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.b f3273b;

    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o.c f3274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o.b f3275b;

        @Override // c3.o.a
        public o a() {
            return new i(this.f3274a, this.f3275b);
        }

        @Override // c3.o.a
        public o.a b(o.b bVar) {
            this.f3275b = bVar;
            return this;
        }

        @Override // c3.o.a
        public o.a c(o.c cVar) {
            this.f3274a = cVar;
            return this;
        }
    }

    public i(o.c cVar, o.b bVar) {
        this.f3272a = cVar;
        this.f3273b = bVar;
    }

    @Override // c3.o
    public o.b b() {
        return this.f3273b;
    }

    @Override // c3.o
    public o.c c() {
        return this.f3272a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.f3272a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.f3273b;
            o.b bVarB = oVar.b();
            if (bVar == null) {
                if (bVarB == null) {
                    return true;
                }
            } else if (bVar.equals(bVarB)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.f3272a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f3273b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f3272a + ", mobileSubtype=" + this.f3273b + "}";
    }
}
