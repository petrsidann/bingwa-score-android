package b8;

/* JADX INFO: loaded from: classes.dex */
public class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2971b;

    public t1(boolean z10, boolean z11) {
        this.f2970a = z10;
        this.f2971b = z11;
    }

    public boolean a() {
        return this.f2970a;
    }

    public boolean b() {
        return this.f2971b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.f2970a == t1Var.f2970a && this.f2971b == t1Var.f2971b;
    }

    public int hashCode() {
        return ((this.f2970a ? 1 : 0) * 31) + (this.f2971b ? 1 : 0);
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f2970a + ", isFromCache=" + this.f2971b + '}';
    }
}
