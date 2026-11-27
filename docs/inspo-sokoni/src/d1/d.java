package d1;

import java.util.Map;
import kotlin.jvm.internal.k;
import mc.e0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6269a;

        public a(String name) {
            k.e(name, "name");
            this.f6269a = name;
        }

        public final String a() {
            return this.f6269a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return k.a(this.f6269a, ((a) obj).f6269a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6269a.hashCode();
        }

        public String toString() {
            return this.f6269a;
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<T> f6270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f6271b;

        public final a<T> a() {
            return this.f6270a;
        }

        public final T b() {
            return this.f6271b;
        }
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);

    public final d c() {
        return new d1.a(e0.o(a()), true);
    }
}
