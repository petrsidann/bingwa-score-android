package d3;

/* JADX INFO: loaded from: classes.dex */
public final class v implements f3.b<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<n3.a> f6364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<n3.a> f6365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<j3.e> f6366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<k3.r> f6367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc.a<k3.v> f6368e;

    public v(kc.a<n3.a> aVar, kc.a<n3.a> aVar2, kc.a<j3.e> aVar3, kc.a<k3.r> aVar4, kc.a<k3.v> aVar5) {
        this.f6364a = aVar;
        this.f6365b = aVar2;
        this.f6366c = aVar3;
        this.f6367d = aVar4;
        this.f6368e = aVar5;
    }

    public static v a(kc.a<n3.a> aVar, kc.a<n3.a> aVar2, kc.a<j3.e> aVar3, kc.a<k3.r> aVar4, kc.a<k3.v> aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(n3.a aVar, n3.a aVar2, j3.e eVar, k3.r rVar, k3.v vVar) {
        return new t(aVar, aVar2, eVar, rVar, vVar);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c(this.f6364a.get(), this.f6365b.get(), this.f6366c.get(), this.f6367d.get(), this.f6368e.get());
    }
}
