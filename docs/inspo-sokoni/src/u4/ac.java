package u4;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ac extends k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f15991a;

    public ac(qb qbVar, AtomicReference atomicReference) {
        this.f15991a = atomicReference;
    }

    @Override // u4.h5
    public final void zza(List<sd> list) {
        synchronized (this.f15991a) {
            this.f15991a.set(list);
            this.f15991a.notifyAll();
        }
    }
}
