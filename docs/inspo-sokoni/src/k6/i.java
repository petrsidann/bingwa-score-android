package k6;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class i<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f11548o = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f11549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f11550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Object[] f11551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Object[] f11552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int f11553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f11554f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public transient Set<K> f11555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f11556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient Collection<V> f11557n;

    public class a extends i<K, V>.e<K> {
        public a() {
            super(i.this, null);
        }

        @Override // k6.i.e
        public K c(int i10) {
            return (K) i.this.G(i10);
        }
    }

    public class b extends i<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(i.this, null);
        }

        @Override // k6.i.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> c(int i10) {
            return new g(i10);
        }
    }

    public class c extends i<K, V>.e<V> {
        public c() {
            super(i.this, null);
        }

        @Override // k6.i.e
        public V c(int i10) {
            return (V) i.this.W(i10);
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapW = i.this.w();
            if (mapW != null) {
                return mapW.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iD = i.this.D(entry.getKey());
            return iD != -1 && j6.i.a(i.this.W(iD), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return i.this.y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapW = i.this.w();
            if (mapW != null) {
                return mapW.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i.this.J()) {
                return false;
            }
            int iB = i.this.B();
            int iF = j.f(entry.getKey(), entry.getValue(), iB, i.this.N(), i.this.L(), i.this.M(), i.this.O());
            if (iF == -1) {
                return false;
            }
            i.this.I(iF, iB);
            i.e(i.this);
            i.this.C();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    public abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11564c;

        public e() {
            this.f11562a = i.this.f11553e;
            this.f11563b = i.this.z();
            this.f11564c = -1;
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this();
        }

        public final void b() {
            if (i.this.f11553e != this.f11562a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T c(int i10);

        public void d() {
            this.f11562a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11563b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f11563b;
            this.f11564c = i10;
            T tC = c(i10);
            this.f11563b = i.this.A(this.f11563b);
            return tC;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            k6.g.c(this.f11564c >= 0);
            d();
            i iVar = i.this;
            iVar.remove(iVar.G(this.f11564c));
            this.f11563b = i.this.o(this.f11563b, this.f11564c);
            this.f11564c = -1;
        }
    }

    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return i.this.H();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapW = i.this.w();
            if (mapW != null) {
                return mapW.keySet().remove(obj);
            }
            return i.this.K(obj) != i.f11548o;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    public final class g extends k6.c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f11567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11568b;

        public g(int i10) {
            this.f11567a = (K) i.this.G(i10);
            this.f11568b = i10;
        }

        public final void a() {
            int i10 = this.f11568b;
            if (i10 == -1 || i10 >= i.this.size() || !j6.i.a(this.f11567a, i.this.G(this.f11568b))) {
                this.f11568b = i.this.D(this.f11567a);
            }
        }

        @Override // k6.c, java.util.Map.Entry
        public K getKey() {
            return this.f11567a;
        }

        @Override // k6.c, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapW = i.this.w();
            if (mapW != null) {
                return (V) g0.a(mapW.get(this.f11567a));
            }
            a();
            int i10 = this.f11568b;
            return i10 == -1 ? (V) g0.b() : (V) i.this.W(i10);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            Map<K, V> mapW = i.this.w();
            if (mapW != null) {
                return (V) g0.a(mapW.put(this.f11567a, v10));
            }
            a();
            int i10 = this.f11568b;
            if (i10 == -1) {
                i.this.put(this.f11567a, v10);
                return (V) g0.b();
            }
            V v11 = (V) i.this.W(i10);
            i.this.V(this.f11568b, v10);
            return v11;
        }
    }

    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return i.this.X();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return i.this.size();
        }
    }

    public i() {
        E(3);
    }

    public static /* synthetic */ int e(i iVar) {
        int i10 = iVar.f11554f;
        iVar.f11554f = i10 - 1;
        return i10;
    }

    public static <K, V> i<K, V> r() {
        return new i<>();
    }

    public int A(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f11554f) {
            return i11;
        }
        return -1;
    }

    public final int B() {
        return (1 << (this.f11553e & 31)) - 1;
    }

    public void C() {
        this.f11553e += 32;
    }

    public final int D(Object obj) {
        if (J()) {
            return -1;
        }
        int iC = o.c(obj);
        int iB = B();
        int iH = j.h(N(), iC & iB);
        if (iH == 0) {
            return -1;
        }
        int iB2 = j.b(iC, iB);
        do {
            int i10 = iH - 1;
            int iX = x(i10);
            if (j.b(iX, iB) == iB2 && j6.i.a(obj, G(i10))) {
                return i10;
            }
            iH = j.c(iX, iB);
        } while (iH != 0);
        return -1;
    }

    public void E(int i10) {
        j6.m.e(i10 >= 0, "Expected size must be >= 0");
        this.f11553e = n6.f.c(i10, 1, 1073741823);
    }

    public void F(int i10, K k10, V v10, int i11, int i12) {
        S(i10, j.d(i11, 0, i12));
        U(i10, k10);
        V(i10, v10);
    }

    public final K G(int i10) {
        return (K) M()[i10];
    }

    public Iterator<K> H() {
        Map<K, V> mapW = w();
        return mapW != null ? mapW.keySet().iterator() : new a();
    }

    public void I(int i10, int i11) {
        Object objN = N();
        int[] iArrL = L();
        Object[] objArrM = M();
        Object[] objArrO = O();
        int size = size() - 1;
        if (i10 >= size) {
            objArrM[i10] = null;
            objArrO[i10] = null;
            iArrL[i10] = 0;
            return;
        }
        Object obj = objArrM[size];
        objArrM[i10] = obj;
        objArrO[i10] = objArrO[size];
        objArrM[size] = null;
        objArrO[size] = null;
        iArrL[i10] = iArrL[size];
        iArrL[size] = 0;
        int iC = o.c(obj) & i11;
        int iH = j.h(objN, iC);
        int i12 = size + 1;
        if (iH == i12) {
            j.i(objN, iC, i10 + 1);
            return;
        }
        while (true) {
            int i13 = iH - 1;
            int i14 = iArrL[i13];
            int iC2 = j.c(i14, i11);
            if (iC2 == i12) {
                iArrL[i13] = j.d(i14, i10 + 1, i11);
                return;
            }
            iH = iC2;
        }
    }

    public boolean J() {
        return this.f11549a == null;
    }

    public final Object K(Object obj) {
        if (J()) {
            return f11548o;
        }
        int iB = B();
        int iF = j.f(obj, null, iB, N(), L(), M(), null);
        if (iF == -1) {
            return f11548o;
        }
        V vW = W(iF);
        I(iF, iB);
        this.f11554f--;
        C();
        return vW;
    }

    public final int[] L() {
        int[] iArr = this.f11550b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] M() {
        Object[] objArr = this.f11551c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object N() {
        Object obj = this.f11549a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] O() {
        Object[] objArr = this.f11552d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void P(int i10) {
        this.f11550b = Arrays.copyOf(L(), i10);
        this.f11551c = Arrays.copyOf(M(), i10);
        this.f11552d = Arrays.copyOf(O(), i10);
    }

    public final void Q(int i10) {
        int iMin;
        int length = L().length;
        if (i10 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        P(iMin);
    }

    public final int R(int i10, int i11, int i12, int i13) {
        Object objA = j.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            j.i(objA, i12 & i14, i13 + 1);
        }
        Object objN = N();
        int[] iArrL = L();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iH = j.h(objN, i15);
            while (iH != 0) {
                int i16 = iH - 1;
                int i17 = iArrL[i16];
                int iB = j.b(i17, i10) | i15;
                int i18 = iB & i14;
                int iH2 = j.h(objA, i18);
                j.i(objA, i18, iH);
                iArrL[i16] = j.d(iB, iH2, i14);
                iH = j.c(i17, i10);
            }
        }
        this.f11549a = objA;
        T(i14);
        return i14;
    }

    public final void S(int i10, int i11) {
        L()[i10] = i11;
    }

    public final void T(int i10) {
        this.f11553e = j.d(this.f11553e, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    public final void U(int i10, K k10) {
        M()[i10] = k10;
    }

    public final void V(int i10, V v10) {
        O()[i10] = v10;
    }

    public final V W(int i10) {
        return (V) O()[i10];
    }

    public Iterator<V> X() {
        Map<K, V> mapW = w();
        return mapW != null ? mapW.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (J()) {
            return;
        }
        C();
        Map<K, V> mapW = w();
        if (mapW != null) {
            this.f11553e = n6.f.c(size(), 3, 1073741823);
            mapW.clear();
            this.f11549a = null;
        } else {
            Arrays.fill(M(), 0, this.f11554f, (Object) null);
            Arrays.fill(O(), 0, this.f11554f, (Object) null);
            j.g(N());
            Arrays.fill(L(), 0, this.f11554f, 0);
        }
        this.f11554f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapW = w();
        if (mapW != null) {
            return mapW.containsKey(obj);
        }
        return D(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapW = w();
        if (mapW != null) {
            return mapW.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f11554f; i10++) {
            if (j6.i.a(obj, W(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f11556m;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setS = s();
        this.f11556m = setS;
        return setS;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapW = w();
        if (mapW != null) {
            return mapW.get(obj);
        }
        int iD = D(obj);
        if (iD == -1) {
            return null;
        }
        n(iD);
        return W(iD);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f11555l;
        if (set != null) {
            return set;
        }
        Set<K> setU = u();
        this.f11555l = setU;
        return setU;
    }

    public void n(int i10) {
    }

    public int o(int i10, int i11) {
        return i10 - 1;
    }

    public int p() {
        j6.m.v(J(), "Arrays already allocated");
        int i10 = this.f11553e;
        int iJ = j.j(i10);
        this.f11549a = j.a(iJ);
        T(iJ - 1);
        this.f11550b = new int[i10];
        this.f11551c = new Object[i10];
        this.f11552d = new Object[i10];
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        int iR;
        if (J()) {
            p();
        }
        Map<K, V> mapW = w();
        if (mapW != null) {
            return mapW.put(k10, v10);
        }
        int[] iArrL = L();
        Object[] objArrM = M();
        Object[] objArrO = O();
        int i10 = this.f11554f;
        int i11 = i10 + 1;
        int iC = o.c(k10);
        int iB = B();
        int i12 = iC & iB;
        int iH = j.h(N(), i12);
        if (iH != 0) {
            int iB2 = j.b(iC, iB);
            int i13 = 0;
            while (true) {
                int i14 = iH - 1;
                int i15 = iArrL[i14];
                if (j.b(i15, iB) == iB2 && j6.i.a(k10, objArrM[i14])) {
                    V v11 = (V) objArrO[i14];
                    objArrO[i14] = v10;
                    n(i14);
                    return v11;
                }
                int iC2 = j.c(i15, iB);
                i13++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i13 >= 9) {
                        return q().put(k10, v10);
                    }
                    if (i11 > iB) {
                        iR = R(iB, j.e(iB), iC, i10);
                    } else {
                        iArrL[i14] = j.d(i15, i11, iB);
                        iR = iB;
                    }
                }
            }
        } else if (i11 > iB) {
            iR = R(iB, j.e(iB), iC, i10);
        } else {
            j.i(N(), i12, i11);
            iR = iB;
        }
        Q(i11);
        F(i10, k10, v10, iC, iR);
        this.f11554f = i11;
        C();
        return null;
    }

    public Map<K, V> q() {
        Map<K, V> mapT = t(B() + 1);
        int iZ = z();
        while (iZ >= 0) {
            mapT.put(G(iZ), W(iZ));
            iZ = A(iZ);
        }
        this.f11549a = mapT;
        this.f11550b = null;
        this.f11551c = null;
        this.f11552d = null;
        C();
        return mapT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapW = w();
        if (mapW != null) {
            return mapW.remove(obj);
        }
        V v10 = (V) K(obj);
        if (v10 == f11548o) {
            return null;
        }
        return v10;
    }

    public Set<Map.Entry<K, V>> s() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapW = w();
        return mapW != null ? mapW.size() : this.f11554f;
    }

    public Map<K, V> t(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    public Set<K> u() {
        return new f();
    }

    public Collection<V> v() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f11557n;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionV = v();
        this.f11557n = collectionV;
        return collectionV;
    }

    public Map<K, V> w() {
        Object obj = this.f11549a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int x(int i10) {
        return L()[i10];
    }

    public Iterator<Map.Entry<K, V>> y() {
        Map<K, V> mapW = w();
        return mapW != null ? mapW.entrySet().iterator() : new b();
    }

    public int z() {
        return isEmpty() ? -1 : 0;
    }
}
