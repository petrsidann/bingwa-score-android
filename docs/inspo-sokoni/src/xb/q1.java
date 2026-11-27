package xb;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 extends vb.w0 implements vb.k0<Object> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Logger f18844k = Logger.getLogger(q1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y0 f18845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.l0 f18846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f18848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f18849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f18850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CountDownLatch f18851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f18852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f18853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q.e f18854j;

    @Override // vb.d
    public String b() {
        return this.f18847c;
    }

    @Override // vb.d
    public <RequestT, ResponseT> vb.g<RequestT, ResponseT> f(vb.b1<RequestT, ResponseT> b1Var, vb.c cVar) {
        return new q(b1Var, cVar.e() == null ? this.f18849e : cVar.e(), cVar, this.f18854j, this.f18850f, this.f18853i, null);
    }

    @Override // vb.r0
    public vb.l0 g() {
        return this.f18846b;
    }

    @Override // vb.w0
    public boolean i(long j10, TimeUnit timeUnit) {
        return this.f18851g.await(j10, timeUnit);
    }

    @Override // vb.w0
    public vb.q k(boolean z10) {
        y0 y0Var = this.f18845a;
        return y0Var == null ? vb.q.IDLE : y0Var.N();
    }

    @Override // vb.w0
    public vb.w0 m() {
        this.f18852h = true;
        this.f18848d.c(vb.l1.f17420t.q("OobChannel.shutdown() called"));
        return this;
    }

    @Override // vb.w0
    public vb.w0 n() {
        this.f18852h = true;
        this.f18848d.d(vb.l1.f17420t.q("OobChannel.shutdownNow() called"));
        return this;
    }

    public y0 o() {
        return this.f18845a;
    }

    public String toString() {
        return j6.g.b(this).c("logId", this.f18846b.d()).d("authority", this.f18847c).toString();
    }
}
