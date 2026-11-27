package u4;

/* JADX INFO: loaded from: classes.dex */
public final class y7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16973b;

    public y7(o7 o7Var, me meVar) {
        this.f16972a = meVar;
        this.f16973b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16973b.f16621a.I0();
        this.f16973b.f16621a.m0(this.f16972a);
    }
}
