package f8;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8253a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f8253a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8253a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8253a[RoundingMode.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8253a[RoundingMode.CEILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8253a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8253a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8253a[RoundingMode.HALF_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8253a[RoundingMode.HALF_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i10, int i11, RoundingMode roundingMode) {
        if (i11 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i12 = i10 / i11;
        int i13 = i10 - (i11 * i12);
        if (i13 == 0) {
            return i12;
        }
        boolean z10 = true;
        int i14 = ((i10 ^ i11) >> 31) | 1;
        switch (a.f8253a[roundingMode.ordinal()]) {
            case 1:
            case 2:
                z10 = false;
                break;
            case 3:
                break;
            case 4:
                if (i14 <= 0) {
                    z10 = false;
                }
                break;
            case 5:
                if (i14 >= 0) {
                    z10 = false;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i13);
                int iAbs2 = iAbs - (Math.abs(i11) - iAbs);
                if (iAbs2 != 0) {
                    if (iAbs2 <= 0) {
                        z10 = false;
                    }
                } else if (roundingMode != RoundingMode.HALF_UP) {
                    if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i12 & 1) != 0))) {
                        z10 = false;
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return z10 ? i12 + i14 : i12;
    }
}
