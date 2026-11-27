package i8;

/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f10522b;

    public b(int i10, f fVar) {
        this.f10521a = i10;
        if (fVar == null) {
            throw new NullPointerException("Null mutation");
        }
        this.f10522b = fVar;
    }

    @Override // i8.k
    public int c() {
        return this.f10521a;
    }

    @Override // i8.k
    public f d() {
        return this.f10522b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f10521a == kVar.c() && this.f10522b.equals(kVar.d());
    }

    public int hashCode() {
        return ((this.f10521a ^ 1000003) * 1000003) ^ this.f10522b.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.f10521a + ", mutation=" + this.f10522b + "}";
    }
}
