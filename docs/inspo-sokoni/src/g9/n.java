package g9;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9107a = c();

    public class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f9108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f9109c;

        public a(Method method, Object obj) {
            this.f9108b = method;
            this.f9109c = obj;
        }

        @Override // g9.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9108b.invoke(this.f9109c, cls);
        }
    }

    public class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f9110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f9111c;

        public b(Method method, int i10) {
            this.f9110b = method;
            this.f9111c = i10;
        }

        @Override // g9.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9110b.invoke(null, cls, Integer.valueOf(this.f9111c));
        }
    }

    public class c extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f9112b;

        public c(Method method) {
            this.f9112b = method;
        }

        @Override // g9.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9112b.invoke(null, cls, Object.class);
        }
    }

    public class d extends n {
        @Override // g9.n
        public <T> T d(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void b(Class<?> cls) {
        String strA = g9.c.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    public static n c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T d(Class<T> cls);
}
