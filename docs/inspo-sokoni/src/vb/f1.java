package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f1<ReqT, RespT> extends g<ReqT, RespT> {
    @Override // vb.g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // vb.g
    public void b() {
        f().b();
    }

    @Override // vb.g
    public void c(int i10) {
        f().c(i10);
    }

    public abstract g<?, ?> f();

    public String toString() {
        return j6.g.b(this).d("delegate", f()).toString();
    }
}
