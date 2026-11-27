package q7;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0<?> f14883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14885c;

    public q(Class<?> cls, int i10, int i11) {
        this((e0<?>) e0.b(cls), i10, i11);
    }

    public q(e0<?> e0Var, int i10, int i11) {
        this.f14883a = (e0) d0.c(e0Var, "Null dependency anInterface.");
        this.f14884b = i10;
        this.f14885c = i11;
    }

    public static q a(Class<?> cls) {
        return new q(cls, 0, 2);
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return "provider";
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    @Deprecated
    public static q h(Class<?> cls) {
        return new q(cls, 0, 0);
    }

    public static q i(Class<?> cls) {
        return new q(cls, 0, 1);
    }

    public static q j(e0<?> e0Var) {
        return new q(e0Var, 0, 1);
    }

    public static q k(Class<?> cls) {
        return new q(cls, 1, 0);
    }

    public static q l(e0<?> e0Var) {
        return new q(e0Var, 1, 0);
    }

    public static q m(Class<?> cls) {
        return new q(cls, 1, 1);
    }

    public static q n(Class<?> cls) {
        return new q(cls, 2, 0);
    }

    public e0<?> c() {
        return this.f14883a;
    }

    public boolean d() {
        return this.f14885c == 2;
    }

    public boolean e() {
        return this.f14885c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f14883a.equals(qVar.f14883a) && this.f14884b == qVar.f14884b && this.f14885c == qVar.f14885c;
    }

    public boolean f() {
        return this.f14884b == 1;
    }

    public boolean g() {
        return this.f14884b == 2;
    }

    public int hashCode() {
        return ((((this.f14883a.hashCode() ^ 1000003) * 1000003) ^ this.f14884b) * 1000003) ^ this.f14885c;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f14883a);
        sb2.append(", type=");
        int i10 = this.f14884b;
        if (i10 == 1) {
            str = "required";
        } else {
            str = i10 == 0 ? "optional" : "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        sb2.append(b(this.f14885c));
        sb2.append("}");
        return sb2.toString();
    }
}
