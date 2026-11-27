package e8;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.f f7218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7221d;

    public l(h8.f fVar, String str, String str2, boolean z10) {
        this.f7218a = fVar;
        this.f7219b = str;
        this.f7220c = str2;
        this.f7221d = z10;
    }

    public h8.f a() {
        return this.f7218a;
    }

    public String b() {
        return this.f7220c;
    }

    public String c() {
        return this.f7219b;
    }

    public boolean d() {
        return this.f7221d;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.f7218a + " host:" + this.f7220c + ")";
    }
}
