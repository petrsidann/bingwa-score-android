package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class c3 implements oc.i.b, oc.i.c<c3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c3 f9148a = new c3();

    @Override // oc.i.b, oc.i
    public <R> R fold(R r10, xc.p<? super R, ? super oc.i.b, ? extends R> pVar) {
        return (R) oc.i.b.a.a(this, r10, pVar);
    }

    @Override // oc.i.b, oc.i
    public <E extends oc.i.b> E get(oc.i.c<E> cVar) {
        return (E) oc.i.b.a.b(this, cVar);
    }

    @Override // oc.i.b
    public oc.i.c<?> getKey() {
        return this;
    }

    @Override // oc.i.b, oc.i
    public oc.i minusKey(oc.i.c<?> cVar) {
        return oc.i.b.a.c(this, cVar);
    }

    @Override // oc.i
    public oc.i plus(oc.i iVar) {
        return oc.i.b.a.d(this, iVar);
    }
}
