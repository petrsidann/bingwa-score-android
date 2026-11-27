package bc;

import zb.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bc.a f3057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3058b;

    /* JADX INFO: renamed from: bc.b$b, reason: collision with other inner class name */
    public static class C0054b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bc.a f3059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f3060b = new e.b();

        public b c() {
            if (this.f3059a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0054b d(String str, String str2) {
            this.f3060b.f(str, str2);
            return this;
        }

        public C0054b e(bc.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f3059a = aVar;
            return this;
        }
    }

    public b(C0054b c0054b) {
        this.f3057a = c0054b.f3059a;
        this.f3058b = c0054b.f3060b.c();
    }

    public e a() {
        return this.f3058b;
    }

    public bc.a b() {
        return this.f3057a;
    }

    public String toString() {
        return "Request{url=" + this.f3057a + '}';
    }
}
