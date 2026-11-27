package b8;

/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f2907a;

    public h1(o0 o0Var) {
        this.f2907a = o0Var;
    }

    public void c() {
        this.f2907a.g(new o0.a() { // from class: b8.e1
            @Override // o0.a
            public final void accept(Object obj) {
                ((e8.q0) obj).B();
            }
        });
    }

    public void d() {
        this.f2907a.g(new o0.a() { // from class: b8.f1
            @Override // o0.a
            public final void accept(Object obj) {
                ((e8.q0) obj).m0(false);
            }
        });
    }

    public void e() {
        this.f2907a.g(new o0.a() { // from class: b8.g1
            @Override // o0.a
            public final void accept(Object obj) {
                ((e8.q0) obj).m0(true);
            }
        });
    }
}
