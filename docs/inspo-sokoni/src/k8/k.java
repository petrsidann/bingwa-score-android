package k8;

/* JADX INFO: loaded from: classes.dex */
public final class k extends x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f11720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11724e;

    public k(m mVar, boolean z10, int i10, int i11, int i12) {
        this.f11720a = mVar;
        this.f11721b = z10;
        this.f11722c = i10;
        this.f11723d = i11;
        this.f11724e = i12;
    }

    @Override // k8.x0.a
    public boolean a() {
        return this.f11721b;
    }

    @Override // k8.x0.a
    public int b() {
        return this.f11723d;
    }

    @Override // k8.x0.a
    public m c() {
        return this.f11720a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0.a)) {
            return false;
        }
        x0.a aVar = (x0.a) obj;
        m mVar = this.f11720a;
        if (mVar != null ? mVar.equals(aVar.c()) : aVar.c() == null) {
            if (this.f11721b == aVar.a() && this.f11722c == aVar.f() && this.f11723d == aVar.b() && this.f11724e == aVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // k8.x0.a
    public int f() {
        return this.f11722c;
    }

    @Override // k8.x0.a
    public int g() {
        return this.f11724e;
    }

    public int hashCode() {
        m mVar = this.f11720a;
        return (((((((((mVar == null ? 0 : mVar.hashCode()) ^ 1000003) * 1000003) ^ (this.f11721b ? 1231 : 1237)) * 1000003) ^ this.f11722c) * 1000003) ^ this.f11723d) * 1000003) ^ this.f11724e;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.f11720a + ", applied=" + this.f11721b + ", hashCount=" + this.f11722c + ", bitmapLength=" + this.f11723d + ", padding=" + this.f11724e + "}";
    }
}
