package gd;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i1 extends j0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public mc.g<z0<?>> f9216e;

    public static /* synthetic */ void g0(i1 i1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        i1Var.f0(z10);
    }

    public static /* synthetic */ void l0(i1 i1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        i1Var.k0(z10);
    }

    public final void f0(boolean z10) {
        long jH0 = this.f9214c - h0(z10);
        this.f9214c = jH0;
        if (jH0 <= 0 && this.f9215d) {
            shutdown();
        }
    }

    public final long h0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public final void i0(z0<?> z0Var) {
        mc.g<z0<?>> gVar = this.f9216e;
        if (gVar == null) {
            gVar = new mc.g<>();
            this.f9216e = gVar;
        }
        gVar.addLast(z0Var);
    }

    public long j0() {
        mc.g<z0<?>> gVar = this.f9216e;
        return (gVar == null || gVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void k0(boolean z10) {
        this.f9214c += h0(z10);
        if (z10) {
            return;
        }
        this.f9215d = true;
    }

    public final boolean m0() {
        return this.f9214c >= h0(true);
    }

    public final boolean n0() {
        mc.g<z0<?>> gVar = this.f9216e;
        if (gVar != null) {
            return gVar.isEmpty();
        }
        return true;
    }

    public long o0() {
        return !p0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean p0() throws IllegalAccessException, InvocationTargetException {
        z0<?> z0VarT;
        mc.g<z0<?>> gVar = this.f9216e;
        if (gVar == null || (z0VarT = gVar.t()) == null) {
            return false;
        }
        z0VarT.run();
        return true;
    }

    public boolean q0() {
        return false;
    }

    public void shutdown() {
    }
}
