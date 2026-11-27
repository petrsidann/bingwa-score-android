package xb;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements p2 {

    public static abstract class a implements e.h, l1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z f18186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18187b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o2 f18188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final u2 f18189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l1 f18190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f18192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f18193h;

        /* JADX INFO: renamed from: xb.c$a$a, reason: collision with other inner class name */
        public class RunnableC0326a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fc.b f18194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f18195b;

            public RunnableC0326a(fc.b bVar, int i10) {
                this.f18194a = bVar;
                this.f18195b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    fc.e eVarH = fc.c.h("AbstractStream.request");
                    try {
                        fc.c.e(this.f18194a);
                        a.this.f18186a.d(this.f18195b);
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
                } catch (Throwable th3) {
                    a.this.e(th3);
                }
            }
        }

        public a(int i10, o2 o2Var, u2 u2Var) {
            this.f18188c = (o2) j6.m.p(o2Var, "statsTraceCtx");
            this.f18189d = (u2) j6.m.p(u2Var, "transportTracer");
            l1 l1Var = new l1(this, vb.m.b.f17449a, i10, o2Var, u2Var);
            this.f18190e = l1Var;
            this.f18186a = l1Var;
        }

        @Override // xb.l1.b
        public void a(q2.a aVar) {
            o().a(aVar);
        }

        public final void b(int i10) {
            boolean z10;
            synchronized (this.f18187b) {
                j6.m.v(this.f18192g, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.f18191f;
                z10 = true;
                boolean z11 = i11 < 32768;
                int i12 = i11 - i10;
                this.f18191f = i12;
                boolean z12 = i12 < 32768;
                if (z11 || !z12) {
                    z10 = false;
                }
            }
            if (z10) {
                p();
            }
        }

        public final void k(boolean z10) {
            if (z10) {
                this.f18186a.close();
            } else {
                this.f18186a.k();
            }
        }

        public final void l(y1 y1Var) {
            try {
                this.f18186a.t(y1Var);
            } catch (Throwable th) {
                e(th);
            }
        }

        public u2 m() {
            return this.f18189d;
        }

        public final boolean n() {
            boolean z10;
            synchronized (this.f18187b) {
                z10 = this.f18192g && this.f18191f < 32768 && !this.f18193h;
            }
            return z10;
        }

        public abstract q2 o();

        public final void p() {
            boolean zN;
            synchronized (this.f18187b) {
                zN = n();
            }
            if (zN) {
                o().b();
            }
        }

        public final void q(int i10) {
            synchronized (this.f18187b) {
                this.f18191f += i10;
            }
        }

        public void r() {
            j6.m.u(o() != null);
            synchronized (this.f18187b) {
                j6.m.v(this.f18192g ? false : true, "Already allocated");
                this.f18192g = true;
            }
            p();
        }

        public final void s() {
            synchronized (this.f18187b) {
                this.f18193h = true;
            }
        }

        public final void t() {
            this.f18190e.O(this);
            this.f18186a = this.f18190e;
        }

        public final void u(int i10) {
            f(new RunnableC0326a(fc.c.f(), i10));
        }

        public final void v(vb.v vVar) {
            this.f18186a.v(vVar);
        }

        public void w(s0 s0Var) {
            this.f18190e.L(s0Var);
            this.f18186a = new e(this, this, this.f18190e);
        }

        public final void x(int i10) {
            this.f18186a.e(i10);
        }
    }

    @Override // xb.p2
    public final void b(vb.o oVar) {
        r().b((vb.o) j6.m.p(oVar, "compressor"));
    }

    @Override // xb.p2
    public boolean c() {
        return t().n();
    }

    @Override // xb.p2
    public final void d(int i10) {
        t().u(i10);
    }

    @Override // xb.p2
    public final void flush() {
        if (r().isClosed()) {
            return;
        }
        r().flush();
    }

    @Override // xb.p2
    public final void k(InputStream inputStream) {
        j6.m.p(inputStream, "message");
        try {
            if (!r().isClosed()) {
                r().c(inputStream);
            }
        } finally {
            r0.d(inputStream);
        }
    }

    @Override // xb.p2
    public void l() {
        t().t();
    }

    public final void q() {
        r().close();
    }

    public abstract p0 r();

    public final void s(int i10) {
        t().q(i10);
    }

    public abstract a t();
}
