package k8;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k8.u0;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<ReqT, RespT, CallbackT extends u0> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f11655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f11656o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f11657p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f11658q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f11659r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l8.g.b f11660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l8.g.b f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.b1<ReqT, RespT> f11663d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l8.g f11665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l8.g.d f11666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l8.g.d f11667h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vb.g<ReqT, RespT> f11670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l8.r f11671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CallbackT f11672m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t0 f11668i = t0.Initial;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11669j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c<ReqT, RespT, CallbackT>.b f11664e = new b();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11673a;

        public a(long j10) {
            this.f11673a = j10;
        }

        public void a(Runnable runnable) {
            c.this.f11665f.x();
            if (c.this.f11669j == this.f11673a) {
                runnable.run();
            } else {
                l8.v.a(c.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j();
        }
    }

    /* JADX INFO: renamed from: k8.c$c, reason: collision with other inner class name */
    public class C0201c implements j0<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c<ReqT, RespT, CallbackT>.a f11676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11677b = 0;

        public C0201c(c<ReqT, RespT, CallbackT>.a aVar) {
            this.f11676a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(l1 l1Var) {
            if (l1Var.o()) {
                l8.v.a(c.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(c.this)));
            } else {
                l8.v.e(c.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(c.this)), l1Var);
            }
            c.this.k(l1Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(vb.a1 a1Var) {
            if (l8.v.c()) {
                HashMap map = new HashMap();
                for (String str : a1Var.j()) {
                    if (q.f11773d.contains(str.toLowerCase(Locale.ENGLISH))) {
                        map.put(str, (String) a1Var.g(vb.a1.g.e(str, vb.a1.f17241e)));
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                l8.v.a(c.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(c.this)), map);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(int i10, Object obj) {
            if (l8.v.c()) {
                l8.v.a(c.this.getClass().getSimpleName(), "(%x) Stream received (%s): %s", Integer.valueOf(System.identityHashCode(c.this)), Integer.valueOf(i10), obj);
            }
            if (i10 == 1) {
                c.this.r(obj);
            } else {
                c.this.s(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            l8.v.a(c.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(c.this)));
            c.this.t();
        }

        @Override // k8.j0
        public void a() {
            this.f11676a.a(new Runnable() { // from class: k8.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11681a.l();
                }
            });
        }

        @Override // k8.j0
        public void b(final l1 l1Var) {
            this.f11676a.a(new Runnable() { // from class: k8.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11684a.i(l1Var);
                }
            });
        }

        @Override // k8.j0
        public void c(final vb.a1 a1Var) {
            this.f11676a.a(new Runnable() { // from class: k8.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11693a.j(a1Var);
                }
            });
        }

        @Override // k8.j0
        public void d(final RespT respt) {
            final int i10 = this.f11677b + 1;
            this.f11676a.a(new Runnable() { // from class: k8.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11688a.k(i10, respt);
                }
            });
            this.f11677b = i10;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f11655n = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        f11656o = timeUnit2.toMillis(1L);
        f11657p = timeUnit2.toMillis(1L);
        f11658q = timeUnit.toMillis(10L);
        f11659r = timeUnit.toMillis(10L);
    }

    public c(y yVar, vb.b1<ReqT, RespT> b1Var, l8.g gVar, l8.g.d dVar, l8.g.d dVar2, l8.g.d dVar3, CallbackT callbackt) {
        this.f11662c = yVar;
        this.f11663d = b1Var;
        this.f11665f = gVar;
        this.f11666g = dVar2;
        this.f11667h = dVar3;
        this.f11672m = callbackt;
        this.f11671l = new l8.r(gVar, dVar, f11655n, 1.5d, f11656o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (m()) {
            this.f11668i = t0.Healthy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        t0 t0Var = this.f11668i;
        l8.b.d(t0Var == t0.Backoff, "State should still be backoff but was %s", t0Var);
        this.f11668i = t0.Initial;
        v();
        l8.b.d(n(), "Stream should have started", new Object[0]);
    }

    public final void g() {
        l8.g.b bVar = this.f11660a;
        if (bVar != null) {
            bVar.c();
            this.f11660a = null;
        }
    }

    public final void h() {
        l8.g.b bVar = this.f11661b;
        if (bVar != null) {
            bVar.c();
            this.f11661b = null;
        }
    }

    public final void i(t0 t0Var, l1 l1Var) {
        l8.b.d(n(), "Only started streams should be closed.", new Object[0]);
        t0 t0Var2 = t0.Error;
        l8.b.d(t0Var == t0Var2 || l1Var.o(), "Can't provide an error when not in an error state.", new Object[0]);
        this.f11665f.x();
        if (q.g(l1Var)) {
            l8.g0.q(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", l1Var.l()));
        }
        h();
        g();
        this.f11671l.c();
        this.f11669j++;
        l1.b bVarM = l1Var.m();
        if (bVarM == l1.b.OK) {
            this.f11671l.f();
        } else if (bVarM == l1.b.RESOURCE_EXHAUSTED) {
            l8.v.a(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.f11671l.g();
        } else if (bVarM == l1.b.UNAUTHENTICATED && this.f11668i != t0.Healthy) {
            this.f11662c.h();
        } else if (bVarM == l1.b.UNAVAILABLE && ((l1Var.l() instanceof UnknownHostException) || (l1Var.l() instanceof ConnectException))) {
            this.f11671l.h(f11659r);
        }
        if (t0Var != t0Var2) {
            l8.v.a(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            x();
        }
        if (this.f11670k != null) {
            if (l1Var.o()) {
                l8.v.a(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f11670k.b();
            }
            this.f11670k = null;
        }
        this.f11668i = t0Var;
        this.f11672m.b(l1Var);
    }

    public final void j() {
        if (m()) {
            i(t0.Initial, l1.f17405e);
        }
    }

    public void k(l1 l1Var) {
        l8.b.d(n(), "Can't handle server close on non-started stream!", new Object[0]);
        i(t0.Error, l1Var);
    }

    public void l() {
        l8.b.d(!n(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f11665f.x();
        this.f11668i = t0.Initial;
        this.f11671l.f();
    }

    public boolean m() {
        this.f11665f.x();
        t0 t0Var = this.f11668i;
        return t0Var == t0.Open || t0Var == t0.Healthy;
    }

    public boolean n() {
        this.f11665f.x();
        t0 t0Var = this.f11668i;
        return t0Var == t0.Starting || t0Var == t0.Backoff || m();
    }

    public void q() {
        if (m() && this.f11661b == null) {
            this.f11661b = this.f11665f.k(this.f11666g, f11657p, this.f11664e);
        }
    }

    public abstract void r(RespT respt);

    public abstract void s(RespT respt);

    public final void t() {
        this.f11668i = t0.Open;
        this.f11672m.a();
        if (this.f11660a == null) {
            this.f11660a = this.f11665f.k(this.f11667h, f11658q, new Runnable() { // from class: k8.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11648a.o();
                }
            });
        }
    }

    public final void u() {
        l8.b.d(this.f11668i == t0.Error, "Should only perform backoff in an error state", new Object[0]);
        this.f11668i = t0.Backoff;
        this.f11671l.b(new Runnable() { // from class: k8.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f11644a.p();
            }
        });
    }

    public void v() {
        this.f11665f.x();
        l8.b.d(this.f11670k == null, "Last call still set", new Object[0]);
        l8.b.d(this.f11661b == null, "Idle timer still set", new Object[0]);
        t0 t0Var = this.f11668i;
        if (t0Var == t0.Error) {
            u();
            return;
        }
        l8.b.d(t0Var == t0.Initial, "Already started", new Object[0]);
        this.f11670k = this.f11662c.m(this.f11663d, new C0201c(new a(this.f11669j)));
        this.f11668i = t0.Starting;
    }

    public void w() {
        if (n()) {
            i(t0.Initial, l1.f17405e);
        }
    }

    public void x() {
    }

    public void y(ReqT reqt) {
        this.f11665f.x();
        l8.v.a(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        h();
        this.f11670k.d(reqt);
    }
}
