package md;

import gd.c0;
import gd.h2;
import gd.x2;
import kotlin.jvm.internal.x;
import lc.j;
import lc.k;
import ld.d0;
import ld.l0;
import oc.e;
import oc.i;
import pc.c;
import qc.h;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r10, e<? super T> eVar) {
        Object objA;
        e eVarA = h.a(eVar);
        try {
            i context = eVar.getContext();
            Object objC = l0.c(context, null);
            try {
                objA = ((p) x.a(pVar, 2)).invoke(r10, eVarA);
                l0.a(context, objC);
                if (objA == c.c()) {
                    return;
                }
            } catch (Throwable th) {
                l0.a(context, objC);
                throw th;
            }
        } catch (Throwable th2) {
            j.a aVar = j.f12703b;
            objA = k.a(th2);
        }
        eVarA.resumeWith(j.b(objA));
    }

    public static final <T, R> Object b(d0<? super T> d0Var, R r10, p<? super R, ? super e<? super T>, ? extends Object> pVar) {
        Object c0Var;
        Object objM0;
        try {
            c0Var = ((p) x.a(pVar, 2)).invoke(r10, d0Var);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var == c.c() || (objM0 = d0Var.m0(c0Var)) == h2.f9204b) {
            return c.c();
        }
        if (objM0 instanceof c0) {
            throw ((c0) objM0).f9143a;
        }
        return h2.h(objM0);
    }

    public static final <T, R> Object c(d0<? super T> d0Var, R r10, p<? super R, ? super e<? super T>, ? extends Object> pVar) throws Throwable {
        Object c0Var;
        Object objM0;
        try {
            c0Var = ((p) x.a(pVar, 2)).invoke(r10, d0Var);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var == c.c() || (objM0 = d0Var.m0(c0Var)) == h2.f9204b) {
            return c.c();
        }
        if (objM0 instanceof c0) {
            Throwable th2 = ((c0) objM0).f9143a;
            if (((th2 instanceof x2) && ((x2) th2).f9271a == d0Var) ? false : true) {
                throw th2;
            }
            if (c0Var instanceof c0) {
                throw ((c0) c0Var).f9143a;
            }
        } else {
            c0Var = h2.h(objM0);
        }
        return c0Var;
    }
}
