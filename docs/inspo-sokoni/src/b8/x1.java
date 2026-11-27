package b8;

/* JADX INFO: loaded from: classes.dex */
public final class x1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x1 f3005b = new b().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3006a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3007a = 5;

        public x1 a() {
            return new x1(this.f3007a);
        }

        public b b(int i10) {
            if (i10 < 1) {
                throw new IllegalArgumentException("Max attempts must be at least 1");
            }
            this.f3007a = i10;
            return this;
        }
    }

    public x1(int i10) {
        this.f3006a = i10;
    }

    public int a() {
        return this.f3006a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && x1.class == obj.getClass() && this.f3006a == ((x1) obj).f3006a;
    }

    public int hashCode() {
        return this.f3006a;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.f3006a + '}';
    }
}
