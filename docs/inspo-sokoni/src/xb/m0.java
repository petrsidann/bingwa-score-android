package xb;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 extends vb.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.w0 f18741a;

    public m0(vb.w0 w0Var) {
        this.f18741a = w0Var;
    }

    @Override // vb.d
    public String b() {
        return this.f18741a.b();
    }

    @Override // vb.d
    public <RequestT, ResponseT> vb.g<RequestT, ResponseT> f(vb.b1<RequestT, ResponseT> b1Var, vb.c cVar) {
        return this.f18741a.f(b1Var, cVar);
    }

    @Override // vb.w0
    public boolean i(long j10, TimeUnit timeUnit) {
        return this.f18741a.i(j10, timeUnit);
    }

    @Override // vb.w0
    public void j() {
        this.f18741a.j();
    }

    @Override // vb.w0
    public vb.q k(boolean z10) {
        return this.f18741a.k(z10);
    }

    @Override // vb.w0
    public void l(vb.q qVar, Runnable runnable) {
        this.f18741a.l(qVar, runnable);
    }

    @Override // vb.w0
    public vb.w0 m() {
        return this.f18741a.m();
    }

    @Override // vb.w0
    public vb.w0 n() {
        return this.f18741a.n();
    }

    public String toString() {
        return j6.g.b(this).d("delegate", this.f18741a).toString();
    }
}
