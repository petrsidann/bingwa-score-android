package k8;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.protobuf.i f11825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s7.e<h8.k> f11827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s7.e<h8.k> f11828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s7.e<h8.k> f11829e;

    public v0(com.google.protobuf.i iVar, boolean z10, s7.e<h8.k> eVar, s7.e<h8.k> eVar2, s7.e<h8.k> eVar3) {
        this.f11825a = iVar;
        this.f11826b = z10;
        this.f11827c = eVar;
        this.f11828d = eVar2;
        this.f11829e = eVar3;
    }

    public static v0 a(boolean z10, com.google.protobuf.i iVar) {
        return new v0(iVar, z10, h8.k.k(), h8.k.k(), h8.k.k());
    }

    public s7.e<h8.k> b() {
        return this.f11827c;
    }

    public s7.e<h8.k> c() {
        return this.f11828d;
    }

    public s7.e<h8.k> d() {
        return this.f11829e;
    }

    public com.google.protobuf.i e() {
        return this.f11825a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        if (this.f11826b == v0Var.f11826b && this.f11825a.equals(v0Var.f11825a) && this.f11827c.equals(v0Var.f11827c) && this.f11828d.equals(v0Var.f11828d)) {
            return this.f11829e.equals(v0Var.f11829e);
        }
        return false;
    }

    public boolean f() {
        return this.f11826b;
    }

    public int hashCode() {
        return (((((((this.f11825a.hashCode() * 31) + (this.f11826b ? 1 : 0)) * 31) + this.f11827c.hashCode()) * 31) + this.f11828d.hashCode()) * 31) + this.f11829e.hashCode();
    }
}
