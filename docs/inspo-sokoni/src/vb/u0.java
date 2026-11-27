package vb;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 extends t0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1.c f17537a = c1.c.a(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public c1.c e(Map<String, ?> map) {
        return f17537a;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return j6.g.b(this).d("policy", b()).b("priority", c()).e("available", d()).toString();
    }
}
