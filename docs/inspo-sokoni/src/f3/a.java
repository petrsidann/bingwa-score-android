package f3;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements kc.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8163c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile kc.a<T> f8164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f8165b = f8163c;

    public a(kc.a<T> aVar) {
        this.f8164a = aVar;
    }

    public static <P extends kc.a<T>, T> kc.a<T> a(P p10) {
        d.b(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f8163c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // kc.a
    public T get() {
        T t10 = (T) this.f8165b;
        Object obj = f8163c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f8165b;
                if (t10 == obj) {
                    t10 = this.f8164a.get();
                    this.f8165b = b(this.f8165b, t10);
                    this.f8164a = null;
                }
            }
        }
        return t10;
    }
}
