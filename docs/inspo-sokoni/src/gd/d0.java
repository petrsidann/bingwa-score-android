package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.l<Throwable, lc.q> f9151b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Object obj, xc.l<? super Throwable, lc.q> lVar) {
        this.f9150a = obj;
        this.f9151b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return kotlin.jvm.internal.k.a(this.f9150a, d0Var.f9150a) && kotlin.jvm.internal.k.a(this.f9151b, d0Var.f9151b);
    }

    public int hashCode() {
        Object obj = this.f9150a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f9151b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f9150a + ", onCancellation=" + this.f9151b + ')';
    }
}
