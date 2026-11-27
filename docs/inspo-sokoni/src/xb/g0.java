package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb.l1 f18464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s.a f18465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vb.k[] f18466e;

    public g0(vb.l1 l1Var, s.a aVar, vb.k[] kVarArr) {
        j6.m.e(!l1Var.o(), "error must not be OK");
        this.f18464c = l1Var;
        this.f18465d = aVar;
        this.f18466e = kVarArr;
    }

    public g0(vb.l1 l1Var, vb.k[] kVarArr) {
        this(l1Var, s.a.PROCESSED, kVarArr);
    }

    @Override // xb.o1, xb.r
    public void g(s sVar) {
        j6.m.v(!this.f18463b, "already started");
        this.f18463b = true;
        for (vb.k kVar : this.f18466e) {
            kVar.i(this.f18464c);
        }
        sVar.c(this.f18464c, this.f18465d, new vb.a1());
    }

    @Override // xb.o1, xb.r
    public void n(x0 x0Var) {
        x0Var.b("error", this.f18464c).b("progress", this.f18465d);
    }
}
