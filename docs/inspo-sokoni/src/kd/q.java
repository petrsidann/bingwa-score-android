package kd;

import id.u;

/* JADX INFO: loaded from: classes2.dex */
public final class q<T> implements jd.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u<T> f12353a;

    /* JADX WARN: Multi-variable type inference failed */
    public q(u<? super T> uVar) {
        this.f12353a = uVar;
    }

    @Override // jd.e
    public Object b(T t10, oc.e<? super lc.q> eVar) {
        Object objD = this.f12353a.d(t10, eVar);
        return objD == pc.c.c() ? objD : lc.q.f12711a;
    }
}
