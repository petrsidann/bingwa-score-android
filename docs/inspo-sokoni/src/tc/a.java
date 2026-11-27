package tc;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public class a extends sc.a {

    /* JADX INFO: renamed from: tc.a$a, reason: collision with other inner class name */
    public static final class C0289a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0289a f15919a = new C0289a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f15920b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null) {
                if (num.intValue() > 0) {
                    num2 = num;
                }
            }
            f15920b = num2;
        }
    }

    @Override // sc.a
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        k.e(cause, "cause");
        k.e(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }

    public final boolean c(int i10) {
        Integer num = C0289a.f15920b;
        return num == null || num.intValue() >= i10;
    }
}
