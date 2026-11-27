package gd;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f9173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f9174e;

    public g(oc.i iVar, Thread thread, i1 i1Var) {
        super(iVar, true, true);
        this.f9173d = thread;
        this.f9174e = i1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T Q0() throws Throwable {
        c.a();
        try {
            i1 i1Var = this.f9174e;
            if (i1Var != null) {
                i1.l0(i1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    i1 i1Var2 = this.f9174e;
                    long jO0 = i1Var2 != null ? i1Var2.o0() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        i1 i1Var3 = this.f9174e;
                        if (i1Var3 != null) {
                            i1.g0(i1Var3, false, 1, null);
                        }
                        c.a();
                        T t10 = (T) h2.h(d0());
                        c0 c0Var = t10 instanceof c0 ? (c0) t10 : null;
                        if (c0Var == null) {
                            return t10;
                        }
                        throw c0Var.f9143a;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jO0);
                } catch (Throwable th) {
                    i1 i1Var4 = this.f9174e;
                    if (i1Var4 != null) {
                        i1.g0(i1Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            D(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }

    @Override // gd.g2
    public boolean h0() {
        return true;
    }

    @Override // gd.g2
    public void x(Object obj) {
        if (kotlin.jvm.internal.k.a(Thread.currentThread(), this.f9173d)) {
            return;
        }
        Thread thread = this.f9173d;
        c.a();
        LockSupport.unpark(thread);
    }
}
