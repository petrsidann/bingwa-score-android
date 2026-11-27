package k6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class v<E> extends w<E> implements NavigableSet<E>, q0<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Comparator<? super E> f11634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient v<E> f11635d;

    public v(Comparator<? super E> comparator) {
        this.f11634c = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> v<E> A(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return G(comparator);
        }
        h0.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            a0.e eVar = (Object) eArr[i12];
            if (comparator.compare(eVar, (Object) eArr[i11 - 1]) != 0) {
                eArr[i11] = eVar;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i11);
        }
        return new n0(q.q(eArr, i11), comparator);
    }

    public static <E> v<E> B(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        j6.m.o(comparator);
        if (r0.b(comparator, iterable) && (iterable instanceof v)) {
            v<E> vVar = (v) iterable;
            if (!vVar.l()) {
                return vVar;
            }
        }
        Object[] objArrC = x.c(iterable);
        return A(comparator, objArrC.length, objArrC);
    }

    public static <E> v<E> C(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return B(comparator, collection);
    }

    public static <E> n0<E> G(Comparator<? super E> comparator) {
        return i0.c().equals(comparator) ? (n0<E>) n0.f11597f : new n0<>(q.x(), comparator);
    }

    public static int S(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public abstract v<E> D();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: E */
    public abstract t0<E> descendingIterator();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public v<E> descendingSet() {
        v<E> vVar = this.f11635d;
        if (vVar != null) {
            return vVar;
        }
        v<E> vVarD = D();
        this.f11635d = vVarD;
        vVarD.f11635d = this;
        return vVarD;
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public v<E> headSet(E e10) {
        return headSet(e10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public v<E> headSet(E e10, boolean z10) {
        return J(j6.m.o(e10), z10);
    }

    public abstract v<E> J(E e10, boolean z10);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public v<E> subSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public v<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        j6.m.o(e10);
        j6.m.o(e11);
        j6.m.d(this.f11634c.compare(e10, e11) <= 0);
        return N(e10, z10, e11, z11);
    }

    public abstract v<E> N(E e10, boolean z10, E e11, boolean z11);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public v<E> tailSet(E e10) {
        return tailSet(e10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public v<E> tailSet(E e10, boolean z10) {
        return Q(j6.m.o(e10), z10);
    }

    public abstract v<E> Q(E e10, boolean z10);

    public int R(Object obj, Object obj2) {
        return S(this.f11634c, obj, obj2);
    }

    public E ceiling(E e10) {
        return (E) x.b(tailSet(e10, true), null);
    }

    @Override // java.util.SortedSet, k6.q0
    public Comparator<? super E> comparator() {
        return this.f11634c;
    }

    public E first() {
        return iterator().next();
    }

    public E floor(E e10) {
        return (E) y.c(headSet(e10, true).descendingIterator(), null);
    }

    public E higher(E e10) {
        return (E) x.b(tailSet(e10, false), null);
    }

    public E last() {
        return descendingIterator().next();
    }

    public E lower(E e10) {
        return (E) y.c(headSet(e10, false).descendingIterator(), null);
    }

    @Override // k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public abstract t0<E> iterator();

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }
}
