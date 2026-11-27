package ed;

/* JADX INFO: loaded from: classes2.dex */
public class p extends o {
    public static final Long j(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return k(str, 10);
    }

    public static final Long k(String str, int i10) {
        boolean z10;
        kotlin.jvm.internal.k.e(str, "<this>");
        a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (kotlin.jvm.internal.k.f(cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z10 = false;
                i11 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j10 = Long.MIN_VALUE;
                i11 = 1;
            }
        } else {
            z10 = false;
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i11 < length) {
            int iB = a.b(str.charAt(i11), i10);
            if (iB < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / ((long) i10);
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * ((long) i10);
            long j15 = iB;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i11++;
            j11 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
    }
}
