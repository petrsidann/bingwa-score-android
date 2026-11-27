package q4;

/* JADX INFO: loaded from: classes.dex */
public enum p implements a {
    ED256(-260),
    ED512(-261),
    ED25519(-8),
    ES256(-7),
    ECDH_HKDF_256(-25),
    ES384(-35),
    ES512(-36);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14755a;

    p(int i10) {
        this.f14755a = i10;
    }

    @Override // q4.a
    public int d() {
        return this.f14755a;
    }
}
