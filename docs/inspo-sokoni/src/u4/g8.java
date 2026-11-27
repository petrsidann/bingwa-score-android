package u4;

/* JADX INFO: loaded from: classes.dex */
public final class g8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16215b;

    public g8(o7 o7Var, me meVar) {
        this.f16214a = meVar;
        this.f16215b = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16215b.f16621a.I0();
        ge geVar = this.f16215b.f16621a;
        me meVar = this.f16214a;
        geVar.zzl().j();
        geVar.J0();
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        geVar.w0(meVar);
        geVar.t0(meVar);
    }
}
