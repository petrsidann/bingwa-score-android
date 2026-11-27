package xb;

import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 extends vb.w0 implements vb.k0<Object> {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final Logger f18467m0 = Logger.getLogger(g1.class.getName());

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Pattern f18468n0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final vb.l1 f18469o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final vb.l1 f18470p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final vb.l1 f18471q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final j1 f18472r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final vb.h0 f18473s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final vb.g<Object, Object> f18474t0;
    public final List<vb.l> A;
    public final String B;
    public vb.c1 C;
    public boolean D;
    public s E;
    public volatile vb.t0.j F;
    public boolean G;
    public final Set<y0> H;
    public Collection<u.g<?, ?>> I;
    public final Object J;
    public final Set<q1> K;
    public final b0 L;
    public final y M;
    public final AtomicBoolean N;
    public boolean O;
    public boolean P;
    public volatile boolean Q;
    public final CountDownLatch R;
    public final xb.n.b S;
    public final xb.n T;
    public final xb.p U;
    public final vb.f V;
    public final vb.f0 W;
    public final u X;
    public v Y;
    public j1 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.l0 f18475a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final j1 f18476a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18477b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f18478b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18479c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f18480c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.e1 f18481d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final c2.t f18482d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vb.c1.b f18483e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f18484e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xb.i f18485f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final long f18486f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xb.u f18487g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final boolean f18488g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final xb.u f18489h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final vb.u.c f18490h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final xb.u f18491i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final k1.a f18492i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f18493j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final w0<Object> f18494j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Executor f18495k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final m f18496k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p1<? extends Executor> f18497l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final b2 f18498l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p1<? extends Executor> f18499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f18500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f18501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r2 f18502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f18503q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final vb.p1 f18504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f18505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final vb.w f18506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final vb.p f18507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j6.r<j6.p> f18508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f18509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final xb.x f18510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final xb.j.a f18511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final vb.d f18512z;

    public class a extends vb.h0 {
        @Override // vb.h0
        public vb.h0.b a(vb.t0.g gVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.x0(true);
        }
    }

    public final class c implements xb.n.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r2 f18514a;

        public c(r2 r2Var) {
            this.f18514a = r2Var;
        }

        @Override // xb.n.b
        public xb.n a() {
            return new xb.n(this.f18514a);
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.q f18517b;

        public d(Runnable runnable, vb.q qVar) {
            this.f18516a = runnable;
            this.f18517b = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.f18510x.c(this.f18516a, g1.this.f18495k, this.f18517b);
        }
    }

    public final class e extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.f f18519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f18520b;

        public e(Throwable th) {
            this.f18520b = th;
            this.f18519a = vb.t0.f.e(vb.l1.f17419s.q("Panic! This is a bug!").p(th));
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            return this.f18519a;
        }

        public String toString() {
            return j6.g.a(e.class).d("panicPickResult", this.f18519a).toString();
        }
    }

    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.N.get() || g1.this.E == null) {
                return;
            }
            g1.this.x0(false);
            g1.this.y0();
        }
    }

    public final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.z0();
            if (g1.this.F != null) {
                g1.this.F.b();
            }
            if (g1.this.E != null) {
                g1.this.E.f18546a.c();
            }
        }
    }

    public final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.V.a(vb.f.a.INFO, "Entering SHUTDOWN state");
            g1.this.f18510x.b(vb.q.SHUTDOWN);
        }
    }

    public final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.O) {
                return;
            }
            g1.this.O = true;
            g1.this.D0();
        }
    }

    public class j implements Thread.UncaughtExceptionHandler {
        public j() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            g1.f18467m0.log(Level.SEVERE, "[" + g1.this.g() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            g1.this.F0(th);
        }
    }

    public class k extends n0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18527b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(vb.c1 c1Var, String str) {
            super(c1Var);
            this.f18527b = str;
        }

        @Override // xb.n0, vb.c1
        public String a() {
            return this.f18527b;
        }
    }

    public class l extends vb.g<Object, Object> {
        @Override // vb.g
        public void a(String str, Throwable th) {
        }

        @Override // vb.g
        public void b() {
        }

        @Override // vb.g
        public void c(int i10) {
        }

        @Override // vb.g
        public void d(Object obj) {
        }

        @Override // vb.g
        public void e(vb.g.a<Object> aVar, vb.a1 a1Var) {
        }
    }

    public final class m implements xb.q.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile c2.d0 f18528a;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.z0();
            }
        }

        public final class b<ReqT> extends c2<ReqT> {
            public final /* synthetic */ vb.b1 E;
            public final /* synthetic */ vb.a1 F;
            public final /* synthetic */ vb.c G;
            public final /* synthetic */ d2 H;
            public final /* synthetic */ t0 I;
            public final /* synthetic */ vb.s J;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(vb.b1 b1Var, vb.a1 a1Var, vb.c cVar, d2 d2Var, t0 t0Var, vb.s sVar) {
                super(b1Var, a1Var, g1.this.f18482d0, g1.this.f18484e0, g1.this.f18486f0, g1.this.A0(cVar), g1.this.f18489h.P(), d2Var, t0Var, m.this.f18528a);
                this.E = b1Var;
                this.F = a1Var;
                this.G = cVar;
                this.H = d2Var;
                this.I = t0Var;
                this.J = sVar;
            }

            @Override // xb.c2
            public xb.r i0(vb.a1 a1Var, vb.k.a aVar, int i10, boolean z10) {
                vb.c cVarR = this.G.r(aVar);
                vb.k[] kVarArrF = r0.f(cVarR, a1Var, i10, z10);
                xb.t tVarC = m.this.c(new w1(this.E, a1Var, cVarR));
                vb.s sVarB = this.J.b();
                try {
                    return tVarC.h(this.E, a1Var, cVarR, kVarArrF);
                } finally {
                    this.J.f(sVarB);
                }
            }

            @Override // xb.c2
            public void j0() {
                g1.this.M.d(this);
            }

            @Override // xb.c2
            public vb.l1 k0() {
                return g1.this.M.a(this);
            }
        }

        public m() {
        }

        public /* synthetic */ m(g1 g1Var, a aVar) {
            this();
        }

        @Override // xb.q.e
        public xb.r a(vb.b1<?, ?> b1Var, vb.c cVar, vb.a1 a1Var, vb.s sVar) {
            if (g1.this.f18488g0) {
                j1.b bVar = (j1.b) cVar.h(j1.b.f18661g);
                return new b(b1Var, a1Var, cVar, bVar == null ? null : bVar.f18666e, bVar != null ? bVar.f18667f : null, sVar);
            }
            xb.t tVarC = c(new w1(b1Var, a1Var, cVar));
            vb.s sVarB = sVar.b();
            try {
                return tVarC.h(b1Var, a1Var, cVar, r0.f(cVar, a1Var, 0, false));
            } finally {
                sVar.f(sVarB);
            }
        }

        public final xb.t c(vb.t0.g gVar) {
            vb.t0.j jVar = g1.this.F;
            if (!g1.this.N.get()) {
                if (jVar == null) {
                    g1.this.f18504r.execute(new a());
                } else {
                    xb.t tVarK = r0.k(jVar.a(gVar), gVar.a().j());
                    if (tVarK != null) {
                        return tVarK;
                    }
                }
            }
            return g1.this.L;
        }
    }

    public static final class n<ReqT, RespT> extends vb.b0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.h0 f18531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.d f18532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f18533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final vb.b1<ReqT, RespT> f18534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final vb.s f18535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public vb.c f18536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public vb.g<ReqT, RespT> f18537g;

        public class a extends xb.y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vb.g.a f18538b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18539c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(vb.g.a aVar, vb.l1 l1Var) {
                super(n.this.f18535e);
                this.f18538b = aVar;
                this.f18539c = l1Var;
            }

            @Override // xb.y
            public void a() {
                this.f18538b.a(this.f18539c, new vb.a1());
            }
        }

        public n(vb.h0 h0Var, vb.d dVar, Executor executor, vb.b1<ReqT, RespT> b1Var, vb.c cVar) {
            this.f18531a = h0Var;
            this.f18532b = dVar;
            this.f18534d = b1Var;
            executor = cVar.e() != null ? cVar.e() : executor;
            this.f18533c = executor;
            this.f18536f = cVar.n(executor);
            this.f18535e = vb.s.e();
        }

        @Override // vb.b0, vb.f1, vb.g
        public void a(String str, Throwable th) {
            vb.g<ReqT, RespT> gVar = this.f18537g;
            if (gVar != null) {
                gVar.a(str, th);
            }
        }

        @Override // vb.b0, vb.g
        public void e(vb.g.a<RespT> aVar, vb.a1 a1Var) {
            vb.h0.b bVarA = this.f18531a.a(new w1(this.f18534d, a1Var, this.f18536f));
            vb.l1 l1VarC = bVarA.c();
            if (!l1VarC.o()) {
                h(aVar, r0.o(l1VarC));
                this.f18537g = g1.f18474t0;
                return;
            }
            vb.h hVarB = bVarA.b();
            j1.b bVarF = ((j1) bVarA.a()).f(this.f18534d);
            if (bVarF != null) {
                this.f18536f = this.f18536f.q(j1.b.f18661g, bVarF);
            }
            this.f18537g = hVarB != null ? hVarB.a(this.f18534d, this.f18536f, this.f18532b) : this.f18532b.f(this.f18534d, this.f18536f);
            this.f18537g.e(aVar, a1Var);
        }

        @Override // vb.b0, vb.f1
        public vb.g<ReqT, RespT> f() {
            return this.f18537g;
        }

        public final void h(vb.g.a<RespT> aVar, vb.l1 l1Var) {
            this.f18533c.execute(new a(aVar, l1Var));
        }
    }

    public final class o implements k1.a {
        public o() {
        }

        public /* synthetic */ o(g1 g1Var, a aVar) {
            this();
        }

        @Override // xb.k1.a
        public void a() {
        }

        @Override // xb.k1.a
        public void b(vb.l1 l1Var) {
            j6.m.v(g1.this.N.get(), "Channel must have been shut down");
        }

        @Override // xb.k1.a
        public void c() {
            j6.m.v(g1.this.N.get(), "Channel must have been shut down");
            g1.this.P = true;
            g1.this.J0(false);
            g1.this.D0();
            g1.this.E0();
        }

        @Override // xb.k1.a
        public vb.a d(vb.a aVar) {
            return aVar;
        }

        @Override // xb.k1.a
        public void e(boolean z10) {
            g1 g1Var = g1.this;
            g1Var.f18494j0.e(g1Var.L, z10);
        }
    }

    public static final class p implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1<? extends Executor> f18542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f18543b;

        public p(p1<? extends Executor> p1Var) {
            this.f18542a = (p1) j6.m.p(p1Var, "executorPool");
        }

        public synchronized Executor a() {
            if (this.f18543b == null) {
                this.f18543b = (Executor) j6.m.q(this.f18542a.a(), "%s.getObject()", this.f18543b);
            }
            return this.f18543b;
        }

        public synchronized void b() {
            Executor executor = this.f18543b;
            if (executor != null) {
                this.f18543b = this.f18542a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    public final class q extends w0<Object> {
        public q() {
        }

        public /* synthetic */ q(g1 g1Var, a aVar) {
            this();
        }

        @Override // xb.w0
        public void b() {
            g1.this.z0();
        }

        @Override // xb.w0
        public void c() {
            if (g1.this.N.get()) {
                return;
            }
            g1.this.H0();
        }
    }

    public class r implements Runnable {
        public r() {
        }

        public /* synthetic */ r(g1 g1Var, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.E == null) {
                return;
            }
            g1.this.y0();
        }
    }

    public final class s extends vb.t0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xb.i.b f18546a;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.G0();
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.t0.j f18549a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vb.q f18550b;

            public b(vb.t0.j jVar, vb.q qVar) {
                this.f18549a = jVar;
                this.f18550b = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                s sVar = s.this;
                if (sVar != g1.this.E) {
                    return;
                }
                g1.this.L0(this.f18549a);
                if (this.f18550b != vb.q.SHUTDOWN) {
                    g1.this.V.b(vb.f.a.INFO, "Entering {0} state with picker: {1}", this.f18550b, this.f18549a);
                    g1.this.f18510x.b(this.f18550b);
                }
            }
        }

        public s() {
        }

        public /* synthetic */ s(g1 g1Var, a aVar) {
            this();
        }

        @Override // vb.t0.e
        public vb.f b() {
            return g1.this.V;
        }

        @Override // vb.t0.e
        public ScheduledExecutorService c() {
            return g1.this.f18493j;
        }

        @Override // vb.t0.e
        public vb.p1 d() {
            return g1.this.f18504r;
        }

        @Override // vb.t0.e
        public void e() {
            g1.this.f18504r.f();
            g1.this.f18504r.execute(new a());
        }

        @Override // vb.t0.e
        public void f(vb.q qVar, vb.t0.j jVar) {
            g1.this.f18504r.f();
            j6.m.p(qVar, "newState");
            j6.m.p(jVar, "newPicker");
            g1.this.f18504r.execute(new b(jVar, qVar));
        }

        @Override // vb.t0.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public xb.d a(vb.t0.b bVar) {
            g1.this.f18504r.f();
            j6.m.v(!g1.this.P, "Channel is being terminated");
            return g1.this.new x(bVar);
        }
    }

    public final class t extends vb.c1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f18552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.c1 f18553b;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18555a;

            public a(vb.l1 l1Var) {
                this.f18555a = l1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                t.this.e(this.f18555a);
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.c1.g f18557a;

            public b(vb.c1.g gVar) {
                this.f18557a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                vb.f fVar;
                String str;
                j1 j1Var;
                if (g1.this.C != t.this.f18553b) {
                    return;
                }
                List<vb.y> listA = this.f18557a.a();
                vb.f fVar2 = g1.this.V;
                vb.f.a aVar = vb.f.a.DEBUG;
                fVar2.b(aVar, "Resolved address: {0}, config={1}", listA, this.f18557a.b());
                v vVar = g1.this.Y;
                v vVar2 = v.SUCCESS;
                if (vVar != vVar2) {
                    g1.this.V.b(vb.f.a.INFO, "Address resolved: {0}", listA);
                    g1.this.Y = vVar2;
                }
                vb.c1.c cVarC = this.f18557a.c();
                f2.b bVar = (f2.b) this.f18557a.b().b(f2.f18450e);
                vb.h0 h0Var = (vb.h0) this.f18557a.b().b(vb.h0.f17379a);
                j1 j1Var2 = (cVarC == null || cVarC.c() == null) ? null : (j1) cVarC.c();
                vb.l1 l1VarD = cVarC != null ? cVarC.d() : null;
                if (g1.this.f18480c0) {
                    if (j1Var2 != null) {
                        u uVar = g1.this.X;
                        if (h0Var != null) {
                            uVar.p(h0Var);
                            if (j1Var2.c() != null) {
                                fVar = g1.this.V;
                                str = "Method configs in service config will be discarded due to presence ofconfig-selector";
                                fVar.a(aVar, str);
                            }
                        } else {
                            uVar.p(j1Var2.c());
                        }
                    } else if (g1.this.f18476a0 != null) {
                        j1Var2 = g1.this.f18476a0;
                        g1.this.X.p(j1Var2.c());
                        fVar = g1.this.V;
                        aVar = vb.f.a.INFO;
                        str = "Received no service config, using default service config";
                        fVar.a(aVar, str);
                    } else if (l1VarD == null) {
                        j1Var2 = g1.f18472r0;
                        g1.this.X.p(null);
                    } else {
                        if (!g1.this.f18478b0) {
                            g1.this.V.a(vb.f.a.INFO, "Fallback to error due to invalid first service config without default config");
                            t.this.b(cVarC.d());
                            if (bVar != null) {
                                bVar.a(cVarC.d());
                                return;
                            }
                            return;
                        }
                        j1Var2 = g1.this.Z;
                    }
                    if (!j1Var2.equals(g1.this.Z)) {
                        vb.f fVar3 = g1.this.V;
                        vb.f.a aVar2 = vb.f.a.INFO;
                        Object[] objArr = new Object[1];
                        objArr[0] = j1Var2 == g1.f18472r0 ? " to empty" : "";
                        fVar3.b(aVar2, "Service config changed{0}", objArr);
                        g1.this.Z = j1Var2;
                        g1.this.f18496k0.f18528a = j1Var2.g();
                    }
                    try {
                        g1.this.f18478b0 = true;
                    } catch (RuntimeException e10) {
                        g1.f18467m0.log(Level.WARNING, "[" + g1.this.g() + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    j1Var = j1Var2;
                } else {
                    if (j1Var2 != null) {
                        g1.this.V.a(vb.f.a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    j1Var = g1.this.f18476a0 == null ? g1.f18472r0 : g1.this.f18476a0;
                    if (h0Var != null) {
                        g1.this.V.a(vb.f.a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    g1.this.X.p(j1Var.c());
                }
                vb.a aVarB = this.f18557a.b();
                t tVar = t.this;
                if (tVar.f18552a == g1.this.E) {
                    vb.a.b bVarC = aVarB.d().c(vb.h0.f17379a);
                    Map<String, ?> mapD = j1Var.d();
                    if (mapD != null) {
                        bVarC.d(vb.t0.f17504b, mapD).a();
                    }
                    vb.l1 l1VarE = t.this.f18552a.f18546a.e(vb.t0.h.d().b(listA).c(bVarC.a()).d(j1Var.e()).a());
                    if (bVar != null) {
                        bVar.a(l1VarE);
                    }
                }
            }
        }

        public t(s sVar, vb.c1 c1Var) {
            this.f18552a = (s) j6.m.p(sVar, "helperImpl");
            this.f18553b = (vb.c1) j6.m.p(c1Var, "resolver");
        }

        @Override // vb.c1.e, vb.c1.f
        public void b(vb.l1 l1Var) {
            j6.m.e(!l1Var.o(), "the error status must not be OK");
            g1.this.f18504r.execute(new a(l1Var));
        }

        @Override // vb.c1.e
        public void c(vb.c1.g gVar) {
            g1.this.f18504r.execute(new b(gVar));
        }

        public final void e(vb.l1 l1Var) {
            g1.f18467m0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{g1.this.g(), l1Var});
            g1.this.X.m();
            v vVar = g1.this.Y;
            v vVar2 = v.ERROR;
            if (vVar != vVar2) {
                g1.this.V.b(vb.f.a.WARNING, "Failed to resolve name: {0}", l1Var);
                g1.this.Y = vVar2;
            }
            if (this.f18552a != g1.this.E) {
                return;
            }
            this.f18552a.f18546a.b(l1Var);
        }
    }

    public class u extends vb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<vb.h0> f18559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vb.d f18561c;

        public class a extends vb.d {
            public a() {
            }

            @Override // vb.d
            public String b() {
                return u.this.f18560b;
            }

            @Override // vb.d
            public <RequestT, ResponseT> vb.g<RequestT, ResponseT> f(vb.b1<RequestT, ResponseT> b1Var, vb.c cVar) {
                return new xb.q(b1Var, g1.this.A0(cVar), cVar, g1.this.f18496k0, g1.this.Q ? null : g1.this.f18489h.P(), g1.this.T, null).E(g1.this.f18505s).D(g1.this.f18506t).C(g1.this.f18507u);
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g1.this.I == null) {
                    if (u.this.f18559a.get() == g1.f18473s0) {
                        u.this.f18559a.set(null);
                    }
                    g1.this.M.b(g1.f18470p0);
                }
            }
        }

        public final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f18559a.get() == g1.f18473s0) {
                    u.this.f18559a.set(null);
                }
                if (g1.this.I != null) {
                    Iterator it = g1.this.I.iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).a("Channel is forcefully shutdown", null);
                    }
                }
                g1.this.M.c(g1.f18469o0);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.z0();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
        public class e<ReqT, RespT> extends vb.g<ReqT, RespT> {
            public e() {
            }

            @Override // vb.g
            public void a(String str, Throwable th) {
            }

            @Override // vb.g
            public void b() {
            }

            @Override // vb.g
            public void c(int i10) {
            }

            @Override // vb.g
            public void d(ReqT reqt) {
            }

            @Override // vb.g
            public void e(vb.g.a<RespT> aVar, vb.a1 a1Var) {
                aVar.a(g1.f18470p0, new vb.a1());
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f18568a;

            public f(g gVar) {
                this.f18568a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f18559a.get() != g1.f18473s0) {
                    this.f18568a.r();
                    return;
                }
                if (g1.this.I == null) {
                    g1.this.I = new LinkedHashSet();
                    g1 g1Var = g1.this;
                    g1Var.f18494j0.e(g1Var.J, true);
                }
                g1.this.I.add(this.f18568a);
            }
        }

        public final class g<ReqT, RespT> extends a0<ReqT, RespT> {

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final vb.s f18570l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final vb.b1<ReqT, RespT> f18571m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final vb.c f18572n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f18573o;

            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f18575a;

                public a(Runnable runnable) {
                    this.f18575a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f18575a.run();
                    g gVar = g.this;
                    g1.this.f18504r.execute(new b());
                }
            }

            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (g1.this.I != null) {
                        g1.this.I.remove(g.this);
                        if (g1.this.I.isEmpty()) {
                            g1 g1Var = g1.this;
                            g1Var.f18494j0.e(g1Var.J, false);
                            g1.this.I = null;
                            if (g1.this.N.get()) {
                                g1.this.M.b(g1.f18470p0);
                            }
                        }
                    }
                }
            }

            public g(vb.s sVar, vb.b1<ReqT, RespT> b1Var, vb.c cVar) {
                super(g1.this.A0(cVar), g1.this.f18493j, cVar.d());
                this.f18570l = sVar;
                this.f18571m = b1Var;
                this.f18572n = cVar;
                this.f18573o = g1.this.f18490h0.a();
            }

            @Override // xb.a0
            public void j() {
                super.j();
                g1.this.f18504r.execute(new b());
            }

            public void r() {
                vb.s sVarB = this.f18570l.b();
                try {
                    vb.g<ReqT, RespT> gVarL = u.this.l(this.f18571m, this.f18572n.q(vb.k.f17392a, Long.valueOf(g1.this.f18490h0.a() - this.f18573o)));
                    this.f18570l.f(sVarB);
                    Runnable runnableP = p(gVarL);
                    if (runnableP == null) {
                        g1.this.f18504r.execute(new b());
                    } else {
                        g1.this.A0(this.f18572n).execute(new a(runnableP));
                    }
                } catch (Throwable th) {
                    this.f18570l.f(sVarB);
                    throw th;
                }
            }
        }

        public u(String str) {
            this.f18559a = new AtomicReference<>(g1.f18473s0);
            this.f18561c = new a();
            this.f18560b = (String) j6.m.p(str, "authority");
        }

        public /* synthetic */ u(g1 g1Var, String str, a aVar) {
            this(str);
        }

        @Override // vb.d
        public String b() {
            return this.f18560b;
        }

        @Override // vb.d
        public <ReqT, RespT> vb.g<ReqT, RespT> f(vb.b1<ReqT, RespT> b1Var, vb.c cVar) {
            if (this.f18559a.get() != g1.f18473s0) {
                return l(b1Var, cVar);
            }
            g1.this.f18504r.execute(new d());
            if (this.f18559a.get() != g1.f18473s0) {
                return l(b1Var, cVar);
            }
            if (g1.this.N.get()) {
                return new e();
            }
            g gVar = new g(vb.s.e(), b1Var, cVar);
            g1.this.f18504r.execute(new f(gVar));
            return gVar;
        }

        public final <ReqT, RespT> vb.g<ReqT, RespT> l(vb.b1<ReqT, RespT> b1Var, vb.c cVar) {
            vb.h0 h0Var = this.f18559a.get();
            if (h0Var != null) {
                if (!(h0Var instanceof j1.c)) {
                    return new n(h0Var, this.f18561c, g1.this.f18495k, b1Var, cVar);
                }
                j1.b bVarF = ((j1.c) h0Var).f18668b.f(b1Var);
                if (bVarF != null) {
                    cVar = cVar.q(j1.b.f18661g, bVarF);
                }
            }
            return this.f18561c.f(b1Var, cVar);
        }

        public void m() {
            if (this.f18559a.get() == g1.f18473s0) {
                p(null);
            }
        }

        public void n() {
            g1.this.f18504r.execute(new b());
        }

        public void o() {
            g1.this.f18504r.execute(new c());
        }

        public void p(vb.h0 h0Var) {
            vb.h0 h0Var2 = this.f18559a.get();
            this.f18559a.set(h0Var);
            if (h0Var2 != g1.f18473s0 || g1.this.I == null) {
                return;
            }
            Iterator it = g1.this.I.iterator();
            while (it.hasNext()) {
                ((g) it.next()).r();
            }
        }
    }

    public enum v {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    public static final class w implements ScheduledExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f18582a;

        public w(ScheduledExecutorService scheduledExecutorService) {
            this.f18582a = (ScheduledExecutorService) j6.m.p(scheduledExecutorService, "delegate");
        }

        public /* synthetic */ w(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) {
            return this.f18582a.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f18582a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.f18582a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
            return this.f18582a.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return (T) this.f18582a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
            return (T) this.f18582a.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f18582a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f18582a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f18582a.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            return this.f18582a.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f18582a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f18582a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f18582a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t10) {
            return this.f18582a.submit(runnable, t10);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f18582a.submit(callable);
        }
    }

    public final class x extends xb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.b f18583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.l0 f18584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xb.o f18585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xb.p f18586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<vb.y> f18587e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public y0 f18588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f18589g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f18590h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public vb.p1.d f18591i;

        public final class a extends y0.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.t0.k f18593a;

            public a(vb.t0.k kVar) {
                this.f18593a = kVar;
            }

            @Override // xb.y0.j
            public void a(y0 y0Var) {
                g1.this.f18494j0.e(y0Var, true);
            }

            @Override // xb.y0.j
            public void b(y0 y0Var) {
                g1.this.f18494j0.e(y0Var, false);
            }

            @Override // xb.y0.j
            public void c(y0 y0Var, vb.r rVar) {
                j6.m.v(this.f18593a != null, "listener is null");
                this.f18593a.a(rVar);
            }

            @Override // xb.y0.j
            public void d(y0 y0Var) {
                g1.this.H.remove(y0Var);
                g1.this.W.k(y0Var);
                g1.this.E0();
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x.this.f18588f.c(g1.f18471q0);
            }
        }

        public x(vb.t0.b bVar) {
            j6.m.p(bVar, "args");
            this.f18587e = bVar.a();
            if (g1.this.f18479c != null) {
                bVar = bVar.e().e(j(bVar.a())).c();
            }
            this.f18583a = bVar;
            vb.l0 l0VarB = vb.l0.b("Subchannel", g1.this.b());
            this.f18584b = l0VarB;
            xb.p pVar = new xb.p(l0VarB, g1.this.f18503q, g1.this.f18502p.a(), "Subchannel for " + bVar.a());
            this.f18586d = pVar;
            this.f18585c = new xb.o(pVar, g1.this.f18502p);
        }

        @Override // vb.t0.i
        public List<vb.y> b() {
            g1.this.f18504r.f();
            j6.m.v(this.f18589g, "not started");
            return this.f18587e;
        }

        @Override // vb.t0.i
        public vb.a c() {
            return this.f18583a.b();
        }

        @Override // vb.t0.i
        public vb.f d() {
            return this.f18585c;
        }

        @Override // vb.t0.i
        public Object e() {
            j6.m.v(this.f18589g, "Subchannel is not started");
            return this.f18588f;
        }

        @Override // vb.t0.i
        public void f() {
            g1.this.f18504r.f();
            j6.m.v(this.f18589g, "not started");
            this.f18588f.b();
        }

        @Override // vb.t0.i
        public void g() {
            vb.p1.d dVar;
            g1.this.f18504r.f();
            if (this.f18588f == null) {
                this.f18590h = true;
                return;
            }
            if (!this.f18590h) {
                this.f18590h = true;
            } else {
                if (!g1.this.P || (dVar = this.f18591i) == null) {
                    return;
                }
                dVar.a();
                this.f18591i = null;
            }
            if (g1.this.P) {
                this.f18588f.c(g1.f18470p0);
            } else {
                this.f18591i = g1.this.f18504r.c(new d1(new b()), 5L, TimeUnit.SECONDS, g1.this.f18489h.P());
            }
        }

        @Override // vb.t0.i
        public void h(vb.t0.k kVar) {
            g1.this.f18504r.f();
            j6.m.v(!this.f18589g, "already started");
            j6.m.v(!this.f18590h, "already shutdown");
            j6.m.v(!g1.this.P, "Channel is being terminated");
            this.f18589g = true;
            y0 y0Var = new y0(this.f18583a.a(), g1.this.b(), g1.this.B, g1.this.f18511y, g1.this.f18489h, g1.this.f18489h.P(), g1.this.f18508v, g1.this.f18504r, new a(kVar), g1.this.W, g1.this.S.a(), this.f18586d, this.f18584b, this.f18585c, g1.this.A);
            g1.this.U.e(new vb.g0.a().b("Child Subchannel started").c(vb.g0.b.CT_INFO).e(g1.this.f18502p.a()).d(y0Var).a());
            this.f18588f = y0Var;
            g1.this.W.e(y0Var);
            g1.this.H.add(y0Var);
        }

        @Override // vb.t0.i
        public void i(List<vb.y> list) {
            g1.this.f18504r.f();
            this.f18587e = list;
            if (g1.this.f18479c != null) {
                list = j(list);
            }
            this.f18588f.V(list);
        }

        public final List<vb.y> j(List<vb.y> list) {
            ArrayList arrayList = new ArrayList();
            for (vb.y yVar : list) {
                arrayList.add(new vb.y(yVar.a(), yVar.b().d().c(vb.y.f17549d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f18584b.toString();
        }
    }

    public final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection<xb.r> f18597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vb.l1 f18598c;

        public y() {
            this.f18596a = new Object();
            this.f18597b = new HashSet();
        }

        public /* synthetic */ y(g1 g1Var, a aVar) {
            this();
        }

        public vb.l1 a(c2<?> c2Var) {
            synchronized (this.f18596a) {
                vb.l1 l1Var = this.f18598c;
                if (l1Var != null) {
                    return l1Var;
                }
                this.f18597b.add(c2Var);
                return null;
            }
        }

        public void b(vb.l1 l1Var) {
            synchronized (this.f18596a) {
                if (this.f18598c != null) {
                    return;
                }
                this.f18598c = l1Var;
                boolean zIsEmpty = this.f18597b.isEmpty();
                if (zIsEmpty) {
                    g1.this.L.c(l1Var);
                }
            }
        }

        public void c(vb.l1 l1Var) {
            ArrayList arrayList;
            b(l1Var);
            synchronized (this.f18596a) {
                arrayList = new ArrayList(this.f18597b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((xb.r) it.next()).a(l1Var);
            }
            g1.this.L.d(l1Var);
        }

        public void d(c2<?> c2Var) {
            vb.l1 l1Var;
            synchronized (this.f18596a) {
                this.f18597b.remove(c2Var);
                if (this.f18597b.isEmpty()) {
                    l1Var = this.f18598c;
                    this.f18597b = new HashSet();
                } else {
                    l1Var = null;
                }
            }
            if (l1Var != null) {
                g1.this.L.c(l1Var);
            }
        }
    }

    static {
        vb.l1 l1Var = vb.l1.f17420t;
        f18469o0 = l1Var.q("Channel shutdownNow invoked");
        f18470p0 = l1Var.q("Channel shutdown invoked");
        f18471q0 = l1Var.q("Subchannel shutdown invoked");
        f18472r0 = j1.a();
        f18473s0 = new a();
        f18474t0 = new l();
    }

    public g1(h1 h1Var, xb.u uVar, xb.j.a aVar, p1<? extends Executor> p1Var, j6.r<j6.p> rVar, List<vb.h> list, r2 r2Var) {
        a aVar2;
        vb.p1 p1Var2 = new vb.p1(new j());
        this.f18504r = p1Var2;
        this.f18510x = new xb.x();
        this.H = new HashSet(16, 0.75f);
        this.J = new Object();
        this.K = new HashSet(1, 0.75f);
        a aVar3 = null;
        this.M = new y(this, aVar3);
        this.N = new AtomicBoolean(false);
        this.R = new CountDownLatch(1);
        this.Y = v.NO_RESOLUTION;
        this.Z = f18472r0;
        this.f18478b0 = false;
        this.f18482d0 = new c2.t();
        this.f18490h0 = vb.u.n();
        o oVar = new o(this, aVar3);
        this.f18492i0 = oVar;
        this.f18494j0 = new q(this, aVar3);
        this.f18496k0 = new m(this, aVar3);
        String str = (String) j6.m.p(h1Var.f18609f, "target");
        this.f18477b = str;
        vb.l0 l0VarB = vb.l0.b("Channel", str);
        this.f18475a = l0VarB;
        this.f18502p = (r2) j6.m.p(r2Var, "timeProvider");
        p1<? extends Executor> p1Var3 = (p1) j6.m.p(h1Var.f18604a, "executorPool");
        this.f18497l = p1Var3;
        Executor executor = (Executor) j6.m.p(p1Var3.a(), "executor");
        this.f18495k = executor;
        this.f18487g = uVar;
        p pVar = new p((p1) j6.m.p(h1Var.f18605b, "offloadExecutorPool"));
        this.f18501o = pVar;
        xb.m mVar = new xb.m(uVar, h1Var.f18610g, pVar);
        this.f18489h = mVar;
        this.f18491i = new xb.m(uVar, null, pVar);
        w wVar = new w(mVar.P(), aVar3);
        this.f18493j = wVar;
        this.f18503q = h1Var.f18625v;
        xb.p pVar2 = new xb.p(l0VarB, h1Var.f18625v, r2Var.a(), "Channel for '" + str + "'");
        this.U = pVar2;
        xb.o oVar2 = new xb.o(pVar2, r2Var);
        this.V = oVar2;
        vb.h1 h1Var2 = h1Var.f18628y;
        h1Var2 = h1Var2 == null ? r0.f18871q : h1Var2;
        boolean z10 = h1Var.f18623t;
        this.f18488g0 = z10;
        xb.i iVar = new xb.i(h1Var.f18614k);
        this.f18485f = iVar;
        vb.e1 e1Var = h1Var.f18607d;
        this.f18481d = e1Var;
        h2 h2Var = new h2(z10, h1Var.f18619p, h1Var.f18620q, iVar);
        String str2 = h1Var.f18613j;
        this.f18479c = str2;
        vb.c1.b bVarA = vb.c1.b.g().c(h1Var.e()).f(h1Var2).i(p1Var2).g(wVar).h(h2Var).b(oVar2).d(pVar).e(str2).a();
        this.f18483e = bVarA;
        this.C = B0(str, str2, e1Var, bVarA, mVar.a0());
        this.f18499m = (p1) j6.m.p(p1Var, "balancerRpcExecutorPool");
        this.f18500n = new p(p1Var);
        b0 b0Var = new b0(executor, p1Var2);
        this.L = b0Var;
        b0Var.a(oVar);
        this.f18511y = aVar;
        Map<String, ?> map = h1Var.f18626w;
        if (map != null) {
            vb.c1.c cVarA = h2Var.a(map);
            j6.m.x(cVarA.d() == null, "Default config is invalid: %s", cVarA.d());
            j1 j1Var = (j1) cVarA.c();
            this.f18476a0 = j1Var;
            this.Z = j1Var;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f18476a0 = null;
        }
        boolean z11 = h1Var.f18627x;
        this.f18480c0 = z11;
        u uVar2 = new u(this, this.C.a(), aVar2);
        this.X = uVar2;
        this.f18512z = vb.j.a(uVar2, list);
        this.A = new ArrayList(h1Var.f18608e);
        this.f18508v = (j6.r) j6.m.p(rVar, "stopwatchSupplier");
        long j10 = h1Var.f18618o;
        if (j10 != -1) {
            j6.m.j(j10 >= h1.J, "invalid idleTimeoutMillis %s", j10);
            j10 = h1Var.f18618o;
        }
        this.f18509w = j10;
        this.f18498l0 = new b2(new r(this, null), p1Var2, mVar.P(), rVar.get());
        this.f18505s = h1Var.f18615l;
        this.f18506t = (vb.w) j6.m.p(h1Var.f18616m, "decompressorRegistry");
        this.f18507u = (vb.p) j6.m.p(h1Var.f18617n, "compressorRegistry");
        this.B = h1Var.f18612i;
        this.f18486f0 = h1Var.f18621r;
        this.f18484e0 = h1Var.f18622s;
        c cVar = new c(r2Var);
        this.S = cVar;
        this.T = cVar.a();
        vb.f0 f0Var = (vb.f0) j6.m.o(h1Var.f18624u);
        this.W = f0Var;
        f0Var.d(this);
        if (z11) {
            return;
        }
        if (this.f18476a0 != null) {
            oVar2.a(vb.f.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f18478b0 = true;
    }

    public static vb.c1 B0(String str, String str2, vb.e1 e1Var, vb.c1.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        f2 f2Var = new f2(C0(str, e1Var, bVar, collection), new xb.l(new f0.a(), bVar.d(), bVar.f()), bVar.f());
        return str2 == null ? f2Var : new k(f2Var, str2);
    }

    public static vb.c1 C0(String str, vb.e1 e1Var, vb.c1.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        URI uri;
        StringBuilder sb2 = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb2.append(e10.getMessage());
            uri = null;
        }
        vb.d1 d1VarE = uri != null ? e1Var.e(uri.getScheme()) : null;
        String str2 = "";
        if (d1VarE == null && !f18468n0.matcher(str).matches()) {
            try {
                uri = new URI(e1Var.c(), "", "/" + str, null);
                d1VarE = e1Var.e(uri.getScheme());
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        if (d1VarE == null) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (sb2.length() > 0) {
                str2 = " (" + ((Object) sb2) + ")";
            }
            objArr[1] = str2;
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", objArr));
        }
        if (collection != null && !collection.containsAll(d1VarE.c())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        vb.c1 c1VarB = d1VarE.b(uri, bVar);
        if (c1VarB != null) {
            return c1VarB;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        if (sb2.length() > 0) {
            str2 = " (" + ((Object) sb2) + ")";
        }
        objArr2[1] = str2;
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", objArr2));
    }

    public final Executor A0(vb.c cVar) {
        Executor executorE = cVar.e();
        return executorE == null ? this.f18495k : executorE;
    }

    public final void D0() {
        if (this.O) {
            Iterator<y0> it = this.H.iterator();
            while (it.hasNext()) {
                it.next().d(f18469o0);
            }
            Iterator<q1> it2 = this.K.iterator();
            while (it2.hasNext()) {
                it2.next().o().d(f18469o0);
            }
        }
    }

    public final void E0() {
        if (!this.Q && this.N.get() && this.H.isEmpty() && this.K.isEmpty()) {
            this.V.a(vb.f.a.INFO, "Terminated");
            this.W.j(this);
            this.f18497l.b(this.f18495k);
            this.f18500n.b();
            this.f18501o.b();
            this.f18489h.close();
            this.Q = true;
            this.R.countDown();
        }
    }

    public void F0(Throwable th) {
        if (this.G) {
            return;
        }
        this.G = true;
        x0(true);
        J0(false);
        L0(new e(th));
        this.X.p(null);
        this.V.a(vb.f.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f18510x.b(vb.q.TRANSIENT_FAILURE);
    }

    public final void G0() {
        this.f18504r.f();
        if (this.D) {
            this.C.b();
        }
    }

    public final void H0() {
        long j10 = this.f18509w;
        if (j10 == -1) {
            return;
        }
        this.f18498l0.k(j10, TimeUnit.MILLISECONDS);
    }

    @Override // vb.w0
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public g1 m() {
        this.V.a(vb.f.a.DEBUG, "shutdown() called");
        if (!this.N.compareAndSet(false, true)) {
            return this;
        }
        this.f18504r.execute(new h());
        this.X.n();
        this.f18504r.execute(new b());
        return this;
    }

    public final void J0(boolean z10) {
        this.f18504r.f();
        if (z10) {
            j6.m.v(this.D, "nameResolver is not started");
            j6.m.v(this.E != null, "lbHelper is null");
        }
        vb.c1 c1Var = this.C;
        if (c1Var != null) {
            c1Var.c();
            this.D = false;
            if (z10) {
                this.C = B0(this.f18477b, this.f18479c, this.f18481d, this.f18483e, this.f18489h.a0());
            } else {
                this.C = null;
            }
        }
        s sVar = this.E;
        if (sVar != null) {
            sVar.f18546a.d();
            this.E = null;
        }
        this.F = null;
    }

    @Override // vb.w0
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public g1 n() {
        this.V.a(vb.f.a.DEBUG, "shutdownNow() called");
        m();
        this.X.o();
        this.f18504r.execute(new i());
        return this;
    }

    public final void L0(vb.t0.j jVar) {
        this.F = jVar;
        this.L.r(jVar);
    }

    @Override // vb.d
    public String b() {
        return this.f18512z.b();
    }

    @Override // vb.d
    public <ReqT, RespT> vb.g<ReqT, RespT> f(vb.b1<ReqT, RespT> b1Var, vb.c cVar) {
        return this.f18512z.f(b1Var, cVar);
    }

    @Override // vb.r0
    public vb.l0 g() {
        return this.f18475a;
    }

    @Override // vb.w0
    public boolean i(long j10, TimeUnit timeUnit) {
        return this.R.await(j10, timeUnit);
    }

    @Override // vb.w0
    public void j() {
        this.f18504r.execute(new f());
    }

    @Override // vb.w0
    public vb.q k(boolean z10) {
        vb.q qVarA = this.f18510x.a();
        if (z10 && qVarA == vb.q.IDLE) {
            this.f18504r.execute(new g());
        }
        return qVarA;
    }

    @Override // vb.w0
    public void l(vb.q qVar, Runnable runnable) {
        this.f18504r.execute(new d(runnable, qVar));
    }

    public String toString() {
        return j6.g.b(this).c("logId", this.f18475a.d()).d("target", this.f18477b).toString();
    }

    public final void x0(boolean z10) {
        this.f18498l0.i(z10);
    }

    public final void y0() {
        J0(true);
        this.L.r(null);
        this.V.a(vb.f.a.INFO, "Entering IDLE state");
        this.f18510x.b(vb.q.IDLE);
        if (this.f18494j0.a(this.J, this.L)) {
            z0();
        }
    }

    public void z0() {
        this.f18504r.f();
        if (this.N.get() || this.G) {
            return;
        }
        if (this.f18494j0.d()) {
            x0(false);
        } else {
            H0();
        }
        if (this.E != null) {
            return;
        }
        this.V.a(vb.f.a.INFO, "Exiting idle mode");
        s sVar = new s(this, null);
        sVar.f18546a = this.f18485f.e(sVar);
        this.E = sVar;
        this.C.d(new t(sVar, this.C));
        this.D = true;
    }
}
