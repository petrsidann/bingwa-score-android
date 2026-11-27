package k6;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class p<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f11604a = new Object[0];

    public static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f11605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11607c;

        public a(int i10) {
            g.b(i10, "initialCapacity");
            this.f11605a = new Object[i10];
            this.f11606b = 0;
        }

        @Override // k6.p.b
        public b<E> b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f11606b + collection.size());
                if (collection instanceof p) {
                    this.f11606b = ((p) collection).h(this.f11605a, this.f11606b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a<E> d(E e10) {
            j6.m.o(e10);
            g(this.f11606b + 1);
            Object[] objArr = this.f11605a;
            int i10 = this.f11606b;
            this.f11606b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public b<E> e(E... eArr) {
            f(eArr, eArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i10) {
            h0.c(objArr, i10);
            g(this.f11606b + i10);
            System.arraycopy(objArr, 0, this.f11605a, this.f11606b, i10);
            this.f11606b += i10;
        }

        public final void g(int i10) {
            Object[] objArr = this.f11605a;
            if (objArr.length < i10) {
                this.f11605a = Arrays.copyOf(objArr, b.c(objArr.length, i10));
            } else if (!this.f11607c) {
                return;
            } else {
                this.f11605a = (Object[]) objArr.clone();
            }
            this.f11607c = false;
        }
    }

    public static abstract class b<E> {
        public static int c(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i10 + (i10 >> 1) + 1;
            if (iHighestOneBit < i11) {
                iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
            }
            return iHighestOneBit < 0 ? com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER : iHighestOneBit;
        }

        public abstract b<E> a(E e10);

        public b<E> b(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public q<E> e() {
        return isEmpty() ? q.x() : q.o(toArray());
    }

    public int h(Object[] objArr, int i10) {
        t0<E> it = iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }

    public Object[] i() {
        return null;
    }

    public int j() {
        throw new UnsupportedOperationException();
    }

    public int k() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean l();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public abstract t0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f11604a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        j6.m.o(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrI = i();
            if (objArrI != null) {
                return (T[]) j0.a(objArrI, k(), j(), tArr);
            }
            tArr = (T[]) h0.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        h(tArr, 0);
        return tArr;
    }
}
