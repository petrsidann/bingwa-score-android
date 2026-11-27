package je;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureRandom f11409a = new SecureRandom();

    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    public static Integer a(Object obj) {
        int iOrdinal;
        if (obj == null) {
            iOrdinal = 0;
        } else if (obj instanceof Number) {
            iOrdinal = ((Number) obj).intValue();
        } else if (obj instanceof Enum) {
            iOrdinal = ((Enum) obj).ordinal();
        } else if (obj instanceof String) {
            try {
                iOrdinal = Integer.parseInt((String) obj);
            } catch (Exception e10) {
                e10.printStackTrace();
                iOrdinal = 0;
            }
        } else {
            iOrdinal = 0;
        }
        return Integer.valueOf(iOrdinal);
    }

    public static Integer b(Object obj, Object obj2) {
        return obj == null ? a(obj2) : a(obj);
    }

    public static int c() {
        int iNextInt = f11409a.nextInt();
        return iNextInt < 0 ? iNextInt * (-1) : iNextInt;
    }

    public static Boolean d(Integer num, Integer num2, Integer num3) {
        return Boolean.valueOf(num.intValue() >= num2.intValue() && num.intValue() <= num3.intValue());
    }
}
