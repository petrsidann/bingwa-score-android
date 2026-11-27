package u4;

/* JADX INFO: loaded from: classes.dex */
public final class a8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f15985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f15986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f15987c;

    public a8(o7 o7Var, h hVar, me meVar) {
        this.f15985a = hVar;
        this.f15986b = meVar;
        this.f15987c = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15987c.f16621a.I0();
        if (this.f15985a.f16267c.S() == null) {
            this.f15987c.f16621a.E(this.f15985a, this.f15986b);
        } else {
            this.f15987c.f16621a.d0(this.f15985a, this.f15986b);
        }
    }
}
