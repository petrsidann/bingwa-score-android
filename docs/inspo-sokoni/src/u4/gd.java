package u4;

/* JADX INFO: loaded from: classes.dex */
public final class gd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge f16226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f16227b;

    public gd(cd cdVar, ge geVar, Runnable runnable) {
        this.f16226a = geVar;
        this.f16227b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16226a.I0();
        this.f16226a.r(this.f16227b);
        this.f16226a.N0();
    }
}
