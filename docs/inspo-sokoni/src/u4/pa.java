package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class pa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16705b;

    public pa(e9 e9Var, AtomicReference atomicReference) {
        this.f16704a = atomicReference;
        this.f16705b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16704a) {
            try {
                this.f16704a.set(Double.valueOf(this.f16705b.a().k(this.f16705b.l().C(), p0.Z)));
                this.f16704a.notify();
            } catch (Throwable th) {
                this.f16704a.notify();
                throw th;
            }
        }
    }
}
