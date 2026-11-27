package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ie implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ se f16370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ge f16371b;

    public ie(ge geVar, se seVar) {
        this.f16370a = seVar;
        this.f16371b = geVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ge.K(this.f16371b, this.f16370a);
        this.f16371b.M0();
    }
}
