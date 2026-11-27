package bd;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    public static final int a(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static final long b(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static final int c(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static final long d(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static final int e(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i10 < i11) {
                return i11;
            }
            return i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static final long f(long j10, long j11, long j12) {
        if (j11 <= j12) {
            if (j10 < j11) {
                return j11;
            }
            return j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    public static final d g(int i10, int i11) {
        return d.f3071d.a(i10, i11, -1);
    }

    public static final f h(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? f.f3079e.a() : new f(i10, i11 - 1);
    }
}
