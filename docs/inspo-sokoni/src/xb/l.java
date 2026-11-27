package xb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements e2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f18680f = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.p1 f18682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.a f18683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f18684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vb.p1.d f18685e;

    public l(j.a aVar, ScheduledExecutorService scheduledExecutorService, vb.p1 p1Var) {
        this.f18683c = aVar;
        this.f18681a = scheduledExecutorService;
        this.f18682b = p1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        vb.p1.d dVar = this.f18685e;
        if (dVar != null && dVar.b()) {
            this.f18685e.a();
        }
        this.f18684d = null;
    }

    @Override // xb.e2
    public void a(Runnable runnable) {
        this.f18682b.f();
        if (this.f18684d == null) {
            this.f18684d = this.f18683c.get();
        }
        vb.p1.d dVar = this.f18685e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f18684d.a();
            this.f18685e = this.f18682b.c(runnable, jA, TimeUnit.NANOSECONDS, this.f18681a);
            f18680f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    @Override // xb.e2
    public void reset() {
        this.f18682b.f();
        this.f18682b.execute(new Runnable() { // from class: xb.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f18675a.c();
            }
        });
    }
}
