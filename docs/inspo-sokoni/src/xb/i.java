package xb;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.v0 f18634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18635b;

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.e f18636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vb.t0 f18637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vb.u0 f18638c;

        public b(vb.t0.e eVar) {
            this.f18636a = eVar;
            vb.u0 u0VarD = i.this.f18634a.d(i.this.f18635b);
            this.f18638c = u0VarD;
            if (u0VarD != null) {
                this.f18637b = u0VarD.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + i.this.f18635b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public vb.t0 a() {
            return this.f18637b;
        }

        public void b(vb.l1 l1Var) {
            a().c(l1Var);
        }

        public void c() {
            a().e();
        }

        public void d() {
            this.f18637b.f();
            this.f18637b = null;
        }

        public vb.l1 e(vb.t0.h hVar) {
            k2.b bVar = (k2.b) hVar.c();
            if (bVar == null) {
                try {
                    i iVar = i.this;
                    bVar = new k2.b(iVar.d(iVar.f18635b, "using default policy"), null);
                } catch (f e10) {
                    this.f18636a.f(vb.q.TRANSIENT_FAILURE, new d(vb.l1.f17419s.q(e10.getMessage())));
                    this.f18637b.f();
                    this.f18638c = null;
                    this.f18637b = new e();
                    return vb.l1.f17405e;
                }
            }
            if (this.f18638c == null || !bVar.f18678a.b().equals(this.f18638c.b())) {
                this.f18636a.f(vb.q.CONNECTING, new c());
                this.f18637b.f();
                vb.u0 u0Var = bVar.f18678a;
                this.f18638c = u0Var;
                vb.t0 t0Var = this.f18637b;
                this.f18637b = u0Var.a(this.f18636a);
                this.f18636a.b().b(vb.f.a.INFO, "Load balancer changed from {0} to {1}", t0Var.getClass().getSimpleName(), this.f18637b.getClass().getSimpleName());
            }
            Object obj = bVar.f18679b;
            if (obj != null) {
                this.f18636a.b().b(vb.f.a.DEBUG, "Load-balancing config: {0}", bVar.f18679b);
            }
            return a().a(vb.t0.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }
    }

    public static final class c extends vb.t0.j {
        public c() {
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            return vb.t0.f.g();
        }

        public String toString() {
            return j6.g.a(c.class).toString();
        }
    }

    public static final class d extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.l1 f18640a;

        public d(vb.l1 l1Var) {
            this.f18640a = l1Var;
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            return vb.t0.f.f(this.f18640a);
        }
    }

    public static final class e extends vb.t0 {
        public e() {
        }

        @Override // vb.t0
        public vb.l1 a(vb.t0.h hVar) {
            return vb.l1.f17405e;
        }

        @Override // vb.t0
        public void c(vb.l1 l1Var) {
        }

        @Override // vb.t0
        @Deprecated
        public void d(vb.t0.h hVar) {
        }

        @Override // vb.t0
        public void f() {
        }
    }

    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public i(String str) {
        this(vb.v0.b(), str);
    }

    public i(vb.v0 v0Var, String str) {
        this.f18634a = (vb.v0) j6.m.p(v0Var, "registry");
        this.f18635b = (String) j6.m.p(str, "defaultPolicy");
    }

    public final vb.u0 d(String str, String str2) throws f {
        vb.u0 u0VarD = this.f18634a.d(str);
        if (u0VarD != null) {
            return u0VarD;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(vb.t0.e eVar) {
        return new b(eVar);
    }

    public vb.c1.c f(Map<String, ?> map) {
        List<k2.a> listA;
        if (map != null) {
            try {
                listA = k2.A(k2.g(map));
            } catch (RuntimeException e10) {
                return vb.c1.c.b(vb.l1.f17407g.q("can't parse load balancer configuration").p(e10));
            }
        } else {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return k2.y(listA, this.f18634a);
    }
}
