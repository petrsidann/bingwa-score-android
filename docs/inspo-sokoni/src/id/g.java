package id;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final <E> d<E> a(int i10, a aVar, xc.l<? super E, lc.q> lVar) {
        d<E> bVar;
        if (i10 != -2) {
            if (i10 == -1) {
                if (aVar == a.SUSPEND) {
                    return new o(1, a.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i10 != 0) {
                if (i10 != Integer.MAX_VALUE) {
                    return aVar == a.SUSPEND ? new b(i10, lVar) : new o(i10, aVar, lVar);
                }
                return new b(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, lVar);
            }
            bVar = aVar == a.SUSPEND ? new b<>(0, lVar) : new o<>(1, aVar, lVar);
        } else {
            bVar = aVar == a.SUSPEND ? new b<>(d.f10619j.a(), lVar) : new o<>(1, aVar, lVar);
        }
        return bVar;
    }

    public static /* synthetic */ d b(int i10, a aVar, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return a(i10, aVar, lVar);
    }
}
