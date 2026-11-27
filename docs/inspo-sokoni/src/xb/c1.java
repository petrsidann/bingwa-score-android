package xb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f18242l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f18243m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j6.p f18245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f18246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f18248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture<?> f18249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture<?> f18250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f18251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f18252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18254k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (c1.this) {
                e eVar = c1.this.f18248e;
                e eVar2 = e.DISCONNECTED;
                if (eVar != eVar2) {
                    c1.this.f18248e = eVar2;
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                c1.this.f18246c.a();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (c1.this) {
                c1.this.f18250g = null;
                e eVar = c1.this.f18248e;
                e eVar2 = e.PING_SCHEDULED;
                if (eVar == eVar2) {
                    c1.this.f18248e = e.PING_SENT;
                    c1 c1Var = c1.this;
                    c1Var.f18249f = c1Var.f18244a.schedule(c1.this.f18251h, c1.this.f18254k, TimeUnit.NANOSECONDS);
                    z10 = true;
                } else {
                    if (c1.this.f18248e == e.PING_DELAYED) {
                        c1 c1Var2 = c1.this;
                        ScheduledExecutorService scheduledExecutorService = c1Var2.f18244a;
                        Runnable runnable = c1.this.f18252i;
                        long j10 = c1.this.f18253j;
                        j6.p pVar = c1.this.f18245b;
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        c1Var2.f18250g = scheduledExecutorService.schedule(runnable, j10 - pVar.d(timeUnit), timeUnit);
                        c1.this.f18248e = eVar2;
                    }
                    z10 = false;
                }
            }
            if (z10) {
                c1.this.f18246c.b();
            }
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f18257a;

        public class a implements t.a {
            public a() {
            }

            @Override // xb.t.a
            public void a(Throwable th) {
                c.this.f18257a.d(vb.l1.f17420t.q("Keepalive failed. The connection is likely gone"));
            }

            @Override // xb.t.a
            public void b(long j10) {
            }
        }

        public c(w wVar) {
            this.f18257a = wVar;
        }

        @Override // xb.c1.d
        public void a() {
            this.f18257a.d(vb.l1.f17420t.q("Keepalive failed. The connection is likely gone"));
        }

        @Override // xb.c1.d
        public void b() {
            this.f18257a.e(new a(), p6.f.a());
        }
    }

    public interface d {
        void a();

        void b();
    }

    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public c1(d dVar, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(dVar, scheduledExecutorService, j6.p.c(), j10, j11, z10);
    }

    public c1(d dVar, ScheduledExecutorService scheduledExecutorService, j6.p pVar, long j10, long j11, boolean z10) {
        this.f18248e = e.IDLE;
        this.f18251h = new d1(new a());
        this.f18252i = new d1(new b());
        this.f18246c = (d) j6.m.p(dVar, "keepAlivePinger");
        this.f18244a = (ScheduledExecutorService) j6.m.p(scheduledExecutorService, "scheduler");
        this.f18245b = (j6.p) j6.m.p(pVar, "stopwatch");
        this.f18253j = j10;
        this.f18254k = j11;
        this.f18247d = z10;
        pVar.f().g();
    }

    public static long l(long j10) {
        return Math.max(j10, f18242l);
    }

    public synchronized void m() {
        this.f18245b.f().g();
        e eVar = this.f18248e;
        e eVar2 = e.PING_SCHEDULED;
        if (eVar == eVar2) {
            this.f18248e = e.PING_DELAYED;
        } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
            ScheduledFuture<?> scheduledFuture = this.f18249f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (this.f18248e == e.IDLE_AND_PING_SENT) {
                this.f18248e = e.IDLE;
            } else {
                this.f18248e = eVar2;
                j6.m.v(this.f18250g == null, "There should be no outstanding pingFuture");
                this.f18250g = this.f18244a.schedule(this.f18252i, this.f18253j, TimeUnit.NANOSECONDS);
            }
        }
    }

    public synchronized void n() {
        e eVar = this.f18248e;
        if (eVar == e.IDLE) {
            this.f18248e = e.PING_SCHEDULED;
            if (this.f18250g == null) {
                ScheduledExecutorService scheduledExecutorService = this.f18244a;
                Runnable runnable = this.f18252i;
                long j10 = this.f18253j;
                j6.p pVar = this.f18245b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f18250g = scheduledExecutorService.schedule(runnable, j10 - pVar.d(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f18248e = e.PING_SENT;
        }
    }

    public synchronized void o() {
        if (this.f18247d) {
            return;
        }
        e eVar = this.f18248e;
        if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
            this.f18248e = e.IDLE;
        }
        if (this.f18248e == e.PING_SENT) {
            this.f18248e = e.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void p() {
        if (this.f18247d) {
            n();
        }
    }

    public synchronized void q() {
        e eVar = this.f18248e;
        e eVar2 = e.DISCONNECTED;
        if (eVar != eVar2) {
            this.f18248e = eVar2;
            ScheduledFuture<?> scheduledFuture = this.f18249f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture<?> scheduledFuture2 = this.f18250g;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.f18250g = null;
            }
        }
    }
}
