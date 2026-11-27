package k6;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class f<F, T> extends i0<F> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j6.e<F, ? extends T> f11545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0<T> f11546b;

    public f(j6.e<F, ? extends T> eVar, i0<T> i0Var) {
        this.f11545a = (j6.e) j6.m.o(eVar);
        this.f11546b = (i0) j6.m.o(i0Var);
    }

    @Override // k6.i0, java.util.Comparator
    public int compare(F f10, F f11) {
        return this.f11546b.compare(this.f11545a.apply(f10), this.f11545a.apply(f11));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11545a.equals(fVar.f11545a) && this.f11546b.equals(fVar.f11546b);
    }

    public int hashCode() {
        return j6.i.b(this.f11545a, this.f11546b);
    }

    public String toString() {
        return this.f11546b + ".onResultOf(" + this.f11545a + ")";
    }
}
