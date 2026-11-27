package gd;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<?> f9152a;

    public d1(Future<?> future) {
        this.f9152a = future;
    }

    @Override // gd.e1
    public void d() {
        this.f9152a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f9152a + ']';
    }
}
