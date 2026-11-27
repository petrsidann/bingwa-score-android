package k3;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class s implements f3.b<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f11497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<e3.e> f11498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<l3.d> f11499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<x> f11500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc.a<Executor> f11501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kc.a<m3.b> f11502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final kc.a<n3.a> f11503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final kc.a<n3.a> f11504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final kc.a<l3.c> f11505i;

    public s(kc.a<Context> aVar, kc.a<e3.e> aVar2, kc.a<l3.d> aVar3, kc.a<x> aVar4, kc.a<Executor> aVar5, kc.a<m3.b> aVar6, kc.a<n3.a> aVar7, kc.a<n3.a> aVar8, kc.a<l3.c> aVar9) {
        this.f11497a = aVar;
        this.f11498b = aVar2;
        this.f11499c = aVar3;
        this.f11500d = aVar4;
        this.f11501e = aVar5;
        this.f11502f = aVar6;
        this.f11503g = aVar7;
        this.f11504h = aVar8;
        this.f11505i = aVar9;
    }

    public static s a(kc.a<Context> aVar, kc.a<e3.e> aVar2, kc.a<l3.d> aVar3, kc.a<x> aVar4, kc.a<Executor> aVar5, kc.a<m3.b> aVar6, kc.a<n3.a> aVar7, kc.a<n3.a> aVar8, kc.a<l3.c> aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, e3.e eVar, l3.d dVar, x xVar, Executor executor, m3.b bVar, n3.a aVar, n3.a aVar2, l3.c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c(this.f11497a.get(), this.f11498b.get(), this.f11499c.get(), this.f11500d.get(), this.f11501e.get(), this.f11502f.get(), this.f11503g.get(), this.f11504h.get(), this.f11505i.get());
    }
}
