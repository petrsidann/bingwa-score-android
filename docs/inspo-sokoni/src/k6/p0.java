package k6;

/* JADX INFO: loaded from: classes.dex */
public final class p0<E> extends t<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient E f11608c;

    public p0(E e10) {
        this.f11608c = (E) j6.m.o(e10);
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f11608c.equals(obj);
    }

    @Override // k6.t, k6.p
    public q<E> e() {
        return q.y(this.f11608c);
    }

    @Override // k6.p
    public int h(Object[] objArr, int i10) {
        objArr[i10] = this.f11608c;
        return i10 + 1;
    }

    @Override // k6.t, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f11608c.hashCode();
    }

    @Override // k6.p
    public boolean l() {
        return false;
    }

    @Override // k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public t0<E> iterator() {
        return y.d(this.f11608c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f11608c.toString() + ']';
    }
}
