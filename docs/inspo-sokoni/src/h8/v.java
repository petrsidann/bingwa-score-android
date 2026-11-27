package h8;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Comparable<v> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f9777b = new v(new h7.q(0, 0));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7.q f9778a;

    public v(h7.q qVar) {
        this.f9778a = qVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        return this.f9778a.compareTo(vVar.f9778a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof v) && compareTo((v) obj) == 0;
    }

    public h7.q h() {
        return this.f9778a;
    }

    public int hashCode() {
        return h().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.f9778a.k() + ", nanos=" + this.f9778a.h() + ")";
    }
}
