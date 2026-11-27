package k6;

import com.google.j2objc.annotations.RetainedWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class t<E> extends p<E> implements Set<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    public transient q<E> f11632b;

    public static int o(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            j6.m.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> t<E> q(int i10, Object... objArr) {
        if (i10 == 0) {
            return v();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return w(obj);
        }
        int iO = o(i10);
        Object[] objArr2 = new Object[iO];
        int i11 = iO - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object objA = h0.a(objArr[i14], i14);
            int iHashCode = objA.hashCode();
            int iB = o.b(iHashCode);
            while (true) {
                int i15 = iB & i11;
                Object obj2 = objArr2[i15];
                if (obj2 == null) {
                    objArr[i13] = objA;
                    objArr2[i15] = objA;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new p0(obj3);
        }
        if (o(i13) < iO / 2) {
            return q(i13, objArr);
        }
        if (z(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new m0(objArr, i12, objArr2, i11, i13);
    }

    public static <E> t<E> r(Collection<? extends E> collection) {
        if ((collection instanceof t) && !(collection instanceof SortedSet)) {
            t<E> tVar = (t) collection;
            if (!tVar.l()) {
                return tVar;
            }
        }
        Object[] array = collection.toArray();
        return q(array.length, array);
    }

    public static <E> t<E> v() {
        return m0.f11591n;
    }

    public static <E> t<E> w(E e10) {
        return new p0(e10);
    }

    public static <E> t<E> x(E e10, E e11, E e12) {
        return q(3, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> t<E> y(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        j6.m.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return q(length, objArr);
    }

    public static boolean z(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // k6.p
    public q<E> e() {
        q<E> qVar = this.f11632b;
        if (qVar != null) {
            return qVar;
        }
        q<E> qVarS = s();
        this.f11632b = qVarS;
        return qVarS;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof t) && t() && ((t) obj).t() && hashCode() != obj.hashCode()) {
            return false;
        }
        return o0.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return o0.b(this);
    }

    @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: n */
    public abstract t0<E> iterator();

    public q<E> s() {
        return q.o(toArray());
    }

    public boolean t() {
        return false;
    }
}
