package xb;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 extends vb.c1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f18633d;

    public h2(boolean z10, int i10, int i11, i iVar) {
        this.f18630a = z10;
        this.f18631b = i10;
        this.f18632c = i11;
        this.f18633d = (i) j6.m.p(iVar, "autoLoadBalancerFactory");
    }

    @Override // vb.c1.h
    public vb.c1.c a(Map<String, ?> map) {
        Object objC;
        try {
            vb.c1.c cVarF = this.f18633d.f(map);
            if (cVarF == null) {
                objC = null;
            } else {
                if (cVarF.d() != null) {
                    return vb.c1.c.b(cVarF.d());
                }
                objC = cVarF.c();
            }
            return vb.c1.c.a(j1.b(map, this.f18630a, this.f18631b, this.f18632c, objC));
        } catch (RuntimeException e10) {
            return vb.c1.c.b(vb.l1.f17407g.q("failed to parse service config").p(e10));
        }
    }
}
