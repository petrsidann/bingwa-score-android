package f7;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    @Deprecated
    public static int a() {
        Integer numA = z6.q.a();
        if (numA != null) {
            return numA.intValue();
        }
        return -1;
    }

    public static boolean b() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }
}
