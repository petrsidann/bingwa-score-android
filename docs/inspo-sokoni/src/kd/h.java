package kd;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends g<T, T> {
    public h(jd.d<? extends T> dVar, oc.i iVar, int i10, id.a aVar) {
        super(dVar, iVar, i10, aVar);
    }

    public /* synthetic */ h(jd.d dVar, oc.i iVar, int i10, id.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(dVar, (i11 & 2) != 0 ? oc.j.f13812a : iVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? id.a.SUSPEND : aVar);
    }

    @Override // kd.e
    public e<T> f(oc.i iVar, int i10, id.a aVar) {
        return new h(this.f12333d, iVar, i10, aVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kd.g
    public Object m(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
        Object objA = this.f12333d.a((jd.e<? super S>) eVar, eVar2);
        return objA == pc.c.c() ? objA : lc.q.f12711a;
    }
}
