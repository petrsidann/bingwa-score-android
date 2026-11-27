package g9;

import e9.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Type, e9.g<?>> f9037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<u> f9039c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: g9.c$c, reason: collision with other inner class name */
    public class C0154c<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> implements g9.i<T> {
        @Override // g9.i
        public T a() {
            return (T) new g9.h();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9040a;

        public j(Class cls) {
            this.f9040a = cls;
        }

        @Override // g9.i
        public T a() {
            try {
                return (T) g9.n.f9107a.d(this.f9040a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f9040a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class k<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e9.g f9042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f9043b;

        public k(e9.g gVar, Type type) {
            this.f9042a = gVar;
            this.f9043b = type;
        }

        @Override // g9.i
        public T a() {
            return (T) this.f9042a.a(this.f9043b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class l<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9045a;

        public l(String str) {
            this.f9045a = str;
        }

        @Override // g9.i
        public T a() {
            throw new e9.l(this.f9045a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class m<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e9.g f9047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f9048b;

        public m(e9.g gVar, Type type) {
            this.f9047a = gVar;
            this.f9048b = type;
        }

        @Override // g9.i
        public T a() {
            return (T) this.f9047a.a(this.f9048b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class n<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9050a;

        public n(String str) {
            this.f9050a = str;
        }

        @Override // g9.i
        public T a() {
            throw new e9.l(this.f9050a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class o<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9052a;

        public o(String str) {
            this.f9052a = str;
        }

        @Override // g9.i
        public T a() {
            throw new e9.l(this.f9052a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class p<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f9054a;

        public p(Type type) {
            this.f9054a = type;
        }

        @Override // g9.i
        public T a() {
            Type type = this.f9054a;
            if (!(type instanceof ParameterizedType)) {
                throw new e9.l("Invalid EnumSet type: " + this.f9054a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new e9.l("Invalid EnumSet type: " + this.f9054a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class q<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f9055a;

        public q(Type type) {
            this.f9055a = type;
        }

        @Override // g9.i
        public T a() {
            Type type = this.f9055a;
            if (!(type instanceof ParameterizedType)) {
                throw new e9.l("Invalid EnumMap type: " + this.f9055a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new e9.l("Invalid EnumMap type: " + this.f9055a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class r<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9056a;

        public r(String str) {
            this.f9056a = str;
        }

        @Override // g9.i
        public T a() {
            throw new e9.l(this.f9056a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class s<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9057a;

        public s(String str) {
            this.f9057a = str;
        }

        @Override // g9.i
        public T a() {
            throw new e9.l(this.f9057a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class t<T> implements g9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Constructor f9058a;

        public t(Constructor constructor) {
            this.f9058a = constructor;
        }

        @Override // g9.i
        public T a() {
            try {
                return (T) this.f9058a.newInstance(new Object[0]);
            } catch (IllegalAccessException e10) {
                throw j9.a.e(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + j9.a.c(this.f9058a) + "' with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + j9.a.c(this.f9058a) + "' with no args", e12.getCause());
            }
        }
    }

    public c(Map<Type, e9.g<?>> map, boolean z10, List<u> list) {
        this.f9037a = map;
        this.f9038b = z10;
        this.f9039c = list;
    }

    public static String a(Class<?> cls) {
        StringBuilder sb2;
        String str;
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            sb2 = new StringBuilder();
            str = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
        } else {
            if (!Modifier.isAbstract(modifiers)) {
                return null;
            }
            sb2 = new StringBuilder();
            str = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        }
        sb2.append(str);
        sb2.append(cls.getName());
        return sb2.toString();
    }

    public static <T> g9.i<T> c(Class<? super T> cls, u.a aVar) {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z10 = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            u.a aVar2 = u.a.ALLOW;
            if (aVar == aVar2 || (g9.l.a(declaredConstructor, null) && (aVar != u.a.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z10 = true;
            }
            if (z10) {
                return (aVar != aVar2 || (strM = j9.a.m(declaredConstructor)) == null) ? new t(declaredConstructor) : new s(strM);
            }
            return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> g9.i<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new C0154c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(l9.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new i() : new h();
    }

    public static <T> g9.i<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    public <T> g9.i<T> b(l9.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        e9.g<?> gVar = this.f9037a.get(typeD);
        if (gVar != null) {
            return new k(gVar, typeD);
        }
        e9.g<?> gVar2 = this.f9037a.get(clsC);
        if (gVar2 != null) {
            return new m(gVar2, typeD);
        }
        g9.i<T> iVarE = e(typeD, clsC);
        if (iVarE != null) {
            return iVarE;
        }
        u.a aVarB = g9.l.b(this.f9039c, clsC);
        g9.i<T> iVarC = c(clsC, aVarB);
        if (iVarC != null) {
            return iVarC;
        }
        g9.i<T> iVarD = d(typeD, clsC);
        if (iVarD != null) {
            return iVarD;
        }
        String strA = a(clsC);
        if (strA != null) {
            return new n(strA);
        }
        if (aVarB == u.a.ALLOW) {
            return f(clsC);
        }
        return new o("Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public final <T> g9.i<T> f(Class<? super T> cls) {
        if (this.f9038b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public String toString() {
        return this.f9037a.toString();
    }
}
