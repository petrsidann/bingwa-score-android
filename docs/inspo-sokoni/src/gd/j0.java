package gd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 extends oc.a implements oc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9218b = new a(null);

    public static final class a extends oc.b<oc.f, j0> {

        /* JADX INFO: renamed from: gd.j0$a$a, reason: collision with other inner class name */
        public static final class C0157a extends kotlin.jvm.internal.l implements xc.l<oc.i.b, j0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0157a f9219a = new C0157a();

            public C0157a() {
                super(1);
            }

            @Override // xc.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final j0 invoke(oc.i.b bVar) {
                if (bVar instanceof j0) {
                    return (j0) bVar;
                }
                return null;
            }
        }

        public a() {
            super(oc.f.f13810k, C0157a.f9219a);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public j0() {
        super(oc.f.f13810k);
    }

    @Override // oc.f
    public final void I(oc.e<?> eVar) {
        kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((ld.j) eVar).s();
    }

    public abstract void c0(oc.i iVar, Runnable runnable);

    public boolean d0(oc.i iVar) {
        return true;
    }

    public j0 e0(int i10) {
        ld.p.a(i10);
        return new ld.o(this, i10);
    }

    @Override // oc.a, oc.i.b, oc.i
    public <E extends oc.i.b> E get(oc.i.c<E> cVar) {
        return (E) oc.f.a.a(this, cVar);
    }

    @Override // oc.a, oc.i.b, oc.i
    public oc.i minusKey(oc.i.c<?> cVar) {
        return oc.f.a.b(this, cVar);
    }

    @Override // oc.f
    public final <T> oc.e<T> t(oc.e<? super T> eVar) {
        return new ld.j(this, eVar);
    }

    public String toString() {
        return q0.a(this) + '@' + q0.b(this);
    }
}
