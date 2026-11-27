package a1;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> extends n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f201b;

    public c(T t10, int i10) {
        super(null);
        this.f200a = t10;
        this.f201b = i10;
    }

    public final void a() {
        T t10 = this.f200a;
        if (!((t10 != null ? t10.hashCode() : 0) == this.f201b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final T b() {
        return this.f200a;
    }
}
