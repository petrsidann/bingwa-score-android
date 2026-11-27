package k6;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<E> extends u0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11533b;

    public a(int i10, int i11) {
        j6.m.r(i11, i10);
        this.f11532a = i10;
        this.f11533b = i11;
    }

    public abstract E b(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f11533b < this.f11532a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11533b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f11533b;
        this.f11533b = i10 + 1;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11533b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f11533b - 1;
        this.f11533b = i10;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11533b - 1;
    }
}
