package l8;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f12593a = b.WARN;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12594a;

        static {
            int[] iArr = new int[b.values().length];
            f12594a = iArr;
            try {
                iArr[b.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12594a[b.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12594a[b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        DEBUG,
        WARN,
        NONE
    }

    public static void a(String str, String str2, Object... objArr) {
        b(b.DEBUG, str, str2, objArr);
    }

    public static void b(b bVar, String str, String str2, Object... objArr) {
        if (bVar.ordinal() >= f12593a.ordinal()) {
            String str3 = String.format("(%s) [%s]: ", "25.1.2", str) + String.format(str2, objArr);
            int i10 = a.f12594a[bVar.ordinal()];
            if (i10 == 1) {
                Log.i("Firestore", str3);
            } else if (i10 == 2) {
                Log.w("Firestore", str3);
            } else if (i10 == 3) {
                throw new IllegalStateException("Trying to log something on level NONE");
            }
        }
    }

    public static boolean c() {
        return f12593a.ordinal() >= b.DEBUG.ordinal();
    }

    public static void d(b bVar) {
        f12593a = bVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        b(b.WARN, str, str2, objArr);
    }
}
