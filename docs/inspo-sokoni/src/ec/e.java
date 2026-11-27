package ec;

import j6.m;
import vb.l1;
import vb.q;
import vb.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends ec.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final t0.j f7784p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t0 f7785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t0.e f7786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t0.c f7787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t0 f7788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public t0.c f7789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t0 f7790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q f7791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t0.j f7792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7793o;

    public class a extends t0 {
        public a() {
        }

        @Override // vb.t0
        public void c(l1 l1Var) {
            e.this.f7786h.f(q.TRANSIENT_FAILURE, new t0.d(t0.f.f(l1Var)));
        }

        @Override // vb.t0
        public void d(t0.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // vb.t0
        public void f() {
        }
    }

    public class b extends ec.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t0 f7795a;

        public b() {
        }

        @Override // ec.c, vb.t0.e
        public void f(q qVar, t0.j jVar) {
            if (this.f7795a == e.this.f7790l) {
                m.v(e.this.f7793o, "there's pending lb while current lb has been out of READY");
                e.this.f7791m = qVar;
                e.this.f7792n = jVar;
                if (qVar != q.READY) {
                    return;
                }
            } else {
                if (this.f7795a != e.this.f7788j) {
                    return;
                }
                e.this.f7793o = qVar == q.READY;
                if (e.this.f7793o || e.this.f7790l == e.this.f7785g) {
                    e.this.f7786h.f(qVar, jVar);
                    return;
                }
            }
            e.this.q();
        }

        @Override // ec.c
        public t0.e g() {
            return e.this.f7786h;
        }
    }

    public class c extends t0.j {
        @Override // vb.t0.j
        public t0.f a(t0.g gVar) {
            return t0.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(t0.e eVar) {
        a aVar = new a();
        this.f7785g = aVar;
        this.f7788j = aVar;
        this.f7790l = aVar;
        this.f7786h = (t0.e) m.p(eVar, "helper");
    }

    @Override // vb.t0
    public void f() {
        this.f7790l.f();
        this.f7788j.f();
    }

    @Override // ec.b
    public t0 g() {
        t0 t0Var = this.f7790l;
        return t0Var == this.f7785g ? this.f7788j : t0Var;
    }

    public final void q() {
        this.f7786h.f(this.f7791m, this.f7792n);
        this.f7788j.f();
        this.f7788j = this.f7790l;
        this.f7787i = this.f7789k;
        this.f7790l = this.f7785g;
        this.f7789k = null;
    }

    public void r(t0.c cVar) {
        m.p(cVar, "newBalancerFactory");
        if (cVar.equals(this.f7789k)) {
            return;
        }
        this.f7790l.f();
        this.f7790l = this.f7785g;
        this.f7789k = null;
        this.f7791m = q.CONNECTING;
        this.f7792n = f7784p;
        if (cVar.equals(this.f7787i)) {
            return;
        }
        b bVar = new b();
        t0 t0VarA = cVar.a(bVar);
        bVar.f7795a = t0VarA;
        this.f7790l = t0VarA;
        this.f7789k = cVar;
        if (this.f7793o) {
            return;
        }
        q();
    }
}
