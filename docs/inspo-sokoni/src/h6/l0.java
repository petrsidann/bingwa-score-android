package h6;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends h0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f f9679l;

    public l0(f fVar) {
        this.f9679l = fVar;
    }

    @Override // h6.h0
    public final void b() {
        synchronized (this.f9679l.f9658f) {
            if (this.f9679l.f9664l.get() > 0 && this.f9679l.f9664l.decrementAndGet() > 0) {
                this.f9679l.f9654b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            f fVar = this.f9679l;
            if (fVar.f9666n != null) {
                fVar.f9654b.d("Unbind from service.", new Object[0]);
                f fVar2 = this.f9679l;
                fVar2.f9653a.unbindService(fVar2.f9665m);
                this.f9679l.f9659g = false;
                this.f9679l.f9666n = null;
                this.f9679l.f9665m = null;
            }
            this.f9679l.x();
        }
    }
}
