package qc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends a {
    private final oc.i _context;
    private transient oc.e<Object> intercepted;

    public d(oc.e<Object> eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }

    public d(oc.e<Object> eVar, oc.i iVar) {
        super(eVar);
        this._context = iVar;
    }

    @Override // oc.e
    public oc.i getContext() {
        oc.i iVar = this._context;
        kotlin.jvm.internal.k.b(iVar);
        return iVar;
    }

    public final oc.e<Object> intercepted() {
        oc.e<Object> eVarT = this.intercepted;
        if (eVarT == null) {
            oc.f fVar = (oc.f) getContext().get(oc.f.f13810k);
            if (fVar == null || (eVarT = fVar.t(this)) == null) {
                eVarT = this;
            }
            this.intercepted = eVarT;
        }
        return eVarT;
    }

    @Override // qc.a
    public void releaseIntercepted() {
        oc.e<?> eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            oc.i.b bVar = getContext().get(oc.f.f13810k);
            kotlin.jvm.internal.k.b(bVar);
            ((oc.f) bVar).I(eVar);
        }
        this.intercepted = c.f14928a;
    }
}
