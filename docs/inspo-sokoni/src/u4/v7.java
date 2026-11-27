package u4;

/* JADX INFO: loaded from: classes.dex */
public final class v7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16901b;

    public v7(o7 o7Var, me meVar) {
        this.f16900a = meVar;
        this.f16901b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16901b.f16621a.I0();
        this.f16901b.f16621a.o0(this.f16900a);
    }
}
