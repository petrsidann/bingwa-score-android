package j9;

import e9.l;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11321a;

    public static abstract class b {
        public b() {
        }

        public abstract Method a(Class<?> cls, Field field);

        public abstract <T> Constructor<T> b(Class<T> cls);

        public abstract String[] c(Class<?> cls);

        public abstract boolean d(Class<?> cls);
    }

    public static class c extends b {
        public c() {
            super();
        }

        @Override // j9.a.b
        public Method a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // j9.a.b
        public <T> Constructor<T> b(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // j9.a.b
        public String[] c(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // j9.a.b
        public boolean d(Class<?> cls) {
            return false;
        }
    }

    public static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f11322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f11323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f11324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f11325d;

        public d() throws NoSuchMethodException {
            super();
            this.f11322a = Class.class.getMethod("isRecord", new Class[0]);
            Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f11323b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f11324c = componentType.getMethod("getName", new Class[0]);
            this.f11325d = componentType.getMethod("getType", new Class[0]);
        }

        @Override // j9.a.b
        public Method a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        @Override // j9.a.b
        public <T> Constructor<T> b(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f11323b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    clsArr[i10] = (Class) this.f11325d.invoke(objArr[i10], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        @Override // j9.a.b
        public String[] c(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f11323b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    strArr[i10] = (String) this.f11324c.invoke(objArr[i10], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        @Override // j9.a.b
        public boolean d(Class<?> cls) {
            try {
                return ((Boolean) this.f11322a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (NoSuchMethodException unused) {
            cVar = new c();
        }
        f11321a = cVar;
    }

    public static void b(AccessibleObject accessibleObject, StringBuilder sb2) {
        sb2.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(parameterTypes[i10].getSimpleName());
        }
        sb2.append(')');
    }

    public static String c(Constructor<?> constructor) {
        StringBuilder sb2 = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb2);
        return sb2.toString();
    }

    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z10) {
        StringBuilder sb2;
        String strC;
        String string;
        if (!(accessibleObject instanceof Field)) {
            if (accessibleObject instanceof Method) {
                Method method = (Method) accessibleObject;
                StringBuilder sb3 = new StringBuilder(method.getName());
                b(method, sb3);
                string = "method '" + method.getDeclaringClass().getName() + "#" + sb3.toString() + "'";
            } else {
                if (accessibleObject instanceof Constructor) {
                    sb2 = new StringBuilder();
                    sb2.append("constructor '");
                    strC = c((Constructor) accessibleObject);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("<unknown AccessibleObject> ");
                    sb2.append(accessibleObject.toString());
                }
                string = sb2.toString();
            }
            if (!z10 && Character.isLowerCase(string.charAt(0))) {
                return Character.toUpperCase(string.charAt(0)) + string.substring(1);
            }
        }
        sb2 = new StringBuilder();
        sb2.append("field '");
        strC = f((Field) accessibleObject);
        sb2.append(strC);
        sb2.append("'");
        string = sb2.toString();
        return !z10 ? string : string;
    }

    public static Method h(Class<?> cls, Field field) {
        return f11321a.a(cls, field);
    }

    public static <T> Constructor<T> i(Class<T> cls) {
        return f11321a.b(cls);
    }

    public static String[] j(Class<?> cls) {
        return f11321a.c(cls);
    }

    public static boolean k(Class<?> cls) {
        return f11321a.d(cls);
    }

    public static void l(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e10) {
            throw new l("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e10);
        }
    }

    public static String m(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e10) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e10.getMessage();
        }
    }
}
