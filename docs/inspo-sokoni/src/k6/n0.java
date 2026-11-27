package k6;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n0<E> extends v<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n0<Comparable> f11597f = new n0<>(q.x(), i0.c());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient q<E> f11598e;

    public n0(q<E> qVar, Comparator<? super E> comparator) {
        super(comparator);
        this.f11598e = qVar;
    }

    @Override // k6.v
    public v<E> D() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f11634c);
        return isEmpty() ? v.G(comparatorReverseOrder) : new n0(this.f11598e.C(), comparatorReverseOrder);
    }

    @Override // k6.v, java.util.NavigableSet
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public t0<E> descendingIterator() {
        return this.f11598e.C().iterator();
    }

    @Override // k6.v
    public v<E> J(E e10, boolean z10) {
        return T(0, U(e10, z10));
    }

    @Override // k6.v
    public v<E> N(E e10, boolean z10, E e11, boolean z11) {
        return Q(e10, z10).J(e11, z11);
    }

    @Override // k6.v
    public v<E> Q(E e10, boolean z10) {
        return T(V(e10, z10), size());
    }

    public n0<E> T(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        return i10 < i11 ? new n0<>(this.f11598e.subList(i10, i11), this.f11634c) : v.G(this.f11634c);
    }

    public int U(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f11598e, j6.m.o(e10), comparator());
        if (iBinarySearch >= 0) {
            return z10 ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    public int V(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f11598e, j6.m.o(e10), comparator());
        if (iBinarySearch >= 0) {
            return z10 ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    public final int W(Object obj) {
        return Collections.binarySearch(this.f11598e, obj, X());
    }

    public Comparator<Object> X() {
        return this.f11634c;
    }

    @Override // k6.v, java.util.NavigableSet
    public E ceiling(E e10) {
        int iV = V(e10, true);
        if (iV == size()) {
            return null;
        }
        return this.f11598e.get(iV);
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return W(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof e0) {
            collection = ((e0) collection).m();
        }
        if (!r0.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        t0<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iR = R(next2, next);
                if (iR < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iR == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iR > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // k6.t, k6.p
    public q<E> e() {
        return this.f11598e;
    }

    @Override // k6.t, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!r0.b(this.f11634c, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            t0<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || R(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // k6.v, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f11598e.get(0);
    }

    @Override // k6.v, java.util.NavigableSet
    public E floor(E e10) {
        int iU = U(e10, true) - 1;
        if (iU == -1) {
            return null;
        }
        return this.f11598e.get(iU);
    }

    @Override // k6.p
    public int h(Object[] objArr, int i10) {
        return this.f11598e.h(objArr, i10);
    }

    @Override // k6.v, java.util.NavigableSet
    public E higher(E e10) {
        int iV = V(e10, false);
        if (iV == size()) {
            return null;
        }
        return this.f11598e.get(iV);
    }

    @Override // k6.p
    public Object[] i() {
        return this.f11598e.i();
    }

    @Override // k6.p
    public int j() {
        return this.f11598e.j();
    }

    @Override // k6.p
    public int k() {
        return this.f11598e.k();
    }

    @Override // k6.p
    public boolean l() {
        return this.f11598e.l();
    }

    @Override // k6.v, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f11598e.get(size() - 1);
    }

    @Override // k6.v, java.util.NavigableSet
    public E lower(E e10) {
        int iU = U(e10, false) - 1;
        if (iU == -1) {
            return null;
        }
        return this.f11598e.get(iU);
    }

    @Override // k6.v, k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public t0<E> iterator() {
        return this.f11598e.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f11598e.size();
    }
}
