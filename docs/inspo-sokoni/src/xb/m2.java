package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class m2<T> implements p1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.d<T> f18759a;

    public m2(l2.d<T> dVar) {
        this.f18759a = dVar;
    }

    public static <T> m2<T> c(l2.d<T> dVar) {
        return new m2<>(dVar);
    }

    @Override // xb.p1
    public T a() {
        return (T) l2.d(this.f18759a);
    }

    @Override // xb.p1
    public T b(Object obj) {
        l2.f(this.f18759a, obj);
        return null;
    }
}
