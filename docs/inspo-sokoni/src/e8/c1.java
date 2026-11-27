package e8;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f7124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.b f7125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b8.r<y1> f7126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7127d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z0 f7128e = z0.UNKNOWN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y1 f7129f;

    public c1(b1 b1Var, o.b bVar, b8.r<y1> rVar) {
        this.f7124a = b1Var;
        this.f7126c = rVar;
        this.f7125b = bVar;
    }

    public b1 a() {
        return this.f7124a;
    }

    public boolean b() {
        o.b bVar = this.f7125b;
        if (bVar != null) {
            return !bVar.f7250d.equals(b8.s0.CACHE);
        }
        return true;
    }

    public void c(com.google.firebase.firestore.f fVar) {
        this.f7126c.a(null, fVar);
    }

    public boolean d(z0 z0Var) {
        this.f7128e = z0Var;
        y1 y1Var = this.f7129f;
        if (y1Var == null || this.f7127d || !h(y1Var, z0Var)) {
            return false;
        }
        f(this.f7129f);
        return true;
    }

    public boolean e(y1 y1Var) {
        boolean z10 = false;
        l8.b.d(!y1Var.d().isEmpty() || y1Var.a(), "We got a new snapshot with no changes?", new Object[0]);
        if (!this.f7125b.f7247a) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : y1Var.d()) {
                if (mVar.c() != m.a.METADATA) {
                    arrayList.add(mVar);
                }
            }
            y1Var = new y1(y1Var.h(), y1Var.e(), y1Var.g(), arrayList, y1Var.k(), y1Var.f(), y1Var.a(), true, y1Var.i());
        }
        if (this.f7127d) {
            if (g(y1Var)) {
                this.f7126c.a(y1Var, null);
                z10 = true;
            }
        } else if (h(y1Var, this.f7128e)) {
            f(y1Var);
            z10 = true;
        }
        this.f7129f = y1Var;
        return z10;
    }

    public final void f(y1 y1Var) {
        l8.b.d(!this.f7127d, "Trying to raise initial event for second time", new Object[0]);
        y1 y1VarC = y1.c(y1Var.h(), y1Var.e(), y1Var.f(), y1Var.k(), y1Var.b(), y1Var.i());
        this.f7127d = true;
        this.f7126c.a(y1VarC, null);
    }

    public final boolean g(y1 y1Var) {
        if (!y1Var.d().isEmpty()) {
            return true;
        }
        y1 y1Var2 = this.f7129f;
        boolean z10 = (y1Var2 == null || y1Var2.j() == y1Var.j()) ? false : true;
        if (y1Var.a() || z10) {
            return this.f7125b.f7248b;
        }
        return false;
    }

    public final boolean h(y1 y1Var, z0 z0Var) {
        l8.b.d(!this.f7127d, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!y1Var.k() || !b()) {
            return true;
        }
        z0 z0Var2 = z0.OFFLINE;
        boolean z10 = !z0Var.equals(z0Var2);
        if (!this.f7125b.f7249c || !z10) {
            return !y1Var.e().isEmpty() || y1Var.i() || z0Var.equals(z0Var2);
        }
        l8.b.d(y1Var.k(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
        return false;
    }
}
