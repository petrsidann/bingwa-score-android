package q7;

/* JADX INFO: loaded from: classes.dex */
public class w<T> implements o8.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f14892c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f14893a = f14892c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile o8.b<T> f14894b;

    public w(o8.b<T> bVar) {
        this.f14894b = bVar;
    }

    @Override // o8.b
    public T get() {
        T t10 = (T) this.f14893a;
        Object obj = f14892c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f14893a;
                if (t10 == obj) {
                    t10 = this.f14894b.get();
                    this.f14893a = t10;
                    this.f14894b = null;
                }
            }
        }
        return t10;
    }
}
