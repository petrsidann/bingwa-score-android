package md;

import lc.j;
import lc.k;
import lc.q;
import oc.e;
import xc.l;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final void a(e<?> eVar, Throwable th) throws Throwable {
        j.a aVar = j.f12703b;
        eVar.resumeWith(j.b(k.a(th)));
        throw th;
    }

    public static final void b(e<? super q> eVar, e<?> eVar2) throws Throwable {
        try {
            e eVarB = pc.b.b(eVar);
            j.a aVar = j.f12703b;
            ld.k.c(eVarB, j.b(q.f12711a), null, 2, null);
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r10, e<? super T> eVar, l<? super Throwable, q> lVar) throws Throwable {
        try {
            e eVarB = pc.b.b(pc.b.a(pVar, r10, eVar));
            j.a aVar = j.f12703b;
            ld.k.b(eVarB, j.b(q.f12711a), lVar);
        } catch (Throwable th) {
            a(eVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, e eVar, l lVar, int i10, Object obj2) throws Throwable {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, eVar, lVar);
    }
}
