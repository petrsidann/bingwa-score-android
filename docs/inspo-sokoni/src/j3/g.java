package j3;

/* JADX INFO: loaded from: classes.dex */
public final class g implements f3.b<k3.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<n3.a> f11219a;

    public g(kc.a<n3.a> aVar) {
        this.f11219a = aVar;
    }

    public static k3.f a(n3.a aVar) {
        return (k3.f) f3.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(kc.a<n3.a> aVar) {
        return new g(aVar);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public k3.f get() {
        return a(this.f11219a.get());
    }
}
