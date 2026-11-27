package g9;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f9030a = new Type[0];

    public static final class a implements GenericArrayType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f9031a;

        public a(Type type) {
            Objects.requireNonNull(type);
            this.f9031a = b.b(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.f(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f9031a;
        }

        public int hashCode() {
            return this.f9031a.hashCode();
        }

        public String toString() {
            return b.t(this.f9031a) + "[]";
        }
    }

    /* JADX INFO: renamed from: g9.b$b, reason: collision with other inner class name */
    public static final class C0153b implements ParameterizedType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f9032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f9033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f9034c;

        public C0153b(Type type, Type type2, Type... typeArr) {
            Objects.requireNonNull(type2);
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z10 = true;
                boolean z11 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z11) {
                    z10 = false;
                }
                g9.a.a(z10);
            }
            this.f9032a = type == null ? null : b.b(type);
            this.f9033b = b.b(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f9034c = typeArr2;
            int length = typeArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                Objects.requireNonNull(this.f9034c[i10]);
                b.c(this.f9034c[i10]);
                Type[] typeArr3 = this.f9034c;
                typeArr3[i10] = b.b(typeArr3[i10]);
            }
        }

        public static int a(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.f(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f9034c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f9032a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f9033b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f9034c) ^ this.f9033b.hashCode()) ^ a(this.f9032a);
        }

        public String toString() {
            int length = this.f9034c.length;
            if (length == 0) {
                return b.t(this.f9033b);
            }
            StringBuilder sb2 = new StringBuilder((length + 1) * 30);
            sb2.append(b.t(this.f9033b));
            sb2.append("<");
            sb2.append(b.t(this.f9034c[0]));
            for (int i10 = 1; i10 < length; i10++) {
                sb2.append(", ");
                sb2.append(b.t(this.f9034c[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    public static final class c implements WildcardType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f9035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f9036b;

        public c(Type[] typeArr, Type[] typeArr2) {
            g9.a.a(typeArr2.length <= 1);
            g9.a.a(typeArr.length == 1);
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                b.c(typeArr[0]);
                this.f9036b = null;
                this.f9035a = b.b(typeArr[0]);
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            b.c(typeArr2[0]);
            g9.a.a(typeArr[0] == Object.class);
            this.f9036b = b.b(typeArr2[0]);
            this.f9035a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.f(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f9036b;
            return type != null ? new Type[]{type} : b.f9030a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f9035a};
        }

        public int hashCode() {
            Type type = this.f9036b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f9035a.hashCode() + 31);
        }

        public String toString() {
            StringBuilder sb2;
            Type type;
            if (this.f9036b != null) {
                sb2 = new StringBuilder();
                sb2.append("? super ");
                type = this.f9036b;
            } else {
                if (this.f9035a == Object.class) {
                    return "?";
                }
                sb2 = new StringBuilder();
                sb2.append("? extends ");
                type = this.f9035a;
            }
            sb2.append(b.t(type));
            return sb2.toString();
        }
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static Type b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(b(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0153b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void c(Type type) {
        g9.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static Class<?> d(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static boolean e(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean f(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return e(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return f(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type h(Type type, Class<?> cls) {
        Type typeL = l(type, cls, Collection.class);
        return typeL instanceof ParameterizedType ? ((ParameterizedType) typeL).getActualTypeArguments()[0] : Object.class;
    }

    public static Type i(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> cls3 = interfaces[i10];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return i(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return i(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type[] j(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeL = l(type, cls, Map.class);
        return typeL instanceof ParameterizedType ? ((ParameterizedType) typeL).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Class<?> k(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            g9.a.a(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(k(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return k(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static Type l(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        g9.a.a(cls2.isAssignableFrom(cls));
        return o(type, cls, i(type, cls, cls2));
    }

    public static int m(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType n(Type type, Type type2, Type... typeArr) {
        return new C0153b(type, type2, typeArr);
    }

    public static Type o(Type type, Class<?> cls, Type type2) {
        return p(type, cls, type2, new HashMap());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1 A[EDGE_INSN: B:50:0x00c1->B:56:0x00d7 BREAK  A[LOOP:0: B:3:0x0001->B:62:?]] */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:65:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (e(r1, r9) != false) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type p(Type type, Class<?> cls, Type type2, Map<TypeVariable<?>, Type> map) {
        int i10;
        Type[] lowerBounds;
        Type[] upperBounds;
        Type typeP;
        Type typeP2;
        Type typeP3;
        boolean z10;
        Type[] actualTypeArguments;
        int length;
        Type typeN;
        Type typeP4;
        Type typeP5;
        TypeVariable typeVariable;
        TypeVariable typeVariable2 = null;
        do {
            if (type2 instanceof TypeVariable) {
                typeVariable = (TypeVariable) type2;
                Type type3 = (Type) map.get(typeVariable);
                if (type3 != null) {
                    return type3 == Void.TYPE ? type2 : type3;
                }
                map.put(typeVariable, Void.TYPE);
                if (typeVariable2 == null) {
                    typeVariable2 = typeVariable;
                }
                type2 = q(type, cls, typeVariable);
            } else if (type2 instanceof Class) {
                Class cls2 = (Class) type2;
                if (cls2.isArray()) {
                    Class<?> componentType = cls2.getComponentType();
                    typeP5 = p(type, cls, componentType, map);
                    if (!e(componentType, typeP5)) {
                        typeN = a(typeP5);
                        type2 = typeN;
                        break;
                    }
                    type2 = cls2;
                    break;
                }
                if (type2 instanceof GenericArrayType) {
                    if (type2 instanceof ParameterizedType) {
                        if (type2 instanceof WildcardType) {
                            break;
                        }
                        type2 = (WildcardType) type2;
                        lowerBounds = type2.getLowerBounds();
                        upperBounds = type2.getUpperBounds();
                        if (lowerBounds.length == 1) {
                            if (upperBounds.length != 1 && (typeP = p(type, cls, upperBounds[0], map)) != upperBounds[0]) {
                                type2 = r(typeP);
                                break;
                            }
                            break;
                            break;
                        }
                        typeP2 = p(type, cls, lowerBounds[0], map);
                        if (typeP2 != lowerBounds[0]) {
                            break;
                        }
                        type2 = s(typeP2);
                        break;
                    }
                    type2 = (ParameterizedType) type2;
                    Type ownerType = type2.getOwnerType();
                    typeP3 = p(type, cls, ownerType, map);
                    z10 = !e(typeP3, ownerType);
                    actualTypeArguments = type2.getActualTypeArguments();
                    length = actualTypeArguments.length;
                    while (i10 < length) {
                        typeP4 = p(type, cls, actualTypeArguments[i10], map);
                        if (e(typeP4, actualTypeArguments[i10])) {
                            if (!z10) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z10 = true;
                            }
                            actualTypeArguments[i10] = typeP4;
                        }
                    }
                    if (z10) {
                        break;
                    }
                    typeN = n(typeP3, type2.getRawType(), actualTypeArguments);
                    type2 = typeN;
                    break;
                }
                type2 = (GenericArrayType) type2;
                Type genericComponentType = type2.getGenericComponentType();
                typeP5 = p(type, cls, genericComponentType, map);
            } else {
                if (type2 instanceof GenericArrayType) {
                    if (type2 instanceof ParameterizedType) {
                        if (type2 instanceof WildcardType) {
                            break;
                        }
                        type2 = (WildcardType) type2;
                        lowerBounds = type2.getLowerBounds();
                        upperBounds = type2.getUpperBounds();
                        if (lowerBounds.length == 1) {
                            if (upperBounds.length != 1) {
                                break;
                            }
                            type2 = r(typeP);
                            break;
                        }
                        typeP2 = p(type, cls, lowerBounds[0], map);
                        if (typeP2 != lowerBounds[0]) {
                            break;
                        }
                        type2 = s(typeP2);
                        break;
                    }
                    type2 = (ParameterizedType) type2;
                    Type ownerType2 = type2.getOwnerType();
                    typeP3 = p(type, cls, ownerType2, map);
                    z10 = !e(typeP3, ownerType2);
                    actualTypeArguments = type2.getActualTypeArguments();
                    length = actualTypeArguments.length;
                    for (i10 = 0; i10 < length; i10++) {
                        typeP4 = p(type, cls, actualTypeArguments[i10], map);
                        if (e(typeP4, actualTypeArguments[i10])) {
                            if (!z10) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z10 = true;
                            }
                            actualTypeArguments[i10] = typeP4;
                        }
                    }
                    if (z10) {
                        break;
                    }
                    typeN = n(typeP3, type2.getRawType(), actualTypeArguments);
                    type2 = typeN;
                    break;
                }
                type2 = (GenericArrayType) type2;
                Type genericComponentType2 = type2.getGenericComponentType();
                typeP5 = p(type, cls, genericComponentType2, map);
            }
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    public static Type q(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsD = d(typeVariable);
        if (clsD == null) {
            return typeVariable;
        }
        Type typeI = i(type, cls, clsD);
        if (!(typeI instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeI).getActualTypeArguments()[m(clsD.getTypeParameters(), typeVariable)];
    }

    public static WildcardType r(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f9030a);
    }

    public static WildcardType s(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
