package k6;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class k0<E> extends q<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q<Object> f11572e = new k0(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f11573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f11574d;

    public k0(Object[] objArr, int i10) {
        this.f11573c = objArr;
        this.f11574d = i10;
    }

    @Override // java.util.List
    public E get(int i10) {
        j6.m.m(i10, this.f11574d);
        E e10 = (E) this.f11573c[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // k6.q, k6.p
    public int h(Object[] objArr, int i10) {
        System.arraycopy(this.f11573c, 0, objArr, i10, this.f11574d);
        return i10 + this.f11574d;
    }

    @Override // k6.p
    public Object[] i() {
        return this.f11573c;
    }

    @Override // k6.p
    public int j() {
        return this.f11574d;
    }

    @Override // k6.p
    public int k() {
        return 0;
    }

    @Override // k6.p
    public boolean l() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11574d;
    }
}
