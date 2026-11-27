package o0;

/* JADX INFO: loaded from: classes.dex */
public class g<T> extends f<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13612c;

    public g(int i10) {
        super(i10);
        this.f13612c = new Object();
    }

    @Override // o0.f, o0.e
    public boolean a(T t10) {
        boolean zA;
        synchronized (this.f13612c) {
            zA = super.a(t10);
        }
        return zA;
    }

    @Override // o0.f, o0.e
    public T b() {
        T t10;
        synchronized (this.f13612c) {
            t10 = (T) super.b();
        }
        return t10;
    }
}
