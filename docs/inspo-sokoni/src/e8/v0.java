package e8;

/* JADX INFO: loaded from: classes.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.k f7339b;

    public enum a {
        ADDED,
        REMOVED
    }

    public v0(a aVar, h8.k kVar) {
        this.f7338a = aVar;
        this.f7339b = kVar;
    }

    public h8.k a() {
        return this.f7339b;
    }

    public a b() {
        return this.f7338a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f7338a.equals(v0Var.b()) && this.f7339b.equals(v0Var.a());
    }

    public int hashCode() {
        return ((2077 + this.f7338a.hashCode()) * 31) + this.f7339b.hashCode();
    }
}
