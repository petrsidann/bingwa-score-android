package c7;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3409b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f3410a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<String, String> f3411a = new HashMap<>();

        public a a() {
            if (this.f3411a == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            a aVar = new a(Collections.unmodifiableMap(this.f3411a));
            this.f3411a = null;
            return aVar;
        }
    }

    public a(Map<String, String> map) {
        this.f3410a = map;
    }

    public static b a() {
        return new b();
    }

    public Map<String, String> b() {
        return this.f3410a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f3410a.equals(((a) obj).f3410a);
        }
        return false;
    }

    public int hashCode() {
        return this.f3410a.hashCode();
    }

    public String toString() {
        return this.f3410a.toString();
    }
}
