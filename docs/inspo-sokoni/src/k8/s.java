package k8;

/* JADX INFO: loaded from: classes.dex */
public class s implements i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vb.a1.g<String> f11788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vb.a1.g<String> f11789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vb.a1.g<String> f11790f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.b<m8.j> f11791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.b<z8.i> f11792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h7.n f11793c;

    static {
        vb.a1.d<String> dVar = vb.a1.f17241e;
        f11788d = vb.a1.g.e("x-firebase-client-log-type", dVar);
        f11789e = vb.a1.g.e("x-firebase-client", dVar);
        f11790f = vb.a1.g.e("x-firebase-gmpid", dVar);
    }

    public s(o8.b<z8.i> bVar, o8.b<m8.j> bVar2, h7.n nVar) {
        this.f11792b = bVar;
        this.f11791a = bVar2;
        this.f11793c = nVar;
    }

    @Override // k8.i0
    public void a(vb.a1 a1Var) {
        if (this.f11791a.get() == null || this.f11792b.get() == null) {
            return;
        }
        int iH = this.f11791a.get().b("fire-fst").h();
        if (iH != 0) {
            a1Var.p(f11788d, Integer.toString(iH));
        }
        a1Var.p(f11789e, this.f11792b.get().a());
        b(a1Var);
    }

    public final void b(vb.a1 a1Var) {
        h7.n nVar = this.f11793c;
        if (nVar == null) {
            return;
        }
        String strC = nVar.c();
        if (strC.length() != 0) {
            a1Var.p(f11790f, strC);
        }
    }
}
