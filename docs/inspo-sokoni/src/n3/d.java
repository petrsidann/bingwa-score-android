package n3;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f3.b<n3.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13421a = new d();
    }

    public static d a() {
        return a.f13421a;
    }

    public static n3.a c() {
        return (n3.a) f3.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n3.a get() {
        return c();
    }
}
