package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9202a;

    public h1(boolean z10) {
        this.f9202a = z10;
    }

    @Override // gd.t1
    public l2 a() {
        return null;
    }

    @Override // gd.t1
    public boolean isActive() {
        return this.f9202a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
