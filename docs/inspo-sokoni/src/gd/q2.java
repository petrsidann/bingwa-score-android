package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 extends f2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oc.e<lc.q> f9252e;

    /* JADX WARN: Multi-variable type inference failed */
    public q2(oc.e<? super lc.q> eVar) {
        this.f9252e = eVar;
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        t(th);
        return lc.q.f12711a;
    }

    @Override // gd.e0
    public void t(Throwable th) {
        oc.e<lc.q> eVar = this.f9252e;
        lc.j.a aVar = lc.j.f12703b;
        eVar.resumeWith(lc.j.b(lc.q.f12711a));
    }
}
