package j6;

/* JADX INFO: loaded from: classes.dex */
public final class n<T> extends j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f11280a;

    public n(T t10) {
        this.f11280a = t10;
    }

    @Override // j6.j
    public T c() {
        return this.f11280a;
    }

    @Override // j6.j
    public boolean d() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f11280a.equals(((n) obj).f11280a);
        }
        return false;
    }

    @Override // j6.j
    public T f(T t10) {
        m.p(t10, "use Optional.orNull() instead of Optional.or(null)");
        return this.f11280a;
    }

    @Override // j6.j
    public T g() {
        return this.f11280a;
    }

    public int hashCode() {
        return this.f11280a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f11280a + ")";
    }
}
