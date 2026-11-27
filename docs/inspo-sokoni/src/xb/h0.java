package xb;

/* JADX INFO: loaded from: classes2.dex */
public class h0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.l1 f18602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.a f18603b;

    public h0(vb.l1 l1Var, s.a aVar) {
        j6.m.e(!l1Var.o(), "error must not be OK");
        this.f18602a = l1Var;
        this.f18603b = aVar;
    }

    @Override // vb.r0
    public vb.l0 g() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // xb.t
    public r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
        return new g0(this.f18602a, this.f18603b, kVarArr);
    }
}
