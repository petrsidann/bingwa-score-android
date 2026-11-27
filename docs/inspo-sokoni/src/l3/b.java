package l3;

/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3.o f12426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d3.i f12427c;

    public b(long j10, d3.o oVar, d3.i iVar) {
        this.f12425a = j10;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f12426b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f12427c = iVar;
    }

    @Override // l3.k
    public d3.i b() {
        return this.f12427c;
    }

    @Override // l3.k
    public long c() {
        return this.f12425a;
    }

    @Override // l3.k
    public d3.o d() {
        return this.f12426b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f12425a == kVar.c() && this.f12426b.equals(kVar.d()) && this.f12427c.equals(kVar.b());
    }

    public int hashCode() {
        long j10 = this.f12425a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f12426b.hashCode()) * 1000003) ^ this.f12427c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f12425a + ", transportContext=" + this.f12426b + ", event=" + this.f12427c + "}";
    }
}
