package gd;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k1 extends i1 {
    public abstract Thread r0();

    public void s0(long j10, j1.c cVar) {
        r0.f9253n.C0(j10, cVar);
    }

    public final void t0() {
        Thread threadR0 = r0();
        if (Thread.currentThread() != threadR0) {
            c.a();
            LockSupport.unpark(threadR0);
        }
    }
}
