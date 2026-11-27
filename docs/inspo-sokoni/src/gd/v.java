package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends a2 implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f9264e;

    public v(w wVar) {
        this.f9264e = wVar;
    }

    @Override // gd.u
    public y1 getParent() {
        return u();
    }

    @Override // gd.u
    public boolean h(Throwable th) {
        return u().N(th);
    }

    @Override // xc.l
    public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
        t(th);
        return lc.q.f12711a;
    }

    @Override // gd.e0
    public void t(Throwable th) {
        this.f9264e.z(u());
    }
}
