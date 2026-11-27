package lc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12703b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12704a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f12705a;

        public b(Throwable exception) {
            kotlin.jvm.internal.k.e(exception, "exception");
            this.f12705a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f12705a, ((b) obj).f12705a);
        }

        public int hashCode() {
            return this.f12705a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f12705a + ')';
        }
    }

    public /* synthetic */ j(Object obj) {
        this.f12704a = obj;
    }

    public static final /* synthetic */ j a(Object obj) {
        return new j(obj);
    }

    public static <T> Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof j) && kotlin.jvm.internal.k.a(obj, ((j) obj2).i());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f12705a;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static final boolean g(Object obj) {
        return !(obj instanceof b);
    }

    public static String h(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f12704a, obj);
    }

    public int hashCode() {
        return e(this.f12704a);
    }

    public final /* synthetic */ Object i() {
        return this.f12704a;
    }

    public String toString() {
        return h(this.f12704a);
    }
}
