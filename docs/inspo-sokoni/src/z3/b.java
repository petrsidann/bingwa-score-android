package z3;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19777a = 1;

    public b a(Object obj) {
        this.f19777a = (this.f19777a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f19777a;
    }

    public final b c(boolean z10) {
        this.f19777a = (this.f19777a * 31) + (z10 ? 1 : 0);
        return this;
    }
}
