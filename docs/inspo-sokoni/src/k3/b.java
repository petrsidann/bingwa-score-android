package k3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3.a f11444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a3.e, f.b> f11445b;

    public b(n3.a aVar, Map<a3.e, f.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f11444a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f11445b = map;
    }

    @Override // k3.f
    public n3.a e() {
        return this.f11444a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11444a.equals(fVar.e()) && this.f11445b.equals(fVar.h());
    }

    @Override // k3.f
    public Map<a3.e, f.b> h() {
        return this.f11445b;
    }

    public int hashCode() {
        return ((this.f11444a.hashCode() ^ 1000003) * 1000003) ^ this.f11445b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f11444a + ", values=" + this.f11445b + "}";
    }
}
