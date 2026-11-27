package a3;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f337d;

    public a(Integer num, T t10, e eVar, f fVar) {
        this.f334a = num;
        if (t10 == null) {
            throw new NullPointerException("Null payload");
        }
        this.f335b = t10;
        if (eVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f336c = eVar;
        this.f337d = fVar;
    }

    @Override // a3.d
    public Integer a() {
        return this.f334a;
    }

    @Override // a3.d
    public T b() {
        return this.f335b;
    }

    @Override // a3.d
    public e c() {
        return this.f336c;
    }

    @Override // a3.d
    public f d() {
        return this.f337d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.f334a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.f335b.equals(dVar.b()) && this.f336c.equals(dVar.c())) {
                f fVar = this.f337d;
                f fVarD = dVar.d();
                if (fVar == null) {
                    if (fVarD == null) {
                        return true;
                    }
                } else if (fVar.equals(fVarD)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f334a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f335b.hashCode()) * 1000003) ^ this.f336c.hashCode()) * 1000003;
        f fVar = this.f337d;
        return iHashCode ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.f334a + ", payload=" + this.f335b + ", priority=" + this.f336c + ", productData=" + this.f337d + "}";
    }
}
