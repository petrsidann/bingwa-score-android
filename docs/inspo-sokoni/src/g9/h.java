package g9;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Comparator<Comparable> f9075n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<? super K> f9076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e<K, V> f9078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e<K, V> f9081f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h<K, V>.b f9082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h<K, V>.c f9083m;

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends h<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9079d;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends h<K, V>.d<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f9097f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9079d;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f9088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f9089b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9090c;

        public d() {
            this.f9088a = h.this.f9081f.f9095d;
            this.f9090c = h.this.f9080e;
        }

        public final e<K, V> b() {
            e<K, V> eVar = this.f9088a;
            h hVar = h.this;
            if (eVar == hVar.f9081f) {
                throw new NoSuchElementException();
            }
            if (hVar.f9080e != this.f9090c) {
                throw new ConcurrentModificationException();
            }
            this.f9088a = eVar.f9095d;
            this.f9089b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9088a != h.this.f9081f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f9089b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f9089b = null;
            this.f9090c = h.this.f9080e;
        }
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f9092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f9093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e<K, V> f9094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e<K, V> f9095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e<K, V> f9096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final K f9097f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f9098l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public V f9099m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f9100n;

        public e(boolean z10) {
            this.f9097f = null;
            this.f9098l = z10;
            this.f9096e = this;
            this.f9095d = this;
        }

        public e(boolean z10, e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f9092a = eVar;
            this.f9097f = k10;
            this.f9098l = z10;
            this.f9100n = 1;
            this.f9095d = eVar2;
            this.f9096e = eVar3;
            eVar3.f9095d = this;
            eVar2.f9096e = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9093b; eVar2 != null; eVar2 = eVar2.f9093b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9094c; eVar2 != null; eVar2 = eVar2.f9094c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f9097f;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f9099m;
            Object value = entry.getValue();
            if (v10 == null) {
                if (value != null) {
                    return false;
                }
            } else if (!v10.equals(value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9097f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9099m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f9097f;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f9099m;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (v10 == null && !this.f9098l) {
                throw new NullPointerException("value == null");
            }
            V v11 = this.f9099m;
            this.f9099m = v10;
            return v11;
        }

        public String toString() {
            return this.f9097f + "=" + this.f9099m;
        }
    }

    public h() {
        this(f9075n, true);
    }

    public h(Comparator<? super K> comparator, boolean z10) {
        this.f9079d = 0;
        this.f9080e = 0;
        this.f9076a = comparator == null ? f9075n : comparator;
        this.f9077b = z10;
        this.f9081f = new e<>(z10);
    }

    public h(boolean z10) {
        this(f9075n, z10);
    }

    public final boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e<K, V> b(K k10, boolean z10) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f9076a;
        e<K, V> eVar2 = this.f9078c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f9075n ? (Comparable) k10 : null;
            while (true) {
                K k11 = eVar2.f9097f;
                iCompareTo = comparable != null ? comparable.compareTo(k11) : comparator.compare(k10, k11);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f9093b : eVar2.f9094c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.f9081f;
        if (eVar2 != null) {
            eVar = new e<>(this.f9077b, eVar2, k10, eVar4, eVar4.f9096e);
            if (iCompareTo < 0) {
                eVar2.f9093b = eVar;
            } else {
                eVar2.f9094c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f9075n && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.f9077b, eVar2, k10, eVar4, eVar4.f9096e);
            this.f9078c = eVar;
        }
        this.f9079d++;
        this.f9080e++;
        return eVar;
    }

    public e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD != null && a(eVarD.f9099m, entry.getValue())) {
            return eVarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f9078c = null;
        this.f9079d = 0;
        this.f9080e++;
        e<K, V> eVar = this.f9081f;
        eVar.f9096e = eVar;
        eVar.f9095d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void e(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f9093b;
            e<K, V> eVar3 = eVar.f9094c;
            int i10 = eVar2 != null ? eVar2.f9100n : 0;
            int i11 = eVar3 != null ? eVar3.f9100n : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f9093b;
                e<K, V> eVar5 = eVar3.f9094c;
                int i13 = (eVar4 != null ? eVar4.f9100n : 0) - (eVar5 != null ? eVar5.f9100n : 0);
                if (i13 != -1 && (i13 != 0 || z10)) {
                    j(eVar3);
                }
                i(eVar);
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f9093b;
                e<K, V> eVar7 = eVar2.f9094c;
                int i14 = (eVar6 != null ? eVar6.f9100n : 0) - (eVar7 != null ? eVar7.f9100n : 0);
                if (i14 != 1 && (i14 != 0 || z10)) {
                    i(eVar2);
                }
                j(eVar);
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f9100n = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f9100n = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f9092a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f9082l;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f9082l = bVar2;
        return bVar2;
    }

    public void f(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f9096e;
            eVar2.f9095d = eVar.f9095d;
            eVar.f9095d.f9096e = eVar2;
        }
        e<K, V> eVar3 = eVar.f9093b;
        e<K, V> eVar4 = eVar.f9094c;
        e<K, V> eVar5 = eVar.f9092a;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f9093b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f9094c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f9079d--;
            this.f9080e++;
            return;
        }
        e<K, V> eVarB = eVar3.f9100n > eVar4.f9100n ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e<K, V> eVar6 = eVar.f9093b;
        if (eVar6 != null) {
            i10 = eVar6.f9100n;
            eVarB.f9093b = eVar6;
            eVar6.f9092a = eVarB;
            eVar.f9093b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f9094c;
        if (eVar7 != null) {
            i11 = eVar7.f9100n;
            eVarB.f9094c = eVar7;
            eVar7.f9092a = eVarB;
            eVar.f9094c = null;
        }
        eVarB.f9100n = Math.max(i10, i11) + 1;
        h(eVar, eVarB);
    }

    public e<K, V> g(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f9099m;
        }
        return null;
    }

    public final void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f9092a;
        eVar.f9092a = null;
        if (eVar2 != null) {
            eVar2.f9092a = eVar3;
        }
        if (eVar3 == null) {
            this.f9078c = eVar2;
        } else if (eVar3.f9093b == eVar) {
            eVar3.f9093b = eVar2;
        } else {
            eVar3.f9094c = eVar2;
        }
    }

    public final void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9093b;
        e<K, V> eVar3 = eVar.f9094c;
        e<K, V> eVar4 = eVar3.f9093b;
        e<K, V> eVar5 = eVar3.f9094c;
        eVar.f9094c = eVar4;
        if (eVar4 != null) {
            eVar4.f9092a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f9093b = eVar;
        eVar.f9092a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f9100n : 0, eVar4 != null ? eVar4.f9100n : 0) + 1;
        eVar.f9100n = iMax;
        eVar3.f9100n = Math.max(iMax, eVar5 != null ? eVar5.f9100n : 0) + 1;
    }

    public final void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9093b;
        e<K, V> eVar3 = eVar.f9094c;
        e<K, V> eVar4 = eVar2.f9093b;
        e<K, V> eVar5 = eVar2.f9094c;
        eVar.f9093b = eVar5;
        if (eVar5 != null) {
            eVar5.f9092a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f9094c = eVar;
        eVar.f9092a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f9100n : 0, eVar5 != null ? eVar5.f9100n : 0) + 1;
        eVar.f9100n = iMax;
        eVar2.f9100n = Math.max(iMax, eVar4 != null ? eVar4.f9100n : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f9083m;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f9083m = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        if (v10 == null && !this.f9077b) {
            throw new NullPointerException("value == null");
        }
        e<K, V> eVarB = b(k10, true);
        V v11 = eVarB.f9099m;
        eVarB.f9099m = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f9099m;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f9079d;
    }
}
