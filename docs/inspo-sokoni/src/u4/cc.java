package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class cc extends l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16079a;

    public cc(qb qbVar, AtomicReference atomicReference) {
        this.f16079a = atomicReference;
    }

    @Override // u4.m5
    public final void w(de deVar) {
        synchronized (this.f16079a) {
            this.f16079a.set(deVar);
            this.f16079a.notifyAll();
        }
    }
}
