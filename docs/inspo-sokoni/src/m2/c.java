package m2;

/* JADX INFO: loaded from: classes.dex */
public interface c extends m2.a {

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0213a f12905b = new C0213a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12906c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12907d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12908a;

        /* JADX INFO: renamed from: m2.c$a$a, reason: collision with other inner class name */
        public static final class C0213a {
            public C0213a() {
            }

            public /* synthetic */ C0213a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public a(String str) {
            this.f12908a = str;
        }

        public String toString() {
            return this.f12908a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12909b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12910c = new b("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f12911d = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12912a;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(String str) {
            this.f12912a = str;
        }

        public String toString() {
            return this.f12912a;
        }
    }

    a a();

    b getState();
}
