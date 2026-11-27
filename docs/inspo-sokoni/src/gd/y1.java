package gd;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface y1 extends oc.i.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f9273i = b.f9274a;

    public static final class a {
        public static /* synthetic */ void b(y1 y1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            y1Var.cancel(cancellationException);
        }

        public static <R> R c(y1 y1Var, R r10, xc.p<? super R, ? super oc.i.b, ? extends R> pVar) {
            return (R) oc.i.b.a.a(y1Var, r10, pVar);
        }

        public static <E extends oc.i.b> E d(y1 y1Var, oc.i.c<E> cVar) {
            return (E) oc.i.b.a.b(y1Var, cVar);
        }

        public static /* synthetic */ e1 e(y1 y1Var, boolean z10, boolean z11, xc.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return y1Var.invokeOnCompletion(z10, z11, lVar);
        }

        public static oc.i f(y1 y1Var, oc.i.c<?> cVar) {
            return oc.i.b.a.c(y1Var, cVar);
        }

        public static y1 g(y1 y1Var, y1 y1Var2) {
            return y1Var2;
        }

        public static oc.i h(y1 y1Var, oc.i iVar) {
            return oc.i.b.a.d(y1Var, iVar);
        }
    }

    public static final class b implements oc.i.c<y1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f9274a = new b();
    }

    u attachChild(w wVar);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    CancellationException getCancellationException();

    dd.b<y1> getChildren();

    od.a getOnJoin();

    y1 getParent();

    e1 invokeOnCompletion(xc.l<? super Throwable, lc.q> lVar);

    e1 invokeOnCompletion(boolean z10, boolean z11, xc.l<? super Throwable, lc.q> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(oc.e<? super lc.q> eVar);

    y1 plus(y1 y1Var);

    boolean start();
}
