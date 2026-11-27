package p;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<K, V> f13909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f13910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f13911c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13912d = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f13916d;
        }

        @Override // p.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f13915c;
        }
    }

    /* JADX INFO: renamed from: p.b$b, reason: collision with other inner class name */
    public static class C0239b<K, V> extends e<K, V> {
        public C0239b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f13915c;
        }

        @Override // p.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f13916d;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f13913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f13914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<K, V> f13915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c<K, V> f13916d;

        public c(K k10, V v10) {
            this.f13913a = k10;
            this.f13914b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f13913a.equals(cVar.f13913a) && this.f13914b.equals(cVar.f13914b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f13913a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f13914b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f13913a.hashCode() ^ this.f13914b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f13913a + "=" + this.f13914b;
        }
    }

    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f13917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13918b = true;

        public d() {
        }

        @Override // p.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f13917a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f13916d;
                this.f13917a = cVar3;
                this.f13918b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f13918b) {
                this.f13918b = false;
                cVar = b.this.f13909a;
            } else {
                c<K, V> cVar2 = this.f13917a;
                cVar = cVar2 != null ? cVar2.f13915c : null;
            }
            this.f13917a = cVar;
            return this.f13917a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f13918b) {
                return b.this.f13909a != null;
            }
            c<K, V> cVar = this.f13917a;
            return (cVar == null || cVar.f13915c == null) ? false : true;
        }
    }

    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f13920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f13921b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f13920a = cVar2;
            this.f13921b = cVar;
        }

        @Override // p.b.f
        public void b(c<K, V> cVar) {
            if (this.f13920a == cVar && cVar == this.f13921b) {
                this.f13921b = null;
                this.f13920a = null;
            }
            c<K, V> cVar2 = this.f13920a;
            if (cVar2 == cVar) {
                this.f13920a = c(cVar2);
            }
            if (this.f13921b == cVar) {
                this.f13921b = f();
            }
        }

        public abstract c<K, V> c(c<K, V> cVar);

        public abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f13921b;
            this.f13921b = f();
            return cVar;
        }

        public final c<K, V> f() {
            c<K, V> cVar = this.f13921b;
            c<K, V> cVar2 = this.f13920a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13921b != null;
        }
    }

    public static abstract class f<K, V> {
        public abstract void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0239b c0239b = new C0239b(this.f13910b, this.f13909a);
        this.f13911c.put(c0239b, Boolean.FALSE);
        return c0239b;
    }

    public Map.Entry<K, V> e() {
        return this.f13909a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public c<K, V> h(K k10) {
        c<K, V> cVar = this.f13909a;
        while (cVar != null && !cVar.f13913a.equals(k10)) {
            cVar = cVar.f13915c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public b<K, V>.d i() {
        b<K, V>.d dVar = new d();
        this.f13911c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f13909a, this.f13910b);
        this.f13911c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry<K, V> j() {
        return this.f13910b;
    }

    public c<K, V> k(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f13912d++;
        c<K, V> cVar2 = this.f13910b;
        if (cVar2 == null) {
            this.f13909a = cVar;
        } else {
            cVar2.f13915c = cVar;
            cVar.f13916d = cVar2;
        }
        this.f13910b = cVar;
        return cVar;
    }

    public V l(K k10, V v10) {
        c<K, V> cVarH = h(k10);
        if (cVarH != null) {
            return cVarH.f13914b;
        }
        k(k10, v10);
        return null;
    }

    public V n(K k10) {
        c<K, V> cVarH = h(k10);
        if (cVarH == null) {
            return null;
        }
        this.f13912d--;
        if (!this.f13911c.isEmpty()) {
            Iterator<f<K, V>> it = this.f13911c.keySet().iterator();
            while (it.hasNext()) {
                it.next().b(cVarH);
            }
        }
        c<K, V> cVar = cVarH.f13916d;
        c<K, V> cVar2 = cVarH.f13915c;
        if (cVar != null) {
            cVar.f13915c = cVar2;
        } else {
            this.f13909a = cVar2;
        }
        c<K, V> cVar3 = cVarH.f13915c;
        if (cVar3 != null) {
            cVar3.f13916d = cVar;
        } else {
            this.f13910b = cVar;
        }
        cVarH.f13915c = null;
        cVarH.f13916d = null;
        return cVarH.f13914b;
    }

    public int size() {
        return this.f13912d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
