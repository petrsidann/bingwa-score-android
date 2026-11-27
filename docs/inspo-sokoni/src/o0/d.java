package o0;

/* JADX INFO: loaded from: classes.dex */
public class d<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f13608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f13609b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f13608a, this.f13608a) && c.a(dVar.f13609b, this.f13609b);
    }

    public int hashCode() {
        F f10 = this.f13608a;
        int iHashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f13609b;
        return iHashCode ^ (s10 != null ? s10.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f13608a + " " + this.f13609b + "}";
    }
}
