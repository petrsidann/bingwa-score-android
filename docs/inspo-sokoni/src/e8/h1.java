package e8;

/* JADX INFO: loaded from: classes.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7180b;

    public h1(int i10, int i11) {
        l8.b.d((i10 & 1) == i10, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i10), 1);
        this.f7180b = i10;
        d(i11);
    }

    public static h1 a() {
        return new h1(1, 1);
    }

    public static h1 b(int i10) {
        h1 h1Var = new h1(0, i10);
        h1Var.c();
        return h1Var;
    }

    public int c() {
        int i10 = this.f7179a;
        this.f7179a = i10 + 2;
        return i10;
    }

    public final void d(int i10) {
        l8.b.d((i10 & 1) == this.f7180b, "Cannot supply target ID from different generator ID", new Object[0]);
        this.f7179a = i10;
    }
}
