package l3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements f3.b<t0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f12481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<String> f12482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<Integer> f12483c;

    public u0(kc.a<Context> aVar, kc.a<String> aVar2, kc.a<Integer> aVar3) {
        this.f12481a = aVar;
        this.f12482b = aVar2;
        this.f12483c = aVar3;
    }

    public static u0 a(kc.a<Context> aVar, kc.a<String> aVar2, kc.a<Integer> aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i10) {
        return new t0(context, str, i10);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c(this.f12481a.get(), this.f12482b.get(), this.f12483c.get().intValue());
    }
}
