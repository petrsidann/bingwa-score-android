package u4;

/* JADX INFO: loaded from: classes.dex */
public final class z7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f16996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16997b;

    public z7(o7 o7Var, h hVar) {
        this.f16996a = hVar;
        this.f16997b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16997b.f16621a.I0();
        if (this.f16996a.f16267c.S() == null) {
            this.f16997b.f16621a.D(this.f16996a);
        } else {
            this.f16997b.f16621a.c0(this.f16996a);
        }
    }
}
