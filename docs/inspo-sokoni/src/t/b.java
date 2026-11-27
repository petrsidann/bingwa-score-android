package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f15721e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f15722f = new Object[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Object[] f15723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f15724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Object[] f15725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f15726o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f15727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f15728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f<E, E> f15730d;

    public class a extends f<E, E> {
        public a() {
        }

        @Override // t.f
        public void a() {
            b.this.clear();
        }

        @Override // t.f
        public Object b(int i10, int i11) {
            return b.this.f15728b[i10];
        }

        @Override // t.f
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // t.f
        public int d() {
            return b.this.f15729c;
        }

        @Override // t.f
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // t.f
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // t.f
        public void g(E e10, E e11) {
            b.this.add(e10);
        }

        @Override // t.f
        public void h(int i10) {
            b.this.n(i10);
        }

        @Override // t.f
        public E i(int i10, E e10) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f15727a = f15721e;
            this.f15728b = f15722f;
        } else {
            e(i10);
        }
        this.f15729c = 0;
    }

    public static void i(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f15726o < 10) {
                    objArr[0] = f15725n;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f15725n = objArr;
                    f15726o++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f15724m < 10) {
                    objArr[0] = f15723l;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f15723l = objArr;
                    f15724m++;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int iK;
        if (e10 == null) {
            iK = l();
            i10 = 0;
        } else {
            int iHashCode = e10.hashCode();
            i10 = iHashCode;
            iK = k(e10, iHashCode);
        }
        if (iK >= 0) {
            return false;
        }
        int i11 = ~iK;
        int i12 = this.f15729c;
        int[] iArr = this.f15727a;
        if (i12 >= iArr.length) {
            int i13 = 8;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f15728b;
            e(i13);
            int[] iArr2 = this.f15727a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f15728b, 0, objArr.length);
            }
            i(iArr, objArr, this.f15729c);
        }
        int i14 = this.f15729c;
        if (i11 < i14) {
            int[] iArr3 = this.f15727a;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f15728b;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f15729c - i11);
        }
        this.f15727a[i11] = i10;
        this.f15728b[i11] = e10;
        this.f15729c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        h(this.f15729c + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f15729c;
        if (i10 != 0) {
            i(this.f15727a, this.f15728b, i10);
            this.f15727a = f15721e;
            this.f15728b = f15722f;
            this.f15729c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void e(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                Object[] objArr = f15725n;
                if (objArr != null) {
                    this.f15728b = objArr;
                    f15725n = (Object[]) objArr[0];
                    this.f15727a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f15726o--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f15723l;
                if (objArr2 != null) {
                    this.f15728b = objArr2;
                    f15723l = (Object[]) objArr2[0];
                    this.f15727a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f15724m--;
                    return;
                }
            }
        }
        this.f15727a = new int[i10];
        this.f15728b = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f15729c; i10++) {
                try {
                    if (!set.contains(o(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void h(int i10) {
        int[] iArr = this.f15727a;
        if (iArr.length < i10) {
            Object[] objArr = this.f15728b;
            e(i10);
            int i11 = this.f15729c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f15727a, 0, i11);
                System.arraycopy(objArr, 0, this.f15728b, 0, this.f15729c);
            }
            i(iArr, objArr, this.f15729c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f15727a;
        int i10 = this.f15729c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? l() : k(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f15729c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return j().m().iterator();
    }

    public final f<E, E> j() {
        if (this.f15730d == null) {
            this.f15730d = new a();
        }
        return this.f15730d;
    }

    public final int k(Object obj, int i10) {
        int i11 = this.f15729c;
        if (i11 == 0) {
            return -1;
        }
        int iA = c.a(this.f15727a, i11, i10);
        if (iA < 0 || obj.equals(this.f15728b[iA])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f15727a[i12] == i10) {
            if (obj.equals(this.f15728b[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f15727a[i13] == i10; i13--) {
            if (obj.equals(this.f15728b[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    public final int l() {
        int i10 = this.f15729c;
        if (i10 == 0) {
            return -1;
        }
        int iA = c.a(this.f15727a, i10, 0);
        if (iA < 0 || this.f15728b[iA] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f15727a[i11] == 0) {
            if (this.f15728b[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f15727a[i12] == 0; i12--) {
            if (this.f15728b[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public E n(int i10) {
        Object[] objArr = this.f15728b;
        E e10 = (E) objArr[i10];
        int i11 = this.f15729c;
        if (i11 <= 1) {
            i(this.f15727a, objArr, i11);
            this.f15727a = f15721e;
            this.f15728b = f15722f;
            this.f15729c = 0;
        } else {
            int[] iArr = this.f15727a;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f15729c = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f15728b;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f15729c - i10);
                }
                this.f15728b[this.f15729c] = null;
            } else {
                e(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f15729c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f15727a, 0, i10);
                    System.arraycopy(objArr, 0, this.f15728b, 0, i10);
                }
                int i14 = this.f15729c;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f15727a, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f15728b, i10, this.f15729c - i10);
                }
            }
        }
        return e10;
    }

    public E o(int i10) {
        return (E) this.f15728b[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        n(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f15729c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f15728b[i10])) {
                n(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f15729c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f15729c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f15728b, 0, objArr, 0, i10);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f15729c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f15729c));
        }
        System.arraycopy(this.f15728b, 0, tArr, 0, this.f15729c);
        int length = tArr.length;
        int i10 = this.f15729c;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15729c * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f15729c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E eO = o(i10);
            if (eO != this) {
                sb2.append(eO);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
