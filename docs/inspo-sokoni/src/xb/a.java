package xb;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends xb.c implements r, m1.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f18077g = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2 f18078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f18079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vb.a1 f18082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f18083f;

    /* JADX INFO: renamed from: xb.a$a, reason: collision with other inner class name */
    public class C0324a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.a1 f18084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o2 f18086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f18087d;

        public C0324a(vb.a1 a1Var, o2 o2Var) {
            this.f18084a = (vb.a1) j6.m.p(a1Var, "headers");
            this.f18086c = (o2) j6.m.p(o2Var, "statsTraceCtx");
        }

        @Override // xb.p0
        public p0 b(vb.o oVar) {
            return this;
        }

        @Override // xb.p0
        public void c(InputStream inputStream) {
            j6.m.v(this.f18087d == null, "writePayload should not be called multiple times");
            try {
                this.f18087d = l6.b.d(inputStream);
                this.f18086c.i(0);
                o2 o2Var = this.f18086c;
                byte[] bArr = this.f18087d;
                o2Var.j(0, bArr.length, bArr.length);
                this.f18086c.k(this.f18087d.length);
                this.f18086c.l(this.f18087d.length);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // xb.p0
        public void close() {
            this.f18085b = true;
            j6.m.v(this.f18087d != null, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().b(this.f18084a, this.f18087d);
            this.f18087d = null;
            this.f18084a = null;
        }

        @Override // xb.p0
        public void f(int i10) {
        }

        @Override // xb.p0
        public void flush() {
        }

        @Override // xb.p0
        public boolean isClosed() {
            return this.f18085b;
        }
    }

    public interface b {
        void a(vb.l1 l1Var);

        void b(vb.a1 a1Var, byte[] bArr);

        void c(v2 v2Var, boolean z10, boolean z11, int i10);
    }

    public static abstract class c extends xb.c.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final o2 f18089i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f18090j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public s f18091k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f18092l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public vb.w f18093m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f18094n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Runnable f18095o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile boolean f18096p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f18097q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f18098r;

        /* JADX INFO: renamed from: xb.a$c$a, reason: collision with other inner class name */
        public class RunnableC0325a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s.a f18100b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18101c;

            public RunnableC0325a(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
                this.f18099a = l1Var;
                this.f18100b = aVar;
                this.f18101c = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.C(this.f18099a, this.f18100b, this.f18101c);
            }
        }

        public c(int i10, o2 o2Var, u2 u2Var) {
            super(i10, o2Var, u2Var);
            this.f18093m = vb.w.c();
            this.f18094n = false;
            this.f18089i = (o2) j6.m.p(o2Var, "statsTraceCtx");
        }

        public final void C(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
            if (this.f18090j) {
                return;
            }
            this.f18090j = true;
            this.f18089i.m(l1Var);
            if (m() != null) {
                m().f(l1Var.o());
            }
            o().c(l1Var, aVar, a1Var);
        }

        public void D(y1 y1Var) throws Throwable {
            j6.m.p(y1Var, "frame");
            boolean z10 = true;
            try {
                if (this.f18097q) {
                    a.f18077g.log(Level.INFO, "Received data on closed stream");
                    y1Var.close();
                    return;
                } else {
                    try {
                        l(y1Var);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z10 = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (z10) {
                y1Var.close();
            }
            throw th;
        }

        public void E(vb.a1 a1Var) {
            boolean z10;
            j6.m.v(!this.f18097q, "Received headers on closed stream");
            this.f18089i.a();
            String str = (String) a1Var.g(r0.f18861g);
            if (!this.f18092l || str == null) {
                z10 = false;
            } else if (str.equalsIgnoreCase("gzip")) {
                w(new s0());
                z10 = true;
            } else {
                if (!str.equalsIgnoreCase("identity")) {
                    e(vb.l1.f17419s.q(String.format("Can't find full stream decompressor for %s", str)).d());
                    return;
                }
                z10 = false;
            }
            String str2 = (String) a1Var.g(r0.f18859e);
            if (str2 != null) {
                vb.v vVarE = this.f18093m.e(str2);
                if (vVarE == null) {
                    e(vb.l1.f17419s.q(String.format("Can't find decompressor for %s", str2)).d());
                    return;
                } else if (vVarE != vb.m.b.f17449a) {
                    if (z10) {
                        e(vb.l1.f17419s.q("Full stream and gRPC message encoding cannot both be set").d());
                        return;
                    }
                    v(vVarE);
                }
            }
            o().d(a1Var);
        }

        public void F(vb.a1 a1Var, vb.l1 l1Var) {
            j6.m.p(l1Var, "status");
            j6.m.p(a1Var, "trailers");
            if (this.f18097q) {
                a.f18077g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{l1Var, a1Var});
            } else {
                this.f18089i.b(a1Var);
                N(l1Var, false, a1Var);
            }
        }

        public final boolean G() {
            return this.f18096p;
        }

        @Override // xb.c.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public final s o() {
            return this.f18091k;
        }

        public final void I(vb.w wVar) {
            j6.m.v(this.f18091k == null, "Already called start");
            this.f18093m = (vb.w) j6.m.p(wVar, "decompressorRegistry");
        }

        public final void J(boolean z10) {
            this.f18092l = z10;
        }

        public final void K(s sVar) {
            j6.m.v(this.f18091k == null, "Already called setListener");
            this.f18091k = (s) j6.m.p(sVar, "listener");
        }

        public final void L() {
            this.f18096p = true;
        }

        public final void M(vb.l1 l1Var, s.a aVar, boolean z10, vb.a1 a1Var) {
            j6.m.p(l1Var, "status");
            j6.m.p(a1Var, "trailers");
            if (!this.f18097q || z10) {
                this.f18097q = true;
                this.f18098r = l1Var.o();
                s();
                if (this.f18094n) {
                    this.f18095o = null;
                    C(l1Var, aVar, a1Var);
                } else {
                    this.f18095o = new RunnableC0325a(l1Var, aVar, a1Var);
                    k(z10);
                }
            }
        }

        public final void N(vb.l1 l1Var, boolean z10, vb.a1 a1Var) {
            M(l1Var, s.a.PROCESSED, z10, a1Var);
        }

        @Override // xb.l1.b
        public void c(boolean z10) {
            j6.m.v(this.f18097q, "status should have been reported on deframer closed");
            this.f18094n = true;
            if (this.f18098r && z10) {
                N(vb.l1.f17419s.q("Encountered end-of-stream mid-frame"), true, new vb.a1());
            }
            Runnable runnable = this.f18095o;
            if (runnable != null) {
                runnable.run();
                this.f18095o = null;
            }
        }
    }

    public a(w2 w2Var, o2 o2Var, u2 u2Var, vb.a1 a1Var, vb.c cVar, boolean z10) {
        j6.m.p(a1Var, "headers");
        this.f18078a = (u2) j6.m.p(u2Var, "transportTracer");
        this.f18080c = r0.p(cVar);
        this.f18081d = z10;
        if (z10) {
            this.f18079b = new C0324a(a1Var, o2Var);
        } else {
            this.f18079b = new m1(this, w2Var, o2Var);
            this.f18082e = a1Var;
        }
    }

    @Override // xb.r
    public final void a(vb.l1 l1Var) {
        j6.m.e(!l1Var.o(), "Should not cancel with OK status");
        this.f18083f = true;
        u().a(l1Var);
    }

    @Override // xb.c, xb.p2
    public final boolean c() {
        return super.c() && !this.f18083f;
    }

    @Override // xb.r
    public void e(int i10) {
        t().x(i10);
    }

    @Override // xb.r
    public void f(int i10) {
        this.f18079b.f(i10);
    }

    @Override // xb.r
    public final void g(s sVar) {
        t().K(sVar);
        if (this.f18081d) {
            return;
        }
        u().b(this.f18082e, null);
        this.f18082e = null;
    }

    @Override // xb.r
    public final void h(vb.w wVar) {
        t().I(wVar);
    }

    @Override // xb.r
    public final void j() {
        if (t().G()) {
            return;
        }
        t().L();
        q();
    }

    @Override // xb.m1.d
    public final void m(v2 v2Var, boolean z10, boolean z11, int i10) {
        j6.m.e(v2Var != null || z10, "null frame before EOS");
        u().c(v2Var, z10, z11, i10);
    }

    @Override // xb.r
    public final void n(x0 x0Var) {
        x0Var.b("remote_addr", getAttributes().b(vb.d0.f17330a));
    }

    @Override // xb.r
    public void o(vb.u uVar) {
        vb.a1 a1Var = this.f18082e;
        vb.a1.g<Long> gVar = r0.f18858d;
        a1Var.e(gVar);
        this.f18082e.p(gVar, Long.valueOf(Math.max(0L, uVar.r(TimeUnit.NANOSECONDS))));
    }

    @Override // xb.r
    public final void p(boolean z10) {
        t().J(z10);
    }

    @Override // xb.c
    public final p0 r() {
        return this.f18079b;
    }

    public abstract b u();

    public u2 w() {
        return this.f18078a;
    }

    public final boolean x() {
        return this.f18080c;
    }

    @Override // xb.c
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public abstract c t();
}
