package mc;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class g<E> extends e<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13302d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f13303e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f13305b = f13303e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13306c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        d.f13286a.c(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        s();
        l(size() + 1);
        int iR = r(this.f13304a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iK = k(iR);
            int iK2 = k(this.f13304a);
            int i11 = this.f13304a;
            if (iK >= i11) {
                Object[] objArr = this.f13305b;
                objArr[iK2] = objArr[i11];
                j.e(objArr, objArr, i11, i11 + 1, iK + 1);
            } else {
                Object[] objArr2 = this.f13305b;
                j.e(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f13305b;
                objArr3[objArr3.length - 1] = objArr3[0];
                j.e(objArr3, objArr3, 0, 1, iK + 1);
            }
            this.f13305b[iK] = e10;
            this.f13304a = iK2;
        } else {
            int iR2 = r(this.f13304a + size());
            Object[] objArr4 = this.f13305b;
            if (iR < iR2) {
                j.e(objArr4, objArr4, iR + 1, iR, iR2);
            } else {
                j.e(objArr4, objArr4, 1, 0, iR2);
                Object[] objArr5 = this.f13305b;
                objArr5[0] = objArr5[objArr5.length - 1];
                j.e(objArr5, objArr5, iR + 1, iR, objArr5.length - 1);
            }
            this.f13305b[iR] = e10;
        }
        this.f13306c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        d.f13286a.c(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        s();
        l(size() + elements.size());
        int iR = r(this.f13304a + size());
        int iR2 = r(this.f13304a + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f13304a;
            int length = i11 - size;
            if (iR2 < i11) {
                Object[] objArr = this.f13305b;
                j.e(objArr, objArr, length, i11, objArr.length);
                Object[] objArr2 = this.f13305b;
                if (size >= iR2) {
                    j.e(objArr2, objArr2, objArr2.length - size, 0, iR2);
                } else {
                    j.e(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f13305b;
                    j.e(objArr3, objArr3, 0, size, iR2);
                }
            } else if (length >= 0) {
                Object[] objArr4 = this.f13305b;
                j.e(objArr4, objArr4, length, i11, iR2);
            } else {
                Object[] objArr5 = this.f13305b;
                length += objArr5.length;
                int i12 = iR2 - i11;
                int length2 = objArr5.length - length;
                if (length2 >= i12) {
                    j.e(objArr5, objArr5, length, i11, iR2);
                } else {
                    j.e(objArr5, objArr5, length, i11, i11 + length2);
                    Object[] objArr6 = this.f13305b;
                    j.e(objArr6, objArr6, 0, this.f13304a + length2, iR2);
                }
            }
            this.f13304a = length;
            i(o(iR2 - size), elements);
        } else {
            int length3 = iR2 + size;
            if (iR2 < iR) {
                int i13 = size + iR;
                Object[] objArr7 = this.f13305b;
                if (i13 <= objArr7.length) {
                    j.e(objArr7, objArr7, length3, iR2, iR);
                } else if (length3 >= objArr7.length) {
                    length3 -= objArr7.length;
                    j.e(objArr7, objArr7, length3, iR2, iR);
                } else {
                    int length4 = iR - (i13 - objArr7.length);
                    j.e(objArr7, objArr7, 0, length4, iR);
                    Object[] objArr8 = this.f13305b;
                    j.e(objArr8, objArr8, length3, iR2, length4);
                }
            } else {
                Object[] objArr9 = this.f13305b;
                j.e(objArr9, objArr9, size, 0, iR);
                Object[] objArr10 = this.f13305b;
                if (length3 >= objArr10.length) {
                    j.e(objArr10, objArr10, length3 - objArr10.length, iR2, objArr10.length);
                } else {
                    j.e(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f13305b;
                    j.e(objArr11, objArr11, length3, iR2, objArr11.length - size);
                }
            }
            i(iR2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        s();
        l(size() + elements.size());
        i(r(this.f13304a + size()), elements);
        return true;
    }

    public final void addFirst(E e10) {
        s();
        l(size() + 1);
        int iK = k(this.f13304a);
        this.f13304a = iK;
        this.f13305b[iK] = e10;
        this.f13306c = size() + 1;
    }

    public final void addLast(E e10) {
        s();
        l(size() + 1);
        this.f13305b[r(this.f13304a + size())] = e10;
        this.f13306c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            s();
            q(this.f13304a, r(this.f13304a + size()));
        }
        this.f13304a = 0;
        this.f13306c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // mc.e
    public int e() {
        return this.f13306c;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        d.f13286a.b(i10, size());
        return (E) this.f13305b[r(this.f13304a + i10)];
    }

    @Override // mc.e
    public E h(int i10) {
        d.f13286a.b(i10, size());
        if (i10 == o.h(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        s();
        int iR = r(this.f13304a + i10);
        E e10 = (E) this.f13305b[iR];
        if (i10 < (size() >> 1)) {
            int i11 = this.f13304a;
            if (iR >= i11) {
                Object[] objArr = this.f13305b;
                j.e(objArr, objArr, i11 + 1, i11, iR);
            } else {
                Object[] objArr2 = this.f13305b;
                j.e(objArr2, objArr2, 1, 0, iR);
                Object[] objArr3 = this.f13305b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f13304a;
                j.e(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f13305b;
            int i13 = this.f13304a;
            objArr4[i13] = null;
            this.f13304a = n(i13);
        } else {
            int iR2 = r(this.f13304a + o.h(this));
            Object[] objArr5 = this.f13305b;
            if (iR <= iR2) {
                j.e(objArr5, objArr5, iR, iR + 1, iR2 + 1);
            } else {
                j.e(objArr5, objArr5, iR, iR + 1, objArr5.length);
                Object[] objArr6 = this.f13305b;
                objArr6[objArr6.length - 1] = objArr6[0];
                j.e(objArr6, objArr6, 0, 1, iR2 + 1);
            }
            this.f13305b[iR2] = null;
        }
        this.f13306c = size() - 1;
        return e10;
    }

    public final void i(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f13305b.length;
        while (i10 < length && it.hasNext()) {
            this.f13305b[i10] = it.next();
            i10++;
        }
        int i11 = this.f13304a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f13305b[i12] = it.next();
        }
        this.f13306c = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int iR = r(this.f13304a + size());
        int length = this.f13304a;
        if (length < iR) {
            while (length < iR) {
                if (!kotlin.jvm.internal.k.a(obj, this.f13305b[length])) {
                    length++;
                }
            }
            return -1;
        }
        if (length < iR) {
            return -1;
        }
        int length2 = this.f13305b.length;
        while (length < length2) {
            if (!kotlin.jvm.internal.k.a(obj, this.f13305b[length])) {
                length++;
            }
        }
        for (int i10 = 0; i10 < iR; i10++) {
            if (kotlin.jvm.internal.k.a(obj, this.f13305b[i10])) {
                length = i10 + this.f13305b.length;
            }
        }
        return -1;
        return length - this.f13304a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void j(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f13305b;
        j.e(objArr2, objArr, 0, this.f13304a, objArr2.length);
        Object[] objArr3 = this.f13305b;
        int length = objArr3.length;
        int i11 = this.f13304a;
        j.e(objArr3, objArr, length - i11, 0, i11);
        this.f13304a = 0;
        this.f13305b = objArr;
    }

    public final int k(int i10) {
        return i10 == 0 ? k.o(this.f13305b) : i10 - 1;
    }

    public final void l(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f13305b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f13303e) {
            this.f13305b = new Object[bd.h.a(i10, 10)];
        } else {
            j(d.f13286a.e(objArr.length, i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iO;
        int iR = r(this.f13304a + size());
        int i10 = this.f13304a;
        if (i10 < iR) {
            iO = iR - 1;
            if (i10 <= iO) {
                while (!kotlin.jvm.internal.k.a(obj, this.f13305b[iO])) {
                    if (iO != i10) {
                        iO--;
                    }
                }
                return iO - this.f13304a;
            }
            return -1;
        }
        if (i10 > iR) {
            for (int i11 = iR - 1; -1 < i11; i11--) {
                if (kotlin.jvm.internal.k.a(obj, this.f13305b[i11])) {
                    iO = i11 + this.f13305b.length;
                    return iO - this.f13304a;
                }
            }
            iO = k.o(this.f13305b);
            int i12 = this.f13304a;
            if (i12 <= iO) {
                while (!kotlin.jvm.internal.k.a(obj, this.f13305b[iO])) {
                    if (iO != i12) {
                        iO--;
                    }
                }
                return iO - this.f13304a;
            }
        }
        return -1;
    }

    public final int n(int i10) {
        if (i10 == k.o(this.f13305b)) {
            return 0;
        }
        return i10 + 1;
    }

    public final int o(int i10) {
        return i10 < 0 ? i10 + this.f13305b.length : i10;
    }

    public final void q(int i10, int i11) {
        Object[] objArr = this.f13305b;
        if (i10 < i11) {
            j.i(objArr, null, i10, i11);
        } else {
            j.i(objArr, null, i10, objArr.length);
            j.i(this.f13305b, null, 0, i11);
        }
    }

    public final int r(int i10) {
        Object[] objArr = this.f13305b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int iR;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if ((this.f13305b.length == 0) == false) {
                int iR2 = r(this.f13304a + size());
                int i10 = this.f13304a;
                if (i10 < iR2) {
                    iR = i10;
                    while (i10 < iR2) {
                        Object obj = this.f13305b[i10];
                        if (!elements.contains(obj)) {
                            this.f13305b[iR] = obj;
                            iR++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    j.i(this.f13305b, null, iR, iR2);
                } else {
                    int length = this.f13305b.length;
                    boolean z11 = false;
                    int i11 = i10;
                    while (i10 < length) {
                        Object[] objArr = this.f13305b;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (!elements.contains(obj2)) {
                            this.f13305b[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iR = r(i11);
                    for (int i12 = 0; i12 < iR2; i12++) {
                        Object[] objArr2 = this.f13305b;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (!elements.contains(obj3)) {
                            this.f13305b[iR] = obj3;
                            iR = n(iR);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    s();
                    this.f13306c = o(iR - this.f13304a);
                }
            }
        }
        return z10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        Object[] objArr = this.f13305b;
        int i10 = this.f13304a;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f13304a = n(i10);
        this.f13306c = size() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        int iR = r(this.f13304a + o.h(this));
        Object[] objArr = this.f13305b;
        E e10 = (E) objArr[iR];
        objArr[iR] = null;
        this.f13306c = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        d.f13286a.d(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == 0) {
            return;
        }
        if (i12 == size()) {
            clear();
            return;
        }
        if (i12 == 1) {
            remove(i10);
            return;
        }
        s();
        if (i10 < size() - i11) {
            v(i10, i11);
            int iR = r(this.f13304a + i12);
            q(this.f13304a, iR);
            this.f13304a = iR;
        } else {
            w(i10, i11);
            int iR2 = r(this.f13304a + size());
            q(o(iR2 - i12), iR2);
        }
        this.f13306c = size() - i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int iR;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if ((this.f13305b.length == 0) == false) {
                int iR2 = r(this.f13304a + size());
                int i10 = this.f13304a;
                if (i10 < iR2) {
                    iR = i10;
                    while (i10 < iR2) {
                        Object obj = this.f13305b[i10];
                        if (elements.contains(obj)) {
                            this.f13305b[iR] = obj;
                            iR++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    j.i(this.f13305b, null, iR, iR2);
                } else {
                    int length = this.f13305b.length;
                    boolean z11 = false;
                    int i11 = i10;
                    while (i10 < length) {
                        Object[] objArr = this.f13305b;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (elements.contains(obj2)) {
                            this.f13305b[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iR = r(i11);
                    for (int i12 = 0; i12 < iR2; i12++) {
                        Object[] objArr2 = this.f13305b;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (elements.contains(obj3)) {
                            this.f13305b[iR] = obj3;
                            iR = n(iR);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    s();
                    this.f13306c = o(iR - this.f13304a);
                }
            }
        }
        return z10;
    }

    public final void s() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        d.f13286a.b(i10, size());
        int iR = r(this.f13304a + i10);
        Object[] objArr = this.f13305b;
        E e11 = (E) objArr[iR];
        objArr[iR] = e10;
        return e11;
    }

    public final E t() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        if (array.length < size()) {
            array = (T[]) h.a(array, size());
        }
        int iR = r(this.f13304a + size());
        int i10 = this.f13304a;
        if (i10 < iR) {
            j.g(this.f13305b, array, 0, i10, iR, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f13305b;
            j.e(objArr, array, 0, this.f13304a, objArr.length);
            Object[] objArr2 = this.f13305b;
            j.e(objArr2, array, objArr2.length - this.f13304a, 0, iR);
        }
        return (T[]) n.d(size(), array);
    }

    public final void v(int i10, int i11) {
        int iR = r(this.f13304a + (i10 - 1));
        int iR2 = r(this.f13304a + (i11 - 1));
        while (i10 > 0) {
            int i12 = iR + 1;
            int iMin = Math.min(i10, Math.min(i12, iR2 + 1));
            Object[] objArr = this.f13305b;
            int i13 = iR2 - iMin;
            int i14 = iR - iMin;
            j.e(objArr, objArr, i13 + 1, i14 + 1, i12);
            iR = o(i14);
            iR2 = o(i13);
            i10 -= iMin;
        }
    }

    public final void w(int i10, int i11) {
        int iR = r(this.f13304a + i11);
        int iR2 = r(this.f13304a + i10);
        int size = size();
        while (true) {
            size -= i11;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f13305b;
            i11 = Math.min(size, Math.min(objArr.length - iR, objArr.length - iR2));
            Object[] objArr2 = this.f13305b;
            int i12 = iR + i11;
            j.e(objArr2, objArr2, iR2, iR, i12);
            iR = r(i12);
            iR2 = r(iR2 + i11);
        }
    }
}
