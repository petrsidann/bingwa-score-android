package vb;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Comparable<u> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f17530d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f17531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f17532f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f17533l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f17534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f17536c;

    public static class b extends c {
        public b() {
        }

        @Override // vb.u.c
        public long a() {
            return System.nanoTime();
        }
    }

    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f17531e = nanos;
        f17532f = -nanos;
        f17533l = TimeUnit.SECONDS.toNanos(1L);
    }

    public u(c cVar, long j10, long j11, boolean z10) {
        this.f17534a = cVar;
        long jMin = Math.min(f17531e, Math.max(f17532f, j11));
        this.f17535b = j10 + jMin;
        this.f17536c = z10 && jMin <= 0;
    }

    public u(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static u d(long j10, TimeUnit timeUnit) {
        return h(j10, timeUnit, f17530d);
    }

    public static u h(long j10, TimeUnit timeUnit, c cVar) {
        i(timeUnit, "units");
        return new u(cVar, timeUnit.toNanos(j10), true);
    }

    public static <T> T i(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static c n() {
        return f17530d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        c cVar = this.f17534a;
        if (cVar != null ? cVar == uVar.f17534a : uVar.f17534a == null) {
            return this.f17535b == uVar.f17535b;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.asList(this.f17534a, Long.valueOf(this.f17535b)).hashCode();
    }

    public final void k(u uVar) {
        if (this.f17534a == uVar.f17534a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f17534a + " and " + uVar.f17534a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        k(uVar);
        long j10 = this.f17535b - uVar.f17535b;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }

    public boolean o(u uVar) {
        k(uVar);
        return this.f17535b - uVar.f17535b < 0;
    }

    public boolean p() {
        if (!this.f17536c) {
            if (this.f17535b - this.f17534a.a() > 0) {
                return false;
            }
            this.f17536c = true;
        }
        return true;
    }

    public u q(u uVar) {
        k(uVar);
        return o(uVar) ? this : uVar;
    }

    public long r(TimeUnit timeUnit) {
        long jA = this.f17534a.a();
        if (!this.f17536c && this.f17535b - jA <= 0) {
            this.f17536c = true;
        }
        return timeUnit.convert(this.f17535b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jR = r(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jR);
        long j10 = f17533l;
        long j11 = jAbs / j10;
        long jAbs2 = Math.abs(jR) % j10;
        StringBuilder sb2 = new StringBuilder();
        if (jR < 0) {
            sb2.append('-');
        }
        sb2.append(j11);
        if (jAbs2 > 0) {
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb2.append("s from now");
        if (this.f17534a != f17530d) {
            sb2.append(" (ticker=" + this.f17534a + ")");
        }
        return sb2.toString();
    }
}
