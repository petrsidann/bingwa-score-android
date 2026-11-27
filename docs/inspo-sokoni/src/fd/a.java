package fd;

import kotlin.jvm.internal.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0144a f8310a = new C0144a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8311b = d(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f8312c = c.b(4611686018427387903L);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f8313d = c.b(-4611686018427387903L);

    /* JADX INFO: renamed from: fd.a$a, reason: collision with other inner class name */
    public static final class C0144a {
        public C0144a() {
        }

        public /* synthetic */ C0144a(g gVar) {
            this();
        }
    }

    public static long d(long j10) {
        if (b.a()) {
            boolean zI = i(j10);
            long jH = h(j10);
            if (zI) {
                if (!(-4611686018426999999L <= jH && jH < 4611686018427000000L)) {
                    throw new AssertionError(h(j10) + " ns is out of nanoseconds range");
                }
            } else {
                if (!(-4611686018427387903L <= jH && jH < 4611686018427387904L)) {
                    throw new AssertionError(h(j10) + " ms is out of milliseconds range");
                }
                long jH2 = h(j10);
                if (-4611686018426L <= jH2 && jH2 < 4611686018427L) {
                    throw new AssertionError(h(j10) + " ms is denormalized");
                }
            }
        }
        return j10;
    }

    public static final long h(long j10) {
        return j10 >> 1;
    }

    public static final boolean i(long j10) {
        return (((int) j10) & 1) == 0;
    }
}
