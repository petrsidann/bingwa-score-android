package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {
    public static final <T> void a(z0<? super T> z0Var, int i10) {
        oc.e<? super T> eVarD = z0Var.d();
        boolean z10 = i10 == 4;
        if (z10 || !(eVarD instanceof ld.j) || b(i10) != b(z0Var.f9276c)) {
            d(z0Var, eVarD, z10);
            return;
        }
        j0 j0Var = ((ld.j) eVarD).f12730d;
        oc.i context = eVarD.getContext();
        if (j0Var.d0(context)) {
            j0Var.c0(context, z0Var);
        } else {
            e(z0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(z0<? super T> z0Var, oc.e<? super T> eVar, boolean z10) {
        Object objF;
        Object objL = z0Var.l();
        Throwable thE = z0Var.e(objL);
        if (thE != null) {
            lc.j.a aVar = lc.j.f12703b;
            objF = lc.k.a(thE);
        } else {
            lc.j.a aVar2 = lc.j.f12703b;
            objF = z0Var.f(objL);
        }
        Object objB = lc.j.b(objF);
        if (!z10) {
            eVar.resumeWith(objB);
            return;
        }
        kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        ld.j jVar = (ld.j) eVar;
        oc.e<T> eVar2 = jVar.f12731e;
        Object obj = jVar.f12733l;
        oc.i context = eVar2.getContext();
        Object objC = ld.l0.c(context, obj);
        b3<?> b3VarG = objC != ld.l0.f12738a ? i0.g(eVar2, context, objC) : null;
        try {
            jVar.f12731e.resumeWith(objB);
            lc.q qVar = lc.q.f12711a;
        } finally {
            if (b3VarG == null || b3VarG.Q0()) {
                ld.l0.a(context, objC);
            }
        }
    }

    public static final void e(z0<?> z0Var) {
        i1 i1VarB = w2.f9268a.b();
        if (i1VarB.m0()) {
            i1VarB.i0(z0Var);
            return;
        }
        i1VarB.k0(true);
        try {
            d(z0Var, z0Var.d(), true);
            do {
            } while (i1VarB.p0());
        } catch (Throwable th) {
            try {
                z0Var.j(th, null);
            } finally {
                i1VarB.f0(true);
            }
        }
    }
}
