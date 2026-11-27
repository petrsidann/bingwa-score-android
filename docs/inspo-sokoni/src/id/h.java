package id;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10625b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f10626c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10627a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f10628a;

        public a(Throwable th) {
            this.f10628a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f10628a, ((a) obj).f10628a);
        }

        public int hashCode() {
            Throwable th = this.f10628a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // id.h.c
        public String toString() {
            return "Closed(" + this.f10628a + ')';
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return h.c(new a(th));
        }

        public final <E> Object b() {
            return h.c(h.f10626c);
        }

        public final <E> Object c(E e10) {
            return h.c(e10);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ h(Object obj) {
        this.f10627a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.jvm.internal.k.a(obj, ((h) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f10628a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f10627a, obj);
    }

    public int hashCode() {
        return g(this.f10627a);
    }

    public final /* synthetic */ Object k() {
        return this.f10627a;
    }

    public String toString() {
        return j(this.f10627a);
    }
}
