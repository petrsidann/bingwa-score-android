package r6;

import e7.a0;
import e7.c0;
import e7.i0;
import e7.z;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0.b f15048a;

    public n(c0.b bVar) {
        this.f15048a = bVar;
    }

    public static n i() {
        return new n(c0.V());
    }

    public static n j(m mVar) {
        return new n(mVar.f().b());
    }

    public synchronized n a(k kVar) {
        b(kVar.b(), false);
        return this;
    }

    @Deprecated
    public synchronized int b(a0 a0Var, boolean z10) {
        c0.c cVarF;
        cVarF = f(a0Var);
        this.f15048a.x(cVarF);
        if (z10) {
            this.f15048a.C(cVarF.S());
        }
        return cVarF.S();
    }

    public final synchronized c0.c c(e7.y yVar, i0 i0Var) {
        int iG;
        iG = g();
        if (i0Var == i0.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return c0.c.W().x(yVar).y(iG).A(z.ENABLED).z(i0Var).build();
    }

    public synchronized m d() {
        return m.e(this.f15048a.build());
    }

    public final synchronized boolean e(int i10) {
        Iterator<c0.c> it = this.f15048a.A().iterator();
        while (it.hasNext()) {
            if (it.next().S() == i10) {
                return true;
            }
        }
        return false;
    }

    public final synchronized c0.c f(a0 a0Var) {
        return c(w.j(a0Var), a0Var.R());
    }

    public final synchronized int g() {
        int iB;
        do {
            iB = z6.q.b();
        } while (e(iB));
        return iB;
    }

    public synchronized n h(int i10) {
        for (int i11 = 0; i11 < this.f15048a.z(); i11++) {
            c0.c cVarY = this.f15048a.y(i11);
            if (cVarY.S() == i10) {
                if (!cVarY.U().equals(z.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i10);
                }
                this.f15048a.C(i10);
            }
        }
        throw new GeneralSecurityException("key not found: " + i10);
        return this;
    }
}
