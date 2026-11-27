package k8;

/* JADX INFO: loaded from: classes.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f11741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o0 f11742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f11743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f11744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f11745e;

    public n a(e8.j.a aVar) {
        return new j(aVar.f7193a);
    }

    public q b(e8.j.a aVar) {
        return new q(aVar.f7194b, j(), h());
    }

    public y c(e8.j.a aVar) {
        return new y(aVar.f7194b, aVar.f7198f, aVar.f7199g, aVar.f7195c.a(), aVar.f7200h, i());
    }

    public h0 d(e8.j.a aVar) {
        return new h0(aVar.f7194b, aVar.f7193a, aVar.f7195c, new u(aVar.f7198f, aVar.f7199g));
    }

    public o0 e(e8.j.a aVar) {
        return new o0(aVar.f7195c.a());
    }

    public n f() {
        return (n) l8.b.e(this.f11745e, "connectivityMonitor not initialized yet", new Object[0]);
    }

    public q g() {
        return (q) l8.b.e(this.f11744d, "datastore not initialized yet", new Object[0]);
    }

    public y h() {
        return (y) l8.b.e(this.f11743c, "firestoreChannel not initialized yet", new Object[0]);
    }

    public h0 i() {
        return (h0) l8.b.e(this.f11741a, "grpcCallProvider not initialized yet", new Object[0]);
    }

    public o0 j() {
        return (o0) l8.b.e(this.f11742b, "remoteSerializer not initialized yet", new Object[0]);
    }

    public void k(e8.j.a aVar) {
        this.f11742b = e(aVar);
        this.f11741a = d(aVar);
        this.f11743c = c(aVar);
        this.f11744d = b(aVar);
        this.f11745e = a(aVar);
    }
}
