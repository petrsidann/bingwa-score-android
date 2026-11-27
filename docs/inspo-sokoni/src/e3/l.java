package e3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class l implements f3.b<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f6989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<i> f6990b;

    public l(kc.a<Context> aVar, kc.a<i> aVar2) {
        this.f6989a = aVar;
        this.f6990b = aVar2;
    }

    public static l a(kc.a<Context> aVar, kc.a<i> aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c(this.f6989a.get(), this.f6990b.get());
    }
}
