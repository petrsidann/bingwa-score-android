package kd;

/* JADX INFO: loaded from: classes2.dex */
public final class r<T> implements oc.e<T>, qc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.e<T> f12354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oc.i f12355b;

    /* JADX WARN: Multi-variable type inference failed */
    public r(oc.e<? super T> eVar, oc.i iVar) {
        this.f12354a = eVar;
        this.f12355b = iVar;
    }

    @Override // qc.e
    public qc.e getCallerFrame() {
        oc.e<T> eVar = this.f12354a;
        if (eVar instanceof qc.e) {
            return (qc.e) eVar;
        }
        return null;
    }

    @Override // oc.e
    public oc.i getContext() {
        return this.f12355b;
    }

    @Override // oc.e
    public void resumeWith(Object obj) {
        this.f12354a.resumeWith(obj);
    }
}
