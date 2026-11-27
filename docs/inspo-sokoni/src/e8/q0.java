package e8;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import g8.l4;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f7293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c8.a<c8.j> f7294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c8.a<String> f7295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l8.g f7296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d8.g f7297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g8.h1 f7298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g8.k0 f7299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k8.s0 f7300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f1 f7301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o f7302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l4 f7303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l4 f7304l;

    public q0(final Context context, l lVar, c8.a<c8.j> aVar, c8.a<String> aVar2, final l8.g gVar, final k8.i0 i0Var, final j jVar) {
        this.f7293a = lVar;
        this.f7294b = aVar;
        this.f7295c = aVar2;
        this.f7296d = gVar;
        this.f7297e = new d8.g(new k8.o0(lVar.a()));
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        gVar.l(new Runnable() { // from class: e8.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f7308a.U(taskCompletionSource, context, jVar, i0Var);
            }
        });
        aVar.d(new l8.u() { // from class: e8.c0
            @Override // l8.u
            public final void a(Object obj) {
                this.f7120a.W(atomicBoolean, taskCompletionSource, gVar, (c8.j) obj);
            }
        });
        aVar2.d(new l8.u() { // from class: e8.i0
            @Override // l8.u
            public final void a(Object obj) {
                q0.X((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(b8.r rVar) {
        this.f7302j.e(rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(List list) {
        this.f7299g.A(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f7299g.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f7300h.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.f7300h.s();
    }

    public static /* synthetic */ h8.h O(Task task) throws com.google.firebase.firestore.f {
        h8.h hVar = (h8.h) task.getResult();
        if (hVar.c()) {
            return hVar;
        }
        if (hVar.j()) {
            return null;
        }
        throw new com.google.firebase.firestore.f("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", com.google.firebase.firestore.f.a.UNAVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ h8.h P(h8.k kVar) {
        return this.f7299g.k0(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ y1 Q(b1 b1Var) {
        g8.l1 l1VarC = this.f7299g.C(b1Var, true);
        w1 w1Var = new w1(b1Var, l1VarC.b());
        return w1Var.b(w1Var.h(l1VarC.a())).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(String str, TaskCompletionSource taskCompletionSource) {
        d8.j jVarJ = this.f7299g.J(str);
        if (jVarJ == null) {
            taskCompletionSource.setResult(null);
        } else {
            g1 g1VarB = jVarJ.a().b();
            taskCompletionSource.setResult(new b1(g1VarB.n(), g1VarB.d(), g1VarB.h(), g1VarB.m(), g1VarB.j(), jVarJ.a().a(), g1VarB.p(), g1VarB.f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(c1 c1Var) {
        this.f7302j.d(c1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(d8.f fVar, b8.v0 v0Var) {
        this.f7301i.p(fVar, v0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(TaskCompletionSource taskCompletionSource, Context context, j jVar, k8.i0 i0Var) {
        try {
            H(context, (c8.j) Tasks.await(taskCompletionSource.getTask()), jVar, i0Var);
        } catch (InterruptedException | ExecutionException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(c8.j jVar) {
        l8.b.d(this.f7301i != null, "SyncEngine not yet initialized", new Object[0]);
        l8.v.a("FirestoreClient", "Credential changed. Current user: %s", jVar.a());
        this.f7301i.l(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, l8.g gVar, final c8.j jVar) {
        if (!atomicBoolean.compareAndSet(false, true)) {
            gVar.l(new Runnable() { // from class: e8.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7336a.V(jVar);
                }
            });
        } else {
            l8.b.d(!taskCompletionSource.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
            taskCompletionSource.setResult(jVar);
        }
    }

    public static /* synthetic */ void X(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(b8.r rVar) {
        this.f7302j.h(rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(b1 b1Var, List list, final TaskCompletionSource taskCompletionSource) {
        this.f7301i.x(b1Var, list).addOnSuccessListener(new OnSuccessListener() { // from class: e8.b0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                taskCompletionSource.setResult((Map) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: e8.d0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                taskCompletionSource.setException(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(boolean z10) {
        this.f7299g.n0(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(c1 c1Var) {
        this.f7302j.g(c1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        this.f7300h.O();
        this.f7298f.m();
        l4 l4Var = this.f7304l;
        if (l4Var != null) {
            l4Var.stop();
        }
        l4 l4Var2 = this.f7303k;
        if (l4Var2 != null) {
            l4Var2.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task f0(b8.x1 x1Var, l8.t tVar) {
        return this.f7301i.C(this.f7296d, x1Var, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(TaskCompletionSource taskCompletionSource) {
        this.f7301i.t(taskCompletionSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(List list, TaskCompletionSource taskCompletionSource) {
        this.f7301i.E(list, taskCompletionSource);
    }

    public Task<Void> A(final List<h8.p> list) {
        q0();
        return this.f7296d.i(new Runnable() { // from class: e8.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7222a.K(list);
            }
        });
    }

    public void B() {
        q0();
        this.f7296d.l(new Runnable() { // from class: e8.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7232a.L();
            }
        });
    }

    public Task<Void> C() {
        q0();
        return this.f7296d.i(new Runnable() { // from class: e8.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f7379a.M();
            }
        });
    }

    public Task<Void> D() {
        q0();
        return this.f7296d.i(new Runnable() { // from class: e8.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f7360a.N();
            }
        });
    }

    public Task<h8.h> E(final h8.k kVar) {
        q0();
        return this.f7296d.j(new Callable() { // from class: e8.p0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7290a.P(kVar);
            }
        }).continueWith(new Continuation() { // from class: e8.s
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return q0.O(task);
            }
        });
    }

    public Task<y1> F(final b1 b1Var) {
        q0();
        return this.f7296d.j(new Callable() { // from class: e8.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7327a.Q(b1Var);
            }
        });
    }

    public Task<b1> G(final String str) {
        q0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7296d.l(new Runnable() { // from class: e8.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f7320a.R(str, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void H(Context context, c8.j jVar, j jVar2, k8.i0 i0Var) {
        l8.v.a("FirestoreClient", "Initializing. user=%s", jVar.a());
        jVar2.s(new j.a(context, this.f7296d, this.f7293a, jVar, 100, this.f7294b, this.f7295c, i0Var));
        this.f7298f = jVar2.o();
        this.f7304l = jVar2.l();
        this.f7299g = jVar2.n();
        this.f7300h = jVar2.q();
        this.f7301i = jVar2.r();
        this.f7302j = jVar2.k();
        g8.l lVarM = jVar2.m();
        l4 l4Var = this.f7304l;
        if (l4Var != null) {
            l4Var.start();
        }
        if (lVarM != null) {
            g8.l.a aVarF = lVarM.f();
            this.f7303k = aVarF;
            aVarF.start();
        }
    }

    public boolean I() {
        return this.f7296d.p();
    }

    public c1 i0(b1 b1Var, o.b bVar, b8.r<y1> rVar) {
        q0();
        final c1 c1Var = new c1(b1Var, bVar, rVar);
        this.f7296d.l(new Runnable() { // from class: e8.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7140a.S(c1Var);
            }
        });
        return c1Var;
    }

    public void j0(InputStream inputStream, final b8.v0 v0Var) {
        q0();
        final d8.f fVar = new d8.f(this.f7297e, inputStream);
        this.f7296d.l(new Runnable() { // from class: e8.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7236a.T(fVar, v0Var);
            }
        });
    }

    public void k0(final b8.r<Void> rVar) {
        this.f7296d.l(new Runnable() { // from class: e8.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7177a.Y(rVar);
            }
        });
    }

    public Task<Map<String, d9.d0>> l0(final b1 b1Var, final List<com.google.firebase.firestore.a> list) {
        q0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7296d.l(new Runnable() { // from class: e8.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7264a.b0(b1Var, list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void m0(final boolean z10) {
        q0();
        this.f7296d.l(new Runnable() { // from class: e8.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f7364a.c0(z10);
            }
        });
    }

    public void n0(final c1 c1Var) {
        this.f7296d.l(new Runnable() { // from class: e8.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7163a.d0(c1Var);
            }
        });
    }

    public Task<Void> o0() {
        this.f7294b.c();
        this.f7295c.c();
        return this.f7296d.n(new Runnable() { // from class: e8.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7201a.e0();
            }
        });
    }

    public <TResult> Task<TResult> p0(final b8.x1 x1Var, final l8.t<k1, Task<TResult>> tVar) {
        q0();
        return l8.g.g(this.f7296d.o(), new Callable() { // from class: e8.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7137a.f0(x1Var, tVar);
            }
        });
    }

    public final void q0() {
        if (I()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public Task<Void> r0() {
        q0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7296d.l(new Runnable() { // from class: e8.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7209a.g0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Void> s0(final List<i8.f> list) {
        q0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7296d.l(new Runnable() { // from class: e8.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f7344a.h0(list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void z(final b8.r<Void> rVar) {
        q0();
        this.f7296d.l(new Runnable() { // from class: e8.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7090a.J(rVar);
            }
        });
    }
}
