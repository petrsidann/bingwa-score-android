package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class p2<T> extends f2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p<T> f9250e;

    /* JADX WARN: Multi-variable type inference failed */
    public p2(p<? super T> pVar) {
        this.f9250e = pVar;
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        t(th);
        return lc.q.f12711a;
    }

    @Override // gd.e0
    public void t(Throwable th) {
        p<T> pVar;
        Object objH;
        Object objD0 = u().d0();
        if (objD0 instanceof c0) {
            pVar = this.f9250e;
            lc.j.a aVar = lc.j.f12703b;
            objH = lc.k.a(((c0) objD0).f9143a);
        } else {
            pVar = this.f9250e;
            lc.j.a aVar2 = lc.j.f12703b;
            objH = h2.h(objD0);
        }
        pVar.resumeWith(lc.j.b(objH));
    }
}
