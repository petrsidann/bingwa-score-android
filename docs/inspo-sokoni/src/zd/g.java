package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum g implements p {
    Resource("Resource"),
    Asset("Asset"),
    File("File"),
    Network("Network"),
    Unknown("Unknown");


    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static g[] f20572l = (g[]) g.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20574a;

    g(String str) {
        this.f20574a = str;
    }

    @Override // zd.p
    public String h() {
        return this.f20574a;
    }
}
