package l3;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements f3.b<m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<n3.a> f12454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<n3.a> f12455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<e> f12456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<t0> f12457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc.a<String> f12458e;

    public n0(kc.a<n3.a> aVar, kc.a<n3.a> aVar2, kc.a<e> aVar3, kc.a<t0> aVar4, kc.a<String> aVar5) {
        this.f12454a = aVar;
        this.f12455b = aVar2;
        this.f12456c = aVar3;
        this.f12457d = aVar4;
        this.f12458e = aVar5;
    }

    public static n0 a(kc.a<n3.a> aVar, kc.a<n3.a> aVar2, kc.a<e> aVar3, kc.a<t0> aVar4, kc.a<String> aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(n3.a aVar, n3.a aVar2, Object obj, Object obj2, kc.a<String> aVar3) {
        return new m0(aVar, aVar2, (e) obj, (t0) obj2, aVar3);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c(this.f12454a.get(), this.f12455b.get(), this.f12456c.get(), this.f12457d.get(), this.f12458e);
    }
}
