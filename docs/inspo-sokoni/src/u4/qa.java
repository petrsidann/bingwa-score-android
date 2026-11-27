package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16736b;

    public qa(e9 e9Var, AtomicReference atomicReference) {
        this.f16735a = atomicReference;
        this.f16736b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16735a) {
            try {
                this.f16735a.set(Integer.valueOf(this.f16736b.a().u(this.f16736b.l().C(), p0.Y)));
                this.f16735a.notify();
            } catch (Throwable th) {
                this.f16735a.notify();
                throw th;
            }
        }
    }
}
