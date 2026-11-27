package k6;

import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class r<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map.Entry<?, ?>[] f11615d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RetainedWith
    public transient t<Map.Entry<K, V>> f11616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    public transient t<K> f11617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RetainedWith
    public transient p<V> f11618c;

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator<? super V> f11619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f11620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11621c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11622d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0200a f11623e;

        /* JADX INFO: renamed from: k6.r$a$a, reason: collision with other inner class name */
        public static final class C0200a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f11624a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f11625b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f11626c;

            public C0200a(Object obj, Object obj2, Object obj3) {
                this.f11624a = obj;
                this.f11625b = obj2;
                this.f11626c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f11624a + "=" + this.f11625b + " and " + this.f11624a + "=" + this.f11626c);
            }
        }

        public a(int i10) {
            this.f11620b = new Object[i10 * 2];
        }

        public static <V> void i(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, i0.a(comparator).e(b0.d()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public r<K, V> a() {
            return c();
        }

        public final r<K, V> b(boolean z10) {
            Object[] objArrE;
            C0200a c0200a;
            C0200a c0200a2;
            if (z10 && (c0200a2 = this.f11623e) != null) {
                throw c0200a2.a();
            }
            int length = this.f11621c;
            if (this.f11619a == null) {
                objArrE = this.f11620b;
            } else {
                if (this.f11622d) {
                    this.f11620b = Arrays.copyOf(this.f11620b, length * 2);
                }
                objArrE = this.f11620b;
                if (!z10) {
                    objArrE = e(objArrE, this.f11621c);
                    if (objArrE.length < this.f11620b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                i(objArrE, length, this.f11619a);
            }
            this.f11622d = true;
            l0 l0VarK = l0.k(length, objArrE, this);
            if (!z10 || (c0200a = this.f11623e) == null) {
                return l0VarK;
            }
            throw c0200a.a();
        }

        public r<K, V> c() {
            return b(true);
        }

        public final void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f11620b;
            if (i11 > objArr.length) {
                this.f11620b = Arrays.copyOf(objArr, p.b.c(objArr.length, i11));
                this.f11622d = false;
            }
        }

        public final Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 = i14 + 1;
                    i12 = i15 + 1;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        public a<K, V> f(K k10, V v10) {
            d(this.f11621c + 1);
            g.a(k10, v10);
            Object[] objArr = this.f11620b;
            int i10 = this.f11621c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v10;
            this.f11621c = i10 + 1;
            return this;
        }

        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f11621c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }
    }

    public static <K, V> r<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.h(iterable);
        return aVar.a();
    }

    public static <K, V> r<K, V> b(Map<? extends K, ? extends V> map) {
        if ((map instanceof r) && !(map instanceof SortedMap)) {
            r<K, V> rVar = (r) map;
            if (!rVar.g()) {
                return rVar;
            }
        }
        return a(map.entrySet());
    }

    public static <K, V> r<K, V> i() {
        return (r<K, V>) l0.f11576m;
    }

    public abstract t<Map.Entry<K, V>> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract t<K> d();

    public abstract p<V> e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return b0.a(this, obj);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public t<Map.Entry<K, V>> entrySet() {
        t<Map.Entry<K, V>> tVar = this.f11616a;
        if (tVar != null) {
            return tVar;
        }
        t<Map.Entry<K, V>> tVarC = c();
        this.f11616a = tVarC;
        return tVarC;
    }

    public abstract boolean g();

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public t<K> keySet() {
        t<K> tVar = this.f11617b;
        if (tVar != null) {
            return tVar;
        }
        t<K> tVarD = d();
        this.f11617b = tVarD;
        return tVarD;
    }

    @Override // java.util.Map
    public int hashCode() {
        return o0.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public p<V> values() {
        p<V> pVar = this.f11618c;
        if (pVar != null) {
            return pVar;
        }
        p<V> pVarE = e();
        this.f11618c = pVarE;
        return pVarE;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return b0.c(this);
    }
}
