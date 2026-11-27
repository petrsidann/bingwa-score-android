package l8;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Semaphore f12562a = new Semaphore(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12563b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        runnable.run();
        this.f12562a.release();
    }

    public void b() {
        try {
            this.f12562a.acquire(this.f12563b);
            this.f12563b = 0;
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            b.a("Interrupted while waiting for background task", e10);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        this.f12563b++;
        p.f12581c.execute(new Runnable() { // from class: l8.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f12560a.c(runnable);
            }
        });
    }
}
