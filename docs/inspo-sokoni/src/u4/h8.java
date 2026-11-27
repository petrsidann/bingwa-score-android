package u4;

/* JADX INFO: loaded from: classes.dex */
public final class h8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f16306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f16307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16308c;

    public h8(o7 o7Var, n0 n0Var, me meVar) {
        this.f16306a = n0Var;
        this.f16307b = meVar;
        this.f16308c = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16308c.t1(this.f16308c.p1(this.f16306a, this.f16307b), this.f16307b);
    }
}
