package gd;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e2 {
    public static final a0 a(y1 y1Var) {
        return new b2(y1Var);
    }

    public static /* synthetic */ a0 b(y1 y1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            y1Var = null;
        }
        return c2.a(y1Var);
    }

    public static final void c(oc.i iVar, CancellationException cancellationException) {
        y1 y1Var = (y1) iVar.get(y1.f9273i);
        if (y1Var != null) {
            y1Var.cancel(cancellationException);
        }
    }

    public static final void d(oc.i iVar, CancellationException cancellationException) {
        dd.b<y1> children;
        y1 y1Var = (y1) iVar.get(y1.f9273i);
        if (y1Var == null || (children = y1Var.getChildren()) == null) {
            return;
        }
        Iterator<y1> it = children.iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    public static /* synthetic */ void e(oc.i iVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        c2.d(iVar, cancellationException);
    }

    public static final e1 f(y1 y1Var, e1 e1Var) {
        return y1Var.invokeOnCompletion(new g1(e1Var));
    }

    public static final void g(y1 y1Var) {
        if (!y1Var.isActive()) {
            throw y1Var.getCancellationException();
        }
    }

    public static final void h(oc.i iVar) {
        y1 y1Var = (y1) iVar.get(y1.f9273i);
        if (y1Var != null) {
            c2.h(y1Var);
        }
    }

    public static final y1 i(oc.i iVar) {
        y1 y1Var = (y1) iVar.get(y1.f9273i);
        if (y1Var != null) {
            return y1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + iVar).toString());
    }
}
