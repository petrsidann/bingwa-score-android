package o0;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f13613a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static char[] f13614b = new char[24];

    public static int a(int i10, int i11, boolean z10, int i12) {
        if (i10 > 99 || (z10 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z10 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z10 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    public static void b(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            d(j10 - j11, printWriter, 0);
        }
    }

    public static void c(long j10, PrintWriter printWriter) {
        d(j10, printWriter, 0);
    }

    public static void d(long j10, PrintWriter printWriter, int i10) {
        synchronized (f13613a) {
            printWriter.print(new String(f13614b, 0, e(j10, i10)));
        }
    }

    public static int e(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11 = j10;
        if (f13614b.length < i10) {
            f13614b = new char[i10];
        }
        char[] cArr = f13614b;
        if (j11 == 0) {
            int i16 = i10 - 1;
            while (i16 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j11 > 0) {
            c10 = '+';
        } else {
            j11 = -j11;
            c10 = '-';
        }
        int i17 = (int) (j11 % 1000);
        int iFloor = (int) Math.floor(j11 / 1000);
        if (iFloor > 86400) {
            i11 = iFloor / 86400;
            iFloor -= 86400 * i11;
        } else {
            i11 = 0;
        }
        if (iFloor > 3600) {
            i12 = iFloor / 3600;
            iFloor -= i12 * 3600;
        } else {
            i12 = 0;
        }
        if (iFloor > 60) {
            int i18 = iFloor / 60;
            i13 = iFloor - (i18 * 60);
            i14 = i18;
        } else {
            i13 = iFloor;
            i14 = 0;
        }
        if (i10 != 0) {
            int iA = a(i11, 1, false, 0);
            int iA2 = iA + a(i12, 1, iA > 0, 2);
            int iA3 = iA2 + a(i14, 1, iA2 > 0, 2);
            int iA4 = iA3 + a(i13, 1, iA3 > 0, 2);
            i15 = 0;
            for (int iA5 = iA4 + a(i17, 2, true, iA4 > 0 ? 3 : 0) + 1; iA5 < i10; iA5++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i19 = i15 + 1;
        boolean z10 = i10 != 0;
        int iF = f(cArr, i11, 'd', i19, false, 0);
        int iF2 = f(cArr, i12, 'h', iF, iF != i19, z10 ? 2 : 0);
        int iF3 = f(cArr, i14, 'm', iF2, iF2 != i19, z10 ? 2 : 0);
        int iF4 = f(cArr, i13, 's', iF3, iF3 != i19, z10 ? 2 : 0);
        int iF5 = f(cArr, i17, 'm', iF4, true, (!z10 || iF4 == i19) ? 0 : 3);
        cArr[iF5] = 's';
        return iF5 + 1;
    }

    public static int f(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (!z10 && i10 <= 0) {
            return i11;
        }
        if ((!z10 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        int i16 = i13 + 1;
        cArr[i16] = c10;
        return i16 + 1;
    }
}
