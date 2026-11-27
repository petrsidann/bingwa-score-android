package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0<ReqT, RespT> extends f1<ReqT, RespT> {
    @Override // vb.f1, vb.g
    public /* bridge */ /* synthetic */ void a(String str, Throwable th) {
        super.a(str, th);
    }

    @Override // vb.f1, vb.g
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // vb.f1, vb.g
    public /* bridge */ /* synthetic */ void c(int i10) {
        super.c(i10);
    }

    @Override // vb.g
    public void d(ReqT reqt) {
        f().d(reqt);
    }

    @Override // vb.g
    public void e(g.a<RespT> aVar, a1 a1Var) {
        f().e(aVar, a1Var);
    }

    @Override // vb.f1
    public abstract g<ReqT, RespT> f();

    @Override // vb.f1
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
