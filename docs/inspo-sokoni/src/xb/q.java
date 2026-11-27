package xb;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q<ReqT, RespT> extends vb.g<ReqT, RespT> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f18797t = Logger.getLogger(q.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte[] f18798u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double f18799v = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.b1<ReqT, RespT> f18800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fc.d f18801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f18804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vb.s f18805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture<?> f18806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vb.c f18808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f18809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f18810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f18813n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f18815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18816q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final q<ReqT, RespT>.f f18814o = new f();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vb.w f18817r = vb.w.c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public vb.p f18818s = vb.p.a();

    public class b extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.g.a f18819b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vb.g.a aVar) {
            super(q.this.f18805f);
            this.f18819b = aVar;
        }

        @Override // xb.y
        public void a() {
            q qVar = q.this;
            qVar.t(this.f18819b, vb.t.a(qVar.f18805f), new vb.a1());
        }
    }

    public class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.g.a f18821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18822c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vb.g.a aVar, String str) {
            super(q.this.f18805f);
            this.f18821b = aVar;
            this.f18822c = str;
        }

        @Override // xb.y
        public void a() {
            q.this.t(this.f18821b, vb.l1.f17419s.q(String.format("Unable to find compressor by name %s", this.f18822c)), new vb.a1());
        }
    }

    public class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.g.a<RespT> f18824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vb.l1 f18825b;

        public final class a extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fc.b f18827b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18828c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(fc.b bVar, vb.a1 a1Var) {
                super(q.this.f18805f);
                this.f18827b = bVar;
                this.f18828c = a1Var;
            }

            @Override // xb.y
            public void a() {
                fc.e eVarH = fc.c.h("ClientCall$Listener.headersRead");
                try {
                    fc.c.a(q.this.f18801b);
                    fc.c.e(this.f18827b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            public final void b() {
                if (d.this.f18825b != null) {
                    return;
                }
                try {
                    d.this.f18824a.b(this.f18828c);
                } catch (Throwable th) {
                    d.this.i(vb.l1.f17406f.p(th).q("Failed to read headers"));
                }
            }
        }

        public final class b extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fc.b f18830b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ q2.a f18831c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(fc.b bVar, q2.a aVar) {
                super(q.this.f18805f);
                this.f18830b = bVar;
                this.f18831c = aVar;
            }

            @Override // xb.y
            public void a() {
                fc.e eVarH = fc.c.h("ClientCall$Listener.messagesAvailable");
                try {
                    fc.c.a(q.this.f18801b);
                    fc.c.e(this.f18830b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            /* JADX WARN: Bottom block not found for handler: all -> 0x0034 */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
            
                return;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void b() {
                if (d.this.f18825b != null) {
                    r0.e(this.f18831c);
                    return;
                }
                while (true) {
                    InputStream next = this.f18831c.next();
                    if (next == null) {
                        return;
                    }
                    try {
                        d.this.f18824a.c(q.this.f18800a.i(next));
                        next.close();
                    } catch (Throwable th) {
                        r0.d(next);
                        throw th;
                    }
                }
            }
        }

        public final class c extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fc.b f18833b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18834c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18835d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(fc.b bVar, vb.l1 l1Var, vb.a1 a1Var) {
                super(q.this.f18805f);
                this.f18833b = bVar;
                this.f18834c = l1Var;
                this.f18835d = a1Var;
            }

            @Override // xb.y
            public void a() {
                fc.e eVarH = fc.c.h("ClientCall$Listener.onClose");
                try {
                    fc.c.a(q.this.f18801b);
                    fc.c.e(this.f18833b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            public final void b() {
                vb.l1 l1Var = this.f18834c;
                vb.a1 a1Var = this.f18835d;
                if (d.this.f18825b != null) {
                    l1Var = d.this.f18825b;
                    a1Var = new vb.a1();
                }
                q.this.f18810k = true;
                try {
                    d dVar = d.this;
                    q.this.t(dVar.f18824a, l1Var, a1Var);
                } finally {
                    q.this.A();
                    q.this.f18804e.a(l1Var.o());
                }
            }
        }

        /* JADX INFO: renamed from: xb.q$d$d, reason: collision with other inner class name */
        public final class C0329d extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fc.b f18837b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0329d(fc.b bVar) {
                super(q.this.f18805f);
                this.f18837b = bVar;
            }

            @Override // xb.y
            public void a() {
                fc.e eVarH = fc.c.h("ClientCall$Listener.onReady");
                try {
                    fc.c.a(q.this.f18801b);
                    fc.c.e(this.f18837b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            public final void b() {
                if (d.this.f18825b != null) {
                    return;
                }
                try {
                    d.this.f18824a.d();
                } catch (Throwable th) {
                    d.this.i(vb.l1.f17406f.p(th).q("Failed to call onReady."));
                }
            }
        }

        public d(vb.g.a<RespT> aVar) {
            this.f18824a = (vb.g.a) j6.m.p(aVar, "observer");
        }

        @Override // xb.q2
        public void a(q2.a aVar) {
            fc.e eVarH = fc.c.h("ClientStreamListener.messagesAvailable");
            try {
                fc.c.a(q.this.f18801b);
                q.this.f18802c.execute(new b(fc.c.f(), aVar));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // xb.q2
        public void b() {
            if (q.this.f18800a.e().d()) {
                return;
            }
            fc.e eVarH = fc.c.h("ClientStreamListener.onReady");
            try {
                fc.c.a(q.this.f18801b);
                q.this.f18802c.execute(new C0329d(fc.c.f()));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // xb.s
        public void c(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
            fc.e eVarH = fc.c.h("ClientStreamListener.closed");
            try {
                fc.c.a(q.this.f18801b);
                h(l1Var, aVar, a1Var);
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // xb.s
        public void d(vb.a1 a1Var) {
            fc.e eVarH = fc.c.h("ClientStreamListener.headersRead");
            try {
                fc.c.a(q.this.f18801b);
                q.this.f18802c.execute(new a(fc.c.f(), a1Var));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final void h(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
            vb.u uVarU = q.this.u();
            if (l1Var.m() == vb.l1.b.CANCELLED && uVarU != null && uVarU.p()) {
                x0 x0Var = new x0();
                q.this.f18809j.n(x0Var);
                l1Var = vb.l1.f17409i.e("ClientCall was cancelled at or after deadline. " + x0Var);
                a1Var = new vb.a1();
            }
            q.this.f18802c.execute(new c(fc.c.f(), l1Var, a1Var));
        }

        public final void i(vb.l1 l1Var) {
            this.f18825b = l1Var;
            q.this.f18809j.a(l1Var);
        }
    }

    public interface e {
        r a(vb.b1<?, ?> b1Var, vb.c cVar, vb.a1 a1Var, vb.s sVar);
    }

    public final class f implements vb.s.a {
        public f() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18840a;

        public g(long j10) {
            this.f18840a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            x0 x0Var = new x0();
            q.this.f18809j.n(x0Var);
            long jAbs = Math.abs(this.f18840a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit.toNanos(1L);
            long jAbs2 = Math.abs(this.f18840a) % timeUnit.toNanos(1L);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deadline exceeded after ");
            if (this.f18840a < 0) {
                sb2.append('-');
            }
            sb2.append(nanos);
            Locale locale = Locale.US;
            sb2.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
            sb2.append("s. ");
            Long l10 = (Long) q.this.f18808i.h(vb.k.f17392a);
            Object[] objArr = new Object[1];
            objArr[0] = Double.valueOf(l10 == null ? 0.0d : l10.longValue() / q.f18799v);
            sb2.append(String.format(locale, "Name resolution delay %.9f seconds. ", objArr));
            sb2.append(x0Var);
            q.this.f18809j.a(vb.l1.f17409i.e(sb2.toString()));
        }
    }

    public q(vb.b1<ReqT, RespT> b1Var, Executor executor, vb.c cVar, e eVar, ScheduledExecutorService scheduledExecutorService, n nVar, vb.h0 h0Var) {
        this.f18800a = b1Var;
        fc.d dVarC = fc.c.c(b1Var.c(), System.identityHashCode(this));
        this.f18801b = dVarC;
        boolean z10 = true;
        if (executor == p6.f.a()) {
            this.f18802c = new i2();
            this.f18803d = true;
        } else {
            this.f18802c = new j2(executor);
            this.f18803d = false;
        }
        this.f18804e = nVar;
        this.f18805f = vb.s.e();
        if (b1Var.e() != vb.b1.d.UNARY && b1Var.e() != vb.b1.d.SERVER_STREAMING) {
            z10 = false;
        }
        this.f18807h = z10;
        this.f18808i = cVar;
        this.f18813n = eVar;
        this.f18815p = scheduledExecutorService;
        fc.c.d("ClientCall.<init>", dVarC);
    }

    public static boolean w(vb.u uVar, vb.u uVar2) {
        if (uVar == null) {
            return false;
        }
        if (uVar2 == null) {
            return true;
        }
        return uVar.o(uVar2);
    }

    public static void x(vb.u uVar, vb.u uVar2, vb.u uVar3) {
        Logger logger = f18797t;
        if (logger.isLoggable(Level.FINE) && uVar != null && uVar.equals(uVar2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jMax = Math.max(0L, uVar.r(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jMax)));
            sb2.append(uVar3 == null ? " Explicit call timeout was not set." : String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(uVar3.r(timeUnit))));
            logger.fine(sb2.toString());
        }
    }

    public static vb.u y(vb.u uVar, vb.u uVar2) {
        if (uVar == null) {
            return uVar2;
        }
        return uVar2 == null ? uVar : uVar.q(uVar2);
    }

    public static void z(vb.a1 a1Var, vb.w wVar, vb.o oVar, boolean z10) {
        a1Var.e(r0.f18863i);
        vb.a1.g<String> gVar = r0.f18859e;
        a1Var.e(gVar);
        if (oVar != vb.m.b.f17449a) {
            a1Var.p(gVar, oVar.a());
        }
        vb.a1.g<byte[]> gVar2 = r0.f18860f;
        a1Var.e(gVar2);
        byte[] bArrA = vb.i0.a(wVar);
        if (bArrA.length != 0) {
            a1Var.p(gVar2, bArrA);
        }
        a1Var.e(r0.f18861g);
        vb.a1.g<byte[]> gVar3 = r0.f18862h;
        a1Var.e(gVar3);
        if (z10) {
            a1Var.p(gVar3, f18798u);
        }
    }

    public final void A() {
        this.f18805f.i(this.f18814o);
        ScheduledFuture<?> scheduledFuture = this.f18806g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void B(ReqT reqt) {
        j6.m.v(this.f18809j != null, "Not started");
        j6.m.v(!this.f18811l, "call was cancelled");
        j6.m.v(!this.f18812m, "call was half-closed");
        try {
            r rVar = this.f18809j;
            if (rVar instanceof c2) {
                ((c2) rVar).n0(reqt);
            } else {
                rVar.k(this.f18800a.j(reqt));
            }
            if (this.f18807h) {
                return;
            }
            this.f18809j.flush();
        } catch (Error e10) {
            this.f18809j.a(vb.l1.f17406f.q("Client sendMessage() failed with Error"));
            throw e10;
        } catch (RuntimeException e11) {
            this.f18809j.a(vb.l1.f17406f.p(e11).q("Failed to stream message"));
        }
    }

    public q<ReqT, RespT> C(vb.p pVar) {
        this.f18818s = pVar;
        return this;
    }

    public q<ReqT, RespT> D(vb.w wVar) {
        this.f18817r = wVar;
        return this;
    }

    public q<ReqT, RespT> E(boolean z10) {
        this.f18816q = z10;
        return this;
    }

    public final ScheduledFuture<?> F(vb.u uVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jR = uVar.r(timeUnit);
        return this.f18815p.schedule(new d1(new g(jR)), jR, timeUnit);
    }

    public final void G(vb.g.a<RespT> aVar, vb.a1 a1Var) {
        vb.o oVarB;
        j6.m.v(this.f18809j == null, "Already started");
        j6.m.v(!this.f18811l, "call was cancelled");
        j6.m.p(aVar, "observer");
        j6.m.p(a1Var, "headers");
        if (this.f18805f.h()) {
            this.f18809j = o1.f18784a;
            this.f18802c.execute(new b(aVar));
            return;
        }
        r();
        String strB = this.f18808i.b();
        if (strB != null) {
            oVarB = this.f18818s.b(strB);
            if (oVarB == null) {
                this.f18809j = o1.f18784a;
                this.f18802c.execute(new c(aVar, strB));
                return;
            }
        } else {
            oVarB = vb.m.b.f17449a;
        }
        z(a1Var, this.f18817r, oVarB, this.f18816q);
        vb.u uVarU = u();
        if (uVarU != null && uVarU.p()) {
            vb.k[] kVarArrF = r0.f(this.f18808i, a1Var, 0, false);
            String str = w(this.f18808i.d(), this.f18805f.g()) ? "CallOptions" : "Context";
            Long l10 = (Long) this.f18808i.h(vb.k.f17392a);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            double dR = uVarU.r(TimeUnit.NANOSECONDS);
            double d10 = f18799v;
            objArr[1] = Double.valueOf(dR / d10);
            objArr[2] = Double.valueOf(l10 == null ? 0.0d : l10.longValue() / d10);
            this.f18809j = new g0(vb.l1.f17409i.q(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", objArr)), kVarArrF);
        } else {
            x(uVarU, this.f18805f.g(), this.f18808i.d());
            this.f18809j = this.f18813n.a(this.f18800a, this.f18808i, a1Var, this.f18805f);
        }
        if (this.f18803d) {
            this.f18809j.l();
        }
        if (this.f18808i.a() != null) {
            this.f18809j.i(this.f18808i.a());
        }
        if (this.f18808i.f() != null) {
            this.f18809j.e(this.f18808i.f().intValue());
        }
        if (this.f18808i.g() != null) {
            this.f18809j.f(this.f18808i.g().intValue());
        }
        if (uVarU != null) {
            this.f18809j.o(uVarU);
        }
        this.f18809j.b(oVarB);
        boolean z10 = this.f18816q;
        if (z10) {
            this.f18809j.p(z10);
        }
        this.f18809j.h(this.f18817r);
        this.f18804e.b();
        this.f18809j.g(new d(aVar));
        this.f18805f.a(this.f18814o, p6.f.a());
        if (uVarU != null && !uVarU.equals(this.f18805f.g()) && this.f18815p != null) {
            this.f18806g = F(uVarU);
        }
        if (this.f18810k) {
            A();
        }
    }

    @Override // vb.g
    public void a(String str, Throwable th) {
        fc.e eVarH = fc.c.h("ClientCall.cancel");
        try {
            fc.c.a(this.f18801b);
            s(str, th);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th2) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // vb.g
    public void b() {
        fc.e eVarH = fc.c.h("ClientCall.halfClose");
        try {
            fc.c.a(this.f18801b);
            v();
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // vb.g
    public void c(int i10) {
        fc.e eVarH = fc.c.h("ClientCall.request");
        try {
            fc.c.a(this.f18801b);
            boolean z10 = true;
            j6.m.v(this.f18809j != null, "Not started");
            if (i10 < 0) {
                z10 = false;
            }
            j6.m.e(z10, "Number requested must be non-negative");
            this.f18809j.d(i10);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // vb.g
    public void d(ReqT reqt) {
        fc.e eVarH = fc.c.h("ClientCall.sendMessage");
        try {
            fc.c.a(this.f18801b);
            B(reqt);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // vb.g
    public void e(vb.g.a<RespT> aVar, vb.a1 a1Var) {
        fc.e eVarH = fc.c.h("ClientCall.start");
        try {
            fc.c.a(this.f18801b);
            G(aVar, a1Var);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void r() {
        j1.b bVar = (j1.b) this.f18808i.h(j1.b.f18661g);
        if (bVar == null) {
            return;
        }
        Long l10 = bVar.f18662a;
        if (l10 != null) {
            vb.u uVarD = vb.u.d(l10.longValue(), TimeUnit.NANOSECONDS);
            vb.u uVarD2 = this.f18808i.d();
            if (uVarD2 == null || uVarD.compareTo(uVarD2) < 0) {
                this.f18808i = this.f18808i.m(uVarD);
            }
        }
        Boolean bool = bVar.f18663b;
        if (bool != null) {
            this.f18808i = bool.booleanValue() ? this.f18808i.s() : this.f18808i.t();
        }
        if (bVar.f18664c != null) {
            Integer numF = this.f18808i.f();
            this.f18808i = numF != null ? this.f18808i.o(Math.min(numF.intValue(), bVar.f18664c.intValue())) : this.f18808i.o(bVar.f18664c.intValue());
        }
        if (bVar.f18665d != null) {
            Integer numG = this.f18808i.g();
            this.f18808i = numG != null ? this.f18808i.p(Math.min(numG.intValue(), bVar.f18665d.intValue())) : this.f18808i.p(bVar.f18665d.intValue());
        }
    }

    public final void s(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f18797t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f18811l) {
            return;
        }
        this.f18811l = true;
        try {
            if (this.f18809j != null) {
                vb.l1 l1Var = vb.l1.f17406f;
                if (str == null) {
                    str = "Call cancelled without message";
                }
                vb.l1 l1VarQ = l1Var.q(str);
                if (th != null) {
                    l1VarQ = l1VarQ.p(th);
                }
                this.f18809j.a(l1VarQ);
            }
        } finally {
            A();
        }
    }

    public final void t(vb.g.a<RespT> aVar, vb.l1 l1Var, vb.a1 a1Var) {
        aVar.a(l1Var, a1Var);
    }

    public String toString() {
        return j6.g.b(this).d("method", this.f18800a).toString();
    }

    public final vb.u u() {
        return y(this.f18808i.d(), this.f18805f.g());
    }

    public final void v() {
        j6.m.v(this.f18809j != null, "Not started");
        j6.m.v(!this.f18811l, "call was cancelled");
        j6.m.v(!this.f18812m, "call already half-closed");
        this.f18812m = true;
        this.f18809j.j();
    }
}
