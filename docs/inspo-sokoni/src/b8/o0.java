package b8;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l8.t<l8.g, e8.q0> f2935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.q0 f2936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l8.g f2937c = new l8.g();

    public o0(l8.t<l8.g, e8.q0> tVar) {
        this.f2935a = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Runnable runnable) {
        this.f2937c.m(runnable);
    }

    public synchronized <T> T b(l8.t<e8.q0, T> tVar) {
        c();
        return tVar.apply(this.f2936b);
    }

    public synchronized void c() {
        if (!e()) {
            this.f2936b = this.f2935a.apply(this.f2937c);
        }
    }

    public synchronized <T> T d(l8.t<Executor, T> tVar, l8.t<Executor, T> tVar2) {
        Executor executor = new Executor() { // from class: b8.n0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f2926a.f(runnable);
            }
        };
        e8.q0 q0Var = this.f2936b;
        if (q0Var != null && !q0Var.I()) {
            return tVar2.apply(executor);
        }
        return tVar.apply(executor);
    }

    public boolean e() {
        return this.f2936b != null;
    }

    public synchronized void g(o0.a<e8.q0> aVar) {
        c();
        aVar.accept(this.f2936b);
    }

    public synchronized Task<Void> h() {
        Task<Void> taskO0;
        c();
        taskO0 = this.f2936b.o0();
        this.f2937c.w();
        return taskO0;
    }
}
