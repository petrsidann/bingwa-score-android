package xb;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f18179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j6.p f18180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture<?> f18183g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b2.this.f18182f) {
                b2.this.f18183g = null;
                return;
            }
            long j10 = b2.this.j();
            if (b2.this.f18181e - j10 > 0) {
                b2 b2Var = b2.this;
                b2Var.f18183g = b2Var.f18177a.schedule(new c(), b2.this.f18181e - j10, TimeUnit.NANOSECONDS);
            } else {
                b2.this.f18182f = false;
                b2.this.f18183g = null;
                b2.this.f18179c.run();
            }
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b2.this.f18178b.execute(new b());
        }
    }

    public b2(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, j6.p pVar) {
        this.f18179c = runnable;
        this.f18178b = executor;
        this.f18177a = scheduledExecutorService;
        this.f18180d = pVar;
        pVar.g();
    }

    public void i(boolean z10) {
        ScheduledFuture<?> scheduledFuture;
        this.f18182f = false;
        if (!z10 || (scheduledFuture = this.f18183g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f18183g = null;
    }

    public final long j() {
        return this.f18180d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long j11 = j() + nanos;
        this.f18182f = true;
        if (j11 - this.f18181e < 0 || this.f18183g == null) {
            ScheduledFuture<?> scheduledFuture = this.f18183g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f18183g = this.f18177a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f18181e = j11;
    }
}
