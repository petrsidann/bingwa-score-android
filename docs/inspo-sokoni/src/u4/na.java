package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16603b;

    public na(e9 e9Var, AtomicReference atomicReference) {
        this.f16602a = atomicReference;
        this.f16603b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16602a) {
            try {
                this.f16602a.set(Long.valueOf(this.f16603b.a().y(this.f16603b.l().C(), p0.X)));
                this.f16602a.notify();
            } catch (Throwable th) {
                this.f16602a.notify();
                throw th;
            }
        }
    }
}
