package xb;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 implements e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f18145b = Logger.getLogger(a2.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f18146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f18147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f18148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f18149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f18150g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18151a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        RuntimeException runtimeException = null;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", new Class[0]);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i10];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f18145b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                    constructor = null;
                }
            } catch (Throwable th2) {
                th = th2;
                method2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
            method2 = null;
        }
        if (th != null || constructor == null) {
            f18146c = null;
            f18147d = null;
            f18148e = null;
            runtimeException = new RuntimeException(th);
        } else {
            f18146c = constructor;
            f18147d = method;
            f18148e = method2;
        }
        f18149f = runtimeException;
        f18150g = new Object[]{1L};
    }

    public a2() {
        RuntimeException runtimeException = f18149f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f18151a = f18146c.newInstance(new Object[0]);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static boolean a() {
        return f18149f == null;
    }

    @Override // xb.e1
    public void add(long j10) {
        try {
            f18147d.invoke(this.f18151a, j10 == 1 ? f18150g : new Object[]{Long.valueOf(j10)});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
