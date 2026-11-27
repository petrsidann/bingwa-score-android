package ld;

/* JADX INFO: loaded from: classes2.dex */
public class d0<T> extends gd.a<T> implements qc.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oc.e<T> f12717d;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(oc.i iVar, oc.e<? super T> eVar) {
        super(iVar, true, true);
        this.f12717d = eVar;
    }

    @Override // gd.a
    public void M0(Object obj) {
        oc.e<T> eVar = this.f12717d;
        eVar.resumeWith(gd.g0.a(obj, eVar));
    }

    @Override // qc.e
    public final qc.e getCallerFrame() {
        oc.e<T> eVar = this.f12717d;
        if (eVar instanceof qc.e) {
            return (qc.e) eVar;
        }
        return null;
    }

    @Override // gd.g2
    public final boolean h0() {
        return true;
    }

    @Override // gd.g2
    public void x(Object obj) {
        k.c(pc.b.b(this.f12717d), gd.g0.a(obj, this.f12717d), null, 2, null);
    }
}
