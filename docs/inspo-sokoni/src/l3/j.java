package l3;

/* JADX INFO: loaded from: classes.dex */
public final class j implements f3.b<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f12437a = new j();
    }

    public static j a() {
        return a.f12437a;
    }

    public static e c() {
        return (e) f3.d.c(f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c();
    }
}
