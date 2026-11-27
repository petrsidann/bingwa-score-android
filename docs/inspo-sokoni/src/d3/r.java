package d3;

/* JADX INFO: loaded from: classes.dex */
public final class r<T> implements a3.h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3.c f6356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3.g<T, byte[]> f6357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f6358e;

    public r(o oVar, String str, a3.c cVar, a3.g<T, byte[]> gVar, s sVar) {
        this.f6354a = oVar;
        this.f6355b = str;
        this.f6356c = cVar;
        this.f6357d = gVar;
        this.f6358e = sVar;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // a3.h
    public void a(a3.d<T> dVar) {
        d(dVar, new a3.j() { // from class: d3.q
            @Override // a3.j
            public final void a(Exception exc) {
                r.c(exc);
            }
        });
    }

    public void d(a3.d<T> dVar, a3.j jVar) {
        this.f6358e.a(n.a().e(this.f6354a).c(dVar).f(this.f6355b).d(this.f6357d).b(this.f6356c).a(), jVar);
    }
}
