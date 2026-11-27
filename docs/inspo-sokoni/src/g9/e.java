package g9;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9072a = a();

    public static int a() {
        return c(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb2.append(cCharAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c(String str) {
        int iE = e(str);
        if (iE == -1) {
            iE = b(str);
        }
        if (iE == -1) {
            return 6;
        }
        return iE;
    }

    public static boolean d() {
        return f9072a >= 9;
    }

    public static int e(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i10 = Integer.parseInt(strArrSplit[0]);
            return (i10 != 1 || strArrSplit.length <= 1) ? i10 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
