package s7;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K[] f15586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V[] f15587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator<K> f15588c;

    /* JADX INFO: renamed from: s7.a$a, reason: collision with other inner class name */
    public class C0275a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f15591c;

        public C0275a(int i10, boolean z10) {
            this.f15590b = i10;
            this.f15591c = z10;
            this.f15589a = i10;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Object obj = a.this.f15586a[this.f15589a];
            Object[] objArr = a.this.f15587b;
            int i10 = this.f15589a;
            Object obj2 = objArr[i10];
            this.f15589a = this.f15591c ? i10 - 1 : i10 + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f15591c) {
                if (this.f15589a >= 0) {
                    return true;
                }
            } else if (this.f15589a < a.this.f15586a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public a(Comparator<K> comparator) {
        this.f15586a = (K[]) new Object[0];
        this.f15587b = (V[]) new Object[0];
        this.f15588c = comparator;
    }

    public a(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f15586a = kArr;
        this.f15587b = vArr;
        this.f15588c = comparator;
    }

    public static <T> T[] s(T[] tArr, int i10, T t10) {
        int length = tArr.length + 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i10);
        tArr2[i10] = t10;
        System.arraycopy(tArr, i10, tArr2, i10 + 1, (length - i10) - 1);
        return tArr2;
    }

    public static <A, B, C> a<A, C> t(List<A> list, Map<B, C> map, c.a.InterfaceC0276a<A, B> interfaceC0276a, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i10 = 0;
        for (A a10 : list) {
            objArr[i10] = a10;
            objArr2[i10] = map.get(interfaceC0276a.a(a10));
            i10++;
        }
        return new a<>(comparator, objArr, objArr2);
    }

    public static <T> T[] y(T[] tArr, int i10) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i10);
        System.arraycopy(tArr, i10 + 1, tArr2, i10, length - i10);
        return tArr2;
    }

    public static <T> T[] z(T[] tArr, int i10, T t10) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i10] = t10;
        return tArr2;
    }

    @Override // s7.c
    public boolean e(K k10) {
        return v(k10) != -1;
    }

    @Override // s7.c
    public V h(K k10) {
        int iV = v(k10);
        if (iV != -1) {
            return this.f15587b[iV];
        }
        return null;
    }

    @Override // s7.c
    public Comparator<K> i() {
        return this.f15588c;
    }

    @Override // s7.c
    public int indexOf(K k10) {
        return v(k10);
    }

    @Override // s7.c
    public boolean isEmpty() {
        return this.f15586a.length == 0;
    }

    @Override // s7.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return x(0, false);
    }

    @Override // s7.c
    public K j() {
        K[] kArr = this.f15586a;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // s7.c
    public K k() {
        K[] kArr = this.f15586a;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // s7.c
    public c<K, V> l(K k10, V v10) {
        int iV = v(k10);
        if (iV != -1) {
            K[] kArr = this.f15586a;
            if (kArr[iV] == k10 && this.f15587b[iV] == v10) {
                return this;
            }
            return new a(this.f15588c, z(kArr, iV, k10), z(this.f15587b, iV, v10));
        }
        if (this.f15586a.length <= 25) {
            int iW = w(k10);
            return new a(this.f15588c, s(this.f15586a, iW, k10), s(this.f15587b, iW, v10));
        }
        HashMap map = new HashMap(this.f15586a.length + 1);
        int i10 = 0;
        while (true) {
            K[] kArr2 = this.f15586a;
            if (i10 >= kArr2.length) {
                map.put(k10, v10);
                return k.r(map, this.f15588c);
            }
            map.put(kArr2[i10], this.f15587b[i10]);
            i10++;
        }
    }

    @Override // s7.c
    public Iterator<Map.Entry<K, V>> n(K k10) {
        return x(w(k10), false);
    }

    @Override // s7.c
    public c<K, V> o(K k10) {
        int iV = v(k10);
        if (iV == -1) {
            return this;
        }
        return new a(this.f15588c, y(this.f15586a, iV), y(this.f15587b, iV));
    }

    @Override // s7.c
    public int size() {
        return this.f15586a.length;
    }

    public final int v(K k10) {
        int i10 = 0;
        for (K k11 : this.f15586a) {
            if (this.f15588c.compare(k10, k11) == 0) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int w(K k10) {
        int i10 = 0;
        while (true) {
            K[] kArr = this.f15586a;
            if (i10 >= kArr.length || this.f15588c.compare(kArr[i10], k10) >= 0) {
                break;
            }
            i10++;
        }
        return i10;
    }

    public final Iterator<Map.Entry<K, V>> x(int i10, boolean z10) {
        return new C0275a(i10, z10);
    }
}
