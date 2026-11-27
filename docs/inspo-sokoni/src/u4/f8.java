package u4;

/* JADX INFO: loaded from: classes.dex */
public final class f8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16189b;

    public f8(o7 o7Var, me meVar) {
        this.f16188a = meVar;
        this.f16189b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16189b.f16621a.I0();
        this.f16189b.f16621a.r0(this.f16188a);
    }
}
