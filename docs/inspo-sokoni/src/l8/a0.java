package l8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class a0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f12515b;

    public a0(int i10, Executor executor) {
        this.f12515b = new Semaphore(i10);
        this.f12514a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        runnable.run();
        this.f12515b.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (this.f12515b.tryAcquire()) {
            try {
                this.f12514a.execute(new Runnable() { // from class: l8.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12599a.b(runnable);
                    }
                });
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        runnable.run();
    }
}
