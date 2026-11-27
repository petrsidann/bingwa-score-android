package q7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<e0<? super T>> f14825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<q> f14826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g<T> f14829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Class<?>> f14830g;

    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<e0<? super T>> f14832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<q> f14833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14835e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<T> f14836f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set<Class<?>> f14837g;

        @SafeVarargs
        public b(Class<T> cls, Class<? super T>... clsArr) {
            this.f14831a = null;
            HashSet hashSet = new HashSet();
            this.f14832b = hashSet;
            this.f14833c = new HashSet();
            this.f14834d = 0;
            this.f14835e = 0;
            this.f14837g = new HashSet();
            d0.c(cls, "Null interface");
            hashSet.add(e0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                d0.c(cls2, "Null interface");
                this.f14832b.add(e0.b(cls2));
            }
        }

        @SafeVarargs
        public b(e0<T> e0Var, e0<? super T>... e0VarArr) {
            this.f14831a = null;
            HashSet hashSet = new HashSet();
            this.f14832b = hashSet;
            this.f14833c = new HashSet();
            this.f14834d = 0;
            this.f14835e = 0;
            this.f14837g = new HashSet();
            d0.c(e0Var, "Null interface");
            hashSet.add(e0Var);
            for (e0<? super T> e0Var2 : e0VarArr) {
                d0.c(e0Var2, "Null interface");
            }
            Collections.addAll(this.f14832b, e0VarArr);
        }

        public b<T> b(q qVar) {
            d0.c(qVar, "Null dependency");
            j(qVar.c());
            this.f14833c.add(qVar);
            return this;
        }

        public b<T> c() {
            return i(1);
        }

        public c<T> d() {
            d0.d(this.f14836f != null, "Missing required property: factory.");
            return new c<>(this.f14831a, new HashSet(this.f14832b), new HashSet(this.f14833c), this.f14834d, this.f14835e, this.f14836f, this.f14837g);
        }

        public b<T> e() {
            return i(2);
        }

        public b<T> f(g<T> gVar) {
            this.f14836f = (g) d0.c(gVar, "Null factory");
            return this;
        }

        public final b<T> g() {
            this.f14835e = 1;
            return this;
        }

        public b<T> h(String str) {
            this.f14831a = str;
            return this;
        }

        public final b<T> i(int i10) {
            d0.d(this.f14834d == 0, "Instantiation type has already been set.");
            this.f14834d = i10;
            return this;
        }

        public final void j(e0<?> e0Var) {
            d0.a(!this.f14832b.contains(e0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }
    }

    public c(String str, Set<e0<? super T>> set, Set<q> set2, int i10, int i11, g<T> gVar, Set<Class<?>> set3) {
        this.f14824a = str;
        this.f14825b = Collections.unmodifiableSet(set);
        this.f14826c = Collections.unmodifiableSet(set2);
        this.f14827d = i10;
        this.f14828e = i11;
        this.f14829f = gVar;
        this.f14830g = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> e(e0<T> e0Var) {
        return new b<>(e0Var, new e0[0]);
    }

    @SafeVarargs
    public static <T> b<T> f(e0<T> e0Var, e0<? super T>... e0VarArr) {
        return new b<>(e0Var, e0VarArr);
    }

    public static <T> c<T> l(final T t10, Class<T> cls) {
        return m(cls).f(new g() { // from class: q7.a
            @Override // q7.g
            public final Object a(d dVar) {
                return c.q(t10, dVar);
            }
        }).d();
    }

    public static <T> b<T> m(Class<T> cls) {
        return c(cls).g();
    }

    public static /* synthetic */ Object q(Object obj, d dVar) {
        return obj;
    }

    public static /* synthetic */ Object r(Object obj, d dVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> c<T> s(final T t10, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).f(new g() { // from class: q7.b
            @Override // q7.g
            public final Object a(d dVar) {
                return c.r(t10, dVar);
            }
        }).d();
    }

    public Set<q> g() {
        return this.f14826c;
    }

    public g<T> h() {
        return this.f14829f;
    }

    public String i() {
        return this.f14824a;
    }

    public Set<e0<? super T>> j() {
        return this.f14825b;
    }

    public Set<Class<?>> k() {
        return this.f14830g;
    }

    public boolean n() {
        return this.f14827d == 1;
    }

    public boolean o() {
        return this.f14827d == 2;
    }

    public boolean p() {
        return this.f14828e == 0;
    }

    public c<T> t(g<T> gVar) {
        return new c<>(this.f14824a, this.f14825b, this.f14826c, this.f14827d, this.f14828e, gVar, this.f14830g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f14825b.toArray()) + ">{" + this.f14827d + ", type=" + this.f14828e + ", deps=" + Arrays.toString(this.f14826c.toArray()) + "}";
    }
}
