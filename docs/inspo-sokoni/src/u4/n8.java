package u4;

/* JADX INFO: loaded from: classes.dex */
public final class n8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ze f16596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f16597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16598c;

    public n8(o7 o7Var, ze zeVar, me meVar) {
        this.f16596a = zeVar;
        this.f16597b = meVar;
        this.f16598c = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16598c.f16621a.I0();
        if (this.f16596a.S() == null) {
            this.f16598c.f16621a.A(this.f16596a.f17015b, this.f16597b);
        } else {
            this.f16598c.f16621a.L(this.f16596a, this.f16597b);
        }
    }
}
