package z;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19702m;

    public g(m mVar) {
        super(mVar);
        this.f19685e = mVar instanceof j ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // z.f
    public void d(int i10) {
        if (this.f19690j) {
            return;
        }
        this.f19690j = true;
        this.f19687g = i10;
        for (d dVar : this.f19691k) {
            dVar.a(dVar);
        }
    }
}
