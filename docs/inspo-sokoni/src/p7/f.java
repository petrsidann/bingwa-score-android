package p7;

/* JADX INFO: loaded from: classes.dex */
public final class f extends o7.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14220c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14221d = false;

    @Override // o7.w
    public final void a(boolean z10) {
        this.f14221d = z10;
    }

    @Override // o7.w
    public final void b(boolean z10) {
        this.f14220c = z10;
    }

    @Override // o7.w
    public final void c(String str, String str2) {
        this.f14218a = str;
        this.f14219b = str2;
    }

    public final String d() {
        return this.f14218a;
    }

    public final String e() {
        return this.f14219b;
    }

    public final boolean f() {
        return this.f14221d;
    }

    public final boolean g() {
        return (this.f14218a == null || this.f14219b == null) ? false : true;
    }

    public final boolean h() {
        return this.f14220c;
    }
}
