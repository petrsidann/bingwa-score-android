package gd;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<?> f9232a;

    public l(Future<?> future) {
        this.f9232a = future;
    }

    @Override // gd.n
    public void g(Throwable th) {
        if (th != null) {
            this.f9232a.cancel(false);
        }
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        g(th);
        return lc.q.f12711a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f9232a + ']';
    }
}
