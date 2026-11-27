package s7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k<K, V> extends c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h<K, V> f15607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Comparator<K> f15608b;

    public static class b<A, B, C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<A> f15609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<B, C> f15610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.a.InterfaceC0276a<A, B> f15611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j<A, C> f15612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j<A, C> f15613e;

        public static class a implements Iterable<C0278b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f15614a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f15615b;

            /* JADX INFO: renamed from: s7.k$b$a$a, reason: collision with other inner class name */
            public class C0277a implements Iterator<C0278b> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f15616a;

                public C0277a() {
                    this.f15616a = a.this.f15615b - 1;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public C0278b next() {
                    long j10 = a.this.f15614a & ((long) (1 << this.f15616a));
                    C0278b c0278b = new C0278b();
                    c0278b.f15618a = j10 == 0;
                    c0278b.f15619b = (int) Math.pow(2.0d, this.f15616a);
                    this.f15616a--;
                    return c0278b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f15616a >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }

            public a(int i10) {
                int i11 = i10 + 1;
                int iFloor = (int) Math.floor(Math.log(i11) / Math.log(2.0d));
                this.f15615b = iFloor;
                this.f15614a = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i11);
            }

            @Override // java.lang.Iterable
            public Iterator<C0278b> iterator() {
                return new C0277a();
            }
        }

        /* JADX INFO: renamed from: s7.k$b$b, reason: collision with other inner class name */
        public static class C0278b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f15618a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15619b;
        }

        public b(List<A> list, Map<B, C> map, c.a.InterfaceC0276a<A, B> interfaceC0276a) {
            this.f15609a = list;
            this.f15610b = map;
            this.f15611c = interfaceC0276a;
        }

        public static <A, B, C> k<A, C> b(List<A> list, Map<B, C> map, c.a.InterfaceC0276a<A, B> interfaceC0276a, Comparator<A> comparator) {
            b bVar = new b(list, map, interfaceC0276a);
            Collections.sort(list, comparator);
            int size = list.size();
            for (C0278b c0278b : new a(list.size())) {
                int i10 = c0278b.f15619b;
                size -= i10;
                if (c0278b.f15618a) {
                    bVar.c(h.a.BLACK, i10, size);
                } else {
                    bVar.c(h.a.BLACK, i10, size);
                    int i11 = c0278b.f15619b;
                    size -= i11;
                    bVar.c(h.a.RED, i11, size);
                }
            }
            h hVarI = bVar.f15612d;
            if (hVarI == null) {
                hVarI = g.i();
            }
            return new k<>(hVarI, comparator);
        }

        public final h<A, C> a(int i10, int i11) {
            if (i11 == 0) {
                return g.i();
            }
            if (i11 == 1) {
                A a10 = this.f15609a.get(i10);
                return new f(a10, d(a10), null, null);
            }
            int i12 = i11 / 2;
            int i13 = i10 + i12;
            h<A, C> hVarA = a(i10, i12);
            h<A, C> hVarA2 = a(i13 + 1, i12);
            A a11 = this.f15609a.get(i13);
            return new f(a11, d(a11), hVarA, hVarA2);
        }

        public final void c(h.a aVar, int i10, int i11) {
            h<A, C> hVarA = a(i11 + 1, i10 - 1);
            A a10 = this.f15609a.get(i11);
            j<A, C> iVar = aVar == h.a.RED ? new i<>(a10, d(a10), null, hVarA) : new f<>(a10, d(a10), null, hVarA);
            if (this.f15612d == null) {
                this.f15612d = iVar;
            } else {
                this.f15613e.t(iVar);
            }
            this.f15613e = iVar;
        }

        public final C d(A a10) {
            return this.f15610b.get(this.f15611c.a(a10));
        }
    }

    public k(h<K, V> hVar, Comparator<K> comparator) {
        this.f15607a = hVar;
        this.f15608b = comparator;
    }

    public static <A, B, C> k<A, C> q(List<A> list, Map<B, C> map, c.a.InterfaceC0276a<A, B> interfaceC0276a, Comparator<A> comparator) {
        return b.b(list, map, interfaceC0276a, comparator);
    }

    public static <A, B> k<A, B> r(Map<A, B> map, Comparator<A> comparator) {
        return b.b(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    @Override // s7.c
    public boolean e(K k10) {
        return s(k10) != null;
    }

    @Override // s7.c
    public V h(K k10) {
        h<K, V> hVarS = s(k10);
        if (hVarS != null) {
            return hVarS.getValue();
        }
        return null;
    }

    @Override // s7.c
    public Comparator<K> i() {
        return this.f15608b;
    }

    @Override // s7.c
    public int indexOf(K k10) {
        h<K, V> hVarA = this.f15607a;
        int size = 0;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f15608b.compare(k10, hVarA.getKey());
            if (iCompare == 0) {
                return size + hVarA.a().size();
            }
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                size += hVarA.a().size() + 1;
                hVarA = hVarA.f();
            }
        }
        return -1;
    }

    @Override // s7.c
    public boolean isEmpty() {
        return this.f15607a.isEmpty();
    }

    @Override // s7.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new d(this.f15607a, null, this.f15608b, false);
    }

    @Override // s7.c
    public K j() {
        return this.f15607a.h().getKey();
    }

    @Override // s7.c
    public K k() {
        return this.f15607a.g().getKey();
    }

    @Override // s7.c
    public c<K, V> l(K k10, V v10) {
        return new k(this.f15607a.b(k10, v10, this.f15608b).e(null, null, h.a.BLACK, null, null), this.f15608b);
    }

    @Override // s7.c
    public Iterator<Map.Entry<K, V>> n(K k10) {
        return new d(this.f15607a, k10, this.f15608b, false);
    }

    @Override // s7.c
    public c<K, V> o(K k10) {
        return !e(k10) ? this : new k(this.f15607a.c(k10, this.f15608b).e(null, null, h.a.BLACK, null, null), this.f15608b);
    }

    public final h<K, V> s(K k10) {
        h<K, V> hVarA = this.f15607a;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f15608b.compare(k10, hVarA.getKey());
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                if (iCompare == 0) {
                    return hVarA;
                }
                hVarA = hVarA.f();
            }
        }
        return null;
    }

    @Override // s7.c
    public int size() {
        return this.f15607a.size();
    }
}
