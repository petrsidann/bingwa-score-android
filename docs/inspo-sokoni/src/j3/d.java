package j3;

import java.util.concurrent.Executor;
import k3.x;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f3.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Executor> f11214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<e3.e> f11215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<x> f11216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<l3.d> f11217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc.a<m3.b> f11218e;

    public d(kc.a<Executor> aVar, kc.a<e3.e> aVar2, kc.a<x> aVar3, kc.a<l3.d> aVar4, kc.a<m3.b> aVar5) {
        this.f11214a = aVar;
        this.f11215b = aVar2;
        this.f11216c = aVar3;
        this.f11217d = aVar4;
        this.f11218e = aVar5;
    }

    public static d a(kc.a<Executor> aVar, kc.a<e3.e> aVar2, kc.a<x> aVar3, kc.a<l3.d> aVar4, kc.a<m3.b> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, e3.e eVar, x xVar, l3.d dVar, m3.b bVar) {
        return new c(executor, eVar, xVar, dVar, bVar);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f11214a.get(), this.f11215b.get(), this.f11216c.get(), this.f11217d.get(), this.f11218e.get());
    }
}
