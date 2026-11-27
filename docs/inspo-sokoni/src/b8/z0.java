package b8;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements a1 {

    public static class b {
        public b() {
        }

        public z0 a() {
            return new z0();
        }
    }

    public z0() {
    }

    public static b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && z0.class == obj.getClass();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "MemoryEagerGcSettings{}";
    }
}
