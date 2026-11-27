package gd;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 extends a2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9266f = AtomicIntegerFieldUpdater.newUpdater(w1.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xc.l<Throwable, lc.q> f9267e;

    /* JADX WARN: Multi-variable type inference failed */
    public w1(xc.l<? super Throwable, lc.q> lVar) {
        this.f9267e = lVar;
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        t(th);
        return lc.q.f12711a;
    }

    @Override // gd.e0
    public void t(Throwable th) {
        if (f9266f.compareAndSet(this, 0, 1)) {
            this.f9267e.invoke(th);
        }
    }
}
