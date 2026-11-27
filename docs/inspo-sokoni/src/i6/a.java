package i6;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static int a(long j10, long j11) {
        return Long.compare(j10, j11);
    }

    public static int b(double d10, long j10) {
        if (Double.isNaN(d10) || d10 < -9.223372036854776E18d) {
            return -1;
        }
        if (d10 >= 9.223372036854776E18d) {
            return 1;
        }
        int iA = a((long) d10, j10);
        return iA != 0 ? iA : c(d10, j10);
    }

    public static int c(double d10, double d11) {
        if (d10 < d11) {
            return -1;
        }
        if (d10 > d11) {
            return 1;
        }
        if (d10 == d11) {
            return 0;
        }
        if (Double.isNaN(d11)) {
            return !Double.isNaN(d10) ? 1 : 0;
        }
        return -1;
    }
}
