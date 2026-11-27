package b8;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f3009a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a1 f3010a;

        public b() {
            this.f3010a = z0.a().a();
        }

        public y0 a() {
            return new y0(this.f3010a);
        }
    }

    public y0(a1 a1Var) {
        this.f3009a = a1Var;
    }

    public static b b() {
        return new b();
    }

    public a1 a() {
        return this.f3009a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        return a().equals(((y0) obj).a());
    }

    public int hashCode() {
        return this.f3009a.hashCode();
    }

    public String toString() {
        return "MemoryCacheSettings{gcSettings=" + a() + "}";
    }
}
