package e8;

import g8.l4;

/* JADX INFO: loaded from: classes.dex */
public class x0 extends j {

    public class b implements k8.s0.c {
        public b() {
        }

        @Override // k8.s0.c
        public void a(z0 z0Var) {
            x0.this.r().a(z0Var);
        }

        @Override // k8.s0.c
        public s7.e<h8.k> b(int i10) {
            return x0.this.r().b(i10);
        }

        @Override // k8.s0.c
        public void c(int i10, vb.l1 l1Var) {
            x0.this.r().c(i10, l1Var);
        }

        @Override // k8.s0.c
        public void d(k8.n0 n0Var) {
            x0.this.r().d(n0Var);
        }

        @Override // k8.s0.c
        public void e(int i10, vb.l1 l1Var) {
            x0.this.r().e(i10, l1Var);
        }

        @Override // k8.s0.c
        public void f(i8.h hVar) {
            x0.this.r().f(hVar);
        }
    }

    public x0(com.google.firebase.firestore.g gVar) {
        super(gVar);
    }

    @Override // e8.j
    public o a(j.a aVar) {
        return new o(r());
    }

    @Override // e8.j
    public l4 b(j.a aVar) {
        return null;
    }

    @Override // e8.j
    public g8.l c(j.a aVar) {
        return null;
    }

    @Override // e8.j
    public g8.k0 d(j.a aVar) {
        return new g8.k0(o(), new g8.j1(), aVar.f7196d);
    }

    @Override // e8.j
    public g8.h1 e(j.a aVar) {
        if (!t(this.f7184a)) {
            return g8.b1.o();
        }
        return g8.b1.p(g8.q0.b.a(this.f7184a.b()), new g8.p(p()));
    }

    @Override // e8.j
    public k8.s0 f(j.a aVar) {
        return new k8.s0(aVar.f7195c.a(), new b(), n(), j(), aVar.f7194b, i());
    }

    @Override // e8.j
    public f1 g(j.a aVar) {
        return new f1(n(), q(), aVar.f7196d, aVar.f7197e);
    }

    public final boolean t(com.google.firebase.firestore.g gVar) {
        if (gVar.a() == null || !(gVar.a() instanceof b8.y0)) {
            return false;
        }
        return ((b8.y0) gVar.a()).a() instanceof b8.b1;
    }
}
