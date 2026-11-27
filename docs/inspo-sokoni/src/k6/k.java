package k6;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class k<T> extends i0<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<T> f11571a;

    public k(Comparator<T> comparator) {
        this.f11571a = (Comparator) j6.m.o(comparator);
    }

    @Override // k6.i0, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.f11571a.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return this.f11571a.equals(((k) obj).f11571a);
        }
        return false;
    }

    public int hashCode() {
        return this.f11571a.hashCode();
    }

    public String toString() {
        return this.f11571a.toString();
    }
}
