package qc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends a {
    public j(oc.e<Object> eVar) {
        super(eVar);
        if (eVar != null) {
            if (!(eVar.getContext() == oc.j.f13812a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // oc.e
    public oc.i getContext() {
        return oc.j.f13812a;
    }
}
