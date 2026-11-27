package k8;

/* JADX INFO: loaded from: classes.dex */
public final class l extends x0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x0.a f11730e;

    public l(int i10, int i11, String str, String str2, x0.a aVar) {
        this.f11726a = i10;
        this.f11727b = i11;
        if (str == null) {
            throw new NullPointerException("Null projectId");
        }
        this.f11728c = str;
        if (str2 == null) {
            throw new NullPointerException("Null databaseId");
        }
        this.f11729d = str2;
        this.f11730e = aVar;
    }

    @Override // k8.x0.b
    public x0.a a() {
        return this.f11730e;
    }

    @Override // k8.x0.b
    public String c() {
        return this.f11729d;
    }

    @Override // k8.x0.b
    public int d() {
        return this.f11727b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0.b)) {
            return false;
        }
        x0.b bVar = (x0.b) obj;
        if (this.f11726a == bVar.f() && this.f11727b == bVar.d() && this.f11728c.equals(bVar.g()) && this.f11729d.equals(bVar.c())) {
            x0.a aVar = this.f11730e;
            x0.a aVarA = bVar.a();
            if (aVar == null) {
                if (aVarA == null) {
                    return true;
                }
            } else if (aVar.equals(aVarA)) {
                return true;
            }
        }
        return false;
    }

    @Override // k8.x0.b
    public int f() {
        return this.f11726a;
    }

    @Override // k8.x0.b
    public String g() {
        return this.f11728c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f11726a ^ 1000003) * 1000003) ^ this.f11727b) * 1000003) ^ this.f11728c.hashCode()) * 1000003) ^ this.f11729d.hashCode()) * 1000003;
        x0.a aVar = this.f11730e;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.f11726a + ", existenceFilterCount=" + this.f11727b + ", projectId=" + this.f11728c + ", databaseId=" + this.f11729d + ", bloomFilter=" + this.f11730e + "}";
    }
}
