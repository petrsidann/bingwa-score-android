package mc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f13285b;

    public abstract void b();

    public final void c() {
        this.f13284a = 2;
    }

    public final void d(T t10) {
        this.f13285b = t10;
        this.f13284a = 1;
    }

    public final boolean e() {
        this.f13284a = 3;
        b();
        return this.f13284a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10 = this.f13284a;
        if (i10 == 0) {
            return e();
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public T next() {
        int i10 = this.f13284a;
        if (i10 != 1 && (i10 == 2 || !e())) {
            throw new NoSuchElementException();
        }
        this.f13284a = 0;
        return this.f13285b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
