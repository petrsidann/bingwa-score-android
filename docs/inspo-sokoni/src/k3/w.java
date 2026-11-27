package k3;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class w implements f3.b<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Executor> f11512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<l3.d> f11513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<x> f11514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<m3.b> f11515d;

    public w(kc.a<Executor> aVar, kc.a<l3.d> aVar2, kc.a<x> aVar3, kc.a<m3.b> aVar4) {
        this.f11512a = aVar;
        this.f11513b = aVar2;
        this.f11514c = aVar3;
        this.f11515d = aVar4;
    }

    public static w a(kc.a<Executor> aVar, kc.a<l3.d> aVar2, kc.a<x> aVar3, kc.a<m3.b> aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, l3.d dVar, x xVar, m3.b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c(this.f11512a.get(), this.f11513b.get(), this.f11514c.get(), this.f11515d.get());
    }
}
