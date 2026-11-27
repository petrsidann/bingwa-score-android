package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends vb.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f18767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.b1<?, ?> f18768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb.a1 f18769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.c f18770d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f18772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vb.k[] f18773g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f18775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c0 f18777k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f18774h = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vb.s f18771e = vb.s.e();

    public interface a {
        void a();
    }

    public n1(t tVar, vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, a aVar, vb.k[] kVarArr) {
        this.f18767a = tVar;
        this.f18768b = b1Var;
        this.f18769c = a1Var;
        this.f18770d = cVar;
        this.f18772f = aVar;
        this.f18773g = kVarArr;
    }

    @Override // vb.b.a
    public void a(vb.a1 a1Var) {
        j6.m.v(!this.f18776j, "apply() or fail() already called");
        j6.m.p(a1Var, "headers");
        this.f18769c.m(a1Var);
        vb.s sVarB = this.f18771e.b();
        try {
            r rVarH = this.f18767a.h(this.f18768b, this.f18769c, this.f18770d, this.f18773g);
            this.f18771e.f(sVarB);
            c(rVarH);
        } catch (Throwable th) {
            this.f18771e.f(sVarB);
            throw th;
        }
    }

    @Override // vb.b.a
    public void b(vb.l1 l1Var) {
        j6.m.e(!l1Var.o(), "Cannot fail with OK status");
        j6.m.v(!this.f18776j, "apply() or fail() already called");
        c(new g0(r0.o(l1Var), this.f18773g));
    }

    public final void c(r rVar) {
        boolean z10;
        j6.m.v(!this.f18776j, "already finalized");
        this.f18776j = true;
        synchronized (this.f18774h) {
            if (this.f18775i == null) {
                this.f18775i = rVar;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (!z10) {
            j6.m.v(this.f18777k != null, "delayedStream is null");
            Runnable runnableW = this.f18777k.w(rVar);
            if (runnableW != null) {
                runnableW.run();
            }
        }
        this.f18772f.a();
    }

    public r d() {
        synchronized (this.f18774h) {
            r rVar = this.f18775i;
            if (rVar != null) {
                return rVar;
            }
            c0 c0Var = new c0();
            this.f18777k = c0Var;
            this.f18775i = c0Var;
            return c0Var;
        }
    }
}
