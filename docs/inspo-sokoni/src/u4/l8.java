package u4;

/* JADX INFO: loaded from: classes.dex */
public final class l8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f16483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16485c;

    public l8(o7 o7Var, n0 n0Var, String str) {
        this.f16483a = n0Var;
        this.f16484b = str;
        this.f16485c = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16485c.f16621a.I0();
        this.f16485c.f16621a.F(this.f16483a, this.f16484b);
    }
}
