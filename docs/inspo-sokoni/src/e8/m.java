package e8;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.h f7226b;

    public enum a {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    public m(a aVar, h8.h hVar) {
        this.f7225a = aVar;
        this.f7226b = hVar;
    }

    public static m a(a aVar, h8.h hVar) {
        return new m(aVar, hVar);
    }

    public h8.h b() {
        return this.f7226b;
    }

    public a c() {
        return this.f7225a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f7225a.equals(mVar.f7225a) && this.f7226b.equals(mVar.f7226b);
    }

    public int hashCode() {
        return ((((1891 + this.f7225a.hashCode()) * 31) + this.f7226b.getKey().hashCode()) * 31) + this.f7226b.a().hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f7226b + "," + this.f7225a + ")";
    }
}
