package kd;

import kotlin.jvm.internal.x;
import ld.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final <T, V> Object b(oc.i iVar, V v10, Object obj, xc.p<? super V, ? super oc.e<? super T>, ? extends Object> pVar, oc.e<? super T> eVar) {
        Object objC = l0.c(iVar, obj);
        try {
            Object objInvoke = ((xc.p) x.a(pVar, 2)).invoke(v10, new r(eVar, iVar));
            l0.a(iVar, objC);
            if (objInvoke == pc.c.c()) {
                qc.h.c(eVar);
            }
            return objInvoke;
        } catch (Throwable th) {
            l0.a(iVar, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object c(oc.i iVar, Object obj, Object obj2, xc.p pVar, oc.e eVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = l0.b(iVar);
        }
        return b(iVar, obj, obj2, pVar, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> jd.e<T> d(jd.e<? super T> eVar, oc.i iVar) {
        return eVar instanceof q ? eVar : new s(eVar, iVar);
    }
}
