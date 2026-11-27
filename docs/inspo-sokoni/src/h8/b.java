package h8;

/* JADX INFO: loaded from: classes.dex */
public final class b extends p.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f9730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f9731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9732e;

    public b(v vVar, k kVar, int i10) {
        if (vVar == null) {
            throw new NullPointerException("Null readTime");
        }
        this.f9730c = vVar;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f9731d = kVar;
        this.f9732e = i10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.a)) {
            return false;
        }
        p.a aVar = (p.a) obj;
        return this.f9730c.equals(aVar.p()) && this.f9731d.equals(aVar.n()) && this.f9732e == aVar.o();
    }

    public int hashCode() {
        return ((((this.f9730c.hashCode() ^ 1000003) * 1000003) ^ this.f9731d.hashCode()) * 1000003) ^ this.f9732e;
    }

    @Override // h8.p.a
    public k n() {
        return this.f9731d;
    }

    @Override // h8.p.a
    public int o() {
        return this.f9732e;
    }

    @Override // h8.p.a
    public v p() {
        return this.f9730c;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.f9730c + ", documentKey=" + this.f9731d + ", largestBatchId=" + this.f9732e + "}";
    }
}
