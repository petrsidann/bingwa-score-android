package jd;

/* JADX INFO: loaded from: classes2.dex */
public final class o<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc.p<e<? super T>, oc.e<? super lc.q>, Object> f11378a;

    /* JADX WARN: Multi-variable type inference failed */
    public o(xc.p<? super e<? super T>, ? super oc.e<? super lc.q>, ? extends Object> pVar) {
        this.f11378a = pVar;
    }

    @Override // jd.a
    public Object b(e<? super T> eVar, oc.e<? super lc.q> eVar2) {
        Object objInvoke = this.f11378a.invoke(eVar, eVar2);
        return objInvoke == pc.c.c() ? objInvoke : lc.q.f12711a;
    }
}
