package gd;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z0<T> extends nd.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9276c;

    public z0(int i10) {
        this.f9276c = i10;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract oc.e<T> d();

    public Throwable e(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f9143a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void j(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            lc.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.k.b(th);
        l0.a(d().getContext(), new p0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objB;
        Object objB2;
        Object objB3;
        nd.i iVar = this.f13580b;
        try {
            oc.e<T> eVarD = d();
            kotlin.jvm.internal.k.c(eVarD, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            ld.j jVar = (ld.j) eVarD;
            oc.e<T> eVar = jVar.f12731e;
            Object obj = jVar.f12733l;
            oc.i context = eVar.getContext();
            Object objC = ld.l0.c(context, obj);
            b3<?> b3VarG = objC != ld.l0.f12738a ? i0.g(eVar, context, objC) : null;
            try {
                oc.i context2 = eVar.getContext();
                Object objL = l();
                Throwable thE = e(objL);
                y1 y1Var = (thE == null && a1.b(this.f9276c)) ? (y1) context2.get(y1.f9273i) : null;
                if (y1Var != null && !y1Var.isActive()) {
                    CancellationException cancellationException = y1Var.getCancellationException();
                    a(objL, cancellationException);
                    lc.j.a aVar = lc.j.f12703b;
                    objB2 = lc.j.b(lc.k.a(cancellationException));
                } else if (thE != null) {
                    lc.j.a aVar2 = lc.j.f12703b;
                    objB2 = lc.j.b(lc.k.a(thE));
                } else {
                    lc.j.a aVar3 = lc.j.f12703b;
                    objB2 = lc.j.b(f(objL));
                }
                eVar.resumeWith(objB2);
                lc.q qVar = lc.q.f12711a;
                if (b3VarG == null || b3VarG.Q0()) {
                    ld.l0.a(context, objC);
                }
                try {
                    iVar.a();
                    objB3 = lc.j.b(lc.q.f12711a);
                } catch (Throwable th) {
                    lc.j.a aVar4 = lc.j.f12703b;
                    objB3 = lc.j.b(lc.k.a(th));
                }
                j(null, lc.j.d(objB3));
            } catch (Throwable th2) {
                if (b3VarG == null || b3VarG.Q0()) {
                    ld.l0.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                lc.j.a aVar5 = lc.j.f12703b;
                iVar.a();
                objB = lc.j.b(lc.q.f12711a);
            } catch (Throwable th4) {
                lc.j.a aVar6 = lc.j.f12703b;
                objB = lc.j.b(lc.k.a(th4));
            }
            j(th3, lc.j.d(objB));
        }
    }
}
