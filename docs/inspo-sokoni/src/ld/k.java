package ld;

import gd.b3;
import gd.i1;
import gd.w2;
import gd.y1;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f12735a = new h0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f12736b = new h0("REUSABLE_CLAIMED");

    public static final <T> void b(oc.e<? super T> eVar, Object obj, xc.l<? super Throwable, lc.q> lVar) {
        boolean z10;
        if (!(eVar instanceof j)) {
            eVar.resumeWith(obj);
            return;
        }
        j jVar = (j) eVar;
        Object objC = gd.g0.c(obj, lVar);
        if (jVar.f12730d.d0(jVar.getContext())) {
            jVar.f12732f = objC;
            jVar.f9276c = 1;
            jVar.f12730d.c0(jVar.getContext(), jVar);
            return;
        }
        i1 i1VarB = w2.f9268a.b();
        if (i1VarB.m0()) {
            jVar.f12732f = objC;
            jVar.f9276c = 1;
            i1VarB.i0(jVar);
            return;
        }
        i1VarB.k0(true);
        try {
            y1 y1Var = (y1) jVar.getContext().get(y1.f9273i);
            if (y1Var == null || y1Var.isActive()) {
                z10 = false;
            } else {
                CancellationException cancellationException = y1Var.getCancellationException();
                jVar.a(objC, cancellationException);
                lc.j.a aVar = lc.j.f12703b;
                jVar.resumeWith(lc.j.b(lc.k.a(cancellationException)));
                z10 = true;
            }
            if (!z10) {
                oc.e<T> eVar2 = jVar.f12731e;
                Object obj2 = jVar.f12733l;
                oc.i context = eVar2.getContext();
                Object objC2 = l0.c(context, obj2);
                b3<?> b3VarG = objC2 != l0.f12738a ? gd.i0.g(eVar2, context, objC2) : null;
                try {
                    jVar.f12731e.resumeWith(obj);
                    lc.q qVar = lc.q.f12711a;
                    if (b3VarG == null || b3VarG.Q0()) {
                        l0.a(context, objC2);
                    }
                } catch (Throwable th) {
                    if (b3VarG == null || b3VarG.Q0()) {
                        l0.a(context, objC2);
                    }
                    throw th;
                }
            }
            while (i1VarB.p0()) {
            }
        } catch (Throwable th2) {
            try {
                jVar.j(th2, null);
            } finally {
                i1VarB.f0(true);
            }
        }
    }

    public static /* synthetic */ void c(oc.e eVar, Object obj, xc.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(eVar, obj, lVar);
    }
}
