package ec;

import vb.l1;
import vb.t0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends t0 {
    @Override // vb.t0
    public boolean b() {
        return g().b();
    }

    @Override // vb.t0
    public void c(l1 l1Var) {
        g().c(l1Var);
    }

    @Override // vb.t0
    public void d(t0.h hVar) {
        g().d(hVar);
    }

    @Override // vb.t0
    public void e() {
        g().e();
    }

    public abstract t0 g();

    public String toString() {
        return j6.g.b(this).d("delegate", g()).toString();
    }
}
