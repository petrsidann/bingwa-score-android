package nd;

import gd.o1;

/* JADX INFO: loaded from: classes2.dex */
public class f extends o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13576f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f13577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f13578m = f0();

    public f(int i10, int i11, long j10, String str) {
        this.f13574d = i10;
        this.f13575e = i11;
        this.f13576f = j10;
        this.f13577l = str;
    }

    @Override // gd.j0
    public void c0(oc.i iVar, Runnable runnable) {
        a.C(this.f13578m, runnable, null, false, 6, null);
    }

    public final a f0() {
        return new a(this.f13574d, this.f13575e, this.f13576f, this.f13577l);
    }

    public final void g0(Runnable runnable, i iVar, boolean z10) {
        this.f13578m.B(runnable, iVar, z10);
    }
}
