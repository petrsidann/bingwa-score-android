package u4;

/* JADX INFO: loaded from: classes.dex */
public final class sa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f16803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16804b;

    public sa(e9 e9Var, Boolean bool) {
        this.f16803a = bool;
        this.f16804b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16804b.M(this.f16803a, true);
    }
}
