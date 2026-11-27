package kd;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements oc.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f12337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oc.i f12338b;

    public i(Throwable th, oc.i iVar) {
        this.f12337a = th;
        this.f12338b = iVar;
    }

    @Override // oc.i
    public <R> R fold(R r10, xc.p<? super R, ? super oc.i.b, ? extends R> pVar) {
        return (R) this.f12338b.fold(r10, pVar);
    }

    @Override // oc.i
    public <E extends oc.i.b> E get(oc.i.c<E> cVar) {
        return (E) this.f12338b.get(cVar);
    }

    @Override // oc.i
    public oc.i minusKey(oc.i.c<?> cVar) {
        return this.f12338b.minusKey(cVar);
    }

    @Override // oc.i
    public oc.i plus(oc.i iVar) {
        return this.f12338b.plus(iVar);
    }
}
