package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc.l<Throwable, lc.q> f9265a;

    /* JADX WARN: Multi-variable type inference failed */
    public v1(xc.l<? super Throwable, lc.q> lVar) {
        this.f9265a = lVar;
    }

    @Override // gd.n
    public void g(Throwable th) {
        this.f9265a.invoke(th);
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        g(th);
        return lc.q.f12711a;
    }

    public String toString() {
        return "InvokeOnCancel[" + q0.a(this.f9265a) + '@' + q0.b(this) + ']';
    }
}
