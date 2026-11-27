package u4;

/* JADX INFO: loaded from: classes.dex */
public final class t7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16831b;

    public t7(o7 o7Var, me meVar) {
        this.f16830a = meVar;
        this.f16831b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16831b.f16621a.I0();
        ge geVar = this.f16831b.f16621a;
        me meVar = this.f16830a;
        geVar.zzl().j();
        geVar.J0();
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        geVar.j(meVar);
    }
}
