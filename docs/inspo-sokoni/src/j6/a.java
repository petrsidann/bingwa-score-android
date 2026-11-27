package j6;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> extends j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<Object> f11255a = new a<>();

    public static <T> j<T> h() {
        return f11255a;
    }

    @Override // j6.j
    public T c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // j6.j
    public boolean d() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // j6.j
    public T f(T t10) {
        return (T) m.p(t10, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // j6.j
    public T g() {
        return null;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
