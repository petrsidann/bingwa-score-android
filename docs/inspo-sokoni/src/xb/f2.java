package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class f2 extends n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vb.a.c<b> f18450e = vb.a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.c1 f18451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e2 f18452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.p1 f18453d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f2.this.b();
        }
    }

    public class b {
        public b() {
        }

        public void a(vb.l1 l1Var) {
            if (l1Var.o()) {
                f2.this.f18452c.reset();
            } else {
                f2.this.f18452c.a(f2.this.new a());
            }
        }
    }

    public class c extends vb.c1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.c1.e f18456a;

        public c(vb.c1.e eVar) {
            this.f18456a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            f2.this.f18452c.a(f2.this.new a());
        }

        @Override // vb.c1.e, vb.c1.f
        public void b(vb.l1 l1Var) {
            this.f18456a.b(l1Var);
            f2.this.f18453d.execute(new Runnable() { // from class: xb.g2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18600a.e();
                }
            });
        }

        @Override // vb.c1.e
        public void c(vb.c1.g gVar) {
            vb.a aVarB = gVar.b();
            vb.a.c<b> cVar = f2.f18450e;
            if (aVarB.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f18456a.c(gVar.e().c(gVar.b().d().d(cVar, f2.this.new b()).a()).a());
        }
    }

    public f2(vb.c1 c1Var, e2 e2Var, vb.p1 p1Var) {
        super(c1Var);
        this.f18451b = c1Var;
        this.f18452c = e2Var;
        this.f18453d = p1Var;
    }

    @Override // xb.n0, vb.c1
    public void c() {
        super.c();
        this.f18452c.reset();
    }

    @Override // xb.n0, vb.c1
    public void d(vb.c1.e eVar) {
        super.d(new c(eVar));
    }
}
