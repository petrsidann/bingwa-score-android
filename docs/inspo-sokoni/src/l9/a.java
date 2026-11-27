package l9;

import g9.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? super T> f12601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f12602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12603c;

    public a() {
        Type typeE = e();
        this.f12602b = typeE;
        this.f12601a = (Class<? super T>) b.k(typeE);
        this.f12603c = typeE.hashCode();
    }

    public a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = b.b(type);
        this.f12602b = typeB;
        this.f12601a = (Class<? super T>) b.k(typeB);
        this.f12603c = typeB.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    public final Class<? super T> c() {
        return this.f12601a;
    }

    public final Type d() {
        return this.f12602b;
    }

    public final Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                return b.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f12602b, ((a) obj).f12602b);
    }

    public final int hashCode() {
        return this.f12603c;
    }

    public final String toString() {
        return b.t(this.f12602b);
    }
}
