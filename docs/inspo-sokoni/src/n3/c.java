package n3;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f3.b<n3.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13420a = new c();
    }

    public static c a() {
        return a.f13420a;
    }

    public static n3.a b() {
        return (n3.a) f3.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n3.a get() {
        return b();
    }
}
