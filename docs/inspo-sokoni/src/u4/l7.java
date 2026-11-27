package u4;

/* JADX INFO: loaded from: classes.dex */
public final class l7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b9 f16481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k7 f16482b;

    public l7(k7 k7Var, b9 b9Var) {
        this.f16481a = b9Var;
        this.f16482b = k7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k7.f(this.f16482b, this.f16481a);
        this.f16482b.b(this.f16481a.f16029g);
    }
}
