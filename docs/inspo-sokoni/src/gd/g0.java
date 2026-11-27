package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {
    public static final <T> Object a(Object obj, oc.e<? super T> eVar) {
        if (obj instanceof c0) {
            lc.j.a aVar = lc.j.f12703b;
            obj = lc.k.a(((c0) obj).f9143a);
        }
        return lc.j.b(obj);
    }

    public static final <T> Object b(Object obj, o<?> oVar) {
        Throwable thD = lc.j.d(obj);
        return thD == null ? obj : new c0(thD, false, 2, null);
    }

    public static final <T> Object c(Object obj, xc.l<? super Throwable, lc.q> lVar) {
        Throwable thD = lc.j.d(obj);
        if (thD == null) {
            return lVar != null ? new d0(obj, lVar) : obj;
        }
        return new c0(thD, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, xc.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
