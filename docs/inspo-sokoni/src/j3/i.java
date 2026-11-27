package j3;

import android.content.Context;
import k3.x;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f3.b<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f11220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<l3.d> f11221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<k3.f> f11222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.a<n3.a> f11223d;

    public i(kc.a<Context> aVar, kc.a<l3.d> aVar2, kc.a<k3.f> aVar3, kc.a<n3.a> aVar4) {
        this.f11220a = aVar;
        this.f11221b = aVar2;
        this.f11222c = aVar3;
        this.f11223d = aVar4;
    }

    public static i a(kc.a<Context> aVar, kc.a<l3.d> aVar2, kc.a<k3.f> aVar3, kc.a<n3.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, l3.d dVar, k3.f fVar, n3.a aVar) {
        return (x) f3.d.c(h.a(context, dVar, fVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c(this.f11220a.get(), this.f11221b.get(), this.f11222c.get(), this.f11223d.get());
    }
}
