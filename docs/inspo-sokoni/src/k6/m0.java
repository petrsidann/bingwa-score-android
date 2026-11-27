package k6;

/* JADX INFO: loaded from: classes.dex */
public final class m0<E> extends t<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object[] f11590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final m0<Object> f11591n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f11592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f11593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f11594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f11595f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final transient int f11596l;

    static {
        Object[] objArr = new Object[0];
        f11590m = objArr;
        f11591n = new m0<>(objArr, 0, objArr, 0, 0);
    }

    public m0(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f11592c = objArr;
        this.f11593d = i10;
        this.f11594e = objArr2;
        this.f11595f = i11;
        this.f11596l = i12;
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f11594e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = o.c(obj);
        while (true) {
            int i10 = iC & this.f11595f;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i10 + 1;
        }
    }

    @Override // k6.p
    public int h(Object[] objArr, int i10) {
        System.arraycopy(this.f11592c, 0, objArr, i10, this.f11596l);
        return i10 + this.f11596l;
    }

    @Override // k6.t, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f11593d;
    }

    @Override // k6.p
    public Object[] i() {
        return this.f11592c;
    }

    @Override // k6.p
    public int j() {
        return this.f11596l;
    }

    @Override // k6.p
    public int k() {
        return 0;
    }

    @Override // k6.p
    public boolean l() {
        return false;
    }

    @Override // k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public t0<E> iterator() {
        return e().iterator();
    }

    @Override // k6.t
    public q<E> s() {
        return q.q(this.f11592c, this.f11596l);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f11596l;
    }

    @Override // k6.t
    public boolean t() {
        return true;
    }
}
