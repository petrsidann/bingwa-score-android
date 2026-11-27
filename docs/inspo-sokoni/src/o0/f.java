package o0;

/* JADX INFO: loaded from: classes.dex */
public class f<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f13610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13611b;

    public f(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f13610a = new Object[i10];
    }

    @Override // o0.e
    public boolean a(T t10) {
        if (c(t10)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f13611b;
        Object[] objArr = this.f13610a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f13611b = i10 + 1;
        return true;
    }

    @Override // o0.e
    public T b() {
        int i10 = this.f13611b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f13610a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f13611b = i10 - 1;
        return t10;
    }

    public final boolean c(T t10) {
        for (int i10 = 0; i10 < this.f13611b; i10++) {
            if (this.f13610a[i10] == t10) {
                return true;
            }
        }
        return false;
    }
}
