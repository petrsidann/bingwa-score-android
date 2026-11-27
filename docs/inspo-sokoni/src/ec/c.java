package ec;

import java.util.concurrent.ScheduledExecutorService;
import vb.p1;
import vb.q;
import vb.t0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends t0.e {
    @Override // vb.t0.e
    public t0.i a(t0.b bVar) {
        return g().a(bVar);
    }

    @Override // vb.t0.e
    public vb.f b() {
        return g().b();
    }

    @Override // vb.t0.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // vb.t0.e
    public p1 d() {
        return g().d();
    }

    @Override // vb.t0.e
    public void e() {
        g().e();
    }

    @Override // vb.t0.e
    public void f(q qVar, t0.j jVar) {
        g().f(qVar, jVar);
    }

    public abstract t0.e g();

    public String toString() {
        return j6.g.b(this).d("delegate", g()).toString();
    }
}
