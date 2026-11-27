package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.s f19041a;

    public y(vb.s sVar) {
        this.f19041a = sVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        vb.s sVarB = this.f19041a.b();
        try {
            a();
        } finally {
            this.f19041a.f(sVarB);
        }
    }
}
