package l8;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static AssertionError a(String str, Object... objArr) {
        throw new AssertionError(c(str, objArr));
    }

    public static AssertionError b(Throwable th, String str, Object... objArr) {
        throw a.b(c(str, objArr), th);
    }

    public static String c(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static void d(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw a(str, objArr);
        }
    }

    public static <T> T e(T t10, String str, Object... objArr) {
        if (t10 != null) {
            return t10;
        }
        throw a(str, objArr);
    }
}
