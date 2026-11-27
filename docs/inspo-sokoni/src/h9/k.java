package h9;

import e9.s;
import e9.u;
import e9.x;
import e9.y;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.c f9840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9.d f9841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g9.d f9842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h9.e f9843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<u> f9844e;

    public class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f9845f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Method f9846g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f9847h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ x f9848i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ e9.e f9849j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ l9.a f9850k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f9851l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f9852m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, x xVar, e9.e eVar, l9.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f9845f = z12;
            this.f9846g = method;
            this.f9847h = z13;
            this.f9848i = xVar;
            this.f9849j = eVar;
            this.f9850k = aVar;
            this.f9851l = z14;
            this.f9852m = z15;
        }

        @Override // h9.k.c
        public void a(m9.a aVar, int i10, Object[] objArr) {
            Object objC = this.f9848i.c(aVar);
            if (objC != null || !this.f9851l) {
                objArr[i10] = objC;
                return;
            }
            throw new e9.o("null is not allowed as value for record component '" + this.f9857c + "' of primitive type; at path " + aVar.D());
        }

        @Override // h9.k.c
        public void b(m9.a aVar, Object obj) throws IllegalAccessException {
            Object objC = this.f9848i.c(aVar);
            if (objC == null && this.f9851l) {
                return;
            }
            if (this.f9845f) {
                k.b(obj, this.f9856b);
            } else if (this.f9852m) {
                throw new e9.l("Cannot set value of 'static final' " + j9.a.g(this.f9856b, false));
            }
            this.f9856b.set(obj, objC);
        }

        @Override // h9.k.c
        public void c(m9.c cVar, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.f9858d) {
                if (this.f9845f) {
                    AccessibleObject accessibleObject = this.f9846g;
                    if (accessibleObject == null) {
                        accessibleObject = this.f9856b;
                    }
                    k.b(obj, accessibleObject);
                }
                Method method = this.f9846g;
                if (method != null) {
                    try {
                        objInvoke = method.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e10) {
                        throw new e9.l("Accessor " + j9.a.g(this.f9846g, false) + " threw exception", e10.getCause());
                    }
                } else {
                    objInvoke = this.f9856b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                cVar.I(this.f9855a);
                (this.f9847h ? this.f9848i : new n(this.f9849j, this.f9848i, this.f9850k.d())).e(cVar, objInvoke);
            }
        }
    }

    public static abstract class b<T, A> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, c> f9854a;

        public b(Map<String, c> map) {
            this.f9854a = map;
        }

        @Override // e9.x
        public T c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            A aF = f();
            try {
                aVar.e();
                while (aVar.I()) {
                    c cVar = this.f9854a.get(aVar.f0());
                    if (cVar == null || !cVar.f9859e) {
                        aVar.v0();
                    } else {
                        h(aF, aVar, cVar);
                    }
                }
                aVar.B();
                return g(aF);
            } catch (IllegalAccessException e10) {
                throw j9.a.e(e10);
            } catch (IllegalStateException e11) {
                throw new s(e11);
            }
        }

        @Override // e9.x
        public void e(m9.c cVar, T t10) throws IOException {
            if (t10 == null) {
                cVar.L();
                return;
            }
            cVar.t();
            try {
                Iterator<c> it = this.f9854a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(cVar, t10);
                }
                cVar.B();
            } catch (IllegalAccessException e10) {
                throw j9.a.e(e10);
            }
        }

        public abstract A f();

        public abstract T g(A a10);

        public abstract void h(A a10, m9.a aVar, c cVar);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f9856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f9859e;

        public c(String str, Field field, boolean z10, boolean z11) {
            this.f9855a = str;
            this.f9856b = field;
            this.f9857c = field.getName();
            this.f9858d = z10;
            this.f9859e = z11;
        }

        public abstract void a(m9.a aVar, int i10, Object[] objArr);

        public abstract void b(m9.a aVar, Object obj);

        public abstract void c(m9.c cVar, Object obj);
    }

    public static final class d<T> extends b<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g9.i<T> f9860b;

        public d(g9.i<T> iVar, Map<String, c> map) {
            super(map);
            this.f9860b = iVar;
        }

        @Override // h9.k.b
        public T f() {
            return this.f9860b.a();
        }

        @Override // h9.k.b
        public T g(T t10) {
            return t10;
        }

        @Override // h9.k.b
        public void h(T t10, m9.a aVar, c cVar) {
            cVar.b(aVar, t10);
        }
    }

    public static final class e<T> extends b<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map<Class<?>, Object> f9861e = k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor<T> f9862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f9863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f9864d;

        public e(Class<T> cls, Map<String, c> map, boolean z10) {
            super(map);
            this.f9864d = new HashMap();
            Constructor<T> constructorI = j9.a.i(cls);
            this.f9862b = constructorI;
            if (z10) {
                k.b(null, constructorI);
            } else {
                j9.a.l(constructorI);
            }
            String[] strArrJ = j9.a.j(cls);
            for (int i10 = 0; i10 < strArrJ.length; i10++) {
                this.f9864d.put(strArrJ[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f9862b.getParameterTypes();
            this.f9863c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f9863c[i11] = f9861e.get(parameterTypes[i11]);
            }
        }

        public static Map<Class<?>, Object> k() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        @Override // h9.k.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object[] f() {
            return (Object[]) this.f9863c.clone();
        }

        @Override // h9.k.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public T g(Object[] objArr) {
            try {
                return this.f9862b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw j9.a.e(e10);
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Failed to invoke constructor '" + j9.a.c(this.f9862b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e12) {
                e = e12;
                throw new RuntimeException("Failed to invoke constructor '" + j9.a.c(this.f9862b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Failed to invoke constructor '" + j9.a.c(this.f9862b) + "' with args " + Arrays.toString(objArr), e13.getCause());
            }
        }

        @Override // h9.k.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Object[] objArr, m9.a aVar, c cVar) {
            Integer num = this.f9864d.get(cVar.f9857c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + j9.a.c(this.f9862b) + "' for field with name '" + cVar.f9857c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(g9.c cVar, e9.d dVar, g9.d dVar2, h9.e eVar, List<u> list) {
        this.f9840a = cVar;
        this.f9841b = dVar;
        this.f9842c = dVar2;
        this.f9843d = eVar;
        this.f9844e = list;
    }

    public static <M extends AccessibleObject & Member> void b(Object obj, M m10) {
        if (Modifier.isStatic(m10.getModifiers())) {
            obj = null;
        }
        if (g9.l.a(m10, obj)) {
            return;
        }
        throw new e9.l(j9.a.g(m10, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    public final c c(e9.e eVar, Field field, Method method, String str, l9.a<?> aVar, boolean z10, boolean z11, boolean z12) {
        boolean zA = g9.k.a(aVar.c());
        int modifiers = field.getModifiers();
        boolean z13 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        f9.b bVar = (f9.b) field.getAnnotation(f9.b.class);
        x<?> xVarA = bVar != null ? this.f9843d.a(this.f9840a, eVar, aVar, bVar) : null;
        boolean z14 = xVarA != null;
        if (xVarA == null) {
            xVarA = eVar.l(aVar);
        }
        return new a(str, field, z10, z11, z12, method, z14, xVarA, eVar, aVar, zA, z13);
    }

    @Override // e9.y
    public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
        Class<? super T> clsC = aVar.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        u.a aVarB = g9.l.b(this.f9844e, clsC);
        if (aVarB != u.a.BLOCK_ALL) {
            boolean z10 = aVarB == u.a.BLOCK_INACCESSIBLE;
            return j9.a.k(clsC) ? new e(clsC, d(eVar, aVar, clsC, z10, true), z10) : new d(this.f9840a.b(aVar), d(eVar, aVar, clsC, z10, false));
        }
        throw new e9.l("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r22v0 */
    public final Map<String, c> d(e9.e eVar, l9.a<?> aVar, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        Method method;
        int i10;
        int i11;
        boolean z13;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        l9.a<?> aVarB = aVar;
        boolean z14 = z10;
        Class<?> clsC = cls;
        while (clsC != Object.class) {
            Field[] declaredFields = clsC.getDeclaredFields();
            boolean z15 = true;
            boolean z16 = false;
            if (clsC != cls && declaredFields.length > 0) {
                u.a aVarB2 = g9.l.b(this.f9844e, clsC);
                if (aVarB2 == u.a.BLOCK_ALL) {
                    throw new e9.l("ReflectionAccessFilter does not permit using reflection for " + clsC + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z14 = aVarB2 == u.a.BLOCK_INACCESSIBLE;
            }
            boolean z17 = z14;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean zF = this.f(field, z15);
                boolean zF2 = this.f(field, z16);
                if (zF || zF2) {
                    c cVar = null;
                    if (!z11) {
                        z12 = zF2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z12 = z16;
                    } else {
                        Method methodH = j9.a.h(clsC, field);
                        if (!z17) {
                            j9.a.l(methodH);
                        }
                        if (methodH.getAnnotation(f9.c.class) != null && field.getAnnotation(f9.c.class) == null) {
                            throw new e9.l("@SerializedName on " + j9.a.g(methodH, z16) + " is not supported");
                        }
                        z12 = zF2;
                        method = methodH;
                    }
                    if (!z17 && method == null) {
                        j9.a.l(field);
                    }
                    Type typeO = g9.b.o(aVarB.d(), clsC, field.getGenericType());
                    List<String> listE = this.e(field);
                    int size = listE.size();
                    ?? r10 = z16;
                    while (r10 < size) {
                        String str = listE.get(r10);
                        boolean z18 = r10 != 0 ? z16 : zF;
                        ?? r22 = r10;
                        c cVar2 = cVar;
                        int i13 = size;
                        List<String> list = listE;
                        Field field2 = field;
                        int i14 = i12;
                        int i15 = length;
                        boolean z19 = z16;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, c(eVar, field, method, str, l9.a.b(typeO), z18, z12, z17)) : cVar2;
                        zF = z18;
                        i12 = i14;
                        size = i13;
                        listE = list;
                        field = field2;
                        length = i15;
                        z16 = z19;
                        r10 = (r22 == true ? 1 : 0) + 1;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.f9855a + "'; conflict is caused by fields " + j9.a.f(cVar3.f9856b) + " and " + j9.a.f(field3));
                    }
                } else {
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                }
                i12 = i10 + 1;
                z15 = true;
                this = this;
                length = i11;
                z16 = z13;
            }
            aVarB = l9.a.b(g9.b.o(aVarB.d(), clsC, clsC.getGenericSuperclass()));
            clsC = aVarB.c();
            z14 = z17;
        }
        return linkedHashMap;
    }

    public final List<String> e(Field field) {
        f9.c cVar = (f9.c) field.getAnnotation(f9.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f9841b.d(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    public final boolean f(Field field, boolean z10) {
        return (this.f9842c.b(field.getType(), z10) || this.f9842c.f(field, z10)) ? false : true;
    }
}
