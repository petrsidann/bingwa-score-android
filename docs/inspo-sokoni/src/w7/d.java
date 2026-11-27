package w7;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Object> f17654b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Class<?>, Object> f17656b = null;

        public b(String str) {
            this.f17655a = str;
        }

        public d a() {
            return new d(this.f17655a, this.f17656b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f17656b)));
        }

        public <T extends Annotation> b b(T t10) {
            if (this.f17656b == null) {
                this.f17656b = new HashMap();
            }
            this.f17656b.put(t10.annotationType(), t10);
            return this;
        }
    }

    public d(String str, Map<Class<?>, Object> map) {
        this.f17653a = str;
        this.f17654b = map;
    }

    public static b a(String str) {
        return new b(str);
    }

    public static d d(String str) {
        return new d(str, Collections.emptyMap());
    }

    public String b() {
        return this.f17653a;
    }

    public <T extends Annotation> T c(Class<T> cls) {
        return (T) this.f17654b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f17653a.equals(dVar.f17653a) && this.f17654b.equals(dVar.f17654b);
    }

    public int hashCode() {
        return (this.f17653a.hashCode() * 31) + this.f17654b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f17653a + ", properties=" + this.f17654b.values() + "}";
    }
}
