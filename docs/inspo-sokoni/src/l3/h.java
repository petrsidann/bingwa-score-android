package l3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f3.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a<Context> f12433a;

    public h(kc.a<Context> aVar) {
        this.f12433a = aVar;
    }

    public static h a(kc.a<Context> aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) f3.d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.f12433a.get());
    }
}
