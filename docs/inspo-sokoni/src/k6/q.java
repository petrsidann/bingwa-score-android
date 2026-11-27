package k6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class q<E> extends p<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u0<Object> f11609b = new b(k0.f11572e, 0);

    public static final class a<E> extends p.a<E> {
        public a() {
            this(4);
        }

        public a(int i10) {
            super(i10);
        }

        @Override // k6.p.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e10) {
            super.d(e10);
            return this;
        }

        public a<E> i(E... eArr) {
            super.e(eArr);
            return this;
        }

        public a<E> j(Iterable<? extends E> iterable) {
            super.b(iterable);
            return this;
        }

        public q<E> k() {
            this.f11607c = true;
            return q.q(this.f11605a, this.f11606b);
        }
    }

    public static class b<E> extends k6.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q<E> f11610c;

        public b(q<E> qVar, int i10) {
            super(qVar.size(), i10);
            this.f11610c = qVar;
        }

        @Override // k6.a
        public E b(int i10) {
            return this.f11610c.get(i10);
        }
    }

    public static class c<E> extends q<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient q<E> f11611c;

        public c(q<E> qVar) {
            this.f11611c = qVar;
        }

        @Override // k6.q
        public q<E> C() {
            return this.f11611c;
        }

        @Override // k6.q, java.util.List
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public q<E> subList(int i10, int i11) {
            j6.m.t(i10, i11, size());
            return this.f11611c.subList(H(i11), H(i10)).C();
        }

        public final int G(int i10) {
            return (size() - 1) - i10;
        }

        public final int H(int i10) {
            return size() - i10;
        }

        @Override // k6.q, k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f11611c.contains(obj);
        }

        @Override // java.util.List
        public E get(int i10) {
            j6.m.m(i10, size());
            return this.f11611c.get(G(i10));
        }

        @Override // k6.q, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f11611c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return G(iLastIndexOf);
            }
            return -1;
        }

        @Override // k6.q, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // k6.p
        public boolean l() {
            return this.f11611c.l();
        }

        @Override // k6.q, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f11611c.indexOf(obj);
            if (iIndexOf >= 0) {
                return G(iIndexOf);
            }
            return -1;
        }

        @Override // k6.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // k6.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f11611c.size();
        }
    }

    public class d extends q<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f11612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f11613d;

        public d(int i10, int i11) {
            this.f11612c = i10;
            this.f11613d = i11;
        }

        @Override // k6.q, java.util.List
        /* JADX INFO: renamed from: E */
        public q<E> subList(int i10, int i11) {
            j6.m.t(i10, i11, this.f11613d);
            q qVar = q.this;
            int i12 = this.f11612c;
            return qVar.subList(i10 + i12, i11 + i12);
        }

        @Override // java.util.List
        public E get(int i10) {
            j6.m.m(i10, this.f11613d);
            return q.this.get(i10 + this.f11612c);
        }

        @Override // k6.p
        public Object[] i() {
            return q.this.i();
        }

        @Override // k6.q, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // k6.p
        public int j() {
            return q.this.k() + this.f11612c + this.f11613d;
        }

        @Override // k6.p
        public int k() {
            return q.this.k() + this.f11612c;
        }

        @Override // k6.p
        public boolean l() {
            return true;
        }

        @Override // k6.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // k6.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f11613d;
        }
    }

    public static <E> q<E> A(E e10, E e11, E e12) {
        return s(e10, e11, e12);
    }

    public static <E> q<E> B(E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return s(e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> q<E> D(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        j6.m.o(comparator);
        Object[] objArrC = x.c(iterable);
        h0.b(objArrC);
        Arrays.sort(objArrC, comparator);
        return o(objArrC);
    }

    public static <E> q<E> o(Object[] objArr) {
        return q(objArr, objArr.length);
    }

    public static <E> q<E> q(Object[] objArr, int i10) {
        return i10 == 0 ? x() : new k0(objArr, i10);
    }

    public static <E> a<E> r() {
        return new a<>();
    }

    public static <E> q<E> s(Object... objArr) {
        return o(h0.b(objArr));
    }

    public static <E> q<E> t(Collection<? extends E> collection) {
        if (!(collection instanceof p)) {
            return s(collection.toArray());
        }
        q<E> qVarE = ((p) collection).e();
        return qVarE.l() ? o(qVarE.toArray()) : qVarE;
    }

    public static <E> q<E> x() {
        return (q<E>) k0.f11572e;
    }

    public static <E> q<E> y(E e10) {
        return s(e10);
    }

    public static <E> q<E> z(E e10, E e11) {
        return s(e10, e11);
    }

    public q<E> C() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: E */
    public q<E> subList(int i10, int i11) {
        j6.m.t(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        return i12 == 0 ? x() : F(i10, i11);
    }

    public q<E> F(int i10, int i11) {
        return new d(i10, i11 - i10);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // k6.p
    @Deprecated
    public final q<E> e() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return z.b(this, obj);
    }

    @Override // k6.p
    public int h(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return z.c(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return z.e(this, obj);
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public t0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public u0<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public u0<E> listIterator(int i10) {
        j6.m.r(i10, size());
        return isEmpty() ? (u0<E>) f11609b : new b(this, i10);
    }
}
