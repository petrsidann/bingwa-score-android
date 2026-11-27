package xb;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class o2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o2 f18785c = new o2(new vb.o1[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.o1[] f18786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f18787b = new AtomicBoolean(false);

    public o2(vb.o1[] o1VarArr) {
        this.f18786a = o1VarArr;
    }

    public static o2 h(vb.k[] kVarArr, vb.a aVar, vb.a1 a1Var) {
        o2 o2Var = new o2(kVarArr);
        for (vb.k kVar : kVarArr) {
            kVar.n(aVar, a1Var);
        }
        return o2Var;
    }

    public void a() {
        for (vb.o1 o1Var : this.f18786a) {
            ((vb.k) o1Var).k();
        }
    }

    public void b(vb.a1 a1Var) {
        for (vb.o1 o1Var : this.f18786a) {
            ((vb.k) o1Var).l(a1Var);
        }
    }

    public void c() {
        for (vb.o1 o1Var : this.f18786a) {
            ((vb.k) o1Var).m();
        }
    }

    public void d(int i10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.a(i10);
        }
    }

    public void e(int i10, long j10, long j11) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.b(i10, j10, j11);
        }
    }

    public void f(long j10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.c(j10);
        }
    }

    public void g(long j10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.d(j10);
        }
    }

    public void i(int i10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.e(i10);
        }
    }

    public void j(int i10, long j10, long j11) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.f(i10, j10, j11);
        }
    }

    public void k(long j10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.g(j10);
        }
    }

    public void l(long j10) {
        for (vb.o1 o1Var : this.f18786a) {
            o1Var.h(j10);
        }
    }

    public void m(vb.l1 l1Var) {
        if (this.f18787b.compareAndSet(false, true)) {
            for (vb.o1 o1Var : this.f18786a) {
                o1Var.i(l1Var);
            }
        }
    }
}
