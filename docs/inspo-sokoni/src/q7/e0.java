package q7;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
public final class e0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Annotation> f14843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f14844b;

    public @interface a {
    }

    public e0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f14843a = cls;
        this.f14844b = cls2;
    }

    public static <T> e0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new e0<>(cls, cls2);
    }

    public static <T> e0<T> b(Class<T> cls) {
        return new e0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (this.f14844b.equals(e0Var.f14844b)) {
            return this.f14843a.equals(e0Var.f14843a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f14844b.hashCode() * 31) + this.f14843a.hashCode();
    }

    public String toString() {
        if (this.f14843a == a.class) {
            return this.f14844b.getName();
        }
        return "@" + this.f14843a.getName() + " " + this.f14844b.getName();
    }
}
