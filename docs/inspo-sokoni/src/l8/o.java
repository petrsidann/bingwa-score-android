package l8;

import android.net.Uri;
import b8.j1;
import b8.q0;
import b8.q1;
import b8.r0;
import b8.v1;
import b8.z1;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<Class<?>, a<?>> f12564a = new ConcurrentHashMap();

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f12565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor<T> f12566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f12568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f12569e = new HashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, Method> f12571g = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Method> f12570f = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Field> f12572h = new HashMap();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final HashSet<String> f12573i = new HashSet<>();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final HashSet<String> f12574j = new HashSet<>();

        public a(Class<T> cls) {
            Constructor<T> declaredConstructor;
            this.f12565a = cls;
            this.f12567c = cls.isAnnotationPresent(v1.class);
            this.f12568d = !cls.isAnnotationPresent(r0.class);
            try {
                declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                declaredConstructor = null;
            }
            this.f12566b = declaredConstructor;
            for (Method method : cls.getMethods()) {
                if (n(method)) {
                    String strJ = j(method);
                    b(strJ);
                    method.setAccessible(true);
                    if (this.f12570f.containsKey(strJ)) {
                        throw new RuntimeException("Found conflicting getters for name " + method.getName() + " on class " + cls.getName());
                    }
                    this.f12570f.put(strJ, method);
                    e(method);
                }
            }
            for (Field field : cls.getFields()) {
                if (m(field)) {
                    b(i(field));
                    d(field);
                }
            }
            HashMap map = new HashMap();
            Class<T> superclass = cls;
            do {
                for (Method method2 : superclass.getDeclaredMethods()) {
                    if (o(method2)) {
                        String strJ2 = j(method2);
                        String str = this.f12569e.get(strJ2.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else {
                            if (!str.equals(strJ2)) {
                                throw new RuntimeException("Found setter on " + superclass.getName() + " with invalid case-sensitive name: " + method2.getName());
                            }
                            if (method2.isBridge()) {
                                map.put(strJ2, method2);
                            } else {
                                Method method3 = this.f12571g.get(strJ2);
                                Method method4 = (Method) map.get(strJ2);
                                if (method3 == null) {
                                    method2.setAccessible(true);
                                    this.f12571g.put(strJ2, method2);
                                    f(method2);
                                } else if (!h(method2, method3) && (method4 == null || !h(method2, method4))) {
                                    if (superclass == cls) {
                                        throw new RuntimeException("Class " + cls.getName() + " has multiple setter overloads with name " + method2.getName());
                                    }
                                    throw new RuntimeException("Found conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                                }
                            }
                        }
                    }
                }
                for (Field field2 : superclass.getDeclaredFields()) {
                    String strI = i(field2);
                    if (this.f12569e.containsKey(strI.toLowerCase(Locale.US)) && !this.f12572h.containsKey(strI)) {
                        field2.setAccessible(true);
                        this.f12572h.put(strI, field2);
                        d(field2);
                    }
                }
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    break;
                }
            } while (!superclass.equals(Object.class));
            if (this.f12569e.isEmpty()) {
                throw new RuntimeException("No properties to serialize found on class " + cls.getName());
            }
            for (String str2 : this.f12574j) {
                if (!this.f12571g.containsKey(str2) && !this.f12572h.containsKey(str2)) {
                    throw new RuntimeException("@DocumentId is annotated on property " + str2 + " of class " + cls.getName() + " but no field or public setter was found");
                }
            }
        }

        public static String c(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(j1.class)) {
                return ((j1) accessibleObject.getAnnotation(j1.class)).value();
            }
            return null;
        }

        public static boolean h(Method method, Method method2) {
            o.d(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            o.d(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            o.d(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            o.d(parameterTypes.length == 1, "Expected exactly one parameter");
            o.d(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        public static String i(Field field) {
            String strC = c(field);
            return strC != null ? strC : field.getName();
        }

        public static String j(Method method) {
            String strC = c(method);
            return strC != null ? strC : l(method.getName());
        }

        public static String l(String str) {
            String[] strArr = {"get", "set", "is"};
            String str2 = null;
            for (int i10 = 0; i10 < 3; i10++) {
                String str3 = strArr[i10];
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
            }
            char[] charArray = str.substring(str2.length()).toCharArray();
            for (int i11 = 0; i11 < charArray.length && Character.isUpperCase(charArray[i11]); i11++) {
                charArray[i11] = Character.toLowerCase(charArray[i11]);
            }
            return new String(charArray);
        }

        public static boolean m(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(b8.s.class)) ? false : true;
        }

        public static boolean n(Method method) {
            return ((!method.getName().startsWith("get") && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isBridge() || method.isAnnotationPresent(b8.s.class)) ? false : true;
        }

        public static boolean o(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(b8.s.class);
        }

        public final void b(String str) {
            Map<String, String> map = this.f12569e;
            Locale locale = Locale.US;
            String strPut = map.put(str.toLowerCase(locale), str);
            if (strPut == null || str.equals(strPut)) {
                return;
            }
            throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(locale));
        }

        public final void d(Field field) {
            if (field.isAnnotationPresent(q1.class)) {
                Class<?> type = field.getType();
                if (type != Date.class && type != h7.q.class) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + type + " instead of Date or Timestamp.");
                }
                this.f12573i.add(i(field));
            }
            if (field.isAnnotationPresent(b8.h.class)) {
                g("Field", "is", field.getType());
                this.f12574j.add(i(field));
            }
        }

        public final void e(Method method) {
            if (method.isAnnotationPresent(q1.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType != Date.class && returnType != h7.q.class) {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
                this.f12573i.add(j(method));
            }
            if (method.isAnnotationPresent(b8.h.class)) {
                g("Method", "returns", method.getReturnType());
                this.f12574j.add(j(method));
            }
        }

        public final void f(Method method) {
            if (method.isAnnotationPresent(q1.class)) {
                throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            }
            if (method.isAnnotationPresent(b8.h.class)) {
                g("Method", "accepts", method.getParameterTypes()[0]);
                this.f12574j.add(j(method));
            }
        }

        public final void g(String str, String str2, Type type) {
            if (type == String.class || type == com.google.firebase.firestore.c.class) {
                return;
            }
            throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + " " + type + " instead of String or DocumentReference.");
        }

        public Map<String, Object> k(T t10, b bVar) {
            Object objA;
            if (!this.f12565a.isAssignableFrom(t10.getClass())) {
                throw new IllegalArgumentException("Can't serialize object of class " + t10.getClass() + " with BeanMapper for class " + this.f12565a);
            }
            HashMap map = new HashMap();
            for (String str : this.f12569e.values()) {
                if (!this.f12574j.contains(str)) {
                    if (this.f12570f.containsKey(str)) {
                        objA = l8.a.a(this.f12570f.get(str), t10, new Object[0]);
                    } else {
                        Field field = this.f12572h.get(str);
                        if (field == null) {
                            throw new IllegalStateException("Bean property without field or getter: " + str);
                        }
                        try {
                            objA = field.get(t10);
                        } catch (IllegalAccessException e10) {
                            throw new RuntimeException(e10);
                        }
                    }
                    map.put(str, (this.f12573i.contains(str) && objA == null) ? b8.u.g() : o.g(objA, bVar.a(str)));
                }
            }
            return map;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f12575d = new b(null, null, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f12577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12578c;

        public b(b bVar, String str, int i10) {
            this.f12577b = bVar;
            this.f12578c = str;
            this.f12576a = i10;
        }

        public b a(String str) {
            return new b(this, str, this.f12576a + 1);
        }

        public int b() {
            return this.f12576a;
        }

        public String toString() {
            int i10 = this.f12576a;
            if (i10 == 0) {
                return "";
            }
            if (i10 == 1) {
                return this.f12578c;
            }
            return this.f12577b.toString() + "." + this.f12578c;
        }
    }

    public static Object c(Object obj) {
        return f(obj);
    }

    public static void d(boolean z10, String str) {
        if (z10) {
            return;
        }
        throw new RuntimeException("Hard assert failed: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> a<T> e(Class<T> cls) {
        ConcurrentMap<Class<?>, a<?>> concurrentMap = f12564a;
        a<T> aVar = (a) concurrentMap.get(cls);
        if (aVar != null) {
            return aVar;
        }
        a<T> aVar2 = (a<T>) new a(cls);
        concurrentMap.put((Class<?>) cls, (a<?>) aVar2);
        return aVar2;
    }

    public static <T> Object f(T t10) {
        return g(t10, b.f12575d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Object g(T t10, b bVar) {
        if (bVar.b() > 500) {
            throw h(bVar, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
        }
        if (t10 == 0) {
            return null;
        }
        if (t10 instanceof Number) {
            if ((t10 instanceof Long) || (t10 instanceof Integer) || (t10 instanceof Double) || (t10 instanceof Float)) {
                return t10;
            }
            throw h(bVar, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t10.getClass().getSimpleName()));
        }
        if ((t10 instanceof String) || (t10 instanceof Boolean)) {
            return t10;
        }
        if (t10 instanceof Character) {
            throw h(bVar, "Characters are not supported, please use Strings");
        }
        if (t10 instanceof Map) {
            HashMap map = new HashMap();
            for (Map.Entry entry : ((Map) t10).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw h(bVar, "Maps with non-string keys are not supported");
                }
                String str = (String) key;
                map.put(str, g(entry.getValue(), bVar.a(str)));
            }
            return map;
        }
        if (t10 instanceof Collection) {
            if (!(t10 instanceof List)) {
                throw h(bVar, "Serializing Collections is not supported, please use Lists instead");
            }
            List list = (List) t10;
            ArrayList arrayList = new ArrayList(list.size());
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(g(list.get(i10), bVar.a("[" + i10 + "]")));
            }
            return arrayList;
        }
        if (t10.getClass().isArray()) {
            throw h(bVar, "Serializing Arrays is not supported, please use Lists instead");
        }
        if (t10 instanceof Enum) {
            String strName = ((Enum) t10).name();
            try {
                return a.i(t10.getClass().getField(strName));
            } catch (NoSuchFieldException unused) {
                return strName;
            }
        }
        if ((t10 instanceof Date) || (t10 instanceof h7.q) || (t10 instanceof q0) || (t10 instanceof b8.e) || (t10 instanceof com.google.firebase.firestore.c) || (t10 instanceof b8.u) || (t10 instanceof z1)) {
            return t10;
        }
        return ((t10 instanceof Uri) || (t10 instanceof URI) || (t10 instanceof URL)) ? t10.toString() : e(t10.getClass()).k(t10, bVar);
    }

    public static IllegalArgumentException h(b bVar, String str) {
        String str2 = "Could not serialize object. " + str;
        if (bVar.b() > 0) {
            str2 = str2 + " (found in field '" + bVar.toString() + "')";
        }
        return new IllegalArgumentException(str2);
    }
}
