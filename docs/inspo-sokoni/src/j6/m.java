package j6;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static String a(int i10, int i11, String str) {
        if (i10 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }

    public static String b(int i10, int i11, String str) {
        if (i10 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }

    public static String c(int i10, int i11, int i12) {
        if (i10 < 0 || i10 > i12) {
            return b(i10, i12, "start index");
        }
        return (i11 < 0 || i11 > i12) ? b(i11, i12, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public static void d(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z10, String str, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c10)));
        }
    }

    public static void g(boolean z10, String str, char c10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c10), obj));
        }
    }

    public static void h(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i10)));
        }
    }

    public static void i(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void j(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j10)));
        }
    }

    public static void k(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static void l(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw new IllegalArgumentException(q.b(str, obj, obj2));
        }
    }

    public static int m(int i10, int i11) {
        return n(i10, i11, "index");
    }

    public static int n(int i10, int i11, String str) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a(i10, i11, str));
        }
        return i10;
    }

    public static <T> T o(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T p(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T q(T t10, String str, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(q.b(str, obj));
    }

    public static int r(int i10, int i11) {
        return s(i10, i11, "index");
    }

    public static int s(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(b(i10, i11, str));
        }
        return i10;
    }

    public static void t(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException(c(i10, i11, i12));
        }
    }

    public static void u(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void v(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void w(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalStateException(q.b(str, Integer.valueOf(i10)));
        }
    }

    public static void x(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }
}
