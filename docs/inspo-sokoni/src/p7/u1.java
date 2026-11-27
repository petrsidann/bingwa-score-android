package p7;

/* JADX INFO: loaded from: classes.dex */
public final class u1 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14324c;

    @Override // p7.q1
    public final q1 a(String str) {
        this.f14323b = str;
        return this;
    }

    @Override // p7.q1
    public final r1 b() {
        return new v1(this.f14322a, this.f14323b, this.f14324c);
    }

    @Override // p7.q1
    public final q1 c(String str) {
        this.f14324c = str;
        return this;
    }

    @Override // p7.q1
    public final q1 d(String str) {
        this.f14322a = str;
        return this;
    }
}
