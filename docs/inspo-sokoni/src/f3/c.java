package f3;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c<Object> f8166b = new c<>(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f8167a;

    public c(T t10) {
        this.f8167a = t10;
    }

    public static <T> b<T> a(T t10) {
        return new c(d.c(t10, "instance cannot be null"));
    }

    @Override // kc.a
    public T get() {
        return this.f8167a;
    }
}
