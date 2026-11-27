package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16114b;

    public da(e9 e9Var, AtomicReference atomicReference) {
        this.f16113a = atomicReference;
        this.f16114b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16113a) {
            try {
                this.f16113a.set(this.f16114b.a().E(this.f16114b.l().C()));
                this.f16113a.notify();
            } catch (Throwable th) {
                this.f16113a.notify();
                throw th;
            }
        }
    }
}
