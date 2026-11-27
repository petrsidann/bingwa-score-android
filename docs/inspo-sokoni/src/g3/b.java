package g3;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8618b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f8619a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f8620a = null;

        public b a() {
            return new b(this.f8620a);
        }

        public a b(e eVar) {
            this.f8620a = eVar;
            return this;
        }
    }

    public b(e eVar) {
        this.f8619a = eVar;
    }

    public static a b() {
        return new a();
    }

    @z7.d(tag = 1)
    public e a() {
        return this.f8619a;
    }
}
