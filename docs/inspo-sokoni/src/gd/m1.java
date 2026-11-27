package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ld.h0 f9233a = new ld.h0("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ld.h0 f9234b = new ld.h0("CLOSED_EMPTY");

    public static final long c(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
