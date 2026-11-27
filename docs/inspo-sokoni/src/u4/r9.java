package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class r9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16758b;

    public r9(e9 e9Var, AtomicReference atomicReference) {
        this.f16757a = atomicReference;
        this.f16758b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16757a) {
            try {
                this.f16757a.set(Boolean.valueOf(this.f16758b.a().K(this.f16758b.l().C())));
                this.f16757a.notify();
            } catch (Throwable th) {
                this.f16757a.notify();
                throw th;
            }
        }
    }
}
