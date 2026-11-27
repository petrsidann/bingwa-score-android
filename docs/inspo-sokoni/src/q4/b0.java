package q4;

/* JADX INFO: loaded from: classes.dex */
public enum b0 implements a {
    RS256(-257),
    RS384(-258),
    RS512(-259),
    LEGACY_RS1(-262),
    PS256(-37),
    PS384(-38),
    PS512(-39),
    RS1(-65535);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14672a;

    b0(int i10) {
        this.f14672a = i10;
    }

    @Override // q4.a
    public int d() {
        return this.f14672a;
    }
}
