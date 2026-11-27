package vb;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap<c<?>, Object> f17233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17234c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<c<?>, Object> f17235a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f17236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap<c<?>, Object> f17237b;

        public b(a aVar) {
            this.f17236a = aVar;
        }

        public a a() {
            if (this.f17237b != null) {
                for (Map.Entry entry : this.f17236a.f17235a.entrySet()) {
                    if (!this.f17237b.containsKey(entry.getKey())) {
                        this.f17237b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f17236a = new a(this.f17237b);
                this.f17237b = null;
            }
            return this.f17236a;
        }

        public final IdentityHashMap<c<?>, Object> b(int i10) {
            if (this.f17237b == null) {
                this.f17237b = new IdentityHashMap<>(i10);
            }
            return this.f17237b;
        }

        public <T> b c(c<T> cVar) {
            if (this.f17236a.f17235a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f17236a.f17235a);
                identityHashMap.remove(cVar);
                this.f17236a = new a(identityHashMap);
            }
            IdentityHashMap<c<?>, Object> identityHashMap2 = this.f17237b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> b d(c<T> cVar, T t10) {
            b(1).put(cVar, t10);
            return this;
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17238a;

        public c(String str) {
            this.f17238a = str;
        }

        public static <T> c<T> a(String str) {
            return new c<>(str);
        }

        public String toString() {
            return this.f17238a;
        }
    }

    static {
        IdentityHashMap<c<?>, Object> identityHashMap = new IdentityHashMap<>();
        f17233b = identityHashMap;
        f17234c = new a(identityHashMap);
    }

    public a(IdentityHashMap<c<?>, Object> identityHashMap) {
        this.f17235a = identityHashMap;
    }

    public static b c() {
        return new b();
    }

    public <T> T b(c<T> cVar) {
        return (T) this.f17235a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f17235a.size() != aVar.f17235a.size()) {
            return false;
        }
        for (Map.Entry<c<?>, Object> entry : this.f17235a.entrySet()) {
            if (!aVar.f17235a.containsKey(entry.getKey()) || !j6.i.a(entry.getValue(), aVar.f17235a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iB = 0;
        for (Map.Entry<c<?>, Object> entry : this.f17235a.entrySet()) {
            iB += j6.i.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public String toString() {
        return this.f17235a.toString();
    }
}
