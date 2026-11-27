package jd;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends kd.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xc.p<id.r<? super T>, oc.e<? super lc.q>, Object> f11356d;

    /* JADX WARN: Multi-variable type inference failed */
    public c(xc.p<? super id.r<? super T>, ? super oc.e<? super lc.q>, ? extends Object> pVar, oc.i iVar, int i10, id.a aVar) {
        super(iVar, i10, aVar);
        this.f11356d = pVar;
    }

    public static /* synthetic */ <T> Object j(c<T> cVar, id.r<? super T> rVar, oc.e<? super lc.q> eVar) {
        Object objInvoke = cVar.f11356d.invoke(rVar, eVar);
        return objInvoke == pc.c.c() ? objInvoke : lc.q.f12711a;
    }

    @Override // kd.e
    public Object e(id.r<? super T> rVar, oc.e<? super lc.q> eVar) {
        return j(this, rVar, eVar);
    }

    @Override // kd.e
    public String toString() {
        return "block[" + this.f11356d + "] -> " + super.toString();
    }
}
