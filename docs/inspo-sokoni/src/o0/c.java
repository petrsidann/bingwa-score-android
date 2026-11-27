package o0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public static class a {
        public static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        public static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(Object... objArr) {
        return a.b(objArr);
    }

    public static <T> T c(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T d(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
