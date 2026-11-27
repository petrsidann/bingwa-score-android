package sc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: sc.a$a, reason: collision with other inner class name */
    public static final class C0283a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0283a f15711a = new C0283a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f15712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f15713c;

        /* JADX WARN: Code duplicated, block: B:10:0x0039  */
        static {
            Method method;
            Method method2;
            boolean z10;
            Method[] methods = Throwable.class.getMethods();
            k.b(methods);
            int length = methods.length;
            int i10 = 0;
            while (true) {
                method = null;
                if (i10 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i10];
                if (k.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k.d(parameterTypes, "getParameterTypes(...)");
                    if (k.a(mc.k.K(parameterTypes), Throwable.class)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else {
                    z10 = false;
                }
                if (z10) {
                    break;
                } else {
                    i10++;
                }
            }
            f15712b = method2;
            for (Method method3 : methods) {
                if (k.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f15713c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        k.e(cause, "cause");
        k.e(exception, "exception");
        Method method = C0283a.f15712b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public zc.c b() {
        return new zc.b();
    }
}
