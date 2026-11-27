package j6;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static abstract class a extends b {
    }

    /* JADX INFO: renamed from: j6.b$b, reason: collision with other inner class name */
    public static final class C0184b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f11256a;

        public C0184b(char c10) {
            this.f11256a = c10;
        }

        public String toString() {
            return "CharMatcher.is('" + b.d(this.f11256a) + "')";
        }
    }

    public static abstract class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11257a;

        public c(String str) {
            this.f11257a = (String) m.o(str);
        }

        public final String toString() {
            return this.f11257a;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f11258b = new d();

        public d() {
            super("CharMatcher.none()");
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11259b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f11260c = new e();

        public e() {
            super("CharMatcher.whitespace()");
        }
    }

    public static b b(char c10) {
        return new C0184b(c10);
    }

    public static b c() {
        return d.f11258b;
    }

    public static String d(char c10) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b e() {
        return e.f11260c;
    }
}
