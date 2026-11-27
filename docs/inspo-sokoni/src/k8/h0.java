package k8;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static l8.y<vb.x0<?>> f11699h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Task<vb.w0> f11700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.g f11701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vb.c f11702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l8.g.b f11703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f11704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e8.l f11705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vb.b f11706g;

    public h0(l8.g gVar, Context context, e8.l lVar, vb.b bVar) {
        this.f11701b = gVar;
        this.f11704e = context;
        this.f11705f = lVar;
        this.f11706g = bVar;
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task l(vb.b1 b1Var, Task task) {
        return Tasks.forResult(((vb.w0) task.getResult()).f(b1Var, this.f11702c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ vb.w0 n() {
        final vb.w0 w0VarJ = j(this.f11704e, this.f11705f);
        this.f11701b.l(new Runnable() { // from class: k8.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11649a.m(w0VarJ);
            }
        });
        this.f11702c = ((d9.r.b) ((d9.r.b) d9.r.f(w0VarJ).c(this.f11706g)).d(this.f11701b.o())).b();
        l8.v.a("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return w0VarJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(vb.w0 w0Var) {
        l8.v.a("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        h();
        t(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final vb.w0 w0Var) {
        this.f11701b.l(new Runnable() { // from class: k8.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11695a.p(w0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(vb.w0 w0Var) {
        w0Var.n();
        k();
    }

    public final void h() {
        if (this.f11703d != null) {
            l8.v.a("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f11703d.c();
            this.f11703d = null;
        }
    }

    public <ReqT, RespT> Task<vb.g<ReqT, RespT>> i(final vb.b1<ReqT, RespT> b1Var) {
        return (Task<vb.g<ReqT, RespT>>) this.f11700a.continueWithTask(this.f11701b.o(), new Continuation() { // from class: k8.e0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f11686a.l(b1Var, task);
            }
        });
    }

    public final vb.w0 j(Context context, e8.l lVar) {
        vb.x0<?> x0Var;
        try {
            v4.a.a(context);
        } catch (c4.g | c4.h | IllegalStateException e10) {
            l8.v.e("GrpcCallProvider", "Failed to update ssl context: %s", e10);
        }
        l8.y<vb.x0<?>> yVar = f11699h;
        if (yVar != null) {
            x0Var = yVar.get();
        } else {
            vb.x0<?> x0VarB = vb.x0.b(lVar.b());
            if (!lVar.d()) {
                x0VarB.d();
            }
            x0Var = x0VarB;
        }
        x0Var.c(30L, TimeUnit.SECONDS);
        return wb.a.k(x0Var).i(context).a();
    }

    public final void k() {
        this.f11700a = Tasks.call(l8.p.f12581c, new Callable() { // from class: k8.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f11645a.n();
            }
        });
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void p(final vb.w0 w0Var) {
        vb.q qVarK = w0Var.k(true);
        l8.v.a("GrpcCallProvider", "Current gRPC connectivity state: " + qVarK, new Object[0]);
        h();
        if (qVarK == vb.q.CONNECTING) {
            l8.v.a("GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f11703d = this.f11701b.k(l8.g.d.CONNECTIVITY_ATTEMPT_TIMER, 15000L, new Runnable() { // from class: k8.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11679a.o(w0Var);
                }
            });
        }
        w0Var.l(qVarK, new Runnable() { // from class: k8.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11682a.q(w0Var);
            }
        });
    }

    public final void t(final vb.w0 w0Var) {
        this.f11701b.l(new Runnable() { // from class: k8.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11691a.r(w0Var);
            }
        });
    }

    public void u() {
        try {
            vb.w0 w0Var = (vb.w0) Tasks.await(this.f11700a);
            w0Var.m();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (w0Var.i(1L, timeUnit)) {
                    return;
                }
                l8.v.a(y.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                w0Var.n();
                if (w0Var.i(60L, timeUnit)) {
                    return;
                }
                l8.v.e(y.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
            } catch (InterruptedException unused) {
                w0Var.n();
                l8.v.e(y.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            l8.v.e(y.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            l8.v.e(y.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e10);
        }
    }
}
