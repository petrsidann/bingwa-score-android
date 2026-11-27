package j6;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    public static class a<T> implements r<T>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r<T> f11291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile transient boolean f11292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient T f11293c;

        public a(r<T> rVar) {
            this.f11291a = (r) m.o(rVar);
        }

        @Override // j6.r
        public T get() {
            if (!this.f11292b) {
                synchronized (this) {
                    if (!this.f11292b) {
                        T t10 = this.f11291a.get();
                        this.f11293c = t10;
                        this.f11292b = true;
                        return t10;
                    }
                }
            }
            return (T) h.a(this.f11293c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.f11292b) {
                obj = "<supplier that returned " + this.f11293c + ">";
            } else {
                obj = this.f11291a;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class b<T> implements r<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final r<Void> f11294c = new r() { // from class: j6.t
            @Override // j6.r
            public final Object get() {
                return s.b.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile r<T> f11295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f11296b;

        public b(r<T> rVar) {
            this.f11295a = (r) m.o(rVar);
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // j6.r
        public T get() {
            r<T> rVar = this.f11295a;
            r<T> rVar2 = (r<T>) f11294c;
            if (rVar != rVar2) {
                synchronized (this) {
                    if (this.f11295a != rVar2) {
                        T t10 = this.f11295a.get();
                        this.f11296b = t10;
                        this.f11295a = rVar2;
                        return t10;
                    }
                }
            }
            return (T) h.a(this.f11296b);
        }

        public String toString() {
            Object obj = this.f11295a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == f11294c) {
                obj = "<supplier that returned " + this.f11296b + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class c<T> implements r<T>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f11297a;

        public c(T t10) {
            this.f11297a = t10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return i.a(this.f11297a, ((c) obj).f11297a);
            }
            return false;
        }

        @Override // j6.r
        public T get() {
            return this.f11297a;
        }

        public int hashCode() {
            return i.b(this.f11297a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f11297a + ")";
        }
    }

    public static <T> r<T> a(r<T> rVar) {
        if ((rVar instanceof b) || (rVar instanceof a)) {
            return rVar;
        }
        return rVar instanceof Serializable ? new a(rVar) : new b(rVar);
    }

    public static <T> r<T> b(T t10) {
        return new c(t10);
    }
}
