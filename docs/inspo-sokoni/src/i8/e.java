package i8;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.q f10525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f10526b;

    public e(h8.q qVar, p pVar) {
        this.f10525a = qVar;
        this.f10526b = pVar;
    }

    public h8.q a() {
        return this.f10525a;
    }

    public p b() {
        return this.f10526b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f10525a.equals(eVar.f10525a)) {
            return this.f10526b.equals(eVar.f10526b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f10525a.hashCode() * 31) + this.f10526b.hashCode();
    }
}
