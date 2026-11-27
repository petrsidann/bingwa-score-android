package jd;

import ld.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f11390a = new h0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f11391b = new h0("PENDING");

    public static final <T> n<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) kd.m.f12341a;
        }
        return new s(t10);
    }

    public static final <T> d<T> d(r<? extends T> rVar, oc.i iVar, int i10, id.a aVar) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 2) {
            z10 = true;
        }
        return ((z10 || i10 == -2) && aVar == id.a.DROP_OLDEST) ? rVar : q.a(rVar, iVar, i10, aVar);
    }
}
