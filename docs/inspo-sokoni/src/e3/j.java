package e3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class j implements f3.b<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f6981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc.a<n3.a> f6982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.a<n3.a> f6983c;

    public j(kc.a<Context> aVar, kc.a<n3.a> aVar2, kc.a<n3.a> aVar3) {
        this.f6981a = aVar;
        this.f6982b = aVar2;
        this.f6983c = aVar3;
    }

    public static j a(kc.a<Context> aVar, kc.a<n3.a> aVar2, kc.a<n3.a> aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, n3.a aVar, n3.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f6981a.get(), this.f6982b.get(), this.f6983c.get());
    }
}
