package vb;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f17400d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17403c;

    public l0(String str, String str2, long j10) {
        j6.m.p(str, "typeName");
        j6.m.e(!str.isEmpty(), "empty type");
        this.f17401a = str;
        this.f17402b = str2;
        this.f17403c = j10;
    }

    public static l0 a(Class<?> cls, String str) {
        return b(c(cls), str);
    }

    public static l0 b(String str, String str2) {
        return new l0(str, str2, e());
    }

    public static String c(Class<?> cls) {
        String simpleName = ((Class) j6.m.p(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f17400d.incrementAndGet();
    }

    public long d() {
        return this.f17403c;
    }

    public String f() {
        return this.f17401a + "<" + this.f17403c + ">";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f());
        if (this.f17402b != null) {
            sb2.append(": (");
            sb2.append(this.f17402b);
            sb2.append(')');
        }
        return sb2.toString();
    }
}
